package com.dt.eam.generator.module;

import com.dt.eam.constants.db.EAMTables.HRM_COMPANY;
import com.dt.eam.constants.db.EAMTables.HRM_EMPLOYEE;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;
 

public class HrmCodeGenerator extends EamCodeGenerator {
 
	public static void main(String[] args) throws Exception {
		HrmCodeGenerator g=new HrmCodeGenerator();
		
		g.generateHrmCompany();
		g.generateHrmEmployee();
		
 
	}
 
	public HrmCodeGenerator() {
		super("service-hrm");
	}
 
	public ModuleContext createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "hrm_", apiSort);
	}
	
	
	private void generateHrmEmployee() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(HRM_EMPLOYEE.$TABLE, 1);
		
		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
		.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
 
		//生成代码
		cfg.buildAll();
	}
	
 
	
	private void generateHrmCompany() throws Exception {
		//创建配置
		ModuleContext cfg=createModuleConfig(HRM_COMPANY.$TABLE, 1);
		
		//文件生成覆盖模式
		cfg.overrides()
		.setServiceIntfAnfImpl(WriteMode.CREATE_IF_NOT_EXISTS) //服务与接口
		.setControllerAndAgent(WriteMode.CREATE_IF_NOT_EXISTS) //Rest
		.setPageController(WriteMode.CREATE_IF_NOT_EXISTS) //页面控制器
		.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
		.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页


		//生成代码
		cfg.buildAll();
	}
	
	 
	 
	
	 
	
	
	

}
