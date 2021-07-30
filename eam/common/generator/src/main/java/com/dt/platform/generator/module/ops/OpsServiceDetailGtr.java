package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.ops.OpsService;
import com.dt.platform.domain.ops.ServiceType;
import com.dt.platform.domain.ops.meta.OpsServiceMeta;
import com.dt.platform.domain.ops.meta.ServiceDetailMeta;
import com.dt.platform.domain.ops.meta.ServiceTypeMeta;
import com.dt.platform.ops.page.OpsServicePageController;
import com.dt.platform.ops.page.ServiceDetailPageController;
import com.dt.platform.proxy.ops.OpsServiceServiceProxy;
import com.dt.platform.proxy.ops.ServiceDetailServiceProxy;
import com.dt.platform.proxy.ops.ServiceTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsServiceDetailGtr extends BaseCodeGenerator{


    public OpsServiceDetailGtr() {
        super(EAMTables.OPS_SERVICE_DETAIL.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {

        cfg.getPoClassFile().addSimpleProperty(OpsService.class,"opsService","服务","");
//
        cfg.view().field(EAMTables.OPS_SERVICE_DETAIL.ID)
                .basic().hidden(true);
        cfg.view().field(EAMTables.OPS_SERVICE_DETAIL.SORT).search().hidden();

        cfg.view().field(EAMTables.OPS_SERVICE_DETAIL.PATCH).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_SERVICE_DETAIL.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.OPS_SERVICE_DETAIL.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.OPS_SERVICE_DETAIL.SERVICE_ID)
                .basic().label("服务")
                .form().validate().required()
                .form().select().queryApi(OpsServiceServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(false)
                .valueField(OpsServiceMeta.ID).textField(OpsServiceMeta.SERVICE_NAME).fillBy(ServiceDetailMeta.OPS_SERVICE).muliti(false);

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
        OpsServiceDetailGtr g=new OpsServiceDetailGtr();
        //生成代码
        g.generateCode();
        //移除之前生成的菜单，视情况执行

       // g.generateMenu(ServiceDetailServiceProxy.class, ServiceDetailPageController.class);
    }
}
