package com.dt.platform.domain.contract;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT_SIGNER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import com.dt.platform.constants.enums.contract.SignerAlias;
import javax.persistence.Transient;
import com.dt.platform.constants.enums.contract.SignerType;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 合同签订方
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-08 17:04:16
 * @sign 23466F001A200B42C1DA3BF1CB8F35B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "cont_contract_signer")
public class ContractSigner extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CONT_CONTRACT_SIGNER.$TABLE;
	
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
	 * 显示顺序：显示顺序
	*/
	@ApiModelProperty(required = false,value="显示顺序" , notes = "显示顺序")
	private Integer sort;
	
	/**
	 * 别名：甲方/乙方等；枚举：SignerAlias
	*/
	@ApiModelProperty(required = false,value="别名" , notes = "甲方/乙方等；枚举：SignerAlias")
	private String alias;
	@Transient
	private SignerAlias aliasEnum;
	
	/**
	 * 签订方类型：企业或个人；枚举：SignerType
	*/
	@ApiModelProperty(required = false,value="签订方类型" , notes = "企业或个人；枚举：SignerType")
	private String type;
	@Transient
	private SignerType typeEnum;
	
	/**
	 * 唯一代码：统一社会信用代码/身份证号码
	*/
	@ApiModelProperty(required = false,value="唯一代码" , notes = "统一社会信用代码/身份证号码")
	private String identityCdoe;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 座机号码：座机号码
	*/
	@ApiModelProperty(required = false,value="座机号码" , notes = "座机号码")
	private String landlineNumber;
	
	/**
	 * 传真号码：传真号码
	*/
	@ApiModelProperty(required = false,value="传真号码" , notes = "传真号码")
	private String faxNumber;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = false,value="地址" , notes = "地址")
	private String address;
	
	/**
	 * 联系人姓名：联系人姓名
	*/
	@ApiModelProperty(required = false,value="联系人姓名" , notes = "联系人姓名")
	private String contactPerson;
	
	/**
	 * 联系人手机：联系人手机
	*/
	@ApiModelProperty(required = false,value="联系人手机" , notes = "联系人手机")
	private String contactPhone;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public ContractSigner setId(String id) {
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
	public ContractSigner setContractId(String contractId) {
		this.contractId=contractId;
		return this;
	}
	
	/**
	 * 获得 显示顺序<br>
	 * 显示顺序
	 * @return 显示顺序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 显示顺序
	 * @param sort 显示顺序
	 * @return 当前对象
	*/
	public ContractSigner setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 别名<br>
	 * 甲方/乙方等；枚举：SignerAlias
	 * @return 别名
	*/
	public String getAlias() {
		return alias;
	}
	
	/**
	 * 获得 别名 的投影属性<br>
	 * 等价于 getAlias 方法，获得对应的枚举类型
	 * @return 别名
	*/
	@Transient
	public SignerAlias getAliasEnum() {
		if(this.aliasEnum==null) {
			this.aliasEnum = (SignerAlias) EnumUtil.parseByCode(SignerAlias.values(),alias);
		}
		return this.aliasEnum ;
	}
	
	/**
	 * 设置 别名
	 * @param alias 别名
	 * @return 当前对象
	*/
	public ContractSigner setAlias(String alias) {
		this.alias=alias;
		this.aliasEnum= (SignerAlias) EnumUtil.parseByCode(SignerAlias.values(),alias) ;
		if(StringUtil.hasContent(alias) && this.aliasEnum==null) {
			throw new IllegalArgumentException( alias + " is not one of SignerAlias");
		}
		return this;
	}
	
	/**
	 * 设置 别名的投影属性，等同于设置 别名
	 * @param aliasEnum 别名
	 * @return 当前对象
	*/
	@Transient
	public ContractSigner setAliasEnum(SignerAlias aliasEnum) {
		if(aliasEnum==null) {
			this.setAlias(null);
		} else {
			this.setAlias(aliasEnum.code());
		}
		this.aliasEnum=aliasEnum;
		return this;
	}
	
	/**
	 * 获得 签订方类型<br>
	 * 企业或个人；枚举：SignerType
	 * @return 签订方类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 签订方类型 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 签订方类型
	*/
	@Transient
	public SignerType getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (SignerType) EnumUtil.parseByCode(SignerType.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 签订方类型
	 * @param type 签订方类型
	 * @return 当前对象
	*/
	public ContractSigner setType(String type) {
		this.type=type;
		this.typeEnum= (SignerType) EnumUtil.parseByCode(SignerType.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of SignerType");
		}
		return this;
	}
	
	/**
	 * 设置 签订方类型的投影属性，等同于设置 签订方类型
	 * @param typeEnum 签订方类型
	 * @return 当前对象
	*/
	@Transient
	public ContractSigner setTypeEnum(SignerType typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 唯一代码<br>
	 * 统一社会信用代码/身份证号码
	 * @return 唯一代码
	*/
	public String getIdentityCdoe() {
		return identityCdoe;
	}
	
	/**
	 * 设置 唯一代码
	 * @param identityCdoe 唯一代码
	 * @return 当前对象
	*/
	public ContractSigner setIdentityCdoe(String identityCdoe) {
		this.identityCdoe=identityCdoe;
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
	public ContractSigner setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 座机号码<br>
	 * 座机号码
	 * @return 座机号码
	*/
	public String getLandlineNumber() {
		return landlineNumber;
	}
	
	/**
	 * 设置 座机号码
	 * @param landlineNumber 座机号码
	 * @return 当前对象
	*/
	public ContractSigner setLandlineNumber(String landlineNumber) {
		this.landlineNumber=landlineNumber;
		return this;
	}
	
	/**
	 * 获得 传真号码<br>
	 * 传真号码
	 * @return 传真号码
	*/
	public String getFaxNumber() {
		return faxNumber;
	}
	
	/**
	 * 设置 传真号码
	 * @param faxNumber 传真号码
	 * @return 当前对象
	*/
	public ContractSigner setFaxNumber(String faxNumber) {
		this.faxNumber=faxNumber;
		return this;
	}
	
	/**
	 * 获得 地址<br>
	 * 地址
	 * @return 地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 地址
	 * @param address 地址
	 * @return 当前对象
	*/
	public ContractSigner setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 联系人姓名<br>
	 * 联系人姓名
	 * @return 联系人姓名
	*/
	public String getContactPerson() {
		return contactPerson;
	}
	
	/**
	 * 设置 联系人姓名
	 * @param contactPerson 联系人姓名
	 * @return 当前对象
	*/
	public ContractSigner setContactPerson(String contactPerson) {
		this.contactPerson=contactPerson;
		return this;
	}
	
	/**
	 * 获得 联系人手机<br>
	 * 联系人手机
	 * @return 联系人手机
	*/
	public String getContactPhone() {
		return contactPhone;
	}
	
	/**
	 * 设置 联系人手机
	 * @param contactPhone 联系人手机
	 * @return 当前对象
	*/
	public ContractSigner setContactPhone(String contactPhone) {
		this.contactPhone=contactPhone;
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
	public ContractSigner setNotes(String notes) {
		this.notes=notes;
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
	public ContractSigner setTenantId(String tenantId) {
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
	public ContractSigner setCreateBy(String createBy) {
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
	public ContractSigner setCreateTime(Date createTime) {
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
	public ContractSigner setUpdateBy(String updateBy) {
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
	public ContractSigner setUpdateTime(Date updateTime) {
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
	public ContractSigner setDeleted(Integer deleted) {
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
	public ContractSigner setDeleteBy(String deleteBy) {
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
	public ContractSigner setDeleteTime(Date deleteTime) {
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
	public ContractSigner setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ContractSigner , 转换好的 ContractSigner 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ContractSigner , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ContractSigner
	 * @param contractSignerMap 包含实体信息的 Map 对象
	 * @return ContractSigner , 转换好的的 ContractSigner 对象
	*/
	@Transient
	public static ContractSigner createFrom(Map<String,Object> contractSignerMap) {
		if(contractSignerMap==null) return null;
		ContractSigner po = EntityContext.create(ContractSigner.class, contractSignerMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ContractSigner
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ContractSigner , 转换好的的 ContractSigner 对象
	*/
	@Transient
	public static ContractSigner createFrom(Object pojo) {
		if(pojo==null) return null;
		ContractSigner po = EntityContext.create(ContractSigner.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ContractSigner，等同于 new
	 * @return ContractSigner 对象
	*/
	@Transient
	public static ContractSigner create() {
		return EntityContext.create(ContractSigner.class);
	}
}