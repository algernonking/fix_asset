package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetEquipmentStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOwnerCodeEnum;

import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.eam.page.AssetDataPermissionsPageController;
import com.dt.platform.eam.service.impl.AssetDataPermissionsCatalogServiceImpl;

import com.dt.platform.eam.service.impl.AssetDataPermissionsOrgServiceImpl;

import com.dt.platform.eam.service.impl.AssetDataPermissionsPositionServiceImpl;
import com.dt.platform.generator.config.Config;
import com.dt.platform.ops.service.impl.HostDbServiceImpl;
import com.dt.platform.proxy.eam.AssetDataPermissionsServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.meta.CatalogMeta;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.system.meta.BusiRoleMeta;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.proxy.system.BusiRoleServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamAssetDataPermGtr extends BaseCodeGenerator{
    public EamAssetDataPermGtr() {
        super(EAMTables.EAM_ASSET_DATA_PERMISSIONS.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(BusiRole.class,"busiRole","业务角色","业务角色");

        cfg.getPoClassFile().addListProperty(Catalog.class,"category","资产分类","资产分类");
        cfg.getPoClassFile().addListProperty(String.class,"categoryIds","资产分类","资产分类");

        cfg.getPoClassFile().addListProperty(Organization.class,"organization","组织节点","组织节点");
        cfg.getPoClassFile().addListProperty(String.class,"organizationIds","组织节点","组织节点");

        cfg.getPoClassFile().addListProperty(Position.class,"position","存放位置","存放位置");
        cfg.getPoClassFile().addListProperty(String.class,"positionIds","存放位置","存放位置");

        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.CREATE_TIME).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ROLE_CODE).search();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.NAME,
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.CODE,
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.ROLE_CODE,
                }
        );


        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.OWNER_CODE).form()
                .validate().required().form().label("归属").selectBox().enumType(AssetOwnerCodeEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.CODE).form().validate().required().form().textInput();

        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ROLE_CODE).form().validate().required().form()
                .label("业务角色").selectBox().queryApi(BusiRoleServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(BusiRoleMeta.CODE).textField(BusiRoleMeta.NAME).fillWith(AssetDataPermissionsMeta.BUSI_ROLE).muliti(false);


        cfg.view().field(AssetDataPermissionsMeta.POSITION_IDS)
                .basic().label("存放位置")
                .table().sort(false)
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_PAGED_LIST)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME)
                .toolbar(false).paging(true).filter(true)
                .fillWith(AssetDataPermissionsMeta.POSITION).muliti(true);


        cfg.view().field(AssetDataPermissionsMeta.CATEGORY_IDS)
                .basic().label("资产分类")
                .form().selectBox().queryApi(CatalogServiceProxy.QUERY_LIST)
                .paging(false).filter(false).toolbar(false)
                .valueField(CatalogMeta.ID).textField(CatalogMeta.NAME)
                .fillWith(AssetDataPermissionsMeta.CATEGORY).muliti(true);


        cfg.view().field(AssetDataPermissionsMeta.ORGANIZATION_IDS).basic().label("组织架构")
                .form().button().chooseOrganization(false);

        cfg.view().field(AssetDataPermissionsMeta.ORGANIZATION_IDS).table().fillBy("organization","fullName");


        cfg.view().form().addJsVariable("ASSET_CATEGORY_DATA","[[${assetCategoryData}]]","资产分类数据");
        cfg.view().list().addJsVariable("CATEGORY_CODE","[[${categoryCode}]]","资产分类数据");


        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ORG_AUTHORITY_ENABLE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ORG_CASCADE_ENABLE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.ORG_LOCAL_ENABLE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.CATALOG_AUTHORITY_ENABLE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.CATALOG_CASCADE_ENABLE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.POSITION_AUTHORITY_ENABLE).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.STATUS).form().validate().required().form().radioBox().enumType(StatusEnableEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.PRIORITY).form().numberInput().integer().defaultValue(100);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS.NOTES).form().textArea().height(20);


        cfg.service().addRelationSaveAction(AssetDataPermissionsPositionServiceImpl.class,AssetDataPermissionsMeta.POSITION_IDS);
        cfg.service().addRelationSaveAction(AssetDataPermissionsCatalogServiceImpl.class,AssetDataPermissionsMeta.CATEGORY_IDS);
        cfg.service().addRelationSaveAction(AssetDataPermissionsOrgServiceImpl.class,AssetDataPermissionsMeta.ORGANIZATION_IDS);


        cfg.view().formWindow().bottomSpace(20);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.NAME,
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.STATUS,

                }, new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.OWNER_CODE,
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.ROLE_CODE
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.PRIORITY,
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.CODE
                }
        );

        cfg.view().form().addGroup("分类权限配置",
                new Object[] {
                        AssetDataPermissionsMeta.CATEGORY_IDS
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.CATALOG_AUTHORITY_ENABLE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.CATALOG_CASCADE_ENABLE,
                }

        );


        cfg.view().form().addGroup("组织权限配置",
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.ORG_AUTHORITY_ENABLE,
                        AssetDataPermissionsMeta.ORGANIZATION_IDS
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.ORG_CASCADE_ENABLE,
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.ORG_LOCAL_ENABLE
                }
        );



        cfg.view().form().addGroup("位置权限配置",
                 new Object[] {
                        AssetDataPermissionsMeta.POSITION_IDS
                },
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.POSITION_AUTHORITY_ENABLE,

                }

        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetDataPermGtr g=new EamAssetDataPermGtr();
        //生成代码
         g.generateCode();

       // g.generateMenu(AssetDataPermissionsServiceProxy.class, AssetDataPermissionsPageController.class);
        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(PositionServiceProxy.class, PositionPageController.class);
    }
}
