package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.github.foxnic.dao.relation.RelationManager;

public class DatacenterRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupDcRack();
    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }
    private void setupDcRack() {

        // 配置关联关系
//        this.property(RackMeta.AREA_PROP)
//                .using(EAMTables.DC_RACK.AREA_ID).join(EAMTables.DC_AREA.ID);
//
//        // 配置关联关系
//        this.property(RackMeta.LAYER_PROP)
//                .using(EAMTables.DC_RACK.LAYER_ID).join(EAMTables.DC_LAYER.ID);
//

    }

}
