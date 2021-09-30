package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.service.*;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.*;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("EamAssetDataService")
public class AssetDataServiceImpl  extends SuperService<Asset> implements IAssetDataService {


    @Autowired
    private IAssetService assetService;


    @Autowired
    private IAssetDataService assetDataService;

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
    public List<Asset> queryAssetList(List<String> ids, AssetVO asset) {
        return assetService.queryList(asset);
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
        //这个key肯定是最后一个满足该条件的key.
    }


    @Override
    public HashMap<String,String> queryUseOrganizationNodes(){
        //id name
        HashMap<String,String> map=new HashMap<String,String>();
        OrganizationVO vo=new OrganizationVO();
        vo.setIsLoadAllDescendants(1);
        vo.setTenantId("T001");
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
        HashMap<String,String> map=new HashMap<String,String>();
        CatalogVO vo=new CatalogVO();
        vo.setTenantId("T001");
     //   vo.setCode("asset");
      //  vo.setIsLoadAllDescendants(1);
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
                map.put(node.getId(),path);
            }
        }
        return map;
    }




    @Override
    public Result verifyAssetRecord(Rcd rcd,HashMap<String,HashMap<String,String>> matchMap, boolean filldata){

        HashMap<String,String> orgMap=matchMap.get("organizationMap");
        HashMap<String,String> categoryMap=matchMap.get("categoryMap");

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

        //Number类型



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

        //办理状态删除

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


        //设备状态
        String maintenanceStatus=BeanNameUtil.instance().depart(AssetMeta.MAINTENANCE_STATUS);
        String valueMaintenanceStatus=rcd.getString(maintenanceStatus);
        if(!StringUtil.isBlank(valueMaintenanceStatus)){
            CodeTextEnum value=EnumUtil.parseByText(AssetMaintenanceStatusEnum.class,valueMaintenanceStatus);
            if(StringUtil.isBlank(value)){
                return ErrorDesc.failureMessage("维保状态不存在:"+valueMaintenanceStatus);
            }else{
                rcd.setValue(maintenanceStatus,value.code());
            }
        }


        //下拉框类型
        String useOrganization=BeanNameUtil.instance().depart(AssetMeta.USE_ORGANIZATION_ID);
        String valueUseOrganization=rcd.getString(useOrganization);
        if(!StringUtil.isBlank(valueUseOrganization)){
            if(orgMap.containsValue(valueUseOrganization.trim())){
                String key=assetDataService.getMapKey(orgMap,valueUseOrganization);
                rcd.setValue(useOrganization,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("组织节点不存在:"+valueUseOrganization);
            }
        }


        String companyId=BeanNameUtil.instance().depart(AssetMeta.OWN_COMPANY_ID);
        String valueOwnerCompany=rcd.getString(companyId);
        if(!StringUtil.isBlank(valueOwnerCompany)){
            if(orgMap.containsValue(valueOwnerCompany.trim())){
                String key=assetDataService.getMapKey(orgMap,valueOwnerCompany);
                rcd.setValue(companyId,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("组织节点不存在:"+valueOwnerCompany);
            }

        }


        String category=BeanNameUtil.instance().depart(AssetMeta.CATEGORY_ID);
        String valueCategory=rcd.getString(category);
        if(!StringUtil.isBlank(valueCategory)){
            if(orgMap.containsValue(valueCategory.trim())){
                String key=assetDataService.getMapKey(categoryMap,valueCategory);
                rcd.setValue(category,key);
            }else{
                //返回报错
                return ErrorDesc.failureMessage("资产分类不存在:"+valueCategory);
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
        if(valueFinancialCategory!=null){
            CategoryFinance categoryFinance = categoryFinanceService.queryEntity(CategoryFinance.create().setHierarchyName(valueFinancialCategory));
            if(categoryFinance==null){
                return ErrorDesc.failureMessage("财务分类不存在:"+valueFinancialCategory);
            }else{
                rcd.setValue(financialCategory,categoryFinance.getId());
            }
        }



        //物品档案
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



        //位置
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



        //仓库
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

        //厂商
        String manufacturerId=BeanNameUtil.instance().depart(AssetMeta.MANUFACTURER_ID);
        String valueManufacturer=rcd.getString(manufacturerId);
        if(!StringUtil.isBlank(valueManufacturer)){
            Manufacturer manufacturer = manufacturerService.queryEntity(Manufacturer.create().setManufacturerName(valueWarehouse));
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



        //数据字典
        //来源
        String sourceId=BeanNameUtil.instance().depart(AssetMeta.SOURCE_ID);
        String valueSource=rcd.getString(sourceId);
        if(!StringUtil.isBlank(valueSource)){
            DictItemVO dictVo=new DictItemVO();
            dictVo.setLabel(valueSource);
            dictVo.setDictCode("eam_source");
            Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
            if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
                rcd.setValue(sourceId,dictItemResult.getData().get(0).getCode());
            }else{
                //返回报错
                return ErrorDesc.failureMessage("资产来源不存在:"+valueSource);
            }
        }

        //安全等级
        String safetyLevel=BeanNameUtil.instance().depart(AssetMeta.SAFETY_LEVEL_CODE);
        String valueSafetyLevel=rcd.getString(safetyLevel);
        if(!StringUtil.isBlank(valueSafetyLevel)){
            DictItemVO dictVo=new DictItemVO();
            dictVo.setLabel(valueSafetyLevel);
            dictVo.setDictCode("eam_safety_level");
            Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
            if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
                rcd.setValue(safetyLevel,dictItemResult.getData().get(0).getCode());
            }else{
                //返回报错
                return ErrorDesc.failureMessage("安全等级不存在:"+valueSafetyLevel);
            }
        }



        String equipEnv=BeanNameUtil.instance().depart(AssetMeta.EQUIPMENT_ENVIRONMENT_CODE);
        String valueEquipEnv=rcd.getString(equipEnv);
        if(!StringUtil.isBlank(valueEquipEnv)){
            DictItemVO dictVo=new DictItemVO();
            dictVo.setLabel(valueEquipEnv);
            dictVo.setDictCode("eam_equipment_environment");
            Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
            if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
                rcd.setValue(equipEnv,dictItemResult.getData().get(0).getCode());
            }else{
                //返回报错
                return ErrorDesc.failureMessage("设备运行状态不存在:"+valueEquipEnv);
            }
        }

        //其他
        return ErrorDesc.success();
    }




    @Override
    public Map<String, Object> queryAssetMap(List<Asset>list) {
        HashMap<String,String> orgMap=queryUseOrganizationNodes();


        HashMap<String,String> categoryMap=queryAssetCategoryNodes();

        Map<String,Object> map=new HashMap<>();

        // 关联出 物品档案 数据
        assetService.join(list,AssetMeta.GOODS);
        // 关联出 厂商 数据
        assetService.join(list,AssetMeta.MANUFACTURER);
        // 关联出 位置 数据
        assetService.join(list,AssetMeta.POSITION);
        // 关联出 仓库 数据
        assetService.join(list,AssetMeta.WAREHOUSE);
        // 关联出 维保商 数据
        assetService.join(list,AssetMeta.MAINTNAINER);
        // 关联出 财务分类 数据
        assetService.join(list,AssetMeta.CATEGORY_FINANCE);
        // 关联出 供应商 数据
        assetService.join(list,AssetMeta.SUPPLIER);
        // 关联出 来源 数据
        assetService.join(list,AssetMeta.SOURCE);
        //
        assetService.join(list,AssetMeta.SAFETY_LEVEL);

        assetService.join(list,AssetMeta.EQUIPMENT_ENVIRONMENT);

        assetService.join(list,AssetMeta.MANAGER);

        assetService.join(list,AssetMeta.USE_USER);

        assetService.join(list,AssetMeta.ORIGINATOR);


        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for(int i=0;i<list.size();i++){
            Asset assetItem=list.get(i);
            Map<String, Object> assetMap= BeanUtil.toMap(assetItem);
            System.out.println(assetItem);

            //资产状态
            CodeTextEnum vAssetStatus=EnumUtil.parseByCode(AssetStatusEnum.class,assetItem.getAssetStatus()) ;
            assetMap.put(AssetDataExportColumnEnum.ASSET_STATUS_NAME.code(), vAssetStatus==null?"":vAssetStatus.text());

            //办理状态
            CodeTextEnum vStatus= EnumUtil.parseByCode(AssetHandleStatusEnum.class,assetItem.getStatus());
            assetMap.put(AssetDataExportColumnEnum.ASSET_STATUS.code(),vStatus==null?"":vStatus.text());

            //设备状态
            CodeTextEnum vEquipStatus= EnumUtil.parseByCode(AssetEquipmentStatusEnum.class,assetItem.getEquipmentStatus());
            assetMap.put(AssetDataExportColumnEnum.EQUIPMENT_STATUS_NAME.code(),vEquipStatus==null?"":vEquipStatus.text());

            //维保状态
            CodeTextEnum vMaintenanceStatus= EnumUtil.parseByCode(AssetEquipmentStatusEnum.class,assetItem.getMaintenanceStatus());
            assetMap.put(AssetDataExportColumnEnum.MAINTENANCE_STATUS.code(),vMaintenanceStatus==null?"":vMaintenanceStatus.text());


            if(assetItem.getPosition()!=null){
                // 关联出 存放位置 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_POSITION_NAME.code(),assetItem.getPosition().getName());
            }
            if(assetItem.getCategory()!=null){
                //关联出 分类 数据
                String name=categoryMap.get(assetItem.getCategoryId());
                assetMap.put(AssetDataExportColumnEnum.ASSET_CATEGORY_NAME.code(),name);
            }
            if(assetItem.getGoods()!=null){
                //关联出 物品档案 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_GOOD_NAME.code(),assetItem.getGoods().getName());
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

            if(assetItem.getSource()!=null){
                // 关联出 来源 数据
                assetMap.put(AssetDataExportColumnEnum.ASSET_SOURCE_NAME.code(),assetItem.getSource().getLabel());
            }

            if(assetItem.getSafetyLevel()!=null){
                assetMap.put(AssetDataExportColumnEnum.SAFETY_LEVEL_NAME.code(),assetItem.getSafetyLevel().getLabel());
            }

            if(assetItem.getEquipmentEnvironment()!=null){
                assetMap.put(AssetDataExportColumnEnum.EQUIPMENT_ENVIRONMENT_NAME.code(),assetItem.getEquipmentEnvironment().getLabel());
            }


            String companyName=orgMap.get(assetItem.getOwnCompanyId());
            assetMap.put(AssetDataExportColumnEnum.OWNER_COMPANY_NAME.code(),companyName);

            String orgName=orgMap.get(assetItem.getUseOrganizationId());
            assetMap.put(AssetDataExportColumnEnum.USE_ORGANIZATION_NAME.code(),orgName);


            if(assetItem.getManager()!=null){
                System.out.println("manan"+assetItem.getManager().getBadge());
                assetMap.put(AssetDataExportColumnEnum.MANAGER_NAME.code(),assetItem.getManager().getName());
                assetMap.put(AssetDataExportColumnEnum.MANAGER_BADGE.code(),assetItem.getManager().getBadge());
            }

            if(assetItem.getUseUser()!=null){
                System.out.println("suer"+assetItem.getUseUser().getBadge());
                assetMap.put(AssetDataExportColumnEnum.USE_USER_NAME.code(),assetItem.getUseUser().getName());
                assetMap.put(AssetDataExportColumnEnum.USE_USER_BADGE.code(),assetItem.getUseUser().getBadge());
            }

            listMap.add(assetMap);
        }
        map.put("dataList", listMap);
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
