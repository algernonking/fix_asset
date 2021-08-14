package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.EAMTables;


import com.dt.platform.constants.enums.datacenter.AreaTypeEnum;
import com.dt.platform.datacenter.page.AreaPageController;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class DcAreaGtr extends BaseCodeGenerator {
    public DcAreaGtr() {
        super(EAMTables.DC_AREA.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.DC_AREA.ID).basic().hidden(true);


        cfg.view().field(EAMTables.DC_AREA.CREATE_TIME).table().disable(true);


        cfg.view().field(EAMTables.DC_AREA.NAME).search().fuzzySearch();

        cfg.view().field(EAMTables.DC_AREA.POSITION).search().fuzzySearch();

        cfg.view().field(EAMTables.DC_AREA.NOTES).search().fuzzySearch();

        cfg.view().field(EAMTables.DC_AREA.TYPE).basic().label("类型")
              .form().validate().required().form().radioBox().enumType(AreaTypeEnum.class);


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DcAreaGtr g=new DcAreaGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        g.removeByBatchId("473608218912751616");
        //生成菜单
       g.generateMenu(AreaServiceProxy.class, AreaPageController.class);
    }
}
