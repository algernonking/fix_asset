package com.dt.platform.eam.service;

import com.dt.platform.domain.eam.AssetCollectionReturn;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.ISuperService;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.misc.ztree.ZTreeNode;

import java.util.List;

public interface IAssetCategoryService  extends ISuperService<Catalog> {


    /**
     * 加载PCM资产树
     * @param categoryV0 节点
     * @return 查询结果
     */
    List<ZTreeNode> queryNodes(CatalogVO categoryV0);

    /**
     * @param code 节点CODE
     * @return 节点ID
     */
     String queryNodeIdByCode(String code);

    /**
     * @param id 节点
     * @return 节点ID
     */
    String queryCatalogAttributeIdByCode(String id);
}
