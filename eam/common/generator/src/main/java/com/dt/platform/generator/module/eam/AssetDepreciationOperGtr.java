package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetDepreciationStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import com.dt.platform.eam.page.AssetDepreciationDetailPageController;
import com.dt.platform.eam.page.AssetDepreciationOperPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetDepreciationDetailServiceProxy;
import com.dt.platform.proxy.eam.AssetDepreciationOperServiceProxy;
import com.dt.platform.proxy.eam.AssetDepreciationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class AssetDepreciationOperGtr extends BaseCodeGenerator {


    public AssetDepreciationOperGtr() {
        super(EAMTables.EAM_ASSET_DEPRECIATION_OPER.$TABLE,BASIC_CY_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetSourceList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetSourceIds","资产列表","资产列表");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetTargetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetTargetIds","资产列表","资产列表");


        cfg.getPoClassFile().addListProperty(Asset.class,"assetDepreciationList","资产","资产");

        cfg.getPoClassFile().addListProperty(String.class,"assetDepreciationIds","资产","资产");

        cfg.getPoClassFile().addSimpleProperty(AssetDepreciation.class,"assetDepreciation","方案","方案");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");




        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DEPRECIATION_OPER.STATUS,
                        EAMTables.EAM_ASSET_DEPRECIATION_OPER.DEPRECIATION_ID,

                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().list().operationColumn().addActionButton("明细","depreciationDetail","depreciationDetail-btn","eam_asset_depreciation_oper:detail");
        cfg.view().list().operationColumn().addActionButton("开始","depreciationStart","depreciationStart-btn","eam_asset_depreciation_oper:start");
        cfg.view().list().operationColumn().addActionButton("预执行","depreciationExecute","depreciationExecute-btn","eam_asset_depreciation_oper:execute");
        cfg.view().list().operationColumn().addActionButton("回退","depreciationRollback","depreciationRollback-btn","eam_asset_depreciation_oper:rollback");
        cfg.view().list().operationColumn().addActionButton("同步数据","depreciationSync","depreciationSync-btn","eam_asset_depreciation_oper:sync");


        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION_OPER.NAME,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION_OPER.DEPRECIATION_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION_OPER.BUSINESS_DATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DEPRECIATION_OPER.CONTENT,
                        EAMTables.EAM_ASSET_DEPRECIATION_OPER.NOTES,
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.DEPRECIATION_ID)
                .form().validate().required().form().selectBox().queryApi(AssetDepreciationServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AssetDepreciationMeta.ID).
                textField(AssetDepreciationMeta.NAME).
                fillWith(AssetDepreciationOperMeta.ASSET_DEPRECIATION).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.CONTENT).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.BUSINESS_DATE).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_DEPRECIATION_OPER.STATUS).form().selectBox().enumType(AssetDepreciationStatusEnum.class);

        cfg.view().search().inputWidth(Config.searchInputWidth);
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        AssetDepreciationOperGtr g=new AssetDepreciationOperGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行

       // g.generateMenu(AssetDepreciationOperServiceProxy.class, AssetDepreciationOperPageController.class);
     //g.generateMenu(BrandServiceProxy.class, BrandPageController.class);
        //生成菜单

    }

}
