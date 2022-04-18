package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetApplyCheckStatusEnum;
import com.dt.platform.constants.enums.eam.AssetPurchaseAssetTypeEnum;
import com.dt.platform.constants.enums.eam.AssetPurchaseStorageTypeEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.PurchaseOrder;
import com.dt.platform.domain.eam.meta.PurchaseApplyMeta;
import com.dt.platform.domain.eam.meta.PurchaseOrderMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.eam.page.PurchaseOrderPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.PurchaseApplyServiceProxy;
import com.dt.platform.proxy.eam.PurchaseOrderServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.dt.platform.proxy.vehicle.ApplyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamPurchaseOrderGtr extends BaseCodeGenerator {

    public EamPurchaseOrderGtr() {
        super(EAMTables.EAM_PURCHASE_ORDER.$TABLE,BASIC_BUY_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"purchaseApply","购买申请","购买申请");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"purchaseCheck","验收单","验收单");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");


        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_PURCHASE_ORDER.BUSINESS_CODE,
                        EAMTables.EAM_PURCHASE_ORDER.NAME,
                        EAMTables.EAM_PURCHASE_ORDER.GOODS_TYPE,
                        EAMTables.EAM_PURCHASE_ORDER.STORAGE_TYPE
                },
                new Object[]{
                        EAMTables.EAM_PURCHASE_ORDER.CODE,

                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.ID).basic().hidden(true);



        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.CHECK_ID).table().disable();

        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.GOODS_TYPE).form().validate().required().form().selectBox().enumType(AssetPurchaseAssetTypeEnum.class).defaultValue(AssetPurchaseAssetTypeEnum.ASSET.code());
        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.STORAGE_TYPE).form().validate().required().form().selectBox().enumType(AssetPurchaseStorageTypeEnum.class).defaultValue(AssetPurchaseStorageTypeEnum.ASSET.code());
        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.NOTES).form().textArea().height(50);

        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.APPLY_ID)
                .basic()
                .form().selectBox().queryApi(PurchaseApplyServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PurchaseApplyMeta.ID).textField(PurchaseApplyMeta.NAME).fillWith(PurchaseOrderMeta.PURCHASE_APPLY).muliti(false);


        cfg.view().field(EAMTables.EAM_PURCHASE_ORDER.NAME)
                .form().validate().required();

        cfg.view().list().disableBatchDelete();

    //    cfg.view().form().addJsVariable("PAGE_TYPE","[[${pageType}]]","页面类型");
        cfg.view().list().addJsVariable("PAGE_TYPE","[[${pageType}]]","页面类型");
        cfg.view().list().addJsVariable("APPLY_ID","[[${applyId}]]","applyId");
        cfg.view().list().addJsVariable("SELECTED_CODE","[[${selectedCode}]]","selectedCode");
        cfg.view().form().addJsVariable("SELECTED_CODE","[[${selectedCode}]]","selectedCode");
        cfg.view().form().addJsVariable("APPLY_ID","[[${applyId}]]","applyId");


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_PURCHASE_ORDER.NAME,
                        EAMTables.EAM_PURCHASE_ORDER.CODE,

                }, new Object[] {
                        EAMTables.EAM_PURCHASE_ORDER.STORAGE_TYPE,
                        EAMTables.EAM_PURCHASE_ORDER.GOODS_TYPE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_PURCHASE_ORDER.NOTES
                }
        );

        //订单
        cfg.view().form().addPage("资产","assetSelectList");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }




    public static void main(String[] args) throws Exception {
        EamPurchaseOrderGtr g=new EamPurchaseOrderGtr();
        //生成代码
        g.generateCode();



        //生成菜单
        //g.removeByBatchId("");
      //  g.generateMenu(PurchaseOrderServiceProxy.class, PurchaseOrderPageController.class);
    }


}
