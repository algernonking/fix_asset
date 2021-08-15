package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.domain.eam.meta.*;
import com.github.foxnic.dao.relation.RelationManager;

public class EAMRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupGoods();
        this.setupAsset();
        this.setupAssetFinancial();
        this.setupAssetMaintainer();
        this.setupAssetEaintainer();
    }
    public void setupProperties() {


    }
    public void setupAssetEaintainer() {

        // 关联区域
        this.property(AssetExtEquipmentMeta.AREA_PROP)
                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID).join(EAMTables.DC_AREA.ID);

        // 关联层级
        this.property(AssetExtEquipmentMeta.LAYER_PROP)
                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.LAYER_ID).join(EAMTables.DC_LAYER.ID);

        // 关联机柜
        this.property(AssetExtEquipmentMeta.RACK_PROP)
                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_ID).join(EAMTables.DC_RACK.ID);

    }

    public void setupAssetMaintainer() {
        // 关联维保商
        this.property(AssetExtMaintainerMeta.MAINTNAINER_PROP)
                .using(EAMTables.EAM_ASSET_EXT_MAINTAINER.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);
    }

    public void setupAssetFinancial() {

        // 关联供应商
        this.property(AssetExtFinancialMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_ASSET_EXT_FINANCIAL.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);

    }

    public void setupAsset() {


        // 关联物品档案
        this.property(AssetMeta.GOODS_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_ID).join(EAMTables.EAM_GOODS.ID);

        // 关联分类
        this.property(AssetMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET.CATEGORY_ID).join(EAMTables.EAM_CATEGORY.ID);


        // 关联品牌
        this.property(AssetMeta.BRAND_PROP)
                .using(EAMTables.EAM_ASSET.BRAND_ID).join(EAMTables.EAM_BRAND.ID);


        // 关联存放位置
        this.property(AssetMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


        // 关联生产厂商
        this.property(AssetMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_ASSET.ID).join(EAMTables.EAM_MANUFACTURER.ID);



        // 关联设备数据
        this.property(AssetMeta.ASSET_EQUIPMENT_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_ID).join(EAMTables.EAM_ASSET_EXT_EQUIPMENT.ID);

        // 关联财务数据
        this.property(AssetMeta.ASSET_FINANCIAL_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_ID).join(EAMTables.EAM_ASSET_EXT_FINANCIAL.ID);

        // 关联维保数据
        this.property(AssetMeta.ASSET_MAINTAINER_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_ID).join(EAMTables.EAM_ASSET_EXT_MAINTAINER.ID);



    }


    private void setupRelations() {

    }
    private void setupGoods() {
        // 关联品牌
        this.property(GoodsMeta.BRAND_PROP)
                .using(EAMTables.EAM_GOODS.BRAND_ID).join(EAMTables.EAM_BRAND.ID);

        // 关联生产厂商
        this.property(GoodsMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_GOODS.MANUFACTURER_ID).join(EAMTables.EAM_MANUFACTURER.ID);

        // 关联分类
        this.property(GoodsMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_GOODS.CATEGORY_ID).join(EAMTables.EAM_CATEGORY.ID);

    }

}
