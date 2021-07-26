package com.dt.platform.generator.module.dc;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.datacenter.controller.DcInfoController;
import com.dt.platform.proxy.datacenter.DcInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DcInfo extends BaseCodeGenerator {


    public DcInfo() {
        super(EAMTables.DC_INFO.$TABLE,BASIC_DATA_MENU_ID,"");
    }

    public void generateCode() throws Exception {

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
        DcInfo g=new DcInfo();
        //生成代码
        //g.generateCode();

        //移除之前生成的菜单，视情况执行
        System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
        //生成菜单
        g.generateMenu(DcInfoServiceProxy.class, DcInfoController.class);
    }

}
