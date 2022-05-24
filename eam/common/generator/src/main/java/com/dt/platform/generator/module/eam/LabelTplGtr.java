package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelTplItem;
import com.dt.platform.eam.page.AssetLabelTplPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetLabelTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class LabelTplGtr extends BaseCodeGenerator{
    public LabelTplGtr() {
        super(EAMTables.EAM_ASSET_LABEL_TPL.$TABLE,BASIC_SETTING_MENU_ID);
    }


    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(AssetLabelTplItem.class,"assetLabelItemList","Item","Item");
        cfg.getPoClassFile().addListProperty(AssetLabelCol.class,"assetLabelColumnlList","Column","Column");


        cfg.view().field(EAMTables.EAM_ASSET_LABEL_TPL.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_LABEL_TPL.ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        LabelTplGtr g=new LabelTplGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetLabelTplServiceProxy.class, AssetLabelTplPageController.class);
    }
}
