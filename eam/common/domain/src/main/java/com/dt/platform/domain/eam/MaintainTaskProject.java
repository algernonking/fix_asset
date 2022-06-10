package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAINTAIN_TASK_PROJECT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 保养项目
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-09 12:22:23
 * @sign 272E1CAC2FCE09C8A14061F1DBC8F8B7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_maintain_task_project")
public class MaintainTaskProject extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAINTAIN_TASK_PROJECT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private String projectId;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String taskId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 项目编号：项目编号
	*/
	@ApiModelProperty(required = false,value="项目编号" , notes = "项目编号")
	private String projectCode;
	
	/**
	 * 项目名称：项目名称
	*/
	@ApiModelProperty(required = false,value="项目名称" , notes = "项目名称")
	private String projectName;
	
	/**
	 * 保养类型：保养类型
	*/
	@ApiModelProperty(required = false,value="保养类型" , notes = "保养类型")
	private String projectMaintainType;
	
	/**
	 * 标准工时(小时)：标准工时(小时)
	*/
	@ApiModelProperty(required = false,value="标准工时(小时)" , notes = "标准工时(小时)")
	private BigDecimal projectBaseCost;
	
	/**
	 * 保养手册：保养手册
	*/
	@ApiModelProperty(required = false,value="保养手册" , notes = "保养手册")
	private String projectAttachId;
	
	/**
	 * 项目备注：项目备注
	*/
	@ApiModelProperty(required = false,value="项目备注" , notes = "项目备注")
	private String projectNotes;
	
	/**
	 * 标准工时(小时)：标准工时(小时)
	*/
	@ApiModelProperty(required = false,value="标准工时(小时)" , notes = "标准工时(小时)")
	private BigDecimal baseCost;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date endTime;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem maintainTypeDict;
	
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
	public MaintainTaskProject setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public String getProjectId() {
		return projectId;
	}
	
	/**
	 * 设置 项目
	 * @param projectId 项目
	 * @return 当前对象
	*/
	public MaintainTaskProject setProjectId(String projectId) {
		this.projectId=projectId;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务
	 * @param taskId 任务
	 * @return 当前对象
	*/
	public MaintainTaskProject setTaskId(String taskId) {
		this.taskId=taskId;
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
	public MaintainTaskProject setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 项目编号<br>
	 * 项目编号
	 * @return 项目编号
	*/
	public String getProjectCode() {
		return projectCode;
	}
	
	/**
	 * 设置 项目编号
	 * @param projectCode 项目编号
	 * @return 当前对象
	*/
	public MaintainTaskProject setProjectCode(String projectCode) {
		this.projectCode=projectCode;
		return this;
	}
	
	/**
	 * 获得 项目名称<br>
	 * 项目名称
	 * @return 项目名称
	*/
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * 设置 项目名称
	 * @param projectName 项目名称
	 * @return 当前对象
	*/
	public MaintainTaskProject setProjectName(String projectName) {
		this.projectName=projectName;
		return this;
	}
	
	/**
	 * 获得 保养类型<br>
	 * 保养类型
	 * @return 保养类型
	*/
	public String getProjectMaintainType() {
		return projectMaintainType;
	}
	
	/**
	 * 设置 保养类型
	 * @param projectMaintainType 保养类型
	 * @return 当前对象
	*/
	public MaintainTaskProject setProjectMaintainType(String projectMaintainType) {
		this.projectMaintainType=projectMaintainType;
		return this;
	}
	
	/**
	 * 获得 标准工时(小时)<br>
	 * 标准工时(小时)
	 * @return 标准工时(小时)
	*/
	public BigDecimal getProjectBaseCost() {
		return projectBaseCost;
	}
	
	/**
	 * 设置 标准工时(小时)
	 * @param projectBaseCost 标准工时(小时)
	 * @return 当前对象
	*/
	public MaintainTaskProject setProjectBaseCost(BigDecimal projectBaseCost) {
		this.projectBaseCost=projectBaseCost;
		return this;
	}
	
	/**
	 * 获得 保养手册<br>
	 * 保养手册
	 * @return 保养手册
	*/
	public String getProjectAttachId() {
		return projectAttachId;
	}
	
	/**
	 * 设置 保养手册
	 * @param projectAttachId 保养手册
	 * @return 当前对象
	*/
	public MaintainTaskProject setProjectAttachId(String projectAttachId) {
		this.projectAttachId=projectAttachId;
		return this;
	}
	
	/**
	 * 获得 项目备注<br>
	 * 项目备注
	 * @return 项目备注
	*/
	public String getProjectNotes() {
		return projectNotes;
	}
	
	/**
	 * 设置 项目备注
	 * @param projectNotes 项目备注
	 * @return 当前对象
	*/
	public MaintainTaskProject setProjectNotes(String projectNotes) {
		this.projectNotes=projectNotes;
		return this;
	}
	
	/**
	 * 获得 标准工时(小时)<br>
	 * 标准工时(小时)
	 * @return 标准工时(小时)
	*/
	public BigDecimal getBaseCost() {
		return baseCost;
	}
	
	/**
	 * 设置 标准工时(小时)
	 * @param baseCost 标准工时(小时)
	 * @return 当前对象
	*/
	public MaintainTaskProject setBaseCost(BigDecimal baseCost) {
		this.baseCost=baseCost;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public MaintainTaskProject setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public MaintainTaskProject setEndTime(Date endTime) {
		this.endTime=endTime;
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
	public MaintainTaskProject setCreateBy(String createBy) {
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
	public MaintainTaskProject setCreateTime(Date createTime) {
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
	public MaintainTaskProject setUpdateBy(String updateBy) {
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
	public MaintainTaskProject setUpdateTime(Date updateTime) {
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
	public MaintainTaskProject setDeleted(Integer deleted) {
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
	public MaintainTaskProject setDeleted(Boolean deletedBool) {
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
	public MaintainTaskProject setDeleteBy(String deleteBy) {
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
	public MaintainTaskProject setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public MaintainTaskProject setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public MaintainTaskProject setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public MaintainTaskProject setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getMaintainTypeDict() {
		return maintainTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param maintainTypeDict 类型
	 * @return 当前对象
	*/
	public MaintainTaskProject setMaintainTypeDict(DictItem maintainTypeDict) {
		this.maintainTypeDict=maintainTypeDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MaintainTaskProject , 转换好的 MaintainTaskProject 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainTaskProject , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MaintainTaskProject
	 * @param maintainTaskProjectMap 包含实体信息的 Map 对象
	 * @return MaintainTaskProject , 转换好的的 MaintainTaskProject 对象
	*/
	@Transient
	public static MaintainTaskProject createFrom(Map<String,Object> maintainTaskProjectMap) {
		if(maintainTaskProjectMap==null) return null;
		MaintainTaskProject po = EntityContext.create(MaintainTaskProject.class, maintainTaskProjectMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MaintainTaskProject
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainTaskProject , 转换好的的 MaintainTaskProject 对象
	*/
	@Transient
	public static MaintainTaskProject createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainTaskProject po = EntityContext.create(MaintainTaskProject.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MaintainTaskProject，等同于 new
	 * @return MaintainTaskProject 对象
	*/
	@Transient
	public static MaintainTaskProject create() {
		return EntityContext.create(MaintainTaskProject.class);
	}
}