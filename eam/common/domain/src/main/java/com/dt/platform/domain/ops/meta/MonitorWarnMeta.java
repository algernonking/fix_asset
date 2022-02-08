package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorWarn;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:57
 * @sign AF2D1B9440B00EA6B31537770BFD2D84
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorWarnMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> NODE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,NODE_ID, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 监控数值 , 类型: java.lang.String
	*/
	public static final String NODE_VALUE_ID="nodeValueId";
	
	/**
	 * 监控数值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> NODE_VALUE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,NODE_VALUE_ID, java.lang.String.class, "监控数值", "监控数值", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 监控指标 , 类型: java.lang.String
	*/
	public static final String INDICATOR_CODE="indicatorCode";
	
	/**
	 * 监控指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> INDICATOR_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,INDICATOR_CODE, java.lang.String.class, "监控指标", "监控指标", java.lang.String.class, null);
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final String INDICATOR_NAME="indicatorName";
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> INDICATOR_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,INDICATOR_NAME, java.lang.String.class, "指标名称", "指标名称", java.lang.String.class, null);
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final String WARN_LEVEL="warnLevel";
	
	/**
	 * 告警等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> WARN_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,WARN_LEVEL, java.lang.String.class, "告警等级", "告警等级", java.lang.String.class, null);
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,STATUS, java.lang.String.class, "处理状态", "处理状态", java.lang.String.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String HANDLED_TIME="handledTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.util.Date> HANDLED_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,HANDLED_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 告警时间 , 类型: java.util.Date
	*/
	public static final String WARN_TIME="warnTime";
	
	/**
	 * 告警时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.util.Date> WARN_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,WARN_TIME, java.util.Date.class, "告警时间", "告警时间", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String TPL="tpl";
	
	/**
	 * 节点模版 , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,com.dt.platform.domain.ops.MonitorTpl> TPL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,TPL, com.dt.platform.domain.ops.MonitorTpl.class, "节点模版", "节点模版", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * 节点指标 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplIndicator
	*/
	public static final String TPL_INDICATOR="tplIndicator";
	
	/**
	 * 节点指标 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTplIndicator
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorWarn,com.dt.platform.domain.ops.MonitorTplIndicator> TPL_INDICATOR_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorWarn.class ,TPL_INDICATOR, java.util.List.class, "节点指标", "节点指标", com.dt.platform.domain.ops.MonitorTplIndicator.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NODE_ID , NODE_VALUE_ID , MONITOR_TPL_CODE , INDICATOR_CODE , INDICATOR_NAME , WARN_LEVEL , STATUS , HANDLED_TIME , WARN_TIME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TPL , TPL_INDICATOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorWarn {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorWarn setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeId 节点
		 * @return 当前对象
		*/
		public MonitorWarn setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 监控数值
		 * @param nodeValueId 监控数值
		 * @return 当前对象
		*/
		public MonitorWarn setNodeValueId(String nodeValueId) {
			super.change(NODE_VALUE_ID,super.getNodeValueId(),nodeValueId);
			super.setNodeValueId(nodeValueId);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorWarn setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 监控指标
		 * @param indicatorCode 监控指标
		 * @return 当前对象
		*/
		public MonitorWarn setIndicatorCode(String indicatorCode) {
			super.change(INDICATOR_CODE,super.getIndicatorCode(),indicatorCode);
			super.setIndicatorCode(indicatorCode);
			return this;
		}
		
		/**
		 * 设置 指标名称
		 * @param indicatorName 指标名称
		 * @return 当前对象
		*/
		public MonitorWarn setIndicatorName(String indicatorName) {
			super.change(INDICATOR_NAME,super.getIndicatorName(),indicatorName);
			super.setIndicatorName(indicatorName);
			return this;
		}
		
		/**
		 * 设置 告警等级
		 * @param warnLevel 告警等级
		 * @return 当前对象
		*/
		public MonitorWarn setWarnLevel(String warnLevel) {
			super.change(WARN_LEVEL,super.getWarnLevel(),warnLevel);
			super.setWarnLevel(warnLevel);
			return this;
		}
		
		/**
		 * 设置 处理状态
		 * @param status 处理状态
		 * @return 当前对象
		*/
		public MonitorWarn setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param handledTime 处理时间
		 * @return 当前对象
		*/
		public MonitorWarn setHandledTime(Date handledTime) {
			super.change(HANDLED_TIME,super.getHandledTime(),handledTime);
			super.setHandledTime(handledTime);
			return this;
		}
		
		/**
		 * 设置 告警时间
		 * @param warnTime 告警时间
		 * @return 当前对象
		*/
		public MonitorWarn setWarnTime(Date warnTime) {
			super.change(WARN_TIME,super.getWarnTime(),warnTime);
			super.setWarnTime(warnTime);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public MonitorWarn setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorWarn setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorWarn setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorWarn setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorWarn setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorWarn setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorWarn setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorWarn setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorWarn setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorWarn setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点模版
		 * @param tpl 节点模版
		 * @return 当前对象
		*/
		public MonitorWarn setTpl(MonitorTpl tpl) {
			super.change(TPL,super.getTpl(),tpl);
			super.setTpl(tpl);
			return this;
		}
		
		/**
		 * 设置 节点指标
		 * @param tplIndicator 节点指标
		 * @return 当前对象
		*/
		public MonitorWarn setTplIndicator(List<MonitorTplIndicator> tplIndicator) {
			super.change(TPL_INDICATOR,super.getTplIndicator(),tplIndicator);
			super.setTplIndicator(tplIndicator);
			return this;
		}
	}
}