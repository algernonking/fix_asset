package com.dt.platform.ops.service.impl;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.dt.platform.constants.enums.ops.*;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.domain.system.Config;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.proxy.system.ConfigServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("MonitorDataProcessZabbixAgentService")
public class MonitorDataProcessZabbixAgentServiceImpl implements IMonitorDataProcessZabbixAgentService {


    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }


    @Autowired
    private IMonitorNodeService monitorNodeService;

    @Autowired
    private IMonitorTplService monitorTplService;

    @Autowired
    private IMonitorNodeValueService monitorNodeValueService;

    @Autowired
    private IMonitorTplIndicatorService monitorTplIndicatorService;

    private String MONITOR_METHOD=MonitorMethodEnum.ZABBIX_AGENT.code();


    @Autowired
    private MonitorDataProcessBaseServiceImpl monitorDataProcessBaseService;

    @Override
    public Result collectData() {
        List<MonitorNode> nodeList=monitorDataProcessBaseService.queryExecuteNodeList(MONITOR_METHOD);
        Logger.info("collectData,find nodes number:"+nodeList.size());

        // 创建 ForkJoin 工具，其中 输入一个 Integer 元素的 List ，输出 Long 元素的 List ，每个线程处理 若干元素 ，此处为 5 个
        SimpleJoinForkTask<MonitorNode,Result> task=new SimpleJoinForkTask<>(nodeList,3);
        // 并行执行
        List<Result> rvs=task.execute(els->{
            // 打印当前线程信息
            System.out.println(Thread.currentThread().getName());
            // 处理当前分到的 若干元素，此处为 5 个
            List<Result> rs=new ArrayList<>();
            for (MonitorNode node : els) {
                Result result=collectNodeData(node);
                if(!result.isSuccess()){
                    Logger.info("node ip:"+node.getNodeIp()+",message"+result.getMessage());
                }
                rs.add(result);
            }
            // 处理完毕，返回本批次的处理结果，由 SimpleJoinForkTask 负责合并全部结果，并由 rvs 变量接收
            return rs;
        });
        return ErrorDesc.success();
    }



    public Result collectNodeData(MonitorNode node) {

        String ip=node.getNodeIp();
        int zabbix_port=node.getZabbixAgengPort();

        if(StringUtil.isBlank(zabbix_port+"")){
            return ErrorDesc.failure().message("主机Zabbix代理端口("+zabbix_port+")端口不存在");
        }

        if(zabbix_port<1024||zabbix_port>20000){
            return ErrorDesc.failure().message("主机Zabbix代理端口("+zabbix_port+")端口设置不正确");
        }

        if(StringUtil.isBlank(ip+"")){
            return ErrorDesc.failure().message("主机("+ip+")不存在");
        }

        //获取指标
        List<MonitorTplIndicator> monitorTplIndicatorList=monitorDataProcessBaseService.queryExecuteIndicatorList(node.getId(),MONITOR_METHOD);
        Logger.info("method:"+this.MONITOR_METHOD+",collectData,process node:"+node.getId()+",ip:"+node.getNodeIp()+",find indicator number:"+monitorTplIndicatorList.size());
        List<Insert> list=executeScriptSingle(monitorTplIndicatorList,node);
        //开始执行insert
        if(list.size()>0){
            monitorDataProcessBaseService.executeCollectDataInsert(list);
        }
        return ErrorDesc.success();

    }

    private String getZabbixGetExe(){
        Result<Config> configResult= ConfigServiceProxy.api().getById("ops.monitorZabbixGetRoute");
        Config config=configResult.getData();
        if(config==null){
            return "";
        }
        return config.getValue();
    }

    private RemoteZabbixAgentResult executeZabbixAgentCommand(MonitorNode node,MonitorTplIndicator tplIndicator){
        //逗号间隔
        String cmd=tplIndicator.getCommand();
        String ip=node.getNodeIp();
        String port=node.getZabbixAgengPort()+"";
        String cmdExe=getZabbixGetExe();
        if(StringUtil.isBlank(cmdExe)){
            Logger.info("ip:"+ip+",没有找到zabbix_get");
            return RemoteZabbixAgentResult.setData(99, "没有找到zabbix_get");
        }
        if(StringUtil.isBlank(cmd)){
            Logger.info("ip:"+ip+",Command 为空");
            return RemoteZabbixAgentResult.setData(99, "没有找到Command");
        }
        String result="";

        if(MonitorIndicatorValueColumnColsEnum.MULTIPLE.code().equals(tplIndicator.getValueColumnCols())
                &&MonitorIndicatorValueColumnRowsEnum.SINGLE.code().equals(tplIndicator.getValueColumnRows())){
            String[] cmdArr=cmd.split("\\|");
            for(int i=0;i<cmdArr.length;i++){
                RemoteZabbixAgentResult res=executeZabbixAgentCommandSingle(node,cmdArr[i],tplIndicator.getIndicatorVariable());
                if(res.code!=0){
                    return res;
                }
                if(i==0){
                    result=res.result;
                }else{
                    result=result+","+res.result;
                }
            }
        }else{
          return executeZabbixAgentCommandSingle(node,tplIndicator.getCommand(),tplIndicator.getIndicatorVariable());
        }

        int code=0;
        if(MonitorZabbixAgentIndicatorEnum.SYSTEM_CONNECTED.code().equals(tplIndicator.getCode())){

        }

        return RemoteZabbixAgentResult.setData(code, result);
    }


    private RemoteZabbixAgentResult executeZabbixAgentCommandSingle(MonitorNode node,String command,String cmdVar){
        //逗号间隔
        String cmd=monitorDataProcessBaseService.queryIndicatorCommand(node,command,cmdVar);
        String cmdExe=getZabbixGetExe();
        String ip=node.getNodeIp();
        String port=node.getZabbixAgengPort()+"";
        if(StringUtil.isBlank(cmdExe)){
            Logger.info("ip:"+ip+",没有找到zabbix_get");
            return RemoteZabbixAgentResult.setData(99, "没有找到zabbix_get");
        }
        if(StringUtil.isBlank(cmd)){
            Logger.info("ip:"+ip+",Command 为空");
            return RemoteZabbixAgentResult.setData(99, "没有找到Command");
        }

        String exeCommand=cmdExe.trim()+" -s "+ip+" -p "+port+" -k "+cmd.trim();
        Logger.info("execute zabbix agent,command:"+exeCommand);
        SystemCommandtResult r=SystemCommandExecutor.exeCmd(exeCommand,30);
        if(r.code==0){
            if(MonitorZabbixAgentItemKeyValueEnum.SYSTEM_LOCALTIME_UTC.code().equals(cmd.trim())){
                String unixTime=r.result.replaceAll("\n","".trim());
                int unixTimeInt= Integer.parseInt(unixTime);
                Date date = new java.util.Date(unixTimeInt*1000L);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                r.result= sdf.format(date);
            } if(MonitorZabbixAgentItemKeyValueEnum.VFS_FS_GET.code().equals(cmd.trim())){


            }
        }
        return RemoteZabbixAgentResult.setData(r.code, r.result);
    }


    private List<Insert> executeScriptSingle(List<MonitorTplIndicator> monitorTplIndicatorList,MonitorNode node){
        List<Insert> insList=new ArrayList<>();
        for(MonitorTplIndicator tplIndicator:monitorTplIndicatorList){
            if(!MonitorMethodEnum.ZABBIX_AGENT.code().equals(tplIndicator.getMonitorMethod())){
                continue;
            }
            //获取一个指标的执行结果
            Logger.info("tplIndicator tpl:"+tplIndicator.getMonitorTplCode()+",tplIndicator code:"+tplIndicator.getCode()+",execute command:"+tplIndicator.getCommand());
            RemoteZabbixAgentResult executeResult = executeZabbixAgentCommand(node,tplIndicator);
            Logger.info("executeCode:"+executeResult.code+",executeResult:"+executeResult.result);
            if(executeResult.code==0){
                //执行结果
                String content=executeResult.result;
                //转换成insert语句
                Result<Object> insertResult=monitorDataProcessBaseService.convertToInsertData(tplIndicator,content,node);
                if(insertResult.isSuccess()){
                    List<Insert> nodeInsList=(List<Insert>)insertResult.getData();
                    if(nodeInsList.size()>0){
                        insList.addAll(nodeInsList);
                    }
                }
            }else{
                List<Insert> nodeInsList=new ArrayList<>();
                Insert errInsert=new Insert("ops_monitor_node_value");
                errInsert.set("id", IDGenerator.getSnowflakeId());
                errInsert.setIf("result_status","failed");
                errInsert.setIf("result_message",executeResult.result);
                errInsert.setIf("indicator_code",tplIndicator.getCode());
                errInsert.setIf("node_id",node.getId());
                errInsert.setIf("is_connected",0);
                errInsert.setIf("monitor_tpl_code",tplIndicator.getMonitorTplCode());
                errInsert.setIf("record_time",new Date());
                nodeInsList.add(errInsert);
                insList.addAll(nodeInsList);
            }
        }
        return insList;
    }


    @Override
    public Result clearNodeValueLastHistoryData() {
        return ErrorDesc.success();
    }
}
