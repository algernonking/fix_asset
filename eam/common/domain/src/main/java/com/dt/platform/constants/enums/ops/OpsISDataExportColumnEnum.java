package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsISDataExportColumnEnum implements CodeTextEnum {


    IS_ID("id","id" ),
    BELONG_ORG_NAME("belongOrgName","belong_org_id" ),
    STATUS("statusName","status" ),
    GRADE("gradeName","grade" ),

    OPS_METHOD("opsMethodName","ops_method" ),
    DEV_METHOD("devMethod","dev_method" ),
    ARCH_METHOD("archMethod","arch_method" ),


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
