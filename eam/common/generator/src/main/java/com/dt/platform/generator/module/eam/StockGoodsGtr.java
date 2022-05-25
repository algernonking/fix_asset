package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetStockGoodsPageController;
import com.dt.platform.eam.page.BrandPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class StockGoodsGtr extends BaseCodeGenerator {


    public StockGoodsGtr() {
        super(EAMTables.EAM_ASSET_STOCK_GOODS.$TABLE,BASIC_STOCK_GOODS_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(GoodsStock.class,"goods","物品","物品");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"source","来源","来源");

        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsModel","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsName","名称","名称");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsCategoryName","分类","分类");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsUnit","计算单位","计算单位");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsCode","物品编码","物品编码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"goodsBarCode","物品条码","物品条码");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_BATCH_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.BUSINESS_CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS.SUPPLIER_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS.WAREHOUSE_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS.BUSINESS_CODE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.OWNER_CODE).form().selectBox()
                .enumType(AssetStockGoodsOwnerEnum.class).defaultValue(AssetStockGoodsOwnerEnum.STOCK);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.OWNER_TYPE).form().selectBox()
                .enumType(AssetStockGoodsTypeEnum.class);


        cfg.view().field(AssetStockGoodsMeta.GOODS_MODEL)
                .basic().label("物品型号")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.MODEL).fillWith(AssetStockGoodsMeta.GOODS).muliti(false);

        cfg.view().field(AssetStockGoodsMeta.GOODS_UNIT)
                .basic().label("计量单位")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.UNIT).fillWith(AssetStockGoodsMeta.GOODS).muliti(false);

        cfg.view().field(AssetStockGoodsMeta.GOODS_CODE)
                .basic().label("物品编码")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.CODE).fillWith(AssetStockGoodsMeta.GOODS).muliti(false);


        cfg.view().field(AssetStockGoodsMeta.GOODS_BAR_CODE)
                .basic().label("物品条码")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.BAR_CODE).fillWith(AssetStockGoodsMeta.GOODS).muliti(false);


//      cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.PURCHASE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.NOTES).form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.USE_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.USE_ORG_ID).table().fillBy("useOrganization","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.OWNER_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.OWNER_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.ORIGINATOR_ID).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.NOTES).table().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillWith(AssetStockGoodsMeta.SUPPLIER).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.WAREHOUSE_ID)
                .basic().label("仓库")
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(AssetStockGoodsMeta.WAREHOUSE).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.SOURCE_ID)
                .basic().label("来源")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_source")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetStockGoodsMeta.SOURCE).muliti(false).defaultValue("purchase");


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.GOODS_ID)
                .basic().label("物品")
                .form().selectBox().queryApi(GoodsStockServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsStockMeta.ID).textField( GoodsStockMeta.NAME).fillWith(AssetStockGoodsMeta.GOODS).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_CUR_NUMBER).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_IN_NUMBER).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.GOODS_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.UNIT_PRICE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.AMOUNT).form().validate().required();

        cfg.view().list().disableBatchDelete();

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_BATCH_CODE,
                        EAMTables.EAM_ASSET_STOCK_GOODS.SOURCE_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS.USE_ORG_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.SUPPLIER_ID,
                        EAMTables.EAM_ASSET_STOCK_GOODS.WAREHOUSE_ID,
                }
        );

        cfg.view().form().addGroup("库存信息",
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_IN_NUMBER,
                        EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_CUR_NUMBER,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.AMOUNT,
                        EAMTables.EAM_ASSET_STOCK_GOODS.UNIT_PRICE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.GOODS_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.NOTES,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        StockGoodsGtr g=new StockGoodsGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(AssetStockGoodsServiceProxy.class, AssetStockGoodsPageController.class);
        //生成菜单

    }

}
