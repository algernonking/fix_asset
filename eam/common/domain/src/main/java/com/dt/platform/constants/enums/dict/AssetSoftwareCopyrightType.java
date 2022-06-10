package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2022-06-07 06:51:48
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum AssetSoftwareCopyrightType implements CodeTextEnum {
	
	/**
	 * 供应商
	*/
	SUPPLIER("supplier" , "供应商"),
	
	/**
	 * 共有
	*/
	COMMON("common" , "共有"),
	
	/**
	 * 自有
	*/
	OWN("own" , "自有"),
	;
	
	private String code;
	private String text;
	private AssetSoftwareCopyrightType(String code,String text)  {
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
	public static AssetSoftwareCopyrightType parseByCode(String code) {
		return (AssetSoftwareCopyrightType) EnumUtil.parseByCode(AssetSoftwareCopyrightType.values(),code);
	}
}