package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostDb;
import com.dt.platform.domain.ops.ServiceInfo;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class OpsHostDbGtr extends BaseCodeGenerator{


    public OpsHostDbGtr() {
        super(OpsTables.OPS_HOST_DB.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        //指定该表为关系表
        cfg.setRelationField(Host.class,OpsTables.OPS_HOST_DB.HOST_ID, ServiceInfo.class, OpsTables.OPS_HOST_DB.SERVICE_INFO_ID,true);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码

        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsHostDbGtr g=new OpsHostDbGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
        //g.generateMenu(HostPositionServiceProxy.class, HostPositionPageController.class);
    }
}
