package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;


import com.dt.platform.domain.eam.meta.TplFileMeta;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.system.UserTenant;

import java.util.Iterator;

public class OPSRelationManager extends RelationManager {
    @Override
    protected void config() {
        this.setupRelations();
        this.setupProperties();

        this.setupOpsHost();
        this.setupOpsDbInstance();

        this.setupOpsServiceCategory();
        this.setupOpsServiceInfo();

        this.setupVoucherOwner();

        this.setupInfoSystem();

        this.setupTplFile();


    }


    public void setupTplFile() {

    }



    public void setupProperties() {

    }

    private void setupRelations() {
        //关联服务分组
        this.property(TplFileMeta.FILE_PROP)
                .using(EAMTables.EAM_TPL_FILE.FILE_ID).join(FoxnicWeb.SYS_FILE.ID);
    }


    private void setupOpsServiceCategory() {

        //关联服务分组
        this.property(ServiceCategoryMeta.GROUP_PROP)
                .using(EAMTables.OPS_SERVICE_CATEGORY.GROUP_ID).join(EAMTables.OPS_SERVICE_GROUP.CODE);


    }


    private void setupOpsServiceInfo() {
        //关联服务类型
        this.property(ServiceInfoMeta.SERVICE_CATEGORY_PROP)
                .using(EAMTables.OPS_SERVICE_INFO.SERVICE_CATEGORY_ID).join(EAMTables.OPS_SERVICE_CATEGORY.ID);

        //关联服务分组
        this.property(ServiceInfoMeta.GROUP_PROP)
                .using(EAMTables.OPS_SERVICE_INFO.GROUP_ID).join(EAMTables.OPS_SERVICE_GROUP.CODE);

    }

    private void setupOpsDbInstance() {

        this.property(DbInstanceMeta.HOST_PROP)
                .using(EAMTables.OPS_DB_INSTANCE.HOST_ID).join(EAMTables.OPS_HOST.ID);

        this.property(DbInstanceMeta.DATABASE_PROP)
                .using(EAMTables.OPS_DB_INSTANCE.DATABASE_ID).join(EAMTables.OPS_SERVICE_INFO.ID);

    }



    private void setupInfoSystem() {

        //用户凭证
        this.property(InformationSystemMeta.VOUCHER_LIST_PROP)
                .using(EAMTables.OPS_INFORMATION_SYSTEM.ID).join(EAMTables.OPS_VOUCHER.OWNER_ID)
                .after((voucherowner,voucher)->{
                    Iterator var2 = voucher.iterator();
                    while(var2.hasNext()) {
                        Voucher obj = (Voucher)var2.next();
                        String pwd="";
                        String voucherStr=obj.getVoucher();
                        if(voucherStr!=null&&voucherStr.length()>5){
                            pwd=","+voucherStr.replaceFirst(voucherStr.substring(0,4),"***" )+"***";
                        }
                        obj.setVoucher("("+obj.getUserCode()+pwd+")");
                    }
                    return voucher;
                });

    }


    private void setupVoucherOwner() {
        //用户凭证
        this.property(VoucherOwnerMeta.VOUCHER_LIST_PROP)
                .using(EAMTables.OPS_VOUCHER_OWNER.ID).join(EAMTables.OPS_VOUCHER.OWNER_ID)
                .after((voucherowner,voucher)->{
                    Iterator var2 = voucher.iterator();
                    while(var2.hasNext()) {
                        Voucher obj = (Voucher)var2.next();
                        String pwd="";
                        String voucherStr=obj.getVoucher();
                         if(voucherStr!=null&&voucherStr.length()>5){
                             pwd=","+voucherStr.replaceFirst(voucherStr.substring(0,4),"***" )+"***";
                         }
                        obj.setVoucher("("+obj.getUserCode()+pwd+")");
                    }
                    return voucher;
                });
    }

    private void setupOpsHost() {

        //用户凭证
        this.property(HostMeta.VOUCHER_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_VOUCHER.OWNER_ID)
                .after((voucherowner,voucher)->{
                    Iterator var2 = voucher.iterator();
                    while(var2.hasNext()) {
                        Voucher obj = (Voucher)var2.next();
                        String pwd="";
                        String voucherStr=obj.getVoucher();
                        if(voucherStr!=null&&voucherStr.length()>5){
                            pwd=","+voucherStr.replaceFirst(voucherStr.substring(0,4),"***" )+"***";
                        }
                        obj.setVoucher("("+obj.getUserCode()+pwd+")");
                    }
                    return voucher;
                });

        //数据库类别
        this.property(HostMeta.HOST_DB_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_DB.HOST_ID)
                .using(EAMTables.OPS_HOST_DB.SERVICE_INFO_ID).join(EAMTables.OPS_SERVICE_INFO.ID)
        .after((host,dbs)->{
            return dbs;
        });

        //中间件列表
        this.property(HostMeta.HOST_MIDDLEWARE_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_MID.HOST_ID)
                .using(EAMTables.OPS_HOST_MID.SERVICE_INFO_ID).join(EAMTables.OPS_SERVICE_INFO.ID);

        //操作系统列表
        this.property(HostMeta.HOST_OS_LIST_PROP)
                .using(EAMTables.OPS_HOST.ID).join(EAMTables.OPS_HOST_OS.HOST_ID)
                .using(EAMTables.OPS_HOST_OS.SERVICE_INFO_ID).join(EAMTables.OPS_SERVICE_INFO.ID);



        //所在位置
        this.property(HostMeta.POSITION_PROP)
                .using(EAMTables.OPS_HOST.POSITION_ID).join(EAMTables.OPS_HOST_POSITION.ID);

        //信息系统
        this.property(HostMeta.INFO_SYSTEM_PROP)
                .using(EAMTables.OPS_HOST.SYSTEM_ID).join(EAMTables.OPS_INFORMATION_SYSTEM.ID);

    }



}
