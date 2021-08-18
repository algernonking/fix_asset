package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.eam.page.AssetBorrowReturnPageController;
import com.dt.platform.proxy.eam.AssetBorrowReturnServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetBorrowReturnGtr extends BaseCodeGenerator {

    public EamAssetBorrowReturnGtr() {
        super(EAMTables.EAM_ASSET_BORROW_RETURN.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW_RETURN.RETURN_DATE,
                        EAMTables.EAM_ASSET_BORROW_RETURN.ORIGINATOR_ID,
                        EAMTables.EAM_ASSET_BORROW_RETURN.CONTENT,
                }

        );






        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW_RETURN.RETURN_DATE,
                }
                ,new Object[] {
                      EAMTables.EAM_ASSET_BORROW_RETURN.ORIGINATOR_ID,
                   }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW_RETURN.CONTENT,
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
        EamAssetBorrowReturnGtr g=new EamAssetBorrowReturnGtr();

        //生成代码
        g.generateCode();
        //生成菜单
       // g.generateMenu(AssetBorrowReturnServiceProxy.class, AssetBorrowReturnPageController.class);
    }

}
