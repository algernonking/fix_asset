package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

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
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 保养方案 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-05 09:51:44
*/


@Service("EamMaintainPlanService")
public class MaintainPlanServiceImpl extends SuperService<MaintainPlan> implements IMaintainPlanService {

	@Autowired
	private IMaintainTaskService maintainTaskService;


	@Autowired
	private AssetItemServiceImpl assetItemService;

	@Autowired
	private IAssetService assetService;

	@Autowired
	private IMaintainProjectSelectService maintainProjectSelectService;


	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;



	@Autowired
	private IMaintainTaskProjectService maintainTaskProjectService;


	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;

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

	@Override
	public Result start(String id) {
		MaintainPlan plan=this.getById(id);
		if(EamPlanStatusEnum.STOP.code().equals(plan.getStatus())){
			plan.setStatus(EamPlanStatusEnum.ACTING.code());
			super.update(plan,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态操作异常!");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result stop(String id) {
		MaintainPlan plan=this.getById(id);
		if(EamPlanStatusEnum.ACTING.code().equals(plan.getStatus())){
			plan.setStatus(EamPlanStatusEnum.STOP.code());
			super.update(plan,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态操作异常!");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result execute(String id) {
		MaintainPlan plan=this.getById(id);
		String status=plan.getStatus();
		boolean run=false;
		if(MaintainCycleMethodEnum.ONCE.code().equals(plan.getCycleMethod())){
			if(MaintainTaskStatusEnum.FINISH.code().equals(status)
					||MaintainTaskStatusEnum.CANCEL.code().equals(status)
			){
				return ErrorDesc.failureMessage("当前状态无法执行");
			}
			run=true;
		}else if(MaintainCycleMethodEnum.CYCLE.code().equals(plan.getCycleMethod())){
			if(!MaintainTaskStatusEnum.ACTING.code().equals(status)){
				return ErrorDesc.failureMessage("当前状态无法执行");
			}
			if(EamPlanStatusEnum.ACTING.code().equals(status)){
				run=true;
			}else{
				Logger.info("plan name:"+plan.getName()+",plan id:"+plan.getId()+",plan status value is "+status);
			}
		}else{
			Logger.info("plan name:"+plan.getName()+",plan id:"+plan.getId()+",cycleMethod not match,value:"+plan.getCycleMethod());
		}

		if(run){
			Logger.info("########## plan execute ###########");
			Logger.info("########## plan id:"+plan.getId()+" ###########");
			Logger.info("########## plan code:"+plan.getCode()+" ###########");
			Logger.info("########## plan name:"+plan.getName()+" ###########");
			Logger.info("########## plan trigger end ###########");
			this.dao().fill(plan)
					.with(MaintainPlanMeta.ASSET_LIST)
					.with(MaintainPlanMeta.PROJECT_LIST)
					.execute();
			List<Asset> assetList=plan.getAssetList();
		 	List<MaintainProject> projectList=plan.getProjectList();

			if(assetList==null||assetList.size()==0){
				return ErrorDesc.failureMessage("请选择保养设备");
			}
			//生产任务
			for(int i=0;i<assetList.size();i++){
				Asset asset=assetList.get(i);
				MaintainTask task=new MaintainTask();
				String taskId=IDGenerator.getSnowflakeIdString();
				task.setId(taskId);
				task.setPlanStartTime(new Date());
				task.setPlanId(plan.getId());
				task.setPlanInfo(plan.getInfo());
				task.setPlanName(plan.getName());
				task.setPlanNotes(plan.getNotes());
				task.setPlanMaintainType(plan.getMaintainType());
				task.setPlanCycleMethod(plan.getCycleMethod());
				task.setPlanTotalCost(plan.getTotalCost());
				task.setGroupId(plan.getGroupId());
				task.setAssetId(asset.getId());
				task.setAssetName(asset.getName());
				task.setAssetModel(asset.getModel());
				task.setAssetStatus(asset.getAssetStatus());
				task.setAssetCode(asset.getSerialNumber());
				//生产项目
				for(int j=0;j<projectList.size();j++){
					MaintainProject project=projectList.get(j);
					MaintainProjectSelect sel=new MaintainProjectSelect();
					sel.setOwnerId(taskId);
					sel.setProjectId(project.getId());
					maintainProjectSelectService.insert(sel);
					MaintainTaskProject taskProject=new MaintainTaskProject();
					taskProject.setTaskId(taskId);
					taskProject.setProjectId(project.getId());
					taskProject.setStatus(MaintainTaskProjectStatusEnum.UNEXECUTED.code());
					taskProject.setProjectCode(project.getCode());
					taskProject.setProjectName(project.getName());
					taskProject.setProjectMaintainType(project.getMaintainType());
					taskProject.setProjectNotes(project.getNotes());
					taskProject.setProjectAttachId(project.getAttachId());
					taskProject.setProjectBaseCost(project.getBaseCost());
					maintainTaskProjectService.insert(taskProject);
				}
				maintainTaskService.insert(task);
			}
		}else{
			Logger.info("########## plan not execute ###########");
			return ErrorDesc.failureMessage("当前执行失败");
		}
		return ErrorDesc.success();
	}


	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param maintainPlan  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MaintainPlan maintainPlan,boolean throwsException) {

		String selectedCode=maintainPlan.getSelectedCode();
		if(maintainPlan.getAssetIds()==null||maintainPlan.getAssetIds().size()==0){
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",selectedCode==null?"":selectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			maintainPlan.setAssetIds(list);
		}

		if(maintainPlan.getAssetIds()==null||maintainPlan.getAssetIds().size()==0){
			return ErrorDesc.failureMessage("请选择要保养的设备");
		}

		if(maintainPlan.getProjectIds()==null||maintainPlan.getProjectIds().size()==0){
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("selected_code",selectedCode==null?"":selectedCode);
			List<String> list=maintainProjectSelectService.queryValues(EAMTables.EAM_MAINTAIN_PROJECT_SELECT.PROJECT_ID,String.class,condition);
			maintainPlan.setProjectIds(list);
		}

		if(maintainPlan.getProjectIds()==null||maintainPlan.getProjectIds().size()==0){
			return ErrorDesc.failureMessage("请选择要保养的项目");
		}




		if(maintainPlan.getEndTime()!=null){
			Calendar c = Calendar.getInstance();
			Date now = new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
			if(maintainPlan.getEndTime().after(now)){
				maintainPlan.setStatus(EamPlanStatusEnum.EXPIRED.code());
			}
		}

		if(StringUtil.isBlank(maintainPlan.getStatus())){
			maintainPlan.setStatus(EamPlanStatusEnum.STOP.code());
		}


		//制单人
		if(StringUtil.isBlank(maintainPlan.getOriginatorId())){
			maintainPlan.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}


		//循环周期
		if(MaintainCycleMethodEnum.CYCLE.code().equals(maintainPlan.getCycleMethod())){
			if(StringUtil.isBlank(maintainPlan.getActionCycleId())){
				return ErrorDesc.failureMessage("请设置循环周期");
			}
		}



		//生成编码规则
		//编码
		if(StringUtil.isBlank(maintainPlan.getCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_MAINTAIN_PLAN.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				maintainPlan.setCode(codeResult.getData().toString());
			}
		}


		Result r=super.insert(maintainPlan,throwsException);
		if(r.isSuccess()){
			//保存表单数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<maintainPlan.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(maintainPlan.getId());
				asset.setAssetId(maintainPlan.getAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}
			dao.execute("update eam_maintain_project_select set owner_id=? where selected_code=?",maintainPlan.getId(),selectedCode);
		}
		return r;
	}


	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param maintainPlan 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MaintainPlan maintainPlan) {
		return this.insert(maintainPlan,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param maintainPlanList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MaintainPlan> maintainPlanList) {
		return super.insertList(maintainPlanList);
	}

	
	/**
	 * 按主键删除 保养方案
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MaintainPlan maintainPlan = new MaintainPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainPlan.setId(id);
		try {
			boolean suc = dao.deleteEntity(maintainPlan);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 保养方案
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MaintainPlan maintainPlan = new MaintainPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainPlan.setId(id);
		maintainPlan.setDeleted(true);
		maintainPlan.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		maintainPlan.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(maintainPlan,SaveMode.NOT_NULL_FIELDS);
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
	 * @param maintainPlan 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainPlan maintainPlan , SaveMode mode) {
		return this.update(maintainPlan,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param maintainPlan 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainPlan maintainPlan , SaveMode mode,boolean throwsException) {

		if(maintainPlan.getEndTime()!=null){
			Calendar c = Calendar.getInstance();
			Date now = new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
			if(maintainPlan.getEndTime().after(now)){
				maintainPlan.setStatus(EamPlanStatusEnum.EXPIRED.code());
			}
		}

		if(StringUtil.isBlank(maintainPlan.getStatus())){
			maintainPlan.setStatus(EamPlanStatusEnum.STOP.code());
		}


		//制单人
		if(StringUtil.isBlank(maintainPlan.getOriginatorId())){
			maintainPlan.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//循环周期
		if(MaintainCycleMethodEnum.CYCLE.code().equals(maintainPlan.getCycleMethod())){
			if(StringUtil.isBlank(maintainPlan.getActionCycleId())){
				return ErrorDesc.failureMessage("请设置循环周期");
			}
		}
		Result r=super.update(maintainPlan , mode , throwsException);
		if(r.isSuccess()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",maintainPlan.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",maintainPlan.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param maintainPlanList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MaintainPlan> maintainPlanList , SaveMode mode) {
		return super.updateList(maintainPlanList , mode);
	}

	
	/**
	 * 按主键更新字段 保养方案
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
	 * 按主键获取 保养方案
	 *
	 * @param id 主键
	 * @return MaintainPlan 数据对象
	 */
	public MaintainPlan getById(String id) {
		MaintainPlan sample = new MaintainPlan();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<MaintainPlan> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MaintainPlan> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MaintainPlan::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MaintainPlan> queryList(MaintainPlan sample) {
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
	public PagedList<MaintainPlan> queryPagedList(MaintainPlan sample, int pageSize, int pageIndex) {
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
	public PagedList<MaintainPlan> queryPagedList(MaintainPlan sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param maintainPlan 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MaintainPlan maintainPlan) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(maintainPlan, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(MaintainPlan sample) {
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