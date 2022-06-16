package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.constants.enums.ops.CertificateStatusEnum;
import com.dt.platform.domain.eam.meta.AssetStockGoodsMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.domain.ops.Certificate;
import com.dt.platform.domain.ops.CertificatePosition;
import com.dt.platform.domain.ops.CertificateType;
import com.dt.platform.domain.ops.meta.CertificateMeta;
import com.dt.platform.domain.ops.meta.CertificatePositionMeta;
import com.dt.platform.domain.ops.meta.CertificateTypeMeta;
import com.dt.platform.ops.page.CertificatePageController;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.dt.platform.proxy.ops.CertificatePositionServiceProxy;
import com.dt.platform.proxy.ops.CertificateServiceProxy;
import com.dt.platform.proxy.ops.CertificateTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;

public class CertificateGtr extends BaseCodeGenerator{


    public CertificateGtr() {
        super(OpsTables.OPS_CERTIFICATE.$TABLE,"589211024419192832");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addSimpleProperty(CertificateType.class,"certificateType","证书类型","证书类型");
        cfg.getPoClassFile().addSimpleProperty(CertificatePosition.class,"certificatePosition","证书位置","证书位置");
        cfg.view().field(OpsTables.OPS_CERTIFICATE.PROJECT).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_CERTIFICATE.START_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").defaultNow().search().range();
        cfg.view().field(OpsTables.OPS_CERTIFICATE.END_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").defaultNow().search().range();

        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_CERTIFICATE.STATUS,
                        OpsTables.OPS_CERTIFICATE.POSITION_ID,
                        OpsTables.OPS_CERTIFICATE.TYPE,
                        OpsTables.OPS_CERTIFICATE.PROJECT,
                }
        );
        cfg.view().search().inputWidth(180);


        cfg.view().field(OpsTables.OPS_CERTIFICATE.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_CERTIFICATE.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(OpsTables.OPS_CERTIFICATE.STATUS).table().form().validate().required().form().selectBox().enumType(CertificateStatusEnum.class);

        cfg.view().field(OpsTables.OPS_CERTIFICATE.TYPE)
                .form().validate().required().form().selectBox().queryApi(CertificateTypeServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CertificateTypeMeta.ID).textField(CertificateTypeMeta.NAME).fillWith(CertificateMeta.CERTIFICATE_TYPE).muliti(false);

        cfg.view().field(OpsTables.OPS_CERTIFICATE.POSITION_ID)
                .form().validate().required().form().selectBox().queryApi(CertificatePositionServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CertificatePositionMeta.ID).textField(CertificateTypeMeta.NAME).fillWith(CertificateMeta.CERTIFICATE_POSITION).muliti(false);



        cfg.view().field(OpsTables.OPS_CERTIFICATE.CONTENT).table().form().textArea().height(80);
        cfg.view().field(OpsTables.OPS_CERTIFICATE.NOTES).table().form().textArea().height(80);

        cfg.view().field(OpsTables.OPS_CERTIFICATE.NAME).table().form().validate().required();
        cfg.view().field(OpsTables.OPS_CERTIFICATE.PROJECT).table().form().validate().required();




        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE.NAME,
                        OpsTables.OPS_CERTIFICATE.STATUS,
                        OpsTables.OPS_CERTIFICATE.TYPE,
                        OpsTables.OPS_CERTIFICATE.PROJECT,

                },
                new Object[] {
                        OpsTables.OPS_CERTIFICATE.POSITION_ID,
                        OpsTables.OPS_CERTIFICATE.START_DATE,
                        OpsTables.OPS_CERTIFICATE.END_DATE
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_CERTIFICATE.CONTENT,
                        OpsTables.OPS_CERTIFICATE.NOTES,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().list().operationColumn().addActionButton("证书项","certificateItem","certificateItem-button","ops_certificate:certificate_item");



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
        CertificateGtr g=new CertificateGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
      //   g.generateMenu(CertificateServiceProxy.class, CertificatePageController.class);
    }
}
