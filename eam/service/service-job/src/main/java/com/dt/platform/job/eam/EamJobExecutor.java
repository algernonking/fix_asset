package com.dt.platform.job.eam;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.springframework.stereotype.Component;

@Component
public class EamJobExecutor implements JobExecutor {
    @Override
    public String getName() {
        return "EamJobExecutor";
    }

    @Override
    public Result execute(Object o, Job job, JSONObject jsonObject) {
        Logger.info("EamJobExecutor 执行 Job ");
        return ErrorDesc.success();
    }
}
