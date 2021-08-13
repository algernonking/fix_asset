package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.ServiceTypeEnum;
import com.github.foxnic.generator.config.WriteMode;

public class OpsServiceGtr extends BaseCodeGenerator{


    public OpsServiceGtr() {
        super(EAMTables.OPS_SERVICE.$TABLE,BASIC_DATA_MENU_ID,"");
    }

    public void generateCode() throws Exception {

//        cfg.getPoClassFile().addSimpleProperty(ServiceType.class,"serviceType","类型","");

        cfg.view().field(EAMTables.OPS_SERVICE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_SERVICE.CREATE_TIME).list().hidden();
        cfg.view().field(EAMTables.OPS_SERVICE.SERVICE_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_SERVICE.SERVICE_NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.OPS_SERVICE.TYPE).basic().label("服务类型")
                .form().validate().required().form().radioBox().enumType(ServiceTypeEnum.class);


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
        OpsServiceGtr g=new OpsServiceGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
//        g.generateMenu(OpsServiceServiceProxy.class, OpsServicePageController.class);
    }
}
