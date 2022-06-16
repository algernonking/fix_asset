package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskStatusEnum;
import com.dt.platform.constants.enums.eam.RepairOrderStatusEnum;
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

        //资产位置
        String posSql="select t.*,\n" +
                "(select name from eam_position where id=t.position_id) label from (\n" +
                "select position_id,count(1) cnt, IFNULL(sum(original_unit_price),0) asset_original_unit_price from eam_asset where owner_code='asset' and deleted=0  and status='complete' group by position_id order by 2 desc\n" +
                ")t";
        RcdSet posRs=dao.query(posSql);
        JSONArray posAssetArr=new JSONArray();
        JSONArray posAssetPieData=new JSONArray();
        for(int i=0;i<posRs.size();i++){
            JSONObject r=posRs.getRcd(i).toJSONObject();
            String value=StringUtil.isBlank(posRs.getRcd(i).getString("label"))?"未知":posRs.getRcd(i).getString("label"); ;
            r.put("name",value);
            posAssetArr.add(r);

            JSONObject r2=new JSONObject();
            r2.put("value",posRs.getRcd(i).getInteger("cnt"));
            r2.put("name",value);
            posAssetPieData.add(r2);
        }
        result.put("posAssetData",posAssetArr);
        result.put("posAssetPieData",posAssetPieData);


        //所属组织
        String ownerSql="select t.*,\n" +
                "(select full_name from hrm_organization where id=t.own_company_id) label from (\n" +
                "select own_company_id,count(1) cnt, IFNULL(sum(original_unit_price),0) asset_original_unit_price from eam_asset where owner_code='asset' and deleted=0  and status='complete' group by own_company_id order by 2 desc\n" +
                ")t\n";
        RcdSet ownerRs=dao.query(ownerSql);
        JSONArray ownerAssetArr=new JSONArray();
        JSONArray ownerAssetPieData=new JSONArray();
        for(int i=0;i<ownerRs.size();i++){
            JSONObject r=ownerRs.getRcd(i).toJSONObject();
            String value=StringUtil.isBlank(ownerRs.getRcd(i).getString("label"))?"未知":ownerRs.getRcd(i).getString("label"); ;
            r.put("name",value);
            ownerAssetArr.add(r);

            JSONObject r2=new JSONObject();
            r2.put("value",ownerRs.getRcd(i).getInteger("cnt"));
            r2.put("name",value);
            ownerAssetPieData.add(r2);
        }
        result.put("ownerAssetData",ownerAssetArr);
        result.put("ownerAssetPieData",ownerAssetPieData);


        //资产分类
        String sql2="select b.name,count(1) cnt from eam_asset a, pcm_catalog b where a.owner_code='asset' and a.deleted=0 and a.status='complete' and a.category_id=b.id group by name";
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
                "(select count(1) from eam_asset_tranfer where deleted='0' and status='approval') wait_asset_tranfer_cnt,\n" +
                "(select count(1) maintenance_end_cnt from eam_asset a where a.owner_code='asset' and a.deleted=0 and a.status='complete' and maintenance_end_date>date_sub(curdate(),interval 30 day) )maintenance_end_cnt,\n"+
                "(select count(1) asset_cnt from eam_asset a where a.owner_code='asset' and a.deleted=0  and a.status='complete') asset_cnt,\n" +
                "(select IFNULL(sum(original_unit_price),0) asset_original_unit_price from eam_asset a where a.owner_code='asset' and a.deleted=0  and a.status='complete') asset_original_unit_price,\n" +
                "(select count(1) asset_clean_cnt from eam_asset a where a.owner_code='asset_clean_out' and a.deleted=0  and a.status='complete') asset_clean_cnt,\n" +
                "(select count(1) asset_repair_cnt from eam_asset a where a.owner_code='asset' and a.deleted=0  and a.status='complete' and a.asset_status='repair') asset_repair_cnt\n";

        Rcd rs3=dao.queryRecord(sql3);
        result.put("assetData",rs3.toJSONObject());


        //公司占比


        //区域占比


        Result<JSONObject> resJson=new Result<>();
        resJson.data(result);
        return resJson;
    }

    @Override
    public Result<JSONObject> dashboardMro() {
        Result<JSONObject> resJson=new Result<>();
        JSONObject result=new JSONObject();


        String sql="select count(1) repair_asset_cnt from eam_asset_item where handle_id in (select id from eam_repair_order where repair_status='finish' and deleted='0') and deleted='0' ";
        result.put("repairAssetCnt",dao.queryRecord(sql).getInteger("repair_asset_cnt"));

        String sql11="select count(1) repairing_asset_cnt from eam_asset_item where handle_id in ( select id from eam_repair_order where repair_status in ('dispatched','repairing') and deleted='0' ) and deleted='0' ";
        result.put("repairingAssetCnt",dao.queryRecord(sql11).getInteger("repairing_asset_cnt"));

        String sql111=" select count(1) repair_order_not_dispatch_cnt from eam_repair_order where repair_status in ('not_dispatch') and deleted='0'   ";
        result.put("repairOrderNotDispatchCnt",dao.queryRecord(sql111).getInteger("repair_order_not_dispatch_cnt"));

        String sql2="select count(1) maintain_project_cnt from eam_maintain_task_project where task_id in (\n" +
                "select id from eam_maintain_task where status='finish' and deleted='0')\n" +
                "and deleted='0'";
        result.put("maintainProjectCnt",dao.queryRecord(sql2).getInteger("maintain_project_cnt"));

        String sql3="select count(1) inspection_task_cnt from eam_inspection_task where task_status='finish' and deleted='0'";
        result.put("inspectionTaskCnt",dao.queryRecord(sql3).getInteger("inspection_task_cnt"));

        String sql31="select count(1) inspection_task_point_cnt from eam_inspection_task_point where task_id in (select id inspection_task_cnt from eam_inspection_task where task_status='finish' and deleted='0') and deleted='0'";
        result.put("inspectionTaskPointCnt",dao.queryRecord(sql31).getInteger("inspection_task_point_cnt"));

        String sql4="select (select count(1) finish_cnt from eam_repair_order where status='complete' and deleted='0' and repair_status='finish') finish_cnt,\n" +
                "(select count(1) not_dispatch_cnt from eam_repair_order where status='complete' and deleted='0' and repair_status='not_dispatch')not_dispatch_cnt,\n" +
                "(select count(1) wait_acceptance_cnt from eam_repair_order where status='complete' and deleted='0' and repair_status='wait_acceptance')wait_acceptance_cnt,\n" +
                "(select count(1) dispatched_cnt from eam_repair_order where status='complete' and deleted='0' and repair_status='dispatched')dispatched_cnt,\n" +
                "(select count(1) repairing_cnt from eam_repair_order where status='complete' and deleted='0' and repair_status='repairing')repairing_cnt";
        Rcd rs=dao.queryRecord(sql4);
        JSONArray repairData=new JSONArray();
        JSONObject a1=new JSONObject();
        a1.put("name", RepairOrderStatusEnum.FINISH.text());
        a1.put("value",rs.getInteger("finish_cnt"));
        repairData.add(a1);

        JSONObject a2=new JSONObject();
        a2.put("name", RepairOrderStatusEnum.NOT_DISPATCH.text());
        a2.put("value",rs.getInteger("not_dispatch_cnt"));
        repairData.add(a2);


        JSONObject a3=new JSONObject();
        a3.put("name", RepairOrderStatusEnum.WAIT_ACCEPTANCE.text());
        a3.put("value",rs.getInteger("wait_acceptance_cnt"));
        repairData.add(a3);

        JSONObject a4=new JSONObject();
        a4.put("name", RepairOrderStatusEnum.DISPATCHED.text());
        a4.put("value",rs.getInteger("dispatched_cnt"));
        repairData.add(a4);

        JSONObject a5=new JSONObject();
        a5.put("name", RepairOrderStatusEnum.REPAIRING.text());
        a5.put("value",rs.getInteger("repairing_cnt"));
        repairData.add(a5);

        result.put("repairData",repairData);

        String sql5="\n" +
                "select \n" +
                "(select count(1) not_start_cnt from eam_inspection_task where task_status='not_start' and deleted='0')not_start_cnt,\n" +
                "(select count(1) acting_cnt from eam_inspection_task where task_status='acting' and deleted='0')acting_cnt,\n" +
                "(select count(1) finish_cnt from eam_inspection_task where task_status='finish' and deleted='0')finish_cnt\n" +
                "\n";
        Rcd rs2=dao.queryRecord(sql5);
        JSONArray inspectionData=new JSONArray();
        JSONObject b1=new JSONObject();
        b1.put("name", InspectionTaskStatusEnum.NOT_START.text());
        b1.put("value",rs2.getInteger("not_start_cnt"));
        inspectionData.add(b1);

        JSONObject b2=new JSONObject();
        b2.put("name", InspectionTaskStatusEnum.ACTING.text());
        b2.put("value",rs2.getInteger("acting_cnt"));
        inspectionData.add(b2);

        JSONObject b3=new JSONObject();
        b3.put("name", InspectionTaskStatusEnum.FINISH.text());
        b3.put("value",rs2.getInteger("finish_cnt"));
        inspectionData.add(b3);
        result.put("inspectionData",inspectionData);


        String sql6="select a.name,b.project_cnt from eam_maintain_project a,(\n" +
                "select project_id,count(1) project_cnt from eam_maintain_task_project where task_id in (\n" +
                "select id from eam_maintain_task where status='finish' and deleted='0'\n" +
                ") and deleted=0 group by project_id)b where a.id=b.project_id\n";

        RcdSet rs6=dao.query(sql6);
        JSONArray maintainProjectName=new JSONArray();
        JSONArray maintainProjectCount=new JSONArray();
        for(int i=0;i<rs6.size();i++){
            maintainProjectName.add(rs6.getRcd(i).getString("name"));
            maintainProjectCount.add(rs6.getRcd(i).getInteger("project_cnt"));
        }
        result.put("assetMaintainProjectName",maintainProjectName);
        result.put("assetMaintainProjectCount",maintainProjectCount);

        resJson.data(result);

        return resJson;
    }

    public JSONArray queryOrganizationData(Asset sample){

//        HashMap<String,String> org = assetDataService.queryUseOrganizationNodes();
//        //查询组织
//        String tenantId= SessionUser.getCurrent().getActivatedTenantId();
//        JSONArray data=new JSONArray();
//        String sql="SELECT '' AS name, t.*\n" +
//                " , (\n" +
//                "  SELECT hierarchy\n" +
//                "  FROM hrm_organization\n" +
//                "  WHERE id = use_organization_id\n" +
//                " ) AS hierarchy\n" +
//                "FROM (\n" +
//                " SELECT use_organization_id, COUNT(1) AS cnt\n" +
//                " FROM  (select ifnull(use_organization_id,'') use_organization_id ,i.id,i.status,i.owner_code ,i.tenant_id,i.deleted from eam_asset i) s\n" +
//                " WHERE s.deleted = '0'\n" +
//                "    AND s.tenant_id=?\n" +
//                "  AND s.owner_code = 'asset'\n" +
//                "  AND s.status  IN ('complete')\n" +
//                " GROUP BY s.use_organization_id\n" +
//                ") t order by hierarchy";
//        RcdSet rs=dao.query(sql,tenantId);
//        //id,org_id,name,count
//        for(int i=0;i<rs.size();i++){
//            String key=rs.getRcd(i).getString("use_organization_id");
//            if(StringUtil.isBlank(key))
//                rs.getRcd(i).setValue("name","资产未分配有使用组织结构");
//            if(org.containsKey(key)){
//                rs.getRcd(i).setValue("name",org.get(key));
//            }
//        }
//        data = rs.toJSONArrayWithJSONObject();

        String sql="select hm.full_name name,hm.type,t2.*,t2.idle_cnt+t2.using_cnt+t2.borrow_cnt+t2.repair_cnt+t2.allocate_cnt+t2.scrap_cnt sum_cnt from (\n" +
                "select ti.use_organization_id,\n" +
                "sum(ti.idle_cnt) idle_cnt,\n" +
                "sum(ti.using_cnt) using_cnt,\n" +
                "sum(ti.borrow_cnt) borrow_cnt,\n" +
                "sum(ti.repair_cnt) repair_cnt,\n" +
                "sum(ti.allocate_cnt) allocate_cnt,\n" +
                "sum(ti.scrap_cnt) scrap_cnt\n" +
                "from (\n" +
                "select t.use_organization_id,\n" +
                "case t.asset_status when 'idle' then cnt else 0 end idle_cnt,\n" +
                "case t.asset_status when 'using' then cnt else 0 end using_cnt,\n" +
                "case t.asset_status when 'borrow' then cnt else 0 end borrow_cnt,\n" +
                "case t.asset_status when 'repair' then cnt else 0 end repair_cnt,\n" +
                "case t.asset_status when 'allocate' then cnt else 0 end allocate_cnt,\n" +
                "case t.asset_status when 'scrap' then cnt else 0 end scrap_cnt\n" +
                " from (\n" +
                "select use_organization_id,asset_status,count(1) cnt from eam_asset where deleted=0 and status='complete' and owner_code='asset' and clean_out=0\n" +
                "group by use_organization_id, asset_status\n" +
                ")t)ti group by ti.use_organization_id\n" +
                ")t2,hrm_organization hm where t2.use_organization_id=hm.id";
        RcdSet rs=dao.query(sql);
        return rs.toJSONArrayWithJSONObject();

    }

    @Override
    public JSONArray queryOwnCompanyData(Asset sample) {
        String sql="select hm.full_name name,hm.type,t2.*,t2.idle_cnt+t2.using_cnt+t2.borrow_cnt+t2.repair_cnt+t2.allocate_cnt+t2.scrap_cnt sum_cnt from (\n" +
                "select ti.own_company_id,\n" +
                "sum(ti.idle_cnt) idle_cnt,\n" +
                "sum(ti.using_cnt) using_cnt,\n" +
                "sum(ti.borrow_cnt) borrow_cnt,\n" +
                "sum(ti.repair_cnt) repair_cnt,\n" +
                "sum(ti.allocate_cnt) allocate_cnt,\n" +
                "sum(ti.scrap_cnt) scrap_cnt\n" +
                "from (\n" +
                "select t.own_company_id,\n" +
                "case t.asset_status when 'idle' then cnt else 0 end idle_cnt,\n" +
                "case t.asset_status when 'using' then cnt else 0 end using_cnt,\n" +
                "case t.asset_status when 'borrow' then cnt else 0 end borrow_cnt,\n" +
                "case t.asset_status when 'repair' then cnt else 0 end repair_cnt,\n" +
                "case t.asset_status when 'allocate' then cnt else 0 end allocate_cnt,\n" +
                "case t.asset_status when 'scrap' then cnt else 0 end scrap_cnt\n" +
                " from (\n" +
                "select own_company_id,asset_status,count(1) cnt from eam_asset where deleted=0 and status='complete' and owner_code='asset' and clean_out=0\n" +
                "group by own_company_id, asset_status\n" +
                ")t)ti group by ti.own_company_id\n" +
                ")t2,hrm_organization hm where t2.own_company_id=hm.id";
        RcdSet rs=dao.query(sql);
        return rs.toJSONArrayWithJSONObject();
    }

    public JSONArray queryCategoryStatusData(Asset sample){
        String sql="select pcm.name,pcm.code,t2.*,t2.idle_cnt+t2.using_cnt+t2.borrow_cnt+t2.repair_cnt+t2.allocate_cnt+t2.scrap_cnt sum_cnt from (\n" +
                "select ti.category_id,\n" +
                "sum(ti.idle_cnt) idle_cnt,\n" +
                "sum(ti.using_cnt) using_cnt,\n" +
                "sum(ti.borrow_cnt) borrow_cnt,\n" +
                "sum(ti.repair_cnt) repair_cnt,\n" +
                "sum(ti.allocate_cnt) allocate_cnt,\n" +
                "sum(ti.scrap_cnt) scrap_cnt\n" +
                "from (\n" +
                "select t.category_id,\n" +
                "case t.asset_status when 'idle' then cnt else 0 end idle_cnt,\n" +
                "case t.asset_status when 'using' then cnt else 0 end using_cnt,\n" +
                "case t.asset_status when 'borrow' then cnt else 0 end borrow_cnt,\n" +
                "case t.asset_status when 'repair' then cnt else 0 end repair_cnt,\n" +
                "case t.asset_status when 'allocate' then cnt else 0 end allocate_cnt,\n" +
                "case t.asset_status when 'scrap' then cnt else 0 end scrap_cnt\n" +
                " from (\n" +
                "select category_id,asset_status,count(1) cnt from eam_asset where deleted=0 and status='complete' and owner_code='asset' and clean_out=0\n" +
                "group by category_id, asset_status\n" +
                ")t)ti group by ti.category_id\n" +
                ")t2,pcm_catalog pcm where t2.category_id=pcm.id";
        RcdSet rs=dao.query(sql);
        return rs.toJSONArrayWithJSONObject();
    }
    public JSONArray queryCategoryData(Asset sample){
        HashMap<String,String> org = assetDataService.queryAssetCategoryNodes("all");
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
