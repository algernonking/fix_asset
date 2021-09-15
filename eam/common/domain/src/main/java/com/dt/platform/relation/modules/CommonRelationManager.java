package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.common.meta.TplFileMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class CommonRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupAllocation();
        this.setupCode();
        this.setupCodeAllocation();
        this.setupTplFile();

    }

    public void setupAllocation() {
        // 管理规则
        this.property(CodeAllocationMeta.RULE_PROP)
                .using(EAMTables.SYS_CODE_ALLOCATION.RULE_ID).join(EAMTables.SYS_CODE_RULE.ID);



    }


    private void setupTplFile() {
        this.property(TplFileMeta.BUSINESS_CODE_PROP)
                .using(EAMTables.SYS_TPL_FILE.CODE).join(EAMTables.SYS_CODE_REGISTER.CODE);

    }


    private void setupRelations() {

    }
    private void setupCode() {
        this.property(CodeRuleMeta.MODULE_PROP)
                .using(EAMTables.SYS_CODE_RULE.MODULE_ID).join(FoxnicWeb.SYS_MENU.ID);

    }

    private void setupCodeAllocation() {
        this.property(CodeAllocationMeta.BUSINESS_CODE_PROP)
                .using(EAMTables.SYS_CODE_ALLOCATION.CODE).join(EAMTables.SYS_CODE_REGISTER.CODE);

    }


}
