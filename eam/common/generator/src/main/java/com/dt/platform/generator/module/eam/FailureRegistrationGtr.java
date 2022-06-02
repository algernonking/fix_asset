package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.FailureRegistration;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.domain.eam.meta.FailureRegistrationMeta;
import com.dt.platform.eam.page.BrandPageController;
import com.dt.platform.eam.page.FailureRegistrationPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.BrandServiceProxy;
import com.dt.platform.proxy.eam.FailureRegistrationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class FailureRegistrationGtr extends BaseCodeGenerator {


    public FailureRegistrationGtr() {
        super(EAMTables.EAM_FAILURE_REGISTRATION.$TABLE,EQ_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");

        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.BUSINESS_CODE).search().fuzzySearch();





        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_FAILURE_REGISTRATION.STATUS,
                        EAMTables.EAM_FAILURE_REGISTRATION.TYPE,
                        EAMTables.EAM_FAILURE_REGISTRATION.NAME,
                }
        );

        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.PICTURE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.PROC_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.SELECTED_CODE).table().disable(true);

        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.STATUS).basic().label("办理状态")
                .form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.CONTENT).form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.TYPE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_equipment_failure")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(FailureRegistrationMeta.TYPE_DICT).muliti(false);

        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);



        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_failure_registration:confirm");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");


        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.ATTACH_ID)
                .form().label("附件").upload().acceptSingleFile().maxFileCount(1).displayFileName(false);

        cfg.view().field(EAMTables.EAM_FAILURE_REGISTRATION.PICTURE_ID)
                .form().label("图片").upload().acceptImageType().maxFileCount(6).buttonLabel("选择图片");

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(60);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_FAILURE_REGISTRATION.NAME ,
                },
                new Object[] {
                        EAMTables.EAM_FAILURE_REGISTRATION.TYPE ,
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_FAILURE_REGISTRATION.CONTENT ,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_FAILURE_REGISTRATION.PICTURE_ID ,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_FAILURE_REGISTRATION.ATTACH_ID  ,
                }
        );
        cfg.view().form().addPage("设备列表","assetSelectList");
        cfg.view().search().inputWidth(Config.searchInputWidth);

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
        FailureRegistrationGtr g=new FailureRegistrationGtr();
        //生成代码
       g.generateCode();
     //   g.removeByBatchId("582429214846746624");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(FailureRegistrationServiceProxy.class, FailureRegistrationPageController.class);
        //生成菜单

    }

}
