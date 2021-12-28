package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT_PERFORMANCE;
import com.dt.platform.generator.module.CodeStarter;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;

public class ContContractPerformanceConfig extends CodeStarter.BaseCodeConfig<CONT_CONTRACT_PERFORMANCE> {

    public ContContractPerformanceConfig() {
        super(PREFIX_CONTRACT, CONT_CONTRACT_PERFORMANCE.$TABLE,"cont_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {



    }

    @Override
    public void configFields(ViewOptions view) {

        view.field(CONT_CONTRACT_PERFORMANCE.ID)
                .basic().hidden();

        view.field(CONT_CONTRACT_PERFORMANCE.CONTRACT_ID)
                .basic().hidden();

        view.field(CONT_CONTRACT_PERFORMANCE.PERFORMANCE_TIME)
                .basic().label("履约日期")
        .form().dateInput().format("yyyy-MM-dd");

        view.field(CONT_CONTRACT_PERFORMANCE.DETAIL)
                .form().textArea().height(100);

        view.field(CONT_CONTRACT_PERFORMANCE.CREATE_TIME)
                .basic().label("登记时间");

//        view.field(SYS_DICT.IS_TREE).basic().hidden();
//
//        view.field(SYS_DICT.MODULE)
//                .basic().label("模块")
//                .form().validate().required()
//                .form().selectBox().queryApi(MenuServiceProxy.QUERY_LIST+"?parentId=0").paging(false).filter(false).toolbar(false)
//                .valueField(MenuMeta.ID).textField(MenuMeta.LABEL).fillWith(DictMeta.MODULE_INFO).muliti(false,false)
//                .search().triggerOnSelect(true);
//
//        view.field(SYS_DICT.CODE)
//                .basic().label("代码")
//                .form().validate().required()
//                .search().fuzzySearch()
//        ;
//
//        view.field(SYS_DICT.NAME)
//                .basic().label("名称")
//                .form().validate().required()
//                .search().fuzzySearch();
//
//        //
//        view.formWindow().bottomSpace(120);

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {

        view.formWindow().width("600px");

        form.addGroup(null,new Object[]{
                CONT_CONTRACT_PERFORMANCE.TITLE,
                CONT_CONTRACT_PERFORMANCE.PERFORMANCE_TIME,
                CONT_CONTRACT_PERFORMANCE.DETAIL
        });
        //嵌入页面，页面在 loadTest1Iframe 函数中载入
        form.addPage("attachment","附件","loadAttachmentFrame");
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        view.search().disable();
        view.list().disableMargin();
        list.columnLayout(CONT_CONTRACT_PERFORMANCE.PERFORMANCE_TIME,CONT_CONTRACT_PERFORMANCE.TITLE,CONT_CONTRACT_PERFORMANCE.DETAIL,CONT_CONTRACT_PERFORMANCE.CREATE_TIME);
    }

    @Override
    public void configOverrides() {
        this.context.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE); //扩展页面
    }






}





