package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InventoryVO;
import java.util.List;
import com.dt.platform.domain.eam.Inventory;
import java.util.Date;
import com.dt.platform.domain.eam.InventoryAsset;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.pcm.Catalog;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-03-26 19:25:56
 * @sign 98BD3C085215D4F9F4525FF653E71299
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InventoryVOMeta extends InventoryMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编码", "业务编码", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,OWNER_CODE, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 业务状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 业务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,STATUS, java.lang.String.class, "业务状态", "业务状态", java.lang.String.class, null);
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 盘点名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,NAME, java.lang.String.class, "盘点名称", "盘点名称", java.lang.String.class, null);
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final String INVENTORY_STATUS="inventoryStatus";
	
	/**
	 * 盘点状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> INVENTORY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_STATUS, java.lang.String.class, "盘点状态", "盘点状态", java.lang.String.class, null);
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final String DATA_STATUS="dataStatus";
	
	/**
	 * 数据状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> DATA_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,DATA_STATUS, java.lang.String.class, "数据状态", "数据状态", java.lang.String.class, null);
	
	/**
	 * 全员盘点 , 类型: java.lang.String
	*/
	public static final String ALL_EMPLOYEE="allEmployee";
	
	/**
	 * 全员盘点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> ALL_EMPLOYEE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,ALL_EMPLOYEE, java.lang.String.class, "全员盘点", "全员盘点", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String ASSET_STATUS="assetStatus";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,ASSET_STATUS, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,CATEGORY_ID, java.lang.String.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final String USE_ORGANIZATION_ID="useOrganizationId";
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> USE_ORGANIZATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,USE_ORGANIZATION_ID, java.lang.String.class, "使用公司/部门", "使用公司/部门", java.lang.String.class, null);
	
	/**
	 * 购置开始日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_START_DATE="purchaseStartDate";
	
	/**
	 * 购置开始日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> PURCHASE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,PURCHASE_START_DATE, java.util.Date.class, "购置开始日期", "购置开始日期", java.util.Date.class, null);
	
	/**
	 * 购置结束日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_END_DATE="purchaseEndDate";
	
	/**
	 * 购置结束日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> PURCHASE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,PURCHASE_END_DATE, java.util.Date.class, "购置结束日期", "购置结束日期", java.util.Date.class, null);
	
	/**
	 * 盘点开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 盘点开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,START_TIME, java.util.Date.class, "盘点开始时间", "盘点开始时间", java.util.Date.class, null);
	
	/**
	 * 盘点结束时间 , 类型: java.util.Date
	*/
	public static final String FINISH_TIME="finishTime";
	
	/**
	 * 盘点结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,FINISH_TIME, java.util.Date.class, "盘点结束时间", "盘点结束时间", java.util.Date.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,PLAN_ID, java.lang.String.class, "计划编号", "计划编号", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 盘点资产数据 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InventoryAsset
	*/
	public static final String INVENTORY_ASSET_INFO_LIST="inventoryAssetInfoList";
	
	/**
	 * 盘点资产数据 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InventoryAsset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,com.dt.platform.domain.eam.InventoryAsset> INVENTORY_ASSET_INFO_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_ASSET_INFO_LIST, java.util.List.class, "盘点资产数据", "盘点资产数据", com.dt.platform.domain.eam.InventoryAsset.class, null);
	
	/**
	 * 待盘点 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_NOT_COUNTED="inventoryAssetCountByNotCounted";
	
	/**
	 * 待盘点 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_NOT_COUNTED_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_ASSET_COUNT_BY_NOT_COUNTED, java.lang.Integer.class, "待盘点", "待盘点", java.lang.Integer.class, null);
	
	/**
	 * 已盘点 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_COUNTED="inventoryAssetCountByCounted";
	
	/**
	 * 已盘点 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_COUNTED_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_ASSET_COUNT_BY_COUNTED, java.lang.Integer.class, "已盘点", "已盘点", java.lang.Integer.class, null);
	
	/**
	 * 盘亏 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_LOSS="inventoryAssetCountByLoss";
	
	/**
	 * 盘亏 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_LOSS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_ASSET_COUNT_BY_LOSS, java.lang.Integer.class, "盘亏", "盘亏", java.lang.Integer.class, null);
	
	/**
	 * 盘盈 , 类型: java.lang.Integer
	*/
	public static final String INVENTORY_ASSET_COUNT_BY_SURPLUS="inventoryAssetCountBySurplus";
	
	/**
	 * 盘盈 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.Integer> INVENTORY_ASSET_COUNT_BY_SURPLUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_ASSET_COUNT_BY_SURPLUS, java.lang.Integer.class, "盘盈", "盘盈", java.lang.Integer.class, null);
	
	/**
	 * 所属公司 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,OWNER_COMPANY, java.util.List.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,USE_ORGANIZATION, java.util.List.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String INVENTORY_USER="inventoryUser";
	
	/**
	 * 盘点人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,org.github.foxnic.web.domain.hrm.Employee> INVENTORY_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_USER, java.util.List.class, "盘点人员", "盘点人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_USER_IDS="inventoryUserIds";
	
	/**
	 * 盘点人员列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> INVENTORY_USER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_USER_IDS, java.util.List.class, "盘点人员列表", "盘点人员列表", java.lang.String.class, null);
	
	/**
	 * 管理人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 管理人员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,MANAGER, java.util.List.class, "管理人员", "管理人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 管理人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_MANAGER_IDS="inventoryManagerIds";
	
	/**
	 * 管理人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> INVENTORY_MANAGER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_MANAGER_IDS, java.util.List.class, "管理人列表", "管理人列表", java.lang.String.class, null);
	
	/**
	 * 负责人 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String DIRECTOR="director";
	
	/**
	 * 负责人 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,org.github.foxnic.web.domain.hrm.Employee> DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,DIRECTOR, java.util.List.class, "负责人", "负责人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 负责人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INVENTORY_DIRECTOR_IDS="inventoryDirectorIds";
	
	/**
	 * 负责人列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> INVENTORY_DIRECTOR_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,INVENTORY_DIRECTOR_IDS, java.util.List.class, "负责人列表", "负责人列表", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,POSITION, java.util.List.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 存放位置Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * 存放位置Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> POSITION_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,POSITION_IDS, java.util.List.class, "存放位置Ids", "存放位置Ids", java.lang.String.class, null);
	
	/**
	 * 仓库 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE="warehouse";
	
	/**
	 * 仓库 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,WAREHOUSE, java.util.List.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 仓库Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_IDS="warehouseIds";
	
	/**
	 * 仓库Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> WAREHOUSE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,WAREHOUSE_IDS, java.util.List.class, "仓库Ids", "仓库Ids", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,CATEGORY, java.util.List.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CATEGORY_IDS="categoryIds";
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryVO,java.lang.String> CATEGORY_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryVO.class ,CATEGORY_IDS, java.util.List.class, "资产分类Ids", "资产分类Ids", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , TYPE , BUSINESS_CODE , OWNER_CODE , STATUS , NAME , INVENTORY_STATUS , DATA_STATUS , ALL_EMPLOYEE , ASSET_STATUS , CATEGORY_ID , OWN_COMPANY_ID , USE_ORGANIZATION_ID , PURCHASE_START_DATE , PURCHASE_END_DATE , START_TIME , FINISH_TIME , ORIGINATOR_ID , BUSINESS_DATE , NOTES , PLAN_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , INVENTORY_ASSET_INFO_LIST , INVENTORY_ASSET_COUNT_BY_NOT_COUNTED , INVENTORY_ASSET_COUNT_BY_COUNTED , INVENTORY_ASSET_COUNT_BY_LOSS , INVENTORY_ASSET_COUNT_BY_SURPLUS , OWNER_COMPANY , USE_ORGANIZATION , INVENTORY_USER , INVENTORY_USER_IDS , MANAGER , INVENTORY_MANAGER_IDS , DIRECTOR , INVENTORY_DIRECTOR_IDS , ORIGINATOR , POSITION , POSITION_IDS , WAREHOUSE , WAREHOUSE_IDS , CATEGORY , CATEGORY_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InventoryVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InventoryVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InventoryVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InventoryVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InventoryVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InventoryVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InventoryVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InventoryVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InventoryVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InventoryVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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
		 * @param inventoryAssetInfoList 盘点资产数据
		 * @return 当前对象
		*/
		public Inventory setInventoryAssetInfoList(List<InventoryAsset> inventoryAssetInfoList) {
			super.change(INVENTORY_ASSET_INFO_LIST,super.getInventoryAssetInfoList(),inventoryAssetInfoList);
			super.setInventoryAssetInfoList(inventoryAssetInfoList);
			return this;
		}
		
		/**
		 * 设置 待盘点
		 * @param inventoryAssetCountByNotCounted 待盘点
		 * @return 当前对象
		*/
		public Inventory setInventoryAssetCountByNotCounted(Integer inventoryAssetCountByNotCounted) {
			super.change(INVENTORY_ASSET_COUNT_BY_NOT_COUNTED,super.getInventoryAssetCountByNotCounted(),inventoryAssetCountByNotCounted);
			super.setInventoryAssetCountByNotCounted(inventoryAssetCountByNotCounted);
			return this;
		}
		
		/**
		 * 设置 已盘点
		 * @param inventoryAssetCountByCounted 已盘点
		 * @return 当前对象
		*/
		public Inventory setInventoryAssetCountByCounted(Integer inventoryAssetCountByCounted) {
			super.change(INVENTORY_ASSET_COUNT_BY_COUNTED,super.getInventoryAssetCountByCounted(),inventoryAssetCountByCounted);
			super.setInventoryAssetCountByCounted(inventoryAssetCountByCounted);
			return this;
		}
		
		/**
		 * 设置 盘亏
		 * @param inventoryAssetCountByLoss 盘亏
		 * @return 当前对象
		*/
		public Inventory setInventoryAssetCountByLoss(Integer inventoryAssetCountByLoss) {
			super.change(INVENTORY_ASSET_COUNT_BY_LOSS,super.getInventoryAssetCountByLoss(),inventoryAssetCountByLoss);
			super.setInventoryAssetCountByLoss(inventoryAssetCountByLoss);
			return this;
		}
		
		/**
		 * 设置 盘盈
		 * @param inventoryAssetCountBySurplus 盘盈
		 * @return 当前对象
		*/
		public Inventory setInventoryAssetCountBySurplus(Integer inventoryAssetCountBySurplus) {
			super.change(INVENTORY_ASSET_COUNT_BY_SURPLUS,super.getInventoryAssetCountBySurplus(),inventoryAssetCountBySurplus);
			super.setInventoryAssetCountBySurplus(inventoryAssetCountBySurplus);
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