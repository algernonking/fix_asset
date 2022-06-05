package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.ActionCrontabVO;
import java.util.List;
import com.dt.platform.domain.eam.ActionCrontab;
import java.util.Date;
import com.dt.platform.domain.eam.ActionCrontabLog;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 21:55:44
 * @sign FF74DDAC6436E72D8FC2225FC4387868
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ActionCrontabVOMeta extends ActionCrontabMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属于 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属于 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,OWNER_ID, java.lang.String.class, "所属于", "所属于", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 表达式 , 类型: java.lang.String
	*/
	public static final String CRONTAB="crontab";
	
	/**
	 * 表达式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> CRONTAB_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,CRONTAB, java.lang.String.class, "表达式", "表达式", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_EXECUTION_TIME="startExecutionTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.util.Date> START_EXECUTION_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,START_EXECUTION_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String FINISH_EXECUTION_TIME="finishExecutionTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.util.Date> FINISH_EXECUTION_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,FINISH_EXECUTION_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 上次执行时间 , 类型: java.util.Date
	*/
	public static final String LAST_EXECUTION_TIME="lastExecutionTime";
	
	/**
	 * 上次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.util.Date> LAST_EXECUTION_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,LAST_EXECUTION_TIME, java.util.Date.class, "上次执行时间", "上次执行时间", java.util.Date.class, null);
	
	/**
	 * 下次执行时间 , 类型: java.util.Date
	*/
	public static final String NEXT_EXECUTION_TIME="nextExecutionTime";
	
	/**
	 * 下次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.util.Date> NEXT_EXECUTION_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,NEXT_EXECUTION_TIME, java.util.Date.class, "下次执行时间", "下次执行时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 日志 , 类型: com.dt.platform.domain.eam.ActionCrontabLog
	*/
	public static final String ACTION_CRONTAB_LOG="actionCrontabLog";
	
	/**
	 * 日志 , 类型: com.dt.platform.domain.eam.ActionCrontabLog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.ActionCrontabVO,com.dt.platform.domain.eam.ActionCrontabLog> ACTION_CRONTAB_LOG_PROP = new BeanProperty(com.dt.platform.domain.eam.ActionCrontabVO.class ,ACTION_CRONTAB_LOG, com.dt.platform.domain.eam.ActionCrontabLog.class, "日志", "日志", com.dt.platform.domain.eam.ActionCrontabLog.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , OWNER_ID , NAME , CRONTAB , START_EXECUTION_TIME , FINISH_EXECUTION_TIME , LAST_EXECUTION_TIME , NEXT_EXECUTION_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , ACTION_CRONTAB_LOG };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.ActionCrontabVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ActionCrontabVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ActionCrontabVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ActionCrontabVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ActionCrontabVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ActionCrontabVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ActionCrontabVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ActionCrontabVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ActionCrontabVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ActionCrontabVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ActionCrontab setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属于
		 * @param ownerId 所属于
		 * @return 当前对象
		*/
		public ActionCrontab setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ActionCrontab setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 表达式
		 * @param crontab 表达式
		 * @return 当前对象
		*/
		public ActionCrontab setCrontab(String crontab) {
			super.change(CRONTAB,super.getCrontab(),crontab);
			super.setCrontab(crontab);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startExecutionTime 开始时间
		 * @return 当前对象
		*/
		public ActionCrontab setStartExecutionTime(Date startExecutionTime) {
			super.change(START_EXECUTION_TIME,super.getStartExecutionTime(),startExecutionTime);
			super.setStartExecutionTime(startExecutionTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param finishExecutionTime 结束时间
		 * @return 当前对象
		*/
		public ActionCrontab setFinishExecutionTime(Date finishExecutionTime) {
			super.change(FINISH_EXECUTION_TIME,super.getFinishExecutionTime(),finishExecutionTime);
			super.setFinishExecutionTime(finishExecutionTime);
			return this;
		}
		
		/**
		 * 设置 上次执行时间
		 * @param lastExecutionTime 上次执行时间
		 * @return 当前对象
		*/
		public ActionCrontab setLastExecutionTime(Date lastExecutionTime) {
			super.change(LAST_EXECUTION_TIME,super.getLastExecutionTime(),lastExecutionTime);
			super.setLastExecutionTime(lastExecutionTime);
			return this;
		}
		
		/**
		 * 设置 下次执行时间
		 * @param nextExecutionTime 下次执行时间
		 * @return 当前对象
		*/
		public ActionCrontab setNextExecutionTime(Date nextExecutionTime) {
			super.change(NEXT_EXECUTION_TIME,super.getNextExecutionTime(),nextExecutionTime);
			super.setNextExecutionTime(nextExecutionTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ActionCrontab setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ActionCrontab setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ActionCrontab setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ActionCrontab setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ActionCrontab setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ActionCrontab setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ActionCrontab setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ActionCrontab setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public ActionCrontab setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ActionCrontab setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 日志
		 * @param actionCrontabLog 日志
		 * @return 当前对象
		*/
		public ActionCrontab setActionCrontabLog(ActionCrontabLog actionCrontabLog) {
			super.change(ACTION_CRONTAB_LOG,super.getActionCrontabLog(),actionCrontabLog);
			super.setActionCrontabLog(actionCrontabLog);
			return this;
		}
	}
}