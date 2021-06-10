package com.dt.eam.constants.enums;




/**
 * @since 2021-06-10 13:04:36
 * @author 李方捷 , leefangjie@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum DictEnum {
	
	/**
	 * EAM_资产来源
	*/
	EAM_SOURCE("eam_source" , "EAM_资产来源"),
	
	/**
	 * EAM_资产计量单位
	*/
	EAM_UNIT("eam_unit" , "EAM_资产计量单位"),
	;
	
	private String code;
	private String text;
	private DictEnum(String code,String text)  {
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
	public static DictEnum parse(String code) {
		for (DictEnum dn : DictEnum.values()) {
			if(code.equals(dn.code())) return dn;
		}
		return null;
	}
}