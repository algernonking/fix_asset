package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.CodeRulePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.CodeRuleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class CodeRuleGtr extends BaseCodeGenerator{
    public CodeRuleGtr() {
        super(EAMTables.EAM_CODE_RULE.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.view().field(EAMTables.EAM_CODE_RULE.ID).basic().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_CODE_RULE.ID,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_CODE_RULE.NUMBER_SEQ).form().numberInput().defaultValue(3.0).allowNegative(false).scale(1);
        cfg.view().field(EAMTables.EAM_CODE_RULE.VALUE).form().readOnly();

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);

        cfg.view().field(EAMTables.EAM_CODE_RULE.NAME).table().disable(true);
        cfg.view().field(EAMTables.EAM_CODE_RULE.PART_IDS).table().disable(true);

        cfg.view().form().addJsVariable("CODE_PARTS","[[${codeParts}]]","codeParts");

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_CODE_RULE.VALUE,
                        EAMTables.EAM_CODE_RULE.FS1,
                        EAMTables.EAM_CODE_RULE.CODE_SEPARATOR,
                        EAMTables.EAM_CODE_RULE.NUMBER_SEQ,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        CodeRuleGtr g=new CodeRuleGtr();
        //生成代码
         g.generateCode();

        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(CodeRuleServiceProxy.class, CodeRulePageController.class);
    }
}
