package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.ops.VoucherTypeEnum;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.domain.ops.meta.VoucherMeta;
import com.dt.platform.domain.ops.meta.VoucherOwnerMeta;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.dt.platform.proxy.ops.VoucherPrivServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;

public class OpsVoucherGtr extends BaseCodeGenerator{


    public OpsVoucherGtr() {
        super(EAMTables.OPS_VOUCHER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.getPoClassFile().addListProperty(DictItem.class,"voucherType","凭证类型","凭证类型");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_VOUCHER.TYPE,
                        EAMTables.OPS_VOUCHER.NOTES
                }

        );

        cfg.view().field(EAMTables.OPS_VOUCHER.NOTES).search().fuzzySearch();

        cfg.view().field(EAMTables.OPS_VOUCHER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_VOUCHER.ID).table().disable(true);
        cfg.view().field(EAMTables.OPS_VOUCHER.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.OPS_VOUCHER.OWNER_ID).table().hidden(true);





        cfg.view().field(EAMTables.OPS_VOUCHER.TYPE).form().validate().required().form().selectBox().queryApi(VoucherPrivServiceProxy.QUERY_TYPE_LIST).valueField(DictItemMeta.CODE)
                .textField(DictItemMeta.LABEL).muliti(false).paging(false).filter(false).toolbar(false).fillBy(VoucherMeta.VOUCHER_TYPE);



        cfg.view().field(EAMTables.OPS_VOUCHER.VOUCHER).form().validate().required();


        cfg.view().field(EAMTables.OPS_VOUCHER.USER_CODE).form().validate().required().form()
                .form().selectBox().dict(DictEnum.OPS_USER_VOUCHER).filter(true).toolbar(false).muliti(false);


        cfg.view().field(EAMTables.OPS_VOUCHER.NOTES).form()
               .textArea().height(30);

        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.OPS_VOUCHER.TYPE,
                        EAMTables.OPS_VOUCHER.USER_CODE,
                        EAMTables.OPS_VOUCHER.VOUCHER,
                        EAMTables.OPS_VOUCHER.NOTES,
                }
        );

        //cfg.setRelationField(EAMTables.OPS_VOUCHER.OWNER_ID, EAMTables.OPS_VOUCHER.USER_CODE,true);

        cfg.view().list().operationColumn().addActionButton("历史记录","openHistoryVoucherWindow");
        cfg.view().list().operationColumn().width(280);

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
        OpsVoucherGtr g=new OpsVoucherGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(VoucherServiceProxy.class, VoucherPageController.class);
    }
}
