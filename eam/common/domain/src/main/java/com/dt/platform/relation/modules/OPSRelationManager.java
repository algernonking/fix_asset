package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceDetailMeta;
import com.github.foxnic.dao.relation.RelationManager;

public class OPSRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
//        this.setupOpsService();
        this.setupOpsServiceDetail();
    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }

    private void setupOpsServiceDetail() {
        this.property(ServiceDetailMeta.OPS_SERVICE_PROP)
                .using(EAMTables.OPS_SERVICE_DETAIL.SERVICE_ID).join(EAMTables.OPS_SERVICE.ID);

    }

    private void setupOpsHost() {

        this.property(HostMeta.HOST_DB_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_DB.HOST_ID);

    }



}
