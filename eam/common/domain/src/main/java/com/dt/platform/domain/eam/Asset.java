package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 16:08:06
 * @sign 7F41570137C24DA53D6E5298E95A7F8C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset")
public class Asset extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = true,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 分类编码：分类编码
	*/
	@ApiModelProperty(required = false,value="分类编码" , notes = "分类编码")
	private String categoryCode;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String busiCode;
	
	/**
	 * 批次编码：批次编码
	*/
	@ApiModelProperty(required = false,value="批次编码" , notes = "批次编码")
	private String batchCode;
	
	/**
	 * 资产编号：资产编号
	*/
	@ApiModelProperty(required = false,value="资产编号" , notes = "资产编号")
	private String assetCode;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = true,value="资产状态" , notes = "资产状态")
	private String status;
	
	/**
	 * 是否显示：是否显示
	*/
	@ApiModelProperty(required = false,value="是否显示" , notes = "是否显示")
	private String display;
	
	/**
	 * 是否报废：是否报废
	*/
	@ApiModelProperty(required = false,value="是否报废" , notes = "是否报废")
	private String scrap;
	
	/**
	 * 标准物品档案：标准物品档案
	*/
	@ApiModelProperty(required = false,value="标准物品档案" , notes = "标准物品档案")
	private String goodsId;
	
	/**
	 * 标准型号资产名称：标准型号资产名称
	*/
	@ApiModelProperty(required = true,value="标准型号资产名称" , notes = "标准型号资产名称")
	private String name;
	
	/**
	 * 标准型号厂商：标准型号厂商
	*/
	@ApiModelProperty(required = false,value="标准型号厂商" , notes = "标准型号厂商")
	private String manufacturerId;
	
	/**
	 * 标准型号规格型号：标准型号规格型号
	*/
	@ApiModelProperty(required = false,value="标准型号规格型号" , notes = "标准型号规格型号")
	private String model;
	
	/**
	 * 标准型号物品图片：标准型号物品图片
	*/
	@ApiModelProperty(required = false,value="标准型号物品图片" , notes = "标准型号物品图片")
	private String pictureId;
	
	/**
	 * 标准型号计量单位：标准型号计量单位
	*/
	@ApiModelProperty(required = false,value="标准型号计量单位" , notes = "标准型号计量单位")
	private String unit;
	
	/**
	 * 序列号：序列号
	*/
	@ApiModelProperty(required = false,value="序列号" , notes = "序列号")
	private String serialNumber;
	
	/**
	 * 所属组织：所属组织
	*/
	@ApiModelProperty(required = false,value="所属组织" , notes = "所属组织")
	private String managementOrganizationId;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private String managerId;
	
	/**
	 * 使用组织：使用组织
	*/
	@ApiModelProperty(required = false,value="使用组织" , notes = "使用组织")
	private String userOrganizationId;
	
	/**
	 * 使用人员：使用人员
	*/
	@ApiModelProperty(required = false,value="使用人员" , notes = "使用人员")
	private String userId;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private String positionId;
	
	/**
	 * 详细位置：详细位置
	*/
	@ApiModelProperty(required = false,value="详细位置" , notes = "详细位置")
	private String positionDetail;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseId;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String sourceId;
	
	/**
	 * 资产数量：资产数量
	*/
	@ApiModelProperty(required = true,value="资产数量" , notes = "资产数量")
	private Integer assetNumber;
	
	/**
	 * 剩余数量：剩余数量
	*/
	@ApiModelProperty(required = false,value="剩余数量" , notes = "剩余数量")
	private Integer remainNumber;
	
	/**
	 * 采购日期：采购日期
	*/
	@ApiModelProperty(required = false,value="采购日期" , notes = "采购日期")
	private Date purchaseDate;
	
	/**
	 * 资产RFID：资产RFID
	*/
	@ApiModelProperty(required = false,value="资产RFID" , notes = "资产RFID")
	private String rfid;
	
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
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
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
	 * 财务信息：财务信息
	*/
	@ApiModelProperty(required = false,value="财务信息" , notes = "财务信息")
	private AssetExtFinancial assetFinancial;
	
	/**
	 * 维保信息：维保信息
	*/
	@ApiModelProperty(required = false,value="维保信息" , notes = "维保信息")
	private AssetExtFinancial assetMaintainer;
	
	/**
	 * 设备信息：设备信息
	*/
	@ApiModelProperty(required = false,value="设备信息" , notes = "设备信息")
	private AssetExtEquipment assetEquipment;
	
	/**
	 * 软件信息：软件信息
	*/
	@ApiModelProperty(required = false,value="软件信息" , notes = "软件信息")
	private AssetExtSoftware assetExtSoftware;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Category category;
	
	/**
	 * 物品档案：物品档案
	*/
	@ApiModelProperty(required = false,value="物品档案" , notes = "物品档案")
	private Goods goods;
	
	/**
	 * 生产厂商：生产厂商
	*/
	@ApiModelProperty(required = false,value="生产厂商" , notes = "生产厂商")
	private Manufacturer manufacturer;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private Warehouse warehouse;
	
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
	public Asset setId(String id) {
		this.id=id;
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
	public Asset setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 分类编码<br>
	 * 分类编码
	 * @return 分类编码
	*/
	public String getCategoryCode() {
		return categoryCode;
	}
	
	/**
	 * 设置 分类编码
	 * @param categoryCode 分类编码
	 * @return 当前对象
	*/
	public Asset setCategoryCode(String categoryCode) {
		this.categoryCode=categoryCode;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusiCode() {
		return busiCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param busiCode 业务编号
	 * @return 当前对象
	*/
	public Asset setBusiCode(String busiCode) {
		this.busiCode=busiCode;
		return this;
	}
	
	/**
	 * 获得 批次编码<br>
	 * 批次编码
	 * @return 批次编码
	*/
	public String getBatchCode() {
		return batchCode;
	}
	
	/**
	 * 设置 批次编码
	 * @param batchCode 批次编码
	 * @return 当前对象
	*/
	public Asset setBatchCode(String batchCode) {
		this.batchCode=batchCode;
		return this;
	}
	
	/**
	 * 获得 资产编号<br>
	 * 资产编号
	 * @return 资产编号
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 资产编号
	 * @param assetCode 资产编号
	 * @return 当前对象
	*/
	public Asset setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 资产状态<br>
	 * 资产状态
	 * @return 资产状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 资产状态
	 * @param status 资产状态
	 * @return 当前对象
	*/
	public Asset setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 是否显示<br>
	 * 是否显示
	 * @return 是否显示
	*/
	public String getDisplay() {
		return display;
	}
	
	/**
	 * 设置 是否显示
	 * @param display 是否显示
	 * @return 当前对象
	*/
	public Asset setDisplay(String display) {
		this.display=display;
		return this;
	}
	
	/**
	 * 获得 是否报废<br>
	 * 是否报废
	 * @return 是否报废
	*/
	public String getScrap() {
		return scrap;
	}
	
	/**
	 * 设置 是否报废
	 * @param scrap 是否报废
	 * @return 当前对象
	*/
	public Asset setScrap(String scrap) {
		this.scrap=scrap;
		return this;
	}
	
	/**
	 * 获得 标准物品档案<br>
	 * 标准物品档案
	 * @return 标准物品档案
	*/
	public String getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置 标准物品档案
	 * @param goodsId 标准物品档案
	 * @return 当前对象
	*/
	public Asset setGoodsId(String goodsId) {
		this.goodsId=goodsId;
		return this;
	}
	
	/**
	 * 获得 标准型号资产名称<br>
	 * 标准型号资产名称
	 * @return 标准型号资产名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 标准型号资产名称
	 * @param name 标准型号资产名称
	 * @return 当前对象
	*/
	public Asset setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 标准型号厂商<br>
	 * 标准型号厂商
	 * @return 标准型号厂商
	*/
	public String getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * 设置 标准型号厂商
	 * @param manufacturerId 标准型号厂商
	 * @return 当前对象
	*/
	public Asset setManufacturerId(String manufacturerId) {
		this.manufacturerId=manufacturerId;
		return this;
	}
	
	/**
	 * 获得 标准型号规格型号<br>
	 * 标准型号规格型号
	 * @return 标准型号规格型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 标准型号规格型号
	 * @param model 标准型号规格型号
	 * @return 当前对象
	*/
	public Asset setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 获得 标准型号物品图片<br>
	 * 标准型号物品图片
	 * @return 标准型号物品图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 标准型号物品图片
	 * @param pictureId 标准型号物品图片
	 * @return 当前对象
	*/
	public Asset setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 标准型号计量单位<br>
	 * 标准型号计量单位
	 * @return 标准型号计量单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 标准型号计量单位
	 * @param unit 标准型号计量单位
	 * @return 当前对象
	*/
	public Asset setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 序列号<br>
	 * 序列号
	 * @return 序列号
	*/
	public String getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * 设置 序列号
	 * @param serialNumber 序列号
	 * @return 当前对象
	*/
	public Asset setSerialNumber(String serialNumber) {
		this.serialNumber=serialNumber;
		return this;
	}
	
	/**
	 * 获得 所属组织<br>
	 * 所属组织
	 * @return 所属组织
	*/
	public String getManagementOrganizationId() {
		return managementOrganizationId;
	}
	
	/**
	 * 设置 所属组织
	 * @param managementOrganizationId 所属组织
	 * @return 当前对象
	*/
	public Asset setManagementOrganizationId(String managementOrganizationId) {
		this.managementOrganizationId=managementOrganizationId;
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 管理人员
	 * @param managerId 管理人员
	 * @return 当前对象
	*/
	public Asset setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 使用组织<br>
	 * 使用组织
	 * @return 使用组织
	*/
	public String getUserOrganizationId() {
		return userOrganizationId;
	}
	
	/**
	 * 设置 使用组织
	 * @param userOrganizationId 使用组织
	 * @return 当前对象
	*/
	public Asset setUserOrganizationId(String userOrganizationId) {
		this.userOrganizationId=userOrganizationId;
		return this;
	}
	
	/**
	 * 获得 使用人员<br>
	 * 使用人员
	 * @return 使用人员
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 使用人员
	 * @param userId 使用人员
	 * @return 当前对象
	*/
	public Asset setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 存放位置
	 * @param positionId 存放位置
	 * @return 当前对象
	*/
	public Asset setPositionId(String positionId) {
		this.positionId=positionId;
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
	public Asset setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
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
	public Asset setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
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
	public Asset setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 资产数量<br>
	 * 资产数量
	 * @return 资产数量
	*/
	public Integer getAssetNumber() {
		return assetNumber;
	}
	
	/**
	 * 设置 资产数量
	 * @param assetNumber 资产数量
	 * @return 当前对象
	*/
	public Asset setAssetNumber(Integer assetNumber) {
		this.assetNumber=assetNumber;
		return this;
	}
	
	/**
	 * 获得 剩余数量<br>
	 * 剩余数量
	 * @return 剩余数量
	*/
	public Integer getRemainNumber() {
		return remainNumber;
	}
	
	/**
	 * 设置 剩余数量
	 * @param remainNumber 剩余数量
	 * @return 当前对象
	*/
	public Asset setRemainNumber(Integer remainNumber) {
		this.remainNumber=remainNumber;
		return this;
	}
	
	/**
	 * 获得 采购日期<br>
	 * 采购日期
	 * @return 采购日期
	*/
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	/**
	 * 设置 采购日期
	 * @param purchaseDate 采购日期
	 * @return 当前对象
	*/
	public Asset setPurchaseDate(Date purchaseDate) {
		this.purchaseDate=purchaseDate;
		return this;
	}
	
	/**
	 * 获得 资产RFID<br>
	 * 资产RFID
	 * @return 资产RFID
	*/
	public String getRfid() {
		return rfid;
	}
	
	/**
	 * 设置 资产RFID
	 * @param rfid 资产RFID
	 * @return 当前对象
	*/
	public Asset setRfid(String rfid) {
		this.rfid=rfid;
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
	public Asset setAttach(String attach) {
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
	public Asset setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public Asset setLabel(String label) {
		this.label=label;
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
	public Asset setCreateBy(String createBy) {
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
	public Asset setCreateTime(Date createTime) {
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
	public Asset setUpdateBy(String updateBy) {
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
	public Asset setUpdateTime(Date updateTime) {
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
	public Asset setDeleted(Integer deleted) {
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
	public Asset setDeleteBy(String deleteBy) {
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
	public Asset setDeleteTime(Date deleteTime) {
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
	public Asset setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 财务信息<br>
	 * 财务信息
	 * @return 财务信息
	*/
	public AssetExtFinancial getAssetFinancial() {
		return assetFinancial;
	}
	
	/**
	 * 设置 财务信息
	 * @param assetFinancial 财务信息
	 * @return 当前对象
	*/
	public Asset setAssetFinancial(AssetExtFinancial assetFinancial) {
		this.assetFinancial=assetFinancial;
		return this;
	}
	
	/**
	 * 获得 维保信息<br>
	 * 维保信息
	 * @return 维保信息
	*/
	public AssetExtFinancial getAssetMaintainer() {
		return assetMaintainer;
	}
	
	/**
	 * 设置 维保信息
	 * @param assetMaintainer 维保信息
	 * @return 当前对象
	*/
	public Asset setAssetMaintainer(AssetExtFinancial assetMaintainer) {
		this.assetMaintainer=assetMaintainer;
		return this;
	}
	
	/**
	 * 获得 设备信息<br>
	 * 设备信息
	 * @return 设备信息
	*/
	public AssetExtEquipment getAssetEquipment() {
		return assetEquipment;
	}
	
	/**
	 * 设置 设备信息
	 * @param assetEquipment 设备信息
	 * @return 当前对象
	*/
	public Asset setAssetEquipment(AssetExtEquipment assetEquipment) {
		this.assetEquipment=assetEquipment;
		return this;
	}
	
	/**
	 * 获得 软件信息<br>
	 * 软件信息
	 * @return 软件信息
	*/
	public AssetExtSoftware getAssetExtSoftware() {
		return assetExtSoftware;
	}
	
	/**
	 * 设置 软件信息
	 * @param assetExtSoftware 软件信息
	 * @return 当前对象
	*/
	public Asset setAssetExtSoftware(AssetExtSoftware assetExtSoftware) {
		this.assetExtSoftware=assetExtSoftware;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Category getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public Asset setCategory(Category category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 物品档案<br>
	 * 物品档案
	 * @return 物品档案
	*/
	public Goods getGoods() {
		return goods;
	}
	
	/**
	 * 设置 物品档案
	 * @param goods 物品档案
	 * @return 当前对象
	*/
	public Asset setGoods(Goods goods) {
		this.goods=goods;
		return this;
	}
	
	/**
	 * 获得 生产厂商<br>
	 * 生产厂商
	 * @return 生产厂商
	*/
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * 设置 生产厂商
	 * @param manufacturer 生产厂商
	 * @return 当前对象
	*/
	public Asset setManufacturer(Manufacturer manufacturer) {
		this.manufacturer=manufacturer;
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
	public Asset setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Asset , 转换好的 Asset 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Asset , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Asset
	 * @param assetMap 包含实体信息的 Map 对象
	 * @return Asset , 转换好的的 Asset 对象
	*/
	@Transient
	public static Asset createFrom(Map<String,Object> assetMap) {
		if(assetMap==null) return null;
		Asset po = EntityContext.create(Asset.class, assetMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Asset
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Asset , 转换好的的 Asset 对象
	*/
	@Transient
	public static Asset createFrom(Object pojo) {
		if(pojo==null) return null;
		Asset po = EntityContext.create(Asset.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Asset，等同于 new
	 * @return Asset 对象
	*/
	@Transient
	public static Asset create() {
		return EntityContext.create(Asset.class);
	}
}