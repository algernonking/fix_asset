package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.meta.MenuMeta;
import org.github.foxnic.web.proxy.oauth.MenuServiceProxy;

public class SysCodeRuleGtr extends BaseCodeGenerator {

    public SysCodeRuleGtr() {
        super(EAMTables.SYS_CODE_RULE.$TABLE,BASIC_CODE_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Menu.class,"module","关联模块","关联模块");
        cfg.view().field(EAMTables.SYS_CODE_RULE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.SYS_CODE_RULE.NAME).search().fuzzySearch();


        cfg.view().field(EAMTables.SYS_CODE_RULE.NOTES).search().hidden();
        cfg.view().field(EAMTables.SYS_CODE_RULE.RULE).search().hidden();
        cfg.view().field(EAMTables.SYS_CODE_RULE.MODULE_ID).search().hidden();



        cfg.view().field(EAMTables.SYS_CODE_RULE.CREATE_TIME).table().hidden(true);

        cfg.view().field(EAMTables.SYS_CODE_RULE.NAME).form().validate().required();


        cfg.view().field(EAMTables.SYS_CODE_RULE.MODULE_ID)
                .basic().label("模块")
                .form().validate().required()
                .form().selectBox().queryApi(MenuServiceProxy.QUERY_LIST+"?parentId=0").paging(false).filter(true).toolbar(false)
                .valueField(MenuMeta.ID).textField(MenuMeta.LABEL).fillBy(CodeRuleMeta.MODULE).muliti(false);




        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.SYS_CODE_RULE.NAME,
                        EAMTables.SYS_CODE_RULE.MODULE_ID,
                        EAMTables.SYS_CODE_RULE.NOTES,
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.SYS_CODE_RULE.NAME,
                        EAMTables.SYS_CODE_RULE.MODULE_ID,
                        EAMTables.SYS_CODE_RULE.RULE,
                        EAMTables.SYS_CODE_RULE.NOTES,


                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE).setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
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
