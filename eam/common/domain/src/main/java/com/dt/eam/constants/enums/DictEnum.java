package com.dt.eam.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum DictEnum implements CodeTextEnum {
	
	/**
	 * EAM_资产安全等级
	*/
	EAM_SECURITY_LEVEL("eam_security_level" , "EAM_资产安全等级"),
	
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
}