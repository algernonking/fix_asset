package com.dt.platform.ops.service;


import com.dt.platform.domain.ops.MonitorNodeDb;
import com.dt.platform.domain.ops.MonitorNodeValue;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 节点数值 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-05 16:28:30
*/

public interface IMonitorIndicatorParseService extends ISuperService<MonitorNodeValue> {

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param monitorNodeDb 数据对象
	 * @return 插入是否成功
	 * */
	Result parse(MonitorNodeDb monitorNodeDb);


}