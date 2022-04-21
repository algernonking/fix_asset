package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_GOODS_DETAIL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 库存物品明细
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 06:06:16
 * @sign 300AEBDB19033946A9A6FEC32B8BA9EE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_goods_detail")
public class AssetStockGoodsDetail extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_GOODS_DETAIL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 物品编码：物品编码
	*/
	@ApiModelProperty(required = false,value="物品编码" , notes = "物品编码")
	private String goodsId;
	
	/**
	 * 库存单：库存单
	*/
	@ApiModelProperty(required = false,value="库存单" , notes = "库存单")
	private String stockId;
	
	/**
	 * 入库数量：入库数量
	*/
	@ApiModelProperty(required = false,value="入库数量" , notes = "入库数量")
	private BigDecimal inNumber;
	
	/**
	 * 当前数量：当前数量
	*/
	@ApiModelProperty(required = false,value="当前数量" , notes = "当前数量")
	private BigDecimal curNumber;
	
	/**
	 * 单价：单价
	*/
	@ApiModelProperty(required = false,value="单价" , notes = "单价")
	private BigDecimal unitPrice;
	
	/**
	 * 金额：金额
	*/
	@ApiModelProperty(required = false,value="金额" , notes = "金额")
	private BigDecimal amount;
	
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
	public AssetStockGoodsDetail setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 物品编码<br>
	 * 物品编码
	 * @return 物品编码
	*/
	public String getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置 物品编码
	 * @param goodsId 物品编码
	 * @return 当前对象
	*/
	public AssetStockGoodsDetail setGoodsId(String goodsId) {
		this.goodsId=goodsId;
		return this;
	}
	
	/**
	 * 获得 库存单<br>
	 * 库存单
	 * @return 库存单
	*/
	public String getStockId() {
		return stockId;
	}
	
	/**
	 * 设置 库存单
	 * @param stockId 库存单
	 * @return 当前对象
	*/
	public AssetStockGoodsDetail setStockId(String stockId) {
		this.stockId=stockId;
		return this;
	}
	
	/**
	 * 获得 入库数量<br>
	 * 入库数量
	 * @return 入库数量
	*/
	public BigDecimal getInNumber() {
		return inNumber;
	}
	
	/**
	 * 设置 入库数量
	 * @param inNumber 入库数量
	 * @return 当前对象
	*/
	public AssetStockGoodsDetail setInNumber(BigDecimal inNumber) {
		this.inNumber=inNumber;
		return this;
	}
	
	/**
	 * 获得 当前数量<br>
	 * 当前数量
	 * @return 当前数量
	*/
	public BigDecimal getCurNumber() {
		return curNumber;
	}
	
	/**
	 * 设置 当前数量
	 * @param curNumber 当前数量
	 * @return 当前对象
	*/
	public AssetStockGoodsDetail setCurNumber(BigDecimal curNumber) {
		this.curNumber=curNumber;
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
	public AssetStockGoodsDetail setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice=unitPrice;
		return this;
	}
	
	/**
	 * 获得 金额<br>
	 * 金额
	 * @return 金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 金额
	 * @param amount 金额
	 * @return 当前对象
	*/
	public AssetStockGoodsDetail setAmount(BigDecimal amount) {
		this.amount=amount;
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
	public AssetStockGoodsDetail setNotes(String notes) {
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
	public AssetStockGoodsDetail setCreateBy(String createBy) {
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
	public AssetStockGoodsDetail setCreateTime(Date createTime) {
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
	public AssetStockGoodsDetail setUpdateBy(String updateBy) {
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
	public AssetStockGoodsDetail setUpdateTime(Date updateTime) {
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
	public AssetStockGoodsDetail setDeleted(Integer deleted) {
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
	public AssetStockGoodsDetail setDeleteBy(String deleteBy) {
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
	public AssetStockGoodsDetail setDeleteTime(Date deleteTime) {
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
	public AssetStockGoodsDetail setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockGoodsDetail , 转换好的 AssetStockGoodsDetail 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsDetail , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetStockGoodsDetail
	 * @param assetStockGoodsDetailMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsDetail , 转换好的的 AssetStockGoodsDetail 对象
	*/
	@Transient
	public static AssetStockGoodsDetail createFrom(Map<String,Object> assetStockGoodsDetailMap) {
		if(assetStockGoodsDetailMap==null) return null;
		AssetStockGoodsDetail po = EntityContext.create(AssetStockGoodsDetail.class, assetStockGoodsDetailMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsDetail
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsDetail , 转换好的的 AssetStockGoodsDetail 对象
	*/
	@Transient
	public static AssetStockGoodsDetail createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsDetail po = EntityContext.create(AssetStockGoodsDetail.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetStockGoodsDetail，等同于 new
	 * @return AssetStockGoodsDetail 对象
	*/
	@Transient
	public static AssetStockGoodsDetail create() {
		return EntityContext.create(AssetStockGoodsDetail.class);
	}
}