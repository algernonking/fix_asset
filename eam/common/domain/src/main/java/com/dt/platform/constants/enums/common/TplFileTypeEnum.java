package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum TplFileTypeEnum implements CodeTextEnum {

    EAM_BILL_DOCX("eam_bill_docx" , "资产单据模板"),
    EAM_ASSET_EXCEL("eam_asset_excel" , "资产下载模板"),
    OPS("ops" , "运维模块"),
    CONT("cont" , "合同模块"),
    ;


    private String code;
    private String text;
    private TplFileTypeEnum(String code, String text)  {
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

