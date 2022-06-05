package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.eam.page.InspectionRoutePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionRouteServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class InspRouteGtr extends BaseCodeGenerator {


    public InspRouteGtr() {
        super(EAMTables.EAM_INSPECTION_ROUTE.$TABLE,"583208550231179264");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_ROUTE.ID).basic().hidden(true);

        
        
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_ROUTE.NAME,
                }
        );


        cfg.view().field(EAMTables.EAM_INSPECTION_ROUTE.NAME)
                .form().validate().required();

        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_ROUTE.NAME,
                        EAMTables.EAM_INSPECTION_ROUTE.SORT,
                        EAMTables.EAM_INSPECTION_ROUTE.NOTES,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().inputWidth(Config.searchInputWidth);

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
        InspRouteGtr g=new InspRouteGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //   g.generateMenu(InspectionRouteServiceProxy.class, InspectionRoutePageController.class);
        //生成菜单

    }

}