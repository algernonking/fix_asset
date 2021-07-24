package com.dt.eam.generator.module.eam;

import com.dt.eam.generator.config.EamConfigs;
import com.dt.eam.proxy.EAMServiceNames;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.sql.meta.DBTable;

public class BaseCodeGenerator {

    public String appConfigPrefix= "service-eam";

    public String tablePrefix="eam_";

    public EamConfigs configs;

    public BaseCodeGenerator() {
        configs=new EamConfigs(appConfigPrefix);
    }

    public ModuleContext createModuleConfig(DBTable table, String tablePrefix, int apiSort) {

        //项目配置
        EamConfigs.ProjectConfigs procfg=this.configs.getProjectConfigs();

        ModuleContext mdu=new ModuleContext(this.configs.getSettings(),table,tablePrefix,procfg.getAppPackageName());
        //设置页面的代码文件路径
        mdu.setViewPrefixPath(procfg.getAppViewPrefixPath());
        //设置页面访问的基础URI
        mdu.setViewPrefixURI(procfg.getAppViewPrefixURI());
        //设置 DAO
        mdu.setDAO(this.configs.getDAO());
        //设置 Domain Project
        mdu.setDomainProject(this.configs.getDomianProject());
        //设置 Proxy Project
        mdu.setProxyProject(this.configs.getProxyProject());
        //设置 Service Project
        mdu.setServiceProject(this.configs.getServiceProject());
        //设置 View Project
        mdu.setViewProject(this.configs.getViewProject());
        //设置 Wrapper Project
        mdu.setWrapperProject(this.configs.getWrapperProject());
        //设置DAO名称常量
        mdu.setDAONameConsts(procfg.getDAONameConst());
        //设置微服务命名常量
        mdu.setMicroServiceNameConst(EAMServiceNames.class.getName()+"."+procfg.getAppMicroServiceNameConst());
        return mdu;
    }

    public ModuleContext createModuleConfig(DBTable table,int apiSort) {
        return createModuleConfig(table, tablePrefix, apiSort);
    }

}
