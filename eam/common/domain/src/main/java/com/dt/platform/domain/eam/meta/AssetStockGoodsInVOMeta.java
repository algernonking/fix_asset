package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetStockGoodsInVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetStockGoodsIn;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.GoodsStock;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 21:20:17
 * @sign 67D0182CEA0E77C92313F8BA2C5DBE15
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetStockGoodsInVOMeta extends AssetStockGoodsInMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 库存所属 , 类型: java.lang.String
	*/
	public static final String OWNER_TYPE="ownerType";
	
	/**
	 * 库存所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> OWNER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,OWNER_TYPE, java.lang.String.class, "库存所属", "库存所属", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 单据名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 单据名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,NAME, java.lang.String.class, "单据名称", "单据名称", java.lang.String.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 入库类型 , 类型: java.lang.String
	*/
	public static final String STOCK_TYPE="stockType";
	
	/**
	 * 入库类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> STOCK_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,STOCK_TYPE, java.lang.String.class, "入库类型", "入库类型", java.lang.String.class, null);
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_ID="warehouseId";
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> WAREHOUSE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,WAREHOUSE_ID, java.lang.String.class, "仓库", "仓库", java.lang.String.class, null);
	
	/**
	 * 管理人 , 类型: java.lang.String
	*/
	public static final String MANAGER_ID="managerId";
	
	/**
	 * 管理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,MANAGER_ID, java.lang.String.class, "管理人", "管理人", java.lang.String.class, null);
	
	/**
	 * 接收人 , 类型: java.lang.String
	*/
	public static final String RECEIVER_USER_NAME="receiverUserName";
	
	/**
	 * 接收人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> RECEIVER_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,RECEIVER_USER_NAME, java.lang.String.class, "接收人", "接收人", java.lang.String.class, null);
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.math.BigDecimal> AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,AMOUNT, java.math.BigDecimal.class, "总金额", "总金额", java.math.BigDecimal.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_NAME="supplierName";
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SUPPLIER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SUPPLIER_NAME, java.lang.String.class, "供应商", "供应商", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 购置日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 购置日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.util.Date> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,PURCHASE_DATE, java.util.Date.class, "购置日期", "购置日期", java.util.Date.class, null);
	
	/**
	 * 业务时间 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,BUSINESS_DATE, java.util.Date.class, "业务时间", "业务时间", java.util.Date.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String CHS_TYPE="chsType";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> CHS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,CHS_TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String CHS_STATUS="chsStatus";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> CHS_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,CHS_STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final String CHS_VERSION="chsVersion";
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> CHS_VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,CHS_VERSION, java.lang.String.class, "变更版本号", "变更版本号", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String CHANGE_INSTANCE_ID="changeInstanceId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> CHANGE_INSTANCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,CHANGE_INSTANCE_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final String SUMMARY="summary";
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> SUMMARY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SUMMARY, java.lang.String.class, "流程概要", "流程概要", java.lang.String.class, null);
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_ID="latestApproverId";
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> LATEST_APPROVER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,LATEST_APPROVER_ID, java.lang.String.class, "最后审批人账户ID", "最后审批人账户ID", java.lang.String.class, null);
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_NAME="latestApproverName";
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> LATEST_APPROVER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,LATEST_APPROVER_NAME, java.lang.String.class, "最后审批人姓名", "最后审批人姓名", java.lang.String.class, null);
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_IDS="nextApproverIds";
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> NEXT_APPROVER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,NEXT_APPROVER_IDS, java.lang.String.class, "下一节点审批人", "下一节点审批人", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_NAMES="nextApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> NEXT_APPROVER_NAMES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,NEXT_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_OPINION="approvalOpinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> APPROVAL_OPINION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,APPROVAL_OPINION, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 物品 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final String GOOD_STOCK_LIST="goodStockList";
	
	/**
	 * 物品 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,com.dt.platform.domain.eam.GoodsStock> GOOD_STOCK_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,GOOD_STOCK_LIST, java.util.List.class, "物品", "物品", com.dt.platform.domain.eam.GoodsStock.class, null);
	
	/**
	 * 物品 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String GOOD_STOCK_IDS="goodStockIds";
	
	/**
	 * 物品 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> GOOD_STOCK_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,GOOD_STOCK_IDS, java.util.List.class, "物品", "物品", java.lang.String.class, null);
	
	/**
	 * 物品 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final String GOOD_STOCK_TMP_LIST="goodStockTmpList";
	
	/**
	 * 物品 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,com.dt.platform.domain.eam.GoodsStock> GOOD_STOCK_TMP_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,GOOD_STOCK_TMP_LIST, java.util.List.class, "物品", "物品", com.dt.platform.domain.eam.GoodsStock.class, null);
	
	/**
	 * 物品 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String GOOD_STOCK_TMP_IDS="goodStockTmpIds";
	
	/**
	 * 物品 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,java.lang.String> GOOD_STOCK_TMP_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,GOOD_STOCK_TMP_IDS, java.util.List.class, "物品", "物品", java.lang.String.class, null);
	
	/**
	 * 入库类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String STOCK_TYPE_DICT="stockTypeDict";
	
	/**
	 * 入库类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,org.github.foxnic.web.domain.system.DictItem> STOCK_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,STOCK_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "入库类型", "入库类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,OWNER_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE="warehouse";
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,WAREHOUSE, com.dt.platform.domain.eam.Warehouse.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,org.github.foxnic.web.domain.system.DictItem> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,SOURCE, org.github.foxnic.web.domain.system.DictItem.class, "来源", "来源", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 管理人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 管理人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsInVO,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsInVO.class ,MANAGER, org.github.foxnic.web.domain.hrm.Employee.class, "管理人", "管理人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , OWNER_TYPE , BUSINESS_CODE , PROC_ID , STATUS , NAME , BATCH_CODE , STOCK_TYPE , WAREHOUSE_ID , MANAGER_ID , RECEIVER_USER_NAME , AMOUNT , OWN_COMPANY_ID , SUPPLIER_NAME , SOURCE_ID , PURCHASE_DATE , BUSINESS_DATE , ATTACH_ID , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , GOOD_STOCK_LIST , GOOD_STOCK_IDS , GOOD_STOCK_TMP_LIST , GOOD_STOCK_TMP_IDS , STOCK_TYPE_DICT , OWNER_COMPANY , USE_ORGANIZATION , WAREHOUSE , SOURCE , ORIGINATOR , MANAGER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetStockGoodsInVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetStockGoodsInVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 库存所属
		 * @param ownerType 库存所属
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setOwnerType(String ownerType) {
			super.change(OWNER_TYPE,super.getOwnerType(),ownerType);
			super.setOwnerType(ownerType);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 单据名称
		 * @param name 单据名称
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchCode 批次号
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 入库类型
		 * @param stockType 入库类型
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setStockType(String stockType) {
			super.change(STOCK_TYPE,super.getStockType(),stockType);
			super.setStockType(stockType);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouseId 仓库
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setWarehouseId(String warehouseId) {
			super.change(WAREHOUSE_ID,super.getWarehouseId(),warehouseId);
			super.setWarehouseId(warehouseId);
			return this;
		}
		
		/**
		 * 设置 管理人
		 * @param managerId 管理人
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setManagerId(String managerId) {
			super.change(MANAGER_ID,super.getManagerId(),managerId);
			super.setManagerId(managerId);
			return this;
		}
		
		/**
		 * 设置 接收人
		 * @param receiverUserName 接收人
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setReceiverUserName(String receiverUserName) {
			super.change(RECEIVER_USER_NAME,super.getReceiverUserName(),receiverUserName);
			super.setReceiverUserName(receiverUserName);
			return this;
		}
		
		/**
		 * 设置 总金额
		 * @param amount 总金额
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setAmount(BigDecimal amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownCompanyId 所属公司
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setOwnCompanyId(String ownCompanyId) {
			super.change(OWN_COMPANY_ID,super.getOwnCompanyId(),ownCompanyId);
			super.setOwnCompanyId(ownCompanyId);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplierName 供应商
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setSupplierName(String supplierName) {
			super.change(SUPPLIER_NAME,super.getSupplierName(),supplierName);
			super.setSupplierName(supplierName);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceId 来源
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 购置日期
		 * @param purchaseDate 购置日期
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setPurchaseDate(Date purchaseDate) {
			super.change(PURCHASE_DATE,super.getPurchaseDate(),purchaseDate);
			super.setPurchaseDate(purchaseDate);
			return this;
		}
		
		/**
		 * 设置 业务时间
		 * @param businessDate 业务时间
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attachId 附件
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param chsType 变更类型
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setChsType(String chsType) {
			super.change(CHS_TYPE,super.getChsType(),chsType);
			super.setChsType(chsType);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param chsStatus 变更状态
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setChsStatus(String chsStatus) {
			super.change(CHS_STATUS,super.getChsStatus(),chsStatus);
			super.setChsStatus(chsStatus);
			return this;
		}
		
		/**
		 * 设置 变更版本号
		 * @param chsVersion 变更版本号
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setChsVersion(String chsVersion) {
			super.change(CHS_VERSION,super.getChsVersion(),chsVersion);
			super.setChsVersion(chsVersion);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param changeInstanceId 变更ID
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setChangeInstanceId(String changeInstanceId) {
			super.change(CHANGE_INSTANCE_ID,super.getChangeInstanceId(),changeInstanceId);
			super.setChangeInstanceId(changeInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param summary 流程概要
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setSummary(String summary) {
			super.change(SUMMARY,super.getSummary(),summary);
			super.setSummary(summary);
			return this;
		}
		
		/**
		 * 设置 最后审批人账户ID
		 * @param latestApproverId 最后审批人账户ID
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setLatestApproverId(String latestApproverId) {
			super.change(LATEST_APPROVER_ID,super.getLatestApproverId(),latestApproverId);
			super.setLatestApproverId(latestApproverId);
			return this;
		}
		
		/**
		 * 设置 最后审批人姓名
		 * @param latestApproverName 最后审批人姓名
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setLatestApproverName(String latestApproverName) {
			super.change(LATEST_APPROVER_NAME,super.getLatestApproverName(),latestApproverName);
			super.setLatestApproverName(latestApproverName);
			return this;
		}
		
		/**
		 * 设置 下一节点审批人
		 * @param nextApproverIds 下一节点审批人
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setNextApproverIds(String nextApproverIds) {
			super.change(NEXT_APPROVER_IDS,super.getNextApproverIds(),nextApproverIds);
			super.setNextApproverIds(nextApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param nextApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setNextApproverNames(String nextApproverNames) {
			super.change(NEXT_APPROVER_NAMES,super.getNextApproverNames(),nextApproverNames);
			super.setNextApproverNames(nextApproverNames);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalOpinion 审批意见
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setApprovalOpinion(String approvalOpinion) {
			super.change(APPROVAL_OPINION,super.getApprovalOpinion(),approvalOpinion);
			super.setApprovalOpinion(approvalOpinion);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodStockList 物品
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setGoodStockList(List<GoodsStock> goodStockList) {
			super.change(GOOD_STOCK_LIST,super.getGoodStockList(),goodStockList);
			super.setGoodStockList(goodStockList);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodStockIds 物品
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setGoodStockIds(List<String> goodStockIds) {
			super.change(GOOD_STOCK_IDS,super.getGoodStockIds(),goodStockIds);
			super.setGoodStockIds(goodStockIds);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodStockTmpList 物品
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setGoodStockTmpList(List<GoodsStock> goodStockTmpList) {
			super.change(GOOD_STOCK_TMP_LIST,super.getGoodStockTmpList(),goodStockTmpList);
			super.setGoodStockTmpList(goodStockTmpList);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodStockTmpIds 物品
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setGoodStockTmpIds(List<String> goodStockTmpIds) {
			super.change(GOOD_STOCK_TMP_IDS,super.getGoodStockTmpIds(),goodStockTmpIds);
			super.setGoodStockTmpIds(goodStockTmpIds);
			return this;
		}
		
		/**
		 * 设置 入库类型
		 * @param stockTypeDict 入库类型
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setStockTypeDict(DictItem stockTypeDict) {
			super.change(STOCK_TYPE_DICT,super.getStockTypeDict(),stockTypeDict);
			super.setStockTypeDict(stockTypeDict);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setOwnerCompany(Organization ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouse 仓库
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setWarehouse(Warehouse warehouse) {
			super.change(WAREHOUSE,super.getWarehouse(),warehouse);
			super.setWarehouse(warehouse);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setSource(DictItem source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 管理人
		 * @param manager 管理人
		 * @return 当前对象
		*/
		public AssetStockGoodsIn setManager(Employee manager) {
			super.change(MANAGER,super.getManager(),manager);
			super.setManager(manager);
			return this;
		}
	}
}