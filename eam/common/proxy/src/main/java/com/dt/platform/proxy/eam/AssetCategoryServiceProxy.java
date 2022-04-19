package com.dt.platform.proxy.eam;

import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = ServiceNames.EAM, contextId = AssetCategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetCategoryServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-borrow
     */
    public static final String API_CONTEXT_PATH = "eam-asset-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 查询资产
     */
    public static final String QUERY_NODES = API_PREFIX + "query-nodes";

    /**
     * 查询资产
     */
    public static final String QUERY_NODES_BY_CODE = API_PREFIX + "query-nodes-by-code";

    /**
     * 查询资产
     */
    public static final String QUERY_CATALOG_ATTRIBUTE_BY_ASSET_CATEGORY = API_PREFIX + "query-catalog-attribute-by-asset-category";

    /**
     * 查询资产
     */
    @RequestMapping(AssetCategoryServiceProxy.QUERY_NODES)
    Result<List<ZTreeNode>> queryNodes(@RequestParam(name = "categoryV0") CatalogVO categoryV0);

    /**
     * 根据code查询ID
     */
    @RequestMapping(AssetCategoryServiceProxy.QUERY_NODES_BY_CODE)
    Result<String> queryNodesByCode(@RequestParam(name = "code") String code);

    @RequestMapping(AssetCategoryServiceProxy.QUERY_CATALOG_ATTRIBUTE_BY_ASSET_CATEGORY)
    Result<List<CatalogAttribute>> queryCatalogAttributeByAssetCategory(@RequestParam(name = "categoryId") String categoryId);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetCategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetCategoryServiceProxy api() {
        return APIProxy.get(AssetCategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
