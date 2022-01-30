package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.MonitorNodeHost;
import com.dt.platform.domain.ops.MonitorNodeSubtype;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.MonitorNodeValue;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorNodePageController;
import com.dt.platform.proxy.ops.MonitorNodeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class MonitoryNodeGtr extends BaseCodeGenerator{


    public MonitoryNodeGtr() {
        super(EAMTables.OPS_MONITOR_NODE.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.getPoClassFile().addSimpleProperty(MonitorNodeType.class,"monitorNodeType","节点类型","节点类型");
        cfg.getPoClassFile().addSimpleProperty(MonitorNodeSubtype.class,"monitorNodeSubType","节点子类型","节点子类型");
        cfg.getPoClassFile().addSimpleProperty(MonitorNodeHost.class,"monitorNodeHost","主机信息","主机信息");
        cfg.getPoClassFile().addListProperty(MonitorNodeValue.class,"monitorNodeValueList","数值信息","数值信息");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_MONITOR_NODE.NODE_IP,
                        EAMTables.OPS_MONITOR_NODE.NODE_NAME,

                }

        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.OPS_MONITOR_NODE.NODE_IP).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_MONITOR_NODE.NODE_NAME).search().fuzzySearch();


        cfg.view().field(EAMTables.OPS_MONITOR_NODE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_MONITOR_NODE.ID).table().disable(true);
        cfg.view().field(EAMTables.OPS_MONITOR_NODE.CREATE_TIME).table().disable(true);





        cfg.view().field(EAMTables.OPS_MONITOR_NODE.NODE_IP).form().validate().required();

        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_MONITOR_NODE.NODE_IP,
                        EAMTables.OPS_MONITOR_NODE.NODE_NAME,
                        EAMTables.OPS_MONITOR_NODE.NOTES,
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
        MonitoryNodeGtr g=new MonitoryNodeGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //g.generateMenu(MonitorNodeServiceProxy.class, MonitorNodePageController.class);
    }
}
