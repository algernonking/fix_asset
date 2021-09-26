package com.dt.platform.constants.enums.eam;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.api.constant.CodeTextEnum;

public enum AssetOperateEnum implements CodeTextEnum {

    EAM_ASSET_INSERT("eam_asset_insert" , "EAM_资产插入"),

    EAM_ASSET_COLLECTION(CodeModuleEnum.EAM_ASSET_COLLECTION.code() , "EAM_资产单据-领用"),
    EAM_ASSET_COLLECTION_RETURN(CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.code() , "EAM_资产单据-退库"),

    EAM_ASSET_BORROW(CodeModuleEnum.EAM_ASSET_BORROW.code() , "EAM_资产单据-借用"),
    EAM_ASSET_REPAIR(CodeModuleEnum.EAM_ASSET_REPAIR.code() , "EAM_资产单据-报修"),
    EAM_ASSET_SCRAP(CodeModuleEnum.EAM_ASSET_SCRAP.code() , "EAM_资产单据-报废"),

    EAM_ASSET_ALLOCATE(CodeModuleEnum.EAM_ASSET_ALLOCATE.code() , "EAM_资产单据-调拨"),
    EAM_ASSET_TRANFER(CodeModuleEnum.EAM_ASSET_TRANFER.code() , "EAM_资产单据-转移"),

    EAM_ASSET_CHANGE_BASE_INFO(CodeModuleEnum.EAM_ASSET_CHANGE_BASE_INFO.code() , "EAM_资产变更-基本"),
    EAM_ASSET_CHANGE_MAINTENANCE(CodeModuleEnum.EAM_ASSET_CHANGE_MAINTENANCE.code() , "EAM_资产变更-维保"),
    EAM_ASSET_CHANGE_FINANCIAL(CodeModuleEnum.EAM_ASSET_CHANGE_FINANCIAL.code() , "EAM_资产变更-财务"),

    EAM_ASSET_STOCK_OUT(CodeModuleEnum.EAM_ASSET_STOCK_OUT.code() , "EAM_资产库存-出库"),
    EAM_ASSET_STOCK_IN(CodeModuleEnum.EAM_ASSET_STOCK_IN.code() , "EAM_资产库存-入库"),

    EAM_DOWNLOAD_ASSET(CodeModuleEnum.EAM_DOWNLOAD_ASSET.code() , "EAM_资产数据下载"),

    EAM_DOWNLOAD_ASSET_CARD("eam_download_asset_card" , "EAM_资产卡片下载"),

    EAM_DOWNLOAD_ASSET_LABEl("eam_download_asset_label" , "EAM_资产标签下载"),
    ;


    private String code;
    private String text;
    private AssetOperateEnum(String code, String text)  {
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
