package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.service.IAssetDataService;
import com.dt.platform.eam.service.IAssetReportService;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.apache.poi.ss.formula.functions.T;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;

@Service("EAMAssetReportService")
public class AssetReportServiceImpl  extends SuperService<Asset> implements IAssetReportService {


    @Autowired
    IAssetDataService assetDataService;

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
    public Object generateId(Field field) {
        return IDGenerator.getSnowflakeIdString();
    }


    public JSONArray queryOrganizationData(Asset sample){

        HashMap<String,String> org = assetDataService.queryUseOrganizationNodes();
        //查询组织
        String tenantId= SessionUser.getCurrent().getActivatedTenantId();
        JSONArray data=new JSONArray();
        String sql="SELECT '' AS name, t.*\n" +
                " , (\n" +
                "  SELECT hierarchy\n" +
                "  FROM hrm_organization\n" +
                "  WHERE id = use_organization_id\n" +
                " ) AS hierarchy\n" +
                "FROM (\n" +
                " SELECT use_organization_id, COUNT(1) AS cnt\n" +
                " FROM  (select ifnull(use_organization_id,'') use_organization_id ,i.id,i.status,i.owner_code ,i.tenant_id,i.deleted from eam_asset i) s\n" +
                " WHERE s.deleted = '0'\n" +
                "    AND s.tenant_id=?\n" +
                "  AND s.owner_code = 'asset'\n" +
                "  AND s.status  IN ('complete')\n" +
                " GROUP BY s.use_organization_id\n" +
                ") t order by hierarchy";
        RcdSet rs=dao.query(sql,tenantId);
        //id,org_id,name,count
        for(int i=0;i<rs.size();i++){
            String key=rs.getRcd(i).getString("use_organization_id");
            if(StringUtil.isBlank(key))
                rs.getRcd(i).setValue("name","资产未分配有使用组织结构");
            if(org.containsKey(key)){
                rs.getRcd(i).setValue("name",org.get(key));
            }
        }
        data = rs.toJSONArrayWithJSONObject();
        return data;
    }

    public JSONArray queryCategoryData(Asset sample){
        HashMap<String,String> org = assetDataService.queryAssetCategoryNodes();
        //查询分类
        String tenantId= SessionUser.getCurrent().getActivatedTenantId();
        JSONArray data=new JSONArray();
        String sql="SELECT '' AS name, t.*\n" +
                " , (\n" +
                "  SELECT hierarchy\n" +
                "  FROM pcm_catalog\n" +
                "  WHERE id = t.category_id\n" +
                " ) AS hierarchy\n" +
                "FROM (\n" +
                " SELECT category_id, COUNT(1) AS cnt\n" +
                " FROM  (select ifnull(category_id,'') category_id ,i.id,i.status,i.owner_code ,i.tenant_id,i.deleted from eam_asset i) s\n" +
                " WHERE s.deleted = '0'\n" +
                "    AND s.tenant_id=?\n" +
                "  AND s.owner_code = 'asset'\n" +
                "  AND s.status  IN ('complete')\n" +
                " GROUP BY s.category_id\n" +
                ") t order by hierarchy";
        RcdSet rs=dao.query(sql,tenantId);
        //id,category_id,name,count
        for(int i=0;i<rs.size();i++){
            String key=rs.getRcd(i).getString("category_id");
            if(StringUtil.isBlank(key))
                rs.getRcd(i).setValue("name","资产未分配分类");
            if(org.containsKey(key)){
                rs.getRcd(i).setValue("name",org.get(key));
            }
        }
        data = rs.toJSONArrayWithJSONObject();
        System.out.println(data);
        return data;
    }


}
