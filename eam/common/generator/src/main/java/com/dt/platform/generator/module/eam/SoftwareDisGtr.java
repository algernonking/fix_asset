package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.domain.eam.AssetSoftwareDistribute;
import com.dt.platform.domain.eam.AssetSoftwareDistributeData;
import com.dt.platform.eam.page.AssetSoftwareDistributePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSoftwareDistributeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;

public class SoftwareDisGtr extends BaseCodeGenerator {


    public SoftwareDisGtr() {
        super(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.$TABLE,BASIC_ASSET_SOFT_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.BUSINESS_CODE).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","领用人","领用人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产分类","资产分类");
        cfg.getPoClassFile().addSimpleProperty(AssetSoftware.class,"assetSoftware","软件","软件");
        cfg.getPoClassFile().addSimpleProperty(AssetSoftwareDistributeData.class,"assetSoftwareDistributeData","软件","软件");


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.PROC_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.CONTENT).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.STATUS).
                form().selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.STATUS,
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.BUSINESS_CODE,
                }
        );
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_ORG_ID).table().fillBy("useOrganization","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_USER_ID).table().fillBy("useUser","name");
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.BUSINESS_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();

        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","APPROVAL_REQUIRED");

        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_software_distribute:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_software_distribute:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_software_distribute:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_software_distribute:bill");

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ATTACH_ID).form().upload().acceptSingleFile().maxFileCount(1);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.CONTENT).form().textArea().height(60);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.NAME,
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.BUSINESS_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_ORG_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.USE_USER_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.CONTENT,
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.NOTES,
                        EAMTables.EAM_ASSET_SOFTWARE_DISTRIBUTE.ATTACH_ID,
                }
        );
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
        SoftwareDisGtr g=new SoftwareDisGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
        //g.generateMenu(AssetSoftwareDistributeServiceProxy.class, AssetSoftwareDistributePageController.class);
        //生成菜单

    }

}
