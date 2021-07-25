package com.dt.eam.generator.module.eam;

import com.dt.eam.constants.db.EAMTables;
import com.github.foxnic.generator.config.WriteMode;

public class EamSafetylevel  extends BaseCodeGenerator{

    public EamSafetylevel() {
        super(EAMTables.EAM_SAFETYLEVEL.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
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
        EamSafetylevel g=new EamSafetylevel();
        //生成代码
        g.generateCode();
        //生成菜单
//        g.generateMenu(SafetylevelServiceProxy.class, SafetylevelPageController.class);
    }
}
