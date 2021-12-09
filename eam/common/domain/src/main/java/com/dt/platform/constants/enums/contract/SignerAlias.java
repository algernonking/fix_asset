package com.dt.platform.constants.enums.contract;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;


/**
 * 合同签订方类型
 * */
public enum SignerAlias implements CodeTextEnum {

	PART_A("part_a" , "甲方",1),
	PART_B("part_b" , "乙方",2),
	PART_C("part_c" , "丙方",3),
	PART_D("part_d" , "丁方",4),
	PART_E("part_e" , "戊方",5),
	PART_F("part_f" , "己方",6),
	;

	private String code;
	private String text;
	private int index;
	private SignerAlias(String code, String text,int index)  {
		this.code=code;
		this.text=text;
		this.index=index;
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
	public static SignerAlias parseByCode(String code) {
		return (SignerAlias) EnumUtil.parseByCode(SignerAlias.values(),code);
	}
}
