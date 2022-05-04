package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.AssetSoftwareMeta;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.eam.page.AssetSoftwarePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetSoftwareServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class SoftwareGtr extends BaseCodeGenerator {


    public SoftwareGtr() {
        super(EAMTables.EAM_ASSET_SOFTWARE.$TABLE,BASIC_ASSET_SOFT_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.ID).basic().hidden(true);
        cfg.getPoClassFile().addSimpleProperty(Catalog.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"source","来源","来源");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人","管理人");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"copyrightTypeDict","版权","版权");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"licenseModeDict","许可","许可");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE.STATUS,
                        EAMTables.EAM_ASSET_SOFTWARE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_SOFTWARE.NAME,
                        EAMTables.EAM_ASSET_SOFTWARE.COPYRIGHT_TYPE
                },
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE.LICENSE_MODE,
                        EAMTables.EAM_ASSET_SOFTWARE.SUPPLIER_ID,
                        EAMTables.EAM_ASSET_SOFTWARE.SOURCE_ID,
                        EAMTables.EAM_ASSET_SOFTWARE.POSITION_DETAIL,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_SOFTWARE.PURCHASE_DATE,
                }
        );
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.LABEL1).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.LABEL2).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.LABEL3).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.LABEL4).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.COST_PRICE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CONTENT).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.PROC_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CHS_STATUS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CHS_TYPE).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CHS_VERSION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CHANGE_INSTANCE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.SUMMARY).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.LATEST_APPROVER_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.LATEST_APPROVER_NAME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.NEXT_APPROVER_IDS).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.NEXT_APPROVER_NAMES).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.APPROVAL_OPINION).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.OWN_COMPANY_ID).table().disable(true);


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.STATUS).form().
                form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.REGISTER_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.PURCHASE_DATE).form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_EXPIRATION_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.MAINTENANCE_START_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.MAINTENANCE_END_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CATEGORY_ID)
                .basic().label("软件分类")
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_NODES)
                .paging(false).filter(false).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME)
                .fillWith(AssetSoftwareMeta.CATEGORY).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillWith(AssetSoftwareMeta.SUPPLIER).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.SOURCE_ID)
                .basic().label("来源")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_source")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetSoftwareMeta.SOURCE).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.COPYRIGHT_TYPE)
                .basic().label("版权类型")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=asset_software_copyright_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetSoftwareMeta.COPYRIGHT_TYPE_DICT).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.LICENSE_MODE)
                .basic().label("许可模式")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=asset_software_license_mode")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetSoftwareMeta.LICENSE_MODE_DICT).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_CODE).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_INFO).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.CONTENT).form().textArea().height(60);

    //    cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZED_AVAILABLE_NUMBER).form().readOnly();

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.OWN_COMPANY_ID)
                .form().validate().required().form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.USE_ORGANIZATION_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.USE_ORGANIZATION_ID).table().fillBy("useOrganization","fullName");


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.MANAGER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.ORIGINATOR_ID).table().fillBy("originator","name");
        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.ORIGINATOR_ID).form()
                .button().chooseEmployee(true);


        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZED_NUMBER_UNLIMIT).table().form().validate().required().form()
                .radioBox().enumType(StatusYNEnum.class).defaultIndex(1);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_EXPIRATION_UNLIMIT).table().form().validate().required().form()
                .radioBox().enumType(StatusYNEnum.class).defaultIndex(1);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.NEED_MAINTENANCE).table().form().validate().required().form()
                .radioBox().enumType(StatusYNEnum.class).defaultIndex(1);

        cfg.view().field(EAMTables.EAM_ASSET_SOFTWARE.ATTACH_ID).form().upload().acceptSingleFile().maxFileCount(1);

        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","APPROVAL_REQUIRED");

        cfg.view().list().operationColumn().addActionButton("送审","forApproval","for-approval-button","eam_asset_software:for-approval");
        cfg.view().list().operationColumn().addActionButton("确认","confirmData","confirm-data-button","eam_asset_software:confirm");
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData","revoke-data-button","eam_asset_software:revoke");
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill","download-bill-button","eam_asset_software:bill");

        cfg.view().form().addJsVariable("ASSET_CATEGORY_DATA","[[${assetCategoryData}]]","ASSET_CATEGORY_DATA");


        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().width("95%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.NAME,
                        EAMTables.EAM_ASSET_SOFTWARE.OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET_SOFTWARE.USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_SOFTWARE.SUPPLIER_ID,
                        EAMTables.EAM_ASSET_SOFTWARE.MANAGER_ID,
                },

                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.CATEGORY_ID,
                        EAMTables.EAM_ASSET_SOFTWARE.SOURCE_ID,
                        EAMTables.EAM_ASSET_SOFTWARE.SOURCE_DETAIL,
                        EAMTables.EAM_ASSET_SOFTWARE.PURCHASE_DATE,
                        EAMTables.EAM_ASSET_SOFTWARE.REGISTER_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.COPYRIGHT_TYPE,
                        EAMTables.EAM_ASSET_SOFTWARE.LICENSE_MODE,
                        EAMTables.EAM_ASSET_SOFTWARE.POSITION_DETAIL,
                        EAMTables.EAM_ASSET_SOFTWARE.COST_PRICE,
                }
        );




        cfg.view().form().addGroup("授权信息",
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_EXPIRATION_UNLIMIT,
                        EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_EXPIRATION_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZED_NUMBER_UNLIMIT,
                        EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZED_NUMBER,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZED_AVAILABLE_NUMBER,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_CODE,
                        EAMTables.EAM_ASSET_SOFTWARE.AUTHORIZATION_INFO,
                }
        );


        cfg.view().form().addGroup("维保信息",
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.NEED_MAINTENANCE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.MAINTENANCE_START_DATE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.MAINTENANCE_END_DATE,
                }
        );

        cfg.view().form().addGroup("其他信息",
                new Object[] {
                        EAMTables.EAM_ASSET_SOFTWARE.CONTENT,
                        EAMTables.EAM_ASSET_SOFTWARE.NOTES,
                        EAMTables.EAM_ASSET_SOFTWARE.ATTACH_ID,
                }
        );




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SoftwareGtr g=new SoftwareGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(AssetSoftwareServiceProxy.class, AssetSoftwarePageController.class);
        //生成菜单

    }

}
