package com.dt.platform.generator.module;

import com.dt.platform.constants.db.EAMTables.*;
import com.github.foxnic.generator.config.ModuleContext;
import com.github.foxnic.generator.config.WriteMode;
import com.github.foxnic.sql.meta.DBTable;


public class DataCenterCodeGenerator extends EamCodeGenerator {

	public static void main(String[] args) throws Exception {
		DataCenterCodeGenerator g=new DataCenterCodeGenerator();

		g.generateDcInfo();



	}

	public DataCenterCodeGenerator() {
		super("service-datacenter");
	}
 
	public ModuleContext createModuleConfig(DBTable table,int apiSort) {
		return createModuleConfig(table, "", apiSort);
	}
	
	
	private void generateDcInfo() throws Exception {
		//创建配置
//		ModuleContext cfg=createModuleConfig(DC_INFO.$TABLE, 1);
		
//		//文件生成覆盖模式
//		cfg.overrides()
//		.setServiceIntfAnfImpl(WriteMode.COVER_EXISTS_FILE) //服务与接口
//		.setControllerAndAgent(WriteMode.COVER_EXISTS_FILE) //Rest
//		.setPageController(WriteMode.COVER_EXISTS_FILE) //页面控制器
//		.setFormPage(WriteMode.COVER_EXISTS_FILE) //表单HTML页
//		.setListPage(WriteMode.COVER_EXISTS_FILE); //列表HTML页
//
//		//生成代码
//		cfg.buildAll();
	}
	

	 
	 
	
	 
	
	
	

}
