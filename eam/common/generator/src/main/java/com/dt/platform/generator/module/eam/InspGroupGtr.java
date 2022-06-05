package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.InspectionGroup;
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.eam.page.InspectionGroupPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class InspGroupGtr extends BaseCodeGenerator {


    public InspGroupGtr() {
        super(EAMTables.EAM_INSPECTION_GROUP.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.NOTES).search().fuzzySearch();

      //  search.inputLayout(new Object[]{SYS_CODE_EXAMPLE_CAR.PLATE_NUMBER,SYS_CODE_EXAMPLE_CAR.ORG_ID,SYS_CODE_EXAMPLE_CAR.EMP_ID});
//        context.view().list().disableMargin();



        cfg.getPoClassFile().addSimpleProperty(Employee.class,"leader","负责人","负责人");
        cfg.getPoClassFile().addListProperty(Employee.class,"memberList","巡检人","巡检人");
        cfg.getPoClassFile().addListProperty(String.class,"memberIds","巡检人","巡检人");


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_GROUP.STATUS,
                        EAMTables.EAM_INSPECTION_GROUP.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);


        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);



        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.LEADER_ID).form();
        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.NOTES).form().textArea().height(60);


        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.LEADER_ID).table().fillBy("leader","nameAndBadge");
        cfg.view().field(EAMTables.EAM_INSPECTION_GROUP.LEADER_ID).form()
                .button().chooseEmployee(true);

        //        cfg.view().field(EAMTables.EAM_INVENTORY.DIRECTOR_ID).table().fillBy("manager","name");
        cfg.view().field(InspectionGroupMeta.MEMBER_IDS).basic().label("成员").form()
                .button().chooseEmployee(false);

        cfg.view().field(InspectionGroupMeta.MEMBER_IDS).table().disable(true);

        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_GROUP.STATUS,
                        EAMTables.EAM_INSPECTION_GROUP.NAME,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_GROUP.LEADER_ID,
                        InspectionGroupMeta.MEMBER_IDS
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_GROUP.NOTES,
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
        InspGroupGtr g=new InspGroupGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //  g.generateMenu(InspectionGroupServiceProxy.class, InspectionGroupPageController.class);

        //生成菜单

    }

}
