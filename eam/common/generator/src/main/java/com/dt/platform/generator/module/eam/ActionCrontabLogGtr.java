package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.eam.page.ActionCrontabLogPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.ActionCrontabLogServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class ActionCrontabLogGtr extends BaseCodeGenerator {


    public ActionCrontabLogGtr() {
        super(EAMTables.EAM_ACTION_CRONTAB_LOG.$TABLE,"583208716988317696");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB_LOG.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB_LOG.EXECUTION_RESULT).search().fuzzySearch();
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ACTION_CRONTAB_LOG.EXECUTION_RESULT,
                }
        );



        cfg.view().field(EAMTables.EAM_ACTION_CRONTAB_LOG.CRONTAB_ID).table().disable(true);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(220);
        cfg.view().form().addGroup(null,
                new Object[] {

                        EAMTables.EAM_ACTION_CRONTAB_LOG.EXECUTION_RESULT,
                        EAMTables.EAM_ACTION_CRONTAB_LOG.RECORD_TIME
                }
        );
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableModify();

        cfg.view().list().addJsVariable("OWNER_ID","[[${ownerId}]]","OWNER_ID");

        cfg.view().search().inputWidth(Config.searchInputWidth);
        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        ActionCrontabLogGtr g=new ActionCrontabLogGtr();
        //生成代码
       g.generateCode();
      // g.generateMenu(ActionCrontabLogServiceProxy.class, ActionCrontabLogPageController.class);

        //生成菜单

    }

}
