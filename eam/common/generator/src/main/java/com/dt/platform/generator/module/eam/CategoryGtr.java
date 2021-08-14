package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.CategoryPageController;
import com.dt.platform.proxy.eam.CategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CategoryGtr extends BaseCodeGenerator{
    public CategoryGtr() {
        super(EAMTables.EAM_CATEGORY.$TABLE,BASIC_SETTING_MENU_ID);
    }


    public void generateCode() throws Exception {


        cfg.view().field(EAMTables.EAM_CATEGORY.ID)
                .basic().hidden(true);



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CategoryGtr g=new CategoryGtr();
        //生成代码


        g.generateCode();


        //生成菜单
      //  g.removeByBatchId("");
        //  g.generateMenu(CategoryServiceProxy.class, CategoryPageController.class);
    }
}
