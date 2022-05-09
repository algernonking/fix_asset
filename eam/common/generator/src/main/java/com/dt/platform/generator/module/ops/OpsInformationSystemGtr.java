package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.dt.platform.domain.ops.meta.InformationSystemVOMeta;
import com.dt.platform.domain.ops.meta.VoucherOwnerMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import com.dt.platform.constants.db.OpsTables;
public class OpsInformationSystemGtr extends BaseCodeGenerator{


    public OpsInformationSystemGtr() {
        super(OpsTables.OPS_INFORMATION_SYSTEM.$TABLE,INFOYSTEM_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

//        cfg.getPoClassFile().addListProperty(Host.class,"hostList","主机信息","主机信息");
//        cfg.getPoClassFile().addListProperty(String.class,"hostIds","主机信息","主机信息");


        cfg.getPoClassFile().addListProperty(Voucher.class,"voucherList","凭证","凭证");
        cfg.getPoClassFile().addListProperty(String.class,"voucherIds","凭证","凭证");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"belongOrganization","所属公司/部门","所属公司/部门");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"infoSystemStatus","状态","状态");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"infoSystemOpsMethod","运维模式","运维模式");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"infoSystemDevMethod","开发模式","开发模式");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"infoSystemGrade","系统分级","系统分级");


        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.PID).basic().hidden(true);

        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.PROFILE).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.BUSINESS_CONTACT).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.TECHNICAL_CONTACT).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.CREATE_TIME).table().disable(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.OFFLINE_DATE).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.ARCH_METHOD).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.HARDWARE_INFO).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.BACKUP_INFO).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.DIFFPLACE_BACKUP_INFO).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.SAMEPLACE_BACUP_INFO).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.DEV_METHOD).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.OPS_METHOD).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.DB_INFO).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.OS_INFO).table().hidden(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.APP_INFO).table().hidden(true);

        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.LASTDRILL_DATE).table().hidden(true);

        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.PROFILE).table().hidden(true);


        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.BELONG_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.BELONG_ORG_ID).table().fillBy("belongOrganization","fullName");


        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.STATUS)
                .basic().label("状态")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_system_status")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InformationSystemMeta.INFO_SYSTEM_STATUS).muliti(false);


        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.GRADE)
                .basic().label("系统分级")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_system_grade")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InformationSystemMeta.INFO_SYSTEM_GRADE).muliti(false);


        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.OPS_METHOD)
                .basic().label("运维模式")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_system_ops_method")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InformationSystemMeta.INFO_SYSTEM_OPS_METHOD).muliti(false);


        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.DEV_METHOD)
                .basic().label("开发模式")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_system_dev_method")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InformationSystemMeta.INFO_SYSTEM_DEV_METHOD).muliti(false);



        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.ONLINE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.OFFLINE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.LASTDRILL_DATE).basic().label("演练时间").form().
                dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(OpsTables.OPS_INFORMATION_SYSTEM.NAME).form().validate().required();

        ;
        cfg.view().field(InformationSystemVOMeta.VOUCHER_IDS)
                .basic().label("用户凭证")
                .table().sort(false)
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST+"?groupId=os")
                .valueField("user_code").textField("voucher")
                .toolbar(false).paging(false)
                .fillWith(InformationSystemMeta.VOUCHER_LIST).muliti(true);


        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_INFORMATION_SYSTEM.BELONG_ORG_ID,
                        OpsTables.OPS_INFORMATION_SYSTEM.STATUS,
                        OpsTables.OPS_INFORMATION_SYSTEM.GRADE,
                        OpsTables.OPS_INFORMATION_SYSTEM.NAME,

                },
                new Object[]{
                        OpsTables.OPS_INFORMATION_SYSTEM.BUSINESS_CONTACT,
                        OpsTables.OPS_INFORMATION_SYSTEM.TECHNICAL_CONTACT,
                        OpsTables.OPS_INFORMATION_SYSTEM.LABELS,
                        OpsTables.OPS_INFORMATION_SYSTEM.NOTES
                }

        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth+20);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth+20);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+20);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+20);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //分成分组布局
        cfg.view().formWindow().width("98%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        OpsTables.OPS_INFORMATION_SYSTEM.STATUS,
                        OpsTables.OPS_INFORMATION_SYSTEM.NAME,
                        OpsTables.OPS_INFORMATION_SYSTEM.GRADE,
                        OpsTables.OPS_INFORMATION_SYSTEM.PROFILE,

                }, new Object[] {
                        OpsTables.OPS_INFORMATION_SYSTEM.BELONG_ORG_ID,
                        OpsTables.OPS_INFORMATION_SYSTEM.ONLINE_DATE,
                        OpsTables.OPS_INFORMATION_SYSTEM.OFFLINE_DATE,
                        OpsTables.OPS_INFORMATION_SYSTEM.NOTES,
                },
                new Object[] {
                        OpsTables.OPS_INFORMATION_SYSTEM.TECHNICAL_CONTACT,
                        OpsTables.OPS_INFORMATION_SYSTEM.BUSINESS_CONTACT,
                        OpsTables.OPS_INFORMATION_SYSTEM.LABELS,
                }
        );
        cfg.view().form().addGroup("运维信息",
                new Object[] {
                        OpsTables.OPS_INFORMATION_SYSTEM.OPS_METHOD,
                        OpsTables.OPS_INFORMATION_SYSTEM.DEV_METHOD,
                        OpsTables.OPS_INFORMATION_SYSTEM.OS_INFO,
                        OpsTables.OPS_INFORMATION_SYSTEM.DB_INFO
                },
                new Object[] {
                        OpsTables.OPS_INFORMATION_SYSTEM.BACKUP_INFO,
                        OpsTables.OPS_INFORMATION_SYSTEM.HARDWARE_INFO,
                        OpsTables.OPS_INFORMATION_SYSTEM.SAMEPLACE_BACUP_INFO,
                        OpsTables.OPS_INFORMATION_SYSTEM.DIFFPLACE_BACKUP_INFO,
                }  ,
                new Object[] {
                        OpsTables.OPS_INFORMATION_SYSTEM.RPO,
                        OpsTables.OPS_INFORMATION_SYSTEM.RTO,
                        OpsTables.OPS_INFORMATION_SYSTEM.LASTDRILL_DATE
              }
        );


        cfg.view().list().operationColumn().addActionButton("凭证","openSystemVoucherWindow","ops_information_system:voucher");
        cfg.view().list().operationColumn().addActionButton("主机","openHostWindow","ops_information_system:host");
        cfg.view().list().operationColumn().width(290);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
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
