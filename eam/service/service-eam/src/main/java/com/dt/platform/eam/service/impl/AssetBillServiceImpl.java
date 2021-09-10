package com.dt.platform.eam.service.impl;

import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.service.IAssetBillService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.apache.poi.ss.formula.functions.T;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 资产字段配置 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-08 16:54:30
 */


@Service("AssetBillService")
public class AssetBillServiceImpl extends SuperService<Asset> implements IAssetBillService {


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
    public Result queryBorrowBills(List<T> ids) {
        return null;
    }

    @Override
    public Result queryCollectionBills(List<T> ids) {
        return null;
    }

    @Override
    public Result queryCollectionReturnBills(List<T> ids) {
        return null;
    }

    @Override
    public Result queryCollectionScrapBills(List<T> ids) {
        return null;
    }

    @Override
    public Result queryCollectionRepairBills(List<T> ids) {
        return null;
    }

    @Override
    public Result queryCollectionAllocationBills(List<T> ids) {
        return null;
    }


}
