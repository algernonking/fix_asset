package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 软件分发项
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:38:16
 * @sign F34A7F274B764A72F1B79A17C750BBC0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_software_distribute_data")
public class AssetSoftwareDistributeData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 软件分发：软件分发
	*/
	@ApiModelProperty(required = false,value="软件分发" , notes = "软件分发")
	private String distributeId;
	
	/**
	 * 软件信息：软件信息
	*/
	@ApiModelProperty(required = false,value="软件信息" , notes = "软件信息")
	private String softwareId;
	
	/**
	 * 授权数量：授权数量
	*/
	@ApiModelProperty(required = false,value="授权数量" , notes = "授权数量")
	private Integer authorizedNumber;
	
	/**
	 * 授权信息：授权信息
	*/
	@ApiModelProperty(required = false,value="授权信息" , notes = "授权信息")
	private String authorizedInfo;
	
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
	public AssetSoftwareDistributeData setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 软件分发<br>
	 * 软件分发
	 * @return 软件分发
	*/
	public String getDistributeId() {
		return distributeId;
	}
	
	/**
	 * 设置 软件分发
	 * @param distributeId 软件分发
	 * @return 当前对象
	*/
	public AssetSoftwareDistributeData setDistributeId(String distributeId) {
		this.distributeId=distributeId;
		return this;
	}
	
	/**
	 * 获得 软件信息<br>
	 * 软件信息
	 * @return 软件信息
	*/
	public String getSoftwareId() {
		return softwareId;
	}
	
	/**
	 * 设置 软件信息
	 * @param softwareId 软件信息
	 * @return 当前对象
	*/
	public AssetSoftwareDistributeData setSoftwareId(String softwareId) {
		this.softwareId=softwareId;
		return this;
	}
	
	/**
	 * 获得 授权数量<br>
	 * 授权数量
	 * @return 授权数量
	*/
	public Integer getAuthorizedNumber() {
		return authorizedNumber;
	}
	
	/**
	 * 设置 授权数量
	 * @param authorizedNumber 授权数量
	 * @return 当前对象
	*/
	public AssetSoftwareDistributeData setAuthorizedNumber(Integer authorizedNumber) {
		this.authorizedNumber=authorizedNumber;
		return this;
	}
	
	/**
	 * 获得 授权信息<br>
	 * 授权信息
	 * @return 授权信息
	*/
	public String getAuthorizedInfo() {
		return authorizedInfo;
	}
	
	/**
	 * 设置 授权信息
	 * @param authorizedInfo 授权信息
	 * @return 当前对象
	*/
	public AssetSoftwareDistributeData setAuthorizedInfo(String authorizedInfo) {
		this.authorizedInfo=authorizedInfo;
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
	public AssetSoftwareDistributeData setCreateBy(String createBy) {
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
	public AssetSoftwareDistributeData setCreateTime(Date createTime) {
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
	public AssetSoftwareDistributeData setUpdateBy(String updateBy) {
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
	public AssetSoftwareDistributeData setUpdateTime(Date updateTime) {
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
	public AssetSoftwareDistributeData setDeleted(Integer deleted) {
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
	public AssetSoftwareDistributeData setDeleteBy(String deleteBy) {
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
	public AssetSoftwareDistributeData setDeleteTime(Date deleteTime) {
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
	public AssetSoftwareDistributeData setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetSoftwareDistributeData , 转换好的 AssetSoftwareDistributeData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetSoftwareDistributeData , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetSoftwareDistributeData
	 * @param assetSoftwareDistributeDataMap 包含实体信息的 Map 对象
	 * @return AssetSoftwareDistributeData , 转换好的的 AssetSoftwareDistributeData 对象
	*/
	@Transient
	public static AssetSoftwareDistributeData createFrom(Map<String,Object> assetSoftwareDistributeDataMap) {
		if(assetSoftwareDistributeDataMap==null) return null;
		AssetSoftwareDistributeData po = EntityContext.create(AssetSoftwareDistributeData.class, assetSoftwareDistributeDataMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetSoftwareDistributeData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetSoftwareDistributeData , 转换好的的 AssetSoftwareDistributeData 对象
	*/
	@Transient
	public static AssetSoftwareDistributeData createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetSoftwareDistributeData po = EntityContext.create(AssetSoftwareDistributeData.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetSoftwareDistributeData，等同于 new
	 * @return AssetSoftwareDistributeData 对象
	*/
	@Transient
	public static AssetSoftwareDistributeData create() {
		return EntityContext.create(AssetSoftwareDistributeData.class);
	}
}