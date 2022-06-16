package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.ops.page.CertificateItemPageController;
import com.dt.platform.ops.page.CertificateTypePageController;
import com.dt.platform.proxy.ops.CertificateItemServiceProxy;
import com.dt.platform.proxy.ops.CertificateTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class CertificateTypeGtr extends BaseCodeGenerator{


    public CertificateTypeGtr() {
        super(OpsTables.OPS_CERTIFICATE_TYPE.$TABLE,"589211024419192832");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(OpsTables.OPS_CERTIFICATE_TYPE.CODE).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_CERTIFICATE_TYPE.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CERTIFICATE_TYPE.CODE,
                        OpsTables.OPS_CERTIFICATE_TYPE.NAME,
                }
        );
        cfg.view().field(OpsTables.OPS_CERTIFICATE_TYPE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_TYPE.CODE).table().form().validate().required();
        cfg.view().field(OpsTables.OPS_CERTIFICATE_TYPE.NAME).table().form().validate().required();
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("50%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE_TYPE.CODE,
                        OpsTables.OPS_CERTIFICATE_TYPE.NAME,
                        OpsTables.OPS_CERTIFICATE_TYPE.NOTES,
                }
        );
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
        CertificateTypeGtr g=new CertificateTypeGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
      //  g.generateMenu(CertificateTypeServiceProxy.class, CertificateTypePageController.class);
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(VoucherPrivServiceProxy.class, VoucherPrivPageController.class);
    }
}
