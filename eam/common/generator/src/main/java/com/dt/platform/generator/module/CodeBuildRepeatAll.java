package com.dt.platform.generator.module;

import java.lang.reflect.Method;

public class CodeBuildRepeatAll {


    public static void main(String[] args) throws Exception {

        String[] clasnamearr={
                "com.dt.platform.generator.module.common.CodeBuildRepeat",
                "com.dt.platform.generator.module.dc.CodeBuildRepeat",
                "com.dt.platform.generator.module.eam.CodeBuildRepeat",
                "com.dt.platform.generator.module.ops.CodeBuildRepeat",
                "com.dt.platform.generator.module.kn.CodeBuildRepeat",
                "com.dt.platform.generator.module.contract.CodeBuildRepeat"
        };
        String [] pars={"1"};
        for(int i=0;i<clasnamearr.length;i++){
            System.out.println("invoke clsss:"+clasnamearr[i]);
            try{
                Class clazz=Class.forName(clasnamearr[i]);
                Method method=clazz.getMethod("main",String[].class);
                method.invoke(null,(Object)pars);
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(clasnamearr[i]+"######这个类真的不存在!##########");
            }

        }
    }


}
