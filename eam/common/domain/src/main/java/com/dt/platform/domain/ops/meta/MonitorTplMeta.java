package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorTpl;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import java.util.List;
import com.dt.platform.domain.ops.MonitorTplGraph;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-13 08:04:05
 * @sign 99F025E78C542A0CC8BF0932CAF85BB7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorTplMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,TYPE, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版类型 , 类型: com.dt.platform.domain.ops.MonitorTplType
	*/
	public static final String TPL_TYPE="tplType";
	
	/**
	 * 节点模版类型 , 类型: com.dt.platform.domain.ops.MonitorTplType
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,com.dt.platform.domain.ops.MonitorTplType> TPL_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,TPL_TYPE, com.dt.platform.domain.ops.MonitorTplType.class, "节点模版类型", "节点模版类型", com.dt.platform.domain.ops.MonitorTplType.class, null);
	
	/**
	 * 指标列表 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplIndicator
	*/
	public static final String TPL_INDICATOR_LIST="tplIndicatorList";
	
	/**
	 * 指标列表 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplIndicator
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,com.dt.platform.domain.ops.MonitorTplIndicator> TPL_INDICATOR_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,TPL_INDICATOR_LIST, java.util.List.class, "指标列表", "指标列表", com.dt.platform.domain.ops.MonitorTplIndicator.class, null);
	
	/**
	 * 图形 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplGraph
	*/
	public static final String GRAPH_LIST="graphList";
	
	/**
	 * 图形 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplGraph
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTpl,com.dt.platform.domain.ops.MonitorTplGraph> GRAPH_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTpl.class ,GRAPH_LIST, java.util.List.class, "图形", "图形", com.dt.platform.domain.ops.MonitorTplGraph.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , CODE , TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL_TYPE , TPL_INDICATOR_LIST , GRAPH_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorTpl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorTpl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorTpl setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public MonitorTpl setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param type 分类
		 * @return 当前对象
		*/
		public MonitorTpl setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorTpl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorTpl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorTpl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorTpl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorTpl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorTpl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorTpl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorTpl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorTpl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版类型
		 * @param tplType 节点模版类型
		 * @return 当前对象
		*/
		public MonitorTpl setTplType(MonitorTplType tplType) {
			super.change(TPL_TYPE,super.getTplType(),tplType);
			super.setTplType(tplType);
			return this;
		}
		
		/**
		 * 设置 指标列表
		 * @param tplIndicatorList 指标列表
		 * @return 当前对象
		*/
		public MonitorTpl setTplIndicatorList(List<MonitorTplIndicator> tplIndicatorList) {
			super.change(TPL_INDICATOR_LIST,super.getTplIndicatorList(),tplIndicatorList);
			super.setTplIndicatorList(tplIndicatorList);
			return this;
		}
		
		/**
		 * 设置 图形
		 * @param graphList 图形
		 * @return 当前对象
		*/
		public MonitorTpl setGraphList(List<MonitorTplGraph> graphList) {
			super.change(GRAPH_LIST,super.getGraphList(),graphList);
			super.setGraphList(graphList);
			return this;
		}
	}
}