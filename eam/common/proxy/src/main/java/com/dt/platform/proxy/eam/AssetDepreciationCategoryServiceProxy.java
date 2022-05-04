package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDepreciationCategory;
import com.dt.platform.domain.eam.AssetDepreciationCategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 折旧分类  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 14:33:28
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDepreciationCategoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDepreciationCategoryServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-depreciation-category
     */
    public static final String API_CONTEXT_PATH = "eam-asset-depreciation-category";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加折旧分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除折旧分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除折旧分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新折旧分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存折旧分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个折旧分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个折旧分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询折旧分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询折旧分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出折旧分类数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载折旧分类导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入折旧分类数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDepreciationCategoryVO") AssetDepreciationCategoryVO assetDepreciationCategoryVO);

    /**
     * 删除折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDepreciationCategoryVO") AssetDepreciationCategoryVO assetDepreciationCategoryVO);

    /**
     * 更新折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDepreciationCategoryVO") AssetDepreciationCategoryVO assetDepreciationCategoryVO);

    /**
     * 获取折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.GET_BY_ID)
    Result<AssetDepreciationCategory> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.GET_BY_IDS)
    Result<List<AssetDepreciationCategory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.QUERY_LIST)
    Result<List<AssetDepreciationCategory>> queryList(@RequestParam(name = "sample") AssetDepreciationCategoryVO sample);

    /**
     * 分页查询折旧分类
     */
    @RequestMapping(AssetDepreciationCategoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDepreciationCategory>> queryPagedList(@RequestParam(name = "sample") AssetDepreciationCategoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDepreciationCategoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDepreciationCategoryServiceProxy api() {
        return APIProxy.get(AssetDepreciationCategoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
