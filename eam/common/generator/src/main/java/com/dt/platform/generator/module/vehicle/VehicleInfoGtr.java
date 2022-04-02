package com.dt.platform.generator.module.vehicle;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.generator.config.Config;

import com.dt.platform.proxy.vehicle.InfoServiceProxy;
import com.dt.platform.vehicle.page.InfoPageController;
import com.github.foxnic.generator.config.WriteMode;

public class VehicleInfoGtr extends BaseCodeGenerator {


    public VehicleInfoGtr() {
        super(VehicleTables.VEHICLE_MAINTENANCE.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(VehicleTables.VEHICLE_INFO.ID).basic().hidden(true);
        cfg.view().field(VehicleTables.VEHICLE_INFO.NAME).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.CODE).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.REGISTRANT).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.ENGINE_NUMBER).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.FRAME_NUMBER).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.DRIVING_LICENSE).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.NOTES).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.INSURANCE_COMPANY).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_INFO.LICENSING_TIME).search().search().range();

        cfg.view().field(VehicleTables.VEHICLE_INFO.NAME).form().validate().required();
        cfg.view().field(VehicleTables.VEHICLE_INFO.MODEL).form().validate().required();

        cfg.view().search().inputLayout(
                new Object[]{
                        VehicleTables.VEHICLE_INFO.VEHICLE_STATUS,
                        VehicleTables.VEHICLE_INFO.TYPE,
                        VehicleTables.VEHICLE_INFO.CODE,
                        VehicleTables.VEHICLE_INFO.MODEL,
                },
                new Object[]{
                        VehicleTables.VEHICLE_INFO.ENGINE_NUMBER,
                        VehicleTables.VEHICLE_INFO.FRAME_NUMBER,
                        VehicleTables.VEHICLE_INFO.DRIVING_LICENSE,
                        VehicleTables.VEHICLE_INFO.REGISTRANT,
                },
                new Object[]{
                        VehicleTables.VEHICLE_INFO.INSURANCE_COMPANY,
                        VehicleTables.VEHICLE_INFO.NOTES,
                        VehicleTables.VEHICLE_INFO.LICENSING_TIME,
                }
        );


        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        VehicleTables.VEHICLE_INFO.VEHICLE_STATUS,
                        VehicleTables.VEHICLE_INFO.TYPE,
                },
                new Object[] {
                        VehicleTables.VEHICLE_INFO.REGISTRANT,
                        VehicleTables.VEHICLE_INFO.POSITION_DETAIL,
                },

                new Object[] {
                        VehicleTables.VEHICLE_INFO.RESCUE_MONEY,
                        VehicleTables.VEHICLE_INFO.COMMERCIAL_INSURANCE_MONEY,
                },
                new Object[] {
                        VehicleTables.VEHICLE_INFO.INSURANCE_COMPANY,

                }
        );

        cfg.view().form().addGroup("车辆信息",
                new Object[] {
                        VehicleTables.VEHICLE_INFO.CODE,
                        VehicleTables.VEHICLE_INFO.MODEL,
                        VehicleTables.VEHICLE_INFO.COLOR,
                },
                new Object[] {
                        VehicleTables.VEHICLE_INFO.DRIVING_LICENSE,
                        VehicleTables.VEHICLE_INFO.KILOMETERS,
                },
                new Object[] {
                        VehicleTables.VEHICLE_INFO.ENGINE_NUMBER,
                        VehicleTables.VEHICLE_INFO.FRAME_NUMBER,
                },
                new Object[] {
                        VehicleTables.VEHICLE_INFO.LICENSING_TIME,
                        VehicleTables.VEHICLE_INFO.SCRAP_TIME,

                }
        );
        cfg.view().form().addGroup(null ,
                new Object[] {
                        VehicleTables.VEHICLE_INFO.NOTES,
                        VehicleTables.VEHICLE_INFO.PICTURES,
                }
        );


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
        VehicleInfoGtr g=new VehicleInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(InfoServiceProxy.class, InfoPageController.class);
    }

}
