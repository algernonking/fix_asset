package com.dt.platform.generator.module.ops;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostMid;
import com.dt.platform.domain.ops.ServiceInfo;
import com.github.foxnic.generator.config.WriteMode;

public class OpsHostMidGtr extends BaseCodeGenerator{


    public OpsHostMidGtr() {
        super(OpsTables.OPS_HOST_MID.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        //cfg.setRelationField(HostMid.class,HostMid.class,OpsTables.OPS_HOST_MID.HOST_ID, OpsTables.OPS_HOST_MID.SERVICE_INFO_ID,true);

        cfg.setRelationField(Host.class,OpsTables.OPS_HOST_MID.HOST_ID, ServiceInfo.class, OpsTables.OPS_HOST_MID.SERVICE_INFO_ID,true);


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_HOST_MID.ID,
                }
        );



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
        OpsHostMidGtr g=new OpsHostMidGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
        //g.generateMenu(HostPositionServiceProxy.class, HostPositionPageController.class);
    }
}
