package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import java.util.List;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.HashMap;
import java.util.ArrayList;
import javax.persistence.Transient;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 资产
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 06:05:59
 * @sign 032BE1C870412AFF2705402BB7633285
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
	 * 批次编码：批次编码
	*/
	@ApiModelProperty(required = false,value="批次编码" , notes = "批次编码")
	private String batchCode;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属")
	private String ownerCode;
	
	/**
	 * 资产编号：资产编号
	*/
	@ApiModelProperty(required = false,value="资产编号" , notes = "资产编号")
	private String assetCode;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = false,value="资产状态" , notes = "资产状态")
	private String assetStatus;
	
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
	@ApiModelProperty(required = false,value="标准型号资产名称" , notes = "标准型号资产名称")
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
	 * 使用期限：使用期限
	*/
	@ApiModelProperty(required = false,value="使用期限" , notes = "使用期限")
	private BigDecimal serviceLife;
	
	/**
	 * 安全等级：安全等级
	*/
	@ApiModelProperty(required = false,value="安全等级" , notes = "安全等级")
	private String safetyLevelCode;
	
	/**
	 * 序列号：序列号
	*/
	@ApiModelProperty(required = false,value="序列号" , notes = "序列号")
	private String serialNumber;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private String managerId;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private String useOrganizationId;
	
	/**
	 * 使用人员：使用人员
	*/
	@ApiModelProperty(required = false,value="使用人员" , notes = "使用人员")
	private String useUserId;
	
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
	@ApiModelProperty(required = false,value="资产数量" , notes = "资产数量")
	private Integer assetNumber;
	
	/**
	 * 剩余数量：剩余数量
	*/
	@ApiModelProperty(required = true,value="剩余数量" , notes = "剩余数量")
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
	 * 资产备注：资产备注
	*/
	@ApiModelProperty(required = false,value="资产备注" , notes = "资产备注")
	private String assetNotes;
	
	/**
	 * 维保厂商：维保厂商
	*/
	@ApiModelProperty(required = false,value="维保厂商" , notes = "维保厂商")
	private String maintainerId;
	
	/**
	 * 维保厂商：维保厂商
	*/
	@ApiModelProperty(required = false,value="维保厂商" , notes = "维保厂商")
	private String maintainerName;
	
	/**
	 * 维保状态：维保状态
	*/
	@ApiModelProperty(required = false,value="维保状态" , notes = "维保状态")
	private String maintenanceStatus;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contacts;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInformation;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String director;
	
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
	 * 维保备注：维保备注
	*/
	@ApiModelProperty(required = false,value="维保备注" , notes = "维保备注")
	private String maintenanceNotes;
	
	/**
	 * 财务分类：财务分类
	*/
	@ApiModelProperty(required = false,value="财务分类" , notes = "财务分类")
	private String financialCategoryId;
	
	/**
	 * 财务编号：财务编号
	*/
	@ApiModelProperty(required = false,value="财务编号" , notes = "财务编号")
	private String financialCode;
	
	/**
	 * 资产供应商：资产供应商
	*/
	@ApiModelProperty(required = false,value="资产供应商" , notes = "资产供应商")
	private String supplierId;
	
	/**
	 * 税额：税额
	*/
	@ApiModelProperty(required = false,value="税额" , notes = "税额")
	private BigDecimal taxamountRate;
	
	/**
	 * 含税金额：含税金额
	*/
	@ApiModelProperty(required = false,value="含税金额" , notes = "含税金额")
	private BigDecimal taxamountPrice;
	
	/**
	 * 资产原值(单价)：资产原值(单价)
	*/
	@ApiModelProperty(required = false,value="资产原值(单价)" , notes = "资产原值(单价)")
	private BigDecimal originalUnitPrice;
	
	/**
	 * 累计折旧：累计折旧
	*/
	@ApiModelProperty(required = false,value="累计折旧" , notes = "累计折旧")
	private BigDecimal accumulatedDepreciation;
	
	/**
	 * 残值率：残值率
	*/
	@ApiModelProperty(required = false,value="残值率" , notes = "残值率")
	private BigDecimal residualsRate;
	
	/**
	 * 资产净值：资产净值
	*/
	@ApiModelProperty(required = false,value="资产净值" , notes = "资产净值")
	private BigDecimal navPrice;
	
	/**
	 * 采购单价：采购单价
	*/
	@ApiModelProperty(required = false,value="采购单价" , notes = "采购单价")
	private BigDecimal purchaseUnitPrice;
	
	/**
	 * 入账时间：入账时间
	*/
	@ApiModelProperty(required = false,value="入账时间" , notes = "入账时间")
	private Date entryTime;
	
	/**
	 * 财务备注：财务备注
	*/
	@ApiModelProperty(required = false,value="财务备注" , notes = "财务备注")
	private String financialNotes;
	
	/**
	 * 设备编号：设备编号
	*/
	@ApiModelProperty(required = false,value="设备编号" , notes = "设备编号")
	private String equipmentCode;
	
	/**
	 * 设备状态：设备状态
	*/
	@ApiModelProperty(required = false,value="设备状态" , notes = "设备状态")
	private String equipmentStatus;
	
	/**
	 * 设备IP：设备IP
	*/
	@ApiModelProperty(required = false,value="设备IP" , notes = "设备IP")
	private String equipmentIp;
	
	/**
	 * 管理IP：管理IP
	*/
	@ApiModelProperty(required = false,value="管理IP" , notes = "管理IP")
	private String manageIp;
	
	/**
	 * 设备CPU：设备CPU
	*/
	@ApiModelProperty(required = false,value="设备CPU" , notes = "设备CPU")
	private String equipmentCpu;
	
	/**
	 * 设备内存：设备内存
	*/
	@ApiModelProperty(required = false,value="设备内存" , notes = "设备内存")
	private String equipmentMemory;
	
	/**
	 * 设备标签：设备标签
	*/
	@ApiModelProperty(required = false,value="设备标签" , notes = "设备标签")
	private String equipmentLabel;
	
	/**
	 * 设备配置：设备配置
	*/
	@ApiModelProperty(required = false,value="设备配置" , notes = "设备配置")
	private String equipmentConf;
	
	/**
	 * 设备运行环境：设备运行环境
	*/
	@ApiModelProperty(required = false,value="设备运行环境" , notes = "设备运行环境")
	private String equipmentEnvironmentCode;
	
	/**
	 * 设备机柜：设备机柜
	*/
	@ApiModelProperty(required = false,value="设备机柜" , notes = "设备机柜")
	private String rackId;
	
	/**
	 * 设备机柜上位置：设备机柜上位置
	*/
	@ApiModelProperty(required = false,value="设备机柜上位置" , notes = "设备机柜上位置")
	private Integer rackUpNumber;
	
	/**
	 * 设备机柜下位置：设备机柜下位置
	*/
	@ApiModelProperty(required = false,value="设备机柜下位置" , notes = "设备机柜下位置")
	private Integer rackDownNumber;
	
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
	 * 扩展数据：扩展数据
	*/
	@ApiModelProperty(required = false,value="扩展数据" , notes = "扩展数据")
	private AssetExtData extData;
	
	/**
	 * PCM数据：PCM数据
	*/
	@ApiModelProperty(required = false,value="PCM数据" , notes = "PCM数据")
	private Map<String,Object> pcmData;
	
	/**
	 * 自定义数据属性字段：自定义数据属性字段
	*/
	@ApiModelProperty(required = false,value="自定义数据属性字段" , notes = "自定义数据属性字段")
	private List<CatalogAttribute> catalogAttribute;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private Position position;
	
	/**
	 * 财务分类：财务分类
	*/
	@ApiModelProperty(required = false,value="财务分类" , notes = "财务分类")
	private CategoryFinance categoryFinance;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Catalog category;
	
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
	 * 使用人员：使用人员
	*/
	@ApiModelProperty(required = false,value="使用人员" , notes = "使用人员")
	private Employee useUser;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private Employee manager;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
	/**
	 * 维保商：维保商
	*/
	@ApiModelProperty(required = false,value="维保商" , notes = "维保商")
	private Maintainer maintnainer;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Organization ownerCompany;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private DictItem source;
	
	/**
	 * 设备运行环境：设备运行环境
	*/
	@ApiModelProperty(required = false,value="设备运行环境" , notes = "设备运行环境")
	private DictItem equipmentEnvironment;
	
	/**
	 * 安全等级：安全等级
	*/
	@ApiModelProperty(required = false,value="安全等级" , notes = "安全等级")
	private DictItem safetyLevel;
	
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
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public Asset setBusinessCode(String businessCode) {
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
	public Asset setProcId(String procId) {
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
	public Asset setStatus(String status) {
		this.status=status;
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
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public Asset setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
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
	public String getAssetStatus() {
		return assetStatus;
	}
	
	/**
	 * 设置 资产状态
	 * @param assetStatus 资产状态
	 * @return 当前对象
	*/
	public Asset setAssetStatus(String assetStatus) {
		this.assetStatus=assetStatus;
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
	 * 获得 使用期限<br>
	 * 使用期限
	 * @return 使用期限
	*/
	public BigDecimal getServiceLife() {
		return serviceLife;
	}
	
	/**
	 * 设置 使用期限
	 * @param serviceLife 使用期限
	 * @return 当前对象
	*/
	public Asset setServiceLife(BigDecimal serviceLife) {
		this.serviceLife=serviceLife;
		return this;
	}
	
	/**
	 * 获得 安全等级<br>
	 * 安全等级
	 * @return 安全等级
	*/
	public String getSafetyLevelCode() {
		return safetyLevelCode;
	}
	
	/**
	 * 设置 安全等级
	 * @param safetyLevelCode 安全等级
	 * @return 当前对象
	*/
	public Asset setSafetyLevelCode(String safetyLevelCode) {
		this.safetyLevelCode=safetyLevelCode;
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
	public Asset setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
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
	public Asset setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 使用人员<br>
	 * 使用人员
	 * @return 使用人员
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 使用人员
	 * @param useUserId 使用人员
	 * @return 当前对象
	*/
	public Asset setUseUserId(String useUserId) {
		this.useUserId=useUserId;
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
	 * 获得 资产备注<br>
	 * 资产备注
	 * @return 资产备注
	*/
	public String getAssetNotes() {
		return assetNotes;
	}
	
	/**
	 * 设置 资产备注
	 * @param assetNotes 资产备注
	 * @return 当前对象
	*/
	public Asset setAssetNotes(String assetNotes) {
		this.assetNotes=assetNotes;
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
	public Asset setMaintainerId(String maintainerId) {
		this.maintainerId=maintainerId;
		return this;
	}
	
	/**
	 * 获得 维保厂商<br>
	 * 维保厂商
	 * @return 维保厂商
	*/
	public String getMaintainerName() {
		return maintainerName;
	}
	
	/**
	 * 设置 维保厂商
	 * @param maintainerName 维保厂商
	 * @return 当前对象
	*/
	public Asset setMaintainerName(String maintainerName) {
		this.maintainerName=maintainerName;
		return this;
	}
	
	/**
	 * 获得 维保状态<br>
	 * 维保状态
	 * @return 维保状态
	*/
	public String getMaintenanceStatus() {
		return maintenanceStatus;
	}
	
	/**
	 * 设置 维保状态
	 * @param maintenanceStatus 维保状态
	 * @return 当前对象
	*/
	public Asset setMaintenanceStatus(String maintenanceStatus) {
		this.maintenanceStatus=maintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 联系人<br>
	 * 联系人
	 * @return 联系人
	*/
	public String getContacts() {
		return contacts;
	}
	
	/**
	 * 设置 联系人
	 * @param contacts 联系人
	 * @return 当前对象
	*/
	public Asset setContacts(String contacts) {
		this.contacts=contacts;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
	 * 设置 联系方式
	 * @param contactInformation 联系方式
	 * @return 当前对象
	*/
	public Asset setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getDirector() {
		return director;
	}
	
	/**
	 * 设置 负责人
	 * @param director 负责人
	 * @return 当前对象
	*/
	public Asset setDirector(String director) {
		this.director=director;
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
	public Asset setMaintenanceStartDate(Date maintenanceStartDate) {
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
	public Asset setMaintenanceEndDate(Date maintenanceEndDate) {
		this.maintenanceEndDate=maintenanceEndDate;
		return this;
	}
	
	/**
	 * 获得 维保备注<br>
	 * 维保备注
	 * @return 维保备注
	*/
	public String getMaintenanceNotes() {
		return maintenanceNotes;
	}
	
	/**
	 * 设置 维保备注
	 * @param maintenanceNotes 维保备注
	 * @return 当前对象
	*/
	public Asset setMaintenanceNotes(String maintenanceNotes) {
		this.maintenanceNotes=maintenanceNotes;
		return this;
	}
	
	/**
	 * 获得 财务分类<br>
	 * 财务分类
	 * @return 财务分类
	*/
	public String getFinancialCategoryId() {
		return financialCategoryId;
	}
	
	/**
	 * 设置 财务分类
	 * @param financialCategoryId 财务分类
	 * @return 当前对象
	*/
	public Asset setFinancialCategoryId(String financialCategoryId) {
		this.financialCategoryId=financialCategoryId;
		return this;
	}
	
	/**
	 * 获得 财务编号<br>
	 * 财务编号
	 * @return 财务编号
	*/
	public String getFinancialCode() {
		return financialCode;
	}
	
	/**
	 * 设置 财务编号
	 * @param financialCode 财务编号
	 * @return 当前对象
	*/
	public Asset setFinancialCode(String financialCode) {
		this.financialCode=financialCode;
		return this;
	}
	
	/**
	 * 获得 资产供应商<br>
	 * 资产供应商
	 * @return 资产供应商
	*/
	public String getSupplierId() {
		return supplierId;
	}
	
	/**
	 * 设置 资产供应商
	 * @param supplierId 资产供应商
	 * @return 当前对象
	*/
	public Asset setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 税额<br>
	 * 税额
	 * @return 税额
	*/
	public BigDecimal getTaxamountRate() {
		return taxamountRate;
	}
	
	/**
	 * 设置 税额
	 * @param taxamountRate 税额
	 * @return 当前对象
	*/
	public Asset setTaxamountRate(BigDecimal taxamountRate) {
		this.taxamountRate=taxamountRate;
		return this;
	}
	
	/**
	 * 获得 含税金额<br>
	 * 含税金额
	 * @return 含税金额
	*/
	public BigDecimal getTaxamountPrice() {
		return taxamountPrice;
	}
	
	/**
	 * 设置 含税金额
	 * @param taxamountPrice 含税金额
	 * @return 当前对象
	*/
	public Asset setTaxamountPrice(BigDecimal taxamountPrice) {
		this.taxamountPrice=taxamountPrice;
		return this;
	}
	
	/**
	 * 获得 资产原值(单价)<br>
	 * 资产原值(单价)
	 * @return 资产原值(单价)
	*/
	public BigDecimal getOriginalUnitPrice() {
		return originalUnitPrice;
	}
	
	/**
	 * 设置 资产原值(单价)
	 * @param originalUnitPrice 资产原值(单价)
	 * @return 当前对象
	*/
	public Asset setOriginalUnitPrice(BigDecimal originalUnitPrice) {
		this.originalUnitPrice=originalUnitPrice;
		return this;
	}
	
	/**
	 * 获得 累计折旧<br>
	 * 累计折旧
	 * @return 累计折旧
	*/
	public BigDecimal getAccumulatedDepreciation() {
		return accumulatedDepreciation;
	}
	
	/**
	 * 设置 累计折旧
	 * @param accumulatedDepreciation 累计折旧
	 * @return 当前对象
	*/
	public Asset setAccumulatedDepreciation(BigDecimal accumulatedDepreciation) {
		this.accumulatedDepreciation=accumulatedDepreciation;
		return this;
	}
	
	/**
	 * 获得 残值率<br>
	 * 残值率
	 * @return 残值率
	*/
	public BigDecimal getResidualsRate() {
		return residualsRate;
	}
	
	/**
	 * 设置 残值率
	 * @param residualsRate 残值率
	 * @return 当前对象
	*/
	public Asset setResidualsRate(BigDecimal residualsRate) {
		this.residualsRate=residualsRate;
		return this;
	}
	
	/**
	 * 获得 资产净值<br>
	 * 资产净值
	 * @return 资产净值
	*/
	public BigDecimal getNavPrice() {
		return navPrice;
	}
	
	/**
	 * 设置 资产净值
	 * @param navPrice 资产净值
	 * @return 当前对象
	*/
	public Asset setNavPrice(BigDecimal navPrice) {
		this.navPrice=navPrice;
		return this;
	}
	
	/**
	 * 获得 采购单价<br>
	 * 采购单价
	 * @return 采购单价
	*/
	public BigDecimal getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}
	
	/**
	 * 设置 采购单价
	 * @param purchaseUnitPrice 采购单价
	 * @return 当前对象
	*/
	public Asset setPurchaseUnitPrice(BigDecimal purchaseUnitPrice) {
		this.purchaseUnitPrice=purchaseUnitPrice;
		return this;
	}
	
	/**
	 * 获得 入账时间<br>
	 * 入账时间
	 * @return 入账时间
	*/
	public Date getEntryTime() {
		return entryTime;
	}
	
	/**
	 * 设置 入账时间
	 * @param entryTime 入账时间
	 * @return 当前对象
	*/
	public Asset setEntryTime(Date entryTime) {
		this.entryTime=entryTime;
		return this;
	}
	
	/**
	 * 获得 财务备注<br>
	 * 财务备注
	 * @return 财务备注
	*/
	public String getFinancialNotes() {
		return financialNotes;
	}
	
	/**
	 * 设置 财务备注
	 * @param financialNotes 财务备注
	 * @return 当前对象
	*/
	public Asset setFinancialNotes(String financialNotes) {
		this.financialNotes=financialNotes;
		return this;
	}
	
	/**
	 * 获得 设备编号<br>
	 * 设备编号
	 * @return 设备编号
	*/
	public String getEquipmentCode() {
		return equipmentCode;
	}
	
	/**
	 * 设置 设备编号
	 * @param equipmentCode 设备编号
	 * @return 当前对象
	*/
	public Asset setEquipmentCode(String equipmentCode) {
		this.equipmentCode=equipmentCode;
		return this;
	}
	
	/**
	 * 获得 设备状态<br>
	 * 设备状态
	 * @return 设备状态
	*/
	public String getEquipmentStatus() {
		return equipmentStatus;
	}
	
	/**
	 * 设置 设备状态
	 * @param equipmentStatus 设备状态
	 * @return 当前对象
	*/
	public Asset setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus=equipmentStatus;
		return this;
	}
	
	/**
	 * 获得 设备IP<br>
	 * 设备IP
	 * @return 设备IP
	*/
	public String getEquipmentIp() {
		return equipmentIp;
	}
	
	/**
	 * 设置 设备IP
	 * @param equipmentIp 设备IP
	 * @return 当前对象
	*/
	public Asset setEquipmentIp(String equipmentIp) {
		this.equipmentIp=equipmentIp;
		return this;
	}
	
	/**
	 * 获得 管理IP<br>
	 * 管理IP
	 * @return 管理IP
	*/
	public String getManageIp() {
		return manageIp;
	}
	
	/**
	 * 设置 管理IP
	 * @param manageIp 管理IP
	 * @return 当前对象
	*/
	public Asset setManageIp(String manageIp) {
		this.manageIp=manageIp;
		return this;
	}
	
	/**
	 * 获得 设备CPU<br>
	 * 设备CPU
	 * @return 设备CPU
	*/
	public String getEquipmentCpu() {
		return equipmentCpu;
	}
	
	/**
	 * 设置 设备CPU
	 * @param equipmentCpu 设备CPU
	 * @return 当前对象
	*/
	public Asset setEquipmentCpu(String equipmentCpu) {
		this.equipmentCpu=equipmentCpu;
		return this;
	}
	
	/**
	 * 获得 设备内存<br>
	 * 设备内存
	 * @return 设备内存
	*/
	public String getEquipmentMemory() {
		return equipmentMemory;
	}
	
	/**
	 * 设置 设备内存
	 * @param equipmentMemory 设备内存
	 * @return 当前对象
	*/
	public Asset setEquipmentMemory(String equipmentMemory) {
		this.equipmentMemory=equipmentMemory;
		return this;
	}
	
	/**
	 * 获得 设备标签<br>
	 * 设备标签
	 * @return 设备标签
	*/
	public String getEquipmentLabel() {
		return equipmentLabel;
	}
	
	/**
	 * 设置 设备标签
	 * @param equipmentLabel 设备标签
	 * @return 当前对象
	*/
	public Asset setEquipmentLabel(String equipmentLabel) {
		this.equipmentLabel=equipmentLabel;
		return this;
	}
	
	/**
	 * 获得 设备配置<br>
	 * 设备配置
	 * @return 设备配置
	*/
	public String getEquipmentConf() {
		return equipmentConf;
	}
	
	/**
	 * 设置 设备配置
	 * @param equipmentConf 设备配置
	 * @return 当前对象
	*/
	public Asset setEquipmentConf(String equipmentConf) {
		this.equipmentConf=equipmentConf;
		return this;
	}
	
	/**
	 * 获得 设备运行环境<br>
	 * 设备运行环境
	 * @return 设备运行环境
	*/
	public String getEquipmentEnvironmentCode() {
		return equipmentEnvironmentCode;
	}
	
	/**
	 * 设置 设备运行环境
	 * @param equipmentEnvironmentCode 设备运行环境
	 * @return 当前对象
	*/
	public Asset setEquipmentEnvironmentCode(String equipmentEnvironmentCode) {
		this.equipmentEnvironmentCode=equipmentEnvironmentCode;
		return this;
	}
	
	/**
	 * 获得 设备机柜<br>
	 * 设备机柜
	 * @return 设备机柜
	*/
	public String getRackId() {
		return rackId;
	}
	
	/**
	 * 设置 设备机柜
	 * @param rackId 设备机柜
	 * @return 当前对象
	*/
	public Asset setRackId(String rackId) {
		this.rackId=rackId;
		return this;
	}
	
	/**
	 * 获得 设备机柜上位置<br>
	 * 设备机柜上位置
	 * @return 设备机柜上位置
	*/
	public Integer getRackUpNumber() {
		return rackUpNumber;
	}
	
	/**
	 * 设置 设备机柜上位置
	 * @param rackUpNumber 设备机柜上位置
	 * @return 当前对象
	*/
	public Asset setRackUpNumber(Integer rackUpNumber) {
		this.rackUpNumber=rackUpNumber;
		return this;
	}
	
	/**
	 * 获得 设备机柜下位置<br>
	 * 设备机柜下位置
	 * @return 设备机柜下位置
	*/
	public Integer getRackDownNumber() {
		return rackDownNumber;
	}
	
	/**
	 * 设置 设备机柜下位置
	 * @param rackDownNumber 设备机柜下位置
	 * @return 当前对象
	*/
	public Asset setRackDownNumber(Integer rackDownNumber) {
		this.rackDownNumber=rackDownNumber;
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
	public Asset setTenantId(String tenantId) {
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
	public Asset setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 扩展数据<br>
	 * 扩展数据
	 * @return 扩展数据
	*/
	public AssetExtData getExtData() {
		return extData;
	}
	
	/**
	 * 设置 扩展数据
	 * @param extData 扩展数据
	 * @return 当前对象
	*/
	public Asset setExtData(AssetExtData extData) {
		this.extData=extData;
		return this;
	}
	
	/**
	 * 获得 PCM数据<br>
	 * PCM数据
	 * @return PCM数据
	*/
	public Map<String,Object> getPcmData() {
		return pcmData;
	}
	
	/**
	 * 设置 PCM数据
	 * @param pcmData PCM数据
	 * @return 当前对象
	*/
	public Asset setPcmData(Map<String,Object> pcmData) {
		this.pcmData=pcmData;
		return this;
	}
	
	/**
	 * 添加 PCM数据
	 * @param key 键
	 * @param pn PCM数据
	 * @return 当前对象
	*/
	public Asset putPcmData(String key,Object pcmData) {
		if(this.pcmData==null) this.pcmData=new HashMap<>();
		this.pcmData.put(key ,pcmData);
		return this;
	}
	
	/**
	 * 获得 自定义数据属性字段<br>
	 * 自定义数据属性字段
	 * @return 自定义数据属性字段
	*/
	public List<CatalogAttribute> getCatalogAttribute() {
		return catalogAttribute;
	}
	
	/**
	 * 设置 自定义数据属性字段
	 * @param catalogAttribute 自定义数据属性字段
	 * @return 当前对象
	*/
	public Asset setCatalogAttribute(List<CatalogAttribute> catalogAttribute) {
		this.catalogAttribute=catalogAttribute;
		return this;
	}
	
	/**
	 * 添加 自定义数据属性字段
	 * @param entity 自定义数据属性字段
	 * @return 当前对象
	*/
	public Asset addCatalogAttribute(CatalogAttribute entity) {
		if(this.catalogAttribute==null) catalogAttribute=new ArrayList<>();
		this.catalogAttribute.add(entity);
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public Asset setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 财务分类<br>
	 * 财务分类
	 * @return 财务分类
	*/
	public CategoryFinance getCategoryFinance() {
		return categoryFinance;
	}
	
	/**
	 * 设置 财务分类
	 * @param categoryFinance 财务分类
	 * @return 当前对象
	*/
	public Asset setCategoryFinance(CategoryFinance categoryFinance) {
		this.categoryFinance=categoryFinance;
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
	public Asset setCategory(Catalog category) {
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
	 * 获得 使用人员<br>
	 * 使用人员
	 * @return 使用人员
	*/
	public Employee getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 使用人员
	 * @param useUser 使用人员
	 * @return 当前对象
	*/
	public Asset setUseUser(Employee useUser) {
		this.useUser=useUser;
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人员
	 * @param manager 管理人员
	 * @return 当前对象
	*/
	public Asset setManager(Employee manager) {
		this.manager=manager;
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
	public Asset setOriginator(Employee originator) {
		this.originator=originator;
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
	public Asset setSupplier(Supplier supplier) {
		this.supplier=supplier;
		return this;
	}
	
	/**
	 * 获得 维保商<br>
	 * 维保商
	 * @return 维保商
	*/
	public Maintainer getMaintnainer() {
		return maintnainer;
	}
	
	/**
	 * 设置 维保商
	 * @param maintnainer 维保商
	 * @return 当前对象
	*/
	public Asset setMaintnainer(Maintainer maintnainer) {
		this.maintnainer=maintnainer;
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
	public Asset setOwnerCompany(Organization ownerCompany) {
		this.ownerCompany=ownerCompany;
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
	public Asset setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
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
	public Asset setSource(DictItem source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 设备运行环境<br>
	 * 设备运行环境
	 * @return 设备运行环境
	*/
	public DictItem getEquipmentEnvironment() {
		return equipmentEnvironment;
	}
	
	/**
	 * 设置 设备运行环境
	 * @param equipmentEnvironment 设备运行环境
	 * @return 当前对象
	*/
	public Asset setEquipmentEnvironment(DictItem equipmentEnvironment) {
		this.equipmentEnvironment=equipmentEnvironment;
		return this;
	}
	
	/**
	 * 获得 安全等级<br>
	 * 安全等级
	 * @return 安全等级
	*/
	public DictItem getSafetyLevel() {
		return safetyLevel;
	}
	
	/**
	 * 设置 安全等级
	 * @param safetyLevel 安全等级
	 * @return 当前对象
	*/
	public Asset setSafetyLevel(DictItem safetyLevel) {
		this.safetyLevel=safetyLevel;
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