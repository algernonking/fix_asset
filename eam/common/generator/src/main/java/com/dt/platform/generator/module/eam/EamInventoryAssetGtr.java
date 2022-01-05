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
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"operater","操作人员","操作人员");


        cfg.view().field(EAMTables.EAM_INVENTORY_ASSET.ID).basic().hidden(true);

        //eam_asset_change_data
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_INVENTORY_ASSET.STATUS,
                        EAMTables.EAM_INVENTORY_ASSET.NOTES
                }
        );

        cfg.view().field(EAMTables.EAM_INVENTORY_ASSET.STATUS).form()
                .label("盘点状态").selectBox().enumType(AssetInventoryDetailStatusEnum.class);


        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_INVENTORY_ASSET.STATUS,
                        EAMTables.EAM_INVENTORY_ASSET.NOTES,
                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamInventoryAssetGtr g=new EamInventoryAssetGtr();
        g.generateCode();
        //生成菜单
        g.generateMenu(InventoryAssetServiceProxy.class, InventoryAssetPageController.class);
    }
}
