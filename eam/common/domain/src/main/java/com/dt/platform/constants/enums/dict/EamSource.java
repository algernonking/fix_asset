package com.dt.platform.constants.enums.dict;

import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-12-08 15:42:14
 * @author 李方捷 , leefangjie@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum EamSource implements CodeTextEnum {
	
	/**
	 * 采购
	*/
	PURCHASE("purchase" , "采购"),
	
	/**
	 * 自购
	*/
	SELFBUY("selfbuy" , "自购"),
	
	/**
	 * 赠送
	*/
	GIVE("give" , "赠送"),
	
	/**
	 * 自建
	*/
	SELFBUILD("selfbuild" , "自建"),
	
	/**
	 * 捐赠
	*/
	DONATION("donation" , "捐赠"),
	
	/**
	 * 其他
	*/
	OTHER("other" , "其他"),
	;
	
	private String code;
	private String text;
	private EamSource(String code,String text)  {
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
	public static EamSource parseByCode(String code) {
		return (EamSource) EnumUtil.parseByCode(EamSource.values(),code);
	}
}