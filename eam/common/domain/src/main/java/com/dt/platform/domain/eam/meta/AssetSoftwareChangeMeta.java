package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetSoftwareChange;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.AssetSoftwareChangeDetail;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:48:39
 * @sign CBEF63A6120E70D655AAD30D3C7D121C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetSoftwareChangeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 变更名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 变更名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,NAME, java.lang.String.class, "变更名称", "变更名称", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 变更说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 变更说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,CONTENT, java.lang.String.class, "变更说明", "变更说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 变更细节 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftwareChangeDetail
	*/
	public static final String ASSET_SOFTWARE_CHANGE_DETAIL_LIST="assetSoftwareChangeDetailList";
	
	/**
	 * 变更细节 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetSoftwareChangeDetail
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,com.dt.platform.domain.eam.AssetSoftwareChangeDetail> ASSET_SOFTWARE_CHANGE_DETAIL_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,ASSET_SOFTWARE_CHANGE_DETAIL_LIST, java.util.List.class, "变更细节", "变更细节", com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class, null);
	
	/**
	 * 变更细节 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_SOFTWARE_CHANGE_DETAIL_IDS="assetSoftwareChangeDetailIds";
	
	/**
	 * 变更细节 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChange,java.lang.String> ASSET_SOFTWARE_CHANGE_DETAIL_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChange.class ,ASSET_SOFTWARE_CHANGE_DETAIL_IDS, java.util.List.class, "变更细节", "变更细节", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , BUSINESS_DATE , CONTENT , NOTES , ATTACH_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , ORIGINATOR , ASSET_SOFTWARE_CHANGE_DETAIL_LIST , ASSET_SOFTWARE_CHANGE_DETAIL_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetSoftwareChange {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetSoftwareChange setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetSoftwareChange setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetSoftwareChange setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetSoftwareChange setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 变更名称
		 * @param name 变更名称
		 * @return 当前对象
		*/
		public AssetSoftwareChange setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetSoftwareChange setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 变更说明
		 * @param content 变更说明
		 * @return 当前对象
		*/
		public AssetSoftwareChange setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetSoftwareChange setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attachId 附件
		 * @return 当前对象
		*/
		public AssetSoftwareChange setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetSoftwareChange setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetSoftwareChange setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetSoftwareChange setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetSoftwareChange setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetSoftwareChange setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetSoftwareChange setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetSoftwareChange setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetSoftwareChange setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetSoftwareChange setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetSoftwareChange setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetSoftwareChange setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 变更细节
		 * @param assetSoftwareChangeDetailList 变更细节
		 * @return 当前对象
		*/
		public AssetSoftwareChange setAssetSoftwareChangeDetailList(List<AssetSoftwareChangeDetail> assetSoftwareChangeDetailList) {
			super.change(ASSET_SOFTWARE_CHANGE_DETAIL_LIST,super.getAssetSoftwareChangeDetailList(),assetSoftwareChangeDetailList);
			super.setAssetSoftwareChangeDetailList(assetSoftwareChangeDetailList);
			return this;
		}
		
		/**
		 * 设置 变更细节
		 * @param assetSoftwareChangeDetailIds 变更细节
		 * @return 当前对象
		*/
		public AssetSoftwareChange setAssetSoftwareChangeDetailIds(List<String> assetSoftwareChangeDetailIds) {
			super.change(ASSET_SOFTWARE_CHANGE_DETAIL_IDS,super.getAssetSoftwareChangeDetailIds(),assetSoftwareChangeDetailIds);
			super.setAssetSoftwareChangeDetailIds(assetSoftwareChangeDetailIds);
			return this;
		}
	}
}