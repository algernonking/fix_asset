package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.page.VoucherHistoryPageController;
import com.dt.platform.proxy.ops.VoucherHistoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.dt.platform.constants.db.OpsTables;
public class OpsVoucherHistoryGtr extends BaseCodeGenerator{


    public OpsVoucherHistoryGtr() {
        super(OpsTables.OPS_VOUCHER_HISTORY.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());





        cfg.view().field(OpsTables.OPS_VOUCHER_HISTORY.NOTES).search().fuzzySearch();

        cfg.view().field(OpsTables.OPS_VOUCHER_HISTORY.ID).basic().hidden(true);
        cfg.view().field(OpsTables.OPS_VOUCHER_HISTORY.ID).table().disable(true);
        cfg.view().field(OpsTables.OPS_VOUCHER_HISTORY.VOUCHER_ID).table().hidden(true);

        cfg.view().field(OpsTables.OPS_VOUCHER.USER_CODE).form().validate().required().form()
                .form().selectBox().dict(DictEnum.OPS_USER_VOUCHER).filter(true).toolbar(false).muliti(false);


        cfg.view().form().disableFooter();

        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableFormView();
        cfg.view().list().disableModify();



        cfg.view().search().inputLayout(
                new Object[]{
                        OpsTables.OPS_VOUCHER_HISTORY.NOTES
                }

        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        OpsVoucherHistoryGtr g=new OpsVoucherHistoryGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(VoucherHistoryServiceProxy.class, VoucherHistoryPageController.class);
    }
}
