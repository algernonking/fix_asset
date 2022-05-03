package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationMethodEnum;
import com.dt.platform.constants.enums.eam.AssetFirstDepreciationDateTypeEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.dt.platform.eam.page.AssetDepreciationPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetDepreciationServiceProxy;
import com.dt.platform.proxy.eam.CategoryServiceProxy;

import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;

public class AssetDepreciationGtr extends BaseCodeGenerator {


    public AssetDepreciationGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION.$TABLE,BASIC_CY_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Catalog.class,"category","资产分类","资产分类");


        cfg.getPoClassFile().addListProperty(String.class,"categoryEntityIds","分类","分类");

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NAME).form().validate().required();


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.STATUS).form().validate().required().
                form().selectBox().enumType(StatusEnableEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.METHOD).form().validate().required().
                form().selectBox().enumType(AssetDepreciationMethodEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.FIRST_DEPRECIATION_DATE).form().validate().required().
                form().selectBox().enumType(AssetFirstDepreciationDateTypeEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.CATEGORY_IDS)
                .basic().label("分类")
                .form().validate().required()
                .form().selectBox().queryApi(CategoryServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME).fillWith(AssetDepreciationMeta.CATEGORY).muliti(false);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DEPRECIATION.STATUS,
                        EAMTables.EAM_ASSET_DEPRECIATION.METHOD,
                        EAMTables.EAM_ASSET_DEPRECIATION.NAME,
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.NOTES).form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION.OWN_COMPANY_ID).table().disable(true);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION.NAME,
                        EAMTables.EAM_ASSET_DEPRECIATION.STATUS,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION.METHOD,
                        EAMTables.EAM_ASSET_DEPRECIATION.FIRST_DEPRECIATION_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION.CATEGORY_IDS,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION.NOTES,
                }

        );

        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AssetDepreciationGtr g=new AssetDepreciationGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
    //  g.generateMenu(AssetDepreciationServiceProxy.class, AssetDepreciationPageController.class);
        //生成菜单

    }

}
