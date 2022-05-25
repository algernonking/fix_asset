package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL_TPL_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 标签模版
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 09:56:56
 * @sign 6084634868C9FFC1B3AF62DBDE4132B5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label_tpl_item")
public class AssetLabelTplItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL_TPL_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版")
	private String tplId;
	
	/**
	 * 字段ID：字段ID
	*/
	@ApiModelProperty(required = false,value="字段ID" , notes = "字段ID")
	private String colId;
	
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
	 * assetLabelCol：assetLabelCol
	*/
	@ApiModelProperty(required = false,value="assetLabelCol" , notes = "assetLabelCol")
	private AssetLabelCol assetLabelCol;
	
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
	public AssetLabelTplItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模版
	 * @param tplId 模版
	 * @return 当前对象
	*/
	public AssetLabelTplItem setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 字段ID<br>
	 * 字段ID
	 * @return 字段ID
	*/
	public String getColId() {
		return colId;
	}
	
	/**
	 * 设置 字段ID
	 * @param colId 字段ID
	 * @return 当前对象
	*/
	public AssetLabelTplItem setColId(String colId) {
		this.colId=colId;
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
	public AssetLabelTplItem setSort(Integer sort) {
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
	public AssetLabelTplItem setCreateBy(String createBy) {
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
	public AssetLabelTplItem setCreateTime(Date createTime) {
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
	public AssetLabelTplItem setUpdateBy(String updateBy) {
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
	public AssetLabelTplItem setUpdateTime(Date updateTime) {
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
	public AssetLabelTplItem setDeleted(Integer deleted) {
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
	public AssetLabelTplItem setDeleteBy(String deleteBy) {
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
	public AssetLabelTplItem setDeleteTime(Date deleteTime) {
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
	public AssetLabelTplItem setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 assetLabelCol<br>
	 * assetLabelCol
	 * @return assetLabelCol
	*/
	public AssetLabelCol getAssetLabelCol() {
		return assetLabelCol;
	}
	
	/**
	 * 设置 assetLabelCol
	 * @param assetLabelCol assetLabelCol
	 * @return 当前对象
	*/
	public AssetLabelTplItem setAssetLabelCol(AssetLabelCol assetLabelCol) {
		this.assetLabelCol=assetLabelCol;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabelTplItem , 转换好的 AssetLabelTplItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelTplItem , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetLabelTplItem
	 * @param assetLabelTplItemMap 包含实体信息的 Map 对象
	 * @return AssetLabelTplItem , 转换好的的 AssetLabelTplItem 对象
	*/
	@Transient
	public static AssetLabelTplItem createFrom(Map<String,Object> assetLabelTplItemMap) {
		if(assetLabelTplItemMap==null) return null;
		AssetLabelTplItem po = EntityContext.create(AssetLabelTplItem.class, assetLabelTplItemMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelTplItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelTplItem , 转换好的的 AssetLabelTplItem 对象
	*/
	@Transient
	public static AssetLabelTplItem createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelTplItem po = EntityContext.create(AssetLabelTplItem.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetLabelTplItem，等同于 new
	 * @return AssetLabelTplItem 对象
	*/
	@Transient
	public static AssetLabelTplItem create() {
		return EntityContext.create(AssetLabelTplItem.class);
	}
}