package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.eam.page.OperatePageController;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetOperateGtr extends BaseCodeGenerator{
    public EamAssetOperateGtr() {
        super(EAMTables.EAM_OPERATE.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.EAM_OPERATE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_OPERATE.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_OPERATE.NOTES).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_OPERATE.NAME,
                        EAMTables.EAM_OPERATE.NOTES,
                }
        );

        cfg.view().field(EAMTables.EAM_OPERATE.NAME).form().validate().required();
        cfg.view().field(EAMTables.EAM_OPERATE.OPERATE_CODE).form().validate().required()
                .form().selectBox().enumType(CodeModuleEnum.class).muliti(false);

        cfg.view().field(EAMTables.EAM_OPERATE.APPROVAL).form().validate().required()
                .form().selectBox().enumType(StatusYNEnum.class).muliti(false);


        cfg.view().field(EAMTables.EAM_OPERATE.ALLOCATE_CODE).form().validate().required();

        cfg.view().formWindow().width("80%");
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_OPERATE.NAME,
                        EAMTables.EAM_OPERATE.APPROVAL,
                        EAMTables.EAM_OPERATE.NOTES,
                }, new Object[] {
                        EAMTables.EAM_OPERATE.ALLOCATE_CODE,
                        EAMTables.EAM_OPERATE.OPERATE_CODE,
                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetOperateGtr g=new EamAssetOperateGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
        //g.generateMenu(OperateServiceProxy.class, OperatePageController.class);
    }
}
