package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.proxy.eam.*;
import com.github.foxnic.generator.config.WriteMode;
import  com.dt.platform.constants.enums.eam.AssetStatusEnum;


public class EamAssetsGtr extends BaseCodeGenerator {

    public EamAssetsGtr() {
        super(EAMTables.EAM_ASSET.$TABLE,BASIC_ASSET_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {


        cfg.getPoClassFile().addSimpleProperty(AssetExtFinancial.class,"assetFinancial","财务信息","财务信息");
        cfg.getPoClassFile().addSimpleProperty(AssetExtFinancial.class,"assetMaintainer","维保信息","维保信息");
        cfg.getPoClassFile().addSimpleProperty(AssetExtEquipment.class,"assetEquipment","设备信息","设备信息");
        cfg.getPoClassFile().addSimpleProperty(AssetExtSoftware.class,"assetExtSoftware","软件信息","软件信息");
        cfg.getPoClassFile().addSimpleProperty(AssetExtAttribution.class,"assetExtAttribution","归属信息","归属信息");




        cfg.getPoClassFile().addSimpleProperty(Category.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addSimpleProperty(Goods.class,"goods","物品档案","物品档案");
        cfg.getPoClassFile().addSimpleProperty(Manufacturer.class,"manufacturer","生产厂商","生产厂商");
        cfg.getPoClassFile().addSimpleProperty(Brand.class,"brand","品牌","品牌");



        cfg.view().field(EAMTables.EAM_ASSET.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.SCRAP).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.DISPLAY).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.INSERT_TYPE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.BUSI_CODE).basic().form().hidden(true);


        cfg.view().field(EAMTables.EAM_ASSET.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.SERIAL_NUMBER).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.MODEL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.BATCH_CODE).search().fuzzySearch();



        cfg.view().field(EAMTables.EAM_ASSET.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET.STATUS).form().validate().required().form().label("状态").selectBox().enumType(AssetStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET.CATEGORY_ID)
                .basic().label("分类")
                .form().validate().required()
                .form().selectBox().queryApi(CategoryServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(true)
                .valueField(CategoryMeta.ID).textField(CategoryMeta.HIERARCHY_NAME).fillBy(AssetMeta.CATEGORY).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.GOODS_ID)
                .basic().label("物品档案")
                .form().selectBox().queryApi(GoodsServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(GoodsMeta.ID).textField(GoodsMeta.NAME).fillBy(AssetMeta.GOODS).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.BRAND_ID)
                .basic().label("品牌")
                .form().selectBox().queryApi(BrandServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(BrandMeta.ID).textField(BrandMeta.BRAND_NAME).fillBy(AssetMeta.BRAND).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET.MANUFACTURER_ID)
                .basic().label("厂商")
                .form().selectBox().queryApi(ManufacturerServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(ManufacturerMeta.ID).textField(ManufacturerMeta.MANUFACTURER_NAME).fillBy(AssetMeta.MANUFACTURER).muliti(false);




        cfg.view().field(EAMTables.EAM_ASSET.NAME)
                .basic().label("名称");


        cfg.view().field(EAMTables.EAM_ASSET.MODEL)
                .basic().label("规格型号");

        cfg.view().field(EAMTables.EAM_ASSET.UNIT)
                .basic().label("计量单位");

        cfg.view().field(EAMTables.EAM_ASSET.SERIAL_NUMBER)
                .basic().label("序列号");

        cfg.view().field(EAMTables.EAM_ASSET.PICTURE_ID)
                .form().label("图片").upload().acceptSingleImage().displayFileName(false);;

        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET.NAME,
                        EAMTables.EAM_ASSET.BUSI_CODE,
                        EAMTables.EAM_ASSET.MODEL,
                        EAMTables.EAM_ASSET.MANUFACTURER_ID
                },
                new Object[]{
                        EAMTables.EAM_ASSET.SERIAL_NUMBER,
                        EAMTables.EAM_ASSET.CATEGORY_ID,
                        EAMTables.EAM_ASSET.STATUS
                }

        );


        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup("基本属性",
                new Object[] {
                        EAMTables.EAM_ASSET.CATEGORY_ID,
                        EAMTables.EAM_ASSET.STATUS,
                        EAMTables.EAM_ASSET.NAME,
                        EAMTables.EAM_ASSET.ASSET_CODE
                }, new Object[] {
                        EAMTables.EAM_ASSET.GOODS_ID,
                        EAMTables.EAM_ASSET.MANUFACTURER_ID,
                        EAMTables.EAM_ASSET.MODEL,
                        EAMTables.EAM_ASSET.BRAND_ID,


                }, new Object[] {
                        EAMTables.EAM_ASSET.UNIT,
                        EAMTables.EAM_ASSET.SERIAL_NUMBER,
                        EAMTables.EAM_ASSET.NOTES
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET.NOTES
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET.PICTURE_ID
                }
        );




//        cfg.view().form().addGroup("所属信息",
//                new Object[] {
//                        AssetExtFinancialMeta.ASSET_CODE
//                },
//                new Object[] {
//                        EAMTables.EAM_ASSET.POSITION_DETAIL
//                }
//        );
//

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
        EamAssetsGtr g=new EamAssetsGtr();
        //生成代码
        g.generateCode();



        //生成菜单
        //g.removeByBatchId("");
        // g.generateMenu(AssetServiceProxy.class, AssetPageController.class);
    }


}
