package com.dt.eam.generator.module;

import com.dt.eam.constants.db.EAMTables;
import com.dt.eam.constants.db.EAMTables.EAM_BRAND;
import com.dt.eam.generator.config.EamConfigs;
import com.dt.eam.generator.config.EamConfigs.ProjectConfigs;
import com.dt.eam.proxy.EAMServiceNames;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
 
 

/**
 * 为以usr_开头的表生成代码
 */
public class EamCodeGenerator  {
 
	public static void main(String[] args) throws Exception {
		EamCodeGenerator g=new EamCodeGenerator();
		g.generateEamBrandConfig();
 		g.generateEamGoodsConfig();
 		g.generateEamMaintainerConfig();
 		g.generateEamManufacturerConfig();
	}
	
	private EamConfigs configs;
	
 
	public EamCodeGenerator() {
		this("service-eam");
	}
	
	public EamCodeGenerator(String appConfigPrefix) {
		configs=new EamConfigs(appConfigPrefix);
	}
	
	
	protected ModuleContext createModuleConfig(DBTable table,String tablePrefix,int apiSort) {

		//项目配置
		ProjectConfigs procfg=this.configs.getProjectConfigs();
		
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
		return createModuleConfig(table, "eam_", apiSort);
	}
	
	
	private void generateEamBrandConfig() throws Exception {
		
		//创建模块配置
		ModuleContext cfg=createModuleConfig(EAM_BRAND.$TABLE, 1);

		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
		.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
		//生成代码
		cfg.buildAll();


	}

	private void generateEamGoodsConfig() throws Exception {
		ModuleContext cfg2=createModuleConfig(EAMTables.EAM_GOODS.$TABLE, 2);
		//文件生成覆盖模式
		cfg2.overrides()
				.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
				.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
				.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
				.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
				.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
		//生成代码
		cfg2.buildAll();
	}
	private void generateEamMaintainerConfig() throws Exception {
		ModuleContext cfg2=createModuleConfig(EAMTables.EAM_MAINTAINER.$TABLE, 3);
		//文件生成覆盖模式
		cfg2.overrides()
				.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
				.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
				.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
				.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
				.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
		//生成代码
		cfg2.buildAll();
	}

	private void generateEamManufacturerConfig() throws Exception {
		ModuleContext cfg2=createModuleConfig(EAMTables.EAM_MANUFACTURER.$TABLE, 4);
		//文件生成覆盖模式
		cfg2.overrides()
				.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
				.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
				.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
				.setFormPage(WriteMode.CREATE_IF_NOT_EXISTS) //表单HTML页
				.setListPage(WriteMode.CREATE_IF_NOT_EXISTS); //列表HTML页
		//生成代码
		cfg2.buildAll();
	}




}
