package com.dt.platform.relation.modules;


import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.datacenter.meta.DcInfoMeta;
import com.dt.platform.domain.datacenter.meta.RackMeta;
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
      //  this.property(RackMeta.DC_ID).using(DcInfoMeta.ID)


    }

}
