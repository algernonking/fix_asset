package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;



/**
 * @since 2021-09-29 11:26:59
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsHostPasswordStrategy {
	
	/**
	 * OpsTools
	*/
	OPS("ops" , "OpsTools"),
	
	/**
	 * 不改
	*/
	UNCHANGE("unchange" , "不改"),
	;
	
	private String code;
	private String text;
	private OpsHostPasswordStrategy(String code,String text)  {
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
	public static OpsHostPasswordStrategy parseByCode(String code) {
		return (OpsHostPasswordStrategy) EnumUtil.parseByCode(OpsHostPasswordStrategy.values(),code);
	}
}