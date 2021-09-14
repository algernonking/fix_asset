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
	EAM_ASSET_ALLOCATE("eam_asset_allocate" , "EAM_资产单据-调拨"),
	EAM_ASSET_BORROW("eam_asset_borrow" , "EAM_资产单据-借用"),
	EAM_ASSET_CHANGE_FINANCIAL("eam_asset_change_financial" , "EAM_资产单据-财务变更"),
	EAM_ASSET_COLLECTION("eam_asset_collection" , "EAM_资产单据-领用"),
	EAM_ASSET_COLLECTION_RETURN("eam_asset_collection_return" , "EAM_资产单据-退库"),
	EAM_ASSET_REGISTER("eam_asset_register" , "EAM_资产单据-登记"),
	EAM_ASSET_REPAIR("eam_asset_repair" , "EAM_资产单据-报修"),
	EAM_ASSET_SCRAP("eam_asset_scrap" , "EAM_资产单据-报废"),
	EAM_ASSET_TRANFER("eam_asset_tranfer" , "EAM_资产单据-转移"),
	EAM_ASSET_STOCK_OUT("eam_stock_out" , "EAM_资产库存出库编码"),
	EAM_ASSET_STOCK_IN("eam_stock_in" , "EAM_资产库存入库编码"),
	EAM_ASSET_CARD("eam_asset_card" , "EAM_资产卡片"),
	EAM_DOWNLOAD_ASSET("eam_download_asset" , "EAM_资产数据下载"),
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