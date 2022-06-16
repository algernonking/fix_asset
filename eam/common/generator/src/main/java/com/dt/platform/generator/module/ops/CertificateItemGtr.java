package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.constants.enums.ops.CertificateItemStatusEnum;
import com.dt.platform.constants.enums.ops.CertificateStatusEnum;
import com.dt.platform.ops.page.CertificateItemPageController;
import com.dt.platform.ops.page.CertificatePageController;
import com.dt.platform.proxy.ops.CertificateItemServiceProxy;
import com.dt.platform.proxy.ops.CertificateServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CertificateItemGtr extends BaseCodeGenerator{


    public CertificateItemGtr() {
        super(OpsTables.OPS_CERTIFICATE_ITEM.$TABLE,"589211024419192832");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operUser","人员","人员");

        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.CONTENT).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CERTIFICATE_ITEM.STATUS,
                        OpsTables.OPS_CERTIFICATE_ITEM.CONTENT,
                }
        );
        cfg.view().search().inputWidth(180);



        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.OPER_USER_ID).form().button().chooseEmployee(true);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.OPER_USER_ID).table().fillBy("operUser","nameAndBadge");



        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.START_DATE).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").defaultNow().search().range();
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.END_DATE).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").defaultNow().search().range();
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.STATUS).table().form().validate().required().form().selectBox().enumType(CertificateItemStatusEnum.class);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.PUBLIC_KEY).table().form().textArea().height(80);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.PRIVATE_KEY).table().form().textArea().height(80);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.CONTENT).table().form().textArea().height(80);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.ATTACH_ID).table().form().upload().acceptAllType().maxFileCount(6);

        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.ATTACH_ID).table().disable();

        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.CERTIFICATE_ID).table().disable();
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.PRIVATE_KEY).table().disable();
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.PUBLIC_KEY).table().disable();
        cfg.view().field(OpsTables.OPS_CERTIFICATE_ITEM.CONTENT).table().disable();

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE_ITEM.STATUS,
                },
                new Object[] {
                        OpsTables.OPS_CERTIFICATE_ITEM.START_DATE,
                },
                new Object[] {
                  OpsTables.OPS_CERTIFICATE_ITEM.END_DATE
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE_ITEM.PUBLIC_KEY,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE_ITEM.PRIVATE_KEY,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE_ITEM.CONTENT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE_ITEM.ATTACH_ID,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().list().addJsVariable("CERTIFICATE_ID","[[${certificateId}]]","certificate_id");

        cfg.view().form().addJsVariable("CERTIFICATE_ID","[[${certificateId}]]","certificate_id");

      //  cfg.view().list().operationColumn().addActionButton("启用","itemEnable","itemEnable-button","ops_certificate_item:item_enable");
      //  cfg.view().list().operationColumn().addActionButton("停用","itemDisable","itemDisable-button","ops_certificate_item:item_disable");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CertificateItemGtr g=new CertificateItemGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        g.generateMenu(CertificateItemServiceProxy.class, CertificateItemPageController.class);
        // g.generateMenu(VoucherPrivServiceProxy.class, VoucherPrivPageController.class);
    }
}
