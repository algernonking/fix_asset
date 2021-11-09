package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDataChange;
import com.dt.platform.eam.page.AssetDataChangePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamAssetDataChangeGtr extends BaseCodeGenerator{

    public EamAssetDataChangeGtr() {
        super(EAMTables.EAM_ASSET_DATA_CHANGE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"changeData","变更数据","变更数据");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addSimpleProperty(ChangeInstance.class,"changeInstance","变更实例","变更实例");


        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.SELECTED_CODE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.ID).basic().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.ID).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.PROC_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_DATE).search().range();



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DATA_CHANGE.STATUS,
                        EAMTables.EAM_ASSET_DATA_CHANGE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_NOTES,
                },
        new Object[]{

                EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_DATE
        }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_DATE).form().validate().required().form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().list().disableBatchDelete();
        cfg.view().form().addJsVariable("CHANGE_TYPE","[[${changeType}]]","变更类型");
        cfg.view().list().addJsVariable("PAGE_TYPE","[[${pageType}]]","页面类型");


        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
        cfg.view().list().operationColumn().addActionButton("送审","forApproval",null);
        cfg.view().list().operationColumn().addActionButton("确认","confirmData",null);
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData",null);
        cfg.view().list().operationColumn().width(350);

        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_CHANGE.BUSINESS_NAME,
                        EAMTables.EAM_ASSET_DATA_CHANGE.BUSINESS_CODE,
                }
                , new Object[] {
                        EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_DATE,

                }
                , new Object[] {
                        EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_NOTES,
                }
        );



        cfg.view().form().addPage("资产列表","assetSelectList");
//        cfg.view().form().addGroup("变更内容",
//                new Object[] {
//                        EAMTables.EAM_ASSET_DATA_CHANGE.NOTES,
//                }
//                , new Object[] {
//                        EAMTables.EAM_ASSET_DATA_CHANGE.NOTES,
//
//                }
//                , new Object[] {
//                        EAMTables.EAM_ASSET_DATA_CHANGE.NOTES,
//                }
//        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
                .setListPage(WriteMode.CREATE_IF_NOT_EXISTS)
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetDataChangeGtr g=new EamAssetDataChangeGtr();
        g.generateCode();
        //生成菜单
//         g.generateMenu(AssetDataChangeServiceProxy.class, AssetDataChangePageController.class);
    }
}
