package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairOrderAct;
import com.dt.platform.domain.eam.RepairOrderActVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维修工单  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 21:56:15
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairOrderActServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairOrderActServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-order-act
     */
    public static final String API_CONTEXT_PATH = "eam-repair-order-act";

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
     *
     */
    public static final String START = API_PREFIX + "start";

    public static final String FINISH = API_PREFIX + "finish";

    public static final String CANCEL = API_PREFIX + "cancel";
    /**
     * 添加维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairOrderActVO") RepairOrderActVO repairOrderActVO);

    /**
     * 删除维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairOrderActVO") RepairOrderActVO repairOrderActVO);

    /**
     * 更新维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairOrderActVO") RepairOrderActVO repairOrderActVO);

    /**
     * 获取维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.GET_BY_ID)
    Result<RepairOrderAct> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.GET_BY_IDS)
    Result<List<RepairOrderAct>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.QUERY_LIST)
    Result<List<RepairOrderAct>> queryList(@RequestParam(name = "sample") RepairOrderActVO sample);

    /**
     * 分页查询维修工单
     */
    @RequestMapping(RepairOrderActServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairOrderAct>> queryPagedList(@RequestParam(name = "sample") RepairOrderActVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairOrderActController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairOrderActServiceProxy api() {
        return APIProxy.get(RepairOrderActServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
