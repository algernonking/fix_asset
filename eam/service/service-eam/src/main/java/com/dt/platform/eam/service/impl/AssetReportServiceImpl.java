package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.service.IAssetDataService;
import com.dt.platform.eam.service.IAssetReportService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
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

    @Override
    public Result<JSONObject>  dashboard() {

        JSONObject result=new JSONObject();

        //获取资产分类数据
        String sql="select asset_status,count(1) cnt, IFNULL(sum(original_unit_price),0) asset_original_unit_price from eam_asset where owner_code='asset' and deleted=0  and status='complete' group by asset_status order by 2 desc";
        RcdSet rs=dao.query(sql);
        JSONArray assetStatusArr=new JSONArray();
        JSONArray assetStatusPieData=new JSONArray();
        for(int i=0;i<rs.size();i++){
            JSONObject r=rs.getRcd(i).toJSONObject();
            String assetStatus=rs.getRcd(i).getString("asset_status");
            String value= EnumUtil.parseByCode(AssetStatusEnum.class,assetStatus)==null
                    ?assetStatus:EnumUtil.parseByCode(AssetStatusEnum.class,assetStatus).text();
            r.put("name",value);
            assetStatusArr.add(r);

            JSONObject r2=new JSONObject();
            r2.put("value",rs.getRcd(i).getInteger("cnt"));
            r2.put("name",value);
            assetStatusPieData.add(r2);
        }
        result.put("assetStatusData",assetStatusArr);
        result.put("assetStatusPieData",assetStatusPieData);

        //资产分类
        String sql2="select b.name,count(1) cnt from eam_asset a, pcm_catalog b where a.owner_code='asset' and a.deleted=0  and a.status='complete'  \n" +
                "and a.category_id=b.id group by name";
        RcdSet rs2=dao.query(sql2);
        JSONArray catalogName=new JSONArray();
        JSONArray catalogCount=new JSONArray();
        for(int i=0;i<rs2.size();i++){
            catalogName.add(rs2.getRcd(i).getString("name"));
            catalogCount.add(rs2.getRcd(i).getInteger("cnt"));
        }
        result.put("catalogNameData",catalogName);
        result.put("catalogCountData",catalogCount);

        //资产总数
        String sql3="select \n" +
                "(select count(1) asset_cnt from eam_asset a where a.owner_code='asset' and a.deleted=0  and a.status='complete') asset_cnt,\n" +
                "(select IFNULL(sum(original_unit_price),0) asset_original_unit_price from eam_asset a where a.owner_code='asset' and a.deleted=0  and a.status='complete') asset_original_unit_price,\n" +
                "(select count(1) asset_clean_cnt from eam_asset a where a.owner_code='asset_clean_out' and a.deleted=0  and a.status='complete') asset_clean_cnt,\n" +
                "(select count(1) asset_repair_cnt from eam_asset a where a.owner_code='asset' and a.deleted=0  and a.status='complete' and a.asset_status='repair') asset_repair_cnt\n";

        Rcd rs3=dao.queryRecord(sql3);
        result.put("assetData",rs3.toJSONObject());

        Result<JSONObject> resJson=new Result<>();
        resJson.data(result);
        return resJson;
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
