package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 巡检任务
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-10 07:34:05
 * @sign E8B6CF07F758B92375C6B03577FC29BA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_task")
public class InspectionTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 巡检计划：巡检计划
	*/
	@ApiModelProperty(required = false,value="巡检计划" , notes = "巡检计划")
	private String planId;
	
	/**
	 * 任务状态：任务状态
	*/
	@ApiModelProperty(required = false,value="任务状态" , notes = "任务状态")
	private String taskStatus;
	
	/**
	 * 巡检编码：巡检编码
	*/
	@ApiModelProperty(required = false,value="巡检编码" , notes = "巡检编码")
	private String planCode;
	
	/**
	 * 巡检名称：巡检名称
	*/
	@ApiModelProperty(required = false,value="巡检名称" , notes = "巡检名称")
	private String planName;
	
	/**
	 * 巡检顺序：巡检顺序
	*/
	@ApiModelProperty(required = false,value="巡检顺序" , notes = "巡检顺序")
	private String planInspectionMethod;
	
	/**
	 * 时间要求：时间要求
	*/
	@ApiModelProperty(required = false,value="时间要求" , notes = "时间要求")
	private BigDecimal planCompletionTime;
	
	/**
	 * 巡检备注：巡检备注
	*/
	@ApiModelProperty(required = false,value="巡检备注" , notes = "巡检备注")
	private String planNotes;
	
	/**
	 * 巡检班组：巡检班组
	*/
	@ApiModelProperty(required = false,value="巡检班组" , notes = "巡检班组")
	private String groupId;
	
	/**
	 * 执行人：执行人
	*/
	@ApiModelProperty(required = false,value="执行人" , notes = "执行人")
	private String executorId;
	
	/**
	 * 应开始时间：应开始时间
	*/
	@ApiModelProperty(required = false,value="应开始时间" , notes = "应开始时间")
	private Date planStartTime;
	
	/**
	 * 实际开始时间：实际开始时间
	*/
	@ApiModelProperty(required = false,value="实际开始时间" , notes = "实际开始时间")
	private Date actStartTime;
	
	/**
	 * 实际完成时间：实际完成时间
	*/
	@ApiModelProperty(required = false,value="实际完成时间" , notes = "实际完成时间")
	private Date actFinishTime;
	
	/**
	 * 实际工时：实际工时
	*/
	@ApiModelProperty(required = false,value="实际工时" , notes = "实际工时")
	private BigDecimal actTotalCost;
	
	/**
	 * 任务反馈：任务反馈
	*/
	@ApiModelProperty(required = false,value="任务反馈" , notes = "任务反馈")
	private String content;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 计划：计划
	*/
	@ApiModelProperty(required = false,value="计划" , notes = "计划")
	private InspectionPlan inspectionPlan;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<InspectionPoint> inspectionPoint;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<String> inspectionPointIds;
	
	/**
	 * 任务巡检点：任务巡检点
	*/
	@ApiModelProperty(required = false,value="任务巡检点" , notes = "任务巡检点")
	private List<InspectionTaskPoint> inspectionTaskPoint;
	
	/**
	 * 任务巡检点：任务巡检点
	*/
	@ApiModelProperty(required = false,value="任务巡检点" , notes = "任务巡检点")
	private List<InspectionTaskPoint> inspectionTaskPointIds;
	
	/**
	 * 时间：时间
	*/
	@ApiModelProperty(required = false,value="时间" , notes = "时间")
	private DictItem timeDict;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem inspectionTypeDict;
	
	/**
	 * 班组：班组
	*/
	@ApiModelProperty(required = false,value="班组" , notes = "班组")
	private InspectionGroup inspectionGroup;
	
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
	public InspectionTask setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 巡检计划<br>
	 * 巡检计划
	 * @return 巡检计划
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 巡检计划
	 * @param planId 巡检计划
	 * @return 当前对象
	*/
	public InspectionTask setPlanId(String planId) {
		this.planId=planId;
		return this;
	}
	
	/**
	 * 获得 任务状态<br>
	 * 任务状态
	 * @return 任务状态
	*/
	public String getTaskStatus() {
		return taskStatus;
	}
	
	/**
	 * 设置 任务状态
	 * @param taskStatus 任务状态
	 * @return 当前对象
	*/
	public InspectionTask setTaskStatus(String taskStatus) {
		this.taskStatus=taskStatus;
		return this;
	}
	
	/**
	 * 获得 巡检编码<br>
	 * 巡检编码
	 * @return 巡检编码
	*/
	public String getPlanCode() {
		return planCode;
	}
	
	/**
	 * 设置 巡检编码
	 * @param planCode 巡检编码
	 * @return 当前对象
	*/
	public InspectionTask setPlanCode(String planCode) {
		this.planCode=planCode;
		return this;
	}
	
	/**
	 * 获得 巡检名称<br>
	 * 巡检名称
	 * @return 巡检名称
	*/
	public String getPlanName() {
		return planName;
	}
	
	/**
	 * 设置 巡检名称
	 * @param planName 巡检名称
	 * @return 当前对象
	*/
	public InspectionTask setPlanName(String planName) {
		this.planName=planName;
		return this;
	}
	
	/**
	 * 获得 巡检顺序<br>
	 * 巡检顺序
	 * @return 巡检顺序
	*/
	public String getPlanInspectionMethod() {
		return planInspectionMethod;
	}
	
	/**
	 * 设置 巡检顺序
	 * @param planInspectionMethod 巡检顺序
	 * @return 当前对象
	*/
	public InspectionTask setPlanInspectionMethod(String planInspectionMethod) {
		this.planInspectionMethod=planInspectionMethod;
		return this;
	}
	
	/**
	 * 获得 时间要求<br>
	 * 时间要求
	 * @return 时间要求
	*/
	public BigDecimal getPlanCompletionTime() {
		return planCompletionTime;
	}
	
	/**
	 * 设置 时间要求
	 * @param planCompletionTime 时间要求
	 * @return 当前对象
	*/
	public InspectionTask setPlanCompletionTime(BigDecimal planCompletionTime) {
		this.planCompletionTime=planCompletionTime;
		return this;
	}
	
	/**
	 * 获得 巡检备注<br>
	 * 巡检备注
	 * @return 巡检备注
	*/
	public String getPlanNotes() {
		return planNotes;
	}
	
	/**
	 * 设置 巡检备注
	 * @param planNotes 巡检备注
	 * @return 当前对象
	*/
	public InspectionTask setPlanNotes(String planNotes) {
		this.planNotes=planNotes;
		return this;
	}
	
	/**
	 * 获得 巡检班组<br>
	 * 巡检班组
	 * @return 巡检班组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 巡检班组
	 * @param groupId 巡检班组
	 * @return 当前对象
	*/
	public InspectionTask setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 执行人<br>
	 * 执行人
	 * @return 执行人
	*/
	public String getExecutorId() {
		return executorId;
	}
	
	/**
	 * 设置 执行人
	 * @param executorId 执行人
	 * @return 当前对象
	*/
	public InspectionTask setExecutorId(String executorId) {
		this.executorId=executorId;
		return this;
	}
	
	/**
	 * 获得 应开始时间<br>
	 * 应开始时间
	 * @return 应开始时间
	*/
	public Date getPlanStartTime() {
		return planStartTime;
	}
	
	/**
	 * 设置 应开始时间
	 * @param planStartTime 应开始时间
	 * @return 当前对象
	*/
	public InspectionTask setPlanStartTime(Date planStartTime) {
		this.planStartTime=planStartTime;
		return this;
	}
	
	/**
	 * 获得 实际开始时间<br>
	 * 实际开始时间
	 * @return 实际开始时间
	*/
	public Date getActStartTime() {
		return actStartTime;
	}
	
	/**
	 * 设置 实际开始时间
	 * @param actStartTime 实际开始时间
	 * @return 当前对象
	*/
	public InspectionTask setActStartTime(Date actStartTime) {
		this.actStartTime=actStartTime;
		return this;
	}
	
	/**
	 * 获得 实际完成时间<br>
	 * 实际完成时间
	 * @return 实际完成时间
	*/
	public Date getActFinishTime() {
		return actFinishTime;
	}
	
	/**
	 * 设置 实际完成时间
	 * @param actFinishTime 实际完成时间
	 * @return 当前对象
	*/
	public InspectionTask setActFinishTime(Date actFinishTime) {
		this.actFinishTime=actFinishTime;
		return this;
	}
	
	/**
	 * 获得 实际工时<br>
	 * 实际工时
	 * @return 实际工时
	*/
	public BigDecimal getActTotalCost() {
		return actTotalCost;
	}
	
	/**
	 * 设置 实际工时
	 * @param actTotalCost 实际工时
	 * @return 当前对象
	*/
	public InspectionTask setActTotalCost(BigDecimal actTotalCost) {
		this.actTotalCost=actTotalCost;
		return this;
	}
	
	/**
	 * 获得 任务反馈<br>
	 * 任务反馈
	 * @return 任务反馈
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 任务反馈
	 * @param content 任务反馈
	 * @return 当前对象
	*/
	public InspectionTask setContent(String content) {
		this.content=content;
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
	public InspectionTask setNotes(String notes) {
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
	public InspectionTask setCreateBy(String createBy) {
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
	public InspectionTask setCreateTime(Date createTime) {
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
	public InspectionTask setUpdateBy(String updateBy) {
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
	public InspectionTask setUpdateTime(Date updateTime) {
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
	public InspectionTask setDeleted(Integer deleted) {
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
	public InspectionTask setDeleted(Boolean deletedBool) {
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
	public InspectionTask setDeleteBy(String deleteBy) {
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
	public InspectionTask setDeleteTime(Date deleteTime) {
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
	public InspectionTask setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public InspectionTask setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 计划<br>
	 * 计划
	 * @return 计划
	*/
	public InspectionPlan getInspectionPlan() {
		return inspectionPlan;
	}
	
	/**
	 * 设置 计划
	 * @param inspectionPlan 计划
	 * @return 当前对象
	*/
	public InspectionTask setInspectionPlan(InspectionPlan inspectionPlan) {
		this.inspectionPlan=inspectionPlan;
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<InspectionPoint> getInspectionPoint() {
		return inspectionPoint;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPoint 巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionPoint(List<InspectionPoint> inspectionPoint) {
		this.inspectionPoint=inspectionPoint;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param entity 巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionPoint(InspectionPoint... entity) {
		if(this.inspectionPoint==null) inspectionPoint=new ArrayList<>();
		this.inspectionPoint.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<String> getInspectionPointIds() {
		return inspectionPointIds;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPointIds 巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionPointIds(List<String> inspectionPointIds) {
		this.inspectionPointIds=inspectionPointIds;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPointId 巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionPointId(String... inspectionPointId) {
		if(this.inspectionPointIds==null) inspectionPointIds=new ArrayList<>();
		this.inspectionPointIds.addAll(Arrays.asList(inspectionPointId));
		return this;
	}
	
	/**
	 * 获得 任务巡检点<br>
	 * 任务巡检点
	 * @return 任务巡检点
	*/
	public List<InspectionTaskPoint> getInspectionTaskPoint() {
		return inspectionTaskPoint;
	}
	
	/**
	 * 设置 任务巡检点
	 * @param inspectionTaskPoint 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionTaskPoint(List<InspectionTaskPoint> inspectionTaskPoint) {
		this.inspectionTaskPoint=inspectionTaskPoint;
		return this;
	}
	
	/**
	 * 添加 任务巡检点
	 * @param entity 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionTaskPoint(InspectionTaskPoint... entity) {
		if(this.inspectionTaskPoint==null) inspectionTaskPoint=new ArrayList<>();
		this.inspectionTaskPoint.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 任务巡检点<br>
	 * 任务巡检点
	 * @return 任务巡检点
	*/
	public List<InspectionTaskPoint> getInspectionTaskPointIds() {
		return inspectionTaskPointIds;
	}
	
	/**
	 * 设置 任务巡检点
	 * @param inspectionTaskPointIds 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionTaskPointIds(List<InspectionTaskPoint> inspectionTaskPointIds) {
		this.inspectionTaskPointIds=inspectionTaskPointIds;
		return this;
	}
	
	/**
	 * 添加 任务巡检点
	 * @param inspectionTaskPointId 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionTaskPointId(InspectionTaskPoint... inspectionTaskPointId) {
		if(this.inspectionTaskPointIds==null) inspectionTaskPointIds=new ArrayList<>();
		this.inspectionTaskPointIds.addAll(Arrays.asList(inspectionTaskPointId));
		return this;
	}
	
	/**
	 * 获得 时间<br>
	 * 时间
	 * @return 时间
	*/
	public DictItem getTimeDict() {
		return timeDict;
	}
	
	/**
	 * 设置 时间
	 * @param timeDict 时间
	 * @return 当前对象
	*/
	public InspectionTask setTimeDict(DictItem timeDict) {
		this.timeDict=timeDict;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getInspectionTypeDict() {
		return inspectionTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param inspectionTypeDict 类型
	 * @return 当前对象
	*/
	public InspectionTask setInspectionTypeDict(DictItem inspectionTypeDict) {
		this.inspectionTypeDict=inspectionTypeDict;
		return this;
	}
	
	/**
	 * 获得 班组<br>
	 * 班组
	 * @return 班组
	*/
	public InspectionGroup getInspectionGroup() {
		return inspectionGroup;
	}
	
	/**
	 * 设置 班组
	 * @param inspectionGroup 班组
	 * @return 当前对象
	*/
	public InspectionTask setInspectionGroup(InspectionGroup inspectionGroup) {
		this.inspectionGroup=inspectionGroup;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionTask , 转换好的 InspectionTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTask , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InspectionTask
	 * @param inspectionTaskMap 包含实体信息的 Map 对象
	 * @return InspectionTask , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTask createFrom(Map<String,Object> inspectionTaskMap) {
		if(inspectionTaskMap==null) return null;
		InspectionTask po = EntityContext.create(InspectionTask.class, inspectionTaskMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTask , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTask createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTask po = EntityContext.create(InspectionTask.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InspectionTask，等同于 new
	 * @return InspectionTask 对象
	*/
	@Transient
	public static InspectionTask create() {
		return EntityContext.create(InspectionTask.class);
	}
}