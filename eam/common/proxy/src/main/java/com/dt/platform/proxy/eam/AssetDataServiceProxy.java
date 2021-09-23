package com.dt.platform.proxy.eam;



import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 资产数据提供服务
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:04:25
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDataServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)

public interface AssetDataServiceProxy {
    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-ext-attribution
     */
    public static final String API_CONTEXT_PATH = "eam-asset-data";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";


    /**
     * 添加品牌
     */
    public static final String EXPORT_ASSET = API_PREFIX + "export-asset";


    /**
     * 添加品牌
     */
    public static final String EXPORT_ASSET_BY_IDS = API_PREFIX + "export-asset-by-ids";

    /**
     * 导出资产
     */
    @RequestMapping(AssetDataServiceProxy.EXPORT_ASSET)
    Result exportAsset(AssetVO asset);


    /**
     * 导出资产
     */
    @RequestMapping(AssetDataServiceProxy.EXPORT_ASSET_BY_IDS)
    Result exportAssetByIds(List<String> ids);



    /**
     * 控制器类名
     * */
    public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetDataController";



    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     * */
    public static AssetDataServiceProxy api() {
        return APIProxy.get(AssetDataServiceProxy.class,CONTROLLER_CLASS_NAME);
    }

}
