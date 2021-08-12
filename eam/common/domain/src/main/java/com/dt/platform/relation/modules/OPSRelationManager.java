package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;


import com.dt.platform.domain.ops.OpsHost;
import com.dt.platform.domain.ops.meta.OpsServiceMeta;
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
//    private void setupOpsService() {
//        this.property(OpsServiceMeta.SERVICE_TYPE_PROP)
//                .using(EAMTables.OPS_SERVICE.TYPE_ID).join(EAMTables.OPS_SERVICE_TYPE.ID);
//    }
    private void setupOpsServiceDetail() {
        this.property(ServiceDetailMeta.OPS_SERVICE_PROP)
                .using(EAMTables.OPS_SERVICE_DETAIL.SERVICE_ID).join(EAMTables.OPS_SERVICE.ID);

    }

    private void setupOpsHost() {
//        this.property(OpsHostMeta)
//                .using(EAMTables.OPS_SERVICE_DETAIL.SERVICE_ID).join(EAMTables.OPS_SERVICE.ID);

    }



}
