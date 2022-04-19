package com.dt.platform.proxy.common;

import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = ServiceNames.COMMON, contextId = CodeRuleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodeModuleServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-code-attr
     */
    public static final String API_CONTEXT_PATH = "sys-code-module";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加编码属性
     */
    public static final String GENERATE_CODE = API_PREFIX + "generate-code";

    /**
     * 获取业务编码
     *
     * @param module 传入业务编码模块
     * @return 返回编号
     */
    @RequestMapping(CodeModuleServiceProxy.GENERATE_CODE)
    Result generateCode(@RequestParam(name = "module") String module);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.CodeModuleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodeModuleServiceProxy api() {
        return APIProxy.get(CodeModuleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
