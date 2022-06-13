package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAINTAIN_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 保养任务
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-13 20:22:29
 * @sign 2FC01F3F467B509F1F36DE91372610CB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_maintain_task")
public class MaintainTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAINTAIN_TASK.$TABLE;
	
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
	 * 逾期：逾期
	*/
	@ApiModelProperty(required = false,value="逾期" , notes = "逾期")
	private String overdue;
	
	/**
	 * 任务编码：任务编码
	*/
	@ApiModelProperty(required = false,value="任务编码" , notes = "任务编码")
	private String businessCode;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private String planId;
	
	/**
	 * 方案名称：方案名称
	*/
	@ApiModelProperty(required = false,value="方案名称" , notes = "方案名称")
	private String planName;
	
	/**
	 * 方案说明：方案说明
	*/
	@ApiModelProperty(required = false,value="方案说明" , notes = "方案说明")
	private String planInfo;
	
	/**
	 * 方案备注：方案备注
	*/
	@ApiModelProperty(required = false,value="方案备注" , notes = "方案备注")
	private String planNotes;
	
	/**
	 * 保养类型：保养类型
	*/
	@ApiModelProperty(required = false,value="保养类型" , notes = "保养类型")
	private String planMaintainType;
	
	/**
	 * 循环方式：循环方式
	*/
	@ApiModelProperty(required = false,value="循环方式" , notes = "循环方式")
	private String planCycleMethod;
	
	/**
	 * 计划工时：计划工时
	*/
	@ApiModelProperty(required = false,value="计划工时" , notes = "计划工时")
	private BigDecimal planTotalCost;
	
	/**
	 * 班组：班组
	*/
	@ApiModelProperty(required = false,value="班组" , notes = "班组")
	private String groupId;
	
	/**
	 * 设备：设备
	*/
	@ApiModelProperty(required = false,value="设备" , notes = "设备")
	private String assetId;
	
	/**
	 * 设备名称：设备名称
	*/
	@ApiModelProperty(required = false,value="设备名称" , notes = "设备名称")
	private String assetName;
	
	/**
	 * 设备型号：设备型号
	*/
	@ApiModelProperty(required = false,value="设备型号" , notes = "设备型号")
	private String assetModel;
	
	/**
	 * 设备状态：设备状态
	*/
	@ApiModelProperty(required = false,value="设备状态" , notes = "设备状态")
	private String assetStatus;
	
	/**
	 * 设备编码：设备编码
	*/
	@ApiModelProperty(required = false,value="设备编码" , notes = "设备编码")
	private String assetCode;
	
	/**
	 * 设备序列号：设备序列号
	*/
	@ApiModelProperty(required = false,value="设备序列号" , notes = "设备序列号")
	private String assetSn;
	
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
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
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
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<MaintainProject> projectList;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<String> projectIds;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<MaintainTaskProject> taskProjectList;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<String> taskProjectIds;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private MaintainPlan MaintainPlan;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem maintainTypeDict;
	
	/**
	 * 执行班组：执行班组
	*/
	@ApiModelProperty(required = false,value="执行班组" , notes = "执行班组")
	private MaintainGroup maintainGroup;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 执行人：执行人
	*/
	@ApiModelProperty(required = false,value="执行人" , notes = "执行人")
	private Employee executor;
	
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
	public MaintainTask setId(String id) {
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
	public MaintainTask setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 逾期<br>
	 * 逾期
	 * @return 逾期
	*/
	public String getOverdue() {
		return overdue;
	}
	
	/**
	 * 设置 逾期
	 * @param overdue 逾期
	 * @return 当前对象
	*/
	public MaintainTask setOverdue(String overdue) {
		this.overdue=overdue;
		return this;
	}
	
	/**
	 * 获得 任务编码<br>
	 * 任务编码
	 * @return 任务编码
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 任务编码
	 * @param businessCode 任务编码
	 * @return 当前对象
	*/
	public MaintainTask setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 方案<br>
	 * 方案
	 * @return 方案
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 方案
	 * @param planId 方案
	 * @return 当前对象
	*/
	public MaintainTask setPlanId(String planId) {
		this.planId=planId;
		return this;
	}
	
	/**
	 * 获得 方案名称<br>
	 * 方案名称
	 * @return 方案名称
	*/
	public String getPlanName() {
		return planName;
	}
	
	/**
	 * 设置 方案名称
	 * @param planName 方案名称
	 * @return 当前对象
	*/
	public MaintainTask setPlanName(String planName) {
		this.planName=planName;
		return this;
	}
	
	/**
	 * 获得 方案说明<br>
	 * 方案说明
	 * @return 方案说明
	*/
	public String getPlanInfo() {
		return planInfo;
	}
	
	/**
	 * 设置 方案说明
	 * @param planInfo 方案说明
	 * @return 当前对象
	*/
	public MaintainTask setPlanInfo(String planInfo) {
		this.planInfo=planInfo;
		return this;
	}
	
	/**
	 * 获得 方案备注<br>
	 * 方案备注
	 * @return 方案备注
	*/
	public String getPlanNotes() {
		return planNotes;
	}
	
	/**
	 * 设置 方案备注
	 * @param planNotes 方案备注
	 * @return 当前对象
	*/
	public MaintainTask setPlanNotes(String planNotes) {
		this.planNotes=planNotes;
		return this;
	}
	
	/**
	 * 获得 保养类型<br>
	 * 保养类型
	 * @return 保养类型
	*/
	public String getPlanMaintainType() {
		return planMaintainType;
	}
	
	/**
	 * 设置 保养类型
	 * @param planMaintainType 保养类型
	 * @return 当前对象
	*/
	public MaintainTask setPlanMaintainType(String planMaintainType) {
		this.planMaintainType=planMaintainType;
		return this;
	}
	
	/**
	 * 获得 循环方式<br>
	 * 循环方式
	 * @return 循环方式
	*/
	public String getPlanCycleMethod() {
		return planCycleMethod;
	}
	
	/**
	 * 设置 循环方式
	 * @param planCycleMethod 循环方式
	 * @return 当前对象
	*/
	public MaintainTask setPlanCycleMethod(String planCycleMethod) {
		this.planCycleMethod=planCycleMethod;
		return this;
	}
	
	/**
	 * 获得 计划工时<br>
	 * 计划工时
	 * @return 计划工时
	*/
	public BigDecimal getPlanTotalCost() {
		return planTotalCost;
	}
	
	/**
	 * 设置 计划工时
	 * @param planTotalCost 计划工时
	 * @return 当前对象
	*/
	public MaintainTask setPlanTotalCost(BigDecimal planTotalCost) {
		this.planTotalCost=planTotalCost;
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
	public MaintainTask setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 设备<br>
	 * 设备
	 * @return 设备
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 设备
	 * @param assetId 设备
	 * @return 当前对象
	*/
	public MaintainTask setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 设备名称<br>
	 * 设备名称
	 * @return 设备名称
	*/
	public String getAssetName() {
		return assetName;
	}
	
	/**
	 * 设置 设备名称
	 * @param assetName 设备名称
	 * @return 当前对象
	*/
	public MaintainTask setAssetName(String assetName) {
		this.assetName=assetName;
		return this;
	}
	
	/**
	 * 获得 设备型号<br>
	 * 设备型号
	 * @return 设备型号
	*/
	public String getAssetModel() {
		return assetModel;
	}
	
	/**
	 * 设置 设备型号
	 * @param assetModel 设备型号
	 * @return 当前对象
	*/
	public MaintainTask setAssetModel(String assetModel) {
		this.assetModel=assetModel;
		return this;
	}
	
	/**
	 * 获得 设备状态<br>
	 * 设备状态
	 * @return 设备状态
	*/
	public String getAssetStatus() {
		return assetStatus;
	}
	
	/**
	 * 设置 设备状态
	 * @param assetStatus 设备状态
	 * @return 当前对象
	*/
	public MaintainTask setAssetStatus(String assetStatus) {
		this.assetStatus=assetStatus;
		return this;
	}
	
	/**
	 * 获得 设备编码<br>
	 * 设备编码
	 * @return 设备编码
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 设备编码
	 * @param assetCode 设备编码
	 * @return 当前对象
	*/
	public MaintainTask setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 设备序列号<br>
	 * 设备序列号
	 * @return 设备序列号
	*/
	public String getAssetSn() {
		return assetSn;
	}
	
	/**
	 * 设置 设备序列号
	 * @param assetSn 设备序列号
	 * @return 当前对象
	*/
	public MaintainTask setAssetSn(String assetSn) {
		this.assetSn=assetSn;
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
	public MaintainTask setExecutorId(String executorId) {
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
	public MaintainTask setPlanStartTime(Date planStartTime) {
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
	public MaintainTask setActStartTime(Date actStartTime) {
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
	public MaintainTask setActFinishTime(Date actFinishTime) {
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
	public MaintainTask setActTotalCost(BigDecimal actTotalCost) {
		this.actTotalCost=actTotalCost;
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
	public MaintainTask setNotes(String notes) {
		this.notes=notes;
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
	public MaintainTask setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public MaintainTask setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public MaintainTask setCreateBy(String createBy) {
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
	public MaintainTask setCreateTime(Date createTime) {
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
	public MaintainTask setUpdateBy(String updateBy) {
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
	public MaintainTask setUpdateTime(Date updateTime) {
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
	public MaintainTask setDeleted(Integer deleted) {
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
	public MaintainTask setDeleted(Boolean deletedBool) {
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
	public MaintainTask setDeleteBy(String deleteBy) {
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
	public MaintainTask setDeleteTime(Date deleteTime) {
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
	public MaintainTask setTenantId(String tenantId) {
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
	public MaintainTask setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<MaintainProject> getProjectList() {
		return projectList;
	}
	
	/**
	 * 设置 项目
	 * @param projectList 项目
	 * @return 当前对象
	*/
	public MaintainTask setProjectList(List<MaintainProject> projectList) {
		this.projectList=projectList;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param project 项目
	 * @return 当前对象
	*/
	public MaintainTask addProject(MaintainProject... project) {
		if(this.projectList==null) projectList=new ArrayList<>();
		this.projectList.addAll(Arrays.asList(project));
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<String> getProjectIds() {
		return projectIds;
	}
	
	/**
	 * 设置 项目
	 * @param projectIds 项目
	 * @return 当前对象
	*/
	public MaintainTask setProjectIds(List<String> projectIds) {
		this.projectIds=projectIds;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param projectId 项目
	 * @return 当前对象
	*/
	public MaintainTask addProjectId(String... projectId) {
		if(this.projectIds==null) projectIds=new ArrayList<>();
		this.projectIds.addAll(Arrays.asList(projectId));
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<MaintainTaskProject> getTaskProjectList() {
		return taskProjectList;
	}
	
	/**
	 * 设置 项目
	 * @param taskProjectList 项目
	 * @return 当前对象
	*/
	public MaintainTask setTaskProjectList(List<MaintainTaskProject> taskProjectList) {
		this.taskProjectList=taskProjectList;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param taskProject 项目
	 * @return 当前对象
	*/
	public MaintainTask addTaskProject(MaintainTaskProject... taskProject) {
		if(this.taskProjectList==null) taskProjectList=new ArrayList<>();
		this.taskProjectList.addAll(Arrays.asList(taskProject));
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<String> getTaskProjectIds() {
		return taskProjectIds;
	}
	
	/**
	 * 设置 项目
	 * @param taskProjectIds 项目
	 * @return 当前对象
	*/
	public MaintainTask setTaskProjectIds(List<String> taskProjectIds) {
		this.taskProjectIds=taskProjectIds;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param taskProjectId 项目
	 * @return 当前对象
	*/
	public MaintainTask addTaskProjectId(String... taskProjectId) {
		if(this.taskProjectIds==null) taskProjectIds=new ArrayList<>();
		this.taskProjectIds.addAll(Arrays.asList(taskProjectId));
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public MaintainTask setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 方案<br>
	 * 方案
	 * @return 方案
	*/
	public MaintainPlan getMaintainPlan() {
		return MaintainPlan;
	}
	
	/**
	 * 设置 方案
	 * @param MaintainPlan 方案
	 * @return 当前对象
	*/
	public MaintainTask setMaintainPlan(MaintainPlan MaintainPlan) {
		this.MaintainPlan=MaintainPlan;
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
	public MaintainTask setMaintainTypeDict(DictItem maintainTypeDict) {
		this.maintainTypeDict=maintainTypeDict;
		return this;
	}
	
	/**
	 * 获得 执行班组<br>
	 * 执行班组
	 * @return 执行班组
	*/
	public MaintainGroup getMaintainGroup() {
		return maintainGroup;
	}
	
	/**
	 * 设置 执行班组
	 * @param maintainGroup 执行班组
	 * @return 当前对象
	*/
	public MaintainTask setMaintainGroup(MaintainGroup maintainGroup) {
		this.maintainGroup=maintainGroup;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public MaintainTask setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 执行人<br>
	 * 执行人
	 * @return 执行人
	*/
	public Employee getExecutor() {
		return executor;
	}
	
	/**
	 * 设置 执行人
	 * @param executor 执行人
	 * @return 当前对象
	*/
	public MaintainTask setExecutor(Employee executor) {
		this.executor=executor;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MaintainTask , 转换好的 MaintainTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainTask , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MaintainTask
	 * @param maintainTaskMap 包含实体信息的 Map 对象
	 * @return MaintainTask , 转换好的的 MaintainTask 对象
	*/
	@Transient
	public static MaintainTask createFrom(Map<String,Object> maintainTaskMap) {
		if(maintainTaskMap==null) return null;
		MaintainTask po = EntityContext.create(MaintainTask.class, maintainTaskMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MaintainTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainTask , 转换好的的 MaintainTask 对象
	*/
	@Transient
	public static MaintainTask createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainTask po = EntityContext.create(MaintainTask.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MaintainTask，等同于 new
	 * @return MaintainTask 对象
	*/
	@Transient
	public static MaintainTask create() {
		return EntityContext.create(MaintainTask.class);
	}
}