package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.GoodsStautsEnum;
import com.dt.platform.domain.eam.Brand;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.meta.BrandMeta;
import com.dt.platform.domain.eam.meta.CategoryMeta;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.dt.platform.domain.eam.meta.ManufacturerMeta;
import com.dt.platform.proxy.eam.BrandServiceProxy;
import com.dt.platform.proxy.eam.CategoryServiceProxy;
import com.dt.platform.proxy.eam.ManufacturerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class EamGoodsGtr extends BaseCodeGenerator {

    public EamGoodsGtr() {
        super(EAMTables.EAM_GOODS.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {


        cfg.getPoClassFile().addSimpleProperty(Category.class,"category","资产分类","资产分类");

        cfg.getPoClassFile().addSimpleProperty(Brand.class,"brand","品牌","品牌");

        cfg.getPoClassFile().addSimpleProperty(Manufacturer.class,"manufacturer","生产厂商","生产厂商");




        cfg.view().field(EAMTables.EAM_GOODS.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_GOODS.NAME).basic().label("物品名称").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS.MODEL).basic().label("规格型号").search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_GOODS.REFERENCE_PRICE).basic().label("参考价").search().hidden();
        cfg.view().field(EAMTables.EAM_GOODS.UNIT).basic().label("计量单位").search().hidden();
        cfg.view().field(EAMTables.EAM_GOODS.NOTES).basic().label("备注").search().fuzzySearch();


        cfg.view().field(EAMTables.EAM_GOODS.PICTURE_ID).basic().label("图片").search().hidden();
        cfg.view().field(EAMTables.EAM_GOODS.STATUS).basic().label("状态")
                .form().validate().required().form().radio().enumType(GoodsStautsEnum.class);

        cfg.view().field(EAMTables.EAM_GOODS.CATEGORY_ID)
                .basic().label("资产分类").search().hidden()
                .form().validate().required()
                .form().select().queryApi(CategoryServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(true)
                .valueField(CategoryMeta.ID).textField(CategoryMeta.HIERARCHY_NAME).fillBy(GoodsMeta.CATEGORY).muliti(false);


        cfg.view().field(EAMTables.EAM_GOODS.BRAND_ID)
                .basic().label("品牌").search().hidden()
                .form().validate().required()
                .form().select().queryApi(BrandServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(BrandMeta.ID).textField(BrandMeta.BRAND_NAME).fillBy(GoodsMeta.BRAND).muliti(false);

        cfg.view().field(EAMTables.EAM_GOODS.MANUFACTURER_ID)
                .basic().label("生产厂商").search().hidden()
                .form().validate().required()
                .form().select().queryApi(ManufacturerServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(ManufacturerMeta.ID).textField(ManufacturerMeta.MANUFACTURER_NAME).fillBy(GoodsMeta.MANUFACTURER).muliti(false);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }




    public static void main(String[] args) throws Exception {
        EamGoodsGtr g=new EamGoodsGtr();
        //生成代码
        g.generateCode();



        //生成菜单
        //g.removeByBatchId("");
         //g.generateMenu(GoodsServiceProxy.class, GoodsPageController.class);
    }


}
