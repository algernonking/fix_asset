package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.eam.page.AssetBorrowPageController;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetBorrowGtr extends BaseCodeGenerator {

    public EamAssetBorrowGtr() {
        super(EAMTables.EAM_ASSET_BORROW.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {


        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.NAME,
                        EAMTables.EAM_ASSET_BORROW.PROC_ID,
                        EAMTables.EAM_ASSET_BORROW.STATUS,
                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME
                },
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.CONTENT
                }

        );


        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROW_TIME).form().validate().required();



        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME,
                        EAMTables.EAM_ASSET_BORROW.BORROWER_ID
                }, new Object[] {
                        EAMTables.EAM_ASSET_BORROW.PLAN_RETURN_DATE
                }, new Object[] {
                        EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID

                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.CONTENT,
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
        EamAssetBorrowGtr g=new EamAssetBorrowGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(AssetBorrowServiceProxy.class, AssetBorrowPageController.class);
    }

}
