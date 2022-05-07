package com.dt.platform.generator.constants;

import com.dt.platform.generator.config.PlatformConfigs;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.constants.DBMetaClassFile;


public class WorkOrderDBMetaGenerator {


	/**
	 * 运行main函数生成代码
	 * */
	public static void main(String[] args) throws Exception {
		WorkOrderDBMetaGenerator g = new WorkOrderDBMetaGenerator();
		g.buildDBMeta();
	}

	private PlatformConfigs configs;
	private DAO dao;

	public WorkOrderDBMetaGenerator() {
		this.configs=new PlatformConfigs("service-eam");
		this.dao=this.configs.getDAO();
	}


	/**
	 * 生成DBMeta数据
	 * */
	private void buildDBMeta() {

		// 主文件
		DBMetaClassFile dbMetaBuilder=new DBMetaClassFile(dao,configs.getDomianProject(),this.configs.getProjectConfigs().getDomainConstantsPackage(),"WorkorderTables");
		dbMetaBuilder.setTableFilter(table->{
			table=table.toLowerCase();
			if( table.startsWith("wo_")) return true;
			return false;
		});
		dbMetaBuilder.save(true);



	}

}
