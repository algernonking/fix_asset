package com.dt.platform.constants.enums.vehicle;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum VehicleOperationEnum implements CodeTextEnum {
	VEHICLE_APPLY(CodeModuleEnum.VEHICLE_APPLY.code() , "申请领用"),
	VEHICLE_MAINTENANCE(CodeModuleEnum.VEHICLE_MAINTENANCE.code(), "报修保险")
	;
	private String code;
	private String text;
	private VehicleOperationEnum(String code, String text)  {
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