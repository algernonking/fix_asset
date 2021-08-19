package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetExtSoftware;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.meta.AssetExtFinancialMeta;
import com.dt.platform.domain.eam.meta.SupplierMeta;
import com.dt.platform.eam.page.AssetExtSoftwarePageController;
import com.dt.platform.proxy.eam.AssetExtSoftwareServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetExtSoftwareGtr extends BaseCodeGenerator {

    public EamAssetExtSoftwareGtr() {
        super(EAMTables.EAM_ASSET_EXT_SOFTWARE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {


        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(Asset.class,"asset","资产","资产");



        cfg.view().field(EAMTables.EAM_ASSET_EXT_SOFTWARE.ID).basic().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_EXT_SOFTWARE.ASSET_ID).basic().search().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_EXT_SOFTWARE.DISTRIBUTION_MODE)
                .basic().label("发行方式")
                .form().selectBox().dict(DictEnum.EAM_SOURCE);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_EXT_SOFTWARE.DISTRIBUTION_MODE
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
        EamAssetExtSoftwareGtr g=new EamAssetExtSoftwareGtr();

        //生成代码
        g.generateCode();


       // g.generateMenu(AssetExtSoftwareServiceProxy.class, AssetExtSoftwarePageController.class);

    }

}
