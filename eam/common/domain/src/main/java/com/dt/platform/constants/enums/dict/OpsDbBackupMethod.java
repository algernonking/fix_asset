package com.dt.platform.constants.enums.dict;




/**
 * @since 2021-08-20 15:03:08
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsDbBackupMethod {
	
	/**
	 * 增量-7
	*/
	INCR7("incr7" , "增量-7"),
	
	/**
	 * 全量
	*/
	FULL("full" , "全量"),
	
	/**
	 * 增量-15
	*/
	INCR15("incr15" , "增量-15"),
	;
	
	private String code;
	private String text;
	private OpsDbBackupMethod(String code,String text)  {
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
	public static OpsDbBackupMethod parse(String code) {
		for (OpsDbBackupMethod dn : OpsDbBackupMethod.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}