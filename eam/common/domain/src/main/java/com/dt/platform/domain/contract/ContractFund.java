package com.dt.platform.domain.contract;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.CONT_CONTRACT_FUND;
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
 * @since 2021-09-05 12:20:36
 * @sign C7E67FF022A95A22B5A8F959B56493E3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "cont_contract_fund")
public class ContractFund extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CONT_CONTRACT_FUND.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 总金额：总金额
	*/
	@ApiModelProperty(required = false,value="总金额" , notes = "总金额")
	private BigDecimal money;
	
	/**
	 * 资金流向：资金流向
	*/
	@ApiModelProperty(required = false,value="资金流向" , notes = "资金流向")
	private String fundDirect;
	
	/**
	 * 收付时间：收付时间
	*/
	@ApiModelProperty(required = false,value="收付时间" , notes = "收付时间")
	private Date receiptPaymentTime;
	
	/**
	 * 发票：发票
	*/
	@ApiModelProperty(required = false,value="发票" , notes = "发票")
	private String invoiceId;
	
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
	public ContractFund setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 总金额<br>
	 * 总金额
	 * @return 总金额
	*/
	public BigDecimal getMoney() {
		return money;
	}
	
	/**
	 * 设置 总金额
	 * @param money 总金额
	 * @return 当前对象
	*/
	public ContractFund setMoney(BigDecimal money) {
		this.money=money;
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
	public ContractFund setFundDirect(String fundDirect) {
		this.fundDirect=fundDirect;
		return this;
	}
	
	/**
	 * 获得 收付时间<br>
	 * 收付时间
	 * @return 收付时间
	*/
	public Date getReceiptPaymentTime() {
		return receiptPaymentTime;
	}
	
	/**
	 * 设置 收付时间
	 * @param receiptPaymentTime 收付时间
	 * @return 当前对象
	*/
	public ContractFund setReceiptPaymentTime(Date receiptPaymentTime) {
		this.receiptPaymentTime=receiptPaymentTime;
		return this;
	}
	
	/**
	 * 获得 发票<br>
	 * 发票
	 * @return 发票
	*/
	public String getInvoiceId() {
		return invoiceId;
	}
	
	/**
	 * 设置 发票
	 * @param invoiceId 发票
	 * @return 当前对象
	*/
	public ContractFund setInvoiceId(String invoiceId) {
		this.invoiceId=invoiceId;
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
	public ContractFund setNotes(String notes) {
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
	public ContractFund setCreateBy(String createBy) {
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
	public ContractFund setCreateTime(Date createTime) {
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
	public ContractFund setUpdateBy(String updateBy) {
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
	public ContractFund setUpdateTime(Date updateTime) {
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
	public ContractFund setDeleted(Integer deleted) {
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
	public ContractFund setDeleteBy(String deleteBy) {
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
	public ContractFund setDeleteTime(Date deleteTime) {
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
	public ContractFund setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ContractFund , 转换好的 ContractFund 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ContractFund , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ContractFund
	 * @param contractFundMap 包含实体信息的 Map 对象
	 * @return ContractFund , 转换好的的 ContractFund 对象
	*/
	@Transient
	public static ContractFund createFrom(Map<String,Object> contractFundMap) {
		if(contractFundMap==null) return null;
		ContractFund po = EntityContext.create(ContractFund.class, contractFundMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ContractFund
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ContractFund , 转换好的的 ContractFund 对象
	*/
	@Transient
	public static ContractFund createFrom(Object pojo) {
		if(pojo==null) return null;
		ContractFund po = EntityContext.create(ContractFund.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ContractFund，等同于 new
	 * @return ContractFund 对象
	*/
	@Transient
	public static ContractFund create() {
		return EntityContext.create(ContractFund.class);
	}
}