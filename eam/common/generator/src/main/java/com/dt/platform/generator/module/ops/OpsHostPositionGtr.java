package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.ops.HostMonitorStatusEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;

import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class OpsHostPositionGtr extends BaseCodeGenerator{


    public OpsHostPositionGtr() {
        super(OpsTables.OPS_HOST_POSITION.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_HOST_POSITION.ID).basic().hidden(true);


        cfg.view().field(OpsTables.OPS_HOST_POSITION.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST_POSITION.NAME).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_HOST_POSITION.NAME).form().validate().required();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_HOST_POSITION.NAME,
                        OpsTables.OPS_HOST_POSITION.NOTES,
                }
        );


        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
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
        OpsHostPositionGtr g=new OpsHostPositionGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
        //g.generateMenu(HostPositionServiceProxy.class, HostPositionPageController.class);
    }
}
