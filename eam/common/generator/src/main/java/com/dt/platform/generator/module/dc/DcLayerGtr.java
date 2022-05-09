package com.dt.platform.generator.module.dc;

import com.dt.platform.constants.db.DataCenterTables;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.datacenter.page.AreaPageController;
import com.dt.platform.datacenter.page.LayerPageController;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.meta.AreaMeta;
import com.dt.platform.domain.datacenter.meta.LayerMeta;
import com.dt.platform.domain.datacenter.meta.RackMeta;

import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.meta.DictItemMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;


public class DcLayerGtr extends BaseCodeGenerator {
    public DcLayerGtr() {
        super(DataCenterTables.DC_LAYER.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        cfg.view().field(DataCenterTables.DC_LAYER.ID).basic().hidden(true);

        cfg.view().field(DataCenterTables.DC_LAYER.NAME).search().fuzzySearch();
        cfg.view().field(DataCenterTables.DC_LAYER.NOTES).search().fuzzySearch();

        cfg.view().field(DataCenterTables.DC_LAYER.NAME).form().validate().required();

        cfg.getPoClassFile().addSimpleProperty(Area.class,"area","区域","");

        cfg.view().search().inputLayout(
                new Object[]{
                        DataCenterTables.DC_LAYER.AREA_ID,
                        DataCenterTables.DC_LAYER.NAME,
                        DataCenterTables.DC_LAYER.NOTES,
                }

        );
        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);

        cfg.view().field(DataCenterTables.DC_LAYER.NAME).form().validate().required();

        cfg.view().field(DataCenterTables.DC_LAYER.AREA_ID)
                .form().validate().required().form().selectBox().queryApi(AreaServiceProxy.QUERY_PAGED_LIST)
                .paging(true).filter(true).toolbar(false)
                .valueField(AreaMeta.ID).
                textField(AreaMeta.NAME).
                fillWith(LayerMeta.AREA).muliti(false).defaultIndex(0);

        //分成分组布局
        cfg.view().formWindow().width("75%");
        cfg.view().formWindow().bottomSpace(80);
        cfg.view().form().addGroup("基本信息",
                new Object[] {
                        DataCenterTables.DC_LAYER.AREA_ID,
                        DataCenterTables.DC_LAYER.NAME,
                        DataCenterTables.DC_LAYER.SORT,
                        DataCenterTables.DC_LAYER.NOTES,
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
        DcLayerGtr g=new DcLayerGtr();
        //生成代码
        g.generateCode();

        //移除之前生成的菜单，视情况执行
       // System.out.println("############"+g.getTablePrefix());
        //g.removeByBatchId("470160949404237824");
       // g.generateMenu(LayerServiceProxy.class, LayerPageController.class);
    }
}
