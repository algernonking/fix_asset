package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.eam.page.AssetTranferPageController;
import com.dt.platform.proxy.eam.AssetTranferServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetTranferGtr extends BaseCodeGenerator {

    public EamAssetTranferGtr() {
        super(EAMTables.EAM_ASSET_TRANFER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


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
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.OUT_USER_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.IN_USER_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.MANAGER_ID).form().form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_TRANFER.CONTENT).form().textArea().height(30);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_TRANFER.STATUS,
                        EAMTables.EAM_ASSET_TRANFER.CONTENT,
                        EAMTables.EAM_ASSET_TRANFER.BUSINESS_DATE
                },
                new Object[]{
                        EAMTables.EAM_ASSET_TRANFER.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_TRANFER.OUT_USER_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.IN_USER_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_TRANFER.MANAGER_ID
                }
        );

        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.MANAGER_ID,
                }, new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.OUT_USER_ORGANIZATION_ID
                }, new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.IN_USER_ORGANIZATION_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_TRANFER.CONTENT,
                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
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
