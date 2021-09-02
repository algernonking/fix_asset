package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.contract.page.ContractPageController;
import com.dt.platform.proxy.contract.ContractServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class ContractGtr extends BaseCodeGenerator {
//
//    public DcAreaGtr() {
//        super(EAMTables.DC_AREA.$TABLE,BASIC_DATA_MENU_ID);
//    }

    public ContractGtr() {
        super(EAMTables.CONT_CONTRACT.$TABLE,BASIC_MGR_MENU_ID);

    }



    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());


        cfg.view().field(EAMTables.CONT_CONTRACT.NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_CONTRACT.FIRST_COMPANY_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_CONTRACT.RELATED_COMPANY_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_CONTRACT.CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.CONT_CONTRACT.NOTES).search().fuzzySearch();


        cfg.view().field(EAMTables.CONT_CONTRACT.ATTACH).table().disable(true);
        cfg.view().field(EAMTables.CONT_CONTRACT.CREATE_TIME).table().disable(true);
        cfg.view().field(EAMTables.CONT_CONTRACT.NOTES).table().hidden(true);


        cfg.view().field(EAMTables.CONT_CONTRACT.NOTES).form().textArea().height(30);

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.CONT_CONTRACT.NAME,
                        EAMTables.CONT_CONTRACT.CODE,
                        EAMTables.CONT_CONTRACT.FUND_STATUS,
                        EAMTables.CONT_CONTRACT.STATE
                },
                new Object[]{
                        EAMTables.CONT_CONTRACT.FIRST_COMPANY_NAME,
                        EAMTables.CONT_CONTRACT.RELATED_COMPANY_ID,
                        EAMTables.CONT_CONTRACT.RELATED_COMPANY_NAME


                },
                new Object[]{
                        EAMTables.CONT_CONTRACT.EFFECT_TIME,
                        EAMTables.CONT_CONTRACT.LOST_EFFECT_TIME

                }
        );




        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("95%");
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.CONT_CONTRACT.CODE,
                        EAMTables.CONT_CONTRACT.CATEGORY_ID,
                        EAMTables.CONT_CONTRACT.NAME,
                        EAMTables.CONT_CONTRACT.FUND_STATUS,
                        EAMTables.CONT_CONTRACT.STATE,
                        EAMTables.CONT_CONTRACT.BIDDING_ID,
                        EAMTables.CONT_CONTRACT.ALLMONEY

                },
                new Object[]{
                        EAMTables.CONT_CONTRACT.FIRST_COMPANY_NAME,
                        EAMTables.CONT_CONTRACT.FIRST_CONTACTS,
                        EAMTables.CONT_CONTRACT.FIRST_CONTACT_INFORMATION,
                        EAMTables.CONT_CONTRACT.SUPERVISION_UNIT,
                        EAMTables.CONT_CONTRACT.SUPERVISION_CONTACTS,
                        EAMTables.CONT_CONTRACT.SUPERVISION_CONTACT_INFORMATION,
                },
                new Object[]{
                        EAMTables.CONT_CONTRACT.RELATED_COMPANY_ID,
                        EAMTables.CONT_CONTRACT.RELATED_COMPANY_NAME,
                        EAMTables.CONT_CONTRACT.RELATED_CONTACTS,
                        EAMTables.CONT_CONTRACT.RELATED_CONTACT_INFORMATION

                } ,
                new Object[]{
                        EAMTables.CONT_CONTRACT.EFFECT_TIME,
                        EAMTables.CONT_CONTRACT.AUDIT_TIME,
                        EAMTables.CONT_CONTRACT.END_TIME,
                        EAMTables.CONT_CONTRACT.LOST_EFFECT_TIME
              }
        );
        cfg.view().form().addGroup(null,
                new Object[]{
                        EAMTables.CONT_CONTRACT.ATTACH,
                        EAMTables.CONT_CONTRACT.NOTES,

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
        ContractGtr g=new ContractGtr();
       // g.reGenerateMenu();
        //生成代码
        g.generateCode();

        //生成菜单

      //  g.generateMenu(ContractServiceProxy.class, ContractPageController.class);
     //  g.reGenerateMenu(AreaServiceProxy.class,AreaPageController.class);
    }
}
