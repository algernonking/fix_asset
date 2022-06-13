package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import java.util.Date;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.domain.eam.InspectionTask;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-14 06:28:14
 * @sign 60EBB7903698DDDA12764F1264B2A7D8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionTaskPointMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,TASK_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final String POINT_STATUS="pointStatus";
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_STATUS, java.lang.String.class, "巡检状态", "巡检状态", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,CONTENT, java.lang.String.class, "巡检结果", "巡检结果", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String POINT_CODE="pointCode";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String POINT_NAME="pointName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 巡检内容 , 类型: java.lang.String
	*/
	public static final String POINT_CONTENT="pointContent";
	
	/**
	 * 巡检内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_CONTENT, java.lang.String.class, "巡检内容", "巡检内容", java.lang.String.class, null);
	
	/**
	 * 巡检路线 , 类型: java.lang.String
	*/
	public static final String POINT_ROUTE_ID="pointRouteId";
	
	/**
	 * 巡检路线 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_ROUTE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_ROUTE_ID, java.lang.String.class, "巡检路线", "巡检路线", java.lang.String.class, null);
	
	/**
	 * RFID , 类型: java.lang.String
	*/
	public static final String POINT_RFID="pointRfid";
	
	/**
	 * RFID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_RFID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_RFID, java.lang.String.class, "RFID", "RFID", java.lang.String.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String POINT_POS="pointPos";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_POS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_POS, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 位置经度 , 类型: java.lang.String
	*/
	public static final String POINT_POS_LONGITUDE="pointPosLongitude";
	
	/**
	 * 位置经度 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_POS_LONGITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_POS_LONGITUDE, java.lang.String.class, "位置经度", "位置经度", java.lang.String.class, null);
	
	/**
	 * 位置纬度 , 类型: java.lang.String
	*/
	public static final String POINT_POS_LATITUDE="pointPosLatitude";
	
	/**
	 * 位置纬度 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_POS_LATITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_POS_LATITUDE, java.lang.String.class, "位置纬度", "位置纬度", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String POINT_NOTES="pointNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> POINT_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,POINT_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_ID="operId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> OPER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,OPER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * route , 类型: com.dt.platform.domain.eam.InspectionRoute
	*/
	public static final String ROUTE="route";
	
	/**
	 * route , 类型: com.dt.platform.domain.eam.InspectionRoute
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,com.dt.platform.domain.eam.InspectionRoute> ROUTE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,ROUTE, com.dt.platform.domain.eam.InspectionRoute.class, "route", "route", com.dt.platform.domain.eam.InspectionRoute.class, null);
	
	/**
	 * task , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final String TASK="task";
	
	/**
	 * task , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPoint,com.dt.platform.domain.eam.InspectionTask> TASK_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPoint.class ,TASK, com.dt.platform.domain.eam.InspectionTask.class, "task", "task", com.dt.platform.domain.eam.InspectionTask.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , STATUS , POINT_STATUS , OPER_TIME , CONTENT , POINT_CODE , POINT_NAME , POINT_CONTENT , POINT_ROUTE_ID , POINT_RFID , POINT_POS , POINT_POS_LONGITUDE , POINT_POS_LATITUDE , POINT_NOTES , SORT , OPER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , SELECTED_CODE , VERSION , ROUTE , TASK };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionTaskPoint {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionTaskPoint setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param taskId 任务
		 * @return 当前对象
		*/
		public InspectionTaskPoint setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public InspectionTaskPoint setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 巡检状态
		 * @param pointStatus 巡检状态
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointStatus(String pointStatus) {
			super.change(POINT_STATUS,super.getPointStatus(),pointStatus);
			super.setPointStatus(pointStatus);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operTime 操作时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 巡检结果
		 * @param content 巡检结果
		 * @return 当前对象
		*/
		public InspectionTaskPoint setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param pointCode 编码
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointCode(String pointCode) {
			super.change(POINT_CODE,super.getPointCode(),pointCode);
			super.setPointCode(pointCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param pointName 名称
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointName(String pointName) {
			super.change(POINT_NAME,super.getPointName(),pointName);
			super.setPointName(pointName);
			return this;
		}
		
		/**
		 * 设置 巡检内容
		 * @param pointContent 巡检内容
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointContent(String pointContent) {
			super.change(POINT_CONTENT,super.getPointContent(),pointContent);
			super.setPointContent(pointContent);
			return this;
		}
		
		/**
		 * 设置 巡检路线
		 * @param pointRouteId 巡检路线
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointRouteId(String pointRouteId) {
			super.change(POINT_ROUTE_ID,super.getPointRouteId(),pointRouteId);
			super.setPointRouteId(pointRouteId);
			return this;
		}
		
		/**
		 * 设置 RFID
		 * @param pointRfid RFID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointRfid(String pointRfid) {
			super.change(POINT_RFID,super.getPointRfid(),pointRfid);
			super.setPointRfid(pointRfid);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param pointPos 位置
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointPos(String pointPos) {
			super.change(POINT_POS,super.getPointPos(),pointPos);
			super.setPointPos(pointPos);
			return this;
		}
		
		/**
		 * 设置 位置经度
		 * @param pointPosLongitude 位置经度
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointPosLongitude(String pointPosLongitude) {
			super.change(POINT_POS_LONGITUDE,super.getPointPosLongitude(),pointPosLongitude);
			super.setPointPosLongitude(pointPosLongitude);
			return this;
		}
		
		/**
		 * 设置 位置纬度
		 * @param pointPosLatitude 位置纬度
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointPosLatitude(String pointPosLatitude) {
			super.change(POINT_POS_LATITUDE,super.getPointPosLatitude(),pointPosLatitude);
			super.setPointPosLatitude(pointPosLatitude);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param pointNotes 备注
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointNotes(String pointNotes) {
			super.change(POINT_NOTES,super.getPointNotes(),pointNotes);
			super.setPointNotes(pointNotes);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public InspectionTaskPoint setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operId 操作人
		 * @return 当前对象
		*/
		public InspectionTaskPoint setOperId(String operId) {
			super.change(OPER_ID,super.getOperId(),operId);
			super.setOperId(operId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionTaskPoint setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionTaskPoint setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InspectionTaskPoint setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public InspectionTaskPoint setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionTaskPoint setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 route
		 * @param route route
		 * @return 当前对象
		*/
		public InspectionTaskPoint setRoute(InspectionRoute route) {
			super.change(ROUTE,super.getRoute(),route);
			super.setRoute(route);
			return this;
		}
		
		/**
		 * 设置 task
		 * @param task task
		 * @return 当前对象
		*/
		public InspectionTaskPoint setTask(InspectionTask task) {
			super.change(TASK,super.getTask(),task);
			super.setTask(task);
			return this;
		}
	}
}