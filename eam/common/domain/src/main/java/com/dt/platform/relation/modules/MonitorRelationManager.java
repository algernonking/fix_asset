package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;
import com.dt.platform.domain.ops.meta.*;
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

        this.monitorTpl();
        this.monitorTplIndicator();
        this.monitorWarn();


    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }

    private void setupContent() {

    }

    private void monitorWarn() {
        this.property(MonitorWarnMeta.TPL_PROP)
                .using(EAMTables.OPS_MONITOR_WARN.MONITOR_TPL_CODE).join(EAMTables.OPS_MONITOR_TPL.CODE);


        this.property(MonitorWarnMeta.TPL_INDICATOR_PROP)
                .using(EAMTables.OPS_MONITOR_WARN.INDICATOR_CODE).join(EAMTables.OPS_MONITOR_TPL_INDICATOR.CODE);
           //     .using(EAMTables.OPS_MONITOR_WARN.MONITOR_TPL_CODE).join(EAMTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE);
    }


    private void monitorNode() {

        this.property(MonitorNodeMeta.SSH_VOUCHER_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.SSH_VOUCHER_ID).join(EAMTables.OPS_MONITOR_VOUCHER.ID);

        this.property(MonitorNodeMeta.MONITOR_TPL_LIST_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.ID).join(EAMTables.OPS_MONITOR_NODE_TPL_ITEM.NODE_ID);

        this.property(MonitorNodeMeta.MONITOR_NODE_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.TYPE).join(EAMTables.OPS_MONITOR_NODE_TYPE.CODE);

        this.property(MonitorNodeMeta.MONITOR_NODE_SUB_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.SUB_TYPE).join(EAMTables.OPS_MONITOR_NODE_SUBTYPE.CODE);


//        this.property(MonitorNodeMeta.MONITOR_NODE_HOST_PROP)
//                .using(EAMTables.OPS_MONITOR_NODE.ID).join(EAMTables.OPS_MONITOR_NODE_HOST.NODE_ID);

        this.property(MonitorNodeMeta.MONITOR_NODE_DB_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.ID).join(EAMTables.OPS_MONITOR_NODE_DB.NODE_ID);

        this.property(MonitorNodeMeta.MONITOR_NODE_VALUE_LIST_PROP)
                .using(EAMTables.OPS_MONITOR_NODE.ID).join(EAMTables.OPS_MONITOR_NODE_VALUE.NODE_ID);

//        this.property(MonitorNodeMeta.MONITOR_NODE_LIST_VALUE_LIST_PROP)
//                .using(EAMTables.OPS_MONITOR_NODE.ID).join(EAMTables.OPS_MONITOR_NODE_LIST_VALUE.NODE_ID);
    }

    private void monitorTplIndicator(){
        this.property(MonitorTplIndicatorMeta.TPL_PROP)
                .using(EAMTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE).join(EAMTables.OPS_MONITOR_TPL.CODE);

        this.property(MonitorTplIndicatorMeta.MONITOR_INDICATOR_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_TPL_INDICATOR.INDICATOR_TYPE).join(EAMTables.OPS_MONITOR_TPL_INDICATOR_TYPE.CODE);

    }


    private void monitorTpl() {
        this.property(MonitorTplMeta.TPL_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_TPL.TYPE).join(EAMTables.OPS_MONITOR_TPL_TYPE.CODE);


        this.property(MonitorTplMeta.TPL_INDICATOR_LIST_PROP)
                .using(EAMTables.OPS_MONITOR_TPL.CODE).join(EAMTables.OPS_MONITOR_TPL_INDICATOR.MONITOR_TPL_CODE);
    }

    private void monitorNodeSubType() {
        this.property(MonitorNodeSubtypeMeta.MONITOR_NODE_TYPE_PROP)
                .using(EAMTables.OPS_MONITOR_NODE_SUBTYPE.TYPE).join(EAMTables.OPS_MONITOR_NODE_TYPE.CODE);
    }

}
