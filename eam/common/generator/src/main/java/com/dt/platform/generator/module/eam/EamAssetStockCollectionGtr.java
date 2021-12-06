package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.eam.page.AssetStockCollectionPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStockCollectionServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EamAssetStockCollectionGtr extends BaseCodeGenerator{
    public EamAssetStockCollectionGtr() {
        super(EAMTables.EAM_ASSET_STOCK_COLLECTION.$TABLE,BASIC_ASSET_STOCK_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetSourceList","资产来源","资产来源");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","领用公司/部门","领用公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","使用人员","使用人员");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");



        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.SELECTED_CODE).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_ORGANIZATION_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_ORGANIZATION_ID).table().fillBy("useOrganization","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_USER_ID).table().fillBy("useUser","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleFile().displayFileName(false);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.STATUS,
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.POSITION_ID,
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_USER_ID,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.CONTENT,
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.COLLECTION_DATE,
                }
        );
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);




        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.POSITION_DETAIL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.COLLECTION_DATE).search().range();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_USER_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_ORGANIZATION_ID).form().validate().required();


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.COLLECTION_DATE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.OWNER_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.ATTACH).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.ATTACH).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.COLLECTION_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.CONTENT).form().textArea().height(30).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_COLLECTION.POSITION_ID)
                .basic().label("存放位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME).fillWith(AssetCollectionMeta.POSITION).muliti(false);


        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_stock_collection:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_stock_collection:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_stock_collection:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_stock_collection:bill");

        cfg.view().list().operationColumn().width(350);

        //分成分组布局
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.NAME,
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_ORGANIZATION_ID,
                }, new Object[] {
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.POSITION_ID,
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.POSITION_DETAIL,

                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_USER_ID,
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.COLLECTION_DATE,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_COLLECTION.CONTENT,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");

        cfg.view().form().addJsVariable("OWNER_CODE","[[${ownerCode}]]","所属");
        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","所属");

        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
//
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetStockCollectionGtr g=new EamAssetStockCollectionGtr();
        //生成代码
        g.generateCode();
        //生成菜单
        //g.removeByBatchId("");
        // g.generateMenu(PositionServiceProxy.class, PositionPageController.class);
         //g.generateMenu(AssetStockCollectionServiceProxy.class, AssetStockCollectionPageController.class);
    }


}
