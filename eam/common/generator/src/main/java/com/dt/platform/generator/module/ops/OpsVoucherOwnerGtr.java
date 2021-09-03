package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.ops.page.VoucherOwnerPageController;
import com.dt.platform.proxy.ops.ServiceCategoryServiceProxy;
import com.dt.platform.proxy.ops.ServiceGroupServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.dt.platform.proxy.ops.VoucherOwnerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;

public class OpsVoucherOwnerGtr extends BaseCodeGenerator{


    public OpsVoucherOwnerGtr() {
        super(EAMTables.OPS_VOUCHER_OWNER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(Voucher.class,"voucherList","凭证","凭证");
        cfg.getPoClassFile().addListProperty(String.class,"voucherIds","凭证","凭证");

        cfg.view().field(EAMTables.OPS_VOUCHER_OWNER.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_VOUCHER_OWNER.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.OPS_VOUCHER.ID).basic().hidden(true);

        cfg.view().field(EAMTables.OPS_VOUCHER.ID).table().disable(true);
        cfg.view().field(EAMTables.OPS_VOUCHER.CREATE_TIME).table().disable(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_VOUCHER_OWNER.CATEGORY_CODE,
                        EAMTables.OPS_VOUCHER_OWNER.NAME,
                        EAMTables.OPS_VOUCHER_OWNER.NOTES
                }

        );


        cfg.view().field(EAMTables.OPS_VOUCHER_OWNER.NAME).form().validate().required();
        cfg.view().field(EAMTables.OPS_VOUCHER_OWNER.CATEGORY_CODE).form()
                .validate().required().form().selectBox()
                .dict(DictEnum.OPS_VOUCHER_TYPE).filter(true).muliti(false).toolbar(false);
        cfg.view().field(EAMTables.OPS_VOUCHER_OWNER.NOTES).form().textArea().height(30);



        cfg.view().field(VoucherOwnerMeta.VOUCHER_IDS)
                .basic().label("用户凭证")
                .table().sort(false)
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST+"?groupId=os")
                .valueField("user_code").textField("voucher")
                .toolbar(false).paging(false)
                .fillBy(VoucherOwnerMeta.VOUCHER_LIST).muliti(true);



        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_VOUCHER_OWNER.NAME,
                        EAMTables.OPS_VOUCHER_OWNER.CATEGORY_CODE,

                },new Object[] {

                        EAMTables.OPS_VOUCHER_OWNER.POSITION,


        }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_VOUCHER_OWNER.NOTES
                }
        );



        cfg.view().list().operationColumn().addActionButton("凭证","openHostVoucherWindow");
        cfg.view().list().operationColumn().width(250);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsVoucherOwnerGtr g=new OpsVoucherOwnerGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
     //    g.generateMenu(VoucherOwnerServiceProxy.class, VoucherOwnerPageController.class);
    }
}
