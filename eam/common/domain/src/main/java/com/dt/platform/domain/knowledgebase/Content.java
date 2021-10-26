package com.dt.platform.domain.knowledgebase;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.KN_CONTENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 知识库内容
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:48
 * @sign AA818F2416E29EAA21A2CAC601827860
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "kn_content")
public class Content extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =KN_CONTENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类")
	private String categoryId;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题")
	private String title;
	
	/**
	 * 简介：简介
	*/
	@ApiModelProperty(required = false,value="简介" , notes = "简介")
	private String profile;
	
	/**
	 * 关键字：关键字
	*/
	@ApiModelProperty(required = false,value="关键字" , notes = "关键字")
	private String keyWords;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 知识内容：知识内容
	*/
	@ApiModelProperty(required = false,value="知识内容" , notes = "知识内容")
	private String content;
	
	/**
	 * 内容类型：内容类型
	*/
	@ApiModelProperty(required = false,value="内容类型" , notes = "内容类型")
	private String contentType;
	
	/**
	 * 阅读数：阅读数
	*/
	@ApiModelProperty(required = false,value="阅读数" , notes = "阅读数")
	private BigDecimal reviewCount;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 是否显示：是否显示
	*/
	@ApiModelProperty(required = false,value="是否显示" , notes = "是否显示")
	private Integer display;
	
	/**
	 * 链接地址：链接地址
	*/
	@ApiModelProperty(required = false,value="链接地址" , notes = "链接地址")
	private String linkAddress;
	
	/**
	 * 等级：等级
	*/
	@ApiModelProperty(required = false,value="等级" , notes = "等级")
	private String gradeId;
	
	/**
	 * 编辑人：编辑人
	*/
	@ApiModelProperty(required = false,value="编辑人" , notes = "编辑人")
	private String editorId;
	
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
	@ApiModelProperty(required = false,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 知识分类：知识分类
	*/
	@ApiModelProperty(required = false,value="知识分类" , notes = "知识分类")
	private Category category;
	
	/**
	 * 编辑人：编辑人
	*/
	@ApiModelProperty(required = false,value="编辑人" , notes = "编辑人")
	private Employee editor;
	
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
	public Content setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 分类
	 * @param categoryId 分类
	 * @return 当前对象
	*/
	public Content setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 * @param title 标题
	 * @return 当前对象
	*/
	public Content setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 简介<br>
	 * 简介
	 * @return 简介
	*/
	public String getProfile() {
		return profile;
	}
	
	/**
	 * 设置 简介
	 * @param profile 简介
	 * @return 当前对象
	*/
	public Content setProfile(String profile) {
		this.profile=profile;
		return this;
	}
	
	/**
	 * 获得 关键字<br>
	 * 关键字
	 * @return 关键字
	*/
	public String getKeyWords() {
		return keyWords;
	}
	
	/**
	 * 设置 关键字
	 * @param keyWords 关键字
	 * @return 当前对象
	*/
	public Content setKeyWords(String keyWords) {
		this.keyWords=keyWords;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public Content setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 知识内容<br>
	 * 知识内容
	 * @return 知识内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 知识内容
	 * @param content 知识内容
	 * @return 当前对象
	*/
	public Content setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 内容类型<br>
	 * 内容类型
	 * @return 内容类型
	*/
	public String getContentType() {
		return contentType;
	}
	
	/**
	 * 设置 内容类型
	 * @param contentType 内容类型
	 * @return 当前对象
	*/
	public Content setContentType(String contentType) {
		this.contentType=contentType;
		return this;
	}
	
	/**
	 * 获得 阅读数<br>
	 * 阅读数
	 * @return 阅读数
	*/
	public BigDecimal getReviewCount() {
		return reviewCount;
	}
	
	/**
	 * 设置 阅读数
	 * @param reviewCount 阅读数
	 * @return 当前对象
	*/
	public Content setReviewCount(BigDecimal reviewCount) {
		this.reviewCount=reviewCount;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public Content setAttach(String attach) {
		this.attach=attach;
		return this;
	}
	
	/**
	 * 获得 是否显示<br>
	 * 是否显示
	 * @return 是否显示
	*/
	public Integer getDisplay() {
		return display;
	}
	
	/**
	 * 设置 是否显示
	 * @param display 是否显示
	 * @return 当前对象
	*/
	public Content setDisplay(Integer display) {
		this.display=display;
		return this;
	}
	
	/**
	 * 获得 链接地址<br>
	 * 链接地址
	 * @return 链接地址
	*/
	public String getLinkAddress() {
		return linkAddress;
	}
	
	/**
	 * 设置 链接地址
	 * @param linkAddress 链接地址
	 * @return 当前对象
	*/
	public Content setLinkAddress(String linkAddress) {
		this.linkAddress=linkAddress;
		return this;
	}
	
	/**
	 * 获得 等级<br>
	 * 等级
	 * @return 等级
	*/
	public String getGradeId() {
		return gradeId;
	}
	
	/**
	 * 设置 等级
	 * @param gradeId 等级
	 * @return 当前对象
	*/
	public Content setGradeId(String gradeId) {
		this.gradeId=gradeId;
		return this;
	}
	
	/**
	 * 获得 编辑人<br>
	 * 编辑人
	 * @return 编辑人
	*/
	public String getEditorId() {
		return editorId;
	}
	
	/**
	 * 设置 编辑人
	 * @param editorId 编辑人
	 * @return 当前对象
	*/
	public Content setEditorId(String editorId) {
		this.editorId=editorId;
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
	public Content setNotes(String notes) {
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
	public Content setCreateBy(String createBy) {
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
	public Content setCreateTime(Date createTime) {
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
	public Content setUpdateBy(String updateBy) {
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
	public Content setUpdateTime(Date updateTime) {
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
	public Content setDeleted(Integer deleted) {
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
	public Content setDeleteBy(String deleteBy) {
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
	public Content setDeleteTime(Date deleteTime) {
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
	public Content setVersion(Integer version) {
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
	public Content setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 知识分类<br>
	 * 知识分类
	 * @return 知识分类
	*/
	public Category getCategory() {
		return category;
	}
	
	/**
	 * 设置 知识分类
	 * @param category 知识分类
	 * @return 当前对象
	*/
	public Content setCategory(Category category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 编辑人<br>
	 * 编辑人
	 * @return 编辑人
	*/
	public Employee getEditor() {
		return editor;
	}
	
	/**
	 * 设置 编辑人
	 * @param editor 编辑人
	 * @return 当前对象
	*/
	public Content setEditor(Employee editor) {
		this.editor=editor;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Content , 转换好的 Content 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Content , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Content
	 * @param contentMap 包含实体信息的 Map 对象
	 * @return Content , 转换好的的 Content 对象
	*/
	@Transient
	public static Content createFrom(Map<String,Object> contentMap) {
		if(contentMap==null) return null;
		Content po = EntityContext.create(Content.class, contentMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Content
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Content , 转换好的的 Content 对象
	*/
	@Transient
	public static Content createFrom(Object pojo) {
		if(pojo==null) return null;
		Content po = EntityContext.create(Content.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Content，等同于 new
	 * @return Content 对象
	*/
	@Transient
	public static Content create() {
		return EntityContext.create(Content.class);
	}
}