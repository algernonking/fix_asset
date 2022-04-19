package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetSelectedData;
import com.dt.platform.domain.eam.AssetSelectedDataVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 资产选择  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 19:01:00
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetSelectedDataServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetSelectedDataServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-selected-data
     */
    public static final String API_CONTEXT_PATH = "eam-asset-selected-data";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产选择
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产选择
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产选择
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产选择
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产选择
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 保存资产选择
     */
    public static final String SAVE_BY_IDS = API_PREFIX + "save-by-ids";

    /**
     * 获取单个资产选择
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产选择
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产选择
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产选择
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询资产选择
     */
    public static final String QUERY_PAGED_LIST_BY_SELECT = API_PREFIX + "query-paged-list-by-select";

    public static final String QUERY_PAGED_LIST_BY_SELECTED = API_PREFIX + "query-paged-list-by-selected";

    /**
     * 导出资产选择数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产选择导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产选择数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetSelectedDataVO") AssetSelectedDataVO assetSelectedDataVO);

    /**
     * 删除资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetSelectedDataVO") AssetSelectedDataVO assetSelectedDataVO);

    /**
     * 更新资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetSelectedDataVO") AssetSelectedDataVO assetSelectedDataVO);

    /**
     * 获取资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.GET_BY_ID)
    Result<AssetSelectedData> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.GET_BY_IDS)
    Result<List<AssetSelectedData>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.QUERY_LIST)
    Result<List<AssetSelectedData>> queryList(@RequestParam(name = "sample") AssetSelectedDataVO sample);

    /**
     * 分页查询资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.SAVE_BY_IDS)
    Result saveById(@RequestParam(name = "ids") List<String> ids, @RequestParam(name = "assetSelectedCode") String assetSelectedCode);

    /**
     * 分页查询资产选择
     */
    @RequestMapping(AssetSelectedDataServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetSelectedData>> queryPagedList(@RequestParam(name = "sample") AssetSelectedDataVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetSelectedDataController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetSelectedDataServiceProxy api() {
        return APIProxy.get(AssetSelectedDataServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
