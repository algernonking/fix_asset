package com.dt.platform.generator;



public class Demo {

    public static void main(String[] args) throws Exception {
        String v=" ${seq,5,asset}${asf}";
// 		g.generateEamGoodsConfig();
// 		g.generateEamMaintainerConfig();
// 		g.generateEamManufacturerConfig();

        String [] a=v.split("\\$");

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println();
    }






}

