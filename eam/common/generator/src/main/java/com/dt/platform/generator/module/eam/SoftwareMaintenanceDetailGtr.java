package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.eam.page.AssetSoftwareMaintenanceDetailPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSoftwareMaintenanceDetailServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SoftwareMaintenanceDetailGtr extends BaseCodeGenerator {


    public SoftwareMaintenanceDetailGtr() {
        super(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL.$TABLE,BASIC_ASSET_SOFT_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL.SOFTWARE_ID,
                }
        );
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE_DETAIL.SOFTWARE_ID,
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SoftwareMaintenanceDetailGtr g=new SoftwareMaintenanceDetailGtr();
        //生成代码
       g.generateCode();

      //  g.generateMenu(AssetSoftwareMaintenanceDetailServiceProxy.class, AssetSoftwareMaintenanceDetailPageController.class);

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //g.generateMenu(BrandServiceProxy.class, BrandPageController.class);
        //生成菜单

    }

}
