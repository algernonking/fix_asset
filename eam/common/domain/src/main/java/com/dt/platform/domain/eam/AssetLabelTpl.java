package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL_TPL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 标签模版
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-21 19:51:12
 * @sign 35C8DB458C2917DE64596A5F315673B3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label_tpl")
public class AssetLabelTpl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL_TPL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 类型：默认为1
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "默认为1")
	private String type;
	
	/**
	 * 是否自定义：是否自定义
	*/
	@ApiModelProperty(required = false,value="是否自定义" , notes = "是否自定义")
	private String isCustom;
	
	/**
	 * 字段：字段
	*/
	@ApiModelProperty(required = false,value="字段" , notes = "字段")
	private String colIds;
	
	/**
	 * 位置：u,d,l,r
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "u,d,l,r")
	private String imagePosition;
	
	/**
	 * 图像：图像
	*/
	@ApiModelProperty(required = false,value="图像" , notes = "图像")
	private String imageColId;
	
	/**
	 * 图像显示：图像显示
	*/
	@ApiModelProperty(required = false,value="图像显示" , notes = "图像显示")
	private String imageShow;
	
	/**
	 * 图像label显示：图像label显示
	*/
	@ApiModelProperty(required = false,value="图像label显示" , notes = "图像label显示")
	private String imageLabelShow;
	
	/**
	 * 图像类型txm：rwm
	*/
	@ApiModelProperty(required = false,value="图像类型txm" , notes = "rwm")
	private String imageType;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String labelFormatContent;
	
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
	 * Item：Item
	*/
	@ApiModelProperty(required = false,value="Item" , notes = "Item")
	private List<AssetLabelTplItem> assetLabelItemList;
	
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
	public AssetLabelTpl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 默认为1
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public AssetLabelTpl setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 是否自定义<br>
	 * 是否自定义
	 * @return 是否自定义
	*/
	public String getIsCustom() {
		return isCustom;
	}
	
	/**
	 * 设置 是否自定义
	 * @param isCustom 是否自定义
	 * @return 当前对象
	*/
	public AssetLabelTpl setIsCustom(String isCustom) {
		this.isCustom=isCustom;
		return this;
	}
	
	/**
	 * 获得 字段<br>
	 * 字段
	 * @return 字段
	*/
	public String getColIds() {
		return colIds;
	}
	
	/**
	 * 设置 字段
	 * @param colIds 字段
	 * @return 当前对象
	*/
	public AssetLabelTpl setColIds(String colIds) {
		this.colIds=colIds;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * u,d,l,r
	 * @return 位置
	*/
	public String getImagePosition() {
		return imagePosition;
	}
	
	/**
	 * 设置 位置
	 * @param imagePosition 位置
	 * @return 当前对象
	*/
	public AssetLabelTpl setImagePosition(String imagePosition) {
		this.imagePosition=imagePosition;
		return this;
	}
	
	/**
	 * 获得 图像<br>
	 * 图像
	 * @return 图像
	*/
	public String getImageColId() {
		return imageColId;
	}
	
	/**
	 * 设置 图像
	 * @param imageColId 图像
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageColId(String imageColId) {
		this.imageColId=imageColId;
		return this;
	}
	
	/**
	 * 获得 图像显示<br>
	 * 图像显示
	 * @return 图像显示
	*/
	public String getImageShow() {
		return imageShow;
	}
	
	/**
	 * 设置 图像显示
	 * @param imageShow 图像显示
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageShow(String imageShow) {
		this.imageShow=imageShow;
		return this;
	}
	
	/**
	 * 获得 图像label显示<br>
	 * 图像label显示
	 * @return 图像label显示
	*/
	public String getImageLabelShow() {
		return imageLabelShow;
	}
	
	/**
	 * 设置 图像label显示
	 * @param imageLabelShow 图像label显示
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageLabelShow(String imageLabelShow) {
		this.imageLabelShow=imageLabelShow;
		return this;
	}
	
	/**
	 * 获得 图像类型txm<br>
	 * rwm
	 * @return 图像类型txm
	*/
	public String getImageType() {
		return imageType;
	}
	
	/**
	 * 设置 图像类型txm
	 * @param imageType 图像类型txm
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageType(String imageType) {
		this.imageType=imageType;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getLabelFormatContent() {
		return labelFormatContent;
	}
	
	/**
	 * 设置 类型
	 * @param labelFormatContent 类型
	 * @return 当前对象
	*/
	public AssetLabelTpl setLabelFormatContent(String labelFormatContent) {
		this.labelFormatContent=labelFormatContent;
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
	public AssetLabelTpl setNotes(String notes) {
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
	public AssetLabelTpl setCreateBy(String createBy) {
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
	public AssetLabelTpl setCreateTime(Date createTime) {
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
	public AssetLabelTpl setUpdateBy(String updateBy) {
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
	public AssetLabelTpl setUpdateTime(Date updateTime) {
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
	public AssetLabelTpl setDeleted(Integer deleted) {
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
	public AssetLabelTpl setDeleteBy(String deleteBy) {
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
	public AssetLabelTpl setDeleteTime(Date deleteTime) {
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
	public AssetLabelTpl setVersion(Integer version) {
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
	public AssetLabelTpl setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 Item<br>
	 * Item
	 * @return Item
	*/
	public List<AssetLabelTplItem> getAssetLabelItemList() {
		return assetLabelItemList;
	}
	
	/**
	 * 设置 Item
	 * @param assetLabelItemList Item
	 * @return 当前对象
	*/
	public AssetLabelTpl setAssetLabelItemList(List<AssetLabelTplItem> assetLabelItemList) {
		this.assetLabelItemList=assetLabelItemList;
		return this;
	}
	
	/**
	 * 添加 Item
	 * @param assetLabelItem Item
	 * @return 当前对象
	*/
	public AssetLabelTpl addAssetLabelItem(AssetLabelTplItem assetLabelItem) {
		if(this.assetLabelItemList==null) assetLabelItemList=new ArrayList<>();
		this.assetLabelItemList.add(assetLabelItem);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabelTpl , 转换好的 AssetLabelTpl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelTpl , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetLabelTpl
	 * @param assetLabelTplMap 包含实体信息的 Map 对象
	 * @return AssetLabelTpl , 转换好的的 AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTpl createFrom(Map<String,Object> assetLabelTplMap) {
		if(assetLabelTplMap==null) return null;
		AssetLabelTpl po = EntityContext.create(AssetLabelTpl.class, assetLabelTplMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelTpl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelTpl , 转换好的的 AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTpl createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelTpl po = EntityContext.create(AssetLabelTpl.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetLabelTpl，等同于 new
	 * @return AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTpl create() {
		return EntityContext.create(AssetLabelTpl.class);
	}
}