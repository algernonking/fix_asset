package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.domain.eam.AssetSoftwareChangeDetail;
import com.dt.platform.eam.page.AssetSoftwareChangePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSoftwareChangeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class SoftwareChangeGtr extends BaseCodeGenerator {


    public SoftwareChangeGtr() {
        super(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.$TABLE,BASIC_ASSET_SOFT_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addListProperty(AssetSoftwareChangeDetail.class,"assetSoftwareChangeDetailList","变更细节","变更细节");
        cfg.getPoClassFile().addListProperty(String.class,"assetSoftwareChangeDetailIds","变更细节","变更细节");

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.CONTENT).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.STATUS,
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NAME,
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.CONTENT,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.BUSINESS_DATE,
                }
        );
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);



        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","APPROVAL_REQUIRED");
        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_software_change:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_software_change:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_software_change:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_software_change:bill");

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.ATTACH_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.PROC_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.BUSINESS_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.CONTENT).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.ATTACH_ID).form().upload().acceptSingleFile().maxFileCount(1);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_CHANGE.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NAME,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.BUSINESS_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.CONTENT,
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.NOTES,
                        EAMTables.EAM_ASSET_SOFTWARE_CHANGE.ATTACH_ID,
                }
        );

        cfg.view().form().addPage("软件信息","softwareSelectList");

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
        SoftwareChangeGtr g=new SoftwareChangeGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(AssetSoftwareChangeServiceProxy.class, AssetSoftwareChangePageController.class);
        //生成菜单

    }

}
