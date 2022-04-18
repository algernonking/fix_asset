package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetDeliverStatusEnum;
import com.dt.platform.constants.enums.eam.AssetDeliverTypeEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.CategoryMeta;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.dt.platform.domain.eam.meta.ManufacturerMeta;
import com.dt.platform.eam.page.AssetStockDeliverPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStockDeliverServiceProxy;
import com.dt.platform.proxy.eam.CategoryServiceProxy;
import com.dt.platform.proxy.eam.ManufacturerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;


public class EamAssetStockDeliverGtr extends BaseCodeGenerator {

    public EamAssetStockDeliverGtr() {
        super(EAMTables.EAM_ASSET_STOCK_DELIVER.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"deliverAssetList","库存资产","库存资产");
        cfg.getPoClassFile().addListProperty(String.class,"deliverAssetIds","库存资产","库存资产");


        cfg.getPoClassFile().addSimpleProperty(ChangeInstance.class,"changeInstance","变更实例","变更实例");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"receiver","领用人","领用人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"receivingCompany","领用公司","领用公司");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"receivingOrg","领用部门","领用部门");


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.POSITION_DETAIL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.NOTES).search().fuzzySearch();



        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_DELIVER.STATUS,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_COMPANY_ID,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_ORG_ID,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.DELIVER_TYPE,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_DELIVER.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.NAME,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.SHIPPER_NAME,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.NOTES,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_DELIVER.DELIVER_DATE,
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.ATTACH).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.OWNER_CODE).table().disable();


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.ATTACH)
                .form().label("附件").upload().acceptSingleImage().maxFileCount(1).displayFileName(false);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.DELIVER_STATUS).form()
                .selectBox().enumType(AssetDeliverStatusEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.DELIVER_TYPE).form().validate().required().form()
                 .selectBox().enumType(AssetDeliverTypeEnum.class);



        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_COMPANY_ID)
                .form().validate().required().form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_COMPANY_ID).table().form().validate().table().fillBy("receivingCompany","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_ORG_ID).table().form().validate().table().fillBy("receivingOrg","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVER_ID).table().form().validate().required().form().fillBy("receiver","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据Id");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","库存所属");
        cfg.view().list().addJsVariable("STOCK_TYPE","[[${stockType}]]","库存类型");
        cfg.view().list().addJsVariable("TABLE_ID","[[${tableId}]]","表格");


        cfg.view().list().disableBatchDelete();


        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_stock_deliver:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_stock_deliver:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_stock_deliver:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_stock_deliver:bill");



        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_DELIVER.NAME,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.SHIPPER_NAME,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.DELIVER_DATE,

                }, new Object[] {
                        EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_COMPANY_ID,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVING_ORG_ID,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.RECEIVER_ID,
                }
                , new Object[] {
                        EAMTables.EAM_ASSET_STOCK_DELIVER.DELIVER_TYPE,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.POSITION_DETAIL,

                }
        );






        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_DELIVER.CONTENT,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.NOTES,
                        EAMTables.EAM_ASSET_STOCK_DELIVER.ATTACH

                }
        );


        cfg.view().form().addPage("资产列表","assetSelectList");



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
        EamAssetStockDeliverGtr g=new EamAssetStockDeliverGtr();
        //生成代码
        g.generateCode();



        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(AssetStockDeliverServiceProxy.class, AssetStockDeliverPageController.class);
    }


}
