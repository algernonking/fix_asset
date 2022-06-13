package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionTaskVO;
import java.util.List;
import com.dt.platform.domain.eam.InspectionTask;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.InspectionGroup;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-13 21:10:48
 * @sign D2CF2B4F4AE8F3605D993E8E9A963E50
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionTaskVOMeta extends InspectionTaskMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 巡检计划 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 巡检计划 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PLAN_ID, java.lang.String.class, "巡检计划", "巡检计划", java.lang.String.class, null);
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String TASK_STATUS="taskStatus";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> TASK_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,TASK_STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 任务编号 , 类型: java.lang.String
	*/
	public static final String TASK_CODE="taskCode";
	
	/**
	 * 任务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> TASK_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,TASK_CODE, java.lang.String.class, "任务编号", "任务编号", java.lang.String.class, null);
	
	/**
	 * 巡检编码 , 类型: java.lang.String
	*/
	public static final String PLAN_CODE="planCode";
	
	/**
	 * 巡检编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> PLAN_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PLAN_CODE, java.lang.String.class, "巡检编码", "巡检编码", java.lang.String.class, null);
	
	/**
	 * 巡检名称 , 类型: java.lang.String
	*/
	public static final String PLAN_NAME="planName";
	
	/**
	 * 巡检名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> PLAN_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PLAN_NAME, java.lang.String.class, "巡检名称", "巡检名称", java.lang.String.class, null);
	
	/**
	 * 巡检顺序 , 类型: java.lang.String
	*/
	public static final String PLAN_INSPECTION_METHOD="planInspectionMethod";
	
	/**
	 * 巡检顺序 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> PLAN_INSPECTION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PLAN_INSPECTION_METHOD, java.lang.String.class, "巡检顺序", "巡检顺序", java.lang.String.class, null);
	
	/**
	 * 时间要求 , 类型: java.math.BigDecimal
	*/
	public static final String PLAN_COMPLETION_TIME="planCompletionTime";
	
	/**
	 * 时间要求 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.math.BigDecimal> PLAN_COMPLETION_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PLAN_COMPLETION_TIME, java.math.BigDecimal.class, "时间要求", "时间要求", java.math.BigDecimal.class, null);
	
	/**
	 * 巡检备注 , 类型: java.lang.String
	*/
	public static final String PLAN_NOTES="planNotes";
	
	/**
	 * 巡检备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> PLAN_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PLAN_NOTES, java.lang.String.class, "巡检备注", "巡检备注", java.lang.String.class, null);
	
	/**
	 * 巡检班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 巡检班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,GROUP_ID, java.lang.String.class, "巡检班组", "巡检班组", java.lang.String.class, null);
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final String EXECUTOR_ID="executorId";
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> EXECUTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,EXECUTOR_ID, java.lang.String.class, "执行人", "执行人", java.lang.String.class, null);
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final String PLAN_START_TIME="planStartTime";
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.util.Date> PLAN_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,PLAN_START_TIME, java.util.Date.class, "应开始时间", "应开始时间", java.util.Date.class, null);
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final String ACT_START_TIME="actStartTime";
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.util.Date> ACT_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,ACT_START_TIME, java.util.Date.class, "实际开始时间", "实际开始时间", java.util.Date.class, null);
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final String ACT_FINISH_TIME="actFinishTime";
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.util.Date> ACT_FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,ACT_FINISH_TIME, java.util.Date.class, "实际完成时间", "实际完成时间", java.util.Date.class, null);
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final String ACT_TOTAL_COST="actTotalCost";
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.math.BigDecimal> ACT_TOTAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,ACT_TOTAL_COST, java.math.BigDecimal.class, "实际工时", "实际工时", java.math.BigDecimal.class, null);
	
	/**
	 * 任务反馈 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 任务反馈 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,CONTENT, java.lang.String.class, "任务反馈", "任务反馈", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 计划 , 类型: com.dt.platform.domain.eam.InspectionPlan
	*/
	public static final String INSPECTION_PLAN="inspectionPlan";
	
	/**
	 * 计划 , 类型: com.dt.platform.domain.eam.InspectionPlan
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,com.dt.platform.domain.eam.InspectionPlan> INSPECTION_PLAN_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,INSPECTION_PLAN, com.dt.platform.domain.eam.InspectionPlan.class, "计划", "计划", com.dt.platform.domain.eam.InspectionPlan.class, null);
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionPoint
	*/
	public static final String INSPECTION_POINT_LIST="inspectionPointList";
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionPoint
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,com.dt.platform.domain.eam.InspectionPoint> INSPECTION_POINT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,INSPECTION_POINT_LIST, java.util.List.class, "巡检点", "巡检点", com.dt.platform.domain.eam.InspectionPoint.class, null);
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INSPECTION_POINT_IDS="inspectionPointIds";
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> INSPECTION_POINT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,INSPECTION_POINT_IDS, java.util.List.class, "巡检点", "巡检点", java.lang.String.class, null);
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionTaskPoint
	*/
	public static final String INSPECTION_TASK_POINT_LIST="inspectionTaskPointList";
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionTaskPoint
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,com.dt.platform.domain.eam.InspectionTaskPoint> INSPECTION_TASK_POINT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,INSPECTION_TASK_POINT_LIST, java.util.List.class, "任务巡检点", "任务巡检点", com.dt.platform.domain.eam.InspectionTaskPoint.class, null);
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INSPECTION_TASK_POINT_IDS="inspectionTaskPointIds";
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,java.lang.String> INSPECTION_TASK_POINT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,INSPECTION_TASK_POINT_IDS, java.util.List.class, "任务巡检点", "任务巡检点", java.lang.String.class, null);
	
	/**
	 * 时间 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TIME_DICT="timeDict";
	
	/**
	 * 时间 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,org.github.foxnic.web.domain.system.DictItem> TIME_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,TIME_DICT, org.github.foxnic.web.domain.system.DictItem.class, "时间", "时间", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INSPECTION_TYPE_DICT="inspectionTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,org.github.foxnic.web.domain.system.DictItem> INSPECTION_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,INSPECTION_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 班组 , 类型: com.dt.platform.domain.eam.InspectionGroup
	*/
	public static final String INSPECTION_GROUP="inspectionGroup";
	
	/**
	 * 班组 , 类型: com.dt.platform.domain.eam.InspectionGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,com.dt.platform.domain.eam.InspectionGroup> INSPECTION_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,INSPECTION_GROUP, com.dt.platform.domain.eam.InspectionGroup.class, "班组", "班组", com.dt.platform.domain.eam.InspectionGroup.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EXECUTOR="executor";
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskVO,org.github.foxnic.web.domain.hrm.Employee> EXECUTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskVO.class ,EXECUTOR, org.github.foxnic.web.domain.hrm.Employee.class, "执行人", "执行人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , PLAN_ID , TASK_STATUS , TASK_CODE , PLAN_CODE , PLAN_NAME , PLAN_INSPECTION_METHOD , PLAN_COMPLETION_TIME , PLAN_NOTES , GROUP_ID , EXECUTOR_ID , PLAN_START_TIME , ACT_START_TIME , ACT_FINISH_TIME , ACT_TOTAL_COST , CONTENT , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , SELECTED_CODE , INSPECTION_PLAN , INSPECTION_POINT_LIST , INSPECTION_POINT_IDS , INSPECTION_TASK_POINT_LIST , INSPECTION_TASK_POINT_IDS , TIME_DICT , INSPECTION_TYPE_DICT , INSPECTION_GROUP , ORIGINATOR , EXECUTOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionTaskVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InspectionTaskVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InspectionTaskVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InspectionTaskVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InspectionTaskVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InspectionTaskVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InspectionTaskVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InspectionTaskVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InspectionTaskVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InspectionTaskVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 巡检计划
		 * @param planId 巡检计划
		 * @return 当前对象
		*/
		public InspectionTask setPlanId(String planId) {
			super.change(PLAN_ID,super.getPlanId(),planId);
			super.setPlanId(planId);
			return this;
		}
		
		/**
		 * 设置 任务状态
		 * @param taskStatus 任务状态
		 * @return 当前对象
		*/
		public InspectionTask setTaskStatus(String taskStatus) {
			super.change(TASK_STATUS,super.getTaskStatus(),taskStatus);
			super.setTaskStatus(taskStatus);
			return this;
		}
		
		/**
		 * 设置 任务编号
		 * @param taskCode 任务编号
		 * @return 当前对象
		*/
		public InspectionTask setTaskCode(String taskCode) {
			super.change(TASK_CODE,super.getTaskCode(),taskCode);
			super.setTaskCode(taskCode);
			return this;
		}
		
		/**
		 * 设置 巡检编码
		 * @param planCode 巡检编码
		 * @return 当前对象
		*/
		public InspectionTask setPlanCode(String planCode) {
			super.change(PLAN_CODE,super.getPlanCode(),planCode);
			super.setPlanCode(planCode);
			return this;
		}
		
		/**
		 * 设置 巡检名称
		 * @param planName 巡检名称
		 * @return 当前对象
		*/
		public InspectionTask setPlanName(String planName) {
			super.change(PLAN_NAME,super.getPlanName(),planName);
			super.setPlanName(planName);
			return this;
		}
		
		/**
		 * 设置 巡检顺序
		 * @param planInspectionMethod 巡检顺序
		 * @return 当前对象
		*/
		public InspectionTask setPlanInspectionMethod(String planInspectionMethod) {
			super.change(PLAN_INSPECTION_METHOD,super.getPlanInspectionMethod(),planInspectionMethod);
			super.setPlanInspectionMethod(planInspectionMethod);
			return this;
		}
		
		/**
		 * 设置 时间要求
		 * @param planCompletionTime 时间要求
		 * @return 当前对象
		*/
		public InspectionTask setPlanCompletionTime(BigDecimal planCompletionTime) {
			super.change(PLAN_COMPLETION_TIME,super.getPlanCompletionTime(),planCompletionTime);
			super.setPlanCompletionTime(planCompletionTime);
			return this;
		}
		
		/**
		 * 设置 巡检备注
		 * @param planNotes 巡检备注
		 * @return 当前对象
		*/
		public InspectionTask setPlanNotes(String planNotes) {
			super.change(PLAN_NOTES,super.getPlanNotes(),planNotes);
			super.setPlanNotes(planNotes);
			return this;
		}
		
		/**
		 * 设置 巡检班组
		 * @param groupId 巡检班组
		 * @return 当前对象
		*/
		public InspectionTask setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executorId 执行人
		 * @return 当前对象
		*/
		public InspectionTask setExecutorId(String executorId) {
			super.change(EXECUTOR_ID,super.getExecutorId(),executorId);
			super.setExecutorId(executorId);
			return this;
		}
		
		/**
		 * 设置 应开始时间
		 * @param planStartTime 应开始时间
		 * @return 当前对象
		*/
		public InspectionTask setPlanStartTime(Date planStartTime) {
			super.change(PLAN_START_TIME,super.getPlanStartTime(),planStartTime);
			super.setPlanStartTime(planStartTime);
			return this;
		}
		
		/**
		 * 设置 实际开始时间
		 * @param actStartTime 实际开始时间
		 * @return 当前对象
		*/
		public InspectionTask setActStartTime(Date actStartTime) {
			super.change(ACT_START_TIME,super.getActStartTime(),actStartTime);
			super.setActStartTime(actStartTime);
			return this;
		}
		
		/**
		 * 设置 实际完成时间
		 * @param actFinishTime 实际完成时间
		 * @return 当前对象
		*/
		public InspectionTask setActFinishTime(Date actFinishTime) {
			super.change(ACT_FINISH_TIME,super.getActFinishTime(),actFinishTime);
			super.setActFinishTime(actFinishTime);
			return this;
		}
		
		/**
		 * 设置 实际工时
		 * @param actTotalCost 实际工时
		 * @return 当前对象
		*/
		public InspectionTask setActTotalCost(BigDecimal actTotalCost) {
			super.change(ACT_TOTAL_COST,super.getActTotalCost(),actTotalCost);
			super.setActTotalCost(actTotalCost);
			return this;
		}
		
		/**
		 * 设置 任务反馈
		 * @param content 任务反馈
		 * @return 当前对象
		*/
		public InspectionTask setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionTask setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public InspectionTask setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InspectionTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public InspectionTask setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 计划
		 * @param inspectionPlan 计划
		 * @return 当前对象
		*/
		public InspectionTask setInspectionPlan(InspectionPlan inspectionPlan) {
			super.change(INSPECTION_PLAN,super.getInspectionPlan(),inspectionPlan);
			super.setInspectionPlan(inspectionPlan);
			return this;
		}
		
		/**
		 * 设置 巡检点
		 * @param inspectionPointList 巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionPointList(List<InspectionPoint> inspectionPointList) {
			super.change(INSPECTION_POINT_LIST,super.getInspectionPointList(),inspectionPointList);
			super.setInspectionPointList(inspectionPointList);
			return this;
		}
		
		/**
		 * 设置 巡检点
		 * @param inspectionPointIds 巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionPointIds(List<String> inspectionPointIds) {
			super.change(INSPECTION_POINT_IDS,super.getInspectionPointIds(),inspectionPointIds);
			super.setInspectionPointIds(inspectionPointIds);
			return this;
		}
		
		/**
		 * 设置 任务巡检点
		 * @param inspectionTaskPointList 任务巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionTaskPointList(List<InspectionTaskPoint> inspectionTaskPointList) {
			super.change(INSPECTION_TASK_POINT_LIST,super.getInspectionTaskPointList(),inspectionTaskPointList);
			super.setInspectionTaskPointList(inspectionTaskPointList);
			return this;
		}
		
		/**
		 * 设置 任务巡检点
		 * @param inspectionTaskPointIds 任务巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionTaskPointIds(List<String> inspectionTaskPointIds) {
			super.change(INSPECTION_TASK_POINT_IDS,super.getInspectionTaskPointIds(),inspectionTaskPointIds);
			super.setInspectionTaskPointIds(inspectionTaskPointIds);
			return this;
		}
		
		/**
		 * 设置 时间
		 * @param timeDict 时间
		 * @return 当前对象
		*/
		public InspectionTask setTimeDict(DictItem timeDict) {
			super.change(TIME_DICT,super.getTimeDict(),timeDict);
			super.setTimeDict(timeDict);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param inspectionTypeDict 类型
		 * @return 当前对象
		*/
		public InspectionTask setInspectionTypeDict(DictItem inspectionTypeDict) {
			super.change(INSPECTION_TYPE_DICT,super.getInspectionTypeDict(),inspectionTypeDict);
			super.setInspectionTypeDict(inspectionTypeDict);
			return this;
		}
		
		/**
		 * 设置 班组
		 * @param inspectionGroup 班组
		 * @return 当前对象
		*/
		public InspectionTask setInspectionGroup(InspectionGroup inspectionGroup) {
			super.change(INSPECTION_GROUP,super.getInspectionGroup(),inspectionGroup);
			super.setInspectionGroup(inspectionGroup);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public InspectionTask setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executor 执行人
		 * @return 当前对象
		*/
		public InspectionTask setExecutor(Employee executor) {
			super.change(EXECUTOR,super.getExecutor(),executor);
			super.setExecutor(executor);
			return this;
		}
	}
}