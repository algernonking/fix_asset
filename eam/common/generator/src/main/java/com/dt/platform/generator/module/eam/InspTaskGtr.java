package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.InspectionMethodEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskStatusEnum;
import com.dt.platform.domain.eam.InspectionGroup;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import com.dt.platform.domain.eam.meta.InspectionTaskMeta;
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import com.dt.platform.eam.page.InspectionTaskPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import com.dt.platform.proxy.eam.InspectionTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.system.DictItem;

public class InspTaskGtr extends BaseCodeGenerator {


    public InspTaskGtr() {
        super(EAMTables.EAM_INSPECTION_TASK.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(InspectionPlan.class,"inspectionPlan","计划","计划");

        cfg.getPoClassFile().addListProperty(InspectionPoint.class,"inspectionPointList","巡检点","巡检点");
        cfg.getPoClassFile().addListProperty(String.class,"inspectionPointIds","巡检点","巡检点");

        cfg.getPoClassFile().addListProperty(InspectionTaskPoint.class,"inspectionTaskPointList","任务巡检点","任务巡检点");
        cfg.getPoClassFile().addListProperty(String.class,"inspectionTaskPointIds","任务巡检点","任务巡检点");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"timeDict","时间","时间");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"inspectionTypeDict","类型","类型");

        cfg.getPoClassFile().addSimpleProperty(InspectionGroup.class,"inspectionGroup","班组","班组");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"executor","执行人","执行人");

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.NOTES).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_TASK.TASK_STATUS,
                        EAMTables.EAM_INSPECTION_TASK.GROUP_ID,
                        EAMTables.EAM_INSPECTION_TASK.PLAN_CODE,
                        EAMTables.EAM_INSPECTION_TASK.PLAN_NAME,
                },
                new Object[]{
                        EAMTables.EAM_INSPECTION_TASK.ACT_START_TIME,
                }
        );

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.NOTES).table().disable(true);
        cfg.view().list().disableBatchDelete();

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.ACT_START_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.ACT_FINISH_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_START_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();



        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.GROUP_ID)
                .form().selectBox().
                queryApi(InspectionGroupServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(InspectionGroupMeta.ID).textField(InspectionGroupMeta.NAME)
                .fillWith(InspectionTaskMeta.INSPECTION_GROUP).muliti(false);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.EXECUTOR_ID)
             .form().selectBox().queryApi(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
                .paging(false).filter(false).toolbar(false)
                .valueField("employeeId").
                textField(PersonMeta.NAME).
                fillWith(InspectionTaskMeta.EXECUTOR).muliti(false);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_INSPECTION_METHOD).form()
                .selectBox().enumType(InspectionMethodEnum.class);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.TASK_STATUS).form()
                .selectBox().enumType(InspectionTaskStatusEnum.class);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_ID).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_CODE).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_CODE).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.GROUP_ID).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_INSPECTION_METHOD).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_COMPLETION_TIME).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_START_TIME).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_NOTES).form().readOnly();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.ACT_TOTAL_COST).form().readOnly();

        cfg.view().search().labelWidth(1,Config.searchLabelWidth+50);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth+50);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+50);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+50);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(85);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.GROUP_ID,
                        EAMTables.EAM_INSPECTION_TASK.ACT_TOTAL_COST,
                    //    EAMTables.EAM_INSPECTION_TASK.EXECUTOR_ID,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.ACT_START_TIME,
                        EAMTables.EAM_INSPECTION_TASK.ACT_FINISH_TIME,
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.CONTENT,
                        EAMTables.EAM_INSPECTION_TASK.NOTES,
                }
        );

        cfg.view().form().addGroup("巡检计划",
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.PLAN_CODE,
                        EAMTables.EAM_INSPECTION_TASK.PLAN_NAME,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.PLAN_COMPLETION_TIME,
                        EAMTables.EAM_INSPECTION_TASK.PLAN_START_TIME,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.PLAN_INSPECTION_METHOD,
                        EAMTables.EAM_INSPECTION_TASK.PLAN_NOTES,
                }
        );

        cfg.view().form().addPage("巡检点","pointSelectList");
        cfg.view().list().operationColumn().addActionButton("执行","execute","execute-button","eam_inspection_task:execute");
        cfg.view().list().operationColumn().addActionButton("完成","finish","finish-button","eam_inspection_task:finish");
        cfg.view().list().operationColumn().addActionButton("取消","cancel","cancel-button","eam_inspection_task:cancel");
//        cfg.view().list().addToolButton("取消","taskCancel","","eam_inspection_task:cancel");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
         //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        InspTaskGtr g=new InspTaskGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(InspectionTaskServiceProxy.class, InspectionTaskPageController.class);
        //生成菜单

    }


}
