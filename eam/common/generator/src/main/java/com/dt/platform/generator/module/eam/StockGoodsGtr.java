package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetStockGoods;
import com.dt.platform.eam.page.AssetStockGoodsPageController;
import com.dt.platform.eam.page.BrandPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.AssetStockGoodsServiceProxy;
import com.dt.platform.proxy.eam.BrandServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class StockGoodsGtr extends BaseCodeGenerator {


    public StockGoodsGtr() {
        super(EAMTables.EAM_ASSET_STOCK_GOODS.$TABLE,BASIC_STOCK_GOODS_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.ID).basic().hidden(true);


        cfg.view().field(EAMTables.EAM_ASSET_STOCK_GOODS.STOCK_NAME).form().validate().required();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_STOCK_GOODS.STATUS,

                }
        );


        cfg.view().formWindow().bottomSpace(20);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_STOCK_GOODS.OWN_COMPANY_ID,

                }
        );


        cfg.view().search().inputWidth(Config.searchInputWidth);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        ; //列表HTML页
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        StockGoodsGtr g=new StockGoodsGtr();
        //生成代码
       g.generateCode();

       // g.removeByBatchId("507635127677878272");
        //移除之前生成的菜单，视情况执行
     // g.generateMenu(AssetStockGoodsServiceProxy.class, AssetStockGoodsPageController.class);
        //生成菜单

    }

}
