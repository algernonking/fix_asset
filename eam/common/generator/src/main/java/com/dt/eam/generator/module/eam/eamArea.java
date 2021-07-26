package com.dt.eam.generator.module.eam;

import com.dt.eam.constants.db.EAMTables;
import com.dt.eam.eam.page.AreaPageController;
import com.dt.eam.eam.page.WarehousePageController;
import com.dt.eam.proxy.eam.AreaServiceProxy;
import com.dt.eam.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class eamArea  extends BaseCodeGenerator{
    public eamArea() {
        super(EAMTables.EAM_AREA.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        eamArea g=new eamArea();
        //生成代码
         // g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
        g.generateMenu(AreaServiceProxy.class, AreaPageController.class);
    }
}
