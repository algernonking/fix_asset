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
	EAM_ASSET_STOCK_OUT("eam_stock_out" , "EAM_资产库存出库编码"),
	EAM_ASSET_STOCK_IN("eam_stock_in" , "EAM_资产库存入库编码"),
	EAM__BILL_COLLECTION("eam_bill_collection" , "EAM_资产单据-领用"),
	EAM__BILL_BORROW("eam_bill_borrow" , "EAM_资产单据-借用"),
	EAM__BILL_SCRAP("eam_bill_scrap" , "EAM_资产单据-报废"),
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