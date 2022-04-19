package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorNodeDb;
import com.dt.platform.domain.ops.MonitorNodeDbVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 节点数据库  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:41
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorNodeDbServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorNodeDbServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-node-db
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-node-db";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点数据库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点数据库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点数据库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点数据库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点数据库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点数据库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点数据库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点数据库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点数据库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出节点数据库数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载节点数据库导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入节点数据库数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorNodeDbVO") MonitorNodeDbVO monitorNodeDbVO);

    /**
     * 删除节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorNodeDbVO") MonitorNodeDbVO monitorNodeDbVO);

    /**
     * 更新节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorNodeDbVO") MonitorNodeDbVO monitorNodeDbVO);

    /**
     * 获取节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.GET_BY_ID)
    Result<MonitorNodeDb> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.GET_BY_IDS)
    Result<List<MonitorNodeDb>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.QUERY_LIST)
    Result<List<MonitorNodeDb>> queryList(@RequestParam(name = "sample") MonitorNodeDbVO sample);

    /**
     * 分页查询节点数据库
     */
    @RequestMapping(MonitorNodeDbServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorNodeDb>> queryPagedList(@RequestParam(name = "sample") MonitorNodeDbVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorNodeDbController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorNodeDbServiceProxy api() {
        return APIProxy.get(MonitorNodeDbServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
