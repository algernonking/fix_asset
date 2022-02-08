package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorNodeDb;
import java.util.Date;
import java.math.BigDecimal;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:41
 * @sign C5FBBA48FEC905A3075125A422AB942A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorNodeDbMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.String> NODE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,NODE_ID, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 数据库名称 , 类型: java.util.Date
	*/
	public static final String DB_NAME="dbName";
	
	/**
	 * 数据库名称 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.util.Date> DB_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,DB_NAME, java.util.Date.class, "数据库名称", "数据库名称", java.util.Date.class, null);
	
	/**
	 * 实例名称 , 类型: java.util.Date
	*/
	public static final String DB_INSTANCE="dbInstance";
	
	/**
	 * 实例名称 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.util.Date> DB_INSTANCE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,DB_INSTANCE, java.util.Date.class, "实例名称", "实例名称", java.util.Date.class, null);
	
	/**
	 * 数据库版本 , 类型: java.lang.String
	*/
	public static final String DB_VERION="dbVerion";
	
	/**
	 * 数据库版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.String> DB_VERION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,DB_VERION, java.lang.String.class, "数据库版本", "数据库版本", java.lang.String.class, null);
	
	/**
	 * 连接数 , 类型: java.lang.Integer
	*/
	public static final String CONNECT_COUNT="connectCount";
	
	/**
	 * 连接数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.Integer> CONNECT_COUNT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,CONNECT_COUNT, java.lang.Integer.class, "连接数", "连接数", java.lang.Integer.class, null);
	
	/**
	 * 数据库大小 , 类型: java.math.BigDecimal
	*/
	public static final String DB_SIZE="dbSize";
	
	/**
	 * 数据库大小 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.math.BigDecimal> DB_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,DB_SIZE, java.math.BigDecimal.class, "数据库大小", "数据库大小", java.math.BigDecimal.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeDb,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeDb.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NODE_ID , DB_NAME , DB_INSTANCE , DB_VERION , CONNECT_COUNT , DB_SIZE , RECORD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorNodeDb {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorNodeDb setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeId 节点
		 * @return 当前对象
		*/
		public MonitorNodeDb setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 数据库名称
		 * @param dbName 数据库名称
		 * @return 当前对象
		*/
		public MonitorNodeDb setDbName(Date dbName) {
			super.change(DB_NAME,super.getDbName(),dbName);
			super.setDbName(dbName);
			return this;
		}
		
		/**
		 * 设置 实例名称
		 * @param dbInstance 实例名称
		 * @return 当前对象
		*/
		public MonitorNodeDb setDbInstance(Date dbInstance) {
			super.change(DB_INSTANCE,super.getDbInstance(),dbInstance);
			super.setDbInstance(dbInstance);
			return this;
		}
		
		/**
		 * 设置 数据库版本
		 * @param dbVerion 数据库版本
		 * @return 当前对象
		*/
		public MonitorNodeDb setDbVerion(String dbVerion) {
			super.change(DB_VERION,super.getDbVerion(),dbVerion);
			super.setDbVerion(dbVerion);
			return this;
		}
		
		/**
		 * 设置 连接数
		 * @param connectCount 连接数
		 * @return 当前对象
		*/
		public MonitorNodeDb setConnectCount(Integer connectCount) {
			super.change(CONNECT_COUNT,super.getConnectCount(),connectCount);
			super.setConnectCount(connectCount);
			return this;
		}
		
		/**
		 * 设置 数据库大小
		 * @param dbSize 数据库大小
		 * @return 当前对象
		*/
		public MonitorNodeDb setDbSize(BigDecimal dbSize) {
			super.change(DB_SIZE,super.getDbSize(),dbSize);
			super.setDbSize(dbSize);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public MonitorNodeDb setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorNodeDb setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorNodeDb setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorNodeDb setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorNodeDb setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorNodeDb setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorNodeDb setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorNodeDb setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorNodeDb setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorNodeDb setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}