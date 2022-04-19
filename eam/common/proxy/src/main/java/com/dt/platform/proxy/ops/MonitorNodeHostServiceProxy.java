package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorNodeHost;
import com.dt.platform.domain.ops.MonitorNodeHostVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 节点主机  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:45
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorNodeHostServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorNodeHostServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-node-host
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-node-host";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点主机
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点主机
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点主机
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点主机
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点主机
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点主机
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点主机
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点主机
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点主机
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出节点主机数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载节点主机导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入节点主机数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorNodeHostVO") MonitorNodeHostVO monitorNodeHostVO);

    /**
     * 删除节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorNodeHostVO") MonitorNodeHostVO monitorNodeHostVO);

    /**
     * 更新节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorNodeHostVO") MonitorNodeHostVO monitorNodeHostVO);

    /**
     * 获取节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.GET_BY_ID)
    Result<MonitorNodeHost> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.GET_BY_IDS)
    Result<List<MonitorNodeHost>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.QUERY_LIST)
    Result<List<MonitorNodeHost>> queryList(@RequestParam(name = "sample") MonitorNodeHostVO sample);

    /**
     * 分页查询节点主机
     */
    @RequestMapping(MonitorNodeHostServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorNodeHost>> queryPagedList(@RequestParam(name = "sample") MonitorNodeHostVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorNodeHostController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorNodeHostServiceProxy api() {
        return APIProxy.get(MonitorNodeHostServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
