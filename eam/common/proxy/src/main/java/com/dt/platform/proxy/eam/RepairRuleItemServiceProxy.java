package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairRuleItem;
import com.dt.platform.domain.eam.RepairRuleItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 规则单  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 07:24:12
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairRuleItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairRuleItemServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-rule-item
     */
    public static final String API_CONTEXT_PATH = "eam-repair-rule-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加规则单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除规则单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除规则单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新规则单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存规则单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个规则单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个规则单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询规则单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询规则单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出规则单数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载规则单导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入规则单数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairRuleItemVO") RepairRuleItemVO repairRuleItemVO);

    /**
     * 删除规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairRuleItemVO") RepairRuleItemVO repairRuleItemVO);

    /**
     * 更新规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairRuleItemVO") RepairRuleItemVO repairRuleItemVO);

    /**
     * 获取规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.GET_BY_ID)
    Result<RepairRuleItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.GET_BY_IDS)
    Result<List<RepairRuleItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.QUERY_LIST)
    Result<List<RepairRuleItem>> queryList(@RequestParam(name = "sample") RepairRuleItemVO sample);

    /**
     * 分页查询规则单
     */
    @RequestMapping(RepairRuleItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairRuleItem>> queryPagedList(@RequestParam(name = "sample") RepairRuleItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairRuleItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairRuleItemServiceProxy api() {
        return APIProxy.get(RepairRuleItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
