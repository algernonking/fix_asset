package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetAttributeItemOwnerEnum implements CodeTextEnum {

	BASE("base" , "资产基本模块"),
	EQUIPMENT("equipment" , "设备模块"),
	ASSET_CHANGE("asset_change" , "变更模块"),
	ASSET_SELECT("asset_select" , "资产选择列表"),
	ASSET_BOOK("asset_book" , "资产公共台账列表"),

	//单据耗材，
	ASSET_CONSUMABLES_BILL("asset_consumables_bill","耗材单据"),
	ASSET_CONSUMABLES_SHOW("asset_consumables_show","耗材公共显示"),
	ASSET_CONSUMABLES_INSERT("asset_consumables_insert","耗材插入"),

	//单据耗材，
	ASSET_STOCK_BILL("asset_stock_bill","库存单据"),
	ASSET_STOCK_SHOW("asset_stock_show","库存公共显示"),
	ASSET_STOCK_INSERT("asset_stock_insert","库存插入"),

	//单据和资产选择，资产公共显示
	ASSET_BILL("asset_bill" , "资产单据列表"),
	PUBLIC_SHOW("public_show" , "公共显示列表"),
	;

	private String code;
	private String text;
	private AssetAttributeItemOwnerEnum(String code, String text)  {
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