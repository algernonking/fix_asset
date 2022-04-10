package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.meta.AreaMeta;
import com.dt.platform.domain.datacenter.meta.LayerMeta;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


//1  我要隐藏search中的字端，是吗
//        cfg.view().field(EAMTables.DC_RACK.ID).search().hidden();
//       //2 我要隐藏form list的字段，是吗
//        cfg.view().field(EAMTables.DC_RACK.ID).form().list().hidden();
//
//        //下面这样调用会咋样
//        //3
//        cfg.view().field(EAMTables.DC_RACK.ID).form().hidden();
//        //4
//        cfg.view().field(EAMTables.DC_RACK.ID).basic().hidden();
//
//        //2和3，4没区别?   4会同时隐藏search 和form list

public class DcRackGtr extends BaseCodeGenerator {
    public DcRackGtr() {
        super(EAMTables.DC_RACK.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
//        //第一步：配置好后，生成代码
        cfg.getPoClassFile().addSimpleProperty(Area.class,"area","区域","");
        cfg.getPoClassFile().addSimpleProperty(Layer.class,"layer","层级","");

        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"statusDict","状态","");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"typeDict","类型","");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"usedTypeDict","使用类型","");
        cfg.getPoClassFile().addSimpleProperty(DictItem.class,"environmentDict","环境","");

        cfg.view().field(EAMTables.DC_RACK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.DC_RACK.ID).search().hidden();

        cfg.view().field(EAMTables.DC_RACK.RACK_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_RACK.RACK_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_RACK.RACK_LABEL1).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_RACK.RACK_LABEL2).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_RACK.EXPIRE_DATE).search().range();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.DC_RACK.STATUS,
                        EAMTables.DC_RACK.RACK_TYPE,
                        EAMTables.DC_RACK.RACK_USED_TYPE,
                        EAMTables.DC_RACK.ENVIRONMENT,
                },
                new Object[]{
                        EAMTables.DC_RACK.AREA_ID,
                        EAMTables.DC_RACK.LAYER_ID,
                        EAMTables.DC_RACK.RACK_NAME,
                        EAMTables.DC_RACK.RACK_LABEL1,
                },
                new Object[]{
                        EAMTables.DC_RACK.EXPIRE_DATE,
                        EAMTables.DC_RACK.RACK_CODE,

                }
        );

        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(EAMTables.DC_RACK.RACK_NAME).form().validate().required();
        cfg.view().field(EAMTables.DC_RACK.RACK_CODE).form().validate().required();
        cfg.view().field(EAMTables.DC_RACK.STATUS).form().validate().required();
        cfg.view().field(EAMTables.DC_RACK.RACK_TYPE).form().validate().required();
        cfg.view().field(EAMTables.DC_RACK.RACK_USED_TYPE).form().validate().required();

        cfg.view().field(EAMTables.DC_RACK.STATUS)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_dc_rack_status")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(RackMeta.STATUS_DICT).muliti(false);


        cfg.view().field(EAMTables.DC_RACK.RACK_TYPE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_dc_rack_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(RackMeta.TYPE_DICT).muliti(false);

        cfg.view().field(EAMTables.DC_RACK.RACK_USED_TYPE)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_dc_rack_used_type")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(RackMeta.USED_TYPE_DICT).muliti(false);

        cfg.view().field(EAMTables.DC_RACK.ENVIRONMENT)
                .form().selectBox().queryApi(DictItemServiceProxy.QUERY_LIST+"?dictCode=ops_dc_rack_environment")
                .paging(false).filter(false).toolbar(false)
                .valueField(DictItemMeta.CODE).
                textField(DictItemMeta.LABEL).
                fillWith(RackMeta.ENVIRONMENT_DICT).muliti(false);


        cfg.view().field(EAMTables.DC_RACK.AREA_ID)
                .basic().label("区域")
//                .form().validate().required()
                .form().selectBox().queryApi(AreaServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(AreaMeta.ID).textField(AreaMeta.NAME).fillWith(RackMeta.AREA).muliti(false);

        cfg.view().field(EAMTables.DC_RACK.LAYER_ID)
                .basic().label("层级")
//                .form().validate().required()
                .form().selectBox().queryApi(LayerServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(LayerMeta.ID).textField(LayerMeta.NAME).fillWith(RackMeta.LAYER).muliti(false);

        cfg.view().field(EAMTables.DC_RACK.RACK_CAPTICAL).form().numberInput().range(0.0,100.0).step(1.0);
        cfg.view().field(EAMTables.DC_RACK.RACK_NOTES).form().textArea().height(30);

        //分成分组布局
        cfg.view().formWindow().width("98%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        EAMTables.DC_RACK.RACK_CODE,
                        EAMTables.DC_RACK.RACK_NAME,
                        EAMTables.DC_RACK.EXPIRE_DATE,
                },
                new Object[] {
                        EAMTables.DC_RACK.STATUS,
                        EAMTables.DC_RACK.RACK_TYPE,
                        EAMTables.DC_RACK.RACK_USED_TYPE,

                },new Object[] {
                        EAMTables.DC_RACK.ENVIRONMENT,
                        EAMTables.DC_RACK.AREA_ID,
                        EAMTables.DC_RACK.LAYER_ID,
                }
        );

        cfg.view().form().addGroup("属性信息",
                new Object[] {
                        EAMTables.DC_RACK.U_POSTION_NUMBER,
                        EAMTables.DC_RACK.RACK_CAPTICAL,
                        EAMTables.DC_RACK.CONTRACT_POWER,
                },
                new Object[] {
                        EAMTables.DC_RACK.PDU_NUMBER,
                        EAMTables.DC_RACK.JUMPER_NUMBER,
                },

                new Object[] {
                        EAMTables.DC_RACK.RACK_LABEL1,
                        EAMTables.DC_RACK.RACK_LABEL2,

                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.DC_RACK.RACK_NOTES,

                }
        );

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        DcRackGtr g=new DcRackGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
        //生成菜单
       //g.generateMenu(RackServiceProxy.class, RackPageController.class);
    }
}
