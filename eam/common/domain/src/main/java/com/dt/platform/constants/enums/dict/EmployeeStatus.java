package com.dt.platform.constants.enums.dict;




/**
 * @since 2021-09-18 12:20:10
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum EmployeeStatus {
	
	/**
	 * 在职
	*/
	ACTIVE("active" , "在职"),
	
	/**
	 * 离职
	*/
	LEAVE("leave" , "离职"),
	;
	
	private String code;
	private String text;
	private EmployeeStatus(String code,String text)  {
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
	public static EmployeeStatus parse(String code) {
		for (EmployeeStatus dn : EmployeeStatus.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}