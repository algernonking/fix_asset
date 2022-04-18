package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_DELIVER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 库存出库
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-17 19:24:29
 * @sign 395556DFFD1DEC72D14959FB981F2D2C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_deliver")
public class AssetStockDeliver extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_DELIVER.$TABLE;
	
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
	 * 出库状态：出库状态
	*/
	@ApiModelProperty(required = false,value="出库状态" , notes = "出库状态")
	private String deliverStatus;
	
	/**
	 * 库存所属：库存所属
	*/
	@ApiModelProperty(required = false,value="库存所属" , notes = "库存所属")
	private String ownerCode;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String name;
	
	/**
	 * 出库类型：出库类型
	*/
	@ApiModelProperty(required = false,value="出库类型" , notes = "出库类型")
	private String deliverType;
	
	/**
	 * 出货日期：出货日期
	*/
	@ApiModelProperty(required = false,value="出货日期" , notes = "出货日期")
	private Date deliverDate;
	
	/**
	 * 领用公司：领用公司
	*/
	@ApiModelProperty(required = false,value="领用公司" , notes = "领用公司")
	private String receivingCompanyId;
	
	/**
	 * 领用部门：领用部门
	*/
	@ApiModelProperty(required = false,value="领用部门" , notes = "领用部门")
	private String receivingOrgId;
	
	/**
	 * 领用人：领用人
	*/
	@ApiModelProperty(required = false,value="领用人" , notes = "领用人")
	private String receiverId;
	
	/**
	 * 出货人：出货人
	*/
	@ApiModelProperty(required = false,value="出货人" , notes = "出货人")
	private String shipperName;
	
	/**
	 * 详细位置：详细位置
	*/
	@ApiModelProperty(required = false,value="详细位置" , notes = "详细位置")
	private String positionDetail;
	
	/**
	 * 出库说明：出库说明
	*/
	@ApiModelProperty(required = false,value="出库说明" , notes = "出库说明")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
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
	 * 库存资产：库存资产
	*/
	@ApiModelProperty(required = false,value="库存资产" , notes = "库存资产")
	private List<Asset> deliverAssetList;
	
	/**
	 * 库存资产：库存资产
	*/
	@ApiModelProperty(required = false,value="库存资产" , notes = "库存资产")
	private List<String> deliverAssetIds;
	
	/**
	 * 变更实例：变更实例
	*/
	@ApiModelProperty(required = false,value="变更实例" , notes = "变更实例")
	private ChangeInstance changeInstance;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 领用人：领用人
	*/
	@ApiModelProperty(required = false,value="领用人" , notes = "领用人")
	private Employee receiver;
	
	/**
	 * 领用公司：领用公司
	*/
	@ApiModelProperty(required = false,value="领用公司" , notes = "领用公司")
	private Organization receivingCompany;
	
	/**
	 * 领用部门：领用部门
	*/
	@ApiModelProperty(required = false,value="领用部门" , notes = "领用部门")
	private Employee receivingOrg;
	
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
	public AssetStockDeliver setId(String id) {
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
	public AssetStockDeliver setBusinessCode(String businessCode) {
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
	public AssetStockDeliver setProcId(String procId) {
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
	public AssetStockDeliver setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 出库状态<br>
	 * 出库状态
	 * @return 出库状态
	*/
	public String getDeliverStatus() {
		return deliverStatus;
	}
	
	/**
	 * 设置 出库状态
	 * @param deliverStatus 出库状态
	 * @return 当前对象
	*/
	public AssetStockDeliver setDeliverStatus(String deliverStatus) {
		this.deliverStatus=deliverStatus;
		return this;
	}
	
	/**
	 * 获得 库存所属<br>
	 * 库存所属
	 * @return 库存所属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 库存所属
	 * @param ownerCode 库存所属
	 * @return 当前对象
	*/
	public AssetStockDeliver setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
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
	public AssetStockDeliver setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 出库类型<br>
	 * 出库类型
	 * @return 出库类型
	*/
	public String getDeliverType() {
		return deliverType;
	}
	
	/**
	 * 设置 出库类型
	 * @param deliverType 出库类型
	 * @return 当前对象
	*/
	public AssetStockDeliver setDeliverType(String deliverType) {
		this.deliverType=deliverType;
		return this;
	}
	
	/**
	 * 获得 出货日期<br>
	 * 出货日期
	 * @return 出货日期
	*/
	public Date getDeliverDate() {
		return deliverDate;
	}
	
	/**
	 * 设置 出货日期
	 * @param deliverDate 出货日期
	 * @return 当前对象
	*/
	public AssetStockDeliver setDeliverDate(Date deliverDate) {
		this.deliverDate=deliverDate;
		return this;
	}
	
	/**
	 * 获得 领用公司<br>
	 * 领用公司
	 * @return 领用公司
	*/
	public String getReceivingCompanyId() {
		return receivingCompanyId;
	}
	
	/**
	 * 设置 领用公司
	 * @param receivingCompanyId 领用公司
	 * @return 当前对象
	*/
	public AssetStockDeliver setReceivingCompanyId(String receivingCompanyId) {
		this.receivingCompanyId=receivingCompanyId;
		return this;
	}
	
	/**
	 * 获得 领用部门<br>
	 * 领用部门
	 * @return 领用部门
	*/
	public String getReceivingOrgId() {
		return receivingOrgId;
	}
	
	/**
	 * 设置 领用部门
	 * @param receivingOrgId 领用部门
	 * @return 当前对象
	*/
	public AssetStockDeliver setReceivingOrgId(String receivingOrgId) {
		this.receivingOrgId=receivingOrgId;
		return this;
	}
	
	/**
	 * 获得 领用人<br>
	 * 领用人
	 * @return 领用人
	*/
	public String getReceiverId() {
		return receiverId;
	}
	
	/**
	 * 设置 领用人
	 * @param receiverId 领用人
	 * @return 当前对象
	*/
	public AssetStockDeliver setReceiverId(String receiverId) {
		this.receiverId=receiverId;
		return this;
	}
	
	/**
	 * 获得 出货人<br>
	 * 出货人
	 * @return 出货人
	*/
	public String getShipperName() {
		return shipperName;
	}
	
	/**
	 * 设置 出货人
	 * @param shipperName 出货人
	 * @return 当前对象
	*/
	public AssetStockDeliver setShipperName(String shipperName) {
		this.shipperName=shipperName;
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
	public AssetStockDeliver setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 出库说明<br>
	 * 出库说明
	 * @return 出库说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 出库说明
	 * @param content 出库说明
	 * @return 当前对象
	*/
	public AssetStockDeliver setContent(String content) {
		this.content=content;
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
	public AssetStockDeliver setAttach(String attach) {
		this.attach=attach;
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
	public AssetStockDeliver setNotes(String notes) {
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
	public AssetStockDeliver setOriginatorId(String originatorId) {
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
	public AssetStockDeliver setCreateBy(String createBy) {
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
	public AssetStockDeliver setCreateTime(Date createTime) {
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
	public AssetStockDeliver setUpdateBy(String updateBy) {
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
	public AssetStockDeliver setUpdateTime(Date updateTime) {
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
	public AssetStockDeliver setDeleted(Integer deleted) {
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
	public AssetStockDeliver setDeleteBy(String deleteBy) {
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
	public AssetStockDeliver setDeleteTime(Date deleteTime) {
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
	public AssetStockDeliver setVersion(Integer version) {
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
	public AssetStockDeliver setTenantId(String tenantId) {
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
	public AssetStockDeliver setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 库存资产<br>
	 * 库存资产
	 * @return 库存资产
	*/
	public List<Asset> getDeliverAssetList() {
		return deliverAssetList;
	}
	
	/**
	 * 设置 库存资产
	 * @param deliverAssetList 库存资产
	 * @return 当前对象
	*/
	public AssetStockDeliver setDeliverAssetList(List<Asset> deliverAssetList) {
		this.deliverAssetList=deliverAssetList;
		return this;
	}
	
	/**
	 * 添加 库存资产
	 * @param deliverAsset 库存资产
	 * @return 当前对象
	*/
	public AssetStockDeliver addDeliverAsset(Asset deliverAsset) {
		if(this.deliverAssetList==null) deliverAssetList=new ArrayList<>();
		this.deliverAssetList.add(deliverAsset);
		return this;
	}
	
	/**
	 * 获得 库存资产<br>
	 * 库存资产
	 * @return 库存资产
	*/
	public List<String> getDeliverAssetIds() {
		return deliverAssetIds;
	}
	
	/**
	 * 设置 库存资产
	 * @param deliverAssetIds 库存资产
	 * @return 当前对象
	*/
	public AssetStockDeliver setDeliverAssetIds(List<String> deliverAssetIds) {
		this.deliverAssetIds=deliverAssetIds;
		return this;
	}
	
	/**
	 * 添加 库存资产
	 * @param deliverAssetId 库存资产
	 * @return 当前对象
	*/
	public AssetStockDeliver addDeliverAssetId(String deliverAssetId) {
		if(this.deliverAssetIds==null) deliverAssetIds=new ArrayList<>();
		this.deliverAssetIds.add(deliverAssetId);
		return this;
	}
	
	/**
	 * 获得 变更实例<br>
	 * 变更实例
	 * @return 变更实例
	*/
	public ChangeInstance getChangeInstance() {
		return changeInstance;
	}
	
	/**
	 * 设置 变更实例
	 * @param changeInstance 变更实例
	 * @return 当前对象
	*/
	public AssetStockDeliver setChangeInstance(ChangeInstance changeInstance) {
		this.changeInstance=changeInstance;
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
	public AssetStockDeliver setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 领用人<br>
	 * 领用人
	 * @return 领用人
	*/
	public Employee getReceiver() {
		return receiver;
	}
	
	/**
	 * 设置 领用人
	 * @param receiver 领用人
	 * @return 当前对象
	*/
	public AssetStockDeliver setReceiver(Employee receiver) {
		this.receiver=receiver;
		return this;
	}
	
	/**
	 * 获得 领用公司<br>
	 * 领用公司
	 * @return 领用公司
	*/
	public Organization getReceivingCompany() {
		return receivingCompany;
	}
	
	/**
	 * 设置 领用公司
	 * @param receivingCompany 领用公司
	 * @return 当前对象
	*/
	public AssetStockDeliver setReceivingCompany(Organization receivingCompany) {
		this.receivingCompany=receivingCompany;
		return this;
	}
	
	/**
	 * 获得 领用部门<br>
	 * 领用部门
	 * @return 领用部门
	*/
	public Employee getReceivingOrg() {
		return receivingOrg;
	}
	
	/**
	 * 设置 领用部门
	 * @param receivingOrg 领用部门
	 * @return 当前对象
	*/
	public AssetStockDeliver setReceivingOrg(Employee receivingOrg) {
		this.receivingOrg=receivingOrg;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockDeliver , 转换好的 AssetStockDeliver 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockDeliver , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetStockDeliver
	 * @param assetStockDeliverMap 包含实体信息的 Map 对象
	 * @return AssetStockDeliver , 转换好的的 AssetStockDeliver 对象
	*/
	@Transient
	public static AssetStockDeliver createFrom(Map<String,Object> assetStockDeliverMap) {
		if(assetStockDeliverMap==null) return null;
		AssetStockDeliver po = EntityContext.create(AssetStockDeliver.class, assetStockDeliverMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockDeliver
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockDeliver , 转换好的的 AssetStockDeliver 对象
	*/
	@Transient
	public static AssetStockDeliver createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockDeliver po = EntityContext.create(AssetStockDeliver.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetStockDeliver，等同于 new
	 * @return AssetStockDeliver 对象
	*/
	@Transient
	public static AssetStockDeliver create() {
		return EntityContext.create(AssetStockDeliver.class);
	}
}