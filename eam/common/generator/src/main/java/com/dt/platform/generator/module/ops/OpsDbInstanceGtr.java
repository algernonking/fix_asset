package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;

import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostPosition;

import com.dt.platform.domain.ops.ServiceInfo;

import com.dt.platform.domain.ops.meta.DbInstanceMeta;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.ops.HostServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class OpsDbInstanceGtr extends BaseCodeGenerator{


    public OpsDbInstanceGtr() {
        super(OpsTables.OPS_DB_INSTANCE.$TABLE,BASIC_HOSTMGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Host.class,"host","所在位置","所在位置");
        cfg.getPoClassFile().addSimpleProperty(ServiceInfo.class,"database","数据库","数据库");


        cfg.view().field(OpsTables.OPS_DB_INSTANCE.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_INSTANCE.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_DB_INSTANCE.LABELS).table().hidden(true);


        cfg.view().field(OpsTables.OPS_DB_INSTANCE.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_INSTANCE.LABELS).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_DB_INSTANCE.NOTES).search().fuzzySearch();


        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{OpsTables.OPS_DB_INSTANCE.NAME,OpsTables.OPS_DB_INSTANCE.NOTES,OpsTables.OPS_DB_INSTANCE.LABELS},
                new Object[]{OpsTables.OPS_DB_INSTANCE.BACKUP_STRATEGY,OpsTables.OPS_DB_INSTANCE.BACKUP_STATUS}

        );

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.BACKUP_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.HOST_ID).basic().label("主机")
                .form().validate().required()
                .form().selectBox().queryApi(HostServiceProxy.QUERY_PAGED_LIST)
                .valueField(HostMeta.ID).textField(HostMeta.HOST_NAME)
                .toolbar(false).filter(true).paging(true).muliti(false).fillWith(DbInstanceMeta.HOST);

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.NAME).form().validate().required();



        cfg.view().field(OpsTables.OPS_DB_INSTANCE.DATABASE_ID).basic().label("数据库")
                .form().validate().required()
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST)
                .valueField(ServiceInfoMeta.ID).textField(ServiceInfoMeta.NAME)
                .toolbar(false).paging(false).muliti(false).fillWith(DbInstanceMeta.DATABASE);



        cfg.view().field(OpsTables.OPS_DB_INSTANCE.BACKUP_METHOD).basic().label("备份方式")
                .form().selectBox().dict(DictEnum.OPS_DB_BACKUP_METHOD).paging(false);

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.BACKUP_STATUS).basic().label("备份状态")
                .form().selectBox().dict(DictEnum.OPS_DB_BACKUP_STATUS).paging(false);

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.BACKUP_TYPE).basic().label("备份状态")
                    .form().selectBox().dict(DictEnum.OPS_DB_BACKUP_TYPE).paging(false);

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.LOG_METHOD).basic().label("日志模式")
                .form().selectBox().dict(DictEnum.OPS_DB_LOG_METHOD).paging(false);

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.BACKUP_TIME)
                .form().label("备份时间").dateInput();

        cfg.view().field(OpsTables.OPS_DB_INSTANCE.BACKUP_SIZE).form().numberInput().scale(2).allowNegative(false);
        cfg.view().field(OpsTables.OPS_DB_INSTANCE.NOTES).form().textArea().height(30);


        String resourceNameField="res_"+OpsTables.OPS_HOST.HOST_IP;
        cfg.view().field(resourceNameField)
                .basic().label("IP")
                .table().fillBy(DbInstanceMeta.HOST, HostMeta.HOST_IP);


        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_DB_INSTANCE.BACKUP_STATUS,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_STRATEGY,
                        OpsTables.OPS_DB_INSTANCE.LOG_METHOD,
                        OpsTables.OPS_DB_INSTANCE.NAME,
                },
                new Object[]{
                      //  resourceNameField,
                        OpsTables.OPS_DB_INSTANCE.LABELS,
                        OpsTables.OPS_DB_INSTANCE.NOTES
                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().list().columnLayout(
                new Object[]{
                        OpsTables.OPS_DB_INSTANCE.HOST_ID,
                        resourceNameField,
                        OpsTables.OPS_DB_INSTANCE.NAME,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_STATUS,
                        OpsTables.OPS_DB_INSTANCE.LOG_METHOD,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_TYPE,
                        OpsTables.OPS_DB_INSTANCE.DATABASE_ID,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_TIME,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_STRATEGY,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_METHOD,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_SIZE,
                        OpsTables.OPS_DB_INSTANCE.NOTES,
                }
        );

        cfg.view().formWindow().width("90%");
        cfg.view().formWindow().bottomSpace(150);
        cfg.view().form().addGroup(null ,
                new Object[] {
                        OpsTables.OPS_DB_INSTANCE.HOST_ID,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_STATUS,
                        OpsTables.OPS_DB_INSTANCE.LOG_METHOD,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_TYPE,

                }, new Object[] {
                        OpsTables.OPS_DB_INSTANCE.DATABASE_ID,
                        OpsTables.OPS_DB_INSTANCE.NAME,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_TIME,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_STRATEGY,
                },
                new Object[] {
                        OpsTables.OPS_DB_INSTANCE.BACKUP_METHOD,
                        OpsTables.OPS_DB_INSTANCE.BACKUP_SIZE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_DB_INSTANCE.NOTES,
                }

        );
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
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
