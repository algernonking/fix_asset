package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同履行状态
 * */
public enum ContractStatus implements CodeTextEnum {

	/**
	 * 未签约
	*/
	NOT_SIGNED("not_signed" , "未签约"),

	/**
	 * 履约中
	*/
	PERFORMING("performing" , "履约中"),

	/**
	 * 终止
	 */
	TERMINATED("terminated" , "终止"),

	/**
	 * 完成
	 */
	DONE("done" , "完成"),

	/**
	 * 作废
	 */
	ABANDONED("abandoned" , "作废")
	;

	private String code;
	private String text;
	private ContractStatus(String code, String text)  {
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
	public static ContractStatus parseByCode(String code) {
		return (ContractStatus) EnumUtil.parseByCode(ContractStatus.values(),code);
	}
}
