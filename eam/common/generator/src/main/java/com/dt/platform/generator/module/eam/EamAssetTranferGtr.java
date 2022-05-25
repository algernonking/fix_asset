package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import com.dt.platform.domain.eam.meta.AssetRepairVOMeta;
import com.dt.platform.domain.eam.meta.AssetTranferVOMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.eam.page.AssetTranferPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetTranferServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetTranferGtr extends BaseCodeGenerator {

    public EamAssetTranferGtr() {
        super(EAMTables.EAM_ASSET_TRANFER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");



        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","位置","位置");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","调入管理员","调入管理员");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","使用人","使用人");

        cfg.getPoClassFile().addSimpleProperty(Organization.class,"outUseOrganization","调出公司/部门","调出公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"inUseOrganization","调入公司/部门","调入公司/部门");
       // cfg.getPoClassFile().joinSimpleProperty(Organization.class,true);



      //  cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetTranferVOMeta.ASSET_IDS);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.SELECTED_CODE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.BUSINESS_DATE).search().range();


        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.NAME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.ATTACH).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).form().form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.CONTENT).form().textArea().height(30).search().fuzzySearch();



        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID).table().fillBy("outUseOrganization","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID).table().fillBy("inUseOrganization","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).table().fillBy("manager","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.USE_USER_ID).table().fillBy("useUser","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).form()
                .button().chooseEmployee(true);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.USE_USER_ID).form()
                .button().chooseEmployee(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_TRANFER.STATUS,
                        EAMTables.EAM_ASSET_TRANFER.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_TRANFER.CONTENT,
                        EAMTables.EAM_ASSET_TRANFER.BUSINESS_DATE,


                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth+60);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth+60);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.POSITION_ID)
                .basic().label("存放位置")
                .form().validate().required().form().selectBox().defaultIndex(0).queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME).fillWith(AssetCollectionMeta.POSITION).muliti(false);

//        cfg.view().list().operationColumn().addActionButton("送审","forApproval",null);
//        cfg.view().list().operationColumn().addActionButton("确认","confirmData",null);
//        cfg.view().list().operationColumn().addActionButton("撤销","revokeData",null);
//        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);

        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_tranfer:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_tranfer:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_tranfer:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_tranfer:bill");


        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleFile().displayFileName(false);
        cfg.view().list().operationColumn().width(350);


        cfg.view().list().disableBatchDelete();

        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
//        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
//        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");
//


        //分成分组布局
        cfg.view().formWindow().width("98%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID,

                }, new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.MANAGER_ID,
                        EAMTables.EAM_ASSET_TRANFER.USE_USER_ID,
                }, new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.POSITION_ID,
                        EAMTables.EAM_ASSET_TRANFER.POSITION_DETAIL,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.CONTENT,
                }
        );

        cfg.view().form().addPage("资产列表","assetSelectList");
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetTranferGtr g=new EamAssetTranferGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(AssetTranferServiceProxy.class, AssetTranferPageController.class);
    }

}
