package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetHandle;
import com.dt.platform.domain.eam.AssetHandleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 资产处置  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:27:45
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetHandleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetHandleServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-handle
     */
    public static final String API_CONTEXT_PATH = "eam-asset-handle";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产处置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产处置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产处置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产处置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产处置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产处置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产处置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产处置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产处置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产处置数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产处置导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产处置数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetHandleVO") AssetHandleVO assetHandleVO);

    /**
     * 删除资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetHandleVO") AssetHandleVO assetHandleVO);

    /**
     * 更新资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetHandleVO") AssetHandleVO assetHandleVO);

    /**
     * 获取资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.GET_BY_ID)
    Result<AssetHandle> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.GET_BY_IDS)
    Result<List<AssetHandle>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.QUERY_LIST)
    Result<List<AssetHandle>> queryList(@RequestParam(name = "sample") AssetHandleVO sample);

    /**
     * 分页查询资产处置
     */
    @RequestMapping(AssetHandleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetHandle>> queryPagedList(@RequestParam(name = "sample") AssetHandleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetHandleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetHandleServiceProxy api() {
        return APIProxy.get(AssetHandleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
