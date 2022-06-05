package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.eam.page.InspectionGroupPageController;
import com.dt.platform.eam.page.RepairGroupPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class RepairGroupGtr extends BaseCodeGenerator {


    public RepairGroupGtr() {
        super(EAMTables.EAM_REPAIR_GROUP.$TABLE,"583208716988317696");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.NOTES).search().fuzzySearch();

      //  search.inputLayout(new Object[]{SYS_CODE_EXAMPLE_CAR.PLATE_NUMBER,SYS_CODE_EXAMPLE_CAR.ORG_ID,SYS_CODE_EXAMPLE_CAR.EMP_ID});
//        context.view().list().disableMargin();

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"leader","负责人","负责人");


        cfg.getPoClassFile().addListProperty(Employee.class,"memberList","成员人","成员人");
        cfg.getPoClassFile().addListProperty(String.class,"memberIds","成员人","成员人");


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_GROUP.STATUS,
                        EAMTables.EAM_REPAIR_GROUP.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(RepairGroupMeta.MEMBER_IDS).table().disable(true);

        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.NOTES).form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.LEADER_ID).table().fillBy("leader","nameAndBadge");
        cfg.view().field(EAMTables.EAM_REPAIR_GROUP.LEADER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(RepairGroupMeta.MEMBER_IDS).basic().label("成员").form()
                .button().chooseEmployee(false);



        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_GROUP.NAME,
                        EAMTables.EAM_REPAIR_GROUP.STATUS,
                },
                new Object[] {
                        EAMTables.EAM_REPAIR_GROUP.LEADER_ID,
                        RepairGroupMeta.MEMBER_IDS
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_GROUP.NOTES,
                }
        );

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
        RepairGroupGtr g=new RepairGroupGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
      // g.generateMenu(RepairGroupServiceProxy.class, RepairGroupPageController.class);

        //生成菜单

    }

}
