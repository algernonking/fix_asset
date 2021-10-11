package com.dt.platform.domain.contract.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.contract.ContractFund;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 02:48:16
 * @sign 5F0799953897372D392AAABC3E5D731F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ContractFundMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final String MONEY="money";
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.math.BigDecimal> MONEY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,MONEY, java.math.BigDecimal.class, "总金额", "总金额", java.math.BigDecimal.class, null);
	
	/**
	 * 资金流向 , 类型: java.lang.String
	*/
	public static final String FUND_DIRECT="fundDirect";
	
	/**
	 * 资金流向 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> FUND_DIRECT_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,FUND_DIRECT, java.lang.String.class, "资金流向", "资金流向", java.lang.String.class, null);
	
	/**
	 * 收付时间 , 类型: java.util.Date
	*/
	public static final String RECEIPT_PAYMENT_TIME="receiptPaymentTime";
	
	/**
	 * 收付时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.util.Date> RECEIPT_PAYMENT_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,RECEIPT_PAYMENT_TIME, java.util.Date.class, "收付时间", "收付时间", java.util.Date.class, null);
	
	/**
	 * 发票 , 类型: java.lang.String
	*/
	public static final String INVOICE_ID="invoiceId";
	
	/**
	 * 发票 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> INVOICE_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,INVOICE_ID, java.lang.String.class, "发票", "发票", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * tenant , id , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * tenant , id , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractFund,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractFund.class ,TENANT_ID, java.lang.String.class, "tenant", "id", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MONEY , FUND_DIRECT , RECEIPT_PAYMENT_TIME , INVOICE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.contract.ContractFund {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ContractFund setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 总金额
		 * @param money 总金额
		 * @return 当前对象
		*/
		public ContractFund setMoney(BigDecimal money) {
			super.change(MONEY,super.getMoney(),money);
			super.setMoney(money);
			return this;
		}
		
		/**
		 * 设置 资金流向
		 * @param fundDirect 资金流向
		 * @return 当前对象
		*/
		public ContractFund setFundDirect(String fundDirect) {
			super.change(FUND_DIRECT,super.getFundDirect(),fundDirect);
			super.setFundDirect(fundDirect);
			return this;
		}
		
		/**
		 * 设置 收付时间
		 * @param receiptPaymentTime 收付时间
		 * @return 当前对象
		*/
		public ContractFund setReceiptPaymentTime(Date receiptPaymentTime) {
			super.change(RECEIPT_PAYMENT_TIME,super.getReceiptPaymentTime(),receiptPaymentTime);
			super.setReceiptPaymentTime(receiptPaymentTime);
			return this;
		}
		
		/**
		 * 设置 发票
		 * @param invoiceId 发票
		 * @return 当前对象
		*/
		public ContractFund setInvoiceId(String invoiceId) {
			super.change(INVOICE_ID,super.getInvoiceId(),invoiceId);
			super.setInvoiceId(invoiceId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ContractFund setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ContractFund setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ContractFund setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ContractFund setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ContractFund setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ContractFund setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ContractFund setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ContractFund setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ContractFund setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 tenant
		 * @param tenantId tenant
		 * @return 当前对象
		*/
		public ContractFund setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
	}
}