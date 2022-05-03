package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;


public enum AssetFirstDepreciationDateTypeEnum implements CodeTextEnum {

    PURCHASE_CUR_MONTH("purchase_cur_month" , "购买当月"),
    PURCHASE_NEXT_MONTH("purchase_next_month" , "购买次月");

    private String code;
    private String text;
    private AssetFirstDepreciationDateTypeEnum(String code, String text)  {
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