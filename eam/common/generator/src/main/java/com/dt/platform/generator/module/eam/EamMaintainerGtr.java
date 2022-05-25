package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class EamMaintainerGtr extends BaseCodeGenerator {

    public EamMaintainerGtr() {
        super(EAMTables.EAM_MAINTAINER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_MAINTAINER.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_MAINTAINER.MAINTAINER_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAINER.MAINTAINER_NAME).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_MAINTAINER.MAINTAINER_NAME,
                        EAMTables.EAM_MAINTAINER.UNIT_CODE

                }
        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth+60);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_MAINTAINER.MAINTAINER_NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_MAINTAINER.ADDRESS).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_MAINTAINER.MAINTAINER_NOTES).form().textArea().height(60);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAINER.MAINTAINER_NAME,
                        EAMTables.EAM_MAINTAINER.UNIT_CODE,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAINER.BUSINESS_CONTACTS,
                        EAMTables.EAM_MAINTAINER.BUSINESS_CONTACTS_INFO,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAINER.AFTER_SALES_CONTACTS,
                        EAMTables.EAM_MAINTAINER.AFTER_SALES_CONTACTS_INFO,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAINER.ADDRESS,
                        EAMTables.EAM_MAINTAINER.MAINTAINER_NOTES,
                }

        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamMaintainerGtr g=new EamMaintainerGtr();

        //生成代码
        g.generateCode();
        //生成菜单
//        g.generateMenu(MaintainerServiceProxy.class,MaintainerPageController.class);
    }

}
