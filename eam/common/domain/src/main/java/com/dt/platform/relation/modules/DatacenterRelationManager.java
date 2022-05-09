package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.DataCenterTables;
import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.domain.datacenter.meta.LayerMeta;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class DatacenterRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupDcRack();

        this.setupDcLayer();
    }

    public void setupProperties() {

    }

    private void setupRelations() {

    }



    private void setupDcLayer() {
        // 配置关联关系
        this.property(LayerMeta.AREA_PROP)
                .using(DataCenterTables.DC_LAYER.AREA_ID).join(DataCenterTables.DC_AREA.ID);
    }

    private void setupDcRack() {

        // 配置关联关系
        this.property(RackMeta.AREA_PROP)
                .using(DataCenterTables.DC_RACK.AREA_ID).join(DataCenterTables.DC_AREA.ID);

        // 配置关联关系
        this.property(RackMeta.LAYER_PROP)
                .using(DataCenterTables.DC_RACK.LAYER_ID).join(DataCenterTables.DC_LAYER.ID);


        this.property(RackMeta.TYPE_DICT_PROP)
                .using(DataCenterTables.DC_RACK.RACK_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_type'");


        this.property(RackMeta.STATUS_DICT_PROP)
                .using(DataCenterTables.DC_RACK.STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_status'");

        this.property(RackMeta.USED_TYPE_DICT_PROP)
                .using(DataCenterTables.DC_RACK.RACK_USED_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_used_type'");

        this.property(RackMeta.ENVIRONMENT_DICT_PROP)
                .using(DataCenterTables.DC_RACK.ENVIRONMENT).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_dc_rack_environment'");




    }

}
