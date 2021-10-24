package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.service.IAssetAlarmService;
import com.dt.platform.eam.service.IAssetBorrowService;
import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

@Service
public class AssetAlarmServiceImpl extends SuperService<Asset> implements IAssetAlarmService {


    @Autowired
    IAssetService assetService;



    @Autowired
    IAssetBorrowService assetBorrowService;

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
    public PagedList<Asset> queryAlarmData(Asset sample, int pageSize, int pageIndex) {
        PagedList<Asset> list=assetService.queryPagedList(sample,pageSize,pageIndex);
        assetService.joinData(list.getList());
        return list;
    }

    @Override
    public JSONArray queryBorrowAlarmData(Asset sample, int pageSize, int pageIndex) {

        String tenantId=SessionUser.getCurrent().getActivatedTenantId();
        String sql="select handle_id,asset_id,a.* from eam_asset_borrow a,eam_asset_item b,eam_asset c\n" +
                "where a.tenant_id='"+tenantId+"' and a.id=b.handle_id \n" +
                "and b.asset_id=c.id\n" +
                "and a.deleted=0 and b.deleted=0\n" +
                "and a.borrow_status='borrowed' \n" +
                "and c.asset_status='borrow'";
        RcdSet rs=dao.query(sql);
        HashMap<String, Rcd> assetMap=(HashMap<String,Rcd>)rs.getMappedRcds("asset_id",String.class);
        ConditionExpr exp=new ConditionExpr();
        exp.and( " id in (  select asset_id from ("+sql+") t  )  " );
        List<Asset> assetList=assetService.queryList(Asset.create(),exp);
        assetService.joinData(assetList);
        JSONArray data=new JSONArray();
        for(Asset asset:assetList){
            JSONObject e=BeanUtil.toJSONObject(asset);
            String assetId=asset.getId();
            if(assetMap.containsKey(assetId)){
                e.put("bill",assetMap.get(assetId).toJSONObject());
            }
            data.add(e);
        }
        return data;
    }

    @Override
    public PagedList<Asset> queryMaintenanceAlarmData(Asset sample, int pageSize, int pageIndex) {
        return queryAlarmData(sample,pageSize,pageIndex);
    }

    @Override
    public PagedList<Asset> queryCollectionAlarmData(Asset sample, int pageSize, int pageIndex) {


        return queryAlarmData(sample,pageSize,pageIndex);
    }

    @Override
    public JSONArray queryAssetSerialNumberUnique() {
        String tenantId= SessionUser.getCurrent().getActivatedTenantId();
        JSONArray data=new JSONArray();
        String sql="\n" +
                "select * from (\n" +
                "select serial_number,count(1) cnt from \n" +
                "(   select ifnull(i.serial_number,'')serial_number ,i.id,i.status,i.owner_code ,i.tenant_id,i.deleted from eam_asset i    ) t\n" +
                " where deleted='0' and owner_code='asset' and tenant_id=? group by serial_number\n" +
                ") t2 where  trim(serial_number) <>'' and  cnt>1";
        RcdSet rs=dao.query(sql,tenantId);
        return rs.toJSONArrayWithJSONObject();
    }


}
