package com.dt.platform.domain.vehicle;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.VehicleTables.VEHICLE_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 车辆信息
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-03 17:20:51
 * @sign 3C54D3B4D2D6E97220F0C081308626A7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "vehicle_info")
public class Info extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =VEHICLE_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String vehicleStatus;
	
	/**
	 * 车辆类型：车辆类型
	*/
	@ApiModelProperty(required = false,value="车辆类型" , notes = "车辆类型")
	private String type;
	
	/**
	 * 车牌号：车牌号
	*/
	@ApiModelProperty(required = false,value="车牌号" , notes = "车牌号")
	private String code;
	
	/**
	 * 品牌型号：品牌型号
	*/
	@ApiModelProperty(required = false,value="品牌型号" , notes = "品牌型号")
	private String model;
	
	/**
	 * 登记人：登记人
	*/
	@ApiModelProperty(required = false,value="登记人" , notes = "登记人")
	private String registrant;
	
	/**
	 * 所属组织：所属组织
	*/
	@ApiModelProperty(required = false,value="所属组织" , notes = "所属组织")
	private String ownerOrgId;
	
	/**
	 * 使用部门：使用部门
	*/
	@ApiModelProperty(required = false,value="使用部门" , notes = "使用部门")
	private String useOrgId;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private String useUserId;
	
	/**
	 * 颜色：颜色
	*/
	@ApiModelProperty(required = false,value="颜色" , notes = "颜色")
	private String color;
	
	/**
	 * 发动机号：发动机号
	*/
	@ApiModelProperty(required = false,value="发动机号" , notes = "发动机号")
	private String engineNumber;
	
	/**
	 * 车架号：车架号
	*/
	@ApiModelProperty(required = false,value="车架号" , notes = "车架号")
	private String frameNumber;
	
	/**
	 * 行驶证：行驶证
	*/
	@ApiModelProperty(required = false,value="行驶证" , notes = "行驶证")
	private String drivingLicense;
	
	/**
	 * 公里数：公里数
	*/
	@ApiModelProperty(required = false,value="公里数" , notes = "公里数")
	private BigDecimal kilometers;
	
	/**
	 * 抢险(元)：抢险(元)
	*/
	@ApiModelProperty(required = false,value="抢险(元)" , notes = "抢险(元)")
	private BigDecimal rescueMoney;
	
	/**
	 * 商业险(元)：商业险(元)
	*/
	@ApiModelProperty(required = false,value="商业险(元)" , notes = "商业险(元)")
	private BigDecimal commercialInsuranceMoney;
	
	/**
	 * 保险公司：保险公司
	*/
	@ApiModelProperty(required = false,value="保险公司" , notes = "保险公司")
	private String insuranceCompany;
	
	/**
	 * 上牌时间：上牌时间
	*/
	@ApiModelProperty(required = false,value="上牌时间" , notes = "上牌时间")
	private Date licensingTime;
	
	/**
	 * 保险到期：保险到期
	*/
	@ApiModelProperty(required = false,value="保险到期" , notes = "保险到期")
	private Date insuranceExpireDate;
	
	/**
	 * 报废时间：报废时间
	*/
	@ApiModelProperty(required = false,value="报废时间" , notes = "报废时间")
	private Date scrapTime;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private String positionDetail;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictures;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
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
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem vehicleTypeDict;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private DictItem vehicleStatusDict;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private Employee useUser;
	
	/**
	 * 车辆列表：车辆列表
	*/
	@ApiModelProperty(required = false,value="车辆列表" , notes = "车辆列表")
	private String selectIds;
	
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
	public Info setId(String id) {
		this.id=id;
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
	public Info setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	
	/**
	 * 设置 状态
	 * @param vehicleStatus 状态
	 * @return 当前对象
	*/
	public Info setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus=vehicleStatus;
		return this;
	}
	
	/**
	 * 获得 车辆类型<br>
	 * 车辆类型
	 * @return 车辆类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 车辆类型
	 * @param type 车辆类型
	 * @return 当前对象
	*/
	public Info setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 车牌号<br>
	 * 车牌号
	 * @return 车牌号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 车牌号
	 * @param code 车牌号
	 * @return 当前对象
	*/
	public Info setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 品牌型号<br>
	 * 品牌型号
	 * @return 品牌型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 品牌型号
	 * @param model 品牌型号
	 * @return 当前对象
	*/
	public Info setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 获得 登记人<br>
	 * 登记人
	 * @return 登记人
	*/
	public String getRegistrant() {
		return registrant;
	}
	
	/**
	 * 设置 登记人
	 * @param registrant 登记人
	 * @return 当前对象
	*/
	public Info setRegistrant(String registrant) {
		this.registrant=registrant;
		return this;
	}
	
	/**
	 * 获得 所属组织<br>
	 * 所属组织
	 * @return 所属组织
	*/
	public String getOwnerOrgId() {
		return ownerOrgId;
	}
	
	/**
	 * 设置 所属组织
	 * @param ownerOrgId 所属组织
	 * @return 当前对象
	*/
	public Info setOwnerOrgId(String ownerOrgId) {
		this.ownerOrgId=ownerOrgId;
		return this;
	}
	
	/**
	 * 获得 使用部门<br>
	 * 使用部门
	 * @return 使用部门
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 使用部门
	 * @param useOrgId 使用部门
	 * @return 当前对象
	*/
	public Info setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 使用人
	 * @param useUserId 使用人
	 * @return 当前对象
	*/
	public Info setUseUserId(String useUserId) {
		this.useUserId=useUserId;
		return this;
	}
	
	/**
	 * 获得 颜色<br>
	 * 颜色
	 * @return 颜色
	*/
	public String getColor() {
		return color;
	}
	
	/**
	 * 设置 颜色
	 * @param color 颜色
	 * @return 当前对象
	*/
	public Info setColor(String color) {
		this.color=color;
		return this;
	}
	
	/**
	 * 获得 发动机号<br>
	 * 发动机号
	 * @return 发动机号
	*/
	public String getEngineNumber() {
		return engineNumber;
	}
	
	/**
	 * 设置 发动机号
	 * @param engineNumber 发动机号
	 * @return 当前对象
	*/
	public Info setEngineNumber(String engineNumber) {
		this.engineNumber=engineNumber;
		return this;
	}
	
	/**
	 * 获得 车架号<br>
	 * 车架号
	 * @return 车架号
	*/
	public String getFrameNumber() {
		return frameNumber;
	}
	
	/**
	 * 设置 车架号
	 * @param frameNumber 车架号
	 * @return 当前对象
	*/
	public Info setFrameNumber(String frameNumber) {
		this.frameNumber=frameNumber;
		return this;
	}
	
	/**
	 * 获得 行驶证<br>
	 * 行驶证
	 * @return 行驶证
	*/
	public String getDrivingLicense() {
		return drivingLicense;
	}
	
	/**
	 * 设置 行驶证
	 * @param drivingLicense 行驶证
	 * @return 当前对象
	*/
	public Info setDrivingLicense(String drivingLicense) {
		this.drivingLicense=drivingLicense;
		return this;
	}
	
	/**
	 * 获得 公里数<br>
	 * 公里数
	 * @return 公里数
	*/
	public BigDecimal getKilometers() {
		return kilometers;
	}
	
	/**
	 * 设置 公里数
	 * @param kilometers 公里数
	 * @return 当前对象
	*/
	public Info setKilometers(BigDecimal kilometers) {
		this.kilometers=kilometers;
		return this;
	}
	
	/**
	 * 获得 抢险(元)<br>
	 * 抢险(元)
	 * @return 抢险(元)
	*/
	public BigDecimal getRescueMoney() {
		return rescueMoney;
	}
	
	/**
	 * 设置 抢险(元)
	 * @param rescueMoney 抢险(元)
	 * @return 当前对象
	*/
	public Info setRescueMoney(BigDecimal rescueMoney) {
		this.rescueMoney=rescueMoney;
		return this;
	}
	
	/**
	 * 获得 商业险(元)<br>
	 * 商业险(元)
	 * @return 商业险(元)
	*/
	public BigDecimal getCommercialInsuranceMoney() {
		return commercialInsuranceMoney;
	}
	
	/**
	 * 设置 商业险(元)
	 * @param commercialInsuranceMoney 商业险(元)
	 * @return 当前对象
	*/
	public Info setCommercialInsuranceMoney(BigDecimal commercialInsuranceMoney) {
		this.commercialInsuranceMoney=commercialInsuranceMoney;
		return this;
	}
	
	/**
	 * 获得 保险公司<br>
	 * 保险公司
	 * @return 保险公司
	*/
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	
	/**
	 * 设置 保险公司
	 * @param insuranceCompany 保险公司
	 * @return 当前对象
	*/
	public Info setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany=insuranceCompany;
		return this;
	}
	
	/**
	 * 获得 上牌时间<br>
	 * 上牌时间
	 * @return 上牌时间
	*/
	public Date getLicensingTime() {
		return licensingTime;
	}
	
	/**
	 * 设置 上牌时间
	 * @param licensingTime 上牌时间
	 * @return 当前对象
	*/
	public Info setLicensingTime(Date licensingTime) {
		this.licensingTime=licensingTime;
		return this;
	}
	
	/**
	 * 获得 保险到期<br>
	 * 保险到期
	 * @return 保险到期
	*/
	public Date getInsuranceExpireDate() {
		return insuranceExpireDate;
	}
	
	/**
	 * 设置 保险到期
	 * @param insuranceExpireDate 保险到期
	 * @return 当前对象
	*/
	public Info setInsuranceExpireDate(Date insuranceExpireDate) {
		this.insuranceExpireDate=insuranceExpireDate;
		return this;
	}
	
	/**
	 * 获得 报废时间<br>
	 * 报废时间
	 * @return 报废时间
	*/
	public Date getScrapTime() {
		return scrapTime;
	}
	
	/**
	 * 设置 报废时间
	 * @param scrapTime 报废时间
	 * @return 当前对象
	*/
	public Info setScrapTime(Date scrapTime) {
		this.scrapTime=scrapTime;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 存放位置
	 * @param positionDetail 存放位置
	 * @return 当前对象
	*/
	public Info setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictures() {
		return pictures;
	}
	
	/**
	 * 设置 图片
	 * @param pictures 图片
	 * @return 当前对象
	*/
	public Info setPictures(String pictures) {
		this.pictures=pictures;
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
	public Info setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public Info setNotes(String notes) {
		this.notes=notes;
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
	public Info setCreateBy(String createBy) {
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
	public Info setCreateTime(Date createTime) {
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
	public Info setUpdateBy(String updateBy) {
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
	public Info setUpdateTime(Date updateTime) {
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
	public Info setDeleted(Integer deleted) {
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
	public Info setDeleteBy(String deleteBy) {
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
	public Info setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public Info setVersion(Integer version) {
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
	public Info setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public Info setOwnerCompany(Organization ownerCompany) {
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
	public Info setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getVehicleTypeDict() {
		return vehicleTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param vehicleTypeDict 类型
	 * @return 当前对象
	*/
	public Info setVehicleTypeDict(DictItem vehicleTypeDict) {
		this.vehicleTypeDict=vehicleTypeDict;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public DictItem getVehicleStatusDict() {
		return vehicleStatusDict;
	}
	
	/**
	 * 设置 状态
	 * @param vehicleStatusDict 状态
	 * @return 当前对象
	*/
	public Info setVehicleStatusDict(DictItem vehicleStatusDict) {
		this.vehicleStatusDict=vehicleStatusDict;
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
	public Info setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public Employee getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 使用人
	 * @param useUser 使用人
	 * @return 当前对象
	*/
	public Info setUseUser(Employee useUser) {
		this.useUser=useUser;
		return this;
	}
	
	/**
	 * 获得 车辆列表<br>
	 * 车辆列表
	 * @return 车辆列表
	*/
	public String getSelectIds() {
		return selectIds;
	}
	
	/**
	 * 设置 车辆列表
	 * @param selectIds 车辆列表
	 * @return 当前对象
	*/
	public Info setSelectIds(String selectIds) {
		this.selectIds=selectIds;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Info , 转换好的 Info 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Info , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Info
	 * @param infoMap 包含实体信息的 Map 对象
	 * @return Info , 转换好的的 Info 对象
	*/
	@Transient
	public static Info createFrom(Map<String,Object> infoMap) {
		if(infoMap==null) return null;
		Info po = EntityContext.create(Info.class, infoMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Info
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Info , 转换好的的 Info 对象
	*/
	@Transient
	public static Info createFrom(Object pojo) {
		if(pojo==null) return null;
		Info po = EntityContext.create(Info.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Info，等同于 new
	 * @return Info 对象
	*/
	@Transient
	public static Info create() {
		return EntityContext.create(Info.class);
	}
}