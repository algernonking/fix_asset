package com.dt.platform.common.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ICodeModuleService;
import com.dt.platform.common.service.ICodeRuleService;
import com.dt.platform.domain.common.CodeRuleVO;
import com.dt.platform.domain.common.meta.CodeRuleVOMeta;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.common.CodeRuleServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "编码生成")
@ApiSort(0)
@RestController("SysCodeModuleController")
public class CodeModuleController {


    @Autowired
    private ICodeModuleService codeModuleService;

    /*
    	 * 获取编码
	*/
    @ApiOperation(value = "获取编码")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="module" , value = "业务编号" , required = true , dataTypeClass=String.class , example = "eam_asset_code"),
    })
    @ApiOperationSupport(order=1)
    @NotNull(name = "module")
    @SentinelResource(value = CodeRuleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping( CodeModuleServiceProxy.GENERATE_CODE)
    public Result generateCode(String module) {
        Result result=codeModuleService.generateCode(module);
        return result;
    }



}
