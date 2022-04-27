package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.InspectionGroup;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.eam.page.InspectionPlanPointPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionPlanPointServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class InspPlanPointGtr extends BaseCodeGenerator {
    public InspPlanPointGtr() {
        super(EAMTables.EAM_INSPECTION_PLAN_POINT.$TABLE,BASIC_INSP);
    }
    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(InspectionPoint.class,"inspectionPoint","巡检点","巡检点");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_PLAN_POINT.POINT_ID,
                }
        );

        cfg.view().field(EAMTables.EAM_INSPECTION_PLAN_POINT.PLAN_ID).table().disable(true);
        cfg.view().list().disableBatchDelete();
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_PLAN_POINT.POINT_ID,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_PLAN_POINT.SORT,
                }
        );
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        InspPlanPointGtr g=new InspPlanPointGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       //g.generateMenu(InspectionPlanPointServiceProxy.class, InspectionPlanPointPageController.class);
        //生成菜单

    }


}
