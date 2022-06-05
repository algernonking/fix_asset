package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.RepairOrderAct;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.RepairOrder;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.RepairGroup;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 09:48:11
 * @sign 5502269C139752A1A1931008A4D3DDF1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RepairOrderActMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 申请单 , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 申请单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ORDER_ID, java.lang.String.class, "申请单", "申请单", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 维修班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 维修班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,GROUP_ID, java.lang.String.class, "维修班组", "维修班组", java.lang.String.class, null);
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final String EXECUTOR_ID="executorId";
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> EXECUTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,EXECUTOR_ID, java.lang.String.class, "执行人", "执行人", java.lang.String.class, null);
	
	/**
	 * 维修费用 , 类型: java.math.BigDecimal
	*/
	public static final String REPAIR_COST="repairCost";
	
	/**
	 * 维修费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.math.BigDecimal> REPAIR_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,REPAIR_COST, java.math.BigDecimal.class, "维修费用", "维修费用", java.math.BigDecimal.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,START_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 完成时间 , 类型: java.util.Date
	*/
	public static final String FINISH_TIME="finishTime";
	
	/**
	 * 完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.util.Date> FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,FINISH_TIME, java.util.Date.class, "完成时间", "完成时间", java.util.Date.class, null);
	
	/**
	 * 维修备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 维修备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,NOTES, java.lang.String.class, "维修备注", "维修备注", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 跟随验证 , 类型: java.lang.String
	*/
	public static final String WITH_ACCEPTANCE="withAcceptance";
	
	/**
	 * 跟随验证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> WITH_ACCEPTANCE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,WITH_ACCEPTANCE, java.lang.String.class, "跟随验证", "跟随验证", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 维修申请 , 类型: com.dt.platform.domain.eam.RepairOrder
	*/
	public static final String ORDER="order";
	
	/**
	 * 维修申请 , 类型: com.dt.platform.domain.eam.RepairOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,com.dt.platform.domain.eam.RepairOrder> ORDER_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ORDER, com.dt.platform.domain.eam.RepairOrder.class, "维修申请", "维修申请", com.dt.platform.domain.eam.RepairOrder.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EXECUTOR="executor";
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,org.github.foxnic.web.domain.hrm.Employee> EXECUTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,EXECUTOR, org.github.foxnic.web.domain.hrm.Employee.class, "执行人", "执行人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 维修班组 , 类型: com.dt.platform.domain.eam.RepairGroup
	*/
	public static final String REPAIR_GROUP="repairGroup";
	
	/**
	 * 维修班组 , 类型: com.dt.platform.domain.eam.RepairGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,com.dt.platform.domain.eam.RepairGroup> REPAIR_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,REPAIR_GROUP, com.dt.platform.domain.eam.RepairGroup.class, "维修班组", "维修班组", com.dt.platform.domain.eam.RepairGroup.class, null);
	
	/**
	 * 订单名称 , 类型: java.lang.String
	*/
	public static final String ORDER_NAME="orderName";
	
	/**
	 * 订单名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> ORDER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ORDER_NAME, java.lang.String.class, "订单名称", "订单名称", java.lang.String.class, null);
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final String ORDER_BUSINESS_CODE="orderBusinessCode";
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> ORDER_BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ORDER_BUSINESS_CODE, java.lang.String.class, "订单编号", "订单编号", java.lang.String.class, null);
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final String ORDER_REPAIR_STATUS="orderRepairStatus";
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAct,java.lang.String> ORDER_REPAIR_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAct.class ,ORDER_REPAIR_STATUS, java.lang.String.class, "维修状态", "维修状态", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_ID , BUSINESS_CODE , GROUP_ID , EXECUTOR_ID , REPAIR_COST , START_TIME , FINISH_TIME , NOTES , PICTURE_ID , ORIGINATOR_ID , WITH_ACCEPTANCE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , ORDER , ORIGINATOR , EXECUTOR , REPAIR_GROUP , ORDER_NAME , ORDER_BUSINESS_CODE , ORDER_REPAIR_STATUS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.RepairOrderAct {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RepairOrderAct setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 申请单
		 * @param orderId 申请单
		 * @return 当前对象
		*/
		public RepairOrderAct setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public RepairOrderAct setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 维修班组
		 * @param groupId 维修班组
		 * @return 当前对象
		*/
		public RepairOrderAct setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executorId 执行人
		 * @return 当前对象
		*/
		public RepairOrderAct setExecutorId(String executorId) {
			super.change(EXECUTOR_ID,super.getExecutorId(),executorId);
			super.setExecutorId(executorId);
			return this;
		}
		
		/**
		 * 设置 维修费用
		 * @param repairCost 维修费用
		 * @return 当前对象
		*/
		public RepairOrderAct setRepairCost(BigDecimal repairCost) {
			super.change(REPAIR_COST,super.getRepairCost(),repairCost);
			super.setRepairCost(repairCost);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startTime 开始时间
		 * @return 当前对象
		*/
		public RepairOrderAct setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 完成时间
		 * @param finishTime 完成时间
		 * @return 当前对象
		*/
		public RepairOrderAct setFinishTime(Date finishTime) {
			super.change(FINISH_TIME,super.getFinishTime(),finishTime);
			super.setFinishTime(finishTime);
			return this;
		}
		
		/**
		 * 设置 维修备注
		 * @param notes 维修备注
		 * @return 当前对象
		*/
		public RepairOrderAct setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public RepairOrderAct setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public RepairOrderAct setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 跟随验证
		 * @param withAcceptance 跟随验证
		 * @return 当前对象
		*/
		public RepairOrderAct setWithAcceptance(String withAcceptance) {
			super.change(WITH_ACCEPTANCE,super.getWithAcceptance(),withAcceptance);
			super.setWithAcceptance(withAcceptance);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RepairOrderAct setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RepairOrderAct setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RepairOrderAct setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RepairOrderAct setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RepairOrderAct setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RepairOrderAct setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RepairOrderAct setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public RepairOrderAct setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public RepairOrderAct setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public RepairOrderAct setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 维修申请
		 * @param order 维修申请
		 * @return 当前对象
		*/
		public RepairOrderAct setOrder(RepairOrder order) {
			super.change(ORDER,super.getOrder(),order);
			super.setOrder(order);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public RepairOrderAct setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executor 执行人
		 * @return 当前对象
		*/
		public RepairOrderAct setExecutor(Employee executor) {
			super.change(EXECUTOR,super.getExecutor(),executor);
			super.setExecutor(executor);
			return this;
		}
		
		/**
		 * 设置 维修班组
		 * @param repairGroup 维修班组
		 * @return 当前对象
		*/
		public RepairOrderAct setRepairGroup(RepairGroup repairGroup) {
			super.change(REPAIR_GROUP,super.getRepairGroup(),repairGroup);
			super.setRepairGroup(repairGroup);
			return this;
		}
		
		/**
		 * 设置 订单名称
		 * @param orderName 订单名称
		 * @return 当前对象
		*/
		public RepairOrderAct setOrderName(String orderName) {
			super.change(ORDER_NAME,super.getOrderName(),orderName);
			super.setOrderName(orderName);
			return this;
		}
		
		/**
		 * 设置 订单编号
		 * @param orderBusinessCode 订单编号
		 * @return 当前对象
		*/
		public RepairOrderAct setOrderBusinessCode(String orderBusinessCode) {
			super.change(ORDER_BUSINESS_CODE,super.getOrderBusinessCode(),orderBusinessCode);
			super.setOrderBusinessCode(orderBusinessCode);
			return this;
		}
		
		/**
		 * 设置 维修状态
		 * @param orderRepairStatus 维修状态
		 * @return 当前对象
		*/
		public RepairOrderAct setOrderRepairStatus(String orderRepairStatus) {
			super.change(ORDER_REPAIR_STATUS,super.getOrderRepairStatus(),orderRepairStatus);
			super.setOrderRepairStatus(orderRepairStatus);
			return this;
		}
	}
}