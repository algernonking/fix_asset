package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorTplGraph;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-17 15:12:42
 * @sign D5993649EDC9F5215357BE6DE2929D76
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorTplGraphMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_CODE="tplCode";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,TPL_CODE, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 宽度 , 类型: java.lang.Integer
	*/
	public static final String GRAPH_WIDTH="graphWidth";
	
	/**
	 * 宽度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.Integer> GRAPH_WIDTH_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,GRAPH_WIDTH, java.lang.Integer.class, "宽度", "宽度", java.lang.Integer.class, null);
	
	/**
	 * 高度 , 类型: java.lang.Integer
	*/
	public static final String GRAPH_HEIGHT="graphHeight";
	
	/**
	 * 高度 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.Integer> GRAPH_HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,GRAPH_HEIGHT, java.lang.Integer.class, "高度", "高度", java.lang.Integer.class, null);
	
	/**
	 * 图形类别 , 类型: java.lang.String
	*/
	public static final String GRAPH_TYPE="graphType";
	
	/**
	 * 图形类别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> GRAPH_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,GRAPH_TYPE, java.lang.String.class, "图形类别", "图形类别", java.lang.String.class, null);
	
	/**
	 * 图形设置 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 图形设置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,CONTENT, java.lang.String.class, "图形设置", "图形设置", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final String DS="ds";
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> DS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,DS, java.lang.String.class, "数据来源", "数据来源", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String TPL="tpl";
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,com.dt.platform.domain.ops.MonitorTpl> TPL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,TPL, com.dt.platform.domain.ops.MonitorTpl.class, "节点模版", "节点模版", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * 指标 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplGraphItem
	*/
	public static final String GRAPH_ITEM="graphItem";
	
	/**
	 * 指标 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplGraphItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplGraph,com.dt.platform.domain.ops.MonitorTplGraphItem> GRAPH_ITEM_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplGraph.class ,GRAPH_ITEM, java.util.List.class, "指标", "指标", com.dt.platform.domain.ops.MonitorTplGraphItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , NAME , TPL_CODE , GRAPH_WIDTH , GRAPH_HEIGHT , GRAPH_TYPE , CONTENT , DS , LABEL , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL , GRAPH_ITEM };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorTplGraph {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorTplGraph setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MonitorTplGraph setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorTplGraph setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplCode 模版
		 * @return 当前对象
		*/
		public MonitorTplGraph setTplCode(String tplCode) {
			super.change(TPL_CODE,super.getTplCode(),tplCode);
			super.setTplCode(tplCode);
			return this;
		}
		
		/**
		 * 设置 宽度
		 * @param graphWidth 宽度
		 * @return 当前对象
		*/
		public MonitorTplGraph setGraphWidth(Integer graphWidth) {
			super.change(GRAPH_WIDTH,super.getGraphWidth(),graphWidth);
			super.setGraphWidth(graphWidth);
			return this;
		}
		
		/**
		 * 设置 高度
		 * @param graphHeight 高度
		 * @return 当前对象
		*/
		public MonitorTplGraph setGraphHeight(Integer graphHeight) {
			super.change(GRAPH_HEIGHT,super.getGraphHeight(),graphHeight);
			super.setGraphHeight(graphHeight);
			return this;
		}
		
		/**
		 * 设置 图形类别
		 * @param graphType 图形类别
		 * @return 当前对象
		*/
		public MonitorTplGraph setGraphType(String graphType) {
			super.change(GRAPH_TYPE,super.getGraphType(),graphType);
			super.setGraphType(graphType);
			return this;
		}
		
		/**
		 * 设置 图形设置
		 * @param content 图形设置
		 * @return 当前对象
		*/
		public MonitorTplGraph setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param ds 数据来源
		 * @return 当前对象
		*/
		public MonitorTplGraph setDs(String ds) {
			super.change(DS,super.getDs(),ds);
			super.setDs(ds);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public MonitorTplGraph setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public MonitorTplGraph setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorTplGraph setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorTplGraph setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorTplGraph setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorTplGraph setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorTplGraph setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorTplGraph setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorTplGraph setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorTplGraph setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorTplGraph setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版
		 * @param tpl 节点模版
		 * @return 当前对象
		*/
		public MonitorTplGraph setTpl(MonitorTpl tpl) {
			super.change(TPL,super.getTpl(),tpl);
			super.setTpl(tpl);
			return this;
		}
		
		/**
		 * 设置 指标
		 * @param graphItem 指标
		 * @return 当前对象
		*/
		public MonitorTplGraph setGraphItem(List<MonitorTplGraphItem> graphItem) {
			super.change(GRAPH_ITEM,super.getGraphItem(),graphItem);
			super.setGraphItem(graphItem);
			return this;
		}
	}
}