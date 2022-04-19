package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.InventoryAssetVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 盘点明细  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-05 12:58:04
 */
@FeignClient(value = ServiceNames.EAM, contextId = InventoryAssetServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InventoryAssetServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inventory-asset
     */
    public static final String API_CONTEXT_PATH = "eam-inventory-asset";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加盘点明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除盘点明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除盘点明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新盘点明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存盘点明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个盘点明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个盘点明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询盘点明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询盘点明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出盘点明细数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载盘点明细导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入盘点明细数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inventoryAssetVO") InventoryAssetVO inventoryAssetVO);

    /**
     * 删除盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inventoryAssetVO") InventoryAssetVO inventoryAssetVO);

    /**
     * 更新盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.SAVE)
    Result save(@RequestParam(name = "inventoryAssetVO") InventoryAssetVO inventoryAssetVO);

    /**
     * 获取盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.GET_BY_ID)
    Result<InventoryAsset> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.GET_BY_IDS)
    Result<List<InventoryAsset>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.QUERY_LIST)
    Result<List<InventoryAsset>> queryList(@RequestParam(name = "sample") InventoryAssetVO sample);

    /**
     * 分页查询盘点明细
     */
    @RequestMapping(InventoryAssetServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InventoryAsset>> queryPagedList(@RequestParam(name = "sample") InventoryAssetVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InventoryAssetController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InventoryAssetServiceProxy api() {
        return APIProxy.get(InventoryAssetServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
