package com.dt.platform.ops.service;

import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.github.foxnic.api.transter.Result;

import java.util.List;

public interface IMonitorDataProcessService {


    List<MonitorNode> queryNodeList();

    List<MonitorTpl> queryTplList();

    List<MonitorTplIndicator> queryIndicatorList(String node);

    Result collectData();

}
