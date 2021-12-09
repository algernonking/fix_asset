package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-12-08 16:04:50
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsSystemOpsMethod implements CodeTextEnum {
	
	/**
	 * 运维
	*/
	OPERATION("operation" , "运维"),
	
	/**
	 * 托管
	*/
	TRUSTEESHIP("trusteeship" , "托管"),
	;
	
	private String code;
	private String text;
	private OpsSystemOpsMethod(String code,String text)  {
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
	public static OpsSystemOpsMethod parseByCode(String code) {
		return (OpsSystemOpsMethod) EnumUtil.parseByCode(OpsSystemOpsMethod.values(),code);
	}
}