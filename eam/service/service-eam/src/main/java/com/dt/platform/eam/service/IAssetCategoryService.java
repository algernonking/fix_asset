package com.dt.platform.eam.service;

import com.dt.platform.domain.eam.AssetCollectionReturn;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.ISuperService;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.misc.ztree.ZTreeNode;

import java.util.List;

public interface IAssetCategoryService  extends ISuperService<Catalog> {


    /**
     * 加载PCM资产树
     * @return 查询结果
     */
    List<ZTreeNode> queryNodes();
}
