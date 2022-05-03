package com.dt.platform.constants.enums.eam;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetOwnerCodeEnum implements CodeTextEnum {

	ASSET("asset" , "资产"),
	ASSET_SOFTWARE("asset_software" , "软件资产"),
	ASSET_SPARE_PARTS(" asset_spare_parts" , "备品备件"),
	ASSET_CONSUMABLES("asset_consumables" , "耗材资产"),
	ASSET_STOCK("asset_stock" , "资产库存"),

	ASSET_PURCHASE_APPLY("asset_purchase_apply" , "资产采购申请"),


	ASSET_UNCONFIRMED("asset_unconfirmed" , "资产新增未确认"),
	ASSET_CHANGE_RECORD("asset_change_record" , "资产变更记录"),
	ASSET_CLEAN_OUT("asset_clean_out" , "资产清理"),
	ASSET_CONSUMABLES_COLLECTION(CodeModuleEnum.EAM_ASSET_CONSUMABLES_COLLECTION.code() , "耗材资产领用"),
	ASSET_STOCK_DISTRIBUTE(CodeModuleEnum.EAM_ASSET_STOCK_DISTRIBUTE.code() , "资产库存分配"),
	ASSET_CHANGE_BASE_INFO(CodeModuleEnum.EAM_ASSET_CHANGE_BASE_INFO.code(), "EAM_资产变更-基本"),
	ASSET_CHANGE_MAINTENANCE(CodeModuleEnum.EAM_ASSET_CHANGE_MAINTENANCE.code() , "EAM_资产变更-维保"),
	ASSET_CHANGE_FINANCIAL(CodeModuleEnum.EAM_ASSET_CHANGE_FINANCIAL.code() , "EAM_资产变更-财务"),
	ASSET_CHANGE_EQUIPMENT(CodeModuleEnum.EAM_ASSET_CHANGE_EQUIPMENT.code() , "EAM_资产变更-设备"),

	ASSET_DEPRECIATION_DATA("asset_depreciation_data" , "资产折旧数据"),

	;
	private String code;
	private String text;
	private AssetOwnerCodeEnum(String code, String text)  {
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