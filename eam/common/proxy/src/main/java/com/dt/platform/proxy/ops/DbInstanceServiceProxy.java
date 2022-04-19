package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.DbInstance;
import com.dt.platform.domain.ops.DbInstanceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 数据库实例  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:23
 */
@FeignClient(value = ServiceNames.OPS, contextId = DbInstanceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface DbInstanceServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-db-instance
     */
    public static final String API_CONTEXT_PATH = "ops-db-instance";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据库实例
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据库实例
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据库实例
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据库实例
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据库实例
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据库实例
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据库实例
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据库实例
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据库实例
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出数据库实例数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载数据库实例导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入数据库实例数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "dbInstanceVO") DbInstanceVO dbInstanceVO);

    /**
     * 删除数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "dbInstanceVO") DbInstanceVO dbInstanceVO);

    /**
     * 更新数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.SAVE)
    Result save(@RequestParam(name = "dbInstanceVO") DbInstanceVO dbInstanceVO);

    /**
     * 获取数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.GET_BY_ID)
    Result<DbInstance> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.GET_BY_IDS)
    Result<List<DbInstance>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.QUERY_LIST)
    Result<List<DbInstance>> queryList(@RequestParam(name = "sample") DbInstanceVO sample);

    /**
     * 分页查询数据库实例
     */
    @RequestMapping(DbInstanceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<DbInstance>> queryPagedList(@RequestParam(name = "sample") DbInstanceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.DbInstanceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static DbInstanceServiceProxy api() {
        return APIProxy.get(DbInstanceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
