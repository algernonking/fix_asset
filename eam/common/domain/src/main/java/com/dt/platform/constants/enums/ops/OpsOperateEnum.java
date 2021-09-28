package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsOperateEnum implements CodeTextEnum {


    OPS_DOWNLOAD_HOST("ops_download_host", "主机列表下载"),
    OPS_DOWNLOAD_INFORMATION_SYSTEM("ops_download_information_system" , "信息系统列表下载"),
    OPS_DOWNLOAD_DATABASE_INST("ops_download_database_inst" , "数据库实例列表下载"),

    ;


    private String code;
    private String text;
    private OpsOperateEnum(String code, String text)  {
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
