package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.datacenter.page.RackAreaPageController;
import com.dt.platform.proxy.datacenter.RackAreaServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

//import com.dt.platform.datacenter.controller.DcInfoController;
//import com.dt.platform.datacenter.page.RackPageController;
//import com.dt.platform.domain.datacenter.meta.DcInfoMeta;
//import com.dt.platform.domain.datacenter.meta.DcInfoVOMeta;
//import com.dt.platform.proxy.datacenter.DcInfoServiceProxy;
//import com.dt.platform.proxy.datacenter.RackServiceProxy;

public class DcRackAreaGtr extends BaseCodeGenerator {
    public DcRackAreaGtr() {
        super(EAMTables.DC_RACK_AREA.$TABLE,BASIC_RACK_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.DC_RACK_AREA.ID)
                .basic().hidden(true);

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
        DcRackAreaGtr g=new DcRackAreaGtr();
        //生成代码
      //  g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        g.removeByBatchId("473534196405501952");
        //生成菜单
       g.generateMenu(RackAreaServiceProxy.class, RackAreaPageController.class);
    }
}
