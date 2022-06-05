package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.generator.config.Config;
import com.github.foxnic.generator.config.WriteMode;

public class RepairRuleItemGtr extends BaseCodeGenerator {


    public RepairRuleItemGtr() {
        super(EAMTables.EAM_REPAIR_RULE_ITEM.$TABLE,BASIC_INSP);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_REPAIR_RULE_ITEM.ID).basic().hidden(true);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_RULE_ITEM.RULE_ID,
                }
        );

        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_RULE_ITEM.RULE_ID,
                }
        );

        cfg.view().list().disableBatchDelete();
        cfg.view().search().inputWidth(Config.searchInputWidth);

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
        RepairRuleItemGtr g=new RepairRuleItemGtr();
        //生成代码
        g.generateCode();

        // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
        //g.generateMenu(BrandServiceProxy.class, BrandPageController.class);
        //生成菜单

    }

}