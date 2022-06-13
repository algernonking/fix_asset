package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InventoryPlan;
import com.dt.platform.domain.eam.InventoryPlanVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 盘点计划  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-03 10:30:37
 */
@FeignClient(value = ServiceNames.EAM, contextId = InventoryPlanServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InventoryPlanServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inventory-plan
     */
    public static final String API_CONTEXT_PATH = "eam-inventory-plan";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加盘点计划
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除盘点计划
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除盘点计划
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新盘点计划
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存盘点计划
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个盘点计划
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个盘点计划
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询盘点计划
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询盘点计划
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出盘点计划数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载盘点计划导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入盘点计划数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 应用模板
     */
    public static final String APPLY_TPL = API_PREFIX + "apply-tpl";


    /**
     * 添加盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inventoryPlanVO") InventoryPlanVO inventoryPlanVO);

    /**
     * 删除盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inventoryPlanVO") InventoryPlanVO inventoryPlanVO);

    /**
     * 更新盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.SAVE)
    Result save(@RequestParam(name = "inventoryPlanVO") InventoryPlanVO inventoryPlanVO);

    /**
     * 获取盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.GET_BY_ID)
    Result<InventoryPlan> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.GET_BY_IDS)
    Result<List<InventoryPlan>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.QUERY_LIST)
    Result<List<InventoryPlan>> queryList(@RequestParam(name = "sample") InventoryPlanVO sample);

    /**
     * 分页查询盘点计划
     */
    @RequestMapping(InventoryPlanServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InventoryPlan>> queryPagedList(@RequestParam(name = "sample") InventoryPlanVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InventoryPlanController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InventoryPlanServiceProxy api() {
        return APIProxy.get(InventoryPlanServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
