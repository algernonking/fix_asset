package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbInstance;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 02:47:43
 * @sign AEAB002B98D62808787FAEC78A22EB54
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbInstanceMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 主机编号 , 类型: java.lang.String
	*/
	public static final String HOST_ID="hostId";
	
	/**
	 * 主机编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> HOST_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,HOST_ID, java.lang.String.class, "主机编号", "主机编号", java.lang.String.class, null);
	
	/**
	 * 数据库编号 , 类型: java.lang.String
	*/
	public static final String DATABASE_ID="databaseId";
	
	/**
	 * 数据库编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> DATABASE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,DATABASE_ID, java.lang.String.class, "数据库编号", "数据库编号", java.lang.String.class, null);
	
	/**
	 * 实例名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 实例名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,NAME, java.lang.String.class, "实例名称", "实例名称", java.lang.String.class, null);
	
	/**
	 * 日志模式 , 类型: java.lang.String
	*/
	public static final String LOG_METHOD="logMethod";
	
	/**
	 * 日志模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> LOG_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,LOG_METHOD, java.lang.String.class, "日志模式", "日志模式", java.lang.String.class, null);
	
	/**
	 * 备份策略 , 类型: java.lang.String
	*/
	public static final String BACKUP_STRATEGY="backupStrategy";
	
	/**
	 * 备份策略 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> BACKUP_STRATEGY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,BACKUP_STRATEGY, java.lang.String.class, "备份策略", "备份策略", java.lang.String.class, null);
	
	/**
	 * 备份类型 , 类型: java.lang.String
	*/
	public static final String BACKUP_TYPE="backupType";
	
	/**
	 * 备份类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> BACKUP_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,BACKUP_TYPE, java.lang.String.class, "备份类型", "备份类型", java.lang.String.class, null);
	
	/**
	 * 备份保留时长 , 类型: java.lang.String
	*/
	public static final String BACKUP_DATAKEEP="backupDatakeep";
	
	/**
	 * 备份保留时长 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> BACKUP_DATAKEEP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,BACKUP_DATAKEEP, java.lang.String.class, "备份保留时长", "备份保留时长", java.lang.String.class, null);
	
	/**
	 * 备份状态 , 类型: java.lang.String
	*/
	public static final String BACKUP_STATUS="backupStatus";
	
	/**
	 * 备份状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> BACKUP_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,BACKUP_STATUS, java.lang.String.class, "备份状态", "备份状态", java.lang.String.class, null);
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final String BACKUP_METHOD="backupMethod";
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> BACKUP_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,BACKUP_METHOD, java.lang.String.class, "备份方式", "备份方式", java.lang.String.class, null);
	
	/**
	 * 上次备份 , 类型: java.util.Date
	*/
	public static final String BACKUP_TIME="backupTime";
	
	/**
	 * 上次备份 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.util.Date> BACKUP_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,BACKUP_TIME, java.util.Date.class, "上次备份", "上次备份", java.util.Date.class, null);
	
	/**
	 * 备份大小 , 类型: java.math.BigDecimal
	*/
	public static final String BACKUP_SIZE="backupSize";
	
	/**
	 * 备份大小 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.math.BigDecimal> BACKUP_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,BACKUP_SIZE, java.math.BigDecimal.class, "备份大小", "备份大小", java.math.BigDecimal.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABELS="labels";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> LABELS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,LABELS, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 所在位置 , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final String HOST="host";
	
	/**
	 * 所在位置 , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,com.dt.platform.domain.ops.Host> HOST_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,HOST, com.dt.platform.domain.ops.Host.class, "所在位置", "所在位置", com.dt.platform.domain.ops.Host.class, null);
	
	/**
	 * 数据库 , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final String DATABASE="database";
	
	/**
	 * 数据库 , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstance,com.dt.platform.domain.ops.ServiceInfo> DATABASE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstance.class ,DATABASE, com.dt.platform.domain.ops.ServiceInfo.class, "数据库", "数据库", com.dt.platform.domain.ops.ServiceInfo.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , HOST_ID , DATABASE_ID , NAME , LOG_METHOD , BACKUP_STRATEGY , BACKUP_TYPE , BACKUP_DATAKEEP , BACKUP_STATUS , BACKUP_METHOD , BACKUP_TIME , BACKUP_SIZE , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , HOST , DATABASE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbInstance {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbInstance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 主机编号
		 * @param hostId 主机编号
		 * @return 当前对象
		*/
		public DbInstance setHostId(String hostId) {
			super.change(HOST_ID,super.getHostId(),hostId);
			super.setHostId(hostId);
			return this;
		}
		
		/**
		 * 设置 数据库编号
		 * @param databaseId 数据库编号
		 * @return 当前对象
		*/
		public DbInstance setDatabaseId(String databaseId) {
			super.change(DATABASE_ID,super.getDatabaseId(),databaseId);
			super.setDatabaseId(databaseId);
			return this;
		}
		
		/**
		 * 设置 实例名称
		 * @param name 实例名称
		 * @return 当前对象
		*/
		public DbInstance setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 日志模式
		 * @param logMethod 日志模式
		 * @return 当前对象
		*/
		public DbInstance setLogMethod(String logMethod) {
			super.change(LOG_METHOD,super.getLogMethod(),logMethod);
			super.setLogMethod(logMethod);
			return this;
		}
		
		/**
		 * 设置 备份策略
		 * @param backupStrategy 备份策略
		 * @return 当前对象
		*/
		public DbInstance setBackupStrategy(String backupStrategy) {
			super.change(BACKUP_STRATEGY,super.getBackupStrategy(),backupStrategy);
			super.setBackupStrategy(backupStrategy);
			return this;
		}
		
		/**
		 * 设置 备份类型
		 * @param backupType 备份类型
		 * @return 当前对象
		*/
		public DbInstance setBackupType(String backupType) {
			super.change(BACKUP_TYPE,super.getBackupType(),backupType);
			super.setBackupType(backupType);
			return this;
		}
		
		/**
		 * 设置 备份保留时长
		 * @param backupDatakeep 备份保留时长
		 * @return 当前对象
		*/
		public DbInstance setBackupDatakeep(String backupDatakeep) {
			super.change(BACKUP_DATAKEEP,super.getBackupDatakeep(),backupDatakeep);
			super.setBackupDatakeep(backupDatakeep);
			return this;
		}
		
		/**
		 * 设置 备份状态
		 * @param backupStatus 备份状态
		 * @return 当前对象
		*/
		public DbInstance setBackupStatus(String backupStatus) {
			super.change(BACKUP_STATUS,super.getBackupStatus(),backupStatus);
			super.setBackupStatus(backupStatus);
			return this;
		}
		
		/**
		 * 设置 备份方式
		 * @param backupMethod 备份方式
		 * @return 当前对象
		*/
		public DbInstance setBackupMethod(String backupMethod) {
			super.change(BACKUP_METHOD,super.getBackupMethod(),backupMethod);
			super.setBackupMethod(backupMethod);
			return this;
		}
		
		/**
		 * 设置 上次备份
		 * @param backupTime 上次备份
		 * @return 当前对象
		*/
		public DbInstance setBackupTime(Date backupTime) {
			super.change(BACKUP_TIME,super.getBackupTime(),backupTime);
			super.setBackupTime(backupTime);
			return this;
		}
		
		/**
		 * 设置 备份大小
		 * @param backupSize 备份大小
		 * @return 当前对象
		*/
		public DbInstance setBackupSize(BigDecimal backupSize) {
			super.change(BACKUP_SIZE,super.getBackupSize(),backupSize);
			super.setBackupSize(backupSize);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param labels 标签
		 * @return 当前对象
		*/
		public DbInstance setLabels(String labels) {
			super.change(LABELS,super.getLabels(),labels);
			super.setLabels(labels);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbInstance setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbInstance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbInstance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbInstance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbInstance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbInstance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbInstance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbInstance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbInstance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DbInstance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 所在位置
		 * @param host 所在位置
		 * @return 当前对象
		*/
		public DbInstance setHost(Host host) {
			super.change(HOST,super.getHost(),host);
			super.setHost(host);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param database 数据库
		 * @return 当前对象
		*/
		public DbInstance setDatabase(ServiceInfo database) {
			super.change(DATABASE,super.getDatabase(),database);
			super.setDatabase(database);
			return this;
		}
	}
}