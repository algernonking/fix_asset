package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskPointStatusEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskStatusEnum;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.domain.eam.InspectionTask;
import com.dt.platform.domain.eam.meta.InspectionPointMeta;
import com.dt.platform.domain.eam.meta.InspectionRouteMeta;
import com.dt.platform.domain.eam.meta.InspectionTaskPointMeta;
import com.dt.platform.eam.page.InspectionTaskPointPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionRouteServiceProxy;
import com.dt.platform.proxy.eam.InspectionTaskPointServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class InspTaskPointGtr extends BaseCodeGenerator {


    public InspTaskPointGtr() {
        super(EAMTables.EAM_INSPECTION_TASK_POINT.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_NAME).search().fuzzySearch();

        cfg.getPoClassFile().addSimpleProperty(InspectionRoute.class,"route","route","route");
        cfg.getPoClassFile().addSimpleProperty(InspectionTask.class,"task","task","task");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_CODE,
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.SELECTED_CODE).table().disable(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.TASK_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS_LATITUDE).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS_LONGITUDE).table().disable(true);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_RFID).table().disable(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS_LATITUDE).form().numberInput().defaultValue(0);
        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS_LONGITUDE).form().numberInput().defaultValue(0);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.STATUS).form()
                .selectBox().enumType(InspectionTaskStatusEnum.class);


        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_STATUS).form()
                .selectBox().enumType(InspectionTaskPointStatusEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.POINT_ROUTE_ID)
                .form().selectBox().queryApi(InspectionRouteServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(InspectionRouteMeta.ID).
                textField(InspectionRouteMeta.NAME).
                fillWith(InspectionTaskPointMeta.ROUTE).muliti(false).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_TASK_POINT.OPER_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").defaultNow();
        cfg.view().formWindow().width("85%");
        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_STATUS,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT.OPER_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT.CONTENT
                }
        );
        cfg.view().form().addGroup("巡检点",
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_CODE,
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_NAME,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_ROUTE_ID,
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_NOTES,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS,
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS_LONGITUDE,
                        EAMTables.EAM_INSPECTION_TASK_POINT.POINT_POS_LATITUDE,
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
        InspTaskPointGtr g=new InspTaskPointGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       // g.generateMenu(InspectionTaskPointServiceProxy.class, InspectionTaskPointPageController.class);
        //生成菜单

    }

}
