package com.dt.platform.domain.contract.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.contract.Contract;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 11:17:21
 * @sign E0EB3189ECCC4E6D040AF1CEFDF509A2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ContractMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 合同名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 合同名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,NAME, java.lang.String.class, "合同名称", "合同名称", java.lang.String.class, null);
	
	/**
	 * 合同编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 合同编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,CODE, java.lang.String.class, "合同编号", "合同编号", java.lang.String.class, null);
	
	/**
	 * 合同状态 , 未签订|履约中|中止|完成|作废 , 类型: java.lang.String
	*/
	public static final String STATE="state";
	
	/**
	 * 合同状态 , 未签订|履约中|中止|完成|作废 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> STATE_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,STATE, java.lang.String.class, "合同状态", "未签订|履约中|中止|完成|作废", java.lang.String.class, null);
	
	/**
	 * 资金状态 , 未生效|收付中|已结清 , 类型: java.lang.String
	*/
	public static final String FUND_STATUS="fundStatus";
	
	/**
	 * 资金状态 , 未生效|收付中|已结清 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> FUND_STATUS_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,FUND_STATUS, java.lang.String.class, "资金状态", "未生效|收付中|已结清", java.lang.String.class, null);
	
	/**
	 * 合同类型 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 合同类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,CATEGORY_ID, java.lang.String.class, "合同类型", "合同类型", java.lang.String.class, null);
	
	/**
	 * 我方身份 , 类型: java.lang.String
	*/
	public static final String IDENTITY="identity";
	
	/**
	 * 我方身份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> IDENTITY_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,IDENTITY, java.lang.String.class, "我方身份", "我方身份", java.lang.String.class, null);
	
	/**
	 * 资金流向 , 类型: java.lang.String
	*/
	public static final String FUND_DIRECT="fundDirect";
	
	/**
	 * 资金流向 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> FUND_DIRECT_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,FUND_DIRECT, java.lang.String.class, "资金流向", "资金流向", java.lang.String.class, null);
	
	/**
	 * 金额 , 类型: java.math.BigDecimal
	*/
	public static final String MONEY="money";
	
	/**
	 * 金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.math.BigDecimal> MONEY_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,MONEY, java.math.BigDecimal.class, "金额", "金额", java.math.BigDecimal.class, null);
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final String ALLMONEY="allmoney";
	
	/**
	 * 总金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.math.BigDecimal> ALLMONEY_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,ALLMONEY, java.math.BigDecimal.class, "总金额", "总金额", java.math.BigDecimal.class, null);
	
	/**
	 * 承办人 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 承办人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,USER_ID, java.lang.String.class, "承办人", "承办人", java.lang.String.class, null);
	
	/**
	 * 承办人部门 , 类型: java.lang.String
	*/
	public static final String DEPT_ID="deptId";
	
	/**
	 * 承办人部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> DEPT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,DEPT_ID, java.lang.String.class, "承办人部门", "承办人部门", java.lang.String.class, null);
	
	/**
	 * 关联招标 , 类型: java.lang.String
	*/
	public static final String BIDDING_ID="biddingId";
	
	/**
	 * 关联招标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> BIDDING_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,BIDDING_ID, java.lang.String.class, "关联招标", "关联招标", java.lang.String.class, null);
	
	/**
	 * 我方单位 , 类型: java.lang.String
	*/
	public static final String FIRST_COMPANY_NAME="firstCompanyName";
	
	/**
	 * 我方单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> FIRST_COMPANY_NAME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,FIRST_COMPANY_NAME, java.lang.String.class, "我方单位", "我方单位", java.lang.String.class, null);
	
	/**
	 * 我方联系人 , 类型: java.lang.String
	*/
	public static final String FIRST_CONTACTS="firstContacts";
	
	/**
	 * 我方联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> FIRST_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,FIRST_CONTACTS, java.lang.String.class, "我方联系人", "我方联系人", java.lang.String.class, null);
	
	/**
	 * 我方联系方式 , 类型: java.lang.String
	*/
	public static final String FIRST_CONTACT_INFORMATION="firstContactInformation";
	
	/**
	 * 我方联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> FIRST_CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,FIRST_CONTACT_INFORMATION, java.lang.String.class, "我方联系方式", "我方联系方式", java.lang.String.class, null);
	
	/**
	 * 对方单位 , 类型: java.lang.String
	*/
	public static final String RELATED_COMPANY_ID="relatedCompanyId";
	
	/**
	 * 对方单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> RELATED_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,RELATED_COMPANY_ID, java.lang.String.class, "对方单位", "对方单位", java.lang.String.class, null);
	
	/**
	 * 对方单位 , 类型: java.lang.String
	*/
	public static final String RELATED_COMPANY_NAME="relatedCompanyName";
	
	/**
	 * 对方单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> RELATED_COMPANY_NAME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,RELATED_COMPANY_NAME, java.lang.String.class, "对方单位", "对方单位", java.lang.String.class, null);
	
	/**
	 * 对方单位联系人 , 类型: java.lang.String
	*/
	public static final String RELATED_CONTACTS="relatedContacts";
	
	/**
	 * 对方单位联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> RELATED_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,RELATED_CONTACTS, java.lang.String.class, "对方单位联系人", "对方单位联系人", java.lang.String.class, null);
	
	/**
	 * 对方单位联系方式 , 类型: java.lang.String
	*/
	public static final String RELATED_CONTACT_INFORMATION="relatedContactInformation";
	
	/**
	 * 对方单位联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> RELATED_CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,RELATED_CONTACT_INFORMATION, java.lang.String.class, "对方单位联系方式", "对方单位联系方式", java.lang.String.class, null);
	
	/**
	 * 监理单位 , 类型: java.lang.String
	*/
	public static final String SUPERVISION_UNIT="supervisionUnit";
	
	/**
	 * 监理单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> SUPERVISION_UNIT_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,SUPERVISION_UNIT, java.lang.String.class, "监理单位", "监理单位", java.lang.String.class, null);
	
	/**
	 * 监理人 , 类型: java.lang.String
	*/
	public static final String SUPERVISION_CONTACTS="supervisionContacts";
	
	/**
	 * 监理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> SUPERVISION_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,SUPERVISION_CONTACTS, java.lang.String.class, "监理人", "监理人", java.lang.String.class, null);
	
	/**
	 * 监理联系方式 , 类型: java.lang.String
	*/
	public static final String SUPERVISION_CONTACT_INFORMATION="supervisionContactInformation";
	
	/**
	 * 监理联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> SUPERVISION_CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,SUPERVISION_CONTACT_INFORMATION, java.lang.String.class, "监理联系方式", "监理联系方式", java.lang.String.class, null);
	
	/**
	 * 生效时间 , 类型: java.util.Date
	*/
	public static final String EFFECT_TIME="effectTime";
	
	/**
	 * 生效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.util.Date> EFFECT_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,EFFECT_TIME, java.util.Date.class, "生效时间", "生效时间", java.util.Date.class, null);
	
	/**
	 * 失效时间 , 类型: java.util.Date
	*/
	public static final String LOST_EFFECT_TIME="lostEffectTime";
	
	/**
	 * 失效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.util.Date> LOST_EFFECT_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,LOST_EFFECT_TIME, java.util.Date.class, "失效时间", "失效时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.util.Date> END_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,END_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 签订时间 , 类型: java.util.Date
	*/
	public static final String AUDIT_TIME="auditTime";
	
	/**
	 * 签订时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.util.Date> AUDIT_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,AUDIT_TIME, java.util.Date.class, "签订时间", "签订时间", java.util.Date.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.Contract,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.Contract.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , CODE , STATE , FUND_STATUS , CATEGORY_ID , IDENTITY , FUND_DIRECT , MONEY , ALLMONEY , USER_ID , DEPT_ID , BIDDING_ID , FIRST_COMPANY_NAME , FIRST_CONTACTS , FIRST_CONTACT_INFORMATION , RELATED_COMPANY_ID , RELATED_COMPANY_NAME , RELATED_CONTACTS , RELATED_CONTACT_INFORMATION , SUPERVISION_UNIT , SUPERVISION_CONTACTS , SUPERVISION_CONTACT_INFORMATION , EFFECT_TIME , LOST_EFFECT_TIME , END_TIME , AUDIT_TIME , ATTACH , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.contract.Contract {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Contract setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 合同名称
		 * @param name 合同名称
		 * @return 当前对象
		*/
		public Contract setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 合同编号
		 * @param code 合同编号
		 * @return 当前对象
		*/
		public Contract setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 合同状态
		 * @param state 合同状态
		 * @return 当前对象
		*/
		public Contract setState(String state) {
			super.change(STATE,super.getState(),state);
			super.setState(state);
			return this;
		}
		
		/**
		 * 设置 资金状态
		 * @param fundStatus 资金状态
		 * @return 当前对象
		*/
		public Contract setFundStatus(String fundStatus) {
			super.change(FUND_STATUS,super.getFundStatus(),fundStatus);
			super.setFundStatus(fundStatus);
			return this;
		}
		
		/**
		 * 设置 合同类型
		 * @param categoryId 合同类型
		 * @return 当前对象
		*/
		public Contract setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 我方身份
		 * @param identity 我方身份
		 * @return 当前对象
		*/
		public Contract setIdentity(String identity) {
			super.change(IDENTITY,super.getIdentity(),identity);
			super.setIdentity(identity);
			return this;
		}
		
		/**
		 * 设置 资金流向
		 * @param fundDirect 资金流向
		 * @return 当前对象
		*/
		public Contract setFundDirect(String fundDirect) {
			super.change(FUND_DIRECT,super.getFundDirect(),fundDirect);
			super.setFundDirect(fundDirect);
			return this;
		}
		
		/**
		 * 设置 金额
		 * @param money 金额
		 * @return 当前对象
		*/
		public Contract setMoney(BigDecimal money) {
			super.change(MONEY,super.getMoney(),money);
			super.setMoney(money);
			return this;
		}
		
		/**
		 * 设置 总金额
		 * @param allmoney 总金额
		 * @return 当前对象
		*/
		public Contract setAllmoney(BigDecimal allmoney) {
			super.change(ALLMONEY,super.getAllmoney(),allmoney);
			super.setAllmoney(allmoney);
			return this;
		}
		
		/**
		 * 设置 承办人
		 * @param userId 承办人
		 * @return 当前对象
		*/
		public Contract setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 承办人部门
		 * @param deptId 承办人部门
		 * @return 当前对象
		*/
		public Contract setDeptId(String deptId) {
			super.change(DEPT_ID,super.getDeptId(),deptId);
			super.setDeptId(deptId);
			return this;
		}
		
		/**
		 * 设置 关联招标
		 * @param biddingId 关联招标
		 * @return 当前对象
		*/
		public Contract setBiddingId(String biddingId) {
			super.change(BIDDING_ID,super.getBiddingId(),biddingId);
			super.setBiddingId(biddingId);
			return this;
		}
		
		/**
		 * 设置 我方单位
		 * @param firstCompanyName 我方单位
		 * @return 当前对象
		*/
		public Contract setFirstCompanyName(String firstCompanyName) {
			super.change(FIRST_COMPANY_NAME,super.getFirstCompanyName(),firstCompanyName);
			super.setFirstCompanyName(firstCompanyName);
			return this;
		}
		
		/**
		 * 设置 我方联系人
		 * @param firstContacts 我方联系人
		 * @return 当前对象
		*/
		public Contract setFirstContacts(String firstContacts) {
			super.change(FIRST_CONTACTS,super.getFirstContacts(),firstContacts);
			super.setFirstContacts(firstContacts);
			return this;
		}
		
		/**
		 * 设置 我方联系方式
		 * @param firstContactInformation 我方联系方式
		 * @return 当前对象
		*/
		public Contract setFirstContactInformation(String firstContactInformation) {
			super.change(FIRST_CONTACT_INFORMATION,super.getFirstContactInformation(),firstContactInformation);
			super.setFirstContactInformation(firstContactInformation);
			return this;
		}
		
		/**
		 * 设置 对方单位
		 * @param relatedCompanyId 对方单位
		 * @return 当前对象
		*/
		public Contract setRelatedCompanyId(String relatedCompanyId) {
			super.change(RELATED_COMPANY_ID,super.getRelatedCompanyId(),relatedCompanyId);
			super.setRelatedCompanyId(relatedCompanyId);
			return this;
		}
		
		/**
		 * 设置 对方单位
		 * @param relatedCompanyName 对方单位
		 * @return 当前对象
		*/
		public Contract setRelatedCompanyName(String relatedCompanyName) {
			super.change(RELATED_COMPANY_NAME,super.getRelatedCompanyName(),relatedCompanyName);
			super.setRelatedCompanyName(relatedCompanyName);
			return this;
		}
		
		/**
		 * 设置 对方单位联系人
		 * @param relatedContacts 对方单位联系人
		 * @return 当前对象
		*/
		public Contract setRelatedContacts(String relatedContacts) {
			super.change(RELATED_CONTACTS,super.getRelatedContacts(),relatedContacts);
			super.setRelatedContacts(relatedContacts);
			return this;
		}
		
		/**
		 * 设置 对方单位联系方式
		 * @param relatedContactInformation 对方单位联系方式
		 * @return 当前对象
		*/
		public Contract setRelatedContactInformation(String relatedContactInformation) {
			super.change(RELATED_CONTACT_INFORMATION,super.getRelatedContactInformation(),relatedContactInformation);
			super.setRelatedContactInformation(relatedContactInformation);
			return this;
		}
		
		/**
		 * 设置 监理单位
		 * @param supervisionUnit 监理单位
		 * @return 当前对象
		*/
		public Contract setSupervisionUnit(String supervisionUnit) {
			super.change(SUPERVISION_UNIT,super.getSupervisionUnit(),supervisionUnit);
			super.setSupervisionUnit(supervisionUnit);
			return this;
		}
		
		/**
		 * 设置 监理人
		 * @param supervisionContacts 监理人
		 * @return 当前对象
		*/
		public Contract setSupervisionContacts(String supervisionContacts) {
			super.change(SUPERVISION_CONTACTS,super.getSupervisionContacts(),supervisionContacts);
			super.setSupervisionContacts(supervisionContacts);
			return this;
		}
		
		/**
		 * 设置 监理联系方式
		 * @param supervisionContactInformation 监理联系方式
		 * @return 当前对象
		*/
		public Contract setSupervisionContactInformation(String supervisionContactInformation) {
			super.change(SUPERVISION_CONTACT_INFORMATION,super.getSupervisionContactInformation(),supervisionContactInformation);
			super.setSupervisionContactInformation(supervisionContactInformation);
			return this;
		}
		
		/**
		 * 设置 生效时间
		 * @param effectTime 生效时间
		 * @return 当前对象
		*/
		public Contract setEffectTime(Date effectTime) {
			super.change(EFFECT_TIME,super.getEffectTime(),effectTime);
			super.setEffectTime(effectTime);
			return this;
		}
		
		/**
		 * 设置 失效时间
		 * @param lostEffectTime 失效时间
		 * @return 当前对象
		*/
		public Contract setLostEffectTime(Date lostEffectTime) {
			super.change(LOST_EFFECT_TIME,super.getLostEffectTime(),lostEffectTime);
			super.setLostEffectTime(lostEffectTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endTime 结束时间
		 * @return 当前对象
		*/
		public Contract setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 签订时间
		 * @param auditTime 签订时间
		 * @return 当前对象
		*/
		public Contract setAuditTime(Date auditTime) {
			super.change(AUDIT_TIME,super.getAuditTime(),auditTime);
			super.setAuditTime(auditTime);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public Contract setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Contract setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Contract setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Contract setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Contract setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Contract setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Contract setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Contract setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Contract setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Contract setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Contract setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
	}
}