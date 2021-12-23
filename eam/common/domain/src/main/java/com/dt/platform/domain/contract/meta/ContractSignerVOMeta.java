package com.dt.platform.domain.contract.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.contract.ContractSignerVO;
import java.util.List;
import com.dt.platform.domain.contract.ContractSigner;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-20 16:55:10
 * @sign 97C8F5CA7020FB6525CEF7D4142EB391
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ContractSignerVOMeta extends ContractSignerMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * id , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,ID, java.lang.String.class, "id", "id", java.lang.String.class, null);
	
	/**
	 * 合同ID , 类型: java.lang.String
	*/
	public static final String CONTRACT_ID="contractId";
	
	/**
	 * 合同ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> CONTRACT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,CONTRACT_ID, java.lang.String.class, "合同ID", "合同ID", java.lang.String.class, null);
	
	/**
	 * 显示顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 显示顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,SORT, java.lang.Integer.class, "显示顺序", "显示顺序", java.lang.Integer.class, null);
	
	/**
	 * 别名 , 甲方/乙方等；枚举：SignerAlias , 类型: java.lang.String
	*/
	public static final String ALIAS="alias";
	
	/**
	 * 别名 , 甲方/乙方等；枚举：SignerAlias , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> ALIAS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,ALIAS, java.lang.String.class, "别名", "甲方/乙方等；枚举：SignerAlias", java.lang.String.class, null);
	
	/**
	 * 签订方类型 , 企业或个人；枚举：SignerType , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 签订方类型 , 企业或个人；枚举：SignerType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,TYPE, java.lang.String.class, "签订方类型", "企业或个人；枚举：SignerType", java.lang.String.class, null);
	
	/**
	 * 唯一代码 , 统一社会信用代码/身份证号码 , 类型: java.lang.String
	*/
	public static final String IDENTITY_CDOE="identityCdoe";
	
	/**
	 * 唯一代码 , 统一社会信用代码/身份证号码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> IDENTITY_CDOE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,IDENTITY_CDOE, java.lang.String.class, "唯一代码", "统一社会信用代码/身份证号码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 座机号码 , 类型: java.lang.String
	*/
	public static final String LANDLINE_NUMBER="landlineNumber";
	
	/**
	 * 座机号码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> LANDLINE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,LANDLINE_NUMBER, java.lang.String.class, "座机号码", "座机号码", java.lang.String.class, null);
	
	/**
	 * 传真号码 , 类型: java.lang.String
	*/
	public static final String FAX_NUMBER="faxNumber";
	
	/**
	 * 传真号码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> FAX_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,FAX_NUMBER, java.lang.String.class, "传真号码", "传真号码", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,ADDRESS, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * 联系人姓名 , 类型: java.lang.String
	*/
	public static final String CONTACT_PERSON="contactPerson";
	
	/**
	 * 联系人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> CONTACT_PERSON_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,CONTACT_PERSON, java.lang.String.class, "联系人姓名", "联系人姓名", java.lang.String.class, null);
	
	/**
	 * 联系人手机 , 类型: java.lang.String
	*/
	public static final String CONTACT_PHONE="contactPhone";
	
	/**
	 * 联系人手机 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> CONTACT_PHONE_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,CONTACT_PHONE, java.lang.String.class, "联系人手机", "联系人手机", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,TENANT_ID, java.lang.String.class, "租户ID", "租户ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.contract.ContractSignerVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.contract.ContractSignerVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , CONTRACT_ID , SORT , ALIAS , TYPE , IDENTITY_CDOE , NAME , LANDLINE_NUMBER , FAX_NUMBER , ADDRESS , CONTACT_PERSON , CONTACT_PHONE , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.contract.ContractSignerVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ContractSignerVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ContractSignerVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ContractSignerVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ContractSignerVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ContractSignerVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ContractSignerVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ContractSignerVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ContractSignerVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ContractSignerVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 id
		 * @param id id
		 * @return 当前对象
		*/
		public ContractSigner setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 合同ID
		 * @param contractId 合同ID
		 * @return 当前对象
		*/
		public ContractSigner setContractId(String contractId) {
			super.change(CONTRACT_ID,super.getContractId(),contractId);
			super.setContractId(contractId);
			return this;
		}
		
		/**
		 * 设置 显示顺序
		 * @param sort 显示顺序
		 * @return 当前对象
		*/
		public ContractSigner setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 别名
		 * @param alias 别名
		 * @return 当前对象
		*/
		public ContractSigner setAlias(String alias) {
			super.change(ALIAS,super.getAlias(),alias);
			super.setAlias(alias);
			return this;
		}
		
		/**
		 * 设置 签订方类型
		 * @param type 签订方类型
		 * @return 当前对象
		*/
		public ContractSigner setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 唯一代码
		 * @param identityCdoe 唯一代码
		 * @return 当前对象
		*/
		public ContractSigner setIdentityCdoe(String identityCdoe) {
			super.change(IDENTITY_CDOE,super.getIdentityCdoe(),identityCdoe);
			super.setIdentityCdoe(identityCdoe);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ContractSigner setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 座机号码
		 * @param landlineNumber 座机号码
		 * @return 当前对象
		*/
		public ContractSigner setLandlineNumber(String landlineNumber) {
			super.change(LANDLINE_NUMBER,super.getLandlineNumber(),landlineNumber);
			super.setLandlineNumber(landlineNumber);
			return this;
		}
		
		/**
		 * 设置 传真号码
		 * @param faxNumber 传真号码
		 * @return 当前对象
		*/
		public ContractSigner setFaxNumber(String faxNumber) {
			super.change(FAX_NUMBER,super.getFaxNumber(),faxNumber);
			super.setFaxNumber(faxNumber);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param address 地址
		 * @return 当前对象
		*/
		public ContractSigner setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 联系人姓名
		 * @param contactPerson 联系人姓名
		 * @return 当前对象
		*/
		public ContractSigner setContactPerson(String contactPerson) {
			super.change(CONTACT_PERSON,super.getContactPerson(),contactPerson);
			super.setContactPerson(contactPerson);
			return this;
		}
		
		/**
		 * 设置 联系人手机
		 * @param contactPhone 联系人手机
		 * @return 当前对象
		*/
		public ContractSigner setContactPhone(String contactPhone) {
			super.change(CONTACT_PHONE,super.getContactPhone(),contactPhone);
			super.setContactPhone(contactPhone);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ContractSigner setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 租户ID
		 * @param tenantId 租户ID
		 * @return 当前对象
		*/
		public ContractSigner setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ContractSigner setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ContractSigner setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ContractSigner setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ContractSigner setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ContractSigner setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ContractSigner setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ContractSigner setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public ContractSigner setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}