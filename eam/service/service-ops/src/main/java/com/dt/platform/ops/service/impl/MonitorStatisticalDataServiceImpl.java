package com.dt.platform.ops.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.ops.MonitorTopDataEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.ops.service.IMonitorStatisticalDataService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
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

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }


    @Override
    public Result<JSONObject> queryNodeStatistics() {
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        //JSONArray nodeStatistics=new JSONArray();
        //统计节点个数
        String sql="select a.name,a.code,ifnull(b.cnt,0) cnt from ops_monitor_node_type a left join (select type,count(1) cnt from ops_monitor_node where deleted=0 group by type) b on a.code=b.type";
        resultData.put("nodeStatistics",dao.query(sql).toJSONArrayWithJSONObject());
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
                }else if(MonitorTopDataEnum.OS_MEMORY_USED.code().equals(topValue)){
                    resultData.put("osMemoryUsed",this.queryNodeHostTopDataOsMemoryUsed(top,day));
                }else if(MonitorTopDataEnum.OS_VMEMORY_USED.code().equals(topValue)){
                    resultData.put("osVmemoryUsed",this.queryNodeHostTopDataOsVmemoryUsed(top,day));
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
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }
    private JSONArray queryNodeHostTopDataOsFsInodeUsed(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsNetFlowUp(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }
    private JSONArray queryNodeHostTopDataOsNetFlowDown(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsCpuUsed(int top,int day){
        String sql="select * from (\n" +
                "select a.node_ip,a.node_name,a.node_name_show,cpu_used,record_time \n" +
                "from ops_monitor_node a,ops_monitor_node_host b \n" +
                "where a.type='os' and node_enabled='1' and a.id=b.node_id order by cpu_used desc\n" +
                ")d limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsLoad(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsMemoryUsed(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsVmemoryUsed(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

}
