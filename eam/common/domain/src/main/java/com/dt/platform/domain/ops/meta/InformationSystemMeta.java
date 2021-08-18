package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.InformationSystem;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-17 22:01:47
 * @sign CD323197665BC9D219152E72F49CA314
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InformationSystemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final String PID="pid";
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> PID_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,PID, java.lang.String.class, "父节点", "父节点", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 介绍 , 类型: java.lang.String
	*/
	public static final String PROFILE="profile";
	
	/**
	 * 介绍 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> PROFILE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,PROFILE, java.lang.String.class, "介绍", "介绍", java.lang.String.class, null);
	
	/**
	 * 当前状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 当前状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,STATUS, java.lang.String.class, "当前状态", "当前状态", java.lang.String.class, null);
	
	/**
	 * 运维模式 , 类型: java.lang.String
	*/
	public static final String OPS_METHOD="opsMethod";
	
	/**
	 * 运维模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> OPS_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,OPS_METHOD, java.lang.String.class, "运维模式", "运维模式", java.lang.String.class, null);
	
	/**
	 * 开发模式 , 类型: java.lang.String
	*/
	public static final String DEV_METHOD="devMethod";
	
	/**
	 * 开发模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> DEV_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,DEV_METHOD, java.lang.String.class, "开发模式", "开发模式", java.lang.String.class, null);
	
	/**
	 * 技术联系人 , 类型: java.lang.String
	*/
	public static final String TECHNICAL_CONTACT="technicalContact";
	
	/**
	 * 技术联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> TECHNICAL_CONTACT_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,TECHNICAL_CONTACT, java.lang.String.class, "技术联系人", "技术联系人", java.lang.String.class, null);
	
	/**
	 * 业务联系人 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CONTACT="businessContact";
	
	/**
	 * 业务联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> BUSINESS_CONTACT_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,BUSINESS_CONTACT, java.lang.String.class, "业务联系人", "业务联系人", java.lang.String.class, null);
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final String BELONG_ORG_INFO="belongOrgInfo";
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> BELONG_ORG_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,BELONG_ORG_INFO, java.lang.String.class, "所属组织", "所属组织", java.lang.String.class, null);
	
	/**
	 * 最后一次演练 , 类型: java.util.Date
	*/
	public static final String LASTDRILL_DATE="lastdrillDate";
	
	/**
	 * 最后一次演练 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.util.Date> LASTDRILL_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,LASTDRILL_DATE, java.util.Date.class, "最后一次演练", "最后一次演练", java.util.Date.class, null);
	
	/**
	 * 上线时间 , 类型: java.util.Date
	*/
	public static final String ONLINE_DATE="onlineDate";
	
	/**
	 * 上线时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.util.Date> ONLINE_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,ONLINE_DATE, java.util.Date.class, "上线时间", "上线时间", java.util.Date.class, null);
	
	/**
	 * 下线时间 , 类型: java.util.Date
	*/
	public static final String OFFLINE_DATE="offlineDate";
	
	/**
	 * 下线时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.util.Date> OFFLINE_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,OFFLINE_DATE, java.util.Date.class, "下线时间", "下线时间", java.util.Date.class, null);
	
	/**
	 * 操作系统 , 类型: java.lang.String
	*/
	public static final String OS_INFO="osInfo";
	
	/**
	 * 操作系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> OS_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,OS_INFO, java.lang.String.class, "操作系统", "操作系统", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_INFO="dbInfo";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> DB_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,DB_INFO, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 应用 , 类型: java.lang.String
	*/
	public static final String APP_INFO="appInfo";
	
	/**
	 * 应用 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> APP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,APP_INFO, java.lang.String.class, "应用", "应用", java.lang.String.class, null);
	
	/**
	 * 等级 , 类型: java.lang.String
	*/
	public static final String GRADE="grade";
	
	/**
	 * 等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> GRADE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,GRADE, java.lang.String.class, "等级", "等级", java.lang.String.class, null);
	
	/**
	 * RTO , 类型: java.lang.String
	*/
	public static final String RTO="rto";
	
	/**
	 * RTO , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> RTO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,RTO, java.lang.String.class, "RTO", "RTO", java.lang.String.class, null);
	
	/**
	 * RPO , 类型: java.lang.String
	*/
	public static final String RPO="rpo";
	
	/**
	 * RPO , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> RPO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,RPO, java.lang.String.class, "RPO", "RPO", java.lang.String.class, null);
	
	/**
	 * 硬件信息 , 类型: java.lang.String
	*/
	public static final String HARDWARE_INFO="hardwareInfo";
	
	/**
	 * 硬件信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> HARDWARE_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,HARDWARE_INFO, java.lang.String.class, "硬件信息", "硬件信息", java.lang.String.class, null);
	
	/**
	 * 备份信息 , 类型: java.lang.String
	*/
	public static final String BACKUP_INFO="backupInfo";
	
	/**
	 * 备份信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> BACKUP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,BACKUP_INFO, java.lang.String.class, "备份信息", "备份信息", java.lang.String.class, null);
	
	/**
	 * 本地备份 , 类型: java.lang.String
	*/
	public static final String SAMEPLACE_BACUP_INFO="sameplaceBacupInfo";
	
	/**
	 * 本地备份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> SAMEPLACE_BACUP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,SAMEPLACE_BACUP_INFO, java.lang.String.class, "本地备份", "本地备份", java.lang.String.class, null);
	
	/**
	 * 异地备份 , 类型: java.lang.String
	*/
	public static final String DIFFPLACE_BACKUP_INFO="diffplaceBackupInfo";
	
	/**
	 * 异地备份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> DIFFPLACE_BACKUP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,DIFFPLACE_BACKUP_INFO, java.lang.String.class, "异地备份", "异地备份", java.lang.String.class, null);
	
	/**
	 * 归档模式 , 类型: java.lang.String
	*/
	public static final String ARCH_METHOD="archMethod";
	
	/**
	 * 归档模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> ARCH_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,ARCH_METHOD, java.lang.String.class, "归档模式", "归档模式", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABELS="labels";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> LABELS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,LABELS, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PID , NAME , PROFILE , STATUS , OPS_METHOD , DEV_METHOD , TECHNICAL_CONTACT , BUSINESS_CONTACT , BELONG_ORG_INFO , LASTDRILL_DATE , ONLINE_DATE , OFFLINE_DATE , OS_INFO , DB_INFO , APP_INFO , GRADE , RTO , RPO , HARDWARE_INFO , BACKUP_INFO , SAMEPLACE_BACUP_INFO , DIFFPLACE_BACKUP_INFO , ARCH_METHOD , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.InformationSystem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InformationSystem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 父节点
		 * @param pid 父节点
		 * @return 当前对象
		*/
		public InformationSystem setPid(String pid) {
			super.change(PID,super.getPid(),pid);
			super.setPid(pid);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public InformationSystem setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 介绍
		 * @param profile 介绍
		 * @return 当前对象
		*/
		public InformationSystem setProfile(String profile) {
			super.change(PROFILE,super.getProfile(),profile);
			super.setProfile(profile);
			return this;
		}
		
		/**
		 * 设置 当前状态
		 * @param status 当前状态
		 * @return 当前对象
		*/
		public InformationSystem setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 运维模式
		 * @param opsMethod 运维模式
		 * @return 当前对象
		*/
		public InformationSystem setOpsMethod(String opsMethod) {
			super.change(OPS_METHOD,super.getOpsMethod(),opsMethod);
			super.setOpsMethod(opsMethod);
			return this;
		}
		
		/**
		 * 设置 开发模式
		 * @param devMethod 开发模式
		 * @return 当前对象
		*/
		public InformationSystem setDevMethod(String devMethod) {
			super.change(DEV_METHOD,super.getDevMethod(),devMethod);
			super.setDevMethod(devMethod);
			return this;
		}
		
		/**
		 * 设置 技术联系人
		 * @param technicalContact 技术联系人
		 * @return 当前对象
		*/
		public InformationSystem setTechnicalContact(String technicalContact) {
			super.change(TECHNICAL_CONTACT,super.getTechnicalContact(),technicalContact);
			super.setTechnicalContact(technicalContact);
			return this;
		}
		
		/**
		 * 设置 业务联系人
		 * @param businessContact 业务联系人
		 * @return 当前对象
		*/
		public InformationSystem setBusinessContact(String businessContact) {
			super.change(BUSINESS_CONTACT,super.getBusinessContact(),businessContact);
			super.setBusinessContact(businessContact);
			return this;
		}
		
		/**
		 * 设置 所属组织
		 * @param belongOrgInfo 所属组织
		 * @return 当前对象
		*/
		public InformationSystem setBelongOrgInfo(String belongOrgInfo) {
			super.change(BELONG_ORG_INFO,super.getBelongOrgInfo(),belongOrgInfo);
			super.setBelongOrgInfo(belongOrgInfo);
			return this;
		}
		
		/**
		 * 设置 最后一次演练
		 * @param lastdrillDate 最后一次演练
		 * @return 当前对象
		*/
		public InformationSystem setLastdrillDate(Date lastdrillDate) {
			super.change(LASTDRILL_DATE,super.getLastdrillDate(),lastdrillDate);
			super.setLastdrillDate(lastdrillDate);
			return this;
		}
		
		/**
		 * 设置 上线时间
		 * @param onlineDate 上线时间
		 * @return 当前对象
		*/
		public InformationSystem setOnlineDate(Date onlineDate) {
			super.change(ONLINE_DATE,super.getOnlineDate(),onlineDate);
			super.setOnlineDate(onlineDate);
			return this;
		}
		
		/**
		 * 设置 下线时间
		 * @param offlineDate 下线时间
		 * @return 当前对象
		*/
		public InformationSystem setOfflineDate(Date offlineDate) {
			super.change(OFFLINE_DATE,super.getOfflineDate(),offlineDate);
			super.setOfflineDate(offlineDate);
			return this;
		}
		
		/**
		 * 设置 操作系统
		 * @param osInfo 操作系统
		 * @return 当前对象
		*/
		public InformationSystem setOsInfo(String osInfo) {
			super.change(OS_INFO,super.getOsInfo(),osInfo);
			super.setOsInfo(osInfo);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbInfo 数据库
		 * @return 当前对象
		*/
		public InformationSystem setDbInfo(String dbInfo) {
			super.change(DB_INFO,super.getDbInfo(),dbInfo);
			super.setDbInfo(dbInfo);
			return this;
		}
		
		/**
		 * 设置 应用
		 * @param appInfo 应用
		 * @return 当前对象
		*/
		public InformationSystem setAppInfo(String appInfo) {
			super.change(APP_INFO,super.getAppInfo(),appInfo);
			super.setAppInfo(appInfo);
			return this;
		}
		
		/**
		 * 设置 等级
		 * @param grade 等级
		 * @return 当前对象
		*/
		public InformationSystem setGrade(String grade) {
			super.change(GRADE,super.getGrade(),grade);
			super.setGrade(grade);
			return this;
		}
		
		/**
		 * 设置 RTO
		 * @param rto RTO
		 * @return 当前对象
		*/
		public InformationSystem setRto(String rto) {
			super.change(RTO,super.getRto(),rto);
			super.setRto(rto);
			return this;
		}
		
		/**
		 * 设置 RPO
		 * @param rpo RPO
		 * @return 当前对象
		*/
		public InformationSystem setRpo(String rpo) {
			super.change(RPO,super.getRpo(),rpo);
			super.setRpo(rpo);
			return this;
		}
		
		/**
		 * 设置 硬件信息
		 * @param hardwareInfo 硬件信息
		 * @return 当前对象
		*/
		public InformationSystem setHardwareInfo(String hardwareInfo) {
			super.change(HARDWARE_INFO,super.getHardwareInfo(),hardwareInfo);
			super.setHardwareInfo(hardwareInfo);
			return this;
		}
		
		/**
		 * 设置 备份信息
		 * @param backupInfo 备份信息
		 * @return 当前对象
		*/
		public InformationSystem setBackupInfo(String backupInfo) {
			super.change(BACKUP_INFO,super.getBackupInfo(),backupInfo);
			super.setBackupInfo(backupInfo);
			return this;
		}
		
		/**
		 * 设置 本地备份
		 * @param sameplaceBacupInfo 本地备份
		 * @return 当前对象
		*/
		public InformationSystem setSameplaceBacupInfo(String sameplaceBacupInfo) {
			super.change(SAMEPLACE_BACUP_INFO,super.getSameplaceBacupInfo(),sameplaceBacupInfo);
			super.setSameplaceBacupInfo(sameplaceBacupInfo);
			return this;
		}
		
		/**
		 * 设置 异地备份
		 * @param diffplaceBackupInfo 异地备份
		 * @return 当前对象
		*/
		public InformationSystem setDiffplaceBackupInfo(String diffplaceBackupInfo) {
			super.change(DIFFPLACE_BACKUP_INFO,super.getDiffplaceBackupInfo(),diffplaceBackupInfo);
			super.setDiffplaceBackupInfo(diffplaceBackupInfo);
			return this;
		}
		
		/**
		 * 设置 归档模式
		 * @param archMethod 归档模式
		 * @return 当前对象
		*/
		public InformationSystem setArchMethod(String archMethod) {
			super.change(ARCH_METHOD,super.getArchMethod(),archMethod);
			super.setArchMethod(archMethod);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param labels 标签
		 * @return 当前对象
		*/
		public InformationSystem setLabels(String labels) {
			super.change(LABELS,super.getLabels(),labels);
			super.setLabels(labels);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InformationSystem setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InformationSystem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InformationSystem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InformationSystem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InformationSystem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InformationSystem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InformationSystem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InformationSystem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InformationSystem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}