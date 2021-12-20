package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT_SIGNER;
import com.dt.platform.constants.enums.contract.SignerAlias;
import com.dt.platform.constants.enums.contract.SignerType;
import com.dt.platform.generator.module.CodeStarter;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;

public class ContContractSignerConfig extends CodeStarter.BaseCodeConfig<CONT_CONTRACT_SIGNER> {

    public ContContractSignerConfig() {
        super(PREFIX_CONTRACT, CONT_CONTRACT_SIGNER.$TABLE,"cont_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        poType.shadow(CONT_CONTRACT_SIGNER.ALIAS, SignerAlias.class);
        poType.shadow(CONT_CONTRACT_SIGNER.TYPE, SignerType.class);

    }

    @Override
    public void configFields(ViewOptions view) {

        view.field(CONT_CONTRACT_SIGNER.ID)
                .basic().hidden();

        view.field(CONT_CONTRACT_SIGNER.CONTRACT_ID)
                .basic().hidden();

        view.field(CONT_CONTRACT_SIGNER.TYPE).basic().label("类型").table().sort(false)
                .form().radioBox().enumType(SignerType.class)
                .form().validate().required();

        view.field(CONT_CONTRACT_SIGNER.ALIAS).basic().label("签订方").table().sort(false)
                .form().selectBox().enumType(SignerAlias.class)
                .form().validate().required();

        view.field(CONT_CONTRACT_SIGNER.IDENTITY_CDOE).form().validate().required();
        view.field(CONT_CONTRACT_SIGNER.NAME).form().validate().required();

        view.field(CONT_CONTRACT_SIGNER.NAME).table().sort(false);

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {

        form.labelWidth(80);

        super.configForm(view, form);
        //分成分组布局
        view.formWindow().width("600px");
        form.addGroup("signer-info","签订方",
                new Object[] {
                        CONT_CONTRACT_SIGNER.ALIAS,
                        CONT_CONTRACT_SIGNER.TYPE,
                        CONT_CONTRACT_SIGNER.IDENTITY_CDOE,
                        CONT_CONTRACT_SIGNER.NAME,
                        CONT_CONTRACT_SIGNER.ADDRESS
                }
        );

        form.addGroup("contact-info","联系方式",
                new Object[] {
                        CONT_CONTRACT_SIGNER.CONTACT_PERSON,
                        CONT_CONTRACT_SIGNER.LANDLINE_NUMBER,
                },
                new Object[] {
                    CONT_CONTRACT_SIGNER.CONTACT_PHONE,
                    CONT_CONTRACT_SIGNER.FAX_NUMBER,
                }
        );

    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        view.search().disable();
        view.list().disableMargin();
        list.columnLayout(CONT_CONTRACT_SIGNER.ALIAS,CONT_CONTRACT_SIGNER.NAME);
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





