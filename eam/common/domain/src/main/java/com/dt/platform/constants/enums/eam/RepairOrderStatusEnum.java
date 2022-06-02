package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum RepairOrderStatusEnum implements CodeTextEnum {

	NOT_DISPATCH("not_dispatch" , "未派单"),
	//已派单,包含派单到组内或者具体执行人，都归纳为已派单
	DISPATCHED("dispatched" , "已派单"),
	REPAIRING("repairing" , "维修中"),
	WAIT_ACCEPTANCE("wait_acceptance" , "待验收"),
	FINISH("finish" , "维修结束"),
	CANCEL("cancel" , "取消");

	private String code;
	private String text;
	private RepairOrderStatusEnum(String code, String text)  {
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