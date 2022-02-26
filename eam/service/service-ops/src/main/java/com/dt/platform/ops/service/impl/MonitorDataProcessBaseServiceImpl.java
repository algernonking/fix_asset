package com.dt.platform.ops.service.impl;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

@Service("MonitorDataProcessBaseService")
public class MonitorDataProcessBaseServiceImpl implements IMonitorDataProcessBaseService {


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
    private IMonitorTplIndicatorService monitorTplIndicatorService;

    public static String NODE_VALUE_COLUMN_COLS_SPLIT=",";

    public static String findExecuteDataSql="select * from (\n" +
            "select t1.*,ifnull(t2.interval_time,100000000) e_interval_time from (\n" +
            "select a.id,c.monitor_tpl_code,c.code,c.interval_time,c.id indicator_id from\n" +
            "ops_monitor_node a,ops_monitor_node_tpl_item b,ops_monitor_tpl_indicator c\n" +
            "where a.deleted='0' \n" +
           // "and a.status='online' \n" +
            "and a.node_enabled='enable' \n"+
            "and b.deleted='0' \n" +
            "and c.deleted='0' \n" +
            "and c.status='enable' \n" +
            "and c.monitor_method='#<MONITOR_METHOD>#' \n" +
            "and a.id=b.node_id \n" +
            "and b.tpl_code=c.monitor_tpl_code)t1\n" +
            "left join \n" +
            "(select node_id,monitor_tpl_code,indicator_code,UNIX_TIMESTAMP(now())-UNIX_TIMESTAMP(max(record_time)) interval_time\n" +
            "from ops_monitor_node_value_last \n" +
            "group by node_id,monitor_tpl_code,indicator_code)t2 \n" +
            "on t1.id=t2.node_id and t1.monitor_tpl_code=t2.monitor_tpl_code and t1.code=t2.indicator_code \n" +
            ") end where e_interval_time>interval_time ";


    @Override
    public Result<JSONArray> queryNodeZabbixAgentData() {
        Result<JSONArray> result=new Result<>();
        String sql="select \n" +
                "a.node_ip,\n" +
                "a.node_name_show,\n" +
                "b.indicator_code indicator_code,\n" +
                "b.value_str1 zabbix_agent_version,\n" +
                "b.record_time record_time\n" +
                "from (\n" +
                "select * from ops_monitor_node where id in (select node_id from ops_monitor_node_tpl_item where tpl_code='tpl_zabbix_agent')\n" +
                ")a\n" +
                "left join \n" +
                "( \n" +
                "select * from ops_monitor_node_value_last where (node_id,indicator_code,record_time)in (\n" +
                "select node_id,indicator_code,max(record_time) max_record_time from ops_monitor_node_value_last where indicator_code='zabbixAgent.version' and  result_status='sucess' group by \n" +
                " node_id,indicator_code)\n" +
                " )b on  a.id=b.node_id and a.deleted=0\n" +
                " \n";
        return result.success(true).data(dao.query(sql).toJSONArrayWithJSONObject());
    }

    @Override
    public Insert createBaseInsert(MonitorTplIndicator indicator,MonitorNode node){
        Insert nodeV=new Insert("ops_monitor_node_value");
        nodeV.set("id", IDGenerator.getSnowflakeIdString());
        nodeV.set("monitor_tpl_code",indicator.getMonitorTplCode());
        nodeV.set("indicator_code",indicator.getCode());
        nodeV.set("result_status", MonitorNodeValueResultStatusEnum.SUCESS.code());
        nodeV.set("result_message","执行成功");
        nodeV.set("record_time",new Date());
        nodeV.set("node_id",node.getId());
        return nodeV;
    }


    @Override
    public List<MonitorTplIndicator> queryIndicatorList(String nodeId) {
        String sql="select distinct c.id from ops_monitor_node a,ops_monitor_node_tpl_item b,ops_monitor_tpl_indicator c\n" +
                "where a.deleted='0'\n" +
                "and b.deleted='0'\n" +
                "and c.deleted='0'\n" +
                "and c.status='enable'\n" +
                "and a.id=b.node_id\n" +
                "and b.tpl_code=c.monitor_tpl_code \n" +
                "and c.monitor_method='"+MonitorMethodEnum.SCRIPT.code()+"'";
        if(!StringUtil.isBlank(nodeId)){
            sql=sql+"and a.id='"+nodeId+"'";
        }
        ConditionExpr expr=new ConditionExpr();
        expr.and("id in ("+sql+")" );
        List<MonitorTplIndicator> list=monitorTplIndicatorService.queryList(expr);
        return list;
    }

    @Override
    public String queryIndicatorCommand(MonitorNode node, String cmd,String cmdVar) {
//        String cmd=iplIndicator.getCommand();
//        String cmdVar=iplIndicator.getIndicatorVariable();
        JSONArray cmdArr=JSONArray.parseArray(cmdVar);
        if(cmdArr==null||cmdArr.size()==0){
            return cmd;
        }
        for(int i=0;i<cmdArr.size();i++){
            JSONObject e=cmdArr.getJSONObject(i);
            String key=e.getString("key");
            String value=e.getString("value");
            if(StringUtil.isBlank(key) || StringUtil.isBlank(value)){
                continue;
            }
            String tmp= cmd.replaceAll(key,value);
            cmd=tmp;
        }
        return cmd;
    }

    @Override
    public List<MonitorNode> queryNodeListByMonitorMethod(String monitorMethod) {
        String sql="select distinct a.id from ops_monitor_node a,ops_monitor_node_tpl_item b,ops_monitor_tpl_indicator c\n" +
                "where a.deleted='0'\n" +
                "and b.deleted='0'\n" +
                "and c.deleted='0'\n" +
                "and a.id=b.node_id\n" +
                "and c.status='enable'\n" +
                "and b.tpl_code=c.monitor_tpl_code \n" +
                "and c.monitor_method='"+monitorMethod+"'";
        ConditionExpr expr=new ConditionExpr();
        expr.and(" id in ("+sql+")" );
       // expr.and("status","enable");
        expr.andIf("node_enabled",MonitorEnableEnum.ENABLE.code());
        List<MonitorNode> list=monitorNodeService.queryList(expr);
        return list;
    }

    @Override
    public List<MonitorTpl> queryTplListByMonitorMethod(String monitorMethod) {
        String sql="select distinct b.tpl_code from ops_monitor_node a,ops_monitor_node_tpl_item b,ops_monitor_tpl_indicator c\n" +
                "where a.deleted='0'\n" +
                "and b.deleted='0'\n" +
                "and c.deleted='0'\n" +
                "and c.status='enable'\n" +
                "and a.id=b.node_id\n" +
                "and b.tpl_code=c.monitor_tpl_code \n" +
                "and c.monitor_method='"+monitorMethod+"'";
        ConditionExpr expr=new ConditionExpr();
        expr.and("code in ("+sql+")" );
        List<MonitorTpl> list=monitorTplService.queryList(expr);
        return list;
    }

    @Override
    public Result<List<MonitorTpl>> queryTplListByNodeId(String nodeId) {

        String sql="select distinct b.tpl_code from ops_monitor_node a,ops_monitor_node_tpl_item b,ops_monitor_tpl_indicator c\n" +
                "where a.deleted='0'\n" +
                "and b.deleted='0'\n" +
                "and c.deleted='0'\n" +
                "and c.status='enable'\n" +
                "and a.id=b.node_id\n" +
                "and a.id='"+nodeId+"'\n"+
                "and b.tpl_code=c.monitor_tpl_code \n";
        ConditionExpr expr=new ConditionExpr();
        expr.and("code in ("+sql+")" );
        expr.and("status=?","enable");
        List<MonitorTpl> list=monitorTplService.queryList(expr);
        Result<List<MonitorTpl>> res=new Result<>();
        res.data(list);
        return res;
    }

    @Override
    public Result executeCollectDataInsert(List<Insert> insList) {

        for(Insert insert:insList){
            try{
                dao.execute(insert);
                insert.into("ops_monitor_node_value_last");
                dao.execute(insert);
            }catch(UncategorizedSQLException e){
                Logger.info("Sql execute error,sql:"+insert.getSQL());
                Insert errInsert=new Insert("ops_monitor_node_value");
                errInsert.set("id",insert.getValue("id"));
                errInsert.setIf("result_status","failed");
                errInsert.setIf("result_message","error execute sql");
                errInsert.setIf("indicator_code",insert.getValue("indicator_code"));
                errInsert.setIf("node_id",insert.getValue("node_id"));
                errInsert.setIf("monitor_tpl_code",insert.getValue("monitor_tpl_code"));
                errInsert.setIf("record_time",new Date());
                dao.execute(errInsert);
                errInsert.into("ops_monitor_node_value_last");
                dao.execute(errInsert);
                e.printStackTrace();
            }
        }
        return ErrorDesc.success();
    }


    @Override
    public Result<Object> convertToInsertData(MonitorTplIndicator tplIndicator,String content,MonitorNode node){

        List<Insert> insList=new ArrayList<>();
        List<String> contentList=new ArrayList<>();

        //判断验证
        String errorMsg="模版:"+tplIndicator.getMonitorTplCode()+",指标:"+tplIndicator.getMonitorTplCode()+",节点:"+node.getId();
        if(StringUtil.isBlank(content)){
            Insert ins=createBaseInsert(tplIndicator,node);
            ins.set("result_status", MonitorNodeValueResultStatusEnum.FAILED.code());
            ins.set("result_message",errorMsg+",采集数据为空");
            return ErrorDesc.success().data(insList);
        }
        if("system.connected".equals(tplIndicator.getCode())){
            if("1".equals(content.replaceAll("\n","").trim())){
                dao.execute("update ops_monitor_node set status='online' where id=? ",node.getId());
            }else{
                dao.execute("update ops_monitor_node set status='offline' where id=? ",node.getId());
            }
        }
        //结果数据转换，开始转换行
        if(MonitorIndicatorValueColumnRowsEnum.SINGLE.code().equals(tplIndicator.getValueColumnRows())){
            contentList.add(content);
        }else if (MonitorIndicatorValueColumnRowsEnum.MULTIPLE.code().equals(tplIndicator.getValueColumnRows())){

            String colContent=null;
            BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
            try {
                colContent = br.readLine();
                while (colContent != null)
                {
                    contentList.add(colContent);
                    colContent=br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            Insert ins=createBaseInsert(tplIndicator,node);
            ins.set("result_status", MonitorNodeValueResultStatusEnum.FAILED.code());
            ins.set("result_message",errorMsg+",getValueColumnRows参数设置错误");
            return ErrorDesc.success().data(insList);
        }

        //结果数据转换，开始转换列
        String[] valueColumnArr=tplIndicator.getValueColumn().split(NODE_VALUE_COLUMN_COLS_SPLIT);
        Date uidDate=new Date();
        //当单列时
        if(MonitorIndicatorValueColumnColsEnum.SINGLE.code().equals(tplIndicator.getValueColumnCols())){
            for(String itemValue:contentList){
                Insert ins=createBaseInsert(tplIndicator,node);
                ins.set(tplIndicator.getValueColumn(),itemValue);
                if(MonitorIndicatorValueColumnRowsEnum.MULTIPLE.code().equals(tplIndicator.getValueColumnRows())){
                    ins.set("record_time",uidDate);
                }
                insList.add(ins);
            }
        }else if(MonitorIndicatorValueColumnColsEnum.MULTIPLE.code().equals(tplIndicator.getValueColumnCols())){
            //当多列时
            for(String itemValue:contentList){
                Logger.info("itemValue:"+itemValue);
                String[] valueColumnItemArr=itemValue.split(NODE_VALUE_COLUMN_COLS_SPLIT);
                Insert ins=createBaseInsert(tplIndicator,node);
                if(MonitorIndicatorValueColumnRowsEnum.MULTIPLE.code().equals(tplIndicator.getValueColumnRows())){
                    ins.set("record_time",uidDate);
                }
                //Logger.info("valueColumnItemArr"+valueColumnItemArr);
                //Logger.info("valueColumnArr"+valueColumnArr);
                if(valueColumnItemArr.length==valueColumnArr.length){
                    for(int i=0;i<valueColumnArr.length;i++){
                        ins.set(valueColumnArr[i],valueColumnItemArr[i]);
                    }
                }else{
                    ins.set("result_status", MonitorNodeValueResultStatusEnum.FAILED.code());
                    ins.set("result_message","采集数据和模版设置列数不一致");
                }
                insList.add(ins);
            }
        }
        return ErrorDesc.success().data(insList);
    }


    @Override
    public List<MonitorNode> queryExecuteNodeList(String monitorMethod) {
        String sql="select distinct ret.id from ("+MonitorDataProcessBaseServiceImpl.findExecuteDataSql.replaceAll("#<MONITOR_METHOD>#",monitorMethod)+") ret ";
        ConditionExpr expr=new ConditionExpr();
        expr.and(" id in ("+sql+")" );
        expr.andIf("node_enabled",MonitorEnableEnum.ENABLE.code());
        List<MonitorNode> list=monitorNodeService.queryList(expr);
        return list;
    }


    @Override
    public List<MonitorTplIndicator> queryExecuteIndicatorList(String nodeId,String monitorMethod) {
        String sql="select distinct ret.indicator_id from ("+MonitorDataProcessBaseServiceImpl.findExecuteDataSql.replaceAll("#<MONITOR_METHOD>#",monitorMethod)+") ret where 1=1 ";
        if(!StringUtil.isBlank(nodeId)){
            sql=sql+" and ret.id='"+nodeId+"'";
        }
        ConditionExpr expr=new ConditionExpr();
        expr.and("id in ("+sql+")" );
        List<MonitorTplIndicator> list=monitorTplIndicatorService.queryList(expr);
        return list;
    }

}
