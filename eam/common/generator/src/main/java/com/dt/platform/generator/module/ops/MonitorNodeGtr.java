package com.dt.platform.generator.module.ops;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.MonitorEnableEnum;
import com.dt.platform.constants.enums.ops.MonitorIndicatorValueColumnRowsEnum;
import com.dt.platform.constants.enums.ops.MonitorStatusEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.service.impl.MonitorNodeTplItemServiceImpl;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;

public class MonitorNodeGtr extends BaseCodeGenerator{


    public MonitorNodeGtr() {
        super(OpsTables.OPS_MONITOR_NODE.$TABLE,MONITOR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(MonitorVoucher.class,"sshVoucher","ssh凭证","ssh凭证");

     //  cfg.getPoClassFile().addSimpleProperty(MonitorNodeHost.class,"monitorNodeHost","主机信息","主机信息");
        cfg.getPoClassFile().addSimpleProperty(MonitorNodeDb.class,"monitorNodeDb","数据库信息","数据库信息");
        cfg.getPoClassFile().addListProperty(MonitorNodeValue.class,"monitorNodeValueList","数值信息","数值信息");
    //    cfg.getPoClassFile().addListProperty(MonitorNodeListValue.class,"monitorNodeListValueList","列表数值信息","列表数值信息");

        cfg.getPoClassFile().addSimpleProperty(MonitorNodeGroup.class,"monitorNodeGroup","节点分组","节点分组");
        cfg.getPoClassFile().addSimpleProperty(MonitorNodeType.class,"monitorNodeType","节点类型","节点类型");
        cfg.getPoClassFile().addSimpleProperty(MonitorNodeSubtype.class,"monitorNodeSubType","节点子类型","节点子类型");

        cfg.getPoClassFile().addListProperty(MonitorTpl.class,"monitorTplList","监控模版列表","监控模版列表");
        cfg.getPoClassFile().addListProperty(String.class,"monitorTplIds","监控模版Ids","监控模版Ids");


        cfg.view().search().inputLayout(
                new Object[]{

                        OpsTables.OPS_MONITOR_NODE.GROUP_ID,
                        OpsTables.OPS_MONITOR_NODE.STATUS,
                        OpsTables.OPS_MONITOR_NODE.NODE_IP,
                        OpsTables.OPS_MONITOR_NODE.NODE_NAME_SHOW,
                },
                new Object[]{
                        OpsTables.OPS_MONITOR_NODE.TYPE,
                        OpsTables.OPS_MONITOR_NODE.NODE_ENABLED,
                        OpsTables.OPS_MONITOR_NODE.NOTES
                }

        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_IP).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_NAME_SHOW).search().fuzzySearch();


        cfg.view().field(OpsTables.OPS_MONITOR_NODE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.ID).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.SUB_TYPE).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.SUB_TYPE).table().disable(true);


        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_NAME).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_NAME).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_TYPE).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_TYPE).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.PID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.PID).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.CREATE_TIME).table().disable(true);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_IP).form().validate().required();
        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_NAME_SHOW).form().validate().required();

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.STATUS).form().validate().required().form()
                .label("监控状态").radioBox().defaultIndex(0).enumType(MonitorStatusEnum.class);


        cfg.view().field(OpsTables.OPS_MONITOR_NODE.NODE_ENABLED).form().validate().required().form()
                .label("启用状态").radioBox().defaultIndex(0).enumType(MonitorEnableEnum.class);



        cfg.service().addRelationSaveAction(MonitorNodeTplItemServiceImpl.class,MonitorNodeVOMeta.MONITOR_TPL_IDS);

        cfg.view().field(MonitorNodeMeta.MONITOR_TPL_IDS)
                .basic().label("监控模版")
                .table().sort(false).form().selectBox().queryApi(MonitorTplServiceProxy.QUERY_LIST)
                .valueField(MonitorTplMeta.CODE).textField(MonitorTplMeta.NAME)
                .toolbar(false).paging(false).defaultIndex(0)
                .fillWith(MonitorNodeMeta.MONITOR_TPL_LIST).muliti(true);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.SSH_VOUCHER_ID)
                .basic().label("凭证(SSH)")
                .form().selectBox().queryApi(MonitorVoucherServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorVoucherMeta.ID).
                textField(MonitorVoucherMeta.NAME).
                fillWith(MonitorNodeMeta.SSH_VOUCHER).muliti(false);

        cfg.view().field(OpsTables.OPS_MONITOR_NODE.GROUP_ID)
                .basic().label("节点分组")
                .form().selectBox().queryApi(MonitorNodeGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(MonitorNodeGroupMeta.ID).
                textField(MonitorNodeGroupMeta.NAME).
                fillWith(MonitorNodeMeta.MONITOR_NODE_GROUP).muliti(false);


        cfg.view().field(OpsTables.OPS_MONITOR_NODE.TYPE)
                .basic().label("节点分类")
                .form().validate().required().form().selectBox().queryApi(ServiceGroupServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(ServiceGroupMeta.CODE).
                textField(ServiceGroupMeta.NAME).
                fillWith(MonitorNodeMeta.MONITOR_NODE_TYPE).muliti(false);

//        cfg.view().field(OpsTables.OPS_MONITOR_NODE.SUB_TYPE)
//                .basic().label("节点子分类")
//                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_PAGED_LIST)
//                .paging(true).filter(true).toolbar(false)
//                .valueField(ServiceInfoMeta.NAME).
//                textField(ServiceInfoMeta.NAME).
//                fillWith(MonitorNodeMeta.MONITOR_NODE_SUB_TYPE).muliti(false);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE.NODE_IP,
                        OpsTables.OPS_MONITOR_NODE.NODE_NAME_SHOW,
                        OpsTables.OPS_MONITOR_NODE.GROUP_ID,
                },
                new Object[] {
                        MonitorNodeMeta.MONITOR_TPL_IDS,
                        OpsTables.OPS_MONITOR_NODE.NODE_ENABLED,
                        OpsTables.OPS_MONITOR_NODE.STATUS,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE.TYPE,
                        OpsTables.OPS_MONITOR_NODE.SUB_TYPE,

                }
        );

        cfg.view().form().addGroup("数据采集",
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE.SSH_VOUCHER_ID,
                        OpsTables.OPS_MONITOR_NODE.SSH_PORT,
                        OpsTables.OPS_MONITOR_NODE.ZABBIX_AGENT_PORT,
                },

                new Object[] {
                        OpsTables.OPS_MONITOR_NODE.SNMP_PORT,
                        OpsTables.OPS_MONITOR_NODE.SNMP_VERSION,
                        OpsTables.OPS_MONITOR_NODE.SNMP_COMMUNITY,
                },
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE.AGENT_PORT,
                        OpsTables.OPS_MONITOR_NODE.IMPI_PORT,
                        OpsTables.OPS_MONITOR_NODE.JDBC_URL,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_MONITOR_NODE.NOTES,
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
        MonitorNodeGtr g=new MonitorNodeGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        //g.generateMenu(MonitorNodeServiceProxy.class, MonitorNodePageController.class);
    }
}
