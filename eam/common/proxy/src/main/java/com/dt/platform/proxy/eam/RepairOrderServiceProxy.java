package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairOrder;
import com.dt.platform.domain.eam.RepairOrderVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维修工单  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 19:33:23
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairOrderServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairOrderServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-order
     */
    public static final String API_CONTEXT_PATH = "eam-repair-order";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维修工单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维修工单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维修工单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维修工单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维修工单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维修工单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维修工单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维修工单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维修工单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出维修工单数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载维修工单导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入维修工单数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";


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
     *
     */
    public static final String DISPATCH = API_PREFIX + "dispatch";


    /**
     *
     */
    public static final String VALIDATE_DISPATCH_ORDER = API_PREFIX + "validate-dispatch-order";


    /**
     * 添加维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairOrderVO") RepairOrderVO repairOrderVO);

    /**
     * 删除维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairOrderVO") RepairOrderVO repairOrderVO);

    /**
     * 更新维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairOrderVO") RepairOrderVO repairOrderVO);

    /**
     * 获取维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.GET_BY_ID)
    Result<RepairOrder> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.GET_BY_IDS)
    Result<List<RepairOrder>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.QUERY_LIST)
    Result<List<RepairOrder>> queryList(@RequestParam(name = "sample") RepairOrderVO sample);

    /**
     * 分页查询维修工单
     */
    @RequestMapping(RepairOrderServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairOrder>> queryPagedList(@RequestParam(name = "sample") RepairOrderVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairOrderController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairOrderServiceProxy api() {
        return APIProxy.get(RepairOrderServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
