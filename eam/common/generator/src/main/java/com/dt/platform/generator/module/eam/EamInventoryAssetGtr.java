package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryActionStatusEnum;
import com.dt.platform.constants.enums.eam.AssetInventoryDetailStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.eam.page.InventoryAssetPageController;
import com.dt.platform.proxy.eam.InventoryAssetServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamInventoryAssetGtr extends BaseCodeGenerator{

    public EamInventoryAssetGtr() {
        super(EAMTables.EAM_INVENTORY_ASSET.$TABLE,BASIC_ASSET_NZ_MENU_ID);
    }

    public void generateCode() throws Exception {

        //盘点明细
        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"inventoryUser","盘点人员","盘点人员");


        cfg.view().field(EAMTables.EAM_INVENTORY_ASSET.ID).basic().hidden(true);

        //eam_asset_change_data
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY_ASSET.STATUS
                }
        );

        cfg.view().field(EAMTables.EAM_INVENTORY_ASSET.STATUS).form()
                .label("盘点状态").selectBox().enumType(AssetInventoryDetailStatusEnum.class);



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamInventoryAssetGtr g=new EamInventoryAssetGtr();
        g.generateCode();
        //生成菜单
      //  g.generateMenu(InventoryAssetServiceProxy.class, InventoryAssetPageController.class);
    }
}
