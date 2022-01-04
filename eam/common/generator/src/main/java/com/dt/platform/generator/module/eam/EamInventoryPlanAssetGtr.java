package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDetailStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Inventory;
import com.dt.platform.domain.eam.InventoryPlan;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.InventoryPlanMeta;
import com.dt.platform.eam.page.InventoryPlanPageController;
import com.dt.platform.proxy.eam.InventoryPlanServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;

public class EamInventoryPlanAssetGtr extends BaseCodeGenerator{

    public EamInventoryPlanAssetGtr() {
        super(EAMTables.EAM_INVENTORY_PLAN.$TABLE,BASIC_ASSET_NZ_MENU_ID);
    }

    public void generateCode() throws Exception {

        //盘点明细
        cfg.getPoClassFile().addSimpleProperty(Inventory.class,"inventory","盘点数据","盘点数据");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"inventoryPlanType","盘点类型","盘点类型");

        cfg.view().field(EAMTables.EAM_INVENTORY_PLAN.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_INVENTORY_PLAN.OWNER_CODE).basic().hidden(true);

        //eam_asset_change_data
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY_PLAN.STATUS,
                        EAMTables.EAM_INVENTORY_PLAN.NAME,
                        EAMTables.EAM_INVENTORY_PLAN.NOTES
                }
        );

        cfg.view().field(EAMTables.EAM_INVENTORY_PLAN.STATUS).form().validate().required().form()
                .label("状态").selectBox().enumType(StatusEnableEnum.class);

        cfg.view().field(EAMTables.EAM_INVENTORY_PLAN.PLAN_TYPE)
                .basic().label("计划类型")
                .form().validate().required().form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=eam_inventory_plan_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(InventoryPlanMeta.INVENTORY_PLAN_TYPE).muliti(false);

        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY_PLAN.NAME,
                        EAMTables.EAM_INVENTORY_PLAN.NOTES,
                }, new Object[] {
                        EAMTables.EAM_INVENTORY_PLAN.STATUS,
                        EAMTables.EAM_INVENTORY_PLAN.PLAN_TYPE,
                }
        );


        cfg.view().list().operationColumn().addActionButton("查看模板","viewTpl","viewTpl","viewTpl");
        cfg.view().list().operationColumn().addActionButton("修改模板","modifyTpl","modifyTpl","modifyTpl");

        cfg.view().form().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");
        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","OWNER_CODE");

        cfg.view().form().addJsVariable("PLAN_ID","[[${planId}]]","PLAN_ID");

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamInventoryPlanAssetGtr g=new EamInventoryPlanAssetGtr();
        g.generateCode();
        //生成菜单
        //g.generateMenu(InventoryPlanServiceProxy.class, InventoryPlanPageController.class);
    }
}
