package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDataPermissionsVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetDataPermissions;
import java.util.Date;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Position;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-17 11:24:07
 * @sign F89DDAE2A9D0256A5A03713C37B6C086
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetDataPermissionsVOMeta extends AssetDataPermissionsMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,OWNER_CODE, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 权限编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 权限编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,CODE, java.lang.String.class, "权限编码", "权限编码", java.lang.String.class, null);
	
	/**
	 * 业务角色 , 类型: java.lang.String
	*/
	public static final String ROLE_CODE="roleCode";
	
	/**
	 * 业务角色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> ROLE_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,ROLE_CODE, java.lang.String.class, "业务角色", "业务角色", java.lang.String.class, null);
	
	/**
	 * 组织权限状态 , 类型: java.lang.String
	*/
	public static final String ORG_AUTHORITY_ENABLE="orgAuthorityEnable";
	
	/**
	 * 组织权限状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> ORG_AUTHORITY_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,ORG_AUTHORITY_ENABLE, java.lang.String.class, "组织权限状态", "组织权限状态", java.lang.String.class, null);
	
	/**
	 * 本组织激活 , 类型: java.lang.String
	*/
	public static final String ORG_LOCAL_ENABLE="orgLocalEnable";
	
	/**
	 * 本组织激活 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> ORG_LOCAL_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,ORG_LOCAL_ENABLE, java.lang.String.class, "本组织激活", "本组织激活", java.lang.String.class, null);
	
	/**
	 * 组织级联状态 , 类型: java.lang.String
	*/
	public static final String ORG_CASCADE_ENABLE="orgCascadeEnable";
	
	/**
	 * 组织级联状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> ORG_CASCADE_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,ORG_CASCADE_ENABLE, java.lang.String.class, "组织级联状态", "组织级联状态", java.lang.String.class, null);
	
	/**
	 * 分类权限状态 , 类型: java.lang.String
	*/
	public static final String CATALOG_AUTHORITY_ENABLE="catalogAuthorityEnable";
	
	/**
	 * 分类权限状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> CATALOG_AUTHORITY_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,CATALOG_AUTHORITY_ENABLE, java.lang.String.class, "分类权限状态", "分类权限状态", java.lang.String.class, null);
	
	/**
	 * 分类级联状态 , 类型: java.lang.String
	*/
	public static final String CATALOG_CASCADE_ENABLE="catalogCascadeEnable";
	
	/**
	 * 分类级联状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> CATALOG_CASCADE_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,CATALOG_CASCADE_ENABLE, java.lang.String.class, "分类级联状态", "分类级联状态", java.lang.String.class, null);
	
	/**
	 * 位置权限状态 , 类型: java.lang.String
	*/
	public static final String POSITION_AUTHORITY_ENABLE="positionAuthorityEnable";
	
	/**
	 * 位置权限状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> POSITION_AUTHORITY_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,POSITION_AUTHORITY_ENABLE, java.lang.String.class, "位置权限状态", "位置权限状态", java.lang.String.class, null);
	
	/**
	 * 优先级 , 类型: java.lang.Integer
	*/
	public static final String PRIORITY="priority";
	
	/**
	 * 优先级 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.Integer> PRIORITY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,PRIORITY, java.lang.Integer.class, "优先级", "优先级", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 业务角色 , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final String BUSI_ROLE="busiRole";
	
	/**
	 * 业务角色 , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,org.github.foxnic.web.domain.system.BusiRole> BUSI_ROLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,BUSI_ROLE, org.github.foxnic.web.domain.system.BusiRole.class, "业务角色", "业务角色", org.github.foxnic.web.domain.system.BusiRole.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,CATEGORY, java.util.List.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CATEGORY_IDS="categoryIds";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> CATEGORY_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,CATEGORY_IDS, java.util.List.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,ORGANIZATION, java.util.List.class, "组织节点", "组织节点", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ORGANIZATION_IDS="organizationIds";
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> ORGANIZATION_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,ORGANIZATION_IDS, java.util.List.class, "组织节点", "组织节点", java.lang.String.class, null);
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,POSITION, java.util.List.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissionsVO,java.lang.String> POSITION_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissionsVO.class ,POSITION_IDS, java.util.List.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , NAME , OWNER_CODE , CODE , ROLE_CODE , ORG_AUTHORITY_ENABLE , ORG_LOCAL_ENABLE , ORG_CASCADE_ENABLE , CATALOG_AUTHORITY_ENABLE , CATALOG_CASCADE_ENABLE , POSITION_AUTHORITY_ENABLE , PRIORITY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , BUSI_ROLE , CATEGORY , CATEGORY_IDS , ORGANIZATION , ORGANIZATION_IDS , POSITION , POSITION_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetDataPermissionsVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetDataPermissionsVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetDataPermissions setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AssetDataPermissions setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param ownerCode 归属
		 * @return 当前对象
		*/
		public AssetDataPermissions setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 权限编码
		 * @param code 权限编码
		 * @return 当前对象
		*/
		public AssetDataPermissions setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 业务角色
		 * @param roleCode 业务角色
		 * @return 当前对象
		*/
		public AssetDataPermissions setRoleCode(String roleCode) {
			super.change(ROLE_CODE,super.getRoleCode(),roleCode);
			super.setRoleCode(roleCode);
			return this;
		}
		
		/**
		 * 设置 组织权限状态
		 * @param orgAuthorityEnable 组织权限状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrgAuthorityEnable(String orgAuthorityEnable) {
			super.change(ORG_AUTHORITY_ENABLE,super.getOrgAuthorityEnable(),orgAuthorityEnable);
			super.setOrgAuthorityEnable(orgAuthorityEnable);
			return this;
		}
		
		/**
		 * 设置 本组织激活
		 * @param orgLocalEnable 本组织激活
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrgLocalEnable(String orgLocalEnable) {
			super.change(ORG_LOCAL_ENABLE,super.getOrgLocalEnable(),orgLocalEnable);
			super.setOrgLocalEnable(orgLocalEnable);
			return this;
		}
		
		/**
		 * 设置 组织级联状态
		 * @param orgCascadeEnable 组织级联状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrgCascadeEnable(String orgCascadeEnable) {
			super.change(ORG_CASCADE_ENABLE,super.getOrgCascadeEnable(),orgCascadeEnable);
			super.setOrgCascadeEnable(orgCascadeEnable);
			return this;
		}
		
		/**
		 * 设置 分类权限状态
		 * @param catalogAuthorityEnable 分类权限状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setCatalogAuthorityEnable(String catalogAuthorityEnable) {
			super.change(CATALOG_AUTHORITY_ENABLE,super.getCatalogAuthorityEnable(),catalogAuthorityEnable);
			super.setCatalogAuthorityEnable(catalogAuthorityEnable);
			return this;
		}
		
		/**
		 * 设置 分类级联状态
		 * @param catalogCascadeEnable 分类级联状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setCatalogCascadeEnable(String catalogCascadeEnable) {
			super.change(CATALOG_CASCADE_ENABLE,super.getCatalogCascadeEnable(),catalogCascadeEnable);
			super.setCatalogCascadeEnable(catalogCascadeEnable);
			return this;
		}
		
		/**
		 * 设置 位置权限状态
		 * @param positionAuthorityEnable 位置权限状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setPositionAuthorityEnable(String positionAuthorityEnable) {
			super.change(POSITION_AUTHORITY_ENABLE,super.getPositionAuthorityEnable(),positionAuthorityEnable);
			super.setPositionAuthorityEnable(positionAuthorityEnable);
			return this;
		}
		
		/**
		 * 设置 优先级
		 * @param priority 优先级
		 * @return 当前对象
		*/
		public AssetDataPermissions setPriority(Integer priority) {
			super.change(PRIORITY,super.getPriority(),priority);
			super.setPriority(priority);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetDataPermissions setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetDataPermissions setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetDataPermissions setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetDataPermissions setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetDataPermissions setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetDataPermissions setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetDataPermissions setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetDataPermissions setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssetDataPermissions setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetDataPermissions setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 业务角色
		 * @param busiRole 业务角色
		 * @return 当前对象
		*/
		public AssetDataPermissions setBusiRole(BusiRole busiRole) {
			super.change(BUSI_ROLE,super.getBusiRole(),busiRole);
			super.setBusiRole(busiRole);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public AssetDataPermissions setCategory(List<Catalog> category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param categoryIds 资产分类
		 * @return 当前对象
		*/
		public AssetDataPermissions setCategoryIds(List<String> categoryIds) {
			super.change(CATEGORY_IDS,super.getCategoryIds(),categoryIds);
			super.setCategoryIds(categoryIds);
			return this;
		}
		
		/**
		 * 设置 组织节点
		 * @param organization 组织节点
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrganization(List<Organization> organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
		
		/**
		 * 设置 组织节点
		 * @param organizationIds 组织节点
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrganizationIds(List<String> organizationIds) {
			super.change(ORGANIZATION_IDS,super.getOrganizationIds(),organizationIds);
			super.setOrganizationIds(organizationIds);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param position 存放位置
		 * @return 当前对象
		*/
		public AssetDataPermissions setPosition(List<Position> position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param positionIds 存放位置
		 * @return 当前对象
		*/
		public AssetDataPermissions setPositionIds(List<String> positionIds) {
			super.change(POSITION_IDS,super.getPositionIds(),positionIds);
			super.setPositionIds(positionIds);
			return this;
		}
	}
}