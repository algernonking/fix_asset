package com.dt.platform.generator.module.vehicle;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.constants.enums.vehicle.VehicleHandleStatusEnum;
import com.dt.platform.constants.enums.vehicle.VehicleRepairStatusEnum;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.domain.vehicle.MSelectItem;
import com.dt.platform.domain.vehicle.Maintenance;
import com.dt.platform.domain.vehicle.meta.ApplyVOMeta;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import com.dt.platform.domain.vehicle.meta.MaintenanceVOMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.vehicle.MaintenanceServiceProxy;
import com.dt.platform.vehicle.page.MaintenancePageController;
import com.dt.platform.vehicle.service.impl.InfoServiceImpl;
import com.dt.platform.vehicle.service.impl.MSelectItemServiceImpl;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class VehicleMaintenanceGtr extends BaseCodeGenerator {


    public VehicleMaintenanceGtr() {
        super(VehicleTables.VEHICLE_MAINTENANCE.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Info.class,"vehicleInfoList","车辆","车辆");
        cfg.getPoClassFile().addListProperty(String.class,"vehicleInfoIds","车辆列表","车辆列表");


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintenanceDict","报修类型","报修类型");



        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.ID).basic().hidden(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.NAME).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.CONTENT).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.BUSINESS_CODE).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        VehicleTables.VEHICLE_MAINTENANCE.REPAIR_STATUS,
                        VehicleTables.VEHICLE_MAINTENANCE.BUSINESS_CODE,
                        VehicleTables.VEHICLE_MAINTENANCE.REPORT_USER_NAME,
                        VehicleTables.VEHICLE_MAINTENANCE.CONTENT
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.NAME).form().validate().required();
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.TYPE).form().validate().required();


        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.ID).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.PROC_ID).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.REPORT_USER_ID).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.SELECTED_CODE).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.CREATE_TIME).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.PICTURE_ID).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.STATUS).table().disable(true);
        //前端还在

        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.ID).table().hidden(true);

        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.STATUS).form().
                label("办理状态").selectBox().enumType(VehicleHandleStatusEnum.class);

        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.REPAIR_STATUS).form().
                label("业务状态").selectBox().enumType(VehicleRepairStatusEnum.class);

        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.PLAN_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.ACTUAL_FINISH_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.TYPE)
                .basic().label("报修类型")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=vehicle_maintenance_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(MaintenanceMeta.MAINTENANCE_DICT).muliti(false);

        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.CONTENT).form().textArea().height(30);
        cfg.view().field(VehicleTables.VEHICLE_MAINTENANCE.PICTURE_ID)
                .form().label("图片").upload().buttonLabel("选择图片").maxFileCount(3).displayFileName(false);

        cfg.view().list().disableBatchDelete();

        cfg.view().list().operationColumn().addActionButton("确认维修","confirmData","confirm-data-button","vehicle_maintenance:confirm");
        cfg.view().list().operationColumn().addActionButton("结束维修","finishData","finish-data-button","vehicle_maintenance:finish");
        cfg.view().list().operationColumn().addActionButton("取消","cancelData","cancel-data-button","vehicle_maintenance:cancel");



        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        VehicleTables.VEHICLE_MAINTENANCE.NAME,
                        VehicleTables.VEHICLE_MAINTENANCE.TYPE,
                },
                new Object[] {
                        VehicleTables.VEHICLE_MAINTENANCE.REPORT_USER_NAME,
                        VehicleTables.VEHICLE_MAINTENANCE.COST,
                },
                new Object[] {
                        VehicleTables.VEHICLE_MAINTENANCE.PLAN_FINISH_DATE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        VehicleTables.VEHICLE_MAINTENANCE.CONTENT,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        VehicleTables.VEHICLE_MAINTENANCE.PICTURE_ID,
                }
        );



        cfg.service().addRelationSaveAction(MSelectItemServiceImpl.class, MaintenanceVOMeta.VEHICLE_INFO_IDS);

        cfg.view().form().addPage("车辆列表","vehicleSelectList");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        VehicleMaintenanceGtr g=new VehicleMaintenanceGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
       // g.generateMenu(MaintenanceServiceProxy.class, MaintenancePageController.class);
    }

}
