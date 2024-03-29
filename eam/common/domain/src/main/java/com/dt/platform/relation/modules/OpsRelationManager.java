package com.dt.platform.relation.modules;


import com.dt.platform.constants.db.EAMTables;


import com.dt.platform.constants.db.OpsTables;
import com.dt.platform.domain.eam.meta.AssetCollectionReturnMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import com.dt.platform.domain.eam.meta.TplFileMeta;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.VoucherPriv;
import com.dt.platform.domain.ops.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.system.UserTenant;

import java.util.Iterator;

public class OpsRelationManager extends RelationManager {
    @Override
    protected void config() {

        this.setupRelations();
        this.setupProperties();
        this.setupOpsHost();
        this.setupOpsDbInstance();
        this.setupOpsServiceCategory();
        this.setupOpsServiceInfo();
        this.setupVoucherOwner();
        this.setupVoucher();
        this.setupVoucherPriv();
        this.setupInfoSystem();
        this.setupTplFile();

        this.setupCertificate();
        this.setupCertificateItem();

    }




    public void setupCertificate() {
        this.property(CertificateMeta.ORIGINATOR_PROP)
                .using(OpsTables.OPS_CERTIFICATE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

        this.property(CertificateMeta.CERTIFICATE_TYPE_PROP)
                .using(OpsTables.OPS_CERTIFICATE.TYPE).join(OpsTables.OPS_CERTIFICATE_TYPE.ID);

        this.property(CertificateMeta.CERTIFICATE_POSITION_PROP)
                .using(OpsTables.OPS_CERTIFICATE.POSITION_ID).join(OpsTables.OPS_CERTIFICATE_POSITION.ID);

    }

    public void setupCertificateItem() {
        this.property(CertificateItemMeta.OPER_USER_PROP)
                .using(OpsTables.OPS_CERTIFICATE_ITEM.OPER_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
    }


    public void setupTplFile() {

    }



    public void setupProperties() {

    }

    private void setupRelations() {
        //关联服务分组
//        this.property(TplFileMeta.FILE_PROP)
//                .using(EAMTables.EAM_TPL_FILE.FILE_ID).join(FoxnicWeb.SYS_FILE.ID);
    }


    private void setupOpsServiceCategory() {

        //关联服务分组
        this.property(ServiceCategoryMeta.GROUP_PROP)
                .using(OpsTables.OPS_SERVICE_CATEGORY.GROUP_ID).join(OpsTables.OPS_SERVICE_GROUP.CODE);


    }


    private void setupOpsServiceInfo() {
        //关联服务类型
        this.property(ServiceInfoMeta.SERVICE_CATEGORY_PROP)
                .using(OpsTables.OPS_SERVICE_INFO.SERVICE_CATEGORY_ID).join(OpsTables.OPS_SERVICE_CATEGORY.ID);

        //关联服务分组
        this.property(ServiceInfoMeta.GROUP_PROP)
                .using(OpsTables.OPS_SERVICE_INFO.GROUP_ID).join(OpsTables.OPS_SERVICE_GROUP.CODE);

    }

    private void setupOpsDbInstance() {

        this.property(DbInstanceMeta.HOST_PROP)
                .using(OpsTables.OPS_DB_INSTANCE.HOST_ID).join(OpsTables.OPS_HOST.ID);

        this.property(DbInstanceMeta.DATABASE_PROP)
                .using(OpsTables.OPS_DB_INSTANCE.DATABASE_ID).join(OpsTables.OPS_SERVICE_INFO.ID);

    }



    private void setupInfoSystem() {

        this.property(InformationSystemMeta.BELONG_ORGANIZATION_PROP)
                .using(OpsTables.OPS_INFORMATION_SYSTEM.BELONG_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

        //用户凭证
        this.property(InformationSystemMeta.VOUCHER_LIST_PROP)
                .using(OpsTables.OPS_INFORMATION_SYSTEM.ID).join(OpsTables.OPS_VOUCHER.OWNER_ID)
                .after((tag,voucherowner,voucher,m)->{
                    Iterator var2 = voucher.iterator();
                    while(var2.hasNext()) {
                        Voucher obj = (Voucher)var2.next();
                        String pwd=",******";
//                        String voucherStr=obj.getVoucher();
//                        if(voucherStr!=null&&voucherStr.length()>5){
//                            pwd=","+voucherStr.replaceFirst(voucherStr.substring(0,4),"***" )+"***";
//                        }
                        obj.setVoucher("("+obj.getUserCode()+pwd+")");
                    }
                    return voucher;
                });

        // 关联来源
        this.property(InformationSystemMeta.INFO_SYSTEM_STATUS_PROP)
                .using(OpsTables.OPS_INFORMATION_SYSTEM.STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_system_status'");


        // 关联来源
        this.property(InformationSystemMeta.INFO_SYSTEM_GRADE_PROP)
                .using(OpsTables.OPS_INFORMATION_SYSTEM.GRADE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_system_grade'");

        // 关联来源
        this.property(InformationSystemMeta.INFO_SYSTEM_OPS_METHOD_PROP)
                .using(OpsTables.OPS_INFORMATION_SYSTEM.OPS_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_system_ops_method'");

        // 关联来源
        this.property(InformationSystemMeta.INFO_SYSTEM_DEV_METHOD_PROP)
                .using(OpsTables.OPS_INFORMATION_SYSTEM.DEV_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_system_dev_method'");


    }


    private void setupVoucherOwner() {
        //用户凭证
        this.property(VoucherOwnerMeta.VOUCHER_LIST_PROP)
                .using(OpsTables.OPS_VOUCHER_OWNER.ID).join(OpsTables.OPS_VOUCHER.OWNER_ID)
                .after((tag,voucherowner,voucher,m)->{
                    Iterator var2 = voucher.iterator();
                    while(var2.hasNext()) {
                        Voucher obj = (Voucher)var2.next();
                        String pwd=",******";
//                        String voucherStr=obj.getVoucher();
//                         if(voucherStr!=null&&voucherStr.length()>5){
//                             pwd=","+voucherStr.replaceFirst(voucherStr.substring(0,4),"***" )+"***";
//                         }
                        obj.setVoucher("("+obj.getUserCode()+pwd+")");
                    }
                    return voucher;
                });

        //凭证类型
        this.property(VoucherOwnerMeta.VOUCHER_CATEGORY_PROP)
                .using(OpsTables.OPS_VOUCHER_OWNER.CATEGORY_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_voucher_type'");
    }

    public void setupVoucher() {

        //凭证类型
        this.property(VoucherMeta.VOUCHER_TYPE_PROP)
                .using(OpsTables.OPS_VOUCHER.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
                .condition("dict_code='ops_voucher_type'");;

    }


    public void setupVoucherPriv() {

        // 关联制单人
        this.property(VoucherPrivMeta.EMPLOYEE_PROP)
                .using(OpsTables.OPS_VOUCHER_PRIV.EMPL_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
//                .using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID);


    }




    private void setupOpsHost() {

        //用户凭证
        this.property(HostMeta.VOUCHER_LIST_PROP)
                .using(OpsTables.OPS_HOST.ID).join(OpsTables.OPS_VOUCHER.OWNER_ID)
                .after((tag,voucherowner,voucher,m)->{
                    Iterator var2 = voucher.iterator();
                    while(var2.hasNext()) {
                        Voucher obj = (Voucher)var2.next();
                        String pwd=",******";
                        String voucherStr=obj.getVoucher();
//                        if(voucherStr!=null&&voucherStr.length()>5){
//                            pwd=","+voucherStr.replaceFirst(voucherStr.substring(0,4),"***" )+"***";
//                        }
                        obj.setVoucher("("+obj.getUserCode()+pwd+")");
                    }
                    return voucher;
                });

        //数据库类别
        this.property(HostMeta.HOST_DB_LIST_PROP)
                .using(OpsTables.OPS_HOST.ID).join(OpsTables.OPS_HOST_DB.HOST_ID)
                .using(OpsTables.OPS_HOST_DB.SERVICE_INFO_ID).join(OpsTables.OPS_SERVICE_INFO.ID)
        .after((tag,host,dbs,m)->{
            return dbs;
        });

        //中间件列表
        this.property(HostMeta.HOST_MIDDLEWARE_LIST_PROP)
                .using(OpsTables.OPS_HOST.ID).join(OpsTables.OPS_HOST_MID.HOST_ID)
                .using(OpsTables.OPS_HOST_MID.SERVICE_INFO_ID).join(OpsTables.OPS_SERVICE_INFO.ID);

        //操作系统列表
        this.property(HostMeta.HOST_OS_LIST_PROP)
                .using(OpsTables.OPS_HOST.ID).join(OpsTables.OPS_HOST_OS.HOST_ID)
                .using(OpsTables.OPS_HOST_OS.SERVICE_INFO_ID).join(OpsTables.OPS_SERVICE_INFO.ID);



        //所在位置
        this.property(HostMeta.POSITION_PROP)
                .using(OpsTables.OPS_HOST.POSITION_ID).join(OpsTables.OPS_HOST_POSITION.ID);

        //信息系统
        this.property(HostMeta.INFO_SYSTEM_PROP)
                .using(OpsTables.OPS_HOST.SYSTEM_ID).join(OpsTables.OPS_INFORMATION_SYSTEM.ID);

        //备份
        this.property(HostMeta.BACKUP_METHOD_PROP)
                .using(OpsTables.OPS_HOST.HOST_BACKUP_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.ID);


    }



}
