package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-12-08 15:42:14
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum ContractType implements CodeTextEnum {
	
	/**
	 * 采购合同
	*/
	PURCHASE("purchase" , "采购合同"),
	
	/**
	 * 销售合同
	*/
	SALES("sales" , "销售合同"),
	;
	
	private String code;
	private String text;
	private ContractType(String code,String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return code;
	}
	
	public String text() {
		return text;
	}
	
	/**
	 * 从字符串转换成当前枚举类型
	*/
	public static ContractType parseByCode(String code) {
		return (ContractType) EnumUtil.parseByCode(ContractType.values(),code);
	}
}