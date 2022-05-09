package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-05-07 16:39:54
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class OpsTables {
	
	/**
	 * 自动化配置
	*/
	public static class OPS_AUTOMATIC_CONF extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_automatic_conf";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		*/
		public static final DBField OPER_CONF = new DBField(DBDataType.STRING , "oper_conf","operConf","oper_conf","oper_conf",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_AUTOMATIC_CONF() {
			this.init($NAME,"自动化配置" , ID , STATUS , NAME , OPER_CONF , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_AUTOMATIC_CONF $TABLE=new OPS_AUTOMATIC_CONF();
	}
	
	/**
	 * 自动化动作
	*/
	public static class OPS_AUTOMATIC_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_automatic_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 存储类型
		*/
		public static final DBField STORAGE_TYPE = new DBField(DBDataType.STRING , "storage_type","storageType","存储类型","存储类型",false,false,true);
		
		/**
		 * 文件类型
		*/
		public static final DBField FILE_TYPE = new DBField(DBDataType.STRING , "file_type","fileType","文件类型","文件类型",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_AUTOMATIC_FILE() {
			this.init($NAME,"自动化动作" , ID , NAME , STORAGE_TYPE , FILE_TYPE , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_AUTOMATIC_FILE $TABLE=new OPS_AUTOMATIC_FILE();
	}
	
	/**
	 * 自动化实例
	*/
	public static class OPS_AUTOMATIC_INSTANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_automatic_instance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","状态","状态",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_AUTOMATIC_INSTANCE() {
			this.init($NAME,"自动化实例" , ID , NAME , TPL_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_AUTOMATIC_INSTANCE $TABLE=new OPS_AUTOMATIC_INSTANCE();
	}
	
	/**
	 * 自动化操作日志
	*/
	public static class OPS_AUTOMATIC_OPER_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_automatic_oper_log";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 节点列表
		*/
		public static final DBField NODE_LIST = new DBField(DBDataType.STRING , "node_list","nodeList","节点列表","节点列表",false,false,true);
		
		/**
		 * 配置
		*/
		public static final DBField OPER_CONF = new DBField(DBDataType.STRING , "oper_conf","operConf","配置","配置",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CT = new DBField(DBDataType.STRING , "ct","ct","内容","内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_AUTOMATIC_OPER_LOG() {
			this.init($NAME,"自动化操作日志" , ID , NAME , NODE_LIST , OPER_CONF , CT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_AUTOMATIC_OPER_LOG $TABLE=new OPS_AUTOMATIC_OPER_LOG();
	}
	
	/**
	 * 自动化模板
	*/
	public static class OPS_AUTOMATIC_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_automatic_tpl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 配置文件
		*/
		public static final DBField AUTO_CONF_FILE = new DBField(DBDataType.STRING , "auto_conf_file","autoConfFile","配置文件","配置文件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_AUTOMATIC_TPL() {
			this.init($NAME,"自动化模板" , ID , NAME , AUTO_CONF_FILE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_AUTOMATIC_TPL $TABLE=new OPS_AUTOMATIC_TPL();
	}
	
	/**
	 * 数据库实例
	*/
	public static class OPS_DB_INSTANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_db_instance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机编号
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机编号","主机编号",false,false,true);
		
		/**
		 * 数据库编号
		*/
		public static final DBField DATABASE_ID = new DBField(DBDataType.STRING , "database_id","databaseId","数据库编号","数据库编号",false,false,true);
		
		/**
		 * 实例名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","实例名称","实例名称",false,false,true);
		
		/**
		 * 日志模式
		*/
		public static final DBField LOG_METHOD = new DBField(DBDataType.STRING , "log_method","logMethod","日志模式","日志模式",false,false,true);
		
		/**
		 * 备份策略
		*/
		public static final DBField BACKUP_STRATEGY = new DBField(DBDataType.STRING , "backup_strategy","backupStrategy","备份策略","备份策略",false,false,true);
		
		/**
		 * 备份类型
		*/
		public static final DBField BACKUP_TYPE = new DBField(DBDataType.STRING , "backup_type","backupType","备份类型","备份类型",false,false,true);
		
		/**
		 * 备份保留时长
		*/
		public static final DBField BACKUP_DATAKEEP = new DBField(DBDataType.STRING , "backup_datakeep","backupDatakeep","备份保留时长","备份保留时长",false,false,true);
		
		/**
		 * 备份状态
		*/
		public static final DBField BACKUP_STATUS = new DBField(DBDataType.STRING , "backup_status","backupStatus","备份状态","备份状态",false,false,true);
		
		/**
		 * 备份方式
		*/
		public static final DBField BACKUP_METHOD = new DBField(DBDataType.STRING , "backup_method","backupMethod","备份方式","备份方式",false,false,true);
		
		/**
		 * 上次备份
		*/
		public static final DBField BACKUP_TIME = new DBField(DBDataType.DATE , "backup_time","backupTime","上次备份","上次备份",false,false,true);
		
		/**
		 * 备份大小
		*/
		public static final DBField BACKUP_SIZE = new DBField(DBDataType.DECIMAL , "backup_size","backupSize","备份大小","备份大小",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABELS = new DBField(DBDataType.STRING , "labels","labels","标签","标签",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_DB_INSTANCE() {
			this.init($NAME,"数据库实例" , ID , HOST_ID , DATABASE_ID , NAME , LOG_METHOD , BACKUP_STRATEGY , BACKUP_TYPE , BACKUP_DATAKEEP , BACKUP_STATUS , BACKUP_METHOD , BACKUP_TIME , BACKUP_SIZE , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_DB_INSTANCE $TABLE=new OPS_DB_INSTANCE();
	}
	
	/**
	 * 主机
	*/
	public static class OPS_HOST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 信息系统
		*/
		public static final DBField SYSTEM_ID = new DBField(DBDataType.STRING , "system_id","systemId","信息系统","信息系统",false,false,true);
		
		/**
		 * 主机类型
		*/
		public static final DBField HOST_TYPE = new DBField(DBDataType.STRING , "host_type","hostType","主机类型","主机类型",false,false,true);
		
		/**
		 * 主机状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","主机状态","主机状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField HOST_NAME = new DBField(DBDataType.STRING , "host_name","hostName","名称","名称",false,false,true);
		
		/**
		 * 物理IP
		*/
		public static final DBField HOST_IP = new DBField(DBDataType.STRING , "host_ip","hostIp","物理IP","物理IP",false,false,true);
		
		/**
		 * 虚拟VIP
		*/
		public static final DBField HOST_VIP = new DBField(DBDataType.STRING , "host_vip","hostVip","虚拟VIP","虚拟VIP",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT = new DBField(DBDataType.STRING , "environment","environment","运行环境","运行环境",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","位置","位置",false,false,true);
		
		/**
		 * 监控状态
		*/
		public static final DBField MONITOR_STATUS = new DBField(DBDataType.STRING , "monitor_status","monitorStatus","监控状态","监控状态",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField DIRECTOR_USERNAME = new DBField(DBDataType.STRING , "director_username","directorUsername","负责人","负责人",false,false,true);
		
		/**
		 * 内存
		*/
		public static final DBField HOST_MEMORY = new DBField(DBDataType.DECIMAL , "host_memory","hostMemory","内存","内存",false,false,true);
		
		/**
		 * CPU
		*/
		public static final DBField HOST_CPU = new DBField(DBDataType.DECIMAL , "host_cpu","hostCpu","CPU","CPU",false,false,true);
		
		/**
		 * 其他配置
		*/
		public static final DBField HOST_CONF = new DBField(DBDataType.STRING , "host_conf","hostConf","其他配置","其他配置",false,false,true);
		
		/**
		 * 系统管理员
		*/
		public static final DBField USER_OS_ADMIN = new DBField(DBDataType.STRING , "user_os_admin","userOsAdmin","系统管理员","系统管理员",false,false,true);
		
		/**
		 * 数据库管理员
		*/
		public static final DBField USER_DB_ADMIN = new DBField(DBDataType.STRING , "user_db_admin","userDbAdmin","数据库管理员","数据库管理员",false,false,true);
		
		/**
		 * 数据库使用用户
		*/
		public static final DBField USER_DB_USED = new DBField(DBDataType.STRING , "user_db_used","userDbUsed","数据库使用用户","数据库使用用户",false,false,true);
		
		/**
		 * 应用使用用户
		*/
		public static final DBField USER_APP_USED = new DBField(DBDataType.STRING , "user_app_used","userAppUsed","应用使用用户","应用使用用户",false,false,true);
		
		/**
		 * 运维操作用户
		*/
		public static final DBField USER_OPS_OPER = new DBField(DBDataType.STRING , "user_ops_oper","userOpsOper","运维操作用户","运维操作用户",false,false,true);
		
		/**
		 * 其他用户
		*/
		public static final DBField USER_OTHER = new DBField(DBDataType.STRING , "user_other","userOther","其他用户","其他用户",false,false,true);
		
		/**
		 * 改密策略
		*/
		public static final DBField PASSWORD_STRATEGY_ID = new DBField(DBDataType.STRING , "password_strategy_id","passwordStrategyId","改密策略","改密策略",false,false,true);
		
		/**
		 * 备份方式
		*/
		public static final DBField HOST_BACKUP_METHOD = new DBField(DBDataType.STRING , "host_backup_method","hostBackupMethod","备份方式","备份方式",false,false,true);
		
		/**
		 * 备份情况
		*/
		public static final DBField HOST_BACKUP_INFO = new DBField(DBDataType.STRING , "host_backup_info","hostBackupInfo","备份情况","备份情况",false,false,true);
		
		/**
		 * 下线时间
		*/
		public static final DBField OFFLINE_TIME = new DBField(DBDataType.DATE , "offline_time","offlineTime","下线时间","下线时间",false,false,true);
		
		/**
		 * 上线时间
		*/
		public static final DBField ONLINE_TIME = new DBField(DBDataType.DATE , "online_time","onlineTime","上线时间","上线时间",false,false,true);
		
		/**
		 * 是否归档
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","是否归档","是否归档",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABELS = new DBField(DBDataType.STRING , "labels","labels","标签","标签",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField HOST_NOTES = new DBField(DBDataType.STRING , "host_notes","hostNotes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_HOST() {
			this.init($NAME,"主机" , ID , SYSTEM_ID , HOST_TYPE , STATUS , HOST_NAME , HOST_IP , HOST_VIP , ENVIRONMENT , POSITION_ID , MONITOR_STATUS , DIRECTOR_USERNAME , HOST_MEMORY , HOST_CPU , HOST_CONF , USER_OS_ADMIN , USER_DB_ADMIN , USER_DB_USED , USER_APP_USED , USER_OPS_OPER , USER_OTHER , PASSWORD_STRATEGY_ID , HOST_BACKUP_METHOD , HOST_BACKUP_INFO , OFFLINE_TIME , ONLINE_TIME , ARCH , LABELS , HOST_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_HOST $TABLE=new OPS_HOST();
	}
	
	/**
	 * 数据库
	*/
	public static class OPS_HOST_DB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_db";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务内容","服务内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_HOST_DB() {
			this.init($NAME,"数据库" , ID , HOST_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_HOST_DB $TABLE=new OPS_HOST_DB();
	}
	
	/**
	 * 中间件
	*/
	public static class OPS_HOST_MID extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_mid";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务内容","服务内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_HOST_MID() {
			this.init($NAME,"中间件" , ID , HOST_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_HOST_MID $TABLE=new OPS_HOST_MID();
	}
	
	/**
	 * 操作系统
	*/
	public static class OPS_HOST_OS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_os";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务内容","服务内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OPS_HOST_OS() {
			this.init($NAME,"操作系统" , ID , HOST_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_HOST_OS $TABLE=new OPS_HOST_OS();
	}
	
	/**
	 * 主机位置
	*/
	public static class OPS_HOST_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,true);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_HOST_POSITION() {
			this.init($NAME,"主机位置" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_HOST_POSITION $TABLE=new OPS_HOST_POSITION();
	}
	
	/**
	 * 主机表-服务
	*/
	public static class OPS_HOST_SERVICE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_host_service";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,true);
		
		/**
		 * 服务类型
		*/
		public static final DBField SERVICE_CATEGORY_ID = new DBField(DBDataType.STRING , "service_category_id","serviceCategoryId","服务类型","服务类型",false,false,true);
		
		/**
		 * 服务具体内容
		*/
		public static final DBField SERVICE_INFO_ID = new DBField(DBDataType.STRING , "service_info_id","serviceInfoId","服务具体内容","服务具体内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_HOST_SERVICE() {
			this.init($NAME,"主机表-服务" , ID , HOST_ID , SERVICE_CATEGORY_ID , SERVICE_INFO_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_HOST_SERVICE $TABLE=new OPS_HOST_SERVICE();
	}
	
	/**
	 * 信息系统
	*/
	public static class OPS_INFORMATION_SYSTEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_information_system";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 父节点
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父节点","父节点",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 介绍
		*/
		public static final DBField PROFILE = new DBField(DBDataType.STRING , "profile","profile","介绍","介绍",false,false,true);
		
		/**
		 * 当前状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","当前状态","当前状态",false,false,true);
		
		/**
		 * 运维模式
		*/
		public static final DBField OPS_METHOD = new DBField(DBDataType.STRING , "ops_method","opsMethod","运维模式","运维模式",false,false,true);
		
		/**
		 * 开发模式
		*/
		public static final DBField DEV_METHOD = new DBField(DBDataType.STRING , "dev_method","devMethod","开发模式","开发模式",false,false,true);
		
		/**
		 * 技术联系人
		*/
		public static final DBField TECHNICAL_CONTACT = new DBField(DBDataType.STRING , "technical_contact","technicalContact","技术联系人","技术联系人",false,false,true);
		
		/**
		 * 业务联系人
		*/
		public static final DBField BUSINESS_CONTACT = new DBField(DBDataType.STRING , "business_contact","businessContact","业务联系人","业务联系人",false,false,true);
		
		/**
		 * 所属公司/部门
		*/
		public static final DBField BELONG_ORG_ID = new DBField(DBDataType.STRING , "belong_org_id","belongOrgId","所属公司/部门","所属公司/部门",false,false,true);
		
		/**
		 * 最后一次演练
		*/
		public static final DBField LASTDRILL_DATE = new DBField(DBDataType.DATE , "lastdrill_date","lastdrillDate","最后一次演练","最后一次演练",false,false,true);
		
		/**
		 * 上线时间
		*/
		public static final DBField ONLINE_DATE = new DBField(DBDataType.DATE , "online_date","onlineDate","上线时间","上线时间",false,false,true);
		
		/**
		 * 下线时间
		*/
		public static final DBField OFFLINE_DATE = new DBField(DBDataType.DATE , "offline_date","offlineDate","下线时间","下线时间",false,false,true);
		
		/**
		 * 操作系统
		*/
		public static final DBField OS_INFO = new DBField(DBDataType.STRING , "os_info","osInfo","操作系统","操作系统",false,false,true);
		
		/**
		 * 数据库
		*/
		public static final DBField DB_INFO = new DBField(DBDataType.STRING , "db_info","dbInfo","数据库","数据库",false,false,true);
		
		/**
		 * 应用
		*/
		public static final DBField APP_INFO = new DBField(DBDataType.STRING , "app_info","appInfo","应用","应用",false,false,true);
		
		/**
		 * 等级
		*/
		public static final DBField GRADE = new DBField(DBDataType.STRING , "grade","grade","等级","等级",false,false,true);
		
		/**
		 * RTO
		*/
		public static final DBField RTO = new DBField(DBDataType.STRING , "rto","rto","RTO","RTO",false,false,true);
		
		/**
		 * RPO
		*/
		public static final DBField RPO = new DBField(DBDataType.STRING , "rpo","rpo","RPO","RPO",false,false,true);
		
		/**
		 * 硬件信息
		*/
		public static final DBField HARDWARE_INFO = new DBField(DBDataType.STRING , "hardware_info","hardwareInfo","硬件信息","硬件信息",false,false,true);
		
		/**
		 * 备份信息
		*/
		public static final DBField BACKUP_INFO = new DBField(DBDataType.STRING , "backup_info","backupInfo","备份信息","备份信息",false,false,true);
		
		/**
		 * 本地备份
		*/
		public static final DBField SAMEPLACE_BACUP_INFO = new DBField(DBDataType.STRING , "sameplace_bacup_info","sameplaceBacupInfo","本地备份","本地备份",false,false,true);
		
		/**
		 * 异地备份
		*/
		public static final DBField DIFFPLACE_BACKUP_INFO = new DBField(DBDataType.STRING , "diffplace_backup_info","diffplaceBackupInfo","异地备份","异地备份",false,false,true);
		
		/**
		 * 归档模式
		*/
		public static final DBField ARCH_METHOD = new DBField(DBDataType.STRING , "arch_method","archMethod","归档模式","归档模式",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABELS = new DBField(DBDataType.STRING , "labels","labels","标签","标签",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_INFORMATION_SYSTEM() {
			this.init($NAME,"信息系统" , ID , PID , NAME , PROFILE , STATUS , OPS_METHOD , DEV_METHOD , TECHNICAL_CONTACT , BUSINESS_CONTACT , BELONG_ORG_ID , LASTDRILL_DATE , ONLINE_DATE , OFFLINE_DATE , OS_INFO , DB_INFO , APP_INFO , GRADE , RTO , RPO , HARDWARE_INFO , BACKUP_INFO , SAMEPLACE_BACUP_INFO , DIFFPLACE_BACKUP_INFO , ARCH_METHOD , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_INFORMATION_SYSTEM $TABLE=new OPS_INFORMATION_SYSTEM();
	}
	
	/**
	 * 节点
	*/
	public static class OPS_MONITOR_NODE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * IP
		*/
		public static final DBField NODE_IP = new DBField(DBDataType.STRING , "node_ip","nodeIp","IP","IP",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父节点","父节点",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 子类型
		*/
		public static final DBField SUB_TYPE = new DBField(DBDataType.STRING , "sub_type","subType","子类型","子类型",false,false,true);
		
		/**
		 * 节点分组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","节点分组","节点分组",false,false,true);
		
		/**
		 * 主机名
		*/
		public static final DBField NODE_NAME = new DBField(DBDataType.STRING , "node_name","nodeName","主机名","主机名",false,false,true);
		
		/**
		 * 可见主机名
		*/
		public static final DBField NODE_NAME_SHOW = new DBField(DBDataType.STRING , "node_name_show","nodeNameShow","可见主机名","可见主机名",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField NODE_TYPE = new DBField(DBDataType.STRING , "node_type","nodeType","类型","类型",false,false,true);
		
		/**
		 * 是否启用
		*/
		public static final DBField NODE_ENABLED = new DBField(DBDataType.STRING , "node_enabled","nodeEnabled","是否启用","是否启用",false,false,true);
		
		/**
		 * 监控状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","监控状态","监控状态",false,false,true);
		
		/**
		 * 凭证(SSH)
		*/
		public static final DBField SSH_VOUCHER_ID = new DBField(DBDataType.STRING , "ssh_voucher_id","sshVoucherId","凭证(SSH)","凭证(SSH)",false,false,true);
		
		/**
		 * SSH端口
		*/
		public static final DBField SSH_PORT = new DBField(DBDataType.INTEGER , "ssh_port","sshPort","SSH端口","SSH端口",false,false,true);
		
		/**
		 * Agent端口
		*/
		public static final DBField AGENT_PORT = new DBField(DBDataType.INTEGER , "agent_port","agentPort","Agent端口","Agent端口",false,false,true);
		
		/**
		 * Zabbix代理端口
		*/
		public static final DBField ZABBIX_AGENT_PORT = new DBField(DBDataType.INTEGER , "zabbix_agent_port","zabbixAgentPort","Zabbix代理端口","Zabbix代理端口",false,false,true);
		
		/**
		 * Snmp端口
		*/
		public static final DBField SNMP_PORT = new DBField(DBDataType.INTEGER , "snmp_port","snmpPort","Snmp端口","Snmp端口",false,false,true);
		
		/**
		 * Snmp版本
		*/
		public static final DBField SNMP_VERSION = new DBField(DBDataType.STRING , "snmp_version","snmpVersion","Snmp版本","Snmp版本",false,false,true);
		
		/**
		 * Snmp团体
		*/
		public static final DBField SNMP_COMMUNITY = new DBField(DBDataType.STRING , "snmp_community","snmpCommunity","Snmp团体","Snmp团体",false,false,true);
		
		/**
		 * Jmx端口
		*/
		public static final DBField JMX_PORT = new DBField(DBDataType.INTEGER , "jmx_port","jmxPort","Jmx端口","Jmx端口",false,false,true);
		
		/**
		 * Jmx端口
		*/
		public static final DBField IMPI_PORT = new DBField(DBDataType.INTEGER , "impi_port","impiPort","Jmx端口","Jmx端口",false,false,true);
		
		/**
		 * Jdbc地址
		*/
		public static final DBField JDBC_URL = new DBField(DBDataType.STRING , "jdbc_url","jdbcUrl","Jdbc地址","Jdbc地址",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE() {
			this.init($NAME,"节点" , ID , NODE_IP , PID , TYPE , SUB_TYPE , GROUP_ID , NODE_NAME , NODE_NAME_SHOW , NODE_TYPE , NODE_ENABLED , STATUS , SSH_VOUCHER_ID , SSH_PORT , AGENT_PORT , ZABBIX_AGENT_PORT , SNMP_PORT , SNMP_VERSION , SNMP_COMMUNITY , JMX_PORT , IMPI_PORT , JDBC_URL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE $TABLE=new OPS_MONITOR_NODE();
	}
	
	/**
	 * 节点数据库
	*/
	public static class OPS_MONITOR_NODE_DB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_db";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 数据库名称
		*/
		public static final DBField DB_NAME = new DBField(DBDataType.DATE , "db_name","dbName","数据库名称","数据库名称",false,false,true);
		
		/**
		 * 实例名称
		*/
		public static final DBField DB_INSTANCE = new DBField(DBDataType.DATE , "db_instance","dbInstance","实例名称","实例名称",false,false,true);
		
		/**
		 * 数据库版本
		*/
		public static final DBField DB_VERION = new DBField(DBDataType.STRING , "db_verion","dbVerion","数据库版本","数据库版本",false,false,true);
		
		/**
		 * 连接数
		*/
		public static final DBField CONNECT_COUNT = new DBField(DBDataType.INTEGER , "connect_count","connectCount","连接数","连接数",false,false,true);
		
		/**
		 * 数据库大小
		*/
		public static final DBField DB_SIZE = new DBField(DBDataType.DECIMAL , "db_size","dbSize","数据库大小","数据库大小",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_DB() {
			this.init($NAME,"节点数据库" , ID , NODE_ID , DB_NAME , DB_INSTANCE , DB_VERION , CONNECT_COUNT , DB_SIZE , RECORD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_DB $TABLE=new OPS_MONITOR_NODE_DB();
	}
	
	/**
	 * 节点分组
	*/
	public static class OPS_MONITOR_NODE_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_GROUP() {
			this.init($NAME,"节点分组" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_GROUP $TABLE=new OPS_MONITOR_NODE_GROUP();
	}
	
	/**
	 * 节点主机
	*/
	public static class OPS_MONITOR_NODE_HOST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_host";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOSTNAME = new DBField(DBDataType.DATE , "hostname","hostname","主机名称","主机名称",false,false,true);
		
		/**
		 * 启动时间
		*/
		public static final DBField BOOTTIME = new DBField(DBDataType.DATE , "boottime","boottime","启动时间","启动时间",false,false,true);
		
		/**
		 * 系统
		*/
		public static final DBField OS_VERION = new DBField(DBDataType.STRING , "os_verion","osVerion","系统","系统",false,false,true);
		
		/**
		 * 架构
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","架构","架构",false,false,true);
		
		/**
		 * CPU数量
		*/
		public static final DBField CPU = new DBField(DBDataType.INTEGER , "cpu","cpu","CPU数量","CPU数量",false,false,true);
		
		/**
		 * CPU主频
		*/
		public static final DBField CPU_FRE = new DBField(DBDataType.DECIMAL , "cpu_fre","cpuFre","CPU主频","CPU主频",false,false,true);
		
		/**
		 * 内存(M)
		*/
		public static final DBField MEMORY = new DBField(DBDataType.INTEGER , "memory","memory","内存(M)","内存(M)",false,false,true);
		
		/**
		 * cpuSys
		*/
		public static final DBField CPU_SYS = new DBField(DBDataType.DECIMAL , "cpu_sys","cpuSys","cpuSys","cpuSys",false,false,true);
		
		/**
		 * cpuUser
		*/
		public static final DBField CPU_USER = new DBField(DBDataType.DECIMAL , "cpu_user","cpuUser","cpuUser","cpuUser",false,false,true);
		
		/**
		 * cpuWait
		*/
		public static final DBField CPU_WAIT = new DBField(DBDataType.DECIMAL , "cpu_wait","cpuWait","cpuWait","cpuWait",false,false,true);
		
		/**
		 * CPU空闲旅
		*/
		public static final DBField CPU_IDLE = new DBField(DBDataType.DECIMAL , "cpu_idle","cpuIdle","CPU空闲旅","CPU空闲旅",false,false,true);
		
		/**
		 * CPU使用率
		*/
		public static final DBField CPU_USED = new DBField(DBDataType.DECIMAL , "cpu_used","cpuUsed","CPU使用率","CPU使用率",false,false,true);
		
		/**
		 * 系统负载
		*/
		public static final DBField OS_LOAD = new DBField(DBDataType.DECIMAL , "os_load","osLoad","系统负载","系统负载",false,false,true);
		
		/**
		 * 系统负载5
		*/
		public static final DBField OS_LOAD5 = new DBField(DBDataType.DECIMAL , "os_load5","osLoad5","系统负载5","系统负载5",false,false,true);
		
		/**
		 * 系统负载15
		*/
		public static final DBField OS_LOAD15 = new DBField(DBDataType.DECIMAL , "os_load15","osLoad15","系统负载15","系统负载15",false,false,true);
		
		/**
		 * 内存使用率
		*/
		public static final DBField MEMORY_USED = new DBField(DBDataType.DECIMAL , "memory_used","memoryUsed","内存使用率","内存使用率",false,false,true);
		
		/**
		 * 虚拟内存使用率
		*/
		public static final DBField VMEMORY_USED = new DBField(DBDataType.DECIMAL , "vmemory_used","vmemoryUsed","虚拟内存使用率","虚拟内存使用率",false,false,true);
		
		/**
		 * 上行流量
		*/
		public static final DBField NETWORK_FLOW_UP = new DBField(DBDataType.DECIMAL , "network_flow_up","networkFlowUp","上行流量","上行流量",false,false,true);
		
		/**
		 * 下流量
		*/
		public static final DBField NETWORK_FLOW_DOWN = new DBField(DBDataType.DECIMAL , "network_flow_down","networkFlowDown","下流量","下流量",false,false,true);
		
		/**
		 * 连接数
		*/
		public static final DBField PROCESS_CNT = new DBField(DBDataType.INTEGER , "process_cnt","processCnt","连接数","连接数",false,false,true);
		
		/**
		 * 内存
		*/
		public static final DBField P_MEMORY_USED = new DBField(DBDataType.INTEGER , "p_memory_used","pMemoryUsed","内存","内存",false,false,true);
		
		/**
		 * 虚拟内存
		*/
		public static final DBField V_MEMORY_USED = new DBField(DBDataType.INTEGER , "v_memory_used","vMemoryUsed","虚拟内存","虚拟内存",false,false,true);
		
		/**
		 * 信息
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","信息","信息",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_HOST() {
			this.init($NAME,"节点主机" , ID , NODE_ID , HOSTNAME , BOOTTIME , OS_VERION , ARCH , CPU , CPU_FRE , MEMORY , CPU_SYS , CPU_USER , CPU_WAIT , CPU_IDLE , CPU_USED , OS_LOAD , OS_LOAD5 , OS_LOAD15 , MEMORY_USED , VMEMORY_USED , NETWORK_FLOW_UP , NETWORK_FLOW_DOWN , PROCESS_CNT , P_MEMORY_USED , V_MEMORY_USED , INFO , RECORD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_HOST $TABLE=new OPS_MONITOR_NODE_HOST();
	}
	
	/**
	 * 节点列表数值
	*/
	public static class OPS_MONITOR_NODE_LIST_VALUE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_list_value";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","指标","指标",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 值类型
		*/
		public static final DBField VALUE_TYPE = new DBField(DBDataType.STRING , "value_type","valueType","值类型","值类型",false,false,true);
		
		/**
		 * 标签1
		*/
		public static final DBField LABEL1 = new DBField(DBDataType.STRING , "label1","label1","标签1","标签1",false,false,true);
		
		/**
		 * 标签2
		*/
		public static final DBField LABEL2 = new DBField(DBDataType.STRING , "label2","label2","标签2","标签2",false,false,true);
		
		/**
		 * 标签3
		*/
		public static final DBField LABEL3 = new DBField(DBDataType.STRING , "label3","label3","标签3","标签3",false,false,true);
		
		/**
		 * 编码1
		*/
		public static final DBField CODE1 = new DBField(DBDataType.STRING , "code1","code1","编码1","编码1",false,false,true);
		
		/**
		 * 编码2
		*/
		public static final DBField CODE2 = new DBField(DBDataType.STRING , "code2","code2","编码2","编码2",false,false,true);
		
		/**
		 * 数值1
		*/
		public static final DBField VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "value_number1","valueNumber1","数值1","数值1",false,false,true);
		
		/**
		 * 数值2
		*/
		public static final DBField VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "value_number2","valueNumber2","数值2","数值2",false,false,true);
		
		/**
		 * 数值3
		*/
		public static final DBField VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "value_number3","valueNumber3","数值3","数值3",false,false,true);
		
		/**
		 * 字符串1
		*/
		public static final DBField VALUE_STR1 = new DBField(DBDataType.STRING , "value_str1","valueStr1","字符串1","字符串1",false,false,true);
		
		/**
		 * 字符串2
		*/
		public static final DBField VALUE_STR2 = new DBField(DBDataType.STRING , "value_str2","valueStr2","字符串2","字符串2",false,false,true);
		
		/**
		 * 字符串3
		*/
		public static final DBField VALUE_STR3 = new DBField(DBDataType.STRING , "value_str3","valueStr3","字符串3","字符串3",false,false,true);
		
		/**
		 * 唯一标识
		*/
		public static final DBField UID = new DBField(DBDataType.STRING , "uid","uid","唯一标识","唯一标识",false,false,true);
		
		/**
		 * 信息
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","信息","信息",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_LIST_VALUE() {
			this.init($NAME,"节点列表数值" , ID , NODE_ID , INDICATOR_CODE , MONITOR_TPL_CODE , VALUE_TYPE , LABEL1 , LABEL2 , LABEL3 , CODE1 , CODE2 , VALUE_NUMBER1 , VALUE_NUMBER2 , VALUE_NUMBER3 , VALUE_STR1 , VALUE_STR2 , VALUE_STR3 , UID , INFO , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_LIST_VALUE $TABLE=new OPS_MONITOR_NODE_LIST_VALUE();
	}
	
	/**
	 * 节点映射
	*/
	public static class OPS_MONITOR_NODE_MAP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_map";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 源值
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","源值","源值",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP","IP",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION_METHOD = new DBField(DBDataType.STRING , "action_method","actionMethod","动作","动作",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_MAP() {
			this.init($NAME,"节点映射" , ID , NODE_ID , SOURCE_ID , IP , ACTION_METHOD , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_MAP $TABLE=new OPS_MONITOR_NODE_MAP();
	}
	
	/**
	 * 节点子类型
	*/
	public static class OPS_MONITOR_NODE_SUBTYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_subtype";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_SUBTYPE() {
			this.init($NAME,"节点子类型" , ID , TYPE , NAME , CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_SUBTYPE $TABLE=new OPS_MONITOR_NODE_SUBTYPE();
	}
	
	/**
	 * 节点监控模版
	*/
	public static class OPS_MONITOR_NODE_TPL_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_tpl_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_CODE = new DBField(DBDataType.STRING , "tpl_code","tplCode","模版","模版",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_TPL_ITEM() {
			this.init($NAME,"节点监控模版" , ID , NODE_ID , TPL_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_TPL_ITEM $TABLE=new OPS_MONITOR_NODE_TPL_ITEM();
	}
	
	/**
	 * 节点类型
	*/
	public static class OPS_MONITOR_NODE_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_TYPE() {
			this.init($NAME,"节点类型" , ID , NAME , CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_TYPE $TABLE=new OPS_MONITOR_NODE_TYPE();
	}
	
	/**
	 * 节点数值
	*/
	public static class OPS_MONITOR_NODE_VALUE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_value";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 结果状态
		*/
		public static final DBField RESULT_STATUS = new DBField(DBDataType.STRING , "result_status","resultStatus","结果状态","结果状态",false,false,true);
		
		/**
		 * 结果内容
		*/
		public static final DBField RESULT_MESSAGE = new DBField(DBDataType.STRING , "result_message","resultMessage","结果内容","结果内容",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","指标","指标",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOSTNAME = new DBField(DBDataType.STRING , "hostname","hostname","主机名称","主机名称",false,false,true);
		
		/**
		 * 系统时间
		*/
		public static final DBField OS_DATETIME = new DBField(DBDataType.STRING , "os_datetime","osDatetime","系统时间","系统时间",false,false,true);
		
		/**
		 * 启动时间
		*/
		public static final DBField BOOTTIME = new DBField(DBDataType.DATE , "boottime","boottime","启动时间","启动时间",false,false,true);
		
		/**
		 * 系统
		*/
		public static final DBField OS_VERION = new DBField(DBDataType.STRING , "os_verion","osVerion","系统","系统",false,false,true);
		
		/**
		 * 架构
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","架构","架构",false,false,true);
		
		/**
		 * CPU数量
		*/
		public static final DBField CPU_NUMBER = new DBField(DBDataType.INTEGER , "cpu_number","cpuNumber","CPU数量","CPU数量",false,false,true);
		
		/**
		 * CPU主频
		*/
		public static final DBField CPU_FREE = new DBField(DBDataType.DECIMAL , "cpu_free","cpuFree","CPU主频","CPU主频",false,false,true);
		
		/**
		 * cpuSys
		*/
		public static final DBField CPU_SYS = new DBField(DBDataType.DECIMAL , "cpu_sys","cpuSys","cpuSys","cpuSys",false,false,true);
		
		/**
		 * cpuUser
		*/
		public static final DBField CPU_USER = new DBField(DBDataType.DECIMAL , "cpu_user","cpuUser","cpuUser","cpuUser",false,false,true);
		
		/**
		 * cpuWait
		*/
		public static final DBField CPU_WAIT = new DBField(DBDataType.DECIMAL , "cpu_wait","cpuWait","cpuWait","cpuWait",false,false,true);
		
		/**
		 * CPU空闲旅
		*/
		public static final DBField CPU_IDLE = new DBField(DBDataType.DECIMAL , "cpu_idle","cpuIdle","CPU空闲旅","CPU空闲旅",false,false,true);
		
		/**
		 * CPU使用率
		*/
		public static final DBField CPU_USED = new DBField(DBDataType.DECIMAL , "cpu_used","cpuUsed","CPU使用率","CPU使用率",false,false,true);
		
		/**
		 * 系统负载
		*/
		public static final DBField OS_LOAD = new DBField(DBDataType.DECIMAL , "os_load","osLoad","系统负载","系统负载",false,false,true);
		
		/**
		 * 系统负载5
		*/
		public static final DBField OS_LOAD5 = new DBField(DBDataType.DECIMAL , "os_load5","osLoad5","系统负载5","系统负载5",false,false,true);
		
		/**
		 * 系统负载15
		*/
		public static final DBField OS_LOAD15 = new DBField(DBDataType.DECIMAL , "os_load15","osLoad15","系统负载15","系统负载15",false,false,true);
		
		/**
		 * 上行流量
		*/
		public static final DBField NETWORK_FLOW_UP = new DBField(DBDataType.DECIMAL , "network_flow_up","networkFlowUp","上行流量","上行流量",false,false,true);
		
		/**
		 * 下流量
		*/
		public static final DBField NETWORK_FLOW_DOWN = new DBField(DBDataType.DECIMAL , "network_flow_down","networkFlowDown","下流量","下流量",false,false,true);
		
		/**
		 * 连接数
		*/
		public static final DBField PROCESS_CNT = new DBField(DBDataType.INTEGER , "process_cnt","processCnt","连接数","连接数",false,false,true);
		
		/**
		 * 物理内存(M)
		*/
		public static final DBField P_MEMORY_SIZE = new DBField(DBDataType.LONG , "p_memory_size","pMemorySize","物理内存(M)","物理内存(M)",false,false,true);
		
		/**
		 * 虚拟内存(M)
		*/
		public static final DBField V_MEMORY_SIZE = new DBField(DBDataType.LONG , "v_memory_size","vMemorySize","虚拟内存(M)","虚拟内存(M)",false,false,true);
		
		/**
		 * 物理内存使用率
		*/
		public static final DBField P_MEMORY_USED = new DBField(DBDataType.DECIMAL , "p_memory_used","pMemoryUsed","物理内存使用率","物理内存使用率",false,false,true);
		
		/**
		 * 虚拟内存使用率
		*/
		public static final DBField V_MEMORY_USED = new DBField(DBDataType.DECIMAL , "v_memory_used","vMemoryUsed","虚拟内存使用率","虚拟内存使用率",false,false,true);
		
		/**
		 * 信息
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","信息","信息",false,false,true);
		
		/**
		 * 标签1
		*/
		public static final DBField LABEL1 = new DBField(DBDataType.STRING , "label1","label1","标签1","标签1",false,false,true);
		
		/**
		 * 标签2
		*/
		public static final DBField LABEL2 = new DBField(DBDataType.STRING , "label2","label2","标签2","标签2",false,false,true);
		
		/**
		 * 标签3
		*/
		public static final DBField LABEL3 = new DBField(DBDataType.STRING , "label3","label3","标签3","标签3",false,false,true);
		
		/**
		 * 编码1
		*/
		public static final DBField CODE1 = new DBField(DBDataType.STRING , "code1","code1","编码1","编码1",false,false,true);
		
		/**
		 * 编码2
		*/
		public static final DBField CODE2 = new DBField(DBDataType.STRING , "code2","code2","编码2","编码2",false,false,true);
		
		/**
		 * 编码3
		*/
		public static final DBField CODE3 = new DBField(DBDataType.STRING , "code3","code3","编码3","编码3",false,false,true);
		
		/**
		 * 数值1
		*/
		public static final DBField VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "value_number1","valueNumber1","数值1","数值1",false,false,true);
		
		/**
		 * 数值2
		*/
		public static final DBField VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "value_number2","valueNumber2","数值2","数值2",false,false,true);
		
		/**
		 * 数值3
		*/
		public static final DBField VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "value_number3","valueNumber3","数值3","数值3",false,false,true);
		
		/**
		 * 字符串1
		*/
		public static final DBField VALUE_STR1 = new DBField(DBDataType.STRING , "value_str1","valueStr1","字符串1","字符串1",false,false,true);
		
		/**
		 * 字符串2
		*/
		public static final DBField VALUE_STR2 = new DBField(DBDataType.STRING , "value_str2","valueStr2","字符串2","字符串2",false,false,true);
		
		/**
		 * 字符串3
		*/
		public static final DBField VALUE_STR3 = new DBField(DBDataType.STRING , "value_str3","valueStr3","字符串3","字符串3",false,false,true);
		
		/**
		 * 整数1
		*/
		public static final DBField VALUE_INT1 = new DBField(DBDataType.LONG , "value_int1","valueInt1","整数1","整数1",false,false,true);
		
		/**
		 * 整数2
		*/
		public static final DBField VALUE_INT2 = new DBField(DBDataType.LONG , "value_int2","valueInt2","整数2","整数2",false,false,true);
		
		/**
		 * 整数3
		*/
		public static final DBField VALUE_INT3 = new DBField(DBDataType.LONG , "value_int3","valueInt3","整数3","整数3",false,false,true);
		
		/**
		 * 标签列1
		*/
		public static final DBField LIST_LABEL1 = new DBField(DBDataType.STRING , "list_label1","listLabel1","标签列1","标签列1",false,false,true);
		
		/**
		 * 标签列2
		*/
		public static final DBField LIST_LABEL2 = new DBField(DBDataType.STRING , "list_label2","listLabel2","标签列2","标签列2",false,false,true);
		
		/**
		 * 标签列3
		*/
		public static final DBField LIST_LABEL3 = new DBField(DBDataType.STRING , "list_label3","listLabel3","标签列3","标签列3",false,false,true);
		
		/**
		 * 编码列1
		*/
		public static final DBField LIST_CODE1 = new DBField(DBDataType.STRING , "list_code1","listCode1","编码列1","编码列1",false,false,true);
		
		/**
		 * 编码列2
		*/
		public static final DBField LIST_CODE2 = new DBField(DBDataType.STRING , "list_code2","listCode2","编码列2","编码列2",false,false,true);
		
		/**
		 * 编码列3
		*/
		public static final DBField LIST_CODE3 = new DBField(DBDataType.STRING , "list_code3","listCode3","编码列3","编码列3",false,false,true);
		
		/**
		 * 数值列1
		*/
		public static final DBField LIST_VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "list_value_number1","listValueNumber1","数值列1","数值列1",false,false,true);
		
		/**
		 * 数值列2
		*/
		public static final DBField LIST_VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "list_value_number2","listValueNumber2","数值列2","数值列2",false,false,true);
		
		/**
		 * 数值列3
		*/
		public static final DBField LIST_VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "list_value_number3","listValueNumber3","数值列3","数值列3",false,false,true);
		
		/**
		 * 字符串列1
		*/
		public static final DBField LIST_VALUE_STR1 = new DBField(DBDataType.STRING , "list_value_str1","listValueStr1","字符串列1","字符串列1",false,false,true);
		
		/**
		 * 字符串列2
		*/
		public static final DBField LIST_VALUE_STR2 = new DBField(DBDataType.STRING , "list_value_str2","listValueStr2","字符串列2","字符串列2",false,false,true);
		
		/**
		 * 字符串列3
		*/
		public static final DBField LIST_VALUE_STR3 = new DBField(DBDataType.STRING , "list_value_str3","listValueStr3","字符串列3","字符串列3",false,false,true);
		
		/**
		 * 整数列1
		*/
		public static final DBField LIST_VALUE_INT1 = new DBField(DBDataType.LONG , "list_value_int1","listValueInt1","整数列1","整数列1",false,false,true);
		
		/**
		 * 整数列2
		*/
		public static final DBField LIST_VALUE_INT2 = new DBField(DBDataType.LONG , "list_value_int2","listValueInt2","整数列2","整数列2",false,false,true);
		
		/**
		 * 整数列3
		*/
		public static final DBField LIST_VALUE_INT3 = new DBField(DBDataType.LONG , "list_value_int3","listValueInt3","整数列3","整数列3",false,false,true);
		
		/**
		 * 唯一标识
		*/
		public static final DBField UID = new DBField(DBDataType.STRING , "uid","uid","唯一标识","唯一标识",false,false,true);
		
		/**
		 * 是否连接
		*/
		public static final DBField IS_CONNECTED = new DBField(DBDataType.INTEGER , "is_connected","isConnected","是否连接","是否连接",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_VALUE() {
			this.init($NAME,"节点数值" , ID , NODE_ID , MONITOR_TPL_CODE , RESULT_STATUS , RESULT_MESSAGE , INDICATOR_CODE , HOSTNAME , OS_DATETIME , BOOTTIME , OS_VERION , ARCH , CPU_NUMBER , CPU_FREE , CPU_SYS , CPU_USER , CPU_WAIT , CPU_IDLE , CPU_USED , OS_LOAD , OS_LOAD5 , OS_LOAD15 , NETWORK_FLOW_UP , NETWORK_FLOW_DOWN , PROCESS_CNT , P_MEMORY_SIZE , V_MEMORY_SIZE , P_MEMORY_USED , V_MEMORY_USED , INFO , LABEL1 , LABEL2 , LABEL3 , CODE1 , CODE2 , CODE3 , VALUE_NUMBER1 , VALUE_NUMBER2 , VALUE_NUMBER3 , VALUE_STR1 , VALUE_STR2 , VALUE_STR3 , VALUE_INT1 , VALUE_INT2 , VALUE_INT3 , LIST_LABEL1 , LIST_LABEL2 , LIST_LABEL3 , LIST_CODE1 , LIST_CODE2 , LIST_CODE3 , LIST_VALUE_NUMBER1 , LIST_VALUE_NUMBER2 , LIST_VALUE_NUMBER3 , LIST_VALUE_STR1 , LIST_VALUE_STR2 , LIST_VALUE_STR3 , LIST_VALUE_INT1 , LIST_VALUE_INT2 , LIST_VALUE_INT3 , UID , IS_CONNECTED , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_VALUE $TABLE=new OPS_MONITOR_NODE_VALUE();
	}
	
	/**
	 * 节点数值最新
	*/
	public static class OPS_MONITOR_NODE_VALUE_LAST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_node_value_last";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 结果状态
		*/
		public static final DBField RESULT_STATUS = new DBField(DBDataType.STRING , "result_status","resultStatus","结果状态","结果状态",false,false,true);
		
		/**
		 * 结果内容
		*/
		public static final DBField RESULT_MESSAGE = new DBField(DBDataType.STRING , "result_message","resultMessage","结果内容","结果内容",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","指标","指标",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOSTNAME = new DBField(DBDataType.STRING , "hostname","hostname","主机名称","主机名称",false,false,true);
		
		/**
		 * 系统时间
		*/
		public static final DBField OS_DATETIME = new DBField(DBDataType.STRING , "os_datetime","osDatetime","系统时间","系统时间",false,false,true);
		
		/**
		 * 启动时间
		*/
		public static final DBField BOOTTIME = new DBField(DBDataType.DATE , "boottime","boottime","启动时间","启动时间",false,false,true);
		
		/**
		 * 系统
		*/
		public static final DBField OS_VERION = new DBField(DBDataType.STRING , "os_verion","osVerion","系统","系统",false,false,true);
		
		/**
		 * 架构
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","架构","架构",false,false,true);
		
		/**
		 * CPU数量
		*/
		public static final DBField CPU_NUMBER = new DBField(DBDataType.INTEGER , "cpu_number","cpuNumber","CPU数量","CPU数量",false,false,true);
		
		/**
		 * CPU主频
		*/
		public static final DBField CPU_FREE = new DBField(DBDataType.DECIMAL , "cpu_free","cpuFree","CPU主频","CPU主频",false,false,true);
		
		/**
		 * cpuSys
		*/
		public static final DBField CPU_SYS = new DBField(DBDataType.DECIMAL , "cpu_sys","cpuSys","cpuSys","cpuSys",false,false,true);
		
		/**
		 * cpuUser
		*/
		public static final DBField CPU_USER = new DBField(DBDataType.DECIMAL , "cpu_user","cpuUser","cpuUser","cpuUser",false,false,true);
		
		/**
		 * cpuWait
		*/
		public static final DBField CPU_WAIT = new DBField(DBDataType.DECIMAL , "cpu_wait","cpuWait","cpuWait","cpuWait",false,false,true);
		
		/**
		 * CPU空闲旅
		*/
		public static final DBField CPU_IDLE = new DBField(DBDataType.DECIMAL , "cpu_idle","cpuIdle","CPU空闲旅","CPU空闲旅",false,false,true);
		
		/**
		 * CPU使用率
		*/
		public static final DBField CPU_USED = new DBField(DBDataType.DECIMAL , "cpu_used","cpuUsed","CPU使用率","CPU使用率",false,false,true);
		
		/**
		 * 系统负载
		*/
		public static final DBField OS_LOAD = new DBField(DBDataType.DECIMAL , "os_load","osLoad","系统负载","系统负载",false,false,true);
		
		/**
		 * 系统负载5
		*/
		public static final DBField OS_LOAD5 = new DBField(DBDataType.DECIMAL , "os_load5","osLoad5","系统负载5","系统负载5",false,false,true);
		
		/**
		 * 系统负载15
		*/
		public static final DBField OS_LOAD15 = new DBField(DBDataType.DECIMAL , "os_load15","osLoad15","系统负载15","系统负载15",false,false,true);
		
		/**
		 * 上行流量
		*/
		public static final DBField NETWORK_FLOW_UP = new DBField(DBDataType.DECIMAL , "network_flow_up","networkFlowUp","上行流量","上行流量",false,false,true);
		
		/**
		 * 下流量
		*/
		public static final DBField NETWORK_FLOW_DOWN = new DBField(DBDataType.DECIMAL , "network_flow_down","networkFlowDown","下流量","下流量",false,false,true);
		
		/**
		 * 连接数
		*/
		public static final DBField PROCESS_CNT = new DBField(DBDataType.INTEGER , "process_cnt","processCnt","连接数","连接数",false,false,true);
		
		/**
		 * 物理内存(M)
		*/
		public static final DBField P_MEMORY_SIZE = new DBField(DBDataType.LONG , "p_memory_size","pMemorySize","物理内存(M)","物理内存(M)",false,false,true);
		
		/**
		 * 虚拟内存(M)
		*/
		public static final DBField V_MEMORY_SIZE = new DBField(DBDataType.LONG , "v_memory_size","vMemorySize","虚拟内存(M)","虚拟内存(M)",false,false,true);
		
		/**
		 * 物理内存使用率
		*/
		public static final DBField P_MEMORY_USED = new DBField(DBDataType.DECIMAL , "p_memory_used","pMemoryUsed","物理内存使用率","物理内存使用率",false,false,true);
		
		/**
		 * 虚拟内存使用率
		*/
		public static final DBField V_MEMORY_USED = new DBField(DBDataType.DECIMAL , "v_memory_used","vMemoryUsed","虚拟内存使用率","虚拟内存使用率",false,false,true);
		
		/**
		 * 信息
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","信息","信息",false,false,true);
		
		/**
		 * 标签1
		*/
		public static final DBField LABEL1 = new DBField(DBDataType.STRING , "label1","label1","标签1","标签1",false,false,true);
		
		/**
		 * 标签2
		*/
		public static final DBField LABEL2 = new DBField(DBDataType.STRING , "label2","label2","标签2","标签2",false,false,true);
		
		/**
		 * 标签3
		*/
		public static final DBField LABEL3 = new DBField(DBDataType.STRING , "label3","label3","标签3","标签3",false,false,true);
		
		/**
		 * 编码1
		*/
		public static final DBField CODE1 = new DBField(DBDataType.STRING , "code1","code1","编码1","编码1",false,false,true);
		
		/**
		 * 编码2
		*/
		public static final DBField CODE2 = new DBField(DBDataType.STRING , "code2","code2","编码2","编码2",false,false,true);
		
		/**
		 * 编码3
		*/
		public static final DBField CODE3 = new DBField(DBDataType.STRING , "code3","code3","编码3","编码3",false,false,true);
		
		/**
		 * 数值1
		*/
		public static final DBField VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "value_number1","valueNumber1","数值1","数值1",false,false,true);
		
		/**
		 * 数值2
		*/
		public static final DBField VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "value_number2","valueNumber2","数值2","数值2",false,false,true);
		
		/**
		 * 数值3
		*/
		public static final DBField VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "value_number3","valueNumber3","数值3","数值3",false,false,true);
		
		/**
		 * 字符串1
		*/
		public static final DBField VALUE_STR1 = new DBField(DBDataType.STRING , "value_str1","valueStr1","字符串1","字符串1",false,false,true);
		
		/**
		 * 字符串2
		*/
		public static final DBField VALUE_STR2 = new DBField(DBDataType.STRING , "value_str2","valueStr2","字符串2","字符串2",false,false,true);
		
		/**
		 * 字符串3
		*/
		public static final DBField VALUE_STR3 = new DBField(DBDataType.STRING , "value_str3","valueStr3","字符串3","字符串3",false,false,true);
		
		/**
		 * 整数1
		*/
		public static final DBField VALUE_INT1 = new DBField(DBDataType.LONG , "value_int1","valueInt1","整数1","整数1",false,false,true);
		
		/**
		 * 整数2
		*/
		public static final DBField VALUE_INT2 = new DBField(DBDataType.LONG , "value_int2","valueInt2","整数2","整数2",false,false,true);
		
		/**
		 * 整数3
		*/
		public static final DBField VALUE_INT3 = new DBField(DBDataType.LONG , "value_int3","valueInt3","整数3","整数3",false,false,true);
		
		/**
		 * 标签列1
		*/
		public static final DBField LIST_LABEL1 = new DBField(DBDataType.STRING , "list_label1","listLabel1","标签列1","标签列1",false,false,true);
		
		/**
		 * 标签列2
		*/
		public static final DBField LIST_LABEL2 = new DBField(DBDataType.STRING , "list_label2","listLabel2","标签列2","标签列2",false,false,true);
		
		/**
		 * 标签列3
		*/
		public static final DBField LIST_LABEL3 = new DBField(DBDataType.STRING , "list_label3","listLabel3","标签列3","标签列3",false,false,true);
		
		/**
		 * 编码列1
		*/
		public static final DBField LIST_CODE1 = new DBField(DBDataType.STRING , "list_code1","listCode1","编码列1","编码列1",false,false,true);
		
		/**
		 * 编码列2
		*/
		public static final DBField LIST_CODE2 = new DBField(DBDataType.STRING , "list_code2","listCode2","编码列2","编码列2",false,false,true);
		
		/**
		 * 编码列3
		*/
		public static final DBField LIST_CODE3 = new DBField(DBDataType.STRING , "list_code3","listCode3","编码列3","编码列3",false,false,true);
		
		/**
		 * 数值列1
		*/
		public static final DBField LIST_VALUE_NUMBER1 = new DBField(DBDataType.DECIMAL , "list_value_number1","listValueNumber1","数值列1","数值列1",false,false,true);
		
		/**
		 * 数值列2
		*/
		public static final DBField LIST_VALUE_NUMBER2 = new DBField(DBDataType.DECIMAL , "list_value_number2","listValueNumber2","数值列2","数值列2",false,false,true);
		
		/**
		 * 数值列3
		*/
		public static final DBField LIST_VALUE_NUMBER3 = new DBField(DBDataType.DECIMAL , "list_value_number3","listValueNumber3","数值列3","数值列3",false,false,true);
		
		/**
		 * 字符串列1
		*/
		public static final DBField LIST_VALUE_STR1 = new DBField(DBDataType.STRING , "list_value_str1","listValueStr1","字符串列1","字符串列1",false,false,true);
		
		/**
		 * 字符串列2
		*/
		public static final DBField LIST_VALUE_STR2 = new DBField(DBDataType.STRING , "list_value_str2","listValueStr2","字符串列2","字符串列2",false,false,true);
		
		/**
		 * 字符串列3
		*/
		public static final DBField LIST_VALUE_STR3 = new DBField(DBDataType.STRING , "list_value_str3","listValueStr3","字符串列3","字符串列3",false,false,true);
		
		/**
		 * 整数列1
		*/
		public static final DBField LIST_VALUE_INT1 = new DBField(DBDataType.LONG , "list_value_int1","listValueInt1","整数列1","整数列1",false,false,true);
		
		/**
		 * 整数列2
		*/
		public static final DBField LIST_VALUE_INT2 = new DBField(DBDataType.LONG , "list_value_int2","listValueInt2","整数列2","整数列2",false,false,true);
		
		/**
		 * 整数列3
		*/
		public static final DBField LIST_VALUE_INT3 = new DBField(DBDataType.LONG , "list_value_int3","listValueInt3","整数列3","整数列3",false,false,true);
		
		/**
		 * 唯一标识
		*/
		public static final DBField UID = new DBField(DBDataType.STRING , "uid","uid","唯一标识","唯一标识",false,false,true);
		
		/**
		 * 是否连接
		*/
		public static final DBField IS_CONNECTED = new DBField(DBDataType.INTEGER , "is_connected","isConnected","是否连接","是否连接",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RECORD_TIME = new DBField(DBDataType.DATE , "record_time","recordTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_NODE_VALUE_LAST() {
			this.init($NAME,"节点数值最新" , ID , NODE_ID , MONITOR_TPL_CODE , RESULT_STATUS , RESULT_MESSAGE , INDICATOR_CODE , HOSTNAME , OS_DATETIME , BOOTTIME , OS_VERION , ARCH , CPU_NUMBER , CPU_FREE , CPU_SYS , CPU_USER , CPU_WAIT , CPU_IDLE , CPU_USED , OS_LOAD , OS_LOAD5 , OS_LOAD15 , NETWORK_FLOW_UP , NETWORK_FLOW_DOWN , PROCESS_CNT , P_MEMORY_SIZE , V_MEMORY_SIZE , P_MEMORY_USED , V_MEMORY_USED , INFO , LABEL1 , LABEL2 , LABEL3 , CODE1 , CODE2 , CODE3 , VALUE_NUMBER1 , VALUE_NUMBER2 , VALUE_NUMBER3 , VALUE_STR1 , VALUE_STR2 , VALUE_STR3 , VALUE_INT1 , VALUE_INT2 , VALUE_INT3 , LIST_LABEL1 , LIST_LABEL2 , LIST_LABEL3 , LIST_CODE1 , LIST_CODE2 , LIST_CODE3 , LIST_VALUE_NUMBER1 , LIST_VALUE_NUMBER2 , LIST_VALUE_NUMBER3 , LIST_VALUE_STR1 , LIST_VALUE_STR2 , LIST_VALUE_STR3 , LIST_VALUE_INT1 , LIST_VALUE_INT2 , LIST_VALUE_INT3 , UID , IS_CONNECTED , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_NODE_VALUE_LAST $TABLE=new OPS_MONITOR_NODE_VALUE_LAST();
	}
	
	/**
	 * 监控模版
	*/
	public static class OPS_MONITOR_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 分类
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","分类","分类",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_TPL() {
			this.init($NAME,"监控模版" , ID , NAME , CODE , STATUS , TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL $TABLE=new OPS_MONITOR_TPL();
	}
	
	/**
	 * 模版图形
	*/
	public static class OPS_MONITOR_TPL_GRAPH extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl_graph";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_CODE = new DBField(DBDataType.STRING , "tpl_code","tplCode","模版","模版",false,false,true);
		
		/**
		 * 宽度
		*/
		public static final DBField GRAPH_WIDTH = new DBField(DBDataType.INTEGER , "graph_width","graphWidth","宽度","宽度",false,false,true);
		
		/**
		 * 高度
		*/
		public static final DBField GRAPH_HEIGHT = new DBField(DBDataType.INTEGER , "graph_height","graphHeight","高度","高度",false,false,true);
		
		/**
		 * 图形类别
		*/
		public static final DBField GRAPH_TYPE = new DBField(DBDataType.STRING , "graph_type","graphType","图形类别","图形类别",false,false,true);
		
		/**
		 * 图形设置
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","图形设置","图形设置",false,false,true);
		
		/**
		 * 数据来源
		*/
		public static final DBField DS = new DBField(DBDataType.STRING , "ds","ds","数据来源","数据来源",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_TPL_GRAPH() {
			this.init($NAME,"模版图形" , ID , STATUS , NAME , TPL_CODE , GRAPH_WIDTH , GRAPH_HEIGHT , GRAPH_TYPE , CONTENT , DS , LABEL , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL_GRAPH $TABLE=new OPS_MONITOR_TPL_GRAPH();
	}
	
	/**
	 * 图形指标
	*/
	public static class OPS_MONITOR_TPL_GRAPH_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl_graph_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 图形
		*/
		public static final DBField GRAPH_ID = new DBField(DBDataType.STRING , "graph_id","graphId","图形","图形",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","指标","指标",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 数据
		*/
		public static final DBField ROUTE = new DBField(DBDataType.STRING , "route","route","数据","数据",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_TPL_GRAPH_ITEM() {
			this.init($NAME,"图形指标" , ID , STATUS , GRAPH_ID , INDICATOR_CODE , NAME , ROUTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL_GRAPH_ITEM $TABLE=new OPS_MONITOR_TPL_GRAPH_ITEM();
	}
	
	/**
	 * 模版指标
	*/
	public static class OPS_MONITOR_TPL_INDICATOR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl_indicator";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 监控方式
		*/
		public static final DBField MONITOR_METHOD = new DBField(DBDataType.STRING , "monitor_method","monitorMethod","监控方式","监控方式",false,false,true);
		
		/**
		 * 指标类型
		*/
		public static final DBField INDICATOR_TYPE = new DBField(DBDataType.STRING , "indicator_type","indicatorType","指标类型","指标类型",false,false,true);
		
		/**
		 * 值行数
		*/
		public static final DBField VALUE_COLUMN_ROWS = new DBField(DBDataType.STRING , "value_column_rows","valueColumnRows","值行数","值行数",false,false,true);
		
		/**
		 * 值列数
		*/
		public static final DBField VALUE_COLUMN_COLS = new DBField(DBDataType.STRING , "value_column_cols","valueColumnCols","值列数","值列数",false,false,true);
		
		/**
		 * 数值类型
		*/
		public static final DBField VALUE_COLUMN_TYPE = new DBField(DBDataType.STRING , "value_column_type","valueColumnType","数值类型","数值类型",false,false,true);
		
		/**
		 * 数值字段
		*/
		public static final DBField VALUE_COLUMN = new DBField(DBDataType.STRING , "value_column","valueColumn","数值字段","数值字段",false,false,true);
		
		/**
		 * 数值字段映射
		*/
		public static final DBField VALUE_COLUMN_MAP = new DBField(DBDataType.STRING , "value_column_map","valueColumnMap","数值字段映射","数值字段映射",false,false,true);
		
		/**
		 * 字段名称
		*/
		public static final DBField VALUE_COLUMN_NAME = new DBField(DBDataType.STRING , "value_column_name","valueColumnName","字段名称","字段名称",false,false,true);
		
		/**
		 * 超时(秒)
		*/
		public static final DBField TIME_OUT = new DBField(DBDataType.INTEGER , "time_out","timeOut","超时(秒)","超时(秒)",false,false,true);
		
		/**
		 * 间隔时间(秒）
		*/
		public static final DBField INTERVAL_TIME = new DBField(DBDataType.INTEGER , "Interval_time","intervalTime","间隔时间(秒）","间隔时间(秒）",false,false,true);
		
		/**
		 * 数据保留天数
		*/
		public static final DBField DATA_KEEP_DAY = new DBField(DBDataType.INTEGER , "data_keep_day","dataKeepDay","数据保留天数","数据保留天数",false,false,true);
		
		/**
		 * 命令
		*/
		public static final DBField COMMAND = new DBField(DBDataType.STRING , "command","command","命令","命令",false,false,true);
		
		/**
		 * 命令值
		*/
		public static final DBField COMMAND_VALUE = new DBField(DBDataType.STRING , "command_value","commandValue","命令值","命令值",false,false,true);
		
		/**
		 * 变量
		*/
		public static final DBField INDICATOR_VARIABLE = new DBField(DBDataType.STRING , "indicator_variable","indicatorVariable","变量","变量",false,false,true);
		
		/**
		 * snmp元数据
		*/
		public static final DBField SNMP_OID = new DBField(DBDataType.STRING , "snmp_oid","snmpOid","snmp元数据","snmp元数据",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField ITEM_SORT = new DBField(DBDataType.INTEGER , "item_sort","itemSort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_TPL_INDICATOR() {
			this.init($NAME,"模版指标" , ID , STATUS , NAME , CODE , MONITOR_TPL_CODE , MONITOR_METHOD , INDICATOR_TYPE , VALUE_COLUMN_ROWS , VALUE_COLUMN_COLS , VALUE_COLUMN_TYPE , VALUE_COLUMN , VALUE_COLUMN_MAP , VALUE_COLUMN_NAME , TIME_OUT , INTERVAL_TIME , DATA_KEEP_DAY , COMMAND , COMMAND_VALUE , INDICATOR_VARIABLE , SNMP_OID , LABEL , ITEM_SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL_INDICATOR $TABLE=new OPS_MONITOR_TPL_INDICATOR();
	}
	
	/**
	 * 指标类型
	*/
	public static class OPS_MONITOR_TPL_INDICATOR_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl_indicator_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_TPL_INDICATOR_TYPE() {
			this.init($NAME,"指标类型" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL_INDICATOR_TYPE $TABLE=new OPS_MONITOR_TPL_INDICATOR_TYPE();
	}
	
	/**
	 * 模版类型
	*/
	public static class OPS_MONITOR_TPL_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_tpl_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_TPL_TYPE() {
			this.init($NAME,"模版类型" , ID , NAME , CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TPL_TYPE $TABLE=new OPS_MONITOR_TPL_TYPE();
	}
	
	/**
	 * 触发器
	*/
	public static class OPS_MONITOR_TRIGGER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_trigger";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 指标
		*/
		public static final DBField INDICATOR_ID = new DBField(DBDataType.STRING , "indicator_id","indicatorId","指标","指标",false,false,true);
		
		/**
		 * 图形设置
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","图形设置","图形设置",false,false,true);
		
		/**
		 * 数据来源
		*/
		public static final DBField DS = new DBField(DBDataType.STRING , "ds","ds","数据来源","数据来源",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_TRIGGER() {
			this.init($NAME,"触发器" , ID , STATUS , NAME , INDICATOR_ID , CONTENT , DS , LABEL , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_TRIGGER $TABLE=new OPS_MONITOR_TRIGGER();
	}
	
	/**
	 * 监控凭证
	*/
	public static class OPS_MONITOR_VOUCHER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_voucher";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 账户
		*/
		public static final DBField ACCOUNT = new DBField(DBDataType.STRING , "account","account","账户","账户",false,false,true);
		
		/**
		 * 凭证
		*/
		public static final DBField VOUCHER = new DBField(DBDataType.STRING , "voucher","voucher","凭证","凭证",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_VOUCHER() {
			this.init($NAME,"监控凭证" , ID , NAME , ACCOUNT , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_VOUCHER $TABLE=new OPS_MONITOR_VOUCHER();
	}
	
	/**
	 * 节点告警
	*/
	public static class OPS_MONITOR_WARN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_monitor_warn";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE_ID = new DBField(DBDataType.STRING , "node_id","nodeId","节点","节点",false,false,true);
		
		/**
		 * 监控数值
		*/
		public static final DBField NODE_VALUE_ID = new DBField(DBDataType.STRING , "node_value_id","nodeValueId","监控数值","监控数值",false,false,true);
		
		/**
		 * 监控模版
		*/
		public static final DBField MONITOR_TPL_CODE = new DBField(DBDataType.STRING , "monitor_tpl_code","monitorTplCode","监控模版","监控模版",false,false,true);
		
		/**
		 * 监控指标
		*/
		public static final DBField INDICATOR_CODE = new DBField(DBDataType.STRING , "indicator_code","indicatorCode","监控指标","监控指标",false,false,true);
		
		/**
		 * 指标名称
		*/
		public static final DBField INDICATOR_NAME = new DBField(DBDataType.STRING , "indicator_name","indicatorName","指标名称","指标名称",false,false,true);
		
		/**
		 * 告警等级
		*/
		public static final DBField WARN_LEVEL = new DBField(DBDataType.STRING , "warn_level","warnLevel","告警等级","告警等级",false,false,true);
		
		/**
		 * 处理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","处理状态","处理状态",false,false,true);
		
		/**
		 * 处理时间
		*/
		public static final DBField HANDLED_TIME = new DBField(DBDataType.DATE , "handled_time","handledTime","处理时间","处理时间",false,false,true);
		
		/**
		 * 告警时间
		*/
		public static final DBField WARN_TIME = new DBField(DBDataType.DATE , "warn_time","warnTime","告警时间","告警时间",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public OPS_MONITOR_WARN() {
			this.init($NAME,"节点告警" , ID , NODE_ID , NODE_VALUE_ID , MONITOR_TPL_CODE , INDICATOR_CODE , INDICATOR_NAME , WARN_LEVEL , STATUS , HANDLED_TIME , WARN_TIME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OPS_MONITOR_WARN $TABLE=new OPS_MONITOR_WARN();
	}
	
	/**
	 * 节点
	*/
	public static class OPS_OPS_HOST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * IP
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP","IP",false,false,true);
		
		/**
		 * 端口
		*/
		public static final DBField PORT = new DBField(DBDataType.STRING , "port","port","端口","端口",false,false,true);
		
		/**
		 * 主机凭证
		*/
		public static final DBField HOST_VOUCHER = new DBField(DBDataType.STRING , "host_voucher","hostVoucher","主机凭证","主机凭证",false,false,true);
		
		/**
		 * 变量
		*/
		public static final DBField OTHER_VARIABLE = new DBField(DBDataType.STRING , "other_variable","otherVariable","变量","变量",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST() {
			this.init($NAME,"节点" , ID , IP , PORT , HOST_VOUCHER , OTHER_VARIABLE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST $TABLE=new OPS_OPS_HOST();
	}
	
	/**
	 * 节点组
	*/
	public static class OPS_OPS_HOST_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST_GROUP() {
			this.init($NAME,"节点组" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST_GROUP $TABLE=new OPS_OPS_HOST_GROUP();
	}
	
	/**
	 * 节点组明细
	*/
	public static class OPS_OPS_HOST_GROUP_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host_group_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 主机
		*/
		public static final DBField HOST_ID = new DBField(DBDataType.STRING , "host_id","hostId","主机","主机",false,false,false);
		
		/**
		 * 主机组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","主机组","主机组",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST_GROUP_ITEM() {
			this.init($NAME,"节点组明细" , ID , HOST_ID , GROUP_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST_GROUP_ITEM $TABLE=new OPS_OPS_HOST_GROUP_ITEM();
	}
	
	/**
	 * 节点凭证
	*/
	public static class OPS_OPS_HOST_VOUCHER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_ops_host_voucher";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 密码
		*/
		public static final DBField HOST_USER = new DBField(DBDataType.STRING , "host_user","hostUser","密码","密码",false,false,true);
		
		/**
		 * 密码
		*/
		public static final DBField HOST_PWD = new DBField(DBDataType.STRING , "host_pwd","hostPwd","密码","密码",false,false,true);
		
		/**
		 * 加密
		*/
		public static final DBField PWD_ENCRYPT = new DBField(DBDataType.STRING , "pwd_encrypt","pwdEncrypt","加密","加密",false,false,true);
		
		/**
		 * 加密
		*/
		public static final DBField ENCRYPT = new DBField(DBDataType.STRING , "encrypt","encrypt","加密","加密",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_OPS_HOST_VOUCHER() {
			this.init($NAME,"节点凭证" , ID , HOST_USER , HOST_PWD , PWD_ENCRYPT , ENCRYPT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_OPS_HOST_VOUCHER $TABLE=new OPS_OPS_HOST_VOUCHER();
	}
	
	/**
	 * 服务类型
	*/
	public static class OPS_SERVICE_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 服务分组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","服务分组","服务分组",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_SERVICE_CATEGORY() {
			this.init($NAME,"服务类型" , ID , GROUP_ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_SERVICE_CATEGORY $TABLE=new OPS_SERVICE_CATEGORY();
	}
	
	/**
	 * 服务分组
	*/
	public static class OPS_SERVICE_GROUP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_group";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_SERVICE_GROUP() {
			this.init($NAME,"服务分组" , ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_SERVICE_GROUP $TABLE=new OPS_SERVICE_GROUP();
	}
	
	/**
	 * 服务
	*/
	public static class OPS_SERVICE_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_service_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 服务分组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","服务分组","服务分组",false,false,true);
		
		/**
		 * 服务分类
		*/
		public static final DBField SERVICE_CATEGORY_ID = new DBField(DBDataType.STRING , "service_category_id","serviceCategoryId","服务分类","服务分类",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 补丁
		*/
		public static final DBField PATCH = new DBField(DBDataType.STRING , "patch","patch","补丁","补丁",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_SERVICE_INFO() {
			this.init($NAME,"服务" , ID , GROUP_ID , SERVICE_CATEGORY_ID , NAME , PATCH , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_SERVICE_INFO $TABLE=new OPS_SERVICE_INFO();
	}
	
	/**
	 * 凭证
	*/
	public static class OPS_VOUCHER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类别
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类别","类别",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_CODE = new DBField(DBDataType.STRING , "user_code","userCode","用户","用户",false,false,true);
		
		/**
		 * 凭证
		*/
		public static final DBField VOUCHER = new DBField(DBDataType.STRING , "voucher","voucher","凭证","凭证",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_VOUCHER() {
			this.init($NAME,"凭证" , ID , TYPE , OWNER_ID , USER_CODE , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER $TABLE=new OPS_VOUCHER();
	}
	
	/**
	 * 凭证记录
	*/
	public static class OPS_VOUCHER_HISTORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher_history";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 凭证
		*/
		public static final DBField VOUCHER_ID = new DBField(DBDataType.STRING , "voucher_id","voucherId","凭证","凭证",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_CODE = new DBField(DBDataType.STRING , "user_code","userCode","用户","用户",false,false,true);
		
		/**
		 * 凭证
		*/
		public static final DBField VOUCHER = new DBField(DBDataType.STRING , "voucher","voucher","凭证","凭证",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_VOUCHER_HISTORY() {
			this.init($NAME,"凭证记录" , ID , VOUCHER_ID , USER_CODE , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER_HISTORY $TABLE=new OPS_VOUCHER_HISTORY();
	}
	
	/**
	 * 所属凭证
	*/
	public static class OPS_VOUCHER_OWNER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher_owner";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类别
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","类别","类别",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION = new DBField(DBDataType.STRING , "position","position","位置","位置",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_VOUCHER_OWNER() {
			this.init($NAME,"所属凭证" , ID , CATEGORY_CODE , LABEL , NAME , POSITION , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER_OWNER $TABLE=new OPS_VOUCHER_OWNER();
	}
	
	/**
	 * 凭证权限
	*/
	public static class OPS_VOUCHER_PRIV extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "ops_voucher_priv";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 凭证类别
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","凭证类别","凭证类别",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField EMPL_ID = new DBField(DBDataType.STRING , "empl_id","emplId","用户","用户",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OPS_VOUCHER_PRIV() {
			this.init($NAME,"凭证权限" , ID , TYPE , EMPL_ID , STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OPS_VOUCHER_PRIV $TABLE=new OPS_VOUCHER_PRIV();
	}
}