package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetSoftwareChangeDetail;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.AssetSoftware;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 15:05:44
 * @sign FB8BB3CBEAC930180D4FED7D5ABA5070
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetSoftwareChangeDetailMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 变更 , 类型: java.lang.String
	*/
	public static final String CHANGE_ID="changeId";
	
	/**
	 * 变更 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> CHANGE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,CHANGE_ID, java.lang.String.class, "变更", "变更", java.lang.String.class, null);
	
	/**
	 * 软件信息 , 类型: java.lang.String
	*/
	public static final String SOFTWARE_ID="softwareId";
	
	/**
	 * 软件信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> SOFTWARE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,SOFTWARE_ID, java.lang.String.class, "软件信息", "软件信息", java.lang.String.class, null);
	
	/**
	 * 变更前软件信息 , 类型: java.lang.String
	*/
	public static final String AFTER_SOFTWARE_ID="afterSoftwareId";
	
	/**
	 * 变更前软件信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> AFTER_SOFTWARE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,AFTER_SOFTWARE_ID, java.lang.String.class, "变更前软件信息", "变更前软件信息", java.lang.String.class, null);
	
	/**
	 * 变更后软件信息 , 类型: java.lang.String
	*/
	public static final String BEFORE_SOFTWARE_ID="beforeSoftwareId";
	
	/**
	 * 变更后软件信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> BEFORE_SOFTWARE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,BEFORE_SOFTWARE_ID, java.lang.String.class, "变更后软件信息", "变更后软件信息", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final String ASSET_SOFTWARE="assetSoftware";
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,com.dt.platform.domain.eam.AssetSoftware> ASSET_SOFTWARE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,ASSET_SOFTWARE, com.dt.platform.domain.eam.AssetSoftware.class, "软件信息", "软件信息", com.dt.platform.domain.eam.AssetSoftware.class, null);
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final String ASSET_SOFTWARE_AFTER="assetSoftwareAfter";
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,com.dt.platform.domain.eam.AssetSoftware> ASSET_SOFTWARE_AFTER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,ASSET_SOFTWARE_AFTER, com.dt.platform.domain.eam.AssetSoftware.class, "软件信息", "软件信息", com.dt.platform.domain.eam.AssetSoftware.class, null);
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final String ASSET_SOFTWARE_BEFORE="assetSoftwareBefore";
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftwareChangeDetail,com.dt.platform.domain.eam.AssetSoftware> ASSET_SOFTWARE_BEFORE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftwareChangeDetail.class ,ASSET_SOFTWARE_BEFORE, com.dt.platform.domain.eam.AssetSoftware.class, "软件信息", "软件信息", com.dt.platform.domain.eam.AssetSoftware.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CHANGE_ID , SOFTWARE_ID , AFTER_SOFTWARE_ID , BEFORE_SOFTWARE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ORIGINATOR , ASSET_SOFTWARE , ASSET_SOFTWARE_AFTER , ASSET_SOFTWARE_BEFORE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetSoftwareChangeDetail {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 变更
		 * @param changeId 变更
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setChangeId(String changeId) {
			super.change(CHANGE_ID,super.getChangeId(),changeId);
			super.setChangeId(changeId);
			return this;
		}
		
		/**
		 * 设置 软件信息
		 * @param softwareId 软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setSoftwareId(String softwareId) {
			super.change(SOFTWARE_ID,super.getSoftwareId(),softwareId);
			super.setSoftwareId(softwareId);
			return this;
		}
		
		/**
		 * 设置 变更前软件信息
		 * @param afterSoftwareId 变更前软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setAfterSoftwareId(String afterSoftwareId) {
			super.change(AFTER_SOFTWARE_ID,super.getAfterSoftwareId(),afterSoftwareId);
			super.setAfterSoftwareId(afterSoftwareId);
			return this;
		}
		
		/**
		 * 设置 变更后软件信息
		 * @param beforeSoftwareId 变更后软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setBeforeSoftwareId(String beforeSoftwareId) {
			super.change(BEFORE_SOFTWARE_ID,super.getBeforeSoftwareId(),beforeSoftwareId);
			super.setBeforeSoftwareId(beforeSoftwareId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 软件信息
		 * @param assetSoftware 软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setAssetSoftware(AssetSoftware assetSoftware) {
			super.change(ASSET_SOFTWARE,super.getAssetSoftware(),assetSoftware);
			super.setAssetSoftware(assetSoftware);
			return this;
		}
		
		/**
		 * 设置 软件信息
		 * @param assetSoftwareAfter 软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setAssetSoftwareAfter(AssetSoftware assetSoftwareAfter) {
			super.change(ASSET_SOFTWARE_AFTER,super.getAssetSoftwareAfter(),assetSoftwareAfter);
			super.setAssetSoftwareAfter(assetSoftwareAfter);
			return this;
		}
		
		/**
		 * 设置 软件信息
		 * @param assetSoftwareBefore 软件信息
		 * @return 当前对象
		*/
		public AssetSoftwareChangeDetail setAssetSoftwareBefore(AssetSoftware assetSoftwareBefore) {
			super.change(ASSET_SOFTWARE_BEFORE,super.getAssetSoftwareBefore(),assetSoftwareBefore);
			super.setAssetSoftwareBefore(assetSoftwareBefore);
			return this;
		}
	}
}