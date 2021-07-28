package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.module.eam.Brand;
import com.dt.platform.ops.page.ServicetypePageController;
import com.dt.platform.proxy.ops.ServicetypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ServiceType extends BaseCodeGenerator{


    public ServiceType() {
        super(EAMTables.OPS_SERVICETYPE.$TABLE,BASIC_SETTING_MENU_ID);
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
        ServiceType g=new ServiceType();
        //生成代码
       // g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
        g.generateMenu(ServicetypeServiceProxy.class, ServicetypePageController.class);
    }
}
