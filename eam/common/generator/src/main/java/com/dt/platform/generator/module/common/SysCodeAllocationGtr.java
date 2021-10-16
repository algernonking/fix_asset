package com.dt.platform.generator.module.common;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.domain.common.CodeRegister;
import com.dt.platform.domain.common.CodeRule;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRegisterMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.CodeRegisterServiceProxy;
import com.dt.platform.proxy.common.CodeRuleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysCodeAllocationGtr extends BaseCodeGenerator {

    public SysCodeAllocationGtr() {
        super(EAMTables.SYS_CODE_ALLOCATION.$TABLE,BASIC_CODE_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(CodeRule.class,"rule","编码规则","编码规则");

        cfg.getPoClassFile().addSimpleProperty(CodeRegister.class,"businessCode","业务编码","业务编码");

        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.ID).basic().hidden();
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.RULE_ID).search().hidden();
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.CODE).search().hidden();
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.RULE_ID).search().hidden();


        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.CREATE_TIME).table().disable();


        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.CODE).basic().label("业务编码")
                .form().validate().required().form().selectBox().paging(true).filter(true).toolbar(false).muliti(false)
                .queryApi(CodeRegisterServiceProxy.QUERY_PAGED_LIST)
                .textField(CodeRegisterMeta.NAME).valueField(CodeRegisterMeta.CODE).fillWith(CodeAllocationMeta.BUSINESS_CODE);





        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.RULE_ID)
                .basic().label("编码规则")
                .form().validate().required()
                .form().selectBox().queryApi(CodeRuleServiceProxy.QUERY_PAGED_LIST).paging(true).filter(true).toolbar(false)
                .valueField(CodeRuleMeta.ID).textField(CodeRuleMeta.NAME).fillWith(CodeAllocationMeta.RULE).muliti(false);



        //指定关联对象的属性填充单元格，为了避免名称重复，加一个前缀
        //改变前端,EAMTables.SYS_CODE_RULE.RULE 在前端显示
        String resourceNameField="res_"+EAMTables.SYS_CODE_RULE.RULE;
        cfg.view().field(resourceNameField)
                .basic().label("规则详情")
                .table().fillBy(CodeAllocationMeta.RULE,CodeRuleMeta.RULE);

//        String resourceNameField2="res_"+EAMTables.SYS_CODE_RULE.MODULE_ID;
//        cfg.view().field(resourceNameField2)
//                .basic().label("模块")
//                .table().fillBy(CodeAllocationMeta.RULE,CodeRuleMeta.MODULE);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.SYS_CODE_ALLOCATION.CODE,
                        EAMTables.SYS_CODE_ALLOCATION.RULE_ID,
                        EAMTables.SYS_CODE_ALLOCATION.NOTES,
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.SYS_CODE_ALLOCATION.CODE,
                        EAMTables.SYS_CODE_ALLOCATION.RULE_ID,
                        EAMTables.SYS_CODE_ALLOCATION.NOTES
                }

        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        SysCodeAllocationGtr g=new SysCodeAllocationGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(CodeAllocationServiceProxy.class, CodeAllocationPageController.class);
    }

}
