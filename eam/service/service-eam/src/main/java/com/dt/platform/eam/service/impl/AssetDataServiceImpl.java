package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.datacenter.RackVO;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.eam.service.*;

import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.pcm.*;
import org.github.foxnic.web.domain.system.Dict;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.domain.system.DictVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.github.foxnic.web.proxy.system.DictServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.*;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Service("EamAssetDataService")
public class AssetDataServiceImpl  extends SuperService<Asset> implements IAssetDataService {


    @Autowired
    private IAssetService assetService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private IMaintainerService maintainerService;

    @Autowired
    private IManufacturerService manufacturerService;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ICategoryFinanceService categoryFinanceService;




    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }


    @Override
    public PagedList<Asset> queryAssetPagedList(List<String> ids, AssetVO asset) {
        asset.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
        return assetService.queryPagedList(asset,10000,1);

    }


    @Override
    public String getMapKey(HashMap<String,String> map,String value){
        String key = null;
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for(String getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                key = getKey;
                return key;
            }
        }
        return key;
    }


    @Override
    public HashMap<String,String> queryUseOrganizationNodes(){
        //id name
        HashMap<String,String> map=new HashMap<String,String>();
        OrganizationVO vo=new OrganizationVO();
        vo.setIsLoadAllDescendants(1);
        vo.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
        Result r= OrganizationServiceProxy.api().queryNodesFlatten(vo);
        if(r.isSuccess()){
            List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
            for( ZTreeNode node:list){
                String path="";
                for(int j=0;j<node.getNamePathArray().size();j++){
                    if(j==0){
                        path=node.getNamePathArray().get(j);
                    }else{
                        path=path+"/"+node.getNamePathArray().get(j);
                    }
                }
                System.out.println(node.getId()+","+path);
                map.put(node.getId(),path);
            }
        }
        return map;
    }

    @Override
    public HashMap<String,String> queryAssetCategoryNodes(){
        //所有分类转换成  id + 全路径名称
        HashMap<String,String> map=new HashMap<>();
        CatalogVO vo=new CatalogVO();
        vo.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
//        vo.setCode("asset");
        vo.setIsLoadAllDescendants(1);
       Result r= CatalogServiceProxy.api().queryNodesFlatten(vo);
        if(r.isSuccess()){
            List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
            for( ZTreeNode node:list){
                String path="";
                for(int j=0;j<node.getNamePathArray().size();j++){
                    if(j==0){
                        path=node.getNamePathArray().get(j);
                    }else{
                        path=path+"/"+node.getNamePathArray().get(j);
                    }
                }
                System.out.println(node.getId()+","+path);
                map.put(node.getId(),path);
            }
        }
        return map;
    }



    @Override
    public HashMap<String,String> queryDictItemDataByDictCode(String dictCode){
        HashMap<String,String> map=new HashMap<>();
        DictItemVO vo=new DictItemVO();
        vo.setDictCode(dictCode);
        Result<List<DictItem>> result=DictItemServiceProxy.api().queryList(vo);
        if(result.isSuccess()){
            List<DictItem> list=result.getData();
            for(int i=0;i<list.size();i++){
                map.put(list.get(i).getCode(),list.get(i).getLabel());
            }
        }else{
        }
        return map;
    }

    @Override
    public Result<CatalogData> verifyAssetExtColumnRecord(Rcd rcd, List<CatalogAttribute> attributeList, boolean fill){
        Result r=new Result();
        CatalogData data=new CatalogData();
        data.setCatalogId(rcd.getString("category_id"));
        data.setOwnerId(rcd.getString("id"));
        data.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
        Map<String,Object> dataMap=new HashMap<>();
        String id=rcd.getString("pcm_ext_id");
        if(!StringUtil.isBlank(id)){
            data.setId(id);
        }
        for(CatalogAttribute attribute:attributeList){
            String col=attribute.getField();
            String value= rcd.getString(col);
            if("pcm_ext_id".equals(col))continue;
            if(!StringUtil.isBlank(value)){
                dataMap.put(col.replaceFirst("pcm_ext_",""),value==null?"":value);
            }
        }
        data.setData(dataMap);
        return r.success(true).data(data);
    }

    @Override
    public Result verifyAssetRecord(Rcd rcd,HashMap<String,HashMap<String,String>> matchMap, boolean filldata){

        HashMap<String,String> orgMap=matchMap.get("organizationMap");
        HashMap<String,String> categoryMap=matchMap.get("categoryMap");

        String category=BeanNameUtil.instance().depart(AssetMeta.CATEGORY_ID);
        String valueCategory=rcd.getString(category);
//        System.out.println("Rcd:"+rcd.toString());
//        for (String f:rcd.getFields()){
//            System.out.println(f+","+rcd.getString(f));
//        }
        if(!StringUtil.isBlank(valueCategory)){
            if(categoryMap.containsValue(valueCategory.trim())){
                String key=getMapKey(categoryMap,valueCategory);
                rcd.setValue(category,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("资产分类未匹配到:"+valueCategory);
            }
        }else{
            return ErrorDesc.failureMessage("资产分类不存在:"+valueCategory);
        }


        //数据字典
        HashMap<String,String> dictColumns=new HashMap<>();
        dictColumns.put(AssetMeta.SOURCE_ID,"eam_source,资产来源");
        dictColumns.put(AssetMeta.SAFETY_LEVEL_CODE,"eam_safety_level,安全等级");
        dictColumns.put(AssetMeta.EQUIPMENT_ENVIRONMENT_CODE,"eam_equipment_environment,设备运行状态");
        dictColumns.put(AssetMeta.ASSET_MAINTENANCE_STATUS,"eam_maintenance_status,维保状态");
        for(String key:dictColumns.keySet()){
            //来源
            String keyValue=dictColumns.get(key);
            String[] keyValueArr=keyValue.split(",");
            String dict=keyValueArr[0];
            String notes=keyValueArr[1];
            HashMap<String,String> map=matchMap.get(dict);
            String col=BeanNameUtil.instance().depart(key);
            String valueCol=rcd.getString(col);
            if(!StringUtil.isBlank(valueCol)){
                if(map.containsValue(valueCol)){
                    rcd.setValue(valueCol,getMapKey(map,valueCol));
                }else{
                    return ErrorDesc.failureMessage(notes+":"+valueCol);
                }
            }
        }

        //字符串类型
        String[] stringColumns = {AssetMeta.ASSET_CODE,AssetMeta.NAME,AssetMeta.SERIAL_NUMBER,AssetMeta.BATCH_CODE,
                AssetMeta.MODEL,AssetMeta.UNIT,AssetMeta.POSITION_DETAIL,AssetMeta.RFID,
                AssetMeta.ASSET_NOTES,AssetMeta.MAINTAINER_NAME,AssetMeta.CONTACTS,AssetMeta.CONTACT_INFORMATION,
                AssetMeta.DIRECTOR,AssetMeta.MAINTENANCE_NOTES,AssetMeta.FINANCIAL_CODE};
        for(int j=0;j<stringColumns.length;j++){
            String stringColumn=stringColumns[j];
            String value=rcd.getString(BeanNameUtil.instance().depart(stringColumn));
            if(!StringUtil.isBlank(value)){
                rcd.set(stringColumn,value);
            }
        }


        //日期类型
        String[] dateColumns = {AssetMeta.MAINTENANCE_START_DATE,AssetMeta.MAINTENANCE_END_DATE,AssetMeta.PURCHASE_DATE};
        for(int j=0;j<dateColumns.length;j++){
            String dateColumn=dateColumns[j];
            String value=rcd.getString(BeanNameUtil.instance().depart(dateColumn));
            if(!StringUtil.isBlank(value)){
                int valueLen=value.trim().length();
                try {
                    DateFormat format1=null;
                    if(valueLen==10){
                        format1 = new SimpleDateFormat("yyyy-MM-dd");
                    }else if(valueLen==19){
                        format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    }else{
                        return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
                    }
                    Date date = format1.parse(value);
                    rcd.set(dateColumn,date);
                } catch (ParseException e) {
                    return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
                }
            }
        }


        //枚举类型
        //资产状态
        String assetStatus=BeanNameUtil.instance().depart(AssetMeta.ASSET_STATUS);
        String valueAssetStatus=rcd.getString(assetStatus);
        if(!StringUtil.isBlank(valueAssetStatus)){
            String value=EnumUtil.parseByText(AssetStatusEnum.class,valueAssetStatus)==null
                    ?AssetStatusEnum.IDLE.code()
                    :EnumUtil.parseByText(AssetStatusEnum.class,valueAssetStatus).code();
            rcd.setValue(assetStatus,value);
        } else{
            rcd.setValue(assetStatus,AssetStatusEnum.IDLE.code());
        }


        //设备状态
        String equipStatus=BeanNameUtil.instance().depart(AssetMeta.EQUIPMENT_STATUS);
        String valueEquipStatus=rcd.getString(equipStatus);
        if(!StringUtil.isBlank(valueEquipStatus)){
            CodeTextEnum value=EnumUtil.parseByText(AssetStatusEnum.class,valueEquipStatus);
            if(StringUtil.isBlank(value)){
                return ErrorDesc.failureMessage("设备状态不存在:"+valueEquipStatus);
            }else{
                rcd.setValue(equipStatus,value.code());
            }
        }

        //下拉框类型
        String useOrganization=BeanNameUtil.instance().depart(AssetMeta.USE_ORGANIZATION_ID);
        String valueUseOrganization=rcd.getString(useOrganization);
        if(!StringUtil.isBlank(valueUseOrganization)){
            if(orgMap.containsValue(valueUseOrganization.trim())){
                String key=getMapKey(orgMap,valueUseOrganization);
                rcd.setValue(useOrganization,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("组织节点未匹配到:"+valueUseOrganization);
            }
        }


        String companyId=BeanNameUtil.instance().depart(AssetMeta.OWN_COMPANY_ID);
        String valueOwnerCompany=rcd.getString(companyId);
        if(!StringUtil.isBlank(valueOwnerCompany)){
            if(orgMap.containsValue(valueOwnerCompany.trim())){
                String key=getMapKey(orgMap,valueOwnerCompany);
                rcd.setValue(companyId,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("组织节点未匹配到:"+valueOwnerCompany);
            }

        }


        String manager=BeanNameUtil.instance().depart(AssetMeta.MANAGER_ID);
        String valueManager=rcd.getString(manager);
        if(!StringUtil.isBlank(valueManager)){
            Employee emp= EmployeeServiceProxy.api().getByBadge(valueManager).data();
            if(emp==null){
                //报错
                return ErrorDesc.failureMessage("管理人员不存在:"+valueManager);
            }else{
                rcd.setValue(manager,emp.getId());
            }
        }

        String useUser=BeanNameUtil.instance().depart(AssetMeta.USE_USER_ID);
        String valueUseUser=rcd.getString(useUser);
        if(!StringUtil.isBlank(valueUseUser)){
            Employee emp= EmployeeServiceProxy.api().getByBadge(valueUseUser).data();
            if(emp==null){
                //报错
                return ErrorDesc.failureMessage("使用人员不存在:"+valueUseUser);
            }else{
                rcd.setValue(useUser,emp.getId());
            }
        }


        //下拉框
        String financialCategory=BeanNameUtil.instance().depart(AssetMeta.FINANCIAL_CATEGORY_ID);
        String valueFinancialCategory=rcd.getString(financialCategory);
        if(!StringUtil.isBlank(valueFinancialCategory)){
            CategoryFinance categoryFinance = categoryFinanceService.queryEntity(CategoryFinance.create().setHierarchyName(valueFinancialCategory));
            if(categoryFinance==null){
                return ErrorDesc.failureMessage("财务分类不存在:"+valueFinancialCategory);
            }else{
                rcd.setValue(financialCategory,categoryFinance.getId());
            }
        }

        //物品档案fill
        String goodsId=BeanNameUtil.instance().depart(AssetMeta.GOODS_ID);
        String valueGoods=rcd.getString(goodsId);
        if(!StringUtil.isBlank(valueGoods)){
            Goods goods = goodsService.queryEntity(Goods.create().setName(valueGoods));
            if(goods==null){
                if(filldata){
                    goods=new Goods();
                    goods.setName(valueGoods);
                    goodsService.insert(goods);
                    rcd.setValue(goodsId,goods.getId());
                }else{
                    return ErrorDesc.failureMessage("物品档案不存在:"+valueGoods);
                }
            }else{
                rcd.setValue(goodsId,goods.getId());
            }
        }

        //位置 fill
        String positionId=BeanNameUtil.instance().depart(AssetMeta.POSITION_ID);
        String valuePosition=rcd.getString(positionId);
        if(!StringUtil.isBlank(valuePosition)){
            Position position = positionService.queryEntity(Position.create().setName(valuePosition));
            if(position==null){
                if(filldata){
                    position=new Position();
                    position.setName(valuePosition);
                    positionService.insert(position);
                    rcd.setValue(positionId,position.getId());
                }else{
                    return ErrorDesc.failureMessage("资产位置不存在:"+valuePosition);
                }
            }else{
                rcd.setValue(positionId,position.getId());
            }
        }

        //仓库 fill
        String wareHouseId=BeanNameUtil.instance().depart(AssetMeta.WAREHOUSE_ID);
        String valueWarehouse=rcd.getString(wareHouseId);
        if(!StringUtil.isBlank(valueWarehouse)){
            Warehouse warehouse = warehouseService.queryEntity(Warehouse.create().setWarehouseName(valueWarehouse));
            if(warehouse==null){
                if(filldata){
                    warehouse=new Warehouse();
                    warehouse.setWarehouseName(valueWarehouse);
                    warehouseService.insert(warehouse);
                    rcd.setValue(wareHouseId,warehouse.getId());
                }else{
                    return ErrorDesc.failureMessage("资产仓库不存在:"+valueWarehouse);
                }
            }else{
                rcd.setValue(wareHouseId,warehouse.getId());
            }
        }

        //厂商 fill
        String manufacturerId=BeanNameUtil.instance().depart(AssetMeta.MANUFACTURER_ID);
        String valueManufacturer=rcd.getString(manufacturerId);
        if(!StringUtil.isBlank(valueManufacturer)){
            Manufacturer manufacturer = manufacturerService.queryEntity(Manufacturer.create().setManufacturerName(valueManufacturer));
            if(manufacturer==null){
                if(filldata){
                    manufacturer=new Manufacturer();
                    manufacturer.setManufacturerName(valueManufacturer);
                    manufacturerService.insert(manufacturer);
                    rcd.setValue(manufacturerId,manufacturer.getId());
                }else{
                    //返回报错
                    return ErrorDesc.failureMessage("厂商不存在:"+valueManufacturer);
                }
            }else{
                rcd.setValue(manufacturerId,manufacturer.getId());
            }
        }


        //机柜 fill
        String rackId=BeanNameUtil.instance().depart(AssetMeta.RACK_ID);
        String valueRack=rcd.getString(rackId);
        if(!StringUtil.isBlank(valueRack)){
            RackVO vo=new RackVO();
            vo.setRackName(valueRack);
            Result<List<Rack>> rackResult=RackServiceProxy.api().queryList(vo);
            if(!rackResult.isSuccess()){
                return rackResult;
            }
            String matchRackId="";
            if (rackResult.getData().size()==0){
                if(filldata){
                    matchRackId=IDGenerator.getSnowflakeIdString();
                    vo.setId(matchRackId);
                    RackServiceProxy.api().insert(vo);
                }else{
                    return ErrorDesc.failureMessage("机柜不存在:"+valueRack);
                }
            }else{
                matchRackId=rackResult.getData().get(0).getId();
            }
            rcd.setValue(rackId,matchRackId);
        }



        return ErrorDesc.success();
    }




    @Override
    public Map<String, Object> queryAssetMap(PagedList<Asset> list,String categoryId) {
        HashMap<String,String> orgMap=queryUseOrganizationNodes();
        HashMap<String,String> categoryMap=queryAssetCategoryNodes();
        Map<String,Object> map=new HashMap<>();
        assetService.joinData(list.getList());
        String tenantId=SessionUser.getCurrent().getActivatedTenantId();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for(int i=0;i<list.size();i++){
            Asset assetItem=list.get(i);
            if(!StringUtil.isBlank(categoryId)){
                if(!categoryId.equals(assetItem.getCategoryId())){
                    continue;
                }
            }

            Map<String, Object> assetMap= BeanUtil.toMap(assetItem);
            //获取自定义属性
            DataQueryVo vo=new DataQueryVo();
            vo.setCatalogId(categoryId);
            vo.setTenantId(tenantId);
            List<String> ids=new ArrayList<>();
            ids.add(assetItem.getId());
            vo.setOwnerIds(ids);
            Result itemResult=CatalogServiceProxy.api().queryData(vo);
            if(itemResult.isSuccess()){
                JSONArray dataArr=(JSONArray)itemResult.getData();
                if(dataArr.size()>0){
                    JSONObject dataObj=dataArr.getJSONObject(0);
                    for(String key:dataObj.keySet()){
                        assetMap.put("pcm_ext_"+key,dataObj.get(key));
                    }
                }
            }

            //资产状态
            CodeTextEnum vAssetStatus=EnumUtil.parseByCode(AssetStatusEnum.class,assetItem.getAssetStatus()) ;
            assetMap.put(AssetDataExportColumnEnum.ASSET_STATUS_NAME.code(), vAssetStatus==null?"":vAssetStatus.text());

            //办理状态
            CodeTextEnum vStatus= EnumUtil.parseByCode(AssetHandleStatusEnum.class,assetItem.getStatus());
            assetMap.put(AssetDataExportColumnEnum.STATUS_NAME.code(),vStatus==null?"":vStatus.text());

            //设备状态
            CodeTextEnum vEquipStatus= EnumUtil.parseByCode(AssetEquipmentStatusEnum.class,assetItem.getEquipmentStatus());
            assetMap.put(AssetDataExportColumnEnum.EQUIPMENT_STATUS_NAME.code(),vEquipStatus==null?"":vEquipStatus.text());

            if(assetItem.getSource()!=null){
                assetMap.put(AssetDataExportColumnEnum.ASSET_SOURCE_NAME.code(),assetItem.getSource().getLabel());
            }

            if(assetItem.getSafetyLevel()!=null){
                assetMap.put(AssetDataExportColumnEnum.SAFETY_LEVEL_NAME.code(),assetItem.getSafetyLevel().getLabel());
            }

            if(assetItem.getEquipmentEnvironment()!=null){
                assetMap.put(AssetDataExportColumnEnum.EQUIPMENT_ENVIRONMENT_NAME.code(),assetItem.getEquipmentEnvironment().getLabel());
            }

            if(assetItem.getAssetMaintenanceStatus()!=null){
                assetMap.put(AssetDataExportColumnEnum.MAINTENANCE_STATUS.code(),assetItem.getAssetMaintenanceStatus().getLabel());
            }

            if(assetItem.getPosition()!=null){
                // 关联出 存放位置 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_POSITION_NAME.code(),assetItem.getPosition().getName());
            }
//            if(assetItem.getCategory()!=null){
//                //关联出 分类 数据
//                String name=categoryMap.get(assetItem.getCategoryId());
//                assetMap.put(AssetDataExportColumnEnum.ASSET_CATEGORY_NAME.code(),name);
//            }
            if(assetItem.getGoods()!=null){
                //关联出 物品档案 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_GOOD_NAME.code(),assetItem.getGoods().getName());
            }

            if(assetItem.getRack()!=null){
                //关联出 机柜 数据
                assetMap.put(AssetDataExportColumnEnum.RACK_NAME.code(),assetItem.getRack().getRackName());
                assetMap.put("rackCode",assetItem.getRack().getRackCode());
            }

            if(assetItem.getManufacturer()!=null){
                //关联出 厂商 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_MANUFACTURER_NAME.code(),assetItem.getManufacturer().getManufacturerName());
            }
            if(assetItem.getWarehouse()!=null){
                //关联出 仓库 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_WAREHOUSE_NAME.code(),assetItem.getWarehouse().getWarehouseName());
            }
            if(assetItem.getMaintnainer()!=null){
                //关联出 维保商 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_MAINTAINER_NAME.code(),assetItem.getMaintnainer().getMaintainerName());
            }
            if(assetItem.getCategoryFinance()!=null){
                // 关联出 财务分类数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_CATEGORY_FINANCE_NAME.code(),assetItem.getCategoryFinance().getHierarchyName());
            }
            if(assetItem.getSupplier()!=null){
                // 关联出 供应商 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_SUPPLIER_NAME.code(),assetItem.getSupplier().getSupplierName());
            }



            String companyName=orgMap.get(assetItem.getOwnCompanyId());
            assetMap.put(AssetDataExportColumnEnum.OWN_COMPANY_NAME.code(),companyName);

            String orgName=orgMap.get(assetItem.getUseOrganizationId());
            assetMap.put(AssetDataExportColumnEnum.USE_ORGANIZATION_NAME.code(),orgName);

            String categoryName=categoryMap.get(assetItem.getCategoryId());
            assetMap.put(AssetDataExportColumnEnum.ASSET_CATEGORY_NAME.code(),categoryName);

            if(assetItem.getManager()!=null){
                System.out.println("manager:"+assetItem.getManager().getBadge());
                assetMap.put(AssetDataExportColumnEnum.MANAGER_NAME_BADGE.code(),assetItem.getManager().getNameAndBadge());
                assetMap.put(AssetDataExportColumnEnum.MANAGER_NAME.code(),assetItem.getManager().getName());
                assetMap.put(AssetDataExportColumnEnum.MANAGER_BADGE.code(),assetItem.getManager().getBadge());
            }

            if(assetItem.getUseUser()!=null){
                System.out.println("user:"+assetItem.getUseUser().getBadge());
                assetMap.put(AssetDataExportColumnEnum.USE_USER_NAME_BADGE.code(),assetItem.getUseUser().getNameAndBadge());
                assetMap.put(AssetDataExportColumnEnum.USE_USER_NAME.code(),assetItem.getUseUser().getName());
                assetMap.put(AssetDataExportColumnEnum.USE_USER_BADGE.code(),assetItem.getUseUser().getBadge());
            }
     //     if(i<5)
            listMap.add(assetMap);
        }
        System.out.println("#########"+listMap.size());
        map.put("dataList", listMap);
   //     System.out.println(map);
        return map;
    }


    public File saveTempFile(InputStream is, String fileName){


        int BYTESIZE=1024;
        String path = System.getProperty("java.io.tmpdir");
//        try {
//            path = URLDecoder.decode(AssetDataServiceImpl.class.getClassLoader().getResource("../temp").getPath(), "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(path);
        File temp = new File(path + fileName);
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(new FileOutputStream(temp));                            //把文件流转为文件，保存在临时目录
            int len = 0;
            byte[] buf = new byte[10*BYTESIZE];                                                    //缓冲区
            while((len=bis.read(buf)) != -1){
                bos.write(buf, 0, len);
            }
            bos.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                if(bos!=null) bos.close();
                if(bis!=null) bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }



}
