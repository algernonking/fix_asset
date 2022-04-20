package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_GOODS_STOCK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 库存物品
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 13:15:09
 * @sign 413570DC08AC047448B23BE995B36C4C
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
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 物品名称：物品名称
	*/
	@ApiModelProperty(required = false,value="物品名称" , notes = "物品名称")
	private String name;
	
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
	 * 规格型号：规格型号
	*/
	@ApiModelProperty(required = false,value="规格型号" , notes = "规格型号")
	private String model;
	
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
	private BigDecimal defaultPrice;
	
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
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Category category;
	
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
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public GoodsStock setStatus(String status) {
		this.status=status;
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
	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}
	
	/**
	 * 设置 默认单价
	 * @param defaultPrice 默认单价
	 * @return 当前对象
	*/
	public GoodsStock setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice=defaultPrice;
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
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Category getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public GoodsStock setCategory(Category category) {
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