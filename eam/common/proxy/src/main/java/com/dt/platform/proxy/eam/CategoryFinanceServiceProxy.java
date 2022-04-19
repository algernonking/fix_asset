package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CategoryFinance;
import com.dt.platform.domain.eam.CategoryFinanceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 财务分类  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 13:01:35
 */
@FeignClient(value = ServiceNames.EAM, contextId = CategoryFinanceServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CategoryFinanceServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-category-finance
     */
    public static final String API_CONTEXT_PATH = "eam-category-finance";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加财务分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除财务分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除财务分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新财务分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存财务分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个财务分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个财务分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询财务分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询财务分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出财务分类数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载财务分类导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入财务分类数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.INSERT)
    Result insert(@RequestParam(name = "categoryFinanceVO") CategoryFinanceVO categoryFinanceVO);

    /**
     * 删除财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.UPDATE)
    Result update(@RequestParam(name = "categoryFinanceVO") CategoryFinanceVO categoryFinanceVO);

    /**
     * 更新财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.SAVE)
    Result save(@RequestParam(name = "categoryFinanceVO") CategoryFinanceVO categoryFinanceVO);

    /**
     * 获取财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.GET_BY_ID)
    Result<CategoryFinance> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.GET_BY_IDS)
    Result<List<CategoryFinance>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.QUERY_LIST)
    Result<List<CategoryFinance>> queryList(@RequestParam(name = "sample") CategoryFinanceVO sample);

    /**
     * 分页查询财务分类
     */
    @RequestMapping(CategoryFinanceServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CategoryFinance>> queryPagedList(@RequestParam(name = "sample") CategoryFinanceVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CategoryFinanceController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CategoryFinanceServiceProxy api() {
        return APIProxy.get(CategoryFinanceServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
