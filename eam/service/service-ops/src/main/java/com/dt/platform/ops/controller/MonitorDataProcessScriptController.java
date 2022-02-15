package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.domain.ops.meta.MonitorNodeVOMeta;
import com.dt.platform.ops.service.IMonitorDataProcessScriptService;
import com.dt.platform.proxy.ops.MonitorDataProcessScriptServiceProxy;
import com.dt.platform.proxy.ops.MonitorNodeServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "脚本监控")
@ApiSort(0)
@RestController("MonitorDataProcessScriptController")
public class MonitorDataProcessScriptController extends SuperController {

    @Autowired
    IMonitorDataProcessScriptService monitorDataProcessScriptService;

    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "收集数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorDataProcessScriptServiceProxy.COLLECT_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessScriptServiceProxy.COLLECT_DATA)
    public Result collectData() {
        return monitorDataProcessScriptService.collectData();
    }


    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "收集数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorDataProcessScriptServiceProxy.CLEAR_NODE_VALUE_LAST_HISTORY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessScriptServiceProxy.CLEAR_NODE_VALUE_LAST_HISTORY_DATA)
    public Result clearNodeValueLastHistoryData() {
        return monitorDataProcessScriptService.clearNodeValueLastHistoryData();
    }


}
