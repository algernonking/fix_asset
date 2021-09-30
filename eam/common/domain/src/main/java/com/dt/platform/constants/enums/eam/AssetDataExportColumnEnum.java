package com.dt.platform.constants.enums.eam;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.api.constant.CodeTextEnum;

public enum AssetDataExportColumnEnum implements CodeTextEnum {

    ASSET_ID("id","id" ),
    ASSET_CODE("assetCode","asset_code" ),
    ASSET_STATUS("statusName","status" ),
    ASSET_STATUS_NAME("assetStatusName","asset_status" ),
    ASSET_POSITION_NAME("assetPositionName" ,  "position_id"),
    ASSET_CATEGORY_NAME("assetCategoryName","category_id" ),
    ASSET_GOOD_NAME( "assetGoodName","goods_id" ),
    ASSET_MANUFACTURER_NAME( "assetManufacturerName","manufacturer_id" ),
    ASSET_WAREHOUSE_NAME("assetWarehouseName","warehouse_id" ),
    ASSET_MAINTAINER_NAME("assetMaintainerName","maintainer_id" ),
    ASSET_CATEGORY_FINANCE_NAME("assetCategoryFinanceName","financial_category_id" ),
    ASSET_SUPPLIER_NAME( "assetSupplierName","supplier_id" ),
    ASSET_SOURCE_NAME("assetSourceName","source_id" ),
    SAFETY_LEVEL_NAME( "safetyLevelName","safety_level_code" ),
    MAINTENANCE_STATUS( "maintenanceStatus","maintenance_status" ),
    OWNER_COMPANY_NAME("ownerCompanyName","owner_company_id" ),
    USE_ORGANIZATION_NAME("useOrganizationName","use_organization_id"),
    MANAGER_NAME( "managerName","manager_id" ),
    MANAGER_BADGE( "managerBadge","manager_id" ),
    USE_USER_NAME("useUserName","use_user_id"  ),
    USE_USER_BADGE( "useUserBadge","use_user_id" ),

    EQUIPMENT_STATUS_NAME( "equipmentStatusName","equipment_status" ),
    EQUIPMENT_ENVIRONMENT_NAME( "equipmentEnvironmentName","equipment_environment_code" ),

    RACK_NAME( "rackName","rack_id" ),

    ;

    private String code;
    private String text;
    private AssetDataExportColumnEnum(String code, String text)  {
        this.code=code;
        this.text=text;
    }

    public String code() {
        return code;
    }

    public String text() {
        return text;
    }


}
