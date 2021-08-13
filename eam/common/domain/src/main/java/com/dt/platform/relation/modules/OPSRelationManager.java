package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceDetailMeta;
import com.github.foxnic.dao.relation.RelationManager;

public class OPSRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupOpsServiceDetail();
        this.setupOpsHost();
        this.setupOpsDbInstance();
    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }

    private void setupOpsServiceDetail() {

        //关联服务类型
        this.property(ServiceDetailMeta.OPS_SERVICE_PROP)
                .using(EAMTables.OPS_SERVICE_DETAIL.SERVICE_ID).join(EAMTables.OPS_SERVICE.ID);

    }

    private void setupOpsDbInstance() {

        this.property(DbInstanceMeta.HOST_PROP)
                .using(EAMTables.OPS_DB_INSTANCE.HOST_ID).join(EAMTables.OPS_HOST.ID);

        this.property(DbInstanceMeta.DATABASE_PROP)
                .using(EAMTables.OPS_DB_INSTANCE.DATABASE_ID).join(EAMTables.OPS_SERVICE_DETAIL.ID);

    }
    private void setupOpsHost() {

        //数据库类别
        this.property(HostMeta.HOST_DB_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_DB.HOST_ID)
                .using(EAMTables.OPS_HOST_DB.SERVICE_DETAIL_ID).join(EAMTables.OPS_SERVICE_DETAIL.ID)
        .after((host,dbs)->{
            return dbs;
        });

        //中间件列表
        this.property(HostMeta.HOST_MIDDLEWARE_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_MID.HOST_ID)
                .using(EAMTables.OPS_HOST_MID.SERVICE_DETAIL_ID).join(EAMTables.OPS_SERVICE_DETAIL.ID);

        //操作系统列表
        this.property(HostMeta.HOST_OS_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_OS.HOST_ID)
                .using(EAMTables.OPS_HOST_OS.SERVICE_DETAIL_ID).join(EAMTables.OPS_SERVICE_DETAIL.ID);

        //所在位置
        this.property(HostMeta.POSITION_PROP)
                .using(EAMTables.OPS_HOST.POSITION_ID).join(EAMTables.OPS_HOST_POSITION.ID);

        //信息系统
        this.property(HostMeta.INFO_SYSTEM_PROP)
                .using(EAMTables.OPS_HOST.SYSTEM_ID).join(EAMTables.OPS_INFORMATION_SYSTEM.ID);

    }



}
