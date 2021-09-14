package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum AssetTplFileTypeEnum implements CodeTextEnum {

    BILL_DOCX("bill_docx" , "单据模板"),
    ASSET_EXCEL("asset_excel" , "资产下载模板");


    private String code;
    private String text;
    private AssetTplFileTypeEnum(String code, String text)  {
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

