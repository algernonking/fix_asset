package com.dt.platform.generator.module.kn;

import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.constants.db.KnTables;
import com.dt.platform.knowledgebase.page.CategoryPageController;
import com.dt.platform.proxy.knowledgebase.CategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class KnCategoryGtr extends BaseCodeGenerator {


    public KnCategoryGtr() {
        super(KnTables.KN_CATEGORY.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {




        cfg.view().field(KnTables.KN_CATEGORY.ID).basic().hidden(true);


        cfg.view().field(KnTables.KN_CATEGORY.CATEGORY_CODE).search().hidden(true);

        cfg.view().field(KnTables.KN_CATEGORY.CATEGORY_NAME).search().hidden(true);
        cfg.view().field(KnTables.KN_CATEGORY.SORT).search().hidden(true);
        cfg.view().field(KnTables.KN_CATEGORY.PARENT_ID).search().hidden(true);
        cfg.view().field(KnTables.KN_CATEGORY.HIERARCHY).search().hidden(true);
        cfg.view().field(KnTables.KN_CATEGORY.HIERARCHY_NAME).search().hidden(true);
        cfg.view().field(KnTables.KN_CATEGORY.NOTES).search().hidden(true);



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
                .setListPage(WriteMode.CREATE_IF_NOT_EXISTS) //列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        KnCategoryGtr g=new KnCategoryGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
     // g.removeByBatchId("483209782904225792");
        //生成菜单
      //g.generateMenu(CategoryServiceProxy.class, CategoryPageController.class);
    }

}
