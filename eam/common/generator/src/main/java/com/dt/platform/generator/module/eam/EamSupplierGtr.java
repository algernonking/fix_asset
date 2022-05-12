package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class EamSupplierGtr extends BaseCodeGenerator{
    public EamSupplierGtr() {
        super(EAMTables.EAM_SUPPLIER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_SUPPLIER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_SUPPLIER.SUPPLIER_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_SUPPLIER.SUPPLIER_NOTES).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_SUPPLIER.SUPPLIER_NAME,
                        EAMTables.EAM_SUPPLIER.UNIT_CODE,

                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth+60);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        //eam_tpl_file

        cfg.view().field(EAMTables.EAM_SUPPLIER.SUPPLIER_NAME).form().validate().required();


        cfg.view().field(EAMTables.EAM_SUPPLIER.ADDRESS).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_SUPPLIER.SUPPLIER_NOTES).form().textArea().height(60);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_SUPPLIER.SUPPLIER_NAME,
                        EAMTables.EAM_SUPPLIER.UNIT_CODE,
                },
                new Object[] {
                        EAMTables.EAM_SUPPLIER.BUSINESS_CONTACTS,
                        EAMTables.EAM_SUPPLIER.BUSINESS_CONTACTS_INFO,
                },
                new Object[] {
                        EAMTables.EAM_SUPPLIER.AFTER_SALES_CONTACTS,
                        EAMTables.EAM_SUPPLIER.AFTER_SALES_CONTACTS_INFO,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_SUPPLIER.ADDRESS,
                        EAMTables.EAM_SUPPLIER.SUPPLIER_NOTES,
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
