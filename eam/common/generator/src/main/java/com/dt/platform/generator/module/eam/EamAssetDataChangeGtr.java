package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetDataChange;
import com.dt.platform.eam.page.AssetDataChangePageController;
import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetDataChangeGtr extends BaseCodeGenerator{

    public EamAssetDataChangeGtr() {
        super(EAMTables.EAM_ASSET_DATA_CHANGE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_DATA_CHANGE.ID,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetDataChangeGtr g=new EamAssetDataChangeGtr();

        g.generateCode();

        //生成菜单
       // g.generateMenu(AssetDataChangeServiceProxy.class, AssetDataChangePageController.class);
    }
}
