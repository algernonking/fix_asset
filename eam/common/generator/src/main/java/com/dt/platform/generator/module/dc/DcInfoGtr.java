package com.dt.platform.generator.module.dc;


import com.dt.platform.constants.db.EAMTables;
//import com.dt.platform.datacenter.controller.DcInfoController;
//import com.dt.platform.datacenter.page.DcInfoPageController;
//import com.dt.platform.proxy.datacenter.DcInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DcInfoGtr extends BaseCodeGenerator {


    public DcInfoGtr() {
        super(EAMTables.DC_INFO.$TABLE,BASIC_DATA_MENU_ID,"");
    }


    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.DC_INFO.ID)
                .basic().hidden(true);
        cfg.view().field(EAMTables.DC_INFO.DC_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_INFO.DC_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_INFO.DC_POSITION).search().fuzzySearch();
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
        DcInfoGtr g=new DcInfoGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
        System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("472099190273474560");
        //生成菜单
       // g.generateMenu(DcInfoServiceProxy.class, DcInfoPageController.class);
    }

}
