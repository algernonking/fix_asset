package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.AssetDepreciationDetail;
import com.dt.platform.domain.eam.AssetDepreciationOper;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetDepreciationDetailPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.config.WriteMode;

public class AssetDepreciationDetailGtr extends BaseCodeGenerator {


    public AssetDepreciationDetailGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.$TABLE,BASIC_CY_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.ID).basic().hidden(true);



        cfg.getPoClassFile().addSimpleProperty(Asset.class,"assetSource","资产","资产");

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"assetTarget","资产","资产");

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");

        cfg.getPoClassFile().addSimpleProperty(AssetDepreciation.class,"assetDepreciation","方案","方案");
        cfg.getPoClassFile().addSimpleProperty(AssetDepreciationOper.class,"assetDepreciationOper","操作","操作");

        cfg.getPoClassFile().addSimpleProperty(String.class,"assetCurName","名称","名称");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetCurModel","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetCurCode","编码","编码");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetCurPurchaseUnitPrice","采购单价","采购单价");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetCurNavPrice","资产净值","资产净值");

        cfg.getPoClassFile().addSimpleProperty(String.class,"assetAfterNavPrice","资产净值","资产净值");
        cfg.getPoClassFile().addSimpleProperty(String.class,"assetBeforeNavPrice","资产净值","资产净值");



      //  cfg.view().search().disable();
        cfg.view().search().inputLayout(
                new Object[]{
                      EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DEPRECIATION_ID,
                }
        );

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DEPRECIATION_ID)
                .form().validate().required().form().selectBox().queryApi(AssetDepreciationServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssetDepreciationMeta.ID).
                textField(AssetDepreciationMeta.NAME).
                fillWith(AssetDepreciationDetailMeta.ASSET_DEPRECIATION).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.OPER_ID)
                .form().validate().required().form().selectBox().queryApi(AssetDepreciationOperServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssetDepreciationOperMeta.ID).
                textField(AssetDepreciationOperMeta.NAME).
                fillWith(AssetDepreciationDetailMeta.ASSET_DEPRECIATION_OPER).muliti(false).defaultIndex(0);


        cfg.view().field(AssetDepreciationDetailMeta.ASSET_CUR_NAME)
                .basic().label("资产名称")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.NAME).fillWith(AssetDepreciationDetailMeta.ASSET).muliti(false);


        cfg.view().field(AssetDepreciationDetailMeta.ASSET_CUR_MODEL)
                .basic().label("资产型号")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.MODEL).fillWith(AssetDepreciationDetailMeta.ASSET).muliti(false);


        cfg.view().field(AssetDepreciationDetailMeta.ASSET_CUR_CODE)
                .basic().label("资产编号")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.ASSET_CODE).fillWith(AssetDepreciationDetailMeta.ASSET).muliti(false);




        cfg.view().field(AssetDepreciationDetailMeta.ASSET_CUR_PURCHASE_UNIT_PRICE)
                .basic().label("当前采购单价")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.PURCHASE_UNIT_PRICE).fillWith(AssetDepreciationDetailMeta.ASSET).muliti(false);

        cfg.view().field(AssetDepreciationDetailMeta.ASSET_CUR_NAV_PRICE)
                .basic().label("当前净值")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.NAV_PRICE).fillWith(AssetDepreciationDetailMeta.ASSET).muliti(false);

        cfg.view().field(AssetDepreciationDetailMeta.ASSET_BEFORE_NAV_PRICE)
                .basic().label("折旧前净值")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.NAV_PRICE).fillWith(AssetDepreciationDetailMeta.ASSET_SOURCE).muliti(false);

        cfg.view().field(AssetDepreciationDetailMeta.ASSET_AFTER_NAV_PRICE)
                .basic().label("折旧后净值")
                .form().selectBox().queryApi(AssetServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(AssetMeta.ID).textField( AssetMeta.NAV_PRICE).fillWith(AssetDepreciationDetailMeta.ASSET_TARGET).muliti(false);



        cfg.view().list().addJsVariable("OPER_ID","[[${operId}]]","OPER_ID");

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.OPER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DEPRECIATION_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.ASSET_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DETAIL_ID_SOURCE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DETAIL_ID_TARGET).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.CREATE_TIME).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.CUR_PRICE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.AFTER_PRICE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.BEFORE_PRICE).table().disable(true);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                      //  EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.OPER_ID,
                       // EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DEPRECIATION_ID,

                        AssetDepreciationDetailMeta.ASSET_CUR_NAME,
                        AssetDepreciationDetailMeta.ASSET_CUR_MODEL,
                        AssetDepreciationDetailMeta.ASSET_CUR_CODE,
                        AssetDepreciationDetailMeta.ASSET_CUR_PURCHASE_UNIT_PRICE,
                        AssetDepreciationDetailMeta.ASSET_CUR_NAV_PRICE,
                        AssetDepreciationDetailMeta.ASSET_BEFORE_NAV_PRICE,
                        AssetDepreciationDetailMeta.ASSET_AFTER_NAV_PRICE
                }
        );


        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableModify();
        cfg.view().list().disableCreateNew();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableFormView();

        cfg.view().search().inputWidth(Config.searchInputWidth);
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
        AssetDepreciationDetailGtr g=new AssetDepreciationDetailGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行

       // g.generateMenu(AssetDepreciationDetailServiceProxy.class, AssetDepreciationDetailPageController.class);
     //g.generateMenu(BrandServiceProxy.class, BrandPageController.class);
        //生成菜单

    }

}
