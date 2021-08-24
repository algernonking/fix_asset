package com.dt.platform.constants.enums.dict;




/**
 * @since 2021-08-20 15:03:08
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsSystemGrade {
	
	/**
	 * 一级
	*/
	G1("G1" , "一级"),
	
	/**
	 * 三级
	*/
	G3("G3" , "三级"),
	
	/**
	 * 二级
	*/
	G2("G2" , "二级"),
	;
	
	private String code;
	private String text;
	private OpsSystemGrade(String code,String text)  {
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
	 * 从字符串转换成当前枚举类型，使用 valueOf 方法可能导致偏差，建议不要使用
	*/
	public static OpsSystemGrade parse(String code) {
		for (OpsSystemGrade dn : OpsSystemGrade.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}