package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.MaintainTask;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.MaintainProject;
import java.util.List;
import com.dt.platform.domain.eam.MaintainTaskProject;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.MaintainPlan;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.MaintainGroup;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-09 07:09:01
 * @sign 2FC01F3F467B509F1F36DE91372610CB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MaintainTaskMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 逾期 , 类型: java.lang.String
	*/
	public static final String OVERDUE="overdue";
	
	/**
	 * 逾期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> OVERDUE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,OVERDUE, java.lang.String.class, "逾期", "逾期", java.lang.String.class, null);
	
	/**
	 * 任务编码 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 任务编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,BUSINESS_CODE, java.lang.String.class, "任务编码", "任务编码", java.lang.String.class, null);
	
	/**
	 * 方案 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 方案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_ID, java.lang.String.class, "方案", "方案", java.lang.String.class, null);
	
	/**
	 * 方案名称 , 类型: java.lang.String
	*/
	public static final String PLAN_NAME="planName";
	
	/**
	 * 方案名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> PLAN_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_NAME, java.lang.String.class, "方案名称", "方案名称", java.lang.String.class, null);
	
	/**
	 * 方案说明 , 类型: java.lang.String
	*/
	public static final String PLAN_INFO="planInfo";
	
	/**
	 * 方案说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> PLAN_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_INFO, java.lang.String.class, "方案说明", "方案说明", java.lang.String.class, null);
	
	/**
	 * 方案备注 , 类型: java.lang.String
	*/
	public static final String PLAN_NOTES="planNotes";
	
	/**
	 * 方案备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> PLAN_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_NOTES, java.lang.String.class, "方案备注", "方案备注", java.lang.String.class, null);
	
	/**
	 * 保养类型 , 类型: java.lang.String
	*/
	public static final String PLAN_MAINTAIN_TYPE="planMaintainType";
	
	/**
	 * 保养类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> PLAN_MAINTAIN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_MAINTAIN_TYPE, java.lang.String.class, "保养类型", "保养类型", java.lang.String.class, null);
	
	/**
	 * 循环方式 , 类型: java.lang.String
	*/
	public static final String PLAN_CYCLE_METHOD="planCycleMethod";
	
	/**
	 * 循环方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> PLAN_CYCLE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_CYCLE_METHOD, java.lang.String.class, "循环方式", "循环方式", java.lang.String.class, null);
	
	/**
	 * 计划工时 , 类型: java.math.BigDecimal
	*/
	public static final String PLAN_TOTAL_COST="planTotalCost";
	
	/**
	 * 计划工时 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.math.BigDecimal> PLAN_TOTAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_TOTAL_COST, java.math.BigDecimal.class, "计划工时", "计划工时", java.math.BigDecimal.class, null);
	
	/**
	 * 班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,GROUP_ID, java.lang.String.class, "班组", "班组", java.lang.String.class, null);
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ASSET_ID, java.lang.String.class, "设备", "设备", java.lang.String.class, null);
	
	/**
	 * 设备名称 , 类型: java.lang.String
	*/
	public static final String ASSET_NAME="assetName";
	
	/**
	 * 设备名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ASSET_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ASSET_NAME, java.lang.String.class, "设备名称", "设备名称", java.lang.String.class, null);
	
	/**
	 * 设备型号 , 类型: java.lang.String
	*/
	public static final String ASSET_MODEL="assetModel";
	
	/**
	 * 设备型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ASSET_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ASSET_MODEL, java.lang.String.class, "设备型号", "设备型号", java.lang.String.class, null);
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final String ASSET_STATUS="assetStatus";
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ASSET_STATUS, java.lang.String.class, "设备状态", "设备状态", java.lang.String.class, null);
	
	/**
	 * 设备编码 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 设备编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ASSET_CODE, java.lang.String.class, "设备编码", "设备编码", java.lang.String.class, null);
	
	/**
	 * 设备序列号 , 类型: java.lang.String
	*/
	public static final String ASSET_SN="assetSn";
	
	/**
	 * 设备序列号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ASSET_SN_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ASSET_SN, java.lang.String.class, "设备序列号", "设备序列号", java.lang.String.class, null);
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final String EXECUTOR_ID="executorId";
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> EXECUTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,EXECUTOR_ID, java.lang.String.class, "执行人", "执行人", java.lang.String.class, null);
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final String PLAN_START_TIME="planStartTime";
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.util.Date> PLAN_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PLAN_START_TIME, java.util.Date.class, "应开始时间", "应开始时间", java.util.Date.class, null);
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final String ACT_START_TIME="actStartTime";
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.util.Date> ACT_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ACT_START_TIME, java.util.Date.class, "实际开始时间", "实际开始时间", java.util.Date.class, null);
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final String ACT_FINISH_TIME="actFinishTime";
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.util.Date> ACT_FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ACT_FINISH_TIME, java.util.Date.class, "实际完成时间", "实际完成时间", java.util.Date.class, null);
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final String ACT_TOTAL_COST="actTotalCost";
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.math.BigDecimal> ACT_TOTAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ACT_TOTAL_COST, java.math.BigDecimal.class, "实际工时", "实际工时", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainProject
	*/
	public static final String PROJECT_LIST="projectList";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainProject
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,com.dt.platform.domain.eam.MaintainProject> PROJECT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PROJECT_LIST, java.util.List.class, "项目", "项目", com.dt.platform.domain.eam.MaintainProject.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PROJECT_IDS="projectIds";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> PROJECT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,PROJECT_IDS, java.util.List.class, "项目", "项目", java.lang.String.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainTaskProject
	*/
	public static final String TASK_PROJECT_LIST="taskProjectList";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainTaskProject
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,com.dt.platform.domain.eam.MaintainTaskProject> TASK_PROJECT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,TASK_PROJECT_LIST, java.util.List.class, "项目", "项目", com.dt.platform.domain.eam.MaintainTaskProject.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String TASK_PROJECT_IDS="taskProjectIds";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,java.lang.String> TASK_PROJECT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,TASK_PROJECT_IDS, java.util.List.class, "项目", "项目", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.MaintainPlan
	*/
	public static final String MAINTAIN_PLAN="MaintainPlan";
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.MaintainPlan
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,com.dt.platform.domain.eam.MaintainPlan> MAINTAIN_PLAN_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,MAINTAIN_PLAN, com.dt.platform.domain.eam.MaintainPlan.class, "方案", "方案", com.dt.platform.domain.eam.MaintainPlan.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTAIN_TYPE_DICT="maintainTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,org.github.foxnic.web.domain.system.DictItem> MAINTAIN_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,MAINTAIN_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 执行班组 , 类型: com.dt.platform.domain.eam.MaintainGroup
	*/
	public static final String MAINTAIN_GROUP="maintainGroup";
	
	/**
	 * 执行班组 , 类型: com.dt.platform.domain.eam.MaintainGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,com.dt.platform.domain.eam.MaintainGroup> MAINTAIN_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,MAINTAIN_GROUP, com.dt.platform.domain.eam.MaintainGroup.class, "执行班组", "执行班组", com.dt.platform.domain.eam.MaintainGroup.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EXECUTOR="executor";
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTask,org.github.foxnic.web.domain.hrm.Employee> EXECUTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTask.class ,EXECUTOR, org.github.foxnic.web.domain.hrm.Employee.class, "执行人", "执行人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , OVERDUE , BUSINESS_CODE , PLAN_ID , PLAN_NAME , PLAN_INFO , PLAN_NOTES , PLAN_MAINTAIN_TYPE , PLAN_CYCLE_METHOD , PLAN_TOTAL_COST , GROUP_ID , ASSET_ID , ASSET_NAME , ASSET_MODEL , ASSET_STATUS , ASSET_CODE , ASSET_SN , EXECUTOR_ID , PLAN_START_TIME , ACT_START_TIME , ACT_FINISH_TIME , ACT_TOTAL_COST , NOTES , SELECTED_CODE , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , PROJECT_LIST , PROJECT_IDS , TASK_PROJECT_LIST , TASK_PROJECT_IDS , ASSET , MAINTAIN_PLAN , MAINTAIN_TYPE_DICT , MAINTAIN_GROUP , ORIGINATOR , EXECUTOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.MaintainTask {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MaintainTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MaintainTask setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 逾期
		 * @param overdue 逾期
		 * @return 当前对象
		*/
		public MaintainTask setOverdue(String overdue) {
			super.change(OVERDUE,super.getOverdue(),overdue);
			super.setOverdue(overdue);
			return this;
		}
		
		/**
		 * 设置 任务编码
		 * @param businessCode 任务编码
		 * @return 当前对象
		*/
		public MaintainTask setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 方案
		 * @param planId 方案
		 * @return 当前对象
		*/
		public MaintainTask setPlanId(String planId) {
			super.change(PLAN_ID,super.getPlanId(),planId);
			super.setPlanId(planId);
			return this;
		}
		
		/**
		 * 设置 方案名称
		 * @param planName 方案名称
		 * @return 当前对象
		*/
		public MaintainTask setPlanName(String planName) {
			super.change(PLAN_NAME,super.getPlanName(),planName);
			super.setPlanName(planName);
			return this;
		}
		
		/**
		 * 设置 方案说明
		 * @param planInfo 方案说明
		 * @return 当前对象
		*/
		public MaintainTask setPlanInfo(String planInfo) {
			super.change(PLAN_INFO,super.getPlanInfo(),planInfo);
			super.setPlanInfo(planInfo);
			return this;
		}
		
		/**
		 * 设置 方案备注
		 * @param planNotes 方案备注
		 * @return 当前对象
		*/
		public MaintainTask setPlanNotes(String planNotes) {
			super.change(PLAN_NOTES,super.getPlanNotes(),planNotes);
			super.setPlanNotes(planNotes);
			return this;
		}
		
		/**
		 * 设置 保养类型
		 * @param planMaintainType 保养类型
		 * @return 当前对象
		*/
		public MaintainTask setPlanMaintainType(String planMaintainType) {
			super.change(PLAN_MAINTAIN_TYPE,super.getPlanMaintainType(),planMaintainType);
			super.setPlanMaintainType(planMaintainType);
			return this;
		}
		
		/**
		 * 设置 循环方式
		 * @param planCycleMethod 循环方式
		 * @return 当前对象
		*/
		public MaintainTask setPlanCycleMethod(String planCycleMethod) {
			super.change(PLAN_CYCLE_METHOD,super.getPlanCycleMethod(),planCycleMethod);
			super.setPlanCycleMethod(planCycleMethod);
			return this;
		}
		
		/**
		 * 设置 计划工时
		 * @param planTotalCost 计划工时
		 * @return 当前对象
		*/
		public MaintainTask setPlanTotalCost(BigDecimal planTotalCost) {
			super.change(PLAN_TOTAL_COST,super.getPlanTotalCost(),planTotalCost);
			super.setPlanTotalCost(planTotalCost);
			return this;
		}
		
		/**
		 * 设置 班组
		 * @param groupId 班组
		 * @return 当前对象
		*/
		public MaintainTask setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 设备
		 * @param assetId 设备
		 * @return 当前对象
		*/
		public MaintainTask setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 设备名称
		 * @param assetName 设备名称
		 * @return 当前对象
		*/
		public MaintainTask setAssetName(String assetName) {
			super.change(ASSET_NAME,super.getAssetName(),assetName);
			super.setAssetName(assetName);
			return this;
		}
		
		/**
		 * 设置 设备型号
		 * @param assetModel 设备型号
		 * @return 当前对象
		*/
		public MaintainTask setAssetModel(String assetModel) {
			super.change(ASSET_MODEL,super.getAssetModel(),assetModel);
			super.setAssetModel(assetModel);
			return this;
		}
		
		/**
		 * 设置 设备状态
		 * @param assetStatus 设备状态
		 * @return 当前对象
		*/
		public MaintainTask setAssetStatus(String assetStatus) {
			super.change(ASSET_STATUS,super.getAssetStatus(),assetStatus);
			super.setAssetStatus(assetStatus);
			return this;
		}
		
		/**
		 * 设置 设备编码
		 * @param assetCode 设备编码
		 * @return 当前对象
		*/
		public MaintainTask setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 设备序列号
		 * @param assetSn 设备序列号
		 * @return 当前对象
		*/
		public MaintainTask setAssetSn(String assetSn) {
			super.change(ASSET_SN,super.getAssetSn(),assetSn);
			super.setAssetSn(assetSn);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executorId 执行人
		 * @return 当前对象
		*/
		public MaintainTask setExecutorId(String executorId) {
			super.change(EXECUTOR_ID,super.getExecutorId(),executorId);
			super.setExecutorId(executorId);
			return this;
		}
		
		/**
		 * 设置 应开始时间
		 * @param planStartTime 应开始时间
		 * @return 当前对象
		*/
		public MaintainTask setPlanStartTime(Date planStartTime) {
			super.change(PLAN_START_TIME,super.getPlanStartTime(),planStartTime);
			super.setPlanStartTime(planStartTime);
			return this;
		}
		
		/**
		 * 设置 实际开始时间
		 * @param actStartTime 实际开始时间
		 * @return 当前对象
		*/
		public MaintainTask setActStartTime(Date actStartTime) {
			super.change(ACT_START_TIME,super.getActStartTime(),actStartTime);
			super.setActStartTime(actStartTime);
			return this;
		}
		
		/**
		 * 设置 实际完成时间
		 * @param actFinishTime 实际完成时间
		 * @return 当前对象
		*/
		public MaintainTask setActFinishTime(Date actFinishTime) {
			super.change(ACT_FINISH_TIME,super.getActFinishTime(),actFinishTime);
			super.setActFinishTime(actFinishTime);
			return this;
		}
		
		/**
		 * 设置 实际工时
		 * @param actTotalCost 实际工时
		 * @return 当前对象
		*/
		public MaintainTask setActTotalCost(BigDecimal actTotalCost) {
			super.change(ACT_TOTAL_COST,super.getActTotalCost(),actTotalCost);
			super.setActTotalCost(actTotalCost);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MaintainTask setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public MaintainTask setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public MaintainTask setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MaintainTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MaintainTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MaintainTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MaintainTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MaintainTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MaintainTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MaintainTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public MaintainTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public MaintainTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param projectList 项目
		 * @return 当前对象
		*/
		public MaintainTask setProjectList(List<MaintainProject> projectList) {
			super.change(PROJECT_LIST,super.getProjectList(),projectList);
			super.setProjectList(projectList);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param projectIds 项目
		 * @return 当前对象
		*/
		public MaintainTask setProjectIds(List<String> projectIds) {
			super.change(PROJECT_IDS,super.getProjectIds(),projectIds);
			super.setProjectIds(projectIds);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param taskProjectList 项目
		 * @return 当前对象
		*/
		public MaintainTask setTaskProjectList(List<MaintainTaskProject> taskProjectList) {
			super.change(TASK_PROJECT_LIST,super.getTaskProjectList(),taskProjectList);
			super.setTaskProjectList(taskProjectList);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param taskProjectIds 项目
		 * @return 当前对象
		*/
		public MaintainTask setTaskProjectIds(List<String> taskProjectIds) {
			super.change(TASK_PROJECT_IDS,super.getTaskProjectIds(),taskProjectIds);
			super.setTaskProjectIds(taskProjectIds);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public MaintainTask setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 方案
		 * @param MaintainPlan 方案
		 * @return 当前对象
		*/
		public MaintainTask setMaintainPlan(MaintainPlan MaintainPlan) {
			super.change(MAINTAIN_PLAN,super.getMaintainPlan(),MaintainPlan);
			super.setMaintainPlan(MaintainPlan);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param maintainTypeDict 类型
		 * @return 当前对象
		*/
		public MaintainTask setMaintainTypeDict(DictItem maintainTypeDict) {
			super.change(MAINTAIN_TYPE_DICT,super.getMaintainTypeDict(),maintainTypeDict);
			super.setMaintainTypeDict(maintainTypeDict);
			return this;
		}
		
		/**
		 * 设置 执行班组
		 * @param maintainGroup 执行班组
		 * @return 当前对象
		*/
		public MaintainTask setMaintainGroup(MaintainGroup maintainGroup) {
			super.change(MAINTAIN_GROUP,super.getMaintainGroup(),maintainGroup);
			super.setMaintainGroup(maintainGroup);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public MaintainTask setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executor 执行人
		 * @return 当前对象
		*/
		public MaintainTask setExecutor(Employee executor) {
			super.change(EXECUTOR,super.getExecutor(),executor);
			super.setExecutor(executor);
			return this;
		}
	}
}