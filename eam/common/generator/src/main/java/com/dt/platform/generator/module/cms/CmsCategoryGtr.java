package com.dt.platform.generator.module.cms;
import com.dt.platform.constants.db.CmsTables.CMS_CATEGORY;
import com.github.foxnic.generator.builder.business.option.ServiceOptions;
import com.github.foxnic.generator.builder.model.PoClassFile;
import com.github.foxnic.generator.builder.model.VoClassFile;
import com.github.foxnic.generator.builder.view.option.FormOptions;
import com.github.foxnic.generator.builder.view.option.ListOptions;
import com.github.foxnic.generator.builder.view.option.ViewOptions;
import com.github.foxnic.generator.config.WriteMode;

public class CmsCategoryGtr extends CodeStarter.BaseCodeConfig<CMS_CATEGORY> {

    public CmsCategoryGtr() {
        super(PREFIX_CONTRACT, CMS_CATEGORY.$TABLE,"cms_", 4);
    }

    @Override
    public void configService(ServiceOptions service) {
    }
    @Override
    public void configModel(PoClassFile poType, VoClassFile voType) {
//        poType.shadow(CMS_CATEGORY.ALIAS, SignerAlias.class);
//        poType.shadow(CMS_CATEGORY.TYPE, SignerType.class);
    }

    @Override
    public void configFields(ViewOptions view) {
        view.field(CMS_CATEGORY.ID).basic().hidden();

    }

    @Override
    public void configForm(ViewOptions view, FormOptions form) {

        form.labelWidth(80);

        super.configForm(view, form);
        //分成分组布局
        view.formWindow().width("600px");
        form.addGroup("label_1","",
                new Object[] {
                        CMS_CATEGORY.NAME,
                        CMS_CATEGORY.NOTES
                }
        );


    }

    @Override
    public void configList(ViewOptions view, ListOptions list) {
        view.search().disable();
        view.list().disableMargin();
       // list.columnLayout(CONT_CONTRACT_SIGNER.ALIAS,CONT_CONTRACT_SIGNER.NAME);
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





