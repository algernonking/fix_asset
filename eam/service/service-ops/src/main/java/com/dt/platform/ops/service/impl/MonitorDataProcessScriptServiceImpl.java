package com.dt.platform.ops.service.impl;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.dt.platform.constants.enums.ops.*;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorVoucher;
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

@Service("MonitorDataProcessScriptService")
public class MonitorDataProcessScriptServiceImpl implements IMonitorDataProcessScriptService {



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
    private MonitorDataProcessBaseServiceImpl monitorDataProcessBaseService;

    private String MONITOR_METHOD=MonitorMethodEnum.SCRIPT.code();


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

    @Override
    public Result clearNodeValueLastHistoryData() {
        String sql1="delete from ops_monitor_node_value_last where record_time<date_sub(now(), interval 1 day) ";
        String sql2="delete from ops_monitor_node_value_last where id in (\n" +
                "select id from (\n" +
                "select \n" +
                "(\n" +
                "select max_record_time from (\n" +
                "select node_id,monitor_tpl_code,indicator_code,max(record_time) max_record_time from ops_monitor_node_value_last b  group by node_id,monitor_tpl_code,indicator_code\n" +
                ") e1 where e1.node_id=a.node_id and e1.monitor_tpl_code=a.monitor_tpl_code and e1.indicator_code=a.indicator_code\n" +
                ") max_record_time,\n" +
                "a.*\n" +
                "from ops_monitor_node_value_last a )end where  end.record_time<end.max_record_time)";
        dao.execute(sql1);
        dao.execute(sql2);
        return ErrorDesc.success();
    }

    public Result collectNodeData(MonitorNode node) {

        String ip=node.getNodeIp();
        int sshPort=node.getSshPort();
        monitorNodeService.dao().fill(node)
                .with(MonitorNodeMeta.SSH_VOUCHER)
                .execute();
        MonitorVoucher monitorVoucher=node.getSshVoucher();
        if(monitorVoucher==null){
            return ErrorDesc.failure().message("主机("+ip+")凭证不存在");
        }
        String account=monitorVoucher.getAccount();
        String voucher=monitorVoucher.getVoucher();

        if(StringUtil.isBlank(account)){
            return ErrorDesc.failure().message("主机("+ip+")凭证用户不存在");
        }
        if(StringUtil.isBlank(voucher)){
            return ErrorDesc.failure().message("主机("+ip+")凭证数据不存在");
        }
        if(StringUtil.isBlank(ip+"")){
            return ErrorDesc.failure().message("主机("+ip+")不存在");
        }

        //获取指标
        List<MonitorTplIndicator> monitorTplIndicatorList=monitorDataProcessBaseService.queryExecuteIndicatorList(node.getId(),MONITOR_METHOD);
        Logger.info("method:"+this.MONITOR_METHOD+",collectData,process node:"+node.getId()+",ip:"+node.getNodeIp()+",find indicator number:"+monitorTplIndicatorList.size());
        List<Insert> list=executeScriptSingle(monitorTplIndicatorList,node,account,voucher,sshPort);
        //开始执行insert
        if(list.size()>0){
            monitorDataProcessBaseService.executeCollectDataInsert(list);
        }
        return ErrorDesc.success();

    }

    private List<Insert> executeScriptSingle(List<MonitorTplIndicator> monitorTplIndicatorList,MonitorNode node,String account,String voucher,int sshPort){
        List<Insert> insList=new ArrayList<>();
        RemoteShellExecutor rmt=new RemoteShellExecutor(node.getNodeIp(),account,voucher,sshPort);
        for(MonitorTplIndicator tplIndicator:monitorTplIndicatorList){
            if(!MonitorMethodEnum.SCRIPT.code().equals(tplIndicator.getMonitorMethod())){
                continue;
            }
            String command=monitorDataProcessBaseService.queryIndicatorCommand(node,tplIndicator.getCommand(),tplIndicator.getIndicatorVariable());
            //获取一个指标的执行结果
            Logger.info("tplIndicator tpl:"+tplIndicator.getMonitorTplCode()+",tplIndicator code:"+tplIndicator.getCode()+",execute command:"+command);
            RemoteShellResult executeResult=null;
            if(StringUtil.isBlank(command)){
                executeResult=RemoteShellResult.setData( 1,"执行内容不能为空");
            }else{
                executeResult = rmt.exec(command);
            }
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
              errInsert.set("id",IDGenerator.getSnowflakeId());
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






}
