package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetBorrowStatusEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.AssetHandle;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.eam.page.AssetBorrowPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.generator.builder.view.config.Tab;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.meta.PersonMeta;

public class EamAssetBorrowGtr extends BaseCodeGenerator {

    public EamAssetBorrowGtr() {
        super(
                AssetBorrowServiceProxy.class, AssetBorrowPageController.class,
                EAMTables.EAM_ASSET_BORROW.$TABLE,BASIC_DATA_MENU_ID);
    }



    public void generateCode() throws Exception {

        System.out.println(this.getClass().getName());
        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"borrower","借用人","借用人");
        cfg.service().addRelationSaveAction(AssetItemServiceImpl.class,AssetBorrowVOMeta.ASSET_IDS);
       // cfg.view().list().disableSpaceColumn();
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ID).basic().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.NAME).table().disable().search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BUSINESS_DATE).table().hidden();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.CREATE_TIME).table().hidden();


        cfg.view().field(EAMTables.EAM_ASSET_BORROW.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROWER_ID).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_BORROW.BORROW_TIME).form().validate().required().search().range();
        cfg.view().field(EAMTables.EAM_ASSET_BORROW.CONTENT).form().textArea().height(30).search().fuzzySearch();
        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);
        cfg.view().list().operationColumn().width(250);
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.STATUS,
                        EAMTables.EAM_ASSET_BORROW.BORROWER_ID,
                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME
                },
                new Object[]{
                        EAMTables.EAM_ASSET_BORROW.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_BORROW.CONTENT
                }
        );
        //分成分组布局
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.BORROWER_ID,
                        EAMTables.EAM_ASSET_BORROW.BORROW_TIME
                }, new Object[] {
                        EAMTables.EAM_ASSET_BORROW.PLAN_RETURN_DATE
                }, new Object[] {
                        EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID
                }
        );


        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.CONTENT,
                }
        );

        //改变前端,EAMTables.SYS_CODE_RULE.RULE 在前端显示
        String resourceNameField="res_"+EAMTables.EAM_ASSET_BORROW.ORIGINATOR_ID;
        cfg.view().field(resourceNameField)
                .basic().label("制单人")
                .table().fillBy(AssetBorrowMeta.ORIGINATOR_ID, PersonMeta.NAME);


        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)
                .setExtendJsFile(WriteMode.COVER_EXISTS_FILE);

 
        //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetBorrowGtr g=new EamAssetBorrowGtr();

        //生成代码
        g.generateCode();
       // g.reGenerateMenu();;
        //生成菜单
        //g.generateMenu(AssetBorrowServiceProxy.class, AssetBorrowPageController.class);
    }



}
