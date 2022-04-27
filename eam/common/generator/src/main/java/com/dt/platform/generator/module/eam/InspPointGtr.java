package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.eam.page.InspectionPointPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.InspectionPointServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class InspPointGtr extends BaseCodeGenerator {


    public InspPointGtr() {
        super(EAMTables.EAM_INSPECTION_POINT.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INSPECTION_POINT.STATUS,
                        EAMTables.EAM_INSPECTION_POINT.CODE,
                        EAMTables.EAM_INSPECTION_POINT.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS_LATITUDE).form().numberInput().defaultValue(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.POS_LONGITUDE).form().numberInput().defaultValue(0);

        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.CONTENT).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_INSPECTION_POINT.PICTURE_ID)
                .form().label("附件").upload().acceptSingleFile().maxFileCount(1).displayFileName(false);


        cfg.view().formWindow().width("85%");

        cfg.view().list().disableBatchDelete();
        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.STATUS,
                        EAMTables.EAM_INSPECTION_POINT.NAME,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.CODE,
                        EAMTables.EAM_INSPECTION_POINT.POS,
                },
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.POS_LONGITUDE,
                        EAMTables.EAM_INSPECTION_POINT.POS_LATITUDE,

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INSPECTION_POINT.CONTENT,
                        EAMTables.EAM_INSPECTION_POINT.NOTES,
                        EAMTables.EAM_INSPECTION_POINT.PICTURE_ID,

                }
        );



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        InspPointGtr g=new InspPointGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       //g.generateMenu(InspectionPointServiceProxy.class, InspectionPointPageController.class);
        //生成菜单

    }

}
