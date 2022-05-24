package com.dt.platform.domain.eam.meta;

import com.dt.platform.domain.eam.AssetLabel;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelTpl;
import com.github.foxnic.commons.log.Logger;

import java.util.List;
import java.util.Map;

public class AssetLabelPrint {


    private float PAGE_SIZE_A4_POINT=595f;
    //210mm
    private float PAGE_SIZE_A4_MM=210f;
    //1mm 对应pt 个数
    private float PAGE_SIZE_A4_POINT_PER_MM=595/210f;
    private List<AssetLabelCol> assetColumnList=null;
    List<Map<String, Object>> assetData=null;
    private AssetLabelTpl labelTpl;
    private AssetLabel label;
    //列个数
    private String paperType="a4";
    private int printColumnNumber=3;
    private int tableColumnNumber=2;

    //单位mm
    private float pointPerMM=PAGE_SIZE_A4_POINT_PER_MM;
    //单位mm
    private float maxTableWidthMM =60f;
    private float curTableWidthMM =60f;
    private int fontSizeLabel=10;
    private int fontSizeValue=10;
    private int fontSizeImageInfo=6;
    private int tableMarginLeftMM =1;
    private int tableMarginRightMM =1;

    public float getPointByMM(float mm){
        return mm*PAGE_SIZE_A4_POINT_PER_MM;
    }

    public void setLabel(AssetLabel label) {
        this.label = label;
        if(label.getAssetPaper()!=null){
            this.paperType=label.getAssetPaper().getType();
            this.printColumnNumber=label.getAssetPaper().getColumnNumber();
        }
        this.curTableWidthMM =label.getLabelWidth().floatValue()*10;
        if("a4".equals(this.paperType)){
            pointPerMM=PAGE_SIZE_A4_POINT_PER_MM;
            this.maxTableWidthMM =(PAGE_SIZE_A4_MM-2*printColumnNumber*tableMarginLeftMM-45)/printColumnNumber;
        }
        Logger.info("current table width(mm):"+this.curTableWidthMM +",allow table width(mm):"+this.maxTableWidthMM);
        if(this.curTableWidthMM >this.maxTableWidthMM){
            Logger.info("curTableWidthMM>maxTableWidthMM,to reset,c:"+this.curTableWidthMM +",m:"+this.maxTableWidthMM);
            this.curTableWidthMM =this.maxTableWidthMM;
        }
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public float getPointPerMM() {
        return pointPerMM;
    }
    public List<Map<String, Object>> getAssetData() {
        return assetData;
    }

    public void setAssetData(List<Map<String, Object>> assetData) {
        this.assetData = assetData;
    }

    public void setPointPerMM(float pointPerMM) {
        this.pointPerMM = pointPerMM;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public List<AssetLabelCol> getAssetColumnList() {
        return assetColumnList;
    }

    public void setAssetColumnList(List<AssetLabelCol> assetColumnList) {
        this.assetColumnList = assetColumnList;
    }


    public AssetLabel getLabel() {
        return label;
    }


    public int getPrintColumnNumber() {
        return printColumnNumber;
    }

    public void setPrintColumnNumber(int printColumnNumber) {
        this.printColumnNumber = printColumnNumber;
    }

    public int getTableColumnNumber() {
        return tableColumnNumber;
    }

    public void setTableColumnNumber(int tableColumnNumber) {
        this.tableColumnNumber = tableColumnNumber;
    }

    public float getMaxTableWidth() {
        return maxTableWidthMM;
    }

    public void setMaxTableWidth(float maxTableWidth) {
        this.maxTableWidthMM = maxTableWidth;
    }

    public float getCurTableWidth() {
        return curTableWidthMM;
    }

    public void setCurTableWidth(float curTableWidth) {
        this.curTableWidthMM = curTableWidth;
    }

    public int getFontSizeLabel() {
        return fontSizeLabel;
    }

    public void setFontSizeLabel(int fontSizeLabel) {
        this.fontSizeLabel = fontSizeLabel;
    }

    public int getFontSizeValue() {
        return fontSizeValue;
    }

    public void setFontSizeValue(int fontSizeValue) {
        this.fontSizeValue = fontSizeValue;
    }

    public int getFontSizeImageInfo() {
        return fontSizeImageInfo;
    }

    public void setFontSizeImageInfo(int fontSizeImageInfo) {
        this.fontSizeImageInfo = fontSizeImageInfo;
    }

    public int getTableMarginLeftMM() {
        return tableMarginLeftMM;
    }


    public int getTableMarginRightMM() {
        return tableMarginRightMM;
    }

    public void setTableMarginRightMM(int tableMarginRightMM) {
        this.tableMarginRightMM = tableMarginRightMM;
    }

    public AssetLabelTpl getLabelTpl() {
        return labelTpl;
    }

    public void setLabelTpl(AssetLabelTpl labelTpl) {
        this.labelTpl = labelTpl;
    }

    private String uuid;

}
