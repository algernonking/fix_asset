package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.github.foxnic.generator.config.WriteMode;

public class EamWarehouseGtr extends BaseCodeGenerator{
    public EamWarehouseGtr() {
        super(EAMTables.EAM_WAREHOUSE.$TABLE,BASIC_DATA_MENU_ID);
    }


    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_WAREHOUSE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_WAREHOUSE.WAREHOUSE_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_WAREHOUSE.WAREHOUSE_NOTES).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_WAREHOUSE.WAREHOUSE_NAME,
                        EAMTables.EAM_WAREHOUSE.WAREHOUSE_NOTES,

                }
        );
        cfg.view().field(EAMTables.EAM_WAREHOUSE.WAREHOUSE_NAME).form().validate().required();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
              .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamWarehouseGtr g=new EamWarehouseGtr();
        //生成代码
        g.generateCode();


        //生成菜单
      //  g.removeByBatchId("");
       // g.generateMenu(WarehouseServiceProxy.class, WarehousePageController.class);
    }
}
