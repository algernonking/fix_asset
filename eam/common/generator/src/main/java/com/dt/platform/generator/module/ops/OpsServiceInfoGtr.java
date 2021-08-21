package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;

import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.meta.ServiceCategoryMeta;

import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.ops.page.ServiceInfoPageController;
import com.dt.platform.proxy.ops.ServiceCategoryServiceProxy;
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsServiceInfoGtr extends BaseCodeGenerator{


    public OpsServiceInfoGtr() {
        super(EAMTables.OPS_SERVICE_INFO.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
        cfg.getPoClassFile().addSimpleProperty(ServiceCategory.class,"serviceCategory","服务","");


        cfg.view().field(EAMTables.OPS_SERVICE_INFO.ID).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_SERVICE_INFO.SORT).basic().hidden(true);
        cfg.view().field(EAMTables.OPS_SERVICE_INFO.CREATE_TIME).table().hidden();

        cfg.view().field(EAMTables.OPS_SERVICE_INFO.PATCH).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_SERVICE_INFO.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_SERVICE_INFO.NOTES).search().fuzzySearch();
//

//        String resourceNameField="res_"+OpsServiceMeta.SERVICE_NAME;
//        cfg.view().field(resourceNameField)
//                .basic().label("服务类型")
//                .table().fillBy(ServiceDetailMeta.OPS_SERVICE,OpsServiceMeta.SERVICE_NAME);


        cfg.view().field(EAMTables.OPS_SERVICE_INFO.SERVICE_CATEGORY_ID)
                .basic().label("服务类型")
                .form().validate().required()
                .form().selectBox().queryApi(ServiceCategoryServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(ServiceCategoryMeta.ID).textField(ServiceCategoryMeta.NAME).fillBy(ServiceInfoMeta.SERVICE_CATEGORY).muliti(false);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.OPS_SERVICE_INFO.NAME,
                        EAMTables.OPS_SERVICE_INFO.SERVICE_CATEGORY_ID,
                        EAMTables.OPS_SERVICE_INFO.NOTES

                }


        );





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
        OpsServiceInfoGtr g=new OpsServiceInfoGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行
        //g.removeByBatchId("478921035245158400");
        // g.generateMenu(ServiceInfoServiceProxy.class, ServiceInfoPageController.class);
    }
}
