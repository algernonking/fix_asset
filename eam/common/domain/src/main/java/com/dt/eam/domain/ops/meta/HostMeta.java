package com.dt.eam.domain.ops.meta;

import com.dt.eam.domain.ops.Host;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-26 13:38:43
 * @sign 1D4EF255FD2B9E973CF28F1E981B0FF6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class HostMeta {
	
	/**
	 * 主键
	*/
	public static final String ID="id";
	
	/**
	 * 主机类型
	*/
	public static final String HOST_TYPE="hostType";
	
	/**
	 * 名称
	*/
	public static final String HOST_NAME="hostName";
	
	/**
	 * IP
	*/
	public static final String HOST_IP="hostIp";
	
	/**
	 * CPU
	*/
	public static final String HOST_CONF_CPU="hostConfCpu";
	
	/**
	 * memory
	*/
	public static final String HOST_CONF_MEMORY="hostConfMemory";
	
	/**
	 * 虚拟IP
	*/
	public static final String VIP="vip";
	
	/**
	 * 运行环境:prod , uat,tst
	*/
	public static final String ENVIRONMENT="environment";
	
	/**
	 * online , offline
	*/
	public static final String STATUS="status";
	
	/**
	 * 监控状态:valid , invalid,unknow
	*/
	public static final String MONITOR_STATUS="monitorStatus";
	
	/**
	 * 上线时间
	*/
	public static final String ONLINE_TIME="onlineTime";
	
	/**
	 * 下线时间
	*/
	public static final String OFFLINE_TIME="offlineTime";
	
	/**
	 * 操作系统 , 不使用
	*/
	public static final String OS="os";
	
	/**
	 * 数据库 , 不使用
	*/
	public static final String DB="db";
	
	/**
	 * 中间件 , 不使用
	*/
	public static final String MIDDLEWARE="middleware";
	
	/**
	 * 标签
	*/
	public static final String LABELS="labels";
	
	/**
	 * 是否归档 , 1归档，0没有归档
	*/
	public static final String ARCH="arch";
	
	/**
	 * 系统管理员
	*/
	public static final String USER_OS_ADMIN="userOsAdmin";
	
	/**
	 * 数据库管理员
	*/
	public static final String USER_DB_ADMIN="userDbAdmin";
	
	/**
	 * 数据库使用用户
	*/
	public static final String USER_DB_USED="userDbUsed";
	
	/**
	 * 应用使用用户
	*/
	public static final String USER_APP_USED="userAppUsed";
	
	/**
	 * 运维操作用户
	*/
	public static final String USER_OPS_OPER="userOpsOper";
	
	/**
	 * 其他用户
	*/
	public static final String USER_OTHER="userOther";
	
	/**
	 * 改密策略
	*/
	public static final String PASSWORD_STRATEGY="passwordStrategy";
	
	/**
	 * 备注
	*/
	public static final String HOST_NOTES="hostNotes";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * version
	*/
	public static final String VERSION="version";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , HOST_TYPE , HOST_NAME , HOST_IP , HOST_CONF_CPU , HOST_CONF_MEMORY , VIP , ENVIRONMENT , STATUS , MONITOR_STATUS , ONLINE_TIME , OFFLINE_TIME , OS , DB , MIDDLEWARE , LABELS , ARCH , USER_OS_ADMIN , USER_DB_ADMIN , USER_DB_USED , USER_APP_USED , USER_OPS_OPER , USER_OTHER , PASSWORD_STRATEGY , HOST_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.eam.domain.ops.Host {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Host setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 主机类型
		 * @param hostType 主机类型
		 * @return 当前对象
		*/
		public Host setHostType(String hostType) {
			super.change(HOST_TYPE,super.getHostType(),hostType);
			super.setHostType(hostType);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param hostName 名称
		 * @return 当前对象
		*/
		public Host setHostName(String hostName) {
			super.change(HOST_NAME,super.getHostName(),hostName);
			super.setHostName(hostName);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param hostIp IP
		 * @return 当前对象
		*/
		public Host setHostIp(String hostIp) {
			super.change(HOST_IP,super.getHostIp(),hostIp);
			super.setHostIp(hostIp);
			return this;
		}
		
		/**
		 * 设置 CPU
		 * @param hostConfCpu CPU
		 * @return 当前对象
		*/
		public Host setHostConfCpu(String hostConfCpu) {
			super.change(HOST_CONF_CPU,super.getHostConfCpu(),hostConfCpu);
			super.setHostConfCpu(hostConfCpu);
			return this;
		}
		
		/**
		 * 设置 memory
		 * @param hostConfMemory memory
		 * @return 当前对象
		*/
		public Host setHostConfMemory(String hostConfMemory) {
			super.change(HOST_CONF_MEMORY,super.getHostConfMemory(),hostConfMemory);
			super.setHostConfMemory(hostConfMemory);
			return this;
		}
		
		/**
		 * 设置 虚拟IP
		 * @param vip 虚拟IP
		 * @return 当前对象
		*/
		public Host setVip(String vip) {
			super.change(VIP,super.getVip(),vip);
			super.setVip(vip);
			return this;
		}
		
		/**
		 * 设置 运行环境:prod
		 * @param environment 运行环境:prod
		 * @return 当前对象
		*/
		public Host setEnvironment(String environment) {
			super.change(ENVIRONMENT,super.getEnvironment(),environment);
			super.setEnvironment(environment);
			return this;
		}
		
		/**
		 * 设置 online
		 * @param status online
		 * @return 当前对象
		*/
		public Host setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 监控状态:valid
		 * @param monitorStatus 监控状态:valid
		 * @return 当前对象
		*/
		public Host setMonitorStatus(String monitorStatus) {
			super.change(MONITOR_STATUS,super.getMonitorStatus(),monitorStatus);
			super.setMonitorStatus(monitorStatus);
			return this;
		}
		
		/**
		 * 设置 上线时间
		 * @param onlineTime 上线时间
		 * @return 当前对象
		*/
		public Host setOnlineTime(Date onlineTime) {
			super.change(ONLINE_TIME,super.getOnlineTime(),onlineTime);
			super.setOnlineTime(onlineTime);
			return this;
		}
		
		/**
		 * 设置 下线时间
		 * @param offlineTime 下线时间
		 * @return 当前对象
		*/
		public Host setOfflineTime(Date offlineTime) {
			super.change(OFFLINE_TIME,super.getOfflineTime(),offlineTime);
			super.setOfflineTime(offlineTime);
			return this;
		}
		
		/**
		 * 设置 操作系统
		 * @param os 操作系统
		 * @return 当前对象
		*/
		public Host setOs(String os) {
			super.change(OS,super.getOs(),os);
			super.setOs(os);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param db 数据库
		 * @return 当前对象
		*/
		public Host setDb(String db) {
			super.change(DB,super.getDb(),db);
			super.setDb(db);
			return this;
		}
		
		/**
		 * 设置 中间件
		 * @param middleware 中间件
		 * @return 当前对象
		*/
		public Host setMiddleware(String middleware) {
			super.change(MIDDLEWARE,super.getMiddleware(),middleware);
			super.setMiddleware(middleware);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param labels 标签
		 * @return 当前对象
		*/
		public Host setLabels(String labels) {
			super.change(LABELS,super.getLabels(),labels);
			super.setLabels(labels);
			return this;
		}
		
		/**
		 * 设置 是否归档
		 * @param arch 是否归档
		 * @return 当前对象
		*/
		public Host setArch(String arch) {
			super.change(ARCH,super.getArch(),arch);
			super.setArch(arch);
			return this;
		}
		
		/**
		 * 设置 系统管理员
		 * @param userOsAdmin 系统管理员
		 * @return 当前对象
		*/
		public Host setUserOsAdmin(String userOsAdmin) {
			super.change(USER_OS_ADMIN,super.getUserOsAdmin(),userOsAdmin);
			super.setUserOsAdmin(userOsAdmin);
			return this;
		}
		
		/**
		 * 设置 数据库管理员
		 * @param userDbAdmin 数据库管理员
		 * @return 当前对象
		*/
		public Host setUserDbAdmin(String userDbAdmin) {
			super.change(USER_DB_ADMIN,super.getUserDbAdmin(),userDbAdmin);
			super.setUserDbAdmin(userDbAdmin);
			return this;
		}
		
		/**
		 * 设置 数据库使用用户
		 * @param userDbUsed 数据库使用用户
		 * @return 当前对象
		*/
		public Host setUserDbUsed(String userDbUsed) {
			super.change(USER_DB_USED,super.getUserDbUsed(),userDbUsed);
			super.setUserDbUsed(userDbUsed);
			return this;
		}
		
		/**
		 * 设置 应用使用用户
		 * @param userAppUsed 应用使用用户
		 * @return 当前对象
		*/
		public Host setUserAppUsed(String userAppUsed) {
			super.change(USER_APP_USED,super.getUserAppUsed(),userAppUsed);
			super.setUserAppUsed(userAppUsed);
			return this;
		}
		
		/**
		 * 设置 运维操作用户
		 * @param userOpsOper 运维操作用户
		 * @return 当前对象
		*/
		public Host setUserOpsOper(String userOpsOper) {
			super.change(USER_OPS_OPER,super.getUserOpsOper(),userOpsOper);
			super.setUserOpsOper(userOpsOper);
			return this;
		}
		
		/**
		 * 设置 其他用户
		 * @param userOther 其他用户
		 * @return 当前对象
		*/
		public Host setUserOther(String userOther) {
			super.change(USER_OTHER,super.getUserOther(),userOther);
			super.setUserOther(userOther);
			return this;
		}
		
		/**
		 * 设置 改密策略
		 * @param passwordStrategy 改密策略
		 * @return 当前对象
		*/
		public Host setPasswordStrategy(String passwordStrategy) {
			super.change(PASSWORD_STRATEGY,super.getPasswordStrategy(),passwordStrategy);
			super.setPasswordStrategy(passwordStrategy);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param hostNotes 备注
		 * @return 当前对象
		*/
		public Host setHostNotes(String hostNotes) {
			super.change(HOST_NOTES,super.getHostNotes(),hostNotes);
			super.setHostNotes(hostNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Host setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Host setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Host setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Host setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Host setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Host setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Host setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Host setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}