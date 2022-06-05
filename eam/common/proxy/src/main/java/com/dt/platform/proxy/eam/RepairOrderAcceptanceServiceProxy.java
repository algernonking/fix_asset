package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairOrderAcceptance;
import com.dt.platform.domain.eam.RepairOrderAcceptanceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维修验收  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-01 07:17:16
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairOrderAcceptanceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairOrderAcceptanceServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-order-acceptance
     */
    public static final String API_CONTEXT_PATH = "eam-repair-order-acceptance";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维修验收
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维修验收
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维修验收
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维修验收
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维修验收
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维修验收
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维修验收
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维修验收
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维修验收
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出维修验收数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载维修验收导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入维修验收数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    public static final String ACCEPTANCE = API_PREFIX + "acceptance";


    /**
     * 添加维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairOrderAcceptanceVO") RepairOrderAcceptanceVO repairOrderAcceptanceVO);

    /**
     * 删除维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairOrderAcceptanceVO") RepairOrderAcceptanceVO repairOrderAcceptanceVO);

    /**
     * 更新维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairOrderAcceptanceVO") RepairOrderAcceptanceVO repairOrderAcceptanceVO);

    /**
     * 获取维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.GET_BY_ID)
    Result<RepairOrderAcceptance> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.GET_BY_IDS)
    Result<List<RepairOrderAcceptance>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.QUERY_LIST)
    Result<List<RepairOrderAcceptance>> queryList(@RequestParam(name = "sample") RepairOrderAcceptanceVO sample);

    /**
     * 分页查询维修验收
     */
    @RequestMapping(RepairOrderAcceptanceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairOrderAcceptance>> queryPagedList(@RequestParam(name = "sample") RepairOrderAcceptanceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairOrderAcceptanceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairOrderAcceptanceServiceProxy api() {
        return APIProxy.get(RepairOrderAcceptanceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
