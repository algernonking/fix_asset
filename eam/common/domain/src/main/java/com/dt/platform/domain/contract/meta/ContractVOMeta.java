package com.dt.platform.domain.contract.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.contract.ContractVO;
import java.util.List;
import com.dt.platform.domain.contract.Contract;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-10 17:05:34
 * @sign 64C302ACE5E20B9C8B88FE6A2052BE36
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ContractVOMeta extends ContractMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 合同类型 , 主合同，子合同、附加协议; ContractType , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 合同类型 , 主合同，子合同、附加协议; ContractType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,TYPE, java.lang.String.class, "合同类型", "主合同，子合同、附加协议; ContractType", java.lang.String.class, null);
	
	/**
	 * 上级合同ID , 类型: java.lang.String
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 上级合同ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> PARENT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,PARENT_ID, java.lang.String.class, "上级合同ID", "上级合同ID", java.lang.String.class, null);
	
	/**
	 * 合同编号 , 类型: java.lang.String
	*/
	public static final String CONTRACT_NO="contractNo";
	
	/**
	 * 合同编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> CONTRACT_NO_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,CONTRACT_NO, java.lang.String.class, "合同编号", "合同编号", java.lang.String.class, null);
	
	/**
	 * 合同抬头 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 合同抬头 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> TITLE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,TITLE, java.lang.String.class, "合同抬头", "合同抬头", java.lang.String.class, null);
	
	/**
	 * 交付物 , 类型: java.lang.String
	*/
	public static final String DELIVERABLES="deliverables";
	
	/**
	 * 交付物 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> DELIVERABLES_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DELIVERABLES, java.lang.String.class, "交付物", "交付物", java.lang.String.class, null);
	
	/**
	 * 交付地 , 类型: java.lang.String
	*/
	public static final String DELIVERY_LOCATION="deliveryLocation";
	
	/**
	 * 交付地 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> DELIVERY_LOCATION_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DELIVERY_LOCATION, java.lang.String.class, "交付地", "交付地", java.lang.String.class, null);
	
	/**
	 * 合同金额 , 类型: java.math.BigDecimal
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 合同金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.math.BigDecimal> AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,AMOUNT, java.math.BigDecimal.class, "合同金额", "合同金额", java.math.BigDecimal.class, null);
	
	/**
	 * 合同状态 , 枚举 ContractStatus , 类型: java.lang.String
	*/
	public static final String CONTRACT_STATUS="contractStatus";
	
	/**
	 * 合同状态 , 枚举 ContractStatus , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> CONTRACT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,CONTRACT_STATUS, java.lang.String.class, "合同状态", "枚举 ContractStatus", java.lang.String.class, null);
	
	/**
	 * 摘要信息 , 类型: java.lang.String
	*/
	public static final String SUMMARY="summary";
	
	/**
	 * 摘要信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> SUMMARY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,SUMMARY, java.lang.String.class, "摘要信息", "摘要信息", java.lang.String.class, null);
	
	/**
	 * 签订日期 , 类型: java.util.Date
	*/
	public static final String SIGNING_DATE="signingDate";
	
	/**
	 * 签订日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.util.Date> SIGNING_DATE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,SIGNING_DATE, java.util.Date.class, "签订日期", "签订日期", java.util.Date.class, null);
	
	/**
	 * 生效日期 , 类型: java.util.Date
	*/
	public static final String EFFECTIVE_DATE="effectiveDate";
	
	/**
	 * 生效日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.util.Date> EFFECTIVE_DATE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,EFFECTIVE_DATE, java.util.Date.class, "生效日期", "生效日期", java.util.Date.class, null);
	
	/**
	 * 结束日期 , 类型: java.util.Date
	*/
	public static final String END_DATE="endDate";
	
	/**
	 * 结束日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.util.Date> END_DATE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,END_DATE, java.util.Date.class, "结束日期", "结束日期", java.util.Date.class, null);
	
	/**
	 * 失效日期 , 类型: java.util.Date
	*/
	public static final String EXPIRATION_DATE="expirationDate";
	
	/**
	 * 失效日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.util.Date> EXPIRATION_DATE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,EXPIRATION_DATE, java.util.Date.class, "失效日期", "失效日期", java.util.Date.class, null);
	
	/**
	 * 归属部门ID , 类型: java.lang.String
	*/
	public static final String DEPARTMENT_ID="departmentId";
	
	/**
	 * 归属部门ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> DEPARTMENT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DEPARTMENT_ID, java.lang.String.class, "归属部门ID", "归属部门ID", java.lang.String.class, null);
	
	/**
	 * 资金状态 , 枚举 FundingStatus , 类型: java.lang.String
	*/
	public static final String FUNDING_STATUS="fundingStatus";
	
	/**
	 * 资金状态 , 枚举 FundingStatus , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> FUNDING_STATUS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,FUNDING_STATUS, java.lang.String.class, "资金状态", "枚举 FundingStatus", java.lang.String.class, null);
	
	/**
	 * 资金流向 , 关联字典 , 类型: java.lang.String
	*/
	public static final String FUNDING_DIRECTION="fundingDirection";
	
	/**
	 * 资金流向 , 关联字典 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> FUNDING_DIRECTION_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,FUNDING_DIRECTION, java.lang.String.class, "资金流向", "关联字典", java.lang.String.class, null);
	
	/**
	 * 合同分类代码 , 关联字典 , 类型: java.lang.String
	*/
	public static final String CATALOG_CODE="catalogCode";
	
	/**
	 * 合同分类代码 , 关联字典 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> CATALOG_CODE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,CATALOG_CODE, java.lang.String.class, "合同分类代码", "关联字典", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 归属部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String DEPARTMENT="department";
	
	/**
	 * 归属部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractVO,org.github.foxnic.web.domain.hrm.Organization> DEPARTMENT_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractVO.class ,DEPARTMENT, org.github.foxnic.web.domain.hrm.Organization.class, "归属部门", "归属部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , TYPE , PARENT_ID , CONTRACT_NO , TITLE , DELIVERABLES , DELIVERY_LOCATION , AMOUNT , CONTRACT_STATUS , SUMMARY , SIGNING_DATE , EFFECTIVE_DATE , END_DATE , EXPIRATION_DATE , DEPARTMENT_ID , FUNDING_STATUS , FUNDING_DIRECTION , CATALOG_CODE , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , DEPARTMENT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.contract.ContractVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ContractVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ContractVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ContractVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ContractVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ContractVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ContractVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ContractVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ContractVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ContractVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Contract setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 合同类型
		 * @param type 合同类型
		 * @return 当前对象
		*/
		public Contract setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 上级合同ID
		 * @param parentId 上级合同ID
		 * @return 当前对象
		*/
		public Contract setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 合同编号
		 * @param contractNo 合同编号
		 * @return 当前对象
		*/
		public Contract setContractNo(String contractNo) {
			super.change(CONTRACT_NO,super.getContractNo(),contractNo);
			super.setContractNo(contractNo);
			return this;
		}
		
		/**
		 * 设置 合同抬头
		 * @param title 合同抬头
		 * @return 当前对象
		*/
		public Contract setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 交付物
		 * @param deliverables 交付物
		 * @return 当前对象
		*/
		public Contract setDeliverables(String deliverables) {
			super.change(DELIVERABLES,super.getDeliverables(),deliverables);
			super.setDeliverables(deliverables);
			return this;
		}
		
		/**
		 * 设置 交付地
		 * @param deliveryLocation 交付地
		 * @return 当前对象
		*/
		public Contract setDeliveryLocation(String deliveryLocation) {
			super.change(DELIVERY_LOCATION,super.getDeliveryLocation(),deliveryLocation);
			super.setDeliveryLocation(deliveryLocation);
			return this;
		}
		
		/**
		 * 设置 合同金额
		 * @param amount 合同金额
		 * @return 当前对象
		*/
		public Contract setAmount(BigDecimal amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 合同状态
		 * @param contractStatus 合同状态
		 * @return 当前对象
		*/
		public Contract setContractStatus(String contractStatus) {
			super.change(CONTRACT_STATUS,super.getContractStatus(),contractStatus);
			super.setContractStatus(contractStatus);
			return this;
		}
		
		/**
		 * 设置 摘要信息
		 * @param summary 摘要信息
		 * @return 当前对象
		*/
		public Contract setSummary(String summary) {
			super.change(SUMMARY,super.getSummary(),summary);
			super.setSummary(summary);
			return this;
		}
		
		/**
		 * 设置 签订日期
		 * @param signingDate 签订日期
		 * @return 当前对象
		*/
		public Contract setSigningDate(Date signingDate) {
			super.change(SIGNING_DATE,super.getSigningDate(),signingDate);
			super.setSigningDate(signingDate);
			return this;
		}
		
		/**
		 * 设置 生效日期
		 * @param effectiveDate 生效日期
		 * @return 当前对象
		*/
		public Contract setEffectiveDate(Date effectiveDate) {
			super.change(EFFECTIVE_DATE,super.getEffectiveDate(),effectiveDate);
			super.setEffectiveDate(effectiveDate);
			return this;
		}
		
		/**
		 * 设置 结束日期
		 * @param endDate 结束日期
		 * @return 当前对象
		*/
		public Contract setEndDate(Date endDate) {
			super.change(END_DATE,super.getEndDate(),endDate);
			super.setEndDate(endDate);
			return this;
		}
		
		/**
		 * 设置 失效日期
		 * @param expirationDate 失效日期
		 * @return 当前对象
		*/
		public Contract setExpirationDate(Date expirationDate) {
			super.change(EXPIRATION_DATE,super.getExpirationDate(),expirationDate);
			super.setExpirationDate(expirationDate);
			return this;
		}
		
		/**
		 * 设置 归属部门ID
		 * @param departmentId 归属部门ID
		 * @return 当前对象
		*/
		public Contract setDepartmentId(String departmentId) {
			super.change(DEPARTMENT_ID,super.getDepartmentId(),departmentId);
			super.setDepartmentId(departmentId);
			return this;
		}
		
		/**
		 * 设置 资金状态
		 * @param fundingStatus 资金状态
		 * @return 当前对象
		*/
		public Contract setFundingStatus(String fundingStatus) {
			super.change(FUNDING_STATUS,super.getFundingStatus(),fundingStatus);
			super.setFundingStatus(fundingStatus);
			return this;
		}
		
		/**
		 * 设置 资金流向
		 * @param fundingDirection 资金流向
		 * @return 当前对象
		*/
		public Contract setFundingDirection(String fundingDirection) {
			super.change(FUNDING_DIRECTION,super.getFundingDirection(),fundingDirection);
			super.setFundingDirection(fundingDirection);
			return this;
		}
		
		/**
		 * 设置 合同分类代码
		 * @param catalogCode 合同分类代码
		 * @return 当前对象
		*/
		public Contract setCatalogCode(String catalogCode) {
			super.change(CATALOG_CODE,super.getCatalogCode(),catalogCode);
			super.setCatalogCode(catalogCode);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public Contract setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Contract setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Contract setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Contract setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Contract setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Contract setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Contract setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Contract setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Contract setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 归属部门
		 * @param department 归属部门
		 * @return 当前对象
		*/
		public Contract setDepartment(Organization department) {
			super.change(DEPARTMENT,super.getDepartment(),department);
			super.setDepartment(department);
			return this;
		}
	}
}