package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2021-12-08 11:17:04
 * @author 李方捷 , leefangjie@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class ContractTables {
	
	/**
	 * 单位
	*/
	public static class CONT_COMPANY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_company";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 单位
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","单位","单位",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACTS = new DBField(DBDataType.STRING , "contacts","contacts","联系人","联系人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 信用代码
		*/
		public static final DBField CREDIT_CODE = new DBField(DBDataType.STRING , "credit_code","creditCode","信用代码","信用代码",false,false,true);
		
		/**
		 * 介绍
		*/
		public static final DBField PROFILE = new DBField(DBDataType.STRING , "profile","profile","介绍","介绍",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_COMPANY() {
			this.init($NAME,"单位" , ID , NAME , ADDRESS , CONTACTS , CONTACT_INFORMATION , CREDIT_CODE , PROFILE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_COMPANY $TABLE=new CONT_COMPANY();
	}
	
	/**
	 * 合同
	*/
	public static class CONT_CONTRACT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 合同名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","合同名称","合同名称",false,false,true);
		
		/**
		 * 合同编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","合同编号","合同编号",false,false,true);
		
		/**
		 * 合同状态，未签订|履约中|中止|完成|作废
		*/
		public static final DBField STATE = new DBField(DBDataType.STRING , "state","state","合同状态","未签订|履约中|中止|完成|作废",false,false,true);
		
		/**
		 * 资金状态,未生效|收付中|已结清
		*/
		public static final DBField FUND_STATUS = new DBField(DBDataType.STRING , "fund_status","fundStatus","资金状态","未生效|收付中|已结清",false,false,true);
		
		/**
		 * 合同类型
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","合同类型","合同类型",false,false,true);
		
		/**
		 * 我方身份
		*/
		public static final DBField IDENTITY = new DBField(DBDataType.STRING , "identity","identity","我方身份","我方身份",false,false,true);
		
		/**
		 * 资金流向
		*/
		public static final DBField FUND_DIRECT = new DBField(DBDataType.STRING , "fund_direct","fundDirect","资金流向","资金流向",false,false,true);
		
		/**
		 * 金额
		*/
		public static final DBField MONEY = new DBField(DBDataType.DECIMAL , "money","money","金额","金额",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField ALLMONEY = new DBField(DBDataType.DECIMAL , "allmoney","allmoney","总金额","总金额",false,false,true);
		
		/**
		 * 承办人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","承办人","承办人",false,false,true);
		
		/**
		 * 承办人部门
		*/
		public static final DBField DEPT_ID = new DBField(DBDataType.STRING , "dept_id","deptId","承办人部门","承办人部门",false,false,true);
		
		/**
		 * 关联招标
		*/
		public static final DBField BIDDING_ID = new DBField(DBDataType.STRING , "bidding_id","biddingId","关联招标","关联招标",false,false,true);
		
		/**
		 * 我方单位
		*/
		public static final DBField FIRST_COMPANY_NAME = new DBField(DBDataType.STRING , "first_company_name","firstCompanyName","我方单位","我方单位",false,false,true);
		
		/**
		 * 我方联系人
		*/
		public static final DBField FIRST_CONTACTS = new DBField(DBDataType.STRING , "first_contacts","firstContacts","我方联系人","我方联系人",false,false,true);
		
		/**
		 * 我方联系方式
		*/
		public static final DBField FIRST_CONTACT_INFORMATION = new DBField(DBDataType.STRING , "first_contact_information","firstContactInformation","我方联系方式","我方联系方式",false,false,true);
		
		/**
		 * 对方单位
		*/
		public static final DBField RELATED_COMPANY_ID = new DBField(DBDataType.STRING , "related_company_id","relatedCompanyId","对方单位","对方单位",false,false,true);
		
		/**
		 * 对方单位
		*/
		public static final DBField RELATED_COMPANY_NAME = new DBField(DBDataType.STRING , "related_company_name","relatedCompanyName","对方单位","对方单位",false,false,true);
		
		/**
		 * 对方单位联系人
		*/
		public static final DBField RELATED_CONTACTS = new DBField(DBDataType.STRING , "related_contacts","relatedContacts","对方单位联系人","对方单位联系人",false,false,true);
		
		/**
		 * 对方单位联系方式
		*/
		public static final DBField RELATED_CONTACT_INFORMATION = new DBField(DBDataType.STRING , "related_contact_information","relatedContactInformation","对方单位联系方式","对方单位联系方式",false,false,true);
		
		/**
		 * 监理单位
		*/
		public static final DBField SUPERVISION_UNIT = new DBField(DBDataType.STRING , "supervision_unit","supervisionUnit","监理单位","监理单位",false,false,true);
		
		/**
		 * 监理人
		*/
		public static final DBField SUPERVISION_CONTACTS = new DBField(DBDataType.STRING , "supervision_contacts","supervisionContacts","监理人","监理人",false,false,true);
		
		/**
		 * 监理联系方式
		*/
		public static final DBField SUPERVISION_CONTACT_INFORMATION = new DBField(DBDataType.STRING , "supervision_contact_information","supervisionContactInformation","监理联系方式","监理联系方式",false,false,true);
		
		/**
		 * 生效时间
		*/
		public static final DBField EFFECT_TIME = new DBField(DBDataType.DATE , "effect_time","effectTime","生效时间","生效时间",false,false,true);
		
		/**
		 * 失效时间
		*/
		public static final DBField LOST_EFFECT_TIME = new DBField(DBDataType.DATE , "lost_effect_time","lostEffectTime","失效时间","失效时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 签订时间
		*/
		public static final DBField AUDIT_TIME = new DBField(DBDataType.DATE , "audit_time","auditTime","签订时间","签订时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_CONTRACT() {
			this.init($NAME,"合同" , ID , NAME , CODE , STATE , FUND_STATUS , CATEGORY_ID , IDENTITY , FUND_DIRECT , MONEY , ALLMONEY , USER_ID , DEPT_ID , BIDDING_ID , FIRST_COMPANY_NAME , FIRST_CONTACTS , FIRST_CONTACT_INFORMATION , RELATED_COMPANY_ID , RELATED_COMPANY_NAME , RELATED_CONTACTS , RELATED_CONTACT_INFORMATION , SUPERVISION_UNIT , SUPERVISION_CONTACTS , SUPERVISION_CONTACT_INFORMATION , EFFECT_TIME , LOST_EFFECT_TIME , END_TIME , AUDIT_TIME , ATTACH , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT $TABLE=new CONT_CONTRACT();
	}
	
	/**
	 * 合同分类
	*/
	public static class CONT_CONTRACT_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 具体名称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","具体名称","具体名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","编码","编码",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 节点路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","节点路径名称","节点路径名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_CONTRACT_CATEGORY() {
			this.init($NAME,"合同分类" , ID , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT_CATEGORY $TABLE=new CONT_CONTRACT_CATEGORY();
	}
	
	/**
	 * 资金明细
	*/
	public static class CONT_CONTRACT_FUND extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_fund";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 总金额
		*/
		public static final DBField MONEY = new DBField(DBDataType.DECIMAL , "money","money","总金额","总金额",false,false,true);
		
		/**
		 * 资金流向
		*/
		public static final DBField FUND_DIRECT = new DBField(DBDataType.STRING , "fund_direct","fundDirect","资金流向","资金流向",false,false,true);
		
		/**
		 * 收付时间
		*/
		public static final DBField RECEIPT_PAYMENT_TIME = new DBField(DBDataType.DATE , "receipt_payment_time","receiptPaymentTime","收付时间","收付时间",false,false,true);
		
		/**
		 * 发票
		*/
		public static final DBField INVOICE_ID = new DBField(DBDataType.STRING , "invoice_id","invoiceId","发票","发票",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * tenant_id
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","tenant","id",false,false,true);
		
		public CONT_CONTRACT_FUND() {
			this.init($NAME,"资金明细" , ID , MONEY , FUND_DIRECT , RECEIPT_PAYMENT_TIME , INVOICE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT_FUND $TABLE=new CONT_CONTRACT_FUND();
	}
	
	/**
	 * 合同发票
	*/
	public static class CONT_CONTRACT_INVOICE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_invoice";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 发票
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","发票","发票",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_CONTRACT_INVOICE() {
			this.init($NAME,"合同发票" , ID , ATTACH , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT_INVOICE $TABLE=new CONT_CONTRACT_INVOICE();
	}
	
	/**
	 * 单位
	*/
	public static class CONT_UNIT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_unit";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 单位名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","单位名称","单位名称",false,false,true);
		
		/**
		 * 社会统一代码
		*/
		public static final DBField SOCIAL_UNIFIED_CODE = new DBField(DBDataType.STRING , "social_unified_code","socialUnifiedCode","社会统一代码","社会统一代码",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACTS = new DBField(DBDataType.STRING , "contacts","contacts","联系人","联系人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT = new DBField(DBDataType.STRING , "contact","contact","联系方式","联系方式",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_UNIT() {
			this.init($NAME,"单位" , ID , NAME , SOCIAL_UNIFIED_CODE , CONTACTS , CONTACT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_UNIT $TABLE=new CONT_UNIT();
	}
}