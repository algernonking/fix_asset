package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.VoucherOwnerPageController;
import com.dt.platform.proxy.ops.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import com.dt.platform.constants.db.OpsTables;
public class OpsVoucherOwnerGtr extends BaseCodeGenerator{


    public OpsVoucherOwnerGtr() {
        super(OpsTables.OPS_VOUCHER_OWNER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(DictItem.class,"voucherCategory","凭证类型","凭证类型");

        cfg.getPoClassFile().addListProperty(Voucher.class,"voucherList","凭证","凭证");
        cfg.getPoClassFile().addListProperty(String.class,"voucherIds","凭证","凭证");

        cfg.view().field(OpsTables.OPS_VOUCHER_OWNER.NAME).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_VOUCHER_OWNER.NOTES).search().fuzzySearch();
        cfg.view().field(OpsTables.OPS_VOUCHER_OWNER.POSITION).search().fuzzySearch();



        cfg.view().field(OpsTables.OPS_VOUCHER.ID).basic().hidden(true);

        cfg.view().field(OpsTables.OPS_VOUCHER.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_VOUCHER.CREATE_TIME).table().disable(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_VOUCHER_OWNER.CATEGORY_CODE,
                        OpsTables.OPS_VOUCHER_OWNER.LABEL,
                        OpsTables.OPS_VOUCHER_OWNER.NAME,
                        OpsTables.OPS_VOUCHER_OWNER.POSITION,
                },
                    new Object[]{

                            OpsTables.OPS_VOUCHER_OWNER.NOTES
                    }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(OpsTables.OPS_VOUCHER_OWNER.CATEGORY_CODE).form().validate().required().form().selectBox().queryApi(VoucherPrivServiceProxy.QUERY_TYPE_LIST).valueField(DictItemMeta.CODE).textField(DictItemMeta.LABEL).paging(false).filter(false).muliti(false).toolbar(false).fillWith(VoucherOwnerMeta.VOUCHER_CATEGORY);

        cfg.view().field(OpsTables.OPS_VOUCHER_OWNER.LABEL).form().selectBox().dict(DictEnum.OPS_VOUCHER_LABEL);


        cfg.view().field(OpsTables.OPS_VOUCHER_OWNER.NAME).form().validate().required();

        cfg.view().field(OpsTables.OPS_VOUCHER_OWNER.NOTES).form().textArea().height(30);



        cfg.view().field(VoucherOwnerMeta.VOUCHER_IDS)
                .basic().label("用户凭证")
                .table().sort(false)
                .form().selectBox().queryApi(ServiceInfoServiceProxy.QUERY_LIST+"?groupId=os")
                .valueField("user_code").textField("voucher")
                .toolbar(false).paging(false)
                .fillWith(VoucherOwnerMeta.VOUCHER_LIST).muliti(true);



        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("800px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_VOUCHER_OWNER.NAME,
                        OpsTables.OPS_VOUCHER_OWNER.POSITION,


                },new Object[] {
                        OpsTables.OPS_VOUCHER_OWNER.CATEGORY_CODE,
                        OpsTables.OPS_VOUCHER_OWNER.LABEL,

        }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        OpsTables.OPS_VOUCHER_OWNER.NOTES
                }
        );


        cfg.view().list().disableBatchDelete();

        cfg.view().list().operationColumn().addActionButton("凭证","openHostVoucherWindow");
        cfg.view().list().operationColumn().width(250);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
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
