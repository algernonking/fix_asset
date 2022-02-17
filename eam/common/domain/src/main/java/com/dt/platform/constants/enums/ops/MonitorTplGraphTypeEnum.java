package com.dt.platform.constants.enums.ops;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 2021-07-24 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
 */


public enum MonitorTplGraphTypeEnum implements CodeTextEnum {

    PIE("pie" , "饼图"),
    LINE("line" , "线条"),
    //route,第一个为name,后面为计算的值
    LINE_CALCULATION("line_calculation" , "线条计算"),
    TABLE("table" , "表格");

    private String code;
    private String text;
    private MonitorTplGraphTypeEnum(String code, String text)  {
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