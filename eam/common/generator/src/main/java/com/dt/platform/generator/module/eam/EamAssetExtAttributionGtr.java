package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetExtAttribution;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetExtAttributionPageController;
import com.dt.platform.proxy.eam.AssetExtAttributionServiceProxy;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetExtAttributionGtr extends BaseCodeGenerator {

    public EamAssetExtAttributionGtr() {
        super(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {



        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");

        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");



        cfg.view().field(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.ID).basic().hidden();


        cfg.view().field(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.ASSET_ID).search().hidden();


        cfg.view().field(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.POSITION_ID)
                .basic().label("存放位置").search().hidden()
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(PositionMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillBy(AssetExtAttributionMeta.POSITION).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.WAREHOUSE_ID)
                .basic().label("仓库").search().hidden()
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(WarehouseMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillBy(AssetExtAttributionMeta.WAREHOUSE).muliti(false);




        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup("归属属性",
                new Object[] {
                        EAMTables.EAM_ASSET_EXT_ATTRIBUTION.MANAGEMENT_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_EXT_ATTRIBUTION.USER_ORGANIZATION_ID,
                }, new Object[] {
                        EAMTables.EAM_ASSET_EXT_ATTRIBUTION.USER_ID,
                        EAMTables.EAM_ASSET_EXT_ATTRIBUTION.NOTES

                },
                new Object[] {
                        EAMTables.EAM_ASSET_EXT_ATTRIBUTION.POSITION_ID,
                        EAMTables.EAM_ASSET_EXT_ATTRIBUTION.POSITION_DETAIL,
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
        EamAssetExtAttributionGtr g=new EamAssetExtAttributionGtr();

         g.generateCode();
       //  g.generateMenu(AssetExtAttributionServiceProxy.class, AssetExtAttributionPageController.class);

    }

}
