package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT_ATTACHMENT;
import com.dt.platform.constants.enums.contract.AttachmentOwnerType;
import com.dt.platform.constants.enums.contract.AttachmentType;
import com.dt.platform.generator.module.CodeStarter;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;

public class ContContractAttachmentConfig extends CodeStarter.BaseCodeConfig<CONT_CONTRACT_ATTACHMENT> {

    public ContContractAttachmentConfig() {
        super(PREFIX_CONTRACT, CONT_CONTRACT_ATTACHMENT.$TABLE,"cont_", 4);
    }



    @Override
    public void configService(ServiceOptions service) {

    }

    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {

        poType.shadow(CONT_CONTRACT_ATTACHMENT.OWNER_TYPE, AttachmentOwnerType.class);
        poType.shadow(CONT_CONTRACT_ATTACHMENT.TYPE, AttachmentType.class);

    }

    @Override
    public void configFields(ViewOptions view) {

        view.field(CONT_CONTRACT_ATTACHMENT.ID)
                .basic().hidden();

        view.field(CONT_CONTRACT_ATTACHMENT.OWNER_TYPE)
                .basic().hidden();

        view.field(CONT_CONTRACT_ATTACHMENT.OWNER_ID)
                .basic().hidden();

        view.field(CONT_CONTRACT_ATTACHMENT.NOTES)
                .form().textArea();

        view.field(CONT_CONTRACT_ATTACHMENT.FILE_ID)
                .basic().label("附件")
                .form().validate().required()
                .form().upload().acceptAllType().acceptSingleFile();

        view.field(CONT_CONTRACT_ATTACHMENT.TYPE).form().radioBox().enumType(AttachmentType.class)
        .form().validate().required();

        view.field(CONT_CONTRACT_ATTACHMENT.NAME)
                .form().validate().required();

        view.field(CONT_CONTRACT_ATTACHMENT.CREATE_TIME).basic().label("上传时间");

    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        view.search().disable();
        view.list().disableMargin();
        list.columnLayout(CONT_CONTRACT_ATTACHMENT.TYPE,CONT_CONTRACT_ATTACHMENT.NAME,CONT_CONTRACT_ATTACHMENT.CREATE_TIME);
        list.operationColumn().addActionButton("下载","download");
    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {
        form.labelWidth(80);
        form.columnLayout(new Object[]{
                CONT_CONTRACT_ATTACHMENT.NAME,
                CONT_CONTRACT_ATTACHMENT.TYPE,
                CONT_CONTRACT_ATTACHMENT.FILE_ID,
                CONT_CONTRACT_ATTACHMENT.NOTES
        });

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





