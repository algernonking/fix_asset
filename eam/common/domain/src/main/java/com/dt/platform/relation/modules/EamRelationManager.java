package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class EamRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();
        this.setupGoods();

        this.setupAsset();


        this.setupAlloction();
        this.setupAssetBorrow();
        this.setupAssetCollection();
        this.setupAssetCollectionReturn();
        this.setupAssetHandle();
        this.setupAssetRepair();
        this.setupAssetTranfer();


        this.setupScrap();

        this.setupAssetAttributeItem();

        this.setupInventory();
        this.setupInventoryUser();
        this.setupInventoryDirecotor();
        this.setupInventoryAsset();
        this.setupInventoryManager();


        this.setupTplFile();

        this.setupAssetDataChange();


        this.setupStockAsset();
        this.setupStockAssetCollection();

    }
    public void setupProperties() {


    }


    public void setupScrap(){

        this.property(AssetScrapMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_SCRAP.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);


        this.property(AssetScrapMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_SCRAP.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }

    public void setupAssetDataChange(){

        this.property(AssetDataChangeMeta.CHANGE_INSTANCE_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_INSTANCE_ID )
                .join(FoxnicWeb.CHS_CHANGE_INSTANCE.ID);

        // 关联资产
        this.property(AssetDataChangeMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);


        //变更数据
        this.property(AssetDataChangeMeta.CHANGE_DATA_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ASSET_CHANGE_ID).join(EAMTables.EAM_ASSET.ID);


        // 制单人
        this.property(AssetDataChangeMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_DATA_CHANGE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }




    public void setupAlloction() {

        // 关联资产
        this.property(AssetAllocationMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_ALLOCATION.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);

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




    public void setupInventory() {


        this.property(InventoryMeta.INVENTORY_ASSET_INFO_LIST_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_ASSET.ASSET_ID);

        //位置
        this.property(InventoryMeta.POSITION_PROP)
                .using(EAMTables.EAM_INVENTORY.POSITION_ID).join(EAMTables.EAM_POSITION.ID);

        //仓库
        this.property(InventoryMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_INVENTORY.WAREHOUSE_ID).join(EAMTables.EAM_WAREHOUSE.ID);

        //关联 使用组织
        this.property(InventoryMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_INVENTORY.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //关联 所属公司
        this.property(InventoryMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_INVENTORY.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        // 关联资产分类
        this.property(InventoryMeta.CATEGORY_PROP)
                .using(EAMTables.EAM_INVENTORY.CATEGORY_ID).join(FoxnicWeb.PCM_CATALOG.ID);

        //制单人
        this.property(InventoryMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_INVENTORY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //盘点人
        this.property(InventoryMeta.INVENTORY_USER_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_USER.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //负责人
        this.property(InventoryMeta.DIRECTOR_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_DIRECTOR.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_DIRECTOR.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        //管理人
        this.property(InventoryMeta.MANAGER_PROP)
                .using(EAMTables.EAM_INVENTORY.ID).join(EAMTables.EAM_INVENTORY_MANAGER.INVENTORY_ID)
                .using(EAMTables.EAM_INVENTORY_MANAGER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }



    public void setupStockAssetCollection(){
        // 关联资产
        this.property(AssetStockCollectionMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);

        // 关联位置
        this.property(AssetStockCollectionMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.POSITION_ID)
                .join( EAMTables.EAM_POSITION.ID);

        // 关联制单人
        this.property(AssetStockCollectionMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        // 关联使用人
        this.property(AssetStockCollectionMeta.USE_USER_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);

        this.property(AssetStockCollectionMeta.USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_STOCK_COLLECTION.USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);
    }



    public void setupStockAsset(){
        this.property(StockMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_STOCK.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        // 关联资产
        this.property(StockMeta.STOCK_ASSET_LIST_PROP)
                .using(EAMTables.EAM_STOCK.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join(EAMTables.EAM_ASSET.ID);


        this.property(StockMeta.CHANGE_INSTANCE_PROP)
                .using(EAMTables.EAM_STOCK.CHANGE_INSTANCE_ID )
                .join(FoxnicWeb.CHS_CHANGE_INSTANCE.ID);


        // 关联来源
        this.property(StockMeta.SOURCE_PROP)
                .using(EAMTables.EAM_STOCK.SOURCE_ID).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_source'");

        // 关联供应商
        this.property(StockMeta.SUPPLIER_PROP)
                .using(EAMTables.EAM_STOCK.SUPPLIER_ID).join(EAMTables.EAM_SUPPLIER.ID);


        // 关联仓库
        this.property(StockMeta.WAREHOUSE_PROP)
                .using(EAMTables.EAM_STOCK.WAREHOUSE_ID).join(EAMTables.EAM_ASSET.ID);


        // 关联管理人员
        this.property(StockMeta.MANAGER_PROP)
                .using(EAMTables.EAM_STOCK.MANAGER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
        //    .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


        //关联 所属公司
        this.property(StockMeta.OWNER_COMPANY_PROP)
                .using(EAMTables.EAM_STOCK.OWN_COMPANY_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);




    }

    public void setupInventoryAsset() {

        this.property(InventoryAssetMeta.INVENTORY_USER_PROP)
                .using(EAMTables.EAM_INVENTORY_ASSET.OPER_EMPL_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(InventoryAssetMeta.ASSET_PROP)
                .using(EAMTables.EAM_INVENTORY_ASSET.ASSET_ID).join(EAMTables.EAM_ASSET.ID);

    }

    public void setupInventoryDirecotor(){
        this.property(InventoryDirectorMeta.INVENTORY_DIRECTOR_PROP)
                .using(EAMTables.EAM_INVENTORY_DIRECTOR.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }

    public void setupInventoryUser() {

        this.property(InventoryUserMeta.INVENTORY_USER_PROP)
                .using(EAMTables.EAM_INVENTORY_USER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }


    public void setupInventoryManager() {

        this.property(InventoryManagerMeta.INVENTORY_MANAGER_PROP)
                .using(EAMTables.EAM_INVENTORY_MANAGER.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

    }


    public void setupAssetBorrow() {

        this.property(AssetBorrowMeta.ASSET_ITEM_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID);


        // 关联资产
        this.property(AssetBorrowMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_BORROW.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);


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
                .using(EAMTables.EAM_ASSET_COLLECTION.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);



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
                .using(EAMTables.EAM_ASSET_COLLECTION_RETURN.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);



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
                .using(EAMTables.EAM_ASSET_REPAIR.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);



        // 关联制单人
        this.property(AssetRepairMeta.ORIGINATOR_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);



        // 维修类型
        this.property(AssetRepairMeta.REPAIR_TYPE_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_repair_type'");



        // 报修人
        this.property(AssetRepairMeta.REPORT_USER_PROP)
                .using(EAMTables.EAM_ASSET_REPAIR.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);



    }

    public void setupAssetTranfer() {

        // 关联资产
        this.property(AssetTranferMeta.ASSET_LIST_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.ID )
                .join(EAMTables.EAM_ASSET_ITEM.HANDLE_ID)
                .using( EAMTables.EAM_ASSET_ITEM.ASSET_ID)
                .join( EAMTables.EAM_ASSET.ID);


        this.property(AssetTranferMeta.IN_USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        this.property(AssetTranferMeta.OUT_USE_ORGANIZATION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);


        // 关联位置
        this.property(AssetTranferMeta.POSITION_PROP)
                .using(EAMTables.EAM_ASSET_TRANFER.POSITION_ID).join(EAMTables.EAM_POSITION.ID);


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
                .using(EAMTables.EAM_ASSET_ITEM.ASSET_ID).join(EAMTables.EAM_ASSET.ID);



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

        this.property(AssetMeta.CHANGE_INSTANCE_PROP)
                .using(EAMTables.EAM_ASSET.CHANGE_INSTANCE_ID )
                .join(FoxnicWeb.CHS_CHANGE_INSTANCE.ID);

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

        // 关联维保
        this.property(AssetMeta.ASSET_MAINTENANCE_STATUS_PROP)
                .using(EAMTables.EAM_ASSET.MAINTENANCE_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='eam_maintenance_status'");

        // 关联机柜
        this.property(AssetMeta.RACK_PROP)
                .using(EAMTables.EAM_ASSET.RACK_ID).join(EAMTables.DC_RACK.ID);


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
