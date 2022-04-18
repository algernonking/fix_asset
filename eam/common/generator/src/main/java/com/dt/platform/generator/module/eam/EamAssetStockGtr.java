package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStockTypeEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.StockMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.eam.page.StockPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.StockServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamAssetStockGtr extends BaseCodeGenerator{
    public EamAssetStockGtr() {
        super(EAMTables.EAM_STOCK.$TABLE,BASIC_ASSET_STOCK_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"stockAssetList","库存资产","库存资产");
        cfg.getPoClassFile().addListProperty(String.class,"stockAssetIds","库存资产","库存资产");

        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");


        cfg.getPoClassFile().addSimpleProperty(ChangeInstance.class,"changeInstance","变更实例","变更实例");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人员","管理人员");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"source","来源","来源");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");





        cfg.view().field(EAMTables.EAM_STOCK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_STOCK.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK.STOCK_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK.STOCK_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK.RECEIVER_USER_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK.BUSINESS_DATE).search().range(true);
        cfg.view().field(EAMTables.EAM_STOCK.PURCHASE_DATE).search().range(true);
        cfg.view().field(EAMTables.EAM_STOCK.ORIGINATOR_ID).basic().hidden(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_STOCK.STATUS,
                        EAMTables.EAM_STOCK.STOCK_NAME,
                        EAMTables.EAM_STOCK.BUSINESS_CODE,
                        EAMTables.EAM_STOCK.STOCK_BATCH_CODE,

                },
                new Object[]{
                        EAMTables.EAM_STOCK.SUPPLIER_ID,
                        EAMTables.EAM_STOCK.SOURCE_ID,
                        EAMTables.EAM_STOCK.STOCK_NOTES,
                        EAMTables.EAM_STOCK.RECEIVER_USER_NAME,

                },
                new Object[]{
                            EAMTables.EAM_STOCK.PURCHASE_DATE,
                            EAMTables.EAM_STOCK.BUSINESS_DATE,
                    }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().field(EAMTables.EAM_STOCK.STOCK_NAME).form().validate().required();
        //cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_STOCK.STOCK_TYPE) .form().selectBox().enumType(AssetStockTypeEnum.class);

        cfg.view().field(EAMTables.EAM_STOCK.WAREHOUSE_ID)
                .basic().label("仓库")
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(StockMeta.WAREHOUSE).muliti(false);

        cfg.view().field(EAMTables.EAM_STOCK.SOURCE_ID)
                .basic().label("来源")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_source")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(StockMeta.SOURCE).muliti(false).defaultValue("purchase");

        cfg.view().field(EAMTables.EAM_ASSET.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillWith(StockMeta.SUPPLIER).muliti(false);




        cfg.view().field(EAMTables.EAM_STOCK.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_STOCK.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_STOCK.AMOUNT).form().numberInput().allowNegative(false).scale(2);

        cfg.view().field(EAMTables.EAM_ASSET.OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");


        cfg.view().field(EAMTables.EAM_STOCK.MANAGER_ID).table().fillBy("manager","nameAndBadge");

        cfg.view().field(EAMTables.EAM_STOCK.MANAGER_ID).form()
                .button().chooseEmployee(true);



        cfg.view().field(EAMTables.EAM_STOCK.ATTACH_ID)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleImage().maxFileCount(1).displayFileName(false);


        cfg.view().list().disableBatchDelete();


        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");

        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","库存所属");
        cfg.view().list().addJsVariable("STOCK_TYPE","[[${stockType}]]","库存类型");
        cfg.view().list().addJsVariable("TABLE_ID","[[${tableId}]]","表格");



        cfg.view().list().operationColumn().addActionButton("送审","forApproval",null);
        cfg.view().list().operationColumn().addActionButton("确认","confirmData",null);
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData",null);




        cfg.view().field(EAMTables.EAM_STOCK.ID).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.OWNER_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.ATTACH_ID).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.CHS_TYPE).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.CHS_STATUS).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.CHS_VERSION).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.CHANGE_INSTANCE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.LATEST_APPROVER_ID).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.LATEST_APPROVER_NAME).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.NEXT_APPROVER_IDS).table().disable();
        cfg.view().field(EAMTables.EAM_STOCK.NEXT_APPROVER_NAMES).table().disable();


        cfg.view().formWindow().bottomSpace(100);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK.STOCK_NAME,
                        EAMTables.EAM_STOCK.STOCK_BATCH_CODE,
                        EAMTables.EAM_STOCK.RECEIVER_USER_NAME,
                }
                , new Object[] {
                        EAMTables.EAM_STOCK.SOURCE_ID,
                        EAMTables.EAM_STOCK.SUPPLIER_ID,
                        EAMTables.EAM_STOCK.WAREHOUSE_ID,
                }
                , new Object[] {
                        EAMTables.EAM_STOCK.OWN_COMPANY_ID,
                        EAMTables.EAM_STOCK.MANAGER_ID,
                        EAMTables.EAM_STOCK.AMOUNT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK.STOCK_NOTES,
                },
                new Object[] {
                        EAMTables.EAM_STOCK.ATTACH_ID
                }
        );

        cfg.view().form().addPage("资产列表","assetSelectList");



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();

        //文件生成覆盖模式
//        cfg.overrides()
//                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
//                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
//                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
//                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
//                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
//                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
//        cfg.buildAll();

    }

    public static void main(String[] args) throws Exception {
        EamAssetStockGtr g=new EamAssetStockGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(StockServiceProxy.class, StockPageController.class);
    }
}
