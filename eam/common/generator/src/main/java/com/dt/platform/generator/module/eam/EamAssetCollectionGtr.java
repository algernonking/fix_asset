package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.page.AssetBorrowPageController;
import com.dt.platform.eam.page.AssetCollectionPageController;
import com.dt.platform.eam.service.impl.AssetHandleServiceImpl;
import com.dt.platform.eam.service.impl.AssetItemServiceImpl;
import com.dt.platform.ops.service.impl.HostMidServiceImpl;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.dt.platform.proxy.eam.AssetCollectionServiceProxy;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;

public class EamAssetCollectionGtr extends BaseCodeGenerator {

    public EamAssetCollectionGtr() {
        super(EAMTables.EAM_ASSET_COLLECTION.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());


        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");

        cfg.getPoClassFile().addListProperty(Asset.class,"assetList","资产","资产");
        cfg.getPoClassFile().addListProperty(String.class,"assetIds","资产列表","资产列表");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"originator","制单人","制单人");
        cfg.getPoClassFile().addSimpleProperty(Employee.class,"useUser","使用人员","使用人员");



        cfg.service().addRelationSaveAction(AssetItemServiceImpl.class, AssetCollectionVOMeta.ASSET_IDS);

        //此设置用于覆盖字段的独立配置；清单中没有出现的，设置为隐藏；重复出现或不存在的字段将抛出异常；只接受 DBField 或 String 类型的元素
        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_COLLECTION.STATUS,
                        EAMTables.EAM_ASSET_COLLECTION.USE_USER_ID,
                        EAMTables.EAM_ASSET_COLLECTION.COLLECTION_DATE,

                },
                new Object[]{
                        EAMTables.EAM_ASSET_COLLECTION.BUSINESS_CODE,
                        EAMTables.EAM_ASSET_COLLECTION.USE_ORGANIZATION_ID,
                        EAMTables.EAM_ASSET_COLLECTION.POSITION_ID,
                        EAMTables.EAM_ASSET_COLLECTION.CONTENT

                }
        );

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.CONTENT).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.BUSINESS_CODE).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.POSITION_DETAIL).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.COLLECTION_DATE).search().range();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.STATUS).form().selectBox().enumType(AssetHandleStatusEnum.class);
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.USE_USER_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.USE_ORGANIZATION_ID).form().validate().required();


        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.COLLECTION_DATE).form().validate().required();

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.CREATE_TIME).table().disable();

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.CREATE_TIME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.NAME).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.PROC_ID).table().disable();
        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.BUSINESS_DATE).table().hidden();

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.CONTENT).form().textArea().height(30).search().fuzzySearch();

        cfg.view().field(EAMTables.EAM_ASSET_COLLECTION.POSITION_ID)
                .basic().label("存放位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(true).toolbar(false)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME).fillBy(AssetCollectionMeta.POSITION).muliti(false);

        cfg.view().list().operationColumn().addActionButton("单据","downloadBill",null);
        cfg.view().list().operationColumn().width(250);

        //分成分组布局
        cfg.view().formWindow().bottomSpace(250);
        cfg.view().formWindow().width("85%");
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION.USE_USER_ID,
                        EAMTables.EAM_ASSET_COLLECTION.USE_ORGANIZATION_ID


                }, new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION.COLLECTION_DATE,
                        EAMTables.EAM_ASSET_COLLECTION.POSITION_ID


                }, new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION.ORIGINATOR_ID
                }
        );

        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION.POSITION_DETAIL,
                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_COLLECTION.CONTENT,
                }
        );


        cfg.view().form().addJsVariable("EMPLOYEE_ID",   "[[${user.getUser().getActivatedEmployeeId()}]]","用户ID");
        cfg.view().form().addJsVariable("EMPLOYEE_NAME", "[[${user.getUser().getActivatedEmployeeName()}]]","用户姓名");


        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetCollectionGtr g=new EamAssetCollectionGtr();

        //生成代码
       g.generateCode();
        //生成菜单
        //g.generateMenu(AssetCollectionServiceProxy.class, AssetCollectionPageController.class);

    }

}
