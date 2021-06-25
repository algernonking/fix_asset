package com.dt.eam.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2021-06-25 16:26:30
 * @author 李方捷 , leefangjie@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class EAMTables {
	
	/**
	 * 资产存放区域
	*/
	public static class EAM_AREA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_area";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField AREA_NAME = new DBField(DBDataType.STRING , "area_name","areaName","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField AREA_NOTES = new DBField(DBDataType.STRING , "area_notes","areaNotes","备注","备注",false,false,true);
		
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
		
		public EAM_AREA() {
			this.init($NAME,"资产存放区域" , ID , AREA_NAME , AREA_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_AREA $TABLE=new EAM_AREA();
	}
	
	/**
	 * 资产表
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
		 * 分类ID
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","分类ID","分类ID",false,false,true);
		
		/**
		 * 标准型号，资产名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标准型号","资产名称",false,false,true);
		
		/**
		 * 标准型号，厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","标准型号","厂商",false,false,true);
		
		/**
		 * 标准型号，品牌
		*/
		public static final DBField BRAND_ID = new DBField(DBDataType.STRING , "brand_id","brandId","标准型号","品牌",false,false,true);
		
		/**
		 * 标准型号，规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","标准型号","规格型号",false,false,true);
		
		/**
		 * 标准型号，物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","标准型号","物品图片",false,false,true);
		
		/**
		 * 标准型号，,计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","标准型号",",计量单位",false,false,true);
		
		/**
		 * 库存批次号号,可以为空
		*/
		public static final DBField STOCK_BATCH_NUMBER = new DBField(DBDataType.STRING , "stock_batch_number","stockBatchNumber","库存批次号号","可以为空",false,false,false);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_NUMBER = new DBField(DBDataType.STRING , "batch_number","batchNumber","批次号","批次号",false,false,true);
		
		/**
		 * 资产状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","资产状态","资产状态",false,false,true);
		
		/**
		 * 资产RFID
		*/
		public static final DBField RFID = new DBField(DBDataType.STRING , "rfid","rfid","资产RFID","资产RFID",false,false,true);
		
		/**
		 * 资产编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","资产编号","资产编号",false,false,true);
		
		/**
		 * 资产序列号
		*/
		public static final DBField SN = new DBField(DBDataType.STRING , "sn","sn","资产序列号","资产序列号",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 来源详情
		*/
		public static final DBField SOURCE_DETAIL = new DBField(DBDataType.STRING , "source_detail","sourceDetail","来源详情","来源详情",false,false,true);
		
		/**
		 * 区域
		*/
		public static final DBField AREA_ID = new DBField(DBDataType.STRING , "area_id","areaId","区域","区域",false,false,true);
		
		/**
		 * 存放地点
		*/
		public static final DBField PLACE_DETAIL = new DBField(DBDataType.STRING , "place_detail","placeDetail","存放地点","存放地点",false,false,true);
		
		/**
		 * 使用组织ID
		*/
		public static final DBField USERORG_ID = new DBField(DBDataType.STRING , "userorg_id","userorgId","使用组织ID","使用组织ID",false,false,true);
		
		/**
		 * 使用人员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","使用人员","使用人员",false,false,true);
		
		/**
		 * 生产日期
		*/
		public static final DBField PRODUCTION_DATE = new DBField(DBDataType.DATE , "production_date","productionDate","生产日期","生产日期",false,false,true);
		
		/**
		 * 入库时间
		*/
		public static final DBField STORAGE_TIME = new DBField(DBDataType.DATE , "storage_time","storageTime","入库时间","入库时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField ASSETS_NOTES = new DBField(DBDataType.STRING , "assets_notes","assetsNotes","备注","备注",false,false,true);
		
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
		
		public EAM_ASSET() {
			this.init($NAME,"资产表" , ID , CATEGORY_ID , NAME , MANUFACTURER_ID , BRAND_ID , MODEL , PICTURE_ID , UNIT , STOCK_BATCH_NUMBER , BATCH_NUMBER , STATUS , RFID , CODE , SN , SOURCE_ID , SOURCE_DETAIL , AREA_ID , PLACE_DETAIL , USERORG_ID , USER_ID , PRODUCTION_DATE , STORAGE_TIME , ASSETS_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET $TABLE=new EAM_ASSET();
	}
	
	/**
	 * 资产财务表
	*/
	public static class EAM_ASSET_FINANCIAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_financial";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产ID
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产ID","资产ID",false,false,false);
		
		/**
		 * 资产类型ID
		*/
		public static final DBField ASSET_TYPE = new DBField(DBDataType.STRING , "asset_type","assetType","资产类型ID","资产类型ID",false,false,false);
		
		/**
		 * 管理组织ID
		*/
		public static final DBField MANAGEORG_ID = new DBField(DBDataType.STRING , "manageorg_id","manageorgId","管理组织ID","管理组织ID",false,false,true);
		
		/**
		 * 管理人员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人员","管理人员",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","供应商","供应商",false,false,true);
		
		/**
		 * 采购日期
		*/
		public static final DBField PURCHASE_DATE = new DBField(DBDataType.DATE , "purchase_date","purchaseDate","采购日期","采购日期",false,false,true);
		
		/**
		 * 税额
		*/
		public static final DBField TAXAMOUNT_RATE = new DBField(DBDataType.DECIMAL , "taxamount_rate","taxamountRate","税额","税额",false,false,true);
		
		/**
		 * 含税金额
		*/
		public static final DBField TAXAMOUNT_PRICE = new DBField(DBDataType.DECIMAL , "taxamount_price","taxamountPrice","含税金额","含税金额",false,false,true);
		
		/**
		 * 资产原值
		*/
		public static final DBField ORIGINAL_PRICE = new DBField(DBDataType.DECIMAL , "original_price","originalPrice","资产原值","资产原值",false,false,true);
		
		/**
		 *  累计折旧
		*/
		public static final DBField ACCUMULATED_DEPRECIATION = new DBField(DBDataType.DECIMAL , "accumulated_depreciation","accumulatedDepreciation"," 累计折旧","累计折旧",false,false,true);
		
		/**
		 *  残值率
		*/
		public static final DBField RESIDUALS_RATE = new DBField(DBDataType.DECIMAL , "residuals_rate","residualsRate"," 残值率","残值率",false,false,true);
		
		/**
		 * 资产净值
		*/
		public static final DBField NAV_PRICE = new DBField(DBDataType.DECIMAL , "nav_price","navPrice","资产净值","资产净值",false,false,true);
		
		/**
		 * 使用期限(月)
		*/
		public static final DBField SERVICELIFE = new DBField(DBDataType.DECIMAL , "servicelife","servicelife","使用期限(月)","使用期限(月)",false,false,true);
		
		/**
		 * 入账时间
		*/
		public static final DBField ENTRY_TIME = new DBField(DBDataType.DECIMAL , "entry_time","entryTime","入账时间","入账时间",false,false,true);
		
		/**
		 * 财务备注
		*/
		public static final DBField FINANCIAL_NOTES = new DBField(DBDataType.STRING , "financial_notes","financialNotes","财务备注","财务备注",false,false,true);
		
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
		
		public EAM_ASSET_FINANCIAL() {
			this.init($NAME,"资产财务表" , ID , ASSET_ID , ASSET_TYPE , MANAGEORG_ID , MANAGER_ID , SUPPLIER_ID , PURCHASE_DATE , TAXAMOUNT_RATE , TAXAMOUNT_PRICE , ORIGINAL_PRICE , ACCUMULATED_DEPRECIATION , RESIDUALS_RATE , NAV_PRICE , SERVICELIFE , ENTRY_TIME , FINANCIAL_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_FINANCIAL $TABLE=new EAM_ASSET_FINANCIAL();
	}
	
	/**
	 * 数据中心
	*/
	public static class EAM_ASSET_IT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_it";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产ID
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产ID","资产ID",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField EQUIPMENT_IP = new DBField(DBDataType.STRING , "equipment_ip","equipmentIp","IP","IP",false,false,true);
		
		/**
		 * CPU
		*/
		public static final DBField EQUIPMENT_CPU = new DBField(DBDataType.STRING , "equipment_cpu","equipmentCpu","CPU","CPU",false,false,true);
		
		/**
		 * 内存
		*/
		public static final DBField EQUIPMENT_MEMORY = new DBField(DBDataType.STRING , "equipment_memory","equipmentMemory","内存","内存",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField EQUIPMENT_NOTES = new DBField(DBDataType.STRING , "equipment_notes","equipmentNotes","备注","备注",false,false,true);
		
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
		
		public EAM_ASSET_IT() {
			this.init($NAME,"数据中心" , ID , ASSET_ID , EQUIPMENT_IP , EQUIPMENT_CPU , EQUIPMENT_MEMORY , EQUIPMENT_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_IT $TABLE=new EAM_ASSET_IT();
	}
	
	/**
	 * 资产维保表
	*/
	public static class EAM_ASSET_MAINTAINER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_maintainer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产ID
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产ID","资产ID",false,false,false);
		
		/**
		 * 维保厂商
		*/
		public static final DBField MAINTAINER_ID = new DBField(DBDataType.STRING , "maintainer_id","maintainerId","维保厂商","维保厂商",false,false,true);
		
		/**
		 * 维保开始时间
		*/
		public static final DBField SDATE = new DBField(DBDataType.DATE , "sdate","sdate","维保开始时间","维保开始时间",false,false,true);
		
		/**
		 * 维保到期时间
		*/
		public static final DBField EDATE = new DBField(DBDataType.DATE , "edate","edate","维保到期时间","维保到期时间",false,false,true);
		
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
		
		public EAM_ASSET_MAINTAINER() {
			this.init($NAME,"资产维保表" , ID , ASSET_ID , MAINTAINER_ID , SDATE , EDATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_MAINTAINER $TABLE=new EAM_ASSET_MAINTAINER();
	}
	
	/**
	 * 品牌表
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
		
		public EAM_BRAND() {
			this.init($NAME,"品牌表" , ID , BRAND_NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_BRAND $TABLE=new EAM_BRAND();
	}
	
	/**
	 * 资产分类表
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
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","编码","编码",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父节点","父节点",false,false,false);
		
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
		
		public EAM_CATEGORY() {
			this.init($NAME,"资产分类表" , ID , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_CATEGORY $TABLE=new EAM_CATEGORY();
	}
	
	/**
	 * 资产物品表
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
		 * 状态，valid有效，invalid无效
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","valid有效，invalid无效",false,false,true);
		
		/**
		 * 分类ID
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","分类ID","分类ID",false,false,true);
		
		/**
		 * 标准型号，资产名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标准型号","资产名称",false,false,true);
		
		/**
		 * 标准型号，厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","标准型号","厂商",false,false,true);
		
		/**
		 * 标准型号，品牌
		*/
		public static final DBField BRAND_ID = new DBField(DBDataType.STRING , "brand_id","brandId","标准型号","品牌",false,false,true);
		
		/**
		 * 标准型号，规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","标准型号","规格型号",false,false,true);
		
		/**
		 * 标准型号，物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","标准型号","物品图片",false,false,true);
		
		/**
		 * 标准型号，,计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","标准型号",",计量单位",false,false,true);
		
		/**
		 * 标准型号，单价
		*/
		public static final DBField PRICE = new DBField(DBDataType.DECIMAL , "price","price","标准型号","单价",false,false,true);
		
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
		
		public EAM_GOODS() {
			this.init($NAME,"资产物品表" , ID , STATUS , CATEGORY_ID , NAME , MANUFACTURER_ID , BRAND_ID , MODEL , PICTURE_ID , UNIT , PRICE , STOCK_MIN , STOCK_MAX , STOCK_SECURITY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_GOODS $TABLE=new EAM_GOODS();
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
		
		public EAM_MAINTAINER() {
			this.init($NAME,"维保厂商" , ID , MAINTAINER_NAME , MAINTAINER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		
		public EAM_MANUFACTURER() {
			this.init($NAME,"生产厂商" , ID , MANUFACTURER_NAME , MANUFACTURER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_MANUFACTURER $TABLE=new EAM_MANUFACTURER();
	}
	
	/**
	 * 资产库存记录单据主表
	*/
	public static class EAM_STOCK_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_stock_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 单据编号
		*/
		public static final DBField BUSI_NUMBER = new DBField(DBDataType.STRING , "busi_number","busiNumber","单据编号","单据编号",false,false,true);
		
		/**
		 * 单据状态
		*/
		public static final DBField BUSI_STATUS = new DBField(DBDataType.STRING , "busi_status","busiStatus","单据状态","单据状态",false,false,true);
		
		/**
		 * 上一级记录ID,调拨使用,入库:0
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","上一级记录ID","调拨使用,入库:0",false,false,true);
		
		/**
		 * 库存的入库:0,出库:1,调拨:2
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","库存的入库:0","出库:1,调拨:2",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BACH_NUMBER = new DBField(DBDataType.STRING , "bach_number","bachNumber","批次号","批次号",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","供应商","供应商",false,false,true);
		
		/**
		 * 接收人
		*/
		public static final DBField RECEIVER_ID = new DBField(DBDataType.STRING , "receiver_id","receiverId","接收人","接收人",false,false,true);
		
		/**
		 * 仓库位置ID
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库位置ID","仓库位置ID",false,false,true);
		
		/**
		 * 管理组织ID
		*/
		public static final DBField MANAGEORG_ID = new DBField(DBDataType.STRING , "manageorg_id","manageorgId","管理组织ID","管理组织ID",false,false,true);
		
		/**
		 * 管理人员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人员","管理人员",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 来源详情
		*/
		public static final DBField SOURCE_DETAIL = new DBField(DBDataType.STRING , "source_detail","sourceDetail","来源详情","来源详情",false,false,true);
		
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
		
		public EAM_STOCK_RECORD() {
			this.init($NAME,"资产库存记录单据主表" , ID , BUSI_NUMBER , BUSI_STATUS , PID , TYPE , BACH_NUMBER , SUPPLIER_ID , RECEIVER_ID , WAREHOUSE_ID , MANAGEORG_ID , MANAGER_ID , SOURCE_ID , SOURCE_DETAIL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_STOCK_RECORD $TABLE=new EAM_STOCK_RECORD();
	}
	
	/**
	 * 资产库存入库物品属性
	*/
	public static class EAM_STOCK_RECORD_ATTR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_stock_record_attr";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 入库记录表
		*/
		public static final DBField RECORD_ID = new DBField(DBDataType.STRING , "record_id","recordId","入库记录表","入库记录表",false,false,true);
		
		/**
		 * 关联属性
		*/
		public static final DBField GOODS_ATTR_ID = new DBField(DBDataType.STRING , "goods_attr_id","goodsAttrId","关联属性","关联属性",false,false,true);
		
		/**
		 * 生产日期
		*/
		public static final DBField PRODUCTION_DATE = new DBField(DBDataType.DATE , "production_date","productionDate","生产日期","生产日期",false,false,true);
		
		/**
		 * 采购日期
		*/
		public static final DBField PURCHASE_DATE = new DBField(DBDataType.DATE , "purchase_date","purchaseDate","采购日期","采购日期",false,false,true);
		
		/**
		 * 采购单价
		*/
		public static final DBField PURCHASE_UNIT_PRICE = new DBField(DBDataType.DECIMAL , "purchase_unit_price","purchaseUnitPrice","采购单价","采购单价",false,false,true);
		
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
		
		public EAM_STOCK_RECORD_ATTR() {
			this.init($NAME,"资产库存入库物品属性" , ID , RECORD_ID , GOODS_ATTR_ID , PRODUCTION_DATE , PURCHASE_DATE , PURCHASE_UNIT_PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_STOCK_RECORD_ATTR $TABLE=new EAM_STOCK_RECORD_ATTR();
	}
	
	/**
	 * 资产库存表
	*/
	public static class EAM_STOCK_RECORD_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_stock_record_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产库存记录单据
		*/
		public static final DBField RECORD_ID = new DBField(DBDataType.STRING , "record_id","recordId","资产库存记录单据","资产库存记录单据",false,false,true);
		
		/**
		 * 关联属性
		*/
		public static final DBField GOODS_ATTR_ID = new DBField(DBDataType.STRING , "goods_attr_id","goodsAttrId","关联属性","关联属性",false,false,true);
		
		/**
		 * 总数
		*/
		public static final DBField TOTAL = new DBField(DBDataType.DECIMAL , "total","total","总数","总数",false,false,true);
		
		/**
		 * 当前剩余总数
		*/
		public static final DBField CURRENT_TOTAL = new DBField(DBDataType.DECIMAL , "current_total","currentTotal","当前剩余总数","当前剩余总数",false,false,true);
		
		/**
		 * 仓库位置ID,支持明细不同位置时使用
		*/
		public static final DBField WAREHOUSE_ID = new DBField(DBDataType.STRING , "warehouse_id","warehouseId","仓库位置ID","支持明细不同位置时使用",false,false,true);
		
		/**
		 * 管理组织ID,支持明细不同管理组织时使用
		*/
		public static final DBField MANAGEORG_ID = new DBField(DBDataType.STRING , "manageorg_id","manageorgId","管理组织ID","支持明细不同管理组织时使用",false,false,true);
		
		/**
		 * 管理人员,支持明细不同管理人员时使用
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人员","支持明细不同管理人员时使用",false,false,true);
		
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
		
		public EAM_STOCK_RECORD_DETAIL() {
			this.init($NAME,"资产库存表" , ID , RECORD_ID , GOODS_ATTR_ID , TOTAL , CURRENT_TOTAL , WAREHOUSE_ID , MANAGEORG_ID , MANAGER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_STOCK_RECORD_DETAIL $TABLE=new EAM_STOCK_RECORD_DETAIL();
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
		
		public EAM_SUPPLIER() {
			this.init($NAME,"供应商" , ID , SUPPLIER_NAME , SUPPLIER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_SUPPLIER $TABLE=new EAM_SUPPLIER();
	}
	
	/**
	 * 资产仓库表
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
		public static final DBField WAREHOUSE_NAME = new DBField(DBDataType.STRING , "warehouse_name","warehouseName","名称","名称",false,false,false);
		
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
		
		public EAM_WAREHOUSE() {
			this.init($NAME,"资产仓库表" , ID , WAREHOUSE_NAME , WAREHOUSE_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 公司名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","公司名称","公司名称",false,false,true);
		
		/**
		 * 社会信用代码
		*/
		public static final DBField SOCIAL_CREDIT_CODE = new DBField(DBDataType.STRING , "social_credit_code","socialCreditCode","社会信用代码","社会信用代码",false,false,true);
		
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
			this.init($NAME,"公司表" , ID , NAME , SOCIAL_CREDIT_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 公司ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","公司ID","公司ID",false,false,true);
		
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
			this.init($NAME,"员工表" , ID , NAME , COMPANY_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HRM_EMPLOYEE $TABLE=new HRM_EMPLOYEE();
	}
	
	/**
	 * 组织层级表
	*/
	public static class HRM_ORGNIZATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_orgnization";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",false,false,true);
		
		public HRM_ORGNIZATION() {
			this.init($NAME,"组织层级表" , ID);
		}
		public static final HRM_ORGNIZATION $TABLE=new HRM_ORGNIZATION();
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
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 身份证号
		*/
		public static final DBField IDENTITY = new DBField(DBDataType.STRING , "identity","identity","身份证号","身份证号",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		public HRM_PERSON() {
			this.init($NAME,"人员表" , ID , IDENTITY , NAME , SEX);
		}
		public static final HRM_PERSON $TABLE=new HRM_PERSON();
	}
	
	/**
	 * 租户表
	*/
	public static class HRM_TENANT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hrm_tenant";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		public HRM_TENANT() {
			this.init($NAME,"租户表" , ID);
		}
		public static final HRM_TENANT $TABLE=new HRM_TENANT();
	}
}