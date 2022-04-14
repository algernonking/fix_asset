package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_PURCHASE_CHECK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 采购验收
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-15 05:45:02
 * @sign 4FE5EF545960C08C1578074F6877D559
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_purchase_check")
public class PurchaseCheck extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_PURCHASE_CHECK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
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
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 采购申请：采购申请
	*/
	@ApiModelProperty(required = false,value="采购申请" , notes = "采购申请")
	private String ownerId;
	
	/**
	 * 验收单：验收单
	*/
	@ApiModelProperty(required = false,value="验收单" , notes = "验收单")
	private String code;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private String supplierId;
	
	/**
	 * 验收部门：验收部门
	*/
	@ApiModelProperty(required = false,value="验收部门" , notes = "验收部门")
	private String checkOrgId;
	
	/**
	 * 验收人：验收人
	*/
	@ApiModelProperty(required = false,value="验收人" , notes = "验收人")
	private String checkUserName;
	
	/**
	 * 到货日期：到货日期
	*/
	@ApiModelProperty(required = false,value="到货日期" , notes = "到货日期")
	private String receiveDate;
	
	/**
	 * 验收时间：验收时间
	*/
	@ApiModelProperty(required = false,value="验收时间" , notes = "验收时间")
	private String checkDate;
	
	/**
	 * 验收信息：验收信息
	*/
	@ApiModelProperty(required = false,value="验收信息" , notes = "验收信息")
	private String checkInformation;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
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
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
	/**
	 * 领用申请：领用申请
	*/
	@ApiModelProperty(required = false,value="领用申请" , notes = "领用申请")
	private PurchaseApply purchaseApply;
	
	/**
	 * 验收公司/部门：验收公司/部门
	*/
	@ApiModelProperty(required = false,value="验收公司/部门" , notes = "验收公司/部门")
	private Organization checkOrg;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 订单：订单
	*/
	@ApiModelProperty(required = false,value="订单" , notes = "订单")
	private List<Asset> orderList;
	
	/**
	 * 订单列表：订单列表
	*/
	@ApiModelProperty(required = false,value="订单列表" , notes = "订单列表")
	private List<String> orderIds;
	
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
	public PurchaseCheck setId(String id) {
		this.id=id;
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
	public PurchaseCheck setProcId(String procId) {
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
	public PurchaseCheck setStatus(String status) {
		this.status=status;
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
	public PurchaseCheck setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public PurchaseCheck setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 采购申请<br>
	 * 采购申请
	 * @return 采购申请
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 采购申请
	 * @param ownerId 采购申请
	 * @return 当前对象
	*/
	public PurchaseCheck setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 验收单<br>
	 * 验收单
	 * @return 验收单
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 验收单
	 * @param code 验收单
	 * @return 当前对象
	*/
	public PurchaseCheck setCode(String code) {
		this.code=code;
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
	public PurchaseCheck setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 验收部门<br>
	 * 验收部门
	 * @return 验收部门
	*/
	public String getCheckOrgId() {
		return checkOrgId;
	}
	
	/**
	 * 设置 验收部门
	 * @param checkOrgId 验收部门
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckOrgId(String checkOrgId) {
		this.checkOrgId=checkOrgId;
		return this;
	}
	
	/**
	 * 获得 验收人<br>
	 * 验收人
	 * @return 验收人
	*/
	public String getCheckUserName() {
		return checkUserName;
	}
	
	/**
	 * 设置 验收人
	 * @param checkUserName 验收人
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckUserName(String checkUserName) {
		this.checkUserName=checkUserName;
		return this;
	}
	
	/**
	 * 获得 到货日期<br>
	 * 到货日期
	 * @return 到货日期
	*/
	public String getReceiveDate() {
		return receiveDate;
	}
	
	/**
	 * 设置 到货日期
	 * @param receiveDate 到货日期
	 * @return 当前对象
	*/
	public PurchaseCheck setReceiveDate(String receiveDate) {
		this.receiveDate=receiveDate;
		return this;
	}
	
	/**
	 * 获得 验收时间<br>
	 * 验收时间
	 * @return 验收时间
	*/
	public String getCheckDate() {
		return checkDate;
	}
	
	/**
	 * 设置 验收时间
	 * @param checkDate 验收时间
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckDate(String checkDate) {
		this.checkDate=checkDate;
		return this;
	}
	
	/**
	 * 获得 验收信息<br>
	 * 验收信息
	 * @return 验收信息
	*/
	public String getCheckInformation() {
		return checkInformation;
	}
	
	/**
	 * 设置 验收信息
	 * @param checkInformation 验收信息
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckInformation(String checkInformation) {
		this.checkInformation=checkInformation;
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
	public PurchaseCheck setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public PurchaseCheck setAttach(String attach) {
		this.attach=attach;
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
	public PurchaseCheck setOriginatorId(String originatorId) {
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
	public PurchaseCheck setCreateBy(String createBy) {
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
	public PurchaseCheck setCreateTime(Date createTime) {
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
	public PurchaseCheck setUpdateBy(String updateBy) {
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
	public PurchaseCheck setUpdateTime(Date updateTime) {
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
	public PurchaseCheck setDeleted(Integer deleted) {
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
	public PurchaseCheck setDeleteBy(String deleteBy) {
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
	public PurchaseCheck setDeleteTime(Date deleteTime) {
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
	public PurchaseCheck setVersion(Integer version) {
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
	public PurchaseCheck setTenantId(String tenantId) {
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
	public PurchaseCheck setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public PurchaseCheck setSupplier(Supplier supplier) {
		this.supplier=supplier;
		return this;
	}
	
	/**
	 * 获得 领用申请<br>
	 * 领用申请
	 * @return 领用申请
	*/
	public PurchaseApply getPurchaseApply() {
		return purchaseApply;
	}
	
	/**
	 * 设置 领用申请
	 * @param purchaseApply 领用申请
	 * @return 当前对象
	*/
	public PurchaseCheck setPurchaseApply(PurchaseApply purchaseApply) {
		this.purchaseApply=purchaseApply;
		return this;
	}
	
	/**
	 * 获得 验收公司/部门<br>
	 * 验收公司/部门
	 * @return 验收公司/部门
	*/
	public Organization getCheckOrg() {
		return checkOrg;
	}
	
	/**
	 * 设置 验收公司/部门
	 * @param checkOrg 验收公司/部门
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckOrg(Organization checkOrg) {
		this.checkOrg=checkOrg;
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
	public PurchaseCheck setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 订单<br>
	 * 订单
	 * @return 订单
	*/
	public List<Asset> getOrderList() {
		return orderList;
	}
	
	/**
	 * 设置 订单
	 * @param orderList 订单
	 * @return 当前对象
	*/
	public PurchaseCheck setOrderList(List<Asset> orderList) {
		this.orderList=orderList;
		return this;
	}
	
	/**
	 * 添加 订单
	 * @param order 订单
	 * @return 当前对象
	*/
	public PurchaseCheck addOrder(Asset order) {
		if(this.orderList==null) orderList=new ArrayList<>();
		this.orderList.add(order);
		return this;
	}
	
	/**
	 * 获得 订单列表<br>
	 * 订单列表
	 * @return 订单列表
	*/
	public List<String> getOrderIds() {
		return orderIds;
	}
	
	/**
	 * 设置 订单列表
	 * @param orderIds 订单列表
	 * @return 当前对象
	*/
	public PurchaseCheck setOrderIds(List<String> orderIds) {
		this.orderIds=orderIds;
		return this;
	}
	
	/**
	 * 添加 订单列表
	 * @param orderId 订单列表
	 * @return 当前对象
	*/
	public PurchaseCheck addOrderId(String orderId) {
		if(this.orderIds==null) orderIds=new ArrayList<>();
		this.orderIds.add(orderId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PurchaseCheck , 转换好的 PurchaseCheck 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PurchaseCheck , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 PurchaseCheck
	 * @param purchaseCheckMap 包含实体信息的 Map 对象
	 * @return PurchaseCheck , 转换好的的 PurchaseCheck 对象
	*/
	@Transient
	public static PurchaseCheck createFrom(Map<String,Object> purchaseCheckMap) {
		if(purchaseCheckMap==null) return null;
		PurchaseCheck po = EntityContext.create(PurchaseCheck.class, purchaseCheckMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 PurchaseCheck
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PurchaseCheck , 转换好的的 PurchaseCheck 对象
	*/
	@Transient
	public static PurchaseCheck createFrom(Object pojo) {
		if(pojo==null) return null;
		PurchaseCheck po = EntityContext.create(PurchaseCheck.class,pojo);
		return po;
	}

	/**
	 * 创建一个 PurchaseCheck，等同于 new
	 * @return PurchaseCheck 对象
	*/
	@Transient
	public static PurchaseCheck create() {
		return EntityContext.create(PurchaseCheck.class);
	}
}