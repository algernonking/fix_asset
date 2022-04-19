package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorNodeSubtype;
import com.dt.platform.domain.ops.MonitorNodeSubtypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 节点子类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:48
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorNodeSubtypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorNodeSubtypeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-node-subtype
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-node-subtype";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点子类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点子类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点子类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点子类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点子类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点子类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点子类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点子类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点子类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出节点子类型数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载节点子类型导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入节点子类型数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorNodeSubtypeVO") MonitorNodeSubtypeVO monitorNodeSubtypeVO);

    /**
     * 删除节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorNodeSubtypeVO") MonitorNodeSubtypeVO monitorNodeSubtypeVO);

    /**
     * 更新节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorNodeSubtypeVO") MonitorNodeSubtypeVO monitorNodeSubtypeVO);

    /**
     * 获取节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.GET_BY_ID)
    Result<MonitorNodeSubtype> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.GET_BY_IDS)
    Result<List<MonitorNodeSubtype>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.QUERY_LIST)
    Result<List<MonitorNodeSubtype>> queryList(@RequestParam(name = "sample") MonitorNodeSubtypeVO sample);

    /**
     * 分页查询节点子类型
     */
    @RequestMapping(MonitorNodeSubtypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorNodeSubtype>> queryPagedList(@RequestParam(name = "sample") MonitorNodeSubtypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorNodeSubtypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorNodeSubtypeServiceProxy api() {
        return APIProxy.get(MonitorNodeSubtypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
