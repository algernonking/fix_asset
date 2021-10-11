package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetCollectionReturn;
import com.dt.platform.domain.eam.Position;

import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import com.dt.platform.domain.eam.meta.AssetCollectionReturnVOMeta;
import com.dt.platform.domain.eam.meta.AssetCollectionVOMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.eam.page.AssetCollectionReturnPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetCollectionReturnServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetCollectionReturnGtr extends BaseCodeGenerator {

    public EamAssetCollectionReturnGtr() {
        super(EAMTables.EAM_ASSET_COLLECTION_RETURN.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        //cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetCollectionReturnVOMeta.ASSET_IDS);

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","退库公司","退库公司");


        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.SELECTED_CODE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.USE_ORGANIZATION_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.USE_ORGANIZATION_ID).table().fillBy("useOrganization","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");


        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleFile().displayFileName(false);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.STATUS,
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.POSITION_ID,
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.USE_ORGANIZATION_ID,

                },
                new Object[]{
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.CONTENT,
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.RETURN_DATE,

                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.BUSINESS_CODE).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.NAME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.ATTACH).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.CONTENT).form().textArea().height(30).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.RETURN_DATE).form().validate().required().search().range();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.POSITION_ID)
                .basic().label("存放位置")
                .form().validate().required().form().selectBox().defaultIndex(0).queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME).fillBy(AssetCollectionMeta.POSITION).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION_RETURN.RETURN_DATE).form().dateInput().format("yyyy-MM-dd").search().range();

        //分成分组布局
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.USE_ORGANIZATION_ID,

                }
                , new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.POSITION_ID,

                }
                , new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.RETURN_DATE,
                }

        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION_RETURN.CONTENT,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");

//        cfg.view().list().operationColumn().addActionButton("送审","forApproval",null);
//        cfg.view().list().operationColumn().addActionButton("确认","confirmData",null);
//        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);
//        cfg.view().list().operationColumn().addActionButton("撤销","revokeData",null);

        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button");

        cfg.view().list().operationColumn().width(350);

//        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
//        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");

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
        EamAssetCollectionReturnGtr g=new EamAssetCollectionReturnGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AssetCollectionReturnServiceProxy.class, AssetCollectionReturnPageController.class);
    }

}
