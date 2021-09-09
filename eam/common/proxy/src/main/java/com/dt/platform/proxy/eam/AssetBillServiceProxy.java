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
    public static final String API_CONTEXT_PATH = "eam-asset-borrow";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";


    /**
     * 查询资产
     */
    public static final String QUERY_BORROW_BILLS = API_PREFIX + "query-borrow-bills";

    /**
     * 查询资产
     */
    @RequestMapping(AssetBillServiceProxy.QUERY_BORROW_BILLS)
    void QUERY_BORROW_BILLS();

    /**
     * 控制器类名
     * */
    public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetBillReport";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     * */
    public static AssetBillServiceProxy api() {
        return APIProxy.get(AssetBillServiceProxy.class,CONTROLLER_CLASS_NAME);
    }


}

