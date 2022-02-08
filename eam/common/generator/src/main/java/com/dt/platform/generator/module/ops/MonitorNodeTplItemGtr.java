package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorNodeTplItemGtr extends BaseCodeGenerator{


    public MonitorNodeTplItemGtr() {
        super(EAMTables.OPS_MONITOR_NODE_TPL_ITEM.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        //A和B，一对多 ，AA。
        cfg.setRelationField(MonitorNode.class,EAMTables.OPS_MONITOR_NODE_TPL_ITEM.NODE_ID, MonitorTpl.class, EAMTables.OPS_MONITOR_NODE_TPL_ITEM.TPL_CODE,true);
        //cfg.setRelationField(Host.class,EAMTables.OPS_HOST_MID.HOST_ID, ServiceInfo.class, EAMTables.OPS_HOST_MID.SERVICE_INFO_ID,true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_MONITOR_NODE_TPL_ITEM.ID,
                }

        );



        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);





        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_MONITOR_NODE_TPL_ITEM.NODE_ID,

                }
        );

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
        MonitorNodeTplItemGtr g=new MonitorNodeTplItemGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //g.generateMenu(MonitorNodeTplItemServiceProxy.class, MonitorNodeTplItemPageController.class);
    }
}
