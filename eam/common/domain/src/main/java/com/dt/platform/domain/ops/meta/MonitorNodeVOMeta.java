package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorNodeVO;
import java.util.List;
import com.dt.platform.domain.ops.MonitorNode;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.MonitorNodeSubtype;
import com.dt.platform.domain.ops.MonitorNodeHost;
import com.dt.platform.domain.ops.MonitorNodeDb;
import com.dt.platform.domain.ops.MonitorNodeValue;
import com.dt.platform.domain.ops.MonitorNodeListValue;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-02 14:55:24
 * @sign 13F4166DF1AF357762C535703A996EE5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorNodeVOMeta extends MonitorNodeMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final String PID="pid";
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> PID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,PID, java.lang.String.class, "父节点", "父节点", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 子类型 , 类型: java.lang.String
	*/
	public static final String SUB_TYPE="subType";
	
	/**
	 * 子类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> SUB_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,SUB_TYPE, java.lang.String.class, "子类型", "子类型", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String NODE_IP="nodeIp";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> NODE_IP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,NODE_IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 主机名 , 类型: java.lang.String
	*/
	public static final String NODE_NAME="nodeName";
	
	/**
	 * 主机名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> NODE_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,NODE_NAME, java.lang.String.class, "主机名", "主机名", java.lang.String.class, null);
	
	/**
	 * 可见主机名 , 类型: java.lang.String
	*/
	public static final String NODE_NAME_SHOW="nodeNameShow";
	
	/**
	 * 可见主机名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> NODE_NAME_SHOW_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,NODE_NAME_SHOW, java.lang.String.class, "可见主机名", "可见主机名", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String NODE_TYPE="nodeType";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> NODE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,NODE_TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 是否启用 , 类型: java.lang.String
	*/
	public static final String NODE_ENABLED="nodeEnabled";
	
	/**
	 * 是否启用 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> NODE_ENABLED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,NODE_ENABLED, java.lang.String.class, "是否启用", "是否启用", java.lang.String.class, null);
	
	/**
	 * 监控状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 监控状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,STATUS, java.lang.String.class, "监控状态", "监控状态", java.lang.String.class, null);
	
	/**
	 * 监控方式 , 类型: java.lang.String
	*/
	public static final String MONITOR_METHOD="monitorMethod";
	
	/**
	 * 监控方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> MONITOR_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,MONITOR_METHOD, java.lang.String.class, "监控方式", "监控方式", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 节点类型 , 类型: com.dt.platform.domain.ops.MonitorNodeType
	*/
	public static final String MONITOR_NODE_TYPE="monitorNodeType";
	
	/**
	 * 节点类型 , 类型: com.dt.platform.domain.ops.MonitorNodeType
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,com.dt.platform.domain.ops.MonitorNodeType> MONITOR_NODE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,MONITOR_NODE_TYPE, com.dt.platform.domain.ops.MonitorNodeType.class, "节点类型", "节点类型", com.dt.platform.domain.ops.MonitorNodeType.class, null);
	
	/**
	 * 节点子类型 , 类型: com.dt.platform.domain.ops.MonitorNodeSubtype
	*/
	public static final String MONITOR_NODE_SUB_TYPE="monitorNodeSubType";
	
	/**
	 * 节点子类型 , 类型: com.dt.platform.domain.ops.MonitorNodeSubtype
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,com.dt.platform.domain.ops.MonitorNodeSubtype> MONITOR_NODE_SUB_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,MONITOR_NODE_SUB_TYPE, com.dt.platform.domain.ops.MonitorNodeSubtype.class, "节点子类型", "节点子类型", com.dt.platform.domain.ops.MonitorNodeSubtype.class, null);
	
	/**
	 * 主机信息 , 类型: com.dt.platform.domain.ops.MonitorNodeHost
	*/
	public static final String MONITOR_NODE_HOST="monitorNodeHost";
	
	/**
	 * 主机信息 , 类型: com.dt.platform.domain.ops.MonitorNodeHost
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,com.dt.platform.domain.ops.MonitorNodeHost> MONITOR_NODE_HOST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,MONITOR_NODE_HOST, com.dt.platform.domain.ops.MonitorNodeHost.class, "主机信息", "主机信息", com.dt.platform.domain.ops.MonitorNodeHost.class, null);
	
	/**
	 * 数据库信息 , 类型: com.dt.platform.domain.ops.MonitorNodeDb
	*/
	public static final String MONITOR_NODE_DB="monitorNodeDb";
	
	/**
	 * 数据库信息 , 类型: com.dt.platform.domain.ops.MonitorNodeDb
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,com.dt.platform.domain.ops.MonitorNodeDb> MONITOR_NODE_DB_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,MONITOR_NODE_DB, com.dt.platform.domain.ops.MonitorNodeDb.class, "数据库信息", "数据库信息", com.dt.platform.domain.ops.MonitorNodeDb.class, null);
	
	/**
	 * 数值信息 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeValue
	*/
	public static final String MONITOR_NODE_VALUE_LIST="monitorNodeValueList";
	
	/**
	 * 数值信息 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeValue
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,com.dt.platform.domain.ops.MonitorNodeValue> MONITOR_NODE_VALUE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,MONITOR_NODE_VALUE_LIST, java.util.List.class, "数值信息", "数值信息", com.dt.platform.domain.ops.MonitorNodeValue.class, null);
	
	/**
	 * 列表数值信息 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeListValue
	*/
	public static final String MONITOR_NODE_LIST_VALUE_LIST="monitorNodeListValueList";
	
	/**
	 * 列表数值信息 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeListValue
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeVO,com.dt.platform.domain.ops.MonitorNodeListValue> MONITOR_NODE_LIST_VALUE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeVO.class ,MONITOR_NODE_LIST_VALUE_LIST, java.util.List.class, "列表数值信息", "列表数值信息", com.dt.platform.domain.ops.MonitorNodeListValue.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , PID , TYPE , SUB_TYPE , NODE_IP , NODE_NAME , NODE_NAME_SHOW , NODE_TYPE , NODE_ENABLED , STATUS , MONITOR_METHOD , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , MONITOR_NODE_TYPE , MONITOR_NODE_SUB_TYPE , MONITOR_NODE_HOST , MONITOR_NODE_DB , MONITOR_NODE_VALUE_LIST , MONITOR_NODE_LIST_VALUE_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorNodeVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MonitorNodeVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MonitorNodeVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MonitorNodeVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MonitorNodeVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MonitorNodeVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MonitorNodeVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MonitorNodeVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MonitorNodeVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MonitorNodeVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorNode setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 父节点
		 * @param pid 父节点
		 * @return 当前对象
		*/
		public MonitorNode setPid(String pid) {
			super.change(PID,super.getPid(),pid);
			super.setPid(pid);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public MonitorNode setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 子类型
		 * @param subType 子类型
		 * @return 当前对象
		*/
		public MonitorNode setSubType(String subType) {
			super.change(SUB_TYPE,super.getSubType(),subType);
			super.setSubType(subType);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param nodeIp IP
		 * @return 当前对象
		*/
		public MonitorNode setNodeIp(String nodeIp) {
			super.change(NODE_IP,super.getNodeIp(),nodeIp);
			super.setNodeIp(nodeIp);
			return this;
		}
		
		/**
		 * 设置 主机名
		 * @param nodeName 主机名
		 * @return 当前对象
		*/
		public MonitorNode setNodeName(String nodeName) {
			super.change(NODE_NAME,super.getNodeName(),nodeName);
			super.setNodeName(nodeName);
			return this;
		}
		
		/**
		 * 设置 可见主机名
		 * @param nodeNameShow 可见主机名
		 * @return 当前对象
		*/
		public MonitorNode setNodeNameShow(String nodeNameShow) {
			super.change(NODE_NAME_SHOW,super.getNodeNameShow(),nodeNameShow);
			super.setNodeNameShow(nodeNameShow);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param nodeType 类型
		 * @return 当前对象
		*/
		public MonitorNode setNodeType(String nodeType) {
			super.change(NODE_TYPE,super.getNodeType(),nodeType);
			super.setNodeType(nodeType);
			return this;
		}
		
		/**
		 * 设置 是否启用
		 * @param nodeEnabled 是否启用
		 * @return 当前对象
		*/
		public MonitorNode setNodeEnabled(String nodeEnabled) {
			super.change(NODE_ENABLED,super.getNodeEnabled(),nodeEnabled);
			super.setNodeEnabled(nodeEnabled);
			return this;
		}
		
		/**
		 * 设置 监控状态
		 * @param status 监控状态
		 * @return 当前对象
		*/
		public MonitorNode setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 监控方式
		 * @param monitorMethod 监控方式
		 * @return 当前对象
		*/
		public MonitorNode setMonitorMethod(String monitorMethod) {
			super.change(MONITOR_METHOD,super.getMonitorMethod(),monitorMethod);
			super.setMonitorMethod(monitorMethod);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorNode setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorNode setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorNode setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorNode setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorNode setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorNode setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorNode setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorNode setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorNode setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param monitorNodeType 节点类型
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeType(MonitorNodeType monitorNodeType) {
			super.change(MONITOR_NODE_TYPE,super.getMonitorNodeType(),monitorNodeType);
			super.setMonitorNodeType(monitorNodeType);
			return this;
		}
		
		/**
		 * 设置 节点子类型
		 * @param monitorNodeSubType 节点子类型
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeSubType(MonitorNodeSubtype monitorNodeSubType) {
			super.change(MONITOR_NODE_SUB_TYPE,super.getMonitorNodeSubType(),monitorNodeSubType);
			super.setMonitorNodeSubType(monitorNodeSubType);
			return this;
		}
		
		/**
		 * 设置 主机信息
		 * @param monitorNodeHost 主机信息
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeHost(MonitorNodeHost monitorNodeHost) {
			super.change(MONITOR_NODE_HOST,super.getMonitorNodeHost(),monitorNodeHost);
			super.setMonitorNodeHost(monitorNodeHost);
			return this;
		}
		
		/**
		 * 设置 数据库信息
		 * @param monitorNodeDb 数据库信息
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeDb(MonitorNodeDb monitorNodeDb) {
			super.change(MONITOR_NODE_DB,super.getMonitorNodeDb(),monitorNodeDb);
			super.setMonitorNodeDb(monitorNodeDb);
			return this;
		}
		
		/**
		 * 设置 数值信息
		 * @param monitorNodeValueList 数值信息
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeValueList(List<MonitorNodeValue> monitorNodeValueList) {
			super.change(MONITOR_NODE_VALUE_LIST,super.getMonitorNodeValueList(),monitorNodeValueList);
			super.setMonitorNodeValueList(monitorNodeValueList);
			return this;
		}
		
		/**
		 * 设置 列表数值信息
		 * @param monitorNodeListValueList 列表数值信息
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeListValueList(List<MonitorNodeListValue> monitorNodeListValueList) {
			super.change(MONITOR_NODE_LIST_VALUE_LIST,super.getMonitorNodeListValueList(),monitorNodeListValueList);
			super.setMonitorNodeListValueList(monitorNodeListValueList);
			return this;
		}
	}
}