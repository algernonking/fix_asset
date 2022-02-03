package com.dt.platform.ops.service;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.MonitorNode;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.entity.ISuperService;

import java.util.HashMap;
import java.util.List;

public interface IMonitorStatisticalDataService extends ISuperService<MonitorNode> {


    Result<JSONObject> queryNodeStatistics();

    Result<JSONObject> queryNodeHostTopData(List<String> topList,int top,int day);


}
