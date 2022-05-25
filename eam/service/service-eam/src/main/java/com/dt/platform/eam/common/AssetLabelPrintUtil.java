package com.dt.platform.eam.common;

import com.dt.platform.domain.eam.AssetLabel;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelTpl;
import com.dt.platform.domain.eam.meta.AssetLabelPrint;
import com.github.foxnic.commons.log.Logger;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.*;


import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetLabelPrintUtil {

    public int PAGE_SIZE_A4_POINT=595;
    public int PAGE_SIZE_A4_MM=210;
    //1mm 对应pt 个数

    public static void main(String[] args) {


        //label
        AssetLabel label=new AssetLabel();
        label.setLabelWidth(new BigDecimal(5.2));
        AssetLabelPaper paper=new AssetLabelPaper();
        paper.setType("a4");
        paper.setColumnNumber(3);
        label.setAssetPaper(paper);

        AssetLabelTpl labelTpl=new AssetLabelTpl();
        labelTpl.setImageShow("1");
        labelTpl.setImageLabelShow("1");
        labelTpl.setImagePosition("d");
        labelTpl.setImageType("txm");

        //列表
        List<AssetLabelCol> colList=new ArrayList<>();
        AssetLabelCol col1=new AssetLabelCol();
       // col1.setColName("资产名称");
        col1.setColName("天地通信");
        col1.setColValue("name");
        colList.add(col1);
        AssetLabelCol col2=new AssetLabelCol();
       // col2.setColName("资产型号");
        col2.setColName("三三两两");
        col2.setColValue("model");
        colList.add(col2);

        //数据
        List<Map<String, Object>> data=new ArrayList<>();
        Map<String, Object> map1=new HashMap<>();
        map1.put("name","测试21212121212ads测试测是");
        map1.put("model","模型");
        map1.put("id","1235");
        map1.put("assetCode","12345678765432");
        data.add(map1);

        Map<String, Object> map2=new HashMap<>();
        map2.put("name","测试222测试");
        map2.put("model","型号123345");
        map2.put("id","123567");
        map2.put("assetCode","9876543456789");
        data.add(map2);

        Map<String, Object> map3=new HashMap<>();
        map3.put("name","nameValue");
        map3.put("model","modelValue");
        map3.put("id","12345");
        map3.put("assetCode","4567875456789876");
        data.add(map3);

        Map<String, Object> map4=new HashMap<>();
        map4.put("name","nameValue");
        map4.put("model","modelValue");
        map4.put("id","76543");
        map4.put("assetCode","9896534534678234");
        data.add(map4);

        Map<String, Object> map5=new HashMap<>();
        map5.put("name","nameValue");
        map5.put("model","modelValue");
        map5.put("id","76543");
        map5.put("assetCode","9896534534678234");
        data.add(map5);

        AssetLabelPrint printData=new AssetLabelPrint();
        printData.setUuid("123");
        printData.setLabel(label);
        printData.setLabelTpl(labelTpl);
        printData.setAssetColumnList(colList);
        printData.setAssetData(data);
        print(printData);
    }

    /**
     * @Description:生成资产标签图片
     * @param type
     * @param data
     */
    public static  BufferedImage createAssetPic(String type, String data) {
        BarcodeFormat format = BarcodeFormat.QR_CODE;
        int w = 500;
        int h = 500;
        if ("rwm".equals(type)) {
            format = BarcodeFormat.QR_CODE;
            w = 450;
            h = 450;
        } else if ("txm".equals(type)) {
            format = BarcodeFormat.CODE_128;
            h = 180;
            w = 450;
        }
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(data, format, w, h);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        BufferedImage buffImg = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return buffImg;
    }

    public static boolean print(AssetLabelPrint print){
        try {

            String path = System.getProperty("java.io.tmpdir");
            List<Map<String, Object>> assetList=print.getAssetData();
            List<AssetLabelCol> colList=print.getAssetColumnList();
            String pdfFileName =path +File.separator+ print.getUuid()+".pdf";
            Logger.info("pdf out file path:"+pdfFileName);
            PdfDocument pdf = new PdfDocument(new PdfWriter(pdfFileName));
            //字体设置
            PdfFont KeyFont=null;
            PdfFont valueFont=null;
            String workDir=System.getProperty("user.dir");
            String fontPath=workDir+File.separator+"bin"+File.separator+"simhei.ttf";
            File file = new File(fontPath);

            if(file.exists()){
                Logger.info("pdf Font path:"+fontPath);
                Logger.info("pdf Font:simhei");
                PdfFontFactory.register(fontPath,"SIM_HEI");
                KeyFont =PdfFontFactory.createRegisteredFont("SIM_HEI",PdfEncodings.IDENTITY_H);
                valueFont =PdfFontFactory.createRegisteredFont("SIM_HEI",PdfEncodings.IDENTITY_H);
            }else{
                Logger.info("pdf Font path:"+fontPath+" not exist!");
                Logger.info("pdf Font:STSong");
                KeyFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");
                valueFont =PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");
            }
            PageSize pageSize =PageSize.A4;
            Float tableWidth=print.getCurTableWidth()*print.getPointPerMM();
            Float tableKeyWidth=tableWidth*0.3f;
            Float tableValueWidth=tableWidth-tableKeyWidth;
            Document document = new Document(pdf, pageSize);

            Logger.info("print point 40 value:"+ UnitValue.createPointValue(40));
            Logger.info("print Page:"+PageSize.A4);
            Logger.info("print Page Type:"+print.getPaperType());
            Logger.info("print Page width:"+pageSize.getWidth());
            Logger.info("print Page height:"+pageSize.getHeight());
            Logger.info("print Page columnNumber:"+print.getPrintColumnNumber());
            Logger.info("print Table allowMaxWidth(mm):"+print.getMaxTableWidth());
            Logger.info("print Table width(pt):"+tableWidth);
           // Logger.info("print Table tableMarginLeft(mm):"+print.getTableMarginLeftMM());
           // Logger.info("print Table tableMarginRight(mm):"+print.getTableMarginRightMM());
            Logger.info("print Table keyWidth(pt):"+tableKeyWidth);
            Logger.info("print Table valueWidth(pt):"+tableValueWidth);
            Logger.info("print Image show:"+print.getLabelTpl().getImageShow());
            Logger.info("print Image type:"+print.getLabelTpl().getImageType());
            Logger.info("print Image position:"+print.getLabelTpl().getImagePosition());
            String imageType=print.getLabelTpl().getImageType();
            Div div = new Div();
            div.setKeepTogether(true);
            div.setWidth(UnitValue.createPercentValue(100));
            div.setHorizontalAlignment(HorizontalAlignment.CENTER);
            div.setVerticalAlignment(VerticalAlignment.MIDDLE);
          //  div.setBackgroundColor(ColorConstants.GREEN);
            Paragraph paragraph=null;
            if(assetList!=null){
                Logger.info("print asset label number:"+assetList.size());
                for(int i=0;i<assetList.size();i++){
                    Map<String, Object> asset=assetList.get(i);
                    String assetId=asset.getOrDefault("id","none").toString();
                    String assetCode=asset.getOrDefault("assetCode","none").toString();

                    if(i%print.getPrintColumnNumber()==0){
                        if(paragraph!=null){
                            div.add(paragraph);
                        }
                        paragraph = new Paragraph();
                  //      paragraph.setBackgroundColor(ColorConstants.YELLOW);
                        paragraph.setTextAlignment(TextAlignment.CENTER);
                        paragraph.setHorizontalAlignment(HorizontalAlignment.CENTER);
                        paragraph.setVerticalAlignment(VerticalAlignment.MIDDLE);
                    }

                    Table table = new Table(print.getTableColumnNumber());
                    table.setFixedLayout();
                    table.setKeepTogether(true);
                    table.setMarginLeft(print.getPointByMM(print.getTableMarginLeftMM()));
                    table.setMarginRight(print.getPointByMM(print.getTableMarginLeftMM()));
                    table.setBorder(new SolidBorder(ColorConstants.BLACK, 2) );
                    table.setWidth(UnitValue.createPointValue(tableWidth));
              //      table.setBackgroundColor(ColorConstants.RED);
                    //图像
                    BufferedImage buffImg=createAssetPic(imageType, assetCode);
                    File imageFile = new File(path + assetId+".jpg");

                    /////////////////图像生成开始
                    ImageIO.write(buffImg,"jpg",imageFile);
                    Image img=new Image(ImageDataFactory.create(path + assetId+".jpg"));
                    if("rwm".equals(imageType)){
                        img.setHeight(50);
                        img.setWidth(50);
                    }else{
                        img.setHeight(25);
                        img.setWidth(UnitValue.createPointValue(tableWidth*0.7f));
                    }

                 //   img.setBackgroundColor(ColorConstants.YELLOW);
                    img.setMargins(0,0,0,0);
                    img.setPaddings(0,0,0,0);
                    Paragraph imgGaragraph = new Paragraph();
                    imgGaragraph.setMargins(3,0,3,0);
                    imgGaragraph.setPaddings(0,0,0,0);
                 //   imgGaragraph.setBackgroundColor(ColorConstants.RED);
                    imgGaragraph.add(img);
                    Cell imageCell= new Cell(1,2)
                               .setTextAlignment(TextAlignment.CENTER)
                            .setHorizontalAlignment(HorizontalAlignment.CENTER).setWidth(UnitValue.createPercentValue(100))
                            .setVerticalAlignment(VerticalAlignment.MIDDLE).add(imgGaragraph);
                    imageCell.setBorderBottom(Border.NO_BORDER)
                            .setBorderLeft(Border.NO_BORDER)
                            .setBorderRight(Border.NO_BORDER)
                            .setBorderTop(Border.NO_BORDER);

                    Cell imageLabelCell= new Cell(1,2)
                            .add(new Paragraph(assetCode+"-"+i)
                                    .setFont(valueFont).setFontSize(print.getFontSizeImageInfo()).setWidth(UnitValue.createPercentValue(100)).setTextAlignment(TextAlignment.CENTER));
                    imageLabelCell.setBorderBottom(Border.NO_BORDER)
                            .setBorderLeft(Border.NO_BORDER)
                            .setBorderRight(Border.NO_BORDER)
                            .setBorderTop(Border.NO_BORDER);

                    /////////////////图像生产结束
                    //图像
                    if("1".equals(print.getLabelTpl().getImageShow()) &&"u".equals(print.getLabelTpl().getImagePosition())){
                            table.addCell(imageCell);
                        if("1".equals(print.getLabelTpl().getImageLabelShow())){
                            table.addCell(imageLabelCell);
                        }
                    }

                    //表字段
                    for(AssetLabelCol col:colList){
                        Paragraph vK=new Paragraph(col.getColName())
                                .setFont(KeyFont)
                                .setFontSize(print.getFontSizeValue());
                        vK.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);

                        Cell keyCell=new Cell().add(vK)
                                .setWidth(UnitValue.createPointValue(tableKeyWidth))
                                .setTextAlignment(TextAlignment.LEFT);
                        keyCell.setMaxWidth(UnitValue.createPointValue(tableKeyWidth));
                 //       keyCell.setBackgroundColor(ColorConstants.GRAY);
                        keyCell.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);

                        keyCell.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);

                        Paragraph vP=new Paragraph(asset.getOrDefault(col.getColValue(),"").toString())
                                .setFont(valueFont)
                                .setFontSize(print.getFontSizeValue()).setWidth(UnitValue.createPointValue(tableValueWidth))
                                .setTextAlignment(TextAlignment.LEFT);;
         //               vP.setBackgroundColor(ColorConstants.GREEN);
                        vP.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
                        Cell valueCell=new Cell().add(vP)
                                .setFontSize(print.getFontSizeValue())
                                .setWidth(UnitValue.createPointValue(tableValueWidth))
                                .setTextAlignment(TextAlignment.LEFT);

                        vP.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
                      //  Logger.info("keyCell.getWidth()"+keyCell.getWidth());
                      //  Logger.info("valueCell.getWidth()"+valueCell.getWidth());
                        table.addCell(keyCell);
                        table.addCell(valueCell);
                    }

                    //图像
                    if("1".equals(print.getLabelTpl().getImageShow()) &&"d".equals(print.getLabelTpl().getImagePosition())){
                        table.addCell(imageCell);
                        if("1".equals(print.getLabelTpl().getImageLabelShow())){
                           table.addCell(imageLabelCell);
                        }
                    }
                //    paragraph.setProperty(Property.OVERFLOW_X, OverflowPropertyValue.VISIBLE);
                    paragraph.add(table);
                }
            }
            if(paragraph!=null){
                div.add(paragraph);
            }
            document.add(div);
            document.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
