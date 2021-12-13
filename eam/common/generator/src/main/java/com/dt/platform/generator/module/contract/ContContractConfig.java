package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.contract.ContractStatus;
import com.dt.platform.constants.enums.contract.ContractType;
import com.dt.platform.constants.enums.contract.FundingStatus;
import com.dt.platform.generator.module.CodeStarter;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
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

        view.field(CONT_CONTRACT.TITLE)
                .table().fix(true)
                .form().validate().required();

        view.field(CONT_CONTRACT.TYPE)
                .basic().search().hidden()
                .form().selectBox().enumType(ContractType.class).defaultValue(ContractType.MAIN)
                .form().validate().required();

        view.field(CONT_CONTRACT.PARENT_ID)
                .basic().hidden();

        view.field(CONT_CONTRACT.CONTRACT_NO)
                .table().fix(true);

        view.field(CONT_CONTRACT.DELIVERABLES)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.FUNDING_DIRECTION)
                .form().selectBox().dict(DictEnum.FUNDING_DIRECTION).muliti(false,false).defaultIndex(0)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.DELIVERY_LOCATION)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.AMOUNT)
                .form().numberInput().decimal().scale(2)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.SUMMARY)
                .search().hidden().table().hidden();

        view.field(CONT_CONTRACT.DEPARTMENT_ID)
                .basic().label("归属部门")
                .form().validate().required()
                .form().button().chooseOrganization(true);

        view.field(CONT_CONTRACT.CONTRACT_STATUS).basic().label("合同状态")
                .form().selectBox().muliti(false,false).enumType(ContractStatus.class);
        view.field(CONT_CONTRACT.CATALOG_CODE).basic().label("合同分类")
                .form().validate().required()
                .form().selectBox().muliti(false,false).dict(DictEnum.CONTRACT_CATALOG);

        view.field(CONT_CONTRACT.FUNDING_STATUS)
                .form().selectBox().muliti(false,false).enumType(FundingStatus.class);

        view.field(CONT_CONTRACT.EFFECTIVE_DATE)
                .form().dateInput().format("yyyy-MM-dd");

        view.field(CONT_CONTRACT.SIGNING_DATE)
                .form().dateInput().format("yyyy-MM-dd");

        view.field(CONT_CONTRACT.END_DATE)
                .form().dateInput().format("yyyy-MM-dd");

        view.field(CONT_CONTRACT.EXPIRATION_DATE)
                .form().dateInput().format("yyyy-MM-dd");


    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {

        form.labelWidth(80);

        //分成分组布局
        view.formWindow().width("800px");
        form.addGroup("contract-info","合同信息",
                new Object[] {
                        CONT_CONTRACT.TITLE,
                        CONT_CONTRACT.CONTRACT_NO
                }
        );

        //嵌入页面，页面在 loadTest1Iframe 函数中载入
        form.addPage("signer","签订方","loadSignerFrame");

        form.addGroup("detail","详细信息",
                new Object[] {
                        CONT_CONTRACT.TYPE,CONT_CONTRACT.CONTRACT_STATUS,
                        CONT_CONTRACT.DELIVERABLES, CONT_CONTRACT.DEPARTMENT_ID,
                        CONT_CONTRACT.SIGNING_DATE,CONT_CONTRACT.END_DATE
                }, new Object[] {
                        CONT_CONTRACT.CATALOG_CODE, CONT_CONTRACT.DELIVERY_LOCATION,
                        CONT_CONTRACT.AMOUNT,CONT_CONTRACT.EFFECTIVE_DATE,
                        CONT_CONTRACT.EXPIRATION_DATE
                }
        );

        form.addGroup(null,
                new Object[] {
                        CONT_CONTRACT.SUMMARY
                }
        );



        form.addGroup("funding","资金情况",
                new Object[] {
                        CONT_CONTRACT.FUNDING_DIRECTION
                }, new Object[] {
                        CONT_CONTRACT.FUNDING_STATUS
                }
        );

        //嵌入页面，页面在 loadTest1Iframe 函数中载入
        form.addPage("attachment","合同附件","loadAttachmentFrame");

        //嵌入页面，页面在 loadTest1Iframe 函数中载入
        form.addPage("performance","执行情况","loadPerformanceFrame");



    }

    @Override
    public void configSearch(ViewOptions view, SearchAreaOptions search) {
        search.inputLayout(
                new Object[]{CONT_CONTRACT.CATALOG_CODE,CONT_CONTRACT.CONTRACT_NO,CONT_CONTRACT.TITLE,CONT_CONTRACT.SIGNING_DATE},
                new Object[]{CONT_CONTRACT.CONTRACT_STATUS,CONT_CONTRACT.DEPARTMENT_ID,CONT_CONTRACT.FUNDING_STATUS,CONT_CONTRACT.EFFECTIVE_DATE}
        );
        search.rowsDisplay(2);
    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
//        list.operationColumn().width(220);
//        //表格操作列增加一个按钮，并指定JS函数
        list.columnLayout(CONT_CONTRACT.CONTRACT_NO,CONT_CONTRACT.TITLE,CONT_CONTRACT.TYPE,CONT_CONTRACT.CATALOG_CODE,
                CONT_CONTRACT.SIGNING_DATE,CONT_CONTRACT.CONTRACT_STATUS,CONT_CONTRACT.DEPARTMENT_ID,CONT_CONTRACT.FUNDING_STATUS,
                CONT_CONTRACT.EFFECTIVE_DATE
        );
        list.operationColumn().addActionMenu("subs","子合同");
        list.operationColumn().addActionMenu("addi","附加协议");

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





