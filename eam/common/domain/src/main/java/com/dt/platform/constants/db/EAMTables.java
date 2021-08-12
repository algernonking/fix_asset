package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2021-08-12 12:16:14
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
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,false);
		
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
		
		public DC_AREA() {
			this.init($NAME,"区域" , ID , TYPE , NAME , POSITION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		
		public DC_LAYER() {
			this.init($NAME,"层级" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DC_LAYER $TABLE=new DC_LAYER();
	}
	
	/**
	 * 机柜管理
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
		 * 区域
		*/
		public static final DBField AREA_ID = new DBField(DBDataType.STRING , "area_id","areaId","区域","区域",false,false,true);
		
		/**
		 * 层级
		*/
		public static final DBField LAYER_ID = new DBField(DBDataType.STRING , "layer_id","layerId","层级","层级",false,false,true);
		
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
		
		public DC_RACK() {
			this.init($NAME,"机柜管理" , ID , AREA_ID , LAYER_ID , RACK_CODE , RACK_NAME , RACK_CAPTICAL , RACK_LABELS , RACK_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final DC_RACK $TABLE=new DC_RACK();
	}
	
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
		 * 单据编号
		*/
		public static final DBField BUSI_CODE = new DBField(DBDataType.STRING , "busi_code","busiCode","单据编号","单据编号",false,false,true);
		
		/**
		 * 入库批次代码
		*/
		public static final DBField BATCH_CODE = new DBField(DBDataType.STRING , "batch_code","batchCode","入库批次代码","入库批次代码",false,false,false);
		
		/**
		 * 资产状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","资产状态","资产状态",false,false,true);
		
		/**
		 * 资产编号
		*/
		public static final DBField ASSET_CODE = new DBField(DBDataType.STRING , "asset_code","assetCode","资产编号","资产编号",false,false,true);
		
		/**
		 * 分类ID
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","分类ID","分类ID",false,false,true);
		
		/**
		 * 标准型号ID
		*/
		public static final DBField GOODS_ID = new DBField(DBDataType.STRING , "goods_id","goodsId","标准型号ID","标准型号ID",false,false,true);
		
		/**
		 * 标准型号资产名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标准型号资产名称","标准型号资产名称",false,false,true);
		
		/**
		 * 标准型号厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","标准型号厂商","标准型号厂商",false,false,true);
		
		/**
		 * 标准型号品牌
		*/
		public static final DBField BRAND_ID = new DBField(DBDataType.STRING , "brand_id","brandId","标准型号品牌","标准型号品牌",false,false,true);
		
		/**
		 * 标准型号规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","标准型号规格型号","标准型号规格型号",false,false,false);
		
		/**
		 * 标准型号物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","标准型号物品图片","标准型号物品图片",false,false,true);
		
		/**
		 * 标准型号计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","标准型号计量单位","标准型号计量单位",false,false,true);
		
		/**
		 * 标准型号单价
		*/
		public static final DBField UNIT_PRICE = new DBField(DBDataType.DECIMAL , "unit_price","unitPrice","标准型号单价","标准型号单价",false,false,true);
		
		/**
		 * 资产RFID
		*/
		public static final DBField RFID = new DBField(DBDataType.STRING , "rfid","rfid","资产RFID","资产RFID",false,false,true);
		
		/**
		 * 资产序列号
		*/
		public static final DBField SN = new DBField(DBDataType.STRING , "sn","sn","资产序列号","资产序列号",false,false,true);
		
		/**
		 * 资产数量
		*/
		public static final DBField ASSET_NUMBER = new DBField(DBDataType.INTEGER , "asset_number","assetNumber","资产数量","资产数量",false,false,false);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","来源","来源",false,false,true);
		
		/**
		 * 来源详情
		*/
		public static final DBField SOURCE_DETAIL = new DBField(DBDataType.STRING , "source_detail","sourceDetail","来源详情","来源详情",false,false,true);
		
		/**
		 * 存放区域
		*/
		public static final DBField AREA_ID = new DBField(DBDataType.STRING , "area_id","areaId","存放区域","存放区域",false,false,true);
		
		/**
		 * 存放地点
		*/
		public static final DBField PLACE_DETAIL = new DBField(DBDataType.STRING , "place_detail","placeDetail","存放地点","存放地点",false,false,true);
		
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
		 * 是否显示
		*/
		public static final DBField DISPLAY = new DBField(DBDataType.STRING , "display","display","是否显示","是否显示",false,false,true);
		
		/**
		 * 是否报废
		*/
		public static final DBField SCRAP = new DBField(DBDataType.STRING , "scrap","scrap","是否报废","是否报废",false,false,false);
		
		/**
		 * 插入方式
		*/
		public static final DBField INSERT_TYPE = new DBField(DBDataType.STRING , "insert_type","insertType","插入方式","插入方式",false,false,true);
		
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
			this.init($NAME,"资产表" , ID , BUSI_CODE , BATCH_CODE , STATUS , ASSET_CODE , CATEGORY_ID , GOODS_ID , NAME , MANUFACTURER_ID , BRAND_ID , MODEL , PICTURE_ID , UNIT , UNIT_PRICE , RFID , SN , ASSET_NUMBER , SOURCE_ID , SOURCE_DETAIL , AREA_ID , PLACE_DETAIL , USER_ID , PRODUCTION_DATE , STORAGE_TIME , DISPLAY , SCRAP , INSERT_TYPE , ASSETS_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET $TABLE=new EAM_ASSET();
	}
	
	/**
	 * 资产变更
	*/
	public static class EAM_ASSET_CHANGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_change";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 变更编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","变更编号","变更编号",false,false,true);
		
		/**
		 * 变更类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","变更类型","变更类型",false,false,true);
		
		/**
		 * 变更数量
		*/
		public static final DBField HANGE_COUNT = new DBField(DBDataType.DECIMAL , "hange_count","hangeCount","变更数量","变更数量",false,false,true);
		
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
		
		public EAM_ASSET_CHANGE() {
			this.init($NAME,"资产变更" , ID , NAME , CODE , TYPE , HANGE_COUNT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_CHANGE $TABLE=new EAM_ASSET_CHANGE();
	}
	
	/**
	 * 资产变更数据
	*/
	public static class EAM_ASSET_CHANGE_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_change_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 变更主键
		*/
		public static final DBField CHANGE_ID = new DBField(DBDataType.STRING , "change_id","changeId","变更主键","变更主键",false,false,true);
		
		/**
		 * 资产主键
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产主键","资产主键",false,false,true);
		
		/**
		 * 变更前数据
		*/
		public static final DBField BEFORE_CHANGESTR = new DBField(DBDataType.STRING , "before_changestr","beforeChangestr","变更前数据","变更前数据",false,false,true);
		
		/**
		 * 变更后数据
		*/
		public static final DBField AFTER_CHANGESTR = new DBField(DBDataType.STRING , "after_changestr","afterChangestr","变更后数据","变更后数据",false,false,true);
		
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
		
		public EAM_ASSET_CHANGE_DATA() {
			this.init($NAME,"资产变更数据" , ID , CHANGE_ID , ASSET_ID , BEFORE_CHANGESTR , AFTER_CHANGESTR , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_CHANGE_DATA $TABLE=new EAM_ASSET_CHANGE_DATA();
	}
	
	/**
	 * 数据中心数据扩展
	*/
	public static class EAM_ASSET_EXT_EQUIPMENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_ext_equipment";
		
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
		 * 管理IP
		*/
		public static final DBField MANAGE_IP = new DBField(DBDataType.STRING , "manage_ip","manageIp","管理IP","管理IP",false,false,true);
		
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
		 * 机柜ID
		*/
		public static final DBField RACK_ID = new DBField(DBDataType.STRING , "rack_id","rackId","机柜ID","机柜ID",false,false,true);
		
		/**
		 * 风险等级
		*/
		public static final DBField SAFETY_LEVEL = new DBField(DBDataType.STRING , "safety_level","safetyLevel","风险等级","风险等级",false,false,true);
		
		/**
		 * 描述
		*/
		public static final DBField EQUIPMENT_DESC = new DBField(DBDataType.STRING , "equipment_desc","equipmentDesc","描述","描述",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
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
		
		public EAM_ASSET_EXT_EQUIPMENT() {
			this.init($NAME,"数据中心数据扩展" , ID , ASSET_ID , EQUIPMENT_IP , MANAGE_IP , EQUIPMENT_CPU , EQUIPMENT_MEMORY , EQUIPMENT_NOTES , RACK_ID , SAFETY_LEVEL , EQUIPMENT_DESC , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_EXT_EQUIPMENT $TABLE=new EAM_ASSET_EXT_EQUIPMENT();
	}
	
	/**
	 * 资产财务表
	*/
	public static class EAM_ASSET_EXT_FINANCIAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_ext_financial";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产ID
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产ID","资产ID",false,false,true);
		
		/**
		 * 财务维度资产类型
		*/
		public static final DBField TYPE_ID = new DBField(DBDataType.STRING , "type_id","typeId","财务维度资产类型","财务维度资产类型",false,false,true);
		
		/**
		 * 财务编号
		*/
		public static final DBField ASSET_CODE = new DBField(DBDataType.STRING , "asset_code","assetCode","财务编号","财务编号",false,false,true);
		
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
		public static final DBField TAXAMOUNT_RATE = new DBField(DBDataType.DECIMAL , "taxamount_rate","taxamountRate","税额","税额",false,false,false);
		
		/**
		 * 含税金额
		*/
		public static final DBField TAXAMOUNT_PRICE = new DBField(DBDataType.DECIMAL , "taxamount_price","taxamountPrice","含税金额","含税金额",false,false,false);
		
		/**
		 * 资产原值
		*/
		public static final DBField ORIGINAL_PRICE = new DBField(DBDataType.DECIMAL , "original_price","originalPrice","资产原值","资产原值",false,false,false);
		
		/**
		 * 累计折旧
		*/
		public static final DBField ACCUMULATED_DEPRECIATION = new DBField(DBDataType.DECIMAL , "accumulated_depreciation","accumulatedDepreciation","累计折旧","累计折旧",false,false,false);
		
		/**
		 * 残值率
		*/
		public static final DBField RESIDUALS_RATE = new DBField(DBDataType.DECIMAL , "residuals_rate","residualsRate","残值率","残值率",false,false,false);
		
		/**
		 * 资产净值
		*/
		public static final DBField NAV_PRICE = new DBField(DBDataType.DECIMAL , "nav_price","navPrice","资产净值","资产净值",false,false,false);
		
		/**
		 * 采购单价
		*/
		public static final DBField PURCHASE_UNIT_PRICE = new DBField(DBDataType.DECIMAL , "purchase_unit_price","purchaseUnitPrice","采购单价","采购单价",false,false,true);
		
		/**
		 * 入账时间
		*/
		public static final DBField ENTRY_TIME = new DBField(DBDataType.DECIMAL , "entry_time","entryTime","入账时间","入账时间",false,false,true);
		
		/**
		 * 使用期限(月)
		*/
		public static final DBField SERVICELIFE = new DBField(DBDataType.DECIMAL , "servicelife","servicelife","使用期限(月)","使用期限(月)",false,false,true);
		
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
		
		public EAM_ASSET_EXT_FINANCIAL() {
			this.init($NAME,"资产财务表" , ID , ASSET_ID , TYPE_ID , ASSET_CODE , MANAGEORG_ID , MANAGER_ID , SUPPLIER_ID , PURCHASE_DATE , TAXAMOUNT_RATE , TAXAMOUNT_PRICE , ORIGINAL_PRICE , ACCUMULATED_DEPRECIATION , RESIDUALS_RATE , NAV_PRICE , PURCHASE_UNIT_PRICE , ENTRY_TIME , SERVICELIFE , FINANCIAL_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_EXT_FINANCIAL $TABLE=new EAM_ASSET_EXT_FINANCIAL();
	}
	
	/**
	 * 资产维保表
	*/
	public static class EAM_ASSET_EXT_MAINTAINER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_asset_ext_maintainer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 资产ID
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产ID","资产ID",false,false,true);
		
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
		
		public EAM_ASSET_EXT_MAINTAINER() {
			this.init($NAME,"资产维保表" , ID , ASSET_ID , MAINTAINER_ID , SDATE , EDATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_EXT_MAINTAINER $TABLE=new EAM_ASSET_EXT_MAINTAINER();
	}
	
	/**
	 * 资产处理表
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
		 * 流程ID
		*/
		public static final DBField FLOW_ID = new DBField(DBDataType.STRING , "flow_id","flowId","流程ID","流程ID",false,false,true);
		
		/**
		 * 单据状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","单据状态","单据状态",false,false,true);
		
		/**
		 * 单据名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","单据名称","单据名称",false,false,true);
		
		/**
		 * 报废scrap
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","报废scrap","报废scrap",false,false,true);
		
		/**
		 * 单据编号
		*/
		public static final DBField BUSI_CODE = new DBField(DBDataType.STRING , "busi_code","busiCode","单据编号","单据编号",false,false,true);
		
		/**
		 * 原因
		*/
		public static final DBField REASON = new DBField(DBDataType.STRING , "reason","reason","原因","原因",false,false,true);
		
		/**
		 * 报废数量
		*/
		public static final DBField ASSET_NUMBER = new DBField(DBDataType.DECIMAL , "asset_number","assetNumber","报废数量","报废数量",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSI_DATE = new DBField(DBDataType.DATE , "busi_date","busiDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 处理日期
		*/
		public static final DBField HANDLE_DATE = new DBField(DBDataType.DATE , "handle_date","handleDate","处理日期","处理日期",false,false,true);
		
		/**
		 * 制单人,操作人
		*/
		public static final DBField OPERUSER_ID = new DBField(DBDataType.STRING , "operuser_id","operuserId","制单人","操作人",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public EAM_ASSET_HANDLE() {
			this.init($NAME,"资产处理表" , ID , FLOW_ID , STATUS , NAME , TYPE , BUSI_CODE , REASON , ASSET_NUMBER , BUSI_DATE , HANDLE_DATE , OPERUSER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_HANDLE $TABLE=new EAM_ASSET_HANDLE();
	}
	
	/**
	 * 资产报修表
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
		 * 流程ID
		*/
		public static final DBField FLOW_ID = new DBField(DBDataType.STRING , "flow_id","flowId","流程ID","流程ID",false,false,true);
		
		/**
		 * 单据状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","单据状态","单据状态",false,false,true);
		
		/**
		 * 单据名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","单据名称","单据名称",false,false,true);
		
		/**
		 * 报废scrap
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","报废scrap","报废scrap",false,false,true);
		
		/**
		 * 单据编号
		*/
		public static final DBField BUSI_CODE = new DBField(DBDataType.STRING , "busi_code","busiCode","单据编号","单据编号",false,false,true);
		
		/**
		 * 原因
		*/
		public static final DBField REASON = new DBField(DBDataType.STRING , "reason","reason","原因","原因",false,false,true);
		
		/**
		 * 数量
		*/
		public static final DBField ASSET_NUMBER = new DBField(DBDataType.DECIMAL , "asset_number","assetNumber","数量","数量",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSI_DATE = new DBField(DBDataType.DATE , "busi_date","busiDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 报废日期
		*/
		public static final DBField HANDLE_DATE = new DBField(DBDataType.DATE , "handle_date","handleDate","报废日期","报废日期",false,false,true);
		
		/**
		 * 制单人,操作人
		*/
		public static final DBField OPERUSER_ID = new DBField(DBDataType.STRING , "operuser_id","operuserId","制单人","操作人",false,false,true);
		
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
		
		public EAM_ASSET_REPAIR() {
			this.init($NAME,"资产报修表" , ID , FLOW_ID , STATUS , NAME , TYPE , BUSI_CODE , REASON , ASSET_NUMBER , BUSI_DATE , HANDLE_DATE , OPERUSER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_ASSET_REPAIR $TABLE=new EAM_ASSET_REPAIR();
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
		 * 状态,valid:有效,invalud:无效
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","valid:有效,invalud:无效",false,false,true);
		
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
		
		public EAM_CATEGORY() {
			this.init($NAME,"资产分类" , ID , STATUS , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_CATEGORY $TABLE=new EAM_CATEGORY();
	}
	
	/**
	 * 编码分配规则
	*/
	public static class EAM_CODE_ALLOCATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_code_allocation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 编码名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","编码名称","编码名称",false,false,true);
		
		/**
		 * 规则名称
		*/
		public static final DBField RULE_NAME = new DBField(DBDataType.STRING , "rule_name","ruleName","规则名称","规则名称",false,false,true);
		
		/**
		 * 编码规则
		*/
		public static final DBField RULE = new DBField(DBDataType.STRING , "rule","rule","编码规则","编码规则",false,false,true);
		
		/**
		 * 所属模块
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","所属模块","所属模块",false,false,true);
		
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
		
		public EAM_CODE_ALLOCATION() {
			this.init($NAME,"编码分配规则" , ID , CODE , NAME , RULE_NAME , RULE , MODEL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_CODE_ALLOCATION $TABLE=new EAM_CODE_ALLOCATION();
	}
	
	/**
	 * 编码分配属性
	*/
	public static class EAM_CODE_ATTR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_code_attr";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 占位符
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","占位符","占位符",false,false,true);
		
		/**
		 * 编码名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","编码名称","编码名称",false,false,true);
		
		/**
		 * 编码类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","编码类型","编码类型",false,false,true);
		
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
		
		public EAM_CODE_ATTR() {
			this.init($NAME,"编码分配属性" , ID , CODE , NAME , TYPE , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_CODE_ATTR $TABLE=new EAM_CODE_ATTR();
	}
	
	/**
	 * 编码模块
	*/
	public static class EAM_CODE_MODEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "eam_code_model";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模块编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","模块编码","模块编码",false,false,true);
		
		/**
		 * 属性编号
		*/
		public static final DBField ATTR_ID = new DBField(DBDataType.STRING , "attr_id","attrId","属性编号","属性编号",false,false,true);
		
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
		
		public EAM_CODE_MODEL() {
			this.init($NAME,"编码模块" , ID , CODE , ATTR_ID , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_CODE_MODEL $TABLE=new EAM_CODE_MODEL();
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
		 * 状态-used|unsed
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","used|unsed",false,false,true);
		
		/**
		 * 分类ID
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","分类ID","分类ID",false,false,true);
		
		/**
		 * 标准型号物品名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标准型号物品名称","标准型号物品名称",false,false,true);
		
		/**
		 * 标准型号规格型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","标准型号规格型号","标准型号规格型号",false,false,true);
		
		/**
		 * 标准型号厂商
		*/
		public static final DBField MANUFACTURER_ID = new DBField(DBDataType.STRING , "manufacturer_id","manufacturerId","标准型号厂商","标准型号厂商",false,false,true);
		
		/**
		 * 标准型号品牌
		*/
		public static final DBField BRAND_ID = new DBField(DBDataType.STRING , "brand_id","brandId","标准型号品牌","标准型号品牌",false,false,true);
		
		/**
		 * 标准型号计量单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","标准型号计量单位","标准型号计量单位",false,false,true);
		
		/**
		 * 标准参考单价
		*/
		public static final DBField REFERENCE_PRICE = new DBField(DBDataType.DECIMAL , "reference_price","referencePrice","标准参考单价","标准参考单价",false,false,true);
		
		/**
		 * 标准型号物品图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","标准型号物品图片","标准型号物品图片",false,false,true);
		
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
			this.init($NAME,"物品档案" , ID , STATUS , CATEGORY_ID , NAME , MODEL , MANUFACTURER_ID , BRAND_ID , UNIT , REFERENCE_PRICE , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		
		public EAM_MANUFACTURER() {
			this.init($NAME,"生产厂商" , ID , MANUFACTURER_NAME , LOCATION , MANUFACTURER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_MANUFACTURER $TABLE=new EAM_MANUFACTURER();
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
		 * 残值率，-1则使用资产设置的残值
		*/
		public static final DBField RESIDUALVALUE_RATE = new DBField(DBDataType.DECIMAL , "residualvalue_rate","residualvalueRate","残值率","-1则使用资产设置的残值",false,false,true);
		
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
		
		public EAM_RESIDUAL_STRATEGY() {
			this.init($NAME,"折旧策略" , ID , NAME , STATUS , STRATEGY_DESCRIBE , RESIDUALVALUE_RATE , DEPRECIATION_RATE , VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_RESIDUAL_STRATEGY $TABLE=new EAM_RESIDUAL_STRATEGY();
	}
	
	/**
	 * 风险等级表
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
		
		public EAM_SAFETYLEVEL() {
			this.init($NAME,"风险等级表" , ID , SAFETY_CODE , SAFETY_NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_SAFETYLEVEL $TABLE=new EAM_SAFETYLEVEL();
	}
	
	/**
	 * 资产库存记录单据主表
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
		 * 单据编号
		*/
		public static final DBField BUSI_CODE = new DBField(DBDataType.STRING , "busi_code","busiCode","单据编号","单据编号",false,false,true);
		
		/**
		 * 流程ID
		*/
		public static final DBField FLOW_ID = new DBField(DBDataType.STRING , "flow_id","flowId","流程ID","流程ID",false,false,true);
		
		/**
		 * 单据状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","单据状态","单据状态",false,false,true);
		
		/**
		 * 库存的入库:0,出库:1,调拨:2
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","库存的入库:0","出库:1,调拨:2",false,false,true);
		
		/**
		 * 批次号
		*/
		public static final DBField BATCH_NUMBER = new DBField(DBDataType.STRING , "batch_number","batchNumber","批次号","批次号",false,false,true);
		
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
		 * 调拨管理人员
		*/
		public static final DBField MANAGER_ID = new DBField(DBDataType.STRING , "manager_id","managerId","调拨管理人员","调拨管理人员",false,false,true);
		
		/**
		 * 调拨管理组织ID
		*/
		public static final DBField TOMANAGEORG_ID = new DBField(DBDataType.STRING , "tomanageorg_id","tomanageorgId","调拨管理组织ID","调拨管理组织ID",false,false,true);
		
		/**
		 * 调拨管理人员
		*/
		public static final DBField TOMANAGER_ID = new DBField(DBDataType.STRING , "tomanager_id","tomanagerId","调拨管理人员","调拨管理人员",false,false,true);
		
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
		
		public EAM_STOCK() {
			this.init($NAME,"资产库存记录单据主表" , ID , BUSI_CODE , FLOW_ID , STATUS , TYPE , BATCH_NUMBER , SUPPLIER_ID , RECEIVER_ID , WAREHOUSE_ID , MANAGEORG_ID , MANAGER_ID , TOMANAGEORG_ID , TOMANAGER_ID , SOURCE_ID , SOURCE_DETAIL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_STOCK $TABLE=new EAM_STOCK();
	}
	
	/**
	 * 资产库存表
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
		 * 资产记录
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","资产记录","资产记录",false,false,true);
		
		/**
		 * 单据数量
		*/
		public static final DBField ASSET_NUMBER = new DBField(DBDataType.DECIMAL , "asset_number","assetNumber","单据数量","单据数量",false,false,true);
		
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
			this.init($NAME,"资产库存表" , ID , ASSET_ID , ASSET_NUMBER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_STOCK_RECORD $TABLE=new EAM_STOCK_RECORD();
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
	 * 资产转移表
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
		 * 流程ID
		*/
		public static final DBField FLOW_ID = new DBField(DBDataType.STRING , "flow_id","flowId","流程ID","流程ID",false,false,true);
		
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
		 * 管理组织ID
		*/
		public static final DBField MANAGEORG_ID = new DBField(DBDataType.STRING , "manageorg_id","manageorgId","管理组织ID","管理组织ID",false,false,true);
		
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
		
		public EAM_TRANSFER() {
			this.init($NAME,"资产转移表" , ID , BUSI_CODE , FLOW_ID , STATUS , BATCH_NUMBER , RECEIVER_ID , AREA_ID , MANAGEORG_ID , MANAGER_ID , BUSI_DATE , FINISH_DATE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final EAM_TRANSFER $TABLE=new EAM_TRANSFER();
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
			this.init($NAME,"仓库" , ID , WAREHOUSE_NAME , WAREHOUSE_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 主机类型
		*/
		public static final DBField HOST_TYPE = new DBField(DBDataType.STRING , "host_type","hostType","主机类型","主机类型",false,false,true);
		
		/**
		 * 主机状态online|offline
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","主机状态online","offline",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField HOST_NAME = new DBField(DBDataType.STRING , "host_name","hostName","名称","名称",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField HOST_IP = new DBField(DBDataType.STRING , "host_ip","hostIp","IP","IP",false,false,false);
		
		/**
		 * VIP
		*/
		public static final DBField HOST_VIP = new DBField(DBDataType.STRING , "host_vip","hostVip","VIP","VIP",false,false,true);
		
		/**
		 * 运行环境prod,uat,tst
		*/
		public static final DBField ENVIRONMENT = new DBField(DBDataType.STRING , "environment","environment","运行环境prod","uat,tst",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","位置","位置",false,false,true);
		
		/**
		 * 监控状态:valid|invalid|unknow
		*/
		public static final DBField MONITOR_STATUS = new DBField(DBDataType.STRING , "monitor_status","monitorStatus","监控状态:valid","invalid|unknow",false,false,true);
		
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
		 * 下线时间
		*/
		public static final DBField OFFLINE_TIME = new DBField(DBDataType.DATE , "offline_time","offlineTime","下线时间","下线时间",false,false,true);
		
		/**
		 * 上线时间
		*/
		public static final DBField ONLINE_TIME = new DBField(DBDataType.DATE , "online_time","onlineTime","上线时间","上线时间",false,false,true);
		
		/**
		 * 是否归档1归档0不归档
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","是否归档1归档0不归档","是否归档1归档0不归档",false,false,false);
		
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
		
		public OPS_HOST() {
			this.init($NAME,"主机" , ID , HOST_TYPE , STATUS , HOST_NAME , HOST_IP , HOST_VIP , ENVIRONMENT , POSITION_ID , MONITOR_STATUS , DIRECTOR_USERNAME , HOST_MEMORY , HOST_CPU , HOST_CONF , USER_OS_ADMIN , USER_DB_ADMIN , USER_DB_USED , USER_APP_USED , USER_OPS_OPER , USER_OTHER , PASSWORD_STRATEGY_ID , OFFLINE_TIME , ONLINE_TIME , ARCH , LABELS , HOST_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField SERVICE_DETAIL_ID = new DBField(DBDataType.STRING , "service_detail_id","serviceDetailId","服务内容","服务内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
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
			this.init($NAME,"数据库" , ID , HOST_ID , SERVICE_DETAIL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField SERVICE_DETAIL_ID = new DBField(DBDataType.STRING , "service_detail_id","serviceDetailId","服务内容","服务内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
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
			this.init($NAME,"中间件" , ID , HOST_ID , SERVICE_DETAIL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField SERVICE_DETAIL_ID = new DBField(DBDataType.STRING , "service_detail_id","serviceDetailId","服务内容","服务内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
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
			this.init($NAME,"操作系统" , ID , HOST_ID , SERVICE_DETAIL_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		
		public OPS_HOST_POSITION() {
			this.init($NAME,"主机位置" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		public static final DBField SERVICE_ID = new DBField(DBDataType.STRING , "service_id","serviceId","服务类型","服务类型",false,false,true);
		
		/**
		 * 服务具体内容
		*/
		public static final DBField SERVICE_DETAIL = new DBField(DBDataType.STRING , "service_detail","serviceDetail","服务具体内容","服务具体内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
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
		
		public OPS_HOST_SERVICE() {
			this.init($NAME,"主机表-服务" , ID , HOST_ID , SERVICE_ID , SERVICE_DETAIL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 父节点,默认无为0
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父节点","默认无为0",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField INFOSYSTEM_NAME = new DBField(DBDataType.STRING , "infosystem_name","infosystemName","名称","名称",false,false,true);
		
		/**
		 * 介绍
		*/
		public static final DBField INFOSYSTEM_PROFILE = new DBField(DBDataType.STRING , "infosystem_profile","infosystemProfile","介绍","介绍",false,false,true);
		
		/**
		 * 状态,online,offline
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","online,offline",false,false,true);
		
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
		public static final DBField TCONTACT = new DBField(DBDataType.STRING , "tcontact","tcontact","技术联系人","技术联系人",false,false,true);
		
		/**
		 * 业务联系人
		*/
		public static final DBField BCONTACT = new DBField(DBDataType.STRING , "bcontact","bcontact","业务联系人","业务联系人",false,false,true);
		
		/**
		 * 业务部门
		*/
		public static final DBField BPART = new DBField(DBDataType.STRING , "bpart","bpart","业务部门","业务部门",false,false,true);
		
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
		public static final DBField OS_DETAIL = new DBField(DBDataType.STRING , "os_detail","osDetail","操作系统","操作系统",false,false,true);
		
		/**
		 * 数据库
		*/
		public static final DBField DB_DETAIL = new DBField(DBDataType.STRING , "db_detail","dbDetail","数据库","数据库",false,false,true);
		
		/**
		 * 应用
		*/
		public static final DBField APP_DETAIL = new DBField(DBDataType.STRING , "app_detail","appDetail","应用","应用",false,false,true);
		
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
		 * 硬件
		*/
		public static final DBField HARDWARE_DETAIL = new DBField(DBDataType.STRING , "hardware_detail","hardwareDetail","硬件","硬件",false,false,true);
		
		/**
		 * 备份方式
		*/
		public static final DBField BACKUP_DETAIL = new DBField(DBDataType.STRING , "backup_detail","backupDetail","备份方式","备份方式",false,false,true);
		
		/**
		 * 本地备份方式
		*/
		public static final DBField SAMEPLACEBACUP_DETAIL = new DBField(DBDataType.STRING , "sameplacebacup_detail","sameplacebacupDetail","本地备份方式","本地备份方式",false,false,true);
		
		/**
		 * 异地备份方式
		*/
		public static final DBField DIFFPLACEBACKUP_DETAL = new DBField(DBDataType.STRING , "diffplacebackup_detal","diffplacebackupDetal","异地备份方式","异地备份方式",false,false,true);
		
		/**
		 * 归档 1,未归档 0
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","归档","1,未归档 0",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
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
		
		public OPS_INFORMATION_SYSTEM() {
			this.init($NAME,"信息系统" , ID , PID , INFOSYSTEM_NAME , INFOSYSTEM_PROFILE , STATUS , OPS_METHOD , DEV_METHOD , TCONTACT , BCONTACT , BPART , LASTDRILL_DATE , ONLINE_DATE , OFFLINE_DATE , OS_DETAIL , DB_DETAIL , APP_DETAIL , GRADE , RTO , RPO , HARDWARE_DETAIL , BACKUP_DETAIL , SAMEPLACEBACUP_DETAIL , DIFFPLACEBACKUP_DETAL , ARCH , TYPE , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_INFORMATION_SYSTEM $TABLE=new OPS_INFORMATION_SYSTEM();
	}
	
	/**
	 * 服务
	*/
	public static class OPS_SERVICE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 服务类型,DB,OS,MIDDLEWARE,OTHER
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","服务类型","DB,OS,MIDDLEWARE,OTHER",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField SERVICE_NAME = new DBField(DBDataType.STRING , "service_name","serviceName","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField SERVICE_NOTES = new DBField(DBDataType.STRING , "service_notes","serviceNotes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
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
		
		public OPS_SERVICE() {
			this.init($NAME,"服务" , ID , TYPE , SERVICE_NAME , SERVICE_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_SERVICE $TABLE=new OPS_SERVICE();
	}
	
	/**
	 * 服务明细
	*/
	public static class OPS_SERVICE_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 服务ID
		*/
		public static final DBField SERVICE_ID = new DBField(DBDataType.STRING , "service_id","serviceId","服务ID","服务ID",false,false,true);
		
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
		
		public OPS_SERVICE_DETAIL() {
			this.init($NAME,"服务明细" , ID , SERVICE_ID , NAME , PATCH , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_SERVICE_DETAIL $TABLE=new OPS_SERVICE_DETAIL();
	}
	
	/**
	 * 服务种类
	*/
	public static class OPS_SERVICE_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_type";
		
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
		
		public OPS_SERVICE_TYPE() {
			this.init($NAME,"服务种类" , ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_SERVICE_TYPE $TABLE=new OPS_SERVICE_TYPE();
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
		 * 业务模块
		*/
		public static final DBField MODULE = new DBField(DBDataType.STRING , "module","module","业务模块","业务模块",false,false,true);
		
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
			this.init($NAME,"编码分配" , ID , MODULE , RULE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
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
		 * 占位符
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","占位符","占位符",false,false,true);
		
		/**
		 * 编码名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","编码名称","编码名称",false,false,true);
		
		/**
		 * 编码类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","编码类型","编码类型",false,false,true);
		
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
			this.init($NAME,"编码属性" , ID , CODE , NAME , TYPE , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_ATTR $TABLE=new SYS_CODE_ATTR();
	}
	
	/**
	 * 代码生成示例
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
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
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
			this.init($NAME,"代码生成示例" , ID , NAME , NOTES , IMAGE_ID , FILE_IDS , AREA , WEIGHT , VALID , RADIO_ENUM , RADIO_DICT , CHECK_ENUM , CHECK_DICT , SELECT_ENUM , SELECT_DICT , RESOURCE_ID , BIRTHDAY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_EXAMPLE $TABLE=new SYS_CODE_EXAMPLE();
	}
	
	/**
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
			this.init($NAME,"" , ID , EXAMPLE_ID , ROLE_ID , VERSION);
		}
		public static final SYS_CODE_EXAMPLE_ROLE $TABLE=new SYS_CODE_EXAMPLE_ROLE();
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
		 * 编码规则
		*/
		public static final DBField RULE = new DBField(DBDataType.STRING , "rule","rule","编码规则","编码规则",false,false,true);
		
		/**
		 * 业务模块
		*/
		public static final DBField MODULE = new DBField(DBDataType.STRING , "module","module","业务模块","业务模块",false,false,true);
		
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
			this.init($NAME,"编码规则" , ID , NAME , RULE , MODULE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_CODE_RULE $TABLE=new SYS_CODE_RULE();
	}
	
	/**
	 * 工单类型
	*/
	public static class WORKORDER_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "workorder_type";
		
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
		
		public WORKORDER_TYPE() {
			this.init($NAME,"工单类型" , ID , NAME , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WORKORDER_TYPE $TABLE=new WORKORDER_TYPE();
	}
}