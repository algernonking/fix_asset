package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.AssetDepreciationOper;
import com.dt.platform.domain.eam.meta.AssetDepreciationDetailMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.dt.platform.eam.page.AssetDepreciationDetailPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetDepreciationDetailServiceProxy;
import com.dt.platform.proxy.eam.AssetDepreciationOperServiceProxy;
import com.dt.platform.proxy.eam.AssetDepreciationServiceProxy;
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

        cfg.view().search().disable();
//        cfg.view().search().inputLayout(
//                new Object[]{
////                        EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.,
//                }
//        );


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

        cfg.view().list().addJsVariable("OPER_ID","[[${operId}]]","OPER_ID");

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.OPER_ID,
                        EAMTables.EAM_ASSET_DEPRECIATION_DETAIL.DEPRECIATION_ID,
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
