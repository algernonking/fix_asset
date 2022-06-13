package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import com.dt.platform.eam.service.IInspectionPointService;
import com.dt.platform.eam.service.IInspectionTaskPointService;
import com.dt.platform.eam.service.IInspectionTaskService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
import com.dt.platform.eam.service.IInspectionPlanService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 巡检计划 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-11 08:12:42
*/


@Service("EamInspectionPlanService")
public class InspectionPlanServiceImpl extends SuperService<InspectionPlan> implements IInspectionPlanService {


	@Autowired
	private IInspectionPointService inspectionPointService;

	@Autowired
	private IInspectionTaskPointService inspectionTaskPointService;


	@Autowired
	private IInspectionTaskService inspectionTaskService;
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
	public Result start(String id) {
		InspectionPlan plan=this.getById(id);
		if(EamPlanStatusEnum.STOP.code().equals(plan.getPlanStatus())){
			plan.setPlanStatus(EamPlanStatusEnum.ACTING.code());
			super.update(plan,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态操作异常!");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result stop(String id) {
		InspectionPlan plan=this.getById(id);
		if(EamPlanStatusEnum.ACTING.code().equals(plan.getPlanStatus())){
			plan.setPlanStatus(EamPlanStatusEnum.STOP.code());
			super.update(plan,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态操作异常!");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result execute(String id) {

		InspectionPlan plan=this.getById(id);
		String status=plan.getPlanStatus();
		if(EamPlanStatusEnum.ACTING.code().equals(status)){
			Logger.info("########## plan execute ###########");
			Logger.info("########## plan id:"+plan.getId()+" ###########");
			Logger.info("########## plan code:"+plan.getPlanCode()+" ###########");
			Logger.info("########## plan name:"+plan.getName()+" ###########");
			Logger.info("########## plan trigger end ###########");
			this.dao().fill(plan)
					.with(InspectionPlanMeta.INSPECTION_PLAN_POINT_LIST)
					.with(InspectionPlanMeta.INSPECTION_POINT_OWNER_LIST)
					.execute();
			List<InspectionPointOwner> pointOwnerList=plan.getInspectionPointOwnerList();
			if(pointOwnerList==null&&pointOwnerList.size()==0){
				return ErrorDesc.failureMessage("当前巡检计划未设置巡检点");
			}

			//生成计划
			InspectionTask task=new InspectionTask();
			String taskId=IDGenerator.getSnowflakeIdString();
			task.setId(taskId);
			task.setPlanId(plan.getId());
			task.setPlanName(plan.getName());
			task.setPlanStartTime(new Date());
			task.setPlanCode(plan.getPlanCode());
			task.setPlanNotes(plan.getNotes());
			task.setPlanInspectionMethod(plan.getInspectionMethod());
			task.setPlanCompletionTime(plan.getCompletionTime());
			task.setGroupId(plan.getGroupId());
			inspectionTaskService.insert(task,false);
			//生成巡检点
			for(int i=0;i<pointOwnerList.size();i++){
				InspectionPointOwner pointOwner=pointOwnerList.get(i);
				InspectionPoint point=inspectionPointService.getById(pointOwner.getPointId());
				InspectionTaskPoint taskPoint=new InspectionTaskPoint();
				taskPoint.setTaskId(taskId);
				taskPoint.setStatus(InspectionTaskStatusEnum.NOT_START.code());
				taskPoint.setPointStatus(InspectionTaskPointStatusEnum.NORMAL.code());
				taskPoint.setPointCode(point.getCode());
				taskPoint.setPointName(point.getName());
				taskPoint.setPointContent(point.getContent());
				taskPoint.setPointRouteId(point.getRouteId());
				taskPoint.setPointRfid(point.getRfid());
				taskPoint.setPointPos(point.getPos());
				taskPoint.setPointPosLatitude(point.getPosLatitude());
				taskPoint.setPointPosLongitude(point.getPosLongitude());
				taskPoint.setNotes(point.getNotes());
				taskPoint.setSort(pointOwner.getSort());
				inspectionTaskPointService.insert(taskPoint,false);
			}
		}else{
			return ErrorDesc.failureMessage("当前巡检计划状态不能生成巡检任务");
		}


		return ErrorDesc.success();
	}


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param inspectionPlan  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(InspectionPlan inspectionPlan,boolean throwsException) {

		String selectedCode=inspectionPlan.getSelectedCode();

		if(StringUtil.isBlank(inspectionPlan.getStatus())){
			inspectionPlan.setStatus(EamPlanStatusEnum.STOP.code());
		}

		//生成编码规则
		//编码
		if(StringUtil.isBlank(inspectionPlan.getPlanCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INSPECTION_PLAN.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				inspectionPlan.setPlanCode(codeResult.getData().toString());
			}
		}
		Result r=super.insert(inspectionPlan,throwsException);
		if(r.isSuccess()){

			dao.execute("update eam_inspection_point_owner set owner_id=? where selected_code=?",inspectionPlan.getId(),selectedCode);
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inspectionPlan 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(InspectionPlan inspectionPlan) {
		return this.insert(inspectionPlan,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inspectionPlanList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<InspectionPlan> inspectionPlanList) {
		return super.insertList(inspectionPlanList);
	}

	
	/**
	 * 按主键删除 巡检计划
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		InspectionPlan inspectionPlan = new InspectionPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionPlan.setId(id);
		try {
			boolean suc = dao.deleteEntity(inspectionPlan);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 巡检计划
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		InspectionPlan inspectionPlan = new InspectionPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionPlan.setId(id);
		inspectionPlan.setDeleted(true);
		inspectionPlan.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inspectionPlan.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inspectionPlan,SaveMode.NOT_NULL_FIELDS);
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
	 * @param inspectionPlan 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionPlan inspectionPlan , SaveMode mode) {
		return this.update(inspectionPlan,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inspectionPlan 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionPlan inspectionPlan , SaveMode mode,boolean throwsException) {

		Result r=super.update(inspectionPlan , mode , throwsException);
		if(r.isSuccess()){
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param inspectionPlanList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<InspectionPlan> inspectionPlanList , SaveMode mode) {
		return super.updateList(inspectionPlanList , mode);
	}

	
	/**
	 * 按主键更新字段 巡检计划
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
	 * 按主键获取 巡检计划
	 *
	 * @param id 主键
	 * @return InspectionPlan 数据对象
	 */
	public InspectionPlan getById(String id) {
		InspectionPlan sample = new InspectionPlan();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<InspectionPlan> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, InspectionPlan> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, InspectionPlan::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<InspectionPlan> queryList(InspectionPlan sample) {
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
	public PagedList<InspectionPlan> queryPagedList(InspectionPlan sample, int pageSize, int pageIndex) {
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
	public PagedList<InspectionPlan> queryPagedList(InspectionPlan sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param inspectionPlan 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(InspectionPlan inspectionPlan) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(inspectionPlan, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(InspectionPlan sample) {
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