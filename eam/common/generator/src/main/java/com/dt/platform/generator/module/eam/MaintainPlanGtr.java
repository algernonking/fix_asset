package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.EamPlanStatusEnum;
import com.dt.platform.constants.enums.eam.MaintainCycleMethodEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.MaintainGroupMeta;
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import com.dt.platform.eam.page.MaintainPlanPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.MaintainGroupServiceProxy;
import com.dt.platform.proxy.eam.MaintainPlanServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class MaintainPlanGtr extends BaseCodeGenerator {

    //583187884257837056 main

    //583208512239173632 setting
    public MaintainPlanGtr() {
        super(EAMTables.EAM_MAINTAIN_PLAN.$TABLE,"583187884257837056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.ID).basic().hidden(true);

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addListProperty(MaintainProject.class,"projectList","项目","项目");
        cfg.getPoClassFile().addListProperty(String.class,"projectIds","项目","项目");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintainTypeDict","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(MaintainGroup.class,"maintainGroup","执行班组","执行班组");

        cfg.getPoClassFile().addSimpleProperty(ActionCrontab.class,"actionCrontab","周期","周期");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_MAINTAIN_PLAN.STATUS,
                        EAMTables.EAM_MAINTAIN_PLAN.MAINTAIN_TYPE,
                        EAMTables.EAM_MAINTAIN_PLAN.CODE,
                        EAMTables.EAM_MAINTAIN_PLAN.NAME,
                },
                new Object[]{
                        EAMTables.EAM_MAINTAIN_PLAN.CYCLE_METHOD,
                        EAMTables.EAM_MAINTAIN_PLAN.GROUP_ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.ACTION_CYCLE_ID).table().disable();

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.START_TIME).form().validate().required().form().dateInput().format("yyyy-MM-dd HH:mm:ss").defaultNow().search().range();

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.END_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();


        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.ACTION_CYCLE_ID).form().readOnly();


        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.STATUS).form().selectBox().enumType(EamPlanStatusEnum.class);

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.CYCLE_METHOD).form().validate().required().form().selectBox().enumType(MaintainCycleMethodEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.MAINTAIN_TYPE)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintain_type")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(MaintainPlanMeta.MAINTAIN_TYPE_DICT).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");

        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(MaintainGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(MaintainGroupMeta.ID).
                textField(MaintainGroupMeta.NAME).
                fillWith(MaintainPlanMeta.MAINTAIN_GROUP).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.TOTAL_COST).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.TOTAL_COST).form().numberInput();
        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.TIMEOUT).form().validate().required().form().numberInput().defaultValue(2.0);
      //  cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.NOTES).form().textArea().height(60);

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().operationColumn().width(250);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAIN_PLAN.NAME,
                        EAMTables.EAM_MAINTAIN_PLAN.INFO,
                        EAMTables.EAM_MAINTAIN_PLAN.CYCLE_METHOD,
                        EAMTables.EAM_MAINTAIN_PLAN.ACTION_CYCLE_ID,

                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_PLAN.GROUP_ID,
                        EAMTables.EAM_MAINTAIN_PLAN.MAINTAIN_TYPE,
                        EAMTables.EAM_MAINTAIN_PLAN.TOTAL_COST,
                        EAMTables.EAM_MAINTAIN_PLAN.TIMEOUT
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_PLAN.START_TIME,
                        EAMTables.EAM_MAINTAIN_PLAN.END_TIME,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                      EAMTables.EAM_MAINTAIN_PLAN.NOTES,
                }

        );




        cfg.view().list().operationColumn().addActionButton("启动","start","start-button","eam_maintain_plan:start");
        cfg.view().list().operationColumn().addActionButton("停用","stop","stop-button","eam_maintain_plan:stop");
        cfg.view().list().operationColumn().addActionButton("执行","execute","execute-button","eam_maintain_plan:execute");

        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");

        cfg.view().form().addPage("设备范围","assetSelectList");
        cfg.view().form().addPage("保养项目","maintainSelectList");

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
        MaintainPlanGtr g=new MaintainPlanGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
      //  g.generateMenu(MaintainPlanServiceProxy.class, MaintainPlanPageController.class);
        //生成菜单

    }

}