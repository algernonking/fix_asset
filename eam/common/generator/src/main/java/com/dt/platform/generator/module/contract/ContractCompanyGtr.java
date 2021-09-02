package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.contract.page.CompanyPageController;
import com.dt.platform.proxy.contract.CompanyServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class ContractCompanyGtr extends BaseCodeGenerator {
//
//    public DcAreaGtr() {
//        super(EAMTables.DC_AREA.$TABLE,BASIC_DATA_MENU_ID);
//    }

    public ContractCompanyGtr() {
        super(EAMTables.CONT_COMPANY.$TABLE,BASIC_MGR_MENU_ID);

    }



    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.view().field(EAMTables.CONT_COMPANY.ID).basic().hidden();

        cfg.view().field(EAMTables.CONT_COMPANY.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_COMPANY.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_COMPANY.ADDRESS).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_COMPANY.CONTACT_INFORMATION).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_COMPANY.CONTACTS).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_COMPANY.PROFILE).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_COMPANY.ID).table().disable(true);
        cfg.view().field(EAMTables.CONT_COMPANY.PROFILE).table().disable(true);

        cfg.view().field(EAMTables.CONT_COMPANY.NAME).form().validate().required();
        cfg.view().field(EAMTables.CONT_COMPANY.NOTES).form().textArea().height(30);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.CONT_COMPANY.NAME,
                        EAMTables.CONT_COMPANY.CREDIT_CODE,
                        EAMTables.CONT_COMPANY.ADDRESS,
                        EAMTables.CONT_COMPANY.NOTES
                },
                new Object[]{
                        EAMTables.CONT_COMPANY.CONTACTS,
                        EAMTables.CONT_COMPANY.CONTACT_INFORMATION
                }
        );



        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.CONT_COMPANY.NAME,
                        EAMTables.CONT_COMPANY.PROFILE,
                },
                new Object[]{
                        EAMTables.CONT_COMPANY.CREDIT_CODE,
                        EAMTables.CONT_COMPANY.ADDRESS,
                },
                new Object[]{
                        EAMTables.CONT_COMPANY.CONTACTS,
                        EAMTables.CONT_COMPANY.CONTACT_INFORMATION

                }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.CONT_COMPANY.NOTES,

                }
        );


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE) //列表HTML页
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);
        //生成代码
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        ContractCompanyGtr g=new ContractCompanyGtr();
       // g.reGenerateMenu();
        //生成代码
        g.generateCode();

        //生成菜单
        // g.generateMenu(CompanyServiceProxy.class, CompanyPageController.class);

    }
}
