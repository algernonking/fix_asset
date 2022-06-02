package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.RepairOrderStatusEnum;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.RepairOrder;
import com.dt.platform.domain.eam.RepairOrderAct;
import com.dt.platform.domain.eam.meta.RepairCategoryTplMeta;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import com.dt.platform.domain.eam.meta.RepairOrderMeta;
import com.dt.platform.eam.page.RepairOrderActPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RepairCategoryTplServiceProxy;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.dt.platform.proxy.eam.RepairOrderActServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.proxy.hrm.PersonServiceProxy;

public class RepairOrderActGtr extends BaseCodeGenerator {


    public RepairOrderActGtr() {
        super(EAMTables.EAM_REPAIR_ORDER_ACT.$TABLE,"568078396299415552");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(RepairOrder.class,"order","维修申请","维修申请");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"executor","执行人","执行人");
        cfg.getPoClassFile().addSimpleProperty(RepairGroup.class,"repairGroup","维修班组","维修班组");


        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.START_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.FINISH_TIME).form().dateInput().format("yyyy-MM-dd").search().range();



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACT.REPAIR_STATUS,
                        EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID,
                        EAMTables.EAM_REPAIR_ORDER_ACT.BUSINESS_CODE,
                        EAMTables.EAM_REPAIR_ORDER_ACT.NOTES,
                },
                new Object[]{
                        EAMTables.EAM_REPAIR_ORDER_ACT.START_TIME,

                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.PICTURE_ID).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.SELECTED_CODE).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.REPAIR_COST).table().disable();
        cfg.view().field(EAMTables.EAM_REPAIR_ORDER.REPAIR_STATUS).form()
                .form().selectBox().enumType(RepairOrderStatusEnum.class);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(RepairGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(RepairGroupMeta.ID).
                textField(RepairGroupMeta.NAME).
                fillWith(RepairOrderActMeta.REPAIR_GROUP).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.EXECUTOR_ID)
                .form().validate().required().form().selectBox().queryApi(PersonServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(PersonMeta.ID).
                textField(PersonMeta.NAME).
                fillWith(RepairOrderActMeta.EXECUTOR).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_ORDER_ACT.NOTES).form().textArea().height(80);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.GROUP_ID,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.EXECUTOR_ID,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_ORDER_ACT.NOTES,
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
        RepairOrderActGtr g=new RepairOrderActGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(RepairOrderActServiceProxy.class, RepairOrderActPageController.class);

        //生成菜单

    }

}
