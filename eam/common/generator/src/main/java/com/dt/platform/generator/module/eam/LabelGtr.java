package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelTpl;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.eam.page.AssetLabelPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetLabelServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class LabelGtr extends BaseCodeGenerator{
    public LabelGtr() {
        super(EAMTables.EAM_ASSET_LABEL.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(AssetLabelTpl.class,"assetTpl","模版","模版");
        cfg.getPoClassFile().addSimpleProperty(AssetLabelPaper.class,"assetPaper","纸张类型","纸张类型");

        cfg.getPoClassFile().addListProperty(AssetLabelCol.class,"assetLabelColumnList","ColumnList","ColumnList");


        cfg.view().field(EAMTables.EAM_ASSET_LABEL.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_LABEL.ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_LABEL.LABEL_WIDTH).form().numberInput().defaultValue(3.0).allowNegative(false).scale(1);
        cfg.view().field(EAMTables.EAM_ASSET_LABEL.LABEL_HEIGHT).form().numberInput().defaultValue(3.0).allowNegative(false).scale(1);
        cfg.view().field(EAMTables.EAM_ASSET_LABEL.PAPER_TYPE_ID).form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_LABEL.LABEL_WIDTH,

                },
                new Object[] {
                        EAMTables.EAM_ASSET_LABEL.LABEL_HEIGHT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_LABEL.PAPER_TYPE_ID
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        LabelGtr g=new LabelGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(AssetLabelServiceProxy.class, AssetLabelPageController.class);
    }
}
