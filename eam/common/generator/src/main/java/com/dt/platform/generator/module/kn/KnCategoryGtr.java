package com.dt.platform.generator.module.kn;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.knowledgebase.page.CategoryPageController;
import com.dt.platform.proxy.knowledgebase.CategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class KnCategoryGtr extends BaseCodeGenerator {


    public KnCategoryGtr() {
        super(EAMTables.KN_CATEGORY.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {



        cfg.view().field(EAMTables.KN_CATEGORY.ID).basic().hidden(true);




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        KnCategoryGtr g=new KnCategoryGtr();
        //生成代码
     //   g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
        g.generateMenu(CategoryServiceProxy.class, CategoryPageController.class);
    }

}
