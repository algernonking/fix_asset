package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsISDataExportColumnEnum implements CodeTextEnum {


    IS_ID("id","id" ),
    ;

    private String code;
    private String text;
    private OpsISDataExportColumnEnum(String code, String text)  {
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
