package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum InspectionOvertimeMethodEnum implements CodeTextEnum {

    NO_HANDLE("no_handle" , "不处理"),
    AUTO_COMPLETE("auto_complete" , "自动完成"),
    HANG("hang" , "挂起"),

    ;
    private String code;
    private String text;
    private InspectionOvertimeMethodEnum(String code, String text)  {
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