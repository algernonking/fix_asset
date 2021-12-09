package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum CodeModuleEnum implements CodeTextEnum {


	EAM_ASSET_CODE("eam_asset_code" , "EAM_资产编码"),
	EAM_ASSET_SOFTWARE_CODE("eam_asset_software_code" , "EAM_软件资产编码"),
	EAM_ASSET_STOCK_CODE("eam_asset_stock_code" , "EAM_资产库存-编码"),
	EAM_ASSET_CONSUMABLES_CODE("eam_asset_consumables_code" , "EAM_资产耗材-编码"),

	//资产单据
	EAM_ASSET_COLLECTION("eam_asset_collection" , "EAM_资产单据-领用"),
	EAM_ASSET_COLLECTION_RETURN("eam_asset_collection_return" , "EAM_资产单据-退库"),
	EAM_ASSET_BORROW("eam_asset_borrow" , "EAM_资产单据-借用"),
	EAM_ASSET_BORROW_RETURN("eam_asset_borrow_return" , "EAM_资产单据-借用归还"),
	EAM_ASSET_REPAIR("eam_asset_repair" , "EAM_资产单据-报修"),
	EAM_ASSET_SCRAP("eam_asset_scrap" , "EAM_资产单据-报废"),
	EAM_ASSET_ALLOCATE("eam_asset_allocate" , "EAM_资产单据-调拨"),
	EAM_ASSET_TRANFER("eam_asset_tranfer" , "EAM_资产单据-转移"),
	EAM_ASSET_CLEAN("eam_asset_clean" , "EAM_资产单据-清理"),
	EAM_ASSET_INVENTORY("eam_asset_inventory" , "EAM_资产数据-盘点"),

	//库存
	EAM_ASSET_STOCK_IN("eam_asset_stock_in" , "EAM_资产库存-入库"),
	EAM_ASSET_STOCK_OUT("eam_asset_stock_out" , "EAM_资产库存-出库"),
	EAM_ASSET_STOCK_ALLOCATE("eam_asset_stock_allocate" , "EAM_资产库存-调拨"),
	EAM_ASSET_STOCK_DISTRIBUTE("eam_asset_stock_distribute" , "EAM_资产库存-分配"),
	EAM_ASSET_STOCK_INVENTORY("eam_asset_stock_inventory" , "EAM_资产库存-盘点"),

	//耗材
	EAM_ASSET_CONSUMABLES_STOCK_IN("eam_asset_consumables_stock_in" , "EAM_资产耗材单据-入库"),
	EAM_ASSET_CONSUMABLES_STOCK_OUT("eam_asset_consumables_stock_out" , "EAM_资产耗材单据-出库"),
	EAM_ASSET_CONSUMABLES_COLLECTION("eam_asset_consumables_collection" , "EAM_资产耗材单据-领用"),
	EAM_ASSET_CONSUMABLES_TRANFER("eam_asset_consumables_tranfer" , "EAM_资产耗材单据-转移"),
	EAM_ASSET_CONSUMABLES_ALLOCATE("eam_asset_consumables_allocate" , "EAM_资产耗材单据-调拨"),


	//变更
	EAM_ASSET_CHANGE_BASE_INFO("eam_asset_change_base_info" , "EAM_资产变更-基本"),
	EAM_ASSET_CHANGE_MAINTENANCE("eam_asset_change_maintenance" , "EAM_资产变更-维保"),
	EAM_ASSET_CHANGE_FINANCIAL("eam_asset_change_financial" , "EAM_资产变更-财务"),
	EAM_ASSET_CHANGE_EQUIPMENT("eam_asset_change_equipment" , "EAM_资产变更-设备"),

;

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