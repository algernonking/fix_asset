package com.dt.platform.generator.module.common;

import com.dt.platform.constants.db.SysTables;
import com.dt.platform.constants.enums.common.LicenceTypeEnum;
import com.dt.platform.constants.enums.common.LicenceStatusEnum;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class SysLicenceGtr extends BaseCodeGenerator{
    public SysLicenceGtr() {
        super(SysTables.SYS_LICENCE_SWITCH.$TABLE,SE);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.view().field(SysTables.SYS_LICENCE_SWITCH.ID).basic().hidden(true);
        cfg.view().field(SysTables.SYS_LICENCE_SWITCH.NOTES).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        SysTables.SYS_LICENCE_SWITCH.NOTES,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(SysTables.SYS_LICENCE_SWITCH.STATUS).form().validate().required().form().selectBox().enumType( LicenceStatusEnum.class);
        cfg.view().field(SysTables.SYS_LICENCE_SWITCH.LICENCE_TAB).form().validate().required().form().selectBox().enumType( LicenceTypeEnum.class);

        cfg.view().field(SysTables.SYS_LICENCE_SWITCH.ACTION_CONTENT).form().textArea().height(100);
        cfg.view().field(SysTables.SYS_LICENCE_SWITCH.NOTES).form().textArea().height(60);
        cfg.view().list().disableBatchDelete();

        cfg.view().list().operationColumn().addActionButton("激活","licenceSwitchEnable","licence-switch-button","licence-switch:enable");




        //分成分组布局
        cfg.view().formWindow().width("80%");
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        SysTables.SYS_LICENCE_SWITCH.LICENCE_TAB,
                        SysTables.SYS_LICENCE_SWITCH.STATUS,
                        SysTables.SYS_LICENCE_SWITCH.ACTION_CONTENT,
                        SysTables.SYS_LICENCE_SWITCH.NOTES,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        SysLicenceGtr g=new SysLicenceGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(LicenceSwitchServiceProxy.class, LicenceSwitchPageController.class);
    }


}
