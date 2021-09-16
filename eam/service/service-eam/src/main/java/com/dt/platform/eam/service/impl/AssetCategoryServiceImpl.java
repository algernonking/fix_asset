package com.dt.platform.eam.service.impl;

import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.eam.service.IAssetBorrowService;
import com.dt.platform.eam.service.IAssetCategoryService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.domain.pcm.DataQueryVo;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EamAssetCategory")
public class AssetCategoryServiceImpl  extends SuperService<Catalog> implements IAssetCategoryService {


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
    public List<ZTreeNode> queryNodes(CatalogVO categoryV0) {
        return CatalogServiceProxy.api().queryNodes(categoryV0).getData();
    }


    @Override
    public String queryNodeIdByCode(String code)
    {
        CatalogVO categoryV0=new CatalogVO();
        categoryV0.setCode(code);
        Result<List<Catalog>> result=CatalogServiceProxy.api().queryList(categoryV0);
        if(result.isSuccess()){
            if(result.getData().size()>0){
                return result.getData().get(0).getId();
            }
        }
        return null;
       // return "486917609841758209";
    }

}
