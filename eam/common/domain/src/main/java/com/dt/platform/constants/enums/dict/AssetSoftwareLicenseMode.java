package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2022-06-07 06:51:48
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum AssetSoftwareLicenseMode implements CodeTextEnum {
	
	/**
	 * 按Core授权
	*/
	CORE("core" , "按Core授权"),
	
	/**
	 * 按Cpu授权
	*/
	CPU("cpu" , "按Cpu授权"),
	
	/**
	 * 按套数授权
	*/
	SETS("sets" , "按套数授权"),
	
	/**
	 * 按用户授权
	*/
	USER("user" , "按用户授权"),
	
	/**
	 * 开源免费
	*/
	OPENSOURCEFREE("openSourceFree" , "开源免费"),
	
	/**
	 * 预装
	*/
	PRELOADED("preloaded" , "预装"),
	
	/**
	 * 自主开发
	*/
	INDEPENDENTDEVELOPMENT("independentDevelopment" , "自主开发"),
	
	/**
	 * 合作开发
	*/
	COOPERATIVEDEVELOPMENT("cooperativeDevelopment" , "合作开发"),
	;
	
	private String code;
	private String text;
	private AssetSoftwareLicenseMode(String code,String text)  {
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
	public static AssetSoftwareLicenseMode parseByCode(String code) {
		return (AssetSoftwareLicenseMode) EnumUtil.parseByCode(AssetSoftwareLicenseMode.values(),code);
	}
}