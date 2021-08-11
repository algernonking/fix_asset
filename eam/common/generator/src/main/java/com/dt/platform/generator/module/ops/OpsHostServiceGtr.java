package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.ops.HostMonitorStatusEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;
import com.dt.platform.constants.enums.ops.ServiceTypeEnum;
import com.dt.platform.ops.page.HostPageController;
import com.dt.platform.proxy.ops.HostServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsHostServiceGtr extends BaseCodeGenerator{


    public OpsHostServiceGtr() {
        super(EAMTables.OPS_HOST.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {



        cfg.view().field(EAMTables.OPS_HOST.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.ARCH).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.HOST_MEMORY).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.HOST_CPU).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.DIRECTOR_ID).search().hidden(true);

        cfg.view().field(EAMTables.OPS_HOST.USER_APP_USED).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_DB_ADMIN).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_DB_USED).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_OPS_OPER).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.USER_OTHER).search().hidden(true);

        cfg.view().field(EAMTables.OPS_HOST.OFFLINE_TIME).search().hidden(true);
        cfg.view().field(EAMTables.OPS_HOST.ONLINE_TIME).search().hidden(true);


        cfg.view().field(EAMTables.OPS_HOST.HOST_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_HOST.HOST_IP).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_HOST.HOST_VIP).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_HOST.HOST_CONF).search().fuzzySearch();


        //
        cfg.view().field(EAMTables.OPS_HOST.STATUS)
                .form().validate().required()
                .form().radioBox().enumType(HostStatusEnum.class);


        cfg.view().field(EAMTables.OPS_HOST.MONITOR_STATUS)
                .form().validate().required()
                .form().radioBox().enumType(HostMonitorStatusEnum.class);


        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        EAMTables.OPS_HOST.HOST_TYPE,
                        EAMTables.OPS_HOST.HOST_NAME,
                        EAMTables.OPS_HOST.POSITION_ID,
                        EAMTables.OPS_HOST.STATUS,
                        EAMTables.OPS_HOST.DIRECTOR_ID,
                }, new Object[] {
                        EAMTables.OPS_HOST.OFFLINE_TIME,
                        EAMTables.OPS_HOST.ONLINE_TIME,
                        EAMTables.OPS_HOST.LABELS,
                        EAMTables.OPS_HOST.HOST_NOTES
                }
        );
        cfg.view().form().addGroup("操作系统",
                new Object[] {EAMTables.OPS_HOST.OS,
                        EAMTables.OPS_HOST.HOST_CPU,
                        EAMTables.OPS_HOST.HOST_MEMORY,
                        EAMTables.OPS_HOST.HOST_IP,
                        EAMTables.OPS_HOST.HOST_VIP
        }
        );
        cfg.view().form().addGroup("应用数据库中间件",
                new Object[] {
                        EAMTables.OPS_HOST.DB
                },
                new Object[] {
                        EAMTables.OPS_HOST.MIDDLEWARE
                }
        );
        cfg.view().form().addGroup("用户情况",
                new Object[] {
                        EAMTables.OPS_HOST.USER_APP_USED,
                        EAMTables.OPS_HOST.USER_DB_ADMIN,
                        EAMTables.OPS_HOST.USER_DB_USED,
                        EAMTables.OPS_HOST.USER_OPS_OPER,
                        EAMTables.OPS_HOST.USER_OTHER
            }
        );

        cfg.view().form().addGroup("其他情况",
                new Object[] {
                        EAMTables.OPS_HOST.MONITOR_STATUS,
                        EAMTables.OPS_HOST.PASSWORD_STRATEGY_ID
                }
        );



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
        OpsHostServiceGtr g=new OpsHostServiceGtr();
        //生成代码
         g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
  //      g.generateMenu(HostServiceProxy.class, HostPageController.class);
    }
}
