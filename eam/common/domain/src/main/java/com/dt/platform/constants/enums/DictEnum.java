package com.dt.platform.constants.enums;

import com.github.foxnic.api.constant.CodeTextEnum;



/**
 * @since 2021-08-20 15:03:06
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('kn','eam','hrm','ops') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/

public enum DictEnum implements CodeTextEnum {
	
	/**
	 * 资产安全等级
	*/
	EAM_SECURITY_LEVEL("eam_security_level" , "资产安全等级"),
	
	/**
	 * 节点改密策略
	*/
	OPS_HOST_PASSWORD_STRATEGY("ops_host_password_strategy" , "节点改密策略"),
	
	/**
	 * 节点类型
	*/
	OPS_HOST_TYPE("ops_host_type" , "节点类型"),
	
	/**
	 * 节点环境
	*/
	OPS_ENVIRONMENT("ops_environment" , "节点环境"),
	
	/**
	 * 节点风险等级
	*/
	OPS_HOST_SAFETY("ops_host_safety" , "节点风险等级"),
	
	/**
	 * 知识库分类等级
	*/
	KN_GRADE("kn_grade" , "知识库分类等级"),
	
	/**
	 * 资产报修类型
	*/
	EAM_REPAIR_TYPE("eam_repair_type" , "资产报修类型"),
	
	/**
	 * 资产处置类型
	*/
	EAM_HANDLE_TYPE("eam_handle_type" , "资产处置类型"),
	
	/**
	 * 资产审批类型
	*/
	EAM_ASSET_APPROVAL_TYPE("eam_asset_approval_type" , "资产审批类型"),
	
	/**
	 * 数据库日志模式
	*/
	OPS_DB_LOG_METHOD("ops_db_log_method" , "数据库日志模式"),
	
	/**
	 * 数据库备份模式
	*/
	OPS_DB_BACKUP_METHOD("ops_db_backup_method" , "数据库备份模式"),
	
	/**
	 * 数据库备份状态
	*/
	OPS_DB_BACKUP_STATUS("ops_db_backup_status" , "数据库备份状态"),
	
	/**
	 * 数据库备份类型
	*/
	OPS_DB_BACKUP_TYPE("ops_db_backup_type" , "数据库备份类型"),
	
	/**
	 * 信息系统运维模式
	*/
	OPS_SYSTEM_OPS_METHOD("ops_system_ops_method" , "信息系统运维模式"),
	
	/**
	 * 信息系统开发模式
	*/
	OPS_SYSTEM_DEV_METHOD("ops_system_dev_method" , "信息系统开发模式"),
	
	/**
	 * 信息系统状态
	*/
	OPS_SYSTEM_STATUS("ops_system_status" , "信息系统状态"),
	
	/**
	 * 信息系统分级
	*/
	OPS_SYSTEM_GRADE("ops_system_grade" , "信息系统分级"),
	
	/**
	 * 资产来源
	*/
	EAM_SOURCE("eam_source" , "资产来源"),
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