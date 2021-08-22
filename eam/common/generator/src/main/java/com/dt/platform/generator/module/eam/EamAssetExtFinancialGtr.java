package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetExtFinancialMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.ManufacturerMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.eam.page.AssetExtFinancialPageController;
import com.dt.platform.eam.page.AssetExtMaintainerPageController;
import com.dt.platform.proxy.eam.AssetExtFinancialServiceProxy;
import com.dt.platform.proxy.eam.AssetExtMaintainerServiceProxy;
import com.dt.platform.proxy.eam.ManufacturerServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetExtFinancialGtr extends BaseCodeGenerator {

    public EamAssetExtFinancialGtr() {
        super(EAMTables.EAM_ASSET_EXT_FINANCIAL.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");

        cfg.view().field(EAMTables.EAM_ASSET_EXT_FINANCIAL.ID).basic().hidden();


        cfg.view().field(EAMTables.EAM_ASSET_EXT_FINANCIAL.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillBy(AssetExtFinancialMeta.SUPPLIER).muliti(false);

//
//        cfg.view().field(EAMTables.EAM_ASSET_EXT_FINANCIAL.SERVICE_LIFE)
//                .basic().label("使用期限");


//        cfg.view().field(EAMTables.EAM_ASSET_EXT_FINANCIAL.SOURCE_ID)
//                .basic().label("资产来源")
//                .form().selectBox().dict(DictEnum.EAM_SOURCE);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.SUPPLIER_ID,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.CATEGORY_ID,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.ENTRY_TIME,
//                        EAMTables.EAM_ASSET_EXT_FINANCIAL.SOURCE_ID,
//                        EAMTables.EAM_ASSET_EXT_FINANCIAL.SOURCE_DETAIL,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.ASSET_CODE,
                },
                new Object[]{
//                        EAMTables.EAM_ASSET_EXT_FINANCIAL.STORAGE_TIME,


                }


        );



        //分成分组布局
        cfg.view().formWindow().width("1000px");
        cfg.view().form().addGroup("财务属性",
                new Object[] {
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.CATEGORY_ID,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.SUPPLIER_ID,
//                        EAMTables.EAM_ASSET_EXT_FINANCIAL.SOURCE_ID,
//                        EAMTables.EAM_ASSET_EXT_FINANCIAL.SOURCE_DETAIL,

                }, new Object[] {
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.ASSET_CODE,
                      //  EAMTables.EAM_ASSET_EXT_FINANCIAL.SERVICE_LIFE,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.PURCHASE_UNIT_PRICE,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.NAV_PRICE,
                }
                , new Object[] {

//                        EAMTables.EAM_ASSET_EXT_FINANCIAL.STORAGE_TIME,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.ENTRY_TIME,
//                        EAMTables.EAM_ASSET_EXT_FINANCIAL.PURCHASE_DATE,
                        EAMTables.EAM_ASSET_EXT_FINANCIAL.NOTES,

                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetExtFinancialGtr g=new EamAssetExtFinancialGtr();

        //生成代码
        g.generateCode();


        //g.generateMenu(AssetExtFinancialServiceProxy.class, AssetExtFinancialPageController.class);

    }

}
