package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetSoftwareDistribute;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.AssetSoftware;
import java.util.List;
import com.dt.platform.domain.eam.AssetSoftwareDistributeData;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:47:31
 * @sign 0DE22DEA94C986225187DE6118B4431B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetSoftwareDistributeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 领用公司 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 领用公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,USE_ORG_ID, java.lang.String.class, "领用公司", "领用公司", java.lang.String.class, null);
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 领用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,USE_USER_ID, java.lang.String.class, "领用人", "领用人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 领用说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 领用说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,CONTENT, java.lang.String.class, "领用说明", "领用说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 关联资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 关联资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ASSET_ID, java.lang.String.class, "关联资产", "关联资产", java.lang.String.class, null);
	
	/**
	 * 软件资产 , 类型: java.lang.String
	*/
	public static final String ASSET_SOFTWARE_ID="assetSoftwareId";
	
	/**
	 * 软件资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> ASSET_SOFTWARE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ASSET_SOFTWARE_ID, java.lang.String.class, "软件资产", "软件资产", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 领用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "领用人", "领用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final String ASSET_SOFTWARE_LIST="assetSoftwareList";
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,com.dt.platform.domain.eam.AssetSoftware> ASSET_SOFTWARE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ASSET_SOFTWARE_LIST, java.util.List.class, "软件资产", "软件资产", com.dt.platform.domain.eam.AssetSoftware.class, null);
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_SOFTWARE_IDS="assetSoftwareIds";
	
	/**
	 * 软件资产 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,java.lang.String> ASSET_SOFTWARE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ASSET_SOFTWARE_IDS, java.util.List.class, "软件资产", "软件资产", java.lang.String.class, null);
	
	/**
	 * 软件 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftwareDistributeData
	*/
	public static final String ASSET_SOFTWARE_DISTRIBUTE_LIST="assetSoftwareDistributeList";
	
	/**
	 * 软件 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftwareDistributeData
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareDistribute,com.dt.platform.domain.eam.AssetSoftwareDistributeData> ASSET_SOFTWARE_DISTRIBUTE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareDistribute.class ,ASSET_SOFTWARE_DISTRIBUTE_LIST, java.util.List.class, "软件", "软件", com.dt.platform.domain.eam.AssetSoftwareDistributeData.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , USE_ORG_ID , USE_USER_ID , BUSINESS_DATE , CONTENT , NOTES , ASSET_ID , ASSET_SOFTWARE_ID , ATTACH_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , ORIGINATOR , USE_USER , USE_ORGANIZATION , ASSET_SOFTWARE_LIST , ASSET_SOFTWARE_IDS , ASSET_SOFTWARE_DISTRIBUTE_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetSoftwareDistribute {

		private static final long serialVersionUID = 1L;

		
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