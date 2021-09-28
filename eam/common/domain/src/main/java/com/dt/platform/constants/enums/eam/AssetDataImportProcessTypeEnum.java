package com.dt.platform.constants.enums.eam;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum AssetDataImportProcessTypeEnum implements CodeTextEnum {

    DATA_FILL("fill","填充" ),
    DATA_KEEP("keep","保留" ),
    ;

    private String code;
    private String text;
    private AssetDataImportProcessTypeEnum(String code, String text)  {
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
