package com.dt.platform.domain.contract;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.CONT_CONTRACT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:28:04
 * @sign CDB830B6EE5E05E0B1B7E74E276F97A8
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
	 * 合同名称：合同名称
	*/
	@ApiModelProperty(required = false,value="合同名称" , notes = "合同名称")
	private String name;
	
	/**
	 * 合同编号：合同编号
	*/
	@ApiModelProperty(required = false,value="合同编号" , notes = "合同编号")
	private String code;
	
	/**
	 * 合同状态：未签订|履约中|中止|完成|作废
	*/
	@ApiModelProperty(required = false,value="合同状态" , notes = "未签订|履约中|中止|完成|作废")
	private String state;
	
	/**
	 * 资金状态：未生效|收付中|已结清
	*/
	@ApiModelProperty(required = false,value="资金状态" , notes = "未生效|收付中|已结清")
	private String fundStatus;
	
	/**
	 * 合同类型：合同类型
	*/
	@ApiModelProperty(required = false,value="合同类型" , notes = "合同类型")
	private String categoryId;
	
	/**
	 * 我方身份：我方身份
	*/
	@ApiModelProperty(required = false,value="我方身份" , notes = "我方身份")
	private String identity;
	
	/**
	 * 资金流向：资金流向
	*/
	@ApiModelProperty(required = false,value="资金流向" , notes = "资金流向")
	private String fundDirect;
	
	/**
	 * 金额：金额
	*/
	@ApiModelProperty(required = false,value="金额" , notes = "金额")
	private BigDecimal money;
	
	/**
	 * 总金额：总金额
	*/
	@ApiModelProperty(required = false,value="总金额" , notes = "总金额")
	private BigDecimal allmoney;
	
	/**
	 * 承办人：承办人
	*/
	@ApiModelProperty(required = false,value="承办人" , notes = "承办人")
	private String userId;
	
	/**
	 * 承办人部门：承办人部门
	*/
	@ApiModelProperty(required = false,value="承办人部门" , notes = "承办人部门")
	private String deptId;
	
	/**
	 * 关联招标：关联招标
	*/
	@ApiModelProperty(required = false,value="关联招标" , notes = "关联招标")
	private String biddingId;
	
	/**
	 * 我方单位：我方单位
	*/
	@ApiModelProperty(required = false,value="我方单位" , notes = "我方单位")
	private String firstCompanyName;
	
	/**
	 * 我方联系人：我方联系人
	*/
	@ApiModelProperty(required = false,value="我方联系人" , notes = "我方联系人")
	private String firstContacts;
	
	/**
	 * 我方联系方式：我方联系方式
	*/
	@ApiModelProperty(required = false,value="我方联系方式" , notes = "我方联系方式")
	private String firstContactInformation;
	
	/**
	 * 对方单位：对方单位
	*/
	@ApiModelProperty(required = false,value="对方单位" , notes = "对方单位")
	private String relatedCompanyId;
	
	/**
	 * 对方单位：对方单位
	*/
	@ApiModelProperty(required = false,value="对方单位" , notes = "对方单位")
	private String relatedCompanyName;
	
	/**
	 * 对方单位联系人：对方单位联系人
	*/
	@ApiModelProperty(required = false,value="对方单位联系人" , notes = "对方单位联系人")
	private String relatedContacts;
	
	/**
	 * 对方单位联系方式：对方单位联系方式
	*/
	@ApiModelProperty(required = false,value="对方单位联系方式" , notes = "对方单位联系方式")
	private String relatedContactInformation;
	
	/**
	 * 监理单位：监理单位
	*/
	@ApiModelProperty(required = false,value="监理单位" , notes = "监理单位")
	private String supervisionUnit;
	
	/**
	 * 监理人：监理人
	*/
	@ApiModelProperty(required = false,value="监理人" , notes = "监理人")
	private String supervisionContacts;
	
	/**
	 * 监理联系方式：监理联系方式
	*/
	@ApiModelProperty(required = false,value="监理联系方式" , notes = "监理联系方式")
	private String supervisionContactInformation;
	
	/**
	 * 生效时间：生效时间
	*/
	@ApiModelProperty(required = false,value="生效时间" , notes = "生效时间")
	private Date effectTime;
	
	/**
	 * 失效时间：失效时间
	*/
	@ApiModelProperty(required = false,value="失效时间" , notes = "失效时间")
	private Date lostEffectTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date endTime;
	
	/**
	 * 签订时间：签订时间
	*/
	@ApiModelProperty(required = false,value="签订时间" , notes = "签订时间")
	private Date auditTime;
	
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
	 * 获得 合同名称<br>
	 * 合同名称
	 * @return 合同名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 合同名称
	 * @param name 合同名称
	 * @return 当前对象
	*/
	public Contract setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 合同编号<br>
	 * 合同编号
	 * @return 合同编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 合同编号
	 * @param code 合同编号
	 * @return 当前对象
	*/
	public Contract setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 合同状态<br>
	 * 未签订|履约中|中止|完成|作废
	 * @return 合同状态
	*/
	public String getState() {
		return state;
	}
	
	/**
	 * 设置 合同状态
	 * @param state 合同状态
	 * @return 当前对象
	*/
	public Contract setState(String state) {
		this.state=state;
		return this;
	}
	
	/**
	 * 获得 资金状态<br>
	 * 未生效|收付中|已结清
	 * @return 资金状态
	*/
	public String getFundStatus() {
		return fundStatus;
	}
	
	/**
	 * 设置 资金状态
	 * @param fundStatus 资金状态
	 * @return 当前对象
	*/
	public Contract setFundStatus(String fundStatus) {
		this.fundStatus=fundStatus;
		return this;
	}
	
	/**
	 * 获得 合同类型<br>
	 * 合同类型
	 * @return 合同类型
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 合同类型
	 * @param categoryId 合同类型
	 * @return 当前对象
	*/
	public Contract setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 我方身份<br>
	 * 我方身份
	 * @return 我方身份
	*/
	public String getIdentity() {
		return identity;
	}
	
	/**
	 * 设置 我方身份
	 * @param identity 我方身份
	 * @return 当前对象
	*/
	public Contract setIdentity(String identity) {
		this.identity=identity;
		return this;
	}
	
	/**
	 * 获得 资金流向<br>
	 * 资金流向
	 * @return 资金流向
	*/
	public String getFundDirect() {
		return fundDirect;
	}
	
	/**
	 * 设置 资金流向
	 * @param fundDirect 资金流向
	 * @return 当前对象
	*/
	public Contract setFundDirect(String fundDirect) {
		this.fundDirect=fundDirect;
		return this;
	}
	
	/**
	 * 获得 金额<br>
	 * 金额
	 * @return 金额
	*/
	public BigDecimal getMoney() {
		return money;
	}
	
	/**
	 * 设置 金额
	 * @param money 金额
	 * @return 当前对象
	*/
	public Contract setMoney(BigDecimal money) {
		this.money=money;
		return this;
	}
	
	/**
	 * 获得 总金额<br>
	 * 总金额
	 * @return 总金额
	*/
	public BigDecimal getAllmoney() {
		return allmoney;
	}
	
	/**
	 * 设置 总金额
	 * @param allmoney 总金额
	 * @return 当前对象
	*/
	public Contract setAllmoney(BigDecimal allmoney) {
		this.allmoney=allmoney;
		return this;
	}
	
	/**
	 * 获得 承办人<br>
	 * 承办人
	 * @return 承办人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 承办人
	 * @param userId 承办人
	 * @return 当前对象
	*/
	public Contract setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 承办人部门<br>
	 * 承办人部门
	 * @return 承办人部门
	*/
	public String getDeptId() {
		return deptId;
	}
	
	/**
	 * 设置 承办人部门
	 * @param deptId 承办人部门
	 * @return 当前对象
	*/
	public Contract setDeptId(String deptId) {
		this.deptId=deptId;
		return this;
	}
	
	/**
	 * 获得 关联招标<br>
	 * 关联招标
	 * @return 关联招标
	*/
	public String getBiddingId() {
		return biddingId;
	}
	
	/**
	 * 设置 关联招标
	 * @param biddingId 关联招标
	 * @return 当前对象
	*/
	public Contract setBiddingId(String biddingId) {
		this.biddingId=biddingId;
		return this;
	}
	
	/**
	 * 获得 我方单位<br>
	 * 我方单位
	 * @return 我方单位
	*/
	public String getFirstCompanyName() {
		return firstCompanyName;
	}
	
	/**
	 * 设置 我方单位
	 * @param firstCompanyName 我方单位
	 * @return 当前对象
	*/
	public Contract setFirstCompanyName(String firstCompanyName) {
		this.firstCompanyName=firstCompanyName;
		return this;
	}
	
	/**
	 * 获得 我方联系人<br>
	 * 我方联系人
	 * @return 我方联系人
	*/
	public String getFirstContacts() {
		return firstContacts;
	}
	
	/**
	 * 设置 我方联系人
	 * @param firstContacts 我方联系人
	 * @return 当前对象
	*/
	public Contract setFirstContacts(String firstContacts) {
		this.firstContacts=firstContacts;
		return this;
	}
	
	/**
	 * 获得 我方联系方式<br>
	 * 我方联系方式
	 * @return 我方联系方式
	*/
	public String getFirstContactInformation() {
		return firstContactInformation;
	}
	
	/**
	 * 设置 我方联系方式
	 * @param firstContactInformation 我方联系方式
	 * @return 当前对象
	*/
	public Contract setFirstContactInformation(String firstContactInformation) {
		this.firstContactInformation=firstContactInformation;
		return this;
	}
	
	/**
	 * 获得 对方单位<br>
	 * 对方单位
	 * @return 对方单位
	*/
	public String getRelatedCompanyId() {
		return relatedCompanyId;
	}
	
	/**
	 * 设置 对方单位
	 * @param relatedCompanyId 对方单位
	 * @return 当前对象
	*/
	public Contract setRelatedCompanyId(String relatedCompanyId) {
		this.relatedCompanyId=relatedCompanyId;
		return this;
	}
	
	/**
	 * 获得 对方单位<br>
	 * 对方单位
	 * @return 对方单位
	*/
	public String getRelatedCompanyName() {
		return relatedCompanyName;
	}
	
	/**
	 * 设置 对方单位
	 * @param relatedCompanyName 对方单位
	 * @return 当前对象
	*/
	public Contract setRelatedCompanyName(String relatedCompanyName) {
		this.relatedCompanyName=relatedCompanyName;
		return this;
	}
	
	/**
	 * 获得 对方单位联系人<br>
	 * 对方单位联系人
	 * @return 对方单位联系人
	*/
	public String getRelatedContacts() {
		return relatedContacts;
	}
	
	/**
	 * 设置 对方单位联系人
	 * @param relatedContacts 对方单位联系人
	 * @return 当前对象
	*/
	public Contract setRelatedContacts(String relatedContacts) {
		this.relatedContacts=relatedContacts;
		return this;
	}
	
	/**
	 * 获得 对方单位联系方式<br>
	 * 对方单位联系方式
	 * @return 对方单位联系方式
	*/
	public String getRelatedContactInformation() {
		return relatedContactInformation;
	}
	
	/**
	 * 设置 对方单位联系方式
	 * @param relatedContactInformation 对方单位联系方式
	 * @return 当前对象
	*/
	public Contract setRelatedContactInformation(String relatedContactInformation) {
		this.relatedContactInformation=relatedContactInformation;
		return this;
	}
	
	/**
	 * 获得 监理单位<br>
	 * 监理单位
	 * @return 监理单位
	*/
	public String getSupervisionUnit() {
		return supervisionUnit;
	}
	
	/**
	 * 设置 监理单位
	 * @param supervisionUnit 监理单位
	 * @return 当前对象
	*/
	public Contract setSupervisionUnit(String supervisionUnit) {
		this.supervisionUnit=supervisionUnit;
		return this;
	}
	
	/**
	 * 获得 监理人<br>
	 * 监理人
	 * @return 监理人
	*/
	public String getSupervisionContacts() {
		return supervisionContacts;
	}
	
	/**
	 * 设置 监理人
	 * @param supervisionContacts 监理人
	 * @return 当前对象
	*/
	public Contract setSupervisionContacts(String supervisionContacts) {
		this.supervisionContacts=supervisionContacts;
		return this;
	}
	
	/**
	 * 获得 监理联系方式<br>
	 * 监理联系方式
	 * @return 监理联系方式
	*/
	public String getSupervisionContactInformation() {
		return supervisionContactInformation;
	}
	
	/**
	 * 设置 监理联系方式
	 * @param supervisionContactInformation 监理联系方式
	 * @return 当前对象
	*/
	public Contract setSupervisionContactInformation(String supervisionContactInformation) {
		this.supervisionContactInformation=supervisionContactInformation;
		return this;
	}
	
	/**
	 * 获得 生效时间<br>
	 * 生效时间
	 * @return 生效时间
	*/
	public Date getEffectTime() {
		return effectTime;
	}
	
	/**
	 * 设置 生效时间
	 * @param effectTime 生效时间
	 * @return 当前对象
	*/
	public Contract setEffectTime(Date effectTime) {
		this.effectTime=effectTime;
		return this;
	}
	
	/**
	 * 获得 失效时间<br>
	 * 失效时间
	 * @return 失效时间
	*/
	public Date getLostEffectTime() {
		return lostEffectTime;
	}
	
	/**
	 * 设置 失效时间
	 * @param lostEffectTime 失效时间
	 * @return 当前对象
	*/
	public Contract setLostEffectTime(Date lostEffectTime) {
		this.lostEffectTime=lostEffectTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public Contract setEndTime(Date endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 签订时间<br>
	 * 签订时间
	 * @return 签订时间
	*/
	public Date getAuditTime() {
		return auditTime;
	}
	
	/**
	 * 设置 签订时间
	 * @param auditTime 签订时间
	 * @return 当前对象
	*/
	public Contract setAuditTime(Date auditTime) {
		this.auditTime=auditTime;
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
	public Contract setAttach(String attach) {
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
	public Contract setNotes(String notes) {
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
	public Contract setVersion(Integer version) {
		this.version=version;
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