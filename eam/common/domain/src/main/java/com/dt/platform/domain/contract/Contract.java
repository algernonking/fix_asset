package com.dt.platform.domain.contract;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import com.dt.platform.constants.enums.contract.ContractType;
import javax.persistence.Transient;
import java.math.BigDecimal;
import com.dt.platform.constants.enums.contract.ContractStatus;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 合同
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-20 16:12:42
 * @sign FBA14368FFA32BC1456A2C0BD5BFA8FA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "cont_contract")
public class Contract extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CONT_CONTRACT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 合同类型：主合同，子合同、附加协议; ContractType
	*/
	@ApiModelProperty(required = false,value="合同类型" , notes = "主合同，子合同、附加协议; ContractType")
	private String type;
	@Transient
	private ContractType typeEnum;
	
	/**
	 * 上级合同ID：上级合同ID
	*/
	@ApiModelProperty(required = false,value="上级合同ID" , notes = "上级合同ID")
	private String parentId;
	
	/**
	 * 合同编号：合同编号
	*/
	@ApiModelProperty(required = false,value="合同编号" , notes = "合同编号")
	private String contractNo;
	
	/**
	 * 合同抬头：合同抬头
	*/
	@ApiModelProperty(required = false,value="合同抬头" , notes = "合同抬头")
	private String title;
	
	/**
	 * 交付物：交付物
	*/
	@ApiModelProperty(required = false,value="交付物" , notes = "交付物")
	private String deliverables;
	
	/**
	 * 交付地：交付地
	*/
	@ApiModelProperty(required = false,value="交付地" , notes = "交付地")
	private String deliveryLocation;
	
	/**
	 * 合同金额：合同金额
	*/
	@ApiModelProperty(required = false,value="合同金额" , notes = "合同金额")
	private BigDecimal amount;
	
	/**
	 * 合同状态：枚举 ContractStatus
	*/
	@ApiModelProperty(required = false,value="合同状态" , notes = "枚举 ContractStatus")
	private String contractStatus;
	@Transient
	private ContractStatus contractStatusEnum;
	
	/**
	 * 摘要信息：摘要信息
	*/
	@ApiModelProperty(required = false,value="摘要信息" , notes = "摘要信息")
	private String summary;
	
	/**
	 * 签订日期：签订日期
	*/
	@ApiModelProperty(required = false,value="签订日期" , notes = "签订日期")
	private Date signingDate;
	
	/**
	 * 生效日期：生效日期
	*/
	@ApiModelProperty(required = false,value="生效日期" , notes = "生效日期")
	private Date effectiveDate;
	
	/**
	 * 结束日期：结束日期
	*/
	@ApiModelProperty(required = false,value="结束日期" , notes = "结束日期")
	private Date endDate;
	
	/**
	 * 失效日期：失效日期
	*/
	@ApiModelProperty(required = false,value="失效日期" , notes = "失效日期")
	private Date expirationDate;
	
	/**
	 * 归属部门ID：归属部门ID
	*/
	@ApiModelProperty(required = false,value="归属部门ID" , notes = "归属部门ID")
	private String departmentId;
	
	/**
	 * 资金状态：枚举 FundingStatus
	*/
	@ApiModelProperty(required = false,value="资金状态" , notes = "枚举 FundingStatus")
	private String fundingStatus;
	
	/**
	 * 资金流向：关联字典
	*/
	@ApiModelProperty(required = false,value="资金流向" , notes = "关联字典")
	private String fundingDirection;
	
	/**
	 * 合同分类代码：关联字典
	*/
	@ApiModelProperty(required = false,value="合同分类代码" , notes = "关联字典")
	private String catalogCode;
	
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
	 * 归属部门：归属部门
	*/
	@ApiModelProperty(required = false,value="归属部门" , notes = "归属部门")
	private Organization department;
	
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
	public Contract setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 合同类型<br>
	 * 主合同，子合同、附加协议; ContractType
	 * @return 合同类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 合同类型 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 合同类型
	*/
	@Transient
	public ContractType getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (ContractType) EnumUtil.parseByCode(ContractType.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 合同类型
	 * @param type 合同类型
	 * @return 当前对象
	*/
	public Contract setType(String type) {
		this.type=type;
		this.typeEnum= (ContractType) EnumUtil.parseByCode(ContractType.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of ContractType");
		}
		return this;
	}
	
	/**
	 * 设置 合同类型的投影属性，等同于设置 合同类型
	 * @param typeEnum 合同类型
	 * @return 当前对象
	*/
	@Transient
	public Contract setTypeEnum(ContractType typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 上级合同ID<br>
	 * 上级合同ID
	 * @return 上级合同ID
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 上级合同ID
	 * @param parentId 上级合同ID
	 * @return 当前对象
	*/
	public Contract setParentId(String parentId) {
		this.parentId=parentId;
		return this;
	}
	
	/**
	 * 获得 合同编号<br>
	 * 合同编号
	 * @return 合同编号
	*/
	public String getContractNo() {
		return contractNo;
	}
	
	/**
	 * 设置 合同编号
	 * @param contractNo 合同编号
	 * @return 当前对象
	*/
	public Contract setContractNo(String contractNo) {
		this.contractNo=contractNo;
		return this;
	}
	
	/**
	 * 获得 合同抬头<br>
	 * 合同抬头
	 * @return 合同抬头
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 合同抬头
	 * @param title 合同抬头
	 * @return 当前对象
	*/
	public Contract setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 交付物<br>
	 * 交付物
	 * @return 交付物
	*/
	public String getDeliverables() {
		return deliverables;
	}
	
	/**
	 * 设置 交付物
	 * @param deliverables 交付物
	 * @return 当前对象
	*/
	public Contract setDeliverables(String deliverables) {
		this.deliverables=deliverables;
		return this;
	}
	
	/**
	 * 获得 交付地<br>
	 * 交付地
	 * @return 交付地
	*/
	public String getDeliveryLocation() {
		return deliveryLocation;
	}
	
	/**
	 * 设置 交付地
	 * @param deliveryLocation 交付地
	 * @return 当前对象
	*/
	public Contract setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation=deliveryLocation;
		return this;
	}
	
	/**
	 * 获得 合同金额<br>
	 * 合同金额
	 * @return 合同金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 合同金额
	 * @param amount 合同金额
	 * @return 当前对象
	*/
	public Contract setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 合同状态<br>
	 * 枚举 ContractStatus
	 * @return 合同状态
	*/
	public String getContractStatus() {
		return contractStatus;
	}
	
	/**
	 * 获得 合同状态 的投影属性<br>
	 * 等价于 getContractStatus 方法，获得对应的枚举类型
	 * @return 合同状态
	*/
	@Transient
	public ContractStatus getContractStatusEnum() {
		if(this.contractStatusEnum==null) {
			this.contractStatusEnum = (ContractStatus) EnumUtil.parseByCode(ContractStatus.values(),contractStatus);
		}
		return this.contractStatusEnum ;
	}
	
	/**
	 * 设置 合同状态
	 * @param contractStatus 合同状态
	 * @return 当前对象
	*/
	public Contract setContractStatus(String contractStatus) {
		this.contractStatus=contractStatus;
		this.contractStatusEnum= (ContractStatus) EnumUtil.parseByCode(ContractStatus.values(),contractStatus) ;
		if(StringUtil.hasContent(contractStatus) && this.contractStatusEnum==null) {
			throw new IllegalArgumentException( contractStatus + " is not one of ContractStatus");
		}
		return this;
	}
	
	/**
	 * 设置 合同状态的投影属性，等同于设置 合同状态
	 * @param contractStatusEnum 合同状态
	 * @return 当前对象
	*/
	@Transient
	public Contract setContractStatusEnum(ContractStatus contractStatusEnum) {
		if(contractStatusEnum==null) {
			this.setContractStatus(null);
		} else {
			this.setContractStatus(contractStatusEnum.code());
		}
		this.contractStatusEnum=contractStatusEnum;
		return this;
	}
	
	/**
	 * 获得 摘要信息<br>
	 * 摘要信息
	 * @return 摘要信息
	*/
	public String getSummary() {
		return summary;
	}
	
	/**
	 * 设置 摘要信息
	 * @param summary 摘要信息
	 * @return 当前对象
	*/
	public Contract setSummary(String summary) {
		this.summary=summary;
		return this;
	}
	
	/**
	 * 获得 签订日期<br>
	 * 签订日期
	 * @return 签订日期
	*/
	public Date getSigningDate() {
		return signingDate;
	}
	
	/**
	 * 设置 签订日期
	 * @param signingDate 签订日期
	 * @return 当前对象
	*/
	public Contract setSigningDate(Date signingDate) {
		this.signingDate=signingDate;
		return this;
	}
	
	/**
	 * 获得 生效日期<br>
	 * 生效日期
	 * @return 生效日期
	*/
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	
	/**
	 * 设置 生效日期
	 * @param effectiveDate 生效日期
	 * @return 当前对象
	*/
	public Contract setEffectiveDate(Date effectiveDate) {
		this.effectiveDate=effectiveDate;
		return this;
	}
	
	/**
	 * 获得 结束日期<br>
	 * 结束日期
	 * @return 结束日期
	*/
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * 设置 结束日期
	 * @param endDate 结束日期
	 * @return 当前对象
	*/
	public Contract setEndDate(Date endDate) {
		this.endDate=endDate;
		return this;
	}
	
	/**
	 * 获得 失效日期<br>
	 * 失效日期
	 * @return 失效日期
	*/
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * 设置 失效日期
	 * @param expirationDate 失效日期
	 * @return 当前对象
	*/
	public Contract setExpirationDate(Date expirationDate) {
		this.expirationDate=expirationDate;
		return this;
	}
	
	/**
	 * 获得 归属部门ID<br>
	 * 归属部门ID
	 * @return 归属部门ID
	*/
	public String getDepartmentId() {
		return departmentId;
	}
	
	/**
	 * 设置 归属部门ID
	 * @param departmentId 归属部门ID
	 * @return 当前对象
	*/
	public Contract setDepartmentId(String departmentId) {
		this.departmentId=departmentId;
		return this;
	}
	
	/**
	 * 获得 资金状态<br>
	 * 枚举 FundingStatus
	 * @return 资金状态
	*/
	public String getFundingStatus() {
		return fundingStatus;
	}
	
	/**
	 * 设置 资金状态
	 * @param fundingStatus 资金状态
	 * @return 当前对象
	*/
	public Contract setFundingStatus(String fundingStatus) {
		this.fundingStatus=fundingStatus;
		return this;
	}
	
	/**
	 * 获得 资金流向<br>
	 * 关联字典
	 * @return 资金流向
	*/
	public String getFundingDirection() {
		return fundingDirection;
	}
	
	/**
	 * 设置 资金流向
	 * @param fundingDirection 资金流向
	 * @return 当前对象
	*/
	public Contract setFundingDirection(String fundingDirection) {
		this.fundingDirection=fundingDirection;
		return this;
	}
	
	/**
	 * 获得 合同分类代码<br>
	 * 关联字典
	 * @return 合同分类代码
	*/
	public String getCatalogCode() {
		return catalogCode;
	}
	
	/**
	 * 设置 合同分类代码
	 * @param catalogCode 合同分类代码
	 * @return 当前对象
	*/
	public Contract setCatalogCode(String catalogCode) {
		this.catalogCode=catalogCode;
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
	public Contract setTenantId(String tenantId) {
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
	public Contract setCreateBy(String createBy) {
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
	public Contract setCreateTime(Date createTime) {
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
	public Contract setUpdateBy(String updateBy) {
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
	public Contract setUpdateTime(Date updateTime) {
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
	public Contract setDeleted(Integer deleted) {
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
	public Contract setDeleteBy(String deleteBy) {
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
	public Contract setDeleteTime(Date deleteTime) {
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
	public Contract setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 归属部门<br>
	 * 归属部门
	 * @return 归属部门
	*/
	public Organization getDepartment() {
		return department;
	}
	
	/**
	 * 设置 归属部门
	 * @param department 归属部门
	 * @return 当前对象
	*/
	public Contract setDepartment(Organization department) {
		this.department=department;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Contract , 转换好的 Contract 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Contract , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Contract
	 * @param contractMap 包含实体信息的 Map 对象
	 * @return Contract , 转换好的的 Contract 对象
	*/
	@Transient
	public static Contract createFrom(Map<String,Object> contractMap) {
		if(contractMap==null) return null;
		Contract po = EntityContext.create(Contract.class, contractMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Contract
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Contract , 转换好的的 Contract 对象
	*/
	@Transient
	public static Contract createFrom(Object pojo) {
		if(pojo==null) return null;
		Contract po = EntityContext.create(Contract.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Contract，等同于 new
	 * @return Contract 对象
	*/
	@Transient
	public static Contract create() {
		return EntityContext.create(Contract.class);
	}
}