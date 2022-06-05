package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.ActionCrontab;
import com.dt.platform.eam.page.MaintainTaskPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.MaintainTaskServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;

public class MaintainTaskGtr extends BaseCodeGenerator {

    //583187884257837056 main

    //583208512239173632 setting
    public MaintainTaskGtr() {
        super(EAMTables.EAM_MAINTAIN_TASK.$TABLE,"583187884257837056");
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.ID).basic().hidden(true);



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_MAINTAIN_TASK.STATUS,

                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);


        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_MAINTAIN_TASK.NAME).form().validate().required();


//
//        cfg.view().field(EAMTables.EAM_MAINTAIN_PLAN.MAINTAIN_TYPE)
//                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_maintain_type")
//                .paging(false).filter(true).toolbar(false)
//                .valueField(DictItemMeta.CODE).
//                textField(DictItemMeta.LABEL).
//                fillWith(MaintainPlanMeta.MAINTAIN_TYPE_DICT).muliti(false).defaultIndex(0);





        cfg.view().search().inputWidth(Config.searchInputWidth);
        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(80);

        cfg.view().form().addGroup(null,
                new Object[] {

                        EAMTables.EAM_MAINTAIN_TASK.NAME,
                        EAMTables.EAM_MAINTAIN_TASK.STATUS,
                },
                new Object[] {


                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_MAINTAIN_TASK.NOTES,

                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        MaintainTaskGtr g=new MaintainTaskGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
       // g.generateMenu(MaintainTaskServiceProxy.class, MaintainTaskPageController.class);
        //生成菜单

    }

}