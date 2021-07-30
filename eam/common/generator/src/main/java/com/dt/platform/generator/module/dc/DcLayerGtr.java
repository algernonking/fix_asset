package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.datacenter.page.AreaPageController;
import com.dt.platform.datacenter.page.LayerPageController;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class DcLayerGtr extends BaseCodeGenerator {
    public DcLayerGtr() {
        super(EAMTables.DC_LAYER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.DC_LAYER.ID).basic().hidden(true);


        cfg.view().field(EAMTables.DC_LAYER.NAME).search().fuzzySearch();



        cfg.view().field(EAMTables.DC_LAYER.NOTES).search().fuzzySearch();

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
        DcLayerGtr g=new DcLayerGtr();
        //生成代码
       // g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
        g.generateMenu(LayerServiceProxy.class, LayerPageController.class);
    }
}
