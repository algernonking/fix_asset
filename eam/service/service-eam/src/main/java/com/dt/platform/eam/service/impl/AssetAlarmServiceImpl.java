package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.service.IAssetAlarmService;
import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
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
        assetService.joinData(list);
        return list;
    }

    @Override
    public PagedList<Asset> queryBorrowAlarmData(Asset sample, int pageSize, int pageIndex) {
        return queryAlarmData(sample,pageSize,pageIndex);
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
                "\n" +
                " \n" +
                "select * from (\n" +
                "select serial_number,count(1) cnt from \n" +
                "(   select ifnull(i.serial_number,'')serial_number ,i.id,i.status,i.owner_code ,i.tenant_id,i.deleted from eam_asset i    ) t\n" +
                " where deleted='0' and owner_code='asset' and tenant_id=? group by serial_number\n" +
                ") t2 where  trim(serial_number) <>'' and  cnt>1";
        RcdSet rs=dao.query(sql,tenantId);
        return rs.toJSONArrayWithJSONObject();
    }


}
