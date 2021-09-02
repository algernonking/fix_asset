package com.dt.platform.generator.module.contract;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.contract.page.ContractFundPageController;
import com.dt.platform.contract.page.ContractPageController;
import com.dt.platform.proxy.contract.ContractFundServiceProxy;
import com.dt.platform.proxy.contract.ContractServiceProxy;
import com.github.foxnic.generator.config.WriteMode;


public class ContractFundGtr extends BaseCodeGenerator {

//    public DcAreaGtr() {
//        super(EAMTables.DC_AREA.$TABLE,BASIC_DATA_MENU_ID);
//    }

    public ContractFundGtr() {
        super(EAMTables.CONT_CONTRACT_FUND.$TABLE,BASIC_MGR_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());
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
        ContractFundGtr g=new ContractFundGtr();
       // g.reGenerateMenu();
        //生成代码
        g.generateCode();

        //生成菜单
       // g.generateMenu(ContractFundServiceProxy.class, ContractFundPageController.class);
//     //  g.reGenerateMenu(AreaServiceProxy.class,AreaPageController.class);
    }
}
