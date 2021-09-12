package com.dt.platform.framework.datasource;

import com.github.foxnic.commons.encrypt.AESUtil;
import com.github.foxnic.commons.io.FileUtil;

import java.io.File;

public class EncryptUtil {

    public static void main(String[] args) {
        String passwd= FileUtil.readText(new File("/tmp/foxnic/passwd.txt"));
        AESUtil aes=new AESUtil(passwd);
        String user="root";
        String pwd="11111";
        String url="jdbc:mysql://39.105.191.22:3306/eam?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&allowPublicKeyRetrieval=true&tinyInt1isBit=false";
        String url2="jdbc:mysql://39.105.191.22:3306/eam?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&allowPublicKeyRetrieval=true&tinyInt1isBit=false";
        user=aes.encryptData(user);
        pwd=aes.encryptData(pwd);
        url=aes.encryptData(url);
        url2=aes.encryptData(url2);
        System.out.println("user = "+user);
        System.out.println("pwd = "+pwd);
        System.out.println("url = "+url);
        System.out.println("url2 = "+url2);
    }

}
