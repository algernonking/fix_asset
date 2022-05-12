package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.KnTables;
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;
import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class KnRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupContent();
    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }

    private void setupContent() {
        this.property(ContentMeta.CATEGORY_PROP)
                .using(KnTables.KN_CONTENT.CATEGORY_ID).join(KnTables.KN_CATEGORY.ID);

        this.property(ContentMeta.EDITOR_PROP)
                .using(KnTables.KN_CONTENT.EDITOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }

}
