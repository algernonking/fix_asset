package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同类型
 * */
public enum ContractType implements CodeTextEnum {

	/**
	 * 主合同
	*/
	MAIN("main" , "主合同"),

	/**
	 * 子合同
	*/
	SUBS("subs" , "子合同"),

	/**
	 * 附加协议
	 */
	ADDI("addi" , "附加协议")
	;

	private String code;
	private String text;
	private ContractType(String code, String text)  {
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
	public static ContractType parseByCode(String code) {
		return (ContractType) EnumUtil.parseByCode(ContractType.values(),code);
	}
}
