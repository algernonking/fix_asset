package com.dt.platform.generator.module.vehicle;

import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class VehicleMaintenanceGtr extends BaseCodeGenerator {


    public VehicleMaintenanceGtr() {
        super(VehicleTables.VEHICLE_MAINTENANCE.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.ID).basic().hidden(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.NAME).search().fuzzySearch();


        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.NAME).form().validate().required();
        cfg.view().search().inputLayout(
                new Object[]{
                        VehicleTables.VEHICLE_MAINTENANCE.NAME
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        VehicleMaintenanceGtr g=new VehicleMaintenanceGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(InfoServiceProxy.class, InfoPageController.class);
    }

}
