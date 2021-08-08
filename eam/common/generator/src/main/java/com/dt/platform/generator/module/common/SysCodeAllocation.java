package com.dt.platform.generator.module.common;

import com.dt.platform.common.page.CodeAllocationPageController;
import com.dt.platform.common.page.CodeAttrPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import com.dt.platform.domain.common.CodeAllocation;
import com.dt.platform.proxy.common.CodeAllocationServiceProxy;
import com.dt.platform.proxy.common.CodeAttrServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysCodeAllocation extends BaseCodeGenerator {

    public SysCodeAllocation() {
        super(EAMTables.SYS_CODE_ALLOCATION.$TABLE,BASIC_CODE_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.MODULE).search().fuzzySearch();
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.NOTES).search().fuzzySearch();


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
        SysCodeAllocation g=new SysCodeAllocation();

        //生成代码
        //g.generateCode();
        //生成菜单
        g.generateMenu(CodeAllocationServiceProxy.class, CodeAllocationPageController.class);
    }

}
