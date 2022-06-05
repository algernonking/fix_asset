package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 故障申请单
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 05:30:41
 * @sign 6936FEF4BE90E7B4FB6F2E8CF68B66B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_order")
public class RepairOrder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String name;
	
	/**
	 * 维修状态：维修状态
	*/
	@ApiModelProperty(required = false,value="维修状态" , notes = "维修状态")
	private String repairStatus;
	
	/**
	 * 故障类型：故障类型
	*/
	@ApiModelProperty(required = false,value="故障类型" , notes = "故障类型")
	private String categoryTplId;
	
	/**
	 * 维修类型：维修类型
	*/
	@ApiModelProperty(required = false,value="维修类型" , notes = "维修类型")
	private String repairType;
	
	/**
	 * 紧急程度：紧急程度
	*/
	@ApiModelProperty(required = false,value="紧急程度" , notes = "紧急程度")
	private String urgencyId;
	
	/**
	 * 报修部门：报修部门
	*/
	@ApiModelProperty(required = false,value="报修部门" , notes = "报修部门")
	private String reportOrgId;
	
	/**
	 * 报修人：报修人
	*/
	@ApiModelProperty(required = false,value="报修人" , notes = "报修人")
	private String reportUserId;
	
	/**
	 * 维修费用：维修费用
	*/
	@ApiModelProperty(required = false,value="维修费用" , notes = "维修费用")
	private BigDecimal repairCost;
	
	/**
	 * 计划完成日期：计划完成日期
	*/
	@ApiModelProperty(required = false,value="计划完成日期" , notes = "计划完成日期")
	private Date planFinishDate;
	
	/**
	 * 报修内容：报修内容
	*/
	@ApiModelProperty(required = false,value="报修内容" , notes = "报修内容")
	private String content;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
	/**
	 * 维修单：维修单
	*/
	@ApiModelProperty(required = false,value="维修单" , notes = "维修单")
	private String autoAct;
	
	/**
	 * 创建规则：创建规则
	*/
	@ApiModelProperty(required = false,value="创建规则" , notes = "创建规则")
	private String autoActRule;
	
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
	private String selectedCode;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetIds;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 报修人：报修人
	*/
	@ApiModelProperty(required = false,value="报修人" , notes = "报修人")
	private Employee reportUser;
	
	/**
	 * 维修单：维修单
	*/
	@ApiModelProperty(required = false,value="维修单" , notes = "维修单")
	private RepairOrderAct orderAct;
	
	/**
	 * 验收单：验收单
	*/
	@ApiModelProperty(required = false,value="验收单" , notes = "验收单")
	private RepairOrderAcceptance orderAcceptance;
	
	/**
	 * 报修故障：报修故障
	*/
	@ApiModelProperty(required = false,value="报修故障" , notes = "报修故障")
	private RepairCategoryTpl categoryTpl;
	
	/**
	 * 紧急程度：紧急程度
	*/
	@ApiModelProperty(required = false,value="紧急程度" , notes = "紧急程度")
	private RepairUrgency repairUrgency;
	
	/**
	 * 报修部门：报修部门
	*/
	@ApiModelProperty(required = false,value="报修部门" , notes = "报修部门")
	private Organization organization;
	
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
	public RepairOrder setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public RepairOrder setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 流程<br>
	 * 流程
	 * @return 流程
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程
	 * @param procId 流程
	 * @return 当前对象
	*/
	public RepairOrder setProcId(String procId) {
		this.procId=procId;
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
	public RepairOrder setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 业务名称<br>
	 * 业务名称
	 * @return 业务名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 业务名称
	 * @param name 业务名称
	 * @return 当前对象
	*/
	public RepairOrder setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 维修状态<br>
	 * 维修状态
	 * @return 维修状态
	*/
	public String getRepairStatus() {
		return repairStatus;
	}
	
	/**
	 * 设置 维修状态
	 * @param repairStatus 维修状态
	 * @return 当前对象
	*/
	public RepairOrder setRepairStatus(String repairStatus) {
		this.repairStatus=repairStatus;
		return this;
	}
	
	/**
	 * 获得 故障类型<br>
	 * 故障类型
	 * @return 故障类型
	*/
	public String getCategoryTplId() {
		return categoryTplId;
	}
	
	/**
	 * 设置 故障类型
	 * @param categoryTplId 故障类型
	 * @return 当前对象
	*/
	public RepairOrder setCategoryTplId(String categoryTplId) {
		this.categoryTplId=categoryTplId;
		return this;
	}
	
	/**
	 * 获得 维修类型<br>
	 * 维修类型
	 * @return 维修类型
	*/
	public String getRepairType() {
		return repairType;
	}
	
	/**
	 * 设置 维修类型
	 * @param repairType 维修类型
	 * @return 当前对象
	*/
	public RepairOrder setRepairType(String repairType) {
		this.repairType=repairType;
		return this;
	}
	
	/**
	 * 获得 紧急程度<br>
	 * 紧急程度
	 * @return 紧急程度
	*/
	public String getUrgencyId() {
		return urgencyId;
	}
	
	/**
	 * 设置 紧急程度
	 * @param urgencyId 紧急程度
	 * @return 当前对象
	*/
	public RepairOrder setUrgencyId(String urgencyId) {
		this.urgencyId=urgencyId;
		return this;
	}
	
	/**
	 * 获得 报修部门<br>
	 * 报修部门
	 * @return 报修部门
	*/
	public String getReportOrgId() {
		return reportOrgId;
	}
	
	/**
	 * 设置 报修部门
	 * @param reportOrgId 报修部门
	 * @return 当前对象
	*/
	public RepairOrder setReportOrgId(String reportOrgId) {
		this.reportOrgId=reportOrgId;
		return this;
	}
	
	/**
	 * 获得 报修人<br>
	 * 报修人
	 * @return 报修人
	*/
	public String getReportUserId() {
		return reportUserId;
	}
	
	/**
	 * 设置 报修人
	 * @param reportUserId 报修人
	 * @return 当前对象
	*/
	public RepairOrder setReportUserId(String reportUserId) {
		this.reportUserId=reportUserId;
		return this;
	}
	
	/**
	 * 获得 维修费用<br>
	 * 维修费用
	 * @return 维修费用
	*/
	public BigDecimal getRepairCost() {
		return repairCost;
	}
	
	/**
	 * 设置 维修费用
	 * @param repairCost 维修费用
	 * @return 当前对象
	*/
	public RepairOrder setRepairCost(BigDecimal repairCost) {
		this.repairCost=repairCost;
		return this;
	}
	
	/**
	 * 获得 计划完成日期<br>
	 * 计划完成日期
	 * @return 计划完成日期
	*/
	public Date getPlanFinishDate() {
		return planFinishDate;
	}
	
	/**
	 * 设置 计划完成日期
	 * @param planFinishDate 计划完成日期
	 * @return 当前对象
	*/
	public RepairOrder setPlanFinishDate(Date planFinishDate) {
		this.planFinishDate=planFinishDate;
		return this;
	}
	
	/**
	 * 获得 报修内容<br>
	 * 报修内容
	 * @return 报修内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 报修内容
	 * @param content 报修内容
	 * @return 当前对象
	*/
	public RepairOrder setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public RepairOrder setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public RepairOrder setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 业务日期<br>
	 * 业务日期
	 * @return 业务日期
	*/
	public Date getBusinessDate() {
		return businessDate;
	}
	
	/**
	 * 设置 业务日期
	 * @param businessDate 业务日期
	 * @return 当前对象
	*/
	public RepairOrder setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 维修单<br>
	 * 维修单
	 * @return 维修单
	*/
	public String getAutoAct() {
		return autoAct;
	}
	
	/**
	 * 设置 维修单
	 * @param autoAct 维修单
	 * @return 当前对象
	*/
	public RepairOrder setAutoAct(String autoAct) {
		this.autoAct=autoAct;
		return this;
	}
	
	/**
	 * 获得 创建规则<br>
	 * 创建规则
	 * @return 创建规则
	*/
	public String getAutoActRule() {
		return autoActRule;
	}
	
	/**
	 * 设置 创建规则
	 * @param autoActRule 创建规则
	 * @return 当前对象
	*/
	public RepairOrder setAutoActRule(String autoActRule) {
		this.autoActRule=autoActRule;
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
	public RepairOrder setCreateBy(String createBy) {
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
	public RepairOrder setCreateTime(Date createTime) {
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
	public RepairOrder setUpdateBy(String updateBy) {
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
	public RepairOrder setUpdateTime(Date updateTime) {
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
	public RepairOrder setDeleted(Integer deleted) {
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
	public RepairOrder setDeleted(Boolean deletedBool) {
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
	public RepairOrder setDeleteBy(String deleteBy) {
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
	public RepairOrder setDeleteTime(Date deleteTime) {
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
	public RepairOrder setVersion(Integer version) {
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
	public RepairOrder setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public RepairOrder setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetList 资产
	 * @return 当前对象
	*/
	public RepairOrder setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public RepairOrder addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetIds() {
		return assetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetIds 资产列表
	 * @return 当前对象
	*/
	public RepairOrder setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public RepairOrder addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
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
	public RepairOrder setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 报修人<br>
	 * 报修人
	 * @return 报修人
	*/
	public Employee getReportUser() {
		return reportUser;
	}
	
	/**
	 * 设置 报修人
	 * @param reportUser 报修人
	 * @return 当前对象
	*/
	public RepairOrder setReportUser(Employee reportUser) {
		this.reportUser=reportUser;
		return this;
	}
	
	/**
	 * 获得 维修单<br>
	 * 维修单
	 * @return 维修单
	*/
	public RepairOrderAct getOrderAct() {
		return orderAct;
	}
	
	/**
	 * 设置 维修单
	 * @param orderAct 维修单
	 * @return 当前对象
	*/
	public RepairOrder setOrderAct(RepairOrderAct orderAct) {
		this.orderAct=orderAct;
		return this;
	}
	
	/**
	 * 获得 验收单<br>
	 * 验收单
	 * @return 验收单
	*/
	public RepairOrderAcceptance getOrderAcceptance() {
		return orderAcceptance;
	}
	
	/**
	 * 设置 验收单
	 * @param orderAcceptance 验收单
	 * @return 当前对象
	*/
	public RepairOrder setOrderAcceptance(RepairOrderAcceptance orderAcceptance) {
		this.orderAcceptance=orderAcceptance;
		return this;
	}
	
	/**
	 * 获得 报修故障<br>
	 * 报修故障
	 * @return 报修故障
	*/
	public RepairCategoryTpl getCategoryTpl() {
		return categoryTpl;
	}
	
	/**
	 * 设置 报修故障
	 * @param categoryTpl 报修故障
	 * @return 当前对象
	*/
	public RepairOrder setCategoryTpl(RepairCategoryTpl categoryTpl) {
		this.categoryTpl=categoryTpl;
		return this;
	}
	
	/**
	 * 获得 紧急程度<br>
	 * 紧急程度
	 * @return 紧急程度
	*/
	public RepairUrgency getRepairUrgency() {
		return repairUrgency;
	}
	
	/**
	 * 设置 紧急程度
	 * @param repairUrgency 紧急程度
	 * @return 当前对象
	*/
	public RepairOrder setRepairUrgency(RepairUrgency repairUrgency) {
		this.repairUrgency=repairUrgency;
		return this;
	}
	
	/**
	 * 获得 报修部门<br>
	 * 报修部门
	 * @return 报修部门
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 报修部门
	 * @param organization 报修部门
	 * @return 当前对象
	*/
	public RepairOrder setOrganization(Organization organization) {
		this.organization=organization;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairOrder , 转换好的 RepairOrder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairOrder , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 RepairOrder
	 * @param repairOrderMap 包含实体信息的 Map 对象
	 * @return RepairOrder , 转换好的的 RepairOrder 对象
	*/
	@Transient
	public static RepairOrder createFrom(Map<String,Object> repairOrderMap) {
		if(repairOrderMap==null) return null;
		RepairOrder po = EntityContext.create(RepairOrder.class, repairOrderMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairOrder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairOrder , 转换好的的 RepairOrder 对象
	*/
	@Transient
	public static RepairOrder createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairOrder po = EntityContext.create(RepairOrder.class,pojo);
		return po;
	}

	/**
	 * 创建一个 RepairOrder，等同于 new
	 * @return RepairOrder 对象
	*/
	@Transient
	public static RepairOrder create() {
		return EntityContext.create(RepairOrder.class);
	}
}