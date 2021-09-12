package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.constants.enums.eam.AssetAttributeComponentTypeEnum;
import com.dt.platform.constants.enums.eam.AssetAttributeDimensionEnum;
import com.dt.platform.domain.eam.AssetAttribute;
import com.dt.platform.eam.page.AssetAttributePageController;
import com.dt.platform.proxy.eam.AssetAttributeServiceProxy;
import com.github.foxnic.generator.builder.view.field.InputType;
import com.github.foxnic.generator.config.WriteMode;

public class EAMAssetAttributeGtr extends BaseCodeGenerator{
    public EAMAssetAttributeGtr() {
        super(EAMTables.EAM_ASSET_ATTRIBUTE.$TABLE,BASIC_SETTING_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.LABEL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.NOTES).search().fuzzySearch();

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_ATTRIBUTE.DIMENSION,
                        EAMTables.EAM_ASSET_ATTRIBUTE.STATUS,
                        EAMTables.EAM_ASSET_ATTRIBUTE.COMPONENT_TYPE,
                        EAMTables.EAM_ASSET_ATTRIBUTE.LABEL,
                        EAMTables.EAM_ASSET_ATTRIBUTE.NOTES
                }
        );


        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.CODE).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.LABEL).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.STATUS).form().validate().required()
                .form().radioBox().enumType(StatusValidEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.COMPONENT_TYPE).form().validate().required()
                .form().radioBox().enumType(AssetAttributeComponentTypeEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.COMPONENT_CONTENT).table().disable(true);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.DIMENSION).form().validate().required()
                .form().radioBox().enumType(AssetAttributeDimensionEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.NOTES)
                .form().textArea().height(30);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE.COMPONENT_CONTENT).form().textArea().height(30);

        cfg.view().formWindow().bottomSpace(80);

        cfg.view().formWindow().width("85%");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EAMAssetAttributeGtr g=new EAMAssetAttributeGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(AssetAttributeServiceProxy.class, AssetAttributePageController.class);
    }
}