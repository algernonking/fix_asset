package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.ServiceInfo;
import java.util.Date;
import com.dt.platform.domain.ops.ServiceCategory;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 16:01:43
 * @sign C76E500B932E95AD19FB1FDEFB3062C1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ServiceInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 服务ID , 类型: java.lang.String
	*/
	public static final String SERVICE_CATEGORY_ID="serviceCategoryId";
	
	/**
	 * 服务ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> SERVICE_CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,SERVICE_CATEGORY_ID, java.lang.String.class, "服务ID", "服务ID", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 补丁 , 类型: java.lang.String
	*/
	public static final String PATCH="patch";
	
	/**
	 * 补丁 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> PATCH_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,PATCH, java.lang.String.class, "补丁", "补丁", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 服务 , 类型: com.dt.platform.domain.ops.ServiceCategory
	*/
	public static final String SERVICE_CATEGORY="serviceCategory";
	
	/**
	 * 服务 , 类型: com.dt.platform.domain.ops.ServiceCategory
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.ServiceInfo,com.dt.platform.domain.ops.ServiceCategory> SERVICE_CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.ops.ServiceInfo.class ,SERVICE_CATEGORY, com.dt.platform.domain.ops.ServiceCategory.class, "服务", "", com.dt.platform.domain.ops.ServiceCategory.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , SERVICE_CATEGORY_ID , NAME , PATCH , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SERVICE_CATEGORY };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.ServiceInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ServiceInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 服务ID
		 * @param serviceCategoryId 服务ID
		 * @return 当前对象
		*/
		public ServiceInfo setServiceCategoryId(String serviceCategoryId) {
			super.change(SERVICE_CATEGORY_ID,super.getServiceCategoryId(),serviceCategoryId);
			super.setServiceCategoryId(serviceCategoryId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ServiceInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 补丁
		 * @param patch 补丁
		 * @return 当前对象
		*/
		public ServiceInfo setPatch(String patch) {
			super.change(PATCH,super.getPatch(),patch);
			super.setPatch(patch);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ServiceInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public ServiceInfo setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ServiceInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ServiceInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ServiceInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ServiceInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ServiceInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ServiceInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ServiceInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ServiceInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 服务
		 * @param serviceCategory 服务
		 * @return 当前对象
		*/
		public ServiceInfo setServiceCategory(ServiceCategory serviceCategory) {
			super.change(SERVICE_CATEGORY,super.getServiceCategory(),serviceCategory);
			super.setServiceCategory(serviceCategory);
			return this;
		}
	}
}