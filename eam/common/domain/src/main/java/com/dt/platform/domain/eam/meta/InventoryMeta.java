package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.Inventory;
import java.util.Date;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.InventoryUser;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-24 20:00:02
 * @sign F1DBC8DB38389F930613D14FA1A07717
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InventoryMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,BUSINESS_CODE, java.lang.String.class, "业务编码", "业务编码", java.lang.String.class, null);
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,NAME, java.lang.String.class, "盘点名称", "盘点名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final String DATA_STATUS="dataStatus";
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> DATA_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,DATA_STATUS, java.lang.String.class, "数据状态", "数据状态", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,CATEGORY_ID, java.lang.String.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final String USE_ORGANIZATION_ID="useOrganizationId";
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> USE_ORGANIZATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,USE_ORGANIZATION_ID, java.lang.String.class, "使用公司/部门", "使用公司/部门", java.lang.String.class, null);
	
	/**
	 * 资产位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 资产位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,POSITION_ID, java.lang.String.class, "资产位置", "资产位置", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String DIRECTORY_ID="directoryId";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> DIRECTORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,DIRECTORY_ID, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,START_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String FINISH_TIME="finishTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,FINISH_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,POSITION, com.dt.platform.domain.eam.Position.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InventoryUser
	*/
	public static final String INVENTORY_USER_LIST="inventoryUserList";
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InventoryUser
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,com.dt.platform.domain.eam.InventoryUser> INVENTORY_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_USER_LIST, java.util.List.class, "盘点人员", "盘点人员", com.dt.platform.domain.eam.InventoryUser.class, null);
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_USER_IDS="inventoryUserIds";
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> INVENTORY_USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_USER_IDS, java.util.List.class, "盘点人员列表", "盘点人员列表", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , NAME , STATUS , DATA_STATUS , CATEGORY_ID , OWN_COMPANY_ID , USE_ORGANIZATION_ID , POSITION_ID , DIRECTORY_ID , START_TIME , FINISH_TIME , ORIGINATOR_ID , BUSINESS_DATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , POSITION , INVENTORY_USER_LIST , INVENTORY_USER_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.Inventory {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Inventory setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编码
		 * @param businessCode 业务编码
		 * @return 当前对象
		*/
		public Inventory setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 盘点名称
		 * @param name 盘点名称
		 * @return 当前对象
		*/
		public Inventory setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Inventory setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 数据状态
		 * @param dataStatus 数据状态
		 * @return 当前对象
		*/
		public Inventory setDataStatus(String dataStatus) {
			super.change(DATA_STATUS,super.getDataStatus(),dataStatus);
			super.setDataStatus(dataStatus);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param categoryId 资产分类
		 * @return 当前对象
		*/
		public Inventory setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownCompanyId 所属公司
		 * @return 当前对象
		*/
		public Inventory setOwnCompanyId(String ownCompanyId) {
			super.change(OWN_COMPANY_ID,super.getOwnCompanyId(),ownCompanyId);
			super.setOwnCompanyId(ownCompanyId);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganizationId 使用公司/部门
		 * @return 当前对象
		*/
		public Inventory setUseOrganizationId(String useOrganizationId) {
			super.change(USE_ORGANIZATION_ID,super.getUseOrganizationId(),useOrganizationId);
			super.setUseOrganizationId(useOrganizationId);
			return this;
		}
		
		/**
		 * 设置 资产位置
		 * @param positionId 资产位置
		 * @return 当前对象
		*/
		public Inventory setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param directoryId 负责人
		 * @return 当前对象
		*/
		public Inventory setDirectoryId(String directoryId) {
			super.change(DIRECTORY_ID,super.getDirectoryId(),directoryId);
			super.setDirectoryId(directoryId);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startTime 开始时间
		 * @return 当前对象
		*/
		public Inventory setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param finishTime 结束时间
		 * @return 当前对象
		*/
		public Inventory setFinishTime(Date finishTime) {
			super.change(FINISH_TIME,super.getFinishTime(),finishTime);
			super.setFinishTime(finishTime);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public Inventory setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public Inventory setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Inventory setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Inventory setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Inventory setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Inventory setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Inventory setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Inventory setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Inventory setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Inventory setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Inventory setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param position 存放位置
		 * @return 当前对象
		*/
		public Inventory setPosition(Position position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 盘点人员
		 * @param inventoryUserList 盘点人员
		 * @return 当前对象
		*/
		public Inventory setInventoryUserList(List<InventoryUser> inventoryUserList) {
			super.change(INVENTORY_USER_LIST,super.getInventoryUserList(),inventoryUserList);
			super.setInventoryUserList(inventoryUserList);
			return this;
		}
		
		/**
		 * 设置 盘点人员列表
		 * @param inventoryUserIds 盘点人员列表
		 * @return 当前对象
		*/
		public Inventory setInventoryUserIds(List<String> inventoryUserIds) {
			super.change(INVENTORY_USER_IDS,super.getInventoryUserIds(),inventoryUserIds);
			super.setInventoryUserIds(inventoryUserIds);
			return this;
		}
	}
}