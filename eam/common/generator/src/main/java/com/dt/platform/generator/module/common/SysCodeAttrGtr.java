package com.dt.platform.generator.module.common;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import com.github.foxnic.generator.config.WriteMode;

public class SysCodeAttrGtr extends BaseCodeGenerator {

    public SysCodeAttrGtr() {
        super(EAMTables.SYS_CODE_ATTR.$TABLE,BASIC_CODE_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.SYS_CODE_ATTR.ID).basic().hidden(true);

        cfg.view().field(EAMTables.SYS_CODE_ATTR.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.SYS_CODE_ATTR.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.SYS_CODE_ATTR.CODE).search().hidden();
        cfg.view().field(EAMTables.SYS_CODE_ATTR.SORT).
                search().hidden();



        cfg.view().field(EAMTables.SYS_CODE_ATTR.TYPE).basic().label("属性类型")
                .form().validate().required().form().radioBox().enumType(CodeAttrTypeEnum.class);


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
        SysCodeAttrGtr g=new SysCodeAttrGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(CodeAttrServiceProxy.class, CodeAttrPageController.class);
    }

}
