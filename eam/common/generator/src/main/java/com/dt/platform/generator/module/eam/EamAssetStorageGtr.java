package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetStorage;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetStoragePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStorageServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;

public class EamAssetStorageGtr extends BaseCodeGenerator {

    public EamAssetStorageGtr() {
        super(EAMTables.EAM_ASSET_STORAGE.$TABLE,"471985490283724800");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());



        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"managerUser","管理人员","管理人员");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.ORIGINATOR_ID).table().fillBy("originator","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.MANAGER_USER_ID).table().fillBy("useUser","nameAndBadge");
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.MANAGER_USER_ID).form().validate().required().form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleFile().displayFileName(false);



        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STORAGE.STATUS,
                        EAMTables.EAM_ASSET_STORAGE.SUPPLIER_ID,
                        EAMTables.EAM_ASSET_STORAGE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_STORAGE.NAME,

                },
                new Object[]{
                        EAMTables.EAM_ASSET_STORAGE.LOCATION_NAME,
                        EAMTables.EAM_ASSET_STORAGE.BUSINESS_DATE,

                }
        );


        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.LOCATION_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.CONTENT).table().disable();

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.ATTACH).table().disable();
       // cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.NAME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.CONTENT).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.BUSINESS_DATE).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.BUSINESS_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.CONTENT).form().textArea().height(20).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.OWN_COMPANY_ID)
                .form().validate().required().form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_STORAGE.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillWith(AssetStorageMeta.SUPPLIER).muliti(false);


        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_storage:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_storage:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_storage:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_storage:bill");
        cfg.view().list().operationColumn().width(350);

        cfg.view().list().disableBatchDelete();

        //分成分组布局
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width("98%");

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STORAGE.NAME,
                        EAMTables.EAM_ASSET_STORAGE.BUSINESS_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STORAGE.SUPPLIER_ID,
                        EAMTables.EAM_ASSET_STORAGE.SUPPLIER_INFO,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STORAGE.OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET_STORAGE.MANAGER_USER_ID,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_STORAGE.LOCATION_NAME,
                        EAMTables.EAM_ASSET_STORAGE.ATTACH,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STORAGE.CONTENT,
                }
        );
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addPage("资产列表","assetSelectList");
        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetStorageGtr g=new EamAssetStorageGtr();
        //生成代码
          g.generateCode();
        //生成菜单
       // g.generateMenu(AssetStorageServiceProxy.class, AssetStoragePageController.class);

    }

}
