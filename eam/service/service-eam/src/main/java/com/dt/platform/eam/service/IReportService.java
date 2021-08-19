package com.dt.platform.eam.service;

import com.dt.platform.domain.eam.Position;
import com.github.foxnic.api.transter.Result;

public interface IReportService {

    /**
     * 插入实体
     * @param value 实体数据
     * @return 插入是否成功
     * */
    void insert(String value);

}
