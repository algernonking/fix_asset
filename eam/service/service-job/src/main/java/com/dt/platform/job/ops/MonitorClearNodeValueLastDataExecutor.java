package com.dt.platform.job.ops;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.proxy.ops.MonitorDataProcessScriptServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.springframework.stereotype.Component;

@Component
public class MonitorClearNodeValueLastDataExecutor implements JobExecutor {
    @Override
    public String getName() {
        return "MonitorClearNodeValueLastDataExecutor";
    }

    @Override
    public Result execute(Object o, Job job, JSONObject jsonObject) {
        Logger.info("MonitorClearNodeValueLastDataExecutor 执行 Job ");
        MonitorDataProcessScriptServiceProxy.api().clearNodeValueLastHistoryData();
        return ErrorDesc.success();
    }
}
