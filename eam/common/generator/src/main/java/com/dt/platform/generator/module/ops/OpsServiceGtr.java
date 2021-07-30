package com.dt.platform.generator.module.ops;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.datacenter.meta.AreaMeta;
import com.dt.platform.domain.datacenter.meta.RackMeta;
import com.dt.platform.domain.ops.ServiceType;

import com.dt.platform.domain.ops.meta.OpsServiceMeta;
import com.dt.platform.domain.ops.meta.ServiceTypeMeta;
import com.dt.platform.ops.page.OpsServicePageController;
import com.dt.platform.proxy.datacenter.AreaServiceProxy;
import com.dt.platform.proxy.ops.OpsServiceServiceProxy;
import com.dt.platform.proxy.ops.ServiceTypeServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class OpsServiceGtr extends BaseCodeGenerator{


    public OpsServiceGtr() {
        super(EAMTables.OPS_SERVICE.$TABLE,BASIC_DATA_MENU_ID,"");
    }

    public void generateCode() throws Exception {

        cfg.getPoClassFile().addSimpleProperty(ServiceType.class,"serviceType","类型","");

        cfg.view().field(EAMTables.OPS_SERVICE.ID)
                .basic().hidden(true);
        cfg.view().field(EAMTables.OPS_SERVICE.SERVICE_NAME).search().fuzzySearch();


        cfg.view().field(EAMTables.OPS_SERVICE.TYPE_ID)
                .basic().label("服务类型")
                .form().validate().required()
                .form().select().queryApi(ServiceTypeServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(false)
                .valueField(ServiceTypeMeta.ID).textField(ServiceTypeMeta.NAME).fillBy(OpsServiceMeta.SERVICE_TYPE).muliti(false);

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
        OpsServiceGtr g=new OpsServiceGtr();
        //生成代码

        //移除之前生成的菜单，视情况执行

        g.generateMenu(OpsServiceServiceProxy.class, OpsServicePageController.class);
    }
}
