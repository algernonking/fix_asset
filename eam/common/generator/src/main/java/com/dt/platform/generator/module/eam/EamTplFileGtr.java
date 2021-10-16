package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetTplFileTypeEnum;
import com.dt.platform.domain.common.CodeRegister;
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.meta.CodeRegisterMeta;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import com.dt.platform.domain.eam.TplFile;
import com.dt.platform.domain.eam.meta.TplFileMeta;
import com.dt.platform.eam.page.TplFilePageController;
import com.dt.platform.generator.config.Config;
import com.dt.platform.proxy.common.CodeRegisterServiceProxy;
import com.dt.platform.proxy.eam.TplFileServiceProxy;
import com.github.foxnic.generator.config.WriteMode;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.domain.storage.meta.FileMeta;

public class EamTplFileGtr extends BaseCodeGenerator{
    public EamTplFileGtr() {
        super(EAMTables.EAM_TPL_FILE.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {
        System.out.println(this.getClass().getName());

        cfg.getPoClassFile().addSimpleProperty(CodeRegister.class,"businessCode","业务编码","业务编码");

        cfg.view().field(EAMTables.EAM_TPL_FILE.ID).basic().hidden(true);

        cfg.view().field(EAMTables.EAM_TPL_FILE.NOTES).search().fuzzySearch();
        cfg.view().field(EAMTables.EAM_TPL_FILE.NAME).search().fuzzySearch();


        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_TPL_FILE.TYPE,
                        EAMTables.EAM_TPL_FILE.NAME,
                        EAMTables.EAM_TPL_FILE.NOTES,
                }
        );
        cfg.view().search().labelWidth(1, Config.searchLabelWidth);
        cfg.view().search().labelWidth(2,Config.searchLabelWidth);
        cfg.view().search().labelWidth(3,Config.searchLabelWidth);
        cfg.view().search().inputWidth(Config.searchInputWidth);



        cfg.view().field(EAMTables.EAM_TPL_FILE.NAME).form().validate().required();

        cfg.view().field(EAMTables.EAM_TPL_FILE.FILE_ID).form().validate().required().form().upload().maxFileCount(1);

        cfg.view().field(EAMTables.EAM_TPL_FILE.TYPE).form().validate().required().form()
                .selectBox().enumType(AssetTplFileTypeEnum.class).defaultIndex(0);

        cfg.view().field(EAMTables.EAM_TPL_FILE.NOTES).form().textArea().height(30);


        cfg.view().field(EAMTables.EAM_TPL_FILE.CODE)
                .form().validate().required().form().selectBox().paging(true).filter(true).toolbar(false).muliti(false)
                .queryApi(CodeRegisterServiceProxy.QUERY_PAGED_LIST)
                .textField(CodeRegisterMeta.NAME).valueField(CodeRegisterMeta.CODE ).fillWith(TplFileMeta.BUSINESS_CODE);




        //分成分组布局
        cfg.view().formWindow().width("80%");
        cfg.view().formWindow().bottomSpace(200);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_TPL_FILE.NAME,
                        EAMTables.EAM_TPL_FILE.TYPE,
                }, new Object[] {
                        EAMTables.EAM_TPL_FILE.CODE
                }, new Object[] {
                        EAMTables.EAM_TPL_FILE.FILE_ID

                }
        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_TPL_FILE.NOTES
                }
        );



        //指定关联对象的属性填充单元格，为了避免名称重复，加一个前缀
        //改变前端,EAMTables.SYS_CODE_RULE.RULE 在前端显示
//        String resourceNameField="res_"+EAMTables.EAM_TPL_FILE.FILE_ID;
//        cfg.view().field(resourceNameField)
//                .basic().label("存放位置")
//                .table().fillBy(TplFileMeta.FILE, FileMeta.LOCATION);

        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.IGNORE) //服务与接口
                .setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
                .setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE)//列表HTML页
                .setExtendJsFile(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
        cfg.buildAll();
    }

    public static void main(String[] args) throws Exception {
        EamTplFileGtr g=new EamTplFileGtr();
        //生成代码
        g.generateCode();


        //生成菜单
        //g.removeByBatchId("");
       // g.generateMenu(TplFileServiceProxy.class, TplFilePageController.class);
    }


}
