package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.page.StockPageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.eam.StockServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;

public class EamAssetStockGtr extends BaseCodeGenerator{
    public EamAssetStockGtr() {
        super(EAMTables.EAM_STOCK.$TABLE,BASIC_ASSET_STOCK_ID);
    }

    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addListProperty(Asset.class,"stockAssetList","库存资产","库存资产");
        cfg.getPoClassFile().addListProperty(String.class,"stockAssetIds","库存资产","库存资产");

        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(ChangeInstance.class,"changeInstance","变更实例","变更实例");

        cfg.view().field(EAMTables.EAM_STOCK.ID).basic().hidden(true);
        cfg.view().field(EAMTables.EAM_STOCK.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK.STOCK_NAME).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK.STOCK_NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_STOCK.BUSINESS_DATE).search().range(true);


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_STOCK.STOCK_NAME,
                        EAMTables.EAM_STOCK.BUSINESS_CODE,
                        EAMTables.EAM_STOCK.STOCK_NOTES,
                        EAMTables.EAM_STOCK.BUSINESS_DATE,
                }
        );

        cfg.view().search().labelWidth(1,Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().labelWidth(4,Config.searchLabelWidth);
        cfg.view().field(EAMTables.EAM_STOCK.STOCK_NAME).form().validate().required();
        //cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_ASSET_DATA_CHANGE.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_STOCK.BUSINESS_DATE).form().dateInput().format("yyyy-MM-dd").search().range();


        cfg.view().list().disableBatchDelete();

        cfg.view().form().addJsVariable("BILL_ID","[[${billId}]]","单据ID");
        cfg.view().form().addJsVariable("BILL_TYPE","[[${billType}]]","单据类型");
        cfg.view().list().addJsVariable("APPROVAL_REQUIRED","[[${approvalRequired}]]","是否需要审批");
        cfg.view().list().addJsVariable("OWNER_CODE","[[${ownerCode}]]","页面类型");


        cfg.view().list().operationColumn().addActionButton("送审","forApproval",null);
        cfg.view().list().operationColumn().addActionButton("确认","confirmData",null);
        cfg.view().list().operationColumn().addActionButton("撤销","revokeData",null);




        cfg.view().formWindow().bottomSpace(100);
        cfg.view().formWindow().width("98%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK.STOCK_NAME,
                }
                , new Object[] {
                        EAMTables.EAM_STOCK.BUSINESS_DATE
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_STOCK.STOCK_NOTES,
                }

        );

        cfg.view().form().addPage("列表","assetSelectList");



        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.IGNORE) //Rest
                .setPageController(WriteMode.IGNORE) //页面控制器
                .setFormPage(WriteMode.IGNORE) //表单HTML页
                .setListPage(WriteMode.IGNORE)//列表HTML页
                .setExtendJsFile(WriteMode.IGNORE); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamAssetStockGtr g=new EamAssetStockGtr();
        //生成代码
         g.generateCode();
        //生成菜单
        //  g.removeByBatchId("");
      //  g.generateMenu(StockServiceProxy.class, StockPageController.class);
    }
}
