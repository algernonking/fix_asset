package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum CodeModuleEnum implements CodeTextEnum {


	EAM_ASSET_STORAGE("eam_asset_storage" , "EAM_资产-入库"),
	EAM_ASSET_CODE("eam_asset_code" , "EAM_资产编码"),
	EAM_ASSET_SOFTWARE_CODE("eam_asset_software_code" , "EAM_软件资产编码"),
	EAM_ASSET_STOCK_CODE("eam_asset_stock_code" , "EAM_资产库存-编码"),
	EAM_ASSET_CONSUMABLES_CODE("eam_asset_consumables_code" , "EAM_资产耗材-编码"),




	//
	//软件资产
	EAM_ASSET_SOFTWARE_INSERT("eam_asset_software_insert" , "EAM_资产软件-登记"),
	EAM_ASSET_SOFTWARE_CHANGE("eam_asset_software_change" , "EAM_资产软件-变更"),
	EAM_ASSET_SOFTWARE_MAINTENANCE("eam_asset_software_maintenance" , "EAM_资产软件-维保"),
	EAM_ASSET_SOFTWARE_DISTRIBUTE("eam_asset_software_distribute" , "EAM_资产软件-分发"),


	//资产单据
	EAM_ASSET_COLLECTION("eam_asset_collection" , "EAM_资产单据-领用"),
	EAM_ASSET_COLLECTION_RETURN("eam_asset_collection_return" , "EAM_资产单据-退库"),
	EAM_ASSET_BORROW("eam_asset_borrow" , "EAM_资产单据-借用"),
	EAM_ASSET_BORROW_RETURN("eam_asset_borrow_return" , "EAM_资产单据-借用归还"),
	EAM_ASSET_REPAIR("eam_asset_repair" , "EAM_资产单据-报修"),
	EAM_ASSET_REPAIR_ORDER("eam_asset_repair_order" , "EAM_资产单据-故障报修申请"),
	EAM_ASSET_REPAIR_ORDER_ACT("eam_asset_repair_order_act" , "EAM_资产单据-维修工单"),
	EAM_ASSET_REPAIR_ORDER_ACCEPTANCE("eam_asset_repair_order_acceptance" , "EAM_资产单据-维修验收"),
	EAM_ASSET_SCRAP("eam_asset_scrap" , "EAM_资产单据-报废"),
	EAM_ASSET_ALLOCATE("eam_asset_allocate" , "EAM_资产单据-调拨"),
	EAM_ASSET_TRANFER("eam_asset_tranfer" , "EAM_资产单据-转移"),
	EAM_ASSET_CLEAN("eam_asset_clean" , "EAM_资产单据-清理"),
	EAM_ASSET_INVENTORY("eam_asset_inventory" , "EAM_资产数据-盘点"),
	EAM_EQUIPMENT_FAILURE_REGISTRATION("eam_equipment_failure_registration" , "EAM_设备故障登记"),

	//库存
	EAM_ASSET_STOCK_IN("eam_asset_stock_in" , "EAM_资产库存-入库"),
	EAM_ASSET_STOCK_DELIVER("eam_asset_stock_deliver" , "EAM_资产库存-出库"),
	EAM_ASSET_STOCK_ALLOCATE("eam_asset_stock_allocate" , "EAM_资产库存-调拨"),
	EAM_ASSET_STOCK_DISTRIBUTE("eam_asset_stock_distribute" , "EAMi_资产库存-分配"),
	EAM_ASSET_STOCK_INVENTORY("eam_asset_stock_inventory" , "EAM_资产库存-盘点"),

	//物品库存
//	EAM_ASSET_STOCK_GOODS("eam_asset_stock_goods" , "EAM_库存物品-入库"),
	EAM_ASSET_STOCK_GOODS_IN("eam_asset_stock_goods_in" , "EAM_库存物品-入库"),
	EAM_ASSET_STOCK_GOODS_OUT("eam_asset_stock_goods_out" , "EAM_库存物品-出库"),
	EAM_ASSET_STOCK_GOODS_TRANFER("eam_asset_stock_goods_tranfer" , "EAM_库存物品-转移"),
	EAM_ASSET_STOCK_GOODS_ADJUST("eam_asset_stock_goods_adjust" , "EAM_库存物品-调整"),
	EAM_ASSET_STOCK_GOODS_INVENTORY("eam_asset_stock_goods_inventory" , "EAM_库存物品-盘点"),

	//物品耗材
//	EAM_ASSET_CONSUMABLES_GOODS("eam_asset_consumables_goods" , "EAM_耗材物品-入库"),
	EAM_ASSET_CONSUMABLES_GOODS_IN("eam_asset_consumables_goods_in" , "EAM_耗材物品-入库"),
	EAM_ASSET_CONSUMABLES_GOODS_OUT("eam_asset_consumables_goods_out" , "EAM_耗材物品-出库"),
	EAM_ASSET_CONSUMABLES_GOODS_TRANFER("eam_asset_consumables_goods_tranfer" , "EAM_耗材物品-转移"),
	EAM_ASSET_CONSUMABLES_GOODS_ADJUST("eam_asset_consumables_goods_adjust" , "EAM_耗材物品-调整"),
	EAM_ASSET_CONSUMABLES_GOODS_INVENTORY("eam_asset_consumables_goods_inventory" , "EAM_耗材物品-盘点"),

	//备件
	EAM_ASSET_PART_GOODS_IN("eam_asset_part_goods_in" , "EAM_备件物品-入库"),
	EAM_ASSET_PART_GOODS_OUT("eam_asset_part_goods_out" , "EAM_备件物品-出库"),
	EAM_ASSET_PART_GOODS_TRANFER("eam_asset_part_goods_tranfer" , "EAM_备件物品-转移"),
	EAM_ASSET_PART_GOODS_ADJUST("eam_asset_part_goods_adjust" , "EAM_备件物品-调整"),

	//耗材
	EAM_ASSET_CONSUMABLES_STOCK_IN("eam_asset_consumables_stock_in" , "EAM_资产耗材单据-入库"),
	EAM_ASSET_CONSUMABLES_DELIVER("eam_asset_consumables_deliver" , "EAM_资产耗材单据-出库"),
	EAM_ASSET_CONSUMABLES_COLLECTION("eam_asset_consumables_collection" , "EAM_资产耗材单据-领用"),
	EAM_ASSET_CONSUMABLES_TRANFER("eam_asset_consumables_tranfer" , "EAM_资产耗材单据-转移"),
	EAM_ASSET_CONSUMABLES_ALLOCATE("eam_asset_consumables_allocate" , "EAM_资产耗材单据-调拨"),


	//变更
	EAM_ASSET_CHANGE_BASE_INFO("eam_asset_change_base_info" , "EAM_资产变更-基本"),
	EAM_ASSET_CHANGE_MAINTENANCE("eam_asset_change_maintenance" , "EAM_资产变更-维保"),
	EAM_ASSET_CHANGE_FINANCIAL("eam_asset_change_financial" , "EAM_资产变更-财务"),
	EAM_ASSET_CHANGE_EQUIPMENT("eam_asset_change_equipment" , "EAM_资产变更-设备"),



	VEHICLE_APPLY("vehicle_apply" , "申请领用"),
	VEHICLE_MAINTENANCE("vehicle_maintenance" , "报修保险"),

	EAM_ASSET_PURCHASE_CHECK("eam_asset_purchase_check" , "EAM_资产采购验收"),
	EAM_ASSET_PURCHASE_APPLY("eam_asset_purchase_apply" , "EAM_资产采购申请"),
	EAM_ASSET_PURCHASE_ORDER("eam_asset_purchase_order" , "EAM_资产采购订单"),


	EAM_ASSET_DEPRECIATION_OPER("eam_asset_depreciation_oper" , "EAM_资产折旧");


	private String code;
	private String text;
	private CodeModuleEnum(String code, String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return code;
	}
	
	public String text() {
		return text;
	}
}