package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.AssetSelectedDataPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSelectedDataServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetSelectedDataGtr extends BaseCodeGenerator{
    public EamAssetSelectedDataGtr() {
        super(EAMTables.EAM_ASSET_SELECTED_DATA.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_ASSET_SELECTED_DATA.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_SELECTED_DATA.CREATE_TIME).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_SELECTED_CODE).basic().hidden(true);


        cfg.view().field(EAMTables.EAM_ASSET_SELECTED_DATA.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_SELECTED_CODE).table().disable(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_SELECTED_CODE,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().addToolButton("选择资产","selectAsset",null);
        cfg.view().list().disableFormView();
        cfg.view().list().disableMargin();



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetSelectedDataGtr g=new EamAssetSelectedDataGtr();
        //生成代码
       //  g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
        g.generateMenu(AssetSelectedDataServiceProxy.class, AssetSelectedDataPageController.class);
    }
}
