package com.dt.platform.eam.service.impl;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.service.IAssetDataService;

import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("EamAssetDataService")
public class AssetDataServiceImpl  extends SuperService<Asset> implements IAssetDataService {


    @Autowired
    private IAssetService assetService;



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
    public Map<String, Object> queryAssetMap(List<String> ids, AssetVO asset) {
        Map<String,Object> map=new HashMap<>();
        List<Asset> list= queryAssetList(null,asset);
        // 关联出 资产分类 数据
        assetService.join(list, AssetMeta.CATEGORY);
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

        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for(int i=0;i<list.size();i++){
            Asset assetItem=list.get(i);
            Map<String, Object> assetMap= BeanUtil.toMap(assetItem);
            if(assetItem.getPosition()!=null){
                // 关联出 存放位置 数据
                assetMap.put("assetPositionName",assetItem.getPosition().getName());
            }
            if(assetItem.getCategory()!=null){
                //关联出 分类 数据
                assetMap.put("assetCategoryName",assetItem.getCategory().getName());
            }
            if(assetItem.getGoods()!=null){
                //关联出 物品档案 数据
                assetMap.put("assetGoodName",assetItem.getGoods().getName());
            }
            if(assetItem.getManufacturer()!=null){
                //关联出 厂商 数据
                assetMap.put("assetManufacturerName",assetItem.getManufacturer().getManufacturerName());
            }
            if(assetItem.getWarehouse()!=null){
                //关联出 仓库 数据
                assetMap.put("assetWarehouseName",assetItem.getWarehouse().getWarehouseName());
            }
            if(assetItem.getMaintnainer()!=null){
                //关联出 维保商 数据
                assetMap.put("assetMaintainerName",assetItem.getMaintnainer().getMaintainerName());
            }
            if(assetItem.getCategoryFinance()!=null){
                // 关联出 财务分类数据
                assetMap.put("assetCategoryFinanceName",assetItem.getCategoryFinance().getCategoryName());
            }
            if(assetItem.getSupplier()!=null){
                // 关联出 供应商 数据
                assetMap.put("assetSupplierName",assetItem.getSupplier().getSupplierName());
            }
            if(assetItem.getSource()!=null){
                // 关联出 来源 数据
                assetMap.put("assetSourceName",assetItem.getSource().getLabel());
            }

          //  System.out.println(assetMap);
            listMap.add(assetMap);
        }
        map.put("assetList", listMap);
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
