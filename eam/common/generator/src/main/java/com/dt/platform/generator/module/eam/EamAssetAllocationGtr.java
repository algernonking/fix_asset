package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetAllocation;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetAllocationVOMeta;
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.dt.platform.eam.page.AssetAllocationPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.proxy.eam.AssetAllocationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetAllocationGtr extends BaseCodeGenerator {

    public EamAssetAllocationGtr() {
        super(EAMTables.EAM_ASSET_ALLOCATION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人","管理人");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"outOwnerCompany","调出公司","调出公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"inOwnerCompany","调入公司","调入公司");


        //cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetAllocationVOMeta.ASSET_IDS);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE).search().range();


        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.NAME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).form().textArea().height(30).search().fuzzySearch();

        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);

        cfg.view().list().operationColumn().width(250);



        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID).table().fillBy("outOwnerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID).table().fillBy("inOwnerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID).form()
                .button().chooseEmployee(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_ALLOCATION.STATUS,
                        EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID,

                },
                new Object[]{
                        EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE,
                        EAMTables.EAM_ASSET_ALLOCATION.CONTENT,
                }
        );

        //分成分组布局
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                 new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.OUT_OWN_COMPANY_ID
                }, new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.IN_OWN_COMPANY_ID
                }, new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.CONTENT,
                }
        );


        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");


//        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
//        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetAllocationGtr g=new EamAssetAllocationGtr();

        //生成代码
        g.generateCode();
        //生成菜单
      //  g.generateMenu(AssetAllocationServiceProxy.class, AssetAllocationPageController.class);
    }

}
