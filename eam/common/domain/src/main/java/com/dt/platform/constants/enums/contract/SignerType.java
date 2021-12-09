package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同签订方类型
 * */
public enum SignerType implements CodeTextEnum {

	/**
	 * 企业
	*/
	ENTERPRISE("enterprise" , "企业"),

	/**
	 * 个人
	*/
	INDIVIDUAL("individual" , "个人")
	;

	private String code;
	private String text;
	private SignerType(String code, String text)  {
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
	public static SignerType parseByCode(String code) {
		return (SignerType) EnumUtil.parseByCode(SignerType.values(),code);
	}
}
