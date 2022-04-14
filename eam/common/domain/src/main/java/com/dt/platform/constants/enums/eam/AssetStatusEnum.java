package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetStatusEnum implements CodeTextEnum {

	IDLE("idle" , "闲置"),
	USING("using" , "在用"),
	BORROW("borrow" , "借用中"),
	REPAIR("repair" , "维修中"),
	ALLOCATING("allocate" , "调拨中"),
	SCRAP("scrap" , "待报废"),
	HANDLED("handled" , "已处置")
	;
	private String code;
	private String text;
	private AssetStatusEnum(String code, String text)  {
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