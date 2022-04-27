package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum InspectionResultStatusEnum implements CodeTextEnum {

    COMPLETE("COMPLETE" , "已完成"),
    OVERTIME("overtime" , "超时未完成"),
    OVERTIME2("overtime2" , "超期未执行"),

    NOT_STARTED("not_started" , "未开始"),

    ;
    private String code;
    private String text;
    private InspectionResultStatusEnum(String code, String text)  {
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