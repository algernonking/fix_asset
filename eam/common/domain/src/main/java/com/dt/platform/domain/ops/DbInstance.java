package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_DB_INSTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据库实例
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 02:47:43
 * @sign AEAB002B98D62808787FAEC78A22EB54
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_instance")
public class DbInstance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_INSTANCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 主机编号：主机编号
	*/
	@ApiModelProperty(required = false,value="主机编号" , notes = "主机编号")
	private String hostId;
	
	/**
	 * 数据库编号：数据库编号
	*/
	@ApiModelProperty(required = false,value="数据库编号" , notes = "数据库编号")
	private String databaseId;
	
	/**
	 * 实例名称：实例名称
	*/
	@ApiModelProperty(required = false,value="实例名称" , notes = "实例名称")
	private String name;
	
	/**
	 * 日志模式：日志模式
	*/
	@ApiModelProperty(required = false,value="日志模式" , notes = "日志模式")
	private String logMethod;
	
	/**
	 * 备份策略：备份策略
	*/
	@ApiModelProperty(required = false,value="备份策略" , notes = "备份策略")
	private String backupStrategy;
	
	/**
	 * 备份类型：备份类型
	*/
	@ApiModelProperty(required = false,value="备份类型" , notes = "备份类型")
	private String backupType;
	
	/**
	 * 备份保留时长：备份保留时长
	*/
	@ApiModelProperty(required = false,value="备份保留时长" , notes = "备份保留时长")
	private String backupDatakeep;
	
	/**
	 * 备份状态：备份状态
	*/
	@ApiModelProperty(required = false,value="备份状态" , notes = "备份状态")
	private String backupStatus;
	
	/**
	 * 备份方式：备份方式
	*/
	@ApiModelProperty(required = false,value="备份方式" , notes = "备份方式")
	private String backupMethod;
	
	/**
	 * 上次备份：上次备份
	*/
	@ApiModelProperty(required = false,value="上次备份" , notes = "上次备份")
	private Date backupTime;
	
	/**
	 * 备份大小：备份大小
	*/
	@ApiModelProperty(required = false,value="备份大小" , notes = "备份大小")
	private BigDecimal backupSize;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String labels;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 所在位置：所在位置
	*/
	@ApiModelProperty(required = false,value="所在位置" , notes = "所在位置")
	private Host host;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private ServiceInfo database;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public DbInstance setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 主机编号<br>
	 * 主机编号
	 * @return 主机编号
	*/
	public String getHostId() {
		return hostId;
	}
	
	/**
	 * 设置 主机编号
	 * @param hostId 主机编号
	 * @return 当前对象
	*/
	public DbInstance setHostId(String hostId) {
		this.hostId=hostId;
		return this;
	}
	
	/**
	 * 获得 数据库编号<br>
	 * 数据库编号
	 * @return 数据库编号
	*/
	public String getDatabaseId() {
		return databaseId;
	}
	
	/**
	 * 设置 数据库编号
	 * @param databaseId 数据库编号
	 * @return 当前对象
	*/
	public DbInstance setDatabaseId(String databaseId) {
		this.databaseId=databaseId;
		return this;
	}
	
	/**
	 * 获得 实例名称<br>
	 * 实例名称
	 * @return 实例名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 实例名称
	 * @param name 实例名称
	 * @return 当前对象
	*/
	public DbInstance setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 日志模式<br>
	 * 日志模式
	 * @return 日志模式
	*/
	public String getLogMethod() {
		return logMethod;
	}
	
	/**
	 * 设置 日志模式
	 * @param logMethod 日志模式
	 * @return 当前对象
	*/
	public DbInstance setLogMethod(String logMethod) {
		this.logMethod=logMethod;
		return this;
	}
	
	/**
	 * 获得 备份策略<br>
	 * 备份策略
	 * @return 备份策略
	*/
	public String getBackupStrategy() {
		return backupStrategy;
	}
	
	/**
	 * 设置 备份策略
	 * @param backupStrategy 备份策略
	 * @return 当前对象
	*/
	public DbInstance setBackupStrategy(String backupStrategy) {
		this.backupStrategy=backupStrategy;
		return this;
	}
	
	/**
	 * 获得 备份类型<br>
	 * 备份类型
	 * @return 备份类型
	*/
	public String getBackupType() {
		return backupType;
	}
	
	/**
	 * 设置 备份类型
	 * @param backupType 备份类型
	 * @return 当前对象
	*/
	public DbInstance setBackupType(String backupType) {
		this.backupType=backupType;
		return this;
	}
	
	/**
	 * 获得 备份保留时长<br>
	 * 备份保留时长
	 * @return 备份保留时长
	*/
	public String getBackupDatakeep() {
		return backupDatakeep;
	}
	
	/**
	 * 设置 备份保留时长
	 * @param backupDatakeep 备份保留时长
	 * @return 当前对象
	*/
	public DbInstance setBackupDatakeep(String backupDatakeep) {
		this.backupDatakeep=backupDatakeep;
		return this;
	}
	
	/**
	 * 获得 备份状态<br>
	 * 备份状态
	 * @return 备份状态
	*/
	public String getBackupStatus() {
		return backupStatus;
	}
	
	/**
	 * 设置 备份状态
	 * @param backupStatus 备份状态
	 * @return 当前对象
	*/
	public DbInstance setBackupStatus(String backupStatus) {
		this.backupStatus=backupStatus;
		return this;
	}
	
	/**
	 * 获得 备份方式<br>
	 * 备份方式
	 * @return 备份方式
	*/
	public String getBackupMethod() {
		return backupMethod;
	}
	
	/**
	 * 设置 备份方式
	 * @param backupMethod 备份方式
	 * @return 当前对象
	*/
	public DbInstance setBackupMethod(String backupMethod) {
		this.backupMethod=backupMethod;
		return this;
	}
	
	/**
	 * 获得 上次备份<br>
	 * 上次备份
	 * @return 上次备份
	*/
	public Date getBackupTime() {
		return backupTime;
	}
	
	/**
	 * 设置 上次备份
	 * @param backupTime 上次备份
	 * @return 当前对象
	*/
	public DbInstance setBackupTime(Date backupTime) {
		this.backupTime=backupTime;
		return this;
	}
	
	/**
	 * 获得 备份大小<br>
	 * 备份大小
	 * @return 备份大小
	*/
	public BigDecimal getBackupSize() {
		return backupSize;
	}
	
	/**
	 * 设置 备份大小
	 * @param backupSize 备份大小
	 * @return 当前对象
	*/
	public DbInstance setBackupSize(BigDecimal backupSize) {
		this.backupSize=backupSize;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabels() {
		return labels;
	}
	
	/**
	 * 设置 标签
	 * @param labels 标签
	 * @return 当前对象
	*/
	public DbInstance setLabels(String labels) {
		this.labels=labels;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public DbInstance setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public DbInstance setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public DbInstance setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public DbInstance setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public DbInstance setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public DbInstance setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public DbInstance setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public DbInstance setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public DbInstance setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public DbInstance setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 所在位置<br>
	 * 所在位置
	 * @return 所在位置
	*/
	public Host getHost() {
		return host;
	}
	
	/**
	 * 设置 所在位置
	 * @param host 所在位置
	 * @return 当前对象
	*/
	public DbInstance setHost(Host host) {
		this.host=host;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public ServiceInfo getDatabase() {
		return database;
	}
	
	/**
	 * 设置 数据库
	 * @param database 数据库
	 * @return 当前对象
	*/
	public DbInstance setDatabase(ServiceInfo database) {
		this.database=database;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbInstance , 转换好的 DbInstance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbInstance , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将 Map 转换成 DbInstance
	 * @param dbInstanceMap 包含实体信息的 Map 对象
	 * @return DbInstance , 转换好的的 DbInstance 对象
	*/
	@Transient
	public static DbInstance createFrom(Map<String,Object> dbInstanceMap) {
		if(dbInstanceMap==null) return null;
		DbInstance po = EntityContext.create(DbInstance.class, dbInstanceMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbInstance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbInstance , 转换好的的 DbInstance 对象
	*/
	@Transient
	public static DbInstance createFrom(Object pojo) {
		if(pojo==null) return null;
		DbInstance po = EntityContext.create(DbInstance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 DbInstance，等同于 new
	 * @return DbInstance 对象
	*/
	@Transient
	public static DbInstance create() {
		return EntityContext.create(DbInstance.class);
	}
}