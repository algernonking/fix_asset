package com.dt.eam.generator.module.eam;

import com.dt.eam.constants.db.EAMTables;
import com.dt.eam.eam.page.MaintainerPageController;
import com.dt.eam.eam.page.ManufacturerPageController;
import com.dt.eam.proxy.eam.MaintainerServiceProxy;
import com.dt.eam.proxy.eam.ManufacturerServiceProxy;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;

public class EamManufacturer extends BaseCodeGenerator{

    public void generateConfig() throws Exception {
        //创建模块配置
        ModuleContext cfg=createModuleConfig(Table, 1);
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
        EamManufacturer g=new EamManufacturer();
        g.Table=EAMTables.EAM_MANUFACTURER.$TABLE;
        //生成代码
        g.generateConfig();
        g.EAM_MENU_ID="471620638545543168";
        //生成菜单
      //  g.generatorMenu(ManufacturerServiceProxy.class, ManufacturerPageController.class,null);
    }
}
