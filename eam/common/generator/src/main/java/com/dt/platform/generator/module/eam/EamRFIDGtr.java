package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetBorrowStatusEnum;
import com.dt.platform.domain.eam.BaseStation;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.BaseStationMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.eam.page.BaseStationPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.BaseStationServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamRFIDGtr extends BaseCodeGenerator{
    public EamRFIDGtr() {
        super(EAMTables.RFID_BASE_STATION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {


        cfg.view().field(EAMTables.RFID_BASE_STATION.ID).basic().hidden(true);
        cfg.view().field(EAMTables.RFID_BASE_STATION.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.RFID_BASE_STATION.DEVICE_TYPE).form()
                .label("设备类型").selectBox().enumType(AssetBorrowStatusEnum.class);
        cfg.view().field(EAMTables.RFID_BASE_STATION.WORK_TYPE).form()
                .label("工作类型").selectBox().enumType(AssetBorrowStatusEnum.class);


        cfg.getPoClassFile().addSimpleProperty(Position.class,"deviceArea","基站区域","基站区域");



        cfg.view().field(EAMTables.RFID_BASE_STATION.AREA_ID)
                .basic().label("基站区域")
                .table().sort(false)
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME)
                .toolbar(false).paging(false)
                .fillWith(BaseStationMeta.DEVICE_AREA).muliti(false);

        cfg.view().field(EAMTables.RFID_BASE_STATION.NAME).form().validate().required();
        cfg.view().field(EAMTables.RFID_BASE_STATION.AREA_ID).form().validate().required();
        cfg.view().field(EAMTables.RFID_BASE_STATION.DEVICE_ID).form().validate().required();
        cfg.view().field(EAMTables.RFID_BASE_STATION.WORK_TYPE).form().validate().required();
        cfg.view().field(EAMTables.RFID_BASE_STATION.DEVICE_TYPE).form().validate().required();
        cfg.view().field(EAMTables.RFID_BASE_STATION.IS_ON_LINE).form().hidden(true);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.RFID_BASE_STATION.NAME,
                        EAMTables.RFID_BASE_STATION.DEVICE_TYPE,
                        EAMTables.RFID_BASE_STATION.IS_ON_LINE,
                        EAMTables.RFID_BASE_STATION.WORK_TYPE
                }
        );
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);

        cfg.view().search().inputWidth(Config.searchInputWidth);


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
        EamRFIDGtr g=new EamRFIDGtr();
        //生成代码
         g.generateCode();


        //生成菜单
        //  g.removeByBatchId("");
        g.generateMenu(BaseStationServiceProxy.class, BaseStationPageController.class);
    }
}
