package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 主机  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 11:16:53
 */
@FeignClient(value = ServiceNames.OPS, contextId = HostServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface HostServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-host
     */
    public static final String API_CONTEXT_PATH = "ops-host";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加主机
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除主机
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除主机
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新主机
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存主机
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个主机
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个主机
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询主机
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询主机
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出主机数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载主机导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入主机数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加主机
     */
    @RequestMapping(HostServiceProxy.INSERT)
    Result insert(@RequestParam(name = "hostVO") HostVO hostVO);

    /**
     * 删除主机
     */
    @RequestMapping(HostServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除主机
     */
    @RequestMapping(HostServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新主机
     */
    @RequestMapping(HostServiceProxy.UPDATE)
    Result update(@RequestParam(name = "hostVO") HostVO hostVO);

    /**
     * 更新主机
     */
    @RequestMapping(HostServiceProxy.SAVE)
    Result save(@RequestParam(name = "hostVO") HostVO hostVO);

    /**
     * 获取主机
     */
    @RequestMapping(HostServiceProxy.GET_BY_ID)
    Result<Host> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除主机
     */
    @RequestMapping(HostServiceProxy.GET_BY_IDS)
    Result<List<Host>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询主机
     */
    @RequestMapping(HostServiceProxy.QUERY_LIST)
    Result<List<Host>> queryList(@RequestParam(name = "sample") HostVO sample);

    /**
     * 分页查询主机
     */
    @RequestMapping(HostServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Host>> queryPagedList(@RequestParam(name = "sample") HostVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.HostController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static HostServiceProxy api() {
        return APIProxy.get(HostServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
