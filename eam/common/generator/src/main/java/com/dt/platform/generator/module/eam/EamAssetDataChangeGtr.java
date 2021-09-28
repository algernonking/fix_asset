package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDataChange;
import com.dt.platform.eam.page.AssetDataChangePageController;
import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamAssetDataChangeGtr extends BaseCodeGenerator{

    public EamAssetDataChangeGtr() {
        super(EAMTables.EAM_ASSET_DATA_CHANGE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"changeUser","变更人","变更人");
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_TIME).search().range();

        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.ID).basic().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.ID).table().disable(true);

        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                       // EAMTables.EAM_ASSET_DATA_CHANGE.BUSINESS_TYPE,
                        EAMTables.EAM_ASSET_DATA_CHANGE.CONTENT
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.BUSINESS_TYPE).form().
                label("业务类型").selectBox().enumType(CodeModuleEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_USER_ID).table().fillBy("changeUser","name");
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_USER_ID).form();
        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_TIME).form().dateInput().format("yyyy-MM-dd HH:mm:ss").search().range();

        cfg.view().list().disableMargin();
        cfg.view().list().disableSpaceColumn();
        cfg.view().list().disableBatchDelete();
        cfg.view().list().disableSingleDelete();
        cfg.view().list().disableModify();
        cfg.view().list().disableCreateNew();




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
                .setListPage(WriteMode.CREATE_IF_NOT_EXISTS)
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetDataChangeGtr g=new EamAssetDataChangeGtr();
        g.generateCode();
        //生成菜单
        // g.generateMenu(AssetDataChangeServiceProxy.class, AssetDataChangePageController.class);
    }
}
