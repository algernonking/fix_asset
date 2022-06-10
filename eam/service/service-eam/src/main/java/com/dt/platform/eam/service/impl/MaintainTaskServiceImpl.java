package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskOverdueEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskProjectStatusEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskStatusEnum;
import com.dt.platform.domain.eam.MaintainTaskProject;
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import com.dt.platform.eam.service.IMaintainTaskProjectService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.MaintainTask;
import com.dt.platform.domain.eam.MaintainTaskVO;

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
import com.dt.platform.eam.service.IMaintainTaskService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 保养任务 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 21:41:15
*/


@Service("EamMaintainTaskService")
public class MaintainTaskServiceImpl extends SuperService<MaintainTask> implements IMaintainTaskService {

	@Autowired
	private IMaintainTaskProjectService maintainTaskProjectService;

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
	public Result cancel(List<String> ids) {
		if(ids==null||ids.size()==0){
			return ErrorDesc.failureMessage("请选择任务");
		}
		ConditionExpr expr=new ConditionExpr();
		expr.andIn("status","not_start");
		expr.andIn("id",ids);
		List<MaintainTask> list=this.queryList(expr);

		if(list.size()!=ids.size()){
			return ErrorDesc.failureMessage("选中的任务部分不符合要求");
		}

		for(int i=0;i<list.size();i++){
			list.get(i).setStatus("cancel");
			super.update(list.get(i),SaveMode.NOT_NULL_FIELDS,false);
		}
		return ErrorDesc.success();
	}

	@Override
	public Result execute(String id) {

		return null;
	}


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param maintainTask  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MaintainTask maintainTask,boolean throwsException) {


		if(StringUtil.isBlank(maintainTask.getAssetId())){
			return ErrorDesc.failureMessage("资产未选择");
		}

		if(StringUtil.isBlank(maintainTask.getPlanId())){
			return ErrorDesc.failureMessage("方案未选择");
		}

		if(StringUtil.isBlank(maintainTask.getStatus())){
			maintainTask.setStatus(MaintainTaskStatusEnum.NOT_START.code());
		}

		if(StringUtil.isBlank(maintainTask.getOverdue())){
			maintainTask.setOverdue(MaintainTaskOverdueEnum.NORMAL.code());
		}


		//生成编码规则
		//编码
		if(StringUtil.isBlank(maintainTask.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_MAINTAIN_TASK.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				maintainTask.setBusinessCode(codeResult.getData().toString());
			}
		}


		Result r=super.insert(maintainTask,throwsException);
		return r;
	}



	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param maintainTask 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MaintainTask maintainTask) {
		return this.insert(maintainTask,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param maintainTaskList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MaintainTask> maintainTaskList) {
		return super.insertList(maintainTaskList);
	}

	
	/**
	 * 按主键删除 保养任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MaintainTask maintainTask = new MaintainTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainTask.setId(id);
		try {
			boolean suc = dao.deleteEntity(maintainTask);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 保养任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MaintainTask maintainTask = new MaintainTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainTask.setId(id);
		maintainTask.setDeleted(true);
		maintainTask.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		maintainTask.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(maintainTask,SaveMode.NOT_NULL_FIELDS);
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
	 * @param maintainTask 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainTask maintainTask , SaveMode mode) {
		return this.update(maintainTask,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param maintainTask 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainTask maintainTask , SaveMode mode,boolean throwsException) {

		if(MaintainTaskStatusEnum.CANCEL.code().equals(maintainTask.getStatus())
		|| MaintainTaskStatusEnum.FINISH.code().equals(maintainTask.getStatus())
		){
			return ErrorDesc.failureMessage("当前状态操作异常");
		}

		//maintainTask
		this.dao().fill(maintainTask)
				.with(MaintainTaskMeta.PROJECT_LIST)
				.with(MaintainTaskMeta.TASK_PROJECT_LIST)
				.execute();
		List<MaintainTaskProject> list=maintainTask.getTaskProjectList();
		double sumDiffTime=0.0;
		Date minDate=null;
		Date maxDate=null;;
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				MaintainTaskProject maintainTaskProject=list.get(i);
				if(maintainTaskProject.getStartTime()==null||maintainTaskProject.getEndTime()==null){
					return ErrorDesc.failureMessage("维保项目编号:"+maintainTaskProject.getProjectCode()+"未选择时间");
				}else{
					if(minDate==null){
						minDate=maintainTaskProject.getStartTime();
					}
					if(maxDate==null){
						maxDate=maintainTaskProject.getEndTime();
					}
					if(maintainTaskProject.getStartTime().getTime()<minDate.getTime()){
						minDate=maintainTaskProject.getStartTime();
					}
					if(maintainTaskProject.getEndTime().getTime()>maxDate.getTime()){
						maxDate=maintainTaskProject.getEndTime();
					}
					long times = maintainTaskProject.getEndTime().getTime() - maintainTaskProject.getStartTime().getTime();
					if(times<0){
						return ErrorDesc.failureMessage("请确保结束时间大于开始时间");
					}
					double hours = (double) times/(60*60*1000);
					BigDecimal a= BigDecimal.valueOf(hours);
					double diffTime = a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					sumDiffTime=sumDiffTime+diffTime;

					list.get(i).setBaseCost(new BigDecimal(diffTime));
					list.get(i).setStatus(MaintainTaskProjectStatusEnum.EXECUTED.code());
				}
			}
			maintainTaskProjectService.updateList(list,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failureMessage("没有需要的保养项目");
		}
		maintainTask.setActStartTime(minDate);
		maintainTask.setActFinishTime(maxDate);
		maintainTask.setStatus(MaintainTaskStatusEnum.FINISH.code());
		maintainTask.setActTotalCost(new BigDecimal(sumDiffTime));
		Result r=super.update(maintainTask , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param maintainTaskList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MaintainTask> maintainTaskList , SaveMode mode) {
		return super.updateList(maintainTaskList , mode);
	}

	
	/**
	 * 按主键更新字段 保养任务
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
	 * 按主键获取 保养任务
	 *
	 * @param id 主键
	 * @return MaintainTask 数据对象
	 */
	public MaintainTask getById(String id) {
		MaintainTask sample = new MaintainTask();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<MaintainTask> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MaintainTask> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MaintainTask::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MaintainTask> queryList(MaintainTask sample) {
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
	public PagedList<MaintainTask> queryPagedList(MaintainTask sample, int pageSize, int pageIndex) {
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
	public PagedList<MaintainTask> queryPagedList(MaintainTask sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param maintainTask 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MaintainTask maintainTask) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(maintainTask, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(MaintainTask sample) {
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