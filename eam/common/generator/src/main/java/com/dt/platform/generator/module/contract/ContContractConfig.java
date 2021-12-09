package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.contract.ContractStatus;
import com.dt.platform.constants.enums.contract.ContractType;
import com.dt.platform.generator.module.CodeStarter;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.SearchAreaOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Organization;

public class ContContractConfig extends CodeStarter.BaseCodeConfig<CONT_CONTRACT> {

    public ContContractConfig() {
        super(PREFIX_CONTRACT, CONT_CONTRACT.$TABLE,"cont_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        poType.shadow(CONT_CONTRACT.TYPE, ContractType.class);
        poType.shadow(CONT_CONTRACT.CONTRACT_STATUS, ContractStatus.class);
        poType.shadow(CONT_CONTRACT.CONTRACT_STATUS, ContractStatus.class);

        poType.addSimpleProperty(Organization.class,"department","归属部门","归属部门");

    }

    @Override
    public void configFields(ViewOptions view) {

        view.field(CONT_CONTRACT.ID)
                .basic().hidden();

        view.field(CONT_CONTRACT.TYPE)
                .basic().hidden();

        view.field(CONT_CONTRACT.PARENT_ID)
                .basic().hidden();

        view.field(CONT_CONTRACT.DELIVERABLES)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.FUNDING_STATUS)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.DELIVERY_LOCATION)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.AMOUNT)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.SUMMARY)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.DEPARTMENT_ID)
                .basic().label("归属部门");

        view.field(CONT_CONTRACT.CATALOG_CODE).basic().label("合同分类").form().selectBox().muliti(false,false).dict(DictEnum.CONTRACT_CATALOG);
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
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(
                new Object[]{CONT_CONTRACT.CATALOG_CODE,CONT_CONTRACT.TITLE},
                new Object[]{CONT_CONTRACT.CONTRACT_STATUS,CONT_CONTRACT.DEPARTMENT_ID}
        );
        search.rowsDisplay(2);
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
//        list.operationColumn().width(220);
//        //表格操作列增加一个按钮，并指定JS函数
//        list.operationColumn().addActionButton("条目","openDictItemWindow");
    }

    @Override
    public void configOverrides() {
        this.context.overrides()
            .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
            .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
            .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
            .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
            .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
    }







}





