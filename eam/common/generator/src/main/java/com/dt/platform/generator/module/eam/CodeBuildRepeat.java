package com.dt.platform.generator.module.eam;

import java.lang.reflect.Method;

public class CodeBuildRepeat {

    public static void main(String[] args) throws Exception {
        String pstr="com.dt.platform.generator.module.eam";
        String[] clasnamearr={
//                "EamProcessRecord",
//                "EamAssetOperateGtr",
//                "EamAssetSelectedDataGtr",
//                "EamAssetCategoryFinanceGtr",
//                "EAMAssetAttributeGtr",
//                "EAMAssetAttributeItemGtr",
//                "EamTplFileGtr",
//                "EamAssetScrapGtr",
//                "EamApproveConfigureGtr",
//                "EamAssetDataChangeGtr",
//                "EamAssetAllocationGtr",
//                "EamAssetTranferGtr",
//                "EamAssetBorrowGtr",
//                "EamAssetBorrowReturnGtr",
//                "EamAssetBorrowDataGtr",
//                "EamAssetCollectionGtr",
//                "EamAssetCollectionReturnGtr",
//                "EamAssetRepairGtr",
//                "EamAssetHandleGtr",
//                "EamAssetItemGtr",
//                "EamAssetExtAttributionGtr",
//                "EamAssetExtEquipmentGtr",
//                "EamAssetExtFinancialGtr",
//                "EamAssetExtMaintainerGtr",
//                "EamAssetExtSoftwareGtr",
//                "BrandGtr",
//                "EamPositionGtr",
//                "EamGoodsGtr",
//                "EamMaintainerGtr",
//                "EamManufacturerGtr",
//                "EamResidualStrategyGtr",
//                "EamSupplierGtr",
//                "EamSafetylevelGtr",
//                "EamInventoryAssetGtr",
//                "EamInventoryGtr",
//                "EamInventoryUserGtr",
//                "EamAssetStockGtr",
//                "EamWarehouseGtr"
                "EamAssetStockCollectionGtr"
        };
        for(int i=0;i<clasnamearr.length;i++){
            System.out.println("invoke clsss:"+clasnamearr[i]);
            try{
                Class clazz=Class.forName(pstr+"."+clasnamearr[i]);
                Method method=clazz.getMethod("generateCode");
                method.invoke(clazz.newInstance());
            }catch(Exception e){
                System.err.println(clasnamearr[i]+"这个类真的不存在!");
            }
            System.out.println("------------------------invoke finish------------------------");
        }
    }
}
