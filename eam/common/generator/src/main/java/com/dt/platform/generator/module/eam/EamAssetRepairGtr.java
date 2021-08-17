package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.eam.meta.CategoryMeta;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.dt.platform.eam.page.AssetHandlePageController;
import com.dt.platform.eam.page.AssetRepairPageController;
import com.dt.platform.eam.page.PositionPageController;
import com.dt.platform.eam.service.IAssetHandleService;
import com.dt.platform.proxy.eam.AssetHandleServiceProxy;
import com.dt.platform.proxy.eam.AssetRepairServiceProxy;
import com.dt.platform.proxy.eam.CategoryServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetRepairGtr extends BaseCodeGenerator{
    public EamAssetRepairGtr() {
        super(EAMTables.EAM_ASSET_REPAIR.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {



        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.NOTES).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.TYPE)
                .form().validate().required()
                .form().selectBox().dict(DictEnum.EAM_REPAIR_TYPE);


        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_REPAIR.PICTURE_ID).form().upload().maxFileCount(6);
//
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_REPAIR.NAME,
                        EAMTables.EAM_ASSET_REPAIR.TYPE,
                        EAMTables.EAM_ASSET_REPAIR.BUSI_CODE,
                        EAMTables.EAM_ASSET_REPAIR.NOTES
                },
                new Object[]{
                        EAMTables.EAM_ASSET_REPAIR.CONTENT,
                        EAMTables.EAM_ASSET_REPAIR.REPAIR_DATE
                }

        );


        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_REPAIR.TYPE,
                        EAMTables.EAM_ASSET_REPAIR.NAME,
                        EAMTables.EAM_ASSET_REPAIR.REPAIR_DATE,


                }, new Object[] {
                        EAMTables.EAM_ASSET_REPAIR.OPERUSER_ID,
                        EAMTables.EAM_ASSET_REPAIR.BUSI_CODE,
                        EAMTables.EAM_ASSET_REPAIR.PROC_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_REPAIR.CONTENT,
                        EAMTables.EAM_ASSET_REPAIR.NOTES,
                        EAMTables.EAM_ASSET_REPAIR.PICTURE_ID,
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
        EamAssetRepairGtr g=new EamAssetRepairGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetRepairServiceProxy.class, AssetRepairPageController.class);
    }
}
