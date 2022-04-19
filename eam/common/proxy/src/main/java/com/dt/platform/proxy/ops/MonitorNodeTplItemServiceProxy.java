package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.MonitorNodeTplItem;
import com.dt.platform.domain.ops.MonitorNodeTplItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 节点监控模版  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:55
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorNodeTplItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorNodeTplItemServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-monitor-node-tpl-item
     */
    public static final String API_CONTEXT_PATH = "ops-monitor-node-tpl-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加节点监控模版
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除节点监控模版
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除节点监控模版
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新节点监控模版
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存节点监控模版
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个节点监控模版
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个节点监控模版
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询节点监控模版
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询节点监控模版
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出节点监控模版数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载节点监控模版导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入节点监控模版数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "monitorNodeTplItemVO") MonitorNodeTplItemVO monitorNodeTplItemVO);

    /**
     * 删除节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "monitorNodeTplItemVO") MonitorNodeTplItemVO monitorNodeTplItemVO);

    /**
     * 更新节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "monitorNodeTplItemVO") MonitorNodeTplItemVO monitorNodeTplItemVO);

    /**
     * 获取节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.GET_BY_ID)
    Result<MonitorNodeTplItem> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.GET_BY_IDS)
    Result<List<MonitorNodeTplItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.QUERY_LIST)
    Result<List<MonitorNodeTplItem>> queryList(@RequestParam(name = "sample") MonitorNodeTplItemVO sample);

    /**
     * 分页查询节点监控模版
     */
    @RequestMapping(MonitorNodeTplItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MonitorNodeTplItem>> queryPagedList(@RequestParam(name = "sample") MonitorNodeTplItemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorNodeTplItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorNodeTplItemServiceProxy api() {
        return APIProxy.get(MonitorNodeTplItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
