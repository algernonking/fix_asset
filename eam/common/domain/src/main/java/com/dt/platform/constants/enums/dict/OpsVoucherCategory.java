package com.dt.platform.constants.enums.dict;




/**
 * @since 2021-09-18 12:20:10
 * @author 金杰 , maillank@qq.com
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public enum OpsVoucherCategory {
	
	/**
	 * 网络
	*/
	NETWORK("network" , "网络"),
	
	/**
	 * 安全
	*/
	SECURITY("security" , "安全"),
	
	/**
	 * Vmware集群
	*/
	VMWARE("vmware" , "Vmware集群"),
	
	/**
	 * IBM HMC Console
	*/
	HMC("hmc" , "IBM HMC Console"),
	;
	
	private String code;
	private String text;
	private OpsVoucherCategory(String code,String text)  {
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
	public static OpsVoucherCategory parse(String code) {
		for (OpsVoucherCategory dn : OpsVoucherCategory.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}