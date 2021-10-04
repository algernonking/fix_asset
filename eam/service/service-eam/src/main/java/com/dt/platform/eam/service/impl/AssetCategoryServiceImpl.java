package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.eam.service.IAssetBorrowService;
import com.dt.platform.eam.service.IAssetCategoryService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBDataType;
import org.github.foxnic.web.domain.pcm.*;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogAttributeServiceProxy;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        DataQueryVo d=new DataQueryVo();
        return CatalogServiceProxy.api().queryNodes(categoryV0).getData();
    }


    @Override
    public String queryNodesByCode(String code)
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
    }

    @Override
    public List<CatalogAttribute> queryCatalogAttributeByAssetCategory(String categoryId) {
        List<CatalogAttribute> list=new ArrayList<>();
        if(StringUtil.isBlank(categoryId)) return list;
        CatalogAttributeVO vo=new CatalogAttributeVO();
        vo.setCatalogId(categoryId);
        Result<List<CatalogAttribute>> result=CatalogAttributeServiceProxy.api().queryList(vo);
        if(result.isSuccess()){
            for(CatalogAttribute e:result.getData()){
                if(DataType.STRING.code().equals(e.getDataType())
                        ||DataType.DATE_TIME.code().equals(e.getDataType())
                        ||DataType.DECIMAL.code().equals(e.getDataType())
                        ||DataType.INTEGER.code().equals(e.getDataType())){
                    list.add(e);
                }
            }
        }
        return list;
    }
}
