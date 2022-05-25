package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetDataPermissions;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.pcm.Catalog;

public class EamAssetDataPermCataGtr extends BaseCodeGenerator{
    public EamAssetDataPermCataGtr() {
        super(EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.ID,
                }
        );

        cfg.setRelationField(AssetDataPermissions.class,EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.PERMISSION_ID, Catalog.class, EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.VALUE,true);


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().field(EAMTables.EAM_ASSET_DATA_PERMISSIONS_CATALOG.ID).form().validate().required();

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetDataPermCataGtr g=new EamAssetDataPermCataGtr();
        //生成代码
         g.generateCode();

    }
}
