package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_CATEGORY_TPL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 故障模版
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 05:35:08
 * @sign CB21EBDAEA21487986A779337D067366
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_category_tpl")
public class RepairCategoryTpl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_CATEGORY_TPL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 故障类型：故障类型
	*/
	@ApiModelProperty(required = false,value="故障类型" , notes = "故障类型")
	private String categoryId;
	
	/**
	 * 故障编码：故障编码
	*/
	@ApiModelProperty(required = false,value="故障编码" , notes = "故障编码")
	private String code;
	
	/**
	 * 故障内容：故障内容
	*/
	@ApiModelProperty(required = false,value="故障内容" , notes = "故障内容")
	private String name;
	
	/**
	 * 故障方案：故障方案
	*/
	@ApiModelProperty(required = false,value="故障方案" , notes = "故障方案")
	private String repairSolution;
	
	/**
	 * 标准耗时：标准耗时
	*/
	@ApiModelProperty(required = false,value="标准耗时" , notes = "标准耗时")
	private Integer costTime;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
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
	@Transient
	private Boolean deletedBool;
	
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
	 * 故障类型：故障类型
	*/
	@ApiModelProperty(required = false,value="故障类型" , notes = "故障类型")
	private RepairCategory category;
	
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
	public RepairCategoryTpl setId(String id) {
		this.id=id;
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
	public RepairCategoryTpl setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 故障类型<br>
	 * 故障类型
	 * @return 故障类型
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 故障类型
	 * @param categoryId 故障类型
	 * @return 当前对象
	*/
	public RepairCategoryTpl setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 故障编码<br>
	 * 故障编码
	 * @return 故障编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 故障编码
	 * @param code 故障编码
	 * @return 当前对象
	*/
	public RepairCategoryTpl setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 故障内容<br>
	 * 故障内容
	 * @return 故障内容
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 故障内容
	 * @param name 故障内容
	 * @return 当前对象
	*/
	public RepairCategoryTpl setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 故障方案<br>
	 * 故障方案
	 * @return 故障方案
	*/
	public String getRepairSolution() {
		return repairSolution;
	}
	
	/**
	 * 设置 故障方案
	 * @param repairSolution 故障方案
	 * @return 当前对象
	*/
	public RepairCategoryTpl setRepairSolution(String repairSolution) {
		this.repairSolution=repairSolution;
		return this;
	}
	
	/**
	 * 获得 标准耗时<br>
	 * 标准耗时
	 * @return 标准耗时
	*/
	public Integer getCostTime() {
		return costTime;
	}
	
	/**
	 * 设置 标准耗时
	 * @param costTime 标准耗时
	 * @return 当前对象
	*/
	public RepairCategoryTpl setCostTime(Integer costTime) {
		this.costTime=costTime;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 附件
	 * @param attachId 附件
	 * @return 当前对象
	*/
	public RepairCategoryTpl setAttachId(String attachId) {
		this.attachId=attachId;
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
	public RepairCategoryTpl setNotes(String notes) {
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
	public RepairCategoryTpl setCreateBy(String createBy) {
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
	public RepairCategoryTpl setCreateTime(Date createTime) {
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
	public RepairCategoryTpl setUpdateBy(String updateBy) {
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
	public RepairCategoryTpl setUpdateTime(Date updateTime) {
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
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public RepairCategoryTpl setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public RepairCategoryTpl setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
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
	public RepairCategoryTpl setDeleteBy(String deleteBy) {
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
	public RepairCategoryTpl setDeleteTime(Date deleteTime) {
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
	public RepairCategoryTpl setVersion(Integer version) {
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
	public RepairCategoryTpl setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 故障类型<br>
	 * 故障类型
	 * @return 故障类型
	*/
	public RepairCategory getCategory() {
		return category;
	}
	
	/**
	 * 设置 故障类型
	 * @param category 故障类型
	 * @return 当前对象
	*/
	public RepairCategoryTpl setCategory(RepairCategory category) {
		this.category=category;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairCategoryTpl , 转换好的 RepairCategoryTpl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairCategoryTpl , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 RepairCategoryTpl
	 * @param repairCategoryTplMap 包含实体信息的 Map 对象
	 * @return RepairCategoryTpl , 转换好的的 RepairCategoryTpl 对象
	*/
	@Transient
	public static RepairCategoryTpl createFrom(Map<String,Object> repairCategoryTplMap) {
		if(repairCategoryTplMap==null) return null;
		RepairCategoryTpl po = EntityContext.create(RepairCategoryTpl.class, repairCategoryTplMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairCategoryTpl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairCategoryTpl , 转换好的的 RepairCategoryTpl 对象
	*/
	@Transient
	public static RepairCategoryTpl createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairCategoryTpl po = EntityContext.create(RepairCategoryTpl.class,pojo);
		return po;
	}

	/**
	 * 创建一个 RepairCategoryTpl，等同于 new
	 * @return RepairCategoryTpl 对象
	*/
	@Transient
	public static RepairCategoryTpl create() {
		return EntityContext.create(RepairCategoryTpl.class);
	}
}