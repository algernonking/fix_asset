package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.ActionCrontab;
import com.dt.platform.domain.eam.MaintainProject;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import com.dt.platform.domain.eam.meta.MaintainGroupMeta;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import com.dt.platform.eam.page.MaintainGroupPageController;
import com.dt.platform.eam.page.MaintainProjectPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.MaintainGroupServiceProxy;
import com.dt.platform.proxy.eam.MaintainProjectServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class MaintainProjectGtr extends BaseCodeGenerator {

    //583187884257837056 main

    //583208512239173632 setting
    public MaintainProjectGtr() {
        super(EAMTables.EAM_MAINTAIN_PROJECT.$TABLE,"583208512239173632");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_MAINTAIN_GROUP.ID).basic().hidden(true);

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"maintainTypeDict","类型","类型");
        cfg.getPoClassFile().addSimpleProperty(ActionCrontab.class,"actionCrontab","周期","周期");


        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_MAINTAIN_PROJECT.STATUS,
                        EAMTables.EAM_MAINTAIN_PROJECT.MAINTAIN_TYPE,
                        EAMTables.EAM_MAINTAIN_PROJECT.CODE,
                        EAMTables.EAM_MAINTAIN_PROJECT.NAME,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);


        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.NAME).form().validate().required();




        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.MAINTAIN_TYPE)
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintain_type")
                .paging(false).filter(true).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(MaintainProjectMeta.MAINTAIN_TYPE_DICT).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.BASE_COSE).form().validate().required();
        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.ACTION_CYCLE_ID).form().validate().required().form().readOnly();

        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.ACTION_CYCLE_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.ATTACH_ID).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.NOTES).table().disable(true);
        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.SELECTED_CODE).table().disable(true);

        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.ATTACH_ID).form().upload().acceptSingleFile().buttonLabel("保养手册");


        cfg.view().field(EAMTables.EAM_MAINTAIN_PROJECT.NOTES).form().textArea().height(60);

        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAIN_PROJECT.CODE,
                        EAMTables.EAM_MAINTAIN_PROJECT.NAME,
                        EAMTables.EAM_MAINTAIN_PROJECT.STATUS,
                },
                new Object[] {
                        EAMTables.EAM_MAINTAIN_PROJECT.MAINTAIN_TYPE,
                        EAMTables.EAM_MAINTAIN_PROJECT.ACTION_CYCLE_ID,
                        EAMTables.EAM_MAINTAIN_PROJECT.BASE_COSE,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAIN_PROJECT.NOTES,
                        EAMTables.EAM_MAINTAIN_PROJECT.ATTACH_ID,
                }
        );

    //    cfg.view().form().addPage("消耗材料","assetSelectList");



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MaintainProjectGtr g=new MaintainProjectGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     //   g.generateMenu(MaintainProjectServiceProxy.class, MaintainProjectPageController.class);
        //生成菜单

    }

}