package com.dt.platform.constants.enums.dict;




/**
 * @since 2021-09-02 20:56:02
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsUserVoucher {
	
	/**
	 * root
	*/
	VOUCHER_ROOT("voucher_root" , "root"),
	
	/**
	 * db2inst1
	*/
	VOUCHER_DB2INST1("voucher_db2inst1" , "db2inst1"),
	;
	
	private String code;
	private String text;
	private OpsUserVoucher(String code,String text)  {
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
	public static OpsUserVoucher parse(String code) {
		for (OpsUserVoucher dn : OpsUserVoucher.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}