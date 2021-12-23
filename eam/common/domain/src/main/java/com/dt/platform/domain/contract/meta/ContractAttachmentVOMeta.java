package com.dt.platform.domain.contract.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.contract.ContractAttachmentVO;
import java.util.List;
import com.dt.platform.domain.contract.ContractAttachment;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-23 16:54:46
 * @sign 1F86ADF32AF5105047C1F0D534DCA64E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ContractAttachmentVOMeta extends ContractAttachmentMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所有者ID , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所有者ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,OWNER_ID, java.lang.String.class, "所有者ID", "所有者ID", java.lang.String.class, null);
	
	/**
	 * 所有者类型 , 合同/履约情况；枚举： AttachmentOwnerType , 类型: java.lang.String
	*/
	public static final String OWNER_TYPE="ownerType";
	
	/**
	 * 所有者类型 , 合同/履约情况；枚举： AttachmentOwnerType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> OWNER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,OWNER_TYPE, java.lang.String.class, "所有者类型", "合同/履约情况；枚举： AttachmentOwnerType", java.lang.String.class, null);
	
	/**
	 * 附件类型 , 枚举：AttachmentType , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 附件类型 , 枚举：AttachmentType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,TYPE, java.lang.String.class, "附件类型", "枚举：AttachmentType", java.lang.String.class, null);
	
	/**
	 * 文件ID , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 文件ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,FILE_ID, java.lang.String.class, "文件ID", "文件ID", java.lang.String.class, null);
	
	/**
	 * 附件名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 附件名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,NAME, java.lang.String.class, "附件名称", "附件名称", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractAttachmentVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractAttachmentVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , OWNER_ID , OWNER_TYPE , TYPE , FILE_ID , NAME , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.contract.ContractAttachmentVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ContractAttachmentVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ContractAttachmentVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ContractAttachmentVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ContractAttachmentVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ContractAttachmentVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ContractAttachmentVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ContractAttachmentVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ContractAttachmentVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ContractAttachmentVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ContractAttachment setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所有者ID
		 * @param ownerId 所有者ID
		 * @return 当前对象
		*/
		public ContractAttachment setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 所有者类型
		 * @param ownerType 所有者类型
		 * @return 当前对象
		*/
		public ContractAttachment setOwnerType(String ownerType) {
			super.change(OWNER_TYPE,super.getOwnerType(),ownerType);
			super.setOwnerType(ownerType);
			return this;
		}
		
		/**
		 * 设置 附件类型
		 * @param type 附件类型
		 * @return 当前对象
		*/
		public ContractAttachment setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 文件ID
		 * @param fileId 文件ID
		 * @return 当前对象
		*/
		public ContractAttachment setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 附件名称
		 * @param name 附件名称
		 * @return 当前对象
		*/
		public ContractAttachment setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ContractAttachment setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ContractAttachment setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ContractAttachment setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ContractAttachment setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ContractAttachment setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ContractAttachment setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ContractAttachment setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ContractAttachment setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ContractAttachment setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ContractAttachment setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}