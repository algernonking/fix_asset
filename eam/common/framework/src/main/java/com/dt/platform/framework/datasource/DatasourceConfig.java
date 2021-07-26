package com.dt.platform.framework.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
	
	public static final String PRIMARY_DATASOURCE_CONFIG_KEY = "spring.datasource.druid.primary";
	public static final String PRIMARY_DATA_SOURCE_NAME = "primaryDataSource";

	@Bean(name = PRIMARY_DATA_SOURCE_NAME)
	@ConfigurationProperties(PRIMARY_DATASOURCE_CONFIG_KEY)
	public DruidDataSource primaryDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	@Primary
	public DataSourceTransactionManager primaryTransactionManager(
			@Qualifier(PRIMARY_DATA_SOURCE_NAME) DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}


}
