package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;

import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostPosition;

import com.dt.platform.domain.ops.ServiceInfo;

import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.proxy.ops.HostServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsDbInstanceGtr extends BaseCodeGenerator{


    public OpsDbInstanceGtr() {
        super(EAMTables.OPS_DB_INSTANCE.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Host.class,"host","所在位置","所在位置");
        cfg.getPoClassFile().addSimpleProperty(ServiceInfo.class,"database","数据库","数据库");


        cfg.view().field(EAMTables.OPS_DB_INSTANCE.ID).table().disable(true);
        cfg.view().field(EAMTables.OPS_DB_INSTANCE.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.OPS_DB_INSTANCE.LABELS).table().hidden(true);


        cfg.view().field(EAMTables.OPS_DB_INSTANCE.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_DB_INSTANCE.LABELS).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_DB_INSTANCE.NOTES).search().fuzzySearch();


        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{EAMTables.OPS_DB_INSTANCE.NAME,EAMTables.OPS_DB_INSTANCE.NOTES,EAMTables.OPS_DB_INSTANCE.LABELS},
                new Object[]{EAMTables.OPS_DB_INSTANCE.BACKUP_STRATEGY,EAMTables.OPS_DB_INSTANCE.BACKUP_STATUS}

        );


        cfg.view().field(EAMTables.OPS_DB_INSTANCE.HOST_ID).basic().label("主机")
                .form().selectBox().queryApi(HostServiceProxy.QUERY_PAGED_LIST)
                .valueField(HostMeta.ID).textField(HostMeta.HOST_NAME)
                .toolbar(false).filter(true).paging(true).muliti(false).fillBy(DbInstanceMeta.HOST);

        cfg.view().field(EAMTables.OPS_DB_INSTANCE.NAME).form().validate().required();



        cfg.view().field(EAMTables.OPS_DB_INSTANCE.DATABASE_ID).basic().label("数据库")
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST)
                .valueField(ServiceInfoMeta.ID).textField(ServiceInfoMeta.NAME)
                .toolbar(false).paging(false).muliti(false).fillBy(DbInstanceMeta.DATABASE);



        cfg.view().field(EAMTables.OPS_DB_INSTANCE.BACKUP_METHOD).basic().label("备份方式")
                .form().selectBox().dict(DictEnum.OPS_DB_BACKUP_METHOD).paging(false);

        cfg.view().field(EAMTables.OPS_DB_INSTANCE.BACKUP_STATUS).basic().label("备份状态")
                .form().selectBox().dict(DictEnum.OPS_DB_BACKUP_STATUS).paging(false);

        cfg.view().field(EAMTables.OPS_DB_INSTANCE.BACKUP_TYPE).basic().label("备份状态")
                    .form().selectBox().dict(DictEnum.OPS_DB_BACKUP_TYPE).paging(false);

        cfg.view().field(EAMTables.OPS_DB_INSTANCE.LOG_METHOD).basic().label("日志模式")
                .form().selectBox().dict(DictEnum.OPS_DB_LOG_METHOD).paging(false);

        cfg.view().field(EAMTables.OPS_DB_INSTANCE.BACKUP_TIME)
                .form().label("备份时间").dateInput();
        cfg.view().field(EAMTables.OPS_DB_INSTANCE.NOTES).form().textArea().height(30);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_DB_INSTANCE.NAME,
                        EAMTables.OPS_DB_INSTANCE.BACKUP_STATUS,
                        EAMTables.OPS_DB_INSTANCE.BACKUP_STRATEGY,
                        EAMTables.OPS_DB_INSTANCE.LOG_METHOD
                },
                new Object[]{
                        EAMTables.OPS_DB_INSTANCE.LABELS,
                        EAMTables.OPS_DB_INSTANCE.NOTES
                }

        );




        cfg.view().formWindow().width("1000px");
        cfg.view().form().addGroup(null ,
                new Object[] {
                        EAMTables.OPS_DB_INSTANCE.NAME,
                        EAMTables.OPS_DB_INSTANCE.HOST_ID,
                        EAMTables.OPS_DB_INSTANCE.DATABASE_ID,
                        EAMTables.OPS_DB_INSTANCE.LOG_METHOD,

                }, new Object[] {
                        EAMTables.OPS_DB_INSTANCE.BACKUP_TIME,
                        EAMTables.OPS_DB_INSTANCE.BACKUP_STATUS,
                        EAMTables.OPS_DB_INSTANCE.BACKUP_STRATEGY,

                },
                new Object[] {
                        EAMTables.OPS_DB_INSTANCE.BACKUP_TYPE,
                        EAMTables.OPS_DB_INSTANCE.BACKUP_METHOD,
                        EAMTables.OPS_DB_INSTANCE.BACKUP_SIZE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_DB_INSTANCE.NOTES,
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
        OpsDbInstanceGtr g=new OpsDbInstanceGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("474331804975759360");
     //   g.generateMenu(DbInstanceServiceProxy.class, DbInstancePageController.class);
    }
}
