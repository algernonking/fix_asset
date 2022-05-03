package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetDepreciationMethodEnum implements CodeTextEnum {

    AVERAGE_AGE("average_age" , "平均年限方法")
    ;
    private String code;
    private String text;
    private AssetDepreciationMethodEnum(String code, String text)  {
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