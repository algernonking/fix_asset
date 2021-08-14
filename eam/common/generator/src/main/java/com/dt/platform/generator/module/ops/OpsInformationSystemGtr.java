package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.github.foxnic.generator.config.WriteMode;

public class OpsInformationSystemGtr extends BaseCodeGenerator{


    public OpsInformationSystemGtr() {
        super(EAMTables.OPS_INFORMATION_SYSTEM.$TABLE,INFOYSTEM_MENU_ID);
    }

    public void generateCode() throws Exception {


        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.PID).basic().hidden(true);

        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.OFFLINE_DATE).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.ARCH_METHOD).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.HARDWARE_INFO).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.BACKUP_INFO).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.DIFFPLACE_BACKUP_INFO).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.SAMEPLACE_BACUP_INFO).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.DEV_METHOD).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.OPS_METHOD).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.DB_INFO).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.OS_INFO).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.APP_INFO).table().hidden(true);

        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.LASTDRILL_DATE).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.BELONG_ORG_INFO).table().hidden(true);
        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.PROFILE).table().hidden(true);


        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.STATUS).basic().label("状态")
                .form().validate().required()
                .form().selectBox().dict(DictEnum.OPS_SYSTEM_STATUS).paging(false);


        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.OPS_METHOD).basic().label("运维模式")
                .form().selectBox().dict(DictEnum.OPS_SYSTEM_OPS_METHOD).paging(false);


        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.DEV_METHOD).basic().label("开发模式")
                .form().selectBox().dict(DictEnum.OPS_SYSTEM_DEV_METHOD).paging(false);

        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.GRADE).basic().label("系统分级")
                .form().selectBox().dict(DictEnum.OPS_SYSTEM_GRADE).paging(false);

        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.ONLINE_DATE).form().numberInput();

        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.OFFLINE_DATE).form().numberInput();

        cfg.view().field(EAMTables.OPS_INFORMATION_SYSTEM.LASTDRILL_DATE).basic().label("演练时间").form().numberInput();


        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{EAMTables.OPS_INFORMATION_SYSTEM.NAME,EAMTables.OPS_INFORMATION_SYSTEM.NOTES,EAMTables.OPS_INFORMATION_SYSTEM.LABELS},
                new Object[]{EAMTables.OPS_INFORMATION_SYSTEM.STATUS,EAMTables.OPS_INFORMATION_SYSTEM.BUSINESS_CONTACT,EAMTables.OPS_INFORMATION_SYSTEM.TECHNICAL_CONTACT}

        );

        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        EAMTables.OPS_INFORMATION_SYSTEM.NAME,
                        EAMTables.OPS_INFORMATION_SYSTEM.PROFILE,
                        EAMTables.OPS_INFORMATION_SYSTEM.STATUS,
                        EAMTables.OPS_INFORMATION_SYSTEM.TECHNICAL_CONTACT,
                        EAMTables.OPS_INFORMATION_SYSTEM.BUSINESS_CONTACT,


                }, new Object[] {
                        EAMTables.OPS_INFORMATION_SYSTEM.BELONG_ORG_INFO,
                        EAMTables.OPS_INFORMATION_SYSTEM.GRADE,
                        EAMTables.OPS_INFORMATION_SYSTEM.ONLINE_DATE,
                        EAMTables.OPS_INFORMATION_SYSTEM.OFFLINE_DATE,
                        EAMTables.OPS_INFORMATION_SYSTEM.LABELS,


                }
        );
        cfg.view().form().addGroup("运维信息",
                new Object[] {
                        EAMTables.OPS_INFORMATION_SYSTEM.OPS_METHOD,
                        EAMTables.OPS_INFORMATION_SYSTEM.DEV_METHOD,
                        EAMTables.OPS_INFORMATION_SYSTEM.LASTDRILL_DATE,
                        EAMTables.OPS_INFORMATION_SYSTEM.BACKUP_INFO,
                        EAMTables.OPS_INFORMATION_SYSTEM.OS_INFO,
                        EAMTables.OPS_INFORMATION_SYSTEM.DB_INFO
                },
                new Object[] {
                        EAMTables.OPS_INFORMATION_SYSTEM.RPO,
                        EAMTables.OPS_INFORMATION_SYSTEM.RTO,
                        EAMTables.OPS_INFORMATION_SYSTEM.HARDWARE_INFO,
                        EAMTables.OPS_INFORMATION_SYSTEM.SAMEPLACE_BACUP_INFO,
                        EAMTables.OPS_INFORMATION_SYSTEM.DIFFPLACE_BACKUP_INFO,
                        EAMTables.OPS_INFORMATION_SYSTEM.NOTES

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
        OpsInformationSystemGtr g=new OpsInformationSystemGtr();
        //生成代码
       g.generateCode();

        //移除之前生成的菜单，视情况执行
     //   g.removeByBatchId("478601852045230080");
      //  g.generateMenu(InformationSystemServiceProxy.class, InformationSystemPageController.class);
    }
}
