package com.dt.platform.generator.module.ops;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorNodeHostGtr extends BaseCodeGenerator{


    public MonitorNodeHostGtr() {
        super(OpsTables.OPS_MONITOR_NODE_HOST.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_NODE_HOST.NOTES,
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE_HOST.NOTES).search().fuzzySearch();



        cfg.view().field(OpsTables.OPS_MONITOR_NODE_HOST.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_HOST.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE_HOST.CREATE_TIME).table().disable(true);




        //cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE_HOST.NOTES,

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
        MonitorNodeHostGtr g=new MonitorNodeHostGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(MonitorNodeHostServiceProxy.class, MonitorNodeHostPageController.class);
    }
}
