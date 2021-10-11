package com.dt.platform.eam.service.impl;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.service.IAssetAlarmService;
import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
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
        // 关联出 资产分类 数据
        assetService.join(list, AssetMeta.CATEGORY);
        // 关联出 物品档案 数据
        assetService.join(list,AssetMeta.GOODS);
        // 关联出 厂商 数据
        assetService.join(list,AssetMeta.MANUFACTURER);
        // 关联出 位置 数据
        assetService.join(list,AssetMeta.POSITION);

        // 关联出 维保商 数据
        assetService.join(list,AssetMeta.MAINTNAINER);
        // 关联出 供应商 数据
        assetService.join(list,AssetMeta.SUPPLIER);

        // 关联出 来源 数据
        assetService.join(list,AssetMeta.SOURCE);
        assetService.join(list,AssetMeta.SAFETY_LEVEL);
        assetService.join(list,AssetMeta.EQUIPMENT_ENVIRONMENT);

        assetService.join(list,AssetMeta.OWNER_COMPANY);
        assetService.join(list,AssetMeta.USE_ORGANIZATION);
        assetService.join(list,AssetMeta.MANAGER);
        assetService.join(list,AssetMeta.USE_USER);
        assetService.join(list,AssetMeta.ORIGINATOR);

//        List<Employee> originators= CollectorUtil.collectList(list,Asset::getOriginator);
//        assetService.dao().join(originators, Person.class);
//
//        List<Employee> managers= CollectorUtil.collectList(list,Asset::getManager);
//        assetService.dao().join(managers, Person.class);
//
//        List<Employee> useUser= CollectorUtil.collectList(list,Asset::getUseUser);
//        assetService.dao().join(useUser, Person.class);
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
}
