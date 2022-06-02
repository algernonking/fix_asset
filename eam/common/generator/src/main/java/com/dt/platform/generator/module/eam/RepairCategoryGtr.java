package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.eam.page.RepairCategoryPageController;
import com.dt.platform.proxy.eam.RepairCategoryServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class RepairCategoryGtr extends BaseCodeGenerator {

    public RepairCategoryGtr() {
        super(EAMTables.EAM_REPAIR_CATEGORY.$TABLE,"583208716988317696");
    }

    public void generateCode() throws Exception {




        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY.REPAIR_NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY.REPAIR_CODE).form().validate().required();

        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY.NOTES).form().textArea().height(60);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(120);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_CATEGORY.REPAIR_NAME,
                        EAMTables.EAM_REPAIR_CATEGORY.REPAIR_CODE,
                        EAMTables.EAM_REPAIR_CATEGORY.SORT,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_CATEGORY.NOTES,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //IGNORE
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页; //列表HTML页; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        RepairCategoryGtr g=new RepairCategoryGtr();
        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(RepairCategoryServiceProxy.class, RepairCategoryPageController.class);
    }

}
