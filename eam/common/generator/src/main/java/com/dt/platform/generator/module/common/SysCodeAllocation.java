package com.dt.platform.generator.module.common;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.domain.common.CodeRule;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.proxy.common.CodeRuleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class SysCodeAllocation extends BaseCodeGenerator {

    public SysCodeAllocation() {
        super(EAMTables.SYS_CODE_ALLOCATION.$TABLE,BASIC_CODE_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.getPoClassFile().addSimpleProperty(CodeRule.class,"rule","编码规则","编码规则");


        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.RULE_ID).search().hidden(true);
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.MODULE).search().hidden();


        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.RULE_ID).search().hidden();



        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.RULE_ID)
                .basic().label("编码规则").search().hidden()
                .form().validate().required()
                .form().selectBox().queryApi(CodeRuleServiceProxy.QUERY_PAGED_LIST).paging(false).filter(false).toolbar(false)
                .valueField(CodeRuleMeta.ID).textField(CodeRuleMeta.NAME).fillBy(CodeAllocationMeta.RULE).muliti(false);




        cfg.view().field(EAMTables.SYS_CODE_ALLOCATION.MODULE).basic().label("业务模块")
                .form().validate().required().form().selectBox().paging(false).muliti(false).filter(false).toolbar(false)
                .enumType(CodeModuleEnum.class);




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
        g.generateCode();
        //生成菜单
        //g.generateMenu(CodeAllocationServiceProxy.class, CodeAllocationPageController.class);
    }

}
