package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.domain.eam.meta.AssetStockGoodsOutMeta;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class StockGoodsOutGtr extends BaseCodeGenerator {


    public StockGoodsOutGtr() {
        super(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.$TABLE,BASIC_STOCK_GOODS_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(GoodsStock.class,"goodsList","物品","物品");
        cfg.getPoClassFile().addListProperty(String.class,"goodsIds","物品","物品");




        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"stockTypeDict","出库类型","出库类型");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOwnCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","领用人","领用人");


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.POSITION_DETAIL).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.BUSINESS_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.COLLECTION_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.STATUS,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.POSITION_DETAIL,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.STOCK_TYPE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.WAREHOUSE_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.BUSINESS_DATE,
                }
        );
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.OWNER_TYPE).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_OWN_COMPANY_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_ORGANIZATION_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.PROC_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CHS_STATUS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CHS_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CHS_VERSION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.SUMMARY).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.LATEST_APPROVER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.LATEST_APPROVER_NAME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.NEXT_APPROVER_IDS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.NEXT_APPROVER_NAMES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.APPROVAL_OPINION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ATTACH_ID).table().disable(true);
//        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ORIGINATOR_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CONTENT).table().disable(true);


        cfg.view().list().addJsVariable("OPER_TYPE","[[${operType}]]","OPER_TYPE");
        cfg.view().form().addJsVariable("OPER_TYPE","[[${operType}]]","OPER_TYPE");
        cfg.view().list().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");
        cfg.view().form().addJsVariable("OWNER_TYPE","[[${ownerType}]]","OWNER_TYPE");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","APPROVAL_REQUIRED");


        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_stock_goods_out:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_stock_goods_out:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_stock_goods_out:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_stock_goods_out:bill");


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CONTENT).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ATTACH_ID)
                .form().label("附件").upload().acceptSingleFile().maxFileCount(1).displayFileName(false);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.NAME)
                .basic().label("单据名称").form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.WAREHOUSE_ID)
                .basic().label("仓库").form().validate().required()
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(AssetStockGoodsOutMeta.WAREHOUSE).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.STOCK_TYPE)
                .basic().label("单据类型")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_PAGED_LIST+"?dictCode=eam_stock_out_type")
                .paging(true).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetStockGoodsOutMeta.STOCK_TYPE_DICT).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_OWN_COMPANY_ID)
                .form().validate().required().form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_OWN_COMPANY_ID).table().fillBy("useOwnerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_ORGANIZATION_ID)
                .form().validate().required().form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_ORGANIZATION_ID).table().fillBy("useOrganization","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.STATUS).basic().label("办理状态")
                .form().selectBox().enumType(AssetHandleStatusEnum.class);




        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_USER_ID).table().fillBy("useUser","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_USER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.NAME,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.STOCK_TYPE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_USER_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.WAREHOUSE_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.USE_ORGANIZATION_ID
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.POSITION_DETAIL,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.COLLECTION_DATE,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.BUSINESS_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.CONTENT,
                        EAMTables.EAM_ASSET_STOCK_GOODS_OUT.ATTACH_ID,
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
        StockGoodsOutGtr g=new StockGoodsOutGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(AssetStockGoodsOutServiceProxy.class, AssetStockGoodsOutPageController.class);
        //生成菜单

    }

}
