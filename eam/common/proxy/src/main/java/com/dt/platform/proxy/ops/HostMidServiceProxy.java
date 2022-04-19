package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.HostMid;
import com.dt.platform.domain.ops.HostMidVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 中间件  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-30 13:55:56
 */
@FeignClient(value = ServiceNames.OPS, contextId = HostMidServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface HostMidServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-host-mid
     */
    public static final String API_CONTEXT_PATH = "ops-host-mid";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加中间件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除中间件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除中间件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新中间件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存中间件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个中间件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个中间件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询中间件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询中间件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出中间件数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载中间件导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入中间件数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加中间件
     */
    @RequestMapping(HostMidServiceProxy.INSERT)
    Result insert(@RequestParam(name = "hostMidVO") HostMidVO hostMidVO);

    /**
     * 删除中间件
     */
    @RequestMapping(HostMidServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除中间件
     */
    @RequestMapping(HostMidServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新中间件
     */
    @RequestMapping(HostMidServiceProxy.UPDATE)
    Result update(@RequestParam(name = "hostMidVO") HostMidVO hostMidVO);

    /**
     * 更新中间件
     */
    @RequestMapping(HostMidServiceProxy.SAVE)
    Result save(@RequestParam(name = "hostMidVO") HostMidVO hostMidVO);

    /**
     * 获取中间件
     */
    @RequestMapping(HostMidServiceProxy.GET_BY_ID)
    Result<HostMid> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除中间件
     */
    @RequestMapping(HostMidServiceProxy.GET_BY_IDS)
    Result<List<HostMid>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询中间件
     */
    @RequestMapping(HostMidServiceProxy.QUERY_LIST)
    Result<List<HostMid>> queryList(@RequestParam(name = "sample") HostMidVO sample);

    /**
     * 分页查询中间件
     */
    @RequestMapping(HostMidServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<HostMid>> queryPagedList(@RequestParam(name = "sample") HostMidVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.HostMidController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static HostMidServiceProxy api() {
        return APIProxy.get(HostMidServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
