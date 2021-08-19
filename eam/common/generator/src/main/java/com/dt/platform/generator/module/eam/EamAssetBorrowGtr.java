package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetBorrowStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.AssetHandle;
import com.dt.platform.eam.page.AssetBorrowPageController;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetBorrowGtr extends BaseCodeGenerator {

    public EamAssetBorrowGtr() {
        super(
                AssetBorrowServiceProxy.class, AssetBorrowPageController.class,
                EAMTables.EAM_ASSET_BORROW.$TABLE,BASIC_DATA_MENU_ID);
    }



    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");

       // cfg.view().list().disableSpaceColumn();
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ID).basic().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.NAME).table().disable().search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.CREATE_TIME).table().disable();


        cfg.view().field(EAMTables.EAM_ASSET_BORROW.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROW_TIME).form().validate().required().search().range();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.CONTENT).form().textArea().height(30).search().fuzzySearch();



        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.STATUS,

                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME
                },
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_BORROW.BORROWER_ID,
                        EAMTables.EAM_ASSET_BORROW.CONTENT
                }
        );
        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.BORROWER_ID,
                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME
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
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
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
       // g.reGenerateMenu();;
        //生成菜单
        //g.generateMenu(AssetBorrowServiceProxy.class, AssetBorrowPageController.class);
    }



}
