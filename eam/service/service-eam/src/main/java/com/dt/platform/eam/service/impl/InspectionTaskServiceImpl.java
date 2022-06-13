package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.InspectionTaskMeta;
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import com.dt.platform.eam.service.IInspectionTaskPointService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import com.dt.platform.eam.service.IInspectionTaskService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 巡检任务 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-13 10:28:04
*/


@Service("EamInspectionTaskService")
public class InspectionTaskServiceImpl extends SuperService<InspectionTask> implements IInspectionTaskService {


	@Autowired
	private IInspectionTaskPointService inspectionTaskPointService;

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param inspectionTask  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(InspectionTask inspectionTask,boolean throwsException) {

		if(StringUtil.isBlank(inspectionTask.getPlanId())){
			return ErrorDesc.failureMessage("方案未选择");
		}

		if(StringUtil.isBlank(inspectionTask.getTaskStatus())){
			inspectionTask.setTaskStatus(MaintainTaskStatusEnum.NOT_START.code());
		}

		//生成编码规则
		//编码
		if(StringUtil.isBlank(inspectionTask.getTaskCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INSPECTION_TASK.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				inspectionTask.setTaskCode(codeResult.getData().toString());
			}
		}
		Result r=super.insert(inspectionTask,throwsException);
		return r;
	}

	@Override
	public Result execute(String id) {
		return ErrorDesc.success();
	}

	@Override
	public Result cancel(String id) {
		InspectionTask task=this.getById(id);
		if(InspectionTaskStatusEnum.CANCEL.code().equals(task.getTaskStatus())||
				InspectionTaskStatusEnum.FINISH.code().equals(task.getTaskStatus())
		){
			return ErrorDesc.failureMessage("当前保养任务状态异常，不能进行完成任务操作");
		}
		task.setTaskStatus(InspectionTaskStatusEnum.CANCEL.code());
		super.update(task,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}

	@Override
	public Result finish(String id) {

		InspectionTask inspectionTask=this.getById(id);
		this.dao().fill(inspectionTask)
				.with(InspectionTaskMeta.INSPECTION_TASK_POINT_LIST)
				.execute();
		List<InspectionTaskPoint> list=inspectionTask.getInspectionTaskPointList();

		if(list==null||list.size()==0){
			return ErrorDesc.failureMessage("当前没有巡检点需要巡检");
		}

		double sumDiffTime=0.0;
		Date minDate=null;
		Date maxDate=null;;

		for(int i=0;i<list.size();i++){
			InspectionTaskPoint inspectionTaskPoint=list.get(i);
			if(!InspectionTaskStatusEnum.FINISH.code().equals(inspectionTaskPoint.getStatus())){
				return ErrorDesc.failureMessage("巡检点:"+inspectionTaskPoint.getPointName()+"未做巡检");
			}
			if(inspectionTaskPoint.getOperTime()==null){
				return ErrorDesc.failureMessage("巡检点:"+inspectionTaskPoint.getPointName()+"未做巡检");
			}else{
				if(minDate==null){
					minDate=inspectionTaskPoint.getOperTime();
				}
				if(maxDate==null){
					maxDate=inspectionTaskPoint.getOperTime();
				}
				if(inspectionTaskPoint.getOperTime().getTime()<minDate.getTime()){
					minDate=inspectionTaskPoint.getOperTime();
				}
				if(inspectionTaskPoint.getOperTime().getTime()>maxDate.getTime()){
					maxDate=inspectionTaskPoint.getOperTime();
				}
			}
		}
		inspectionTask.setActStartTime(minDate);
		inspectionTask.setActFinishTime(maxDate);
		inspectionTask.setTaskStatus(InspectionTaskStatusEnum.FINISH.code());
		inspectionTask.setExecutorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		long times = maxDate.getTime() - minDate.getTime();
		double hours = (double) times/(60*60*1000);
		BigDecimal a= BigDecimal.valueOf(hours);
		double diffTime = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		inspectionTask.setActTotalCost(new BigDecimal(sumDiffTime));
		super.update(inspectionTask,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inspectionTask 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(InspectionTask inspectionTask) {
		return this.insert(inspectionTask,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inspectionTaskList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<InspectionTask> inspectionTaskList) {
		return super.insertList(inspectionTaskList);
	}

	
	/**
	 * 按主键删除 巡检任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		InspectionTask inspectionTask = new InspectionTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionTask.setId(id);
		try {
			boolean suc = dao.deleteEntity(inspectionTask);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 巡检任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		InspectionTask inspectionTask = new InspectionTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionTask.setId(id);
		inspectionTask.setDeleted(true);
		inspectionTask.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inspectionTask.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inspectionTask,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param inspectionTask 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionTask inspectionTask , SaveMode mode) {
		return this.update(inspectionTask,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inspectionTask 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionTask inspectionTask , SaveMode mode,boolean throwsException) {
		inspectionTask.setTaskStatus(InspectionTaskStatusEnum.ACTING.code());
		Result r=super.update(inspectionTask , mode , throwsException);
		return r;

	}

	/**
	 * 更新实体集，事务内
	 * @param inspectionTaskList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<InspectionTask> inspectionTaskList , SaveMode mode) {
		return super.updateList(inspectionTaskList , mode);
	}

	
	/**
	 * 按主键更新字段 巡检任务
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取 巡检任务
	 *
	 * @param id 主键
	 * @return InspectionTask 数据对象
	 */
	public InspectionTask getById(String id) {
		InspectionTask sample = new InspectionTask();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<InspectionTask> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, InspectionTask> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, InspectionTask::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<InspectionTask> queryList(InspectionTask sample) {
		return super.queryList(sample);
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<InspectionTask> queryPagedList(InspectionTask sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}

	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<InspectionTask> queryPagedList(InspectionTask sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param inspectionTask 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(InspectionTask inspectionTask) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(inspectionTask, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(InspectionTask sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}