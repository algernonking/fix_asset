package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.constants.enums.eam.MaintainCycleMethodEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskOverdueEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.MaintainGroupMeta;
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import com.dt.platform.eam.page.MaintainTaskPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.proxy.eam.MaintainGroupServiceProxy;
import com.dt.platform.proxy.eam.MaintainTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class MaintainTaskGtr extends BaseCodeGenerator {

    //583187884257837056 main

    //583208512239173632 setting
    public MaintainTaskGtr() {
        super(EAMTables.EAM_MAINTAIN_TASK.$TABLE,"583187884257837056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ID).basic().hidden(true);

        cfg.getPoClassFile().addListProperty(MaintainProject.class,"projectList","项目","项目");
        cfg.getPoClassFile().addListProperty(String.class,"projectIds","项目","项目");

        cfg.getPoClassFile().addListProperty(MaintainTaskProject.class,"taskProjectList","项目","项目");
        cfg.getPoClassFile().addListProperty(String.class,"taskProjectIds","项目","项目");


        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");
        cfg.getPoClassFile().addSimpleProperty(MaintainPlan.class,"MaintainPlan","方案","方案");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintainTypeDict","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(MaintainGroup.class,"maintainGroup","执行班组","执行班组");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"executor","执行人","执行人");


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ACT_START_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ACT_FINISH_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_START_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_MODEL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_SN).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_MAINTAIN_TASK.STATUS,
                        EAMTables.EAM_MAINTAIN_TASK.OVERDUE,
                        EAMTables.EAM_MAINTAIN_TASK.GROUP_ID,
                        EAMTables.EAM_MAINTAIN_TASK.BUSINESS_CODE
                },
                new Object[]{
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_NAME,
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_CODE,
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_MODEL,
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_SN,
                },
                new Object[]{
                        EAMTables.EAM_MAINTAIN_TASK.ACT_START_TIME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.STATUS).form().selectBox().enumType(MaintainTaskStatusEnum.class);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.OVERDUE).form().selectBox().enumType(MaintainTaskOverdueEnum.class);


        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(80);




        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.EXECUTOR_ID)
                .form().selectBox().queryApi(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
                .paging(false).filter(false).toolbar(false)
                .valueField("employeeId").
                textField(PersonMeta.NAME).
                fillWith(MaintainTaskMeta.EXECUTOR).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).form().textArea().height(80);

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.NOTES).form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.GROUP_ID).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(MaintainGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(MaintainGroupMeta.ID).
                textField(MaintainGroupMeta.NAME).
                fillWith(MaintainTaskMeta.MAINTAIN_GROUP).muliti(false);



        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_INFO).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_NOTES).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_MAINTAIN_TYPE).form().readOnly();

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_MAINTAIN_TYPE).form()
               .selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintain_type")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(MaintainTaskMeta.MAINTAIN_TYPE_DICT).muliti(false);



        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_CYCLE_METHOD).form().readOnly();

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_CYCLE_METHOD).form().selectBox().enumType(MaintainCycleMethodEnum.class);


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_START_TIME).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_TOTAL_COST).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_CODE).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_MODEL).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_SN).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_STATUS).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_STATUS).form().selectBox().enumType(AssetStatusEnum.class);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ACT_TOTAL_COST).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ACT_TOTAL_COST).form().numberInput();

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ASSET_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.PLAN_ID).table().disable(true);

        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.GROUP_ID,
                        EAMTables.EAM_MAINTAIN_TASK.ACT_TOTAL_COST,
//                        EAMTables.EAM_MAINTAIN_TASK.EXECUTOR_ID,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.ACT_START_TIME,
                        EAMTables.EAM_MAINTAIN_TASK.ACT_FINISH_TIME,
                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.NOTES,

                }
        );

        cfg.view().form().addGroup("保养方案",
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_NAME,
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_INFO,
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_NOTES,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_MAINTAIN_TYPE,
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_CYCLE_METHOD,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_START_TIME,
                        EAMTables.EAM_MAINTAIN_TASK.PLAN_TOTAL_COST,
                }
        );
        cfg.view().form().addGroup("保养设备",
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_CODE,
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_NAME,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_MODEL,
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_SN,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.ASSET_STATUS,
                }
        );
        cfg.view().form().addPage("保养项目","maintainSelectList");
        cfg.view().list().operationColumn().addActionButton("执行","execute","execute-button","eam_maintain_task:execute");
        cfg.view().list().operationColumn().addActionButton("完成","finish","finish-button","eam_maintain_task:finish");

        cfg.view().list().addToolButton("取消","taskCancel","","eam_maintain_task:cancel");
        cfg.view().form().addJsVariable("GROUP_EMPLOYEE","[[${groupEmployee}]]","groupEmployee");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MaintainTaskGtr g=new MaintainTaskGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       // g.generateMenu(MaintainTaskServiceProxy.class, MaintainTaskPageController.class);
        //生成菜单

    }

}