package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_ATTRIBUTE_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-13 05:51:57
 * @sign C90E2F387CF2195CF6D186C7490DBA1D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_attribute_item")
public class AssetAttributeItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_ATTRIBUTE_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属模块：所属模块
	*/
	@ApiModelProperty(required = false,value="所属模块" , notes = "所属模块")
	private String ownerCode;
	
	/**
	 * 属性：属性
	*/
	@ApiModelProperty(required = false,value="属性" , notes = "属性")
	private String attributeId;
	
	/**
	 * 所属维度：所属维度
	*/
	@ApiModelProperty(required = false,value="所属维度" , notes = "所属维度")
	private String dimension;
	
	/**
	 * 必选：必选
	*/
	@ApiModelProperty(required = false,value="必选" , notes = "必选")
	private Integer required;
	
	/**
	 * 布局类型：布局类型
	*/
	@ApiModelProperty(required = false,value="布局类型" , notes = "布局类型")
	private Integer layoutType;
	
	/**
	 * 列表显示：列表显示
	*/
	@ApiModelProperty(required = false,value="列表显示" , notes = "列表显示")
	private Integer listShow;
	
	/**
	 * 列表内容：列表内容
	*/
	@ApiModelProperty(required = false,value="列表内容" , notes = "列表内容")
	private String listContent;
	
	/**
	 * 列表排序：列表排序
	*/
	@ApiModelProperty(required = false,value="列表排序" , notes = "列表排序")
	private Integer listSort;
	
	/**
	 * 表单显示：表单显示
	*/
	@ApiModelProperty(required = false,value="表单显示" , notes = "表单显示")
	private Integer formShow;
	
	/**
	 * 行布局位置：行布局位置
	*/
	@ApiModelProperty(required = false,value="行布局位置" , notes = "行布局位置")
	private Integer layoutRow;
	
	/**
	 * 列布局位置：列布局位置
	*/
	@ApiModelProperty(required = false,value="列布局位置" , notes = "列布局位置")
	private Integer layoutColumn;
	
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
	 * 属性：属性
	*/
	@ApiModelProperty(required = false,value="属性" , notes = "属性")
	private AssetAttribute attribute;
	
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
	public AssetAttributeItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属模块<br>
	 * 所属模块
	 * @return 所属模块
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 所属模块
	 * @param ownerCode 所属模块
	 * @return 当前对象
	*/
	public AssetAttributeItem setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 属性<br>
	 * 属性
	 * @return 属性
	*/
	public String getAttributeId() {
		return attributeId;
	}
	
	/**
	 * 设置 属性
	 * @param attributeId 属性
	 * @return 当前对象
	*/
	public AssetAttributeItem setAttributeId(String attributeId) {
		this.attributeId=attributeId;
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
	public AssetAttributeItem setDimension(String dimension) {
		this.dimension=dimension;
		return this;
	}
	
	/**
	 * 获得 必选<br>
	 * 必选
	 * @return 必选
	*/
	public Integer getRequired() {
		return required;
	}
	
	/**
	 * 设置 必选
	 * @param required 必选
	 * @return 当前对象
	*/
	public AssetAttributeItem setRequired(Integer required) {
		this.required=required;
		return this;
	}
	
	/**
	 * 获得 布局类型<br>
	 * 布局类型
	 * @return 布局类型
	*/
	public Integer getLayoutType() {
		return layoutType;
	}
	
	/**
	 * 设置 布局类型
	 * @param layoutType 布局类型
	 * @return 当前对象
	*/
	public AssetAttributeItem setLayoutType(Integer layoutType) {
		this.layoutType=layoutType;
		return this;
	}
	
	/**
	 * 获得 列表显示<br>
	 * 列表显示
	 * @return 列表显示
	*/
	public Integer getListShow() {
		return listShow;
	}
	
	/**
	 * 设置 列表显示
	 * @param listShow 列表显示
	 * @return 当前对象
	*/
	public AssetAttributeItem setListShow(Integer listShow) {
		this.listShow=listShow;
		return this;
	}
	
	/**
	 * 获得 列表内容<br>
	 * 列表内容
	 * @return 列表内容
	*/
	public String getListContent() {
		return listContent;
	}
	
	/**
	 * 设置 列表内容
	 * @param listContent 列表内容
	 * @return 当前对象
	*/
	public AssetAttributeItem setListContent(String listContent) {
		this.listContent=listContent;
		return this;
	}
	
	/**
	 * 获得 列表排序<br>
	 * 列表排序
	 * @return 列表排序
	*/
	public Integer getListSort() {
		return listSort;
	}
	
	/**
	 * 设置 列表排序
	 * @param listSort 列表排序
	 * @return 当前对象
	*/
	public AssetAttributeItem setListSort(Integer listSort) {
		this.listSort=listSort;
		return this;
	}
	
	/**
	 * 获得 表单显示<br>
	 * 表单显示
	 * @return 表单显示
	*/
	public Integer getFormShow() {
		return formShow;
	}
	
	/**
	 * 设置 表单显示
	 * @param formShow 表单显示
	 * @return 当前对象
	*/
	public AssetAttributeItem setFormShow(Integer formShow) {
		this.formShow=formShow;
		return this;
	}
	
	/**
	 * 获得 行布局位置<br>
	 * 行布局位置
	 * @return 行布局位置
	*/
	public Integer getLayoutRow() {
		return layoutRow;
	}
	
	/**
	 * 设置 行布局位置
	 * @param layoutRow 行布局位置
	 * @return 当前对象
	*/
	public AssetAttributeItem setLayoutRow(Integer layoutRow) {
		this.layoutRow=layoutRow;
		return this;
	}
	
	/**
	 * 获得 列布局位置<br>
	 * 列布局位置
	 * @return 列布局位置
	*/
	public Integer getLayoutColumn() {
		return layoutColumn;
	}
	
	/**
	 * 设置 列布局位置
	 * @param layoutColumn 列布局位置
	 * @return 当前对象
	*/
	public AssetAttributeItem setLayoutColumn(Integer layoutColumn) {
		this.layoutColumn=layoutColumn;
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
	public AssetAttributeItem setNotes(String notes) {
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
	public AssetAttributeItem setCreateBy(String createBy) {
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
	public AssetAttributeItem setCreateTime(Date createTime) {
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
	public AssetAttributeItem setUpdateBy(String updateBy) {
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
	public AssetAttributeItem setUpdateTime(Date updateTime) {
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
	public AssetAttributeItem setDeleted(Integer deleted) {
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
	public AssetAttributeItem setDeleteBy(String deleteBy) {
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
	public AssetAttributeItem setDeleteTime(Date deleteTime) {
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
	public AssetAttributeItem setVersion(Integer version) {
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
	public AssetAttributeItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 属性<br>
	 * 属性
	 * @return 属性
	*/
	public AssetAttribute getAttribute() {
		return attribute;
	}
	
	/**
	 * 设置 属性
	 * @param attribute 属性
	 * @return 当前对象
	*/
	public AssetAttributeItem setAttribute(AssetAttribute attribute) {
		this.attribute=attribute;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetAttributeItem , 转换好的 AssetAttributeItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetAttributeItem , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetAttributeItem
	 * @param assetAttributeItemMap 包含实体信息的 Map 对象
	 * @return AssetAttributeItem , 转换好的的 AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItem createFrom(Map<String,Object> assetAttributeItemMap) {
		if(assetAttributeItemMap==null) return null;
		AssetAttributeItem po = EntityContext.create(AssetAttributeItem.class, assetAttributeItemMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetAttributeItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetAttributeItem , 转换好的的 AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItem createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetAttributeItem po = EntityContext.create(AssetAttributeItem.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetAttributeItem，等同于 new
	 * @return AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItem create() {
		return EntityContext.create(AssetAttributeItem.class);
	}
}