package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorTplIndicatorType;
import com.dt.platform.domain.ops.MonitorTplIndicatorTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 指标类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-07 12:58:14
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorTplIndicatorTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorTplIndicatorTypeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-tpl-indicator-type
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-tpl-indicator-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加指标类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除指标类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除指标类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新指标类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存指标类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个指标类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个指标类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询指标类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询指标类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出指标类型数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载指标类型导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入指标类型数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorTplIndicatorTypeVO") MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO);

    /**
     * 删除指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorTplIndicatorTypeVO") MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO);

    /**
     * 更新指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorTplIndicatorTypeVO") MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO);

    /**
     * 获取指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.GET_BY_ID)
    Result<MonitorTplIndicatorType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.GET_BY_IDS)
    Result<List<MonitorTplIndicatorType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.QUERY_LIST)
    Result<List<MonitorTplIndicatorType>> queryList(@RequestParam(name = "sample") MonitorTplIndicatorTypeVO sample);

    /**
     * 分页查询指标类型
     */
    @RequestMapping(MonitorTplIndicatorTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorTplIndicatorType>> queryPagedList(@RequestParam(name = "sample") MonitorTplIndicatorTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorTplIndicatorTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorTplIndicatorTypeServiceProxy api() {
        return APIProxy.get(MonitorTplIndicatorTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
