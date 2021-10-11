package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetAttributeItem;
import java.util.Date;
import com.dt.platform.domain.eam.AssetAttribute;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-10 09:53:47
 * @sign B8559719E6FA753A6D1633A459D5B084
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetAttributeItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属模块 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 所属模块 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,OWNER_CODE, java.lang.String.class, "所属模块", "所属模块", java.lang.String.class, null);
	
	/**
	 * 属性 , 类型: java.lang.String
	*/
	public static final String ATTRIBUTE_ID="attributeId";
	
	/**
	 * 属性 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> ATTRIBUTE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,ATTRIBUTE_ID, java.lang.String.class, "属性", "属性", java.lang.String.class, null);
	
	/**
	 * 所属维度 , 类型: java.lang.String
	*/
	public static final String DIMENSION="dimension";
	
	/**
	 * 所属维度 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> DIMENSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,DIMENSION, java.lang.String.class, "所属维度", "所属维度", java.lang.String.class, null);
	
	/**
	 * 必选 , 类型: java.lang.String
	*/
	public static final String REQUIRED="required";
	
	/**
	 * 必选 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> REQUIRED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,REQUIRED, java.lang.String.class, "必选", "必选", java.lang.String.class, null);
	
	/**
	 * 布局类型 , 类型: java.lang.String
	*/
	public static final String LAYOUT_TYPE="layoutType";
	
	/**
	 * 布局类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> LAYOUT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,LAYOUT_TYPE, java.lang.String.class, "布局类型", "布局类型", java.lang.String.class, null);
	
	/**
	 * 列表显示 , 类型: java.lang.String
	*/
	public static final String LIST_SHOW="listShow";
	
	/**
	 * 列表显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> LIST_SHOW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,LIST_SHOW, java.lang.String.class, "列表显示", "列表显示", java.lang.String.class, null);
	
	/**
	 * 列表内容 , 类型: java.lang.String
	*/
	public static final String LIST_CONTENT="listContent";
	
	/**
	 * 列表内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> LIST_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,LIST_CONTENT, java.lang.String.class, "列表内容", "列表内容", java.lang.String.class, null);
	
	/**
	 * 列表排序 , 类型: java.lang.Integer
	*/
	public static final String LIST_SORT="listSort";
	
	/**
	 * 列表排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.Integer> LIST_SORT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,LIST_SORT, java.lang.Integer.class, "列表排序", "列表排序", java.lang.Integer.class, null);
	
	/**
	 * 表单显示 , 类型: java.lang.String
	*/
	public static final String FORM_SHOW="formShow";
	
	/**
	 * 表单显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> FORM_SHOW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,FORM_SHOW, java.lang.String.class, "表单显示", "表单显示", java.lang.String.class, null);
	
	/**
	 * 行布局位置 , 类型: java.lang.Integer
	*/
	public static final String LAYOUT_ROW="layoutRow";
	
	/**
	 * 行布局位置 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.Integer> LAYOUT_ROW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,LAYOUT_ROW, java.lang.Integer.class, "行布局位置", "行布局位置", java.lang.Integer.class, null);
	
	/**
	 * 列布局位置 , 类型: java.lang.Integer
	*/
	public static final String LAYOUT_COLUMN="layoutColumn";
	
	/**
	 * 列布局位置 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.Integer> LAYOUT_COLUMN_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,LAYOUT_COLUMN, java.lang.Integer.class, "列布局位置", "列布局位置", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 属性 , 类型: com.dt.platform.domain.eam.AssetAttribute
	*/
	public static final String ATTRIBUTE="attribute";
	
	/**
	 * 属性 , 类型: com.dt.platform.domain.eam.AssetAttribute
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetAttributeItem,com.dt.platform.domain.eam.AssetAttribute> ATTRIBUTE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetAttributeItem.class ,ATTRIBUTE, com.dt.platform.domain.eam.AssetAttribute.class, "属性", "属性", com.dt.platform.domain.eam.AssetAttribute.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_CODE , ATTRIBUTE_ID , DIMENSION , REQUIRED , LAYOUT_TYPE , LIST_SHOW , LIST_CONTENT , LIST_SORT , FORM_SHOW , LAYOUT_ROW , LAYOUT_COLUMN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ATTRIBUTE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetAttributeItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetAttributeItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属模块
		 * @param ownerCode 所属模块
		 * @return 当前对象
		*/
		public AssetAttributeItem setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 属性
		 * @param attributeId 属性
		 * @return 当前对象
		*/
		public AssetAttributeItem setAttributeId(String attributeId) {
			super.change(ATTRIBUTE_ID,super.getAttributeId(),attributeId);
			super.setAttributeId(attributeId);
			return this;
		}
		
		/**
		 * 设置 所属维度
		 * @param dimension 所属维度
		 * @return 当前对象
		*/
		public AssetAttributeItem setDimension(String dimension) {
			super.change(DIMENSION,super.getDimension(),dimension);
			super.setDimension(dimension);
			return this;
		}
		
		/**
		 * 设置 必选
		 * @param required 必选
		 * @return 当前对象
		*/
		public AssetAttributeItem setRequired(String required) {
			super.change(REQUIRED,super.getRequired(),required);
			super.setRequired(required);
			return this;
		}
		
		/**
		 * 设置 布局类型
		 * @param layoutType 布局类型
		 * @return 当前对象
		*/
		public AssetAttributeItem setLayoutType(String layoutType) {
			super.change(LAYOUT_TYPE,super.getLayoutType(),layoutType);
			super.setLayoutType(layoutType);
			return this;
		}
		
		/**
		 * 设置 列表显示
		 * @param listShow 列表显示
		 * @return 当前对象
		*/
		public AssetAttributeItem setListShow(String listShow) {
			super.change(LIST_SHOW,super.getListShow(),listShow);
			super.setListShow(listShow);
			return this;
		}
		
		/**
		 * 设置 列表内容
		 * @param listContent 列表内容
		 * @return 当前对象
		*/
		public AssetAttributeItem setListContent(String listContent) {
			super.change(LIST_CONTENT,super.getListContent(),listContent);
			super.setListContent(listContent);
			return this;
		}
		
		/**
		 * 设置 列表排序
		 * @param listSort 列表排序
		 * @return 当前对象
		*/
		public AssetAttributeItem setListSort(Integer listSort) {
			super.change(LIST_SORT,super.getListSort(),listSort);
			super.setListSort(listSort);
			return this;
		}
		
		/**
		 * 设置 表单显示
		 * @param formShow 表单显示
		 * @return 当前对象
		*/
		public AssetAttributeItem setFormShow(String formShow) {
			super.change(FORM_SHOW,super.getFormShow(),formShow);
			super.setFormShow(formShow);
			return this;
		}
		
		/**
		 * 设置 行布局位置
		 * @param layoutRow 行布局位置
		 * @return 当前对象
		*/
		public AssetAttributeItem setLayoutRow(Integer layoutRow) {
			super.change(LAYOUT_ROW,super.getLayoutRow(),layoutRow);
			super.setLayoutRow(layoutRow);
			return this;
		}
		
		/**
		 * 设置 列布局位置
		 * @param layoutColumn 列布局位置
		 * @return 当前对象
		*/
		public AssetAttributeItem setLayoutColumn(Integer layoutColumn) {
			super.change(LAYOUT_COLUMN,super.getLayoutColumn(),layoutColumn);
			super.setLayoutColumn(layoutColumn);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetAttributeItem setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetAttributeItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetAttributeItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetAttributeItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetAttributeItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetAttributeItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetAttributeItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetAttributeItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetAttributeItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetAttributeItem setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 属性
		 * @param attribute 属性
		 * @return 当前对象
		*/
		public AssetAttributeItem setAttribute(AssetAttribute attribute) {
			super.change(ATTRIBUTE,super.getAttribute(),attribute);
			super.setAttribute(attribute);
			return this;
		}
	}
}