package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;

import com.github.foxnic.dao.relation.RelationManager;

public class EAMRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();

    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }
    private void setupDcRack() {


    }

}
