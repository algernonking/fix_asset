package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-12-08 16:04:50
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsHostType implements CodeTextEnum {
	
	/**
	 * 业务系统
	*/
	BUSINESS("business" , "业务系统"),
	
	/**
	 * 办公系统
	*/
	OFFICE("office" , "办公系统"),
	
	/**
	 * 外围系统
	*/
	OUT("out" , "外围系统"),
	
	/**
	 * 其他业务系统
	*/
	OTHER_BUSINESS("other_business" , "其他业务系统"),
	
	/**
	 * 其他-办公系统
	*/
	OTHER_OFFICE("other_office" , "其他-办公系统"),
	
	/**
	 * 其他-运维系统
	*/
	OTHER_OPS("other_ops" , "其他-运维系统"),
	
	/**
	 * 运维系统
	*/
	OPS("ops" , "运维系统"),
	
	/**
	 * 分析系统
	*/
	ANALYZE("analyze" , "分析系统"),
	;
	
	private String code;
	private String text;
	private OpsHostType(String code,String text)  {
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
	public static OpsHostType parseByCode(String code) {
		return (OpsHostType) EnumUtil.parseByCode(OpsHostType.values(),code);
	}
}