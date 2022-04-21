package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetStockGoodsVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetStockGoods;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.GoodsStock;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.system.DictItem;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 17:52:46
 * @sign 7D4339BF417666EEADF8D5E7912310EF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetStockGoodsVOMeta extends AssetStockGoodsMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 库存所属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 库存所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,OWNER_CODE, java.lang.String.class, "库存所属", "库存所属", java.lang.String.class, null);
	
	/**
	 * 所属类型 , 类型: java.lang.String
	*/
	public static final String OWNER_TYPE="ownerType";
	
	/**
	 * 所属类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> OWNER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,OWNER_TYPE, java.lang.String.class, "所属类型", "所属类型", java.lang.String.class, null);
	
	/**
	 * 库存类型 , 类型: java.lang.String
	*/
	public static final String STOCK_TYPE="stockType";
	
	/**
	 * 库存类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> STOCK_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,STOCK_TYPE, java.lang.String.class, "库存类型", "库存类型", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String STOCK_BATCH_CODE="stockBatchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> STOCK_BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,STOCK_BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 物品 , 类型: java.lang.String
	*/
	public static final String GOODS_ID="goodsId";
	
	/**
	 * 物品 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> GOODS_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS_ID, java.lang.String.class, "物品", "物品", java.lang.String.class, null);
	
	/**
	 * 入库存数量 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_IN_NUMBER="stockInNumber";
	
	/**
	 * 入库存数量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.math.BigDecimal> STOCK_IN_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,STOCK_IN_NUMBER, java.math.BigDecimal.class, "入库存数量", "入库存数量", java.math.BigDecimal.class, null);
	
	/**
	 * 当前库存数量 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_CUR_NUMBER="stockCurNumber";
	
	/**
	 * 当前库存数量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.math.BigDecimal> STOCK_CUR_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,STOCK_CUR_NUMBER, java.math.BigDecimal.class, "当前库存数量", "当前库存数量", java.math.BigDecimal.class, null);
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final String UNIT_PRICE="unitPrice";
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.math.BigDecimal> UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,UNIT_PRICE, java.math.BigDecimal.class, "单价", "单价", java.math.BigDecimal.class, null);
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.math.BigDecimal> AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,AMOUNT, java.math.BigDecimal.class, "总金额", "总金额", java.math.BigDecimal.class, null);
	
	/**
	 * 资产供应商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_ID="supplierId";
	
	/**
	 * 资产供应商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> SUPPLIER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SUPPLIER_ID, java.lang.String.class, "资产供应商", "资产供应商", java.lang.String.class, null);
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_ID="warehouseId";
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> WAREHOUSE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,WAREHOUSE_ID, java.lang.String.class, "仓库", "仓库", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,USE_ORG_ID, java.lang.String.class, "所属组织", "所属组织", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 物品 , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final String GOODS="goods";
	
	/**
	 * 物品 , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,com.dt.platform.domain.eam.GoodsStock> GOODS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS, com.dt.platform.domain.eam.GoodsStock.class, "物品", "物品", com.dt.platform.domain.eam.GoodsStock.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final String SUPPLIER="supplier";
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,com.dt.platform.domain.eam.Supplier> SUPPLIER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SUPPLIER, com.dt.platform.domain.eam.Supplier.class, "供应商", "供应商", com.dt.platform.domain.eam.Supplier.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,OWNER_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE="warehouse";
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,WAREHOUSE, com.dt.platform.domain.eam.Warehouse.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,org.github.foxnic.web.domain.system.DictItem> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,SOURCE, org.github.foxnic.web.domain.system.DictItem.class, "来源", "来源", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String GOODS_MODEL="goodsModel";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> GOODS_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS_MODEL, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String GOODS_NAME="goodsName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> GOODS_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String GOODS_CATEGORY_NAME="goodsCategoryName";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> GOODS_CATEGORY_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS_CATEGORY_NAME, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 计算单位 , 类型: java.lang.String
	*/
	public static final String GOODS_UNIT="goodsUnit";
	
	/**
	 * 计算单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> GOODS_UNIT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS_UNIT, java.lang.String.class, "计算单位", "计算单位", java.lang.String.class, null);
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final String GOODS_CODE="goodsCode";
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> GOODS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS_CODE, java.lang.String.class, "物品编码", "物品编码", java.lang.String.class, null);
	
	/**
	 * 物品条码 , 类型: java.lang.String
	*/
	public static final String GOODS_BAR_CODE="goodsBarCode";
	
	/**
	 * 物品条码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsVO,java.lang.String> GOODS_BAR_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsVO.class ,GOODS_BAR_CODE, java.lang.String.class, "物品条码", "物品条码", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , OWNER_CODE , OWNER_TYPE , STOCK_TYPE , BUSINESS_CODE , STOCK_BATCH_CODE , SOURCE_ID , GOODS_ID , STOCK_IN_NUMBER , STOCK_CUR_NUMBER , UNIT_PRICE , AMOUNT , SUPPLIER_ID , WAREHOUSE_ID , OWN_COMPANY_ID , NOTES , USE_ORG_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , GOODS , ORIGINATOR , SUPPLIER , OWNER_COMPANY , USE_ORGANIZATION , WAREHOUSE , SOURCE , GOODS_MODEL , GOODS_NAME , GOODS_CATEGORY_NAME , GOODS_UNIT , GOODS_CODE , GOODS_BAR_CODE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetStockGoodsVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetStockGoodsVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetStockGoods setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 库存所属
		 * @param ownerCode 库存所属
		 * @return 当前对象
		*/
		public AssetStockGoods setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 所属类型
		 * @param ownerType 所属类型
		 * @return 当前对象
		*/
		public AssetStockGoods setOwnerType(String ownerType) {
			super.change(OWNER_TYPE,super.getOwnerType(),ownerType);
			super.setOwnerType(ownerType);
			return this;
		}
		
		/**
		 * 设置 库存类型
		 * @param stockType 库存类型
		 * @return 当前对象
		*/
		public AssetStockGoods setStockType(String stockType) {
			super.change(STOCK_TYPE,super.getStockType(),stockType);
			super.setStockType(stockType);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetStockGoods setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param stockBatchCode 批次号
		 * @return 当前对象
		*/
		public AssetStockGoods setStockBatchCode(String stockBatchCode) {
			super.change(STOCK_BATCH_CODE,super.getStockBatchCode(),stockBatchCode);
			super.setStockBatchCode(stockBatchCode);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceId 来源
		 * @return 当前对象
		*/
		public AssetStockGoods setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodsId 物品
		 * @return 当前对象
		*/
		public AssetStockGoods setGoodsId(String goodsId) {
			super.change(GOODS_ID,super.getGoodsId(),goodsId);
			super.setGoodsId(goodsId);
			return this;
		}
		
		/**
		 * 设置 入库存数量
		 * @param stockInNumber 入库存数量
		 * @return 当前对象
		*/
		public AssetStockGoods setStockInNumber(BigDecimal stockInNumber) {
			super.change(STOCK_IN_NUMBER,super.getStockInNumber(),stockInNumber);
			super.setStockInNumber(stockInNumber);
			return this;
		}
		
		/**
		 * 设置 当前库存数量
		 * @param stockCurNumber 当前库存数量
		 * @return 当前对象
		*/
		public AssetStockGoods setStockCurNumber(BigDecimal stockCurNumber) {
			super.change(STOCK_CUR_NUMBER,super.getStockCurNumber(),stockCurNumber);
			super.setStockCurNumber(stockCurNumber);
			return this;
		}
		
		/**
		 * 设置 单价
		 * @param unitPrice 单价
		 * @return 当前对象
		*/
		public AssetStockGoods setUnitPrice(BigDecimal unitPrice) {
			super.change(UNIT_PRICE,super.getUnitPrice(),unitPrice);
			super.setUnitPrice(unitPrice);
			return this;
		}
		
		/**
		 * 设置 总金额
		 * @param amount 总金额
		 * @return 当前对象
		*/
		public AssetStockGoods setAmount(BigDecimal amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 资产供应商
		 * @param supplierId 资产供应商
		 * @return 当前对象
		*/
		public AssetStockGoods setSupplierId(String supplierId) {
			super.change(SUPPLIER_ID,super.getSupplierId(),supplierId);
			super.setSupplierId(supplierId);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouseId 仓库
		 * @return 当前对象
		*/
		public AssetStockGoods setWarehouseId(String warehouseId) {
			super.change(WAREHOUSE_ID,super.getWarehouseId(),warehouseId);
			super.setWarehouseId(warehouseId);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownCompanyId 所属公司
		 * @return 当前对象
		*/
		public AssetStockGoods setOwnCompanyId(String ownCompanyId) {
			super.change(OWN_COMPANY_ID,super.getOwnCompanyId(),ownCompanyId);
			super.setOwnCompanyId(ownCompanyId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetStockGoods setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 所属组织
		 * @param useOrgId 所属组织
		 * @return 当前对象
		*/
		public AssetStockGoods setUseOrgId(String useOrgId) {
			super.change(USE_ORG_ID,super.getUseOrgId(),useOrgId);
			super.setUseOrgId(useOrgId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetStockGoods setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetStockGoods setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetStockGoods setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetStockGoods setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetStockGoods setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetStockGoods setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetStockGoods setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetStockGoods setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetStockGoods setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetStockGoods setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public AssetStockGoods setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goods 物品
		 * @return 当前对象
		*/
		public AssetStockGoods setGoods(GoodsStock goods) {
			super.change(GOODS,super.getGoods(),goods);
			super.setGoods(goods);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetStockGoods setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplier 供应商
		 * @return 当前对象
		*/
		public AssetStockGoods setSupplier(Supplier supplier) {
			super.change(SUPPLIER,super.getSupplier(),supplier);
			super.setSupplier(supplier);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public AssetStockGoods setOwnerCompany(Organization ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public AssetStockGoods setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouse 仓库
		 * @return 当前对象
		*/
		public AssetStockGoods setWarehouse(Warehouse warehouse) {
			super.change(WAREHOUSE,super.getWarehouse(),warehouse);
			super.setWarehouse(warehouse);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public AssetStockGoods setSource(DictItem source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param goodsModel 类型
		 * @return 当前对象
		*/
		public AssetStockGoods setGoodsModel(String goodsModel) {
			super.change(GOODS_MODEL,super.getGoodsModel(),goodsModel);
			super.setGoodsModel(goodsModel);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param goodsName 名称
		 * @return 当前对象
		*/
		public AssetStockGoods setGoodsName(String goodsName) {
			super.change(GOODS_NAME,super.getGoodsName(),goodsName);
			super.setGoodsName(goodsName);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param goodsCategoryName 分类
		 * @return 当前对象
		*/
		public AssetStockGoods setGoodsCategoryName(String goodsCategoryName) {
			super.change(GOODS_CATEGORY_NAME,super.getGoodsCategoryName(),goodsCategoryName);
			super.setGoodsCategoryName(goodsCategoryName);
			return this;
		}
		
		/**
		 * 设置 计算单位
		 * @param goodsUnit 计算单位
		 * @return 当前对象
		*/
		public AssetStockGoods setGoodsUnit(String goodsUnit) {
			super.change(GOODS_UNIT,super.getGoodsUnit(),goodsUnit);
			super.setGoodsUnit(goodsUnit);
			return this;
		}
		
		/**
		 * 设置 物品编码
		 * @param goodsCode 物品编码
		 * @return 当前对象
		*/
		public AssetStockGoods setGoodsCode(String goodsCode) {
			super.change(GOODS_CODE,super.getGoodsCode(),goodsCode);
			super.setGoodsCode(goodsCode);
			return this;
		}
		
		/**
		 * 设置 物品条码
		 * @param goodsBarCode 物品条码
		 * @return 当前对象
		*/
		public AssetStockGoods setGoodsBarCode(String goodsBarCode) {
			super.change(GOODS_BAR_CODE,super.getGoodsBarCode(),goodsBarCode);
			super.setGoodsBarCode(goodsBarCode);
			return this;
		}
	}
}