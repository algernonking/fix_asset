package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_GOODS_OUT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 库存出库
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-24 15:04:54
 * @sign D5EA2B41E4FDD5275EBDF127006BD9A5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_goods_out")
public class AssetStockGoodsOut extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_GOODS_OUT.$TABLE;
	
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
	 * 库存所属：库存所属
	*/
	@ApiModelProperty(required = false,value="库存所属" , notes = "库存所属")
	private String ownerType;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String name;
	
	/**
	 * 出库所属：出库所属
	*/
	@ApiModelProperty(required = false,value="出库所属" , notes = "出库所属")
	private String stockType;
	
	/**
	 * 领用公司：领用公司
	*/
	@ApiModelProperty(required = false,value="领用公司" , notes = "领用公司")
	private String useOwnCompanyId;
	
	/**
	 * 领用部门：领用部门
	*/
	@ApiModelProperty(required = false,value="领用部门" , notes = "领用部门")
	private String useOrganizationId;
	
	/**
	 * 领用人员：领用人员
	*/
	@ApiModelProperty(required = false,value="领用人员" , notes = "领用人员")
	private String useUserId;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseId;
	
	/**
	 * 出库位置：出库位置
	*/
	@ApiModelProperty(required = false,value="出库位置" , notes = "出库位置")
	private String positionDetail;
	
	/**
	 * 出库日期：出库日期
	*/
	@ApiModelProperty(required = false,value="出库日期" , notes = "出库日期")
	private Date collectionDate;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
	/**
	 * 出库说明：出库说明
	*/
	@ApiModelProperty(required = false,value="出库说明" , notes = "出库说明")
	private String content;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
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
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private List<GoodsStock> goodsList;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private List<String> goodsIds;
	
	/**
	 * 出库类型：出库类型
	*/
	@ApiModelProperty(required = false,value="出库类型" , notes = "出库类型")
	private DictItem stockTypeDict;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Organization useOwnCompany;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private Warehouse warehouse;
	
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
	public AssetStockGoodsOut setId(String id) {
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
	public AssetStockGoodsOut setBusinessCode(String businessCode) {
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
	public AssetStockGoodsOut setProcId(String procId) {
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
	public AssetStockGoodsOut setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 库存所属<br>
	 * 库存所属
	 * @return 库存所属
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 库存所属
	 * @param ownerType 库存所属
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setOwnerType(String ownerType) {
		this.ownerType=ownerType;
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
	public AssetStockGoodsOut setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 出库所属<br>
	 * 出库所属
	 * @return 出库所属
	*/
	public String getStockType() {
		return stockType;
	}
	
	/**
	 * 设置 出库所属
	 * @param stockType 出库所属
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setStockType(String stockType) {
		this.stockType=stockType;
		return this;
	}
	
	/**
	 * 获得 领用公司<br>
	 * 领用公司
	 * @return 领用公司
	*/
	public String getUseOwnCompanyId() {
		return useOwnCompanyId;
	}
	
	/**
	 * 设置 领用公司
	 * @param useOwnCompanyId 领用公司
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setUseOwnCompanyId(String useOwnCompanyId) {
		this.useOwnCompanyId=useOwnCompanyId;
		return this;
	}
	
	/**
	 * 获得 领用部门<br>
	 * 领用部门
	 * @return 领用部门
	*/
	public String getUseOrganizationId() {
		return useOrganizationId;
	}
	
	/**
	 * 设置 领用部门
	 * @param useOrganizationId 领用部门
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 领用人员<br>
	 * 领用人员
	 * @return 领用人员
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 领用人员
	 * @param useUserId 领用人员
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setUseUserId(String useUserId) {
		this.useUserId=useUserId;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseId 仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
		return this;
	}
	
	/**
	 * 获得 出库位置<br>
	 * 出库位置
	 * @return 出库位置
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 出库位置
	 * @param positionDetail 出库位置
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 出库日期<br>
	 * 出库日期
	 * @return 出库日期
	*/
	public Date getCollectionDate() {
		return collectionDate;
	}
	
	/**
	 * 设置 出库日期
	 * @param collectionDate 出库日期
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setCollectionDate(Date collectionDate) {
		this.collectionDate=collectionDate;
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
	public AssetStockGoodsOut setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
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
	public AssetStockGoodsOut setContent(String content) {
		this.content=content;
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
	public AssetStockGoodsOut setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public AssetStockGoodsOut setAttachId(String attachId) {
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
	public AssetStockGoodsOut setCreateBy(String createBy) {
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
	public AssetStockGoodsOut setCreateTime(Date createTime) {
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
	public AssetStockGoodsOut setUpdateBy(String updateBy) {
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
	public AssetStockGoodsOut setUpdateTime(Date updateTime) {
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
	public AssetStockGoodsOut setDeleted(Integer deleted) {
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
	public AssetStockGoodsOut setDeleteBy(String deleteBy) {
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
	public AssetStockGoodsOut setDeleteTime(Date deleteTime) {
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
	public AssetStockGoodsOut setVersion(Integer version) {
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
	public AssetStockGoodsOut setTenantId(String tenantId) {
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
	public AssetStockGoodsOut setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public AssetStockGoodsOut setChsType(String chsType) {
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
	public AssetStockGoodsOut setChsStatus(String chsStatus) {
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
	public AssetStockGoodsOut setChsVersion(String chsVersion) {
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
	public AssetStockGoodsOut setChangeInstanceId(String changeInstanceId) {
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
	public AssetStockGoodsOut setSummary(String summary) {
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
	public AssetStockGoodsOut setLatestApproverId(String latestApproverId) {
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
	public AssetStockGoodsOut setLatestApproverName(String latestApproverName) {
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
	public AssetStockGoodsOut setNextApproverIds(String nextApproverIds) {
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
	public AssetStockGoodsOut setNextApproverNames(String nextApproverNames) {
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
	public AssetStockGoodsOut setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion=approvalOpinion;
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public List<GoodsStock> getGoodsList() {
		return goodsList;
	}
	
	/**
	 * 设置 物品
	 * @param goodsList 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setGoodsList(List<GoodsStock> goodsList) {
		this.goodsList=goodsList;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goods 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsOut addGoods(GoodsStock goods) {
		if(this.goodsList==null) goodsList=new ArrayList<>();
		this.goodsList.add(goods);
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public List<String> getGoodsIds() {
		return goodsIds;
	}
	
	/**
	 * 设置 物品
	 * @param goodsIds 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setGoodsIds(List<String> goodsIds) {
		this.goodsIds=goodsIds;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goodsId 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsOut addGoodsId(String goodsId) {
		if(this.goodsIds==null) goodsIds=new ArrayList<>();
		this.goodsIds.add(goodsId);
		return this;
	}
	
	/**
	 * 获得 出库类型<br>
	 * 出库类型
	 * @return 出库类型
	*/
	public DictItem getStockTypeDict() {
		return stockTypeDict;
	}
	
	/**
	 * 设置 出库类型
	 * @param stockTypeDict 出库类型
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setStockTypeDict(DictItem stockTypeDict) {
		this.stockTypeDict=stockTypeDict;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public Organization getUseOwnCompany() {
		return useOwnCompany;
	}
	
	/**
	 * 设置 所属公司
	 * @param useOwnCompany 所属公司
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setUseOwnCompany(Organization useOwnCompany) {
		this.useOwnCompany=useOwnCompany;
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
	public AssetStockGoodsOut setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsOut setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
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
	public AssetStockGoodsOut setOriginator(Employee originator) {
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
	public AssetStockGoodsOut setUseUser(Employee useUser) {
		this.useUser=useUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockGoodsOut , 转换好的 AssetStockGoodsOut 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsOut , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetStockGoodsOut
	 * @param assetStockGoodsOutMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsOut , 转换好的的 AssetStockGoodsOut 对象
	*/
	@Transient
	public static AssetStockGoodsOut createFrom(Map<String,Object> assetStockGoodsOutMap) {
		if(assetStockGoodsOutMap==null) return null;
		AssetStockGoodsOut po = EntityContext.create(AssetStockGoodsOut.class, assetStockGoodsOutMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsOut
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsOut , 转换好的的 AssetStockGoodsOut 对象
	*/
	@Transient
	public static AssetStockGoodsOut createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsOut po = EntityContext.create(AssetStockGoodsOut.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetStockGoodsOut，等同于 new
	 * @return AssetStockGoodsOut 对象
	*/
	@Transient
	public static AssetStockGoodsOut create() {
		return EntityContext.create(AssetStockGoodsOut.class);
	}
}