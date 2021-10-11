package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum AssetAttributeComponentTypeEnum implements CodeTextEnum {


	TEXT_INPUT("text_input" , "单行文本"),
	TEXT_AREA("text_area" , "多行文本"),
	UPLOAD("upload" , "上传组件"),
	RADIO_BOX("raido_box" , "单选框"),
	SELECT_BOX("select_box","下拉框"),
	DATE_INPUT("date_input","日期选择框"),
	NUMBER_INPUT("number_input" , "数字输入框")

	;
	private String code;
	private String text;
	private AssetAttributeComponentTypeEnum(String code, String text)  {
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