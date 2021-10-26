package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_ATTRIBUTE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 资产字段配置
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:27:05
 * @sign 4B049EACE36F2858D4347F37D9C6A484
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_attribute")
public class AssetAttribute extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_ATTRIBUTE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 字段编码：字段编码
	*/
	@ApiModelProperty(required = false,value="字段编码" , notes = "字段编码")
	private String code;
	
	/**
	 * 字段名称：字段名称
	*/
	@ApiModelProperty(required = false,value="字段名称" , notes = "字段名称")
	private String label;
	
	/**
	 * 字段值类型：字段值类型
	*/
	@ApiModelProperty(required = false,value="字段值类型" , notes = "字段值类型")
	private String valueType;
	
	/**
	 * 取值路径：取值路径
	*/
	@ApiModelProperty(required = false,value="取值路径" , notes = "取值路径")
	private String valuePath;
	
	/**
	 * 标签备注：标签备注
	*/
	@ApiModelProperty(required = false,value="标签备注" , notes = "标签备注")
	private String labelNotes;
	
	/**
	 * 所属维度：所属维度
	*/
	@ApiModelProperty(required = false,value="所属维度" , notes = "所属维度")
	private String dimension;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 是否必选：是否必选
	*/
	@ApiModelProperty(required = false,value="是否必选" , notes = "是否必选")
	private String required;
	
	/**
	 * 是否修改：是否修改
	*/
	@ApiModelProperty(required = false,value="是否修改" , notes = "是否修改")
	private String requiredModify;
	
	/**
	 * 组件类型：组件类型
	*/
	@ApiModelProperty(required = false,value="组件类型" , notes = "组件类型")
	private String componentType;
	
	/**
	 * 组件内容：组件内容
	*/
	@ApiModelProperty(required = false,value="组件内容" , notes = "组件内容")
	private String componentContent;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属")
	private String owner;
	
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
	public AssetAttribute setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 字段编码<br>
	 * 字段编码
	 * @return 字段编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 字段编码
	 * @param code 字段编码
	 * @return 当前对象
	*/
	public AssetAttribute setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 字段名称<br>
	 * 字段名称
	 * @return 字段名称
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 字段名称
	 * @param label 字段名称
	 * @return 当前对象
	*/
	public AssetAttribute setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 字段值类型<br>
	 * 字段值类型
	 * @return 字段值类型
	*/
	public String getValueType() {
		return valueType;
	}
	
	/**
	 * 设置 字段值类型
	 * @param valueType 字段值类型
	 * @return 当前对象
	*/
	public AssetAttribute setValueType(String valueType) {
		this.valueType=valueType;
		return this;
	}
	
	/**
	 * 获得 取值路径<br>
	 * 取值路径
	 * @return 取值路径
	*/
	public String getValuePath() {
		return valuePath;
	}
	
	/**
	 * 设置 取值路径
	 * @param valuePath 取值路径
	 * @return 当前对象
	*/
	public AssetAttribute setValuePath(String valuePath) {
		this.valuePath=valuePath;
		return this;
	}
	
	/**
	 * 获得 标签备注<br>
	 * 标签备注
	 * @return 标签备注
	*/
	public String getLabelNotes() {
		return labelNotes;
	}
	
	/**
	 * 设置 标签备注
	 * @param labelNotes 标签备注
	 * @return 当前对象
	*/
	public AssetAttribute setLabelNotes(String labelNotes) {
		this.labelNotes=labelNotes;
		return this;
	}
	
	/**
	 * 获得 所属维度<br>
	 * 所属维度
	 * @return 所属维度
	*/
	public String getDimension() {
		return dimension;
	}
	
	/**
	 * 设置 所属维度
	 * @param dimension 所属维度
	 * @return 当前对象
	*/
	public AssetAttribute setDimension(String dimension) {
		this.dimension=dimension;
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
	public AssetAttribute setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 是否必选<br>
	 * 是否必选
	 * @return 是否必选
	*/
	public String getRequired() {
		return required;
	}
	
	/**
	 * 设置 是否必选
	 * @param required 是否必选
	 * @return 当前对象
	*/
	public AssetAttribute setRequired(String required) {
		this.required=required;
		return this;
	}
	
	/**
	 * 获得 是否修改<br>
	 * 是否修改
	 * @return 是否修改
	*/
	public String getRequiredModify() {
		return requiredModify;
	}
	
	/**
	 * 设置 是否修改
	 * @param requiredModify 是否修改
	 * @return 当前对象
	*/
	public AssetAttribute setRequiredModify(String requiredModify) {
		this.requiredModify=requiredModify;
		return this;
	}
	
	/**
	 * 获得 组件类型<br>
	 * 组件类型
	 * @return 组件类型
	*/
	public String getComponentType() {
		return componentType;
	}
	
	/**
	 * 设置 组件类型
	 * @param componentType 组件类型
	 * @return 当前对象
	*/
	public AssetAttribute setComponentType(String componentType) {
		this.componentType=componentType;
		return this;
	}
	
	/**
	 * 获得 组件内容<br>
	 * 组件内容
	 * @return 组件内容
	*/
	public String getComponentContent() {
		return componentContent;
	}
	
	/**
	 * 设置 组件内容
	 * @param componentContent 组件内容
	 * @return 当前对象
	*/
	public AssetAttribute setComponentContent(String componentContent) {
		this.componentContent=componentContent;
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
	public AssetAttribute setNotes(String notes) {
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
	public AssetAttribute setCreateBy(String createBy) {
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
	public AssetAttribute setCreateTime(Date createTime) {
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
	public AssetAttribute setUpdateBy(String updateBy) {
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
	public AssetAttribute setUpdateTime(Date updateTime) {
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
	public AssetAttribute setDeleted(Integer deleted) {
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
	public AssetAttribute setDeleteBy(String deleteBy) {
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
	public AssetAttribute setDeleteTime(Date deleteTime) {
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
	public AssetAttribute setVersion(Integer version) {
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
	public AssetAttribute setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwner() {
		return owner;
	}
	
	/**
	 * 设置 归属
	 * @param owner 归属
	 * @return 当前对象
	*/
	public AssetAttribute setOwner(String owner) {
		this.owner=owner;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetAttribute , 转换好的 AssetAttribute 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetAttribute , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetAttribute
	 * @param assetAttributeMap 包含实体信息的 Map 对象
	 * @return AssetAttribute , 转换好的的 AssetAttribute 对象
	*/
	@Transient
	public static AssetAttribute createFrom(Map<String,Object> assetAttributeMap) {
		if(assetAttributeMap==null) return null;
		AssetAttribute po = EntityContext.create(AssetAttribute.class, assetAttributeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetAttribute
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetAttribute , 转换好的的 AssetAttribute 对象
	*/
	@Transient
	public static AssetAttribute createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetAttribute po = EntityContext.create(AssetAttribute.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetAttribute，等同于 new
	 * @return AssetAttribute 对象
	*/
	@Transient
	public static AssetAttribute create() {
		return EntityContext.create(AssetAttribute.class);
	}
}