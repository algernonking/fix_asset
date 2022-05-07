package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 软件维保
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:46:48
 * @sign B3304579A5A513DB17174D4DC112725F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_software_maintenance")
public class AssetSoftwareMaintenance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_SOFTWARE_MAINTENANCE.$TABLE;
	
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
	 * 维保名称：维保名称
	*/
	@ApiModelProperty(required = false,value="维保名称" , notes = "维保名称")
	private String name;
	
	/**
	 * 维保厂商：维保厂商
	*/
	@ApiModelProperty(required = false,value="维保厂商" , notes = "维保厂商")
	private String maintainerId;
	
	/**
	 * 负责部门：负责部门
	*/
	@ApiModelProperty(required = false,value="负责部门" , notes = "负责部门")
	private String useOrgId;
	
	/**
	 * 维保负责人：维保负责人
	*/
	@ApiModelProperty(required = false,value="维保负责人" , notes = "维保负责人")
	private String managerId;
	
	/**
	 * 维保联系人：维保联系人
	*/
	@ApiModelProperty(required = false,value="维保联系人" , notes = "维保联系人")
	private String contacts;
	
	/**
	 * 联系信息：联系信息
	*/
	@ApiModelProperty(required = false,value="联系信息" , notes = "联系信息")
	private String contactInfo;
	
	/**
	 * 维保费用：维保费用
	*/
	@ApiModelProperty(required = false,value="维保费用" , notes = "维保费用")
	private BigDecimal maintenanceCost;
	
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
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
	/**
	 * 维保说明：维保说明
	*/
	@ApiModelProperty(required = false,value="维保说明" , notes = "维保说明")
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
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private Employee manager;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private Maintainer maintainer;
	
	/**
	 * 负责部门：负责部门
	*/
	@ApiModelProperty(required = false,value="负责部门" , notes = "负责部门")
	private Organization useOrganization;
	
	/**
	 * 软件信息：软件信息
	*/
	@ApiModelProperty(required = false,value="软件信息" , notes = "软件信息")
	private List<AssetSoftware> assetSoftwareList;
	
	/**
	 * 软件信息：软件信息
	*/
	@ApiModelProperty(required = false,value="软件信息" , notes = "软件信息")
	private List<String> assetSoftwareIds;
	
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
	public AssetSoftwareMaintenance setId(String id) {
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
	public AssetSoftwareMaintenance setBusinessCode(String businessCode) {
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
	public AssetSoftwareMaintenance setProcId(String procId) {
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
	public AssetSoftwareMaintenance setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 维保名称<br>
	 * 维保名称
	 * @return 维保名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 维保名称
	 * @param name 维保名称
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 维保厂商<br>
	 * 维保厂商
	 * @return 维保厂商
	*/
	public String getMaintainerId() {
		return maintainerId;
	}
	
	/**
	 * 设置 维保厂商
	 * @param maintainerId 维保厂商
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setMaintainerId(String maintainerId) {
		this.maintainerId=maintainerId;
		return this;
	}
	
	/**
	 * 获得 负责部门<br>
	 * 负责部门
	 * @return 负责部门
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 负责部门
	 * @param useOrgId 负责部门
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
		return this;
	}
	
	/**
	 * 获得 维保负责人<br>
	 * 维保负责人
	 * @return 维保负责人
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 维保负责人
	 * @param managerId 维保负责人
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 维保联系人<br>
	 * 维保联系人
	 * @return 维保联系人
	*/
	public String getContacts() {
		return contacts;
	}
	
	/**
	 * 设置 维保联系人
	 * @param contacts 维保联系人
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setContacts(String contacts) {
		this.contacts=contacts;
		return this;
	}
	
	/**
	 * 获得 联系信息<br>
	 * 联系信息
	 * @return 联系信息
	*/
	public String getContactInfo() {
		return contactInfo;
	}
	
	/**
	 * 设置 联系信息
	 * @param contactInfo 联系信息
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setContactInfo(String contactInfo) {
		this.contactInfo=contactInfo;
		return this;
	}
	
	/**
	 * 获得 维保费用<br>
	 * 维保费用
	 * @return 维保费用
	*/
	public BigDecimal getMaintenanceCost() {
		return maintenanceCost;
	}
	
	/**
	 * 设置 维保费用
	 * @param maintenanceCost 维保费用
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setMaintenanceCost(BigDecimal maintenanceCost) {
		this.maintenanceCost=maintenanceCost;
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
	public AssetSoftwareMaintenance setMaintenanceStartDate(Date maintenanceStartDate) {
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
	public AssetSoftwareMaintenance setMaintenanceEndDate(Date maintenanceEndDate) {
		this.maintenanceEndDate=maintenanceEndDate;
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
	public AssetSoftwareMaintenance setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 维保说明<br>
	 * 维保说明
	 * @return 维保说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 维保说明
	 * @param content 维保说明
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setContent(String content) {
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
	public AssetSoftwareMaintenance setNotes(String notes) {
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
	public AssetSoftwareMaintenance setAttachId(String attachId) {
		this.attachId=attachId;
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
	public AssetSoftwareMaintenance setCreateBy(String createBy) {
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
	public AssetSoftwareMaintenance setCreateTime(Date createTime) {
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
	public AssetSoftwareMaintenance setUpdateBy(String updateBy) {
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
	public AssetSoftwareMaintenance setUpdateTime(Date updateTime) {
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
	public AssetSoftwareMaintenance setDeleted(Integer deleted) {
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
	public AssetSoftwareMaintenance setDeleteBy(String deleteBy) {
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
	public AssetSoftwareMaintenance setDeleteTime(Date deleteTime) {
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
	public AssetSoftwareMaintenance setVersion(Integer version) {
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
	public AssetSoftwareMaintenance setTenantId(String tenantId) {
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
	public AssetSoftwareMaintenance setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public AssetSoftwareMaintenance setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 负责人
	 * @param manager 负责人
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setManager(Employee manager) {
		this.manager=manager;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public Maintainer getMaintainer() {
		return maintainer;
	}
	
	/**
	 * 设置 负责人
	 * @param maintainer 负责人
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setMaintainer(Maintainer maintainer) {
		this.maintainer=maintainer;
		return this;
	}
	
	/**
	 * 获得 负责部门<br>
	 * 负责部门
	 * @return 负责部门
	*/
	public Organization getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 负责部门
	 * @param useOrganization 负责部门
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 软件信息<br>
	 * 软件信息
	 * @return 软件信息
	*/
	public List<AssetSoftware> getAssetSoftwareList() {
		return assetSoftwareList;
	}
	
	/**
	 * 设置 软件信息
	 * @param assetSoftwareList 软件信息
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setAssetSoftwareList(List<AssetSoftware> assetSoftwareList) {
		this.assetSoftwareList=assetSoftwareList;
		return this;
	}
	
	/**
	 * 添加 软件信息
	 * @param assetSoftware 软件信息
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance addAssetSoftware(AssetSoftware assetSoftware) {
		if(this.assetSoftwareList==null) assetSoftwareList=new ArrayList<>();
		this.assetSoftwareList.add(assetSoftware);
		return this;
	}
	
	/**
	 * 获得 软件信息<br>
	 * 软件信息
	 * @return 软件信息
	*/
	public List<String> getAssetSoftwareIds() {
		return assetSoftwareIds;
	}
	
	/**
	 * 设置 软件信息
	 * @param assetSoftwareIds 软件信息
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance setAssetSoftwareIds(List<String> assetSoftwareIds) {
		this.assetSoftwareIds=assetSoftwareIds;
		return this;
	}
	
	/**
	 * 添加 软件信息
	 * @param assetSoftwareId 软件信息
	 * @return 当前对象
	*/
	public AssetSoftwareMaintenance addAssetSoftwareId(String assetSoftwareId) {
		if(this.assetSoftwareIds==null) assetSoftwareIds=new ArrayList<>();
		this.assetSoftwareIds.add(assetSoftwareId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetSoftwareMaintenance , 转换好的 AssetSoftwareMaintenance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetSoftwareMaintenance , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetSoftwareMaintenance
	 * @param assetSoftwareMaintenanceMap 包含实体信息的 Map 对象
	 * @return AssetSoftwareMaintenance , 转换好的的 AssetSoftwareMaintenance 对象
	*/
	@Transient
	public static AssetSoftwareMaintenance createFrom(Map<String,Object> assetSoftwareMaintenanceMap) {
		if(assetSoftwareMaintenanceMap==null) return null;
		AssetSoftwareMaintenance po = EntityContext.create(AssetSoftwareMaintenance.class, assetSoftwareMaintenanceMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetSoftwareMaintenance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetSoftwareMaintenance , 转换好的的 AssetSoftwareMaintenance 对象
	*/
	@Transient
	public static AssetSoftwareMaintenance createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetSoftwareMaintenance po = EntityContext.create(AssetSoftwareMaintenance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetSoftwareMaintenance，等同于 new
	 * @return AssetSoftwareMaintenance 对象
	*/
	@Transient
	public static AssetSoftwareMaintenance create() {
		return EntityContext.create(AssetSoftwareMaintenance.class);
	}
}