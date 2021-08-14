package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_EXT_FINANCIAL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 08:53:27
 * @sign 804C387374F1AFD9F3B9844CD3D102C6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_ext_financial")
public class AssetExtFinancial extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_EXT_FINANCIAL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 资产ID：资产ID
	*/
	@ApiModelProperty(required = false,value="资产ID" , notes = "资产ID")
	private String assetId;
	
	/**
	 * 财务维度资产类型：财务维度资产类型
	*/
	@ApiModelProperty(required = false,value="财务维度资产类型" , notes = "财务维度资产类型")
	private String typeId;
	
	/**
	 * 财务编号：财务编号
	*/
	@ApiModelProperty(required = false,value="财务编号" , notes = "财务编号")
	private String assetCode;
	
	/**
	 * 管理组织ID：管理组织ID
	*/
	@ApiModelProperty(required = false,value="管理组织ID" , notes = "管理组织ID")
	private String manageorgId;
	
	/**
	 * 资产供应商：资产供应商
	*/
	@ApiModelProperty(required = false,value="资产供应商" , notes = "资产供应商")
	private String supplierId;
	
	/**
	 * 采购日期：采购日期
	*/
	@ApiModelProperty(required = false,value="采购日期" , notes = "采购日期")
	private Date purchaseDate;
	
	/**
	 * 税额：税额
	*/
	@ApiModelProperty(required = true,value="税额" , notes = "税额")
	private BigDecimal taxamountRate;
	
	/**
	 * 含税金额：含税金额
	*/
	@ApiModelProperty(required = true,value="含税金额" , notes = "含税金额")
	private BigDecimal taxamountPrice;
	
	/**
	 * 资产原值(单价)：资产原值(单价)
	*/
	@ApiModelProperty(required = true,value="资产原值(单价)" , notes = "资产原值(单价)")
	private BigDecimal originalUnitPrice;
	
	/**
	 * 累计折旧：累计折旧
	*/
	@ApiModelProperty(required = true,value="累计折旧" , notes = "累计折旧")
	private BigDecimal accumulatedDepreciation;
	
	/**
	 * 残值率：残值率
	*/
	@ApiModelProperty(required = true,value="残值率" , notes = "残值率")
	private BigDecimal residualsRate;
	
	/**
	 * 资产净值：资产净值
	*/
	@ApiModelProperty(required = true,value="资产净值" , notes = "资产净值")
	private BigDecimal navPrice;
	
	/**
	 * 采购单价：采购单价
	*/
	@ApiModelProperty(required = false,value="采购单价" , notes = "采购单价")
	private BigDecimal purchaseUnitPrice;
	
	/**
	 * 入账时间：入账时间
	*/
	@ApiModelProperty(required = false,value="入账时间" , notes = "入账时间")
	private BigDecimal entryTime;
	
	/**
	 * 使用期限(月)：使用期限(月)
	*/
	@ApiModelProperty(required = false,value="使用期限(月)" , notes = "使用期限(月)")
	private BigDecimal serviceLife;
	
	/**
	 * 财务备注：财务备注
	*/
	@ApiModelProperty(required = false,value="财务备注" , notes = "财务备注")
	private String financialNotes;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
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
	public AssetExtFinancial setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 资产ID<br>
	 * 资产ID
	 * @return 资产ID
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产ID
	 * @param assetId 资产ID
	 * @return 当前对象
	*/
	public AssetExtFinancial setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 财务维度资产类型<br>
	 * 财务维度资产类型
	 * @return 财务维度资产类型
	*/
	public String getTypeId() {
		return typeId;
	}
	
	/**
	 * 设置 财务维度资产类型
	 * @param typeId 财务维度资产类型
	 * @return 当前对象
	*/
	public AssetExtFinancial setTypeId(String typeId) {
		this.typeId=typeId;
		return this;
	}
	
	/**
	 * 获得 财务编号<br>
	 * 财务编号
	 * @return 财务编号
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 财务编号
	 * @param assetCode 财务编号
	 * @return 当前对象
	*/
	public AssetExtFinancial setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 管理组织ID<br>
	 * 管理组织ID
	 * @return 管理组织ID
	*/
	public String getManageorgId() {
		return manageorgId;
	}
	
	/**
	 * 设置 管理组织ID
	 * @param manageorgId 管理组织ID
	 * @return 当前对象
	*/
	public AssetExtFinancial setManageorgId(String manageorgId) {
		this.manageorgId=manageorgId;
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
	public AssetExtFinancial setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 采购日期<br>
	 * 采购日期
	 * @return 采购日期
	*/
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	/**
	 * 设置 采购日期
	 * @param purchaseDate 采购日期
	 * @return 当前对象
	*/
	public AssetExtFinancial setPurchaseDate(Date purchaseDate) {
		this.purchaseDate=purchaseDate;
		return this;
	}
	
	/**
	 * 获得 税额<br>
	 * 税额
	 * @return 税额
	*/
	public BigDecimal getTaxamountRate() {
		return taxamountRate;
	}
	
	/**
	 * 设置 税额
	 * @param taxamountRate 税额
	 * @return 当前对象
	*/
	public AssetExtFinancial setTaxamountRate(BigDecimal taxamountRate) {
		this.taxamountRate=taxamountRate;
		return this;
	}
	
	/**
	 * 获得 含税金额<br>
	 * 含税金额
	 * @return 含税金额
	*/
	public BigDecimal getTaxamountPrice() {
		return taxamountPrice;
	}
	
	/**
	 * 设置 含税金额
	 * @param taxamountPrice 含税金额
	 * @return 当前对象
	*/
	public AssetExtFinancial setTaxamountPrice(BigDecimal taxamountPrice) {
		this.taxamountPrice=taxamountPrice;
		return this;
	}
	
	/**
	 * 获得 资产原值(单价)<br>
	 * 资产原值(单价)
	 * @return 资产原值(单价)
	*/
	public BigDecimal getOriginalUnitPrice() {
		return originalUnitPrice;
	}
	
	/**
	 * 设置 资产原值(单价)
	 * @param originalUnitPrice 资产原值(单价)
	 * @return 当前对象
	*/
	public AssetExtFinancial setOriginalUnitPrice(BigDecimal originalUnitPrice) {
		this.originalUnitPrice=originalUnitPrice;
		return this;
	}
	
	/**
	 * 获得 累计折旧<br>
	 * 累计折旧
	 * @return 累计折旧
	*/
	public BigDecimal getAccumulatedDepreciation() {
		return accumulatedDepreciation;
	}
	
	/**
	 * 设置 累计折旧
	 * @param accumulatedDepreciation 累计折旧
	 * @return 当前对象
	*/
	public AssetExtFinancial setAccumulatedDepreciation(BigDecimal accumulatedDepreciation) {
		this.accumulatedDepreciation=accumulatedDepreciation;
		return this;
	}
	
	/**
	 * 获得 残值率<br>
	 * 残值率
	 * @return 残值率
	*/
	public BigDecimal getResidualsRate() {
		return residualsRate;
	}
	
	/**
	 * 设置 残值率
	 * @param residualsRate 残值率
	 * @return 当前对象
	*/
	public AssetExtFinancial setResidualsRate(BigDecimal residualsRate) {
		this.residualsRate=residualsRate;
		return this;
	}
	
	/**
	 * 获得 资产净值<br>
	 * 资产净值
	 * @return 资产净值
	*/
	public BigDecimal getNavPrice() {
		return navPrice;
	}
	
	/**
	 * 设置 资产净值
	 * @param navPrice 资产净值
	 * @return 当前对象
	*/
	public AssetExtFinancial setNavPrice(BigDecimal navPrice) {
		this.navPrice=navPrice;
		return this;
	}
	
	/**
	 * 获得 采购单价<br>
	 * 采购单价
	 * @return 采购单价
	*/
	public BigDecimal getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}
	
	/**
	 * 设置 采购单价
	 * @param purchaseUnitPrice 采购单价
	 * @return 当前对象
	*/
	public AssetExtFinancial setPurchaseUnitPrice(BigDecimal purchaseUnitPrice) {
		this.purchaseUnitPrice=purchaseUnitPrice;
		return this;
	}
	
	/**
	 * 获得 入账时间<br>
	 * 入账时间
	 * @return 入账时间
	*/
	public BigDecimal getEntryTime() {
		return entryTime;
	}
	
	/**
	 * 设置 入账时间
	 * @param entryTime 入账时间
	 * @return 当前对象
	*/
	public AssetExtFinancial setEntryTime(BigDecimal entryTime) {
		this.entryTime=entryTime;
		return this;
	}
	
	/**
	 * 获得 使用期限(月)<br>
	 * 使用期限(月)
	 * @return 使用期限(月)
	*/
	public BigDecimal getServiceLife() {
		return serviceLife;
	}
	
	/**
	 * 设置 使用期限(月)
	 * @param serviceLife 使用期限(月)
	 * @return 当前对象
	*/
	public AssetExtFinancial setServiceLife(BigDecimal serviceLife) {
		this.serviceLife=serviceLife;
		return this;
	}
	
	/**
	 * 获得 财务备注<br>
	 * 财务备注
	 * @return 财务备注
	*/
	public String getFinancialNotes() {
		return financialNotes;
	}
	
	/**
	 * 设置 财务备注
	 * @param financialNotes 财务备注
	 * @return 当前对象
	*/
	public AssetExtFinancial setFinancialNotes(String financialNotes) {
		this.financialNotes=financialNotes;
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
	public AssetExtFinancial setCreateBy(String createBy) {
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
	public AssetExtFinancial setCreateTime(Date createTime) {
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
	public AssetExtFinancial setUpdateBy(String updateBy) {
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
	public AssetExtFinancial setUpdateTime(Date updateTime) {
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
	public AssetExtFinancial setDeleted(Integer deleted) {
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
	public AssetExtFinancial setDeleteBy(String deleteBy) {
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
	public AssetExtFinancial setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public AssetExtFinancial setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetExtFinancial , 转换好的 AssetExtFinancial 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetExtFinancial , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetExtFinancial
	 * @param assetExtFinancialMap 包含实体信息的 Map 对象
	 * @return AssetExtFinancial , 转换好的的 AssetExtFinancial 对象
	*/
	@Transient
	public static AssetExtFinancial createFrom(Map<String,Object> assetExtFinancialMap) {
		if(assetExtFinancialMap==null) return null;
		AssetExtFinancial po = EntityContext.create(AssetExtFinancial.class, assetExtFinancialMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetExtFinancial
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetExtFinancial , 转换好的的 AssetExtFinancial 对象
	*/
	@Transient
	public static AssetExtFinancial createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetExtFinancial po = EntityContext.create(AssetExtFinancial.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetExtFinancial，等同于 new
	 * @return AssetExtFinancial 对象
	*/
	@Transient
	public static AssetExtFinancial create() {
		return EntityContext.create(AssetExtFinancial.class);
	}
}