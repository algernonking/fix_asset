package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.MonitorNodeTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 节点类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:50
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorNodeTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorNodeTypeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-node-type
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-node-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出节点类型数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载节点类型导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入节点类型数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorNodeTypeVO") MonitorNodeTypeVO monitorNodeTypeVO);

    /**
     * 删除节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorNodeTypeVO") MonitorNodeTypeVO monitorNodeTypeVO);

    /**
     * 更新节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorNodeTypeVO") MonitorNodeTypeVO monitorNodeTypeVO);

    /**
     * 获取节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.GET_BY_ID)
    Result<MonitorNodeType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.GET_BY_IDS)
    Result<List<MonitorNodeType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.QUERY_LIST)
    Result<List<MonitorNodeType>> queryList(@RequestParam(name = "sample") MonitorNodeTypeVO sample);

    /**
     * 分页查询节点类型
     */
    @RequestMapping(MonitorNodeTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorNodeType>> queryPagedList(@RequestParam(name = "sample") MonitorNodeTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorNodeTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorNodeTypeServiceProxy api() {
        return APIProxy.get(MonitorNodeTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
