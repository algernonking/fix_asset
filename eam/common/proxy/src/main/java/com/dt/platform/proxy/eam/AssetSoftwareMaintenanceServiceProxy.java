package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetSoftwareMaintenance;
import com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 软件维保  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 16:44:03
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetSoftwareMaintenanceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetSoftwareMaintenanceServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-software-maintenance
     */
    public static final String API_CONTEXT_PATH = "eam-asset-software-maintenance";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加软件维保
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除软件维保
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除软件维保
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新软件维保
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存软件维保
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个软件维保
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个软件维保
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询软件维保
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询软件维保
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";


    /**
     * 审批
     */
    public static final String APPROVE = API_PREFIX + "approve";

    /**
     * 提交审批
     */
    public static final String FOR_APPROVAL = API_PREFIX + "for-approval";

    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";

    /**
     * 撤销操作
     */
    public static final String REVOKE_OPERATION = API_PREFIX + "revoke-operation";


    /**
     * 导出软件维保数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载软件维保导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入软件维保数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetSoftwareMaintenanceVO") AssetSoftwareMaintenanceVO assetSoftwareMaintenanceVO);

    /**
     * 删除软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetSoftwareMaintenanceVO") AssetSoftwareMaintenanceVO assetSoftwareMaintenanceVO);

    /**
     * 更新软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetSoftwareMaintenanceVO") AssetSoftwareMaintenanceVO assetSoftwareMaintenanceVO);

    /**
     * 获取软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.GET_BY_ID)
    Result<AssetSoftwareMaintenance> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.GET_BY_IDS)
    Result<List<AssetSoftwareMaintenance>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.QUERY_LIST)
    Result<List<AssetSoftwareMaintenance>> queryList(@RequestParam(name = "sample") AssetSoftwareMaintenanceVO sample);

    /**
     * 分页查询软件维保
     */
    @RequestMapping(AssetSoftwareMaintenanceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetSoftwareMaintenance>> queryPagedList(@RequestParam(name = "sample") AssetSoftwareMaintenanceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetSoftwareMaintenanceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetSoftwareMaintenanceServiceProxy api() {
        return APIProxy.get(AssetSoftwareMaintenanceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
