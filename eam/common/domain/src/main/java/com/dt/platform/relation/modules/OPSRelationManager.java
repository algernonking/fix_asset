package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;


import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
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
        this.property(ServiceInfoMeta.SERVICE_CATEGORY_PROP)
                .using(EAMTables.OPS_SERVICE_INFO.SERVICE_CATEGORY_ID).join(EAMTables.OPS_SERVICE_CATEGORY.ID);

    }

    private void setupOpsDbInstance() {

        this.property(DbInstanceMeta.HOST_PROP)
                .using(EAMTables.OPS_DB_INSTANCE.HOST_ID).join(EAMTables.OPS_HOST.ID);

        this.property(DbInstanceMeta.DATABASE_PROP)
                .using(EAMTables.OPS_DB_INSTANCE.DATABASE_ID).join(EAMTables.OPS_SERVICE_INFO.ID);

    }
    private void setupOpsHost() {

        //数据库类别
        this.property(HostMeta.HOST_DB_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_DB.HOST_ID)
                .using(EAMTables.OPS_HOST_DB.SERVICE_INFO_ID).join(EAMTables.OPS_SERVICE_INFO.ID)
        .after((host,dbs)->{
            return dbs;
        });

        //中间件列表
        this.property(HostMeta.HOST_MIDDLEWARE_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_MID.HOST_ID)
                .using(EAMTables.OPS_HOST_MID.SERVICE_INFO_ID).join(EAMTables.OPS_SERVICE_INFO.ID);

        //操作系统列表
        this.property(HostMeta.HOST_OS_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_OS.HOST_ID)
                .using(EAMTables.OPS_HOST_OS.SERVICE_INFO_ID).join(EAMTables.OPS_SERVICE_INFO.ID);



        //所在位置
        this.property(HostMeta.POSITION_PROP)
                .using(EAMTables.OPS_HOST.POSITION_ID).join(EAMTables.OPS_HOST_POSITION.ID);

        //信息系统
        this.property(HostMeta.INFO_SYSTEM_PROP)
                .using(EAMTables.OPS_HOST.SYSTEM_ID).join(EAMTables.OPS_INFORMATION_SYSTEM.ID);

    }



}
