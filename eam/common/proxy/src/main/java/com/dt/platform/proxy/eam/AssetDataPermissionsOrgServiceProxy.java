package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDataPermissionsOrg;
import com.dt.platform.domain.eam.AssetDataPermissionsOrgVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 组织  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-16 15:24:09
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDataPermissionsOrgServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDataPermissionsOrgServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-data-permissions-org
     */
    public static final String API_CONTEXT_PATH = "eam-asset-data-permissions-org";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加组织
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除组织
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除组织
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新组织
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存组织
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个组织
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个组织
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询组织
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询组织
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出组织数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载组织导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入组织数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDataPermissionsOrgVO") AssetDataPermissionsOrgVO assetDataPermissionsOrgVO);

    /**
     * 删除组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDataPermissionsOrgVO") AssetDataPermissionsOrgVO assetDataPermissionsOrgVO);

    /**
     * 更新组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDataPermissionsOrgVO") AssetDataPermissionsOrgVO assetDataPermissionsOrgVO);

    /**
     * 获取组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.GET_BY_ID)
    Result<AssetDataPermissionsOrg> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.GET_BY_IDS)
    Result<List<AssetDataPermissionsOrg>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.QUERY_LIST)
    Result<List<AssetDataPermissionsOrg>> queryList(@RequestParam(name = "sample") AssetDataPermissionsOrgVO sample);

    /**
     * 分页查询组织
     */
    @RequestMapping(AssetDataPermissionsOrgServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDataPermissionsOrg>> queryPagedList(@RequestParam(name = "sample") AssetDataPermissionsOrgVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDataPermissionsOrgController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDataPermissionsOrgServiceProxy api() {
        return APIProxy.get(AssetDataPermissionsOrgServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
