package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairRule;
import com.dt.platform.domain.eam.RepairRuleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 分单规则  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 09:22:52
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairRuleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairRuleServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-rule
     */
    public static final String API_CONTEXT_PATH = "eam-repair-rule";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加分单规则
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除分单规则
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除分单规则
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新分单规则
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存分单规则
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个分单规则
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个分单规则
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询分单规则
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询分单规则
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出分单规则数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载分单规则导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入分单规则数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairRuleVO") RepairRuleVO repairRuleVO);

    /**
     * 删除分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairRuleVO") RepairRuleVO repairRuleVO);

    /**
     * 更新分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairRuleVO") RepairRuleVO repairRuleVO);

    /**
     * 获取分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.GET_BY_ID)
    Result<RepairRule> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.GET_BY_IDS)
    Result<List<RepairRule>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.QUERY_LIST)
    Result<List<RepairRule>> queryList(@RequestParam(name = "sample") RepairRuleVO sample);

    /**
     * 分页查询分单规则
     */
    @RequestMapping(RepairRuleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairRule>> queryPagedList(@RequestParam(name = "sample") RepairRuleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairRuleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairRuleServiceProxy api() {
        return APIProxy.get(RepairRuleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
