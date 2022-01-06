package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 资产盘点
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-05 19:34:06
 * @sign 28D5E4311CAB3B9FDC44C0599870EF36
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory")
public class Inventory extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 业务编码：业务编码
	*/
	@ApiModelProperty(required = false,value="业务编码" , notes = "业务编码")
	private String businessCode;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerCode;
	
	/**
	 * 业务状态：业务状态
	*/
	@ApiModelProperty(required = false,value="业务状态" , notes = "业务状态")
	private String status;
	
	/**
	 * 盘点名称：盘点名称
	*/
	@ApiModelProperty(required = false,value="盘点名称" , notes = "盘点名称")
	private String name;
	
	/**
	 * 盘点状态：盘点状态
	*/
	@ApiModelProperty(required = false,value="盘点状态" , notes = "盘点状态")
	private String inventoryStatus;
	
	/**
	 * 数据状态：数据状态
	*/
	@ApiModelProperty(required = false,value="数据状态" , notes = "数据状态")
	private String dataStatus;
	
	/**
	 * 全员盘点：全员盘点
	*/
	@ApiModelProperty(required = false,value="全员盘点" , notes = "全员盘点")
	private String allEmployee;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = false,value="资产状态" , notes = "资产状态")
	private String assetStatus;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private String useOrganizationId;
	
	/**
	 * 购置开始日期：购置开始日期
	*/
	@ApiModelProperty(required = false,value="购置开始日期" , notes = "购置开始日期")
	private Date purchaseStartDate;
	
	/**
	 * 购置结束日期：购置结束日期
	*/
	@ApiModelProperty(required = false,value="购置结束日期" , notes = "购置结束日期")
	private Date purchaseEndDate;
	
	/**
	 * 盘点开始时间：盘点开始时间
	*/
	@ApiModelProperty(required = false,value="盘点开始时间" , notes = "盘点开始时间")
	private Date startTime;
	
	/**
	 * 盘点结束时间：盘点结束时间
	*/
	@ApiModelProperty(required = false,value="盘点结束时间" , notes = "盘点结束时间")
	private Date finishTime;
	
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
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 计划编号：计划编号
	*/
	@ApiModelProperty(required = false,value="计划编号" , notes = "计划编号")
	private String planId;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 盘点资产数据：盘点资产数据
	*/
	@ApiModelProperty(required = false,value="盘点资产数据" , notes = "盘点资产数据")
	private List<InventoryAsset> InventoryAssetInfoList;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private List<Organization> ownerCompany;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private List<Organization> useOrganization;
	
	/**
	 * 盘点人员：盘点人员
	*/
	@ApiModelProperty(required = false,value="盘点人员" , notes = "盘点人员")
	private List<Employee> inventoryUser;
	
	/**
	 * 盘点人员列表：盘点人员列表
	*/
	@ApiModelProperty(required = false,value="盘点人员列表" , notes = "盘点人员列表")
	private List<String> inventoryUserIds;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private List<Employee> manager;
	
	/**
	 * 管理人列表：管理人列表
	*/
	@ApiModelProperty(required = false,value="管理人列表" , notes = "管理人列表")
	private List<String> inventoryManagerIds;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private List<Employee> director;
	
	/**
	 * 负责人列表：负责人列表
	*/
	@ApiModelProperty(required = false,value="负责人列表" , notes = "负责人列表")
	private List<String> inventoryDirectorIds;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private List<Position> position;
	
	/**
	 * 存放位置Ids：存放位置Ids
	*/
	@ApiModelProperty(required = false,value="存放位置Ids" , notes = "存放位置Ids")
	private List<String> positionIds;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private List<Warehouse> warehouse;
	
	/**
	 * 仓库Ids：仓库Ids
	*/
	@ApiModelProperty(required = false,value="仓库Ids" , notes = "仓库Ids")
	private List<String> warehouseIds;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private List<Catalog> category;
	
	/**
	 * 资产分类Ids：资产分类Ids
	*/
	@ApiModelProperty(required = false,value="资产分类Ids" , notes = "资产分类Ids")
	private List<String> categoryIds;
	
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
	public Inventory setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public Inventory setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 业务编码<br>
	 * 业务编码
	 * @return 业务编码
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编码
	 * @param businessCode 业务编码
	 * @return 当前对象
	*/
	public Inventory setBusinessCode(String businessCode) {
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
	public Inventory setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 业务状态<br>
	 * 业务状态
	 * @return 业务状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 业务状态
	 * @param status 业务状态
	 * @return 当前对象
	*/
	public Inventory setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 盘点名称<br>
	 * 盘点名称
	 * @return 盘点名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 盘点名称
	 * @param name 盘点名称
	 * @return 当前对象
	*/
	public Inventory setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 盘点状态<br>
	 * 盘点状态
	 * @return 盘点状态
	*/
	public String getInventoryStatus() {
		return inventoryStatus;
	}
	
	/**
	 * 设置 盘点状态
	 * @param inventoryStatus 盘点状态
	 * @return 当前对象
	*/
	public Inventory setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus=inventoryStatus;
		return this;
	}
	
	/**
	 * 获得 数据状态<br>
	 * 数据状态
	 * @return 数据状态
	*/
	public String getDataStatus() {
		return dataStatus;
	}
	
	/**
	 * 设置 数据状态
	 * @param dataStatus 数据状态
	 * @return 当前对象
	*/
	public Inventory setDataStatus(String dataStatus) {
		this.dataStatus=dataStatus;
		return this;
	}
	
	/**
	 * 获得 全员盘点<br>
	 * 全员盘点
	 * @return 全员盘点
	*/
	public String getAllEmployee() {
		return allEmployee;
	}
	
	/**
	 * 设置 全员盘点
	 * @param allEmployee 全员盘点
	 * @return 当前对象
	*/
	public Inventory setAllEmployee(String allEmployee) {
		this.allEmployee=allEmployee;
		return this;
	}
	
	/**
	 * 获得 资产状态<br>
	 * 资产状态
	 * @return 资产状态
	*/
	public String getAssetStatus() {
		return assetStatus;
	}
	
	/**
	 * 设置 资产状态
	 * @param assetStatus 资产状态
	 * @return 当前对象
	*/
	public Inventory setAssetStatus(String assetStatus) {
		this.assetStatus=assetStatus;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public Inventory setCategoryId(String categoryId) {
		this.categoryId=categoryId;
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
	public Inventory setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public String getUseOrganizationId() {
		return useOrganizationId;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganizationId 使用公司/部门
	 * @return 当前对象
	*/
	public Inventory setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 购置开始日期<br>
	 * 购置开始日期
	 * @return 购置开始日期
	*/
	public Date getPurchaseStartDate() {
		return purchaseStartDate;
	}
	
	/**
	 * 设置 购置开始日期
	 * @param purchaseStartDate 购置开始日期
	 * @return 当前对象
	*/
	public Inventory setPurchaseStartDate(Date purchaseStartDate) {
		this.purchaseStartDate=purchaseStartDate;
		return this;
	}
	
	/**
	 * 获得 购置结束日期<br>
	 * 购置结束日期
	 * @return 购置结束日期
	*/
	public Date getPurchaseEndDate() {
		return purchaseEndDate;
	}
	
	/**
	 * 设置 购置结束日期
	 * @param purchaseEndDate 购置结束日期
	 * @return 当前对象
	*/
	public Inventory setPurchaseEndDate(Date purchaseEndDate) {
		this.purchaseEndDate=purchaseEndDate;
		return this;
	}
	
	/**
	 * 获得 盘点开始时间<br>
	 * 盘点开始时间
	 * @return 盘点开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 盘点开始时间
	 * @param startTime 盘点开始时间
	 * @return 当前对象
	*/
	public Inventory setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 盘点结束时间<br>
	 * 盘点结束时间
	 * @return 盘点结束时间
	*/
	public Date getFinishTime() {
		return finishTime;
	}
	
	/**
	 * 设置 盘点结束时间
	 * @param finishTime 盘点结束时间
	 * @return 当前对象
	*/
	public Inventory setFinishTime(Date finishTime) {
		this.finishTime=finishTime;
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
	public Inventory setOriginatorId(String originatorId) {
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
	public Inventory setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
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
	public Inventory setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 计划编号<br>
	 * 计划编号
	 * @return 计划编号
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 计划编号
	 * @param planId 计划编号
	 * @return 当前对象
	*/
	public Inventory setPlanId(String planId) {
		this.planId=planId;
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
	public Inventory setCreateBy(String createBy) {
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
	public Inventory setCreateTime(Date createTime) {
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
	public Inventory setUpdateBy(String updateBy) {
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
	public Inventory setUpdateTime(Date updateTime) {
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
	public Inventory setDeleted(Integer deleted) {
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
	public Inventory setDeleteBy(String deleteBy) {
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
	public Inventory setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public Inventory setVersion(Integer version) {
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
	public Inventory setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 盘点资产数据<br>
	 * 盘点资产数据
	 * @return 盘点资产数据
	*/
	public List<InventoryAsset> getInventoryAssetInfoList() {
		return InventoryAssetInfoList;
	}
	
	/**
	 * 设置 盘点资产数据
	 * @param InventoryAssetInfoList 盘点资产数据
	 * @return 当前对象
	*/
	public Inventory setInventoryAssetInfoList(List<InventoryAsset> InventoryAssetInfoList) {
		this.InventoryAssetInfoList=InventoryAssetInfoList;
		return this;
	}
	
	/**
	 * 添加 盘点资产数据
	 * @param InventoryAssetInfo 盘点资产数据
	 * @return 当前对象
	*/
	public Inventory addInventoryAssetInfo(InventoryAsset InventoryAssetInfo) {
		if(this.InventoryAssetInfoList==null) InventoryAssetInfoList=new ArrayList<>();
		this.InventoryAssetInfoList.add(InventoryAssetInfo);
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public List<Organization> getOwnerCompany() {
		return ownerCompany;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownerCompany 所属公司
	 * @return 当前对象
	*/
	public Inventory setOwnerCompany(List<Organization> ownerCompany) {
		this.ownerCompany=ownerCompany;
		return this;
	}
	
	/**
	 * 添加 所属公司
	 * @param entity 所属公司
	 * @return 当前对象
	*/
	public Inventory addOwnerCompany(Organization entity) {
		if(this.ownerCompany==null) ownerCompany=new ArrayList<>();
		this.ownerCompany.add(entity);
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public List<Organization> getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganization 使用公司/部门
	 * @return 当前对象
	*/
	public Inventory setUseOrganization(List<Organization> useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 添加 使用公司/部门
	 * @param entity 使用公司/部门
	 * @return 当前对象
	*/
	public Inventory addUseOrganization(Organization entity) {
		if(this.useOrganization==null) useOrganization=new ArrayList<>();
		this.useOrganization.add(entity);
		return this;
	}
	
	/**
	 * 获得 盘点人员<br>
	 * 盘点人员
	 * @return 盘点人员
	*/
	public List<Employee> getInventoryUser() {
		return inventoryUser;
	}
	
	/**
	 * 设置 盘点人员
	 * @param inventoryUser 盘点人员
	 * @return 当前对象
	*/
	public Inventory setInventoryUser(List<Employee> inventoryUser) {
		this.inventoryUser=inventoryUser;
		return this;
	}
	
	/**
	 * 添加 盘点人员
	 * @param entity 盘点人员
	 * @return 当前对象
	*/
	public Inventory addInventoryUser(Employee entity) {
		if(this.inventoryUser==null) inventoryUser=new ArrayList<>();
		this.inventoryUser.add(entity);
		return this;
	}
	
	/**
	 * 获得 盘点人员列表<br>
	 * 盘点人员列表
	 * @return 盘点人员列表
	*/
	public List<String> getInventoryUserIds() {
		return inventoryUserIds;
	}
	
	/**
	 * 设置 盘点人员列表
	 * @param inventoryUserIds 盘点人员列表
	 * @return 当前对象
	*/
	public Inventory setInventoryUserIds(List<String> inventoryUserIds) {
		this.inventoryUserIds=inventoryUserIds;
		return this;
	}
	
	/**
	 * 添加 盘点人员列表
	 * @param inventoryUserId 盘点人员列表
	 * @return 当前对象
	*/
	public Inventory addInventoryUserId(String inventoryUserId) {
		if(this.inventoryUserIds==null) inventoryUserIds=new ArrayList<>();
		this.inventoryUserIds.add(inventoryUserId);
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public List<Employee> getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人员
	 * @param manager 管理人员
	 * @return 当前对象
	*/
	public Inventory setManager(List<Employee> manager) {
		this.manager=manager;
		return this;
	}
	
	/**
	 * 添加 管理人员
	 * @param entity 管理人员
	 * @return 当前对象
	*/
	public Inventory addManager(Employee entity) {
		if(this.manager==null) manager=new ArrayList<>();
		this.manager.add(entity);
		return this;
	}
	
	/**
	 * 获得 管理人列表<br>
	 * 管理人列表
	 * @return 管理人列表
	*/
	public List<String> getInventoryManagerIds() {
		return inventoryManagerIds;
	}
	
	/**
	 * 设置 管理人列表
	 * @param inventoryManagerIds 管理人列表
	 * @return 当前对象
	*/
	public Inventory setInventoryManagerIds(List<String> inventoryManagerIds) {
		this.inventoryManagerIds=inventoryManagerIds;
		return this;
	}
	
	/**
	 * 添加 管理人列表
	 * @param inventoryManagerId 管理人列表
	 * @return 当前对象
	*/
	public Inventory addInventoryManagerId(String inventoryManagerId) {
		if(this.inventoryManagerIds==null) inventoryManagerIds=new ArrayList<>();
		this.inventoryManagerIds.add(inventoryManagerId);
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public List<Employee> getDirector() {
		return director;
	}
	
	/**
	 * 设置 负责人
	 * @param director 负责人
	 * @return 当前对象
	*/
	public Inventory setDirector(List<Employee> director) {
		this.director=director;
		return this;
	}
	
	/**
	 * 添加 负责人
	 * @param entity 负责人
	 * @return 当前对象
	*/
	public Inventory addDirector(Employee entity) {
		if(this.director==null) director=new ArrayList<>();
		this.director.add(entity);
		return this;
	}
	
	/**
	 * 获得 负责人列表<br>
	 * 负责人列表
	 * @return 负责人列表
	*/
	public List<String> getInventoryDirectorIds() {
		return inventoryDirectorIds;
	}
	
	/**
	 * 设置 负责人列表
	 * @param inventoryDirectorIds 负责人列表
	 * @return 当前对象
	*/
	public Inventory setInventoryDirectorIds(List<String> inventoryDirectorIds) {
		this.inventoryDirectorIds=inventoryDirectorIds;
		return this;
	}
	
	/**
	 * 添加 负责人列表
	 * @param inventoryDirectorId 负责人列表
	 * @return 当前对象
	*/
	public Inventory addInventoryDirectorId(String inventoryDirectorId) {
		if(this.inventoryDirectorIds==null) inventoryDirectorIds=new ArrayList<>();
		this.inventoryDirectorIds.add(inventoryDirectorId);
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
	public Inventory setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public List<Position> getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public Inventory setPosition(List<Position> position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 添加 存放位置
	 * @param entity 存放位置
	 * @return 当前对象
	*/
	public Inventory addPosition(Position entity) {
		if(this.position==null) position=new ArrayList<>();
		this.position.add(entity);
		return this;
	}
	
	/**
	 * 获得 存放位置Ids<br>
	 * 存放位置Ids
	 * @return 存放位置Ids
	*/
	public List<String> getPositionIds() {
		return positionIds;
	}
	
	/**
	 * 设置 存放位置Ids
	 * @param positionIds 存放位置Ids
	 * @return 当前对象
	*/
	public Inventory setPositionIds(List<String> positionIds) {
		this.positionIds=positionIds;
		return this;
	}
	
	/**
	 * 添加 存放位置Ids
	 * @param positionId 存放位置Ids
	 * @return 当前对象
	*/
	public Inventory addPositionId(String positionId) {
		if(this.positionIds==null) positionIds=new ArrayList<>();
		this.positionIds.add(positionId);
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public List<Warehouse> getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public Inventory setWarehouse(List<Warehouse> warehouse) {
		this.warehouse=warehouse;
		return this;
	}
	
	/**
	 * 添加 仓库
	 * @param entity 仓库
	 * @return 当前对象
	*/
	public Inventory addWarehouse(Warehouse entity) {
		if(this.warehouse==null) warehouse=new ArrayList<>();
		this.warehouse.add(entity);
		return this;
	}
	
	/**
	 * 获得 仓库Ids<br>
	 * 仓库Ids
	 * @return 仓库Ids
	*/
	public List<String> getWarehouseIds() {
		return warehouseIds;
	}
	
	/**
	 * 设置 仓库Ids
	 * @param warehouseIds 仓库Ids
	 * @return 当前对象
	*/
	public Inventory setWarehouseIds(List<String> warehouseIds) {
		this.warehouseIds=warehouseIds;
		return this;
	}
	
	/**
	 * 添加 仓库Ids
	 * @param warehouseId 仓库Ids
	 * @return 当前对象
	*/
	public Inventory addWarehouseId(String warehouseId) {
		if(this.warehouseIds==null) warehouseIds=new ArrayList<>();
		this.warehouseIds.add(warehouseId);
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public List<Catalog> getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public Inventory setCategory(List<Catalog> category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 添加 资产分类
	 * @param entity 资产分类
	 * @return 当前对象
	*/
	public Inventory addCategory(Catalog entity) {
		if(this.category==null) category=new ArrayList<>();
		this.category.add(entity);
		return this;
	}
	
	/**
	 * 获得 资产分类Ids<br>
	 * 资产分类Ids
	 * @return 资产分类Ids
	*/
	public List<String> getCategoryIds() {
		return categoryIds;
	}
	
	/**
	 * 设置 资产分类Ids
	 * @param categoryIds 资产分类Ids
	 * @return 当前对象
	*/
	public Inventory setCategoryIds(List<String> categoryIds) {
		this.categoryIds=categoryIds;
		return this;
	}
	
	/**
	 * 添加 资产分类Ids
	 * @param categoryId 资产分类Ids
	 * @return 当前对象
	*/
	public Inventory addCategoryId(String categoryId) {
		if(this.categoryIds==null) categoryIds=new ArrayList<>();
		this.categoryIds.add(categoryId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Inventory , 转换好的 Inventory 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Inventory , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Inventory
	 * @param inventoryMap 包含实体信息的 Map 对象
	 * @return Inventory , 转换好的的 Inventory 对象
	*/
	@Transient
	public static Inventory createFrom(Map<String,Object> inventoryMap) {
		if(inventoryMap==null) return null;
		Inventory po = EntityContext.create(Inventory.class, inventoryMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Inventory
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Inventory , 转换好的的 Inventory 对象
	*/
	@Transient
	public static Inventory createFrom(Object pojo) {
		if(pojo==null) return null;
		Inventory po = EntityContext.create(Inventory.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Inventory，等同于 new
	 * @return Inventory 对象
	*/
	@Transient
	public static Inventory create() {
		return EntityContext.create(Inventory.class);
	}
}