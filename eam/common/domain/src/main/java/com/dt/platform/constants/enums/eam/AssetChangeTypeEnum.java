package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetChangeTypeEnum implements CodeTextEnum {

	EAM_ASSET_CHANGE_BASE_INFO("eam_asset_change_base_info" , "EAM_资产变更-基本"),
	EAM_ASSET_CHANGE_MAINTENANCE("eam_asset_change_maintenance" , "EAM_资产变更-维保"),
	EAM_ASSET_CHANGE_FINANCIAL("eam_asset_change_financial" , "EAM_资产变更-财务"),
	EAM_ASSET_CHANGE_EQUIPMENT("eam_asset_change_equipment" , "EAM_资产变更-设备"),
	;
	private String code;
	private String text;
	private AssetChangeTypeEnum(String code, String text)  {
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