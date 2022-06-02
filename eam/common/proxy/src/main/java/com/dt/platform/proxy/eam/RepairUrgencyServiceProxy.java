package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairUrgency;
import com.dt.platform.domain.eam.RepairUrgencyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 紧急程度  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 07:51:13
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairUrgencyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairUrgencyServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-urgency
     */
    public static final String API_CONTEXT_PATH = "eam-repair-urgency";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加紧急程度
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除紧急程度
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除紧急程度
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新紧急程度
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存紧急程度
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个紧急程度
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个紧急程度
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询紧急程度
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询紧急程度
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出紧急程度数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载紧急程度导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入紧急程度数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairUrgencyVO") RepairUrgencyVO repairUrgencyVO);

    /**
     * 删除紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairUrgencyVO") RepairUrgencyVO repairUrgencyVO);

    /**
     * 更新紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairUrgencyVO") RepairUrgencyVO repairUrgencyVO);

    /**
     * 获取紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.GET_BY_ID)
    Result<RepairUrgency> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.GET_BY_IDS)
    Result<List<RepairUrgency>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.QUERY_LIST)
    Result<List<RepairUrgency>> queryList(@RequestParam(name = "sample") RepairUrgencyVO sample);

    /**
     * 分页查询紧急程度
     */
    @RequestMapping(RepairUrgencyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairUrgency>> queryPagedList(@RequestParam(name = "sample") RepairUrgencyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairUrgencyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairUrgencyServiceProxy api() {
        return APIProxy.get(RepairUrgencyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
