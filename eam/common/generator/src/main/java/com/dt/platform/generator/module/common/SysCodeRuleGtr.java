package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.generator.config.WriteMode;

public class SysCodeRuleGtr extends BaseCodeGenerator {

    public SysCodeRuleGtr() {
        super(EAMTables.SYS_CODE_RULE.$TABLE,BASIC_CODE_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.SYS_CODE_RULE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.SYS_CODE_RULE.NAME).search().fuzzySearch();


        cfg.view().field(EAMTables.SYS_CODE_RULE.NOTES).search().hidden();
        cfg.view().field(EAMTables.SYS_CODE_RULE.RULE).search().hidden();
        cfg.view().field(EAMTables.SYS_CODE_RULE.MODULE).search().hidden();



        cfg.view().field(EAMTables.SYS_CODE_RULE.CREATE_TIME).table().hidden(true);

        cfg.view().field(EAMTables.SYS_CODE_RULE.NAME).form().validate().required();


        cfg.view().field(EAMTables.SYS_CODE_RULE.MODULE).basic().label("业务模块")
                .form().validate().required().form().selectBox()
                .enumType(CodeModuleEnum.class).form().selectBox().paging(false).muliti(false);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.SYS_CODE_RULE.NAME,
                        EAMTables.SYS_CODE_RULE.MODULE,
                        EAMTables.SYS_CODE_RULE.NOTES,
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
        SysCodeRuleGtr g=new SysCodeRuleGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(CodeRuleServiceProxy.class, CodeRulePageController.class);
    }

}
