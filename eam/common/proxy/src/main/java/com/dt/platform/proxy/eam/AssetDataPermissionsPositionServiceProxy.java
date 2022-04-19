package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDataPermissionsPosition;
import com.dt.platform.domain.eam.AssetDataPermissionsPositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 位置  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-17 09:15:33
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDataPermissionsPositionServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDataPermissionsPositionServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-data-permissions-position
     */
    public static final String API_CONTEXT_PATH = "eam-asset-data-permissions-position";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加位置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除位置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除位置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新位置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存位置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个位置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个位置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询位置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询位置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出位置数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载位置导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入位置数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDataPermissionsPositionVO") AssetDataPermissionsPositionVO assetDataPermissionsPositionVO);

    /**
     * 删除位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDataPermissionsPositionVO") AssetDataPermissionsPositionVO assetDataPermissionsPositionVO);

    /**
     * 更新位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDataPermissionsPositionVO") AssetDataPermissionsPositionVO assetDataPermissionsPositionVO);

    /**
     * 获取位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.GET_BY_ID)
    Result<AssetDataPermissionsPosition> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.GET_BY_IDS)
    Result<List<AssetDataPermissionsPosition>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.QUERY_LIST)
    Result<List<AssetDataPermissionsPosition>> queryList(@RequestParam(name = "sample") AssetDataPermissionsPositionVO sample);

    /**
     * 分页查询位置
     */
    @RequestMapping(AssetDataPermissionsPositionServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDataPermissionsPosition>> queryPagedList(@RequestParam(name = "sample") AssetDataPermissionsPositionVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDataPermissionsPositionController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDataPermissionsPositionServiceProxy api() {
        return APIProxy.get(AssetDataPermissionsPositionServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
