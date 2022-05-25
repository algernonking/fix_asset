package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class EamSafetylevelGtr extends BaseCodeGenerator{

    public EamSafetylevelGtr() {
        super(EAMTables.EAM_SAFETYLEVEL.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_SAFETYLEVEL.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_SAFETYLEVEL.SAFETY_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_SAFETYLEVEL.SAFETY_NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_SAFETYLEVEL.SAFETY_NAME,
                        EAMTables.EAM_SAFETYLEVEL.SAFETY_CODE,

                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_SAFETYLEVEL.SAFETY_CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_SAFETYLEVEL.SAFETY_NAME).form().validate().required();


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamSafetylevelGtr g=new EamSafetylevelGtr();
        //生成代码
        g.generateCode();
        //生成菜单
//        g.generateMenu(SafetylevelServiceProxy.class, SafetylevelPageController.class);
    }
}
