package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetBorrowStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.page.AssetBorrowPageController;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetBorrowDataGtr extends BaseCodeGenerator {

    public EamAssetBorrowDataGtr() {
        super(

                EAMTables.EAM_ASSET_BORROW_DATA.$TABLE,BASIC_DATA_MENU_ID);
    }



    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素




        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW_DATA.ID,


                }

        );

        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetBorrowDataGtr g=new EamAssetBorrowDataGtr();

        //生成代码
        g.generateCode();
       // g.reGenerateMenu();;
        //生成菜单
        //g.generateMenu(AssetBorrowServiceProxy.class, AssetBorrowPageController.class);
    }



}
