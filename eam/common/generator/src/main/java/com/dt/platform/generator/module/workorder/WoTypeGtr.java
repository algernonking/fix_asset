package com.dt.platform.generator.module.workorder;

import com.dt.platform.constants.db.EAMTables;

import com.github.foxnic.generator.config.WriteMode;

public class WoTypeGtr extends BaseCodeGenerator{


    public WoTypeGtr() {
        super(EAMTables.WORKORDER_CATEGORY.$TABLE,BASIC_SETTING_MENU_ID,"");
    }

    public void generateCode() throws Exception {


//
        cfg.view().field(EAMTables.WORKORDER_CATEGORY.ID).basic().hidden(true);
        cfg.view().field(EAMTables.WORKORDER_CATEGORY.SORT).search().hidden();



        cfg.view().search().inputLayout(
                new Object[]{

                        EAMTables.WORKORDER_CATEGORY.NAME,

                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        WoTypeGtr g=new WoTypeGtr();
        //生成代码
        //g.generateCode();
        //移除之前生成的菜单，视情况执行

       // g.generateMenu(WorkorderTypeServiceProxy.class, WorkorderTypePageController.class);
    }
}
