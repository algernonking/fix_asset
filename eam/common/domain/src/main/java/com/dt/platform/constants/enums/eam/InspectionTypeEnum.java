package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;




public enum InspectionTypeEnum implements CodeTextEnum {

    TYPE1("type1" , "类型1"),


    ;
    private String code;
    private String text;
    private InspectionTypeEnum(String code, String text)  {
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