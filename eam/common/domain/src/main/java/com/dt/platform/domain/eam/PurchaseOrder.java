package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_PURCHASE_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 采购订单
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-17 01:46:37
 * @sign F3BF4A39023C4678982061352917D506
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_purchase_order")
public class PurchaseOrder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_PURCHASE_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 业务编码：业务编码
	*/
	@ApiModelProperty(required = false,value="业务编码" , notes = "业务编码")
	private String businessCode;
	
	/**
	 * 订单编号：订单编号
	*/
	@ApiModelProperty(required = false,value="订单编号" , notes = "订单编号")
	private String code;
	
	/**
	 * 订单名称：订单名称
	*/
	@ApiModelProperty(required = false,value="订单名称" , notes = "订单名称")
	private String name;
	
	/**
	 * 采购申请单：采购申请单
	*/
	@ApiModelProperty(required = false,value="采购申请单" , notes = "采购申请单")
	private String applyId;
	
	/**
	 * 验收单：验收单
	*/
	@ApiModelProperty(required = false,value="验收单" , notes = "验收单")
	private String checkId;
	
	/**
	 * 物品类型：物品类型
	*/
	@ApiModelProperty(required = false,value="物品类型" , notes = "物品类型")
	private String goodsType;
	
	/**
	 * 存放类型：存放类型
	*/
	@ApiModelProperty(required = false,value="存放类型" , notes = "存放类型")
	private String storageType;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * 购买申请：购买申请
	*/
	@ApiModelProperty(required = false,value="购买申请" , notes = "购买申请")
	private Employee purchaseApply;
	
	/**
	 * 验收单：验收单
	*/
	@ApiModelProperty(required = false,value="验收单" , notes = "验收单")
	private Employee purchaseCheck;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
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
	public PurchaseOrder setId(String id) {
		this.id=id;
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
	public PurchaseOrder setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 订单编号<br>
	 * 订单编号
	 * @return 订单编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 订单编号
	 * @param code 订单编号
	 * @return 当前对象
	*/
	public PurchaseOrder setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 订单名称<br>
	 * 订单名称
	 * @return 订单名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 订单名称
	 * @param name 订单名称
	 * @return 当前对象
	*/
	public PurchaseOrder setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 采购申请单<br>
	 * 采购申请单
	 * @return 采购申请单
	*/
	public String getApplyId() {
		return applyId;
	}
	
	/**
	 * 设置 采购申请单
	 * @param applyId 采购申请单
	 * @return 当前对象
	*/
	public PurchaseOrder setApplyId(String applyId) {
		this.applyId=applyId;
		return this;
	}
	
	/**
	 * 获得 验收单<br>
	 * 验收单
	 * @return 验收单
	*/
	public String getCheckId() {
		return checkId;
	}
	
	/**
	 * 设置 验收单
	 * @param checkId 验收单
	 * @return 当前对象
	*/
	public PurchaseOrder setCheckId(String checkId) {
		this.checkId=checkId;
		return this;
	}
	
	/**
	 * 获得 物品类型<br>
	 * 物品类型
	 * @return 物品类型
	*/
	public String getGoodsType() {
		return goodsType;
	}
	
	/**
	 * 设置 物品类型
	 * @param goodsType 物品类型
	 * @return 当前对象
	*/
	public PurchaseOrder setGoodsType(String goodsType) {
		this.goodsType=goodsType;
		return this;
	}
	
	/**
	 * 获得 存放类型<br>
	 * 存放类型
	 * @return 存放类型
	*/
	public String getStorageType() {
		return storageType;
	}
	
	/**
	 * 设置 存放类型
	 * @param storageType 存放类型
	 * @return 当前对象
	*/
	public PurchaseOrder setStorageType(String storageType) {
		this.storageType=storageType;
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
	public PurchaseOrder setNotes(String notes) {
		this.notes=notes;
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
	public PurchaseOrder setOriginatorId(String originatorId) {
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
	public PurchaseOrder setCreateBy(String createBy) {
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
	public PurchaseOrder setCreateTime(Date createTime) {
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
	public PurchaseOrder setUpdateBy(String updateBy) {
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
	public PurchaseOrder setUpdateTime(Date updateTime) {
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
	public PurchaseOrder setDeleted(Integer deleted) {
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
	public PurchaseOrder setDeleteBy(String deleteBy) {
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
	public PurchaseOrder setDeleteTime(Date deleteTime) {
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
	public PurchaseOrder setVersion(Integer version) {
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
	public PurchaseOrder setTenantId(String tenantId) {
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
	public PurchaseOrder setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 购买申请<br>
	 * 购买申请
	 * @return 购买申请
	*/
	public Employee getPurchaseApply() {
		return purchaseApply;
	}
	
	/**
	 * 设置 购买申请
	 * @param purchaseApply 购买申请
	 * @return 当前对象
	*/
	public PurchaseOrder setPurchaseApply(Employee purchaseApply) {
		this.purchaseApply=purchaseApply;
		return this;
	}
	
	/**
	 * 获得 验收单<br>
	 * 验收单
	 * @return 验收单
	*/
	public Employee getPurchaseCheck() {
		return purchaseCheck;
	}
	
	/**
	 * 设置 验收单
	 * @param purchaseCheck 验收单
	 * @return 当前对象
	*/
	public PurchaseOrder setPurchaseCheck(Employee purchaseCheck) {
		this.purchaseCheck=purchaseCheck;
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
	public PurchaseOrder setOriginator(Employee originator) {
		this.originator=originator;
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
	public PurchaseOrder setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public PurchaseOrder addAsset(Asset asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.add(asset);
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
	public PurchaseOrder setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public PurchaseOrder addAssetId(String assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.add(assetId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PurchaseOrder , 转换好的 PurchaseOrder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PurchaseOrder , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 PurchaseOrder
	 * @param purchaseOrderMap 包含实体信息的 Map 对象
	 * @return PurchaseOrder , 转换好的的 PurchaseOrder 对象
	*/
	@Transient
	public static PurchaseOrder createFrom(Map<String,Object> purchaseOrderMap) {
		if(purchaseOrderMap==null) return null;
		PurchaseOrder po = EntityContext.create(PurchaseOrder.class, purchaseOrderMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 PurchaseOrder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PurchaseOrder , 转换好的的 PurchaseOrder 对象
	*/
	@Transient
	public static PurchaseOrder createFrom(Object pojo) {
		if(pojo==null) return null;
		PurchaseOrder po = EntityContext.create(PurchaseOrder.class,pojo);
		return po;
	}

	/**
	 * 创建一个 PurchaseOrder，等同于 new
	 * @return PurchaseOrder 对象
	*/
	@Transient
	public static PurchaseOrder create() {
		return EntityContext.create(PurchaseOrder.class);
	}
}