package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetSoftwareDistributeVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetSoftwareDistribute;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.domain.eam.AssetSoftwareDistributeData;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:47:31
 * @sign 1DFCC97F60DA8CF680340636739FE3B5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetSoftwareDistributeVOMeta extends AssetSoftwareDistributeMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 领用公司 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 领用公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,USE_ORG_ID, java.lang.String.class, "领用公司", "领用公司", java.lang.String.class, null);
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,USE_USER_ID, java.lang.String.class, "领用人", "领用人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 领用说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 领用说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,CONTENT, java.lang.String.class, "领用说明", "领用说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 关联资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 关联资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ASSET_ID, java.lang.String.class, "关联资产", "关联资产", java.lang.String.class, null);
	
	/**
	 * 软件资产 , 类型: java.lang.String
	*/
	public static final String ASSET_SOFTWARE_ID="assetSoftwareId";
	
	/**
	 * 软件资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> ASSET_SOFTWARE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ASSET_SOFTWARE_ID, java.lang.String.class, "软件资产", "软件资产", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "领用人", "领用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final String ASSET_SOFTWARE_LIST="assetSoftwareList";
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,com.dt.platform.domain.eam.AssetSoftware> ASSET_SOFTWARE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ASSET_SOFTWARE_LIST, java.util.List.class, "软件资产", "软件资产", com.dt.platform.domain.eam.AssetSoftware.class, null);
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_SOFTWARE_IDS="assetSoftwareIds";
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,java.lang.String> ASSET_SOFTWARE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ASSET_SOFTWARE_IDS, java.util.List.class, "软件资产", "软件资产", java.lang.String.class, null);
	
	/**
	 * 软件 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftwareDistributeData
	*/
	public static final String ASSET_SOFTWARE_DISTRIBUTE_LIST="assetSoftwareDistributeList";
	
	/**
	 * 软件 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftwareDistributeData
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistributeVO,com.dt.platform.domain.eam.AssetSoftwareDistributeData> ASSET_SOFTWARE_DISTRIBUTE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistributeVO.class ,ASSET_SOFTWARE_DISTRIBUTE_LIST, java.util.List.class, "软件", "软件", com.dt.platform.domain.eam.AssetSoftwareDistributeData.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , USE_ORG_ID , USE_USER_ID , BUSINESS_DATE , CONTENT , NOTES , ASSET_ID , ASSET_SOFTWARE_ID , ATTACH_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , ORIGINATOR , USE_USER , USE_ORGANIZATION , ASSET_SOFTWARE_LIST , ASSET_SOFTWARE_IDS , ASSET_SOFTWARE_DISTRIBUTE_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetSoftwareDistributeVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetSoftwareDistributeVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 领用公司
		 * @param useOrgId 领用公司
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setUseOrgId(String useOrgId) {
			super.change(USE_ORG_ID,super.getUseOrgId(),useOrgId);
			super.setUseOrgId(useOrgId);
			return this;
		}
		
		/**
		 * 设置 领用人
		 * @param useUserId 领用人
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setUseUserId(String useUserId) {
			super.change(USE_USER_ID,super.getUseUserId(),useUserId);
			super.setUseUserId(useUserId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 领用说明
		 * @param content 领用说明
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 关联资产
		 * @param assetId 关联资产
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 软件资产
		 * @param assetSoftwareId 软件资产
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setAssetSoftwareId(String assetSoftwareId) {
			super.change(ASSET_SOFTWARE_ID,super.getAssetSoftwareId(),assetSoftwareId);
			super.setAssetSoftwareId(assetSoftwareId);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attachId 附件
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 领用人
		 * @param useUser 领用人
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setUseUser(Employee useUser) {
			super.change(USE_USER,super.getUseUser(),useUser);
			super.setUseUser(useUser);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 软件资产
		 * @param assetSoftwareList 软件资产
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setAssetSoftwareList(List<AssetSoftware> assetSoftwareList) {
			super.change(ASSET_SOFTWARE_LIST,super.getAssetSoftwareList(),assetSoftwareList);
			super.setAssetSoftwareList(assetSoftwareList);
			return this;
		}
		
		/**
		 * 设置 软件资产
		 * @param assetSoftwareIds 软件资产
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setAssetSoftwareIds(List<String> assetSoftwareIds) {
			super.change(ASSET_SOFTWARE_IDS,super.getAssetSoftwareIds(),assetSoftwareIds);
			super.setAssetSoftwareIds(assetSoftwareIds);
			return this;
		}
		
		/**
		 * 设置 软件
		 * @param assetSoftwareDistributeList 软件
		 * @return 当前对象
		*/
		public AssetSoftwareDistribute setAssetSoftwareDistributeList(List<AssetSoftwareDistributeData> assetSoftwareDistributeList) {
			super.change(ASSET_SOFTWARE_DISTRIBUTE_LIST,super.getAssetSoftwareDistributeList(),assetSoftwareDistributeList);
			super.setAssetSoftwareDistributeList(assetSoftwareDistributeList);
			return this;
		}
	}
}