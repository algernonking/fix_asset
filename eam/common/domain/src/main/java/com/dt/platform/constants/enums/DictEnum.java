package com.dt.platform.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-08-12 05:45:47
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm','ops') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum DictEnum implements CodeTextEnum {
	
	/**
	 * EAM_资产安全等级
	*/
	EAM_SECURITY_LEVEL("eam_security_level" , "EAM_资产安全等级"),
	
	/**
	 * 服务类型
	*/
	SERVICE("service" , "服务类型"),
	
	/**
	 * 节点改密策略
	*/
	OPS_HOST_PASSWORD_STRATEGY("ops_host_password_strategy" , "节点改密策略"),
	
	/**
	 * EAM_资产编号
	*/
	EAM_CODE_ATTR("eam_code_attr" , "EAM_资产编号"),
	
	/**
	 * 节点类型
	*/
	OPS_HOST_TYPE("ops_host_type" , "节点类型"),
	
	/**
	 * 节点环境
	*/
	OPS_ENV("ops_env" , "节点环境"),
	
	/**
	 * 节点风险等级
	*/
	OPS_HOST_SAFETY("ops_host_safety" , "节点风险等级"),
	
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