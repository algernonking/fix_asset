package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_NODE_DB;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 节点数据库
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:41
 * @sign C5FBBA48FEC905A3075125A422AB942A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_node_db")
public class MonitorNodeDb extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_NODE_DB.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点")
	private String nodeId;
	
	/**
	 * 数据库名称：数据库名称
	*/
	@ApiModelProperty(required = false,value="数据库名称" , notes = "数据库名称")
	private Date dbName;
	
	/**
	 * 实例名称：实例名称
	*/
	@ApiModelProperty(required = false,value="实例名称" , notes = "实例名称")
	private Date dbInstance;
	
	/**
	 * 数据库版本：数据库版本
	*/
	@ApiModelProperty(required = false,value="数据库版本" , notes = "数据库版本")
	private String dbVerion;
	
	/**
	 * 连接数：连接数
	*/
	@ApiModelProperty(required = false,value="连接数" , notes = "连接数")
	private Integer connectCount;
	
	/**
	 * 数据库大小：数据库大小
	*/
	@ApiModelProperty(required = false,value="数据库大小" , notes = "数据库大小")
	private BigDecimal dbSize;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recordTime;
	
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
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
	public MonitorNodeDb setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 节点<br>
	 * 节点
	 * @return 节点
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点
	 * @param nodeId 节点
	 * @return 当前对象
	*/
	public MonitorNodeDb setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 数据库名称<br>
	 * 数据库名称
	 * @return 数据库名称
	*/
	public Date getDbName() {
		return dbName;
	}
	
	/**
	 * 设置 数据库名称
	 * @param dbName 数据库名称
	 * @return 当前对象
	*/
	public MonitorNodeDb setDbName(Date dbName) {
		this.dbName=dbName;
		return this;
	}
	
	/**
	 * 获得 实例名称<br>
	 * 实例名称
	 * @return 实例名称
	*/
	public Date getDbInstance() {
		return dbInstance;
	}
	
	/**
	 * 设置 实例名称
	 * @param dbInstance 实例名称
	 * @return 当前对象
	*/
	public MonitorNodeDb setDbInstance(Date dbInstance) {
		this.dbInstance=dbInstance;
		return this;
	}
	
	/**
	 * 获得 数据库版本<br>
	 * 数据库版本
	 * @return 数据库版本
	*/
	public String getDbVerion() {
		return dbVerion;
	}
	
	/**
	 * 设置 数据库版本
	 * @param dbVerion 数据库版本
	 * @return 当前对象
	*/
	public MonitorNodeDb setDbVerion(String dbVerion) {
		this.dbVerion=dbVerion;
		return this;
	}
	
	/**
	 * 获得 连接数<br>
	 * 连接数
	 * @return 连接数
	*/
	public Integer getConnectCount() {
		return connectCount;
	}
	
	/**
	 * 设置 连接数
	 * @param connectCount 连接数
	 * @return 当前对象
	*/
	public MonitorNodeDb setConnectCount(Integer connectCount) {
		this.connectCount=connectCount;
		return this;
	}
	
	/**
	 * 获得 数据库大小<br>
	 * 数据库大小
	 * @return 数据库大小
	*/
	public BigDecimal getDbSize() {
		return dbSize;
	}
	
	/**
	 * 设置 数据库大小
	 * @param dbSize 数据库大小
	 * @return 当前对象
	*/
	public MonitorNodeDb setDbSize(BigDecimal dbSize) {
		this.dbSize=dbSize;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public MonitorNodeDb setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public MonitorNodeDb setNotes(String notes) {
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
	public MonitorNodeDb setCreateBy(String createBy) {
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
	public MonitorNodeDb setCreateTime(Date createTime) {
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
	public MonitorNodeDb setUpdateBy(String updateBy) {
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
	public MonitorNodeDb setUpdateTime(Date updateTime) {
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
	public MonitorNodeDb setDeleted(Integer deleted) {
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
	public MonitorNodeDb setDeleteBy(String deleteBy) {
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
	public MonitorNodeDb setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public MonitorNodeDb setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorNodeDb , 转换好的 MonitorNodeDb 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeDb , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorNodeDb
	 * @param monitorNodeDbMap 包含实体信息的 Map 对象
	 * @return MonitorNodeDb , 转换好的的 MonitorNodeDb 对象
	*/
	@Transient
	public static MonitorNodeDb createFrom(Map<String,Object> monitorNodeDbMap) {
		if(monitorNodeDbMap==null) return null;
		MonitorNodeDb po = EntityContext.create(MonitorNodeDb.class, monitorNodeDbMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeDb
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeDb , 转换好的的 MonitorNodeDb 对象
	*/
	@Transient
	public static MonitorNodeDb createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeDb po = EntityContext.create(MonitorNodeDb.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorNodeDb，等同于 new
	 * @return MonitorNodeDb 对象
	*/
	@Transient
	public static MonitorNodeDb create() {
		return EntityContext.create(MonitorNodeDb.class);
	}
}