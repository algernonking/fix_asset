package com.dt.platform.generator.constants;

import com.dt.platform.generator.config.PlatformConfigs;
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
	
	private PlatformConfigs configs;
	private DAO dao;
	
	public EamDbMetaGenerator() {
		this.configs=new PlatformConfigs("service-eam");
		this.dao=this.configs.getDAO();
	}

 
	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {
		
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"EAMTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if( table.startsWith("rfid_")|| table.startsWith("cont_")|| table.startsWith("kn_") ||table.startsWith("workorder_")||    table.startsWith("sys_tpl")||  table.startsWith("sys_code") ||table.startsWith("eam_") || table.startsWith("hrm_") || table.startsWith("dc_") || table.startsWith("ops_")) return true;
			return false;
		});
		dbMetaBuilder.save(true);
	}

}
