package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.github.foxnic.generator.config.WriteMode;

public class EamSupplierGtr extends BaseCodeGenerator{
    public EamSupplierGtr() {
        super(EAMTables.EAM_SUPPLIER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.EAM_SUPPLIER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_SUPPLIER.SUPPLIER_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_SUPPLIER.SUPPLIER_NOTES).search().fuzzySearch();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamSupplierGtr g=new EamSupplierGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(SupplierServiceProxy.class, SupplierPageController.class);
    }


}
