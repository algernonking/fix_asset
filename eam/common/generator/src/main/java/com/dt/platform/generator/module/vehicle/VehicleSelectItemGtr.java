package com.dt.platform.generator.module.vehicle;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.vehicle.Apply;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.domain.vehicle.Maintenance;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBField;

public class VehicleSelectItemGtr extends BaseCodeGenerator {

    public VehicleSelectItemGtr() {
        super(VehicleTables.VEHICLE_SELECT_ITEM.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        VehicleTables.VEHICLE_SELECT_ITEM.ID,
                }
        );

        cfg.setRelationField(Apply.class,VehicleTables.VEHICLE_SELECT_ITEM.HANDLE_ID, Info.class, VehicleTables.VEHICLE_SELECT_ITEM.ASSET_ID,true);
        cfg.setRelationField(Maintenance.class,VehicleTables.VEHICLE_SELECT_ITEM.HANDLE_ID, Info.class, VehicleTables.VEHICLE_SELECT_ITEM.ASSET_ID,true);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        ; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        VehicleSelectItemGtr g=new VehicleSelectItemGtr();

        //生成代码
        g.generateCode();
        //生成菜单

    }

}
