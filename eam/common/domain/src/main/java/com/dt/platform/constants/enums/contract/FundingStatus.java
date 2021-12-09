package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同资金状态
 * */
public enum FundingStatus implements CodeTextEnum {

	/**
	 * 未生效
	*/
	NOT_ACTIVE("not_active" , "未生效"),

	/**
	 * 收付中
	*/
	PERFORMING("performing" , "收付中"),


	/**
	 * 完成
	 */
	DONE("done" , "已结清"),

	;

	private String code;
	private String text;
	private FundingStatus(String code, String text)  {
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
	public static FundingStatus parseByCode(String code) {
		return (FundingStatus) EnumUtil.parseByCode(FundingStatus.values(),code);
	}
}
