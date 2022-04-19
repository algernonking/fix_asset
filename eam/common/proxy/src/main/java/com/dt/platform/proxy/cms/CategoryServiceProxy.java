package com.dt.platform.proxy.cms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.cms.Category;
import com.dt.platform.domain.cms.CategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-10 11:54:36
 */
@FeignClient(value = ServiceNames.CMS, contextId = CategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CategoryServiceProxy {

    /**
     * 基础路径 , service-cms
     */
    public static final String API_BASIC_PATH = "service-cms";

    /**
     * API 上下文路径 , cms-category
     */
    public static final String API_CONTEXT_PATH = "cms-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出类型数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载类型导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入类型数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加类型
     */
    @RequestMapping(CategoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "categoryVO") CategoryVO categoryVO);

    /**
     * 删除类型
     */
    @RequestMapping(CategoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除类型
     */
    @RequestMapping(CategoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新类型
     */
    @RequestMapping(CategoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "categoryVO") CategoryVO categoryVO);

    /**
     * 更新类型
     */
    @RequestMapping(CategoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "categoryVO") CategoryVO categoryVO);

    /**
     * 获取类型
     */
    @RequestMapping(CategoryServiceProxy.GET_BY_ID)
    Result<Category> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个类型
     */
    @RequestMapping(CategoryServiceProxy.GET_BY_IDS)
    Result<List<Category>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询类型
     */
    @RequestMapping(CategoryServiceProxy.QUERY_LIST)
    Result<List<Category>> queryList(@RequestParam(name = "sample") CategoryVO sample);

    /**
     * 分页查询类型
     */
    @RequestMapping(CategoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Category>> queryPagedList(@RequestParam(name = "sample") CategoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.cms.controller.CategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CategoryServiceProxy api() {
        return APIProxy.get(CategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
