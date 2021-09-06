package com.dt.platform.eam.service.impl;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.service.IAssetReportService;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.apache.poi.ss.formula.functions.T;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.lang.reflect.Field;

public class AssetReportServiceImpl  extends SuperService<Asset> implements IAssetReportService {


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


}
