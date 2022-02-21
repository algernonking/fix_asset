package com.dt.platform.ops.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemCommandExecutor {
    private final static int BUFFER_SIZE=1024;
    private final static String DEFAULT_ENCODING="gbk";
    private static class ProcessWorker extends Thread{
        private Process process;
        private volatile int exitCode=-99;
        private volatile boolean completed=false;
        private volatile  String output="";
        private ProcessWorker(Process p){
            this.process=p;

        }

        @Override
        public void run(){
            try(InputStreamReader reader=new InputStreamReader(process.getInputStream(),DEFAULT_ENCODING)){
                StringBuilder log=new StringBuilder();
                char[] buffer=new char[BUFFER_SIZE];
                int length;
                while((length= reader.read(buffer))!=-1){
                    log.append(buffer,0,length);
                }
                output=log.toString();
                exitCode=0;
                completed=true;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        public int getExitCode(){
            return exitCode;
        }

        public String getOutput(){
            return output;
        }

        public boolean isCompleted(){
            return completed;
        }
    }

    public static SystemCommandtResult exeCmd(String command,int timeoutSecond){

        StringBuilder log=new StringBuilder();
//        String[] cmdArr=command.split(" ");
//        for(int i=0;i< cmdArr.length;i++){
//            System.out.println(cmdArr[i]+i);
//        }
        //System.out.println(command);
        ProcessBuilder processBuilder=new ProcessBuilder(command.split(" "));
        processBuilder.redirectErrorStream(true);
        Process process= null;
        int exitCode=99;
        try {
          //  process = Runtime.getRuntime().exec(command);
            process = processBuilder.start();
            ProcessWorker processWorker=new ProcessWorker(process);
            exitCode=processWorker.getExitCode();
            processWorker.start();
            processWorker.join(timeoutSecond*1000);
            if(processWorker.isCompleted()){
                log.append(processWorker.getOutput());
                exitCode=processWorker.getExitCode();
            }else {
                process.destroy();
                processWorker.interrupt();
                exitCode=-99;
                log.append("执行时间超时");
               // throw new TimeoutException("执行时间超时");
            }
        } catch (InterruptedException|IOException e) {
            log.append(e.getMessage());
            e.printStackTrace();
        }
        return SystemCommandtResult.setData(exitCode,log.toString());
    }

    public static void main(String[] args) {
       //SystemCommandExecutor.exeCmd("/usr/local/bin/zabbix_get -s 121.43.103.102 -p 10050 -k vfs.file.contents[/etc/passwd] | awk '{print $1}'",2000).print();
       //SystemCommandExecutor.exeCmd("/usr/local/bin/zabbix_get -s 121.43.103.102 -p 10050 -k vfs.file.size[/etc/passwd]",2000).print();
      //  SystemCommandExecutor.exeCmd("ping baidu.com",2000).print();
        String ass="system.cpu.util[all,user,avg1]|system.cpu.util[all,system,avg1]|system.cpu.util[all,iowait,avg1]|system.cpu.util[all,idle,avg1]";


        String[] as =ass.split("\\|")
                ;
        System.out.println(as.length);
        for(int i=0;i<as.length;i++){
            System.out.println(as[i]);
        }

        String a="1645361756";
        int aa= Integer.parseInt(a);
        Date date = new java.util.Date(aa*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        String formattedDate = sdf.format(date);
        System.out.println(formattedDate);
//        String a="abcdef";
//        System.out.println(a.replaceAll("a","1"));
//        System.out.println(a.replaceAll("b","1"));
      //  SystemCommandExecutor.exeCmd("zabbix_get",2000).print();
    }

}
