package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetDepreciationStatusEnum implements CodeTextEnum {

    NOT_START("not_start" , "未开始"),
    ACTING("acting" , "进行中"),
    SUCCESS("sucess" , "成功"),
    FAILED("failed" , "失败"),
    COMPLETE("complete" , "完成"),
    ;
    private String code;
    private String text;
    private AssetDepreciationStatusEnum(String code, String text)  {
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