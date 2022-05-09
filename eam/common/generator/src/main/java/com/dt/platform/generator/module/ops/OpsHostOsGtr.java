package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostOs;
import com.dt.platform.domain.ops.ServiceInfo;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class OpsHostOsGtr extends BaseCodeGenerator{


    public OpsHostOsGtr() {
        super(OpsTables.OPS_HOST_OS.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.setRelationField(Host.class,OpsTables.OPS_HOST_OS.HOST_ID, ServiceInfo.class, OpsTables.OPS_HOST_OS.SERVICE_INFO_ID,true);

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_HOST_OS.ID,
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
               .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsHostOsGtr g=new OpsHostOsGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
        //g.generateMenu(HostPositionServiceProxy.class, HostPositionPageController.class);
    }
}
