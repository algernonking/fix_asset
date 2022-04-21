package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_GOODS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 库存物品单
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 17:52:46
 * @sign C79AE054D75AB9EE3A1D73C02A1B18EA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_goods")
public class AssetStockGoods extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_GOODS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 库存所属：库存所属
	*/
	@ApiModelProperty(required = false,value="库存所属" , notes = "库存所属")
	private String ownerCode;
	
	/**
	 * 所属类型：所属类型
	*/
	@ApiModelProperty(required = false,value="所属类型" , notes = "所属类型")
	private String ownerType;
	
	/**
	 * 库存类型：库存类型
	*/
	@ApiModelProperty(required = false,value="库存类型" , notes = "库存类型")
	private String stockType;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String stockBatchCode;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String sourceId;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private String goodsId;
	
	/**
	 * 入库存数量：入库存数量
	*/
	@ApiModelProperty(required = false,value="入库存数量" , notes = "入库存数量")
	private BigDecimal stockInNumber;
	
	/**
	 * 当前库存数量：当前库存数量
	*/
	@ApiModelProperty(required = false,value="当前库存数量" , notes = "当前库存数量")
	private BigDecimal stockCurNumber;
	
	/**
	 * 单价：单价
	*/
	@ApiModelProperty(required = false,value="单价" , notes = "单价")
	private BigDecimal unitPrice;
	
	/**
	 * 总金额：总金额
	*/
	@ApiModelProperty(required = false,value="总金额" , notes = "总金额")
	private BigDecimal amount;
	
	/**
	 * 资产供应商：资产供应商
	*/
	@ApiModelProperty(required = false,value="资产供应商" , notes = "资产供应商")
	private String supplierId;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseId;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 所属组织：所属组织
	*/
	@ApiModelProperty(required = false,value="所属组织" , notes = "所属组织")
	private String useOrgId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
	private String selectedCode;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private GoodsStock goods;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Organization ownerCompany;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private Warehouse warehouse;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private DictItem source;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String goodsModel;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String goodsName;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类")
	private String goodsCategoryName;
	
	/**
	 * 计算单位：计算单位
	*/
	@ApiModelProperty(required = false,value="计算单位" , notes = "计算单位")
	private String goodsUnit;
	
	/**
	 * 物品编码：物品编码
	*/
	@ApiModelProperty(required = false,value="物品编码" , notes = "物品编码")
	private String goodsCode;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsBarCode;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public AssetStockGoods setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 库存所属<br>
	 * 库存所属
	 * @return 库存所属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 库存所属
	 * @param ownerCode 库存所属
	 * @return 当前对象
	*/
	public AssetStockGoods setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 所属类型<br>
	 * 所属类型
	 * @return 所属类型
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 所属类型
	 * @param ownerType 所属类型
	 * @return 当前对象
	*/
	public AssetStockGoods setOwnerType(String ownerType) {
		this.ownerType=ownerType;
		return this;
	}
	
	/**
	 * 获得 库存类型<br>
	 * 库存类型
	 * @return 库存类型
	*/
	public String getStockType() {
		return stockType;
	}
	
	/**
	 * 设置 库存类型
	 * @param stockType 库存类型
	 * @return 当前对象
	*/
	public AssetStockGoods setStockType(String stockType) {
		this.stockType=stockType;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public AssetStockGoods setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 批次号
	 * @return 批次号
	*/
	public String getStockBatchCode() {
		return stockBatchCode;
	}
	
	/**
	 * 设置 批次号
	 * @param stockBatchCode 批次号
	 * @return 当前对象
	*/
	public AssetStockGoods setStockBatchCode(String stockBatchCode) {
		this.stockBatchCode=stockBatchCode;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 来源
	 * @param sourceId 来源
	 * @return 当前对象
	*/
	public AssetStockGoods setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public String getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置 物品
	 * @param goodsId 物品
	 * @return 当前对象
	*/
	public AssetStockGoods setGoodsId(String goodsId) {
		this.goodsId=goodsId;
		return this;
	}
	
	/**
	 * 获得 入库存数量<br>
	 * 入库存数量
	 * @return 入库存数量
	*/
	public BigDecimal getStockInNumber() {
		return stockInNumber;
	}
	
	/**
	 * 设置 入库存数量
	 * @param stockInNumber 入库存数量
	 * @return 当前对象
	*/
	public AssetStockGoods setStockInNumber(BigDecimal stockInNumber) {
		this.stockInNumber=stockInNumber;
		return this;
	}
	
	/**
	 * 获得 当前库存数量<br>
	 * 当前库存数量
	 * @return 当前库存数量
	*/
	public BigDecimal getStockCurNumber() {
		return stockCurNumber;
	}
	
	/**
	 * 设置 当前库存数量
	 * @param stockCurNumber 当前库存数量
	 * @return 当前对象
	*/
	public AssetStockGoods setStockCurNumber(BigDecimal stockCurNumber) {
		this.stockCurNumber=stockCurNumber;
		return this;
	}
	
	/**
	 * 获得 单价<br>
	 * 单价
	 * @return 单价
	*/
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	/**
	 * 设置 单价
	 * @param unitPrice 单价
	 * @return 当前对象
	*/
	public AssetStockGoods setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice=unitPrice;
		return this;
	}
	
	/**
	 * 获得 总金额<br>
	 * 总金额
	 * @return 总金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 总金额
	 * @param amount 总金额
	 * @return 当前对象
	*/
	public AssetStockGoods setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 资产供应商<br>
	 * 资产供应商
	 * @return 资产供应商
	*/
	public String getSupplierId() {
		return supplierId;
	}
	
	/**
	 * 设置 资产供应商
	 * @param supplierId 资产供应商
	 * @return 当前对象
	*/
	public AssetStockGoods setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseId 仓库
	 * @return 当前对象
	*/
	public AssetStockGoods setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public String getOwnCompanyId() {
		return ownCompanyId;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownCompanyId 所属公司
	 * @return 当前对象
	*/
	public AssetStockGoods setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public AssetStockGoods setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 所属组织<br>
	 * 所属组织
	 * @return 所属组织
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 所属组织
	 * @param useOrgId 所属组织
	 * @return 当前对象
	*/
	public AssetStockGoods setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public AssetStockGoods setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public AssetStockGoods setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public AssetStockGoods setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public AssetStockGoods setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public AssetStockGoods setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public AssetStockGoods setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public AssetStockGoods setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public AssetStockGoods setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public AssetStockGoods setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public AssetStockGoods setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public AssetStockGoods setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public GoodsStock getGoods() {
		return goods;
	}
	
	/**
	 * 设置 物品
	 * @param goods 物品
	 * @return 当前对象
	*/
	public AssetStockGoods setGoods(GoodsStock goods) {
		this.goods=goods;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public AssetStockGoods setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * 设置 供应商
	 * @param supplier 供应商
	 * @return 当前对象
	*/
	public AssetStockGoods setSupplier(Supplier supplier) {
		this.supplier=supplier;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public Organization getOwnerCompany() {
		return ownerCompany;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownerCompany 所属公司
	 * @return 当前对象
	*/
	public AssetStockGoods setOwnerCompany(Organization ownerCompany) {
		this.ownerCompany=ownerCompany;
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public Organization getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganization 使用公司/部门
	 * @return 当前对象
	*/
	public AssetStockGoods setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public AssetStockGoods setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public DictItem getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public AssetStockGoods setSource(DictItem source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getGoodsModel() {
		return goodsModel;
	}
	
	/**
	 * 设置 类型
	 * @param goodsModel 类型
	 * @return 当前对象
	*/
	public AssetStockGoods setGoodsModel(String goodsModel) {
		this.goodsModel=goodsModel;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getGoodsName() {
		return goodsName;
	}
	
	/**
	 * 设置 名称
	 * @param goodsName 名称
	 * @return 当前对象
	*/
	public AssetStockGoods setGoodsName(String goodsName) {
		this.goodsName=goodsName;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}
	
	/**
	 * 设置 分类
	 * @param goodsCategoryName 分类
	 * @return 当前对象
	*/
	public AssetStockGoods setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName=goodsCategoryName;
		return this;
	}
	
	/**
	 * 获得 计算单位<br>
	 * 计算单位
	 * @return 计算单位
	*/
	public String getGoodsUnit() {
		return goodsUnit;
	}
	
	/**
	 * 设置 计算单位
	 * @param goodsUnit 计算单位
	 * @return 当前对象
	*/
	public AssetStockGoods setGoodsUnit(String goodsUnit) {
		this.goodsUnit=goodsUnit;
		return this;
	}
	
	/**
	 * 获得 物品编码<br>
	 * 物品编码
	 * @return 物品编码
	*/
	public String getGoodsCode() {
		return goodsCode;
	}
	
	/**
	 * 设置 物品编码
	 * @param goodsCode 物品编码
	 * @return 当前对象
	*/
	public AssetStockGoods setGoodsCode(String goodsCode) {
		this.goodsCode=goodsCode;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsBarCode() {
		return goodsBarCode;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsBarCode 物品条码
	 * @return 当前对象
	*/
	public AssetStockGoods setGoodsBarCode(String goodsBarCode) {
		this.goodsBarCode=goodsBarCode;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockGoods , 转换好的 AssetStockGoods 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoods , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将 Map 转换成 AssetStockGoods
	 * @param assetStockGoodsMap 包含实体信息的 Map 对象
	 * @return AssetStockGoods , 转换好的的 AssetStockGoods 对象
	*/
	@Transient
	public static AssetStockGoods createFrom(Map<String,Object> assetStockGoodsMap) {
		if(assetStockGoodsMap==null) return null;
		AssetStockGoods po = EntityContext.create(AssetStockGoods.class, assetStockGoodsMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoods
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoods , 转换好的的 AssetStockGoods 对象
	*/
	@Transient
	public static AssetStockGoods createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoods po = EntityContext.create(AssetStockGoods.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetStockGoods，等同于 new
	 * @return AssetStockGoods 对象
	*/
	@Transient
	public static AssetStockGoods create() {
		return EntityContext.create(AssetStockGoods.class);
	}
}