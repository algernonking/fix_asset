package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.OpsService;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-08 17:10:07
 * @sign C5CCA2FA8CB3419E1539F0273C657AB6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OpsServiceMeta {
	
	/**
	 * 主键
	*/
	public static final String ID="id";
	
	/**
	 * 主键
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.String> ID_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 服务类型 , DB,OS,MIDDLEWARE,OTHER
	*/
	public static final String TYPE="type";
	
	/**
	 * 服务类型 , DB,OS,MIDDLEWARE,OTHER
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.String> TYPE_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,TYPE, java.lang.String.class, "服务类型", "DB,OS,MIDDLEWARE,OTHER", java.lang.String.class, null);
	
	/**
	 * 名称
	*/
	public static final String SERVICE_NAME="serviceName";
	
	/**
	 * 名称
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.String> SERVICE_NAME_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,SERVICE_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 备注
	*/
	public static final String SERVICE_NOTES="serviceNotes";
	
	/**
	 * 备注
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.String> SERVICE_NOTES_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,SERVICE_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.String> CREATE_BY_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.util.Date> CREATE_TIME_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.String> UPDATE_BY_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.util.Date> UPDATE_TIME_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.Integer> DELETED_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.String> DELETE_BY_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.util.Date> DELETE_TIME_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version
	*/
	public static final String VERSION="version";
	
	/**
	 * version
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsService,java.lang.Integer> VERSION_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsService.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , SERVICE_NAME , SERVICE_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.OpsService {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public OpsService setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 服务类型
		 * @param type 服务类型
		 * @return 当前对象
		*/
		public OpsService setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param serviceName 名称
		 * @return 当前对象
		*/
		public OpsService setServiceName(String serviceName) {
			super.change(SERVICE_NAME,super.getServiceName(),serviceName);
			super.setServiceName(serviceName);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param serviceNotes 备注
		 * @return 当前对象
		*/
		public OpsService setServiceNotes(String serviceNotes) {
			super.change(SERVICE_NOTES,super.getServiceNotes(),serviceNotes);
			super.setServiceNotes(serviceNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public OpsService setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public OpsService setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public OpsService setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public OpsService setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public OpsService setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public OpsService setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public OpsService setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public OpsService setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}