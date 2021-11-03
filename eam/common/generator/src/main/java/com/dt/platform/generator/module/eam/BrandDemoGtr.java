package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.BrandDemoPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.BrandDemoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class BrandDemoGtr extends BaseCodeGenerator {


    public BrandDemoGtr() {
        super(EAMTables.EAM_BRAND_DEMO.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_BRAND_DEMO.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_BRAND_DEMO.BRAND_NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_BRAND_DEMO.BRAND_NAME).form().validate().required();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_BRAND_DEMO.BRAND_NAME,
                        EAMTables.EAM_BRAND_DEMO.SORT
                }
        );

       // cfg.view().search().labelWidth(1, Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        BrandDemoGtr g=new BrandDemoGtr();
        //生成代码
//        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单

        g.generateMenu(BrandDemoServiceProxy.class, BrandDemoPageController.class);
    }

}
