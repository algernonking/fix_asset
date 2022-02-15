package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-13 20:47:04
 * @sign 092A4056712C2B5BA36928CD898F19B2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorTplGraphItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 图形 , 类型: java.lang.String
	*/
	public static final String GRAPH_ID="graphId";
	
	/**
	 * 图形 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> GRAPH_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,GRAPH_ID, java.lang.String.class, "图形", "图形", java.lang.String.class, null);
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final String INDICATOR_CODE="indicatorCode";
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> INDICATOR_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,INDICATOR_CODE, java.lang.String.class, "指标", "指标", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final String ROUTE="route";
	
	/**
	 * 数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> ROUTE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,ROUTE, java.lang.String.class, "数据", "数据", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraphItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraphItem.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , GRAPH_ID , INDICATOR_CODE , NAME , ROUTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorTplGraphItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 图形
		 * @param graphId 图形
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setGraphId(String graphId) {
			super.change(GRAPH_ID,super.getGraphId(),graphId);
			super.setGraphId(graphId);
			return this;
		}
		
		/**
		 * 设置 指标
		 * @param indicatorCode 指标
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setIndicatorCode(String indicatorCode) {
			super.change(INDICATOR_CODE,super.getIndicatorCode(),indicatorCode);
			super.setIndicatorCode(indicatorCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 数据
		 * @param route 数据
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setRoute(String route) {
			super.change(ROUTE,super.getRoute(),route);
			super.setRoute(route);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorTplGraphItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}