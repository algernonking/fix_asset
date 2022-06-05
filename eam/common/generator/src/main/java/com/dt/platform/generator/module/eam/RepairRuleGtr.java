package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.EmployeePerson;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import com.dt.platform.domain.eam.meta.RepairRuleMeta;
import com.dt.platform.eam.page.RepairRulePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.dt.platform.proxy.eam.RepairRuleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;
import org.github.foxnic.web.proxy.hrm.PersonServiceProxy;

public class RepairRuleGtr extends BaseCodeGenerator {


    public RepairRuleGtr() {
        super(EAMTables.EAM_REPAIR_RULE.$TABLE,"583208716988317696");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_GROUP_USER.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"user","执行人","执行人");
        cfg.getPoClassFile().addSimpleProperty(RepairGroup.class,"repairGroup","维修班组","维修班组");


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_RULE.STATUS,
                        EAMTables.EAM_REPAIR_RULE.GROUP_ID,
                        EAMTables.EAM_REPAIR_RULE.NAME,
                }
        );


        cfg.view().field(EAMTables.EAM_REPAIR_RULE.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_REPAIR_RULE.NAME)
                .form().validate().required();

        cfg.view().field(EAMTables.EAM_REPAIR_RULE.NOTES)
                .form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_REPAIR_RULE.GROUP_ID)
                .form().validate().required().form().selectBox().queryApi(RepairGroupServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(RepairGroupMeta.ID).
                textField(RepairGroupMeta.NAME).
                fillWith(RepairRuleMeta.REPAIR_GROUP).muliti(false);

        cfg.view().field(EAMTables.EAM_REPAIR_RULE.USER_ID)
                .form().selectBox().queryApi(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
                .paging(false).filter(false).toolbar(false)
                .valueField("employeeId").
                textField(PersonMeta.NAME).
                fillWith(RepairRuleMeta.USER).muliti(false);


        cfg.view().formWindow().width("75%");
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_RULE.NAME,
                        EAMTables.EAM_REPAIR_RULE.STATUS,
                        EAMTables.EAM_REPAIR_RULE.CODE,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_RULE.GROUP_ID,
                        EAMTables.EAM_REPAIR_RULE.USER_ID,
                        EAMTables.EAM_REPAIR_RULE.SORT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_RULE.NOTES,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().inputWidth(Config.searchInputWidth);

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
        RepairRuleGtr g=new RepairRuleGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
        //g.generateMenu(RepairRuleServiceProxy.class, RepairRulePageController.class);
        //生成菜单

    }

}