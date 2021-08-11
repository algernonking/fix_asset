package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.github.foxnic.dao.relation.RelationManager;

public class CommonRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupCode();

    }

    public void setupProperties() {
        // 管理规则
        this.property(CodeAllocationMeta.RULE_PROP)
                .using(EAMTables.SYS_CODE_ALLOCATION.RULE_ID).join(EAMTables.SYS_CODE_RULE.ID);
    }

    private void setupRelations() {

    }
    private void setupCode() {
 

    }

}
