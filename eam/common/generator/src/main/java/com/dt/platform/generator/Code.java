package com.dt.platform.generator;

import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Code {
    public static void main(String[] args) throws Exception {
        Code c=new Code();
        c.test();
    }

    /**
     * 测试
     * */
    private void test(){
        System.out.println(parseCode("${string_fix,CODE}"));
        System.out.println(parseCode("${string_fix,CODE}${time,yyyy}${time,mm}${time,dd}${string_fix,-}${number_rand,5}"));
        System.out.println(parsePlaceholder("{time,yyyy}"));
        System.out.println(parsePlaceholder("{time,mm}"));
        System.out.println(parsePlaceholder("{time,dd}"));
        System.out.println(parsePlaceholder("{time,hh}"));
        System.out.println(parsePlaceholder("{time,mm}"));
        System.out.println(parsePlaceholder("{time,ss}"));
        System.out.println(parsePlaceholder("{string_fix,AS}"));
        System.out.println(parsePlaceholder("{string_fix,-}"));
        System.out.println(parsePlaceholder("{string_fix,/}"));
        System.out.println(parsePlaceholder("{string_rand,5}"));
        System.out.println(parsePlaceholder("{number_seq,5,asset}"));
        System.out.println(parsePlaceholder("{number_seq,0,asset}"));
        System.out.println("1-"+parsePlaceholder("{number_rand,1}"));
        System.out.println(parsePlaceholder("{number_rand,2}"));
        System.out.println(parsePlaceholder("{number_rand,3}"));
        System.out.println(parsePlaceholder("{number_rand,5}"));
        System.out.println(parsePlaceholder("{number_rand,8}"));
        System.out.println(parsePlaceholder("{number_rand}"));
    }


    /**
     * 生成编码
     * @param ph 传入占位符
     * @return 返回编号
     * */
    public String parseCode(String ph){
        if (ph==null){
            return null;
        }
        String result="";
        String[] pharr=ph.split("\\$");
        for(int i=0;i< pharr.length;i++){
            if(i>0){
                result=result+parsePlaceholder(pharr[i]);
            }
        }
        return result;
    }

    /**
     * 解析占位符编码
     * @param ph 传入占位符
     * @return 返回编号
     * */
    private String parsePlaceholder(String ph){
        if(ph==null){
            return "";
        }
        String type=ph.replaceAll("\\{","").replaceAll("\\}","").split(",")[0];
        if(type.equals(CodeAttrTypeEnum.TIME.code())){
            return parseTime(ph);
        }else if (type.equals(CodeAttrTypeEnum.STRING_FIX.code())){
            return parseStringFix(ph);
        }else if (type.equals(CodeAttrTypeEnum.STRING_RAND.code())){
            return parseStringRand(ph);
        }else if (type.equals(CodeAttrTypeEnum.NUMBER_RAND.code())){
            return parseNumberRand(ph);
        }else if (type.equals(CodeAttrTypeEnum.NUMBER_SEQ.code())){
            return parseNumberSeq(ph);
        }else if (type.equals(CodeAttrTypeEnum.ORG.code())){
           return "";
        }
        return null;
    }

    /**
     * 解析时间占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    private String parseTime(String ph){
        String timeNow = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(Calendar.getInstance().getTime());
        String [] timeArr=timeNow.split("-");
        String year=timeArr[0];
        String month=timeArr[1];
        String day=timeArr[2];
        String hour=timeArr[3];
        String mins=timeArr[4];
        String second=timeArr[4];
        if(ph==null){
            return "";
        }
        return ph.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",yyyy\\}",year)
                .replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",mm\\}",month)
                .replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",dd\\}",day)
                .replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",hh\\}",hour)
                .replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",mm\\}",mins)
                .replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",ss\\}",second);
    }

    /**
     * 解析字符串占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    private String parseStringFix(String ph){
        if(ph==null){
            return "";
        }
        return ph.replaceAll("\\{"+CodeAttrTypeEnum.STRING_FIX.code() +",","")
                .replaceAll("\\}","").trim();
    }

    /**
     * 按照指定长度生成字符串
     * @param length 长度
     * @return 返回随时资产负债
     * */
    private  String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 解析字符串占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    private String parseStringRand(String ph){
        int phLength=1;
        String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
        if(attr.length>=2){
            phLength=Integer.valueOf(attr[1]);
        }
        return getRandomString(phLength).toUpperCase();
    }

    /**
     * 解析数字类型占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    private String parseNumberRand(String ph){
        int phLength=1;
        String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
        if(attr.length>=2){
            phLength=Integer.valueOf(attr[1]);
        }
        return String.valueOf((int)((Math.random()*9+1)*Math.pow(10,phLength-1)));
    }

    /**
     * 解析数字类型占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    private String parseNumberSeq(String ph){
        String seqSource="default";
        int phLength=0;
        String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
        for(int i=0;i<attr.length;i++){
            if(i==1){
                phLength=Integer.valueOf(attr[i]);
            }else if(i==2){
                seqSource=attr[i];
            }
        }
        return "";
    }
}
