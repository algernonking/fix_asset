package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum InspectionPlanTypeEnum implements CodeTextEnum {

    INSPECTION("inspection" , "巡检"),
    POINT_CHECK("point_check" , "点检"),


    ;
    private String code;
    private String text;
    private InspectionPlanTypeEnum(String code, String text)  {
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