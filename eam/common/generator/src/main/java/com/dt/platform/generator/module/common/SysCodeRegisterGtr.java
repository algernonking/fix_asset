package com.dt.platform.generator.module.common;


import com.dt.platform.common.page.CodeRegisterPageController;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.common.CodeTypeEnum;
import com.dt.platform.domain.common.CodeRule;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRegisterMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.CodeRegisterServiceProxy;
import com.dt.platform.proxy.common.CodeRuleServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class SysCodeRegisterGtr extends BaseCodeGenerator {

    public SysCodeRegisterGtr() {
        super(EAMTables.SYS_CODE_REGISTER.$TABLE,BASIC_CODE_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

//        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"businessType","分类","分类");


        cfg.view().field(EAMTables.SYS_CODE_REGISTER.ID).basic().hidden();
        cfg.view().field(EAMTables.SYS_CODE_REGISTER.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.SYS_CODE_REGISTER.NAME).search().fuzzySearch();




        cfg.view().field(EAMTables.SYS_CODE_REGISTER.CODE).basic().label("业务编码")
                .form().validate().required() ;


        cfg.view().field(EAMTables.SYS_CODE_REGISTER.NAME).basic().label("业务名称")
                .form().validate().required() ;

        cfg.view().field(EAMTables.SYS_CODE_REGISTER.TYPE)
                .form().validate().required()
                .form().selectBox().enumType(CodeTypeEnum.class);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.SYS_CODE_REGISTER.TYPE,
                        EAMTables.SYS_CODE_REGISTER.NAME,
                        EAMTables.SYS_CODE_REGISTER.CODE,
                        EAMTables.SYS_CODE_REGISTER.NOTES,
                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().formWindow().bottomSpace(80);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.SYS_CODE_REGISTER.TYPE,
                        EAMTables.SYS_CODE_REGISTER.CODE,
                },
                new Object[]{
                        EAMTables.SYS_CODE_REGISTER.NAME,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{

                        EAMTables.SYS_CODE_REGISTER.NOTES
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
        SysCodeRegisterGtr g=new SysCodeRegisterGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(CodeRegisterServiceProxy.class, CodeRegisterPageController.class);
    }

}
