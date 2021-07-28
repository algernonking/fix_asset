package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.EAMTables;
//import com.dt.platform.datacenter.controller.DcInfoController;
//import com.dt.platform.datacenter.page.RackPageController;
//import com.dt.platform.domain.datacenter.meta.DcInfoMeta;
//import com.dt.platform.domain.datacenter.meta.DcInfoVOMeta;
//import com.dt.platform.proxy.datacenter.DcInfoServiceProxy;
//import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class DcRack extends BaseCodeGenerator {
    public DcRack() {
        super(EAMTables.DC_RACK.$TABLE,BASIC_RACK_MENU_ID);
    }

    public void generateCode() throws Exception {

        //cfg.getVoClassFile().addSimpleProperty(String.class,"dcName","数据中心","");
//        cfg.field(EAMTables.DC_RACK.ID).hideInForm().hideInSearch();
//
//
//
//        cfg.field(EAMTables.DC_RACK.DC_ID).selectField().
//                queryApi(DcInfoServiceProxy.QUERY_LIST)
//                .muliti(false).
//                fillBy(DcInfoVOMeta.ID);
//
//        cfg.field(EAMTables.DC_RACK.RACK_CAPTICAL).hideInSearch();
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
        DcRack g=new DcRack();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
        //生成菜单
       //g.generateMenu(RackServiceProxy.class, RackPageController.class);
    }
}
