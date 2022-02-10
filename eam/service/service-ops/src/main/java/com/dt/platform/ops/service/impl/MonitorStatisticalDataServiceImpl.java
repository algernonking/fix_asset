package com.dt.platform.ops.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.ops.MonitorTopDataEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.dt.platform.ops.service.IMonitorNodeService;
import com.dt.platform.ops.service.IMonitorStatisticalDataService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MonitorStatisticalDataService")
public class MonitorStatisticalDataServiceImpl extends SuperService<MonitorNode> implements IMonitorStatisticalDataService {

        /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @Autowired
    private IMonitorNodeService monitorNodeService;



    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }


    @Override
    public Result<JSONObject> queryNodeStatistics() {
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        //统计节点个数
        String sql="select a.name,a.code,ifnull(b.cnt,0) cnt from ops_monitor_node_type a left join (select type,count(1) cnt from ops_monitor_node where deleted=0 group by type) b on a.code=b.type";
        resultData.put("nodeStatistics",dao.query(sql).toJSONArrayWithJSONObject());
        return result.success(true).data(resultData);
    }

    @Override
    public Result<JSONObject> queryNodeHostResourceList() {

        String sql="select\n" +
                "(\n" +
                "select is_connected\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.connected' and t.node_id=end.id\n" +
                ") data_os_connected, \n"+

                "(select max_record_time from \n" +
                "(select node_id, max(record_time) max_record_time from ops_monitor_node_value where result_status='sucess' group by node_id) t\n" +
                "where t.node_id=end.id\n" +
                ") data_max_record_time,\n"+

                "(\n" +
                "select p_memory_size\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.memory_size' and t.node_id=end.id\n" +
                ") data_p_memory_size,\n"+

                "(\n" +
                "select process_cnt\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.process_cnt' and t.node_id=end.id\n" +
                ") data_process_cnt,\n" +
                "(\n" +
                "select os_load\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.load' and t.node_id=end.id\n" +
                ") data_os_load,\n" +
                "(\n" +
                "select cpu_number\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.cpu_number' and t.node_id=end.id\n" +
                ") data_os_cpu_number,\n" +
                "(\n" +
                "select hostname\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.hostname' and t.node_id=end.id\n" +
                ") data_hostname,\n" +
                "\n" +
                "(\n" +
                "select p_memory_used\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.memory_used' and t.node_id=end.id\n" +
                ") data_p_memory_used,\n" +
                "(\n" +
                "select os_datetime\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.datetime' and t.node_id=end.id\n" +
                ") data_os_datetime,\n" +
                "\n" +
                "(\n" +
                "select max(list_value_number1) flow_up\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.net_interface_flow' and t.node_id=end.id\n" +
                ") data_os_net_interface_flow_up,\n" +
                "(\n" +
                "select max(list_value_number2) flow_down\n" +
                "from ops_monitor_node_value t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value group by node_id,indicator_code)\n" +
                "and result_status='sucess' and t.indicator_code='os.net_interface_flow' and t.node_id=end.id\n" +
                ") data_os_net_interface_flow_down,\n" +
                "\n" +
                "end.*\n" +
                "from ops_monitor_node end where node_enabled='enable' and deleted='0'";
       // System.out.println("nodeList Sql:\n"+sql);
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        //统计节点个数
        resultData.put("nodeHostList",dao.query(sql).toJSONArrayWithJSONObject());
        return result.success(true).data(resultData);
    }

    @Override
    public Result<JSONObject> queryNodeCollectDataFailed() {

        String sql="select t1.*,t2.node_ip,t2.node_name_show,t3.name tpl_name from \n" +
                "(\n" +
                "select node_id,monitor_tpl_code,indicator_code,record_time,result_message  \n" +
                "from ops_monitor_node_value t \n" +
                "where (node_id,monitor_tpl_code,indicator_code,record_time) in (\n" +
                "\n" +
                "select node_id,monitor_tpl_code,indicator_code,max_record_time from (\n" +
                "select a1.*, a2.max_record_time a2_max_record_time from (\n" +
                "select node_id,monitor_tpl_code,indicator_code, max(record_time) max_record_time from ops_monitor_node_value where result_status='failed' group by node_id,monitor_tpl_code,indicator_code\n" +
                ")a1 left join \n" +
                "(\n" +
                "select node_id,monitor_tpl_code,indicator_code, max(record_time) max_record_time from ops_monitor_node_value where result_status='sucess' group by node_id,monitor_tpl_code,indicator_code\n" +
                ")a2\n" +
                "on  a1.node_id=a2.node_id\n" +
                "and a1.monitor_tpl_code=a2.monitor_tpl_code\n" +
                "and a1.indicator_code=a2.indicator_code\n" +
                ") end where a2_max_record_time is null or max_record_time>a2_max_record_time\n" +
                ")\n" +
                ")t1,ops_monitor_node t2,ops_monitor_tpl t3\n" +
                "where t1.node_id=t2.id and t3.code=t1.monitor_tpl_code";
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        //统计节点个数
        resultData.put("nodeList",dao.query(sql).toJSONArrayWithJSONObject());
        return result.success(true).data(resultData);
    }

    /*
    * nodeIp,
    *
    * */
    private JSONObject parseCollectData(JSONObject data){

        JSONObject result=new JSONObject();
        return result;
    }

    @Override
    public Result<JSONObject> queryNodeCollectData(String nodeId) {

        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        MonitorNode monitorNode=monitorNodeService.getById(nodeId);

        // join 关联的对象
        monitorNodeService.dao().fill(monitorNode)
                .with(MonitorNodeMeta.MONITOR_TPL_LIST)
                .with(MonitorNodeMeta.SSH_VOUCHER)
                .with(MonitorNodeMeta.MONITOR_NODE_GROUP)
                .with(MonitorNodeMeta.MONITOR_NODE_TYPE)
                .execute();
        String sql="";


        JSONArray nodeCollectData=new JSONArray();
        List<MonitorTpl> nodeTplList=monitorNode.getMonitorTplList();
        if(nodeTplList!=null&&nodeTplList.size()>0)
        for(MonitorTpl tpl:nodeTplList){
           String dataSql="select * from (\n" +
                   "select * from ops_monitor_tpl_indicator where monitor_tpl_code='tpl_host_linux_script' and status='enable'\n" +
                   ") a1 left join \n" +
                   "(\n" +
                   "select * from ops_monitor_node_value where (node_id,indicator_code,record_time) \n" +
                   "in(\n" +
                   "select node_id,indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value where node_id=2 and result_status='sucess' and monitor_tpl_code='tpl_host_linux_script') t group by node_id,indicator_code\n" +
                   "))a2 on a1.monitor_tpl_code=a2.monitor_tpl_code and a1.code=a2.indicator_code order by a1.item_sort\n";
           RcdSet rs=dao.query(dataSql);
           for(Rcd r:rs){
               JSONObject data=parseCollectData(r.toJSONObject());
               nodeCollectData.add(data);
           }
        }


        resultData.put("nodeCollectDataList",nodeCollectData);
        resultData.put("nodeInfo",BeanUtil.toJSONObject(monitorNode));
        return result.success(true).data(resultData);

    }


    @Override
    public Result<JSONObject> queryNodeHostTopData(List<String> topList,int top,int day) {
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        if(topList!=null&&topList.size()>0){
            for(String topValue : topList){
                if(MonitorTopDataEnum.OS_CPU_USED.code().equals(topValue)){
                    resultData.put("osCpuUsed",this.queryNodeHostTopDataOsCpuUsed(top,day));
                }else if(MonitorTopDataEnum.OS_FS_USED.code().equals(topValue)){
                    resultData.put("osFs",this.queryNodeHostTopDataOsFsUsed(top,day));
                }else if(MonitorTopDataEnum.OS_FS_INODE_USED.code().equals(topValue)){
                    resultData.put("osFsInodeUsed",this.queryNodeHostTopDataOsFsInodeUsed(top,day));
                }else if(MonitorTopDataEnum.OS_LOAD.code().equals(topValue)){
                    resultData.put("osLoad",this.queryNodeHostTopDataOsLoad(top,day));
                }else if(MonitorTopDataEnum.OS_P_MEMORY_USED.code().equals(topValue)){
                    resultData.put("osPMemoryUsed",this.queryNodeHostTopDataOsMemoryUsed(top,day));
                }else if(MonitorTopDataEnum.OS_V_MEMORY_USED.code().equals(topValue)){
                    resultData.put("osVMemoryUsed",this.queryNodeHostTopDataOsVmemoryUsed(top,day));
                }else if(MonitorTopDataEnum.OS_NET_FLOW_UP.code().equals(topValue)){
                    resultData.put("osNetFlowUp",this.queryNodeHostTopDataOsNetFlowUp(top,day));
                }else if(MonitorTopDataEnum.OS_NET_FLOW_DOWN.code().equals(topValue)){
                    resultData.put("osNetFlowDown",this.queryNodeHostTopDataOsNetFlowDown(top,day));
                }
            }
        }
        return result.success(true).data(resultData);
    }

    private JSONArray queryNodeHostTopDataOsFsUsed(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.list_value_str1 fs_name,list_value_number1 pct from ops_monitor_node_value a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
                "and b.status='online' \n" +
                "and (node_id,indicator_code,list_value_str1,record_time) \n" +
                "in (\n" +
                "select node_id,indicator_code,list_value_str1,max(record_time) max_record_time from (select * from ops_monitor_node_value where indicator_code='os.fs' and result_status='sucess') t group by node_id,indicator_code,list_value_str1\n" +
                ")\n" +
                "order by a.list_value_number2 desc)end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }
    private JSONArray queryNodeHostTopDataOsFsInodeUsed(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsNetFlowUp(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.list_value_str1 fs_namae,a.list_value_number1 up_flow from ops_monitor_node_value a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
                "and b.status='online' \n" +
                "and (node_id,indicator_code,list_value_str1,record_time) \n" +
                "in (select node_id,indicator_code,list_value_str1,max(record_time) max_record_time from (select * from ops_monitor_node_value where indicator_code='os.net_interface_flow') t group by node_id,indicator_code,list_value_str1)\n" +
                "order by a.list_value_number1 desc)end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }
    private JSONArray queryNodeHostTopDataOsNetFlowDown(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.list_value_str1 fs_namae,a.list_value_number2 down_flow from ops_monitor_node_value a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
                "and b.status='online' \n" +
                "and (node_id,indicator_code,list_value_str1,record_time) \n" +
                "in (select node_id,indicator_code,list_value_str1,max(record_time) max_record_time from (select * from ops_monitor_node_value where indicator_code='os.net_interface_flow') t group by node_id,indicator_code,list_value_str1)\n" +
                "order by a.list_value_number2 desc)end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsCpuUsed(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.cpu_used from ops_monitor_node_value a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
                "and b.status='online' \n" +
                "and (node_id,indicator_code,record_time) \n" +
                "in (select node_id,indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value where indicator_code='os.cpu') t group by node_id,indicator_code)\n" +
                "order by cpu_used desc)end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsLoad(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.os_load from ops_monitor_node_value a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
                "and b.status='online' \n" +
                "and (node_id,indicator_code,record_time) \n" +
                "in (select node_id,indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value where indicator_code='os.load') t group by node_id,indicator_code)\n" +
                "order by os_load desc)end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsMemoryUsed(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.p_memory_used from ops_monitor_node_value a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
                "and b.status='online' \n" +
                "and (node_id,indicator_code,record_time) \n" +
                "in (select node_id,indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value where indicator_code='os.memory_used') t group by node_id,indicator_code)\n" +
                "order by p_memory_used desc)end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsVmemoryUsed(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

}
