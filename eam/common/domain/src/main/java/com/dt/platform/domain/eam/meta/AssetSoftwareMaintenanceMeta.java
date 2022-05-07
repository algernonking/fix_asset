package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetSoftwareMaintenance;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Maintainer;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.AssetSoftware;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:46:48
 * @sign B3304579A5A513DB17174D4DC112725F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetSoftwareMaintenanceMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 维保名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 维保名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,NAME, java.lang.String.class, "维保名称", "维保名称", java.lang.String.class, null);
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_ID="maintainerId";
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,MAINTAINER_ID, java.lang.String.class, "维保厂商", "维保厂商", java.lang.String.class, null);
	
	/**
	 * 负责部门 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 负责部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,USE_ORG_ID, java.lang.String.class, "负责部门", "负责部门", java.lang.String.class, null);
	
	/**
	 * 维保负责人 , 类型: java.lang.String
	*/
	public static final String MANAGER_ID="managerId";
	
	/**
	 * 维保负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,MANAGER_ID, java.lang.String.class, "维保负责人", "维保负责人", java.lang.String.class, null);
	
	/**
	 * 维保联系人 , 类型: java.lang.String
	*/
	public static final String CONTACTS="contacts";
	
	/**
	 * 维保联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,CONTACTS, java.lang.String.class, "维保联系人", "维保联系人", java.lang.String.class, null);
	
	/**
	 * 联系信息 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFO="contactInfo";
	
	/**
	 * 联系信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> CONTACT_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,CONTACT_INFO, java.lang.String.class, "联系信息", "联系信息", java.lang.String.class, null);
	
	/**
	 * 维保费用 , 类型: java.math.BigDecimal
	*/
	public static final String MAINTENANCE_COST="maintenanceCost";
	
	/**
	 * 维保费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.math.BigDecimal> MAINTENANCE_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,MAINTENANCE_COST, java.math.BigDecimal.class, "维保费用", "维保费用", java.math.BigDecimal.class, null);
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_START_DATE="maintenanceStartDate";
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.util.Date> MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,MAINTENANCE_START_DATE, java.util.Date.class, "维保开始时间", "维保开始时间", java.util.Date.class, null);
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_END_DATE="maintenanceEndDate";
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.util.Date> MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,MAINTENANCE_END_DATE, java.util.Date.class, "维保到期时间", "维保到期时间", java.util.Date.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 维保说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 维保说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,CONTENT, java.lang.String.class, "维保说明", "维保说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 负责人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 负责人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,MANAGER, org.github.foxnic.web.domain.hrm.Employee.class, "负责人", "负责人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 负责人 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final String MAINTAINER="maintainer";
	
	/**
	 * 负责人 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,com.dt.platform.domain.eam.Maintainer> MAINTAINER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,MAINTAINER, com.dt.platform.domain.eam.Maintainer.class, "负责人", "负责人", com.dt.platform.domain.eam.Maintainer.class, null);
	
	/**
	 * 负责部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 负责部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "负责部门", "负责部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final String ASSET_SOFTWARE_LIST="assetSoftwareList";
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,com.dt.platform.domain.eam.AssetSoftware> ASSET_SOFTWARE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,ASSET_SOFTWARE_LIST, java.util.List.class, "软件信息", "软件信息", com.dt.platform.domain.eam.AssetSoftware.class, null);
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_SOFTWARE_IDS="assetSoftwareIds";
	
	/**
	 * 软件信息 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareMaintenance,java.lang.String> ASSET_SOFTWARE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareMaintenance.class ,ASSET_SOFTWARE_IDS, java.util.List.class, "软件信息", "软件信息", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , MAINTAINER_ID , USE_ORG_ID , MANAGER_ID , CONTACTS , CONTACT_INFO , MAINTENANCE_COST , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , BUSINESS_DATE , CONTENT , NOTES , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , ORIGINATOR , MANAGER , MAINTAINER , USE_ORGANIZATION , ASSET_SOFTWARE_LIST , ASSET_SOFTWARE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetSoftwareMaintenance {

		private static final long serialVersionUID = 1L;

		
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