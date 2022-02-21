package com.dt.platform.ops.service.impl;


/**
 * @author: algernonking
 * @date: 2017年12月25日 下午9:58:55
 * @Description: TODO
 */
public class RemoteZabbixAgentResult {

    public int code;
    public String result ="";
    public static RemoteZabbixAgentResult setData(int code, String result) {
        RemoteZabbixAgentResult res = new RemoteZabbixAgentResult();
        res.result = result;
        res.code = code;
        return res;
    }
    public void print() {
        System.out.print("code:" + code+",result:\n" + result+"\n");
    }

}