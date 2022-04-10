package com.dt.platform.generator.module.cms;

import com.dt.platform.generator.config.PlatformConfigs;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.util.ModuleCodeConfig;
import com.github.foxnic.generator.util.ModuleCodeGenerator;
import com.github.foxnic.sql.meta.DBTable;

public class CodeStarter extends ModuleCodeGenerator {

    public static void main(String[] args) {

        CodeStarter g=new CodeStarter();
        g.initModules();
        g.start();

    }

    public void initModules()
    {
        initSystemModules();
    }


    private void initSystemModules() {

        this.addConfig(new CmsCategoryGtr());


    }



    public static abstract class BaseCodeConfig<T extends DBTable> extends ModuleCodeConfig<T> {

        public static final String PREFIX_CONTRACT="service-cms";

        private PlatformConfigs configs;
        private int apiSort;


        public BaseCodeConfig(String appConfigPrefix, T table, String tablePrefix, int apiSort) {
            super(table,tablePrefix);
            this.apiSort=apiSort;
            this.configs=new PlatformConfigs(appConfigPrefix);
        }

        @Override
        protected ModuleContext createModuleContext() {
            return createModuleConfig();
        }

        protected ModuleContext createModuleConfig() {

            //项目配置
            PlatformConfigs.ProjectConfigs procfg=this.configs.getProjectConfigs();


            ModuleContext mdu=new ModuleContext(this.configs.getSettings(),TABLE,tablePrefix,procfg.getAppPackageName());
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
            mdu.setMicroServiceNameConst(ServiceNames.class.getName()+"."+procfg.getAppMicroServiceNameConst());

            return mdu;

        }

    }

}
