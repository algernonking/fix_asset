package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 软件分发
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:47:31
 * @sign 0DE22DEA94C986225187DE6118B4431B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_software_distribute")
public class AssetSoftwareDistribute extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_SOFTWARE_DISTRIBUTE.$TABLE;
	
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
	 * 领用公司：领用公司
	*/
	@ApiModelProperty(required = false,value="领用公司" , notes = "领用公司")
	private String useOrgId;
	
	/**
	 * 领用人：领用人
	*/
	@ApiModelProperty(required = false,value="领用人" , notes = "领用人")
	private String useUserId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
	/**
	 * 领用说明：领用说明
	*/
	@ApiModelProperty(required = false,value="领用说明" , notes = "领用说明")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 关联资产：关联资产
	*/
	@ApiModelProperty(required = false,value="关联资产" , notes = "关联资产")
	private String assetId;
	
	/**
	 * 软件资产：软件资产
	*/
	@ApiModelProperty(required = false,value="软件资产" , notes = "软件资产")
	private String assetSoftwareId;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
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
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 领用人：领用人
	*/
	@ApiModelProperty(required = false,value="领用人" , notes = "领用人")
	private Employee useUser;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
	/**
	 * 软件资产：软件资产
	*/
	@ApiModelProperty(required = false,value="软件资产" , notes = "软件资产")
	private List<AssetSoftware> assetSoftwareList;
	
	/**
	 * 软件资产：软件资产
	*/
	@ApiModelProperty(required = false,value="软件资产" , notes = "软件资产")
	private List<String> assetSoftwareIds;
	
	/**
	 * 软件：软件
	*/
	@ApiModelProperty(required = false,value="软件" , notes = "软件")
	private List<AssetSoftwareDistributeData> assetSoftwareDistributeList;
	
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
	public AssetSoftwareDistribute setId(String id) {
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
	public AssetSoftwareDistribute setBusinessCode(String businessCode) {
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
	public AssetSoftwareDistribute setProcId(String procId) {
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
	public AssetSoftwareDistribute setStatus(String status) {
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
	public AssetSoftwareDistribute setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 领用公司<br>
	 * 领用公司
	 * @return 领用公司
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 领用公司
	 * @param useOrgId 领用公司
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
		return this;
	}
	
	/**
	 * 获得 领用人<br>
	 * 领用人
	 * @return 领用人
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 领用人
	 * @param useUserId 领用人
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setUseUserId(String useUserId) {
		this.useUserId=useUserId;
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
	public AssetSoftwareDistribute setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 领用说明<br>
	 * 领用说明
	 * @return 领用说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 领用说明
	 * @param content 领用说明
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setContent(String content) {
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
	public AssetSoftwareDistribute setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 关联资产<br>
	 * 关联资产
	 * @return 关联资产
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 关联资产
	 * @param assetId 关联资产
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 软件资产<br>
	 * 软件资产
	 * @return 软件资产
	*/
	public String getAssetSoftwareId() {
		return assetSoftwareId;
	}
	
	/**
	 * 设置 软件资产
	 * @param assetSoftwareId 软件资产
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setAssetSoftwareId(String assetSoftwareId) {
		this.assetSoftwareId=assetSoftwareId;
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
	public AssetSoftwareDistribute setAttachId(String attachId) {
		this.attachId=attachId;
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
	public AssetSoftwareDistribute setOriginatorId(String originatorId) {
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
	public AssetSoftwareDistribute setCreateBy(String createBy) {
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
	public AssetSoftwareDistribute setCreateTime(Date createTime) {
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
	public AssetSoftwareDistribute setUpdateBy(String updateBy) {
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
	public AssetSoftwareDistribute setUpdateTime(Date updateTime) {
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
	public AssetSoftwareDistribute setDeleted(Integer deleted) {
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
	public AssetSoftwareDistribute setDeleteBy(String deleteBy) {
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
	public AssetSoftwareDistribute setDeleteTime(Date deleteTime) {
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
	public AssetSoftwareDistribute setVersion(Integer version) {
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
	public AssetSoftwareDistribute setTenantId(String tenantId) {
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
	public AssetSoftwareDistribute setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public AssetSoftwareDistribute setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 领用人<br>
	 * 领用人
	 * @return 领用人
	*/
	public Employee getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 领用人
	 * @param useUser 领用人
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setUseUser(Employee useUser) {
		this.useUser=useUser;
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
	public AssetSoftwareDistribute setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 软件资产<br>
	 * 软件资产
	 * @return 软件资产
	*/
	public List<AssetSoftware> getAssetSoftwareList() {
		return assetSoftwareList;
	}
	
	/**
	 * 设置 软件资产
	 * @param assetSoftwareList 软件资产
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setAssetSoftwareList(List<AssetSoftware> assetSoftwareList) {
		this.assetSoftwareList=assetSoftwareList;
		return this;
	}
	
	/**
	 * 添加 软件资产
	 * @param assetSoftware 软件资产
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute addAssetSoftware(AssetSoftware assetSoftware) {
		if(this.assetSoftwareList==null) assetSoftwareList=new ArrayList<>();
		this.assetSoftwareList.add(assetSoftware);
		return this;
	}
	
	/**
	 * 获得 软件资产<br>
	 * 软件资产
	 * @return 软件资产
	*/
	public List<String> getAssetSoftwareIds() {
		return assetSoftwareIds;
	}
	
	/**
	 * 设置 软件资产
	 * @param assetSoftwareIds 软件资产
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setAssetSoftwareIds(List<String> assetSoftwareIds) {
		this.assetSoftwareIds=assetSoftwareIds;
		return this;
	}
	
	/**
	 * 添加 软件资产
	 * @param assetSoftwareId 软件资产
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute addAssetSoftwareId(String assetSoftwareId) {
		if(this.assetSoftwareIds==null) assetSoftwareIds=new ArrayList<>();
		this.assetSoftwareIds.add(assetSoftwareId);
		return this;
	}
	
	/**
	 * 获得 软件<br>
	 * 软件
	 * @return 软件
	*/
	public List<AssetSoftwareDistributeData> getAssetSoftwareDistributeList() {
		return assetSoftwareDistributeList;
	}
	
	/**
	 * 设置 软件
	 * @param assetSoftwareDistributeList 软件
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute setAssetSoftwareDistributeList(List<AssetSoftwareDistributeData> assetSoftwareDistributeList) {
		this.assetSoftwareDistributeList=assetSoftwareDistributeList;
		return this;
	}
	
	/**
	 * 添加 软件
	 * @param assetSoftwareDistribute 软件
	 * @return 当前对象
	*/
	public AssetSoftwareDistribute addAssetSoftwareDistribute(AssetSoftwareDistributeData assetSoftwareDistribute) {
		if(this.assetSoftwareDistributeList==null) assetSoftwareDistributeList=new ArrayList<>();
		this.assetSoftwareDistributeList.add(assetSoftwareDistribute);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetSoftwareDistribute , 转换好的 AssetSoftwareDistribute 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetSoftwareDistribute , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetSoftwareDistribute
	 * @param assetSoftwareDistributeMap 包含实体信息的 Map 对象
	 * @return AssetSoftwareDistribute , 转换好的的 AssetSoftwareDistribute 对象
	*/
	@Transient
	public static AssetSoftwareDistribute createFrom(Map<String,Object> assetSoftwareDistributeMap) {
		if(assetSoftwareDistributeMap==null) return null;
		AssetSoftwareDistribute po = EntityContext.create(AssetSoftwareDistribute.class, assetSoftwareDistributeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetSoftwareDistribute
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetSoftwareDistribute , 转换好的的 AssetSoftwareDistribute 对象
	*/
	@Transient
	public static AssetSoftwareDistribute createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetSoftwareDistribute po = EntityContext.create(AssetSoftwareDistribute.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetSoftwareDistribute，等同于 new
	 * @return AssetSoftwareDistribute 对象
	*/
	@Transient
	public static AssetSoftwareDistribute create() {
		return EntityContext.create(AssetSoftwareDistribute.class);
	}
}