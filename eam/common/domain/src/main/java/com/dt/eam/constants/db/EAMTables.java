package com.dt.eam.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2021-06-10 13:25:50
 * @author 李方捷 , leefangjie@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class EAMTables {
	
	/**
	 * 资产表
	*/
	public static class EAM_ASSETS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_assets";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 库存批次号号,可以为空
		*/
		public static final DBField STOCK_BATCH_NUMBER = new DBField(DBDataType.STRING , "stock_batch_number","stockBatchNumber","库存批次号号","可以为空",false,false,false);
		
		/**
		 * 资产编号
		*/
		public static final DBField UUID = new DBField(DBDataType.STRING , "uuid","uuid","资产编号","资产编号",false,false,true);
		
		/**
		 * 资产状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","资产状态","资产状态",false,false,true);
		
		/**
		 * 资产RFID
		*/
		public static final DBField RFID = new DBField(DBDataType.STRING , "rfid","rfid","资产RFID","资产RFID",false,false,true);
		
		/**
		 * 物品表
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","物品表","物品表",false,false,true);
		
		/**
		 * 资产图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","资产图片","资产图片",false,false,true);
		
		/**
		 * 供应商
		*/
		public static final DBField SUPPLIER_ID = new DBField(DBDataType.STRING , "supplier_id","supplierId","供应商","供应商",false,false,true);
		
		/**
		 * 单位
		*/
		public static final DBField UNIT_ID = new DBField(DBDataType.STRING , "unit_id","unitId","单位","单位",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 来源详情
		*/
		public static final DBField SOURCE_DETAIL = new DBField(DBDataType.STRING , "source_detail","sourceDetail","来源详情","来源详情",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_NUMBER = new DBField(DBDataType.STRING , "batch_number","batchNumber","批次号","批次号",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","位置","位置",false,false,true);
		
		/**
		 * 位置详情
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","位置详情","位置详情",false,false,true);
		
		/**
		 * 管理组织ID
		*/
		public static final DBField MANAGEORG_ID = new DBField(DBDataType.STRING , "manageorg_id","manageorgId","管理组织ID","管理组织ID",false,false,true);
		
		/**
		 * 使用组织ID
		*/
		public static final DBField USERORG_ID = new DBField(DBDataType.STRING , "userorg_id","userorgId","使用组织ID","使用组织ID",false,false,true);
		
		/**
		 * 管理人员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","管理人员","管理人员",false,false,true);
		
		/**
		 * 使用人员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","使用人员","使用人员",false,false,true);
		
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
		 * 资产净值
		*/
		public static final DBField NAV_PRICE = new DBField(DBDataType.DECIMAL , "nav_price","navPrice","资产净值","资产净值",false,false,true);
		
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
		
		public EAM_ASSETS() {
			this.init($NAME,"资产表" , ID , STOCK_BATCH_NUMBER , UUID , STATUS , RFID , GOODS_ID , PICTURE_ID , SUPPLIER_ID , UNIT_ID , SOURCE_ID , SOURCE_DETAIL , BATCH_NUMBER , POSITION_ID , POSITION_DETAIL , MANAGEORG_ID , USERORG_ID , MANAGER_ID , USER_ID , PRODUCTION_DATE , PURCHASE_DATE , PURCHASE_UNIT_PRICE , NAV_PRICE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSETS $TABLE=new EAM_ASSETS();
	}
	
	/**
	 * 资产维护表
	*/
	public static class EAM_ASSETS_MAINTAINER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_assets_maintainer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产ID
		*/
		public static final DBField ASSETS_ID = new DBField(DBDataType.STRING , "assets_id","assetsId","资产ID","资产ID",false,false,false);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_ASSETS_MAINTAINER() {
			this.init($NAME,"资产维护表" , ID , ASSETS_ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSETS_MAINTAINER $TABLE=new EAM_ASSETS_MAINTAINER();
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_BRAND() {
			this.init($NAME,"品牌表" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
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
			this.init($NAME,"资产分类表" , ID , NAME , CODE , PID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","物品图片","物品图片",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","厂商","厂商",false,false,true);
		
		/**
		 * 品牌
		*/
		public static final DBField BRAND_ID = new DBField(DBDataType.STRING , "brand_id","brandId","品牌","品牌",false,false,true);
		
		/**
		 * 规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","规格型号","规格型号",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
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
			this.init($NAME,"资产物品表" , ID , STATUS , CATEGORY_ID , PICTURE_ID , CODE , NAME , MANUFACTURER_ID , BRAND_ID , MODEL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_MAINTAINER() {
			this.init($NAME,"维保厂商" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_MANUFACTURER() {
			this.init($NAME,"生产厂商" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 上一级记录ID,调拨使用
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","上一级记录ID","调拨使用",false,false,true);
		
		/**
		 * 库存的出库,入库,调拨
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","库存的出库","入库,调拨",false,false,true);
		
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
		 * 物品ID
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","物品ID","物品ID",false,false,true);
		
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
			this.init($NAME,"资产库存入库物品属性" , ID , RECORD_ID , GOODS_ID , PRODUCTION_DATE , PURCHASE_DATE , PURCHASE_UNIT_PRICE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 物品ID
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","物品ID","物品ID",false,false,true);
		
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
			this.init($NAME,"资产库存表" , ID , RECORD_ID , GOODS_ID , TOTAL , CURRENT_TOTAL , WAREHOUSE_ID , MANAGEORG_ID , MANAGER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public EAM_SUPPLIER() {
			this.init($NAME,"供应商" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,false);
		
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
		
		public EAM_WAREHOUSE() {
			this.init($NAME,"资产仓库表" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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