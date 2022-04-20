package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.Brand;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.GoodsStockPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.BrandServiceProxy;
import com.dt.platform.proxy.eam.CategoryServiceProxy;
import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import com.dt.platform.proxy.eam.ManufacturerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class EamGoodsStockGtr extends BaseCodeGenerator {

    public EamGoodsStockGtr() {
        super(EAMTables.EAM_GOODS_STOCK.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Category.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addSimpleProperty(Manufacturer.class,"manufacturer","生产厂商","生产厂商");
        cfg.getPoClassFile().addSimpleProperty(Brand.class,"brand","品牌","品牌");

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NAME).basic().label("物品名称").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MODEL).basic().label("规格型号").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NOTES).basic().label("备注").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.PICTURE_ID).table().disable();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_GOODS_STOCK.STATUS,
                        EAMTables.EAM_GOODS_STOCK.CODE,
                        EAMTables.EAM_GOODS_STOCK.CATEGORY_ID,
                        EAMTables.EAM_GOODS_STOCK.MANUFACTURER_ID
                },
                new Object[]{
                        EAMTables.EAM_GOODS_STOCK.BAR_CODE,
                        EAMTables.EAM_GOODS_STOCK.BRAND_ID,
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.PICTURE_ID)
                .form().label("图片").upload().acceptSingleImage().maxFileCount(1).displayFileName(false);



        cfg.view().field(EAMTables.EAM_GOODS_STOCK.CATEGORY_ID)
                .basic().label("分类")
                .form().validate().required()
                .form().selectBox().queryApi(CategoryServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CategoryMeta.ID).textField(CategoryMeta.HIERARCHY_NAME).fillWith(GoodsMeta.CATEGORY).muliti(false);

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.BRAND_ID)
                .basic().label("品牌")
                .form().validate().required()
                .form().selectBox().queryApi(BrandServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(BrandMeta.ID).textField(BrandMeta.BRAND_NAME).fillWith(GoodsStockMeta.BRAND).muliti(false);


        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MANUFACTURER_ID)
                .basic().label("厂商")
                .form().validate().required()
                .form().selectBox().queryApi(ManufacturerServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(ManufacturerMeta.ID).textField(ManufacturerMeta.MANUFACTURER_NAME).fillWith(GoodsMeta.MANUFACTURER).muliti(false);

        cfg.view().field(EAMTables.EAM_GOODS_STOCK.STATUS).basic().label("状态")
                .form().validate().required().form().selectBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.BAR_CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.MODEL).form().validate().required();
        cfg.view().field(EAMTables.EAM_GOODS_STOCK.NOTES).form().textArea().height(60);


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.CATEGORY_ID,
                        EAMTables.EAM_GOODS_STOCK.STATUS,
                        EAMTables.EAM_GOODS_STOCK.UNIT,
                }, new Object[] {
                        EAMTables.EAM_GOODS_STOCK.CODE,
                        EAMTables.EAM_GOODS_STOCK.BAR_CODE,
                },
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.MANUFACTURER_ID,
                        EAMTables.EAM_GOODS_STOCK.BRAND_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.NAME,
                        EAMTables.EAM_GOODS_STOCK.MODEL,
                },
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.STOCK_MIN,
                        EAMTables.EAM_GOODS_STOCK.STOCK_MAX,
                }, new Object[] {
                        EAMTables.EAM_GOODS_STOCK.STOCK_SECURITY,
                        EAMTables.EAM_GOODS_STOCK.DEFAULT_PRICE,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_GOODS_STOCK.NOTES,
                        EAMTables.EAM_GOODS_STOCK.PICTURE_ID

                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }




    public static void main(String[] args) throws Exception {
        EamGoodsStockGtr g=new EamGoodsStockGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
         //g.generateMenu(GoodsStockServiceProxy.class, GoodsStockPageController.class);
    }


}
