package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 附件所有者类型
 * */
public enum AttachmentOwnerType implements CodeTextEnum {

	/**
	 * 合同
	*/
	CONTRACT("contract" , "合同"),

	/**
	 * 履约登记
	*/
	PERFORMANCE("performance" , "履约登记")
	;

	private String code;
	private String text;
	private AttachmentOwnerType(String code, String text)  {
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
	public static AttachmentOwnerType parseByCode(String code) {
		return (AttachmentOwnerType) EnumUtil.parseByCode(AttachmentOwnerType.values(),code);
	}
}
