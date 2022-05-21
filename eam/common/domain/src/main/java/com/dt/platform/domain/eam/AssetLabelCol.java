package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL_COL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 标签字段
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-20 21:16:59
 * @sign 5EE1DDB9D5F840A741AF97F47964C873
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label_col")
public class AssetLabelCol extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL_COL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 字段：字段
	*/
	@ApiModelProperty(required = false,value="字段" , notes = "字段")
	private String colValue;
	
	/**
	 * 字段名称：字段名称
	*/
	@ApiModelProperty(required = false,value="字段名称" , notes = "字段名称")
	private String colName;
	
	/**
	 * 是否图像：是否图像
	*/
	@ApiModelProperty(required = false,value="是否图像" , notes = "是否图像")
	private String isImage;
	
	/**
	 * 图像类型：rwm|txm
	*/
	@ApiModelProperty(required = false,value="图像类型" , notes = "rwm|txm")
	private String imageType;
	
	/**
	 * 顺序：顺序
	*/
	@ApiModelProperty(required = false,value="顺序" , notes = "顺序")
	private Integer sort;
	
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
	public AssetLabelCol setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 字段<br>
	 * 字段
	 * @return 字段
	*/
	public String getColValue() {
		return colValue;
	}
	
	/**
	 * 设置 字段
	 * @param colValue 字段
	 * @return 当前对象
	*/
	public AssetLabelCol setColValue(String colValue) {
		this.colValue=colValue;
		return this;
	}
	
	/**
	 * 获得 字段名称<br>
	 * 字段名称
	 * @return 字段名称
	*/
	public String getColName() {
		return colName;
	}
	
	/**
	 * 设置 字段名称
	 * @param colName 字段名称
	 * @return 当前对象
	*/
	public AssetLabelCol setColName(String colName) {
		this.colName=colName;
		return this;
	}
	
	/**
	 * 获得 是否图像<br>
	 * 是否图像
	 * @return 是否图像
	*/
	public String getIsImage() {
		return isImage;
	}
	
	/**
	 * 设置 是否图像
	 * @param isImage 是否图像
	 * @return 当前对象
	*/
	public AssetLabelCol setIsImage(String isImage) {
		this.isImage=isImage;
		return this;
	}
	
	/**
	 * 获得 图像类型<br>
	 * rwm|txm
	 * @return 图像类型
	*/
	public String getImageType() {
		return imageType;
	}
	
	/**
	 * 设置 图像类型
	 * @param imageType 图像类型
	 * @return 当前对象
	*/
	public AssetLabelCol setImageType(String imageType) {
		this.imageType=imageType;
		return this;
	}
	
	/**
	 * 获得 顺序<br>
	 * 顺序
	 * @return 顺序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 顺序
	 * @param sort 顺序
	 * @return 当前对象
	*/
	public AssetLabelCol setSort(Integer sort) {
		this.sort=sort;
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
	public AssetLabelCol setCreateBy(String createBy) {
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
	public AssetLabelCol setCreateTime(Date createTime) {
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
	public AssetLabelCol setUpdateBy(String updateBy) {
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
	public AssetLabelCol setUpdateTime(Date updateTime) {
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
	public AssetLabelCol setDeleted(Integer deleted) {
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
	public AssetLabelCol setDeleteBy(String deleteBy) {
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
	public AssetLabelCol setDeleteTime(Date deleteTime) {
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
	public AssetLabelCol setVersion(Integer version) {
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
	public AssetLabelCol setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabelCol , 转换好的 AssetLabelCol 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelCol , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetLabelCol
	 * @param assetLabelColMap 包含实体信息的 Map 对象
	 * @return AssetLabelCol , 转换好的的 AssetLabelCol 对象
	*/
	@Transient
	public static AssetLabelCol createFrom(Map<String,Object> assetLabelColMap) {
		if(assetLabelColMap==null) return null;
		AssetLabelCol po = EntityContext.create(AssetLabelCol.class, assetLabelColMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelCol
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelCol , 转换好的的 AssetLabelCol 对象
	*/
	@Transient
	public static AssetLabelCol createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelCol po = EntityContext.create(AssetLabelCol.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetLabelCol，等同于 new
	 * @return AssetLabelCol 对象
	*/
	@Transient
	public static AssetLabelCol create() {
		return EntityContext.create(AssetLabelCol.class);
	}
}