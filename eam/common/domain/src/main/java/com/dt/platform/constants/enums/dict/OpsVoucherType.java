package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-12-08 16:04:50
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsVoucherType implements CodeTextEnum {
	
	/**
	 * 操作系统
	*/
	OS("os" , "操作系统"),
	
	/**
	 * 数据库
	*/
	DB("db" , "数据库"),
	
	/**
	 * 应用系统
	*/
	APP("app" , "应用系统"),
	
	/**
	 * Vmware
	*/
	VMWARE("vmware" , "Vmware"),
	
	/**
	 * 存储系统
	*/
	STORAGE("storage" , "存储系统"),
	
	/**
	 * 网络
	*/
	NETWORK("network" , "网络"),
	
	/**
	 * 安全
	*/
	SECURITY("security" , "安全"),
	
	/**
	 * 中间件
	*/
	MIDDLEWARE("middleware" , "中间件"),
	;
	
	private String code;
	private String text;
	private OpsVoucherType(String code,String text)  {
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
	public static OpsVoucherType parseByCode(String code) {
		return (OpsVoucherType) EnumUtil.parseByCode(OpsVoucherType.values(),code);
	}
}