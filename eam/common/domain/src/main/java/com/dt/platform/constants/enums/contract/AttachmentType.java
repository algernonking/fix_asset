package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 附件所有者类型
 * */
public enum AttachmentType implements CodeTextEnum {

	/**
	 * 合同文本
	 */
	CONTRACT_TEXT("contract_text" , "合同文本"),

	/**
	 * 交付物
	*/
	DELIVERABLE("deliverable" , "交付物"),

	/**
	 * 履约附件
	*/
	PERFORMANCE("performance" , "履约附件")
	;

	private String code;
	private String text;
	private AttachmentType(String code, String text)  {
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
	public static AttachmentType parseByCode(String code) {
		return (AttachmentType) EnumUtil.parseByCode(AttachmentType.values(),code);
	}
}
