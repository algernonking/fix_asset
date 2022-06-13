package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-06-13 11:02:03
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class EAMTables {
	
	/**
	 * 执行动作
	*/
	public static class EAM_ACTION_CRONTAB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_action_crontab";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属于
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属于","所属于",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 表达式
		*/
		public static final DBField CRONTAB = new DBField(DBDataType.STRING , "crontab","crontab","表达式","表达式",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_EXECUTION_TIME = new DBField(DBDataType.DATE , "start_execution_time","startExecutionTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField FINISH_EXECUTION_TIME = new DBField(DBDataType.DATE , "finish_execution_time","finishExecutionTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 上次执行时间
		*/
		public static final DBField LAST_EXECUTION_TIME = new DBField(DBDataType.DATE , "last_execution_time","lastExecutionTime","上次执行时间","上次执行时间",false,false,true);
		
		/**
		 * 下次执行时间
		*/
		public static final DBField NEXT_EXECUTION_TIME = new DBField(DBDataType.DATE , "next_execution_time","nextExecutionTime","下次执行时间","下次执行时间",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_ACTION_CRONTAB() {
			this.init($NAME,"执行动作" , ID , OWNER_ID , NAME , CRONTAB , START_EXECUTION_TIME , FINISH_EXECUTION_TIME , LAST_EXECUTION_TIME , NEXT_EXECUTION_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_ACTION_CRONTAB $TABLE=new EAM_ACTION_CRONTAB();
	}
	
	/**
	 * 日志
	*/
	public static class EAM_ACTION_CRONTAB_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_action_crontab_log";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * crontab
		*/
		public static final DBField CRONTAB_ID = new DBField(DBDataType.STRING , "crontab_id","crontabId","crontab","crontab",false,false,true);
		
		/**
		 * 执行结果
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","执行结果","执行结果",false,false,true);
		
		/**
		 * 结果内容
		*/
		public static final DBField EXECUTION_RESULT = new DBField(DBDataType.STRING , "execution_result","executionResult","结果内容","结果内容",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
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
		
		public EAM_ACTION_CRONTAB_LOG() {
			this.init($NAME,"日志" , ID , CRONTAB_ID , RESULT , EXECUTION_RESULT , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ACTION_CRONTAB_LOG $TABLE=new EAM_ACTION_CRONTAB_LOG();
	}
	
	/**
	 * 资产审批配置
	*/
	public static class EAM_APPROVE_CONFIGURE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_approve_configure";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 审批类型
		*/
		public static final DBField APPROVAL_TYPE = new DBField(DBDataType.STRING , "approval_type","approvalType","审批类型","审批类型",false,false,true);
		
		/**
		 * 审批状态
		*/
		public static final DBField APPROVAL_STATUS = new DBField(DBDataType.STRING , "approval_status","approvalStatus","审批状态","审批状态",false,false,true);
		
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
		
		public EAM_APPROVE_CONFIGURE() {
			this.init($NAME,"资产审批配置" , ID , NAME , APPROVAL_TYPE , APPROVAL_STATUS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_APPROVE_CONFIGURE $TABLE=new EAM_APPROVE_CONFIGURE();
	}
	
	/**
	 * 资产审批角色
	*/
	public static class EAM_APPROVE_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_approve_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		
		public EAM_APPROVE_ROLE() {
			this.init($NAME,"资产审批角色" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_APPROVE_ROLE $TABLE=new EAM_APPROVE_ROLE();
	}
	
	/**
	 * 资产
	*/
	public static class EAM_ASSET extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","资产分类","资产分类",false,false,true);
		
		/**
		 * 分类编码
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","分类编码","分类编码",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 批次编码
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次编码","批次编码",false,false,true);
		
		/**
		 * 归属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","归属","归属",false,false,true);
		
		/**
		 * 资产编号
		*/
		public static final DBField ASSET_CODE = new DBField(DBDataType.STRING , "asset_code","assetCode","资产编号","资产编号",false,false,true);
		
		/**
		 * 资产状态
		*/
		public static final DBField ASSET_STATUS = new DBField(DBDataType.STRING , "asset_status","assetStatus","资产状态","资产状态",false,false,true);
		
		/**
		 * 是否显示
		*/
		public static final DBField DISPLAY = new DBField(DBDataType.STRING , "display","display","是否显示","是否显示",false,false,true);
		
		/**
		 * 是否清理
		*/
		public static final DBField CLEAN_OUT = new DBField(DBDataType.STRING , "clean_out","cleanOut","是否清理","是否清理",false,false,true);
		
		/**
		 * 标准物品档案
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","标准物品档案","标准物品档案",false,false,true);
		
		/**
		 * 标准型号资产名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标准型号资产名称","标准型号资产名称",false,false,true);
		
		/**
		 * 标准型号厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","标准型号厂商","标准型号厂商",false,false,true);
		
		/**
		 * 标准型号规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","标准型号规格型号","标准型号规格型号",false,false,true);
		
		/**
		 * 标准型号物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","标准型号物品图片","标准型号物品图片",false,false,true);
		
		/**
		 * 标准型号计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","标准型号计量单位","标准型号计量单位",false,false,true);
		
		/**
		 * 使用期限(月)
		*/
		public static final DBField SERVICE_LIFE = new DBField(DBDataType.DECIMAL , "service_life","serviceLife","使用期限(月)","使用期限(月)",false,false,true);
		
		/**
		 * 安全等级
		*/
		public static final DBField SAFETY_LEVEL_CODE = new DBField(DBDataType.STRING , "safety_level_code","safetyLevelCode","安全等级","安全等级",false,false,true);
		
		/**
		 * 序列号
		*/
		public static final DBField SERIAL_NUMBER = new DBField(DBDataType.STRING , "serial_number","serialNumber","序列号","序列号",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 管理人员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人员","管理人员",false,false,true);
		
		/**
		 * 使用公司/部门
		*/
		public static final DBField USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "use_organization_id","useOrganizationId","使用公司/部门","使用公司/部门",false,false,true);
		
		/**
		 * 使用人员
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","使用人员","使用人员",false,false,true);
		
		/**
		 * 存放位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","存放位置","存放位置",false,false,true);
		
		/**
		 * 详细位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","详细位置","详细位置",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 库存物品
		*/
		public static final DBField GOODS_STOCK_ID = new DBField(DBDataType.STRING , "goods_stock_id","goodsStockId","库存物品","库存物品",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 资产数量
		*/
		public static final DBField ASSET_NUMBER = new DBField(DBDataType.INTEGER , "asset_number","assetNumber","资产数量","资产数量",false,false,true);
		
		/**
		 * 剩余数量
		*/
		public static final DBField REMAIN_NUMBER = new DBField(DBDataType.INTEGER , "remain_number","remainNumber","剩余数量","剩余数量",false,false,true);
		
		/**
		 * 购置日期
		*/
		public static final DBField PURCHASE_DATE = new DBField(DBDataType.DATE , "purchase_date","purchaseDate","购置日期","购置日期",false,false,true);
		
		/**
		 * 生产日期
		*/
		public static final DBField PRODUCTION_DATE = new DBField(DBDataType.DATE , "production_date","productionDate","生产日期","生产日期",false,false,true);
		
		/**
		 * 登记时间
		*/
		public static final DBField REGISTER_DATE = new DBField(DBDataType.DATE , "register_date","registerDate","登记时间","登记时间",false,false,true);
		
		/**
		 * RFID标签
		*/
		public static final DBField RFID = new DBField(DBDataType.STRING , "rfid","rfid","RFID标签","RFID标签",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 最近核对日期
		*/
		public static final DBField LAST_VERIFICATION_DATE = new DBField(DBDataType.DATE , "last_verification_date","lastVerificationDate","最近核对日期","最近核对日期",false,false,true);
		
		/**
		 * 用途
		*/
		public static final DBField PURPOSE = new DBField(DBDataType.STRING , "purpose","purpose","用途","用途",false,false,true);
		
		/**
		 * 资产备注
		*/
		public static final DBField ASSET_NOTES = new DBField(DBDataType.STRING , "asset_notes","assetNotes","资产备注","资产备注",false,false,true);
		
		/**
		 * 维保厂商
		*/
		public static final DBField MAINTAINER_ID = new DBField(DBDataType.STRING , "maintainer_id","maintainerId","维保厂商","维保厂商",false,false,true);
		
		/**
		 * 维保厂商
		*/
		public static final DBField MAINTAINER_NAME = new DBField(DBDataType.STRING , "maintainer_name","maintainerName","维保厂商","维保厂商",false,false,true);
		
		/**
		 * 维保状态
		*/
		public static final DBField MAINTENANCE_STATUS = new DBField(DBDataType.STRING , "maintenance_status","maintenanceStatus","维保状态","维保状态",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACTS = new DBField(DBDataType.STRING , "contacts","contacts","联系人","联系人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField DIRECTOR = new DBField(DBDataType.STRING , "director","director","负责人","负责人",false,false,true);
		
		/**
		 * 维保开始时间
		*/
		public static final DBField MAINTENANCE_START_DATE = new DBField(DBDataType.DATE , "maintenance_start_date","maintenanceStartDate","维保开始时间","维保开始时间",false,false,true);
		
		/**
		 * 维保到期时间
		*/
		public static final DBField MAINTENANCE_END_DATE = new DBField(DBDataType.DATE , "maintenance_end_date","maintenanceEndDate","维保到期时间","维保到期时间",false,false,true);
		
		/**
		 * 维保备注
		*/
		public static final DBField MAINTENANCE_NOTES = new DBField(DBDataType.STRING , "maintenance_notes","maintenanceNotes","维保备注","维保备注",false,false,true);
		
		/**
		 * 财务分类
		*/
		public static final DBField FINANCIAL_CATEGORY_ID = new DBField(DBDataType.STRING , "financial_category_id","financialCategoryId","财务分类","财务分类",false,false,true);
		
		/**
		 * 财务编号
		*/
		public static final DBField FINANCIAL_CODE = new DBField(DBDataType.STRING , "financial_code","financialCode","财务编号","财务编号",false,false,true);
		
		/**
		 * 资产供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","资产供应商","资产供应商",false,false,true);
		
		/**
		 * 税额
		*/
		public static final DBField TAX_AMOUNT_RATE = new DBField(DBDataType.DECIMAL , "tax_amount_rate","taxAmountRate","税额","税额",false,false,true);
		
		/**
		 * 含税金额
		*/
		public static final DBField TAX_AMOUNT_PRICE = new DBField(DBDataType.DECIMAL , "tax_amount_price","taxAmountPrice","含税金额","含税金额",false,false,true);
		
		/**
		 * 资产总值
		*/
		public static final DBField TOTAL_AMOUNT_PRICE = new DBField(DBDataType.DECIMAL , "total_amount_price","totalAmountPrice","资产总值","资产总值",false,false,true);
		
		/**
		 * 资产原值(单价)
		*/
		public static final DBField ORIGINAL_UNIT_PRICE = new DBField(DBDataType.DECIMAL , "original_unit_price","originalUnitPrice","资产原值(单价)","资产原值(单价)",false,false,true);
		
		/**
		 * 累计折旧
		*/
		public static final DBField ACCUMULATED_DEPRECIATION = new DBField(DBDataType.DECIMAL , "accumulated_depreciation","accumulatedDepreciation","累计折旧","累计折旧",false,false,true);
		
		/**
		 * 残值率
		*/
		public static final DBField RESIDUALS_RATE = new DBField(DBDataType.DECIMAL , "residuals_rate","residualsRate","残值率","残值率",false,false,true);
		
		/**
		 * 资产净值
		*/
		public static final DBField NAV_PRICE = new DBField(DBDataType.DECIMAL , "nav_price","navPrice","资产净值","资产净值",false,false,true);
		
		/**
		 * 采购单价
		*/
		public static final DBField PURCHASE_UNIT_PRICE = new DBField(DBDataType.DECIMAL , "purchase_unit_price","purchaseUnitPrice","采购单价","采购单价",false,false,true);
		
		/**
		 * 入账时间
		*/
		public static final DBField ENTRY_TIME = new DBField(DBDataType.DATE , "entry_time","entryTime","入账时间","入账时间",false,false,true);
		
		/**
		 * 财务备注
		*/
		public static final DBField FINANCIAL_NOTES = new DBField(DBDataType.STRING , "financial_notes","financialNotes","财务备注","财务备注",false,false,true);
		
		/**
		 * 设备编号
		*/
		public static final DBField EQUIPMENT_CODE = new DBField(DBDataType.STRING , "equipment_code","equipmentCode","设备编号","设备编号",false,false,true);
		
		/**
		 * 设备状态
		*/
		public static final DBField EQUIPMENT_STATUS = new DBField(DBDataType.STRING , "equipment_status","equipmentStatus","设备状态","设备状态",false,false,true);
		
		/**
		 * 设备IP
		*/
		public static final DBField EQUIPMENT_IP = new DBField(DBDataType.STRING , "equipment_ip","equipmentIp","设备IP","设备IP",false,false,true);
		
		/**
		 * 管理IP
		*/
		public static final DBField MANAGE_IP = new DBField(DBDataType.STRING , "manage_ip","manageIp","管理IP","管理IP",false,false,true);
		
		/**
		 * 设备CPU
		*/
		public static final DBField EQUIPMENT_CPU = new DBField(DBDataType.STRING , "equipment_cpu","equipmentCpu","设备CPU","设备CPU",false,false,true);
		
		/**
		 * 设备内存
		*/
		public static final DBField EQUIPMENT_MEMORY = new DBField(DBDataType.STRING , "equipment_memory","equipmentMemory","设备内存","设备内存",false,false,true);
		
		/**
		 * 设备标签
		*/
		public static final DBField EQUIPMENT_LABEL = new DBField(DBDataType.STRING , "equipment_label","equipmentLabel","设备标签","设备标签",false,false,true);
		
		/**
		 * 设备配置
		*/
		public static final DBField EQUIPMENT_CONF = new DBField(DBDataType.STRING , "equipment_conf","equipmentConf","设备配置","设备配置",false,false,true);
		
		/**
		 * 设备运行环境
		*/
		public static final DBField EQUIPMENT_ENVIRONMENT_CODE = new DBField(DBDataType.STRING , "equipment_environment_code","equipmentEnvironmentCode","设备运行环境","设备运行环境",false,false,true);
		
		/**
		 * 设备序列号
		*/
		public static final DBField EQUIPMENT_SERIAL_NUMBER = new DBField(DBDataType.STRING , "equipment_serial_number","equipmentSerialNumber","设备序列号","设备序列号",false,false,true);
		
		/**
		 * 设备机柜
		*/
		public static final DBField RACK_ID = new DBField(DBDataType.STRING , "rack_id","rackId","设备机柜","设备机柜",false,false,true);
		
		/**
		 * 设备机柜上位置
		*/
		public static final DBField RACK_UP_NUMBER = new DBField(DBDataType.INTEGER , "rack_up_number","rackUpNumber","设备机柜上位置","设备机柜上位置",false,false,true);
		
		/**
		 * 设备机柜下位置
		*/
		public static final DBField RACK_DOWN_NUMBER = new DBField(DBDataType.INTEGER , "rack_down_number","rackDownNumber","设备机柜下位置","设备机柜下位置",false,false,true);
		
		/**
		 * 标签1
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签1","标签1",false,false,true);
		
		/**
		 * 标签2
		*/
		public static final DBField LABEL2 = new DBField(DBDataType.STRING , "label2","label2","标签2","标签2",false,false,true);
		
		/**
		 * 标签3
		*/
		public static final DBField LABEL3 = new DBField(DBDataType.STRING , "label3","label3","标签3","标签3",false,false,true);
		
		/**
		 * 标签4
		*/
		public static final DBField LABEL4 = new DBField(DBDataType.STRING , "label4","label4","标签4","标签4",false,false,true);
		
		/**
		 * 内部控制标签
		*/
		public static final DBField INTERNAL_CONTROL_LABEL = new DBField(DBDataType.STRING , "internal_control_label","internalControlLabel","内部控制标签","内部控制标签",false,false,true);
		
		/**
		 * 单据
		*/
		public static final DBField BILL_ID = new DBField(DBDataType.STRING , "bill_id","billId","单据","单据",false,false,true);
		
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
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField ASSET_SELECTED_DATA = new DBField(DBDataType.STRING , "asset_selected_data","assetSelectedData","选择","选择",false,false,true);
		
		public EAM_ASSET() {
			this.init($NAME,"资产" , ID , CATEGORY_ID , CATEGORY_CODE , BUSINESS_CODE , PROC_ID , STATUS , BATCH_CODE , OWNER_CODE , ASSET_CODE , ASSET_STATUS , DISPLAY , CLEAN_OUT , GOODS_ID , NAME , MANUFACTURER_ID , MODEL , PICTURE_ID , UNIT , SERVICE_LIFE , SAFETY_LEVEL_CODE , SERIAL_NUMBER , OWN_COMPANY_ID , MANAGER_ID , USE_ORGANIZATION_ID , USE_USER_ID , POSITION_ID , POSITION_DETAIL , WAREHOUSE_ID , GOODS_STOCK_ID , SOURCE_ID , ASSET_NUMBER , REMAIN_NUMBER , PURCHASE_DATE , PRODUCTION_DATE , REGISTER_DATE , RFID , ATTACH , LAST_VERIFICATION_DATE , PURPOSE , ASSET_NOTES , MAINTAINER_ID , MAINTAINER_NAME , MAINTENANCE_STATUS , CONTACTS , CONTACT_INFORMATION , DIRECTOR , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , MAINTENANCE_NOTES , FINANCIAL_CATEGORY_ID , FINANCIAL_CODE , SUPPLIER_ID , TAX_AMOUNT_RATE , TAX_AMOUNT_PRICE , TOTAL_AMOUNT_PRICE , ORIGINAL_UNIT_PRICE , ACCUMULATED_DEPRECIATION , RESIDUALS_RATE , NAV_PRICE , PURCHASE_UNIT_PRICE , ENTRY_TIME , FINANCIAL_NOTES , EQUIPMENT_CODE , EQUIPMENT_STATUS , EQUIPMENT_IP , MANAGE_IP , EQUIPMENT_CPU , EQUIPMENT_MEMORY , EQUIPMENT_LABEL , EQUIPMENT_CONF , EQUIPMENT_ENVIRONMENT_CODE , EQUIPMENT_SERIAL_NUMBER , RACK_ID , RACK_UP_NUMBER , RACK_DOWN_NUMBER , LABEL , LABEL2 , LABEL3 , LABEL4 , INTERNAL_CONTROL_LABEL , BILL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , ASSET_SELECTED_DATA);
		}
		public static final EAM_ASSET $TABLE=new EAM_ASSET();
	}
	
	/**
	 * 资产调拨
	*/
	public static class EAM_ASSET_ALLOCATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_allocation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 调出所属公司
		*/
		public static final DBField OUT_OWN_COMPANY_ID = new DBField(DBDataType.STRING , "out_own_company_id","outOwnCompanyId","调出所属公司","调出所属公司",false,false,true);
		
		/**
		 * 调入所属公司
		*/
		public static final DBField IN_OWN_COMPANY_ID = new DBField(DBDataType.STRING , "in_own_company_id","inOwnCompanyId","调入所属公司","调入所属公司",false,false,true);
		
		/**
		 * 调入管理员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","调入管理员","调入管理员",false,false,true);
		
		/**
		 * 调拨说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","调拨说明","调拨说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_ALLOCATION() {
			this.init($NAME,"资产调拨" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , OUT_OWN_COMPANY_ID , IN_OWN_COMPANY_ID , MANAGER_ID , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_ALLOCATION $TABLE=new EAM_ASSET_ALLOCATION();
	}
	
	/**
	 * 资产字段配置
	*/
	public static class EAM_ASSET_ATTRIBUTE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_attribute";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 字段编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","字段编码","字段编码",false,false,true);
		
		/**
		 * 字段名称
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","字段名称","字段名称",false,false,true);
		
		/**
		 * 字段值类型
		*/
		public static final DBField VALUE_TYPE = new DBField(DBDataType.STRING , "value_type","valueType","字段值类型","字段值类型",false,false,true);
		
		/**
		 * 取值路径
		*/
		public static final DBField VALUE_PATH = new DBField(DBDataType.STRING , "value_path","valuePath","取值路径","取值路径",false,false,true);
		
		/**
		 * 标签备注
		*/
		public static final DBField LABEL_NOTES = new DBField(DBDataType.STRING , "label_notes","labelNotes","标签备注","标签备注",false,false,true);
		
		/**
		 * 所属维度
		*/
		public static final DBField DIMENSION = new DBField(DBDataType.STRING , "dimension","dimension","所属维度","所属维度",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 是否必选
		*/
		public static final DBField REQUIRED = new DBField(DBDataType.STRING , "required","required","是否必选","是否必选",false,false,true);
		
		/**
		 * 是否修改
		*/
		public static final DBField REQUIRED_MODIFY = new DBField(DBDataType.STRING , "required_modify","requiredModify","是否修改","是否修改",false,false,true);
		
		/**
		 * 组件类型
		*/
		public static final DBField COMPONENT_TYPE = new DBField(DBDataType.STRING , "component_type","componentType","组件类型","组件类型",false,false,true);
		
		/**
		 * 组件内容
		*/
		public static final DBField COMPONENT_CONTENT = new DBField(DBDataType.STRING , "component_content","componentContent","组件内容","组件内容",false,false,true);
		
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
		
		/**
		 * 归属
		*/
		public static final DBField OWNER = new DBField(DBDataType.STRING , "owner","owner","归属","归属",false,false,true);
		
		public EAM_ASSET_ATTRIBUTE() {
			this.init($NAME,"资产字段配置" , ID , CODE , LABEL , VALUE_TYPE , VALUE_PATH , LABEL_NOTES , DIMENSION , STATUS , REQUIRED , REQUIRED_MODIFY , COMPONENT_TYPE , COMPONENT_CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , OWNER);
		}
		public static final EAM_ASSET_ATTRIBUTE $TABLE=new EAM_ASSET_ATTRIBUTE();
	}
	
	/**
	 * 资产字段配置项
	*/
	public static class EAM_ASSET_ATTRIBUTE_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_attribute_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属模块
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","所属模块","所属模块",false,false,true);
		
		/**
		 * 属性
		*/
		public static final DBField ATTRIBUTE_ID = new DBField(DBDataType.STRING , "attribute_id","attributeId","属性","属性",false,false,true);
		
		/**
		 * 所属维度
		*/
		public static final DBField DIMENSION = new DBField(DBDataType.STRING , "dimension","dimension","所属维度","所属维度",false,false,true);
		
		/**
		 * 必选
		*/
		public static final DBField REQUIRED = new DBField(DBDataType.STRING , "required","required","必选","必选",false,false,true);
		
		/**
		 * 布局类型
		*/
		public static final DBField LAYOUT_TYPE = new DBField(DBDataType.STRING , "layout_type","layoutType","布局类型","布局类型",false,false,true);
		
		/**
		 * 列表显示
		*/
		public static final DBField LIST_SHOW = new DBField(DBDataType.STRING , "list_show","listShow","列表显示","列表显示",false,false,true);
		
		/**
		 * 列表内容
		*/
		public static final DBField LIST_CONTENT = new DBField(DBDataType.STRING , "list_content","listContent","列表内容","列表内容",false,false,true);
		
		/**
		 * 列表排序
		*/
		public static final DBField LIST_SORT = new DBField(DBDataType.INTEGER , "list_sort","listSort","列表排序","列表排序",false,false,true);
		
		/**
		 * 表单显示
		*/
		public static final DBField FORM_SHOW = new DBField(DBDataType.STRING , "form_show","formShow","表单显示","表单显示",false,false,true);
		
		/**
		 * 行布局位置
		*/
		public static final DBField LAYOUT_ROW = new DBField(DBDataType.INTEGER , "layout_row","layoutRow","行布局位置","行布局位置",false,false,true);
		
		/**
		 * 列布局位置
		*/
		public static final DBField LAYOUT_COLUMN = new DBField(DBDataType.INTEGER , "layout_column","layoutColumn","列布局位置","列布局位置",false,false,true);
		
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
		
		public EAM_ASSET_ATTRIBUTE_ITEM() {
			this.init($NAME,"资产字段配置项" , ID , OWNER_CODE , ATTRIBUTE_ID , DIMENSION , REQUIRED , LAYOUT_TYPE , LIST_SHOW , LIST_CONTENT , LIST_SORT , FORM_SHOW , LAYOUT_ROW , LAYOUT_COLUMN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_ATTRIBUTE_ITEM $TABLE=new EAM_ASSET_ATTRIBUTE_ITEM();
	}
	
	/**
	 * 资产批次
	*/
	public static class EAM_ASSET_BATCH extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_batch";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 批次编码
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次编码","批次编码",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
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
		
		public EAM_ASSET_BATCH() {
			this.init($NAME,"资产批次" , ID , BATCH_CODE , NOTES , LABEL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_BATCH $TABLE=new EAM_ASSET_BATCH();
	}
	
	/**
	 * 资产借用
	*/
	public static class EAM_ASSET_BORROW extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_borrow";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 借用状态
		*/
		public static final DBField BORROW_STATUS = new DBField(DBDataType.STRING , "borrow_status","borrowStatus","借用状态","借用状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 借用人
		*/
		public static final DBField BORROWER_ID = new DBField(DBDataType.STRING , "borrower_id","borrowerId","借用人","借用人",false,false,true);
		
		/**
		 * 借出时间
		*/
		public static final DBField BORROW_TIME = new DBField(DBDataType.DATE , "borrow_time","borrowTime","借出时间","借出时间",false,false,true);
		
		/**
		 * 预计归还时间
		*/
		public static final DBField PLAN_RETURN_DATE = new DBField(DBDataType.DATE , "plan_return_date","planReturnDate","预计归还时间","预计归还时间",false,false,true);
		
		/**
		 * 归还时间
		*/
		public static final DBField RETURN_DATE = new DBField(DBDataType.DATE , "return_date","returnDate","归还时间","归还时间",false,false,true);
		
		/**
		 * 借出说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","借出说明","借出说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_BORROW() {
			this.init($NAME,"资产借用" , ID , BUSINESS_CODE , PROC_ID , STATUS , BORROW_STATUS , NAME , BORROWER_ID , BORROW_TIME , PLAN_RETURN_DATE , RETURN_DATE , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_BORROW $TABLE=new EAM_ASSET_BORROW();
	}
	
	/**
	 * 资产借用归还
	*/
	public static class EAM_ASSET_BORROW_RETURN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_borrow_return";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 借用单
		*/
		public static final DBField BORROW_ID = new DBField(DBDataType.STRING , "borrow_id","borrowId","借用单","借用单",false,false,true);
		
		/**
		 * 归还时间
		*/
		public static final DBField RETURN_DATE = new DBField(DBDataType.DATE , "return_date","returnDate","归还时间","归还时间",false,false,true);
		
		/**
		 * 归还说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","归还说明","归还说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		public EAM_ASSET_BORROW_RETURN() {
			this.init($NAME,"资产借用归还" , ID , BORROW_ID , RETURN_DATE , CONTENT , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_BORROW_RETURN $TABLE=new EAM_ASSET_BORROW_RETURN();
	}
	
	/**
	 * 资产领用
	*/
	public static class EAM_ASSET_COLLECTION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_collection";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 领用后公司/部门
		*/
		public static final DBField USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "use_organization_id","useOrganizationId","领用后公司/部门","领用后公司/部门",false,false,true);
		
		/**
		 * 使用人员
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","使用人员","使用人员",false,false,true);
		
		/**
		 * 领用后位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","领用后位置","领用后位置",false,false,true);
		
		/**
		 * 详细位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","详细位置","详细位置",false,false,true);
		
		/**
		 * 领用日期
		*/
		public static final DBField COLLECTION_DATE = new DBField(DBDataType.DATE , "collection_date","collectionDate","领用日期","领用日期",false,false,true);
		
		/**
		 * 领用说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","领用说明","领用说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_COLLECTION() {
			this.init($NAME,"资产领用" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , USE_ORGANIZATION_ID , USE_USER_ID , POSITION_ID , POSITION_DETAIL , COLLECTION_DATE , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_COLLECTION $TABLE=new EAM_ASSET_COLLECTION();
	}
	
	/**
	 * 资产退库
	*/
	public static class EAM_ASSET_COLLECTION_RETURN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_collection_return";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 退库后公司/部门
		*/
		public static final DBField USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "use_organization_id","useOrganizationId","退库后公司/部门","退库后公司/部门",false,false,true);
		
		/**
		 * 退库后位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","退库后位置","退库后位置",false,false,true);
		
		/**
		 * 详细位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","详细位置","详细位置",false,false,true);
		
		/**
		 * 退库说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","退库说明","退库说明",false,false,true);
		
		/**
		 * 退库日期
		*/
		public static final DBField RETURN_DATE = new DBField(DBDataType.DATE , "return_date","returnDate","退库日期","退库日期",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_COLLECTION_RETURN() {
			this.init($NAME,"资产退库" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , USE_ORGANIZATION_ID , POSITION_ID , POSITION_DETAIL , CONTENT , RETURN_DATE , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_COLLECTION_RETURN $TABLE=new EAM_ASSET_COLLECTION_RETURN();
	}
	
	/**
	 * 数据变更
	*/
	public static class EAM_ASSET_DATA_CHANGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_data_change";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField BUSINESS_NAME = new DBField(DBDataType.STRING , "business_name","businessName","业务名称","业务名称",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHANGE_TYPE = new DBField(DBDataType.STRING , "change_type","changeType","变更类型","变更类型",false,false,true);
		
		/**
		 * 资产变更
		*/
		public static final DBField ASSET_CHANGE_ID = new DBField(DBDataType.STRING , "asset_change_id","assetChangeId","资产变更","资产变更",false,false,true);
		
		/**
		 * 变更日期
		*/
		public static final DBField CHANGE_DATE = new DBField(DBDataType.DATE , "change_date","changeDate","变更日期","变更日期",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField CHANGE_NOTES = new DBField(DBDataType.STRING , "change_notes","changeNotes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_ASSET_DATA_CHANGE() {
			this.init($NAME,"数据变更" , ID , BUSINESS_CODE , PROC_ID , STATUS , BUSINESS_NAME , CHANGE_TYPE , ASSET_CHANGE_ID , CHANGE_DATE , CHANGE_NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_ASSET_DATA_CHANGE $TABLE=new EAM_ASSET_DATA_CHANGE();
	}
	
	/**
	 * 资产数据权限
	*/
	public static class EAM_ASSET_DATA_PERMISSIONS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_data_permissions";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 权限状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","权限状态","权限状态",false,false,true);
		
		/**
		 * 归属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","归属","归属",false,false,true);
		
		/**
		 * 权限编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","权限编码","权限编码",false,false,true);
		
		/**
		 * 业务角色
		*/
		public static final DBField ROLE_CODE = new DBField(DBDataType.STRING , "role_code","roleCode","业务角色","业务角色",false,false,true);
		
		/**
		 * 组织权限状态
		*/
		public static final DBField ORG_AUTHORITY_ENABLE = new DBField(DBDataType.STRING , "org_authority_enable","orgAuthorityEnable","组织权限状态","组织权限状态",false,false,true);
		
		/**
		 * 本组织激活
		*/
		public static final DBField ORG_LOCAL_ENABLE = new DBField(DBDataType.STRING , "org_local_enable","orgLocalEnable","本组织激活","本组织激活",false,false,true);
		
		/**
		 * 组织级联状态
		*/
		public static final DBField ORG_CASCADE_ENABLE = new DBField(DBDataType.STRING , "org_cascade_enable","orgCascadeEnable","组织级联状态","组织级联状态",false,false,true);
		
		/**
		 * 分类权限状态
		*/
		public static final DBField CATALOG_AUTHORITY_ENABLE = new DBField(DBDataType.STRING , "catalog_authority_enable","catalogAuthorityEnable","分类权限状态","分类权限状态",false,false,true);
		
		/**
		 * 分类级联状态
		*/
		public static final DBField CATALOG_CASCADE_ENABLE = new DBField(DBDataType.STRING , "catalog_cascade_enable","catalogCascadeEnable","分类级联状态","分类级联状态",false,false,true);
		
		/**
		 * 位置权限状态
		*/
		public static final DBField POSITION_AUTHORITY_ENABLE = new DBField(DBDataType.STRING , "position_authority_enable","positionAuthorityEnable","位置权限状态","位置权限状态",false,false,true);
		
		/**
		 * 优先级
		*/
		public static final DBField PRIORITY = new DBField(DBDataType.INTEGER , "priority","priority","优先级","优先级",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_ASSET_DATA_PERMISSIONS() {
			this.init($NAME,"资产数据权限" , ID , NAME , STATUS , OWNER_CODE , CODE , ROLE_CODE , ORG_AUTHORITY_ENABLE , ORG_LOCAL_ENABLE , ORG_CASCADE_ENABLE , CATALOG_AUTHORITY_ENABLE , CATALOG_CASCADE_ENABLE , POSITION_AUTHORITY_ENABLE , PRIORITY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_DATA_PERMISSIONS $TABLE=new EAM_ASSET_DATA_PERMISSIONS();
	}
	
	/**
	 * 分类
	*/
	public static class EAM_ASSET_DATA_PERMISSIONS_CATALOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_data_permissions_catalog";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 权限
		*/
		public static final DBField PERMISSION_ID = new DBField(DBDataType.STRING , "permission_id","permissionId","权限","权限",false,false,true);
		
		/**
		 * 值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","值","值",false,false,true);
		
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
		
		public EAM_ASSET_DATA_PERMISSIONS_CATALOG() {
			this.init($NAME,"分类" , ID , PERMISSION_ID , VALUE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final EAM_ASSET_DATA_PERMISSIONS_CATALOG $TABLE=new EAM_ASSET_DATA_PERMISSIONS_CATALOG();
	}
	
	/**
	 * 组织
	*/
	public static class EAM_ASSET_DATA_PERMISSIONS_ORG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_data_permissions_org";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 权限
		*/
		public static final DBField PERMISSION_ID = new DBField(DBDataType.STRING , "permission_id","permissionId","权限","权限",false,false,true);
		
		/**
		 * 值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","值","值",false,false,true);
		
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
		
		public EAM_ASSET_DATA_PERMISSIONS_ORG() {
			this.init($NAME,"组织" , ID , PERMISSION_ID , VALUE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final EAM_ASSET_DATA_PERMISSIONS_ORG $TABLE=new EAM_ASSET_DATA_PERMISSIONS_ORG();
	}
	
	/**
	 * 位置
	*/
	public static class EAM_ASSET_DATA_PERMISSIONS_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_data_permissions_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 权限
		*/
		public static final DBField PERMISSION_ID = new DBField(DBDataType.STRING , "permission_id","permissionId","权限","权限",false,false,true);
		
		/**
		 * 值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","值","值",false,false,true);
		
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
		
		public EAM_ASSET_DATA_PERMISSIONS_POSITION() {
			this.init($NAME,"位置" , ID , PERMISSION_ID , VALUE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final EAM_ASSET_DATA_PERMISSIONS_POSITION $TABLE=new EAM_ASSET_DATA_PERMISSIONS_POSITION();
	}
	
	/**
	 * 折旧方案
	*/
	public static class EAM_ASSET_DEPRECIATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_depreciation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 折旧方案
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","折旧方案","折旧方案",false,false,true);
		
		/**
		 * 折旧方式
		*/
		public static final DBField METHOD = new DBField(DBDataType.STRING , "method","method","折旧方式","折旧方式",false,false,true);
		
		/**
		 * 预计残值率
		*/
		public static final DBField PRE_RESIDUAL_RATE = new DBField(DBDataType.DECIMAL , "pre_residual_rate","preResidualRate","预计残值率","预计残值率",false,false,true);
		
		/**
		 * 首次折旧时间
		*/
		public static final DBField FIRST_DEPRECIATION_DATE = new DBField(DBDataType.STRING , "first_depreciation_date","firstDepreciationDate","首次折旧时间","首次折旧时间",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 资产分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","资产分类","资产分类",false,false,true);
		
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
		
		public EAM_ASSET_DEPRECIATION() {
			this.init($NAME,"折旧方案" , ID , STATUS , NAME , METHOD , PRE_RESIDUAL_RATE , FIRST_DEPRECIATION_DATE , OWN_COMPANY_ID , CATEGORY_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_DEPRECIATION $TABLE=new EAM_ASSET_DEPRECIATION();
	}
	
	/**
	 * 折旧分类
	*/
	public static class EAM_ASSET_DEPRECIATION_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_depreciation_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 折旧方案
		*/
		public static final DBField DEPRECIATION_ID = new DBField(DBDataType.STRING , "depreciation_id","depreciationId","折旧方案","折旧方案",false,false,true);
		
		/**
		 * 资产分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","资产分类","资产分类",false,false,true);
		
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
		
		public EAM_ASSET_DEPRECIATION_CATEGORY() {
			this.init($NAME,"折旧分类" , ID , DEPRECIATION_ID , CATEGORY_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_DEPRECIATION_CATEGORY $TABLE=new EAM_ASSET_DEPRECIATION_CATEGORY();
	}
	
	/**
	 * 折旧明细
	*/
	public static class EAM_ASSET_DEPRECIATION_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_depreciation_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 折旧方案
		*/
		public static final DBField DEPRECIATION_ID = new DBField(DBDataType.STRING , "depreciation_id","depreciationId","折旧方案","折旧方案",false,false,true);
		
		/**
		 * 折旧操作
		*/
		public static final DBField OPER_ID = new DBField(DBDataType.STRING , "oper_id","operId","折旧操作","折旧操作",false,false,true);
		
		/**
		 * 资产
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产","资产",false,false,true);
		
		/**
		 * 折旧前
		*/
		public static final DBField DETAIL_ID_SOURCE = new DBField(DBDataType.STRING , "detail_id_source","detailIdSource","折旧前","折旧前",false,false,true);
		
		/**
		 * 折旧后
		*/
		public static final DBField DETAIL_ID_TARGET = new DBField(DBDataType.STRING , "detail_id_target","detailIdTarget","折旧后","折旧后",false,false,true);
		
		/**
		 * 当前净值
		*/
		public static final DBField CUR_PRICE = new DBField(DBDataType.DECIMAL , "cur_price","curPrice","当前净值","当前净值",false,false,true);
		
		/**
		 * 折旧前净值
		*/
		public static final DBField BEFORE_PRICE = new DBField(DBDataType.DECIMAL , "before_price","beforePrice","折旧前净值","折旧前净值",false,false,true);
		
		/**
		 * 折旧后净值
		*/
		public static final DBField AFTER_PRICE = new DBField(DBDataType.DECIMAL , "after_price","afterPrice","折旧后净值","折旧后净值",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,false);
		
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
		
		public EAM_ASSET_DEPRECIATION_DETAIL() {
			this.init($NAME,"折旧明细" , ID , DEPRECIATION_ID , OPER_ID , ASSET_ID , DETAIL_ID_SOURCE , DETAIL_ID_TARGET , CUR_PRICE , BEFORE_PRICE , AFTER_PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_DEPRECIATION_DETAIL $TABLE=new EAM_ASSET_DEPRECIATION_DETAIL();
	}
	
	/**
	 * 折旧操作
	*/
	public static class EAM_ASSET_DEPRECIATION_OPER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_depreciation_oper";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 折旧方案
		*/
		public static final DBField DEPRECIATION_ID = new DBField(DBDataType.STRING , "depreciation_id","depreciationId","折旧方案","折旧方案",false,false,true);
		
		/**
		 * 折旧内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","折旧内容","折旧内容",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 执行时间
		*/
		public static final DBField EXECUTION_START_TIME = new DBField(DBDataType.DATE , "execution_start_time","executionStartTime","执行时间","执行时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField EXECUTION_END_TIME = new DBField(DBDataType.DATE , "execution_end_time","executionEndTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		public EAM_ASSET_DEPRECIATION_OPER() {
			this.init($NAME,"折旧操作" , ID , BUSINESS_CODE , STATUS , NAME , DEPRECIATION_ID , CONTENT , BUSINESS_DATE , EXECUTION_START_TIME , EXECUTION_END_TIME , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_DEPRECIATION_OPER $TABLE=new EAM_ASSET_DEPRECIATION_OPER();
	}
	
	/**
	 * 资产处置
	*/
	public static class EAM_ASSET_HANDLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_handle";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 处置类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","处置类型","处置类型",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 处置数量
		*/
		public static final DBField HANDLE_NUMBER = new DBField(DBDataType.DECIMAL , "handle_number","handleNumber","处置数量","处置数量",false,false,true);
		
		/**
		 * 处理日期
		*/
		public static final DBField HANDLE_DATE = new DBField(DBDataType.DATE , "handle_date","handleDate","处理日期","处理日期",false,false,true);
		
		/**
		 * 计划完成时间
		*/
		public static final DBField PLAN_FINISH_DATE = new DBField(DBDataType.DATE , "plan_finish_date","planFinishDate","计划完成时间","计划完成时间",false,false,true);
		
		/**
		 * 实际完成时间
		*/
		public static final DBField ACTUAL_FINISH_DATE = new DBField(DBDataType.DATE , "actual_finish_date","actualFinishDate","实际完成时间","实际完成时间",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 修改标记
		*/
		public static final DBField CRD_ACTION = new DBField(DBDataType.STRING , "crd_action","crdAction","修改标记","修改标记",false,false,true);
		
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
		
		public EAM_ASSET_HANDLE() {
			this.init($NAME,"资产处置" , ID , PROC_ID , BUSINESS_CODE , NAME , STATUS , TYPE , CONTENT , HANDLE_NUMBER , HANDLE_DATE , PLAN_FINISH_DATE , ACTUAL_FINISH_DATE , ORIGINATOR_ID , PICTURE_ID , CRD_ACTION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_HANDLE $TABLE=new EAM_ASSET_HANDLE();
	}
	
	/**
	 * 资产
	*/
	public static class EAM_ASSET_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 处理
		*/
		public static final DBField HANDLE_ID = new DBField(DBDataType.STRING , "handle_id","handleId","处理","处理",false,false,true);
		
		/**
		 * 资产
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产","资产",false,false,true);
		
		/**
		 * 资产使用人
		*/
		public static final DBField BEFORE_USE_USER_ID = new DBField(DBDataType.STRING , "before_use_user_id","beforeUseUserId","资产使用人","资产使用人",false,false,true);
		
		/**
		 * 资产状态
		*/
		public static final DBField BEFORE_ASSET_STATUS = new DBField(DBDataType.STRING , "before_asset_status","beforeAssetStatus","资产状态","资产状态",false,false,true);
		
		/**
		 * 修改标记
		*/
		public static final DBField CRD = new DBField(DBDataType.STRING , "crd","crd","修改标记","修改标记",false,false,true);
		
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
		
		public EAM_ASSET_ITEM() {
			this.init($NAME,"资产" , ID , HANDLE_ID , ASSET_ID , BEFORE_USE_USER_ID , BEFORE_ASSET_STATUS , CRD , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_ITEM $TABLE=new EAM_ASSET_ITEM();
	}
	
	/**
	 * 资产标签
	*/
	public static class EAM_ASSET_LABEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_label";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,false);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL_TPL_ID = new DBField(DBDataType.STRING , "label_tpl_id","labelTplId","标签","标签",false,false,true);
		
		/**
		 * 标签宽度
		*/
		public static final DBField LABEL_WIDTH = new DBField(DBDataType.DECIMAL , "label_width","labelWidth","标签宽度","标签宽度",false,false,true);
		
		/**
		 * 标签高度
		*/
		public static final DBField LABEL_HEIGHT = new DBField(DBDataType.DECIMAL , "label_height","labelHeight","标签高度","标签高度",false,false,true);
		
		/**
		 * 标签布局
		*/
		public static final DBField LABEL_LAYOUT = new DBField(DBDataType.STRING , "label_layout","labelLayout","标签布局","标签布局",false,false,true);
		
		/**
		 * 标签间隔
		*/
		public static final DBField LABEL_TABLE_MARGIN = new DBField(DBDataType.DECIMAL , "label_table_margin","labelTableMargin","标签间隔","标签间隔",false,false,true);
		
		/**
		 * 字体大小
		*/
		public static final DBField LABEL_KEY_FONT_SIZE = new DBField(DBDataType.INTEGER , "label_key_font_size","labelKeyFontSize","字体大小","字体大小",false,false,true);
		
		/**
		 * 字体大小
		*/
		public static final DBField LABEL_VALUE_FONT_SIZE = new DBField(DBDataType.INTEGER , "label_value_font_size","labelValueFontSize","字体大小","字体大小",false,false,true);
		
		/**
		 * 图形宽度
		*/
		public static final DBField IMAGE_WIDTH = new DBField(DBDataType.INTEGER , "image_width","imageWidth","图形宽度","图形宽度",false,false,true);
		
		/**
		 * 图形高度
		*/
		public static final DBField IMAGE_HEIGHT = new DBField(DBDataType.INTEGER , "image_height","imageHeight","图形高度","图形高度",false,false,true);
		
		/**
		 * 纸张类型
		*/
		public static final DBField PAPER_TYPE_ID = new DBField(DBDataType.STRING , "paper_type_id","paperTypeId","纸张类型","纸张类型",false,false,true);
		
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
		
		public EAM_ASSET_LABEL() {
			this.init($NAME,"资产标签" , ID , CODE , LABEL_TPL_ID , LABEL_WIDTH , LABEL_HEIGHT , LABEL_LAYOUT , LABEL_TABLE_MARGIN , LABEL_KEY_FONT_SIZE , LABEL_VALUE_FONT_SIZE , IMAGE_WIDTH , IMAGE_HEIGHT , PAPER_TYPE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_LABEL $TABLE=new EAM_ASSET_LABEL();
	}
	
	/**
	 * 标签字段
	*/
	public static class EAM_ASSET_LABEL_COL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_label_col";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 字段
		*/
		public static final DBField COL_VALUE = new DBField(DBDataType.STRING , "col_value","colValue","字段","字段",false,false,true);
		
		/**
		 * 字段名称
		*/
		public static final DBField COL_NAME = new DBField(DBDataType.STRING , "col_name","colName","字段名称","字段名称",false,false,true);
		
		/**
		 * 字段全名称
		*/
		public static final DBField COL_FULL_NAME = new DBField(DBDataType.STRING , "col_full_name","colFullName","字段全名称","字段全名称",false,false,true);
		
		/**
		 * 是否图像
		*/
		public static final DBField IS_IMAGE = new DBField(DBDataType.STRING , "is_image","isImage","是否图像","是否图像",false,false,true);
		
		/**
		 * 图像类型,rwm|txm
		*/
		public static final DBField IMAGE_TYPE = new DBField(DBDataType.STRING , "image_type","imageType","图像类型","rwm|txm",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
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
		
		public EAM_ASSET_LABEL_COL() {
			this.init($NAME,"标签字段" , ID , COL_VALUE , COL_NAME , COL_FULL_NAME , IS_IMAGE , IMAGE_TYPE , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_LABEL_COL $TABLE=new EAM_ASSET_LABEL_COL();
	}
	
	/**
	 * 纸张类型
	*/
	public static class EAM_ASSET_LABEL_PAPER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_label_paper";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 是否启用
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","是否启用","是否启用",false,false,true);
		
		/**
		 * 类型,paper|special
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","paper|special",false,false,true);
		
		/**
		 * 列数
		*/
		public static final DBField COLUMN_NUMBER = new DBField(DBDataType.INTEGER , "column_number","columnNumber","列数","列数",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public EAM_ASSET_LABEL_PAPER() {
			this.init($NAME,"纸张类型" , ID , NAME , STATUS , TYPE , COLUMN_NUMBER , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_LABEL_PAPER $TABLE=new EAM_ASSET_LABEL_PAPER();
	}
	
	/**
	 * 标签模版
	*/
	public static class EAM_ASSET_LABEL_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_label_tpl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型,默认为1
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","默认为1",false,false,true);
		
		/**
		 * 是否自定义
		*/
		public static final DBField IS_CUSTOM = new DBField(DBDataType.STRING , "is_custom","isCustom","是否自定义","是否自定义",false,false,true);
		
		/**
		 * 字段
		*/
		public static final DBField COL_IDS = new DBField(DBDataType.STRING , "col_ids","colIds","字段","字段",false,false,true);
		
		/**
		 * 位置:u,d
		*/
		public static final DBField IMAGE_POSITION = new DBField(DBDataType.STRING , "image_position","imagePosition","位置:u","d",false,false,true);
		
		/**
		 * 图像
		*/
		public static final DBField IMAGE_COL_ID = new DBField(DBDataType.STRING , "image_col_id","imageColId","图像","图像",false,false,true);
		
		/**
		 * 图像显示
		*/
		public static final DBField IMAGE_SHOW = new DBField(DBDataType.STRING , "image_show","imageShow","图像显示","图像显示",false,false,true);
		
		/**
		 * 图像label显示
		*/
		public static final DBField IMAGE_LABEL_SHOW = new DBField(DBDataType.STRING , "image_label_show","imageLabelShow","图像label显示","图像label显示",false,false,true);
		
		/**
		 * 图像类型txm,rwm
		*/
		public static final DBField IMAGE_TYPE = new DBField(DBDataType.STRING , "image_type","imageType","图像类型txm","rwm",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField LABEL_FORMAT_CONTENT = new DBField(DBDataType.STRING , "label_format_content","labelFormatContent","类型","类型",false,false,true);
		
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
		
		public EAM_ASSET_LABEL_TPL() {
			this.init($NAME,"标签模版" , ID , TYPE , IS_CUSTOM , COL_IDS , IMAGE_POSITION , IMAGE_COL_ID , IMAGE_SHOW , IMAGE_LABEL_SHOW , IMAGE_TYPE , LABEL_FORMAT_CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_LABEL_TPL $TABLE=new EAM_ASSET_LABEL_TPL();
	}
	
	/**
	 * 标签模版
	*/
	public static class EAM_ASSET_LABEL_TPL_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_label_tpl_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 字段ID
		*/
		public static final DBField COL_ID = new DBField(DBDataType.STRING , "col_id","colId","字段ID","字段ID",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
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
		
		public EAM_ASSET_LABEL_TPL_ITEM() {
			this.init($NAME,"标签模版" , ID , TPL_ID , COL_ID , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_LABEL_TPL_ITEM $TABLE=new EAM_ASSET_LABEL_TPL_ITEM();
	}
	
	/**
	 * 维保处理
	*/
	public static class EAM_ASSET_MAINTENANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_maintenance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","所属","所属",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 处理状态
		*/
		public static final DBField HANDLE_STATUS = new DBField(DBDataType.STRING , "handle_status","handleStatus","处理状态","处理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 合同
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同","合同",false,false,true);
		
		/**
		 * 维保厂商
		*/
		public static final DBField MAINTAINER_ID = new DBField(DBDataType.STRING , "maintainer_id","maintainerId","维保厂商","维保厂商",false,false,true);
		
		/**
		 * 维保开始时间
		*/
		public static final DBField STARTDATE = new DBField(DBDataType.DATE , "startDate","startdate","维保开始时间","维保开始时间",false,false,true);
		
		/**
		 * 维保结束时间
		*/
		public static final DBField ENDDATE = new DBField(DBDataType.DATE , "endDate","enddate","维保结束时间","维保结束时间",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 操作日期
		*/
		public static final DBField OPER_TIME = new DBField(DBDataType.DATE , "oper_time","operTime","操作日期","操作日期",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_MAINTENANCE() {
			this.init($NAME,"维保处理" , ID , OWNER_TYPE , BUSINESS_CODE , HANDLE_STATUS , NAME , CONTRACT_ID , MAINTAINER_ID , STARTDATE , ENDDATE , BUSINESS_DATE , NOTES , ORIGINATOR_ID , OPER_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_MAINTENANCE $TABLE=new EAM_ASSET_MAINTENANCE();
	}
	
	/**
	 * 我的申请
	*/
	public static class EAM_ASSET_MY_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_my_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
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
		
		public EAM_ASSET_MY_APPLY() {
			this.init($NAME,"我的申请" , ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_MY_APPLY $TABLE=new EAM_ASSET_MY_APPLY();
	}
	
	/**
	 * 我的申请
	*/
	public static class EAM_ASSET_MY_APPLY_LIST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_my_apply_list";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
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
		
		public EAM_ASSET_MY_APPLY_LIST() {
			this.init($NAME,"我的申请" , ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_MY_APPLY_LIST $TABLE=new EAM_ASSET_MY_APPLY_LIST();
	}
	
	/**
	 * 资产处理记录
	*/
	public static class EAM_ASSET_PROCESS_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_process_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产","资产",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 操作类型
		*/
		public static final DBField PROCESS_TYPE = new DBField(DBDataType.STRING , "process_type","processType","操作类型","操作类型",false,false,true);
		
		/**
		 * 操作内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","操作内容","操作内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 使用人
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","使用人","使用人",false,false,true);
		
		/**
		 * 变更人
		*/
		public static final DBField PROCESS_USER_ID = new DBField(DBDataType.STRING , "process_user_id","processUserId","变更人","变更人",false,false,true);
		
		/**
		 * 变更时间
		*/
		public static final DBField PROCESSD_TIME = new DBField(DBDataType.DATE , "processd_time","processdTime","变更时间","变更时间",false,false,true);
		
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
		
		public EAM_ASSET_PROCESS_RECORD() {
			this.init($NAME,"资产处理记录" , ID , ASSET_ID , BUSINESS_CODE , PROCESS_TYPE , CONTENT , NOTES , USE_USER_ID , PROCESS_USER_ID , PROCESSD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_PROCESS_RECORD $TABLE=new EAM_ASSET_PROCESS_RECORD();
	}
	
	/**
	 * 资产报修
	*/
	public static class EAM_ASSET_REPAIR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_repair";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 维修状态
		*/
		public static final DBField REPAIR_STATUS = new DBField(DBDataType.STRING , "repair_status","repairStatus","维修状态","维修状态",false,false,true);
		
		/**
		 * 报修类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","报修类型","报修类型",false,false,true);
		
		/**
		 * 计划完成日期
		*/
		public static final DBField PLAN_FINISH_DATE = new DBField(DBDataType.DATE , "plan_finish_date","planFinishDate","计划完成日期","计划完成日期",false,false,true);
		
		/**
		 * 实际完成日期
		*/
		public static final DBField ACTUAL_FINISH_DATE = new DBField(DBDataType.DATE , "actual_finish_date","actualFinishDate","实际完成日期","实际完成日期",false,false,true);
		
		/**
		 * 报修内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","报修内容","报修内容",false,false,true);
		
		/**
		 * 报修人
		*/
		public static final DBField REPORT_USER_ID = new DBField(DBDataType.STRING , "report_user_id","reportUserId","报修人","报修人",false,false,true);
		
		/**
		 * 报修人
		*/
		public static final DBField REPORT_USER_NAME = new DBField(DBDataType.STRING , "report_user_name","reportUserName","报修人","报修人",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_REPAIR() {
			this.init($NAME,"资产报修" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , REPAIR_STATUS , TYPE , PLAN_FINISH_DATE , ACTUAL_FINISH_DATE , CONTENT , REPORT_USER_ID , REPORT_USER_NAME , PICTURE_ID , ORIGINATOR_ID , BUSINESS_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_REPAIR $TABLE=new EAM_ASSET_REPAIR();
	}
	
	/**
	 * 资产报废
	*/
	public static class EAM_ASSET_SCRAP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_scrap";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 清理状态
		*/
		public static final DBField CLEAN_STATUS = new DBField(DBDataType.STRING , "clean_status","cleanStatus","清理状态","清理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 报废时间
		*/
		public static final DBField SCRAP_DATE = new DBField(DBDataType.STRING , "scrap_date","scrapDate","报废时间","报废时间",false,false,true);
		
		/**
		 * 报废说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","报废说明","报废说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_ASSET_SCRAP() {
			this.init($NAME,"资产报废" , ID , BUSINESS_CODE , PROC_ID , STATUS , CLEAN_STATUS , NAME , SCRAP_DATE , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_ASSET_SCRAP $TABLE=new EAM_ASSET_SCRAP();
	}
	
	/**
	 * 资产选择
	*/
	public static class EAM_ASSET_SELECTED_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_selected_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产选择编号
		*/
		public static final DBField ASSET_SELECTED_CODE = new DBField(DBDataType.STRING , "asset_selected_code","assetSelectedCode","资产选择编号","资产选择编号",false,false,true);
		
		/**
		 * 资产
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产","资产",false,false,true);
		
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
		
		public EAM_ASSET_SELECTED_DATA() {
			this.init($NAME,"资产选择" , ID , ASSET_SELECTED_CODE , ASSET_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ASSET_SELECTED_DATA $TABLE=new EAM_ASSET_SELECTED_DATA();
	}
	
	/**
	 * 软件资产
	*/
	public static class EAM_ASSET_SOFTWARE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_software";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","所属","所属",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 软件名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","软件名称","软件名称",false,false,true);
		
		/**
		 * 软件分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","软件分类","软件分类",false,false,true);
		
		/**
		 * 软件编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","软件编号","软件编号",false,false,true);
		
		/**
		 * 软件版本
		*/
		public static final DBField SOFTWARE_VERSION = new DBField(DBDataType.STRING , "software_version","softwareVersion","软件版本","软件版本",false,false,true);
		
		/**
		 * 版权类型
		*/
		public static final DBField COPYRIGHT_TYPE = new DBField(DBDataType.STRING , "copyright_type","copyrightType","版权类型","版权类型",false,false,true);
		
		/**
		 * 许可方式
		*/
		public static final DBField LICENSE_MODE = new DBField(DBDataType.STRING , "license_mode","licenseMode","许可方式","许可方式",false,false,true);
		
		/**
		 * 成本
		*/
		public static final DBField COST_PRICE = new DBField(DBDataType.DECIMAL , "cost_price","costPrice","成本","成本",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 使用公司
		*/
		public static final DBField USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "use_organization_id","useOrganizationId","使用公司","使用公司",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","供应商","供应商",false,false,true);
		
		/**
		 * 管理人
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人","管理人",false,false,true);
		
		/**
		 * 详细位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","详细位置","详细位置",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 来源明细
		*/
		public static final DBField SOURCE_DETAIL = new DBField(DBDataType.STRING , "source_detail","sourceDetail","来源明细","来源明细",false,false,true);
		
		/**
		 * 授权信息
		*/
		public static final DBField AUTHORIZATION_INFO = new DBField(DBDataType.STRING , "authorization_info","authorizationInfo","授权信息","授权信息",false,false,true);
		
		/**
		 * 授权数量
		*/
		public static final DBField AUTHORIZED_NUMBER = new DBField(DBDataType.INTEGER , "authorized_number","authorizedNumber","授权数量","授权数量",false,false,true);
		
		/**
		 * 可用数量
		*/
		public static final DBField AUTHORIZED_AVAILABLE_NUMBER = new DBField(DBDataType.INTEGER , "authorized_available_number","authorizedAvailableNumber","可用数量","可用数量",false,false,true);
		
		/**
		 * 无限授权
		*/
		public static final DBField AUTHORIZED_NUMBER_UNLIMIT = new DBField(DBDataType.STRING , "authorized_number_unlimit","authorizedNumberUnlimit","无限授权","无限授权",false,false,true);
		
		/**
		 * 授权码
		*/
		public static final DBField AUTHORIZATION_CODE = new DBField(DBDataType.STRING , "authorization_code","authorizationCode","授权码","授权码",false,false,true);
		
		/**
		 * 授权到期时间
		*/
		public static final DBField AUTHORIZATION_EXPIRATION_DATE = new DBField(DBDataType.DATE , "authorization_expiration_date","authorizationExpirationDate","授权到期时间","授权到期时间",false,false,true);
		
		/**
		 * 永久授权
		*/
		public static final DBField AUTHORIZATION_EXPIRATION_UNLIMIT = new DBField(DBDataType.STRING , "authorization_expiration_unlimit","authorizationExpirationUnlimit","永久授权","永久授权",false,false,true);
		
		/**
		 * 是否维保
		*/
		public static final DBField NEED_MAINTENANCE = new DBField(DBDataType.STRING , "need_maintenance","needMaintenance","是否维保","是否维保",false,false,true);
		
		/**
		 * 维保开始时间
		*/
		public static final DBField MAINTENANCE_START_DATE = new DBField(DBDataType.DATE , "maintenance_start_date","maintenanceStartDate","维保开始时间","维保开始时间",false,false,true);
		
		/**
		 * 维保到期时间
		*/
		public static final DBField MAINTENANCE_END_DATE = new DBField(DBDataType.DATE , "maintenance_end_date","maintenanceEndDate","维保到期时间","维保到期时间",false,false,true);
		
		/**
		 * 购置日期
		*/
		public static final DBField PURCHASE_DATE = new DBField(DBDataType.DATE , "purchase_date","purchaseDate","购置日期","购置日期",false,false,true);
		
		/**
		 * 登记时间
		*/
		public static final DBField REGISTER_DATE = new DBField(DBDataType.DATE , "register_date","registerDate","登记时间","登记时间",false,false,true);
		
		/**
		 * 软件说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","软件说明","软件说明",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
		/**
		 * 标签1
		*/
		public static final DBField LABEL1 = new DBField(DBDataType.STRING , "label1","label1","标签1","标签1",false,false,true);
		
		/**
		 * 标签2
		*/
		public static final DBField LABEL2 = new DBField(DBDataType.STRING , "label2","label2","标签2","标签2",false,false,true);
		
		/**
		 * 标签3
		*/
		public static final DBField LABEL3 = new DBField(DBDataType.STRING , "label3","label3","标签3","标签3",false,false,true);
		
		/**
		 * 标签4
		*/
		public static final DBField LABEL4 = new DBField(DBDataType.STRING , "label4","label4","标签4","标签4",false,false,true);
		
		/**
		 * 控制
		*/
		public static final DBField CTL = new DBField(DBDataType.STRING , "ctl","ctl","控制","控制",false,false,true);
		
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
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
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
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		public EAM_ASSET_SOFTWARE() {
			this.init($NAME,"软件资产" , ID , BUSINESS_CODE , OWNER_CODE , PROC_ID , STATUS , NAME , CATEGORY_ID , CODE , SOFTWARE_VERSION , COPYRIGHT_TYPE , LICENSE_MODE , COST_PRICE , OWN_COMPANY_ID , USE_ORGANIZATION_ID , SUPPLIER_ID , MANAGER_ID , POSITION_DETAIL , SOURCE_ID , SOURCE_DETAIL , AUTHORIZATION_INFO , AUTHORIZED_NUMBER , AUTHORIZED_AVAILABLE_NUMBER , AUTHORIZED_NUMBER_UNLIMIT , AUTHORIZATION_CODE , AUTHORIZATION_EXPIRATION_DATE , AUTHORIZATION_EXPIRATION_UNLIMIT , NEED_MAINTENANCE , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , PURCHASE_DATE , REGISTER_DATE , CONTENT , NOTES , ATTACH_ID , LABEL1 , LABEL2 , LABEL3 , LABEL4 , CTL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , SELECTED_CODE);
		}
		public static final EAM_ASSET_SOFTWARE $TABLE=new EAM_ASSET_SOFTWARE();
	}
	
	/**
	 * 软件变更
	*/
	public static class EAM_ASSET_SOFTWARE_CHANGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_software_change";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 变更名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","变更名称","变更名称",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 变更说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","变更说明","变更说明",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
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
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
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
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		public EAM_ASSET_SOFTWARE_CHANGE() {
			this.init($NAME,"软件变更" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , BUSINESS_DATE , CONTENT , NOTES , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID);
		}
		public static final EAM_ASSET_SOFTWARE_CHANGE $TABLE=new EAM_ASSET_SOFTWARE_CHANGE();
	}
	
	/**
	 * 软件变更明细
	*/
	public static class EAM_ASSET_SOFTWARE_CHANGE_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_software_change_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更
		*/
		public static final DBField CHANGE_ID = new DBField(DBDataType.STRING , "change_id","changeId","变更","变更",false,false,true);
		
		/**
		 * 软件信息
		*/
		public static final DBField SOFTWARE_ID = new DBField(DBDataType.STRING , "software_id","softwareId","软件信息","软件信息",false,false,true);
		
		/**
		 * 变更前软件信息
		*/
		public static final DBField AFTER_SOFTWARE_ID = new DBField(DBDataType.STRING , "after_software_id","afterSoftwareId","变更前软件信息","变更前软件信息",false,false,true);
		
		/**
		 * 变更后软件信息
		*/
		public static final DBField BEFORE_SOFTWARE_ID = new DBField(DBDataType.STRING , "before_software_id","beforeSoftwareId","变更后软件信息","变更后软件信息",false,false,true);
		
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
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
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
		
		public EAM_ASSET_SOFTWARE_CHANGE_DETAIL() {
			this.init($NAME,"软件变更明细" , ID , CHANGE_ID , SOFTWARE_ID , AFTER_SOFTWARE_ID , BEFORE_SOFTWARE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_SOFTWARE_CHANGE_DETAIL $TABLE=new EAM_ASSET_SOFTWARE_CHANGE_DETAIL();
	}
	
	/**
	 * 软件分发
	*/
	public static class EAM_ASSET_SOFTWARE_DISTRIBUTE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_software_distribute";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 领用公司
		*/
		public static final DBField USE_ORG_ID = new DBField(DBDataType.STRING , "use_org_id","useOrgId","领用公司","领用公司",false,false,true);
		
		/**
		 * 领用人
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","领用人","领用人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 领用说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","领用说明","领用说明",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 关联资产
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","关联资产","关联资产",false,false,true);
		
		/**
		 * 软件资产
		*/
		public static final DBField ASSET_SOFTWARE_ID = new DBField(DBDataType.STRING , "asset_software_id","assetSoftwareId","软件资产","软件资产",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_SOFTWARE_DISTRIBUTE() {
			this.init($NAME,"软件分发" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , USE_ORG_ID , USE_USER_ID , BUSINESS_DATE , CONTENT , NOTES , ASSET_ID , ASSET_SOFTWARE_ID , ATTACH_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_SOFTWARE_DISTRIBUTE $TABLE=new EAM_ASSET_SOFTWARE_DISTRIBUTE();
	}
	
	/**
	 * 软件分发项
	*/
	public static class EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_software_distribute_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 软件分发
		*/
		public static final DBField DISTRIBUTE_ID = new DBField(DBDataType.STRING , "distribute_id","distributeId","软件分发","软件分发",false,false,true);
		
		/**
		 * 软件信息
		*/
		public static final DBField SOFTWARE_ID = new DBField(DBDataType.STRING , "software_id","softwareId","软件信息","软件信息",false,false,true);
		
		/**
		 * 授权数量
		*/
		public static final DBField AUTHORIZED_NUMBER = new DBField(DBDataType.INTEGER , "authorized_number","authorizedNumber","授权数量","授权数量",false,false,true);
		
		/**
		 * 授权信息
		*/
		public static final DBField AUTHORIZED_INFO = new DBField(DBDataType.STRING , "authorized_info","authorizedInfo","授权信息","授权信息",false,false,true);
		
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
		
		public EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA() {
			this.init($NAME,"软件分发项" , ID , DISTRIBUTE_ID , SOFTWARE_ID , AUTHORIZED_NUMBER , AUTHORIZED_INFO , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA $TABLE=new EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA();
	}
	
	/**
	 * 软件维保
	*/
	public static class EAM_ASSET_SOFTWARE_MAINTENANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_software_maintenance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 维保名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","维保名称","维保名称",false,false,true);
		
		/**
		 * 维保厂商
		*/
		public static final DBField MAINTAINER_ID = new DBField(DBDataType.STRING , "maintainer_id","maintainerId","维保厂商","维保厂商",false,false,true);
		
		/**
		 * 负责部门
		*/
		public static final DBField USE_ORG_ID = new DBField(DBDataType.STRING , "use_org_id","useOrgId","负责部门","负责部门",false,false,true);
		
		/**
		 * 维保负责人
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","维保负责人","维保负责人",false,false,true);
		
		/**
		 * 维保联系人
		*/
		public static final DBField CONTACTS = new DBField(DBDataType.STRING , "contacts","contacts","维保联系人","维保联系人",false,false,true);
		
		/**
		 * 联系信息
		*/
		public static final DBField CONTACT_INFO = new DBField(DBDataType.STRING , "contact_info","contactInfo","联系信息","联系信息",false,false,true);
		
		/**
		 * 维保费用
		*/
		public static final DBField MAINTENANCE_COST = new DBField(DBDataType.DECIMAL , "maintenance_cost","maintenanceCost","维保费用","维保费用",false,false,true);
		
		/**
		 * 维保开始时间
		*/
		public static final DBField MAINTENANCE_START_DATE = new DBField(DBDataType.DATE , "maintenance_start_date","maintenanceStartDate","维保开始时间","维保开始时间",false,false,true);
		
		/**
		 * 维保到期时间
		*/
		public static final DBField MAINTENANCE_END_DATE = new DBField(DBDataType.DATE , "maintenance_end_date","maintenanceEndDate","维保到期时间","维保到期时间",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 维保说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","维保说明","维保说明",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
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
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
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
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		public EAM_ASSET_SOFTWARE_MAINTENANCE() {
			this.init($NAME,"软件维保" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , MAINTAINER_ID , USE_ORG_ID , MANAGER_ID , CONTACTS , CONTACT_INFO , MAINTENANCE_COST , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , BUSINESS_DATE , CONTENT , NOTES , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID);
		}
		public static final EAM_ASSET_SOFTWARE_MAINTENANCE $TABLE=new EAM_ASSET_SOFTWARE_MAINTENANCE();
	}
	
	/**
	 * 软件维保明细
	*/
	public static class EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_software_maintenance_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更
		*/
		public static final DBField MAINTENANCE_ID = new DBField(DBDataType.STRING , "maintenance_id","maintenanceId","变更","变更",false,false,true);
		
		/**
		 * 软件信息
		*/
		public static final DBField SOFTWARE_ID = new DBField(DBDataType.STRING , "software_id","softwareId","软件信息","软件信息",false,false,true);
		
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
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
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
		
		public EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL() {
			this.init($NAME,"软件维保明细" , ID , MAINTENANCE_ID , SOFTWARE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL $TABLE=new EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL();
	}
	
	/**
	 * 资产领用
	*/
	public static class EAM_ASSET_STOCK_COLLECTION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_collection";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","库存所属","库存所属",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 领用后公司/部门
		*/
		public static final DBField USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "use_organization_id","useOrganizationId","领用后公司/部门","领用后公司/部门",false,false,true);
		
		/**
		 * 使用人员
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","使用人员","使用人员",false,false,true);
		
		/**
		 * 领用后位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","领用后位置","领用后位置",false,false,true);
		
		/**
		 * 详细位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","详细位置","详细位置",false,false,true);
		
		/**
		 * 领用日期
		*/
		public static final DBField COLLECTION_DATE = new DBField(DBDataType.DATE , "collection_date","collectionDate","领用日期","领用日期",false,false,true);
		
		/**
		 * 领用说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","领用说明","领用说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_STOCK_COLLECTION() {
			this.init($NAME,"资产领用" , ID , BUSINESS_CODE , PROC_ID , STATUS , OWNER_CODE , NAME , USE_ORGANIZATION_ID , USE_USER_ID , POSITION_ID , POSITION_DETAIL , COLLECTION_DATE , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_STOCK_COLLECTION $TABLE=new EAM_ASSET_STOCK_COLLECTION();
	}
	
	/**
	 * 库存出库
	*/
	public static class EAM_ASSET_STOCK_DELIVER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_deliver";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 出库状态
		*/
		public static final DBField DELIVER_STATUS = new DBField(DBDataType.STRING , "deliver_status","deliverStatus","出库状态","出库状态",false,false,true);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","库存所属","库存所属",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 出库类型
		*/
		public static final DBField DELIVER_TYPE = new DBField(DBDataType.STRING , "deliver_type","deliverType","出库类型","出库类型",false,false,true);
		
		/**
		 * 出货日期
		*/
		public static final DBField DELIVER_DATE = new DBField(DBDataType.DATE , "deliver_date","deliverDate","出货日期","出货日期",false,false,true);
		
		/**
		 * 领用公司
		*/
		public static final DBField RECEIVING_COMPANY_ID = new DBField(DBDataType.STRING , "receiving_company_id","receivingCompanyId","领用公司","领用公司",false,false,true);
		
		/**
		 * 领用部门
		*/
		public static final DBField RECEIVING_ORG_ID = new DBField(DBDataType.STRING , "receiving_org_id","receivingOrgId","领用部门","领用部门",false,false,true);
		
		/**
		 * 领用人
		*/
		public static final DBField RECEIVER_ID = new DBField(DBDataType.STRING , "receiver_id","receiverId","领用人","领用人",false,false,true);
		
		/**
		 * 出货人
		*/
		public static final DBField SHIPPER_NAME = new DBField(DBDataType.STRING , "shipper_name","shipperName","出货人","出货人",false,false,true);
		
		/**
		 * 详细位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","详细位置","详细位置",false,false,true);
		
		/**
		 * 出库说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","出库说明","出库说明",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_STOCK_DELIVER() {
			this.init($NAME,"库存出库" , ID , BUSINESS_CODE , PROC_ID , STATUS , DELIVER_STATUS , OWNER_CODE , NAME , DELIVER_TYPE , DELIVER_DATE , RECEIVING_COMPANY_ID , RECEIVING_ORG_ID , RECEIVER_ID , SHIPPER_NAME , POSITION_DETAIL , CONTENT , ATTACH , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_STOCK_DELIVER $TABLE=new EAM_ASSET_STOCK_DELIVER();
	}
	
	/**
	 * 库存物品单
	*/
	public static class EAM_ASSET_STOCK_GOODS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_goods";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","库存所属","库存所属",false,false,true);
		
		/**
		 * 所属类型
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","所属类型","所属类型",false,false,true);
		
		/**
		 * 库存类型
		*/
		public static final DBField STOCK_TYPE = new DBField(DBDataType.STRING , "stock_type","stockType","库存类型","库存类型",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField STOCK_BATCH_CODE = new DBField(DBDataType.STRING , "stock_batch_code","stockBatchCode","批次号","批次号",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 物品
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","物品","物品",false,false,true);
		
		/**
		 * 入库存数量
		*/
		public static final DBField STOCK_IN_NUMBER = new DBField(DBDataType.DECIMAL , "stock_in_number","stockInNumber","入库存数量","入库存数量",false,false,true);
		
		/**
		 * 当前库存数量
		*/
		public static final DBField STOCK_CUR_NUMBER = new DBField(DBDataType.DECIMAL , "stock_cur_number","stockCurNumber","当前库存数量","当前库存数量",false,false,true);
		
		/**
		 * 单价
		*/
		public static final DBField UNIT_PRICE = new DBField(DBDataType.DECIMAL , "unit_price","unitPrice","单价","单价",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","总金额","总金额",false,false,true);
		
		/**
		 * 资产供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","资产供应商","资产供应商",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 所属组织
		*/
		public static final DBField USE_ORG_ID = new DBField(DBDataType.STRING , "use_org_id","useOrgId","所属组织","所属组织",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_STOCK_GOODS() {
			this.init($NAME,"库存物品单" , ID , OWNER_CODE , OWNER_TYPE , STOCK_TYPE , BUSINESS_CODE , STOCK_BATCH_CODE , SOURCE_ID , GOODS_ID , STOCK_IN_NUMBER , STOCK_CUR_NUMBER , UNIT_PRICE , AMOUNT , SUPPLIER_ID , WAREHOUSE_ID , OWN_COMPANY_ID , NOTES , USE_ORG_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_STOCK_GOODS $TABLE=new EAM_ASSET_STOCK_GOODS();
	}
	
	/**
	 * 库存调整
	*/
	public static class EAM_ASSET_STOCK_GOODS_ADJUST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_goods_adjust";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","库存所属","库存所属",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 调整说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","调整说明","调整说明",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_ASSET_STOCK_GOODS_ADJUST() {
			this.init($NAME,"库存调整" , ID , BUSINESS_CODE , PROC_ID , STATUS , OWNER_TYPE , NAME , WAREHOUSE_ID , ORIGINATOR_ID , BUSINESS_DATE , CONTENT , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_ASSET_STOCK_GOODS_ADJUST $TABLE=new EAM_ASSET_STOCK_GOODS_ADJUST();
	}
	
	/**
	 * 库存物品明细
	*/
	public static class EAM_ASSET_STOCK_GOODS_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_goods_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 物品编码
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","物品编码","物品编码",false,false,true);
		
		/**
		 * 库存单
		*/
		public static final DBField STOCK_ID = new DBField(DBDataType.STRING , "stock_id","stockId","库存单","库存单",false,false,true);
		
		/**
		 * 入库数量
		*/
		public static final DBField IN_NUMBER = new DBField(DBDataType.DECIMAL , "in_number","inNumber","入库数量","入库数量",false,false,true);
		
		/**
		 * 当前数量
		*/
		public static final DBField CUR_NUMBER = new DBField(DBDataType.DECIMAL , "cur_number","curNumber","当前数量","当前数量",false,false,true);
		
		/**
		 * 单价
		*/
		public static final DBField UNIT_PRICE = new DBField(DBDataType.DECIMAL , "unit_price","unitPrice","单价","单价",false,false,true);
		
		/**
		 * 金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","金额","金额",false,false,true);
		
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
		
		public EAM_ASSET_STOCK_GOODS_DETAIL() {
			this.init($NAME,"库存物品明细" , ID , GOODS_ID , STOCK_ID , IN_NUMBER , CUR_NUMBER , UNIT_PRICE , AMOUNT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_STOCK_GOODS_DETAIL $TABLE=new EAM_ASSET_STOCK_GOODS_DETAIL();
	}
	
	/**
	 * 库存物品单
	*/
	public static class EAM_ASSET_STOCK_GOODS_IN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_goods_in";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","库存所属","库存所属",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 单据名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","单据名称","单据名称",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 入库类型
		*/
		public static final DBField STOCK_TYPE = new DBField(DBDataType.STRING , "stock_type","stockType","入库类型","入库类型",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 管理人
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人","管理人",false,false,true);
		
		/**
		 * 接收人
		*/
		public static final DBField RECEIVER_USER_NAME = new DBField(DBDataType.STRING , "receiver_user_name","receiverUserName","接收人","接收人",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","总金额","总金额",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_NAME = new DBField(DBDataType.STRING , "supplier_name","supplierName","供应商","供应商",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 购置日期
		*/
		public static final DBField PURCHASE_DATE = new DBField(DBDataType.DATE , "purchase_date","purchaseDate","购置日期","购置日期",false,false,true);
		
		/**
		 * 业务时间
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务时间","业务时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_ASSET_STOCK_GOODS_IN() {
			this.init($NAME,"库存物品单" , ID , OWNER_TYPE , BUSINESS_CODE , PROC_ID , STATUS , NAME , BATCH_CODE , STOCK_TYPE , WAREHOUSE_ID , MANAGER_ID , RECEIVER_USER_NAME , AMOUNT , OWN_COMPANY_ID , SUPPLIER_NAME , SOURCE_ID , PURCHASE_DATE , BUSINESS_DATE , ATTACH_ID , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_ASSET_STOCK_GOODS_IN $TABLE=new EAM_ASSET_STOCK_GOODS_IN();
	}
	
	/**
	 * 库存出库
	*/
	public static class EAM_ASSET_STOCK_GOODS_OUT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_goods_out";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","库存所属","库存所属",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 出库所属
		*/
		public static final DBField STOCK_TYPE = new DBField(DBDataType.STRING , "stock_type","stockType","出库所属","出库所属",false,false,true);
		
		/**
		 * 领用公司
		*/
		public static final DBField USE_OWN_COMPANY_ID = new DBField(DBDataType.STRING , "use_own_company_id","useOwnCompanyId","领用公司","领用公司",false,false,true);
		
		/**
		 * 领用部门
		*/
		public static final DBField USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "use_organization_id","useOrganizationId","领用部门","领用部门",false,false,true);
		
		/**
		 * 领用人员
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","领用人员","领用人员",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 出库位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","出库位置","出库位置",false,false,true);
		
		/**
		 * 出库日期
		*/
		public static final DBField COLLECTION_DATE = new DBField(DBDataType.DATE , "collection_date","collectionDate","出库日期","出库日期",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 出库说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","出库说明","出库说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_ASSET_STOCK_GOODS_OUT() {
			this.init($NAME,"库存出库" , ID , BUSINESS_CODE , PROC_ID , STATUS , OWNER_TYPE , NAME , STOCK_TYPE , USE_OWN_COMPANY_ID , USE_ORGANIZATION_ID , USE_USER_ID , WAREHOUSE_ID , POSITION_DETAIL , COLLECTION_DATE , BUSINESS_DATE , CONTENT , ORIGINATOR_ID , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_ASSET_STOCK_GOODS_OUT $TABLE=new EAM_ASSET_STOCK_GOODS_OUT();
	}
	
	/**
	 * 库存调拨
	*/
	public static class EAM_ASSET_STOCK_GOODS_TRANFER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_stock_goods_tranfer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","库存所属","库存所属",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 调出仓库
		*/
		public static final DBField WAREHOUSE_OUT_ID = new DBField(DBDataType.STRING , "warehouse_out_id","warehouseOutId","调出仓库","调出仓库",false,false,true);
		
		/**
		 * 调入仓库
		*/
		public static final DBField WAREHOUSE_IN_ID = new DBField(DBDataType.STRING , "warehouse_in_id","warehouseInId","调入仓库","调入仓库",false,false,true);
		
		/**
		 * 转移说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","转移说明","转移说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_ASSET_STOCK_GOODS_TRANFER() {
			this.init($NAME,"库存调拨" , ID , BUSINESS_CODE , PROC_ID , STATUS , OWNER_TYPE , NAME , WAREHOUSE_OUT_ID , WAREHOUSE_IN_ID , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_ASSET_STOCK_GOODS_TRANFER $TABLE=new EAM_ASSET_STOCK_GOODS_TRANFER();
	}
	
	/**
	 * 资产入库
	*/
	public static class EAM_ASSET_STORAGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_storage";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","供应商","供应商",false,false,true);
		
		/**
		 * 供应商备注
		*/
		public static final DBField SUPPLIER_INFO = new DBField(DBDataType.STRING , "supplier_info","supplierInfo","供应商备注","供应商备注",false,false,true);
		
		/**
		 * 归属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","归属公司","归属公司",false,false,true);
		
		/**
		 * 管理人员
		*/
		public static final DBField MANAGER_USER_ID = new DBField(DBDataType.STRING , "manager_user_id","managerUserId","管理人员","管理人员",false,false,true);
		
		/**
		 * 位置信息
		*/
		public static final DBField LOCATION_NAME = new DBField(DBDataType.STRING , "location_name","locationName","位置信息","位置信息",false,false,true);
		
		/**
		 * 入库说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","入库说明","入库说明",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 自定义数据
		*/
		public static final DBField CUSTOM_DATA = new DBField(DBDataType.STRING , "custom_data","customData","自定义数据","自定义数据",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		public EAM_ASSET_STORAGE() {
			this.init($NAME,"资产入库" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , SUPPLIER_ID , SUPPLIER_INFO , OWN_COMPANY_ID , MANAGER_USER_ID , LOCATION_NAME , CONTENT , BUSINESS_DATE , ATTACH , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CUSTOM_DATA , SELECTED_CODE);
		}
		public static final EAM_ASSET_STORAGE $TABLE=new EAM_ASSET_STORAGE();
	}
	
	/**
	 * 资产追溯
	*/
	public static class EAM_ASSET_TRACE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_trace";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 操作日期
		*/
		public static final DBField OPER_TIME = new DBField(DBDataType.DATE , "oper_time","operTime","操作日期","操作日期",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_TRACE() {
			this.init($NAME,"资产追溯" , ID , ORIGINATOR_ID , OPER_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_TRACE $TABLE=new EAM_ASSET_TRACE();
	}
	
	/**
	 * 资产转移
	*/
	public static class EAM_ASSET_TRANFER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_tranfer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 调出使用公司/部门
		*/
		public static final DBField OUT_USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "out_use_organization_id","outUseOrganizationId","调出使用公司/部门","调出使用公司/部门",false,false,true);
		
		/**
		 * 调入使用公司/部门
		*/
		public static final DBField IN_USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "in_use_organization_id","inUseOrganizationId","调入使用公司/部门","调入使用公司/部门",false,false,true);
		
		/**
		 * 调入管理员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","调入管理员","调入管理员",false,false,true);
		
		/**
		 * 使用人员
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","使用人员","使用人员",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","位置","位置",false,false,true);
		
		/**
		 * 位置详情
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","位置详情","位置详情",false,false,true);
		
		/**
		 * 转移说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","转移说明","转移说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_ASSET_TRANFER() {
			this.init($NAME,"资产转移" , ID , NAME , BUSINESS_CODE , PROC_ID , STATUS , OUT_USE_ORGANIZATION_ID , IN_USE_ORGANIZATION_ID , MANAGER_ID , USE_USER_ID , POSITION_ID , POSITION_DETAIL , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_ASSET_TRANFER $TABLE=new EAM_ASSET_TRANFER();
	}
	
	/**
	 * 品牌
	*/
	public static class EAM_BRAND extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_brand";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField BRAND_CODE = new DBField(DBDataType.STRING , "brand_code","brandCode","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField BRAND_NAME = new DBField(DBDataType.STRING , "brand_name","brandName","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.DECIMAL , "sort","sort","排序","排序",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_BRAND() {
			this.init($NAME,"品牌" , ID , STATUS , BRAND_CODE , BRAND_NAME , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_BRAND $TABLE=new EAM_BRAND();
	}
	
	/**
	 * 品牌
	*/
	public static class EAM_BRAND_DEMO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_brand_demo";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField BRAND_NAME = new DBField(DBDataType.STRING , "brand_name","brandName","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.DECIMAL , "sort","sort","排序","排序",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_BRAND_DEMO() {
			this.init($NAME,"品牌" , ID , BRAND_NAME , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_BRAND_DEMO $TABLE=new EAM_BRAND_DEMO();
	}
	
	/**
	 * 映射表
	*/
	public static class EAM_C1_MAPPING extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_c1_mapping";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 映射类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","映射类型","映射类型",false,false,true);
		
		/**
		 * 原值
		*/
		public static final DBField SOURCE_VALUE = new DBField(DBDataType.STRING , "source_value","sourceValue","原值","原值",false,false,true);
		
		/**
		 * 映射后值
		*/
		public static final DBField MAPPING_VALUE = new DBField(DBDataType.STRING , "mapping_value","mappingValue","映射后值","映射后值",false,false,true);
		
		/**
		 * 映射值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","映射值","映射值",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public EAM_C1_MAPPING() {
			this.init($NAME,"映射表" , ID , TYPE , SOURCE_VALUE , MAPPING_VALUE , VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_C1_MAPPING $TABLE=new EAM_C1_MAPPING();
	}
	
	/**
	 * 中间表
	*/
	public static class EAM_C1_QH_FA_ADDITIONS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_c1_qh_fa_additions";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主记录
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","主记录","主记录",false,false,true);
		
		/**
		 * 原资产ID
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","原资产ID","原资产ID",false,false,true);
		
		/**
		 * 资产编号
		*/
		public static final DBField ASSET_NUMBER = new DBField(DBDataType.STRING , "asset_number","assetNumber","资产编号","资产编号",false,false,true);
		
		/**
		 * 序列号
		*/
		public static final DBField SERIAL_NUMBER = new DBField(DBDataType.STRING , "serial_number","serialNumber","序列号","序列号",false,false,true);
		
		/**
		 * 标签号
		*/
		public static final DBField TAG_NUMBER = new DBField(DBDataType.STRING , "tag_number","tagNumber","标签号","标签号",false,false,true);
		
		/**
		 * 资产名称
		*/
		public static final DBField ASSET_NAME = new DBField(DBDataType.STRING , "asset_name","assetName","资产名称","资产名称",false,false,true);
		
		/**
		 * 资产类别
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","资产类别","资产类别",false,false,true);
		
		/**
		 * 启用日期
		*/
		public static final DBField DATE_PLACED_IN_SERVICE = new DBField(DBDataType.STRING , "date_placed_in_service","datePlacedInService","启用日期","启用日期",false,false,true);
		
		/**
		 * 数量
		*/
		public static final DBField CURRENT_UNITS = new DBField(DBDataType.STRING , "current_units","currentUnits","数量","数量",false,false,true);
		
		/**
		 * 原始成本
		*/
		public static final DBField ORIGINAL_COST = new DBField(DBDataType.STRING , "original_cost","originalCost","原始成本","原始成本",false,false,true);
		
		/**
		 * 净值
		*/
		public static final DBField NET_BOOK_VALUE = new DBField(DBDataType.STRING , "net_book_value","netBookValue","净值","净值",false,false,true);
		
		/**
		 * 使用人
		*/
		public static final DBField ASSIGNED_TO = new DBField(DBDataType.STRING , "assigned_to","assignedTo","使用人","使用人",false,false,true);
		
		/**
		 * 地点
		*/
		public static final DBField ASSIGNED_LOCATION = new DBField(DBDataType.STRING , "assigned_location","assignedLocation","地点","地点",false,false,true);
		
		/**
		 * 数据日期
		*/
		public static final DBField DATA_DATE = new DBField(DBDataType.STRING , "data_date","dataDate","数据日期","数据日期",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_DATE = new DBField(DBDataType.DATE , "record_date","recordDate","记录时间","记录时间",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public EAM_C1_QH_FA_ADDITIONS() {
			this.init($NAME,"中间表" , ID , PID , ASSET_ID , ASSET_NUMBER , SERIAL_NUMBER , TAG_NUMBER , ASSET_NAME , CATEGORY_NAME , DATE_PLACED_IN_SERVICE , CURRENT_UNITS , ORIGINAL_COST , NET_BOOK_VALUE , ASSIGNED_TO , ASSIGNED_LOCATION , DATA_DATE , RECORD_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_C1_QH_FA_ADDITIONS $TABLE=new EAM_C1_QH_FA_ADDITIONS();
	}
	
	/**
	 * 资产数据同步
	*/
	public static class EAM_C1_SYNC_ASSET extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_c1_sync_asset";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField PROCESS_START = new DBField(DBDataType.DATE , "process_start","processStart","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField PROCESS_STOP = new DBField(DBDataType.DATE , "process_stop","processStop","结束时间","结束时间",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public EAM_C1_SYNC_ASSET() {
			this.init($NAME,"资产数据同步" , ID , STATUS , PROCESS_START , PROCESS_STOP , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_C1_SYNC_ASSET $TABLE=new EAM_C1_SYNC_ASSET();
	}
	
	/**
	 * 资产数据同步明细
	*/
	public static class EAM_C1_SYNC_ASSET_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_c1_sync_asset_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主记录
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","主记录","主记录",false,false,true);
		
		/**
		 * 资产记录
		*/
		public static final DBField RECORD_ID = new DBField(DBDataType.STRING , "record_id","recordId","资产记录","资产记录",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 结果
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","结果","结果",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_DATE = new DBField(DBDataType.DATE , "record_date","recordDate","记录时间","记录时间",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public EAM_C1_SYNC_ASSET_RECORD() {
			this.init($NAME,"资产数据同步明细" , ID , PID , RECORD_ID , STATUS , RESULT , CONTENT , RECORD_DATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_C1_SYNC_ASSET_RECORD $TABLE=new EAM_C1_SYNC_ASSET_RECORD();
	}
	
	/**
	 * 资产分类
	*/
	public static class EAM_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","全称","全称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","编码","编码",false,false,true);
		
		/**
		 * 使用期限
		*/
		public static final DBField SERVICE_LIFE = new DBField(DBDataType.DECIMAL , "service_life","serviceLife","使用期限","使用期限",false,false,true);
		
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
		
		public EAM_CATEGORY() {
			this.init($NAME,"资产分类" , ID , STATUS , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , SERVICE_LIFE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_CATEGORY $TABLE=new EAM_CATEGORY();
	}
	
	/**
	 * 财务分类
	*/
	public static class EAM_CATEGORY_FINANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_category_finance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","全称","全称",false,false,true);
		
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
		
		public EAM_CATEGORY_FINANCE() {
			this.init($NAME,"财务分类" , ID , STATUS , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_CATEGORY_FINANCE $TABLE=new EAM_CATEGORY_FINANCE();
	}
	
	/**
	 * 分类权限
	*/
	public static class EAM_CATEGORY_PRIV extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_category_priv";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","分类","分类",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField EMPL_ID = new DBField(DBDataType.STRING , "empl_id","emplId","用户","用户",false,false,true);
		
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
		
		public EAM_CATEGORY_PRIV() {
			this.init($NAME,"分类权限" , ID , CATEGORY_ID , EMPL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_CATEGORY_PRIV $TABLE=new EAM_CATEGORY_PRIV();
	}
	
	/**
	 * 编码字段
	*/
	public static class EAM_CODE_PART extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_code_part";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 字段
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","字段","字段",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
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
		
		public EAM_CODE_PART() {
			this.init($NAME,"编码字段" , ID , CODE , NAME , TYPE , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_CODE_PART $TABLE=new EAM_CODE_PART();
	}
	
	/**
	 * 编码字段
	*/
	public static class EAM_CODE_RULE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_code_rule";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","编码","编码",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField SYS_VALUE = new DBField(DBDataType.STRING , "sys_value","sysValue","编码","编码",false,false,true);
		
		/**
		 * 组成
		*/
		public static final DBField PART_IDS = new DBField(DBDataType.STRING , "part_ids","partIds","组成","组成",false,false,true);
		
		/**
		 * 分割符
		*/
		public static final DBField CODE_SEPARATOR = new DBField(DBDataType.STRING , "code_separator","codeSeparator","分割符","分割符",false,false,true);
		
		/**
		 * 随机数位数
		*/
		public static final DBField NUMBER_SEQ = new DBField(DBDataType.INTEGER , "number_seq","numberSeq","随机数位数","随机数位数",false,false,true);
		
		/**
		 * 固定字符串
		*/
		public static final DBField FS1 = new DBField(DBDataType.STRING , "fs1","fs1","固定字符串","固定字符串",false,false,true);
		
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
		
		public EAM_CODE_RULE() {
			this.init($NAME,"编码字段" , ID , NAME , VALUE , SYS_VALUE , PART_IDS , CODE_SEPARATOR , NUMBER_SEQ , FS1 , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_CODE_RULE $TABLE=new EAM_CODE_RULE();
	}
	
	/**
	 * C1客户代码生成测试专用表
	*/
	public static class EAM_DEMO_C1 extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_demo_c1";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 标题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","标题","标题",false,false,true);
		
		/**
		 * 价格
		*/
		public static final DBField PRICE = new DBField(DBDataType.DECIMAL , "price","price","价格","价格",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,false);
		
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
		
		public EAM_DEMO_C1() {
			this.init($NAME,"C1客户代码生成测试专用表" , ID , TITLE , PRICE , NOTES , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_DEMO_C1 $TABLE=new EAM_DEMO_C1();
	}
	
	/**
	 * 故障登记
	*/
	public static class EAM_FAILURE_REGISTRATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_failure_registration";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 故障类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","故障类型","故障类型",false,false,true);
		
		/**
		 * 故障说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","故障说明","故障说明",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_FAILURE_REGISTRATION() {
			this.init($NAME,"故障登记" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , TYPE , CONTENT , PICTURE_ID , ATTACH_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_FAILURE_REGISTRATION $TABLE=new EAM_FAILURE_REGISTRATION();
	}
	
	/**
	 * 反馈信息
	*/
	public static class EAM_FEEDBACK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_feedback";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 标题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","标题","标题",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_FEEDBACK() {
			this.init($NAME,"反馈信息" , ID , TITLE , CONTENT , ATTACH , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_FEEDBACK $TABLE=new EAM_FEEDBACK();
	}
	
	/**
	 * 物品档案
	*/
	public static class EAM_GOODS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_goods";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","资产分类","资产分类",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 物品名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","物品名称","物品名称",false,false,true);
		
		/**
		 * 规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","规格型号","规格型号",false,false,true);
		
		/**
		 * 厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","厂商","厂商",false,false,true);
		
		/**
		 * 计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","计量单位","计量单位",false,false,true);
		
		/**
		 * 参考单价
		*/
		public static final DBField REFERENCE_PRICE = new DBField(DBDataType.DECIMAL , "reference_price","referencePrice","参考单价","参考单价",false,false,true);
		
		/**
		 * 物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","物品图片","物品图片",false,false,true);
		
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
		
		public EAM_GOODS() {
			this.init($NAME,"物品档案" , ID , CATEGORY_ID , STATUS , NAME , MODEL , MANUFACTURER_ID , UNIT , REFERENCE_PRICE , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_GOODS $TABLE=new EAM_GOODS();
	}
	
	/**
	 * 库存物品
	*/
	public static class EAM_GOODS_STOCK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_goods_stock";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_TMP_ID = new DBField(DBDataType.STRING , "owner_tmp_id","ownerTmpId","所属","所属",false,false,true);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","库存所属","库存所属",false,false,true);
		
		/**
		 * 所属类型
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","所属类型","所属类型",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField GOODS_STATUS = new DBField(DBDataType.STRING , "goods_status","goodsStatus","状态","状态",false,false,true);
		
		/**
		 * 资产分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","资产分类","资产分类",false,false,true);
		
		/**
		 * 物品名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","物品名称","物品名称",false,false,true);
		
		/**
		 * 规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","规格型号","规格型号",false,false,true);
		
		/**
		 * 物品编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","物品编码","物品编码",false,false,true);
		
		/**
		 * 物品条码
		*/
		public static final DBField BAR_CODE = new DBField(DBDataType.STRING , "bar_code","barCode","物品条码","物品条码",false,false,true);
		
		/**
		 * 厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","厂商","厂商",false,false,true);
		
		/**
		 * 品牌商标
		*/
		public static final DBField BRAND_ID = new DBField(DBDataType.STRING , "brand_id","brandId","品牌商标","品牌商标",false,false,true);
		
		/**
		 * 默认单价
		*/
		public static final DBField UNIT_PRICE = new DBField(DBDataType.DECIMAL , "unit_price","unitPrice","默认单价","默认单价",false,false,true);
		
		/**
		 * 计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","计量单位","计量单位",false,false,true);
		
		/**
		 * 安全库存下限
		*/
		public static final DBField STOCK_MIN = new DBField(DBDataType.DECIMAL , "stock_min","stockMin","安全库存下限","安全库存下限",false,false,true);
		
		/**
		 * 安全库存上限
		*/
		public static final DBField STOCK_MAX = new DBField(DBDataType.DECIMAL , "stock_max","stockMax","安全库存上限","安全库存上限",false,false,true);
		
		/**
		 * 安全库存
		*/
		public static final DBField STOCK_SECURITY = new DBField(DBDataType.DECIMAL , "stock_security","stockSecurity","安全库存","安全库存",false,false,true);
		
		/**
		 * 物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","物品图片","物品图片",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","批次号","批次号",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 使用组织
		*/
		public static final DBField USE_ORG_ID = new DBField(DBDataType.STRING , "use_org_id","useOrgId","使用组织","使用组织",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_NAME = new DBField(DBDataType.STRING , "supplier_name","supplierName","供应商","供应商",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 物品
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","物品","物品",false,false,true);
		
		/**
		 * 入库数量
		*/
		public static final DBField STOCK_IN_NUMBER = new DBField(DBDataType.DECIMAL , "stock_in_number","stockInNumber","入库数量","入库数量",false,false,true);
		
		/**
		 * 当前数量
		*/
		public static final DBField STOCK_CUR_NUMBER = new DBField(DBDataType.DECIMAL , "stock_cur_number","stockCurNumber","当前数量","当前数量",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","总金额","总金额",false,false,true);
		
		/**
		 * 管理人
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人","管理人",false,false,true);
		
		/**
		 * 入库时间
		*/
		public static final DBField STORAGE_DATE = new DBField(DBDataType.DATE , "storage_date","storageDate","入库时间","入库时间",false,false,true);
		
		/**
		 * 库存数据
		*/
		public static final DBField REAL_STOCK_ID = new DBField(DBDataType.STRING , "real_stock_id","realStockId","库存数据","库存数据",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
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
		
		public EAM_GOODS_STOCK() {
			this.init($NAME,"库存物品" , ID , OWNER_ID , OWNER_TMP_ID , OWNER_CODE , OWNER_TYPE , BUSINESS_CODE , STATUS , GOODS_STATUS , CATEGORY_ID , NAME , MODEL , CODE , BAR_CODE , MANUFACTURER_ID , BRAND_ID , UNIT_PRICE , UNIT , STOCK_MIN , STOCK_MAX , STOCK_SECURITY , PICTURE_ID , NOTES , BATCH_CODE , OWN_COMPANY_ID , USE_ORG_ID , SUPPLIER_NAME , WAREHOUSE_ID , SOURCE_ID , GOODS_ID , STOCK_IN_NUMBER , STOCK_CUR_NUMBER , AMOUNT , MANAGER_ID , STORAGE_DATE , REAL_STOCK_ID , ORIGINATOR_ID , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_GOODS_STOCK $TABLE=new EAM_GOODS_STOCK();
	}
	
	/**
	 * 班组成员
	*/
	public static class EAM_GROUP_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_group_user";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","班组","班组",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","人员","人员",false,false,true);
		
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
		
		public EAM_GROUP_USER() {
			this.init($NAME,"班组成员" , ID , GROUP_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_GROUP_USER $TABLE=new EAM_GROUP_USER();
	}
	
	/**
	 * 巡检班组
	*/
	public static class EAM_INSPECTION_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField LEADER_ID = new DBField(DBDataType.STRING , "leader_id","leaderId","负责人","负责人",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_INSPECTION_GROUP() {
			this.init($NAME,"巡检班组" , ID , NAME , STATUS , LEADER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_INSPECTION_GROUP $TABLE=new EAM_INSPECTION_GROUP();
	}
	
	/**
	 * 班组人员
	*/
	public static class EAM_INSPECTION_GROUP_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_group_user";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","班组","班组",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","人员","人员",false,false,true);
		
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
		
		public EAM_INSPECTION_GROUP_USER() {
			this.init($NAME,"班组人员" , ID , GROUP_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INSPECTION_GROUP_USER $TABLE=new EAM_INSPECTION_GROUP_USER();
	}
	
	/**
	 * 巡检计划
	*/
	public static class EAM_INSPECTION_PLAN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_plan";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 计划编号
		*/
		public static final DBField PLAN_CODE = new DBField(DBDataType.STRING , "plan_code","planCode","计划编号","计划编号",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField PLAN_STATUS = new DBField(DBDataType.STRING , "plan_status","planStatus","状态","状态",false,false,true);
		
		/**
		 * 计划类型
		*/
		public static final DBField PLAN_TYPE = new DBField(DBDataType.STRING , "plan_type","planType","计划类型","计划类型",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField LEADER_ID = new DBField(DBDataType.STRING , "leader_id","leaderId","负责人","负责人",false,false,true);
		
		/**
		 * 班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","班组","班组",false,false,true);
		
		/**
		 * 开始日期
		*/
		public static final DBField START_DATE = new DBField(DBDataType.DATE , "start_date","startDate","开始日期","开始日期",false,false,true);
		
		/**
		 * 截止日期
		*/
		public static final DBField END_DATE = new DBField(DBDataType.DATE , "end_date","endDate","截止日期","截止日期",false,false,true);
		
		/**
		 * 周期
		*/
		public static final DBField ACTION_CYCLE_ID = new DBField(DBDataType.STRING , "action_cycle_id","actionCycleId","周期","周期",false,false,true);
		
		/**
		 * 巡检顺序
		*/
		public static final DBField INSPECTION_METHOD = new DBField(DBDataType.STRING , "inspection_method","inspectionMethod","巡检顺序","巡检顺序",false,false,true);
		
		/**
		 * 时间要求(小时)
		*/
		public static final DBField COMPLETION_TIME = new DBField(DBDataType.DECIMAL , "completion_time","completionTime","时间要求(小时)","时间要求(小时)",false,false,true);
		
		/**
		 * 超时处理
		*/
		public static final DBField OVERTIME_METHOD = new DBField(DBDataType.STRING , "overtime_method","overtimeMethod","超时处理","超时处理",false,false,true);
		
		/**
		 * 提醒时间(小时)
		*/
		public static final DBField REMIND_TIME = new DBField(DBDataType.DECIMAL , "remind_time","remindTime","提醒时间(小时)","提醒时间(小时)",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		public EAM_INSPECTION_PLAN() {
			this.init($NAME,"巡检计划" , ID , PLAN_CODE , NAME , STATUS , PLAN_STATUS , PLAN_TYPE , LEADER_ID , GROUP_ID , START_DATE , END_DATE , ACTION_CYCLE_ID , INSPECTION_METHOD , COMPLETION_TIME , OVERTIME_METHOD , REMIND_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , SELECTED_CODE);
		}
		public static final EAM_INSPECTION_PLAN $TABLE=new EAM_INSPECTION_PLAN();
	}
	
	/**
	 * 巡检点
	*/
	public static class EAM_INSPECTION_PLAN_POINT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_plan_point";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 巡检计划
		*/
		public static final DBField PLAN_ID = new DBField(DBDataType.STRING , "plan_id","planId","巡检计划","巡检计划",false,false,true);
		
		/**
		 * 巡检点
		*/
		public static final DBField POINT_ID = new DBField(DBDataType.STRING , "point_id","pointId","巡检点","巡检点",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_INSPECTION_PLAN_POINT() {
			this.init($NAME,"巡检点" , ID , PLAN_ID , POINT_ID , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_INSPECTION_PLAN_POINT $TABLE=new EAM_INSPECTION_PLAN_POINT();
	}
	
	/**
	 * 巡检点
	*/
	public static class EAM_INSPECTION_POINT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_point";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 巡检内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","巡检内容","巡检内容",false,false,true);
		
		/**
		 * 巡检路线
		*/
		public static final DBField ROUTE_ID = new DBField(DBDataType.STRING , "route_id","routeId","巡检路线","巡检路线",false,false,true);
		
		/**
		 * RFID
		*/
		public static final DBField RFID = new DBField(DBDataType.STRING , "rfid","rfid","RFID","RFID",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POS = new DBField(DBDataType.STRING , "pos","pos","位置","位置",false,false,true);
		
		/**
		 * 位置经度
		*/
		public static final DBField POS_LONGITUDE = new DBField(DBDataType.STRING , "pos_longitude","posLongitude","位置经度","位置经度",false,false,true);
		
		/**
		 * 位置纬度
		*/
		public static final DBField POS_LATITUDE = new DBField(DBDataType.STRING , "pos_latitude","posLatitude","位置纬度","位置纬度",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_INSPECTION_POINT() {
			this.init($NAME,"巡检点" , ID , CODE , NAME , STATUS , CONTENT , ROUTE_ID , RFID , POS , POS_LONGITUDE , POS_LATITUDE , NOTES , PICTURE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , SELECTED_CODE , VERSION);
		}
		public static final EAM_INSPECTION_POINT $TABLE=new EAM_INSPECTION_POINT();
	}
	
	/**
	 * 巡检点
	*/
	public static class EAM_INSPECTION_POINT_OWNER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_point_owner";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 巡检计划
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","巡检计划","巡检计划",false,false,true);
		
		/**
		 * 巡检点
		*/
		public static final DBField POINT_ID = new DBField(DBDataType.STRING , "point_id","pointId","巡检点","巡检点",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_INSPECTION_POINT_OWNER() {
			this.init($NAME,"巡检点" , ID , OWNER_ID , POINT_ID , SORT , NOTES , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_INSPECTION_POINT_OWNER $TABLE=new EAM_INSPECTION_POINT_OWNER();
	}
	
	/**
	 * 巡检路径
	*/
	public static class EAM_INSPECTION_ROUTE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_route";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 路径
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","路径","路径",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_INSPECTION_ROUTE() {
			this.init($NAME,"巡检路径" , ID , NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_INSPECTION_ROUTE $TABLE=new EAM_INSPECTION_ROUTE();
	}
	
	/**
	 * 巡检任务
	*/
	public static class EAM_INSPECTION_TASK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_task";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 巡检计划
		*/
		public static final DBField PLAN_ID = new DBField(DBDataType.STRING , "plan_id","planId","巡检计划","巡检计划",false,false,true);
		
		/**
		 * 任务状态
		*/
		public static final DBField TASK_STATUS = new DBField(DBDataType.STRING , "task_status","taskStatus","任务状态","任务状态",false,false,true);
		
		/**
		 * 任务编号
		*/
		public static final DBField TASK_CODE = new DBField(DBDataType.STRING , "task_code","taskCode","任务编号","任务编号",false,false,true);
		
		/**
		 * 巡检编码
		*/
		public static final DBField PLAN_CODE = new DBField(DBDataType.STRING , "plan_code","planCode","巡检编码","巡检编码",false,false,true);
		
		/**
		 * 巡检名称
		*/
		public static final DBField PLAN_NAME = new DBField(DBDataType.STRING , "plan_name","planName","巡检名称","巡检名称",false,false,true);
		
		/**
		 * 巡检顺序
		*/
		public static final DBField PLAN_INSPECTION_METHOD = new DBField(DBDataType.STRING , "plan_inspection_method","planInspectionMethod","巡检顺序","巡检顺序",false,false,true);
		
		/**
		 * 时间要求
		*/
		public static final DBField PLAN_COMPLETION_TIME = new DBField(DBDataType.DECIMAL , "plan_completion_time","planCompletionTime","时间要求","时间要求",false,false,true);
		
		/**
		 * 巡检备注
		*/
		public static final DBField PLAN_NOTES = new DBField(DBDataType.STRING , "plan_notes","planNotes","巡检备注","巡检备注",false,false,true);
		
		/**
		 * 巡检班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","巡检班组","巡检班组",false,false,true);
		
		/**
		 * 执行人
		*/
		public static final DBField EXECUTOR_ID = new DBField(DBDataType.STRING , "executor_id","executorId","执行人","执行人",false,false,true);
		
		/**
		 * 应开始时间
		*/
		public static final DBField PLAN_START_TIME = new DBField(DBDataType.DATE , "plan_start_time","planStartTime","应开始时间","应开始时间",false,false,true);
		
		/**
		 * 实际开始时间
		*/
		public static final DBField ACT_START_TIME = new DBField(DBDataType.DATE , "act_start_time","actStartTime","实际开始时间","实际开始时间",false,false,true);
		
		/**
		 * 实际完成时间
		*/
		public static final DBField ACT_FINISH_TIME = new DBField(DBDataType.DATE , "act_finish_time","actFinishTime","实际完成时间","实际完成时间",false,false,true);
		
		/**
		 * 实际工时
		*/
		public static final DBField ACT_TOTAL_COST = new DBField(DBDataType.DECIMAL , "act_total_cost","actTotalCost","实际工时","实际工时",false,false,true);
		
		/**
		 * 任务反馈
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","任务反馈","任务反馈",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		public EAM_INSPECTION_TASK() {
			this.init($NAME,"巡检任务" , ID , PLAN_ID , TASK_STATUS , TASK_CODE , PLAN_CODE , PLAN_NAME , PLAN_INSPECTION_METHOD , PLAN_COMPLETION_TIME , PLAN_NOTES , GROUP_ID , EXECUTOR_ID , PLAN_START_TIME , ACT_START_TIME , ACT_FINISH_TIME , ACT_TOTAL_COST , CONTENT , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , SELECTED_CODE);
		}
		public static final EAM_INSPECTION_TASK $TABLE=new EAM_INSPECTION_TASK();
	}
	
	/**
	 * 巡检点
	*/
	public static class EAM_INSPECTION_TASK_POINT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inspection_task_point";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 任务
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","任务","任务",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 巡检状态
		*/
		public static final DBField POINT_STATUS = new DBField(DBDataType.STRING , "point_status","pointStatus","巡检状态","巡检状态",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField OPER_TIME = new DBField(DBDataType.DATE , "oper_time","operTime","操作时间","操作时间",false,false,true);
		
		/**
		 * 巡检结果
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","巡检结果","巡检结果",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField POINT_CODE = new DBField(DBDataType.STRING , "point_code","pointCode","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField POINT_NAME = new DBField(DBDataType.STRING , "point_name","pointName","名称","名称",false,false,true);
		
		/**
		 * 巡检内容
		*/
		public static final DBField POINT_CONTENT = new DBField(DBDataType.STRING , "point_content","pointContent","巡检内容","巡检内容",false,false,true);
		
		/**
		 * 巡检路线
		*/
		public static final DBField POINT_ROUTE_ID = new DBField(DBDataType.STRING , "point_route_id","pointRouteId","巡检路线","巡检路线",false,false,true);
		
		/**
		 * RFID
		*/
		public static final DBField POINT_RFID = new DBField(DBDataType.STRING , "point_rfid","pointRfid","RFID","RFID",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POINT_POS = new DBField(DBDataType.STRING , "point_pos","pointPos","位置","位置",false,false,true);
		
		/**
		 * 位置经度
		*/
		public static final DBField POINT_POS_LONGITUDE = new DBField(DBDataType.STRING , "point_pos_longitude","pointPosLongitude","位置经度","位置经度",false,false,true);
		
		/**
		 * 位置纬度
		*/
		public static final DBField POINT_POS_LATITUDE = new DBField(DBDataType.STRING , "point_pos_latitude","pointPosLatitude","位置纬度","位置纬度",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField POINT_NOTES = new DBField(DBDataType.STRING , "point_notes","pointNotes","备注","备注",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_ID = new DBField(DBDataType.STRING , "oper_id","operId","操作人","操作人",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_INSPECTION_TASK_POINT() {
			this.init($NAME,"巡检点" , ID , TASK_ID , STATUS , POINT_STATUS , OPER_TIME , CONTENT , POINT_CODE , POINT_NAME , POINT_CONTENT , POINT_ROUTE_ID , POINT_RFID , POINT_POS , POINT_POS_LONGITUDE , POINT_POS_LATITUDE , POINT_NOTES , SORT , OPER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , SELECTED_CODE , VERSION);
		}
		public static final EAM_INSPECTION_TASK_POINT $TABLE=new EAM_INSPECTION_TASK_POINT();
	}
	
	/**
	 * 资产盘点
	*/
	public static class EAM_INVENTORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 业务编码
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编码","业务编码",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","所属","所属",false,false,true);
		
		/**
		 * 业务状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","业务状态","业务状态",false,false,true);
		
		/**
		 * 盘点名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","盘点名称","盘点名称",false,false,true);
		
		/**
		 * 盘点状态
		*/
		public static final DBField INVENTORY_STATUS = new DBField(DBDataType.STRING , "inventory_status","inventoryStatus","盘点状态","盘点状态",false,false,true);
		
		/**
		 * 数据状态
		*/
		public static final DBField DATA_STATUS = new DBField(DBDataType.STRING , "data_status","dataStatus","数据状态","数据状态",false,false,true);
		
		/**
		 * 全员盘点
		*/
		public static final DBField ALL_EMPLOYEE = new DBField(DBDataType.STRING , "all_employee","allEmployee","全员盘点","全员盘点",false,false,true);
		
		/**
		 * 资产状态
		*/
		public static final DBField ASSET_STATUS = new DBField(DBDataType.STRING , "asset_status","assetStatus","资产状态","资产状态",false,false,true);
		
		/**
		 * 资产分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","资产分类","资产分类",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 使用公司/部门
		*/
		public static final DBField USE_ORGANIZATION_ID = new DBField(DBDataType.STRING , "use_organization_id","useOrganizationId","使用公司/部门","使用公司/部门",false,false,true);
		
		/**
		 * 购置开始日期
		*/
		public static final DBField PURCHASE_START_DATE = new DBField(DBDataType.DATE , "purchase_start_date","purchaseStartDate","购置开始日期","购置开始日期",false,false,true);
		
		/**
		 * 购置结束日期
		*/
		public static final DBField PURCHASE_END_DATE = new DBField(DBDataType.DATE , "purchase_end_date","purchaseEndDate","购置结束日期","购置结束日期",false,false,true);
		
		/**
		 * 盘点开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","盘点开始时间","盘点开始时间",false,false,true);
		
		/**
		 * 盘点结束时间
		*/
		public static final DBField FINISH_TIME = new DBField(DBDataType.DATE , "finish_time","finishTime","盘点结束时间","盘点结束时间",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 计划编号
		*/
		public static final DBField PLAN_ID = new DBField(DBDataType.STRING , "plan_id","planId","计划编号","计划编号",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_INVENTORY() {
			this.init($NAME,"资产盘点" , ID , TYPE , BUSINESS_CODE , OWNER_CODE , STATUS , NAME , INVENTORY_STATUS , DATA_STATUS , ALL_EMPLOYEE , ASSET_STATUS , CATEGORY_ID , OWN_COMPANY_ID , USE_ORGANIZATION_ID , PURCHASE_START_DATE , PURCHASE_END_DATE , START_TIME , FINISH_TIME , ORIGINATOR_ID , BUSINESS_DATE , NOTES , PLAN_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_INVENTORY $TABLE=new EAM_INVENTORY();
	}
	
	/**
	 * 盘点明细
	*/
	public static class EAM_INVENTORY_ASSET extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_asset";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 盘点
		*/
		public static final DBField INVENTORY_ID = new DBField(DBDataType.STRING , "inventory_id","inventoryId","盘点","盘点",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 资产
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产","资产",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField OPER_EMPL_ID = new DBField(DBDataType.STRING , "oper_empl_id","operEmplId","员工","员工",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField OPER_DATE = new DBField(DBDataType.DATE , "oper_date","operDate","操作时间","操作时间",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_INVENTORY_ASSET() {
			this.init($NAME,"盘点明细" , ID , INVENTORY_ID , STATUS , ASSET_ID , OPER_EMPL_ID , OPER_DATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INVENTORY_ASSET $TABLE=new EAM_INVENTORY_ASSET();
	}
	
	/**
	 * 盘点分类
	*/
	public static class EAM_INVENTORY_CATALOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_catalog";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 盘点
		*/
		public static final DBField INVENTORY_ID = new DBField(DBDataType.STRING , "inventory_id","inventoryId","盘点","盘点",false,false,true);
		
		/**
		 * 分类
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","分类","分类",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_INVENTORY_CATALOG() {
			this.init($NAME,"盘点分类" , ID , INVENTORY_ID , VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INVENTORY_CATALOG $TABLE=new EAM_INVENTORY_CATALOG();
	}
	
	/**
	 * 盘点负责人
	*/
	public static class EAM_INVENTORY_DIRECTOR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_director";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 盘点
		*/
		public static final DBField INVENTORY_ID = new DBField(DBDataType.STRING , "inventory_id","inventoryId","盘点","盘点",false,false,true);
		
		/**
		 * 盘点人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","盘点人","盘点人",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_INVENTORY_DIRECTOR() {
			this.init($NAME,"盘点负责人" , ID , INVENTORY_ID , USER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INVENTORY_DIRECTOR $TABLE=new EAM_INVENTORY_DIRECTOR();
	}
	
	/**
	 * 资产管理人
	*/
	public static class EAM_INVENTORY_MANAGER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_manager";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 盘点
		*/
		public static final DBField INVENTORY_ID = new DBField(DBDataType.STRING , "inventory_id","inventoryId","盘点","盘点",false,false,true);
		
		/**
		 * 盘点人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","盘点人","盘点人",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_INVENTORY_MANAGER() {
			this.init($NAME,"资产管理人" , ID , INVENTORY_ID , USER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INVENTORY_MANAGER $TABLE=new EAM_INVENTORY_MANAGER();
	}
	
	/**
	 * 盘点计划
	*/
	public static class EAM_INVENTORY_PLAN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_plan";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 计划名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","计划名称","计划名称",false,false,true);
		
		/**
		 * 归属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","归属","归属",false,false,true);
		
		/**
		 * 启用状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","启用状态","启用状态",false,false,true);
		
		/**
		 * 计划类型
		*/
		public static final DBField PLAN_TYPE = new DBField(DBDataType.STRING , "plan_type","planType","计划类型","计划类型",false,false,true);
		
		/**
		 * 模板
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模板","模板",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_INVENTORY_PLAN() {
			this.init($NAME,"盘点计划" , ID , NAME , OWNER_CODE , STATUS , PLAN_TYPE , TPL_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_INVENTORY_PLAN $TABLE=new EAM_INVENTORY_PLAN();
	}
	
	/**
	 * 盘点位置
	*/
	public static class EAM_INVENTORY_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 盘点
		*/
		public static final DBField INVENTORY_ID = new DBField(DBDataType.STRING , "inventory_id","inventoryId","盘点","盘点",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","位置","位置",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_INVENTORY_POSITION() {
			this.init($NAME,"盘点位置" , ID , INVENTORY_ID , VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INVENTORY_POSITION $TABLE=new EAM_INVENTORY_POSITION();
	}
	
	/**
	 * 盘点用户
	*/
	public static class EAM_INVENTORY_USER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_user";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 盘点
		*/
		public static final DBField INVENTORY_ID = new DBField(DBDataType.STRING , "inventory_id","inventoryId","盘点","盘点",false,false,true);
		
		/**
		 * 盘点人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","盘点人","盘点人",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_INVENTORY_USER() {
			this.init($NAME,"盘点用户" , ID , INVENTORY_ID , USER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INVENTORY_USER $TABLE=new EAM_INVENTORY_USER();
	}
	
	/**
	 * 盘点仓库
	*/
	public static class EAM_INVENTORY_WAREHOUSE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_inventory_warehouse";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 盘点
		*/
		public static final DBField INVENTORY_ID = new DBField(DBDataType.STRING , "inventory_id","inventoryId","盘点","盘点",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","仓库","仓库",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_INVENTORY_WAREHOUSE() {
			this.init($NAME,"盘点仓库" , ID , INVENTORY_ID , VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_INVENTORY_WAREHOUSE $TABLE=new EAM_INVENTORY_WAREHOUSE();
	}
	
	/**
	 * 保养班组
	*/
	public static class EAM_MAINTAIN_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_maintain_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField LEADER_ID = new DBField(DBDataType.STRING , "leader_id","leaderId","负责人","负责人",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_MAINTAIN_GROUP() {
			this.init($NAME,"保养班组" , ID , NAME , STATUS , LEADER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_MAINTAIN_GROUP $TABLE=new EAM_MAINTAIN_GROUP();
	}
	
	/**
	 * 保养方案
	*/
	public static class EAM_MAINTAIN_PLAN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_maintain_plan";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 方案名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","方案名称","方案名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 执行班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","执行班组","执行班组",false,false,true);
		
		/**
		 * 保养类型
		*/
		public static final DBField MAINTAIN_TYPE = new DBField(DBDataType.STRING , "maintain_type","maintainType","保养类型","保养类型",false,false,true);
		
		/**
		 * 循环方式
		*/
		public static final DBField CYCLE_METHOD = new DBField(DBDataType.STRING , "cycle_method","cycleMethod","循环方式","循环方式",false,false,true);
		
		/**
		 * 保养周期
		*/
		public static final DBField ACTION_CYCLE_ID = new DBField(DBDataType.STRING , "action_cycle_id","actionCycleId","保养周期","保养周期",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 总工时
		*/
		public static final DBField TOTAL_COST = new DBField(DBDataType.DECIMAL , "total_cost","totalCost","总工时","总工时",false,false,true);
		
		/**
		 * 超时时间
		*/
		public static final DBField TIMEOUT = new DBField(DBDataType.DECIMAL , "timeout","timeout","超时时间","超时时间",false,false,true);
		
		/**
		 * 方案说明
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","方案说明","方案说明",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_MAINTAIN_PLAN() {
			this.init($NAME,"保养方案" , ID , CODE , NAME , STATUS , GROUP_ID , MAINTAIN_TYPE , CYCLE_METHOD , ACTION_CYCLE_ID , START_TIME , END_TIME , TOTAL_COST , TIMEOUT , INFO , NOTES , ORIGINATOR_ID , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_MAINTAIN_PLAN $TABLE=new EAM_MAINTAIN_PLAN();
	}
	
	/**
	 * 保养项目
	*/
	public static class EAM_MAINTAIN_PROJECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_maintain_project";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 项目编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","项目编号","项目编号",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","项目名称","项目名称",false,false,true);
		
		/**
		 * 保养类型
		*/
		public static final DBField MAINTAIN_TYPE = new DBField(DBDataType.STRING , "maintain_type","maintainType","保养类型","保养类型",false,false,true);
		
		/**
		 * 标准工时(小时)
		*/
		public static final DBField BASE_COST = new DBField(DBDataType.DECIMAL , "base_cost","baseCost","标准工时(小时)","标准工时(小时)",false,false,true);
		
		/**
		 * 保养周期
		*/
		public static final DBField ACTION_CYCLE_ID = new DBField(DBDataType.STRING , "action_cycle_id","actionCycleId","保养周期","保养周期",false,false,true);
		
		/**
		 * 保养手册
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","保养手册","保养手册",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_MAINTAIN_PROJECT() {
			this.init($NAME,"保养项目" , ID , CODE , STATUS , NAME , MAINTAIN_TYPE , BASE_COST , ACTION_CYCLE_ID , ATTACH_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , SELECTED_CODE , VERSION);
		}
		public static final EAM_MAINTAIN_PROJECT $TABLE=new EAM_MAINTAIN_PROJECT();
	}
	
	/**
	 * 项目
	*/
	public static class EAM_MAINTAIN_PROJECT_SELECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_maintain_project_select";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 处理
		*/
		public static final DBField PROJECT_ID = new DBField(DBDataType.STRING , "project_id","projectId","处理","处理",false,false,true);
		
		/**
		 * 资产
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","资产","资产",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
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
		
		public EAM_MAINTAIN_PROJECT_SELECT() {
			this.init($NAME,"项目" , ID , PROJECT_ID , OWNER_ID , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_MAINTAIN_PROJECT_SELECT $TABLE=new EAM_MAINTAIN_PROJECT_SELECT();
	}
	
	/**
	 * 保养任务
	*/
	public static class EAM_MAINTAIN_TASK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_maintain_task";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 逾期
		*/
		public static final DBField OVERDUE = new DBField(DBDataType.STRING , "overdue","overdue","逾期","逾期",false,false,true);
		
		/**
		 * 任务编码
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","任务编码","任务编码",false,false,true);
		
		/**
		 * 方案
		*/
		public static final DBField PLAN_ID = new DBField(DBDataType.STRING , "plan_id","planId","方案","方案",false,false,true);
		
		/**
		 * 方案名称
		*/
		public static final DBField PLAN_NAME = new DBField(DBDataType.STRING , "plan_name","planName","方案名称","方案名称",false,false,true);
		
		/**
		 * 方案说明
		*/
		public static final DBField PLAN_INFO = new DBField(DBDataType.STRING , "plan_info","planInfo","方案说明","方案说明",false,false,true);
		
		/**
		 * 方案备注
		*/
		public static final DBField PLAN_NOTES = new DBField(DBDataType.STRING , "plan_notes","planNotes","方案备注","方案备注",false,false,true);
		
		/**
		 * 保养类型
		*/
		public static final DBField PLAN_MAINTAIN_TYPE = new DBField(DBDataType.STRING , "plan_maintain_type","planMaintainType","保养类型","保养类型",false,false,true);
		
		/**
		 * 循环方式
		*/
		public static final DBField PLAN_CYCLE_METHOD = new DBField(DBDataType.STRING , "plan_cycle_method","planCycleMethod","循环方式","循环方式",false,false,true);
		
		/**
		 * 计划工时
		*/
		public static final DBField PLAN_TOTAL_COST = new DBField(DBDataType.DECIMAL , "plan_total_cost","planTotalCost","计划工时","计划工时",false,false,true);
		
		/**
		 * 班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","班组","班组",false,false,true);
		
		/**
		 * 设备
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","设备","设备",false,false,true);
		
		/**
		 * 设备名称
		*/
		public static final DBField ASSET_NAME = new DBField(DBDataType.STRING , "asset_name","assetName","设备名称","设备名称",false,false,true);
		
		/**
		 * 设备型号
		*/
		public static final DBField ASSET_MODEL = new DBField(DBDataType.STRING , "asset_model","assetModel","设备型号","设备型号",false,false,true);
		
		/**
		 * 设备状态
		*/
		public static final DBField ASSET_STATUS = new DBField(DBDataType.STRING , "asset_status","assetStatus","设备状态","设备状态",false,false,true);
		
		/**
		 * 设备编码
		*/
		public static final DBField ASSET_CODE = new DBField(DBDataType.STRING , "asset_code","assetCode","设备编码","设备编码",false,false,true);
		
		/**
		 * 设备序列号
		*/
		public static final DBField ASSET_SN = new DBField(DBDataType.STRING , "asset_sn","assetSn","设备序列号","设备序列号",false,false,true);
		
		/**
		 * 执行人
		*/
		public static final DBField EXECUTOR_ID = new DBField(DBDataType.STRING , "executor_id","executorId","执行人","执行人",false,false,true);
		
		/**
		 * 应开始时间
		*/
		public static final DBField PLAN_START_TIME = new DBField(DBDataType.DATE , "plan_start_time","planStartTime","应开始时间","应开始时间",false,false,true);
		
		/**
		 * 实际开始时间
		*/
		public static final DBField ACT_START_TIME = new DBField(DBDataType.DATE , "act_start_time","actStartTime","实际开始时间","实际开始时间",false,false,true);
		
		/**
		 * 实际完成时间
		*/
		public static final DBField ACT_FINISH_TIME = new DBField(DBDataType.DATE , "act_finish_time","actFinishTime","实际完成时间","实际完成时间",false,false,true);
		
		/**
		 * 实际工时
		*/
		public static final DBField ACT_TOTAL_COST = new DBField(DBDataType.DECIMAL , "act_total_cost","actTotalCost","实际工时","实际工时",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_MAINTAIN_TASK() {
			this.init($NAME,"保养任务" , ID , STATUS , OVERDUE , BUSINESS_CODE , PLAN_ID , PLAN_NAME , PLAN_INFO , PLAN_NOTES , PLAN_MAINTAIN_TYPE , PLAN_CYCLE_METHOD , PLAN_TOTAL_COST , GROUP_ID , ASSET_ID , ASSET_NAME , ASSET_MODEL , ASSET_STATUS , ASSET_CODE , ASSET_SN , EXECUTOR_ID , PLAN_START_TIME , ACT_START_TIME , ACT_FINISH_TIME , ACT_TOTAL_COST , NOTES , SELECTED_CODE , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_MAINTAIN_TASK $TABLE=new EAM_MAINTAIN_TASK();
	}
	
	/**
	 * 保养项目
	*/
	public static class EAM_MAINTAIN_TASK_PROJECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_maintain_task_project";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 项目
		*/
		public static final DBField PROJECT_ID = new DBField(DBDataType.STRING , "project_id","projectId","项目","项目",false,false,true);
		
		/**
		 * 任务
		*/
		public static final DBField TASK_ID = new DBField(DBDataType.STRING , "task_id","taskId","任务","任务",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 项目编号
		*/
		public static final DBField PROJECT_CODE = new DBField(DBDataType.STRING , "project_code","projectCode","项目编号","项目编号",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目名称","项目名称",false,false,true);
		
		/**
		 * 保养类型
		*/
		public static final DBField PROJECT_MAINTAIN_TYPE = new DBField(DBDataType.STRING , "project_maintain_type","projectMaintainType","保养类型","保养类型",false,false,true);
		
		/**
		 * 标准工时(小时)
		*/
		public static final DBField PROJECT_BASE_COST = new DBField(DBDataType.DECIMAL , "project_base_cost","projectBaseCost","标准工时(小时)","标准工时(小时)",false,false,true);
		
		/**
		 * 保养手册
		*/
		public static final DBField PROJECT_ATTACH_ID = new DBField(DBDataType.STRING , "project_attach_id","projectAttachId","保养手册","保养手册",false,false,true);
		
		/**
		 * 项目备注
		*/
		public static final DBField PROJECT_NOTES = new DBField(DBDataType.STRING , "project_notes","projectNotes","项目备注","项目备注",false,false,true);
		
		/**
		 * 标准工时(小时)
		*/
		public static final DBField BASE_COST = new DBField(DBDataType.DECIMAL , "base_cost","baseCost","标准工时(小时)","标准工时(小时)",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_MAINTAIN_TASK_PROJECT() {
			this.init($NAME,"保养项目" , ID , PROJECT_ID , TASK_ID , STATUS , PROJECT_CODE , PROJECT_NAME , PROJECT_MAINTAIN_TYPE , PROJECT_BASE_COST , PROJECT_ATTACH_ID , PROJECT_NOTES , BASE_COST , START_TIME , END_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , SELECTED_CODE , VERSION);
		}
		public static final EAM_MAINTAIN_TASK_PROJECT $TABLE=new EAM_MAINTAIN_TASK_PROJECT();
	}
	
	/**
	 * 维保厂商
	*/
	public static class EAM_MAINTAINER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_maintainer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField MAINTAINER_NAME = new DBField(DBDataType.STRING , "maintainer_name","maintainerName","名称","名称",false,false,true);
		
		/**
		 * 商务联系人
		*/
		public static final DBField BUSINESS_CONTACTS = new DBField(DBDataType.STRING , "business_contacts","businessContacts","商务联系人","商务联系人",false,false,true);
		
		/**
		 * 商务联系方式
		*/
		public static final DBField BUSINESS_CONTACTS_INFO = new DBField(DBDataType.STRING , "business_contacts_info","businessContactsInfo","商务联系方式","商务联系方式",false,false,true);
		
		/**
		 * 售后联系人
		*/
		public static final DBField AFTER_SALES_CONTACTS = new DBField(DBDataType.STRING , "after_sales_contacts","afterSalesContacts","售后联系人","售后联系人",false,false,true);
		
		/**
		 * 售后联系方式
		*/
		public static final DBField AFTER_SALES_CONTACTS_INFO = new DBField(DBDataType.STRING , "after_sales_contacts_info","afterSalesContactsInfo","售后联系方式","售后联系方式",false,false,true);
		
		/**
		 * 统一社会信用代码
		*/
		public static final DBField UNIT_CODE = new DBField(DBDataType.STRING , "unit_code","unitCode","统一社会信用代码","统一社会信用代码",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField MAINTAINER_NOTES = new DBField(DBDataType.STRING , "maintainer_notes","maintainerNotes","备注","备注",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_MAINTAINER() {
			this.init($NAME,"维保厂商" , ID , MAINTAINER_NAME , BUSINESS_CONTACTS , BUSINESS_CONTACTS_INFO , AFTER_SALES_CONTACTS , AFTER_SALES_CONTACTS_INFO , UNIT_CODE , ADDRESS , MAINTAINER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_MAINTAINER $TABLE=new EAM_MAINTAINER();
	}
	
	/**
	 * 生产厂商
	*/
	public static class EAM_MANUFACTURER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_manufacturer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField MANUFACTURER_NAME = new DBField(DBDataType.STRING , "manufacturer_name","manufacturerName","名称","名称",false,false,true);
		
		/**
		 * 所在地
		*/
		public static final DBField LOCATION = new DBField(DBDataType.STRING , "location","location","所在地","所在地",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField MANUFACTURER_NOTES = new DBField(DBDataType.STRING , "manufacturer_notes","manufacturerNotes","备注","备注",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_MANUFACTURER() {
			this.init($NAME,"生产厂商" , ID , MANUFACTURER_NAME , LOCATION , MANUFACTURER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_MANUFACTURER $TABLE=new EAM_MANUFACTURER();
	}
	
	/**
	 * 资产操作
	*/
	public static class EAM_OPERATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_operate";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 分配编号
		*/
		public static final DBField ALLOCATE_CODE = new DBField(DBDataType.STRING , "allocate_code","allocateCode","分配编号","分配编号",false,false,true);
		
		/**
		 * 操作编码
		*/
		public static final DBField OPERATE_CODE = new DBField(DBDataType.STRING , "operate_code","operateCode","操作编码","操作编码",false,false,true);
		
		/**
		 * 审批
		*/
		public static final DBField APPROVAL = new DBField(DBDataType.STRING , "approval","approval","审批","审批",false,false,true);
		
		/**
		 * 数据编码
		*/
		public static final DBField CUST_DATA_CODE = new DBField(DBDataType.STRING , "cust_data_code","custDataCode","数据编码","数据编码",false,false,true);
		
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
		
		public EAM_OPERATE() {
			this.init($NAME,"资产操作" , ID , NAME , ALLOCATE_CODE , OPERATE_CODE , APPROVAL , CUST_DATA_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_OPERATE $TABLE=new EAM_OPERATE();
	}
	
	/**
	 * 存放位置
	*/
	public static class EAM_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		
		public EAM_POSITION() {
			this.init($NAME,"存放位置" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_POSITION $TABLE=new EAM_POSITION();
	}
	
	/**
	 * 采购申请
	*/
	public static class EAM_PURCHASE_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_purchase_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 申请状态
		*/
		public static final DBField APPLY_STATUS = new DBField(DBDataType.STRING , "apply_status","applyStatus","申请状态","申请状态",false,false,true);
		
		/**
		 * 申请部门
		*/
		public static final DBField APPLY_ORG_ID = new DBField(DBDataType.STRING , "apply_org_id","applyOrgId","申请部门","申请部门",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","供应商","供应商",false,false,true);
		
		/**
		 * 收货信息
		*/
		public static final DBField HARVEST_INFORMATION = new DBField(DBDataType.STRING , "harvest_information","harvestInformation","收货信息","收货信息",false,false,true);
		
		/**
		 * 期望到货时间
		*/
		public static final DBField EXPECTED_ARRIVAL_DATE = new DBField(DBDataType.STRING , "expected_arrival_date","expectedArrivalDate","期望到货时间","期望到货时间",false,false,true);
		
		/**
		 * 申请说明
		*/
		public static final DBField APPLY_CONTENT = new DBField(DBDataType.STRING , "apply_content","applyContent","申请说明","申请说明",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField APPLY_DATE = new DBField(DBDataType.STRING , "apply_date","applyDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 验收情况
		*/
		public static final DBField ASSET_CHECK = new DBField(DBDataType.STRING , "asset_check","assetCheck","验收情况","验收情况",false,false,true);
		
		/**
		 * 验收编号
		*/
		public static final DBField CHECK_CODE = new DBField(DBDataType.STRING , "check_code","checkCode","验收编号","验收编号",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_PURCHASE_APPLY() {
			this.init($NAME,"采购申请" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , APPLY_STATUS , APPLY_ORG_ID , SUPPLIER_ID , HARVEST_INFORMATION , EXPECTED_ARRIVAL_DATE , APPLY_CONTENT , APPLY_DATE , ASSET_CHECK , CHECK_CODE , NOTES , ATTACH , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_PURCHASE_APPLY $TABLE=new EAM_PURCHASE_APPLY();
	}
	
	/**
	 * 申请明细
	*/
	public static class EAM_PURCHASE_APPLY_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_purchase_apply_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 订单
		*/
		public static final DBField APPLY_ID = new DBField(DBDataType.STRING , "apply_id","applyId","订单","订单",false,false,false);
		
		/**
		 * 资产
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.STRING , "order_id","orderId","资产","资产",false,false,false);
		
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
		
		public EAM_PURCHASE_APPLY_ITEM() {
			this.init($NAME,"申请明细" , ID , APPLY_ID , ORDER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_PURCHASE_APPLY_ITEM $TABLE=new EAM_PURCHASE_APPLY_ITEM();
	}
	
	/**
	 * 采购验收
	*/
	public static class EAM_PURCHASE_CHECK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_purchase_check";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 采购申请
		*/
		public static final DBField APPLY_ID = new DBField(DBDataType.STRING , "apply_id","applyId","采购申请","采购申请",false,false,true);
		
		/**
		 * 验收单
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","验收单","验收单",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","供应商","供应商",false,false,true);
		
		/**
		 * 验收部门
		*/
		public static final DBField CHECK_ORG_ID = new DBField(DBDataType.STRING , "check_org_id","checkOrgId","验收部门","验收部门",false,false,true);
		
		/**
		 * 验收人
		*/
		public static final DBField CHECK_USER_NAME = new DBField(DBDataType.STRING , "check_user_name","checkUserName","验收人","验收人",false,false,true);
		
		/**
		 * 到货日期
		*/
		public static final DBField RECEIVE_DATE = new DBField(DBDataType.STRING , "receive_date","receiveDate","到货日期","到货日期",false,false,true);
		
		/**
		 * 验收时间
		*/
		public static final DBField CHECK_DATE = new DBField(DBDataType.STRING , "check_date","checkDate","验收时间","验收时间",false,false,true);
		
		/**
		 * 验收信息
		*/
		public static final DBField CHECK_INFORMATION = new DBField(DBDataType.STRING , "check_information","checkInformation","验收信息","验收信息",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_PURCHASE_CHECK() {
			this.init($NAME,"采购验收" , ID , PROC_ID , STATUS , BUSINESS_CODE , NAME , APPLY_ID , CODE , SUPPLIER_ID , CHECK_ORG_ID , CHECK_USER_NAME , RECEIVE_DATE , CHECK_DATE , CHECK_INFORMATION , NOTES , ATTACH , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_PURCHASE_CHECK $TABLE=new EAM_PURCHASE_CHECK();
	}
	
	/**
	 * 采购订单
	*/
	public static class EAM_PURCHASE_ORDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_purchase_order";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编码
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编码","业务编码",false,false,true);
		
		/**
		 * 订单编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","订单编号","订单编号",false,false,true);
		
		/**
		 * 订单名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","订单名称","订单名称",false,false,true);
		
		/**
		 * 采购申请单
		*/
		public static final DBField APPLY_ID = new DBField(DBDataType.STRING , "apply_id","applyId","采购申请单","采购申请单",false,false,true);
		
		/**
		 * 验收单
		*/
		public static final DBField CHECK_ID = new DBField(DBDataType.STRING , "check_id","checkId","验收单","验收单",false,false,true);
		
		/**
		 * 物品类型
		*/
		public static final DBField GOODS_TYPE = new DBField(DBDataType.STRING , "goods_type","goodsType","物品类型","物品类型",false,false,true);
		
		/**
		 * 存放类型
		*/
		public static final DBField STORAGE_TYPE = new DBField(DBDataType.STRING , "storage_type","storageType","存放类型","存放类型",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_PURCHASE_ORDER() {
			this.init($NAME,"采购订单" , ID , BUSINESS_CODE , CODE , NAME , APPLY_ID , CHECK_ID , GOODS_TYPE , STORAGE_TYPE , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_PURCHASE_ORDER $TABLE=new EAM_PURCHASE_ORDER();
	}
	
	/**
	 * 订单明细
	*/
	public static class EAM_PURCHASE_ORDER_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_purchase_order_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 订单
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.STRING , "order_id","orderId","订单","订单",false,false,false);
		
		/**
		 * 资产
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产","资产",false,false,false);
		
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
		
		public EAM_PURCHASE_ORDER_DETAIL() {
			this.init($NAME,"订单明细" , ID , ORDER_ID , ASSET_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_PURCHASE_ORDER_DETAIL $TABLE=new EAM_PURCHASE_ORDER_DETAIL();
	}
	
	/**
	 * 故障分类
	*/
	public static class EAM_REPAIR_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField REPAIR_NAME = new DBField(DBDataType.STRING , "repair_name","repairName","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField REPAIR_CODE = new DBField(DBDataType.STRING , "repair_code","repairCode","编码","编码",false,false,true);
		
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
		
		public EAM_REPAIR_CATEGORY() {
			this.init($NAME,"故障分类" , ID , REPAIR_NAME , REPAIR_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_REPAIR_CATEGORY $TABLE=new EAM_REPAIR_CATEGORY();
	}
	
	/**
	 * 故障模版
	*/
	public static class EAM_REPAIR_CATEGORY_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_category_tpl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 故障类型
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","故障类型","故障类型",false,false,true);
		
		/**
		 * 故障编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","故障编码","故障编码",false,false,true);
		
		/**
		 * 故障内容
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","故障内容","故障内容",false,false,true);
		
		/**
		 * 故障方案
		*/
		public static final DBField REPAIR_SOLUTION = new DBField(DBDataType.STRING , "repair_solution","repairSolution","故障方案","故障方案",false,false,true);
		
		/**
		 * 标准耗时
		*/
		public static final DBField COST_TIME = new DBField(DBDataType.INTEGER , "cost_time","costTime","标准耗时","标准耗时",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
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
		
		public EAM_REPAIR_CATEGORY_TPL() {
			this.init($NAME,"故障模版" , ID , STATUS , CATEGORY_ID , CODE , NAME , REPAIR_SOLUTION , COST_TIME , ATTACH_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_REPAIR_CATEGORY_TPL $TABLE=new EAM_REPAIR_CATEGORY_TPL();
	}
	
	/**
	 * 维修班组
	*/
	public static class EAM_REPAIR_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField LEADER_ID = new DBField(DBDataType.STRING , "leader_id","leaderId","负责人","负责人",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public EAM_REPAIR_GROUP() {
			this.init($NAME,"维修班组" , ID , NAME , STATUS , LEADER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final EAM_REPAIR_GROUP $TABLE=new EAM_REPAIR_GROUP();
	}
	
	/**
	 * 故障申请单
	*/
	public static class EAM_REPAIR_ORDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_order";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 维修状态
		*/
		public static final DBField REPAIR_STATUS = new DBField(DBDataType.STRING , "repair_status","repairStatus","维修状态","维修状态",false,false,true);
		
		/**
		 * 故障类型
		*/
		public static final DBField CATEGORY_TPL_ID = new DBField(DBDataType.STRING , "category_tpl_id","categoryTplId","故障类型","故障类型",false,false,true);
		
		/**
		 * 维修类型
		*/
		public static final DBField REPAIR_TYPE = new DBField(DBDataType.STRING , "repair_type","repairType","维修类型","维修类型",false,false,true);
		
		/**
		 * 紧急程度
		*/
		public static final DBField URGENCY_ID = new DBField(DBDataType.STRING , "urgency_id","urgencyId","紧急程度","紧急程度",false,false,true);
		
		/**
		 * 报修部门
		*/
		public static final DBField REPORT_ORG_ID = new DBField(DBDataType.STRING , "report_org_id","reportOrgId","报修部门","报修部门",false,false,true);
		
		/**
		 * 报修人
		*/
		public static final DBField REPORT_USER_ID = new DBField(DBDataType.STRING , "report_user_id","reportUserId","报修人","报修人",false,false,true);
		
		/**
		 * 维修费用
		*/
		public static final DBField REPAIR_COST = new DBField(DBDataType.DECIMAL , "repair_cost","repairCost","维修费用","维修费用",false,false,true);
		
		/**
		 * 计划完成日期
		*/
		public static final DBField PLAN_FINISH_DATE = new DBField(DBDataType.DATE , "plan_finish_date","planFinishDate","计划完成日期","计划完成日期",false,false,true);
		
		/**
		 * 报修内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","报修内容","报修内容",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 维修单
		*/
		public static final DBField AUTO_ACT = new DBField(DBDataType.STRING , "auto_act","autoAct","维修单","维修单",false,false,true);
		
		/**
		 * 创建规则
		*/
		public static final DBField AUTO_ACT_RULE = new DBField(DBDataType.STRING , "auto_act_rule","autoActRule","创建规则","创建规则",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_REPAIR_ORDER() {
			this.init($NAME,"故障申请单" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , REPAIR_STATUS , CATEGORY_TPL_ID , REPAIR_TYPE , URGENCY_ID , REPORT_ORG_ID , REPORT_USER_ID , REPAIR_COST , PLAN_FINISH_DATE , CONTENT , PICTURE_ID , ORIGINATOR_ID , BUSINESS_DATE , AUTO_ACT , AUTO_ACT_RULE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_REPAIR_ORDER $TABLE=new EAM_REPAIR_ORDER();
	}
	
	/**
	 * 维修验收
	*/
	public static class EAM_REPAIR_ORDER_ACCEPTANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_order_acceptance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 申请单
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.STRING , "order_id","orderId","申请单","申请单",false,false,true);
		
		/**
		 * 维修单
		*/
		public static final DBField ORDER_ACT_ID = new DBField(DBDataType.STRING , "order_act_id","orderActId","维修单","维修单",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 维修结果
		*/
		public static final DBField RESULT_TYPE = new DBField(DBDataType.STRING , "result_type","resultType","维修结果","维修结果",false,false,true);
		
		/**
		 * 验收人
		*/
		public static final DBField ACCEPTER_ID = new DBField(DBDataType.STRING , "accepter_id","accepterId","验收人","验收人",false,false,true);
		
		/**
		 * 实际故障
		*/
		public static final DBField CATEGORY_TPL_ID = new DBField(DBDataType.STRING , "category_tpl_id","categoryTplId","实际故障","实际故障",false,false,true);
		
		/**
		 * 实际花费
		*/
		public static final DBField ACTUAL_COST = new DBField(DBDataType.DECIMAL , "actual_cost","actualCost","实际花费","实际花费",false,false,true);
		
		/**
		 * 完成时间
		*/
		public static final DBField FINISH_TIME = new DBField(DBDataType.DATE , "finish_time","finishTime","完成时间","完成时间",false,false,true);
		
		/**
		 * 验收备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","验收备注","验收备注",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_REPAIR_ORDER_ACCEPTANCE() {
			this.init($NAME,"维修验收" , ID , ORDER_ID , ORDER_ACT_ID , BUSINESS_CODE , RESULT_TYPE , ACCEPTER_ID , CATEGORY_TPL_ID , ACTUAL_COST , FINISH_TIME , NOTES , PICTURE_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_REPAIR_ORDER_ACCEPTANCE $TABLE=new EAM_REPAIR_ORDER_ACCEPTANCE();
	}
	
	/**
	 * 维修工单
	*/
	public static class EAM_REPAIR_ORDER_ACT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_order_act";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 申请单
		*/
		public static final DBField ORDER_ID = new DBField(DBDataType.STRING , "order_id","orderId","申请单","申请单",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 维修班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","维修班组","维修班组",false,false,true);
		
		/**
		 * 执行人
		*/
		public static final DBField EXECUTOR_ID = new DBField(DBDataType.STRING , "executor_id","executorId","执行人","执行人",false,false,true);
		
		/**
		 * 维修费用
		*/
		public static final DBField REPAIR_COST = new DBField(DBDataType.DECIMAL , "repair_cost","repairCost","维修费用","维修费用",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 完成时间
		*/
		public static final DBField FINISH_TIME = new DBField(DBDataType.DATE , "finish_time","finishTime","完成时间","完成时间",false,false,true);
		
		/**
		 * 维修备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","维修备注","维修备注",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 跟随验证
		*/
		public static final DBField WITH_ACCEPTANCE = new DBField(DBDataType.STRING , "with_acceptance","withAcceptance","跟随验证","跟随验证",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public EAM_REPAIR_ORDER_ACT() {
			this.init($NAME,"维修工单" , ID , ORDER_ID , BUSINESS_CODE , GROUP_ID , EXECUTOR_ID , REPAIR_COST , START_TIME , FINISH_TIME , NOTES , PICTURE_ID , ORIGINATOR_ID , WITH_ACCEPTANCE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final EAM_REPAIR_ORDER_ACT $TABLE=new EAM_REPAIR_ORDER_ACT();
	}
	
	/**
	 * 分单规则
	*/
	public static class EAM_REPAIR_RULE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_rule";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 班组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","班组","班组",false,false,true);
		
		/**
		 * 成员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","成员","成员",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public EAM_REPAIR_RULE() {
			this.init($NAME,"分单规则" , ID , CODE , NAME , STATUS , GROUP_ID , USER_ID , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_REPAIR_RULE $TABLE=new EAM_REPAIR_RULE();
	}
	
	/**
	 * 规则单
	*/
	public static class EAM_REPAIR_RULE_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_rule_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 转发规则
		*/
		public static final DBField RULE_ID = new DBField(DBDataType.STRING , "rule_id","ruleId","转发规则","转发规则",false,false,true);
		
		/**
		 * 故障内容
		*/
		public static final DBField CATEGORY_TPL_ID = new DBField(DBDataType.STRING , "category_tpl_id","categoryTplId","故障内容","故障内容",false,false,true);
		
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
		
		public EAM_REPAIR_RULE_ITEM() {
			this.init($NAME,"规则单" , ID , RULE_ID , CATEGORY_TPL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_REPAIR_RULE_ITEM $TABLE=new EAM_REPAIR_RULE_ITEM();
	}
	
	/**
	 * 紧急程度
	*/
	public static class EAM_REPAIR_URGENCY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_repair_urgency";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public EAM_REPAIR_URGENCY() {
			this.init($NAME,"紧急程度" , ID , NAME , CODE , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_REPAIR_URGENCY $TABLE=new EAM_REPAIR_URGENCY();
	}
	
	/**
	 * 折旧策略
	*/
	public static class EAM_RESIDUAL_STRATEGY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_residual_strategy";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 策略描述
		*/
		public static final DBField STRATEGY_DESCRIBE = new DBField(DBDataType.STRING , "strategy_describe","strategyDescribe","策略描述","策略描述",false,false,true);
		
		/**
		 * 残值率
		*/
		public static final DBField RESIDUALVALUE_RATE = new DBField(DBDataType.DECIMAL , "residualvalue_rate","residualvalueRate","残值率","残值率",false,false,true);
		
		/**
		 * 折旧率
		*/
		public static final DBField DEPRECIATION_RATE = new DBField(DBDataType.DECIMAL , "depreciation_rate","depreciationRate","折旧率","折旧率",false,false,true);
		
		/**
		 * 设置值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","设置值","设置值",false,false,true);
		
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
		
		public EAM_RESIDUAL_STRATEGY() {
			this.init($NAME,"折旧策略" , ID , NAME , STATUS , STRATEGY_DESCRIBE , RESIDUALVALUE_RATE , DEPRECIATION_RATE , VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_RESIDUAL_STRATEGY $TABLE=new EAM_RESIDUAL_STRATEGY();
	}
	
	/**
	 * 资产审批角色
	*/
	public static class EAM_ROLE_APPROVE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_role_approve";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		
		public EAM_ROLE_APPROVE() {
			this.init($NAME,"资产审批角色" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_ROLE_APPROVE $TABLE=new EAM_ROLE_APPROVE();
	}
	
	/**
	 * 风险等级
	*/
	public static class EAM_SAFETYLEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_safetylevel";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 风险等级编码
		*/
		public static final DBField SAFETY_CODE = new DBField(DBDataType.STRING , "safety_code","safetyCode","风险等级编码","风险等级编码",false,false,true);
		
		/**
		 * 风险等级
		*/
		public static final DBField SAFETY_NAME = new DBField(DBDataType.STRING , "safety_name","safetyName","风险等级","风险等级",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_SAFETYLEVEL() {
			this.init($NAME,"风险等级" , ID , SAFETY_CODE , SAFETY_NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_SAFETYLEVEL $TABLE=new EAM_SAFETYLEVEL();
	}
	
	/**
	 * 资产库存
	*/
	public static class EAM_STOCK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_stock";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 库存所属
		*/
		public static final DBField OWNER_CODE = new DBField(DBDataType.STRING , "owner_code","ownerCode","库存所属","库存所属",false,false,true);
		
		/**
		 * 库存类型
		*/
		public static final DBField STOCK_TYPE = new DBField(DBDataType.STRING , "stock_type","stockType","库存类型","库存类型",false,false,true);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField STOCK_BATCH_CODE = new DBField(DBDataType.STRING , "stock_batch_code","stockBatchCode","批次号","批次号",false,false,true);
		
		/**
		 * 单据名称
		*/
		public static final DBField STOCK_NAME = new DBField(DBDataType.STRING , "stock_name","stockName","单据名称","单据名称",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 所属公司
		*/
		public static final DBField OWN_COMPANY_ID = new DBField(DBDataType.STRING , "own_company_id","ownCompanyId","所属公司","所属公司",false,false,true);
		
		/**
		 * 资产供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","资产供应商","资产供应商",false,false,true);
		
		/**
		 * 仓库
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 总金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","总金额","总金额",false,false,true);
		
		/**
		 * 购置日期
		*/
		public static final DBField PURCHASE_DATE = new DBField(DBDataType.DATE , "purchase_date","purchaseDate","购置日期","购置日期",false,false,true);
		
		/**
		 * 管理人
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人","管理人",false,false,true);
		
		/**
		 * 接收人
		*/
		public static final DBField RECEIVER_USER_NAME = new DBField(DBDataType.STRING , "receiver_user_name","receiverUserName","接收人","接收人",false,false,true);
		
		/**
		 * 业务时间
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务时间","业务时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH_ID = new DBField(DBDataType.STRING , "attach_id","attachId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField STOCK_NOTES = new DBField(DBDataType.STRING , "stock_notes","stockNotes","备注","备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
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
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField CHS_TYPE = new DBField(DBDataType.STRING , "chs_type","chsType","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更状态
		*/
		public static final DBField CHS_STATUS = new DBField(DBDataType.STRING , "chs_status","chsStatus","变更状态","变更状态",false,false,true);
		
		/**
		 * 变更版本号
		*/
		public static final DBField CHS_VERSION = new DBField(DBDataType.STRING , "chs_version","chsVersion","变更版本号","变更版本号",false,false,true);
		
		/**
		 * 变更ID
		*/
		public static final DBField CHANGE_INSTANCE_ID = new DBField(DBDataType.STRING , "change_instance_id","changeInstanceId","变更ID","变更ID",false,false,true);
		
		/**
		 * 流程概要
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","流程概要","流程概要",false,false,true);
		
		/**
		 * 最后审批人账户ID
		*/
		public static final DBField LATEST_APPROVER_ID = new DBField(DBDataType.STRING , "latest_approver_id","latestApproverId","最后审批人账户ID","最后审批人账户ID",false,false,true);
		
		/**
		 * 最后审批人姓名
		*/
		public static final DBField LATEST_APPROVER_NAME = new DBField(DBDataType.STRING , "latest_approver_name","latestApproverName","最后审批人姓名","最后审批人姓名",false,false,true);
		
		/**
		 * 下一节点审批人
		*/
		public static final DBField NEXT_APPROVER_IDS = new DBField(DBDataType.STRING , "next_approver_ids","nextApproverIds","下一节点审批人","下一节点审批人",false,false,true);
		
		/**
		 * 下一个审批节点审批人姓名，用逗号隔开
		*/
		public static final DBField NEXT_APPROVER_NAMES = new DBField(DBDataType.STRING , "next_approver_names","nextApproverNames","下一个审批节点审批人姓名","用逗号隔开",false,false,true);
		
		/**
		 * 审批意见
		*/
		public static final DBField APPROVAL_OPINION = new DBField(DBDataType.STRING , "approval_opinion","approvalOpinion","审批意见","审批意见",false,false,true);
		
		public EAM_STOCK() {
			this.init($NAME,"资产库存" , ID , OWNER_CODE , STOCK_TYPE , BUSINESS_CODE , PROC_ID , STATUS , STOCK_BATCH_CODE , STOCK_NAME , SOURCE_ID , OWN_COMPANY_ID , SUPPLIER_ID , WAREHOUSE_ID , AMOUNT , PURCHASE_DATE , MANAGER_ID , RECEIVER_USER_NAME , BUSINESS_DATE , ATTACH_ID , STOCK_NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
		}
		public static final EAM_STOCK $TABLE=new EAM_STOCK();
	}
	
	/**
	 * 供应商
	*/
	public static class EAM_SUPPLIER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_supplier";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField SUPPLIER_NAME = new DBField(DBDataType.STRING , "supplier_name","supplierName","名称","名称",false,false,true);
		
		/**
		 * 商务联系人
		*/
		public static final DBField BUSINESS_CONTACTS = new DBField(DBDataType.STRING , "business_contacts","businessContacts","商务联系人","商务联系人",false,false,true);
		
		/**
		 * 商务联系方式
		*/
		public static final DBField BUSINESS_CONTACTS_INFO = new DBField(DBDataType.STRING , "business_contacts_info","businessContactsInfo","商务联系方式","商务联系方式",false,false,true);
		
		/**
		 * 售后联系人
		*/
		public static final DBField AFTER_SALES_CONTACTS = new DBField(DBDataType.STRING , "after_sales_contacts","afterSalesContacts","售后联系人","售后联系人",false,false,true);
		
		/**
		 * 售后联系方式
		*/
		public static final DBField AFTER_SALES_CONTACTS_INFO = new DBField(DBDataType.STRING , "after_sales_contacts_info","afterSalesContactsInfo","售后联系方式","售后联系方式",false,false,true);
		
		/**
		 * 统一社会信用代码
		*/
		public static final DBField UNIT_CODE = new DBField(DBDataType.STRING , "unit_code","unitCode","统一社会信用代码","统一社会信用代码",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField SUPPLIER_NOTES = new DBField(DBDataType.STRING , "supplier_notes","supplierNotes","备注","备注",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_SUPPLIER() {
			this.init($NAME,"供应商" , ID , SUPPLIER_NAME , BUSINESS_CONTACTS , BUSINESS_CONTACTS_INFO , AFTER_SALES_CONTACTS , AFTER_SALES_CONTACTS_INFO , UNIT_CODE , ADDRESS , SUPPLIER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_SUPPLIER $TABLE=new EAM_SUPPLIER();
	}
	
	/**
	 * 模板文件
	*/
	public static class EAM_TPL_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_tpl_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 模板类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","模板类型","模板类型",false,false,true);
		
		/**
		 * 业务编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","业务编码","业务编码",false,false,true);
		
		/**
		 * 模板文件类型
		*/
		public static final DBField TPL_FILE_TYPE = new DBField(DBDataType.STRING , "tpl_file_type","tplFileType","模板文件类型","模板文件类型",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
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
		
		public EAM_TPL_FILE() {
			this.init($NAME,"模板文件" , ID , NAME , TYPE , CODE , TPL_FILE_TYPE , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_TPL_FILE $TABLE=new EAM_TPL_FILE();
	}
	
	/**
	 * 资产转移
	*/
	public static class EAM_TRANSFER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_transfer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 单据编号
		*/
		public static final DBField BUSI_CODE = new DBField(DBDataType.STRING , "busi_code","busiCode","单据编号","单据编号",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField FLOW_ID = new DBField(DBDataType.STRING , "flow_id","flowId","流程","流程",false,false,true);
		
		/**
		 * 单据状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","单据状态","单据状态",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_NUMBER = new DBField(DBDataType.STRING , "batch_number","batchNumber","批次号","批次号",false,false,true);
		
		/**
		 * 接收人
		*/
		public static final DBField RECEIVER_ID = new DBField(DBDataType.STRING , "receiver_id","receiverId","接收人","接收人",false,false,true);
		
		/**
		 * 存放区域
		*/
		public static final DBField AREA_ID = new DBField(DBDataType.STRING , "area_id","areaId","存放区域","存放区域",false,false,true);
		
		/**
		 * 管理组织
		*/
		public static final DBField MANAGEORG_ID = new DBField(DBDataType.STRING , "manageorg_id","manageorgId","管理组织","管理组织",false,false,true);
		
		/**
		 * 管理人员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人员","管理人员",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSI_DATE = new DBField(DBDataType.DATE , "busi_date","busiDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 完成日期
		*/
		public static final DBField FINISH_DATE = new DBField(DBDataType.DATE , "finish_date","finishDate","完成日期","完成日期",false,false,true);
		
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
		
		public EAM_TRANSFER() {
			this.init($NAME,"资产转移" , ID , BUSI_CODE , FLOW_ID , STATUS , BATCH_NUMBER , RECEIVER_ID , AREA_ID , MANAGEORG_ID , MANAGER_ID , BUSI_DATE , FINISH_DATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_TRANSFER $TABLE=new EAM_TRANSFER();
	}
	
	/**
	 * EAM用户创建动作
	*/
	public static class EAM_USER_CREATE_ACTION_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_user_create_action_log";
		
		/**
		 * id
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 成员
		*/
		public static final DBField MEMBER_ID = new DBField(DBDataType.STRING , "member_id","memberId","成员","成员",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION = new DBField(DBDataType.STRING , "action","action","动作","动作",false,false,true);
		
		/**
		 * 结果
		*/
		public static final DBField RESULT = new DBField(DBDataType.STRING , "result","result","结果","结果",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 父标记
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父标记","父标记",false,false,true);
		
		/**
		 * 标记
		*/
		public static final DBField UID = new DBField(DBDataType.STRING , "uid","uid","标记","标记",false,false,true);
		
		/**
		*/
		public static final DBField TIME_POINT = new DBField(DBDataType.DATE , "time_point","timePoint","time_point","time_point",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public EAM_USER_CREATE_ACTION_LOG() {
			this.init($NAME,"EAM用户创建动作" , ID , MEMBER_ID , ACTION , RESULT , CONTENT , PID , UID , TIME_POINT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_USER_CREATE_ACTION_LOG $TABLE=new EAM_USER_CREATE_ACTION_LOG();
	}
	
	/**
	 * 仓库
	*/
	public static class EAM_WAREHOUSE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_warehouse";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField WAREHOUSE_NAME = new DBField(DBDataType.STRING , "warehouse_name","warehouseName","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField WAREHOUSE_NOTES = new DBField(DBDataType.STRING , "warehouse_notes","warehouseNotes","备注","备注",false,false,true);
		
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
		
		public EAM_WAREHOUSE() {
			this.init($NAME,"仓库" , ID , CODE , STATUS , WAREHOUSE_NAME , WAREHOUSE_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_WAREHOUSE $TABLE=new EAM_WAREHOUSE();
	}
	
	/**
	 * 编码分配
	*/
	public static class SYS_CODE_ALLOCATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_allocation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","业务编码","业务编码",false,false,true);
		
		/**
		 * 规则ID
		*/
		public static final DBField RULE_ID = new DBField(DBDataType.STRING , "rule_id","ruleId","规则ID","规则ID",false,false,true);
		
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
		
		public SYS_CODE_ALLOCATION() {
			this.init($NAME,"编码分配" , ID , CODE , RULE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_ALLOCATION $TABLE=new SYS_CODE_ALLOCATION();
	}
	
	/**
	 * 编码属性
	*/
	public static class SYS_CODE_ATTR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_attr";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","编码名称","编码名称",false,false,true);
		
		/**
		 * 编码类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","编码类型","编码类型",false,false,true);
		
		/**
		 * 占位符
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","占位符","占位符",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public SYS_CODE_ATTR() {
			this.init($NAME,"编码属性" , ID , NAME , TYPE , CODE , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_ATTR $TABLE=new SYS_CODE_ATTR();
	}
	
	/**
	 * 代码生成示例主表
	*/
	public static class SYS_CODE_EXAMPLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 单行文本
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","单行文本","单行文本",false,false,true);
		
		/**
		 * 多行文本
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","多行文本","多行文本",false,false,true);
		
		/**
		 * 图片上传
		*/
		public static final DBField IMAGE_ID = new DBField(DBDataType.STRING , "image_id","imageId","图片上传","图片上传",false,false,true);
		
		/**
		 * 多文件上传
		*/
		public static final DBField FILE_IDS = new DBField(DBDataType.STRING , "file_ids","fileIds","多文件上传","多文件上传",false,false,true);
		
		/**
		 * 整数输入
		*/
		public static final DBField AREA = new DBField(DBDataType.INTEGER , "area","area","整数输入","整数输入",false,false,true);
		
		/**
		 * 小数输入
		*/
		public static final DBField WEIGHT = new DBField(DBDataType.DOUBLE , "weight","weight","小数输入","小数输入",false,false,true);
		
		/**
		 * 逻辑值
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","逻辑值","逻辑值",false,false,true);
		
		/**
		 * 对话框
		*/
		public static final DBField BUTTON_INPUT = new DBField(DBDataType.STRING , "button_input","buttonInput","对话框","对话框",false,false,true);
		
		/**
		 * 单选框(枚举)
		*/
		public static final DBField RADIO_ENUM = new DBField(DBDataType.STRING , "radio_enum","radioEnum","单选框(枚举)","单选框(枚举)",false,false,true);
		
		/**
		 * 单选框(字典)
		*/
		public static final DBField RADIO_DICT = new DBField(DBDataType.STRING , "radio_dict","radioDict","单选框(字典)","单选框(字典)",false,false,true);
		
		/**
		 * 复选框(枚举)
		*/
		public static final DBField CHECK_ENUM = new DBField(DBDataType.STRING , "check_enum","checkEnum","复选框(枚举)","复选框(枚举)",false,false,true);
		
		/**
		 * 复选框(字典)
		*/
		public static final DBField CHECK_DICT = new DBField(DBDataType.STRING , "check_dict","checkDict","复选框(字典)","复选框(字典)",false,false,true);
		
		/**
		 * 选择框(枚举)
		*/
		public static final DBField SELECT_ENUM = new DBField(DBDataType.STRING , "select_enum","selectEnum","选择框(枚举)","选择框(枚举)",false,false,true);
		
		/**
		 * 选择框(字典)
		*/
		public static final DBField SELECT_DICT = new DBField(DBDataType.STRING , "select_dict","selectDict","选择框(字典)","选择框(字典)",false,false,true);
		
		/**
		 * 选择框(查询)
		*/
		public static final DBField RESOURCE_ID = new DBField(DBDataType.STRING , "resource_id","resourceId","选择框(查询)","选择框(查询)",false,false,true);
		
		/**
		 * 日期
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","日期","日期",false,false,true);
		
		/**
		 * 工作时间
		*/
		public static final DBField WORK_TIME = new DBField(DBDataType.DATE , "work_time","workTime","工作时间","工作时间",false,false,true);
		
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
		
		public SYS_CODE_EXAMPLE() {
			this.init($NAME,"代码生成示例主表" , ID , NAME , NOTES , IMAGE_ID , FILE_IDS , AREA , WEIGHT , VALID , BUTTON_INPUT , RADIO_ENUM , RADIO_DICT , CHECK_ENUM , CHECK_DICT , SELECT_ENUM , SELECT_DICT , RESOURCE_ID , BIRTHDAY , WORK_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_EXAMPLE $TABLE=new SYS_CODE_EXAMPLE();
	}
	
	/**
	 * 代码生成拥有的车辆
	*/
	public static class SYS_CODE_EXAMPLE_CAR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_car";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 属主ID
		*/
		public static final DBField EXAMPLE_ID = new DBField(DBDataType.STRING , "example_id","exampleId","属主ID","属主ID",false,false,true);
		
		/**
		 * 车牌号
		*/
		public static final DBField PLATE_NUMBER = new DBField(DBDataType.STRING , "plate_number","plateNumber","车牌号","车牌号",false,false,true);
		
		/**
		 * 颜色
		*/
		public static final DBField COLOR = new DBField(DBDataType.STRING , "color","color","颜色","颜色",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
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
		 * 岗位单选
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","岗位单选","岗位单选",false,false,true);
		
		/**
		 * 组织单选
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","组织单选","组织单选",false,false,true);
		
		/**
		 * 员工单选
		*/
		public static final DBField EMP_ID = new DBField(DBDataType.STRING , "emp_id","empId","员工单选","员工单选",false,false,true);
		
		/**
		 * 岗位多选
		*/
		public static final DBField POSITION_IDS = new DBField(DBDataType.STRING , "position_ids","positionIds","岗位多选","岗位多选",false,false,true);
		
		/**
		 * 组织多选
		*/
		public static final DBField ORG_IDS = new DBField(DBDataType.STRING , "org_ids","orgIds","组织多选","组织多选",false,false,true);
		
		/**
		 * 员工多选
		*/
		public static final DBField EMP_IDS = new DBField(DBDataType.STRING , "emp_ids","empIds","员工多选","员工多选",false,false,true);
		
		/**
		 * 员工下拉
		*/
		public static final DBField SELECT_EMP_ID = new DBField(DBDataType.STRING , "select_emp_id","selectEmpId","员工下拉","员工下拉",false,false,true);
		
		/**
		 * 公司单选
		*/
		public static final DBField COM_ID = new DBField(DBDataType.STRING , "com_id","comId","公司单选","公司单选",false,false,true);
		
		/**
		 * 部门多选
		*/
		public static final DBField DEPT_IDS = new DBField(DBDataType.STRING , "dept_ids","deptIds","部门多选","部门多选",false,false,true);
		
		/**
		 * 限定上级
		*/
		public static final DBField SUB_ORG_ID = new DBField(DBDataType.STRING , "sub_org_id","subOrgId","限定上级","限定上级",false,false,true);
		
		public SYS_CODE_EXAMPLE_CAR() {
			this.init($NAME,"代码生成拥有的车辆" , ID , EXAMPLE_ID , PLATE_NUMBER , COLOR , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , POSITION_ID , ORG_ID , EMP_ID , POSITION_IDS , ORG_IDS , EMP_IDS , SELECT_EMP_ID , COM_ID , DEPT_IDS , SUB_ORG_ID);
		}
		public static final SYS_CODE_EXAMPLE_CAR $TABLE=new SYS_CODE_EXAMPLE_CAR();
	}
	
	/**
	 * 主键多字段测试表
	*/
	public static class SYS_CODE_EXAMPLE_MULIT_PK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_mulit_pk";
		
		/**
		 * 主键1
		*/
		public static final DBField NID = new DBField(DBDataType.LONG , "nid","nid","主键1","主键1",true,false,false);
		
		/**
		 * 主键2
		*/
		public static final DBField DAY = new DBField(DBDataType.DATE , "day","day","主键2","主键2",true,false,false);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		public SYS_CODE_EXAMPLE_MULIT_PK() {
			this.init($NAME,"主键多字段测试表" , NID , DAY , CONTENT);
		}
		public static final SYS_CODE_EXAMPLE_MULIT_PK $TABLE=new SYS_CODE_EXAMPLE_MULIT_PK();
	}
	
	/**
	 * 代码示例主表角色关系表
	*/
	public static class SYS_CODE_EXAMPLE_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 属主ID
		*/
		public static final DBField EXAMPLE_ID = new DBField(DBDataType.STRING , "example_id","exampleId","属主ID","属主ID",false,false,true);
		
		/**
		 * 角色ID
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色ID","角色ID",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_CODE_EXAMPLE_ROLE() {
			this.init($NAME,"代码示例主表角色关系表" , ID , EXAMPLE_ID , ROLE_ID , VERSION);
		}
		public static final SYS_CODE_EXAMPLE_ROLE $TABLE=new SYS_CODE_EXAMPLE_ROLE();
	}
	
	/**
	 * 代码生成主表学生
	*/
	public static class SYS_CODE_EXAMPLE_STUDENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_example_student";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 属主ID
		*/
		public static final DBField EXAMPLE_ID = new DBField(DBDataType.STRING , "example_id","exampleId","属主ID","属主ID",false,false,true);
		
		/**
		 * 学生姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","学生姓名","学生姓名",false,false,true);
		
		/**
		 * 年龄
		*/
		public static final DBField AGE = new DBField(DBDataType.STRING , "age","age","年龄","年龄",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
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
		
		public SYS_CODE_EXAMPLE_STUDENT() {
			this.init($NAME,"代码生成主表学生" , ID , EXAMPLE_ID , NAME , AGE , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final SYS_CODE_EXAMPLE_STUDENT $TABLE=new SYS_CODE_EXAMPLE_STUDENT();
	}
	
	/**
	 * 业务编码
	*/
	public static class SYS_CODE_REGISTER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_register";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","业务编码","业务编码",false,false,true);
		
		/**
		 * 编码类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","编码类型","编码类型",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
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
		
		public SYS_CODE_REGISTER() {
			this.init($NAME,"业务编码" , ID , CODE , TYPE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_CODE_REGISTER $TABLE=new SYS_CODE_REGISTER();
	}
	
	/**
	 * 编码规则
	*/
	public static class SYS_CODE_RULE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_code_rule";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","编码名称","编码名称",false,false,true);
		
		/**
		 * 业务模块
		*/
		public static final DBField MODULE_ID = new DBField(DBDataType.STRING , "module_id","moduleId","业务模块","业务模块",false,false,true);
		
		/**
		 * 编码规则
		*/
		public static final DBField RULE = new DBField(DBDataType.STRING , "rule","rule","编码规则","编码规则",false,false,true);
		
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
		
		public SYS_CODE_RULE() {
			this.init($NAME,"编码规则" , ID , NAME , MODULE_ID , RULE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_RULE $TABLE=new SYS_CODE_RULE();
	}
	
	/**
	 * 模板文件
	*/
	public static class SYS_TPL_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_tpl_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 模板类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","模板类型","模板类型",false,false,true);
		
		/**
		 * 业务编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","业务编码","业务编码",false,false,true);
		
		/**
		 * 模板文件类型
		*/
		public static final DBField TPL_FILE_TYPE = new DBField(DBDataType.STRING , "tpl_file_type","tplFileType","模板文件类型","模板文件类型",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
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
		
		public SYS_TPL_FILE() {
			this.init($NAME,"模板文件" , ID , NAME , TYPE , CODE , TPL_FILE_TYPE , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_TPL_FILE $TABLE=new SYS_TPL_FILE();
	}
}