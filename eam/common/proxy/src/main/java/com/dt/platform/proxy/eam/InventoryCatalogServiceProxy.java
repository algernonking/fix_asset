package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InventoryCatalog;
import com.dt.platform.domain.eam.InventoryCatalogVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 盘点分类  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-04 10:56:47
 */
@FeignClient(value = ServiceNames.EAM, contextId = InventoryCatalogServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InventoryCatalogServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inventory-catalog
     */
    public static final String API_CONTEXT_PATH = "eam-inventory-catalog";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加盘点分类
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除盘点分类
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除盘点分类
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新盘点分类
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存盘点分类
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个盘点分类
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个盘点分类
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询盘点分类
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询盘点分类
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出盘点分类数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载盘点分类导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入盘点分类数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inventoryCatalogVO") InventoryCatalogVO inventoryCatalogVO);

    /**
     * 删除盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inventoryCatalogVO") InventoryCatalogVO inventoryCatalogVO);

    /**
     * 更新盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.SAVE)
    Result save(@RequestParam(name = "inventoryCatalogVO") InventoryCatalogVO inventoryCatalogVO);

    /**
     * 获取盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.GET_BY_ID)
    Result<InventoryCatalog> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.GET_BY_IDS)
    Result<List<InventoryCatalog>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.QUERY_LIST)
    Result<List<InventoryCatalog>> queryList(@RequestParam(name = "sample") InventoryCatalogVO sample);

    /**
     * 分页查询盘点分类
     */
    @RequestMapping(InventoryCatalogServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InventoryCatalog>> queryPagedList(@RequestParam(name = "sample") InventoryCatalogVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InventoryCatalogController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InventoryCatalogServiceProxy api() {
        return APIProxy.get(InventoryCatalogServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
