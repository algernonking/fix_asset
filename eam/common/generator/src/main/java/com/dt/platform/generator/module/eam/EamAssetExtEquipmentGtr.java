package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.datacenter.meta.AreaMeta;
import com.dt.platform.domain.datacenter.meta.LayerMeta;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.domain.eam.AssetExtEquipment;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.meta.AssetExtEquipmentMeta;
import com.dt.platform.domain.eam.meta.AssetExtFinancialMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.eam.page.AssetExtEquipmentPageController;
import com.dt.platform.eam.page.MaintainerPageController;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.dt.platform.proxy.eam.AssetExtEquipmentServiceProxy;
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetExtEquipmentGtr extends BaseCodeGenerator {

    public EamAssetExtEquipmentGtr() {
        super(EAMTables.EAM_ASSET_EXT_EQUIPMENT.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Area.class,"area","区域","区域");

        cfg.getPoClassFile().addSimpleProperty(Layer.class,"layer","层级","层级");

        cfg.getPoClassFile().addSimpleProperty(Rack.class,"rack","机柜","机柜");

        cfg.view().field(EAMTables.EAM_ASSET_EXT_EQUIPMENT.ID).basic().hidden();



        cfg.view().field(EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID)
                .basic().label("区域")
                .form().selectBox().queryApi(AreaServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(AreaMeta.ID).textField(AreaMeta.NAME).fillBy(AssetExtEquipmentMeta.AREA).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_EXT_EQUIPMENT.LAYER_ID)
                .basic().label("层级")
                .form().selectBox().queryApi(LayerServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(LayerMeta.ID).textField(LayerMeta.NAME).fillBy(AssetExtEquipmentMeta.LAYER).muliti(false);

        cfg.view().field(EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_ID)
                .basic().label("机柜")
                .form().selectBox().queryApi(RackServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(RackMeta.ID).textField(RackMeta.RACK_NAME).fillBy(AssetExtEquipmentMeta.RACK).muliti(false);


        cfg.view().field(EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_DOWN_POSITION_NUMBER).form().numberInput().range(0.0,100.0).step(1.0);
        cfg.view().field(EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_UP_POSITION_NUMBER).form().numberInput().range(0.0,100.0).step(1.0);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_ID,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.MANAGE_IP,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_IP
                }
                ,new Object[]{
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.LAYER_ID,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_NOTES,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_DESC
                }
        );

        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup("设备属性",
                new Object[] {
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.AREA_ID,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.LAYER_ID,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_IP,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.MANAGE_IP,
                }, new Object[] {
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_CPU,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_MEMORY,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_DESC
                },
                new Object[] {
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_ID,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_UP_POSITION_NUMBER,
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.RACK_DOWN_POSITION_NUMBER,
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_EXT_EQUIPMENT.EQUIPMENT_NOTES

                }


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
        g.generateCode();
        //生成菜单
      //  g.generateMenu(AssetExtEquipmentServiceProxy.class, AssetExtEquipmentPageController.class);
    }

}
