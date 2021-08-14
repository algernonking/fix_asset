package com.dt.platform.generator.module.kn;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.knowledgebase.Category;
import com.dt.platform.domain.knowledgebase.Grade;
import com.dt.platform.domain.ops.HostPosition;
import com.dt.platform.domain.ops.InformationSystem;
import com.dt.platform.knowledgebase.page.GradePageController;
import com.dt.platform.proxy.knowledgebase.GradeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class KnGradeGtr extends BaseCodeGenerator {


    public KnGradeGtr() {
        super(EAMTables.KN_GRADE.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.KN_GRADE.ID).basic().hidden(true);

        cfg.view().field(EAMTables.KN_GRADE.CODE).search().hidden(true);

        cfg.view().field(EAMTables.KN_GRADE.CODE).form().numberInput();
        cfg.view().field(EAMTables.KN_GRADE.CODE)
                .form().numberInput().integer().step(1.0).range(0.0,20.0).allowNegative(false)
                .form().validate().required()

        ;


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
        KnGradeGtr g=new KnGradeGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
//        g.removeByBatchId("471622036347682816");
        //生成菜单
    //   g.generateMenu(GradeServiceProxy.class, GradePageController.class);
    }

}
