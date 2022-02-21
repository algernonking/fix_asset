package com.dt.platform.ops.service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.ops.MonitorMethodEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Insert;

import java.util.List;

public interface IMonitorDataProcessBaseService {



    Result<JSONArray> queryNodeZabbixAgentData();


    List<MonitorNode> queryNodeListByMonitorMethod(String monitorMethod);

    List<MonitorTpl> queryTplListByMonitorMethod(String monitorMethod);

    Result<List<MonitorTpl>> queryTplListByNodeId(String nodeId);

    List<MonitorTplIndicator> queryIndicatorList(String nodeId);

    Insert createBaseInsert(MonitorTplIndicator indicator, MonitorNode node);

    Result executeCollectDataInsert(List<Insert> insList);

    String queryIndicatorCommand(MonitorNode node, String cmd,String cmdVar);

    Result<Object> convertToInsertData(MonitorTplIndicator tplIndicator,String content,MonitorNode node);

    List<MonitorNode> queryExecuteNodeList(String monitorMethod) ;

    List<MonitorTplIndicator> queryExecuteIndicatorList(String nodeId,String monitorMethod);



}
