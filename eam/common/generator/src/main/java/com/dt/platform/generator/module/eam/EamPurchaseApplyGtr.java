package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetApplyCheckStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.PurchaseOrder;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.meta.PurchaseApplyMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;


public class EamPurchaseApplyGtr extends BaseCodeGenerator {

    public EamPurchaseApplyGtr() {
        super(EAMTables.EAM_PURCHASE_APPLY.$TABLE,BASIC_BUY_ID);
    }

    public void generateCode() throws Exception {


        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"applyOrg","申请部门","申请部门");

        cfg.getPoClassFile().addSimpleProperty(ChangeInstance.class,"changeInstance","变更实例","变更实例");

        cfg.getPoClassFile().addListProperty(PurchaseOrder.class,"orderList","订单","订单");
        cfg.getPoClassFile().addListProperty(String.class,"orderIds","订单列表","订单列表");



        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.NAME).basic().search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.NOTES).basic().search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.HARVEST_INFORMATION).basic().search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_CONTENT).basic().search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.BUSINESS_CODE).basic().search().fuzzySearch().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.EXPECTED_ARRIVAL_DATE).basic().search().range();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_DATE).basic().search().range();

        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.EXPECTED_ARRIVAL_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.ATTACH)
                .form().label("附件").upload().acceptSingleImage().maxFileCount(1).displayFileName(false);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_PURCHASE_APPLY.STATUS,
//                        EAMTables.EAM_PURCHASE_APPLY.APPLY_STATUS,
                        EAMTables.EAM_PURCHASE_APPLY.SUPPLIER_ID,
                        EAMTables.EAM_PURCHASE_APPLY.ASSET_CHECK,
                        EAMTables.EAM_PURCHASE_APPLY.APPLY_ORG_ID,
                },
                new Object[]{
                        EAMTables.EAM_PURCHASE_APPLY.BUSINESS_CODE,
                        EAMTables.EAM_PURCHASE_APPLY.NAME,
                        EAMTables.EAM_PURCHASE_APPLY.APPLY_DATE,
                }
        );



        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_CONTENT).form().textArea().height(50);
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.NOTES).form().textArea().height(50);

        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillWith(PurchaseApplyMeta.SUPPLIER).muliti(false);

        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.ASSET_CHECK).form().form().selectBox().enumType(AssetApplyCheckStatusEnum.class).defaultValue("not_check");

        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_CONTENT).form().validate().required();


        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_STATUS).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.CHS_STATUS).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.CHS_TYPE).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.CHS_VERSION).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.CHANGE_INSTANCE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.SUMMARY).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.LATEST_APPROVER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.LATEST_APPROVER_NAME).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.NEXT_APPROVER_IDS).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.NEXT_APPROVER_NAMES).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPROVAL_OPINION).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.ATTACH).table().disable();



        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_PURCHASE_APPLY.APPLY_ORG_ID).table().fillBy("applyOrg","fullName");

        cfg.view().list().disableBatchDelete();

        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_scrap:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_scrap:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_scrap:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_scrap:bill");


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_PURCHASE_APPLY.NAME,
                        EAMTables.EAM_PURCHASE_APPLY.HARVEST_INFORMATION,
                },
                new Object[] {
                        EAMTables.EAM_PURCHASE_APPLY.SUPPLIER_ID,
                        EAMTables.EAM_PURCHASE_APPLY.APPLY_ORG_ID,
                },
                new Object[] {
                        EAMTables.EAM_PURCHASE_APPLY.APPLY_DATE,
                        EAMTables.EAM_PURCHASE_APPLY.EXPECTED_ARRIVAL_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_PURCHASE_APPLY.APPLY_CONTENT,
                        EAMTables.EAM_PURCHASE_APPLY.NOTES,
                        EAMTables.EAM_PURCHASE_APPLY.ATTACH
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
        EamPurchaseApplyGtr g=new EamPurchaseApplyGtr();
        //生成代码
        g.generateCode();
      //  g.removeByBatchId("567079529017769984");
      //  g.generateMenu(PurchaseApplyServiceProxy.class, PurchaseApplyPageController.class);
    }


}
