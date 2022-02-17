package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.MonitorEnableEnum;
import com.dt.platform.constants.enums.ops.MonitorTplGraphTypeEnum;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.meta.MonitorTplGraphMeta;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.domain.ops.meta.MonitorTplTypeMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorTplGraphPageController;
import com.dt.platform.proxy.ops.MonitorTplGraphServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorTplGraphGtr extends BaseCodeGenerator{


    public MonitorTplGraphGtr() {
        super(EAMTables.OPS_MONITOR_TPL_GRAPH.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(MonitorTpl.class,"tpl","节点模版","节点模版");
        cfg.getPoClassFile().addListProperty(MonitorTplGraphItem.class,"graphItem","指标","指标");


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_MONITOR_TPL_GRAPH.NAME,
                        EAMTables.OPS_MONITOR_TPL_GRAPH.NOTES,
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.TPL_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.ID).table().disable(true);
        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.CREATE_TIME).table().disable(true);

        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.STATUS).form().validate().required().form()
                .label("状态").radioBox().defaultIndex(0).enumType(MonitorEnableEnum.class);

        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.GRAPH_TYPE).form().validate().required().form()
                .label("类型").radioBox().defaultIndex(0).enumType(MonitorTplGraphTypeEnum.class);

        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.TPL_CODE)
                .basic().label("图形模版")
                .form().selectBox().queryApi(MonitorTplServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorTplMeta.CODE).
                textField(MonitorTplMeta.NAME).
                fillWith(MonitorTplGraphMeta.TPL).muliti(false);

        cfg.view().field(EAMTables.OPS_MONITOR_TPL_GRAPH.NAME).form().validate().required();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_MONITOR_TPL_GRAPH.NAME,
                        EAMTables.OPS_MONITOR_TPL_GRAPH.STATUS,
                        EAMTables.OPS_MONITOR_TPL_GRAPH.GRAPH_TYPE,
                },
                new Object[] {
                        EAMTables.OPS_MONITOR_TPL_GRAPH.TPL_CODE,
                        EAMTables.OPS_MONITOR_TPL_GRAPH.SORT,
                },
                new Object[] {
                        EAMTables.OPS_MONITOR_TPL_GRAPH.GRAPH_WIDTH,
                        EAMTables.OPS_MONITOR_TPL_GRAPH.GRAPH_HEIGHT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_MONITOR_TPL_GRAPH.CONTENT,
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_MONITOR_TPL_GRAPH.NOTES,
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
        MonitorTplGraphGtr g=new MonitorTplGraphGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // g.generateMenu(MonitorTplGraphServiceProxy.class, MonitorTplGraphPageController.class);


    }
}
