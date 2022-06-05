package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.InspectionGroup;
import com.dt.platform.domain.eam.InspectionPlanPoint;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.InspectionPlanPageController;
import com.dt.platform.eam.service.impl.InspectionPlanServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import com.dt.platform.proxy.eam.InspectionPlanServiceProxy;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class InspPlanGtr extends BaseCodeGenerator {


    public InspPlanGtr() {
        super(EAMTables.EAM_INSPECTION_PLAN.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.NAME).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(InspectionGroup.class,"inspectionGroup","班组","班组");
      //  cfg.getPoClassFile().addSimpleProperty(DictItem.class,"inspectionTypeDict","类型","类型");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"timeDict","时间","时间");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"inspectionTypeDict","类型","类型");


        cfg.getPoClassFile().addListProperty(InspectionPlanPoint.class,"inspectionPlanPointList","巡检点","巡检点");
        cfg.getPoClassFile().addListProperty(String.class,"inspectionPlanPointIds","巡检点","巡检点");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_PLAN.STATUS,
                        EAMTables.EAM_INSPECTION_PLAN.PLAN_STATUS,
                        EAMTables.EAM_INSPECTION_PLAN.NAME,
                        EAMTables.EAM_INSPECTION_PLAN.PLAN_CODE,
                }
                ,
                new Object[]{
                        EAMTables.EAM_INSPECTION_PLAN.GROUP_ID,
                        EAMTables.EAM_INSPECTION_PLAN.INSPECTION_METHOD,
                        EAMTables.EAM_INSPECTION_PLAN.PLAN_TYPE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);




        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.START_DATE).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.END_DATE).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();


//         cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.LAST_EXECUTION_TIME).table().disable(true);
//         cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.NEXT_EXECUTION_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.LEADER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.STATUS).table().disable(true);


        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.STATUS).form()
        .selectBox().enumType(AssetHandleStatusEnum.class).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.PLAN_STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.OVERTIME_METHOD).form().validate().required().form().selectBox()
                .enumType(InspectionOvertimeMethodEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.PLAN_CODE).form().validate().required().form();
        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.NAME).form().validate().required().form();

//        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.COMPLETION_TIME).form().validate().required().form().numberInput();


        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.COMPLETION_TIME)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_completion_time")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InspectionPlanMeta.TIME_DICT).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.GROUP_ID)
                .form().validate().required()
                .form().selectBox().
                queryApi(InspectionGroupServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(InspectionGroupMeta.ID).textField(InspectionGroupMeta.NAME)
                .fillWith(InspectionPlanMeta.INSPECTION_GROUP).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.INSPECTION_METHOD).form().validate().required().form()
                .selectBox().enumType(InspectionMethodEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.PLAN_TYPE).form().validate().required().form()
                .selectBox().enumType(InspectionPlanTypeEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.NOTES).form().textArea().height(80);

        cfg.view().list().disableBatchDelete();

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_PLAN.PLAN_CODE,
                        EAMTables.EAM_INSPECTION_PLAN.NAME,
                        EAMTables.EAM_INSPECTION_PLAN.PLAN_STATUS,
                        EAMTables.EAM_INSPECTION_PLAN.PLAN_TYPE,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_PLAN.GROUP_ID,
                        EAMTables.EAM_INSPECTION_PLAN.INSPECTION_METHOD,
//                        EAMTables.EAM_INSPECTION_PLAN.INSPECTION_TYPE,
                        EAMTables.EAM_INSPECTION_PLAN.OVERTIME_METHOD,
                },
                new Object[] {

                        EAMTables.EAM_INSPECTION_PLAN.COMPLETION_TIME,
                        EAMTables.EAM_INSPECTION_PLAN.START_DATE,
                        EAMTables.EAM_INSPECTION_PLAN.END_DATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_PLAN.NOTES,
                }
        );
        cfg.view().form().addPage("巡检点","pointSelectList");


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
        InspPlanGtr g=new InspPlanGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //    g.generateMenu(InspectionPlanServiceProxy.class, InspectionPlanPageController.class);
        //生成菜单

    }

}
