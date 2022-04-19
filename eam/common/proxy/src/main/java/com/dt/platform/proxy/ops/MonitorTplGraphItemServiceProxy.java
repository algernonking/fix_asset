package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import com.dt.platform.domain.ops.MonitorTplGraphItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 图形指标  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-13 20:47:04
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorTplGraphItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorTplGraphItemServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-tpl-graph-item
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-tpl-graph-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加图形指标
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除图形指标
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除图形指标
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新图形指标
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存图形指标
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个图形指标
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个图形指标
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询图形指标
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询图形指标
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出图形指标数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载图形指标导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入图形指标数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorTplGraphItemVO") MonitorTplGraphItemVO monitorTplGraphItemVO);

    /**
     * 删除图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorTplGraphItemVO") MonitorTplGraphItemVO monitorTplGraphItemVO);

    /**
     * 更新图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorTplGraphItemVO") MonitorTplGraphItemVO monitorTplGraphItemVO);

    /**
     * 获取图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.GET_BY_ID)
    Result<MonitorTplGraphItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.GET_BY_IDS)
    Result<List<MonitorTplGraphItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.QUERY_LIST)
    Result<List<MonitorTplGraphItem>> queryList(@RequestParam(name = "sample") MonitorTplGraphItemVO sample);

    /**
     * 分页查询图形指标
     */
    @RequestMapping(MonitorTplGraphItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorTplGraphItem>> queryPagedList(@RequestParam(name = "sample") MonitorTplGraphItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorTplGraphItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorTplGraphItemServiceProxy api() {
        return APIProxy.get(MonitorTplGraphItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
