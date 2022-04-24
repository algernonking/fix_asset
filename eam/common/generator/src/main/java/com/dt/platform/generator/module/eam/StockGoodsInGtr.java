package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetStockGoodsInPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStockGoodsInServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class StockGoodsInGtr extends BaseCodeGenerator {


    public StockGoodsInGtr() {
        super(EAMTables.EAM_ASSET_STOCK_GOODS_IN.$TABLE,BASIC_STOCK_GOODS_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ID).basic().hidden(true);


        cfg.getPoClassFile().addListProperty(GoodsStock.class,"goodsList","物品","物品");
        cfg.getPoClassFile().addListProperty(String.class,"goodsIds","物品","物品");




        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"stockTypeDict","入库类型","入库类型");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"source","来源","来源");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人","管理人");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.BATCH_CODE).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.STATUS,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.BATCH_CODE,

                },
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.WAREHOUSE_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.SUPPLIER_NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.RECEIVER_USER_NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.NOTES,

                }
        );

        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().list().disableBatchDelete();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.WAREHOUSE_ID).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.OWNER_TYPE).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.PROC_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.CHS_STATUS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.CHS_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.CHS_VERSION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.SUMMARY).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.LATEST_APPROVER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.LATEST_APPROVER_NAME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.NEXT_APPROVER_IDS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.NEXT_APPROVER_NAMES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.APPROVAL_OPINION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.OWN_COMPANY_ID).table().disable(true);
//        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ORIGINATOR_ID).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.BUSINESS_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.PURCHASE_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ATTACH_ID)
                .form().label("附件").upload().acceptSingleFile().maxFileCount(1).displayFileName(false);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.WAREHOUSE_ID)
                .basic().label("仓库")
                .form().validate().required().form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(AssetStockGoodsInMeta.WAREHOUSE).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.SOURCE_ID)
                .basic().label("来源")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_source")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetStockGoodsInMeta.SOURCE).muliti(false).defaultValue("purchase");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.STOCK_TYPE)
                .basic().label("单据类型")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_PAGED_LIST+"?dictCode=eam_stock_in_type")
                .paging(true).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetStockGoodsOutMeta.STOCK_TYPE_DICT).muliti(false).defaultIndex(0);





        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.STATUS).basic().label("办理状态")
                .form().selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.MANAGER_ID).table().fillBy("manager","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_IN.MANAGER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().list().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");
        cfg.view().form().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");

        cfg.view().list().addJsVariable("OPER_TYPE","[[${operType}]]","OPER_TYPE");
        cfg.view().form().addJsVariable("OPER_TYPE","[[${operType}]]","OPER_TYPE");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","APPROVAL_REQUIRED");




        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_stock_goods_in:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_stock_goods_in:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_stock_goods_in:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_stock_goods_in:bill");



        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.STOCK_TYPE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.RECEIVER_USER_NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.MANAGER_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.WAREHOUSE_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.SUPPLIER_NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.BATCH_CODE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.AMOUNT,
                },
                new Object[] {
                     //   EAMTables.EAM_ASSET_STOCK_GOODS_IN.OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.SOURCE_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.BUSINESS_DATE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.PURCHASE_DATE,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.NOTES,
                        EAMTables.EAM_ASSET_STOCK_GOODS_IN.ATTACH_ID,
                }
        );

        cfg.view().form().addPage("物品列表","goodsSelectList");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        StockGoodsInGtr g=new StockGoodsInGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(AssetStockGoodsInServiceProxy.class, AssetStockGoodsInPageController.class);
        //生成菜单

    }

}
