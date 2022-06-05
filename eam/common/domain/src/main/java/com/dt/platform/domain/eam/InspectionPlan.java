package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 巡检计划
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 12:17:56
 * @sign 93ED77E11FB1CD2FB41A0FDA575B4665
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_plan")
public class InspectionPlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_PLAN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 计划编号：计划编号
	*/
	@ApiModelProperty(required = false,value="计划编号" , notes = "计划编号")
	private String planCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String planStatus;
	
	/**
	 * 计划类型：计划类型
	*/
	@ApiModelProperty(required = false,value="计划类型" , notes = "计划类型")
	private String planType;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String leaderId;
	
	/**
	 * 班组：班组
	*/
	@ApiModelProperty(required = false,value="班组" , notes = "班组")
	private String groupId;
	
	/**
	 * 开始日期：开始日期
	*/
	@ApiModelProperty(required = false,value="开始日期" , notes = "开始日期")
	private Date startDate;
	
	/**
	 * 截止日期：截止日期
	*/
	@ApiModelProperty(required = false,value="截止日期" , notes = "截止日期")
	private Date endDate;
	
	/**
	 * 周期：周期
	*/
	@ApiModelProperty(required = false,value="周期" , notes = "周期")
	private String actionCycle;
	
	/**
	 * 巡检顺序：巡检顺序
	*/
	@ApiModelProperty(required = false,value="巡检顺序" , notes = "巡检顺序")
	private String inspectionMethod;
	
	/**
	 * 时间要求：时间要求
	*/
	@ApiModelProperty(required = false,value="时间要求" , notes = "时间要求")
	private BigDecimal completionTime;
	
	/**
	 * 超时处理：超时处理
	*/
	@ApiModelProperty(required = false,value="超时处理" , notes = "超时处理")
	private String overtimeMethod;
	
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
	 * 班组：班组
	*/
	@ApiModelProperty(required = false,value="班组" , notes = "班组")
	private InspectionGroup inspectionGroup;
	
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
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<InspectionPlanPoint> inspectionPlanPointList;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<String> inspectionPlanPointIds;
	
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
	public InspectionPlan setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 计划编号<br>
	 * 计划编号
	 * @return 计划编号
	*/
	public String getPlanCode() {
		return planCode;
	}
	
	/**
	 * 设置 计划编号
	 * @param planCode 计划编号
	 * @return 当前对象
	*/
	public InspectionPlan setPlanCode(String planCode) {
		this.planCode=planCode;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public InspectionPlan setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public InspectionPlan setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getPlanStatus() {
		return planStatus;
	}
	
	/**
	 * 设置 状态
	 * @param planStatus 状态
	 * @return 当前对象
	*/
	public InspectionPlan setPlanStatus(String planStatus) {
		this.planStatus=planStatus;
		return this;
	}
	
	/**
	 * 获得 计划类型<br>
	 * 计划类型
	 * @return 计划类型
	*/
	public String getPlanType() {
		return planType;
	}
	
	/**
	 * 设置 计划类型
	 * @param planType 计划类型
	 * @return 当前对象
	*/
	public InspectionPlan setPlanType(String planType) {
		this.planType=planType;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getLeaderId() {
		return leaderId;
	}
	
	/**
	 * 设置 负责人
	 * @param leaderId 负责人
	 * @return 当前对象
	*/
	public InspectionPlan setLeaderId(String leaderId) {
		this.leaderId=leaderId;
		return this;
	}
	
	/**
	 * 获得 班组<br>
	 * 班组
	 * @return 班组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 班组
	 * @param groupId 班组
	 * @return 当前对象
	*/
	public InspectionPlan setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 开始日期<br>
	 * 开始日期
	 * @return 开始日期
	*/
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * 设置 开始日期
	 * @param startDate 开始日期
	 * @return 当前对象
	*/
	public InspectionPlan setStartDate(Date startDate) {
		this.startDate=startDate;
		return this;
	}
	
	/**
	 * 获得 截止日期<br>
	 * 截止日期
	 * @return 截止日期
	*/
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * 设置 截止日期
	 * @param endDate 截止日期
	 * @return 当前对象
	*/
	public InspectionPlan setEndDate(Date endDate) {
		this.endDate=endDate;
		return this;
	}
	
	/**
	 * 获得 周期<br>
	 * 周期
	 * @return 周期
	*/
	public String getActionCycle() {
		return actionCycle;
	}
	
	/**
	 * 设置 周期
	 * @param actionCycle 周期
	 * @return 当前对象
	*/
	public InspectionPlan setActionCycle(String actionCycle) {
		this.actionCycle=actionCycle;
		return this;
	}
	
	/**
	 * 获得 巡检顺序<br>
	 * 巡检顺序
	 * @return 巡检顺序
	*/
	public String getInspectionMethod() {
		return inspectionMethod;
	}
	
	/**
	 * 设置 巡检顺序
	 * @param inspectionMethod 巡检顺序
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionMethod(String inspectionMethod) {
		this.inspectionMethod=inspectionMethod;
		return this;
	}
	
	/**
	 * 获得 时间要求<br>
	 * 时间要求
	 * @return 时间要求
	*/
	public BigDecimal getCompletionTime() {
		return completionTime;
	}
	
	/**
	 * 设置 时间要求
	 * @param completionTime 时间要求
	 * @return 当前对象
	*/
	public InspectionPlan setCompletionTime(BigDecimal completionTime) {
		this.completionTime=completionTime;
		return this;
	}
	
	/**
	 * 获得 超时处理<br>
	 * 超时处理
	 * @return 超时处理
	*/
	public String getOvertimeMethod() {
		return overtimeMethod;
	}
	
	/**
	 * 设置 超时处理
	 * @param overtimeMethod 超时处理
	 * @return 当前对象
	*/
	public InspectionPlan setOvertimeMethod(String overtimeMethod) {
		this.overtimeMethod=overtimeMethod;
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
	public InspectionPlan setNotes(String notes) {
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
	public InspectionPlan setCreateBy(String createBy) {
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
	public InspectionPlan setCreateTime(Date createTime) {
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
	public InspectionPlan setUpdateBy(String updateBy) {
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
	public InspectionPlan setUpdateTime(Date updateTime) {
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
	public InspectionPlan setDeleted(Integer deleted) {
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
	public InspectionPlan setDeleted(Boolean deletedBool) {
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
	public InspectionPlan setDeleteBy(String deleteBy) {
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
	public InspectionPlan setDeleteTime(Date deleteTime) {
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
	public InspectionPlan setTenantId(String tenantId) {
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
	public InspectionPlan setVersion(Integer version) {
		this.version=version;
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
	public InspectionPlan setInspectionGroup(InspectionGroup inspectionGroup) {
		this.inspectionGroup=inspectionGroup;
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
	public InspectionPlan setTimeDict(DictItem timeDict) {
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
	public InspectionPlan setInspectionTypeDict(DictItem inspectionTypeDict) {
		this.inspectionTypeDict=inspectionTypeDict;
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<InspectionPlanPoint> getInspectionPlanPointList() {
		return inspectionPlanPointList;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPlanPointList 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionPlanPointList(List<InspectionPlanPoint> inspectionPlanPointList) {
		this.inspectionPlanPointList=inspectionPlanPointList;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPlanPoint 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan addInspectionPlanPoint(InspectionPlanPoint... inspectionPlanPoint) {
		if(this.inspectionPlanPointList==null) inspectionPlanPointList=new ArrayList<>();
		this.inspectionPlanPointList.addAll(Arrays.asList(inspectionPlanPoint));
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<String> getInspectionPlanPointIds() {
		return inspectionPlanPointIds;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPlanPointIds 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionPlanPointIds(List<String> inspectionPlanPointIds) {
		this.inspectionPlanPointIds=inspectionPlanPointIds;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPlanPointId 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan addInspectionPlanPointId(String... inspectionPlanPointId) {
		if(this.inspectionPlanPointIds==null) inspectionPlanPointIds=new ArrayList<>();
		this.inspectionPlanPointIds.addAll(Arrays.asList(inspectionPlanPointId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionPlan , 转换好的 InspectionPlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionPlan , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InspectionPlan
	 * @param inspectionPlanMap 包含实体信息的 Map 对象
	 * @return InspectionPlan , 转换好的的 InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlan createFrom(Map<String,Object> inspectionPlanMap) {
		if(inspectionPlanMap==null) return null;
		InspectionPlan po = EntityContext.create(InspectionPlan.class, inspectionPlanMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionPlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionPlan , 转换好的的 InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlan createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionPlan po = EntityContext.create(InspectionPlan.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InspectionPlan，等同于 new
	 * @return InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlan create() {
		return EntityContext.create(InspectionPlan.class);
	}
}