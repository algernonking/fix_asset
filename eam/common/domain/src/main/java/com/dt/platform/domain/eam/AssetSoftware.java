package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_SOFTWARE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 软件资产
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-06 21:34:26
 * @sign 1B84BCA61152A65A4B61686FD338FDCF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_software")
public class AssetSoftware extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_SOFTWARE.$TABLE;
	
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
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerCode;
	
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
	 * 软件名称：软件名称
	*/
	@ApiModelProperty(required = false,value="软件名称" , notes = "软件名称")
	private String name;
	
	/**
	 * 软件分类：软件分类
	*/
	@ApiModelProperty(required = false,value="软件分类" , notes = "软件分类")
	private String categoryId;
	
	/**
	 * 软件编号：软件编号
	*/
	@ApiModelProperty(required = false,value="软件编号" , notes = "软件编号")
	private String code;
	
	/**
	 * 软件版本：软件版本
	*/
	@ApiModelProperty(required = false,value="软件版本" , notes = "软件版本")
	private String softwareVersion;
	
	/**
	 * 版权类型：版权类型
	*/
	@ApiModelProperty(required = false,value="版权类型" , notes = "版权类型")
	private String copyrightType;
	
	/**
	 * 许可方式：许可方式
	*/
	@ApiModelProperty(required = false,value="许可方式" , notes = "许可方式")
	private String licenseMode;
	
	/**
	 * 成本：成本
	*/
	@ApiModelProperty(required = false,value="成本" , notes = "成本")
	private BigDecimal costPrice;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 使用公司：使用公司
	*/
	@ApiModelProperty(required = false,value="使用公司" , notes = "使用公司")
	private String useOrganizationId;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private String supplierId;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private String managerId;
	
	/**
	 * 详细位置：详细位置
	*/
	@ApiModelProperty(required = false,value="详细位置" , notes = "详细位置")
	private String positionDetail;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String sourceId;
	
	/**
	 * 来源明细：来源明细
	*/
	@ApiModelProperty(required = false,value="来源明细" , notes = "来源明细")
	private String sourceDetail;
	
	/**
	 * 授权信息：授权信息
	*/
	@ApiModelProperty(required = false,value="授权信息" , notes = "授权信息")
	private String authorizationInfo;
	
	/**
	 * 授权数量：授权数量
	*/
	@ApiModelProperty(required = false,value="授权数量" , notes = "授权数量")
	private Integer authorizedNumber;
	
	/**
	 * 可用数量：可用数量
	*/
	@ApiModelProperty(required = false,value="可用数量" , notes = "可用数量")
	private Integer authorizedAvailableNumber;
	
	/**
	 * 无限授权：无限授权
	*/
	@ApiModelProperty(required = false,value="无限授权" , notes = "无限授权")
	private String authorizedNumberUnlimit;
	
	/**
	 * 授权码：授权码
	*/
	@ApiModelProperty(required = false,value="授权码" , notes = "授权码")
	private String authorizationCode;
	
	/**
	 * 授权到期时间：授权到期时间
	*/
	@ApiModelProperty(required = false,value="授权到期时间" , notes = "授权到期时间")
	private Date authorizationExpirationDate;
	
	/**
	 * 永久授权：永久授权
	*/
	@ApiModelProperty(required = false,value="永久授权" , notes = "永久授权")
	private String authorizationExpirationUnlimit;
	
	/**
	 * 是否维保：是否维保
	*/
	@ApiModelProperty(required = false,value="是否维保" , notes = "是否维保")
	private String needMaintenance;
	
	/**
	 * 维保开始时间：维保开始时间
	*/
	@ApiModelProperty(required = false,value="维保开始时间" , notes = "维保开始时间")
	private Date maintenanceStartDate;
	
	/**
	 * 维保到期时间：维保到期时间
	*/
	@ApiModelProperty(required = false,value="维保到期时间" , notes = "维保到期时间")
	private Date maintenanceEndDate;
	
	/**
	 * 购置日期：购置日期
	*/
	@ApiModelProperty(required = false,value="购置日期" , notes = "购置日期")
	private Date purchaseDate;
	
	/**
	 * 登记时间：登记时间
	*/
	@ApiModelProperty(required = false,value="登记时间" , notes = "登记时间")
	private Date registerDate;
	
	/**
	 * 软件说明：软件说明
	*/
	@ApiModelProperty(required = false,value="软件说明" , notes = "软件说明")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
	/**
	 * 标签1：标签1
	*/
	@ApiModelProperty(required = false,value="标签1" , notes = "标签1")
	private String label1;
	
	/**
	 * 标签2：标签2
	*/
	@ApiModelProperty(required = false,value="标签2" , notes = "标签2")
	private String label2;
	
	/**
	 * 标签3：标签3
	*/
	@ApiModelProperty(required = false,value="标签3" , notes = "标签3")
	private String label3;
	
	/**
	 * 标签4：标签4
	*/
	@ApiModelProperty(required = false,value="标签4" , notes = "标签4")
	private String label4;
	
	/**
	 * 控制：控制
	*/
	@ApiModelProperty(required = false,value="控制" , notes = "控制")
	private String ctl;
	
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除")
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
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 变更类型：变更类型
	*/
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String chsType;
	
	/**
	 * 变更状态：变更状态
	*/
	@ApiModelProperty(required = false,value="变更状态" , notes = "变更状态")
	private String chsStatus;
	
	/**
	 * 变更版本号：变更版本号
	*/
	@ApiModelProperty(required = false,value="变更版本号" , notes = "变更版本号")
	private String chsVersion;
	
	/**
	 * 变更ID：变更ID
	*/
	@ApiModelProperty(required = false,value="变更ID" , notes = "变更ID")
	private String changeInstanceId;
	
	/**
	 * 流程概要：流程概要
	*/
	@ApiModelProperty(required = false,value="流程概要" , notes = "流程概要")
	private String summary;
	
	/**
	 * 最后审批人账户ID：最后审批人账户ID
	*/
	@ApiModelProperty(required = false,value="最后审批人账户ID" , notes = "最后审批人账户ID")
	private String latestApproverId;
	
	/**
	 * 最后审批人姓名：最后审批人姓名
	*/
	@ApiModelProperty(required = false,value="最后审批人姓名" , notes = "最后审批人姓名")
	private String latestApproverName;
	
	/**
	 * 下一节点审批人：下一节点审批人
	*/
	@ApiModelProperty(required = false,value="下一节点审批人" , notes = "下一节点审批人")
	private String nextApproverIds;
	
	/**
	 * 下一个审批节点审批人姓名：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人姓名" , notes = "用逗号隔开")
	private String nextApproverNames;
	
	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见")
	private String approvalOpinion;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Catalog category;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Organization ownerCompany;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private DictItem source;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private Employee manager;
	
	/**
	 * 版权：版权
	*/
	@ApiModelProperty(required = false,value="版权" , notes = "版权")
	private DictItem copyrightTypeDict;
	
	/**
	 * 许可：许可
	*/
	@ApiModelProperty(required = false,value="许可" , notes = "许可")
	private DictItem licenseModeDict;
	
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
	public AssetSoftware setId(String id) {
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
	public AssetSoftware setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 所属
	 * @param ownerCode 所属
	 * @return 当前对象
	*/
	public AssetSoftware setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
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
	public AssetSoftware setProcId(String procId) {
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
	public AssetSoftware setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 软件名称<br>
	 * 软件名称
	 * @return 软件名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 软件名称
	 * @param name 软件名称
	 * @return 当前对象
	*/
	public AssetSoftware setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 软件分类<br>
	 * 软件分类
	 * @return 软件分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 软件分类
	 * @param categoryId 软件分类
	 * @return 当前对象
	*/
	public AssetSoftware setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 软件编号<br>
	 * 软件编号
	 * @return 软件编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 软件编号
	 * @param code 软件编号
	 * @return 当前对象
	*/
	public AssetSoftware setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 软件版本<br>
	 * 软件版本
	 * @return 软件版本
	*/
	public String getSoftwareVersion() {
		return softwareVersion;
	}
	
	/**
	 * 设置 软件版本
	 * @param softwareVersion 软件版本
	 * @return 当前对象
	*/
	public AssetSoftware setSoftwareVersion(String softwareVersion) {
		this.softwareVersion=softwareVersion;
		return this;
	}
	
	/**
	 * 获得 版权类型<br>
	 * 版权类型
	 * @return 版权类型
	*/
	public String getCopyrightType() {
		return copyrightType;
	}
	
	/**
	 * 设置 版权类型
	 * @param copyrightType 版权类型
	 * @return 当前对象
	*/
	public AssetSoftware setCopyrightType(String copyrightType) {
		this.copyrightType=copyrightType;
		return this;
	}
	
	/**
	 * 获得 许可方式<br>
	 * 许可方式
	 * @return 许可方式
	*/
	public String getLicenseMode() {
		return licenseMode;
	}
	
	/**
	 * 设置 许可方式
	 * @param licenseMode 许可方式
	 * @return 当前对象
	*/
	public AssetSoftware setLicenseMode(String licenseMode) {
		this.licenseMode=licenseMode;
		return this;
	}
	
	/**
	 * 获得 成本<br>
	 * 成本
	 * @return 成本
	*/
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	
	/**
	 * 设置 成本
	 * @param costPrice 成本
	 * @return 当前对象
	*/
	public AssetSoftware setCostPrice(BigDecimal costPrice) {
		this.costPrice=costPrice;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public String getOwnCompanyId() {
		return ownCompanyId;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownCompanyId 所属公司
	 * @return 当前对象
	*/
	public AssetSoftware setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 使用公司<br>
	 * 使用公司
	 * @return 使用公司
	*/
	public String getUseOrganizationId() {
		return useOrganizationId;
	}
	
	/**
	 * 设置 使用公司
	 * @param useOrganizationId 使用公司
	 * @return 当前对象
	*/
	public AssetSoftware setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public String getSupplierId() {
		return supplierId;
	}
	
	/**
	 * 设置 供应商
	 * @param supplierId 供应商
	 * @return 当前对象
	*/
	public AssetSoftware setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 管理人
	 * @param managerId 管理人
	 * @return 当前对象
	*/
	public AssetSoftware setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 详细位置<br>
	 * 详细位置
	 * @return 详细位置
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 详细位置
	 * @param positionDetail 详细位置
	 * @return 当前对象
	*/
	public AssetSoftware setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 来源
	 * @param sourceId 来源
	 * @return 当前对象
	*/
	public AssetSoftware setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 来源明细<br>
	 * 来源明细
	 * @return 来源明细
	*/
	public String getSourceDetail() {
		return sourceDetail;
	}
	
	/**
	 * 设置 来源明细
	 * @param sourceDetail 来源明细
	 * @return 当前对象
	*/
	public AssetSoftware setSourceDetail(String sourceDetail) {
		this.sourceDetail=sourceDetail;
		return this;
	}
	
	/**
	 * 获得 授权信息<br>
	 * 授权信息
	 * @return 授权信息
	*/
	public String getAuthorizationInfo() {
		return authorizationInfo;
	}
	
	/**
	 * 设置 授权信息
	 * @param authorizationInfo 授权信息
	 * @return 当前对象
	*/
	public AssetSoftware setAuthorizationInfo(String authorizationInfo) {
		this.authorizationInfo=authorizationInfo;
		return this;
	}
	
	/**
	 * 获得 授权数量<br>
	 * 授权数量
	 * @return 授权数量
	*/
	public Integer getAuthorizedNumber() {
		return authorizedNumber;
	}
	
	/**
	 * 设置 授权数量
	 * @param authorizedNumber 授权数量
	 * @return 当前对象
	*/
	public AssetSoftware setAuthorizedNumber(Integer authorizedNumber) {
		this.authorizedNumber=authorizedNumber;
		return this;
	}
	
	/**
	 * 获得 可用数量<br>
	 * 可用数量
	 * @return 可用数量
	*/
	public Integer getAuthorizedAvailableNumber() {
		return authorizedAvailableNumber;
	}
	
	/**
	 * 设置 可用数量
	 * @param authorizedAvailableNumber 可用数量
	 * @return 当前对象
	*/
	public AssetSoftware setAuthorizedAvailableNumber(Integer authorizedAvailableNumber) {
		this.authorizedAvailableNumber=authorizedAvailableNumber;
		return this;
	}
	
	/**
	 * 获得 无限授权<br>
	 * 无限授权
	 * @return 无限授权
	*/
	public String getAuthorizedNumberUnlimit() {
		return authorizedNumberUnlimit;
	}
	
	/**
	 * 设置 无限授权
	 * @param authorizedNumberUnlimit 无限授权
	 * @return 当前对象
	*/
	public AssetSoftware setAuthorizedNumberUnlimit(String authorizedNumberUnlimit) {
		this.authorizedNumberUnlimit=authorizedNumberUnlimit;
		return this;
	}
	
	/**
	 * 获得 授权码<br>
	 * 授权码
	 * @return 授权码
	*/
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	
	/**
	 * 设置 授权码
	 * @param authorizationCode 授权码
	 * @return 当前对象
	*/
	public AssetSoftware setAuthorizationCode(String authorizationCode) {
		this.authorizationCode=authorizationCode;
		return this;
	}
	
	/**
	 * 获得 授权到期时间<br>
	 * 授权到期时间
	 * @return 授权到期时间
	*/
	public Date getAuthorizationExpirationDate() {
		return authorizationExpirationDate;
	}
	
	/**
	 * 设置 授权到期时间
	 * @param authorizationExpirationDate 授权到期时间
	 * @return 当前对象
	*/
	public AssetSoftware setAuthorizationExpirationDate(Date authorizationExpirationDate) {
		this.authorizationExpirationDate=authorizationExpirationDate;
		return this;
	}
	
	/**
	 * 获得 永久授权<br>
	 * 永久授权
	 * @return 永久授权
	*/
	public String getAuthorizationExpirationUnlimit() {
		return authorizationExpirationUnlimit;
	}
	
	/**
	 * 设置 永久授权
	 * @param authorizationExpirationUnlimit 永久授权
	 * @return 当前对象
	*/
	public AssetSoftware setAuthorizationExpirationUnlimit(String authorizationExpirationUnlimit) {
		this.authorizationExpirationUnlimit=authorizationExpirationUnlimit;
		return this;
	}
	
	/**
	 * 获得 是否维保<br>
	 * 是否维保
	 * @return 是否维保
	*/
	public String getNeedMaintenance() {
		return needMaintenance;
	}
	
	/**
	 * 设置 是否维保
	 * @param needMaintenance 是否维保
	 * @return 当前对象
	*/
	public AssetSoftware setNeedMaintenance(String needMaintenance) {
		this.needMaintenance=needMaintenance;
		return this;
	}
	
	/**
	 * 获得 维保开始时间<br>
	 * 维保开始时间
	 * @return 维保开始时间
	*/
	public Date getMaintenanceStartDate() {
		return maintenanceStartDate;
	}
	
	/**
	 * 设置 维保开始时间
	 * @param maintenanceStartDate 维保开始时间
	 * @return 当前对象
	*/
	public AssetSoftware setMaintenanceStartDate(Date maintenanceStartDate) {
		this.maintenanceStartDate=maintenanceStartDate;
		return this;
	}
	
	/**
	 * 获得 维保到期时间<br>
	 * 维保到期时间
	 * @return 维保到期时间
	*/
	public Date getMaintenanceEndDate() {
		return maintenanceEndDate;
	}
	
	/**
	 * 设置 维保到期时间
	 * @param maintenanceEndDate 维保到期时间
	 * @return 当前对象
	*/
	public AssetSoftware setMaintenanceEndDate(Date maintenanceEndDate) {
		this.maintenanceEndDate=maintenanceEndDate;
		return this;
	}
	
	/**
	 * 获得 购置日期<br>
	 * 购置日期
	 * @return 购置日期
	*/
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	/**
	 * 设置 购置日期
	 * @param purchaseDate 购置日期
	 * @return 当前对象
	*/
	public AssetSoftware setPurchaseDate(Date purchaseDate) {
		this.purchaseDate=purchaseDate;
		return this;
	}
	
	/**
	 * 获得 登记时间<br>
	 * 登记时间
	 * @return 登记时间
	*/
	public Date getRegisterDate() {
		return registerDate;
	}
	
	/**
	 * 设置 登记时间
	 * @param registerDate 登记时间
	 * @return 当前对象
	*/
	public AssetSoftware setRegisterDate(Date registerDate) {
		this.registerDate=registerDate;
		return this;
	}
	
	/**
	 * 获得 软件说明<br>
	 * 软件说明
	 * @return 软件说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 软件说明
	 * @param content 软件说明
	 * @return 当前对象
	*/
	public AssetSoftware setContent(String content) {
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
	public AssetSoftware setNotes(String notes) {
		this.notes=notes;
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
	public AssetSoftware setAttachId(String attachId) {
		this.attachId=attachId;
		return this;
	}
	
	/**
	 * 获得 标签1<br>
	 * 标签1
	 * @return 标签1
	*/
	public String getLabel1() {
		return label1;
	}
	
	/**
	 * 设置 标签1
	 * @param label1 标签1
	 * @return 当前对象
	*/
	public AssetSoftware setLabel1(String label1) {
		this.label1=label1;
		return this;
	}
	
	/**
	 * 获得 标签2<br>
	 * 标签2
	 * @return 标签2
	*/
	public String getLabel2() {
		return label2;
	}
	
	/**
	 * 设置 标签2
	 * @param label2 标签2
	 * @return 当前对象
	*/
	public AssetSoftware setLabel2(String label2) {
		this.label2=label2;
		return this;
	}
	
	/**
	 * 获得 标签3<br>
	 * 标签3
	 * @return 标签3
	*/
	public String getLabel3() {
		return label3;
	}
	
	/**
	 * 设置 标签3
	 * @param label3 标签3
	 * @return 当前对象
	*/
	public AssetSoftware setLabel3(String label3) {
		this.label3=label3;
		return this;
	}
	
	/**
	 * 获得 标签4<br>
	 * 标签4
	 * @return 标签4
	*/
	public String getLabel4() {
		return label4;
	}
	
	/**
	 * 设置 标签4
	 * @param label4 标签4
	 * @return 当前对象
	*/
	public AssetSoftware setLabel4(String label4) {
		this.label4=label4;
		return this;
	}
	
	/**
	 * 获得 控制<br>
	 * 控制
	 * @return 控制
	*/
	public String getCtl() {
		return ctl;
	}
	
	/**
	 * 设置 控制
	 * @param ctl 控制
	 * @return 当前对象
	*/
	public AssetSoftware setCtl(String ctl) {
		this.ctl=ctl;
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
	public AssetSoftware setCreateBy(String createBy) {
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
	public AssetSoftware setCreateTime(Date createTime) {
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
	public AssetSoftware setUpdateBy(String updateBy) {
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
	public AssetSoftware setUpdateTime(Date updateTime) {
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
	public AssetSoftware setDeleted(Integer deleted) {
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
	public AssetSoftware setDeleteBy(String deleteBy) {
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
	public AssetSoftware setDeleteTime(Date deleteTime) {
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
	public AssetSoftware setVersion(Integer version) {
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
	public AssetSoftware setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AssetSoftware setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 变更类型<br>
	 * 变更类型
	 * @return 变更类型
	*/
	public String getChsType() {
		return chsType;
	}
	
	/**
	 * 设置 变更类型
	 * @param chsType 变更类型
	 * @return 当前对象
	*/
	public AssetSoftware setChsType(String chsType) {
		this.chsType=chsType;
		return this;
	}
	
	/**
	 * 获得 变更状态<br>
	 * 变更状态
	 * @return 变更状态
	*/
	public String getChsStatus() {
		return chsStatus;
	}
	
	/**
	 * 设置 变更状态
	 * @param chsStatus 变更状态
	 * @return 当前对象
	*/
	public AssetSoftware setChsStatus(String chsStatus) {
		this.chsStatus=chsStatus;
		return this;
	}
	
	/**
	 * 获得 变更版本号<br>
	 * 变更版本号
	 * @return 变更版本号
	*/
	public String getChsVersion() {
		return chsVersion;
	}
	
	/**
	 * 设置 变更版本号
	 * @param chsVersion 变更版本号
	 * @return 当前对象
	*/
	public AssetSoftware setChsVersion(String chsVersion) {
		this.chsVersion=chsVersion;
		return this;
	}
	
	/**
	 * 获得 变更ID<br>
	 * 变更ID
	 * @return 变更ID
	*/
	public String getChangeInstanceId() {
		return changeInstanceId;
	}
	
	/**
	 * 设置 变更ID
	 * @param changeInstanceId 变更ID
	 * @return 当前对象
	*/
	public AssetSoftware setChangeInstanceId(String changeInstanceId) {
		this.changeInstanceId=changeInstanceId;
		return this;
	}
	
	/**
	 * 获得 流程概要<br>
	 * 流程概要
	 * @return 流程概要
	*/
	public String getSummary() {
		return summary;
	}
	
	/**
	 * 设置 流程概要
	 * @param summary 流程概要
	 * @return 当前对象
	*/
	public AssetSoftware setSummary(String summary) {
		this.summary=summary;
		return this;
	}
	
	/**
	 * 获得 最后审批人账户ID<br>
	 * 最后审批人账户ID
	 * @return 最后审批人账户ID
	*/
	public String getLatestApproverId() {
		return latestApproverId;
	}
	
	/**
	 * 设置 最后审批人账户ID
	 * @param latestApproverId 最后审批人账户ID
	 * @return 当前对象
	*/
	public AssetSoftware setLatestApproverId(String latestApproverId) {
		this.latestApproverId=latestApproverId;
		return this;
	}
	
	/**
	 * 获得 最后审批人姓名<br>
	 * 最后审批人姓名
	 * @return 最后审批人姓名
	*/
	public String getLatestApproverName() {
		return latestApproverName;
	}
	
	/**
	 * 设置 最后审批人姓名
	 * @param latestApproverName 最后审批人姓名
	 * @return 当前对象
	*/
	public AssetSoftware setLatestApproverName(String latestApproverName) {
		this.latestApproverName=latestApproverName;
		return this;
	}
	
	/**
	 * 获得 下一节点审批人<br>
	 * 下一节点审批人
	 * @return 下一节点审批人
	*/
	public String getNextApproverIds() {
		return nextApproverIds;
	}
	
	/**
	 * 设置 下一节点审批人
	 * @param nextApproverIds 下一节点审批人
	 * @return 当前对象
	*/
	public AssetSoftware setNextApproverIds(String nextApproverIds) {
		this.nextApproverIds=nextApproverIds;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人姓名<br>
	 * 用逗号隔开
	 * @return 下一个审批节点审批人姓名
	*/
	public String getNextApproverNames() {
		return nextApproverNames;
	}
	
	/**
	 * 设置 下一个审批节点审批人姓名
	 * @param nextApproverNames 下一个审批节点审批人姓名
	 * @return 当前对象
	*/
	public AssetSoftware setNextApproverNames(String nextApproverNames) {
		this.nextApproverNames=nextApproverNames;
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getApprovalOpinion() {
		return approvalOpinion;
	}
	
	/**
	 * 设置 审批意见
	 * @param approvalOpinion 审批意见
	 * @return 当前对象
	*/
	public AssetSoftware setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion=approvalOpinion;
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
	public AssetSoftware setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Catalog getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public AssetSoftware setCategory(Catalog category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * 设置 供应商
	 * @param supplier 供应商
	 * @return 当前对象
	*/
	public AssetSoftware setSupplier(Supplier supplier) {
		this.supplier=supplier;
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public Organization getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganization 使用公司/部门
	 * @return 当前对象
	*/
	public AssetSoftware setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public Organization getOwnerCompany() {
		return ownerCompany;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownerCompany 所属公司
	 * @return 当前对象
	*/
	public AssetSoftware setOwnerCompany(Organization ownerCompany) {
		this.ownerCompany=ownerCompany;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public DictItem getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public AssetSoftware setSource(DictItem source) {
		this.source=source;
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
	public AssetSoftware setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人
	 * @param manager 管理人
	 * @return 当前对象
	*/
	public AssetSoftware setManager(Employee manager) {
		this.manager=manager;
		return this;
	}
	
	/**
	 * 获得 版权<br>
	 * 版权
	 * @return 版权
	*/
	public DictItem getCopyrightTypeDict() {
		return copyrightTypeDict;
	}
	
	/**
	 * 设置 版权
	 * @param copyrightTypeDict 版权
	 * @return 当前对象
	*/
	public AssetSoftware setCopyrightTypeDict(DictItem copyrightTypeDict) {
		this.copyrightTypeDict=copyrightTypeDict;
		return this;
	}
	
	/**
	 * 获得 许可<br>
	 * 许可
	 * @return 许可
	*/
	public DictItem getLicenseModeDict() {
		return licenseModeDict;
	}
	
	/**
	 * 设置 许可
	 * @param licenseModeDict 许可
	 * @return 当前对象
	*/
	public AssetSoftware setLicenseModeDict(DictItem licenseModeDict) {
		this.licenseModeDict=licenseModeDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetSoftware , 转换好的 AssetSoftware 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetSoftware , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetSoftware
	 * @param assetSoftwareMap 包含实体信息的 Map 对象
	 * @return AssetSoftware , 转换好的的 AssetSoftware 对象
	*/
	@Transient
	public static AssetSoftware createFrom(Map<String,Object> assetSoftwareMap) {
		if(assetSoftwareMap==null) return null;
		AssetSoftware po = EntityContext.create(AssetSoftware.class, assetSoftwareMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetSoftware
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetSoftware , 转换好的的 AssetSoftware 对象
	*/
	@Transient
	public static AssetSoftware createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetSoftware po = EntityContext.create(AssetSoftware.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetSoftware，等同于 new
	 * @return AssetSoftware 对象
	*/
	@Transient
	public static AssetSoftware create() {
		return EntityContext.create(AssetSoftware.class);
	}
}