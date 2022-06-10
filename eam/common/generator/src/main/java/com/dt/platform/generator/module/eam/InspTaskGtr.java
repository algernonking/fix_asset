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
import com.dt.platform.eam.page.InspectionTaskPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import com.dt.platform.proxy.eam.InspectionTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;

public class InspTaskGtr extends BaseCodeGenerator {


    public InspTaskGtr() {
        super(EAMTables.EAM_INSPECTION_TASK.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(InspectionPlan.class,"inspectionPlan","计划","计划");
        cfg.getPoClassFile().addListProperty(InspectionPoint.class,"inspectionPoint","巡检点","巡检点");
        cfg.getPoClassFile().addListProperty(String.class,"inspectionPointIds","巡检点","巡检点");
        cfg.getPoClassFile().addListProperty(InspectionTaskPoint.class,"inspectionTaskPoint","任务巡检点","任务巡检点");
        cfg.getPoClassFile().addListProperty(InspectionTaskPoint.class,"inspectionTaskPointIds","任务巡检点","任务巡检点");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"timeDict","时间","时间");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"inspectionTypeDict","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(InspectionGroup.class,"inspectionGroup","班组","班组");

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


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.NOTES).table().disable(true);
        cfg.view().list().disableBatchDelete();


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.GROUP_ID)
                .form().selectBox().
                queryApi(InspectionGroupServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(InspectionGroupMeta.ID).textField(InspectionGroupMeta.NAME)
                .fillWith(InspectionTaskMeta.INSPECTION_GROUP).muliti(false);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.PLAN_INSPECTION_METHOD).form()
                .selectBox().enumType(InspectionMethodEnum.class);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK.TASK_STATUS).form()
                .selectBox().enumType(InspectionTaskStatusEnum.class);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.ACT_START_TIME,
                        EAMTables.EAM_INSPECTION_TASK.EXECUTOR_ID,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.ACT_FINISH_TIME,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.ACT_TOTAL_COST,
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
                        EAMTables.EAM_INSPECTION_TASK.GROUP_ID,
                        EAMTables.EAM_INSPECTION_TASK.PLAN_INSPECTION_METHOD,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK.PLAN_COMPLETION_TIME,
                        EAMTables.EAM_INSPECTION_TASK.PLAN_START_TIME,

                }
        );
        cfg.view().form().addPage("巡检点","pointSelectList");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
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
