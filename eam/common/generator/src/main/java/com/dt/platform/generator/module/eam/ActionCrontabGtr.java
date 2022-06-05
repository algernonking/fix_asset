package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.ActionCrontabLog;
import com.dt.platform.eam.page.ActionCrontabPageController;
import com.dt.platform.eam.page.BrandPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.ActionCrontabServiceProxy;
import com.dt.platform.proxy.eam.BrandServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.pcm.Catalog;

public class ActionCrontabGtr extends BaseCodeGenerator {


    public ActionCrontabGtr() {
        super(EAMTables.EAM_ACTION_CRONTAB.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(ActionCrontabLog.class,"actionCrontabLog","日志","日志");

        //         cfg.view().field(EAMTables.EAM_INSPECTION_PLAN.LAST_EXECUTION_TIME).table().disable(true);
        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB.OWNER_ID).table().disable(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ACTION_CRONTAB.NAME,
                        EAMTables.EAM_ACTION_CRONTAB.CRONTAB,
                }
        );
        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB.CRONTAB).form().validate().required().form().readOnly();
        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB.NOTES).form().textArea().height(80);
        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB.START_EXECUTION_TIME).form().validate().required().form().dateInput().defaultNow().format("yyyy-MM-dd").search().range();
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(220);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ACTION_CRONTAB.NAME,
                        EAMTables.EAM_ACTION_CRONTAB.CRONTAB,
                },
                new Object[] {
                        EAMTables.EAM_ACTION_CRONTAB.START_EXECUTION_TIME,
                        EAMTables.EAM_ACTION_CRONTAB.FINISH_EXECUTION_TIME,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ACTION_CRONTAB.NOTES
                }
        );

        cfg.view().form().addJsVariable("OWNER_ID","[[${ownerId}]]","OWNER_ID");

        cfg.view().search().inputWidth(Config.searchInputWidth);
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        ActionCrontabGtr g=new ActionCrontabGtr();
        //生成代码
       g.generateCode();
     //  g.generateMenu(ActionCrontabServiceProxy.class, ActionCrontabPageController.class);

        //生成菜单

    }

}
