package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum MonitorTopDataEnum implements CodeTextEnum {

    OS_CPU_USED("os_cpu_used" , "TOP主机CPU使用率"),
    OS_LOAD("os_load" , "TOP主机负载"),
    OS_FS_USED("fs_used" , "TOP主机文件系统"),
    OS_FS_INODE_USED("fs_inode_used" , "TOP主机文件系统INODE"),
    OS_P_MEMORY_USED("os_p_memory_used" , "TOP主机内存使用率"),
    OS_V_MEMORY_USED("os_v_memory_used" , "TOP主机虚拟内存使用率"),
    OS_NET_FLOW_UP("os_net_flow_up" , "TOP主机上传流量"),
    OS_NET_FLOW_DOWN("os_net_flow_down" , "TOP主机下传流量"),

    DB_ORACLE_TABLESPACE("db_oracle_tablespace" , "TOPOracle表空间"),
    DB_DB2_TABLESPACE("db_db2_tablespace" , "TOPDB2表空间")
    ;

    private String code;
    private String text;
    private MonitorTopDataEnum(String code, String text)  {
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