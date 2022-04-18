package com.dt.platform.proxy.eam;

import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = ServiceNames.EAM, contextId = AssetBillServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface AssetBillServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /*
     * API 上下文路径 , eam-asset-borrow
     */
    public static final String API_CONTEXT_PATH = "eam-asset-bill";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

    /**
     * 查询资产单据
     */
    public static final String QUERY_ASSET_REGISTER_BILLS = API_PREFIX + "query-asset-register-bills";


    public static final String QUERY_ASSET_REGISTER_BILL = API_PREFIX + "query-asset-register-bill";



    /**
     * 查询资产单据
     */
    public static final String QUERY_BORROW_BILL = API_PREFIX + "query-borrow-bill";

    /**
     * 查询资产单据
     */
    public static final String QUERY_BORROW_BILLS = API_PREFIX + "query-borrow-bills";


    /**
     * 查询资产单据
     */
    public static final String QUERY_SCRAP_BILL = API_PREFIX + "query-scrap-bill";

    /**
     * 查询资产单据
     */
    public static final String QUERY_SCRAP_BILLS = API_PREFIX + "query-scrap-bills";

    /**
     * 查询资产单据
     */
    public static final String QUERY_REAPIR_BILL = API_PREFIX + "query-repair-bill";

    /**
     * 查询资产单据
     */
    public static final String QUERY_REAPIR_BILLS = API_PREFIX + "query-repair-bills";


    /**
     * 查询资产单据
     */
    public static final String QUERY_ALLOCATION_BILL = API_PREFIX + "query-allocation-bill";

    /**
     * 查询资产单据
     */
    public static final String QUERY_ALLOCATION_BILLS = API_PREFIX + "query-allocation-bills";


    /**
     * 查询资产单据
     */
    public static final String QUERY_COLLECTION_BILL = API_PREFIX + "query-collection-bill";

    /**
     * 查询资产单据
     */
    public static final String QUERY_COLLECTION_BILLS = API_PREFIX + "query-collection-bills";

    /**
     * 查询采购
     */
    public static final String QUERY_PURCHASE_APPLY_BILL = API_PREFIX + "query-purchase-apply-bill";


    /**
     * 查询资产单据
     */
    public static final String QUERY_COLLECTION_RETURN_BILL = API_PREFIX + "query-collection-return-bill";


    /**
     * 查询资产单据
     */
    public static final String QUERY_COLLECTION_RETURN_BILLS = API_PREFIX + "query-collection-return-bills";

    /**
     * 查询资产单据
     */
    public static final String QUERY_ASSET_CARD = API_PREFIX + "query-asset-card";

    /**
     * 查询资产单据
     */
    public static final String QUERY_ASSET_CARDS = API_PREFIX + "query-asset-cards";


    /**
     * 查询资产单据
     */
    public static final String QUERY_ASSET_LABEL = API_PREFIX + "query-asset-label";

    /**
     * 查询资产单据
     */
    public static final String QUERY_ASSET_LABELS = API_PREFIX + "query-asset-labels";


    /**
     * 查询转移单据
     */
    public static final String QUERY_ASSET_TRANSFER_BILL = API_PREFIX + "query-asset-transfer-bill";

    /**
     * 查询转移单据
     */
    public static final String QUERY_ASSET_TRANSFER_BILLS = API_PREFIX + "query-asset-transfer-bills";


    /**
     * 控制器类名
     * */
    public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetBillController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     * */
    public static AssetBillServiceProxy api() {
        return APIProxy.get(AssetBillServiceProxy.class,CONTROLLER_CLASS_NAME);
    }


}

