package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusShowHideEnum;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.eam.AssetAttribute;
import com.dt.platform.domain.eam.meta.AssetAttributeItemMeta;
import com.dt.platform.domain.eam.meta.AssetAttributeMeta;
import com.dt.platform.eam.page.AssetAttributeItemPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.AssetAttributeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EAMAssetAttributeItemGtr extends BaseCodeGenerator{
    public EAMAssetAttributeItemGtr() {
        super(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(AssetAttribute.class,"attribute","属性","属性");

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.NOTES).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.OWNER_CODE,
                        EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.LAYOUT_TYPE,
                        EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.LIST_SHOW,
                        EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.FORM_SHOW,


                } ,
                new Object[]{
                        EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.DIMENSION,
                        EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.NOTES,

        }
        );


        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.ATTRIBUTE_ID).form().validate().required()
                .form().selectBox().queryApi(AssetAttributeServiceProxy.QUERY_ATTRIBUTE_OWNER_LIST+"?owner=asset&itemOwner=-1").valueField(AssetAttributeMeta.ID).textField(AssetAttributeMeta.LABEL)
        .filter(true).toolbar(false).paging(false).muliti(false).fillWith(AssetAttributeItemMeta.ATTRIBUTE);




        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.OWNER_CODE).form().validate().required()
                .form().selectBox().enumType(AssetAttributeItemOwnerEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.FORM_SHOW).form().validate().required()
                .form().radioBox().enumType(StatusShowHideEnum.class);


        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.LIST_SHOW).form().validate().required()
                .form().radioBox().enumType(StatusShowHideEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.LAYOUT_TYPE).form().validate().required()
                .form().radioBox().enumType(AssetAttributeLayoutTypeEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.REQUIRED).form().validate().required()
                .form().radioBox().enumType(StatusYNEnum.class);



        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.NOTES).form().textArea().height(30);




        cfg.view().field(EAMTables.EAM_ASSET_ATTRIBUTE_ITEM.DIMENSION).form().validate().required()
                .form().radioBox().enumType(AssetAttributeDimensionEnum.class);



        //指定关联对象的属性填充单元格，为了避免名称重复，加一个前缀
        //改变前端,EAMTables.SYS_CODE_RULE.RULE 在前端显示
        String resourceNameField="res_"+EAMTables.EAM_ASSET_ATTRIBUTE.NOTES;
        cfg.view().field(resourceNameField)
                .basic().form().hidden(true).label("属性备注")
                .table().fillBy(AssetAttributeItemMeta.ATTRIBUTE, AssetAttributeMeta.NOTES);

        String resourceNameField2="res_"+EAMTables.EAM_ASSET_ATTRIBUTE.CODE;
        cfg.view().field(resourceNameField2)
                .basic().form().hidden(true).label("属性字段")
                .table().fillBy(AssetAttributeItemMeta.ATTRIBUTE, AssetAttributeMeta.CODE);

        cfg.view().formWindow().width("85%");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EAMAssetAttributeItemGtr g=new EAMAssetAttributeItemGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
       // g.generateMenu(AssetAttributeItemServiceProxy.class, AssetAttributeItemPageController.class);
    }
}
