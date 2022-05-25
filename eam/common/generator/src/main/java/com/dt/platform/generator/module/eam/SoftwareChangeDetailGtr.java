package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.eam.page.AssetSoftwareChangeDetailPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSoftwareChangeDetailServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class SoftwareChangeDetailGtr extends BaseCodeGenerator {


    public SoftwareChangeDetailGtr() {
        super(EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.$TABLE,BASIC_ASSET_SOFT_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addSimpleProperty(AssetSoftware.class,"assetSoftware","软件信息","软件信息");
        cfg.getPoClassFile().addSimpleProperty(AssetSoftware.class,"assetSoftwareAfter","软件信息","软件信息");
        cfg.getPoClassFile().addSimpleProperty(AssetSoftware.class,"assetSoftwareBefore","软件信息","软件信息");


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.CHANGE_ID,
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
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE_DETAIL.CHANGE_ID,

                }
        );


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
        SoftwareChangeDetailGtr g=new SoftwareChangeDetailGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
   //     g.generateMenu(AssetSoftwareChangeDetailServiceProxy.class, AssetSoftwareChangeDetailPageController.class);
        //生成菜单

    }

}
