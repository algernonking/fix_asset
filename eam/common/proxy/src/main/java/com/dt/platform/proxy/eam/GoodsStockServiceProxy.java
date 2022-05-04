package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.GoodsStockVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 库存物品  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 11:41:53
 */
@FeignClient(value = ServiceNames.EAM, contextId = GoodsStockServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface GoodsStockServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-goods-stock
     */
    public static final String API_CONTEXT_PATH = "eam-goods-stock";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加库存物品
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除库存物品
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除库存物品
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新库存物品
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存库存物品
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 保存库存物品
     */
    public static final String SAVE_BY_IDS= API_PREFIX + "save-by-ids";


    /**
     * 获取单个库存物品
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个库存物品
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询库存物品
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询库存物品
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出库存物品数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载库存物品导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入库存物品数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";


    public static final String QUERY_PAGED_LIST_BY_SELECTED = API_PREFIX + "query-paged-list-by-selected";

    public static final String QUERY_PAGED_LIST_BY_SELECT = API_PREFIX + "query-paged-list-by-select";

    public static final String QUERY_GOODS_STOCK_REAL_ALL = API_PREFIX + "query-goods-stock-real-all";


    public static final String QUERY_MIN_STOCK_WARN = API_PREFIX + "query-min-stock-warn";

    public static final String QUERY_MAX_STOCK_WARN = API_PREFIX + "query-max-stock-warn";

    public static final String QUERY_SECURITY_STOCK_WARN = API_PREFIX + "query-security-stock-warn";
    /**
     * 添加库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.INSERT)
    Result insert(@RequestParam(name = "goodsStockVO") GoodsStockVO goodsStockVO);

    /**
     * 删除库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.UPDATE)
    Result update(@RequestParam(name = "goodsStockVO") GoodsStockVO goodsStockVO);

    /**
     * 更新库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.SAVE)
    Result save(@RequestParam(name = "goodsStockVO") GoodsStockVO goodsStockVO);

    /**
     * 获取库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.GET_BY_ID)
    Result<GoodsStock> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.GET_BY_IDS)
    Result<List<GoodsStock>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.QUERY_LIST)
    Result<List<GoodsStock>> queryList(@RequestParam(name = "sample") GoodsStockVO sample);

    /**
     * 分页查询库存物品
     */
    @RequestMapping(GoodsStockServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<GoodsStock>> queryPagedList(@RequestParam(name = "sample") GoodsStockVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.GoodsStockController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static GoodsStockServiceProxy api() {
        return APIProxy.get(GoodsStockServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
