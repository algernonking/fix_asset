package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/




public enum CodeAttrTypeEnum implements CodeTextEnum {

	STRING_FIX("string_fix" , "固定字符串"),
	STRING_RAND("string_rand" , "随机字符串"),
	NUMBER_SEQ("number_seq" , "顺序数字"),
	NUMBER_RAND("number_rand" , "随机数字"),
	TIME("time" , "时间"),
	ORG("org" , "组织架构"),
	;

	private String code;
	private String text;
	private CodeAttrTypeEnum(String code, String text)  {
		this.code=code;
		this.text=text;
	}
	
	public String code() {
		return code;
	}
	
	public String text() {
		return text;
	}
}