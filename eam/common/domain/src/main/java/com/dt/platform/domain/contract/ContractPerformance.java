package com.dt.platform.domain.contract;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT_PERFORMANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 合同履行情况
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-08 17:04:16
 * @sign 61DCAE93D76DB8089960045411D71F6B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "cont_contract_performance")
public class ContractPerformance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CONT_CONTRACT_PERFORMANCE.$TABLE;
	
	/**
	 * id：id
	*/
	@Id
	@ApiModelProperty(required = true,value="id" , notes = "id")
	private String id;
	
	/**
	 * 合同ID：合同ID
	*/
	@ApiModelProperty(required = false,value="合同ID" , notes = "合同ID")
	private String contractId;
	
	/**
	 * 概述：概述
	*/
	@ApiModelProperty(required = false,value="概述" , notes = "概述")
	private String title;
	
	/**
	 * 履约细节：履约细节
	*/
	@ApiModelProperty(required = false,value="履约细节" , notes = "履约细节")
	private String detail;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
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
	 * 履约时间：履约时间
	*/
	@ApiModelProperty(required = false,value="履约时间" , notes = "履约时间")
	private Date performanceTime;
	
	/**
	 * 获得 id<br>
	 * id
	 * @return id
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 id
	 * @param id id
	 * @return 当前对象
	*/
	public ContractPerformance setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 合同ID<br>
	 * 合同ID
	 * @return 合同ID
	*/
	public String getContractId() {
		return contractId;
	}
	
	/**
	 * 设置 合同ID
	 * @param contractId 合同ID
	 * @return 当前对象
	*/
	public ContractPerformance setContractId(String contractId) {
		this.contractId=contractId;
		return this;
	}
	
	/**
	 * 获得 概述<br>
	 * 概述
	 * @return 概述
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 概述
	 * @param title 概述
	 * @return 当前对象
	*/
	public ContractPerformance setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 履约细节<br>
	 * 履约细节
	 * @return 履约细节
	*/
	public String getDetail() {
		return detail;
	}
	
	/**
	 * 设置 履约细节
	 * @param detail 履约细节
	 * @return 当前对象
	*/
	public ContractPerformance setDetail(String detail) {
		this.detail=detail;
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public ContractPerformance setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public ContractPerformance setCreateBy(String createBy) {
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
	public ContractPerformance setCreateTime(Date createTime) {
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
	public ContractPerformance setUpdateBy(String updateBy) {
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
	public ContractPerformance setUpdateTime(Date updateTime) {
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
	public ContractPerformance setDeleted(Integer deleted) {
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
	public ContractPerformance setDeleteBy(String deleteBy) {
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
	public ContractPerformance setDeleteTime(Date deleteTime) {
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
	public ContractPerformance setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 履约时间<br>
	 * 履约时间
	 * @return 履约时间
	*/
	public Date getPerformanceTime() {
		return performanceTime;
	}
	
	/**
	 * 设置 履约时间
	 * @param performanceTime 履约时间
	 * @return 当前对象
	*/
	public ContractPerformance setPerformanceTime(Date performanceTime) {
		this.performanceTime=performanceTime;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ContractPerformance , 转换好的 ContractPerformance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ContractPerformance , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ContractPerformance
	 * @param contractPerformanceMap 包含实体信息的 Map 对象
	 * @return ContractPerformance , 转换好的的 ContractPerformance 对象
	*/
	@Transient
	public static ContractPerformance createFrom(Map<String,Object> contractPerformanceMap) {
		if(contractPerformanceMap==null) return null;
		ContractPerformance po = EntityContext.create(ContractPerformance.class, contractPerformanceMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ContractPerformance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ContractPerformance , 转换好的的 ContractPerformance 对象
	*/
	@Transient
	public static ContractPerformance createFrom(Object pojo) {
		if(pojo==null) return null;
		ContractPerformance po = EntityContext.create(ContractPerformance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ContractPerformance，等同于 new
	 * @return ContractPerformance 对象
	*/
	@Transient
	public static ContractPerformance create() {
		return EntityContext.create(ContractPerformance.class);
	}
}