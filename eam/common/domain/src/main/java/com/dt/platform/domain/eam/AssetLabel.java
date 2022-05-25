package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 资产标签
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 13:14:50
 * @sign DA06D7AB218419507E702CF6F5EFC7DD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label")
public class AssetLabel extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = true,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String labelTplId;
	
	/**
	 * 标签宽度：标签宽度
	*/
	@ApiModelProperty(required = false,value="标签宽度" , notes = "标签宽度")
	private BigDecimal labelWidth;
	
	/**
	 * 标签高度：标签高度
	*/
	@ApiModelProperty(required = false,value="标签高度" , notes = "标签高度")
	private BigDecimal labelHeight;
	
	/**
	 * 标签布局：标签布局
	*/
	@ApiModelProperty(required = false,value="标签布局" , notes = "标签布局")
	private String labelLayout;
	
	/**
	 * 标签间隔：标签间隔
	*/
	@ApiModelProperty(required = false,value="标签间隔" , notes = "标签间隔")
	private BigDecimal labelTableMargin;
	
	/**
	 * 字体大小：字体大小
	*/
	@ApiModelProperty(required = false,value="字体大小" , notes = "字体大小")
	private Integer labelKeyFontSize;
	
	/**
	 * 字体大小：字体大小
	*/
	@ApiModelProperty(required = false,value="字体大小" , notes = "字体大小")
	private Integer labelValueFontSize;
	
	/**
	 * 图形宽度：图形宽度
	*/
	@ApiModelProperty(required = false,value="图形宽度" , notes = "图形宽度")
	private Integer imageWidth;
	
	/**
	 * 图形高度：图形高度
	*/
	@ApiModelProperty(required = false,value="图形高度" , notes = "图形高度")
	private Integer imageHeight;
	
	/**
	 * 纸张类型：纸张类型
	*/
	@ApiModelProperty(required = false,value="纸张类型" , notes = "纸张类型")
	private String paperTypeId;
	
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
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版")
	private AssetLabelTpl assetTpl;
	
	/**
	 * 纸张类型：纸张类型
	*/
	@ApiModelProperty(required = false,value="纸张类型" , notes = "纸张类型")
	private AssetLabelPaper assetPaper;
	
	/**
	 * ColumnList：ColumnList
	*/
	@ApiModelProperty(required = false,value="ColumnList" , notes = "ColumnList")
	private List<AssetLabelCol> assetLabelColumnList;
	
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
	public AssetLabel setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public AssetLabel setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabelTplId() {
		return labelTplId;
	}
	
	/**
	 * 设置 标签
	 * @param labelTplId 标签
	 * @return 当前对象
	*/
	public AssetLabel setLabelTplId(String labelTplId) {
		this.labelTplId=labelTplId;
		return this;
	}
	
	/**
	 * 获得 标签宽度<br>
	 * 标签宽度
	 * @return 标签宽度
	*/
	public BigDecimal getLabelWidth() {
		return labelWidth;
	}
	
	/**
	 * 设置 标签宽度
	 * @param labelWidth 标签宽度
	 * @return 当前对象
	*/
	public AssetLabel setLabelWidth(BigDecimal labelWidth) {
		this.labelWidth=labelWidth;
		return this;
	}
	
	/**
	 * 获得 标签高度<br>
	 * 标签高度
	 * @return 标签高度
	*/
	public BigDecimal getLabelHeight() {
		return labelHeight;
	}
	
	/**
	 * 设置 标签高度
	 * @param labelHeight 标签高度
	 * @return 当前对象
	*/
	public AssetLabel setLabelHeight(BigDecimal labelHeight) {
		this.labelHeight=labelHeight;
		return this;
	}
	
	/**
	 * 获得 标签布局<br>
	 * 标签布局
	 * @return 标签布局
	*/
	public String getLabelLayout() {
		return labelLayout;
	}
	
	/**
	 * 设置 标签布局
	 * @param labelLayout 标签布局
	 * @return 当前对象
	*/
	public AssetLabel setLabelLayout(String labelLayout) {
		this.labelLayout=labelLayout;
		return this;
	}
	
	/**
	 * 获得 标签间隔<br>
	 * 标签间隔
	 * @return 标签间隔
	*/
	public BigDecimal getLabelTableMargin() {
		return labelTableMargin;
	}
	
	/**
	 * 设置 标签间隔
	 * @param labelTableMargin 标签间隔
	 * @return 当前对象
	*/
	public AssetLabel setLabelTableMargin(BigDecimal labelTableMargin) {
		this.labelTableMargin=labelTableMargin;
		return this;
	}
	
	/**
	 * 获得 字体大小<br>
	 * 字体大小
	 * @return 字体大小
	*/
	public Integer getLabelKeyFontSize() {
		return labelKeyFontSize;
	}
	
	/**
	 * 设置 字体大小
	 * @param labelKeyFontSize 字体大小
	 * @return 当前对象
	*/
	public AssetLabel setLabelKeyFontSize(Integer labelKeyFontSize) {
		this.labelKeyFontSize=labelKeyFontSize;
		return this;
	}
	
	/**
	 * 获得 字体大小<br>
	 * 字体大小
	 * @return 字体大小
	*/
	public Integer getLabelValueFontSize() {
		return labelValueFontSize;
	}
	
	/**
	 * 设置 字体大小
	 * @param labelValueFontSize 字体大小
	 * @return 当前对象
	*/
	public AssetLabel setLabelValueFontSize(Integer labelValueFontSize) {
		this.labelValueFontSize=labelValueFontSize;
		return this;
	}
	
	/**
	 * 获得 图形宽度<br>
	 * 图形宽度
	 * @return 图形宽度
	*/
	public Integer getImageWidth() {
		return imageWidth;
	}
	
	/**
	 * 设置 图形宽度
	 * @param imageWidth 图形宽度
	 * @return 当前对象
	*/
	public AssetLabel setImageWidth(Integer imageWidth) {
		this.imageWidth=imageWidth;
		return this;
	}
	
	/**
	 * 获得 图形高度<br>
	 * 图形高度
	 * @return 图形高度
	*/
	public Integer getImageHeight() {
		return imageHeight;
	}
	
	/**
	 * 设置 图形高度
	 * @param imageHeight 图形高度
	 * @return 当前对象
	*/
	public AssetLabel setImageHeight(Integer imageHeight) {
		this.imageHeight=imageHeight;
		return this;
	}
	
	/**
	 * 获得 纸张类型<br>
	 * 纸张类型
	 * @return 纸张类型
	*/
	public String getPaperTypeId() {
		return paperTypeId;
	}
	
	/**
	 * 设置 纸张类型
	 * @param paperTypeId 纸张类型
	 * @return 当前对象
	*/
	public AssetLabel setPaperTypeId(String paperTypeId) {
		this.paperTypeId=paperTypeId;
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
	public AssetLabel setCreateBy(String createBy) {
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
	public AssetLabel setCreateTime(Date createTime) {
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
	public AssetLabel setUpdateBy(String updateBy) {
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
	public AssetLabel setUpdateTime(Date updateTime) {
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
	public AssetLabel setDeleted(Integer deleted) {
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
	public AssetLabel setDeleteBy(String deleteBy) {
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
	public AssetLabel setDeleteTime(Date deleteTime) {
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
	public AssetLabel setVersion(Integer version) {
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
	public AssetLabel setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public AssetLabelTpl getAssetTpl() {
		return assetTpl;
	}
	
	/**
	 * 设置 模版
	 * @param assetTpl 模版
	 * @return 当前对象
	*/
	public AssetLabel setAssetTpl(AssetLabelTpl assetTpl) {
		this.assetTpl=assetTpl;
		return this;
	}
	
	/**
	 * 获得 纸张类型<br>
	 * 纸张类型
	 * @return 纸张类型
	*/
	public AssetLabelPaper getAssetPaper() {
		return assetPaper;
	}
	
	/**
	 * 设置 纸张类型
	 * @param assetPaper 纸张类型
	 * @return 当前对象
	*/
	public AssetLabel setAssetPaper(AssetLabelPaper assetPaper) {
		this.assetPaper=assetPaper;
		return this;
	}
	
	/**
	 * 获得 ColumnList<br>
	 * ColumnList
	 * @return ColumnList
	*/
	public List<AssetLabelCol> getAssetLabelColumnList() {
		return assetLabelColumnList;
	}
	
	/**
	 * 设置 ColumnList
	 * @param assetLabelColumnList ColumnList
	 * @return 当前对象
	*/
	public AssetLabel setAssetLabelColumnList(List<AssetLabelCol> assetLabelColumnList) {
		this.assetLabelColumnList=assetLabelColumnList;
		return this;
	}
	
	/**
	 * 添加 ColumnList
	 * @param assetLabelColumn ColumnList
	 * @return 当前对象
	*/
	public AssetLabel addAssetLabelColumn(AssetLabelCol assetLabelColumn) {
		if(this.assetLabelColumnList==null) assetLabelColumnList=new ArrayList<>();
		this.assetLabelColumnList.add(assetLabelColumn);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabel , 转换好的 AssetLabel 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabel , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetLabel
	 * @param assetLabelMap 包含实体信息的 Map 对象
	 * @return AssetLabel , 转换好的的 AssetLabel 对象
	*/
	@Transient
	public static AssetLabel createFrom(Map<String,Object> assetLabelMap) {
		if(assetLabelMap==null) return null;
		AssetLabel po = EntityContext.create(AssetLabel.class, assetLabelMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabel , 转换好的的 AssetLabel 对象
	*/
	@Transient
	public static AssetLabel createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabel po = EntityContext.create(AssetLabel.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetLabel，等同于 new
	 * @return AssetLabel 对象
	*/
	@Transient
	public static AssetLabel create() {
		return EntityContext.create(AssetLabel.class);
	}
}