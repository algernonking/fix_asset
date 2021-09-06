package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.proxy.eam.*;

import com.github.foxnic.generator.builder.view.config.Tab;
import com.github.foxnic.generator.config.WriteMode;
import  com.dt.platform.constants.enums.eam.AssetStatusEnum;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;


public class EamAssetsGtr extends BaseCodeGenerator {

    public EamAssetsGtr() {
        super(EAMTables.EAM_ASSET.$TABLE,BASIC_ASSET_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(AssetExtFinancial.class,"assetFinancial","财务信息","财务信息");
        cfg.getPoClassFile().addSimpleProperty(AssetExtFinancial.class,"assetMaintainer","维保信息","维保信息");
        cfg.getPoClassFile().addSimpleProperty(AssetExtEquipment.class,"assetEquipment","设备信息","设备信息");
        cfg.getPoClassFile().addSimpleProperty(AssetExtSoftware.class,"assetExtSoftware","软件信息","软件信息");
        //cfg.getPoClassFile().addSimpleProperty(AssetExtAttribution.class,"assetExtAttribution","归属信息","归属信息");

        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");

        cfg.getPoClassFile().addSimpleProperty(Catalog.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addSimpleProperty(Goods.class,"goods","物品档案","物品档案");
        cfg.getPoClassFile().addSimpleProperty(Manufacturer.class,"manufacturer","生产厂商","生产厂商");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");

        cfg.getPoClassFile().addSimpleProperty(Person.class,"use_user","使用人员","使用人员");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"manager","管理人员","管理人员");

       // cfg.getPoClassFile().addSimpleProperty(Person.class,"position","存放位置","软件信息");
     //   cfg.getPoClassFile().addSimpleProperty(Brand.class,"brand","品牌","品牌");


        cfg.view().field(EAMTables.EAM_ASSET.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.SERIAL_NUMBER).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.MODEL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.BATCH_CODE).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.SCRAP).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.DISPLAY).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET.BUSI_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.PICTURE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.RFID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.ATTACH).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.CATEGORY_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.ASSET_NUMBER).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.REMAIN_NUMBER).table().disable(true);

        //cfg.view().field(EAMTables.EAM_ASSET.OWN_COMPANY_ID).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.MANAGER_ID).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.GOODS_ID).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.BATCH_CODE).table().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET.UNIT).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.WAREHOUSE_ID).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.POSITION_DETAIL).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.LABEL).table().hidden(true);


     //  cfg.view().field(EAMTables.EAM_ASSET.PRODUCTION_DATE).table().hidden(true);


        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET.STATUS,
                        EAMTables.EAM_ASSET.ASSET_CODE,
                        EAMTables.EAM_ASSET.NAME,
                        EAMTables.EAM_ASSET.MODEL,
                        EAMTables.EAM_ASSET.SERIAL_NUMBER,
                },
                new Object[]{
                        EAMTables.EAM_ASSET.CATEGORY_ID,
                        EAMTables.EAM_ASSET.MANUFACTURER_ID,
//                        EAMTables.EAM_ASSET.BRAND_ID,
                        EAMTables.EAM_ASSET.NOTES,

                }

        );


        cfg.view().field(EAMTables.EAM_ASSET.SOURCE_ID).form()
                .form().selectBox().dict(DictEnum.EAM_SOURCE);

        cfg.view().field(EAMTables.EAM_ASSET.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET.STATUS).form().
                label("状态").selectBox().enumType(AssetStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET.CATEGORY_ID)
                .basic().label("分类")
                .form().validate().required()
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME)
                .fillBy(AssetMeta.CATEGORY).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.GOODS_ID)
                .basic().label("物品档案")
                .form().selectBox().queryApi(GoodsServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(GoodsMeta.ID).textField(GoodsMeta.NAME).fillBy(AssetMeta.GOODS).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.WAREHOUSE_ID)
                .basic().label("仓库")
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillBy(AssetMeta.WAREHOUSE).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET.POSITION_ID)
                .basic().label("位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField( PositionMeta.NAME).fillBy(AssetMeta.POSITION).muliti(false);


//
//        cfg.view().field(EAMTables.EAM_ASSET.BRAND_ID)
//                .basic().label("品牌")
//                .form().selectBox().queryApi(BrandServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
//                .valueField(BrandMeta.ID).textField(BrandMeta.BRAND_NAME).fillBy(AssetMeta.BRAND).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET.MANUFACTURER_ID)
                .basic().label("厂商")
                .form().selectBox().queryApi(ManufacturerServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(ManufacturerMeta.ID).textField(ManufacturerMeta.MANUFACTURER_NAME).fillBy(AssetMeta.MANUFACTURER).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.USE_ORGANIZATION_ID).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET.OWN_COMPANY_ID).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET.NOTES).form().textArea().height(30);



        cfg.view().field(EAMTables.EAM_ASSET.NAME)
                .basic().label("名称");

        cfg.view().field(EAMTables.EAM_ASSET.MODEL)
                .basic().label("规格型号");

        cfg.view().field(EAMTables.EAM_ASSET.UNIT)
                .basic().label("计量单位");

        cfg.view().field(EAMTables.EAM_ASSET.SERIAL_NUMBER)
                .basic().label("序列号");

        cfg.view().field(EAMTables.EAM_ASSET.PICTURE_ID)
                .form().label("图片").upload().acceptSingleImage().maxFileCount(1).displayFileName(false);

        cfg.view().field(EAMTables.EAM_ASSET.ATTACH)
                .form().label("附件").upload().acceptSingleImage().maxFileCount(3).displayFileName(false);


        //分成分组布局
        cfg.view().formWindow().width("95%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET.CATEGORY_ID,
                        EAMTables.EAM_ASSET.NAME,
                        EAMTables.EAM_ASSET.ASSET_CODE,
                        EAMTables.EAM_ASSET.PURCHASE_DATE,
                        EAMTables.EAM_ASSET.SERIAL_NUMBER,
                        EAMTables.EAM_ASSET.SERVICE_LIFE,
                }, new Object[] {
                        EAMTables.EAM_ASSET.OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET.USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET.MANAGER_ID,
                        EAMTables.EAM_ASSET.USE_USER_ID,
                        EAMTables.EAM_ASSET.POSITION_ID,
                        EAMTables.EAM_ASSET.POSITION_DETAIL,

                }, new Object[] {
                        EAMTables.EAM_ASSET.SOURCE_ID,
                        EAMTables.EAM_ASSET.GOODS_ID,
                        EAMTables.EAM_ASSET.MANUFACTURER_ID,
                        EAMTables.EAM_ASSET.MODEL,
                        EAMTables.EAM_ASSET.UNIT,
                        EAMTables.EAM_ASSET.WAREHOUSE_ID,

                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET.NOTES,
                },
                new Object[] {

                        EAMTables.EAM_ASSET.ATTACH,

                },
                new Object[] {
                        EAMTables.EAM_ASSET.PICTURE_ID,
                }

        );





//        cfg.view().form().addTab(
//                new Tab("基本信息","loadBaseInfoIframe"),
//                new Tab("维保信息","loadMaintainerIframe"),
//                new Tab("财务信息","loadFinancialIframe")
//        );
//
        cfg.view().field(EAMTables.EAM_ASSET_EXT_FINANCIAL.NOTES).form().textArea().height(30);
        cfg.view().form().disableFooter();


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS
                ) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
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
