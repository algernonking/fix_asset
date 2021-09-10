package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.CategoryFinancePageController;
import com.dt.platform.proxy.eam.CategoryFinanceServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetCategoryFinanceGtr extends BaseCodeGenerator {

    public EamAssetCategoryFinanceGtr() {
        super(EAMTables.EAM_CATEGORY_FINANCE.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetCategoryFinanceGtr g=new EamAssetCategoryFinanceGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(CategoryFinanceServiceProxy.class, CategoryFinancePageController.class);
    }

}
