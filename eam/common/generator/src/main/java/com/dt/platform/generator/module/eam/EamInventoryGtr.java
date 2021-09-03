package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.InventoryUser;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.InventoryVOMeta;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.eam.page.InventoryPageController;
import com.dt.platform.eam.service.impl.InventoryUserServiceImpl;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.proxy.eam.InventoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamInventoryGtr extends BaseCodeGenerator{

    public EamInventoryGtr() {
        super(EAMTables.EAM_INVENTORY.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addListProperty(InventoryUser.class,"inventoryUserList","盘点人员","盘点人员");
        cfg.getPoClassFile().addListProperty(String.class,"inventoryUserIds","盘点人员列表","盘点人员列表");



        cfg.view().field(EAMTables.EAM_INVENTORY.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_INVENTORY.BUSINESS_DATE).search().range();
        cfg.view().field(EAMTables.EAM_INVENTORY.START_TIME).search().range();
        cfg.view().field(EAMTables.EAM_INVENTORY.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INVENTORY.NOTES).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY.CATEGORY_ID,
                        EAMTables.EAM_INVENTORY.NAME,
                        EAMTables.EAM_INVENTORY.STATUS,
                        EAMTables.EAM_INVENTORY.BUSINESS_CODE,
                        EAMTables.EAM_INVENTORY.NOTES,
                },new Object[]{
                        EAMTables.EAM_INVENTORY.BUSINESS_DATE,
                        EAMTables.EAM_INVENTORY.START_TIME,

        }
        );


        cfg.view().field(EAMTables.EAM_INVENTORY.NOTES).form().textArea().height(30);
        cfg.view().field(EAMTables.EAM_INVENTORY.NAME).form().validate().required();


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
              cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY.NAME,
                        EAMTables.EAM_INVENTORY.DIRECTORY_ID,
                        InventoryMeta.INVENTORY_USER_IDS,
                        EAMTables.EAM_INVENTORY.START_TIME,

                }, new Object[] {
                        EAMTables.EAM_INVENTORY.CATEGORY_ID,
                        EAMTables.EAM_INVENTORY.OWN_COMPANY_ID,
                        EAMTables.EAM_INVENTORY.USE_ORGANIZATION_ID,
                        EAMTables.EAM_INVENTORY.POSITION_ID,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY.NOTES,

                }
        );



        cfg.service().addRelationSaveAction(InventoryUserServiceImpl.class, InventoryVOMeta.INVENTORY_USER_IDS);

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
        EamInventoryGtr g=new EamInventoryGtr();

        g.generateCode();

        //生成菜单
     //   g.generateMenu(InventoryServiceProxy.class, InventoryPageController.class);
    }
}
