package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetBorrowStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.AssetHandle;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.eam.page.AssetBorrowPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.generator.builder.view.config.Tab;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

public class EamAssetBorrowGtr extends BaseCodeGenerator {

    public EamAssetBorrowGtr() {
        super(
                AssetBorrowServiceProxy.class, AssetBorrowPageController.class,
                EAMTables.EAM_ASSET_BORROW.$TABLE,BASIC_DATA_MENU_ID);
    }



    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.getPoClassFile().addListProperty(AssetItem.class,"assetItemList","资产列表","资产列表");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"borrower","借用人","借用人");
        //cfg.service().addRelationSaveAction(AssetItemServiceImpl.class,AssetBorrowVOMeta.ASSET_IDS);
       // cfg.view().list().disableSpaceColumn();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.SELECTED_CODE).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ID).basic().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ATTACH).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROW_STATUS).form().selectBox().enumType(AssetBorrowStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROW_TIME).form().validate().required().search().range();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.PLAN_RETURN_DATE).form().validate().required().search().range();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.RETURN_DATE).form().search().range();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).form().validate().required().form().button().chooseEmployee(true);



        cfg.view().field(EAMTables.EAM_ASSET_BORROW.CONTENT).form().textArea().height(30).search().fuzzySearch();


//        cfg.view().list().operationColumn().addActionButton("送审","forApproval",null);
//        cfg.view().list().operationColumn().addActionButton("确认","confirmData",null);
//        cfg.view().list().operationColumn().addActionButton("撤销","revokeData",null);
//        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);
        cfg.view().list().addToolButton("归还","assetReturn","asset_return_buttion","eam_asset_borrow:return");
        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_borrow:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_borrow:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_borrow:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_borrow:bill");

        //  cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROW_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().list().operationColumn().width(350);

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROW_TIME).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.PLAN_RETURN_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.RETURN_DATE).form().dateInput().format("yyyy-MM-dd").search().range();



        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).table().fillBy("borrower","nameAndBadge");


        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleFile().displayFileName(false);

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).form()
                .button().chooseEmployee(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.STATUS,
                        EAMTables.EAM_ASSET_BORROW.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_BORROW.BORROWER_ID,
                        EAMTables.EAM_ASSET_BORROW.CONTENT
                },
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME,

                }
        );
        //分成分组布局


        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);


        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.NAME,
                        EAMTables.EAM_ASSET_BORROW.BORROWER_ID,
                }, new Object[] {
                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME
                }, new Object[] {
                        EAMTables.EAM_ASSET_BORROW.PLAN_RETURN_DATE
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.CONTENT,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
 
        //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetBorrowGtr g=new EamAssetBorrowGtr();

        //生成代码
        g.generateCode();
       // g.reGenerateMenu();;
        //生成菜单
        //g.generateMenu(AssetBorrowServiceProxy.class, AssetBorrowPageController.class);
    }



}
