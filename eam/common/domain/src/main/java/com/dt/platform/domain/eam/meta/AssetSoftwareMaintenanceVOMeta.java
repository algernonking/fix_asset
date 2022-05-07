package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetSoftwareMaintenance;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Maintainer;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.AssetSoftware;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:46:48
 * @sign B514DEF04B114C311A15ED05E48B34CA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetSoftwareMaintenanceVOMeta extends AssetSoftwareMaintenanceMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 维保名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 维保名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,NAME, java.lang.String.class, "维保名称", "维保名称", java.lang.String.class, null);
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_ID="maintainerId";
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,MAINTAINER_ID, java.lang.String.class, "维保厂商", "维保厂商", java.lang.String.class, null);
	
	/**
	 * 负责部门 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 负责部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,USE_ORG_ID, java.lang.String.class, "负责部门", "负责部门", java.lang.String.class, null);
	
	/**
	 * 维保负责人 , 类型: java.lang.String
	*/
	public static final String MANAGER_ID="managerId";
	
	/**
	 * 维保负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,MANAGER_ID, java.lang.String.class, "维保负责人", "维保负责人", java.lang.String.class, null);
	
	/**
	 * 维保联系人 , 类型: java.lang.String
	*/
	public static final String CONTACTS="contacts";
	
	/**
	 * 维保联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,CONTACTS, java.lang.String.class, "维保联系人", "维保联系人", java.lang.String.class, null);
	
	/**
	 * 联系信息 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFO="contactInfo";
	
	/**
	 * 联系信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> CONTACT_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,CONTACT_INFO, java.lang.String.class, "联系信息", "联系信息", java.lang.String.class, null);
	
	/**
	 * 维保费用 , 类型: java.math.BigDecimal
	*/
	public static final String MAINTENANCE_COST="maintenanceCost";
	
	/**
	 * 维保费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.math.BigDecimal> MAINTENANCE_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,MAINTENANCE_COST, java.math.BigDecimal.class, "维保费用", "维保费用", java.math.BigDecimal.class, null);
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_START_DATE="maintenanceStartDate";
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.util.Date> MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,MAINTENANCE_START_DATE, java.util.Date.class, "维保开始时间", "维保开始时间", java.util.Date.class, null);
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_END_DATE="maintenanceEndDate";
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.util.Date> MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,MAINTENANCE_END_DATE, java.util.Date.class, "维保到期时间", "维保到期时间", java.util.Date.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 维保说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 维保说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,CONTENT, java.lang.String.class, "维保说明", "维保说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 负责人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 负责人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,MANAGER, org.github.foxnic.web.domain.hrm.Employee.class, "负责人", "负责人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 负责人 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final String MAINTAINER="maintainer";
	
	/**
	 * 负责人 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,com.dt.platform.domain.eam.Maintainer> MAINTAINER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,MAINTAINER, com.dt.platform.domain.eam.Maintainer.class, "负责人", "负责人", com.dt.platform.domain.eam.Maintainer.class, null);
	
	/**
	 * 负责部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 负责部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "负责部门", "负责部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final String ASSET_SOFTWARE_LIST="assetSoftwareList";
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,com.dt.platform.domain.eam.AssetSoftware> ASSET_SOFTWARE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,ASSET_SOFTWARE_LIST, java.util.List.class, "软件信息", "软件信息", com.dt.platform.domain.eam.AssetSoftware.class, null);
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_SOFTWARE_IDS="assetSoftwareIds";
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO,java.lang.String> ASSET_SOFTWARE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO.class ,ASSET_SOFTWARE_IDS, java.util.List.class, "软件信息", "软件信息", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , MAINTAINER_ID , USE_ORG_ID , MANAGER_ID , CONTACTS , CONTACT_INFO , MAINTENANCE_COST , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , BUSINESS_DATE , CONTENT , NOTES , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , ORIGINATOR , MANAGER , MAINTAINER , USE_ORGANIZATION , ASSET_SOFTWARE_LIST , ASSET_SOFTWARE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetSoftwareMaintenanceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenanceVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 维保名称
		 * @param name 维保名称
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 维保厂商
		 * @param maintainerId 维保厂商
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setMaintainerId(String maintainerId) {
			super.change(MAINTAINER_ID,super.getMaintainerId(),maintainerId);
			super.setMaintainerId(maintainerId);
			return this;
		}
		
		/**
		 * 设置 负责部门
		 * @param useOrgId 负责部门
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setUseOrgId(String useOrgId) {
			super.change(USE_ORG_ID,super.getUseOrgId(),useOrgId);
			super.setUseOrgId(useOrgId);
			return this;
		}
		
		/**
		 * 设置 维保负责人
		 * @param managerId 维保负责人
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setManagerId(String managerId) {
			super.change(MANAGER_ID,super.getManagerId(),managerId);
			super.setManagerId(managerId);
			return this;
		}
		
		/**
		 * 设置 维保联系人
		 * @param contacts 维保联系人
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setContacts(String contacts) {
			super.change(CONTACTS,super.getContacts(),contacts);
			super.setContacts(contacts);
			return this;
		}
		
		/**
		 * 设置 联系信息
		 * @param contactInfo 联系信息
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setContactInfo(String contactInfo) {
			super.change(CONTACT_INFO,super.getContactInfo(),contactInfo);
			super.setContactInfo(contactInfo);
			return this;
		}
		
		/**
		 * 设置 维保费用
		 * @param maintenanceCost 维保费用
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setMaintenanceCost(BigDecimal maintenanceCost) {
			super.change(MAINTENANCE_COST,super.getMaintenanceCost(),maintenanceCost);
			super.setMaintenanceCost(maintenanceCost);
			return this;
		}
		
		/**
		 * 设置 维保开始时间
		 * @param maintenanceStartDate 维保开始时间
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setMaintenanceStartDate(Date maintenanceStartDate) {
			super.change(MAINTENANCE_START_DATE,super.getMaintenanceStartDate(),maintenanceStartDate);
			super.setMaintenanceStartDate(maintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 维保到期时间
		 * @param maintenanceEndDate 维保到期时间
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setMaintenanceEndDate(Date maintenanceEndDate) {
			super.change(MAINTENANCE_END_DATE,super.getMaintenanceEndDate(),maintenanceEndDate);
			super.setMaintenanceEndDate(maintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 维保说明
		 * @param content 维保说明
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attachId 附件
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param manager 负责人
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setManager(Employee manager) {
			super.change(MANAGER,super.getManager(),manager);
			super.setManager(manager);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param maintainer 负责人
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setMaintainer(Maintainer maintainer) {
			super.change(MAINTAINER,super.getMaintainer(),maintainer);
			super.setMaintainer(maintainer);
			return this;
		}
		
		/**
		 * 设置 负责部门
		 * @param useOrganization 负责部门
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 软件信息
		 * @param assetSoftwareList 软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setAssetSoftwareList(List<AssetSoftware> assetSoftwareList) {
			super.change(ASSET_SOFTWARE_LIST,super.getAssetSoftwareList(),assetSoftwareList);
			super.setAssetSoftwareList(assetSoftwareList);
			return this;
		}
		
		/**
		 * 设置 软件信息
		 * @param assetSoftwareIds 软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareMaintenance setAssetSoftwareIds(List<String> assetSoftwareIds) {
			super.change(ASSET_SOFTWARE_IDS,super.getAssetSoftwareIds(),assetSoftwareIds);
			super.setAssetSoftwareIds(assetSoftwareIds);
			return this;
		}
	}
}