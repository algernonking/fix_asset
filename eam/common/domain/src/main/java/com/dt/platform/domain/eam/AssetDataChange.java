package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DATA_CHANGE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 16:43:04
 * @sign 55C08C77A4D906C58EF5F9E6FBC72902
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_data_change")
public class AssetDataChange extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DATA_CHANGE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private String assetId;
	
	/**
	 * 变更号：变更号
	*/
	@ApiModelProperty(required = false,value="变更号" , notes = "变更号")
	private String businessCode;
	
	/**
	 * 变更类型：变更类型
	*/
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String type;
	
	/**
	 * 变更内容：变更内容
	*/
	@ApiModelProperty(required = false,value="变更内容" , notes = "变更内容")
	private String content;
	
	/**
	 * 变更人：变更人
	*/
	@ApiModelProperty(required = false,value="变更人" , notes = "变更人")
	private Date changeUserId;
	
	/**
	 * 变更时间：变更时间
	*/
	@ApiModelProperty(required = false,value="变更时间" , notes = "变更时间")
	private Date changeTime;
	
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
	public AssetDataChange setId(String id) {
		this.id=id;
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
	public AssetDataChange setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 变更号<br>
	 * 变更号
	 * @return 变更号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 变更号
	 * @param businessCode 变更号
	 * @return 当前对象
	*/
	public AssetDataChange setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 变更类型<br>
	 * 变更类型
	 * @return 变更类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 变更类型
	 * @param type 变更类型
	 * @return 当前对象
	*/
	public AssetDataChange setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 变更内容<br>
	 * 变更内容
	 * @return 变更内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 变更内容
	 * @param content 变更内容
	 * @return 当前对象
	*/
	public AssetDataChange setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 变更人<br>
	 * 变更人
	 * @return 变更人
	*/
	public Date getChangeUserId() {
		return changeUserId;
	}
	
	/**
	 * 设置 变更人
	 * @param changeUserId 变更人
	 * @return 当前对象
	*/
	public AssetDataChange setChangeUserId(Date changeUserId) {
		this.changeUserId=changeUserId;
		return this;
	}
	
	/**
	 * 获得 变更时间<br>
	 * 变更时间
	 * @return 变更时间
	*/
	public Date getChangeTime() {
		return changeTime;
	}
	
	/**
	 * 设置 变更时间
	 * @param changeTime 变更时间
	 * @return 当前对象
	*/
	public AssetDataChange setChangeTime(Date changeTime) {
		this.changeTime=changeTime;
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
	public AssetDataChange setCreateBy(String createBy) {
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
	public AssetDataChange setCreateTime(Date createTime) {
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
	public AssetDataChange setUpdateBy(String updateBy) {
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
	public AssetDataChange setUpdateTime(Date updateTime) {
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
	public AssetDataChange setDeleted(Integer deleted) {
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
	public AssetDataChange setDeleteBy(String deleteBy) {
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
	public AssetDataChange setDeleteTime(Date deleteTime) {
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
	public AssetDataChange setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDataChange , 转换好的 AssetDataChange 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDataChange , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetDataChange
	 * @param assetDataChangeMap 包含实体信息的 Map 对象
	 * @return AssetDataChange , 转换好的的 AssetDataChange 对象
	*/
	@Transient
	public static AssetDataChange createFrom(Map<String,Object> assetDataChangeMap) {
		if(assetDataChangeMap==null) return null;
		AssetDataChange po = EntityContext.create(AssetDataChange.class, assetDataChangeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDataChange
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDataChange , 转换好的的 AssetDataChange 对象
	*/
	@Transient
	public static AssetDataChange createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDataChange po = EntityContext.create(AssetDataChange.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetDataChange，等同于 new
	 * @return AssetDataChange 对象
	*/
	@Transient
	public static AssetDataChange create() {
		return EntityContext.create(AssetDataChange.class);
	}
}