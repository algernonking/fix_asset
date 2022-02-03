package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.meta.MonitorNodeTypeMeta;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.MonitorTplPageController;
import com.dt.platform.proxy.ops.MonitorNodeTypeServiceProxy;
import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorTplGtr extends BaseCodeGenerator{


    public MonitorTplGtr() {
        super(EAMTables.OPS_MONITOR_TPL.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(MonitorNodeType.class,"tplType","节点模版类型","节点模版类型");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_MONITOR_TPL.TYPE,
                        EAMTables.OPS_MONITOR_TPL.NAME,
                        EAMTables.OPS_MONITOR_TPL.CODE,

                }

        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.OPS_MONITOR_TPL.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_MONITOR_TPL.CODE).search().fuzzySearch();

        cfg.view().field(EAMTables.OPS_MONITOR_TPL.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_MONITOR_TPL.ID).table().disable(true);
        cfg.view().field(EAMTables.OPS_MONITOR_TPL.CREATE_TIME).table().disable(true);



        cfg.view().field(EAMTables.OPS_MONITOR_TPL.TYPE)
                .basic().label("归类")
                .form().selectBox().queryApi(MonitorNodeTypeServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorNodeTypeMeta.CODE).
                textField(MonitorNodeTypeMeta.NAME).
                fillWith(MonitorTplMeta.TPL_TYPE).muliti(false);



        cfg.view().field(EAMTables.OPS_MONITOR_TPL.CODE).form().validate().required();

       // cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_MONITOR_TPL.TYPE,
                        EAMTables.OPS_MONITOR_TPL.NAME,
                        EAMTables.OPS_MONITOR_TPL.CODE,
                        EAMTables.OPS_MONITOR_TPL.NOTES,
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
        MonitorTplGtr g=new MonitorTplGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
       g.generateMenu(MonitorTplServiceProxy.class, MonitorTplPageController.class);
    }
}
