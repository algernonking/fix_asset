package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDataPermissionsCatalog;
import com.dt.platform.domain.eam.AssetDataPermissionsCatalogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 分类  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-16 15:22:58
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDataPermissionsCatalogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDataPermissionsCatalogServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-data-permissions-catalog
     */
    public static final String API_CONTEXT_PATH = "eam-asset-data-permissions-catalog";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出分类数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载分类导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入分类数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDataPermissionsCatalogVO") AssetDataPermissionsCatalogVO assetDataPermissionsCatalogVO);

    /**
     * 删除分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDataPermissionsCatalogVO") AssetDataPermissionsCatalogVO assetDataPermissionsCatalogVO);

    /**
     * 更新分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDataPermissionsCatalogVO") AssetDataPermissionsCatalogVO assetDataPermissionsCatalogVO);

    /**
     * 获取分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.GET_BY_ID)
    Result<AssetDataPermissionsCatalog> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.GET_BY_IDS)
    Result<List<AssetDataPermissionsCatalog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.QUERY_LIST)
    Result<List<AssetDataPermissionsCatalog>> queryList(@RequestParam(name = "sample") AssetDataPermissionsCatalogVO sample);

    /**
     * 分页查询分类
     */
    @RequestMapping(AssetDataPermissionsCatalogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDataPermissionsCatalog>> queryPagedList(@RequestParam(name = "sample") AssetDataPermissionsCatalogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDataPermissionsCatalogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDataPermissionsCatalogServiceProxy api() {
        return APIProxy.get(AssetDataPermissionsCatalogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
