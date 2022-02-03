package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTpl;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-02 14:55:22
 * @sign A87A02F9B410468FDF85794733B1F07D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorTplIndicatorMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 指标类型 , 类型: java.lang.String
	*/
	public static final String INDICATOR_TYPE="indicatorType";
	
	/**
	 * 指标类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> INDICATOR_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,INDICATOR_TYPE, java.lang.String.class, "指标类型", "指标类型", java.lang.String.class, null);
	
	/**
	 * 值行数 , 类型: java.lang.String
	*/
	public static final String VALUE_DATA_ROWS="valueDataRows";
	
	/**
	 * 值行数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> VALUE_DATA_ROWS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,VALUE_DATA_ROWS, java.lang.String.class, "值行数", "值行数", java.lang.String.class, null);
	
	/**
	 * 值类型 , 类型: java.lang.String
	*/
	public static final String VALUE_TYPE="valueType";
	
	/**
	 * 值类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> VALUE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,VALUE_TYPE, java.lang.String.class, "值类型", "值类型", java.lang.String.class, null);
	
	/**
	 * 来源类型 , 类型: java.lang.String
	*/
	public static final String SOURCE_TYPE="sourceType";
	
	/**
	 * 来源类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> SOURCE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,SOURCE_TYPE, java.lang.String.class, "来源类型", "来源类型", java.lang.String.class, null);
	
	/**
	 * 来源数据 , 类型: java.lang.String
	*/
	public static final String SOURCE_VALUE="sourceValue";
	
	/**
	 * 来源数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> SOURCE_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,SOURCE_VALUE, java.lang.String.class, "来源数据", "来源数据", java.lang.String.class, null);
	
	/**
	 * 数值类型 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN_TYPE="valueColumnType";
	
	/**
	 * 数值类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> VALUE_COLUMN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,VALUE_COLUMN_TYPE, java.lang.String.class, "数值类型", "数值类型", java.lang.String.class, null);
	
	/**
	 * 数值字段 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN="valueColumn";
	
	/**
	 * 数值字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> VALUE_COLUMN_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,VALUE_COLUMN, java.lang.String.class, "数值字段", "数值字段", java.lang.String.class, null);
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final String VALUE_COLUMN_DESC="valueColumnDesc";
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> VALUE_COLUMN_DESC_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,VALUE_COLUMN_DESC, java.lang.String.class, "描述", "描述", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String TPL="tpl";
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorTplIndicator,com.dt.platform.domain.ops.MonitorTpl> TPL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorTplIndicator.class ,TPL, com.dt.platform.domain.ops.MonitorTpl.class, "节点模版", "节点模版", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MONITOR_TPL_CODE , NAME , CODE , INDICATOR_TYPE , VALUE_DATA_ROWS , VALUE_TYPE , SOURCE_TYPE , SOURCE_VALUE , VALUE_COLUMN_TYPE , VALUE_COLUMN , VALUE_COLUMN_DESC , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorTplIndicator {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorTplIndicator setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorTplIndicator setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorTplIndicator setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 指标类型
		 * @param indicatorType 指标类型
		 * @return 当前对象
		*/
		public MonitorTplIndicator setIndicatorType(String indicatorType) {
			super.change(INDICATOR_TYPE,super.getIndicatorType(),indicatorType);
			super.setIndicatorType(indicatorType);
			return this;
		}
		
		/**
		 * 设置 值行数
		 * @param valueDataRows 值行数
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueDataRows(String valueDataRows) {
			super.change(VALUE_DATA_ROWS,super.getValueDataRows(),valueDataRows);
			super.setValueDataRows(valueDataRows);
			return this;
		}
		
		/**
		 * 设置 值类型
		 * @param valueType 值类型
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueType(String valueType) {
			super.change(VALUE_TYPE,super.getValueType(),valueType);
			super.setValueType(valueType);
			return this;
		}
		
		/**
		 * 设置 来源类型
		 * @param sourceType 来源类型
		 * @return 当前对象
		*/
		public MonitorTplIndicator setSourceType(String sourceType) {
			super.change(SOURCE_TYPE,super.getSourceType(),sourceType);
			super.setSourceType(sourceType);
			return this;
		}
		
		/**
		 * 设置 来源数据
		 * @param sourceValue 来源数据
		 * @return 当前对象
		*/
		public MonitorTplIndicator setSourceValue(String sourceValue) {
			super.change(SOURCE_VALUE,super.getSourceValue(),sourceValue);
			super.setSourceValue(sourceValue);
			return this;
		}
		
		/**
		 * 设置 数值类型
		 * @param valueColumnType 数值类型
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumnType(String valueColumnType) {
			super.change(VALUE_COLUMN_TYPE,super.getValueColumnType(),valueColumnType);
			super.setValueColumnType(valueColumnType);
			return this;
		}
		
		/**
		 * 设置 数值字段
		 * @param valueColumn 数值字段
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumn(String valueColumn) {
			super.change(VALUE_COLUMN,super.getValueColumn(),valueColumn);
			super.setValueColumn(valueColumn);
			return this;
		}
		
		/**
		 * 设置 描述
		 * @param valueColumnDesc 描述
		 * @return 当前对象
		*/
		public MonitorTplIndicator setValueColumnDesc(String valueColumnDesc) {
			super.change(VALUE_COLUMN_DESC,super.getValueColumnDesc(),valueColumnDesc);
			super.setValueColumnDesc(valueColumnDesc);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorTplIndicator setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorTplIndicator setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorTplIndicator setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorTplIndicator setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorTplIndicator setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorTplIndicator setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorTplIndicator setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorTplIndicator setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版
		 * @param tpl 节点模版
		 * @return 当前对象
		*/
		public MonitorTplIndicator setTpl(MonitorTpl tpl) {
			super.change(TPL,super.getTpl(),tpl);
			super.setTpl(tpl);
			return this;
		}
	}
}