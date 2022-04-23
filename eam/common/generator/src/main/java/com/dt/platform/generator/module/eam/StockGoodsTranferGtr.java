package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.domain.eam.meta.AssetStockGoodsTranferMeta;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;

public class StockGoodsTranferGtr extends BaseCodeGenerator {


    public StockGoodsTranferGtr() {
        super(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.$TABLE,BASIC_STOCK_GOODS_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ID).basic().hidden(true);

        cfg.getPoClassFile().addListProperty(GoodsStock.class,"goodsList","物品","物品");
        cfg.getPoClassFile().addListProperty(String.class,"goodsIds","物品","物品");



        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouseOut","调出仓库","调出仓库");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouseIn","调入仓库","调入仓库");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.BUSINESS_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.STATUS,
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_OUT_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_IN_ID
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.BUSINESS_DATE,
                }
        );


        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+60);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+60);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.OWNER_TYPE).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.PROC_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CHS_STATUS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CHS_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CHS_VERSION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.SUMMARY).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.LATEST_APPROVER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.LATEST_APPROVER_NAME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.NEXT_APPROVER_IDS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.NEXT_APPROVER_NAMES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.APPROVAL_OPINION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ORIGINATOR_ID).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CONTENT).table().disable(true);

        cfg.view().list().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");
        cfg.view().form().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","APPROVAL_REQUIRED");


        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_stock_goods_tranfer:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_stock_goods_tranfer:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_stock_goods_tranfer:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_stock_goods_tranfer:bill");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CONTENT).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ATTACH_ID)
                .form().label("附件").upload().acceptSingleFile().maxFileCount(1).displayFileName(false);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_IN_ID)
                .basic().label("调入仓库")
                .form().validate().required().form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(AssetStockGoodsTranferMeta.WAREHOUSE_IN).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_OUT_ID)
                .basic().label("调出仓库")
                .form().validate().required().form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(AssetStockGoodsTranferMeta.WAREHOUSE_OUT).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.BUSINESS_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_OUT_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.WAREHOUSE_IN_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.CONTENT,
                        EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER.ATTACH_ID,
                }
        );
        cfg.view().form().addPage("物品列表","goodsSelectList");



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页


        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        StockGoodsTranferGtr g=new StockGoodsTranferGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(AssetStockGoodsTranferServiceProxy.class, AssetStockGoodsTranferPageController.class);
        //生成菜单

    }

}
