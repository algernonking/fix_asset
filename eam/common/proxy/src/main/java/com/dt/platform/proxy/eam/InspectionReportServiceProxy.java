package com.dt.platform.proxy.eam;

import com.dt.platform.proxy.ServiceNames;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 巡检计划  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 21:18:33
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionReportServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionReportServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-plan
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-report";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";


    public static final String INSPECTION_POINT_REPORT = API_PREFIX + "inspection-point-report";


    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionReportController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionReportServiceProxy api() {
        return APIProxy.get(InspectionReportServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
