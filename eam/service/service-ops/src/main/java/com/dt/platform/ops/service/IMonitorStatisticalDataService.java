package com.dt.platform.ops.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.entity.ISuperService;

import java.util.HashMap;
import java.util.List;

public interface IMonitorStatisticalDataService extends ISuperService<MonitorNode> {


    Result<JSONObject> queryNodeStatistics();

    Result<JSONObject> queryNodeHostTopData(List<String> topList,int top,int day);

    Result<JSONObject> queryNodeHostResourceList();

    Result<JSONArray> queryNodeTreeResourceList();

    Result<JSONObject> queryNodeCollectDataFailed();

    Result<JSONObject> queryNodeCollectData(String nodeId);

    Result<JSONObject> queryNodeCollectDataGraph(String nodeId,String tplCode,String sdate,String edate,String day);

    Result<JSONArray> queryNodeCollectDataTpl(MonitorTpl tpl, String nodeId, String sdate, String edate, String day);



    Result<JSONObject> queryNodeCollectDataGraphByGraph(MonitorTplGraph graph, String nodeId, String sdate, String edate, String day);
}
