package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DEPRECIATION_OPER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 折旧操作
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 16:09:53
 * @sign 03334B63D4CFA318A8E8B91DF291309B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_depreciation_oper")
public class AssetDepreciationOper extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DEPRECIATION_OPER.$TABLE;
	
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
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 折旧方案：折旧方案
	*/
	@ApiModelProperty(required = false,value="折旧方案" , notes = "折旧方案")
	private String depreciationId;
	
	/**
	 * 折旧内容：折旧内容
	*/
	@ApiModelProperty(required = false,value="折旧内容" , notes = "折旧内容")
	private String content;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
	/**
	 * 执行时间：执行时间
	*/
	@ApiModelProperty(required = false,value="执行时间" , notes = "执行时间")
	private Date executionStartTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date executionEndTime;
	
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
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetSourceList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetSourceIds;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetTargetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetTargetIds;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetDepreciationList;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<String> assetDepreciationIds;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private AssetDepreciation assetDepreciation;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
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
	public AssetDepreciationOper setId(String id) {
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
	public AssetDepreciationOper setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public AssetDepreciationOper setStatus(String status) {
		this.status=status;
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
	public AssetDepreciationOper setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 折旧方案<br>
	 * 折旧方案
	 * @return 折旧方案
	*/
	public String getDepreciationId() {
		return depreciationId;
	}
	
	/**
	 * 设置 折旧方案
	 * @param depreciationId 折旧方案
	 * @return 当前对象
	*/
	public AssetDepreciationOper setDepreciationId(String depreciationId) {
		this.depreciationId=depreciationId;
		return this;
	}
	
	/**
	 * 获得 折旧内容<br>
	 * 折旧内容
	 * @return 折旧内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 折旧内容
	 * @param content 折旧内容
	 * @return 当前对象
	*/
	public AssetDepreciationOper setContent(String content) {
		this.content=content;
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
	public AssetDepreciationOper setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 执行时间<br>
	 * 执行时间
	 * @return 执行时间
	*/
	public Date getExecutionStartTime() {
		return executionStartTime;
	}
	
	/**
	 * 设置 执行时间
	 * @param executionStartTime 执行时间
	 * @return 当前对象
	*/
	public AssetDepreciationOper setExecutionStartTime(Date executionStartTime) {
		this.executionStartTime=executionStartTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getExecutionEndTime() {
		return executionEndTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param executionEndTime 结束时间
	 * @return 当前对象
	*/
	public AssetDepreciationOper setExecutionEndTime(Date executionEndTime) {
		this.executionEndTime=executionEndTime;
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
	public AssetDepreciationOper setNotes(String notes) {
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
	public AssetDepreciationOper setOriginatorId(String originatorId) {
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
	public AssetDepreciationOper setCreateBy(String createBy) {
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
	public AssetDepreciationOper setCreateTime(Date createTime) {
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
	public AssetDepreciationOper setUpdateBy(String updateBy) {
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
	public AssetDepreciationOper setUpdateTime(Date updateTime) {
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
	public AssetDepreciationOper setDeleted(Integer deleted) {
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
	public AssetDepreciationOper setDeleteBy(String deleteBy) {
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
	public AssetDepreciationOper setDeleteTime(Date deleteTime) {
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
	public AssetDepreciationOper setVersion(Integer version) {
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
	public AssetDepreciationOper setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetSourceList() {
		return assetSourceList;
	}
	
	/**
	 * 设置 资产
	 * @param assetSourceList 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetSourceList(List<Asset> assetSourceList) {
		this.assetSourceList=assetSourceList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetSource 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetSource(Asset assetSource) {
		if(this.assetSourceList==null) assetSourceList=new ArrayList<>();
		this.assetSourceList.add(assetSource);
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetSourceIds() {
		return assetSourceIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetSourceIds 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetSourceIds(List<String> assetSourceIds) {
		this.assetSourceIds=assetSourceIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetSourceId 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetSourceId(String assetSourceId) {
		if(this.assetSourceIds==null) assetSourceIds=new ArrayList<>();
		this.assetSourceIds.add(assetSourceId);
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetTargetList() {
		return assetTargetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetTargetList 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetTargetList(List<Asset> assetTargetList) {
		this.assetTargetList=assetTargetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetTarget 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetTarget(Asset assetTarget) {
		if(this.assetTargetList==null) assetTargetList=new ArrayList<>();
		this.assetTargetList.add(assetTarget);
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetTargetIds() {
		return assetTargetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetTargetIds 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetTargetIds(List<String> assetTargetIds) {
		this.assetTargetIds=assetTargetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetTargetId 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetTargetId(String assetTargetId) {
		if(this.assetTargetIds==null) assetTargetIds=new ArrayList<>();
		this.assetTargetIds.add(assetTargetId);
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetDepreciationList() {
		return assetDepreciationList;
	}
	
	/**
	 * 设置 资产
	 * @param assetDepreciationList 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetDepreciationList(List<Asset> assetDepreciationList) {
		this.assetDepreciationList=assetDepreciationList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetDepreciation 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetDepreciation(Asset assetDepreciation) {
		if(this.assetDepreciationList==null) assetDepreciationList=new ArrayList<>();
		this.assetDepreciationList.add(assetDepreciation);
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<String> getAssetDepreciationIds() {
		return assetDepreciationIds;
	}
	
	/**
	 * 设置 资产
	 * @param assetDepreciationIds 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetDepreciationIds(List<String> assetDepreciationIds) {
		this.assetDepreciationIds=assetDepreciationIds;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetDepreciationId 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetDepreciationId(String assetDepreciationId) {
		if(this.assetDepreciationIds==null) assetDepreciationIds=new ArrayList<>();
		this.assetDepreciationIds.add(assetDepreciationId);
		return this;
	}
	
	/**
	 * 获得 方案<br>
	 * 方案
	 * @return 方案
	*/
	public AssetDepreciation getAssetDepreciation() {
		return assetDepreciation;
	}
	
	/**
	 * 设置 方案
	 * @param assetDepreciation 方案
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetDepreciation(AssetDepreciation assetDepreciation) {
		this.assetDepreciation=assetDepreciation;
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
	public AssetDepreciationOper setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDepreciationOper , 转换好的 AssetDepreciationOper 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationOper , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetDepreciationOper
	 * @param assetDepreciationOperMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationOper , 转换好的的 AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOper createFrom(Map<String,Object> assetDepreciationOperMap) {
		if(assetDepreciationOperMap==null) return null;
		AssetDepreciationOper po = EntityContext.create(AssetDepreciationOper.class, assetDepreciationOperMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationOper
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationOper , 转换好的的 AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOper createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationOper po = EntityContext.create(AssetDepreciationOper.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetDepreciationOper，等同于 new
	 * @return AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOper create() {
		return EntityContext.create(AssetDepreciationOper.class);
	}
}