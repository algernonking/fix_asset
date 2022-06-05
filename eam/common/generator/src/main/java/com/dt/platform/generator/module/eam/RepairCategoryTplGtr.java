package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.eam.RepairCategory;
import com.dt.platform.domain.eam.RepairCategoryTpl;
import com.dt.platform.domain.eam.meta.RepairCategoryMeta;
import com.dt.platform.domain.eam.meta.RepairCategoryTplMeta;
import com.dt.platform.eam.page.RepairCategoryTplPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.RepairCategoryServiceProxy;
import com.dt.platform.proxy.eam.RepairCategoryTplServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class RepairCategoryTplGtr extends BaseCodeGenerator {

    public RepairCategoryTplGtr() {
        super(EAMTables.EAM_REPAIR_CATEGORY_TPL.$TABLE,"583208716988317696");
    }

    public void generateCode() throws Exception {


        cfg.getPoClassFile().addSimpleProperty(RepairCategory.class,"category","故障类型","故障类型");

        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.NAME).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.STATUS,
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.NAME,
                }
        );


        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.ATTACH_ID).table().disable(true);

        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.STATUS).form().validate().required().form().selectBox().enumType(StatusEnableEnum.class).defaultIndex(0);
        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.CODE).form().validate().required();
        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.COST_TIME).form().label("标准耗时(分)").numberInput();
        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.NOTES).form().textArea().height(60);
        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.REPAIR_SOLUTION).form().validate().required().form().textArea().height(60);

        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.CATEGORY_ID)
        .basic().label("故障类型")
        .form().validate().required().form().selectBox().queryApi(RepairCategoryServiceProxy.QUERY_LIST)
        .paging(false).filter(true).toolbar(false)
        .valueField(RepairCategoryMeta.ID).
        textField(RepairCategoryMeta.HIERARCHY_NAME).
        fillWith(RepairCategoryTplMeta.CATEGORY).muliti(false).defaultIndex(0);


        cfg.view().field(EAMTables.EAM_REPAIR_CATEGORY_TPL.ATTACH_ID).form().upload().acceptSingleFile().maxFileCount(1);

        cfg.view().formWindow().width("85%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().list().disableBatchDelete();
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.STATUS,
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.NAME,
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.COST_TIME,

                },
                new Object[] {
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.CATEGORY_ID,
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.CODE,
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.ATTACH_ID
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.REPAIR_SOLUTION,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_REPAIR_CATEGORY_TPL.NOTES,
                }
        );





        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页; //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        RepairCategoryTplGtr g=new RepairCategoryTplGtr();
        //生成代码
        g.generateCode();
        //生成菜单
     //   g.generateMenu(RepairCategoryTplServiceProxy.class, RepairCategoryTplPageController.class);
    }

}
