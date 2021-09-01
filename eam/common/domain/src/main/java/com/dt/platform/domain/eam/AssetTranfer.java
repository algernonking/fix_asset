package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_TRANFER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Person;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-31 15:17:07
 * @sign 5AD0C2E9402F02956C5FE27540A9825C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_tranfer")
public class AssetTranfer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_TRANFER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = true,value="业务名称" , notes = "业务名称")
	private String name;
	
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
	 * 调出使用公司/部门：调出使用公司/部门
	*/
	@ApiModelProperty(required = false,value="调出使用公司/部门" , notes = "调出使用公司/部门")
	private String outUseOrganizationId;
	
	/**
	 * 调入使用公司/部门：调入使用公司/部门
	*/
	@ApiModelProperty(required = false,value="调入使用公司/部门" , notes = "调入使用公司/部门")
	private String inUseOrganizationId;
	
	/**
	 * 调入管理员：调入管理员
	*/
	@ApiModelProperty(required = false,value="调入管理员" , notes = "调入管理员")
	private String managerId;
	
	/**
	 * 使用人员：使用人员
	*/
	@ApiModelProperty(required = false,value="使用人员" , notes = "使用人员")
	private String useUserId;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String positionId;
	
	/**
	 * 位置详情：位置详情
	*/
	@ApiModelProperty(required = false,value="位置详情" , notes = "位置详情")
	private String positionDetail;
	
	/**
	 * 转移说明：转移说明
	*/
	@ApiModelProperty(required = false,value="转移说明" , notes = "转移说明")
	private String content;
	
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
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private Position position;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Person originator;
	
	/**
	 * 调入管理员：调入管理员
	*/
	@ApiModelProperty(required = false,value="调入管理员" , notes = "调入管理员")
	private Person manager;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private Person useUser;
	
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
	public AssetTranfer setId(String id) {
		this.id=id;
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
	public AssetTranfer setName(String name) {
		this.name=name;
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
	public AssetTranfer setBusinessCode(String businessCode) {
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
	public AssetTranfer setProcId(String procId) {
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
	public AssetTranfer setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 调出使用公司/部门<br>
	 * 调出使用公司/部门
	 * @return 调出使用公司/部门
	*/
	public String getOutUseOrganizationId() {
		return outUseOrganizationId;
	}
	
	/**
	 * 设置 调出使用公司/部门
	 * @param outUseOrganizationId 调出使用公司/部门
	 * @return 当前对象
	*/
	public AssetTranfer setOutUseOrganizationId(String outUseOrganizationId) {
		this.outUseOrganizationId=outUseOrganizationId;
		return this;
	}
	
	/**
	 * 获得 调入使用公司/部门<br>
	 * 调入使用公司/部门
	 * @return 调入使用公司/部门
	*/
	public String getInUseOrganizationId() {
		return inUseOrganizationId;
	}
	
	/**
	 * 设置 调入使用公司/部门
	 * @param inUseOrganizationId 调入使用公司/部门
	 * @return 当前对象
	*/
	public AssetTranfer setInUseOrganizationId(String inUseOrganizationId) {
		this.inUseOrganizationId=inUseOrganizationId;
		return this;
	}
	
	/**
	 * 获得 调入管理员<br>
	 * 调入管理员
	 * @return 调入管理员
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 调入管理员
	 * @param managerId 调入管理员
	 * @return 当前对象
	*/
	public AssetTranfer setManagerId(String managerId) {
		this.managerId=managerId;
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
	public AssetTranfer setUseUserId(String useUserId) {
		this.useUserId=useUserId;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 位置
	 * @param positionId 位置
	 * @return 当前对象
	*/
	public AssetTranfer setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 位置详情<br>
	 * 位置详情
	 * @return 位置详情
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 位置详情
	 * @param positionDetail 位置详情
	 * @return 当前对象
	*/
	public AssetTranfer setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 转移说明<br>
	 * 转移说明
	 * @return 转移说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 转移说明
	 * @param content 转移说明
	 * @return 当前对象
	*/
	public AssetTranfer setContent(String content) {
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
	public AssetTranfer setOriginatorId(String originatorId) {
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
	public AssetTranfer setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
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
	public AssetTranfer setCreateBy(String createBy) {
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
	public AssetTranfer setCreateTime(Date createTime) {
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
	public AssetTranfer setUpdateBy(String updateBy) {
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
	public AssetTranfer setUpdateTime(Date updateTime) {
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
	public AssetTranfer setDeleted(Integer deleted) {
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
	public AssetTranfer setDeleteBy(String deleteBy) {
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
	public AssetTranfer setDeleteTime(Date deleteTime) {
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
	public AssetTranfer setVersion(Integer version) {
		this.version=version;
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
	public AssetTranfer setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetTranfer addAsset(Asset asset) {
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
	public AssetTranfer setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetTranfer addAssetId(String assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.add(assetId);
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 位置
	 * @param position 位置
	 * @return 当前对象
	*/
	public AssetTranfer setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Person getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public AssetTranfer setOriginator(Person originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 调入管理员<br>
	 * 调入管理员
	 * @return 调入管理员
	*/
	public Person getManager() {
		return manager;
	}
	
	/**
	 * 设置 调入管理员
	 * @param manager 调入管理员
	 * @return 当前对象
	*/
	public AssetTranfer setManager(Person manager) {
		this.manager=manager;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public Person getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 使用人
	 * @param useUser 使用人
	 * @return 当前对象
	*/
	public AssetTranfer setUseUser(Person useUser) {
		this.useUser=useUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetTranfer , 转换好的 AssetTranfer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetTranfer , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetTranfer
	 * @param assetTranferMap 包含实体信息的 Map 对象
	 * @return AssetTranfer , 转换好的的 AssetTranfer 对象
	*/
	@Transient
	public static AssetTranfer createFrom(Map<String,Object> assetTranferMap) {
		if(assetTranferMap==null) return null;
		AssetTranfer po = EntityContext.create(AssetTranfer.class, assetTranferMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetTranfer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetTranfer , 转换好的的 AssetTranfer 对象
	*/
	@Transient
	public static AssetTranfer createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetTranfer po = EntityContext.create(AssetTranfer.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetTranfer，等同于 new
	 * @return AssetTranfer 对象
	*/
	@Transient
	public static AssetTranfer create() {
		return EntityContext.create(AssetTranfer.class);
	}
}