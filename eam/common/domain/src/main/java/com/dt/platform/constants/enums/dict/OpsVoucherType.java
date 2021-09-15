package com.dt.platform.constants.enums.dict;




/**
 * @since 2021-09-13 21:20:09
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsVoucherType {
	
	/**
	 * 操作系统
	*/
	OS("os" , "操作系统"),
	
	/**
	 * 数据库
	*/
	DB("db" , "数据库"),
	
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
	
	/**
	 * 应用系统
	*/
	APP("app" , "应用系统"),
	
	/**
	 * Vmware
	*/
	VMWARE("vmware" , "Vmware"),
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
	 * 从字符串转换成当前枚举类型，使用 valueOf 方法可能导致偏差，建议不要使用
	*/
	public static OpsVoucherType parse(String code) {
		for (OpsVoucherType dn : OpsVoucherType.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}