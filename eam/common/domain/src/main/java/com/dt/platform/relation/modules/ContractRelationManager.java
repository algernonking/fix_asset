package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceCategoryMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.github.foxnic.dao.relation.RelationManager;

public class ContractRelationManager extends RelationManager {
    @Override
    protected void config() {

        this.setupProperties();

    }

    public void setupProperties() {

    }



}
