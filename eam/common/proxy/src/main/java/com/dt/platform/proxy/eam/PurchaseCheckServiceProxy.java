package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.PurchaseCheck;
import com.dt.platform.domain.eam.PurchaseCheckVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 采购验收  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-16 23:19:16
 */
@FeignClient(value = ServiceNames.EAM, contextId = PurchaseCheckServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface PurchaseCheckServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-purchase-check
     */
    public static final String API_CONTEXT_PATH = "eam-purchase-check";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加采购验收
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除采购验收
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除采购验收
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新采购验收
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存采购验收
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个采购验收
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个采购验收
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询采购验收
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询采购验收
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出采购验收数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载采购验收导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入采购验收数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.INSERT)
    Result insert(@RequestParam(name = "purchaseCheckVO") PurchaseCheckVO purchaseCheckVO);

    /**
     * 删除采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.UPDATE)
    Result update(@RequestParam(name = "purchaseCheckVO") PurchaseCheckVO purchaseCheckVO);

    /**
     * 更新采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.SAVE)
    Result save(@RequestParam(name = "purchaseCheckVO") PurchaseCheckVO purchaseCheckVO);

    /**
     * 获取采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.GET_BY_ID)
    Result<PurchaseCheck> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.GET_BY_IDS)
    Result<List<PurchaseCheck>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.QUERY_LIST)
    Result<List<PurchaseCheck>> queryList(@RequestParam(name = "sample") PurchaseCheckVO sample);

    /**
     * 分页查询采购验收
     */
    @RequestMapping(PurchaseCheckServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<PurchaseCheck>> queryPagedList(@RequestParam(name = "sample") PurchaseCheckVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.PurchaseCheckController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static PurchaseCheckServiceProxy api() {
        return APIProxy.get(PurchaseCheckServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
