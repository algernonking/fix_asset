package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;


import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.eam.page.ResidualStrategyPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.ResidualStrategyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class EamResidualStrategyGtr extends BaseCodeGenerator {

    public EamResidualStrategyGtr() {
        super(EAMTables.EAM_RESIDUAL_STRATEGY.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_RESIDUAL_STRATEGY.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_RESIDUAL_STRATEGY.VALUE).basic().search().hidden(true);
        cfg.view().field(EAMTables.EAM_RESIDUAL_STRATEGY.STATUS).basic().search().hidden(true);
        cfg.view().field(EAMTables.EAM_RESIDUAL_STRATEGY.DEPRECIATION_RATE).basic().search().hidden(true);
        cfg.view().field(EAMTables.EAM_RESIDUAL_STRATEGY.RESIDUALVALUE_RATE).basic().search().hidden(true);


        cfg.view().field(EAMTables.EAM_RESIDUAL_STRATEGY.STATUS).basic().label("状态")
                .form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);


        cfg.view().field(EAMTables.EAM_RESIDUAL_STRATEGY.NAME).form().validate().required();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_RESIDUAL_STRATEGY.NAME,
                        EAMTables.EAM_RESIDUAL_STRATEGY.NOTES,

                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }




    public static void main(String[] args) throws Exception {
        EamResidualStrategyGtr g=new EamResidualStrategyGtr();
        //生成代码
        g.generateCode();
        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(ResidualStrategyServiceProxy.class, ResidualStrategyPageController.class);
    }


}
