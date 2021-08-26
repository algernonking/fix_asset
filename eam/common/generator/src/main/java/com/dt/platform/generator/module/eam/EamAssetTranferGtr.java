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
import com.dt.platform.proxy.eam.AssetTranferServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetTranferGtr extends BaseCodeGenerator {

    public EamAssetTranferGtr() {
        super(EAMTables.EAM_ASSET_TRANFER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");

        cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetTranferVOMeta.ASSET_IDS);

        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","位置","位置");
        cfg.getPoClassFile().addSimpleProperty(Person.class,"originator","制单人","制单人");


        cfg.getPoClassFile().addSimpleProperty(Person.class,"manager","调入管理员","调入管理员");

        cfg.getPoClassFile().addSimpleProperty(Person.class,"useUser","使用人","使用人");



        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.BUSINESS_DATE).search().range();


        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.NAME).table().disable();


        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).form().form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.CONTENT).form().textArea().height(30).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_TRANFER.STATUS,
                        EAMTables.EAM_ASSET_TRANFER.MANAGER_ID,
                        EAMTables.EAM_ASSET_TRANFER.BUSINESS_DATE
                },
                new Object[]{
                        EAMTables.EAM_ASSET_TRANFER.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.CONTENT,

                }
        );

        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.POSITION_ID)
                .basic().label("存放位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME).fillBy(AssetCollectionMeta.POSITION).muliti(false);


        //分成分组布局
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.OUT_USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.USE_USER_ID,

                }, new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.IN_USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.MANAGER_ID,
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

        cfg.view().form().addJsVariable("PERSON_ID",   "[[${user.getUser().getPerson().getId()}]]","用户ID");
        cfg.view().form().addJsVariable("PERSON_NAME", "[[${user.getUser().getPerson().getName()}]]","用户姓名");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
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
