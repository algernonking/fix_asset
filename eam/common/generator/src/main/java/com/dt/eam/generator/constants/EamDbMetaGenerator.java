package com.dt.eam.generator.constants;

import com.dt.eam.generator.config.EamConfigs;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;


public class EamDbMetaGenerator  {
 
 
	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		EamDbMetaGenerator g = new EamDbMetaGenerator();
		g.buildDBMeta();
	}
	
	private EamConfigs configs;
	private DAO dao;
	
	public EamDbMetaGenerator() {
		this.configs=new EamConfigs("service-eam");
		this.dao=this.configs.getDAO();
	}

 
	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {
		
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"EAMTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if(table.startsWith("eam_") || table.startsWith("hrm_") || table.startsWith("dc_") || table.startsWith("ops_")) return true;
			return false;
		});
		dbMetaBuilder.save(true);
	}

}
