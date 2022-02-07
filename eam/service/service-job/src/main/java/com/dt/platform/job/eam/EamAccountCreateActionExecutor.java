package com.dt.platform.job.eam;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.job.Job;
import org.github.foxnic.web.domain.job.JobExecutor;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Instant;

@Component
public class EamAccountCreateActionExecutor implements JobExecutor {

    @Override
    public String getName() {
        return "EamAccountCreateExecutor";
    }
    /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;


    @Override
    public Result execute(Object context, Job job, JSONObject jsonObject) {
        Logger.info("用户新建后,相关赋权操作");
        JobExecutionContext ctx=(JobExecutionContext) context;
        Long pid=Instant.now().toEpochMilli();
        //业务数据权限
        Rcd busiRs=dao.queryRecord("select id from sys_busi_role where code='eam_data_perm_default'");
        if(busiRs!=null){
            long uid = Instant.now().toEpochMilli();
            String id=busiRs.getString("id");
            String sql="insert into eam_user_create_action_log (id,member_id,action,result,pid,uid,time_point)  \n" +
                    "select uuid(),id,'data_perm_role','success','"+pid+"','"+uid+"',create_time from hrm_employee where create_time>(select ifnull(max(time_point),now()-100000000000) from eam_user_create_action_log where action='data_perm_role' and result='success' and deleted='0')\n" +
                    "and id not in (select member_id from sys_busi_role_member a,sys_busi_role b where a.role_id=b.id and b.code='eam_data_perm_default')";
            dao.execute(sql);
            String sql2="insert into sys_busi_role_member(id,role_id,member_id,member_type)\n" +
                    " select uuid_short() ,'"+id+"',member_id,'employee' from eam_user_create_action_log where deleted=0 and action='data_perm_role' and uid='"+uid+"'";
            dao.execute(sql2);
            Logger.info("新用户数据权限检查操作完毕");
        }

        //功能权限 eam_employee
        Rcd roleRs=dao.queryRecord("select id from sys_role where code='eam_employee' and deleted='0'");
        if(roleRs!=null){
            long uid = Instant.now().toEpochMilli();
            String id=roleRs.getString("id");
        }

        return ErrorDesc.success();
    }
}
