package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.RepairOrderTypeEnum;
import com.dt.platform.domain.eam.RepairCategoryTpl;
import com.dt.platform.domain.eam.RepairOrder;
import com.dt.platform.domain.eam.RepairOrderAcceptance;
import com.dt.platform.domain.eam.RepairOrderAct;
import com.dt.platform.domain.eam.meta.FailureRegistrationMeta;
import com.dt.platform.domain.eam.meta.RepairCategoryTplMeta;
import com.dt.platform.domain.eam.meta.RepairOrderAcceptanceMeta;
import com.dt.platform.domain.eam.meta.RepairOrderMeta;
import com.dt.platform.eam.page.RepairOrderAcceptancePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RepairCategoryTplServiceProxy;
import com.dt.platform.proxy.eam.RepairOrderAcceptanceServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import com.google.zxing.ResultMetadataType;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class RepairOrderAcceptGtr extends BaseCodeGenerator {


    public RepairOrderAcceptGtr() {
        super(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.$TABLE,"568078396299415552");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.NOTES).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(RepairOrder.class,"order","申请单","申请单");
        cfg.getPoClassFile().addSimpleProperty(RepairOrderAct.class,"orderAct","维修单","维修单");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"accepter","验收人","验收人");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"resultTypeDict","结果类型","结果类型");

        cfg.getPoClassFile().addSimpleProperty(RepairCategoryTpl.class,"categoryTpl","报修故障","报修故障");

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.FINISH_TIME).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.NOTES).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.CATEGORY_TPL_ID,
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.RESULT_TYPE,
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.BUSINESS_CODE,
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.NOTES,
                },
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.FINISH_TIME,
                }

        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.RESULT_TYPE)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_repair_result_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(RepairOrderAcceptanceMeta.RESULT_TYPE_DICT ).muliti(false);


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.CATEGORY_TPL_ID)
                .form().validate().required().form().selectBox().queryApi(RepairCategoryTplServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(RepairCategoryTplMeta.ID).
                textField(RepairCategoryTplMeta.NAME).
                fillWith(RepairOrderAcceptanceMeta.CATEGORY_TPL).muliti(false);




        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.FINISH_TIME).form().dateInput().format("yyyy-MM-dd").defaultNow();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ACCEPTER_ID).table().fillBy("accepter","nameAndBadge");
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ACCEPTER_ID).form().validate().required().form()
                .button().chooseEmployee(true);


        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ACCEPTER_ID,
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.ACTUAL_COST,
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.FINISH_TIME,

                },
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.RESULT_TYPE,
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.CATEGORY_TPL_ID
                }


        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE.NOTES
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        RepairOrderAcceptGtr g=new RepairOrderAcceptGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       // g.generateMenu(RepairOrderAcceptanceServiceProxy.class, RepairOrderAcceptancePageController.class);

        //生成菜单

    }

}
