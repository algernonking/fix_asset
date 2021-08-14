package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.ServiceTypeEnum;
import com.dt.platform.ops.page.ServiceCategoryPageController;
import com.dt.platform.proxy.ops.ServiceCategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsServiceCategoryGtr extends BaseCodeGenerator{


    public OpsServiceCategoryGtr() {
        super(EAMTables.OPS_SERVICE_CATEGORY.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.OPS_SERVICE_CATEGORY.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_SERVICE_CATEGORY.CREATE_TIME).table().hidden();
        cfg.view().field(EAMTables.OPS_SERVICE_CATEGORY.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_SERVICE_CATEGORY.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.OPS_SERVICE_CATEGORY.GROUP_ID).basic().label("服务分组")
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
        OpsServiceCategoryGtr g=new OpsServiceCategoryGtr();
        //生成代码
       // g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.removeByBatchId("474335473372758016");
     //   g.generateMenu(ServiceCategoryServiceProxy.class, ServiceCategoryPageController.class);
    }
}
