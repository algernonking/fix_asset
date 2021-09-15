package com.dt.platform.eam.service.impl;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetExtAttribution;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.eam.service.IAssetDataService;
import com.dt.platform.eam.service.IAssetExtAttributionService;
import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("EamAssetDataService")
public class AssetDataServiceImpl  extends SuperService<Asset> implements IAssetDataService {


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
    public List<Asset> queryAssetData(List<String> ids, AssetVO asset) {

        return assetService.queryList(asset);
    }



}
