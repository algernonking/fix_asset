package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

import java.util.Iterator;

public class EamRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupGoods();

        this.setupAsset();

//        this.setupAssetFinancial();
//        this.setupAssetMaintainer();
//        this.setupAssetEaintainer();


        this.setupAlloction();
        this.setupAssetBorrow();
        this.setupAssetCollection();
        this.setupAssetCollectionReturn();
        this.setupAssetHandle();
        this.setupAssetRepair();
        this.setupAssetTranfer();

        this.setupInventory();
        this.setupAssetAttributeItem();

        this.setupTplFile();


        this.setupAssetDataChange();

    }
    public void setupProperties() {


    }

    public void setupAssetDataChange(){

        // 关联资产
        this.property(AssetDataChangeMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        //变更数据
        this.property(AssetDataChangeMeta.CHANGE_DATA_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ASSET_CHANGE_ID).join(EAMTables.EAM_ASSET.ID);


        // 制单人
        this.property(AssetDataChangeMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }




    public void setupAlloction() {

        // 关联
        this.property(AssetAllocationMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        this.property(AssetAllocationMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        this.property(AssetAllocationMeta.IN_OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetAllocationMeta.OUT_OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }





    private void setupTplFile() {
        this.property(TplFileMeta.BUSINESS_CODE_PROP)
                .using(EAMTables.EAM_TPL_FILE.CODE).join(EAMTables.SYS_CODE_REGISTER.CODE);

    }


    public void setupAssetAttributeItem() {
        // 关联字段
        this.property(AssetAttributeItemMeta.ATTRIBUTE_PROP)
                .using(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.ATTRIBUTE_ID).join(EAMTables.EAM_ASSET_ATTRIBUTE.ID);

    }


    //select * from attrubte_item where id in (select * from attrube)

    public void setupInventory() {

        // 关联位置
//        this.property(InventoryMeta.POSITION_PROP)
//                .using(EAMTables.EAM_INVENTORY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

    }

    public void setupAssetBorrow() {
        // 关联资产
        this.property(AssetBorrowMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联制单人
        this.property(AssetBorrowMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);



        // 关联借用人
        this.property(AssetBorrowMeta.BORROWER_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

    }


    public void setupAssetCollection() {
        // 关联资产
        this.property(AssetCollectionMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联位置
        this.property(AssetCollectionMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetCollectionMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人
        this.property(AssetCollectionMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        this.property(AssetCollectionMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }


    public void setupAssetCollectionReturn() {
        // 关联资产
        this.property(AssetCollectionReturnMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联位置
        this.property(AssetCollectionReturnMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetCollectionReturnMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        this.property(AssetCollectionReturnMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }


    public void setupAssetRepair() {
        // 关联资产
        this.property(AssetRepairMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);


        // 关联制单人
        this.property(AssetRepairMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);



        // 报修人
        this.property(AssetRepairMeta.REPORT_USER_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }

    public void setupAssetTranfer() {

        this.property(AssetTranferMeta.IN_USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetTranferMeta.OUT_USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        // 关联位置
        this.property(AssetTranferMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


        // 关联资产
        this.property(AssetTranferMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.ID)
                .join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID)
                .join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);

        // 关联制单人
        this.property(AssetTranferMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        // 关联人员
        this.property(AssetTranferMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人员
        this.property(AssetTranferMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

    }

    public void setupAssetHandle() {
        // 关联资产
        this.property(AssetHandleMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_HANDLE.ID).join( EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET.ID).join(EAMTables.EAM_ASSET_ITEM.ASSET_ID);



        // 关联制单人
        this.property(AssetHandleMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_HANDLE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }



//    public void setupAssetAssetExtAttribution() {
//
//        // 关联仓库
//        this.property(AssetExtAttributionMeta.WAREHOUSE_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_ATTRIBUTION.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);
//
//
//
//    }
//        public void setupAssetEaintainer() {
//
////        // 关联区域
////        this.property(AssetExtEquipmentMeta.AREA_PROP)
////                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID).join(EAMTables.DC_AREA.ID);
////
////        // 关联层级
////        this.property(AssetExtEquipmentMeta.LAYER_PROP)
////                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.LAYER_ID).join(EAMTables.DC_LAYER.ID);
//
//        // 关联机柜
//        this.property(AssetExtEquipmentMeta.RACK_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_ID).join(EAMTables.DC_RACK.ID);
//
//    }

//    public void setupAssetMaintainer() {
//
//        // 关联维保商
//        this.property(AssetExtMaintainerMeta.MAINTNAINER_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_MAINTAINER.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);
//    }
//
//    public void setupAssetFinancial() {
//
//        // 关联供应商
//        this.property(AssetExtFinancialMeta.SUPPLIER_PROP)
//                .using(EAMTables.EAM_ASSET_EXT_FINANCIAL.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);
//
//    }

    public void setupAsset() {

        // 关联维保商
        this.property(AssetMeta.MAINTNAINER_PROP)
                .using(EAMTables.EAM_ASSET.MAINTAINER_ID).join(EAMTables.EAM_MAINTAINER.ID);

        // 关联来源
        this.property(AssetMeta.SOURCE_PROP)
                .using(EAMTables.EAM_ASSET.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
          .condition("dict_code='eam_source'");


        // 关联安全等级
        this.property(AssetMeta.SAFETY_LEVEL_PROP)
                .using(EAMTables.EAM_ASSET.SAFETY_LEVEL_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_safety_level'");

        // 关联运行环境
        this.property(AssetMeta.EQUIPMENT_ENVIRONMENT_PROP)
                .using(EAMTables.EAM_ASSET.EQUIPMENT_ENVIRONMENT_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_equipment_environment'");



        // 关联物品档案
        this.property(AssetMeta.GOODS_PROP)
                .using(EAMTables.EAM_ASSET.GOODS_ID).join(EAMTables.EAM_GOODS.ID);


        // 关联供应商
        this.property(AssetMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_ASSET.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);


        // 关联生产厂商
        this.property(AssetMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_ASSET.MANUFACTURER_ID).join(EAMTables.EAM_MANUFACTURER.ID);


        // 关联位置
        this.property(AssetMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


        // 关联财务分类
        this.property(AssetMeta.CATEGORY_FINANCE_PROP)
                .using(EAMTables.EAM_ASSET.FINANCIAL_CATEGORY_ID).join(EAMTables.EAM_CATEGORY_FINANCE.ID);


        // 关联资产分类
        this.property(AssetMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_ASSET.CATEGORY_ID).join(FoxnicWeb.PCM_CATALOG.ID);

        // 关联仓库
        this.property(AssetMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_ASSET.WAREHOUSE_ID).join(EAMTables.EAM_ASSET.ID);

        // 关联使用人
        this.property(AssetMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联管理人员
        this.property(AssetMeta.MANAGER_PROP)
                .using(EAMTables.EAM_ASSET.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
            //    .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联制单人
        this.property(AssetMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        //关联 使用组织
        this.property(AssetMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //关联 所属公司
        this.property(AssetMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_ASSET.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

    }


    private void setupRelations() {

    }
    private void setupGoods() {

        // 关联品牌
//        this.property(GoodsMeta.BRAND_PROP)
//                .using(EAMTables.EAM_GOODS.BRAND_ID).join(EAMTables.EAM_BRAND.ID);

        // 关联生产厂商
        this.property(GoodsMeta.MANUFACTURER_PROP)
                .using(EAMTables.EAM_GOODS.MANUFACTURER_ID).join(EAMTables.EAM_MANUFACTURER.ID);

        // 关联分类
        this.property(GoodsMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_GOODS.CATEGORY_ID).join(EAMTables.EAM_CATEGORY.ID);

    }

}
