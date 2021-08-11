package com.dt.platform.generator.module.eam;

import java.lang.reflect.Method;

public class CodeBuildRepeat {

    public static void main(String[] args) throws Exception {
        String pstr="com.dt.platform.generator.module.eam";
        String[] clasnamearr={
                "BrandGtr",
                "EamAreaGtr",
                "EamGoodsGtr",
                "EamMaintainerGtr",
                "EamManufacturerGtr",
                "EamResidualStrategyGtr",
                "EamSupplierGtr",
                "EamWarehouseGtr"
        };
        for(int i=0;i<clasnamearr.length;i++){
            System.out.println("invoke clsss:"+clasnamearr[i]);
            try{
                Class clazz=Class.forName(pstr+"."+clasnamearr[i]);
                Method method=clazz.getMethod("generateCode");
                method.invoke(clazz.newInstance());
            }catch(Exception e){
                System.out.println("这个类真的不存在!");
            }
            System.out.println("------------------------invoke finish------------------------");
        }
    }
}