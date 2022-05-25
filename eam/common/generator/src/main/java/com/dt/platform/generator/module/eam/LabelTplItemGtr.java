package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelTplItem;
import com.dt.platform.eam.page.AssetLabelTplItemPageController;
import com.dt.platform.eam.page.AssetLabelTplPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetLabelTplItemServiceProxy;
import com.dt.platform.proxy.eam.AssetLabelTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class LabelTplItemGtr extends BaseCodeGenerator{
    public LabelTplItemGtr() {
        super(EAMTables.EAM_ASSET_LABEL_TPL_ITEM.$TABLE,BASIC_SETTING_MENU_ID);
    }


    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(AssetLabelCol.class,"assetLabelCol","assetLabelCol","assetLabelCol");



        cfg.view().field(EAMTables.EAM_ASSET_LABEL_TPL_ITEM.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_LABEL_TPL_ITEM.ID,
                }
        );

        cfg.view().list().operationColumn().addActionMenu("t1","test1");
        cfg.view().list().operationColumn().addActionMenu("t2","test2");

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        LabelTplItemGtr g=new LabelTplItemGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("580142775496867840");
       // g.generateMenu(AssetLabelTplItemServiceProxy.class, AssetLabelTplItemPageController.class);
    }
}
