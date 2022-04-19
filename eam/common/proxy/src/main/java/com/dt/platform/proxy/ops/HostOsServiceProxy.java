package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.HostOs;
import com.dt.platform.domain.ops.HostOsVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 操作系统  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:26
 */
@FeignClient(value = ServiceNames.OPS, contextId = HostOsServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface HostOsServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-host-os
     */
    public static final String API_CONTEXT_PATH = "ops-host-os";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加操作系统
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除操作系统
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除操作系统
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新操作系统
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存操作系统
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个操作系统
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个操作系统
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询操作系统
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询操作系统
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出操作系统数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载操作系统导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入操作系统数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加操作系统
     */
    @RequestMapping(HostOsServiceProxy.INSERT)
    Result insert(@RequestParam(name = "hostOsVO") HostOsVO hostOsVO);

    /**
     * 删除操作系统
     */
    @RequestMapping(HostOsServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除操作系统
     */
    @RequestMapping(HostOsServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新操作系统
     */
    @RequestMapping(HostOsServiceProxy.UPDATE)
    Result update(@RequestParam(name = "hostOsVO") HostOsVO hostOsVO);

    /**
     * 更新操作系统
     */
    @RequestMapping(HostOsServiceProxy.SAVE)
    Result save(@RequestParam(name = "hostOsVO") HostOsVO hostOsVO);

    /**
     * 获取操作系统
     */
    @RequestMapping(HostOsServiceProxy.GET_BY_ID)
    Result<HostOs> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除操作系统
     */
    @RequestMapping(HostOsServiceProxy.GET_BY_IDS)
    Result<List<HostOs>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询操作系统
     */
    @RequestMapping(HostOsServiceProxy.QUERY_LIST)
    Result<List<HostOs>> queryList(@RequestParam(name = "sample") HostOsVO sample);

    /**
     * 分页查询操作系统
     */
    @RequestMapping(HostOsServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<HostOs>> queryPagedList(@RequestParam(name = "sample") HostOsVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.HostOsController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static HostOsServiceProxy api() {
        return APIProxy.get(HostOsServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
