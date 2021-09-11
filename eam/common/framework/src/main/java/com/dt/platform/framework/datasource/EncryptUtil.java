package com.dt.platform.framework.datasource;

import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.io.FileUtil;

import java.io.File;

public class EncryptUtil {

    public static void main(String[] args) {
        String passwd= FileUtil.readText(new File("d:/foxnic/encrypt.txt"));
        AESUtil aes=new AESUtil(passwd);
        String user="root";
        String pwd="rxoxoxt_pxwxd";
        String url="jdbc:mysql://39.105.191.22:3306/eam?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&allowPublicKeyRetrieval=true&tinyInt1isBit=false";
        user=aes.encryptData(user);
        pwd=aes.encryptData(pwd);
        url=aes.encryptData(url);

        System.out.println("user = "+user);
        System.out.println("pwd = "+pwd);
        System.out.println("url = "+url);
    }

}
