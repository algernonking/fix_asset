package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.domain.eam.TplFile;
import com.dt.platform.eam.page.TplFilePageController;
import com.dt.platform.proxy.eam.TplFileServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamTplFileGtr extends BaseCodeGenerator{
    public EamTplFileGtr() {
        super(EAMTables.EAM_TPL_FILE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_TPL_FILE.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_TPL_FILE.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_TPL_FILE.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_TPL_FILE.NAME,
                        EAMTables.EAM_TPL_FILE.NOTES,
                }
        );


        cfg.view().field(EAMTables.EAM_TPL_FILE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_TPL_FILE.FILE_ID).form().validate().required().form().upload().maxFileCount(1);
        cfg.view().field(EAMTables.EAM_TPL_FILE.NOTES).form().textArea().height(30);


        cfg.view().field(EAMTables.EAM_TPL_FILE.CODE).form().validate().required().
                form().selectBox().enumType(CodeModuleEnum.class).muliti(false).filter(true).toolbar(false).paging(false);

        //分成分组布局
        cfg.view().formWindow().width("80%");
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_TPL_FILE.NAME,
                }, new Object[] {
                        EAMTables.EAM_TPL_FILE.CODE
                }, new Object[] {
                        EAMTables.EAM_TPL_FILE.FILE_ID

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_TPL_FILE.NOTES
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
        EamTplFileGtr g=new EamTplFileGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(TplFileServiceProxy.class, TplFilePageController.class);
    }


}
