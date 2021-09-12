package com.dt.platform.generator.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dt.platform.framework.datasource.DAOConfig;
import com.dt.platform.framework.datasource.DatasourceConfig;
import com.dt.platform.relation.PlatformRelationManager;
import com.github.foxnic.commons.cache.Variable;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.network.Machine;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.commons.property.YMLProperties;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.dao.spec.DAOBuilder;
import com.github.foxnic.generator.config.GlobalSettings;
import com.github.foxnic.sql.treaty.DBTreaty;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.framework.nacos.NacosConfig;

import java.io.File;

public class PlatformConfigs {
	
	private String appConfigPrefix;
	private ProjectConfigs projectConfigs;
	
	

	protected GlobalSettings settings=null;
	
	//
	private MavenProject  generatorProject=null;
	private MavenProject  domianProject=null;
	private MavenProject serviceProject;
	private MavenProject proxyProject;
	private MavenProject viewProject;
	private MavenProject wrapperProject;
	
	


	//
	private String nacosGroup;
	private String nacosDataId;
	
	//
	private String nacosServerAddr = null;
	private String nacosNamespace=null;
	private String nacosUserName=null;
	private String nacosPassword=null;
	//
	private String datasourceConfigKey=null;
	//
	private YMLProperties applicationConfigs;
	private DAO dao;
	
	
//	public FoxnicWebConfigs() {
//		this(FoxnicWebConstants.SERVICE_SYSTEM_PROJECT_FOLDER_NAME, FoxnicWebConstants.PRIMARY_DATASOURCE_CONFIG_KEY, FoxnicWebConstants.NACOS_GROUP, FoxnicWebConstants.DEFAULT_NACOS_DATA_ID);
//	}
//	
//	public FoxnicWebConfigs(String serviceProjectFolderName) {
//		this(serviceProjectFolderName, FoxnicWebConstants.PRIMARY_DATASOURCE_CONFIG_KEY, FoxnicWebConstants.NACOS_GROUP, FoxnicWebConstants.DEFAULT_NACOS_DATA_ID);
//	}
//	
//	public FoxnicWebConfigs(String serviceProjectFolderName,String datasourceConfigKey,String nacosGroup,String nacosDataId) {
//		
	
	public PlatformConfigs(String appId) {
		
		System.out.println("machine Id : "+Machine.getIdentity());
		
		initGlobalSettings();
		//
		generatorProject=new MavenProject(PlatformConfigs.class);
		
		
		File configFile=FileUtil.resolveByPath(this.generatorProject.getMainResourceDir(), "config.yml");
		this.appConfigPrefix="applications."+appId;
		projectConfigs=new ProjectConfigs(this.appConfigPrefix,new YMLProperties(configFile));
		
		File baseDir=generatorProject.getProjectDir().getParentFile().getParentFile();
		
		//
		File domainProjectFolder=FileUtil.resolveByPath(baseDir, this.projectConfigs.getDomainProjectPath());
		domianProject=new MavenProject(domainProjectFolder); 
		
		File serviceProjectFolder=FileUtil.resolveByPath(baseDir,  projectConfigs.getAppServiceProjectPath());
		serviceProject=new MavenProject(serviceProjectFolder);
		
		File proxyProjectFolder=FileUtil.resolveByPath(baseDir,  this.projectConfigs.getProxyProjectPath());
		proxyProject=new MavenProject(proxyProjectFolder);
		
		File viewProjectFolder=FileUtil.resolveByPath(baseDir,  this.projectConfigs.getAppViewProjectPath());
		viewProject=new MavenProject(viewProjectFolder);
		
		File wrapperProjectFolder=FileUtil.resolveByPath(baseDir,  this.projectConfigs.getAppWrapperProjectPath());
		wrapperProject=new MavenProject(wrapperProjectFolder);
		
		
		//读取配置
		File bootstrapFile=FileUtil.resolveByPath(this.getWrapperProject().getMainResourceDir(), "bootstrap.yml");
		File applicationFile=FileUtil.resolveByPath(this.getWrapperProject().getMainResourceDir(), "application.yml");
		
		if(bootstrapFile.exists() && !applicationFile.exists()) {
			YMLProperties bootstrapProperties=new YMLProperties(bootstrapFile);
			nacosServerAddr=bootstrapProperties.getProperty("application.nacos.ip").stringValue();
			nacosUserName=bootstrapProperties.getProperty("application.nacos.username").stringValue();
			nacosPassword=bootstrapProperties.getProperty("application.nacos.password").stringValue();
			nacosNamespace=bootstrapProperties.getProperty("application.nacos.namespace").stringValue();
			this.nacosDataId=this.projectConfigs.getAppNacosDataId();
			this.nacosGroup=this.projectConfigs.getAppNacosGroup();
			File file= this.saveRemoteConfig();
			//配置文件
			applicationConfigs=new YMLProperties(file);
		} else if(!bootstrapFile.exists() && applicationFile.exists()) {
			applicationConfigs=new YMLProperties(applicationFile);
		}
 
		this.datasourceConfigKey=this.projectConfigs.getAppPrimaryDatasourceConfigKey();
 
		try {
			initDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String author=projectConfigs.getAuthorInfo();
		
		if(author==null) {
			throw new IllegalArgumentException("请按机器码 "+Machine.getIdentity()+" 配置开发人员");
		}
		
		this.settings.setAuthor(author);
		this.settings.setEnableSwagger(projectConfigs.isEnableSwagger());
		this.settings.setEnableMicroService(projectConfigs.isEnableMicroService());
		//强制实体重建
		this.settings.setRebuildEntity(true);
	}

	
	
	private void initGlobalSettings() {
		this.settings=new GlobalSettings();
		this.settings.setAuthor("李方捷");
	}

	private void initDAO() throws Exception {
		
		if(dao!=null) return;
		
		// 读取数据库配置
		
		String prefix=this.getDatasourceConfigKey()+".";
		//
		String driver=applicationConfigs.getProperty(prefix+"driver-class-name").stringValue();
		String url=applicationConfigs.getProperty(prefix+"url").stringValue();
		String username=applicationConfigs.getProperty(prefix+"username").stringValue();
		String password=applicationConfigs.getProperty(prefix+"password").stringValue();
		
		// 创建数据源
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driver);
		ds.setUsername(username);
		ds.setPassword(password);

		DBConfigs.reset(ds, DatasourceConfig.PRIMARY_DATASOURCE_CONFIG_KEY,applicationConfigs);

		dao = (new DAOBuilder()).datasource(ds).build();
		
		// 设置数据库规约
		DBTreaty dbTreaty = (new DAOConfig()).getDBTreaty();
		dao.setDBTreaty(dbTreaty);
		dao.setRelationManager(new PlatformRelationManager());
		
 
	}

	private File saveRemoteConfig() {
		NacosConfig nacosConfig=new NacosConfig(this.getNacosServerAddr(), this.getNacosNamespace(), this.getNacosUserName(), this.getNacosPassword());
		File file=FileUtil.resolveByPath(this.getGeneratorProject().getMainResourceDir(), "remote",this.getNacosNamespace()+"."+this.nacosGroup+"."+this.nacosDataId);
		nacosConfig.saveConfig(this.nacosDataId, this.nacosGroup, file);
		return file;
	}
	
	public MavenProject getGeneratorProject() {
		return generatorProject;
	}



	public MavenProject getDomianProject() {
		return domianProject;
	}

	public ProjectConfigs getProjectConfigs() {
		return projectConfigs;
	}
	
	public MavenProject getViewProject() {
		return viewProject;
	}

	public MavenProject getServiceProject() {
		return serviceProject;
	}



	public MavenProject getProxyProject() {
		return proxyProject;
	}
 
	public String getNacosServerAddr() {
		return nacosServerAddr;
	}
 
	public String getNacosNamespace() {
		return nacosNamespace;
	}
 
	public String getNacosUserName() {
		return nacosUserName;
	}
 
	public String getNacosPassword() {
		return nacosPassword;
	}
 
	public String getDatasourceConfigKey() {
		return datasourceConfigKey;
	}
 
	public DAO getDAO() {
		return dao;
	}

	public GlobalSettings getSettings() {
		return settings;
	}
	
	public static class ProjectConfigs {
		private YMLProperties properties;
		private String appConfigPrefix;
		public ProjectConfigs(String appConfigPrefix,YMLProperties properties) {
			this.properties=properties;
			this.appConfigPrefix=appConfigPrefix;
		}
		
		

		public String getDAONameConst() {
			return properties.getProperty("source.daoNameConst").stringValue();
		}
		
		/**
		 * 获得 nacos group
		 * */
		public String getAppNacosGroup() {
			return properties.getProperty(this.appConfigPrefix+".nacosGroup").stringValue();
		}
		
		/**
		 * 获得 nacos group
		 * */
		public String getAppNacosDataId() {
			return properties.getProperty(this.appConfigPrefix+".nacosDataId").stringValue();
		}
		
		/**
		 * 获得 enableMicroService
		 * */
		public boolean isEnableMicroService() {
			return properties.getProperty("settings.enableMicroService").booleanValue();
		}
		
		/**
		 * 获得 isFrontendDepart
		 * */
		public boolean isFrontendDepart() {
			return properties.getProperty("settings.isFrontendDepart").booleanValue();
		}
		
		
		
		/**
		 * 获得 enableSwagger
		 * */
		public boolean isEnableSwagger() {
			return properties.getProperty("settings.enableSwagger").booleanValue();
		}
		
		/**
		 * 获得 domain 的路径
		 * */
		public String getDomainProjectPath() {
			return properties.getProperty("compoments.domain").stringValue();
		}
		
		/**
		 * 获得 proxy 的路径
		 * */
		public String getProxyProjectPath() {
			return properties.getProperty("compoments.proxy").stringValue();
		}
		
		/**
		 * 获得 domain 的路径
		 * */
		public String getDomainConstantsPackage() {
			return properties.getProperty("source.domainConstantsPackage").stringValue();
		}
		
		
		
		
		/**
		 * 获得应用的路径
		 * */
		public String getAppServiceProjectPath() {
			return properties.getProperty(this.appConfigPrefix+".serviceProjectPath").stringValue();
		}
		
		public String getAppWrapperProjectPath() {
			return properties.getProperty(this.appConfigPrefix+".wrapperProjectPath").stringValue();
		}
		
		public String getAppPrimaryDatasourceConfigKey() {
			return properties.getProperty(this.appConfigPrefix+".primaryDatasourceConfigKey").stringValue();
		}
		
		public String getAppMicroServiceNameConst() {
			return properties.getProperty(this.appConfigPrefix+".microServiceNameConst").stringValue();
		}
		
		public String getAppPackageName() {
			return properties.getProperty(this.appConfigPrefix+".packageName").stringValue();
		}
		
		public String getAppViewProjectPath() {
			return properties.getProperty(this.appConfigPrefix+".viewProjectPath").stringValue();
		}
		
		public String getAppViewPrefixPath() {
			return properties.getProperty(this.appConfigPrefix+".viewPrefixPath").stringValue();
		}
		
		
		
		public String getAppViewPrefixURI() {
			String codePathPrefix=this.getAppViewPrefixPath();
			return codePathPrefix.substring(codePathPrefix.indexOf("/"));
		}
		
		public String getAuthorInfo() {
			Variable var=properties.getProperty("authors."+Machine.getIdentity());
			if(var==null) {
				return null;
			}
			return var.stringValue();
		}
		
		
		
		
		
	}

	public MavenProject getWrapperProject() {
		return wrapperProject;
	}


 
}


