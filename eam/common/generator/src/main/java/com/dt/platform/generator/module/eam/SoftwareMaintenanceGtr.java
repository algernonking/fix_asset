package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.domain.eam.AssetSoftwareMaintenance;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.eam.meta.AssetSoftwareMaintenanceMeta;
import com.dt.platform.domain.eam.meta.AssetSoftwareMeta;
import com.dt.platform.domain.eam.meta.MaintainerMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.domain.vehicle.Maintenance;
import com.dt.platform.eam.page.AssetSoftwareMaintenancePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSoftwareMaintenanceServiceProxy;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class SoftwareMaintenanceGtr extends BaseCodeGenerator {


    public SoftwareMaintenanceGtr() {
        super(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.$TABLE,BASIC_ASSET_SOFT_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ID).basic().hidden(true);


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","负责人","负责人");

        cfg.getPoClassFile().addSimpleProperty(Maintainer.class,"maintainer","负责人","负责人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","负责部门","负责部门");

        cfg.getPoClassFile().addListProperty(AssetSoftware.class,"assetSoftwareList","软件信息","软件信息");
        cfg.getPoClassFile().addListProperty(String.class,"assetSoftwareIds","软件信息","软件信息");


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.BUSINESS_CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.STATUS,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTAINER_ID,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.USE_ORG_ID,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.NAME,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.BUSINESS_DATE,
                }

        );
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);



        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","APPROVAL_REQUIRED");
        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_software_maintenance:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_software_maintenance:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_software_maintenance:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_software_maintenance:bill");


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.PROC_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.BUSINESS_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTENANCE_START_DATE).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTENANCE_END_DATE).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTAINER_ID)
                .basic().label("维保商")
                .form().validate().required().form().selectBox().queryApi(MaintainerServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(MaintainerMeta.ID).textField(MaintainerMeta.MAINTAINER_NAME).fillWith(AssetSoftwareMaintenanceMeta.MAINTAINER).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.USE_ORG_ID)
                .form().validate().required().form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.USE_ORG_ID).table().fillBy("useOrganization","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MANAGER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.CONTENT).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ATTACH_ID).form().upload().acceptSingleFile().maxFileCount(1);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.NAME,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.USE_ORG_ID,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MANAGER_ID,
                }
                ,  new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTAINER_ID,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.CONTACTS,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.CONTACT_INFO,
                }
                ,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTENANCE_START_DATE,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTENANCE_END_DATE,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.MAINTENANCE_COST,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.CONTENT,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.NOTES,
                        EAMTables.EAM_ASSET_SOFTWARE_MAINTENANCE.ATTACH_ID,
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
        SoftwareMaintenanceGtr g=new SoftwareMaintenanceGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(AssetSoftwareMaintenanceServiceProxy.class, AssetSoftwareMaintenancePageController.class);
        //生成菜单

    }

}
