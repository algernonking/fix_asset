package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.ServiceTypeEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.ServiceGroupPageController;
import com.dt.platform.proxy.ops.ServiceGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class OpsServiceGroupGtr extends BaseCodeGenerator{


    public OpsServiceGroupGtr() {
        super(OpsTables.OPS_SERVICE_GROUP.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_SERVICE_GROUP.NAME).search().fuzzySearch();



        cfg.view().field(OpsTables.OPS_SERVICE_GROUP.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_SERVICE_GROUP.NAME).form().validate().required();
        cfg.view().field(OpsTables.OPS_SERVICE_GROUP.CODE).form().validate().required();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_SERVICE_GROUP.NAME,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsServiceGroupGtr g=new OpsServiceGroupGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.removeByBatchId("474335473372758016");
        g.generateMenu(ServiceGroupServiceProxy.class, ServiceGroupPageController.class);
    }
}
