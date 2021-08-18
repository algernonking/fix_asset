package com.dt.platform.generator.module.kn;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.knowledgebase.KnowledgebaseContentTypeEnum;
import com.dt.platform.constants.enums.knowledgebase.KnowledgebaseDisplayEnum;
import com.dt.platform.domain.knowledgebase.Category;

import com.dt.platform.domain.knowledgebase.meta.CategoryMeta;
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;


import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.knowledgebase.page.ContentPageController;
import com.dt.platform.proxy.knowledgebase.CategoryServiceProxy;
import com.dt.platform.proxy.knowledgebase.ContentServiceProxy;

import com.github.foxnic.generator.config.WriteMode;

public class KnContentGtr extends BaseCodeGenerator {


    public KnContentGtr() {
        super(EAMTables.KN_CONTENT.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {

     //   cfg.getPoClassFile().addSimpleProperty(Grade.class,"grade","知识分级","知识分级");
        cfg.getPoClassFile().addSimpleProperty(Category.class,"category","知识分类","知识分类");



        cfg.view().field(EAMTables.KN_CONTENT.ID).basic().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.CATEGORY_ID).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.KEY_WORDS).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.LABEL).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.NOTES).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.GRADE_ID).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.LINK_ADDRESS).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.CONTENT).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.REVIEW_COUNT).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.ATTACH).search().hidden(true);
//
//        cfg.view().field(EAMTables.KN_CONTENT.DISPLAY).search().hidden(true);
//        cfg.view().field(EAMTables.KN_CONTENT.CONTENT_TYPE).search().hidden(true);


        cfg.view().field(EAMTables.KN_CONTENT.ATTACH).table().disable(true);

        cfg.view().field(EAMTables.KN_CONTENT.NOTES).table().disable(true);
        cfg.view().field(EAMTables.KN_CONTENT.PROFILE).table().disable(true);
        cfg.view().field(EAMTables.KN_CONTENT.LINK_ADDRESS).table().disable(true);
        cfg.view().field(EAMTables.KN_CONTENT.KEY_WORDS).table().disable(true);
        cfg.view().field(EAMTables.KN_CONTENT.LABEL).table().disable(true);


        cfg.view().field(EAMTables.KN_CONTENT.ATTACH)
                .form().upload().acceptExts("doc","zip","xlsx","rar","docx","txt","svg").maxFileCount(3);




        cfg.view().field(EAMTables.KN_CONTENT.GRADE_ID)
                .form().validate().required().form().selectBox().dict(DictEnum.KN_GRADE);


        cfg.view().field(EAMTables.KN_CONTENT.TITLE)
                .form().validate().required().form();



        cfg.view().field(EAMTables.KN_CONTENT.DISPLAY)
                .form().validate().required().form().radioBox().enumType(KnowledgebaseDisplayEnum.class);


        cfg.view().field(EAMTables.KN_CONTENT.CONTENT_TYPE)
                .form().validate().required().form().radioBox().enumType(KnowledgebaseContentTypeEnum.class);


        cfg.view().field(EAMTables.KN_CONTENT.CONTENT)
                .form().validate().required().form().textArea().height(450);


        cfg.view().field(EAMTables.KN_CONTENT.CATEGORY_ID)
                .form().validate().required().form()
                .selectBox().queryApi(CategoryServiceProxy.QUERY_LIST)
                .valueField(CategoryMeta.ID).textField(CategoryMeta.HIERARCHY_NAME)
                .paging(false).muliti(false).fillBy(ContentMeta.CATEGORY);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.KN_CONTENT.CATEGORY_ID,
                        EAMTables.KN_CONTENT.TITLE,
                        EAMTables.KN_CONTENT.GRADE_ID,
                        EAMTables.KN_CONTENT.DISPLAY
                },
                new Object[]{
                        EAMTables.KN_CONTENT.NOTES,
                        EAMTables.KN_CONTENT.CONTENT_TYPE,
                        EAMTables.KN_CONTENT.PROFILE
                }

        );



        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.KN_CONTENT.CATEGORY_ID,
                        EAMTables.KN_CONTENT.GRADE_ID,
                        EAMTables.KN_CONTENT.TITLE,
                        EAMTables.KN_CONTENT.PROFILE,
                        EAMTables.KN_CONTENT.KEY_WORDS,


                }, new Object[] {
                        EAMTables.KN_CONTENT.DISPLAY,
                        EAMTables.KN_CONTENT.CONTENT_TYPE,
                        EAMTables.KN_CONTENT.LINK_ADDRESS,
                        EAMTables.KN_CONTENT.LABEL

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.KN_CONTENT.NOTES
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.KN_CONTENT.ATTACH
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.KN_CONTENT.CONTENT
                }
        );

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
        KnContentGtr g=new KnContentGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
   //    g.removeByBatchId("478979243053678592");
        //生成菜单
     //   g.generateMenu(ContentServiceProxy.class, ContentPageController.class);
    }

}
