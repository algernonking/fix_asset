package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum MonitorMethodEnum implements CodeTextEnum {

    AGENT("agent" , "代理方式"),
    SNMP("snmp" , "SNMP方式"),
    ZABBIX("zabbix" , "Zabbix"),
    VMWARE("vmware" , "Vmware"),
    DIRECT("direct" , "直接取数"),
    SCRIPT("script" , "脚本取数"),
    JDBC("jdbc" , "JDBC取数");

    private String code;
    private String text;
    private MonitorMethodEnum(String code, String text)  {
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