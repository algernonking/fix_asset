package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;

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
        this.property(CodeRuleMeta.MODULE_PROP)
                .using(EAMTables.SYS_CODE_RULE.MODULE_ID).join(FoxnicWeb.SYS_MENU.ID);

    }

}
