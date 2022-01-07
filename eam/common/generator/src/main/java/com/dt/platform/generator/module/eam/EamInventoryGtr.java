package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryActionStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDataStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.InventoryVOMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import com.dt.platform.eam.service.impl.*;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;

public class EamInventoryGtr extends BaseCodeGenerator{

    public EamInventoryGtr() {
        super(EAMTables.EAM_INVENTORY.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(InventoryAsset.class,"InventoryAssetInfoList","盘点资产数据","盘点资产数据");


        cfg.getPoClassFile().addListProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addListProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");




        cfg.getPoClassFile().addListProperty(Employee.class,"inventoryUser","盘点人员","盘点人员");
        cfg.getPoClassFile().addListProperty(String.class,"inventoryUserIds","盘点人员列表","盘点人员列表");

        cfg.getPoClassFile().addListProperty(Employee.class,"manager","管理人员","管理人员");
        cfg.getPoClassFile().addListProperty(String.class,"inventoryManagerIds","管理人列表","管理人列表");

        cfg.getPoClassFile().addListProperty(Employee.class,"director","负责人","负责人");
        cfg.getPoClassFile().addListProperty(String.class,"inventoryDirectorIds","负责人列表","负责人列表");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");



        cfg.getPoClassFile().addListProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addListProperty(String.class,"positionIds","存放位置Ids","存放位置Ids");

        cfg.getPoClassFile().addListProperty(Warehouse.class,"warehouse","仓库","仓库");
        cfg.getPoClassFile().addListProperty(String.class,"warehouseIds","仓库Ids","仓库Ids");

        cfg.getPoClassFile().addListProperty(Catalog.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addListProperty(String.class,"categoryIds","资产分类Ids","资产分类Ids");


        cfg.view().field(EAMTables.EAM_INVENTORY.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_INVENTORY.PLAN_ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_INVENTORY.TYPE).basic().hidden(true);


        cfg.view().field(EAMTables.EAM_INVENTORY.BUSINESS_DATE).search().range();
        cfg.view().field(EAMTables.EAM_INVENTORY.START_TIME).search().range();
        cfg.view().field(EAMTables.EAM_INVENTORY.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_INVENTORY.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.EAM_INVENTORY.STATUS).table().disable(true);
        cfg.view().field(EAMTables.EAM_INVENTORY.OWN_COMPANY_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_INVENTORY.USE_ORGANIZATION_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_INVENTORY.POSITION_ID).table().disable(true);

        cfg.view().field(InventoryMeta.INVENTORY_MANAGER_IDS).table().disable(true);
        cfg.view().field(InventoryMeta.INVENTORY_USER_IDS).table().disable(true);
        cfg.view().field(InventoryMeta.INVENTORY_DIRECTOR_IDS).table().disable(true);
        cfg.view().field(InventoryMeta.ORIGINATOR_ID).table().disable(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY.INVENTORY_STATUS,
                        EAMTables.EAM_INVENTORY.BUSINESS_CODE,
                        EAMTables.EAM_INVENTORY.NAME,
                        EAMTables.EAM_INVENTORY.NOTES,
                },new Object[]{
                        EAMTables.EAM_INVENTORY.BUSINESS_DATE,

        }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+30);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+30);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_INVENTORY.ALL_EMPLOYEE).form().validate().required().form().
                label("全员盘点").selectBox().enumType(StatusEnableEnum.class).muliti(false).defaultValue("disable");


        cfg.view().field(EAMTables.EAM_INVENTORY.DATA_STATUS).form().
                label("数据状态").selectBox().enumType(AssetInventoryDataStatusEnum.class).muliti(false);


        cfg.view().field(EAMTables.EAM_INVENTORY.STATUS).form().
                label("业务状态").selectBox().enumType(AssetHandleStatusEnum.class).muliti(false);

        cfg.view().field(EAMTables.EAM_INVENTORY.INVENTORY_STATUS).form().
                label("盘点状态").selectBox().enumType(AssetInventoryActionStatusEnum.class).muliti(false);

        cfg.view().field(EAMTables.EAM_INVENTORY.NOTES).form().textArea().height(30);

        cfg.view().field(EAMTables.EAM_INVENTORY.ASSET_STATUS).form().
                label("资产状态").selectBox().enumType(AssetStatusEnum.class).muliti(true);


        cfg.view().field(EAMTables.EAM_INVENTORY.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_INVENTORY.PURCHASE_START_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_INVENTORY.PURCHASE_END_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_INVENTORY.START_TIME).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_INVENTORY.FINISH_TIME).form().dateInput().format("yyyy-MM-dd").search().range();




        cfg.view().field(InventoryMeta.WAREHOUSE_IDS)
                .basic().label("仓库")
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(InventoryMeta.WAREHOUSE).muliti(true);

        cfg.view().field(InventoryMeta.POSITION_IDS)
                .basic().label("位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField( PositionMeta.NAME).fillWith(InventoryMeta.POSITION).muliti(true);


        cfg.view().field(InventoryMeta.CATEGORY_IDS)
                .basic().label("资产分类")
                .table().sort(false)
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_NODES)
                .paging(false).filter(false).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME)
                .fillWith(InventoryMeta.CATEGORY).muliti(true);



        cfg.view().field(EAMTables.EAM_INVENTORY.OWN_COMPANY_ID)
                .form().button().chooseCompany(false);
//        cfg.view().field(EAMTables.EAM_INVENTORY.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_INVENTORY.USE_ORGANIZATION_ID)
                .form().button().chooseOrganization(false);
//        cfg.view().field(EAMTables.EAM_INVENTORY.USE_ORGANIZATION_ID).table().fillBy("useOrganization","fullName");

        cfg.view().field(InventoryMeta.INVENTORY_MANAGER_IDS).basic().label("保管人").form().button().chooseEmployee(false);

//       cfg.view().field(EAMTables.EAM_INVENTORY.ORIGINATOR_ID).basic().fillBy("manager","name");
        cfg.view().field(InventoryMeta.INVENTORY_DIRECTOR_IDS).basic().label("负责人").form()
                .button().chooseEmployee(false);

//        cfg.view().field(EAMTables.EAM_INVENTORY.DIRECTOR_ID).table().fillBy("manager","name");
        cfg.view().field(InventoryMeta.INVENTORY_USER_IDS).basic().label("盘点人").form()
                .button().chooseEmployee(false);


//        List<List<Employee>> managerList= CollectorUtil.collectList(list.getList(), Inventory::getManager);
//        List<Employee> managers=managerList.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
//        inventoryService.dao().join(managers, Person.class);
//
//        List<List<Employee>> usersList= CollectorUtil.collectList(list.getList(), Inventory::getInventoryUser);
//        List<Employee> users=usersList.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
//        inventoryService.dao().join(users, Person.class);
//
//        List<List<Employee>> directorList= CollectorUtil.collectList(list.getList(), Inventory::getDirector);
//        List<Employee> directors=directorList.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
//        inventoryService.dao().join(directors, Person.class);

        cfg.view().list().disableBatchDelete();
        cfg.view().list().addToolButton("开始","inventoryStart",null,"eam_inventory:start");
        cfg.view().list().addToolButton("结束","inventoryFinish",null,"eam_inventory:finish");
        cfg.view().list().addToolButton("取消","inventoryCancel",null,"eam_inventory:cancel");
        cfg.view().list().addToolButton("数据同步","inventoryDataSync",null,"eam_inventory:datasync");
       cfg.view().list().operationColumn().addActionButton("明细","inventoryDetail","inventory-detail-button",null);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY.NAME,
                        InventoryMeta.INVENTORY_USER_IDS
                },
                new Object[] {
                        InventoryMeta.INVENTORY_DIRECTOR_IDS,
                },
                new Object[]{
                        EAMTables.EAM_INVENTORY.ALL_EMPLOYEE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY.NOTES,
                }
        );

        cfg.view().form().addGroup("盘点范围",
                new Object[] {
                        EAMTables.EAM_INVENTORY.PURCHASE_START_DATE,
                        EAMTables.EAM_INVENTORY.PURCHASE_END_DATE,
                        EAMTables.EAM_INVENTORY.ASSET_STATUS,
                },
                new Object[] {
                        EAMTables.EAM_INVENTORY.OWN_COMPANY_ID,
                        EAMTables.EAM_INVENTORY.USE_ORGANIZATION_ID,
                        InventoryMeta.INVENTORY_MANAGER_IDS,
                },
                new Object[] {
                        InventoryMeta.CATEGORY_IDS,
                        InventoryMeta.POSITION_IDS,
                        InventoryMeta.WAREHOUSE_IDS
//                        EAMTables.EAM_INVENTORY.CATEGORY_ID,
//                        EAMTables.EAM_INVENTORY.POSITION_ID,
//                        EAMTables.EAM_INVENTORY.WAREHOUSE_ID,
                }

        );

        cfg.view().form().addJsVariable("PLAN_ID","[[${planId}]]","PLAN_ID");
        cfg.view().form().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");
        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");

        cfg.service().addRelationSaveAction(InventoryUserServiceImpl.class, InventoryVOMeta.INVENTORY_USER_IDS);
        cfg.service().addRelationSaveAction(InventoryDirectorServiceImpl.class, InventoryVOMeta.INVENTORY_DIRECTOR_IDS);
        cfg.service().addRelationSaveAction(InventoryManagerServiceImpl.class, InventoryVOMeta.INVENTORY_MANAGER_IDS);

        cfg.service().addRelationSaveAction(InventoryPositionServiceImpl.class,InventoryVOMeta.POSITION_IDS);
        cfg.service().addRelationSaveAction(InventoryWarehouseServiceImpl.class,InventoryVOMeta.WAREHOUSE_IDS);
        cfg.service().addRelationSaveAction(InventoryCatalogServiceImpl.class,InventoryVOMeta.CATEGORY_IDS);



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
                .setListPage(WriteMode.CREATE_IF_NOT_EXISTS)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();


    }

    public static void main(String[] args) throws Exception {
        EamInventoryGtr g=new EamInventoryGtr();

        g.generateCode();

        //生成菜单
     //   g.generateMenu(InventoryServiceProxy.class, InventoryPageController.class);
    }
}
