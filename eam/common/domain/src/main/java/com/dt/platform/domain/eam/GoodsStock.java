package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_GOODS_STOCK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 库存物品
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-24 20:39:36
 * @sign E01BFB39E9982699E66C58785D332C80
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_goods_stock")
public class GoodsStock extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_GOODS_STOCK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerId;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerTmpId;
	
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
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String goodsStatus;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 物品名称：物品名称
	*/
	@ApiModelProperty(required = false,value="物品名称" , notes = "物品名称")
	private String name;
	
	/**
	 * 规格型号：规格型号
	*/
	@ApiModelProperty(required = false,value="规格型号" , notes = "规格型号")
	private String model;
	
	/**
	 * 物品编码：物品编码
	*/
	@ApiModelProperty(required = false,value="物品编码" , notes = "物品编码")
	private String code;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String barCode;
	
	/**
	 * 厂商：厂商
	*/
	@ApiModelProperty(required = false,value="厂商" , notes = "厂商")
	private String manufacturerId;
	
	/**
	 * 品牌商标：品牌商标
	*/
	@ApiModelProperty(required = false,value="品牌商标" , notes = "品牌商标")
	private String brandId;
	
	/**
	 * 默认单价：默认单价
	*/
	@ApiModelProperty(required = false,value="默认单价" , notes = "默认单价")
	private BigDecimal unitPrice;
	
	/**
	 * 计量单位：计量单位
	*/
	@ApiModelProperty(required = false,value="计量单位" , notes = "计量单位")
	private String unit;
	
	/**
	 * 安全库存下限：安全库存下限
	*/
	@ApiModelProperty(required = false,value="安全库存下限" , notes = "安全库存下限")
	private BigDecimal stockMin;
	
	/**
	 * 安全库存上限：安全库存上限
	*/
	@ApiModelProperty(required = false,value="安全库存上限" , notes = "安全库存上限")
	private BigDecimal stockMax;
	
	/**
	 * 安全库存：安全库存
	*/
	@ApiModelProperty(required = false,value="安全库存" , notes = "安全库存")
	private BigDecimal stockSecurity;
	
	/**
	 * 物品图片：物品图片
	*/
	@ApiModelProperty(required = false,value="物品图片" , notes = "物品图片")
	private String pictureId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String batchCode;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 使用组织：使用组织
	*/
	@ApiModelProperty(required = false,value="使用组织" , notes = "使用组织")
	private String useOrgId;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private String supplierName;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseId;
	
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
	 * 入库数量：入库数量
	*/
	@ApiModelProperty(required = false,value="入库数量" , notes = "入库数量")
	private BigDecimal stockInNumber;
	
	/**
	 * 当前数量：当前数量
	*/
	@ApiModelProperty(required = false,value="当前数量" , notes = "当前数量")
	private BigDecimal stockCurNumber;
	
	/**
	 * 总金额：总金额
	*/
	@ApiModelProperty(required = false,value="总金额" , notes = "总金额")
	private BigDecimal amount;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private String managerId;
	
	/**
	 * 入库时间：入库时间
	*/
	@ApiModelProperty(required = false,value="入库时间" , notes = "入库时间")
	private Date storageDate;
	
	/**
	 * 库存数据：库存数据
	*/
	@ApiModelProperty(required = false,value="库存数据" , notes = "库存数据")
	private String realStockId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
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
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Catalog category;
	
	/**
	 * 生产厂商：生产厂商
	*/
	@ApiModelProperty(required = false,value="生产厂商" , notes = "生产厂商")
	private Manufacturer manufacturer;
	
	/**
	 * 品牌：品牌
	*/
	@ApiModelProperty(required = false,value="品牌" , notes = "品牌")
	private Brand brand;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private GoodsStock goods;
	
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
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private Employee manager;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 库存数据：库存数据
	*/
	@ApiModelProperty(required = false,value="库存数据" , notes = "库存数据")
	private GoodsStock realGoods;
	
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
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsStockMax;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsStockMin;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsStockSecurity;
	
	/**
	 * 库存备注：库存备注
	*/
	@ApiModelProperty(required = false,value="库存备注" , notes = "库存备注")
	private String goodsStockNotes;
	
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
	public GoodsStock setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerId 所属
	 * @return 当前对象
	*/
	public GoodsStock setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerTmpId() {
		return ownerTmpId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerTmpId 所属
	 * @return 当前对象
	*/
	public GoodsStock setOwnerTmpId(String ownerTmpId) {
		this.ownerTmpId=ownerTmpId;
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
	public GoodsStock setOwnerCode(String ownerCode) {
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
	public GoodsStock setOwnerType(String ownerType) {
		this.ownerType=ownerType;
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
	public GoodsStock setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public GoodsStock setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getGoodsStatus() {
		return goodsStatus;
	}
	
	/**
	 * 设置 状态
	 * @param goodsStatus 状态
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStatus(String goodsStatus) {
		this.goodsStatus=goodsStatus;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public GoodsStock setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 物品名称<br>
	 * 物品名称
	 * @return 物品名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 物品名称
	 * @param name 物品名称
	 * @return 当前对象
	*/
	public GoodsStock setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 规格型号<br>
	 * 规格型号
	 * @return 规格型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 规格型号
	 * @param model 规格型号
	 * @return 当前对象
	*/
	public GoodsStock setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 获得 物品编码<br>
	 * 物品编码
	 * @return 物品编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 物品编码
	 * @param code 物品编码
	 * @return 当前对象
	*/
	public GoodsStock setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getBarCode() {
		return barCode;
	}
	
	/**
	 * 设置 物品条码
	 * @param barCode 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setBarCode(String barCode) {
		this.barCode=barCode;
		return this;
	}
	
	/**
	 * 获得 厂商<br>
	 * 厂商
	 * @return 厂商
	*/
	public String getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * 设置 厂商
	 * @param manufacturerId 厂商
	 * @return 当前对象
	*/
	public GoodsStock setManufacturerId(String manufacturerId) {
		this.manufacturerId=manufacturerId;
		return this;
	}
	
	/**
	 * 获得 品牌商标<br>
	 * 品牌商标
	 * @return 品牌商标
	*/
	public String getBrandId() {
		return brandId;
	}
	
	/**
	 * 设置 品牌商标
	 * @param brandId 品牌商标
	 * @return 当前对象
	*/
	public GoodsStock setBrandId(String brandId) {
		this.brandId=brandId;
		return this;
	}
	
	/**
	 * 获得 默认单价<br>
	 * 默认单价
	 * @return 默认单价
	*/
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	/**
	 * 设置 默认单价
	 * @param unitPrice 默认单价
	 * @return 当前对象
	*/
	public GoodsStock setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice=unitPrice;
		return this;
	}
	
	/**
	 * 获得 计量单位<br>
	 * 计量单位
	 * @return 计量单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 计量单位
	 * @param unit 计量单位
	 * @return 当前对象
	*/
	public GoodsStock setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 安全库存下限<br>
	 * 安全库存下限
	 * @return 安全库存下限
	*/
	public BigDecimal getStockMin() {
		return stockMin;
	}
	
	/**
	 * 设置 安全库存下限
	 * @param stockMin 安全库存下限
	 * @return 当前对象
	*/
	public GoodsStock setStockMin(BigDecimal stockMin) {
		this.stockMin=stockMin;
		return this;
	}
	
	/**
	 * 获得 安全库存上限<br>
	 * 安全库存上限
	 * @return 安全库存上限
	*/
	public BigDecimal getStockMax() {
		return stockMax;
	}
	
	/**
	 * 设置 安全库存上限
	 * @param stockMax 安全库存上限
	 * @return 当前对象
	*/
	public GoodsStock setStockMax(BigDecimal stockMax) {
		this.stockMax=stockMax;
		return this;
	}
	
	/**
	 * 获得 安全库存<br>
	 * 安全库存
	 * @return 安全库存
	*/
	public BigDecimal getStockSecurity() {
		return stockSecurity;
	}
	
	/**
	 * 设置 安全库存
	 * @param stockSecurity 安全库存
	 * @return 当前对象
	*/
	public GoodsStock setStockSecurity(BigDecimal stockSecurity) {
		this.stockSecurity=stockSecurity;
		return this;
	}
	
	/**
	 * 获得 物品图片<br>
	 * 物品图片
	 * @return 物品图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 物品图片
	 * @param pictureId 物品图片
	 * @return 当前对象
	*/
	public GoodsStock setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public GoodsStock setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 批次号
	 * @return 批次号
	*/
	public String getBatchCode() {
		return batchCode;
	}
	
	/**
	 * 设置 批次号
	 * @param batchCode 批次号
	 * @return 当前对象
	*/
	public GoodsStock setBatchCode(String batchCode) {
		this.batchCode=batchCode;
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
	public GoodsStock setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 使用组织<br>
	 * 使用组织
	 * @return 使用组织
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 使用组织
	 * @param useOrgId 使用组织
	 * @return 当前对象
	*/
	public GoodsStock setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public String getSupplierName() {
		return supplierName;
	}
	
	/**
	 * 设置 供应商
	 * @param supplierName 供应商
	 * @return 当前对象
	*/
	public GoodsStock setSupplierName(String supplierName) {
		this.supplierName=supplierName;
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
	public GoodsStock setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
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
	public GoodsStock setSourceId(String sourceId) {
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
	public GoodsStock setGoodsId(String goodsId) {
		this.goodsId=goodsId;
		return this;
	}
	
	/**
	 * 获得 入库数量<br>
	 * 入库数量
	 * @return 入库数量
	*/
	public BigDecimal getStockInNumber() {
		return stockInNumber;
	}
	
	/**
	 * 设置 入库数量
	 * @param stockInNumber 入库数量
	 * @return 当前对象
	*/
	public GoodsStock setStockInNumber(BigDecimal stockInNumber) {
		this.stockInNumber=stockInNumber;
		return this;
	}
	
	/**
	 * 获得 当前数量<br>
	 * 当前数量
	 * @return 当前数量
	*/
	public BigDecimal getStockCurNumber() {
		return stockCurNumber;
	}
	
	/**
	 * 设置 当前数量
	 * @param stockCurNumber 当前数量
	 * @return 当前对象
	*/
	public GoodsStock setStockCurNumber(BigDecimal stockCurNumber) {
		this.stockCurNumber=stockCurNumber;
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
	public GoodsStock setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 管理人
	 * @param managerId 管理人
	 * @return 当前对象
	*/
	public GoodsStock setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 入库时间<br>
	 * 入库时间
	 * @return 入库时间
	*/
	public Date getStorageDate() {
		return storageDate;
	}
	
	/**
	 * 设置 入库时间
	 * @param storageDate 入库时间
	 * @return 当前对象
	*/
	public GoodsStock setStorageDate(Date storageDate) {
		this.storageDate=storageDate;
		return this;
	}
	
	/**
	 * 获得 库存数据<br>
	 * 库存数据
	 * @return 库存数据
	*/
	public String getRealStockId() {
		return realStockId;
	}
	
	/**
	 * 设置 库存数据
	 * @param realStockId 库存数据
	 * @return 当前对象
	*/
	public GoodsStock setRealStockId(String realStockId) {
		this.realStockId=realStockId;
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
	public GoodsStock setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public GoodsStock setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public GoodsStock setCreateBy(String createBy) {
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
	public GoodsStock setCreateTime(Date createTime) {
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
	public GoodsStock setUpdateBy(String updateBy) {
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
	public GoodsStock setUpdateTime(Date updateTime) {
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
	public GoodsStock setDeleted(Integer deleted) {
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
	public GoodsStock setDeleteBy(String deleteBy) {
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
	public GoodsStock setDeleteTime(Date deleteTime) {
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
	public GoodsStock setVersion(Integer version) {
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
	public GoodsStock setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Catalog getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public GoodsStock setCategory(Catalog category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 生产厂商<br>
	 * 生产厂商
	 * @return 生产厂商
	*/
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * 设置 生产厂商
	 * @param manufacturer 生产厂商
	 * @return 当前对象
	*/
	public GoodsStock setManufacturer(Manufacturer manufacturer) {
		this.manufacturer=manufacturer;
		return this;
	}
	
	/**
	 * 获得 品牌<br>
	 * 品牌
	 * @return 品牌
	*/
	public Brand getBrand() {
		return brand;
	}
	
	/**
	 * 设置 品牌
	 * @param brand 品牌
	 * @return 当前对象
	*/
	public GoodsStock setBrand(Brand brand) {
		this.brand=brand;
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
	public GoodsStock setGoods(GoodsStock goods) {
		this.goods=goods;
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
	public GoodsStock setOwnerCompany(Organization ownerCompany) {
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
	public GoodsStock setUseOrganization(Organization useOrganization) {
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
	public GoodsStock setWarehouse(Warehouse warehouse) {
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
	public GoodsStock setSource(DictItem source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人
	 * @param manager 管理人
	 * @return 当前对象
	*/
	public GoodsStock setManager(Employee manager) {
		this.manager=manager;
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
	public GoodsStock setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 库存数据<br>
	 * 库存数据
	 * @return 库存数据
	*/
	public GoodsStock getRealGoods() {
		return realGoods;
	}
	
	/**
	 * 设置 库存数据
	 * @param realGoods 库存数据
	 * @return 当前对象
	*/
	public GoodsStock setRealGoods(GoodsStock realGoods) {
		this.realGoods=realGoods;
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
	public GoodsStock setGoodsModel(String goodsModel) {
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
	public GoodsStock setGoodsName(String goodsName) {
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
	public GoodsStock setGoodsCategoryName(String goodsCategoryName) {
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
	public GoodsStock setGoodsUnit(String goodsUnit) {
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
	public GoodsStock setGoodsCode(String goodsCode) {
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
	public GoodsStock setGoodsBarCode(String goodsBarCode) {
		this.goodsBarCode=goodsBarCode;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsStockMax() {
		return goodsStockMax;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsStockMax 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockMax(String goodsStockMax) {
		this.goodsStockMax=goodsStockMax;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsStockMin() {
		return goodsStockMin;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsStockMin 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockMin(String goodsStockMin) {
		this.goodsStockMin=goodsStockMin;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsStockSecurity() {
		return goodsStockSecurity;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsStockSecurity 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockSecurity(String goodsStockSecurity) {
		this.goodsStockSecurity=goodsStockSecurity;
		return this;
	}
	
	/**
	 * 获得 库存备注<br>
	 * 库存备注
	 * @return 库存备注
	*/
	public String getGoodsStockNotes() {
		return goodsStockNotes;
	}
	
	/**
	 * 设置 库存备注
	 * @param goodsStockNotes 库存备注
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockNotes(String goodsStockNotes) {
		this.goodsStockNotes=goodsStockNotes;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return GoodsStock , 转换好的 GoodsStock 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return GoodsStock , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 GoodsStock
	 * @param goodsStockMap 包含实体信息的 Map 对象
	 * @return GoodsStock , 转换好的的 GoodsStock 对象
	*/
	@Transient
	public static GoodsStock createFrom(Map<String,Object> goodsStockMap) {
		if(goodsStockMap==null) return null;
		GoodsStock po = EntityContext.create(GoodsStock.class, goodsStockMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 GoodsStock
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return GoodsStock , 转换好的的 GoodsStock 对象
	*/
	@Transient
	public static GoodsStock createFrom(Object pojo) {
		if(pojo==null) return null;
		GoodsStock po = EntityContext.create(GoodsStock.class,pojo);
		return po;
	}

	/**
	 * 创建一个 GoodsStock，等同于 new
	 * @return GoodsStock 对象
	*/
	@Transient
	public static GoodsStock create() {
		return EntityContext.create(GoodsStock.class);
	}
}