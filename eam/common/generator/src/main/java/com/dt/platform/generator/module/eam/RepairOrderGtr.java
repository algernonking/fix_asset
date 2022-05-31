package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetRepairStatusEnum;
import com.dt.platform.constants.enums.eam.RepairOrderStatusEnum;
import com.dt.platform.constants.enums.eam.RepairOrderTypeEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.RepairOrderPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RepairCategoryTplServiceProxy;
import com.dt.platform.proxy.eam.RepairOrderServiceProxy;
import com.dt.platform.proxy.eam.RepairUrgencyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class RepairOrderGtr extends BaseCodeGenerator{
    public RepairOrderGtr() {
        super(EAMTables.EAM_REPAIR_ORDER.$TABLE,"568078396299415552");
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"reportUser","报修人","报修人");

        cfg.getPoClassFile().addSimpleProperty(RepairOrderAct.class,"orderAct","维修单","维修单");
        cfg.getPoClassFile().addSimpleProperty(RepairOrderAcceptance.class,"orderAcceptance","验收单","验收单");

        cfg.getPoClassFile().addSimpleProperty(RepairCategoryTpl.class,"categoryTpl","报修故障","报修故障");
        cfg.getPoClassFile().addSimpleProperty(RepairUrgency.class,"repairUrgency","紧急程度","紧急程度");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"organization","报修部门","报修部门");



        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.SELECTED_CODE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.BUSINESS_CODE).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.PICTURE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.CONTENT).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.PICTURE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPORT_USER_ID).table().disable();

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.CONTENT).search()
                .form().validate().required().
                form().textArea().height(60)
                .search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.STATUS).form().form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPAIR_STATUS).form()
                .form().selectBox().enumType(RepairOrderStatusEnum.class);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.PLAN_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
      //  cfg.view().field(EAMTables.EAM_REPAIR_ORDER.ACTUAL_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.CATEGORY_TPL_ID)
                .form().validate().required().form().selectBox().queryApi(RepairCategoryTplServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(RepairCategoryTplMeta.ID).
                textField(RepairCategoryTplMeta.NAME).
                fillWith(RepairOrderMeta.CATEGORY_TPL).muliti(false);

//
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.URGENCY_ID)
                .form().validate().required().form().selectBox().queryApi(RepairUrgencyServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(RepairUrgencyMeta.ID).
                textField(RepairUrgencyMeta.NAME).
                fillWith(RepairOrderMeta.REPAIR_URGENCY).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPAIR_TYPE).form().validate().required().form().selectBox().enumType(RepairOrderTypeEnum.class);


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPORT_ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPORT_ORG_ID).table().fillBy("organization","fullName");


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPORT_USER_ID).table().fillBy("reportUser","nameAndBadge");
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPORT_USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.PICTURE_ID).form().upload().acceptImageType().maxFileCount(6).buttonLabel("选择图片");

        cfg.view().list().addToolButton("派单","dispatchOrder","","eam_repair_order:dispatch");

        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_repair_order:for-approval");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_repair_order:revoke");
        cfg.view().list().operationColumn().addActionButton("结束维修","finishData","finish-data-button","eam_repair_order:finish");
        cfg.view().list().operationColumn().addActionButton("确认工单","confirmData","confirm-data-button","eam_repair_order:confirm");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_repair_order:bill");


        cfg.view().list().operationColumn().width(350);
        cfg.view().formWindow().width("98%");
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER.STATUS,
                        EAMTables.EAM_REPAIR_ORDER.REPAIR_STATUS,
                        EAMTables.EAM_REPAIR_ORDER.BUSINESS_CODE,
                },
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER.URGENCY_ID,
                        EAMTables.EAM_REPAIR_ORDER.BUSINESS_DATE
                }

        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().list().disableBatchDelete();
//
//        cfg.view().form().addJsVariable("ASSET_DEFAULT_OWN_COMPANY","[[${assetDefaultOwnCompany}]]"," ");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");




        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER.NAME,
                        EAMTables.EAM_REPAIR_ORDER.REPORT_ORG_ID ,
                        EAMTables.EAM_REPAIR_ORDER.REPORT_USER_ID,

                }, new Object[] {
                        EAMTables.EAM_REPAIR_ORDER.REPAIR_TYPE,
                        EAMTables.EAM_REPAIR_ORDER.CATEGORY_TPL_ID,

                }, new Object[] {
                        EAMTables.EAM_REPAIR_ORDER.URGENCY_ID,
                        EAMTables.EAM_REPAIR_ORDER.PLAN_FINISH_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER.CONTENT,
                        EAMTables.EAM_REPAIR_ORDER.PICTURE_ID,
                }

        );

        cfg.view().form().addPage("资产列表","assetSelectList");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        RepairOrderGtr g=new RepairOrderGtr();
        //生成代码
         g.generateCode();


        //生成菜单
       //   g.removeByBatchId("583540584287830016");
    //   g.generateMenu(RepairOrderServiceProxy.class, RepairOrderPageController.class);
    }
}
