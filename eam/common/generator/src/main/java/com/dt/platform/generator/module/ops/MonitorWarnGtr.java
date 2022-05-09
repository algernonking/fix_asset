package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.ops.MonitorWarnLevelEnum;
import com.dt.platform.constants.enums.ops.MonitorWarnProcessStatusEnum;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorTplTypePageController;
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class MonitorWarnGtr extends BaseCodeGenerator{


    public MonitorWarnGtr() {
        super(OpsTables.OPS_MONITOR_WARN.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(MonitorTpl.class,"tpl","节点模版","节点模版");
        cfg.getPoClassFile().addListProperty(MonitorTplIndicator.class,"tplIndicator","节点指标","节点指标");

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_MONITOR_WARN.STATUS,
                        OpsTables.OPS_MONITOR_WARN.WARN_LEVEL,
                        OpsTables.OPS_MONITOR_WARN.INDICATOR_NAME,
                        OpsTables.OPS_MONITOR_WARN.CONTENT
                },
                new Object[]{
                        OpsTables.OPS_MONITOR_WARN.WARN_TIME,
                        OpsTables.OPS_MONITOR_WARN.HANDLED_TIME
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_MONITOR_WARN.WARN_TIME).search().range();
        cfg.view().field(OpsTables.OPS_MONITOR_WARN.HANDLED_TIME).search().range();
        cfg.view().field(OpsTables.OPS_MONITOR_WARN.INDICATOR_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_WARN.CONTENT).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_MONITOR_WARN.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_WARN.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_MONITOR_WARN.CREATE_TIME).table().disable(true);


        cfg.view().field(OpsTables.OPS_MONITOR_WARN.STATUS).form()
                .label("状态").selectBox().enumType(MonitorWarnProcessStatusEnum.class);

        cfg.view().field(OpsTables.OPS_MONITOR_WARN.WARN_LEVEL).form()
                .label("告警等级").selectBox().enumType(MonitorWarnLevelEnum.class);


       // cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_WARN.STATUS,
                        OpsTables.OPS_MONITOR_WARN.WARN_LEVEL,
                        OpsTables.OPS_MONITOR_WARN.INDICATOR_NAME,
                        OpsTables.OPS_MONITOR_WARN.CONTENT
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_WARN.WARN_TIME,
                        OpsTables.OPS_MONITOR_WARN.HANDLED_TIME,
                        OpsTables.OPS_MONITOR_WARN.NOTES,

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
        MonitorWarnGtr g=new MonitorWarnGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        g.generateMenu(MonitorTplTypeServiceProxy.class, MonitorTplTypePageController.class);
    }
}
