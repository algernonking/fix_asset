package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.PurchaseApply;
import com.dt.platform.domain.eam.PurchaseOrder;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;


public class EamPurchaseCheckGtr extends BaseCodeGenerator {

    public EamPurchaseCheckGtr() {
        super(EAMTables.EAM_PURCHASE_CHECK.$TABLE,BASIC_BUY_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");
        cfg.getPoClassFile().addSimpleProperty(PurchaseApply.class,"purchaseApply","领用申请","领用申请");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"checkOrg","验收公司/部门","验收公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addListProperty(PurchaseOrder.class,"orderList","订单","订单");
        cfg.getPoClassFile().addListProperty(String.class,"orderIds","订单列表","订单列表");

        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CHECK_USER_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.BUSINESS_CODE).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.RECEIVE_DATE).search().range();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CHECK_DATE).search().range();




        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_PURCHASE_CHECK.BUSINESS_CODE,
                        EAMTables.EAM_PURCHASE_CHECK.CODE,
                        EAMTables.EAM_PURCHASE_CHECK.NAME,
                        EAMTables.EAM_PURCHASE_CHECK.CHECK_USER_NAME,
                },
                new Object[]{
                        EAMTables.EAM_PURCHASE_CHECK.RECEIVE_DATE,
                        EAMTables.EAM_PURCHASE_CHECK.CHECK_DATE,
                }
        );





        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.ATTACH).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.STATUS).table().disable();

        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.ATTACH)
                .form().label("附件").upload().acceptSingleImage().maxFileCount(1).displayFileName(false);


        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CHECK_INFORMATION).form().textArea().height(50);
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.NOTES).form().textArea().height(50);




        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.NAME)
                .form().validate().required();

        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CHECK_USER_NAME)
                .form().validate().required();


        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillWith(PurchaseCheckMeta.SUPPLIER).muliti(false);


        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CHECK_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.RECEIVE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();



        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CHECK_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_CHECK.CHECK_ORG_ID).table().fillBy("checkOrg","fullName");

        cfg.view().list().disableBatchDelete();

        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_scrap:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_scrap:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_scrap:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_scrap:bill");


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_PURCHASE_CHECK.NAME,
                        EAMTables.EAM_PURCHASE_CHECK.CODE,
                        EAMTables.EAM_PURCHASE_CHECK.CHECK_USER_NAME,
                }, new Object[] {
                        EAMTables.EAM_PURCHASE_CHECK.SUPPLIER_ID,
                        EAMTables.EAM_PURCHASE_CHECK.CHECK_ORG_ID,
                }, new Object[] {
                        EAMTables.EAM_PURCHASE_CHECK.RECEIVE_DATE,
                        EAMTables.EAM_PURCHASE_CHECK.CHECK_DATE,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_PURCHASE_CHECK.CHECK_INFORMATION,
                        EAMTables.EAM_PURCHASE_CHECK.NOTES,
                        EAMTables.EAM_PURCHASE_CHECK.ATTACH

                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }




    public static void main(String[] args) throws Exception {
        EamPurchaseCheckGtr g=new EamPurchaseCheckGtr();
        //生成代码
        g.generateCode();



        //生成菜单
        //g.removeByBatchId("");
       //  g.generateMenu(PurchaseCheckServiceProxy.class, PurchaseCheckPageController.class);
    }


}
