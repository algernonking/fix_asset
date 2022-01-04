package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.Inventory;
import java.util.Date;
import com.dt.platform.domain.eam.InventoryAsset;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.pcm.Catalog;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-04 12:33:21
 * @sign F0F77F1296F86ABED8DF9228BB38A75F
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
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,BUSINESS_CODE, java.lang.String.class, "业务编码", "业务编码", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,OWNER_CODE, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 业务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 业务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,STATUS, java.lang.String.class, "业务状态", "业务状态", java.lang.String.class, null);
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,NAME, java.lang.String.class, "盘点名称", "盘点名称", java.lang.String.class, null);
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final String INVENTORY_STATUS="inventoryStatus";
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> INVENTORY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_STATUS, java.lang.String.class, "盘点状态", "盘点状态", java.lang.String.class, null);
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final String DATA_STATUS="dataStatus";
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> DATA_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,DATA_STATUS, java.lang.String.class, "数据状态", "数据状态", java.lang.String.class, null);
	
	/**
	 * 全员盘点 , 类型: java.lang.String
	*/
	public static final String ALL_EMPLOYEE="allEmployee";
	
	/**
	 * 全员盘点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> ALL_EMPLOYEE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,ALL_EMPLOYEE, java.lang.String.class, "全员盘点", "全员盘点", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String ASSET_STATUS="assetStatus";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,ASSET_STATUS, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
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
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,POSITION_ID, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_ID="warehouseId";
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> WAREHOUSE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,WAREHOUSE_ID, java.lang.String.class, "仓库", "仓库", java.lang.String.class, null);
	
	/**
	 * 购置开始日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_START_DATE="purchaseStartDate";
	
	/**
	 * 购置开始日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> PURCHASE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,PURCHASE_START_DATE, java.util.Date.class, "购置开始日期", "购置开始日期", java.util.Date.class, null);
	
	/**
	 * 购置结束日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_END_DATE="purchaseEndDate";
	
	/**
	 * 购置结束日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> PURCHASE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,PURCHASE_END_DATE, java.util.Date.class, "购置结束日期", "购置结束日期", java.util.Date.class, null);
	
	/**
	 * 盘点开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 盘点开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,START_TIME, java.util.Date.class, "盘点开始时间", "盘点开始时间", java.util.Date.class, null);
	
	/**
	 * 盘点结束时间 , 类型: java.util.Date
	*/
	public static final String FINISH_TIME="finishTime";
	
	/**
	 * 盘点结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.util.Date> FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,FINISH_TIME, java.util.Date.class, "盘点结束时间", "盘点结束时间", java.util.Date.class, null);
	
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
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,PLAN_ID, java.lang.String.class, "计划编号", "计划编号", java.lang.String.class, null);
	
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
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 盘点资产数据 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InventoryAsset
	*/
	public static final String INVENTORY_ASSET_INFO_LIST="InventoryAssetInfoList";
	
	/**
	 * 盘点资产数据 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InventoryAsset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,com.dt.platform.domain.eam.InventoryAsset> INVENTORY_ASSET_INFO_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_ASSET_INFO_LIST, java.util.List.class, "盘点资产数据", "盘点资产数据", com.dt.platform.domain.eam.InventoryAsset.class, null);
	
	/**
	 * 所属公司 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,OWNER_COMPANY, java.util.List.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,USE_ORGANIZATION, java.util.List.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String INVENTORY_USER="inventoryUser";
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,org.github.foxnic.web.domain.hrm.Employee> INVENTORY_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_USER, java.util.List.class, "盘点人员", "盘点人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_USER_IDS="inventoryUserIds";
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> INVENTORY_USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_USER_IDS, java.util.List.class, "盘点人员列表", "盘点人员列表", java.lang.String.class, null);
	
	/**
	 * 管理人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 管理人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,MANAGER, java.util.List.class, "管理人员", "管理人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 管理人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_MANAGER_IDS="inventoryManagerIds";
	
	/**
	 * 管理人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> INVENTORY_MANAGER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_MANAGER_IDS, java.util.List.class, "管理人列表", "管理人列表", java.lang.String.class, null);
	
	/**
	 * 负责人 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String DIRECTOR="director";
	
	/**
	 * 负责人 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,org.github.foxnic.web.domain.hrm.Employee> DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,DIRECTOR, java.util.List.class, "负责人", "负责人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 负责人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_DIRECTOR_IDS="inventoryDirectorIds";
	
	/**
	 * 负责人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> INVENTORY_DIRECTOR_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,INVENTORY_DIRECTOR_IDS, java.util.List.class, "负责人列表", "负责人列表", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,POSITION, java.util.List.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 存放位置Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * 存放位置Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> POSITION_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,POSITION_IDS, java.util.List.class, "存放位置Ids", "存放位置Ids", java.lang.String.class, null);
	
	/**
	 * 仓库 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE="warehouse";
	
	/**
	 * 仓库 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,WAREHOUSE, java.util.List.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 仓库Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_IDS="warehouseIds";
	
	/**
	 * 仓库Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> WAREHOUSE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,WAREHOUSE_IDS, java.util.List.class, "仓库Ids", "仓库Ids", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,CATEGORY, java.util.List.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CATEGORY_IDS="categoryIds";
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Inventory,java.lang.String> CATEGORY_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.Inventory.class ,CATEGORY_IDS, java.util.List.class, "资产分类Ids", "资产分类Ids", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , BUSINESS_CODE , OWNER_CODE , STATUS , NAME , INVENTORY_STATUS , DATA_STATUS , ALL_EMPLOYEE , ASSET_STATUS , CATEGORY_ID , OWN_COMPANY_ID , USE_ORGANIZATION_ID , POSITION_ID , WAREHOUSE_ID , PURCHASE_START_DATE , PURCHASE_END_DATE , START_TIME , FINISH_TIME , ORIGINATOR_ID , BUSINESS_DATE , NOTES , PLAN_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , INVENTORY_ASSET_INFO_LIST , OWNER_COMPANY , USE_ORGANIZATION , INVENTORY_USER , INVENTORY_USER_IDS , MANAGER , INVENTORY_MANAGER_IDS , DIRECTOR , INVENTORY_DIRECTOR_IDS , ORIGINATOR , POSITION , POSITION_IDS , WAREHOUSE , WAREHOUSE_IDS , CATEGORY , CATEGORY_IDS };
	
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
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public Inventory setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
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
		 * 设置 所属
		 * @param ownerCode 所属
		 * @return 当前对象
		*/
		public Inventory setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 业务状态
		 * @param status 业务状态
		 * @return 当前对象
		*/
		public Inventory setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
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
		 * 设置 盘点状态
		 * @param inventoryStatus 盘点状态
		 * @return 当前对象
		*/
		public Inventory setInventoryStatus(String inventoryStatus) {
			super.change(INVENTORY_STATUS,super.getInventoryStatus(),inventoryStatus);
			super.setInventoryStatus(inventoryStatus);
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
		 * 设置 全员盘点
		 * @param allEmployee 全员盘点
		 * @return 当前对象
		*/
		public Inventory setAllEmployee(String allEmployee) {
			super.change(ALL_EMPLOYEE,super.getAllEmployee(),allEmployee);
			super.setAllEmployee(allEmployee);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param assetStatus 资产状态
		 * @return 当前对象
		*/
		public Inventory setAssetStatus(String assetStatus) {
			super.change(ASSET_STATUS,super.getAssetStatus(),assetStatus);
			super.setAssetStatus(assetStatus);
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
		 * 设置 存放位置
		 * @param positionId 存放位置
		 * @return 当前对象
		*/
		public Inventory setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouseId 仓库
		 * @return 当前对象
		*/
		public Inventory setWarehouseId(String warehouseId) {
			super.change(WAREHOUSE_ID,super.getWarehouseId(),warehouseId);
			super.setWarehouseId(warehouseId);
			return this;
		}
		
		/**
		 * 设置 购置开始日期
		 * @param purchaseStartDate 购置开始日期
		 * @return 当前对象
		*/
		public Inventory setPurchaseStartDate(Date purchaseStartDate) {
			super.change(PURCHASE_START_DATE,super.getPurchaseStartDate(),purchaseStartDate);
			super.setPurchaseStartDate(purchaseStartDate);
			return this;
		}
		
		/**
		 * 设置 购置结束日期
		 * @param purchaseEndDate 购置结束日期
		 * @return 当前对象
		*/
		public Inventory setPurchaseEndDate(Date purchaseEndDate) {
			super.change(PURCHASE_END_DATE,super.getPurchaseEndDate(),purchaseEndDate);
			super.setPurchaseEndDate(purchaseEndDate);
			return this;
		}
		
		/**
		 * 设置 盘点开始时间
		 * @param startTime 盘点开始时间
		 * @return 当前对象
		*/
		public Inventory setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 盘点结束时间
		 * @param finishTime 盘点结束时间
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
		 * 设置 计划编号
		 * @param planId 计划编号
		 * @return 当前对象
		*/
		public Inventory setPlanId(String planId) {
			super.change(PLAN_ID,super.getPlanId(),planId);
			super.setPlanId(planId);
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
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Inventory setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 盘点资产数据
		 * @param InventoryAssetInfoList 盘点资产数据
		 * @return 当前对象
		*/
		public Inventory setInventoryAssetInfoList(List<InventoryAsset> InventoryAssetInfoList) {
			super.change(INVENTORY_ASSET_INFO_LIST,super.getInventoryAssetInfoList(),InventoryAssetInfoList);
			super.setInventoryAssetInfoList(InventoryAssetInfoList);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public Inventory setOwnerCompany(List<Organization> ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public Inventory setUseOrganization(List<Organization> useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 盘点人员
		 * @param inventoryUser 盘点人员
		 * @return 当前对象
		*/
		public Inventory setInventoryUser(List<Employee> inventoryUser) {
			super.change(INVENTORY_USER,super.getInventoryUser(),inventoryUser);
			super.setInventoryUser(inventoryUser);
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
		
		/**
		 * 设置 管理人员
		 * @param manager 管理人员
		 * @return 当前对象
		*/
		public Inventory setManager(List<Employee> manager) {
			super.change(MANAGER,super.getManager(),manager);
			super.setManager(manager);
			return this;
		}
		
		/**
		 * 设置 管理人列表
		 * @param inventoryManagerIds 管理人列表
		 * @return 当前对象
		*/
		public Inventory setInventoryManagerIds(List<String> inventoryManagerIds) {
			super.change(INVENTORY_MANAGER_IDS,super.getInventoryManagerIds(),inventoryManagerIds);
			super.setInventoryManagerIds(inventoryManagerIds);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param director 负责人
		 * @return 当前对象
		*/
		public Inventory setDirector(List<Employee> director) {
			super.change(DIRECTOR,super.getDirector(),director);
			super.setDirector(director);
			return this;
		}
		
		/**
		 * 设置 负责人列表
		 * @param inventoryDirectorIds 负责人列表
		 * @return 当前对象
		*/
		public Inventory setInventoryDirectorIds(List<String> inventoryDirectorIds) {
			super.change(INVENTORY_DIRECTOR_IDS,super.getInventoryDirectorIds(),inventoryDirectorIds);
			super.setInventoryDirectorIds(inventoryDirectorIds);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public Inventory setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param position 存放位置
		 * @return 当前对象
		*/
		public Inventory setPosition(List<Position> position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 存放位置Ids
		 * @param positionIds 存放位置Ids
		 * @return 当前对象
		*/
		public Inventory setPositionIds(List<String> positionIds) {
			super.change(POSITION_IDS,super.getPositionIds(),positionIds);
			super.setPositionIds(positionIds);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouse 仓库
		 * @return 当前对象
		*/
		public Inventory setWarehouse(List<Warehouse> warehouse) {
			super.change(WAREHOUSE,super.getWarehouse(),warehouse);
			super.setWarehouse(warehouse);
			return this;
		}
		
		/**
		 * 设置 仓库Ids
		 * @param warehouseIds 仓库Ids
		 * @return 当前对象
		*/
		public Inventory setWarehouseIds(List<String> warehouseIds) {
			super.change(WAREHOUSE_IDS,super.getWarehouseIds(),warehouseIds);
			super.setWarehouseIds(warehouseIds);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public Inventory setCategory(List<Catalog> category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 资产分类Ids
		 * @param categoryIds 资产分类Ids
		 * @return 当前对象
		*/
		public Inventory setCategoryIds(List<String> categoryIds) {
			super.change(CATEGORY_IDS,super.getCategoryIds(),categoryIds);
			super.setCategoryIds(categoryIds);
			return this;
		}
	}
}