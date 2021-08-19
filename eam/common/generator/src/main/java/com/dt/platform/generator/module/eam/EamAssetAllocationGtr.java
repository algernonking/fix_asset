package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetAllocation;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.eam.page.AssetAllocationPageController;
import com.dt.platform.proxy.eam.AssetAllocationServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetAllocationGtr extends BaseCodeGenerator {

    public EamAssetAllocationGtr() {
        super(EAMTables.EAM_ASSET_ALLOCATION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");


        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE).search().range();



        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.NAME).table().disable();


        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.OUT_MANAGEMENT_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.IN_MANAGEMENT_ORGANIZATION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_ALLOCATION.CONTENT).form().textArea().height(30);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_ALLOCATION.STATUS,
                        EAMTables.EAM_ASSET_ALLOCATION.CONTENT,
                        EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_DATE
                },
                new Object[]{
                        EAMTables.EAM_ASSET_ALLOCATION.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_ALLOCATION.IN_MANAGEMENT_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_ALLOCATION.OUT_MANAGEMENT_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID
                }
        );

        //分成分组布局
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.MANAGER_ID,
                }, new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.OUT_MANAGEMENT_ORGANIZATION_ID
                }, new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.IN_MANAGEMENT_ORGANIZATION_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_ALLOCATION.CONTENT,
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
        EamAssetAllocationGtr g=new EamAssetAllocationGtr();

        //生成代码
        g.generateCode();
        //生成菜单
      //  g.generateMenu(AssetAllocationServiceProxy.class, AssetAllocationPageController.class);
    }

}
