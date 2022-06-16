package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.ops.page.CertificatePositionPageController;
import com.dt.platform.proxy.ops.CertificatePositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CertificatePosGtr extends BaseCodeGenerator{


    public CertificatePosGtr() {
        super(OpsTables.OPS_CERTIFICATE_POSITION.$TABLE,"589211024419192832");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.view().field(OpsTables.OPS_CERTIFICATE_TYPE.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CERTIFICATE_POSITION.NAME,
                }
        );

        cfg.view().field(OpsTables.OPS_CERTIFICATE_POSITION.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CERTIFICATE_POSITION.NAME).table().form().validate().required();
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("50%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {

                        OpsTables.OPS_CERTIFICATE_POSITION.NAME,
                        OpsTables.OPS_CERTIFICATE_POSITION.NOTES,
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
        CertificatePosGtr g=new CertificatePosGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
       g.generateMenu(CertificatePositionServiceProxy.class, CertificatePositionPageController.class);
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(VoucherPrivServiceProxy.class, VoucherPrivPageController.class);
    }
}
