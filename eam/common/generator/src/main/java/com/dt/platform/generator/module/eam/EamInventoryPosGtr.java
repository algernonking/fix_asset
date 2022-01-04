package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Inventory;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamInventoryPosGtr extends BaseCodeGenerator{

    public EamInventoryPosGtr() {
        super(EAMTables.EAM_INVENTORY_POSITION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

       // cfg.getPoClassFile().addSimpleProperty(Employee.class,"inventoryDirector","盘点负责人","盘点负责人");
        cfg.view().field(EAMTables.EAM_INVENTORY_POSITION.ID).basic().hidden(true);

        //eam_asset_change_data
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY_POSITION.ID
                }
        );

        cfg.setRelationField(Inventory.class,EAMTables.EAM_INVENTORY_POSITION.INVENTORY_ID, Employee.class,EAMTables.EAM_INVENTORY_POSITION.VALUE,true);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamInventoryPosGtr g=new EamInventoryPosGtr();

        g.generateCode();

        //生成菜单
        //g.generateMenu(InventoryUserServiceProxy.class, InventoryUserPageController.class);
    }
}
