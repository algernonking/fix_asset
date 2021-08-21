package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.meta.AssetCollectionReturnVOMeta;
import com.dt.platform.domain.eam.meta.AssetHandleVOMeta;
import com.dt.platform.eam.page.AssetHandlePageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.proxy.eam.AssetHandleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetHandleGtr extends BaseCodeGenerator{
    public EamAssetHandleGtr() {
        super(EAMTables.EAM_ASSET_HANDLE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetHandleVOMeta.ASSET_IDS);


        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NOTES).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.TYPE)
                .form().validate().required()
                .form().selectBox().dict(DictEnum.EAM_HANDLE_TYPE);
        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_HANDLE.PICTURE_ID).form().upload().maxFileCount(6);

            cfg.view().search().inputLayout(
                    new Object[]{
                            EAMTables.EAM_ASSET_HANDLE.NAME,
                            EAMTables.EAM_ASSET_HANDLE.TYPE,
                            EAMTables.EAM_ASSET_HANDLE.BUSINESS_CODE,
                            EAMTables.EAM_ASSET_HANDLE.NOTES
                    },
                    new Object[]{
                            EAMTables.EAM_ASSET_HANDLE.CONTENT,
                            EAMTables.EAM_ASSET_HANDLE.HANDLE_DATE
                    }

            );


        cfg.view().formWindow().width("1000px");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_HANDLE.TYPE,
                        EAMTables.EAM_ASSET_HANDLE.NAME,
                        EAMTables.EAM_ASSET_HANDLE.HANDLE_DATE,


                }, new Object[] {
                        EAMTables.EAM_ASSET_HANDLE.ORIGINATOR_ID,
                        EAMTables.EAM_ASSET_HANDLE.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_HANDLE.PROC_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_HANDLE.CONTENT,
                        EAMTables.EAM_ASSET_HANDLE.NOTES,
                        EAMTables.EAM_ASSET_HANDLE.PICTURE_ID,
                }

        );





//
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
        EamAssetHandleGtr g=new EamAssetHandleGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       //  g.generateMenu(AssetHandleServiceProxy.class, AssetHandlePageController.class);
    }
}
