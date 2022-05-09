package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.ops.HostMonitorStatusEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.service.impl.HostDbServiceImpl;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.ops.service.impl.HostOsServiceImpl;
import com.dt.platform.proxy.ops.HostPositionServiceProxy;
import com.dt.platform.proxy.ops.InformationSystemServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import com.dt.platform.constants.db.OpsTables;
public class OpsHostGtr extends BaseCodeGenerator{


    public OpsHostGtr() {
        super(OpsTables.OPS_HOST.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(Voucher.class,"voucherList","凭证","凭证");
        cfg.getPoClassFile().addListProperty(String.class,"voucherIds","凭证","凭证");

        cfg.getPoClassFile().addSimpleProperty(InformationSystem.class,"infoSystem","信息系统","信息系统");

        cfg.getPoClassFile().addSimpleProperty(HostPosition.class,"position","所在位置","所在位置");


        cfg.getPoClassFile().addListProperty(ServiceInfo.class,"hostDbList","数据库","数据库");
        cfg.getPoClassFile().addListProperty(String.class,"hostDbIds","数据库列表","数据库");


        cfg.getPoClassFile().addListProperty(ServiceInfo.class,"hostMiddlewareList","中间件","中间件");
        cfg.getPoClassFile().addListProperty(String.class,"hostMiddlewareIds","中间件列表","中间件");


        cfg.getPoClassFile().addListProperty(ServiceInfo.class,"hostOsList","操作系统","操作系统");
        cfg.getPoClassFile().addListProperty(String.class,"hostOsIds","操作系统列表","操作系统");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"backupMethod","备份情况","备份情况");



        cfg.view().field(OpsTables.OPS_HOST.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.ARCH).table().disable(true);
        cfg.view().field(OpsTables.OPS_HOST.HOST_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST.HOST_MEMORY).search().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.HOST_CPU).search().hidden(true);

        cfg.view().field(OpsTables.OPS_HOST.DIRECTOR_USERNAME).search().fuzzySearch().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_APP_USED).search().fuzzySearch().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_DB_ADMIN).search().fuzzySearch().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_DB_USED).search().fuzzySearch().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_OS_ADMIN).search().fuzzySearch().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_OPS_OPER).search().fuzzySearch().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_OTHER).search().fuzzySearch().hidden(true);

        cfg.view().field(OpsTables.OPS_HOST.OFFLINE_TIME).search().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.ONLINE_TIME).search().hidden(true);

        cfg.view().field(OpsTables.OPS_HOST.HOST_NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST.HOST_IP).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST.HOST_VIP).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST.HOST_CONF).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_HOST.DIRECTOR_USERNAME).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_HOST.HOST_CONF).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.HOST_MEMORY).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.HOST_CPU).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_OPS_OPER).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_OS_ADMIN).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.USER_OTHER).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.OFFLINE_TIME).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.ONLINE_TIME).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.LABELS).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.CREATE_TIME).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.HOST_NOTES).table().hidden(true);
        cfg.view().field(OpsTables.OPS_HOST.PASSWORD_STRATEGY_ID).table().hidden(true);



//        //保存关系
        cfg.service().addRelationSaveAction(HostMidServiceImpl.class,HostVOMeta.HOST_MIDDLEWARE_IDS);
        cfg.service().addRelationSaveAction(HostOsServiceImpl.class,HostVOMeta.HOST_OS_IDS);
        cfg.service().addRelationSaveAction(HostDbServiceImpl.class,HostVOMeta.HOST_DB_IDS);



        //单选组织，包括公司和部门，并指定根节点


        cfg.view().field(OpsTables.OPS_HOST.ONLINE_TIME)
                .form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(OpsTables.OPS_HOST.OFFLINE_TIME)
                .form().dateInput().format("yyyy-MM-dd")
                .search().range();

        cfg.view().field(HostMeta.HOST_DB_IDS)
                .basic().label("数据库")
                .table().sort(false)
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST+"?groupId=db")
                .valueField(ServiceInfoMeta.ID).textField(ServiceInfoMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(HostMeta.HOST_DB_LIST).muliti(true);


        cfg.view().field(HostMeta.HOST_MIDDLEWARE_IDS)
                .basic().label("中间件")
                .table().sort(false)
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST+"?groupId=mid")
                .valueField(ServiceInfoMeta.ID).textField(ServiceInfoMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(HostMeta.HOST_MIDDLEWARE_LIST).muliti(true);

        cfg.view().field(HostMeta.HOST_OS_IDS)
                .basic().label("操作系统")
                .table().sort(false)
                .form().validate().required().form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST+"?groupId=os")
                .valueField(ServiceInfoMeta.ID).textField(ServiceInfoMeta.NAME)
                .toolbar(false).paging(false).defaultIndex(0)
                .fillWith(HostMeta.HOST_OS_LIST).muliti(false);


        cfg.view().field(HostMeta.POSITION_ID)
                .basic().label("所在位置")
                .table().sort(false)
                .form().selectBox().queryApi(HostPositionServiceProxy.QUERY_LIST)
                .valueField(HostPositionMeta.ID).textField(ServiceInfoMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(HostMeta.POSITION).muliti(false);

        cfg.view().field(HostMeta.SYSTEM_ID)
                .basic().label("信息系统")
                .table().sort(false)
                .form().selectBox().queryApi(InformationSystemServiceProxy.QUERY_LIST)
                .valueField(InformationSystemMeta.ID).textField(InformationSystemMeta.NAME)
                .toolbar(false).paging(false).defaultIndex(0)
                .fillWith(HostMeta.INFO_SYSTEM).muliti(false);

        cfg.view().field(HostMeta.HOST_NOTES).form().textArea().height(30);



        cfg.view().field(HostVOMeta.VOUCHER_IDS)
                .basic().label("用户凭证")
                .table().sort(false)
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST+"?groupId=os")
                .valueField("user_code").textField("voucher")
                .toolbar(false).paging(false)
                .fillWith(HostMeta.VOUCHER_LIST).muliti(true);


        cfg.view().field(HostVOMeta.HOST_BACKUP_METHOD)
                .basic().label("备份方式")
                .table().sort(false)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_host_backup_method")
                .valueField("id").textField("label")
                .toolbar(false).paging(false)
                .fillWith(HostMeta.BACKUP_METHOD).muliti(false);


        cfg.view().field(OpsTables.OPS_HOST.HOST_TYPE)
                .form().validate().required()
                .form().selectBox().dict(DictEnum.OPS_HOST_TYPE).filter(true).toolbar(false).muliti(false).defaultIndex(0);

//        cfg.view().field(OpsTables.OPS_HOST.HOST_BACKUP_METHOD)
//                .form().selectBox().dict(DictEnum.OPS_HOST_BACKUP_METHOD).filter(true).toolbar(false).muliti(false).defaultIndex(0);

        cfg.view().field(OpsTables.OPS_HOST.PASSWORD_STRATEGY_ID)
                .form().selectBox().dict(DictEnum.OPS_HOST_PASSWORD_STRATEGY);


        cfg.view().field(OpsTables.OPS_HOST.ENVIRONMENT).basic().label("所在环境")
                .form().selectBox().dict(DictEnum.OPS_ENVIRONMENT).defaultIndex(0);


        cfg.view().field(OpsTables.OPS_HOST.STATUS).basic().label("主机状态")
                .form().validate().required()
                .form().radioBox().enumType(HostStatusEnum.class).defaultIndex(0);


        cfg.view().field(OpsTables.OPS_HOST.MONITOR_STATUS).basic().label("监控状态")
                .form().radioBox().enumType(HostMonitorStatusEnum.class).defaultIndex(0);



        cfg.view().field(OpsTables.OPS_HOST.HOST_NAME).form().validate().required();

        cfg.view().field(OpsTables.OPS_HOST.USER_OTHER).form().textArea().height(30);

        cfg.view().list().addToolButton("数据导出","exportHost",null,"ops_host:export");

        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_HOST.STATUS,
                        OpsTables.OPS_HOST.SYSTEM_ID,
                        OpsTables.OPS_HOST.HOST_VIP,
                        OpsTables.OPS_HOST.HOST_IP,
                },
                new Object[]{
                        OpsTables.OPS_HOST.HOST_NAME,
                        HostMeta.HOST_OS_IDS,
                        HostMeta.HOST_DB_IDS,
                        HostMeta.HOST_MIDDLEWARE_IDS
                },
                new Object[]{
                        OpsTables.OPS_HOST.POSITION_ID,
                        OpsTables.OPS_HOST.ENVIRONMENT,
                        OpsTables.OPS_HOST.LABELS,
                        OpsTables.OPS_HOST.HOST_NOTES,
                }
        );
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //分成分组布局
        cfg.view().formWindow().width("98%");
        cfg.view().formWindow().bottomSpace(50);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        OpsTables.OPS_HOST.HOST_NAME,
                        OpsTables.OPS_HOST.STATUS,
                        OpsTables.OPS_HOST.HOST_TYPE
                }, new Object[] {
                        OpsTables.OPS_HOST.SYSTEM_ID,
                        OpsTables.OPS_HOST.ENVIRONMENT,
                        OpsTables.OPS_HOST.DIRECTOR_USERNAME
                },new Object[] {
                        OpsTables.OPS_HOST.POSITION_ID,
                        OpsTables.OPS_HOST.ONLINE_TIME,
                        OpsTables.OPS_HOST.OFFLINE_TIME,
                }
        );
        cfg.view().form().addGroup("操作系统",
                new Object[] {
                        OpsTables.OPS_HOST.HOST_CPU,
                        OpsTables.OPS_HOST.HOST_MEMORY,
                  },
                new Object[] {
                        OpsTables.OPS_HOST.HOST_IP,
                        OpsTables.OPS_HOST.HOST_VIP
                },
                new Object[] {
                        OpsTables.OPS_HOST.HOST_CONF
                }
        );
        cfg.view().form().addGroup("系统、数据库和中间件",
                new Object[]{
                        HostMeta.HOST_OS_IDS,
                },
                new Object[]{
                        HostMeta.HOST_DB_IDS,
                },
                new Object[]{
                        HostMeta.HOST_MIDDLEWARE_IDS
                }
        );

        cfg.view().form().addGroup("用户情况",
                new Object[] {
                        OpsTables.OPS_HOST.USER_APP_USED,
                        OpsTables.OPS_HOST.USER_OPS_OPER,

            },
                new Object[] {
                        OpsTables.OPS_HOST.USER_DB_ADMIN,
                        OpsTables.OPS_HOST.USER_DB_USED,

                },
                new Object[] {
                        OpsTables.OPS_HOST.USER_OS_ADMIN,

                }
        );
            cfg.view().form().addGroup(null,

                    new Object[] {
                            OpsTables.OPS_HOST.USER_OTHER,

                    }
            );

        cfg.view().form().addGroup("备份情况",
                new Object[] {
                        OpsTables.OPS_HOST.HOST_BACKUP_METHOD,
                },
                new Object[] {
                        OpsTables.OPS_HOST.HOST_BACKUP_INFO
                }


        );


        cfg.view().form().addGroup("其他情况",
                new Object[] {
                        OpsTables.OPS_HOST.MONITOR_STATUS,
                },
                new Object[] {
                        OpsTables.OPS_HOST.PASSWORD_STRATEGY_ID
                },
                new Object[] {
                        OpsTables.OPS_HOST.LABELS
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_HOST.HOST_NOTES,
                }

        );



        cfg.view().list().operationColumn().addActionButton("凭证","openHostVoucherWindow","ops_host:voucher");
        cfg.view().list().operationColumn().width(250);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS);
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsHostGtr g=new OpsHostGtr();
        //生成代码
         g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
  //      g.generateMenu(HostServiceProxy.class, HostPageController.class);
    }
}
