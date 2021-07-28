package com.dt.platform.relation.modules;


import com.github.foxnic.dao.relation.RelationManager;

public class DCRelationManager  extends RelationManager {
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
//        this.property(Rack.class, "dcName", DcInfo.class, "数据中心", "数据中心名称").single().
//				using(EAMTables.DC_RACK.DC_ID).join(EAMTables.DC_INFO.ID);

    }

}
