package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorDataProcessBaseService;
import com.dt.platform.ops.service.IMonitorDataProcessZabbixAgentService;
import com.dt.platform.proxy.ops.MonitorDataProcessBaseServiceProxy;
import com.dt.platform.proxy.ops.MonitorDataProcessScriptServiceProxy;
import com.dt.platform.proxy.ops.MonitorDataProcessZabbixAgentServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "基础数据")
@ApiSort(0)
@RestController("MonitorDataProcessBaseController")
public class MonitorDataProcessBaseController extends SuperController {

    @Autowired
    IMonitorDataProcessBaseService monitorDataProcessBaseService;


    /**
     */
    @ApiOperation(value = "查询zabbixAgent信息")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorDataProcessBaseServiceProxy.QUERY_NODE_ZABBIX_AGENT_DATA, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessBaseServiceProxy.QUERY_NODE_ZABBIX_AGENT_DATA)
    public Result queryNodeZabbixAgentData() {
        return monitorDataProcessBaseService.queryNodeZabbixAgentData();
    }

    /**
     */
    @ApiOperation(value = "查询节点的模版数据")
    @ApiOperationSupport(order=2)
    @SentinelResource(value = MonitorDataProcessBaseServiceProxy.QUERY_TPL_LIST_BY_NODE_ID, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorDataProcessBaseServiceProxy.QUERY_TPL_LIST_BY_NODE_ID)
    public Result queryTplListByNodeId(String nodeId) {
        return monitorDataProcessBaseService.queryTplListByNodeId(nodeId);
    }


}
