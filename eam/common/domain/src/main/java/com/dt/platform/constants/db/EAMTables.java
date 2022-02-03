package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-02-02 15:29:23
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class EAMTables {
	
	/**
	 * 区域
	*/
	public static class DC_AREA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dc_area";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION = new DBField(DBDataType.STRING , "position","position","位置","位置",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public DC_AREA() {
			this.init($NAME,"区域" , ID , TYPE , NAME , POSITION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final DC_AREA $TABLE=new DC_AREA();
	}
	
	/**
	 * 层级
	*/
	public static class DC_LAYER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dc_layer";
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public DC_LAYER() {
			this.init($NAME,"层级" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final DC_LAYER $TABLE=new DC_LAYER();
	}
	
	/**
	 * 机柜
	*/
	public static class DC_RACK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "dc_rack";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField RACK_CODE = new DBField(DBDataType.STRING , "rack_code","rackCode","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField RACK_NAME = new DBField(DBDataType.STRING , "rack_name","rackName","名称","名称",false,false,true);
		
		/**
		 * 容量
		*/
		public static final DBField RACK_CAPTICAL = new DBField(DBDataType.DECIMAL , "rack_captical","rackCaptical","容量","容量",false,false,true);
		
		/**
		 * PDU数量
		*/
		public static final DBField PDU_NUMBER = new DBField(DBDataType.INTEGER , "pdu_number","pduNumber","PDU数量","PDU数量",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField RACK_LABELS = new DBField(DBDataType.STRING , "rack_labels","rackLabels","标签","标签",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField RACK_NOTES = new DBField(DBDataType.STRING , "rack_notes","rackNotes","备注","备注",false,false,true);
		
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
		
		public DC_RACK() {
			this.init($NAME,"机柜" , ID , RACK_CODE , RACK_NAME , RACK_CAPTICAL , PDU_NUMBER , RACK_LABELS , RACK_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final DC_RACK $TABLE=new DC_RACK();
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
		 * 使用期限
		*/
		public static final DBField SERVICE_LIFE = new DBField(DBDataType.DECIMAL , "service_life","serviceLife","使用期限","使用期限",false,false,true);
		
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
		 * 资产RFID
		*/
		public static final DBField RFID = new DBField(DBDataType.STRING , "rfid","rfid","资产RFID","资产RFID",false,false,true);
		
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
		
		public EAM_ASSET() {
			this.init($NAME,"资产" , ID , CATEGORY_ID , CATEGORY_CODE , BUSINESS_CODE , PROC_ID , STATUS , BATCH_CODE , OWNER_CODE , ASSET_CODE , ASSET_STATUS , DISPLAY , CLEAN_OUT , GOODS_ID , NAME , MANUFACTURER_ID , MODEL , PICTURE_ID , UNIT , SERVICE_LIFE , SAFETY_LEVEL_CODE , SERIAL_NUMBER , OWN_COMPANY_ID , MANAGER_ID , USE_ORGANIZATION_ID , USE_USER_ID , POSITION_ID , POSITION_DETAIL , WAREHOUSE_ID , SOURCE_ID , ASSET_NUMBER , REMAIN_NUMBER , PURCHASE_DATE , PRODUCTION_DATE , REGISTER_DATE , RFID , ATTACH , LAST_VERIFICATION_DATE , PURPOSE , ASSET_NOTES , MAINTAINER_ID , MAINTAINER_NAME , MAINTENANCE_STATUS , CONTACTS , CONTACT_INFORMATION , DIRECTOR , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , MAINTENANCE_NOTES , FINANCIAL_CATEGORY_ID , FINANCIAL_CODE , SUPPLIER_ID , TAX_AMOUNT_RATE , TAX_AMOUNT_PRICE , TOTAL_AMOUNT_PRICE , ORIGINAL_UNIT_PRICE , ACCUMULATED_DEPRECIATION , RESIDUALS_RATE , NAV_PRICE , PURCHASE_UNIT_PRICE , ENTRY_TIME , FINANCIAL_NOTES , EQUIPMENT_CODE , EQUIPMENT_STATUS , EQUIPMENT_IP , MANAGE_IP , EQUIPMENT_CPU , EQUIPMENT_MEMORY , EQUIPMENT_LABEL , EQUIPMENT_CONF , EQUIPMENT_ENVIRONMENT_CODE , EQUIPMENT_SERIAL_NUMBER , RACK_ID , RACK_UP_NUMBER , RACK_DOWN_NUMBER , LABEL , LABEL2 , INTERNAL_CONTROL_LABEL , BILL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION);
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
			this.init($NAME,"资产报修" , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , REPAIR_STATUS , TYPE , PLAN_FINISH_DATE , ACTUAL_FINISH_DATE , CONTENT , REPORT_USER_ID , PICTURE_ID , ORIGINATOR_ID , BUSINESS_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
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
		 * 名称
		*/
		public static final DBField BRAND_NAME = new DBField(DBDataType.STRING , "brand_name","brandName","名称","名称",false,false,true);
		
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
			this.init($NAME,"品牌" , ID , BRAND_NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
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
		 * 抬头
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","抬头","抬头",false,false,true);
		
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
	 * 物品库存
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
		 * 物品档案
		*/
		public static final DBField GOOD_ID = new DBField(DBDataType.STRING , "good_id","goodId","物品档案","物品档案",false,false,true);
		
		/**
		 * 标准型号，单价
		*/
		public static final DBField UNIT_PRICE = new DBField(DBDataType.DECIMAL , "unit_price","unitPrice","标准型号","单价",false,false,true);
		
		/**
		 * 标准型号，库存
		*/
		public static final DBField STOCK_MIN = new DBField(DBDataType.DECIMAL , "stock_min","stockMin","标准型号","库存",false,false,true);
		
		/**
		 * 标准型号，库存
		*/
		public static final DBField STOCK_MAX = new DBField(DBDataType.DECIMAL , "stock_max","stockMax","标准型号","库存",false,false,true);
		
		/**
		 * 标准型号，安全库存
		*/
		public static final DBField STOCK_SECURITY = new DBField(DBDataType.DECIMAL , "stock_security","stockSecurity","标准型号","安全库存",false,false,true);
		
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
		
		public EAM_GOODS_STOCK() {
			this.init($NAME,"物品库存" , ID , GOOD_ID , UNIT_PRICE , STOCK_MIN , STOCK_MAX , STOCK_SECURITY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_GOODS_STOCK $TABLE=new EAM_GOODS_STOCK();
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
			this.init($NAME,"维保厂商" , ID , MAINTAINER_NAME , MAINTAINER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
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
			this.init($NAME,"资产操作" , ID , NAME , ALLOCATE_CODE , OPERATE_CODE , APPROVAL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
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
			this.init($NAME,"供应商" , ID , SUPPLIER_NAME , SUPPLIER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
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
			this.init($NAME,"仓库" , ID , WAREHOUSE_NAME , WAREHOUSE_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final EAM_WAREHOUSE $TABLE=new EAM_WAREHOUSE();
	}
	
	/**
	 * 公司表
	*/
	public static class HRM_COMPANY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_company";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 公司名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","公司名称","公司名称",false,false,true);
		
		/**
		 * 社会信用代码
		*/
		public static final DBField SOCIAL_CREDIT_CODE = new DBField(DBDataType.STRING , "social_credit_code","socialCreditCode","社会信用代码","社会信用代码",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
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
		
		public HRM_COMPANY() {
			this.init($NAME,"公司表" , ID , NAME , SOCIAL_CREDIT_CODE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_COMPANY $TABLE=new HRM_COMPANY();
	}
	
	/**
	 * 员工表
	*/
	public static class HRM_EMPLOYEE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_employee";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 工号
		*/
		public static final DBField BADGE = new DBField(DBDataType.STRING , "badge","badge","工号","工号",false,false,true);
		
		/**
		 * 手机号
		*/
		public static final DBField PHONE = new DBField(DBDataType.STRING , "phone","phone","手机号","手机号",false,false,true);
		
		/**
		 * 人员ID
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员ID","人员ID",false,false,true);
		
		/**
		 * 公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","公司ID","公司ID",false,false,true);
		
		/**
		 * 状态，字典代码：employee_status
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","字典代码：employee_status",false,false,true);
		
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
		
		public HRM_EMPLOYEE() {
			this.init($NAME,"员工表" , ID , BADGE , PHONE , PERSON_ID , COMPANY_ID , STATUS , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_EMPLOYEE $TABLE=new HRM_EMPLOYEE();
	}
	
	/**
	 * 员工岗位关系表
	*/
	public static class HRM_EMPLOYEE_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_employee_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 员工ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工ID","员工ID",false,false,false);
		
		/**
		 * 岗位ID
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","岗位ID","岗位ID",false,false,false);
		
		/**
		 * 是否主岗
		*/
		public static final DBField IS_PRIMARY = new DBField(DBDataType.INTEGER , "is_primary","isPrimary","是否主岗","是否主岗",false,false,true);
		
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
		
		public HRM_EMPLOYEE_POSITION() {
			this.init($NAME,"员工岗位关系表" , ID , EMPLOYEE_ID , POSITION_ID , IS_PRIMARY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_EMPLOYEE_POSITION $TABLE=new HRM_EMPLOYEE_POSITION();
	}
	
	/**
	 * 常用人员分组表
	*/
	public static class HRM_FAVOURITE_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_favourite_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 组名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","组名","组名",false,false,false);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,false);
		
		/**
		 * 所有者ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","所有者ID","所有者ID",false,false,false);
		
		/**
		 * 层级路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","层级路径","层级路径",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
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
		
		public HRM_FAVOURITE_GROUP() {
			this.init($NAME,"常用人员分组表" , ID , NAME , PARENT_ID , EMPLOYEE_ID , HIERARCHY , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_FAVOURITE_GROUP $TABLE=new HRM_FAVOURITE_GROUP();
	}
	
	/**
	 * 常用人员分组条目表
	*/
	public static class HRM_FAVOURITE_GROUP_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_favourite_group_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 对象ID
		*/
		public static final DBField TARGET_ID = new DBField(DBDataType.STRING , "target_id","targetId","对象ID","对象ID",false,false,false);
		
		/**
		 * 对象类型
		*/
		public static final DBField TARGET_TYPE = new DBField(DBDataType.STRING , "target_type","targetType","对象类型","对象类型",false,false,false);
		
		/**
		 * 对象名称
		*/
		public static final DBField TARGET_NAME = new DBField(DBDataType.STRING , "target_name","targetName","对象名称","对象名称",false,false,true);
		
		/**
		 * 层级路径
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","层级路径","层级路径",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 所有者ID
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","所有者ID","所有者ID",false,false,true);
		
		/**
		 * 是否临时
		*/
		public static final DBField TEMPORARY = new DBField(DBDataType.INTEGER , "temporary","temporary","是否临时","是否临时",false,false,false);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
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
		
		public HRM_FAVOURITE_GROUP_ITEM() {
			this.init($NAME,"常用人员分组条目表" , ID , TARGET_ID , TARGET_TYPE , TARGET_NAME , GROUP_ID , SORT , EMPLOYEE_ID , TEMPORARY , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_FAVOURITE_GROUP_ITEM $TABLE=new HRM_FAVOURITE_GROUP_ITEM();
	}
	
	/**
	 * 组织层级表
	*/
	public static class HRM_ORGANIZATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_organization";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","代码","代码",false,false,true);
		
		/**
		 * 简称
		*/
		public static final DBField SHORT_NAME = new DBField(DBDataType.STRING , "short_name","shortName","简称","简称",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField FULL_NAME = new DBField(DBDataType.STRING , "full_name","fullName","全称","全称",false,false,false);
		
		/**
		 * 组织类型,公司(com)或部门(dept)
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","组织类型","公司(com)或部门(dept)",false,false,false);
		
		/**
		 * 上级ID
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上级ID","上级ID",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 层级路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","层级路径","层级路径",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
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
		
		public HRM_ORGANIZATION() {
			this.init($NAME,"组织层级表" , ID , CODE , SHORT_NAME , FULL_NAME , TYPE , PARENT_ID , VALID , HIERARCHY , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_ORGANIZATION $TABLE=new HRM_ORGANIZATION();
	}
	
	/**
	 * 人员表
	*/
	public static class HRM_PERSON extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_person";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		/**
		 * 来源，PersonSource枚举
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","PersonSource枚举",false,false,false);
		
		/**
		 * 身份证号码
		*/
		public static final DBField IDENTITY = new DBField(DBDataType.STRING , "identity","identity","身份证号码","身份证号码",false,false,false);
		
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
		
		public HRM_PERSON() {
			this.init($NAME,"人员表" , ID , NAME , SEX , SOURCE , IDENTITY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_PERSON $TABLE=new HRM_PERSON();
	}
	
	/**
	 * 岗位表
	*/
	public static class HRM_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属组织ID
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","所属组织ID","所属组织ID",false,false,true);
		
		/**
		 * 岗位代码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","岗位代码","岗位代码",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField FULL_NAME = new DBField(DBDataType.STRING , "full_name","fullName","全称","全称",false,false,false);
		
		/**
		 * 简称
		*/
		public static final DBField SHORT_NAME = new DBField(DBDataType.STRING , "short_name","shortName","简称","简称",false,false,true);
		
		/**
		 * 是否有效
		*/
		public static final DBField VALID = new DBField(DBDataType.INTEGER , "valid","valid","是否有效","是否有效",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 总公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","总公司ID","总公司ID",false,false,true);
		
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
		 * 岗位类型，关联字典 position_type
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","岗位类型","关联字典 position_type",false,false,true);
		
		public HRM_POSITION() {
			this.init($NAME,"岗位表" , ID , ORG_ID , CODE , FULL_NAME , SHORT_NAME , VALID , SORT , COMPANY_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TYPE);
		}
		public static final HRM_POSITION $TABLE=new HRM_POSITION();
	}
	
	/**
	 * 知识分类
	*/
	public static class KN_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "kn_category";
		
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
		
		public KN_CATEGORY() {
			this.init($NAME,"知识分类" , ID , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final KN_CATEGORY $TABLE=new KN_CATEGORY();
	}
	
	/**
	 * 知识库内容
	*/
	public static class KN_CONTENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "kn_content";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 分类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","分类","分类",false,false,true);
		
		/**
		 * 标题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","标题","标题",false,false,true);
		
		/**
		 * 简介
		*/
		public static final DBField PROFILE = new DBField(DBDataType.STRING , "profile","profile","简介","简介",false,false,true);
		
		/**
		 * 关键字
		*/
		public static final DBField KEY_WORDS = new DBField(DBDataType.STRING , "key_words","keyWords","关键字","关键字",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 知识内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","知识内容","知识内容",false,false,true);
		
		/**
		 * 内容类型
		*/
		public static final DBField CONTENT_TYPE = new DBField(DBDataType.STRING , "content_type","contentType","内容类型","内容类型",false,false,true);
		
		/**
		 * 阅读数
		*/
		public static final DBField REVIEW_COUNT = new DBField(DBDataType.DECIMAL , "review_count","reviewCount","阅读数","阅读数",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 是否显示
		*/
		public static final DBField DISPLAY = new DBField(DBDataType.INTEGER , "display","display","是否显示","是否显示",false,false,true);
		
		/**
		 * 链接地址
		*/
		public static final DBField LINK_ADDRESS = new DBField(DBDataType.STRING , "link_address","linkAddress","链接地址","链接地址",false,false,true);
		
		/**
		 * 等级
		*/
		public static final DBField GRADE_ID = new DBField(DBDataType.STRING , "grade_id","gradeId","等级","等级",false,false,true);
		
		/**
		 * 编辑人
		*/
		public static final DBField EDITOR_ID = new DBField(DBDataType.STRING , "editor_id","editorId","编辑人","编辑人",false,false,true);
		
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
		
		public KN_CONTENT() {
			this.init($NAME,"知识库内容" , ID , CATEGORY_ID , TITLE , PROFILE , KEY_WORDS , LABEL , CONTENT , CONTENT_TYPE , REVIEW_COUNT , ATTACH , DISPLAY , LINK_ADDRESS , GRADE_ID , EDITOR_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final KN_CONTENT $TABLE=new KN_CONTENT();
	}
	
	/**
	 * 数据库实例
	*/
	public static class OPS_DB_INSTANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_db_instance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机编号
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机编号","主机编号",false,false,true);
		
		/**
		 * 数据库编号
		*/
		public static final DBField DATABASE_ID = new DBField(DBDataType.STRING , "database_id","databaseId","数据库编号","数据库编号",false,false,true);
		
		/**
		 * 实例名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","实例名称","实例名称",false,false,true);
		
		/**
		 * 日志模式
		*/
		public static final DBField LOG_METHOD = new DBField(DBDataType.STRING , "log_method","logMethod","日志模式","日志模式",false,false,true);
		
		/**
		 * 备份策略
		*/
		public static final DBField BACKUP_STRATEGY = new DBField(DBDataType.STRING , "backup_strategy","backupStrategy","备份策略","备份策略",false,false,true);
		
		/**
		 * 备份类型
		*/
		public static final DBField BACKUP_TYPE = new DBField(DBDataType.STRING , "backup_type","backupType","备份类型","备份类型",false,false,true);
		
		/**
		 * 备份保留时长
		*/
		public static final DBField BACKUP_DATAKEEP = new DBField(DBDataType.STRING , "backup_datakeep","backupDatakeep","备份保留时长","备份保留时长",false,false,true);
		
		/**
		 * 备份状态
		*/
		public static final DBField BACKUP_STATUS = new DBField(DBDataType.STRING , "backup_status","backupStatus","备份状态","备份状态",false,false,true);
		
		/**
		 * 备份方式
		*/
		public static final DBField BACKUP_METHOD = new DBField(DBDataType.STRING , "backup_method","backupMethod","备份方式","备份方式",false,false,true);
		
		/**
		 * 上次备份
		*/
		public static final DBField BACKUP_TIME = new DBField(DBDataType.DATE , "backup_time","backupTime","上次备份","上次备份",false,false,true);
		
		/**
		 * 备份大小
		*/
		public static final DBField BACKUP_SIZE = new DBField(DBDataType.DECIMAL , "backup_size","backupSize","备份大小","备份大小",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABELS = new DBField(DBDataType.STRING , "labels","labels","标签","标签",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_DB_INSTANCE() {
			this.init($NAME,"数据库实例" , ID , HOST_ID , DATABASE_ID , NAME , LOG_METHOD , BACKUP_STRATEGY , BACKUP_TYPE , BACKUP_DATAKEEP , BACKUP_STATUS , BACKUP_METHOD , BACKUP_TIME , BACKUP_SIZE , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_DB_INSTANCE $TABLE=new OPS_DB_INSTANCE();
	}
	
	/**
	 * 主机
	*/
	public static class OPS_HOST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 信息系统
		*/
		public static final DBField SYSTEM_ID = new DBField(DBDataType.STRING , "system_id","systemId","信息系统","信息系统",false,false,true);
		
		/**
		 * 主机类型
		*/
		public static final DBField HOST_TYPE = new DBField(DBDataType.STRING , "host_type","hostType","主机类型","主机类型",false,false,true);
		
		/**
		 * 主机状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","主机状态","主机状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField HOST_NAME = new DBField(DBDataType.STRING , "host_name","hostName","名称","名称",false,false,true);
		
		/**
		 * 物理IP
		*/
		public static final DBField HOST_IP = new DBField(DBDataType.STRING , "host_ip","hostIp","物理IP","物理IP",false,false,true);
		
		/**
		 * 虚拟VIP
		*/
		public static final DBField HOST_VIP = new DBField(DBDataType.STRING , "host_vip","hostVip","虚拟VIP","虚拟VIP",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT = new DBField(DBDataType.STRING , "environment","environment","运行环境","运行环境",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","位置","位置",false,false,true);
		
		/**
		 * 监控状态
		*/
		public static final DBField MONITOR_STATUS = new DBField(DBDataType.STRING , "monitor_status","monitorStatus","监控状态","监控状态",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField DIRECTOR_USERNAME = new DBField(DBDataType.STRING , "director_username","directorUsername","负责人","负责人",false,false,true);
		
		/**
		 * 内存
		*/
		public static final DBField HOST_MEMORY = new DBField(DBDataType.DECIMAL , "host_memory","hostMemory","内存","内存",false,false,true);
		
		/**
		 * CPU
		*/
		public static final DBField HOST_CPU = new DBField(DBDataType.DECIMAL , "host_cpu","hostCpu","CPU","CPU",false,false,true);
		
		/**
		 * 其他配置
		*/
		public static final DBField HOST_CONF = new DBField(DBDataType.STRING , "host_conf","hostConf","其他配置","其他配置",false,false,true);
		
		/**
		 * 系统管理员
		*/
		public static final DBField USER_OS_ADMIN = new DBField(DBDataType.STRING , "user_os_admin","userOsAdmin","系统管理员","系统管理员",false,false,true);
		
		/**
		 * 数据库管理员
		*/
		public static final DBField USER_DB_ADMIN = new DBField(DBDataType.STRING , "user_db_admin","userDbAdmin","数据库管理员","数据库管理员",false,false,true);
		
		/**
		 * 数据库使用用户
		*/
		public static final DBField USER_DB_USED = new DBField(DBDataType.STRING , "user_db_used","userDbUsed","数据库使用用户","数据库使用用户",false,false,true);
		
		/**
		 * 应用使用用户
		*/
		public static final DBField USER_APP_USED = new DBField(DBDataType.STRING , "user_app_used","userAppUsed","应用使用用户","应用使用用户",false,false,true);
		
		/**
		 * 运维操作用户
		*/
		public static final DBField USER_OPS_OPER = new DBField(DBDataType.STRING , "user_ops_oper","userOpsOper","运维操作用户","运维操作用户",false,false,true);
		
		/**
		 * 其他用户
		*/
		public static final DBField USER_OTHER = new DBField(DBDataType.STRING , "user_other","userOther","其他用户","其他用户",false,false,true);
		
		/**
		 * 改密策略
		*/
		public static final DBField PASSWORD_STRATEGY_ID = new DBField(DBDataType.STRING , "password_strategy_id","passwordStrategyId","改密策略","改密策略",false,false,true);
		
		/**
		 * 备份方式
		*/
		public static final DBField HOST_BACKUP_METHOD = new DBField(DBDataType.STRING , "host_backup_method","hostBackupMethod","备份方式","备份方式",false,false,true);
		
		/**
		 * 备份情况
		*/
		public static final DBField HOST_BACKUP_INFO = new DBField(DBDataType.STRING , "host_backup_info","hostBackupInfo","备份情况","备份情况",false,false,true);
		
		/**
		 * 下线时间
		*/
		public static final DBField OFFLINE_TIME = new DBField(DBDataType.DATE , "offline_time","offlineTime","下线时间","下线时间",false,false,true);
		
		/**
		 * 上线时间
		*/
		public static final DBField ONLINE_TIME = new DBField(DBDataType.DATE , "online_time","onlineTime","上线时间","上线时间",false,false,true);
		
		/**
		 * 是否归档
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","是否归档","是否归档",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABELS = new DBField(DBDataType.STRING , "labels","labels","标签","标签",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField HOST_NOTES = new DBField(DBDataType.STRING , "host_notes","hostNotes","备注","备注",false,false,true);
		
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
		
		public OPS_HOST() {
			this.init($NAME,"主机" , ID , SYSTEM_ID , HOST_TYPE , STATUS , HOST_NAME , HOST_IP , HOST_VIP , ENVIRONMENT , POSITION_ID , MONITOR_STATUS , DIRECTOR_USERNAME , HOST_MEMORY , HOST_CPU , HOST_CONF , USER_OS_ADMIN , USER_DB_ADMIN , USER_DB_USED , USER_APP_USED , USER_OPS_OPER , USER_OTHER , PASSWORD_STRATEGY_ID , HOST_BACKUP_METHOD , HOST_BACKUP_INFO , OFFLINE_TIME , ONLINE_TIME , ARCH , LABELS , HOST_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_HOST $TABLE=new OPS_HOST();
	}
	
	/**
	 * 数据库
	*/
	public static class OPS_HOST_DB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_db";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务内容","服务内容",false,false,true);
		
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
		
		public OPS_HOST_DB() {
			this.init($NAME,"数据库" , ID , HOST_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_HOST_DB $TABLE=new OPS_HOST_DB();
	}
	
	/**
	 * 中间件
	*/
	public static class OPS_HOST_MID extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_mid";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务内容","服务内容",false,false,true);
		
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
		
		public OPS_HOST_MID() {
			this.init($NAME,"中间件" , ID , HOST_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_HOST_MID $TABLE=new OPS_HOST_MID();
	}
	
	/**
	 * 操作系统
	*/
	public static class OPS_HOST_OS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_os";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务内容","服务内容",false,false,true);
		
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
		
		public OPS_HOST_OS() {
			this.init($NAME,"操作系统" , ID , HOST_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_HOST_OS $TABLE=new OPS_HOST_OS();
	}
	
	/**
	 * 主机位置
	*/
	public static class OPS_HOST_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_position";
		
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
		
		public OPS_HOST_POSITION() {
			this.init($NAME,"主机位置" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_HOST_POSITION $TABLE=new OPS_HOST_POSITION();
	}
	
	/**
	 * 主机表-服务
	*/
	public static class OPS_HOST_SERVICE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_service";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务类型
		*/
		public static final DBField SERVICE_CATEGORY_ID = new DBField(DBDataType.STRING , "service_category_id","serviceCategoryId","服务类型","服务类型",false,false,true);
		
		/**
		 * 服务具体内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务具体内容","服务具体内容",false,false,true);
		
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
		
		public OPS_HOST_SERVICE() {
			this.init($NAME,"主机表-服务" , ID , HOST_ID , SERVICE_CATEGORY_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_HOST_SERVICE $TABLE=new OPS_HOST_SERVICE();
	}
	
	/**
	 * 信息系统
	*/
	public static class OPS_INFORMATION_SYSTEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_information_system";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 父节点
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父节点","父节点",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 介绍
		*/
		public static final DBField PROFILE = new DBField(DBDataType.STRING , "profile","profile","介绍","介绍",false,false,true);
		
		/**
		 * 当前状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","当前状态","当前状态",false,false,true);
		
		/**
		 * 运维模式
		*/
		public static final DBField OPS_METHOD = new DBField(DBDataType.STRING , "ops_method","opsMethod","运维模式","运维模式",false,false,true);
		
		/**
		 * 开发模式
		*/
		public static final DBField DEV_METHOD = new DBField(DBDataType.STRING , "dev_method","devMethod","开发模式","开发模式",false,false,true);
		
		/**
		 * 技术联系人
		*/
		public static final DBField TECHNICAL_CONTACT = new DBField(DBDataType.STRING , "technical_contact","technicalContact","技术联系人","技术联系人",false,false,true);
		
		/**
		 * 业务联系人
		*/
		public static final DBField BUSINESS_CONTACT = new DBField(DBDataType.STRING , "business_contact","businessContact","业务联系人","业务联系人",false,false,true);
		
		/**
		 * 所属公司/部门
		*/
		public static final DBField BELONG_ORG_ID = new DBField(DBDataType.STRING , "belong_org_id","belongOrgId","所属公司/部门","所属公司/部门",false,false,true);
		
		/**
		 * 最后一次演练
		*/
		public static final DBField LASTDRILL_DATE = new DBField(DBDataType.DATE , "lastdrill_date","lastdrillDate","最后一次演练","最后一次演练",false,false,true);
		
		/**
		 * 上线时间
		*/
		public static final DBField ONLINE_DATE = new DBField(DBDataType.DATE , "online_date","onlineDate","上线时间","上线时间",false,false,true);
		
		/**
		 * 下线时间
		*/
		public static final DBField OFFLINE_DATE = new DBField(DBDataType.DATE , "offline_date","offlineDate","下线时间","下线时间",false,false,true);
		
		/**
		 * 操作系统
		*/
		public static final DBField OS_INFO = new DBField(DBDataType.STRING , "os_info","osInfo","操作系统","操作系统",false,false,true);
		
		/**
		 * 数据库
		*/
		public static final DBField DB_INFO = new DBField(DBDataType.STRING , "db_info","dbInfo","数据库","数据库",false,false,true);
		
		/**
		 * 应用
		*/
		public static final DBField APP_INFO = new DBField(DBDataType.STRING , "app_info","appInfo","应用","应用",false,false,true);
		
		/**
		 * 等级
		*/
		public static final DBField GRADE = new DBField(DBDataType.STRING , "grade","grade","等级","等级",false,false,true);
		
		/**
		 * RTO
		*/
		public static final DBField RTO = new DBField(DBDataType.STRING , "rto","rto","RTO","RTO",false,false,true);
		
		/**
		 * RPO
		*/
		public static final DBField RPO = new DBField(DBDataType.STRING , "rpo","rpo","RPO","RPO",false,false,true);
		
		/**
		 * 硬件信息
		*/
		public static final DBField HARDWARE_INFO = new DBField(DBDataType.STRING , "hardware_info","hardwareInfo","硬件信息","硬件信息",false,false,true);
		
		/**
		 * 备份信息
		*/
		public static final DBField BACKUP_INFO = new DBField(DBDataType.STRING , "backup_info","backupInfo","备份信息","备份信息",false,false,true);
		
		/**
		 * 本地备份
		*/
		public static final DBField SAMEPLACE_BACUP_INFO = new DBField(DBDataType.STRING , "sameplace_bacup_info","sameplaceBacupInfo","本地备份","本地备份",false,false,true);
		
		/**
		 * 异地备份
		*/
		public static final DBField DIFFPLACE_BACKUP_INFO = new DBField(DBDataType.STRING , "diffplace_backup_info","diffplaceBackupInfo","异地备份","异地备份",false,false,true);
		
		/**
		 * 归档模式
		*/
		public static final DBField ARCH_METHOD = new DBField(DBDataType.STRING , "arch_method","archMethod","归档模式","归档模式",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABELS = new DBField(DBDataType.STRING , "labels","labels","标签","标签",false,false,true);
		
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
		
		public OPS_INFORMATION_SYSTEM() {
			this.init($NAME,"信息系统" , ID , PID , NAME , PROFILE , STATUS , OPS_METHOD , DEV_METHOD , TECHNICAL_CONTACT , BUSINESS_CONTACT , BELONG_ORG_ID , LASTDRILL_DATE , ONLINE_DATE , OFFLINE_DATE , OS_INFO , DB_INFO , APP_INFO , GRADE , RTO , RPO , HARDWARE_INFO , BACKUP_INFO , SAMEPLACE_BACUP_INFO , DIFFPLACE_BACKUP_INFO , ARCH_METHOD , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_INFORMATION_SYSTEM $TABLE=new OPS_INFORMATION_SYSTEM();
	}
	
	/**
	 * 节点
	*/
	public static class OPS_MONITOR_NODE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 父节点
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父节点","父节点",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 子类型
		*/
		public static final DBField SUB_TYPE = new DBField(DBDataType.STRING , "sub_type","subType","子类型","子类型",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField NODE_IP = new DBField(DBDataType.STRING , "node_ip","nodeIp","IP","IP",false,false,true);
		
		/**
		 * 主机名
		*/
		public static final DBField NODE_NAME = new DBField(DBDataType.STRING , "node_name","nodeName","主机名","主机名",false,false,true);
		
		/**
		 * 可见主机名
		*/
		public static final DBField NODE_NAME_SHOW = new DBField(DBDataType.STRING , "node_name_show","nodeNameShow","可见主机名","可见主机名",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField NODE_TYPE = new DBField(DBDataType.STRING , "node_type","nodeType","类型","类型",false,false,true);
		
		/**
		 * 是否启用
		*/
		public static final DBField NODE_ENABLED = new DBField(DBDataType.STRING , "node_enabled","nodeEnabled","是否启用","是否启用",false,false,true);
		
		/**
		 * 监控状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","监控状态","监控状态",false,false,true);
		
		/**
		 * 监控方式
		*/
		public static final DBField MONITOR_METHOD = new DBField(DBDataType.STRING , "monitor_method","monitorMethod","监控方式","监控方式",false,false,true);
		
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
		
		public OPS_MONITOR_NODE() {
			this.init($NAME,"节点" , ID , PID , TYPE , SUB_TYPE , NODE_IP , NODE_NAME , NODE_NAME_SHOW , NODE_TYPE , NODE_ENABLED , STATUS , MONITOR_METHOD , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE $TABLE=new OPS_MONITOR_NODE();
	}
	
	/**
	 * 节点数据库
	*/
	public static class OPS_MONITOR_NODE_DB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_db";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 数据库名称
		*/
		public static final DBField DB_NAME = new DBField(DBDataType.DATE , "db_name","dbName","数据库名称","数据库名称",false,false,true);
		
		/**
		 * 实例名称
		*/
		public static final DBField DB_INSTANCE = new DBField(DBDataType.DATE , "db_instance","dbInstance","实例名称","实例名称",false,false,true);
		
		/**
		 * 数据库版本
		*/
		public static final DBField DB_VERION = new DBField(DBDataType.STRING , "db_verion","dbVerion","数据库版本","数据库版本",false,false,true);
		
		/**
		 * 连接数
		*/
		public static final DBField CONNECT_COUNT = new DBField(DBDataType.INTEGER , "connect_count","connectCount","连接数","连接数",false,false,true);
		
		/**
		 * 数据库大小
		*/
		public static final DBField DB_SIZE = new DBField(DBDataType.DECIMAL , "db_size","dbSize","数据库大小","数据库大小",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
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
		
		public OPS_MONITOR_NODE_DB() {
			this.init($NAME,"节点数据库" , ID , NODE_ID , DB_NAME , DB_INSTANCE , DB_VERION , CONNECT_COUNT , DB_SIZE , RECORD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_DB $TABLE=new OPS_MONITOR_NODE_DB();
	}
	
	/**
	 * 节点主机
	*/
	public static class OPS_MONITOR_NODE_HOST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_host";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOSTNAME = new DBField(DBDataType.DATE , "hostname","hostname","主机名称","主机名称",false,false,true);
		
		/**
		 * 启动时间
		*/
		public static final DBField BOOTTIME = new DBField(DBDataType.DATE , "boottime","boottime","启动时间","启动时间",false,false,true);
		
		/**
		 * 系统
		*/
		public static final DBField OS_VERION = new DBField(DBDataType.STRING , "os_verion","osVerion","系统","系统",false,false,true);
		
		/**
		 * 架构
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","架构","架构",false,false,true);
		
		/**
		 * CPU数量
		*/
		public static final DBField CPU = new DBField(DBDataType.INTEGER , "cpu","cpu","CPU数量","CPU数量",false,false,true);
		
		/**
		 * CPU主频
		*/
		public static final DBField CPU_FRE = new DBField(DBDataType.DECIMAL , "cpu_fre","cpuFre","CPU主频","CPU主频",false,false,true);
		
		/**
		 * 内存(M)
		*/
		public static final DBField MEMORY = new DBField(DBDataType.INTEGER , "memory","memory","内存(M)","内存(M)",false,false,true);
		
		/**
		 * cpuSys
		*/
		public static final DBField CPU_SYS = new DBField(DBDataType.DECIMAL , "cpu_sys","cpuSys","cpuSys","cpuSys",false,false,true);
		
		/**
		 * cpuUser
		*/
		public static final DBField CPU_USER = new DBField(DBDataType.DECIMAL , "cpu_user","cpuUser","cpuUser","cpuUser",false,false,true);
		
		/**
		 * cpuWait
		*/
		public static final DBField CPU_WAIT = new DBField(DBDataType.DECIMAL , "cpu_wait","cpuWait","cpuWait","cpuWait",false,false,true);
		
		/**
		 * CPU空闲旅
		*/
		public static final DBField CPU_IDLE = new DBField(DBDataType.DECIMAL , "cpu_idle","cpuIdle","CPU空闲旅","CPU空闲旅",false,false,true);
		
		/**
		 * CPU使用率
		*/
		public static final DBField CPU_USED = new DBField(DBDataType.DECIMAL , "cpu_used","cpuUsed","CPU使用率","CPU使用率",false,false,true);
		
		/**
		 * 系统负载
		*/
		public static final DBField OS_LOAD = new DBField(DBDataType.DECIMAL , "os_load","osLoad","系统负载","系统负载",false,false,true);
		
		/**
		 * 系统负载5
		*/
		public static final DBField OS_LOAD5 = new DBField(DBDataType.DECIMAL , "os_load5","osLoad5","系统负载5","系统负载5",false,false,true);
		
		/**
		 * 系统负载15
		*/
		public static final DBField OS_LOAD15 = new DBField(DBDataType.DECIMAL , "os_load15","osLoad15","系统负载15","系统负载15",false,false,true);
		
		/**
		 * 内存使用率
		*/
		public static final DBField MEMORY_USED = new DBField(DBDataType.DECIMAL , "memory_used","memoryUsed","内存使用率","内存使用率",false,false,true);
		
		/**
		 * 虚拟内存使用率
		*/
		public static final DBField VMEMORY_USED = new DBField(DBDataType.DECIMAL , "vmemory_used","vmemoryUsed","虚拟内存使用率","虚拟内存使用率",false,false,true);
		
		/**
		 * 上行流量
		*/
		public static final DBField NETWORK_FLOW_UP = new DBField(DBDataType.DECIMAL , "network_flow_up","networkFlowUp","上行流量","上行流量",false,false,true);
		
		/**
		 * 下流量
		*/
		public static final DBField NETWORK_FLOW_DOWN = new DBField(DBDataType.DECIMAL , "network_flow_down","networkFlowDown","下流量","下流量",false,false,true);
		
		/**
		 * 连接数
		*/
		public static final DBField PROCESS_CNT = new DBField(DBDataType.INTEGER , "process_cnt","processCnt","连接数","连接数",false,false,true);
		
		/**
		 * 内存
		*/
		public static final DBField P_MEMORY_USED = new DBField(DBDataType.INTEGER , "p_memory_used","pMemoryUsed","内存","内存",false,false,true);
		
		/**
		 * 虚拟内存
		*/
		public static final DBField V_MEMORY_USED = new DBField(DBDataType.INTEGER , "v_memory_used","vMemoryUsed","虚拟内存","虚拟内存",false,false,true);
		
		/**
		 * 信息
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","信息","信息",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
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
		
		public OPS_MONITOR_NODE_HOST() {
			this.init($NAME,"节点主机" , ID , NODE_ID , HOSTNAME , BOOTTIME , OS_VERION , ARCH , CPU , CPU_FRE , MEMORY , CPU_SYS , CPU_USER , CPU_WAIT , CPU_IDLE , CPU_USED , OS_LOAD , OS_LOAD5 , OS_LOAD15 , MEMORY_USED , VMEMORY_USED , NETWORK_FLOW_UP , NETWORK_FLOW_DOWN , PROCESS_CNT , P_MEMORY_USED , V_MEMORY_USED , INFO , RECORD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_HOST $TABLE=new OPS_MONITOR_NODE_HOST();
	}
	
	/**
	 * 节点列表数值
	*/
	public static class OPS_MONITOR_NODE_LIST_VALUE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_list_value";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","指标","指标",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 值类型
		*/
		public static final DBField VALUE_TYPE = new DBField(DBDataType.STRING , "value_type","valueType","值类型","值类型",false,false,true);
		
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
		 * 编码1
		*/
		public static final DBField CODE1 = new DBField(DBDataType.STRING , "code1","code1","编码1","编码1",false,false,true);
		
		/**
		 * 编码2
		*/
		public static final DBField CODE2 = new DBField(DBDataType.STRING , "code2","code2","编码2","编码2",false,false,true);
		
		/**
		 * 数值1
		*/
		public static final DBField VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "value_number1","valueNumber1","数值1","数值1",false,false,true);
		
		/**
		 * 数值2
		*/
		public static final DBField VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "value_number2","valueNumber2","数值2","数值2",false,false,true);
		
		/**
		 * 数值3
		*/
		public static final DBField VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "value_number3","valueNumber3","数值3","数值3",false,false,true);
		
		/**
		 * 字符串1
		*/
		public static final DBField VALUE_STR1 = new DBField(DBDataType.STRING , "value_str1","valueStr1","字符串1","字符串1",false,false,true);
		
		/**
		 * 字符串2
		*/
		public static final DBField VALUE_STR2 = new DBField(DBDataType.STRING , "value_str2","valueStr2","字符串2","字符串2",false,false,true);
		
		/**
		 * 字符串3
		*/
		public static final DBField VALUE_STR3 = new DBField(DBDataType.STRING , "value_str3","valueStr3","字符串3","字符串3",false,false,true);
		
		/**
		 * 唯一标识
		*/
		public static final DBField UID = new DBField(DBDataType.STRING , "uid","uid","唯一标识","唯一标识",false,false,true);
		
		/**
		 * 信息
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","信息","信息",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_LIST_VALUE() {
			this.init($NAME,"节点列表数值" , ID , NODE_ID , INDICATOR_CODE , MONITOR_TPL_CODE , VALUE_TYPE , LABEL1 , LABEL2 , LABEL3 , CODE1 , CODE2 , VALUE_NUMBER1 , VALUE_NUMBER2 , VALUE_NUMBER3 , VALUE_STR1 , VALUE_STR2 , VALUE_STR3 , UID , INFO , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_LIST_VALUE $TABLE=new OPS_MONITOR_NODE_LIST_VALUE();
	}
	
	/**
	 * 节点映射
	*/
	public static class OPS_MONITOR_NODE_MAP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_map";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 源值
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","源值","源值",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP","IP",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION_METHOD = new DBField(DBDataType.STRING , "action_method","actionMethod","动作","动作",false,false,true);
		
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
		
		public OPS_MONITOR_NODE_MAP() {
			this.init($NAME,"节点映射" , ID , NODE_ID , SOURCE_ID , IP , ACTION_METHOD , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_MAP $TABLE=new OPS_MONITOR_NODE_MAP();
	}
	
	/**
	 * 节点子类型
	*/
	public static class OPS_MONITOR_NODE_SUBTYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_subtype";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
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
		
		public OPS_MONITOR_NODE_SUBTYPE() {
			this.init($NAME,"节点子类型" , ID , TYPE , NAME , CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_SUBTYPE $TABLE=new OPS_MONITOR_NODE_SUBTYPE();
	}
	
	/**
	 * 节点监控模版
	*/
	public static class OPS_MONITOR_NODE_TPL_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_tpl_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
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
		
		public OPS_MONITOR_NODE_TPL_ITEM() {
			this.init($NAME,"节点监控模版" , ID , NODE_ID , TPL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_TPL_ITEM $TABLE=new OPS_MONITOR_NODE_TPL_ITEM();
	}
	
	/**
	 * 节点类型
	*/
	public static class OPS_MONITOR_NODE_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_type";
		
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
		
		public OPS_MONITOR_NODE_TYPE() {
			this.init($NAME,"节点类型" , ID , NAME , CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_TYPE $TABLE=new OPS_MONITOR_NODE_TYPE();
	}
	
	/**
	 * 节点数值
	*/
	public static class OPS_MONITOR_NODE_VALUE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_value";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","指标","指标",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOSTNAME = new DBField(DBDataType.DATE , "hostname","hostname","主机名称","主机名称",false,false,true);
		
		/**
		 * 启动时间
		*/
		public static final DBField BOOTTIME = new DBField(DBDataType.DATE , "boottime","boottime","启动时间","启动时间",false,false,true);
		
		/**
		 * 系统
		*/
		public static final DBField OS_VERION = new DBField(DBDataType.STRING , "os_verion","osVerion","系统","系统",false,false,true);
		
		/**
		 * 架构
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","架构","架构",false,false,true);
		
		/**
		 * CPU数量
		*/
		public static final DBField CPU = new DBField(DBDataType.INTEGER , "cpu","cpu","CPU数量","CPU数量",false,false,true);
		
		/**
		 * CPU主频
		*/
		public static final DBField CPU_FRE = new DBField(DBDataType.DECIMAL , "cpu_fre","cpuFre","CPU主频","CPU主频",false,false,true);
		
		/**
		 * 内存(M)
		*/
		public static final DBField MEMORY = new DBField(DBDataType.INTEGER , "memory","memory","内存(M)","内存(M)",false,false,true);
		
		/**
		 * cpuSys
		*/
		public static final DBField CPU_SYS = new DBField(DBDataType.DECIMAL , "cpu_sys","cpuSys","cpuSys","cpuSys",false,false,true);
		
		/**
		 * cpuUser
		*/
		public static final DBField CPU_USER = new DBField(DBDataType.DECIMAL , "cpu_user","cpuUser","cpuUser","cpuUser",false,false,true);
		
		/**
		 * cpuWait
		*/
		public static final DBField CPU_WAIT = new DBField(DBDataType.DECIMAL , "cpu_wait","cpuWait","cpuWait","cpuWait",false,false,true);
		
		/**
		 * CPU空闲旅
		*/
		public static final DBField CPU_IDLE = new DBField(DBDataType.DECIMAL , "cpu_idle","cpuIdle","CPU空闲旅","CPU空闲旅",false,false,true);
		
		/**
		 * CPU使用率
		*/
		public static final DBField CPU_USED = new DBField(DBDataType.DECIMAL , "cpu_used","cpuUsed","CPU使用率","CPU使用率",false,false,true);
		
		/**
		 * 系统负载
		*/
		public static final DBField OS_LOAD = new DBField(DBDataType.DECIMAL , "os_load","osLoad","系统负载","系统负载",false,false,true);
		
		/**
		 * 系统负载5
		*/
		public static final DBField OS_LOAD5 = new DBField(DBDataType.DECIMAL , "os_load5","osLoad5","系统负载5","系统负载5",false,false,true);
		
		/**
		 * 系统负载15
		*/
		public static final DBField OS_LOAD15 = new DBField(DBDataType.DECIMAL , "os_load15","osLoad15","系统负载15","系统负载15",false,false,true);
		
		/**
		 * 内存使用率
		*/
		public static final DBField MEMORY_USED = new DBField(DBDataType.DECIMAL , "memory_used","memoryUsed","内存使用率","内存使用率",false,false,true);
		
		/**
		 * 虚拟内存使用率
		*/
		public static final DBField VMEMORY_USED = new DBField(DBDataType.DECIMAL , "vmemory_used","vmemoryUsed","虚拟内存使用率","虚拟内存使用率",false,false,true);
		
		/**
		 * 上行流量
		*/
		public static final DBField NETWORK_FLOW_UP = new DBField(DBDataType.DECIMAL , "network_flow_up","networkFlowUp","上行流量","上行流量",false,false,true);
		
		/**
		 * 下流量
		*/
		public static final DBField NETWORK_FLOW_DOWN = new DBField(DBDataType.DECIMAL , "network_flow_down","networkFlowDown","下流量","下流量",false,false,true);
		
		/**
		 * 连接数
		*/
		public static final DBField PROCESS_CNT = new DBField(DBDataType.INTEGER , "process_cnt","processCnt","连接数","连接数",false,false,true);
		
		/**
		 * 内存
		*/
		public static final DBField P_MEMORY_USED = new DBField(DBDataType.INTEGER , "p_memory_used","pMemoryUsed","内存","内存",false,false,true);
		
		/**
		 * 虚拟内存
		*/
		public static final DBField V_MEMORY_USED = new DBField(DBDataType.INTEGER , "v_memory_used","vMemoryUsed","虚拟内存","虚拟内存",false,false,true);
		
		/**
		 * 信息
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","信息","信息",false,false,true);
		
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
		 * 编码1
		*/
		public static final DBField CODE1 = new DBField(DBDataType.STRING , "code1","code1","编码1","编码1",false,false,true);
		
		/**
		 * 编码2
		*/
		public static final DBField CODE2 = new DBField(DBDataType.STRING , "code2","code2","编码2","编码2",false,false,true);
		
		/**
		 * 编码3
		*/
		public static final DBField CODE3 = new DBField(DBDataType.STRING , "code3","code3","编码3","编码3",false,false,true);
		
		/**
		 * 数值1
		*/
		public static final DBField VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "value_number1","valueNumber1","数值1","数值1",false,false,true);
		
		/**
		 * 数值2
		*/
		public static final DBField VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "value_number2","valueNumber2","数值2","数值2",false,false,true);
		
		/**
		 * 数值3
		*/
		public static final DBField VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "value_number3","valueNumber3","数值3","数值3",false,false,true);
		
		/**
		 * 字符串1
		*/
		public static final DBField VALUE_STR1 = new DBField(DBDataType.STRING , "value_str1","valueStr1","字符串1","字符串1",false,false,true);
		
		/**
		 * 字符串2
		*/
		public static final DBField VALUE_STR2 = new DBField(DBDataType.STRING , "value_str2","valueStr2","字符串2","字符串2",false,false,true);
		
		/**
		 * 字符串3
		*/
		public static final DBField VALUE_STR3 = new DBField(DBDataType.STRING , "value_str3","valueStr3","字符串3","字符串3",false,false,true);
		
		/**
		 * 整数1
		*/
		public static final DBField VALUE_INT1 = new DBField(DBDataType.STRING , "value_int1","valueInt1","整数1","整数1",false,false,true);
		
		/**
		 * 整数2
		*/
		public static final DBField VALUE_INT2 = new DBField(DBDataType.STRING , "value_int2","valueInt2","整数2","整数2",false,false,true);
		
		/**
		 * 整数3
		*/
		public static final DBField VALUE_INT3 = new DBField(DBDataType.STRING , "value_int3","valueInt3","整数3","整数3",false,false,true);
		
		/**
		 * 唯一标识
		*/
		public static final DBField UID = new DBField(DBDataType.STRING , "uid","uid","唯一标识","唯一标识",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 标签列1
		*/
		public static final DBField LIST_LABEL1 = new DBField(DBDataType.STRING , "list_label1","listLabel1","标签列1","标签列1",false,false,true);
		
		/**
		 * 标签列2
		*/
		public static final DBField LIST_LABEL2 = new DBField(DBDataType.STRING , "list_label2","listLabel2","标签列2","标签列2",false,false,true);
		
		/**
		 * 标签列3
		*/
		public static final DBField LIST_LABEL3 = new DBField(DBDataType.STRING , "list_label3","listLabel3","标签列3","标签列3",false,false,true);
		
		/**
		 * 编码列1
		*/
		public static final DBField LIST_CODE1 = new DBField(DBDataType.STRING , "list_code1","listCode1","编码列1","编码列1",false,false,true);
		
		/**
		 * 编码列2
		*/
		public static final DBField LIST_CODE2 = new DBField(DBDataType.STRING , "list_code2","listCode2","编码列2","编码列2",false,false,true);
		
		/**
		 * 编码列3
		*/
		public static final DBField LIST_CODE23 = new DBField(DBDataType.STRING , "list_code23","listCode23","编码列3","编码列3",false,false,true);
		
		/**
		 * 数值列1
		*/
		public static final DBField LIST_VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "list_value_number1","listValueNumber1","数值列1","数值列1",false,false,true);
		
		/**
		 * 数值列2
		*/
		public static final DBField LIST_VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "list_value_number2","listValueNumber2","数值列2","数值列2",false,false,true);
		
		/**
		 * 数值列3
		*/
		public static final DBField LIST_VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "list_value_number3","listValueNumber3","数值列3","数值列3",false,false,true);
		
		/**
		 * 字符串列1
		*/
		public static final DBField LIST_VALUE_STR1 = new DBField(DBDataType.STRING , "list_value_str1","listValueStr1","字符串列1","字符串列1",false,false,true);
		
		/**
		 * 字符串列2
		*/
		public static final DBField LIST_VALUE_STR2 = new DBField(DBDataType.STRING , "list_value_str2","listValueStr2","字符串列2","字符串列2",false,false,true);
		
		/**
		 * 字符串列3
		*/
		public static final DBField LIST_VALUE_STR3 = new DBField(DBDataType.STRING , "list_value_str3","listValueStr3","字符串列3","字符串列3",false,false,true);
		
		/**
		 * 整数列1
		*/
		public static final DBField LIST_VALUE_INT1 = new DBField(DBDataType.STRING , "list_value_int1","listValueInt1","整数列1","整数列1",false,false,true);
		
		/**
		 * 整数列2
		*/
		public static final DBField LIST_VALUE_INT2 = new DBField(DBDataType.STRING , "list_value_int2","listValueInt2","整数列2","整数列2",false,false,true);
		
		/**
		 * 整数列3
		*/
		public static final DBField LIST_VALUE_INT3 = new DBField(DBDataType.STRING , "list_value_int3","listValueInt3","整数列3","整数列3",false,false,true);
		
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
		
		public OPS_MONITOR_NODE_VALUE() {
			this.init($NAME,"节点数值" , ID , NODE_ID , MONITOR_TPL_CODE , INDICATOR_CODE , HOSTNAME , BOOTTIME , OS_VERION , ARCH , CPU , CPU_FRE , MEMORY , CPU_SYS , CPU_USER , CPU_WAIT , CPU_IDLE , CPU_USED , OS_LOAD , OS_LOAD5 , OS_LOAD15 , MEMORY_USED , VMEMORY_USED , NETWORK_FLOW_UP , NETWORK_FLOW_DOWN , PROCESS_CNT , P_MEMORY_USED , V_MEMORY_USED , INFO , LABEL1 , LABEL2 , LABEL3 , CODE1 , CODE2 , CODE3 , VALUE_NUMBER1 , VALUE_NUMBER2 , VALUE_NUMBER3 , VALUE_STR1 , VALUE_STR2 , VALUE_STR3 , VALUE_INT1 , VALUE_INT2 , VALUE_INT3 , UID , RECORD_TIME , LIST_LABEL1 , LIST_LABEL2 , LIST_LABEL3 , LIST_CODE1 , LIST_CODE2 , LIST_CODE23 , LIST_VALUE_NUMBER1 , LIST_VALUE_NUMBER2 , LIST_VALUE_NUMBER3 , LIST_VALUE_STR1 , LIST_VALUE_STR2 , LIST_VALUE_STR3 , LIST_VALUE_INT1 , LIST_VALUE_INT2 , LIST_VALUE_INT3 , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_VALUE $TABLE=new OPS_MONITOR_NODE_VALUE();
	}
	
	/**
	 * 监控模版
	*/
	public static class OPS_MONITOR_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl";
		
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
		 * 分类
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","分类","分类",false,false,true);
		
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
		
		public OPS_MONITOR_TPL() {
			this.init($NAME,"监控模版" , ID , NAME , CODE , TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL $TABLE=new OPS_MONITOR_TPL();
	}
	
	/**
	 * 模版指标
	*/
	public static class OPS_MONITOR_TPL_INDICATOR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl_indicator";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 指标类型
		*/
		public static final DBField INDICATOR_TYPE = new DBField(DBDataType.STRING , "indicator_type","indicatorType","指标类型","指标类型",false,false,true);
		
		/**
		 * 值行数
		*/
		public static final DBField VALUE_DATA_ROWS = new DBField(DBDataType.STRING , "value_data_rows","valueDataRows","值行数","值行数",false,false,true);
		
		/**
		 * 值类型
		*/
		public static final DBField VALUE_TYPE = new DBField(DBDataType.STRING , "value_type","valueType","值类型","值类型",false,false,true);
		
		/**
		 * 来源类型
		*/
		public static final DBField SOURCE_TYPE = new DBField(DBDataType.STRING , "source_type","sourceType","来源类型","来源类型",false,false,true);
		
		/**
		 * 来源数据
		*/
		public static final DBField SOURCE_VALUE = new DBField(DBDataType.STRING , "source_value","sourceValue","来源数据","来源数据",false,false,true);
		
		/**
		 * 数值类型
		*/
		public static final DBField VALUE_COLUMN_TYPE = new DBField(DBDataType.STRING , "value_column_type","valueColumnType","数值类型","数值类型",false,false,true);
		
		/**
		 * 数值字段
		*/
		public static final DBField VALUE_COLUMN = new DBField(DBDataType.STRING , "value_column","valueColumn","数值字段","数值字段",false,false,true);
		
		/**
		 * 描述
		*/
		public static final DBField VALUE_COLUMN_DESC = new DBField(DBDataType.STRING , "value_column_desc","valueColumnDesc","描述","描述",false,false,true);
		
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
		
		public OPS_MONITOR_TPL_INDICATOR() {
			this.init($NAME,"模版指标" , ID , MONITOR_TPL_CODE , NAME , CODE , INDICATOR_TYPE , VALUE_DATA_ROWS , VALUE_TYPE , SOURCE_TYPE , SOURCE_VALUE , VALUE_COLUMN_TYPE , VALUE_COLUMN , VALUE_COLUMN_DESC , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL_INDICATOR $TABLE=new OPS_MONITOR_TPL_INDICATOR();
	}
	
	/**
	 * 节点告警
	*/
	public static class OPS_MONITOR_WARN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_warn";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","类型","类型",false,false,true);
		
		/**
		 * 监控数值
		*/
		public static final DBField NODE_VALUE_ID = new DBField(DBDataType.STRING , "node_value_id","nodeValueId","监控数值","监控数值",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 监控指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","监控指标","监控指标",false,false,true);
		
		/**
		 * 指标名称
		*/
		public static final DBField INDICATOR_NAME = new DBField(DBDataType.STRING , "indicator_name","indicatorName","指标名称","指标名称",false,false,true);
		
		/**
		 * 告警等级
		*/
		public static final DBField WARN_LEVEL = new DBField(DBDataType.STRING , "warn_level","warnLevel","告警等级","告警等级",false,false,true);
		
		/**
		 * 处理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","处理状态","处理状态",false,false,true);
		
		/**
		 * 处理时间
		*/
		public static final DBField HANDLED_TIME = new DBField(DBDataType.DATE , "handled_time","handledTime","处理时间","处理时间",false,false,true);
		
		/**
		 * 告警时间
		*/
		public static final DBField WARN_TIME = new DBField(DBDataType.DATE , "warn_time","warnTime","告警时间","告警时间",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
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
		
		public OPS_MONITOR_WARN() {
			this.init($NAME,"节点告警" , ID , NODE_ID , NODE_VALUE_ID , MONITOR_TPL_CODE , INDICATOR_CODE , INDICATOR_NAME , WARN_LEVEL , STATUS , HANDLED_TIME , WARN_TIME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_WARN $TABLE=new OPS_MONITOR_WARN();
	}
	
	/**
	 * 节点
	*/
	public static class OPS_OPS_HOST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * IP
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP","IP",false,false,true);
		
		/**
		 * 端口
		*/
		public static final DBField PORT = new DBField(DBDataType.STRING , "port","port","端口","端口",false,false,true);
		
		/**
		 * 主机凭证
		*/
		public static final DBField HOST_VOUCHER = new DBField(DBDataType.STRING , "host_voucher","hostVoucher","主机凭证","主机凭证",false,false,true);
		
		/**
		 * 变量
		*/
		public static final DBField OTHER_VARIABLE = new DBField(DBDataType.STRING , "other_variable","otherVariable","变量","变量",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST() {
			this.init($NAME,"节点" , ID , IP , PORT , HOST_VOUCHER , OTHER_VARIABLE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST $TABLE=new OPS_OPS_HOST();
	}
	
	/**
	 * 节点组
	*/
	public static class OPS_OPS_HOST_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host_group";
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST_GROUP() {
			this.init($NAME,"节点组" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST_GROUP $TABLE=new OPS_OPS_HOST_GROUP();
	}
	
	/**
	 * 节点组明细
	*/
	public static class OPS_OPS_HOST_GROUP_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host_group_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,false);
		
		/**
		 * 主机组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","主机组","主机组",false,false,false);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST_GROUP_ITEM() {
			this.init($NAME,"节点组明细" , ID , HOST_ID , GROUP_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST_GROUP_ITEM $TABLE=new OPS_OPS_HOST_GROUP_ITEM();
	}
	
	/**
	 * 节点凭证
	*/
	public static class OPS_OPS_HOST_VOUCHER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host_voucher";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 密码
		*/
		public static final DBField HOST_USER = new DBField(DBDataType.STRING , "host_user","hostUser","密码","密码",false,false,true);
		
		/**
		 * 密码
		*/
		public static final DBField HOST_PWD = new DBField(DBDataType.STRING , "host_pwd","hostPwd","密码","密码",false,false,true);
		
		/**
		 * 加密
		*/
		public static final DBField PWD_ENCRYPT = new DBField(DBDataType.STRING , "pwd_encrypt","pwdEncrypt","加密","加密",false,false,true);
		
		/**
		 * 加密
		*/
		public static final DBField ENCRYPT = new DBField(DBDataType.STRING , "encrypt","encrypt","加密","加密",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST_VOUCHER() {
			this.init($NAME,"节点凭证" , ID , HOST_USER , HOST_PWD , PWD_ENCRYPT , ENCRYPT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST_VOUCHER $TABLE=new OPS_OPS_HOST_VOUCHER();
	}
	
	/**
	 * 服务类型
	*/
	public static class OPS_SERVICE_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 服务分组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","服务分组","服务分组",false,false,true);
		
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
		
		public OPS_SERVICE_CATEGORY() {
			this.init($NAME,"服务类型" , ID , GROUP_ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_SERVICE_CATEGORY $TABLE=new OPS_SERVICE_CATEGORY();
	}
	
	/**
	 * 服务分组
	*/
	public static class OPS_SERVICE_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_group";
		
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
		
		public OPS_SERVICE_GROUP() {
			this.init($NAME,"服务分组" , ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_SERVICE_GROUP $TABLE=new OPS_SERVICE_GROUP();
	}
	
	/**
	 * 服务
	*/
	public static class OPS_SERVICE_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 服务分组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","服务分组","服务分组",false,false,true);
		
		/**
		 * 服务分类
		*/
		public static final DBField SERVICE_CATEGORY_ID = new DBField(DBDataType.STRING , "service_category_id","serviceCategoryId","服务分类","服务分类",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 补丁
		*/
		public static final DBField PATCH = new DBField(DBDataType.STRING , "patch","patch","补丁","补丁",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public OPS_SERVICE_INFO() {
			this.init($NAME,"服务" , ID , GROUP_ID , SERVICE_CATEGORY_ID , NAME , PATCH , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_SERVICE_INFO $TABLE=new OPS_SERVICE_INFO();
	}
	
	/**
	 * 凭证
	*/
	public static class OPS_VOUCHER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类别
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类别","类别",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_CODE = new DBField(DBDataType.STRING , "user_code","userCode","用户","用户",false,false,true);
		
		/**
		 * 凭证
		*/
		public static final DBField VOUCHER = new DBField(DBDataType.STRING , "voucher","voucher","凭证","凭证",false,false,true);
		
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
		
		public OPS_VOUCHER() {
			this.init($NAME,"凭证" , ID , TYPE , OWNER_ID , USER_CODE , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER $TABLE=new OPS_VOUCHER();
	}
	
	/**
	 * 凭证记录
	*/
	public static class OPS_VOUCHER_HISTORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher_history";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 凭证
		*/
		public static final DBField VOUCHER_ID = new DBField(DBDataType.STRING , "voucher_id","voucherId","凭证","凭证",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_CODE = new DBField(DBDataType.STRING , "user_code","userCode","用户","用户",false,false,true);
		
		/**
		 * 凭证
		*/
		public static final DBField VOUCHER = new DBField(DBDataType.STRING , "voucher","voucher","凭证","凭证",false,false,true);
		
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
		
		public OPS_VOUCHER_HISTORY() {
			this.init($NAME,"凭证记录" , ID , VOUCHER_ID , USER_CODE , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER_HISTORY $TABLE=new OPS_VOUCHER_HISTORY();
	}
	
	/**
	 * 所属凭证
	*/
	public static class OPS_VOUCHER_OWNER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher_owner";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类别
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","类别","类别",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION = new DBField(DBDataType.STRING , "position","position","位置","位置",false,false,true);
		
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
		
		public OPS_VOUCHER_OWNER() {
			this.init($NAME,"所属凭证" , ID , CATEGORY_CODE , LABEL , NAME , POSITION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER_OWNER $TABLE=new OPS_VOUCHER_OWNER();
	}
	
	/**
	 * 凭证权限
	*/
	public static class OPS_VOUCHER_PRIV extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher_priv";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 凭证类别
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","凭证类别","凭证类别",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField EMPL_ID = new DBField(DBDataType.STRING , "empl_id","emplId","用户","用户",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
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
		
		public OPS_VOUCHER_PRIV() {
			this.init($NAME,"凭证权限" , ID , TYPE , EMPL_ID , STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER_PRIV $TABLE=new OPS_VOUCHER_PRIV();
	}
	
	/**
	 * rfid基站
	*/
	public static class RFID_BASE_STATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "rfid_base_station";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 区域主键
		*/
		public static final DBField AREA_ID = new DBField(DBDataType.STRING , "area_id","areaId","区域主键","区域主键",false,false,true);
		
		/**
		 * 基站名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","基站名称","基站名称",false,false,true);
		
		/**
		 * 经度
		*/
		public static final DBField LONGITUDE = new DBField(DBDataType.DECIMAL , "longitude","longitude","经度","经度",false,false,true);
		
		/**
		 * 纬度
		*/
		public static final DBField LATITUDE = new DBField(DBDataType.DECIMAL , "latitude","latitude","纬度","纬度",false,false,true);
		
		/**
		 * 设备ID
		*/
		public static final DBField DEVICE_ID = new DBField(DBDataType.STRING , "device_id","deviceId","设备ID","设备ID",false,false,true);
		
		/**
		 * 设备类型，1：无源；2：有源
		*/
		public static final DBField DEVICE_TYPE = new DBField(DBDataType.STRING , "device_type","deviceType","设备类型","1：无源；2：有源",false,false,true);
		
		/**
		 * 是否在线
		*/
		public static final DBField IS_ON_LINE = new DBField(DBDataType.INTEGER , "is_on_line","isOnLine","是否在线","是否在线",false,false,true);
		
		/**
		 * 工作类型，1：入基站；2：出基站；3：范围基站；4：工位基站
		*/
		public static final DBField WORK_TYPE = new DBField(DBDataType.STRING , "work_type","workType","工作类型","1：入基站；2：出基站；3：范围基站；4：工位基站",false,false,true);
		
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
		
		public RFID_BASE_STATION() {
			this.init($NAME,"rfid基站" , ID , AREA_ID , NAME , LONGITUDE , LATITUDE , DEVICE_ID , DEVICE_TYPE , IS_ON_LINE , WORK_TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final RFID_BASE_STATION $TABLE=new RFID_BASE_STATION();
	}
	
	/**
	 * 区域
	*/
	public static class RFID_DEVICE_AREA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "rfid_device_area";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 区域名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","区域名称","区域名称",false,false,true);
		
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
		
		public RFID_DEVICE_AREA() {
			this.init($NAME,"区域" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final RFID_DEVICE_AREA $TABLE=new RFID_DEVICE_AREA();
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
	
	/**
	 * 工单类型
	*/
	public static class WORKORDER_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "workorder_category";
		
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
		
		public WORKORDER_CATEGORY() {
			this.init($NAME,"工单类型" , ID , NAME , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WORKORDER_CATEGORY $TABLE=new WORKORDER_CATEGORY();
	}
}