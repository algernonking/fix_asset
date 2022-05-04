package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.AssetSoftwareDistributeData;
import com.dt.platform.eam.page.AssetSoftwareDistributeDataPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSoftwareDistributeDataServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SoftwareDistItemGtr extends BaseCodeGenerator {


    public SoftwareDistItemGtr() {
        super(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.$TABLE,BASIC_ASSET_SOFT_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.ID).basic().hidden(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.AUTHORIZED_INFO,

                }
        );

        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.AUTHORIZED_NUMBER,
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE_DATA.AUTHORIZED_INFO,

                }
        );

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SoftwareDistItemGtr g=new SoftwareDistItemGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //   g.generateMenu(AssetSoftwareDistributeDataServiceProxy.class, AssetSoftwareDistributeDataPageController.class);
        //生成菜单

    }

}
