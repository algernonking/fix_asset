package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.dt.platform.domain.ops.meta.MonitorNodeSubtypeMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class MonitorRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupContent();

        this.monitorNodeSubType();
        this.monitorNode();
    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }

    private void setupContent() {

    }

    private void monitorNode() {
        this.property(MonitorNodeMeta.MONITOR_NODE_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.TYPE).join(EAMTables.OPS_MONITOR_NODE_TYPE.CODE);

        this.property(MonitorNodeMeta.MONITOR_NODE_SUB_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.SUB_TYPE).join(EAMTables.OPS_MONITOR_NODE_SUBTYPE.CODE);


        this.property(MonitorNodeMeta.MONITOR_NODE_HOST_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.ID).join(EAMTables.OPS_MONITOR_NODE_HOST.NODE_ID);


        this.property(MonitorNodeMeta.MONITOR_NODE_VALUE_LIST_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.ID).join(EAMTables.OPS_MONITOR_NODE_VALUE.NODE_ID);
    }

    private void monitorNodeSubType() {
        this.property(MonitorNodeSubtypeMeta.MONITOR_NODE_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_NODE_SUBTYPE.TYPE).join(EAMTables.OPS_MONITOR_NODE_TYPE.CODE);
    }

}
