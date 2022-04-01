package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-04-02 05:57:11
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class ContractTables {
	
	/**
	 * 合同表
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
		 * 合同类型，主合同，子合同、附加协议; ContractType
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","合同类型","主合同，子合同、附加协议; ContractType",false,false,true);
		
		/**
		 * 上级合同ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级合同ID","上级合同ID",false,false,true);
		
		/**
		 * 合同编号
		*/
		public static final DBField CONTRACT_NO = new DBField(DBDataType.STRING , "contract_no","contractNo","合同编号","合同编号",false,false,true);
		
		/**
		 * 合同抬头
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","合同抬头","合同抬头",false,false,true);
		
		/**
		 * 交付物
		*/
		public static final DBField DELIVERABLES = new DBField(DBDataType.STRING , "deliverables","deliverables","交付物","交付物",false,false,true);
		
		/**
		 * 交付地
		*/
		public static final DBField DELIVERY_LOCATION = new DBField(DBDataType.STRING , "delivery_location","deliveryLocation","交付地","交付地",false,false,true);
		
		/**
		 * 合同金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","合同金额","合同金额",false,false,true);
		
		/**
		 * 合同状态;枚举 ContractStatus
		*/
		public static final DBField CONTRACT_STATUS = new DBField(DBDataType.STRING , "contract_status","contractStatus","合同状态","枚举 ContractStatus",false,false,true);
		
		/**
		 * 摘要信息
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","摘要信息","摘要信息",false,false,true);
		
		/**
		 * 签订日期
		*/
		public static final DBField SIGNING_DATE = new DBField(DBDataType.DATE , "signing_date","signingDate","签订日期","签订日期",false,false,true);
		
		/**
		 * 生效日期
		*/
		public static final DBField EFFECTIVE_DATE = new DBField(DBDataType.DATE , "effective_date","effectiveDate","生效日期","生效日期",false,false,true);
		
		/**
		 * 结束日期
		*/
		public static final DBField END_DATE = new DBField(DBDataType.DATE , "end_date","endDate","结束日期","结束日期",false,false,true);
		
		/**
		 * 失效日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","失效日期","失效日期",false,false,true);
		
		/**
		 * 归属部门ID
		*/
		public static final DBField DEPARTMENT_ID = new DBField(DBDataType.STRING , "department_id","departmentId","归属部门ID","归属部门ID",false,false,true);
		
		/**
		 * 资金状态；枚举 FundingStatus
		*/
		public static final DBField FUNDING_STATUS = new DBField(DBDataType.STRING , "funding_status","fundingStatus","资金状态","枚举 FundingStatus",false,false,true);
		
		/**
		 * 资金流向，关联字典
		*/
		public static final DBField FUNDING_DIRECTION = new DBField(DBDataType.STRING , "funding_direction","fundingDirection","资金流向","关联字典",false,false,true);
		
		/**
		 * 合同分类代码，关联字典
		*/
		public static final DBField CATALOG_CODE = new DBField(DBDataType.STRING , "catalog_code","catalogCode","合同分类代码","关联字典",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CONT_CONTRACT() {
			this.init($NAME,"合同表" , ID , TYPE , PARENT_ID , CONTRACT_NO , TITLE , DELIVERABLES , DELIVERY_LOCATION , AMOUNT , CONTRACT_STATUS , SUMMARY , SIGNING_DATE , EFFECTIVE_DATE , END_DATE , EXPIRATION_DATE , DEPARTMENT_ID , FUNDING_STATUS , FUNDING_DIRECTION , CATALOG_CODE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT $TABLE=new CONT_CONTRACT();
	}
	
	/**
	 * 合同附件
	*/
	public static class CONT_CONTRACT_ATTACHMENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_attachment";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所有者ID
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所有者ID","所有者ID",false,false,true);
		
		/**
		 * 所有者类型，合同/履约情况；枚举： AttachmentOwnerType
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","所有者类型","合同/履约情况；枚举： AttachmentOwnerType",false,false,true);
		
		/**
		 * 附件类型；枚举：AttachmentType
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","附件类型","枚举：AttachmentType",false,false,true);
		
		/**
		 * 文件ID
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件ID","文件ID",false,false,true);
		
		/**
		 * 附件名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","附件名称","附件名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CONT_CONTRACT_ATTACHMENT() {
			this.init($NAME,"合同附件" , ID , OWNER_ID , OWNER_TYPE , TYPE , FILE_ID , NAME , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_ATTACHMENT $TABLE=new CONT_CONTRACT_ATTACHMENT();
	}
	
	/**
	 * 合同履行情况表
	*/
	public static class CONT_CONTRACT_PERFORMANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_performance";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 合同ID
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同ID","合同ID",false,false,true);
		
		/**
		 * 概述
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","概述","概述",false,false,true);
		
		/**
		 * 履约细节
		*/
		public static final DBField DETAIL = new DBField(DBDataType.STRING , "detail","detail","履约细节","履约细节",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 履约时间
		*/
		public static final DBField PERFORMANCE_TIME = new DBField(DBDataType.DATE , "performance_time","performanceTime","履约时间","履约时间",false,false,true);
		
		public CONT_CONTRACT_PERFORMANCE() {
			this.init($NAME,"合同履行情况表" , ID , CONTRACT_ID , TITLE , DETAIL , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PERFORMANCE_TIME);
		}
		public static final CONT_CONTRACT_PERFORMANCE $TABLE=new CONT_CONTRACT_PERFORMANCE();
	}
	
	/**
	 * 合同签订方
	*/
	public static class CONT_CONTRACT_SIGNER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_signer";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 合同ID
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同ID","合同ID",false,false,true);
		
		/**
		 * 显示顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","显示顺序","显示顺序",false,false,true);
		
		/**
		 * 别名，甲方/乙方等；枚举：SignerAlias
		*/
		public static final DBField ALIAS = new DBField(DBDataType.STRING , "alias","alias","别名","甲方/乙方等；枚举：SignerAlias",false,false,true);
		
		/**
		 * 签订方类型，企业或个人；枚举：SignerType
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","签订方类型","企业或个人；枚举：SignerType",false,false,true);
		
		/**
		 * 唯一代码，统一社会信用代码/身份证号码
		*/
		public static final DBField IDENTITY_CDOE = new DBField(DBDataType.STRING , "identity_cdoe","identityCdoe","唯一代码","统一社会信用代码/身份证号码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 座机号码
		*/
		public static final DBField LANDLINE_NUMBER = new DBField(DBDataType.STRING , "landline_number","landlineNumber","座机号码","座机号码",false,false,true);
		
		/**
		 * 传真号码
		*/
		public static final DBField FAX_NUMBER = new DBField(DBDataType.STRING , "fax_number","faxNumber","传真号码","传真号码",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 联系人姓名
		*/
		public static final DBField CONTACT_PERSON = new DBField(DBDataType.STRING , "contact_person","contactPerson","联系人姓名","联系人姓名",false,false,true);
		
		/**
		 * 联系人手机
		*/
		public static final DBField CONTACT_PHONE = new DBField(DBDataType.STRING , "contact_phone","contactPhone","联系人手机","联系人手机",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public CONT_CONTRACT_SIGNER() {
			this.init($NAME,"合同签订方" , ID , CONTRACT_ID , SORT , ALIAS , TYPE , IDENTITY_CDOE , NAME , LANDLINE_NUMBER , FAX_NUMBER , ADDRESS , CONTACT_PERSON , CONTACT_PHONE , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_SIGNER $TABLE=new CONT_CONTRACT_SIGNER();
	}
}