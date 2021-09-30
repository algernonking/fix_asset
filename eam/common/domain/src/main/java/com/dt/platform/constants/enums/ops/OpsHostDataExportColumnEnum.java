package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsHostDataExportColumnEnum implements CodeTextEnum {

    HOST_ID("id","id" ),
    POSITION_ID("hostPositionName","position_id" ),
    HOST_STATUS("statusName","status" ),


    HOST_MONITOR_STATUS("monitorStatusName","monitor_status" ),
    HOST_INFO_SYSTEM_NAME("hostInfoSystemName","system_id" ),

    HOST_OS("hostOs","host_os" ),
    HOST_DB("hostDb","host_db" ),
    HOST_MID("hostMid","host_mid" ),

    HOST_TYPE("hostTypeName","host_type" ),
    HOST_BACKUP_METHOD("hostBackupMethod","host_backup_method" ),

    HOST_ENVIRONMENT("hostEnvironmentName","environment" ),
    HOST_PASSWORD_STRATEGY("hostPasswordStrategy","password_strategy_id" ),


    ;

    private String code;
    private String text;
    private OpsHostDataExportColumnEnum(String code, String text)  {
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
