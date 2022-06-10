package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.MaintainPlan;
import com.dt.platform.domain.eam.MaintainPlanVO;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 保养方案  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-05 09:51:44
 */
@FeignClient(value = ServiceNames.EAM, contextId = MaintainReportServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaintainReportServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-maintain-plan
     */
    public static final String API_CONTEXT_PATH = "eam-maintain-report";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";


    public static final String MAINTAIN_ITEM_REPORT = API_PREFIX + "maintain-item-report";
    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MaintainReportController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaintainReportServiceProxy api() {
        return APIProxy.get(MaintainReportServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
