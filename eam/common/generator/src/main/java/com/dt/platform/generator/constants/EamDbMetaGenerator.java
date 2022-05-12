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

		// 主文件
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"EAMTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if(table.startsWith("sys_tpl")||
					table.startsWith("sys_code") ||
					table.startsWith("eam_") ) return true;
			return false;
		});
		dbMetaBuilder.save(true);

		// 第二个文件
		dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"ContractTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if( table.startsWith("cont_")) return true;
			return false;
		});
		dbMetaBuilder.save(true);




	}

}
