package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DEPRECIATION_DETAIL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 折旧明细
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 06:22:54
 * @sign DAAAB18C459883CDBD54E0AF117ED37D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_depreciation_detail")
public class AssetDepreciationDetail extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DEPRECIATION_DETAIL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 折旧方案：折旧方案
	*/
	@ApiModelProperty(required = false,value="折旧方案" , notes = "折旧方案")
	private String depreciationId;
	
	/**
	 * 折旧操作：折旧操作
	*/
	@ApiModelProperty(required = false,value="折旧操作" , notes = "折旧操作")
	private String operId;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private String assetId;
	
	/**
	 * 折旧前：折旧前
	*/
	@ApiModelProperty(required = false,value="折旧前" , notes = "折旧前")
	private String detailIdSource;
	
	/**
	 * 折旧后：折旧后
	*/
	@ApiModelProperty(required = false,value="折旧后" , notes = "折旧后")
	private String detailIdTarget;
	
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
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset assetSource;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset assetTarget;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private AssetDepreciation assetDepreciation;
	
	/**
	 * 操作：操作
	*/
	@ApiModelProperty(required = false,value="操作" , notes = "操作")
	private AssetDepreciationOper assetDepreciationOper;
	
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
	public AssetDepreciationDetail setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 折旧方案<br>
	 * 折旧方案
	 * @return 折旧方案
	*/
	public String getDepreciationId() {
		return depreciationId;
	}
	
	/**
	 * 设置 折旧方案
	 * @param depreciationId 折旧方案
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setDepreciationId(String depreciationId) {
		this.depreciationId=depreciationId;
		return this;
	}
	
	/**
	 * 获得 折旧操作<br>
	 * 折旧操作
	 * @return 折旧操作
	*/
	public String getOperId() {
		return operId;
	}
	
	/**
	 * 设置 折旧操作
	 * @param operId 折旧操作
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setOperId(String operId) {
		this.operId=operId;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产
	 * @param assetId 资产
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 折旧前<br>
	 * 折旧前
	 * @return 折旧前
	*/
	public String getDetailIdSource() {
		return detailIdSource;
	}
	
	/**
	 * 设置 折旧前
	 * @param detailIdSource 折旧前
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setDetailIdSource(String detailIdSource) {
		this.detailIdSource=detailIdSource;
		return this;
	}
	
	/**
	 * 获得 折旧后<br>
	 * 折旧后
	 * @return 折旧后
	*/
	public String getDetailIdTarget() {
		return detailIdTarget;
	}
	
	/**
	 * 设置 折旧后
	 * @param detailIdTarget 折旧后
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setDetailIdTarget(String detailIdTarget) {
		this.detailIdTarget=detailIdTarget;
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
	public AssetDepreciationDetail setCreateBy(String createBy) {
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
	public AssetDepreciationDetail setCreateTime(Date createTime) {
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
	public AssetDepreciationDetail setUpdateBy(String updateBy) {
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
	public AssetDepreciationDetail setUpdateTime(Date updateTime) {
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
	public AssetDepreciationDetail setDeleted(Integer deleted) {
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
	public AssetDepreciationDetail setDeleteBy(String deleteBy) {
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
	public AssetDepreciationDetail setDeleteTime(Date deleteTime) {
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
	public AssetDepreciationDetail setVersion(Integer version) {
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
	public AssetDepreciationDetail setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAssetSource() {
		return assetSource;
	}
	
	/**
	 * 设置 资产
	 * @param assetSource 资产
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setAssetSource(Asset assetSource) {
		this.assetSource=assetSource;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAssetTarget() {
		return assetTarget;
	}
	
	/**
	 * 设置 资产
	 * @param assetTarget 资产
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setAssetTarget(Asset assetTarget) {
		this.assetTarget=assetTarget;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 方案<br>
	 * 方案
	 * @return 方案
	*/
	public AssetDepreciation getAssetDepreciation() {
		return assetDepreciation;
	}
	
	/**
	 * 设置 方案
	 * @param assetDepreciation 方案
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setAssetDepreciation(AssetDepreciation assetDepreciation) {
		this.assetDepreciation=assetDepreciation;
		return this;
	}
	
	/**
	 * 获得 操作<br>
	 * 操作
	 * @return 操作
	*/
	public AssetDepreciationOper getAssetDepreciationOper() {
		return assetDepreciationOper;
	}
	
	/**
	 * 设置 操作
	 * @param assetDepreciationOper 操作
	 * @return 当前对象
	*/
	public AssetDepreciationDetail setAssetDepreciationOper(AssetDepreciationOper assetDepreciationOper) {
		this.assetDepreciationOper=assetDepreciationOper;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDepreciationDetail , 转换好的 AssetDepreciationDetail 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationDetail , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetDepreciationDetail
	 * @param assetDepreciationDetailMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationDetail , 转换好的的 AssetDepreciationDetail 对象
	*/
	@Transient
	public static AssetDepreciationDetail createFrom(Map<String,Object> assetDepreciationDetailMap) {
		if(assetDepreciationDetailMap==null) return null;
		AssetDepreciationDetail po = EntityContext.create(AssetDepreciationDetail.class, assetDepreciationDetailMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationDetail
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationDetail , 转换好的的 AssetDepreciationDetail 对象
	*/
	@Transient
	public static AssetDepreciationDetail createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationDetail po = EntityContext.create(AssetDepreciationDetail.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetDepreciationDetail，等同于 new
	 * @return AssetDepreciationDetail 对象
	*/
	@Transient
	public static AssetDepreciationDetail create() {
		return EntityContext.create(AssetDepreciationDetail.class);
	}
}