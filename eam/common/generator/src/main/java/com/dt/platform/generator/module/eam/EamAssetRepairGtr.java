package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetRepairStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetHandleVOMeta;
import com.dt.platform.domain.eam.meta.AssetRepairVOMeta;
import com.dt.platform.domain.eam.meta.CategoryMeta;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.dt.platform.eam.page.AssetHandlePageController;
import com.dt.platform.eam.page.AssetRepairPageController;
import com.dt.platform.eam.page.PositionPageController;
import com.dt.platform.eam.service.IAssetHandleService;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.proxy.eam.AssetHandleServiceProxy;
import com.dt.platform.proxy.eam.AssetRepairServiceProxy;
import com.dt.platform.proxy.eam.CategoryServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetRepairGtr extends BaseCodeGenerator{
    public EamAssetRepairGtr() {
        super(EAMTables.EAM_ASSET_REPAIR.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
       // cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetRepairVOMeta.ASSET_IDS);
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"reportUser","报修人","报修人");


        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.NAME).search().fuzzySearch();



        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.BUSINESS_DATE).search().range();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.BUSINESS_CODE).search();


        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.PICTURE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.NAME).table().hidden();



        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.CONTENT).search()
                .form().validate().required().
                form().textArea().height(30)
                .search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.STATUS).form().form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.REPAIR_STATUS).form().validate().required().form().selectBox().enumType(AssetRepairStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.PLAN_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.ACTUAL_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.TYPE)
                .form().selectBox().dict(DictEnum.EAM_REPAIR_TYPE);


        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.PICTURE_ID).form().upload().maxFileCount(6);

        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);
        cfg.view().list().operationColumn().width(20);
        cfg.view().formWindow().width("98%");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_REPAIR.STATUS,
                        EAMTables.EAM_ASSET_REPAIR.REPAIR_STATUS,
                        EAMTables.EAM_ASSET_REPAIR.BUSINESS_DATE
                },
                new Object[]{
                        EAMTables.EAM_ASSET_REPAIR.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_REPAIR.TYPE,
                        EAMTables.EAM_ASSET_REPAIR.REPORT_USER_ID,
                        EAMTables.EAM_ASSET_REPAIR.CONTENT
                }

        );

        cfg.view().list().disableBatchDelete();

        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
//        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
//        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");


        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_REPAIR.NAME,
                        EAMTables.EAM_ASSET_REPAIR.REPAIR_STATUS,
                }, new Object[] {
                        EAMTables.EAM_ASSET_REPAIR.PLAN_FINISH_DATE,
                        EAMTables.EAM_ASSET_REPAIR.TYPE,

                }, new Object[] {
                        EAMTables.EAM_ASSET_REPAIR.REPORT_USER_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_REPAIR.CONTENT,
                        EAMTables.EAM_ASSET_REPAIR.PICTURE_ID,
                }

        );

        cfg.view().form().addPage("资产列表","assetSelectList");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetRepairGtr g=new EamAssetRepairGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetRepairServiceProxy.class, AssetRepairPageController.class);
    }
}
