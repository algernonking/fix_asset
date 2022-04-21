package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetStockGoods;
import com.dt.platform.domain.eam.AssetStockGoodsVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 库存物品单  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 17:52:46
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetStockGoodsServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetStockGoodsServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-stock-goods
     */
    public static final String API_CONTEXT_PATH = "eam-asset-stock-goods";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加库存物品单
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除库存物品单
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除库存物品单
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新库存物品单
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存库存物品单
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个库存物品单
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个库存物品单
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询库存物品单
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询库存物品单
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出库存物品单数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载库存物品单导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入库存物品单数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetStockGoodsVO") AssetStockGoodsVO assetStockGoodsVO);

    /**
     * 删除库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetStockGoodsVO") AssetStockGoodsVO assetStockGoodsVO);

    /**
     * 更新库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetStockGoodsVO") AssetStockGoodsVO assetStockGoodsVO);

    /**
     * 获取库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.GET_BY_ID)
    Result<AssetStockGoods> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.GET_BY_IDS)
    Result<List<AssetStockGoods>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.QUERY_LIST)
    Result<List<AssetStockGoods>> queryList(@RequestParam(name = "sample") AssetStockGoodsVO sample);

    /**
     * 分页查询库存物品单
     */
    @RequestMapping(AssetStockGoodsServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetStockGoods>> queryPagedList(@RequestParam(name = "sample") AssetStockGoodsVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetStockGoodsController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetStockGoodsServiceProxy api() {
        return APIProxy.get(AssetStockGoodsServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
