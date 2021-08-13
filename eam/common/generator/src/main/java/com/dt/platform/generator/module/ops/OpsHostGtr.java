package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.ops.HostMonitorStatusEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.proxy.ops.HostPositionServiceProxy;
import com.dt.platform.proxy.ops.ServiceDetailServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsHostGtr extends BaseCodeGenerator{


    public OpsHostGtr() {
        super(EAMTables.OPS_HOST.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.getPoClassFile().addSimpleProperty(HostPosition.class,"position","所在位置","所在位置");


        cfg.getPoClassFile().addListProperty(ServiceDetail.class,"hostDbList","数据库","数据库");
        cfg.getPoClassFile().addListProperty(String.class,"hostDbIds","数据库列表","数据库");


        cfg.getPoClassFile().addListProperty(ServiceDetail.class,"hostMiddlewareList","中间件","中间件");
        cfg.getPoClassFile().addListProperty(String.class,"hostMiddlewareIds","中间件列表","中间件");


        cfg.getPoClassFile().addListProperty(ServiceDetail.class,"hostOsList","操作系统","操作系统");
        cfg.getPoClassFile().addListProperty(String.class,"hostOsIds","操作系统列表","操作系统");

        cfg.view().field(EAMTables.OPS_HOST.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.ARCH).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.HOST_MEMORY).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.HOST_CPU).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.DIRECTOR_USERNAME).search().hidden(true);

        cfg.view().field(EAMTables.OPS_HOST.USER_APP_USED).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_DB_ADMIN).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_DB_USED).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_OS_ADMIN).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_OPS_OPER).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_OTHER).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.OFFLINE_TIME).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.ONLINE_TIME).search().hidden(true);


          cfg.view().field(EAMTables.OPS_HOST.OFFLINE_TIME).list().hidden();
//        cfg.view().field(EAMTables.OPS_HOST.USER_OTHER).table().hidden(true);
//        cfg.view().field(EAMTables.OPS_HOST.USER_OS_ADMIN).table().hidden(true);
//        cfg.view().field(EAMTables.OPS_HOST.USER_OPS_OPER).table().hidden(true);
//
//        cfg.view().field(EAMTables.OPS_HOST.HOST_MEMORY).table().hidden(true);
//        cfg.view().field(EAMTables.OPS_HOST.HOST_CPU).table().hidden(true);



        cfg.view().field(EAMTables.OPS_HOST.HOST_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_HOST.HOST_IP).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_HOST.HOST_VIP).basic().label("服务IP").search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_HOST.HOST_CONF).search().fuzzySearch();


        cfg.view().field(EAMTables.OPS_HOST.ONLINE_TIME)
                .form().dateInput().search().range();

        cfg.view().field(EAMTables.OPS_HOST.OFFLINE_TIME)
                .form().dateInput()
                .search().range();

        cfg.view().field(HostMeta.HOST_DB_IDS)
                .basic().label("数据库")
                .search().inputWidth(140)
                .table().sort(false)
                .form().selectBox().queryApi(ServiceDetailServiceProxy.QUERY_LIST)
                .valueField(ServiceDetailMeta.ID).textField(ServiceDetailMeta.NAME)
                .toolbar(false).paging(false)
                .fillBy(HostMeta.HOST_DB_LIST).muliti(true);


        cfg.view().field(HostMeta.HOST_MIDDLEWARE_IDS)
                .basic().label("中间件")
                .search().inputWidth(140)
                .table().sort(false)
                .form().selectBox().queryApi(ServiceDetailServiceProxy.QUERY_LIST)
                .valueField(ServiceDetailMeta.ID).textField(ServiceDetailMeta.NAME)
                .toolbar(false).paging(false)
                .fillBy(HostMeta.HOST_MIDDLEWARE_LIST).muliti(true);

        cfg.view().field(HostMeta.HOST_OS_IDS)
                .basic().label("操作系统")
                .search().inputWidth(160)
                .table().sort(false)
                .form().selectBox().queryApi(ServiceDetailServiceProxy.QUERY_LIST)
                .valueField(ServiceDetailMeta.ID).textField(ServiceDetailMeta.NAME)
                .toolbar(false).paging(false)
                .fillBy(HostMeta.HOST_OS_LIST).muliti(true);


        cfg.view().field(HostMeta.POSITION_ID)
                .basic().label("所在位置")
                .search().inputWidth(140)
                .table().sort(false)
                .form().selectBox().queryApi(HostPositionServiceProxy.QUERY_LIST)
                .valueField(HostPositionMeta.ID).textField(ServiceDetailMeta.NAME)
                .toolbar(false).paging(false)
                .fillBy(HostMeta.POSITION).muliti(false);


        //
        cfg.view().field(EAMTables.OPS_HOST.HOST_TYPE)
                .form().validate().required()
                .form().selectBox().dict(DictEnum.OPS_HOST_TYPE);


        cfg.view().field(EAMTables.OPS_HOST.PASSWORD_STRATEGY_ID)
                .form().selectBox().dict(DictEnum.OPS_HOST_PASSWORD_STRATEGY);


        cfg.view().field(EAMTables.OPS_HOST.ENVIRONMENT).basic().label("所在环境")
                .form().selectBox().dict(DictEnum.OPS_ENV);


        cfg.view().field(EAMTables.OPS_HOST.STATUS).basic().label("主机状态")
                .form().validate().required()
                .form().radioBox().enumType(HostStatusEnum.class);


        cfg.view().field(EAMTables.OPS_HOST.MONITOR_STATUS).basic().label("监控状态")
                .form().validate().required()
                .form().radioBox().enumType(HostMonitorStatusEnum.class);


        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{EAMTables.OPS_HOST.HOST_NAME,EAMTables.OPS_HOST.HOST_NOTES,EAMTables.OPS_HOST.LABELS},
                new Object[]{EAMTables.OPS_HOST.HOST_IP,EAMTables.OPS_HOST.HOST_VIP,EAMTables.OPS_HOST.POSITION_ID},
                new Object[]{HostMeta.HOST_OS_IDS, HostMeta.HOST_DB_IDS, HostMeta.HOST_MIDDLEWARE_IDS}
        );


        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        EAMTables.OPS_HOST.HOST_TYPE,
                        EAMTables.OPS_HOST.HOST_NAME,
                        EAMTables.OPS_HOST.POSITION_ID,
                        EAMTables.OPS_HOST.STATUS,
                        EAMTables.OPS_HOST.ENVIRONMENT,

                }, new Object[] {
                        EAMTables.OPS_HOST.OFFLINE_TIME,
                        EAMTables.OPS_HOST.ONLINE_TIME,
                        EAMTables.OPS_HOST.LABELS,
                        EAMTables.OPS_HOST.DIRECTOR_USERNAME,
                        EAMTables.OPS_HOST.HOST_NOTES
                }
        );
        cfg.view().form().addGroup("操作系统",
                new Object[] {
                        EAMTables.OPS_HOST.HOST_CPU,
                        EAMTables.OPS_HOST.HOST_MEMORY,
                        EAMTables.OPS_HOST.HOST_CONF
        },
                new Object[] {
                        EAMTables.OPS_HOST.HOST_IP,
                        EAMTables.OPS_HOST.HOST_VIP

                }
        );
        cfg.view().form().addGroup("系统、数据库和中间件",
                new Object[]{
                        HostMeta.HOST_OS_IDS, HostMeta.HOST_DB_IDS
                },
                new Object[]{
                        HostMeta.HOST_MIDDLEWARE_IDS
                }
        );
        cfg.view().form().addGroup("用户情况",
                new Object[] {
                        EAMTables.OPS_HOST.USER_APP_USED,
                        EAMTables.OPS_HOST.USER_OPS_OPER,
                        EAMTables.OPS_HOST.USER_OTHER
            },
                new Object[] {
                        EAMTables.OPS_HOST.USER_DB_ADMIN,
                        EAMTables.OPS_HOST.USER_DB_USED,

                }
        );

        cfg.view().form().addGroup("其他情况",
                new Object[] {
                        EAMTables.OPS_HOST.MONITOR_STATUS,  EAMTables.OPS_HOST.PASSWORD_STRATEGY_ID
                }
        );

        //指定该表为关系表

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
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
