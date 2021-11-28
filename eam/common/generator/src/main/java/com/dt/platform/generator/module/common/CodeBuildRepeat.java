package com.dt.platform.generator.module.common;

import java.lang.reflect.Method;

public class CodeBuildRepeat {

    public static void main(String[] args) throws Exception {
        String pstr="com.dt.platform.generator.module.common";
        String[] clasnamearr={
//                "SysTplFileGtr",
//                "SysCodeRegisterGtr",
//                "SysCodeAllocationGtr",
//                "SysCodeAttrGtr",
//                "SysCodeRuleGtr"
        };
        for(int i=0;i<clasnamearr.length;i++){
            System.out.println("invoke clsss:"+clasnamearr[i]);
            try{
                System.out.println(1);
                Class clazz=Class.forName(pstr+"."+clasnamearr[i]);
                System.out.println(2);
                Method method=clazz.getMethod("generateCode");
                System.out.println(3);
                System.out.println("333"+clazz.newInstance()+method.getName());
                System.out.println("result:"+method.invoke(clazz.newInstance()));
                System.out.println(4);
            }catch(Exception e){
                System.err.println(clasnamearr[i]+"这个类真的不存在!"+e.getMessage());
            }
            System.out.println("------------------------invoke finish------------------------");
        }
    }
}
