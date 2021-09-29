package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2021-09-29 11:26:59
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsSystemDevMethod {
	
	/**
	 * 自研
	*/
	DEVELOPMENT("development" , "自研"),
	
	/**
	 * 购买
	*/
	PURCHASE("purchase" , "购买"),
	;
	
	private String code;
	private String text;
	private OpsSystemDevMethod(String code,String text)  {
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
	public static OpsSystemDevMethod parseByCode(String code) {

		return (OpsSystemDevMethod) EnumUtil.parseByCode(OpsSystemDevMethod.values(),code);
	}
}