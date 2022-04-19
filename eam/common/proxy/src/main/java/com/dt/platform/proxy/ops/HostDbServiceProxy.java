package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.HostDb;
import com.dt.platform.domain.ops.HostDbVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 数据库  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:28
 */
@FeignClient(value = ServiceNames.OPS, contextId = HostDbServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface HostDbServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-host-db
     */
    public static final String API_CONTEXT_PATH = "ops-host-db";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出数据库数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载数据库导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入数据库数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加数据库
     */
    @RequestMapping(HostDbServiceProxy.INSERT)
    Result insert(@RequestParam(name = "hostDbVO") HostDbVO hostDbVO);

    /**
     * 删除数据库
     */
    @RequestMapping(HostDbServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库
     */
    @RequestMapping(HostDbServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据库
     */
    @RequestMapping(HostDbServiceProxy.UPDATE)
    Result update(@RequestParam(name = "hostDbVO") HostDbVO hostDbVO);

    /**
     * 更新数据库
     */
    @RequestMapping(HostDbServiceProxy.SAVE)
    Result save(@RequestParam(name = "hostDbVO") HostDbVO hostDbVO);

    /**
     * 获取数据库
     */
    @RequestMapping(HostDbServiceProxy.GET_BY_ID)
    Result<HostDb> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库
     */
    @RequestMapping(HostDbServiceProxy.GET_BY_IDS)
    Result<List<HostDb>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据库
     */
    @RequestMapping(HostDbServiceProxy.QUERY_LIST)
    Result<List<HostDb>> queryList(@RequestParam(name = "sample") HostDbVO sample);

    /**
     * 分页查询数据库
     */
    @RequestMapping(HostDbServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<HostDb>> queryPagedList(@RequestParam(name = "sample") HostDbVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.HostDbController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static HostDbServiceProxy api() {
        return APIProxy.get(HostDbServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
