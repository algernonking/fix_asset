package com.dt.platform.framework.datasource;

import com.dt.platform.relation.EAMRelationManager;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.dao.sql.loader.SQLoader;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.github.foxnic.sql.meta.DBDataType;
import com.github.foxnic.sql.treaty.DBTreaty;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DAOConfig {

	@Value("${"+ DatasourceConfig.PRIMARY_DATASOURCE_CONFIG_KEY+".printSQL}")
	private Boolean printSQL;

	@Value("${develop.start-relation-monitor}")
	private  Boolean startRelationMonitor=false;

	@Bean(DBConfigs.PRIMARY_DAO)
	@Primary
	public DAO primaryDAO (
            @Qualifier(DatasourceConfig.PRIMARY_DATA_SOURCE_NAME) DataSource dataSource, DBTreaty dbTreaty) {
		try {
			if(printSQL==null) printSQL=false;
			DAO dao= (new DAOBuilder().datasource(dataSource)).build();
			dao.setPrintSQL(printSQL);
			dao.setPrintSQLSimple(printSQL);
			dao.setDBTreaty(dbTreaty);
			EAMRelationManager relationManager=new EAMRelationManager();
			if(startRelationMonitor) {
				relationManager.startMonitor();
			}
			dao.setRelationManager(relationManager);

			//设置序列相关的配置
			dao.setSequenceTable(FoxnicWeb.SYS_SEQUENCE.$NAME);
			dao.setSequenceProcedure("NEXT_VAL");


			//设置SQL扫描
			SQLoader.addTQLScanPackage(dao,SpringUtil.getStartupClass().getPackage().getName());
			ComponentScan sc=(ComponentScan)SpringUtil.getStartupClass().getAnnotation(ComponentScan.class);
			for (String pkg : sc.basePackages()) {
				SQLoader.addTQLScanPackage(dao,pkg);
			}

			Logger.info("dao is ready : \n\n"+dao.toString()+"\n");

			return dao;
		} catch (Exception e) {
			Logger.error("创建DAO失败",e);
			return null;
		}
	}
 
	@Bean
	public DBTreaty getDBTreaty() {
		
		DBTreaty dbTreaty=new DBTreaty();
		//
		dbTreaty.setAllowDeleteWithoutWhere(false);
		dbTreaty.setAllowUpdateWithoutWhere(false);
		
		//
		dbTreaty.setUserIdDataType(DBDataType.STRING);
		//
		dbTreaty.setCreateTimeField("create_time");
		dbTreaty.setCreateUserIdField("create_by");
		//
		dbTreaty.setUpdateTimeField("update_time");
		dbTreaty.setUpdateUserIdField("update_by");
		//
		dbTreaty.setDeletedField("deleted");
		dbTreaty.setDeleteTimeField("delete_time");
		dbTreaty.setDeleteUserIdField("delete_by");
		//
		dbTreaty.setVersionField("version");
		//
		dbTreaty.setAutoCastLogicField(false);
		//
		dbTreaty.setFalseValue(0);
		dbTreaty.setTrueValue(1);
		
		//设置获取当前用户的逻辑
		if(SpringUtil.isReady()) {
			dbTreaty.setUserIdHandler(()->{
				SessionUser user=SessionUser.getCurrent();
				if(user==null) return null;
				return  user.getUserId();
			});
		}
		
		//
		return dbTreaty;
	}
	
}
