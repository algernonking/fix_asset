package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum InspectionMethodEnum implements CodeTextEnum {

    RANDOM("random" , "随机"),
    ORDER("order" , "顺序"),
    ;
    private String code;
    private String text;
    private InspectionMethodEnum(String code, String text)  {
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