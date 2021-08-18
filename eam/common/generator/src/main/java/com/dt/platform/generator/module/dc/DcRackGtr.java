package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.meta.AreaMeta;
import com.dt.platform.domain.datacenter.meta.LayerMeta;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


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

        cfg.view().field(EAMTables.DC_RACK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.DC_RACK.ID).search().hidden();

        cfg.view().field(EAMTables.DC_RACK.RACK_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_RACK.RACK_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.DC_RACK.RACK_LABELS).search().fuzzySearch();



        cfg.view().field(EAMTables.DC_RACK.RACK_CAPTICAL).search().hidden();




        cfg.view().field(EAMTables.DC_RACK.RACK_CODE).form().validate().required();
        cfg.view().field(EAMTables.DC_RACK.AREA_ID)
                .basic().label("区域")
                .form().validate().required()
                .form().selectBox().queryApi(AreaServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(false)
                .valueField(AreaMeta.ID).textField(AreaMeta.NAME).fillBy(RackMeta.AREA).muliti(false);

        cfg.view().field(EAMTables.DC_RACK.LAYER_ID)
                .basic().label("层级")
                .form().validate().required()
                .form().selectBox().queryApi(LayerServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(false)
                .valueField(LayerMeta.ID).textField(LayerMeta.NAME).fillBy(RackMeta.LAYER).muliti(false);

        cfg.view().field(EAMTables.DC_RACK.RACK_CAPTICAL).form().numberInput().range(0.0,100.0).step(1.0);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
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
