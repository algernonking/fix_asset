package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.MaintainTaskProjectStatusEnum;
import com.dt.platform.domain.eam.ActionCrontab;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import com.dt.platform.eam.page.MaintainTaskProjectPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.MaintainTaskProjectServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class MaintainTaskProjectGtr extends BaseCodeGenerator {

    //583187884257837056 main

    //583208512239173632 setting
    public MaintainTaskProjectGtr() {
        super(EAMTables.EAM_MAINTAIN_TASK_PROJECT.$TABLE,"583187884257837056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_MAINTAIN_GROUP.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintainTypeDict","类型","类型");
       // cfg.getPoClassFile().addSimpleProperty(ActionCrontab.class,"actionCrontab","周期","周期");


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_CODE).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.STATUS,
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_MAINTAIN_TYPE,
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_CODE,
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.STATUS).form().selectBox().enumType(MaintainTaskProjectStatusEnum.class);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_MAINTAIN_TYPE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintain_type")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(MaintainProjectMeta.MAINTAIN_TYPE_DICT).muliti(false).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_BASE_COST).form().numberInput().defaultValue(0.0);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_ATTACH_ID).form().upload().acceptSingleFile().buttonLabel("保养手册");
  //      cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.NO).form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.START_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.END_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_NAME).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_CODE).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_NOTES).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_BASE_COST).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_ATTACH_ID).form().readOnly();
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_MAINTAIN_TYPE).form().readOnly();


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_ATTACH_ID).table().disable(true);
   //     cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.SELECTED_CODE).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK_PROJECT.TASK_ID).table().disable(true);




        cfg.view().list().disableBatchDelete();
        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().form().addGroup("保养项目",
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_NAME,
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_CODE,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_MAINTAIN_TYPE,
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_BASE_COST,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_ATTACH_ID,
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.PROJECT_NOTES,
                }
        );


        cfg.view().form().addGroup("项目信息",
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.START_TIME,
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.END_TIME,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK_PROJECT.BASE_COST,
                }
        );


    //    cfg.view().form().addPage("消耗材料","assetSelectList");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MaintainTaskProjectGtr g=new MaintainTaskProjectGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       //g.generateMenu(MaintainTaskProjectServiceProxy.class, MaintainTaskProjectPageController.class);
        //生成菜单

    }

}