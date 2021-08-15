package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetExtEquipment;
import com.dt.platform.eam.page.AssetExtEquipmentPageController;
import com.dt.platform.eam.page.MaintainerPageController;
import com.dt.platform.proxy.eam.AssetExtEquipmentServiceProxy;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetExtEquipmentGtr extends BaseCodeGenerator {

    public EamAssetExtEquipmentGtr() {
        super(EAMTables.EAM_ASSET_EXT_EQUIPMENT.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {


        cfg.view().search().inputLayout(
                new Object[]{EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID,EAMTables.EAM_ASSET_EXT_EQUIPMENT.MANAGE_IP,EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_IP}
                ,new Object[]{EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_NOTES,EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_DESC}

        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetExtEquipmentGtr g=new EamAssetExtEquipmentGtr();

        //生成代码
      //  g.generateCode();
        //生成菜单
        g.generateMenu(AssetExtEquipmentServiceProxy.class, AssetExtEquipmentPageController.class);
    }

}
