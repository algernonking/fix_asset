package com.dt.platform.domain.eam.meta;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;

public class AssetLuckySheetColumnMeta {

    private String col="";
    //General 自动 --g
    // @ 纯文本   -- s
    // 0 整数    --n
    // 0.0 数字一位小数 --n
    // 0.00 数字两位小数 --n
    // 0.00% 百分比  n
    //yyyy-MM-dd hh:mm  --d
    //yyyy-MM-dd   --d
    private String valueType="";
    private String valueFormat="";
    private String colName="";
    private String colType="";
    private int colNumber=0;
    private int rowNumber=0;


    private JSONObject dataVerification;


    public String getCol() {
        return col;
    }



    public void setCol(String col) {
        this.col = col;
    }

    public JSONObject getDataVerification() {
        return dataVerification;
    }

    public void setDataVerification(JSONObject dataVerification) {
        this.dataVerification = dataVerification;
    }


    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public int getColNumber() {
        return colNumber;
    }

    public void setColNumber(int colNumber) {
        this.colNumber = colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueFormat() {
        return valueFormat;
    }

    public void setValueFormat(String valueFormat) {
        this.valueFormat = valueFormat;
    }


}
