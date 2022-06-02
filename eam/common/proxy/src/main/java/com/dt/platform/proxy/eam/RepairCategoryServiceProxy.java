package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairCategory;
import com.dt.platform.domain.eam.RepairCategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 故障分类  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 14:35:56
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairCategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairCategoryServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-category
     */
    public static final String API_CONTEXT_PATH = "eam-repair-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加故障分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除故障分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除故障分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新故障分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存故障分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个故障分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个故障分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询故障分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询故障分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出故障分类数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载故障分类导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入故障分类数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairCategoryVO") RepairCategoryVO repairCategoryVO);

    /**
     * 删除故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairCategoryVO") RepairCategoryVO repairCategoryVO);

    /**
     * 更新故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairCategoryVO") RepairCategoryVO repairCategoryVO);

    /**
     * 获取故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.GET_BY_ID)
    Result<RepairCategory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.GET_BY_IDS)
    Result<List<RepairCategory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.QUERY_LIST)
    Result<List<RepairCategory>> queryList(@RequestParam(name = "sample") RepairCategoryVO sample);

    /**
     * 分页查询故障分类
     */
    @RequestMapping(RepairCategoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairCategory>> queryPagedList(@RequestParam(name = "sample") RepairCategoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairCategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairCategoryServiceProxy api() {
        return APIProxy.get(RepairCategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
