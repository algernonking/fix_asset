package com.dt.platform.generator.module.vehicle;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.constants.enums.vehicle.VehicleApplyReturnEnum;
import com.dt.platform.constants.enums.vehicle.VehicleHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.domain.vehicle.meta.ApplyVOMeta;
import com.dt.platform.domain.vehicle.meta.InfoVOMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.service.impl.HostDbServiceImpl;
import com.dt.platform.proxy.vehicle.ApplyServiceProxy;
import com.dt.platform.vehicle.page.ApplyPageController;
import com.dt.platform.vehicle.service.impl.ASelectItemServiceImpl;
import com.dt.platform.vehicle.service.impl.InfoServiceImpl;
import com.dt.platform.vehicle.service.impl.MSelectItemServiceImpl;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class VehicleApplyGtr extends BaseCodeGenerator {


    public VehicleApplyGtr() {
        super(VehicleTables.VEHICLE_APPLY.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(VehicleTables.VEHICLE_APPLY.ID).basic().hidden(true);

        cfg.getPoClassFile().addListProperty(Info.class,"vehicleInfoList","车辆","车辆");
        cfg.getPoClassFile().addListProperty(String.class,"vehicleInfoIds","车辆列表","车辆列表");


        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"receiver","领用人","领用人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");


        cfg.view().field(VehicleTables.VEHICLE_APPLY.NAME).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.DRIVER).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.NOTES).search().fuzzySearch();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.CONTENT).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        VehicleTables.VEHICLE_APPLY.STATUS,
                        VehicleTables.VEHICLE_APPLY.BUSINESS_CODE,
                        VehicleTables.VEHICLE_APPLY.DRIVER,
                        VehicleTables.VEHICLE_APPLY.RECEIVER_ID
                },
                new Object[]{
                        VehicleTables.VEHICLE_APPLY.COLLECTION_DATE
//                        VehicleTables.VEHICLE_APPLY.PLAN_RETURN_DATE
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().field(VehicleTables.VEHICLE_APPLY.NAME).form().validate().required();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.RECEIVER_ID).form().validate().required();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.COLLECTION_DATE).form().validate().required();

        cfg.view().field(VehicleTables.VEHICLE_APPLY.SELECTED_CODE).table().disable(true);

        cfg.view().field(VehicleTables.VEHICLE_APPLY.CREATE_TIME).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_APPLY.ORIGINATOR_ID).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_APPLY.ATTACH).table().disable(true);
        cfg.view().field(VehicleTables.VEHICLE_APPLY.CONTENT).table().disable(true);


        cfg.view().field(VehicleTables.VEHICLE_APPLY.COLLECTION_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.PLAN_RETURN_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(VehicleTables.VEHICLE_APPLY.ACT_RETURN_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(VehicleTables.VEHICLE_APPLY.IF_RETURN).form().
                label("是否归还").selectBox().enumType(VehicleApplyReturnEnum.class);


        cfg.view().field(VehicleTables.VEHICLE_APPLY.STATUS).form().
                label("办理状态").selectBox().enumType(VehicleHandleStatusEnum.class);

        cfg.view().field(VehicleTables.VEHICLE_APPLY.CONTENT).form().textArea().height(30);
        cfg.view().field(VehicleTables.VEHICLE_APPLY.NOTES).form().textArea().height(30);

        cfg.view().field(VehicleTables.VEHICLE_APPLY.ORG_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(VehicleTables.VEHICLE_APPLY.ORG_ID).table().fillBy("useOrganization","fullName");


        cfg.view().field(VehicleTables.VEHICLE_APPLY.RECEIVER_ID).table().fillBy("receiver","name");
        cfg.view().field(VehicleTables.VEHICLE_APPLY.RECEIVER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(VehicleTables.VEHICLE_APPLY.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").maxFileCount(3).displayFileName(false);

        cfg.view().formWindow().bottomSpace(120);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        VehicleTables.VEHICLE_APPLY.NAME,
                        VehicleTables.VEHICLE_APPLY.DRIVER,
                        VehicleTables.VEHICLE_APPLY.CONTACT,
                },
                new Object[] {
                        VehicleTables.VEHICLE_APPLY.ORG_ID,
                        VehicleTables.VEHICLE_APPLY.RECEIVER_ID,
                },

                new Object[] {
                        VehicleTables.VEHICLE_APPLY.COLLECTION_DATE,
                        VehicleTables.VEHICLE_APPLY.PLAN_RETURN_DATE,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        VehicleTables.VEHICLE_APPLY.CONTENT,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        VehicleTables.VEHICLE_APPLY.NOTES,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        VehicleTables.VEHICLE_APPLY.ATTACH,

                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("车辆列表","vehicleSelectList");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","vehicle_apply:confirm");
        cfg.view().list().operationColumn().addActionButton("取消","cancelData","cancel-data-button","vehicle_apply:cancel");
        cfg.view().list().operationColumn().addActionButton("归还","returnData","return-data-button","vehicle_apply:return");


        //Info中间数据  ，Apply为A
        cfg.service().addRelationSaveAction(ASelectItemServiceImpl.class, ApplyVOMeta.VEHICLE_INFO_IDS);

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
        VehicleApplyGtr g=new VehicleApplyGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
     //   g.generateMenu(ApplyServiceProxy.class, ApplyPageController.class);
    }

}
