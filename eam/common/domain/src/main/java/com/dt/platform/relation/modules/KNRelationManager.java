package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;
import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.github.foxnic.dao.relation.RelationManager;

public class KNRelationManager extends RelationManager {
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
    private void setupDcRack() {
 

    }
    private void setupContent() {


        this.property(ContentMeta.CATEGORY_PROP)
                .using(EAMTables.KN_CONTENT.CATEGORY_ID).join(EAMTables.KN_CATEGORY.ID);

        this.property(ContentMeta.GRADE_PROP)
                .using(EAMTables.KN_CONTENT.GRADE_ID).join(EAMTables.KN_GRADE.ID);

    }

}
