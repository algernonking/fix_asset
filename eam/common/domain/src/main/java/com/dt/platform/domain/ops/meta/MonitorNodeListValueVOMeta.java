package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorNodeListValueVO;
import java.util.List;
import com.dt.platform.domain.ops.MonitorNodeListValue;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:53
 * @sign BEB5DB40C343836F1108C7FB3AF19254
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorNodeListValueVOMeta extends MonitorNodeListValueMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> NODE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,NODE_ID, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final String INDICATOR_CODE="indicatorCode";
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> INDICATOR_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,INDICATOR_CODE, java.lang.String.class, "指标", "指标", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 值类型 , 类型: java.lang.String
	*/
	public static final String VALUE_TYPE="valueType";
	
	/**
	 * 值类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> VALUE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VALUE_TYPE, java.lang.String.class, "值类型", "值类型", java.lang.String.class, null);
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final String LABEL1="label1";
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> LABEL1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,LABEL1, java.lang.String.class, "标签1", "标签1", java.lang.String.class, null);
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final String LABEL2="label2";
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> LABEL2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,LABEL2, java.lang.String.class, "标签2", "标签2", java.lang.String.class, null);
	
	/**
	 * 标签3 , 类型: java.lang.String
	*/
	public static final String LABEL3="label3";
	
	/**
	 * 标签3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> LABEL3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,LABEL3, java.lang.String.class, "标签3", "标签3", java.lang.String.class, null);
	
	/**
	 * 编码1 , 类型: java.lang.String
	*/
	public static final String CODE1="code1";
	
	/**
	 * 编码1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> CODE1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,CODE1, java.lang.String.class, "编码1", "编码1", java.lang.String.class, null);
	
	/**
	 * 编码2 , 类型: java.lang.String
	*/
	public static final String CODE2="code2";
	
	/**
	 * 编码2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> CODE2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,CODE2, java.lang.String.class, "编码2", "编码2", java.lang.String.class, null);
	
	/**
	 * 数值1 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE_NUMBER1="valueNumber1";
	
	/**
	 * 数值1 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.math.BigDecimal> VALUE_NUMBER1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VALUE_NUMBER1, java.math.BigDecimal.class, "数值1", "数值1", java.math.BigDecimal.class, null);
	
	/**
	 * 数值2 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE_NUMBER2="valueNumber2";
	
	/**
	 * 数值2 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.math.BigDecimal> VALUE_NUMBER2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VALUE_NUMBER2, java.math.BigDecimal.class, "数值2", "数值2", java.math.BigDecimal.class, null);
	
	/**
	 * 数值3 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE_NUMBER3="valueNumber3";
	
	/**
	 * 数值3 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.math.BigDecimal> VALUE_NUMBER3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VALUE_NUMBER3, java.math.BigDecimal.class, "数值3", "数值3", java.math.BigDecimal.class, null);
	
	/**
	 * 字符串1 , 类型: java.lang.String
	*/
	public static final String VALUE_STR1="valueStr1";
	
	/**
	 * 字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> VALUE_STR1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VALUE_STR1, java.lang.String.class, "字符串1", "字符串1", java.lang.String.class, null);
	
	/**
	 * 字符串2 , 类型: java.lang.String
	*/
	public static final String VALUE_STR2="valueStr2";
	
	/**
	 * 字符串2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> VALUE_STR2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VALUE_STR2, java.lang.String.class, "字符串2", "字符串2", java.lang.String.class, null);
	
	/**
	 * 字符串3 , 类型: java.lang.String
	*/
	public static final String VALUE_STR3="valueStr3";
	
	/**
	 * 字符串3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> VALUE_STR3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VALUE_STR3, java.lang.String.class, "字符串3", "字符串3", java.lang.String.class, null);
	
	/**
	 * 唯一标识 , 类型: java.lang.String
	*/
	public static final String UID="uid";
	
	/**
	 * 唯一标识 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> UID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,UID, java.lang.String.class, "唯一标识", "唯一标识", java.lang.String.class, null);
	
	/**
	 * 信息 , 类型: java.lang.String
	*/
	public static final String INFO="info";
	
	/**
	 * 信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,INFO, java.lang.String.class, "信息", "信息", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeListValueVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeListValueVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , NODE_ID , INDICATOR_CODE , MONITOR_TPL_CODE , VALUE_TYPE , LABEL1 , LABEL2 , LABEL3 , CODE1 , CODE2 , VALUE_NUMBER1 , VALUE_NUMBER2 , VALUE_NUMBER3 , VALUE_STR1 , VALUE_STR2 , VALUE_STR3 , UID , INFO , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorNodeListValueVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MonitorNodeListValueVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorNodeListValue setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeId 节点
		 * @return 当前对象
		*/
		public MonitorNodeListValue setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 指标
		 * @param indicatorCode 指标
		 * @return 当前对象
		*/
		public MonitorNodeListValue setIndicatorCode(String indicatorCode) {
			super.change(INDICATOR_CODE,super.getIndicatorCode(),indicatorCode);
			super.setIndicatorCode(indicatorCode);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorNodeListValue setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 值类型
		 * @param valueType 值类型
		 * @return 当前对象
		*/
		public MonitorNodeListValue setValueType(String valueType) {
			super.change(VALUE_TYPE,super.getValueType(),valueType);
			super.setValueType(valueType);
			return this;
		}
		
		/**
		 * 设置 标签1
		 * @param label1 标签1
		 * @return 当前对象
		*/
		public MonitorNodeListValue setLabel1(String label1) {
			super.change(LABEL1,super.getLabel1(),label1);
			super.setLabel1(label1);
			return this;
		}
		
		/**
		 * 设置 标签2
		 * @param label2 标签2
		 * @return 当前对象
		*/
		public MonitorNodeListValue setLabel2(String label2) {
			super.change(LABEL2,super.getLabel2(),label2);
			super.setLabel2(label2);
			return this;
		}
		
		/**
		 * 设置 标签3
		 * @param label3 标签3
		 * @return 当前对象
		*/
		public MonitorNodeListValue setLabel3(String label3) {
			super.change(LABEL3,super.getLabel3(),label3);
			super.setLabel3(label3);
			return this;
		}
		
		/**
		 * 设置 编码1
		 * @param code1 编码1
		 * @return 当前对象
		*/
		public MonitorNodeListValue setCode1(String code1) {
			super.change(CODE1,super.getCode1(),code1);
			super.setCode1(code1);
			return this;
		}
		
		/**
		 * 设置 编码2
		 * @param code2 编码2
		 * @return 当前对象
		*/
		public MonitorNodeListValue setCode2(String code2) {
			super.change(CODE2,super.getCode2(),code2);
			super.setCode2(code2);
			return this;
		}
		
		/**
		 * 设置 数值1
		 * @param valueNumber1 数值1
		 * @return 当前对象
		*/
		public MonitorNodeListValue setValueNumber1(BigDecimal valueNumber1) {
			super.change(VALUE_NUMBER1,super.getValueNumber1(),valueNumber1);
			super.setValueNumber1(valueNumber1);
			return this;
		}
		
		/**
		 * 设置 数值2
		 * @param valueNumber2 数值2
		 * @return 当前对象
		*/
		public MonitorNodeListValue setValueNumber2(BigDecimal valueNumber2) {
			super.change(VALUE_NUMBER2,super.getValueNumber2(),valueNumber2);
			super.setValueNumber2(valueNumber2);
			return this;
		}
		
		/**
		 * 设置 数值3
		 * @param valueNumber3 数值3
		 * @return 当前对象
		*/
		public MonitorNodeListValue setValueNumber3(BigDecimal valueNumber3) {
			super.change(VALUE_NUMBER3,super.getValueNumber3(),valueNumber3);
			super.setValueNumber3(valueNumber3);
			return this;
		}
		
		/**
		 * 设置 字符串1
		 * @param valueStr1 字符串1
		 * @return 当前对象
		*/
		public MonitorNodeListValue setValueStr1(String valueStr1) {
			super.change(VALUE_STR1,super.getValueStr1(),valueStr1);
			super.setValueStr1(valueStr1);
			return this;
		}
		
		/**
		 * 设置 字符串2
		 * @param valueStr2 字符串2
		 * @return 当前对象
		*/
		public MonitorNodeListValue setValueStr2(String valueStr2) {
			super.change(VALUE_STR2,super.getValueStr2(),valueStr2);
			super.setValueStr2(valueStr2);
			return this;
		}
		
		/**
		 * 设置 字符串3
		 * @param valueStr3 字符串3
		 * @return 当前对象
		*/
		public MonitorNodeListValue setValueStr3(String valueStr3) {
			super.change(VALUE_STR3,super.getValueStr3(),valueStr3);
			super.setValueStr3(valueStr3);
			return this;
		}
		
		/**
		 * 设置 唯一标识
		 * @param uid 唯一标识
		 * @return 当前对象
		*/
		public MonitorNodeListValue setUid(String uid) {
			super.change(UID,super.getUid(),uid);
			super.setUid(uid);
			return this;
		}
		
		/**
		 * 设置 信息
		 * @param info 信息
		 * @return 当前对象
		*/
		public MonitorNodeListValue setInfo(String info) {
			super.change(INFO,super.getInfo(),info);
			super.setInfo(info);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public MonitorNodeListValue setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorNodeListValue setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorNodeListValue setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorNodeListValue setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorNodeListValue setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorNodeListValue setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorNodeListValue setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorNodeListValue setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorNodeListValue setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}