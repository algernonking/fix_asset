package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetLabelTpl;
import java.util.Date;
import com.dt.platform.domain.eam.AssetLabelTplItem;
import java.util.List;
import com.dt.platform.domain.eam.AssetLabelCol;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 08:08:21
 * @sign 013863AE6D6932B3B4734023D1415FFF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetLabelTplMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 默认为1 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 默认为1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,TYPE, java.lang.String.class, "类型", "默认为1", java.lang.String.class, null);
	
	/**
	 * 是否自定义 , 类型: java.lang.String
	*/
	public static final String IS_CUSTOM="isCustom";
	
	/**
	 * 是否自定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IS_CUSTOM_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IS_CUSTOM, java.lang.String.class, "是否自定义", "是否自定义", java.lang.String.class, null);
	
	/**
	 * 字段 , 类型: java.lang.String
	*/
	public static final String COL_IDS="colIds";
	
	/**
	 * 字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> COL_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,COL_IDS, java.lang.String.class, "字段", "字段", java.lang.String.class, null);
	
	/**
	 * 位置 , u,d,l,r , 类型: java.lang.String
	*/
	public static final String IMAGE_POSITION="imagePosition";
	
	/**
	 * 位置 , u,d,l,r , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_POSITION, java.lang.String.class, "位置", "u,d,l,r", java.lang.String.class, null);
	
	/**
	 * 图像 , 类型: java.lang.String
	*/
	public static final String IMAGE_COL_ID="imageColId";
	
	/**
	 * 图像 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_COL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_COL_ID, java.lang.String.class, "图像", "图像", java.lang.String.class, null);
	
	/**
	 * 图像显示 , 类型: java.lang.String
	*/
	public static final String IMAGE_SHOW="imageShow";
	
	/**
	 * 图像显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_SHOW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_SHOW, java.lang.String.class, "图像显示", "图像显示", java.lang.String.class, null);
	
	/**
	 * 图像label显示 , 类型: java.lang.String
	*/
	public static final String IMAGE_LABEL_SHOW="imageLabelShow";
	
	/**
	 * 图像label显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_LABEL_SHOW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_LABEL_SHOW, java.lang.String.class, "图像label显示", "图像label显示", java.lang.String.class, null);
	
	/**
	 * 图像类型txm , rwm , 类型: java.lang.String
	*/
	public static final String IMAGE_TYPE="imageType";
	
	/**
	 * 图像类型txm , rwm , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_TYPE, java.lang.String.class, "图像类型txm", "rwm", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String LABEL_FORMAT_CONTENT="labelFormatContent";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> LABEL_FORMAT_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,LABEL_FORMAT_CONTENT, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * Item , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelTplItem
	*/
	public static final String ASSET_LABEL_ITEM_LIST="assetLabelItemList";
	
	/**
	 * Item , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelTplItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,com.dt.platform.domain.eam.AssetLabelTplItem> ASSET_LABEL_ITEM_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,ASSET_LABEL_ITEM_LIST, java.util.List.class, "Item", "Item", com.dt.platform.domain.eam.AssetLabelTplItem.class, null);
	
	/**
	 * Column , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelCol
	*/
	public static final String ASSET_LABEL_COLUMNL_LIST="assetLabelColumnlList";
	
	/**
	 * Column , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelCol
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,com.dt.platform.domain.eam.AssetLabelCol> ASSET_LABEL_COLUMNL_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,ASSET_LABEL_COLUMNL_LIST, java.util.List.class, "Column", "Column", com.dt.platform.domain.eam.AssetLabelCol.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , IS_CUSTOM , COL_IDS , IMAGE_POSITION , IMAGE_COL_ID , IMAGE_SHOW , IMAGE_LABEL_SHOW , IMAGE_TYPE , LABEL_FORMAT_CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSET_LABEL_ITEM_LIST , ASSET_LABEL_COLUMNL_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetLabelTpl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetLabelTpl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public AssetLabelTpl setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 是否自定义
		 * @param isCustom 是否自定义
		 * @return 当前对象
		*/
		public AssetLabelTpl setIsCustom(String isCustom) {
			super.change(IS_CUSTOM,super.getIsCustom(),isCustom);
			super.setIsCustom(isCustom);
			return this;
		}
		
		/**
		 * 设置 字段
		 * @param colIds 字段
		 * @return 当前对象
		*/
		public AssetLabelTpl setColIds(String colIds) {
			super.change(COL_IDS,super.getColIds(),colIds);
			super.setColIds(colIds);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param imagePosition 位置
		 * @return 当前对象
		*/
		public AssetLabelTpl setImagePosition(String imagePosition) {
			super.change(IMAGE_POSITION,super.getImagePosition(),imagePosition);
			super.setImagePosition(imagePosition);
			return this;
		}
		
		/**
		 * 设置 图像
		 * @param imageColId 图像
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageColId(String imageColId) {
			super.change(IMAGE_COL_ID,super.getImageColId(),imageColId);
			super.setImageColId(imageColId);
			return this;
		}
		
		/**
		 * 设置 图像显示
		 * @param imageShow 图像显示
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageShow(String imageShow) {
			super.change(IMAGE_SHOW,super.getImageShow(),imageShow);
			super.setImageShow(imageShow);
			return this;
		}
		
		/**
		 * 设置 图像label显示
		 * @param imageLabelShow 图像label显示
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageLabelShow(String imageLabelShow) {
			super.change(IMAGE_LABEL_SHOW,super.getImageLabelShow(),imageLabelShow);
			super.setImageLabelShow(imageLabelShow);
			return this;
		}
		
		/**
		 * 设置 图像类型txm
		 * @param imageType 图像类型txm
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageType(String imageType) {
			super.change(IMAGE_TYPE,super.getImageType(),imageType);
			super.setImageType(imageType);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param labelFormatContent 类型
		 * @return 当前对象
		*/
		public AssetLabelTpl setLabelFormatContent(String labelFormatContent) {
			super.change(LABEL_FORMAT_CONTENT,super.getLabelFormatContent(),labelFormatContent);
			super.setLabelFormatContent(labelFormatContent);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetLabelTpl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetLabelTpl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetLabelTpl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetLabelTpl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetLabelTpl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetLabelTpl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetLabelTpl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetLabelTpl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetLabelTpl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetLabelTpl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 Item
		 * @param assetLabelItemList Item
		 * @return 当前对象
		*/
		public AssetLabelTpl setAssetLabelItemList(List<AssetLabelTplItem> assetLabelItemList) {
			super.change(ASSET_LABEL_ITEM_LIST,super.getAssetLabelItemList(),assetLabelItemList);
			super.setAssetLabelItemList(assetLabelItemList);
			return this;
		}
		
		/**
		 * 设置 Column
		 * @param assetLabelColumnlList Column
		 * @return 当前对象
		*/
		public AssetLabelTpl setAssetLabelColumnlList(List<AssetLabelCol> assetLabelColumnlList) {
			super.change(ASSET_LABEL_COLUMNL_LIST,super.getAssetLabelColumnlList(),assetLabelColumnlList);
			super.setAssetLabelColumnlList(assetLabelColumnlList);
			return this;
		}
	}
}