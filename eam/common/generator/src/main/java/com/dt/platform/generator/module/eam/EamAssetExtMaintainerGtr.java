package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetExtMaintainerGtr extends BaseCodeGenerator {

    public EamAssetExtMaintainerGtr() {
        super(EAMTables.EAM_ASSET_EXT_MAINTAINER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetExtMaintainerGtr g=new EamAssetExtMaintainerGtr();

        //生成代码
        g.generateCode();

    }

}
