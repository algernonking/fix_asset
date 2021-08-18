package com.dt.platform.generator.module.eam;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import com.dt.platform.domain.eam.meta.AssetReturnMeta;
import com.dt.platform.domain.eam.meta.PositionMeta;
import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.github.foxnic.generator.config.WriteMode;

public class EamAssetReturnGtr extends BaseCodeGenerator {

    public EamAssetReturnGtr() {
        super(EAMTables.EAM_ASSET_RETURN.$TABLE,BASIC_DATA_MENU_ID);
    }

    public void generateCode() throws Exception {


        cfg.getPoClassFile().addSimpleProperty(Position.class,"position","存放位置","存放位置");

        cfg.view().search().inputLayout(
                new Object[]{
                        EAMTables.EAM_ASSET_RETURN.BUSINESS_DATE,
                        EAMTables.EAM_ASSET_RETURN.ORIGINATOR_ID,
                        EAMTables.EAM_ASSET_RETURN.CONTENT,
                },
                new Object[]{
                        EAMTables.EAM_ASSET_RETURN.STATUS
                }
        );



        cfg.view().field(EAMTables.EAM_ASSET_RETURN.POSITION_ID).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_RETURN.RETURN_DATE).form().validate().required();
        cfg.view().field(EAMTables.EAM_ASSET_RETURN.POSITION_ID)
                .basic().label("存放位置")
                .form().selectBox().queryApi(PositionServiceProxy.QUERY_LIST).paging(false).filter(false).toolbar(true)
                .valueField(PositionMeta.ID).textField(PositionMeta.NAME).fillBy(AssetReturnMeta.POSITION).muliti(false);




        //分成分组布局
        cfg.view().formWindow().width(1000);
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_RETURN.RETURN_DATE,
                        EAMTables.EAM_ASSET_RETURN.USER_ORGANIZATION_ID

                }, new Object[] {
                        EAMTables.EAM_ASSET_RETURN.POSITION_ID,
                        EAMTables.EAM_ASSET_RETURN.POSITION_DETAIL
                }, new Object[] {
                        EAMTables.EAM_ASSET_RETURN.ORIGINATOR_ID

                }

        );
        cfg.view().form().addGroup(null,
                new Object[] {
                        EAMTables.EAM_ASSET_BORROW.CONTENT,
                }
        );




        //文件生成覆盖模式
        cfg.overrides()
                .setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
                .setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
                .setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
                .setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
                .setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
        cfg.buildAll();
    }
    public static void main(String[] args) throws Exception {
        EamAssetReturnGtr g=new EamAssetReturnGtr();

        //生成代码
        g.generateCode();
        //生成菜单
        //g.generateMenu(MaintainerServiceProxy.class,MaintainerPageController.class);
    }

}
