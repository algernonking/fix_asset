package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.eam.AssetEquipmentStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;

import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.dt.platform.proxy.eam.*;

import com.github.foxnic.generator.builder.view.config.Tab;
import com.github.foxnic.generator.config.WriteMode;
import  com.dt.platform.constants.enums.eam.AssetStatusEnum;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

import java.util.HashMap;


public class EamAssetsGtr extends BaseCodeGenerator {

    public EamAssetsGtr() {
        super(EAMTables.EAM_ASSET.$TABLE,BASIC_ASSET_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
//        cfg.getPoClassFile().addSimpleProperty(AssetExtFinancial.class,"assetFinancial","财务信息","财务信息");
//        cfg.getPoClassFile().addSimpleProperty(AssetExtFinancial.class,"assetMaintainer","维保信息","维保信息");
//        cfg.getPoClassFile().addSimpleProperty(AssetExtEquipment.class,"assetEquipment","设备信息","设备信息");
//        cfg.getPoClassFile().addSimpleProperty(AssetExtSoftware.class,"assetExtSoftware","软件信息","软件信息");



        cfg.getPoClassFile().addSimpleProperty(AssetExtData.class,"extData","扩展数据","扩展数据");
        cfg.getPoClassFile().addMapProperty(String.class,Object.class,"pcmData","PCM数据","PCM数据");
        cfg.getPoClassFile().addListProperty(CatalogAttribute.class,"catalogAttribute","自定义数据属性字段","自定义数据属性字段");
        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addSimpleProperty(CategoryFinance.class,"categoryFinance","财务分类","财务分类");
        cfg.getPoClassFile().addSimpleProperty(Catalog.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addSimpleProperty(Goods.class,"goods","物品档案","物品档案");
        cfg.getPoClassFile().addSimpleProperty(Manufacturer.class,"manufacturer","生产厂商","生产厂商");
        cfg.getPoClassFile().addSimpleProperty(Warehouse.class,"warehouse","仓库","仓库");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","使用人员","使用人员");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"manager","管理人员","管理人员");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Supplier.class,"supplier","供应商","供应商");
        cfg.getPoClassFile().addSimpleProperty(Maintainer.class,"maintnainer","维保商","维保商");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"ownerCompany","所属公司","所属公司");
        cfg.getPoClassFile().addSimpleProperty(Organization.class,"useOrganization","使用公司/部门","使用公司/部门");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"source","来源","来源");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"equipmentEnvironment","设备运行环境","设备运行环境");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"safetyLevel","安全等级","安全等级");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"assetMaintenanceStatus","维保状态","维保状态");
        cfg.getPoClassFile().addSimpleProperty(Rack.class,"rack","机柜","机柜");
        cfg.getPoClassFile().addSimpleProperty(ChangeInstance.class,"changeInstance","变更实例","变更实例");



        cfg.view().field(EAMTables.EAM_ASSET.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.ASSET_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.SERIAL_NUMBER).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.MODEL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.BATCH_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_START_DATE).basic().form().label("开始时间");
        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_END_DATE).basic().form().label("结束时间");
        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_START_DATE).search().range();
        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_END_DATE).search().range();
        cfg.view().field(EAMTables.EAM_ASSET.DIRECTOR).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.CONTACTS).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.FINANCIAL_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.ASSET_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.EQUIPMENT_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.MANAGE_IP).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET.EQUIPMENT_IP).search().fuzzySearch();



        cfg.view().field(EAMTables.EAM_ASSET.ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.CLEAN_OUT).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.DISPLAY).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.PICTURE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.ATTACH).table().disable(true);
        cfg.view().field(EAMTables.EAM_ASSET.CREATE_TIME).table().disable(true);



        cfg.view().field(EAMTables.EAM_ASSET.MANAGER_ID).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.GOODS_ID).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.BATCH_CODE).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.UNIT).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.WAREHOUSE_ID).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.POSITION_DETAIL).table().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET.LABEL).table().hidden(true);





        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET.STATUS,
                        EAMTables.EAM_ASSET.ASSET_STATUS,
                        EAMTables.EAM_ASSET.ASSET_CODE,
                        EAMTables.EAM_ASSET.SOURCE_ID,
                },
                new Object[]{
                        EAMTables.EAM_ASSET.NAME,
                        EAMTables.EAM_ASSET.MODEL,
                        EAMTables.EAM_ASSET.SERIAL_NUMBER,
                        EAMTables.EAM_ASSET.ASSET_NOTES,
                },

                new Object[]{
                        EAMTables.EAM_ASSET.OWN_COMPANY_ID,
                        EAMTables.EAM_ASSET.USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET.MANAGER_ID,
                        EAMTables.EAM_ASSET.USE_USER_ID,

                },
                new Object[]{
                        EAMTables.EAM_ASSET.POSITION_ID,
                        EAMTables.EAM_ASSET.BUSINESS_CODE,
                        EAMTables.EAM_ASSET.MANUFACTURER_ID,
                        EAMTables.EAM_ASSET.MAINTAINER_ID,
                        EAMTables.EAM_ASSET.PURCHASE_DATE,
                }

        );




        cfg.view().field(EAMTables.EAM_ASSET.MAINTAINER_ID)
                .basic().label("维保商")
                .form().selectBox().queryApi(MaintainerServiceProxy.QUERY_LIST)
                .paging(false).filter(true).toolbar(false)
                .valueField(MaintainerMeta.ID).
                textField(MaintainerMeta.MAINTAINER_NAME).
                fillWith(AssetMeta.MAINTNAINER).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.SOURCE_ID)
                .basic().label("来源")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_source")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMeta.SOURCE).muliti(false).defaultValue("purchase");

        cfg.view().field(EAMTables.EAM_ASSET.SAFETY_LEVEL_CODE)
                .basic().label("安全等级")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_safety_level")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMeta.SAFETY_LEVEL).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.EQUIPMENT_ENVIRONMENT_CODE)
                .basic().label("运行环境")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_equipment_environment")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMeta.EQUIPMENT_ENVIRONMENT).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_STATUS)
                .basic().label("维保状态")
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintenance_status")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(AssetMeta.ASSET_MAINTENANCE_STATUS).muliti(false);



        cfg.view().field(EAMTables.EAM_ASSET.RACK_ID)
                .basic().label("机柜")
                .form().selectBox().queryApi(RackServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(RackMeta.ID).
                textField(RackMeta.RACK_NAME).
                fillWith(AssetMeta.RACK).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET.STATUS).form()
                .label("办理状态").selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET.ASSET_STATUS).form().
                label("资产状态").selectBox().enumType(AssetStatusEnum.class).defaultValue("idle");

        cfg.view().field(EAMTables.EAM_ASSET.EQUIPMENT_STATUS).form().
                label("设备状态").selectBox().enumType(AssetEquipmentStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET.CATEGORY_ID)
                .basic().label("资产分类")
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_NODES)
                .paging(false).filter(false).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME)
                .fillWith(AssetMeta.CATEGORY).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.FINANCIAL_CATEGORY_ID)
                .basic().label("财务分类")
                .form().selectBox().queryApi(CategoryFinanceServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(CategoryFinanceMeta.ID).textField(CategoryFinanceMeta.HIERARCHY_NAME)
                .fillWith(AssetMeta.CATEGORY_FINANCE).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.GOODS_ID)
                .basic().label("物品档案")
                .form().selectBox().queryApi(GoodsServiceProxy.QUERY_LIST).paging(true).filter(true).toolbar(false)
                .valueField(GoodsMeta.ID).textField(GoodsMeta.NAME).fillWith(AssetMeta.GOODS).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.SUPPLIER_ID)
                .basic().label("供应商")
                .form().selectBox().queryApi(SupplierServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(SupplierMeta.ID).textField(SupplierMeta.SUPPLIER_NAME).fillWith(AssetMeta.SUPPLIER).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.WAREHOUSE_ID)
                .basic().label("仓库")
                .form().selectBox().queryApi(WarehouseServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(WarehouseMeta.ID).textField(WarehouseMeta.WAREHOUSE_NAME).fillWith(AssetMeta.WAREHOUSE).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET.POSITION_ID)
                .basic().label("位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField( PositionMeta.NAME).fillWith(AssetMeta.POSITION).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET.MANUFACTURER_ID)
                .basic().label("厂商")
                .form().selectBox().queryApi(ManufacturerServiceProxy.QUERY_LIST).paging(true).filter(true).toolbar(false)
                .valueField(ManufacturerMeta.ID).textField(ManufacturerMeta.MANUFACTURER_NAME).fillWith(AssetMeta.MANUFACTURER).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_END_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_START_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET.PURCHASE_DATE).form().dateInput().format("yyyy-MM-dd").search().range();
        cfg.view().field(EAMTables.EAM_ASSET.ENTRY_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().field(EAMTables.EAM_ASSET.RACK_UP_NUMBER).form().numberInput().allowNegative(false).scale(0);
        cfg.view().field(EAMTables.EAM_ASSET.RACK_DOWN_NUMBER).form().numberInput().allowNegative(false).scale(0);
        cfg.view().field(EAMTables.EAM_ASSET.ASSET_NUMBER).form().numberInput().allowNegative(false).scale(0);
        cfg.view().field(EAMTables.EAM_ASSET.REMAIN_NUMBER).form().numberInput().allowNegative(false).scale(0);

        cfg.view().field(EAMTables.EAM_ASSET.SERVICE_LIFE).form().numberInput().allowNegative(false).scale(2);
        cfg.view().field(EAMTables.EAM_ASSET.TAX_AMOUNT_RATE).form().numberInput().allowNegative(false).scale(2);
        cfg.view().field(EAMTables.EAM_ASSET.TAX_AMOUNT_PRICE).form().numberInput().allowNegative(false).scale(2);
        cfg.view().field(EAMTables.EAM_ASSET.ORIGINAL_UNIT_PRICE).form().numberInput().allowNegative(false).scale(2);
        cfg.view().field(EAMTables.EAM_ASSET.ACCUMULATED_DEPRECIATION).form().numberInput().allowNegative(false).scale(2);
        cfg.view().field(EAMTables.EAM_ASSET.RESIDUALS_RATE).form().numberInput().allowNegative(false).scale(2);
        cfg.view().field(EAMTables.EAM_ASSET.PURCHASE_UNIT_PRICE).form().numberInput().allowNegative(false).scale(2);


        cfg.view().field(EAMTables.EAM_ASSET.ASSET_NOTES).form().textArea().height(30);

        cfg.view().field(EAMTables.EAM_ASSET.FINANCIAL_NOTES).form().textArea().height(30);
        cfg.view().field(EAMTables.EAM_ASSET.MAINTENANCE_NOTES).form().textArea().height(30);


        cfg.view().field(EAMTables.EAM_ASSET.OWN_COMPANY_ID)
                .form().button().chooseCompany(true);
        cfg.view().field(EAMTables.EAM_ASSET.OWN_COMPANY_ID).table().fillBy("ownerCompany","fullName");

        cfg.view().field(EAMTables.EAM_ASSET.USE_ORGANIZATION_ID)
                .form().button().chooseOrganization(true);
        cfg.view().field(EAMTables.EAM_ASSET.USE_ORGANIZATION_ID).table().fillBy("useOrganization","fullName");


        cfg.view().field(EAMTables.EAM_ASSET.MANAGER_ID).table().fillBy("manager","name");
        cfg.view().field(EAMTables.EAM_ASSET.MANAGER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET.USE_USER_ID).table().fillBy("useUser","name");
        cfg.view().field(EAMTables.EAM_ASSET.USE_USER_ID).form()
                .button().chooseEmployee(true);

        cfg.view().field(EAMTables.EAM_ASSET.NAME)
                .basic().label("名称");

        cfg.view().field(EAMTables.EAM_ASSET.MODEL)
                .basic().label("规格型号");

        cfg.view().field(EAMTables.EAM_ASSET.UNIT)
                .basic().label("计量单位");

        cfg.view().field(EAMTables.EAM_ASSET.SERIAL_NUMBER)
                .basic().label("序列号");

        cfg.view().field(EAMTables.EAM_ASSET.PICTURE_ID)
                .form().label("图片").upload().buttonLabel("选择图片").acceptSingleImage().maxFileCount(1).displayFileName(false);

        cfg.view().field(EAMTables.EAM_ASSET.ATTACH)
                .form().label("附件").upload().buttonLabel("选择附件").acceptSingleImage().maxFileCount(1).displayFileName(false);

        cfg.view().list().operationColumn().addActionButton("变更","assetDataChange");

        //分成分组布局
        cfg.view().formWindow().width("98%");
//        cfg.view().form().addGroup(null,
//                new Object[] {
//                        EAMTables.EAM_ASSET.CATEGORY_ID,
//                        EAMTables.EAM_ASSET.NAME,
//                        EAMTables.EAM_ASSET.ASSET_CODE,
//                        EAMTables.EAM_ASSET.PURCHASE_DATE,
//                        EAMTables.EAM_ASSET.SERIAL_NUMBER,
//                        EAMTables.EAM_ASSET.SERVICE_LIFE,
//                }, new Object[] {
//                        EAMTables.EAM_ASSET.OWN_COMPANY_ID,
//                        EAMTables.EAM_ASSET.USE_ORGANIZATION_ID,
//                        EAMTables.EAM_ASSET.MANAGER_ID,
//                        EAMTables.EAM_ASSET.USE_USER_ID,
//                        EAMTables.EAM_ASSET.POSITION_ID,
//                        EAMTables.EAM_ASSET.POSITION_DETAIL,
//
//                }, new Object[] {
//                        EAMTables.EAM_ASSET.SOURCE_ID,
//                        EAMTables.EAM_ASSET.GOODS_ID,
//                        EAMTables.EAM_ASSET.MANUFACTURER_ID,
//                        EAMTables.EAM_ASSET.MODEL,
//                        EAMTables.EAM_ASSET.UNIT,
//                        EAMTables.EAM_ASSET.WAREHOUSE_ID,
//
//                }
//        );
//
//        cfg.view().form().addGroup(null,
//                new Object[] {
//                        EAMTables.EAM_ASSET.ASSET_NOTES,
//                },
//                new Object[] {
//
//                        EAMTables.EAM_ASSET.ATTACH,
//
//                },
//                new Object[] {
//                        EAMTables.EAM_ASSET.PICTURE_ID,
//                }
//
//        );

//        cfg.view().form().addTab(
//                new Tab("基本信息","loadBaseInfoIframe"),
//                new Tab("维保信息","loadMaintainerIframe"),
//                new Tab("财务信息","loadFinancialIframe")
//        );
//




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        //生成代码
        cfg.buildAll();

    }




    public static void main(String[] args) throws Exception {
        EamAssetsGtr g=new EamAssetsGtr();
        //生成代码
        g.generateCode();

        //生成菜单
        //g.removeByBatchId("");
        // g.generateMenu(AssetServiceProxy.class, AssetPageController.class);
    }


}
