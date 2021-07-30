package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.ops.page.ServiceTypePageController;
import com.dt.platform.proxy.ops.ServiceTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ServiceType extends BaseCodeGenerator{


    public ServiceType() {
        super(EAMTables.OPS_SERVICE_TYPE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.OPS_SERVICE_TYPE.ID)
                .basic().hidden(true);
        cfg.view().field(EAMTables.OPS_SERVICE_TYPE.NAME).search().fuzzySearch();

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
      //  g.generateCode();

        //移除之前生成的菜单，视情况执行
       g.removeByBatchId("473490445867941888");
        g.removeByBatchId("472419134236262400");
        //生成菜单
        g.generateMenu(ServiceTypeServiceProxy.class, ServiceTypePageController.class);
    }
}
