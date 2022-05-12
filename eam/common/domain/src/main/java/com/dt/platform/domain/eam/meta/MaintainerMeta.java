package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.Maintainer;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-12 06:33:05
 * @sign BE475E8518678522324F652F63572308
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MaintainerMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_NAME="maintainerName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,MAINTAINER_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 商务联系人 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CONTACTS="businessContacts";
	
	/**
	 * 商务联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> BUSINESS_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,BUSINESS_CONTACTS, java.lang.String.class, "商务联系人", "商务联系人", java.lang.String.class, null);
	
	/**
	 * 商务联系方式 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CONTACTS_INFO="businessContactsInfo";
	
	/**
	 * 商务联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> BUSINESS_CONTACTS_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,BUSINESS_CONTACTS_INFO, java.lang.String.class, "商务联系方式", "商务联系方式", java.lang.String.class, null);
	
	/**
	 * 售后联系人 , 类型: java.lang.String
	*/
	public static final String AFTER_SALES_CONTACTS="afterSalesContacts";
	
	/**
	 * 售后联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> AFTER_SALES_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,AFTER_SALES_CONTACTS, java.lang.String.class, "售后联系人", "售后联系人", java.lang.String.class, null);
	
	/**
	 * 售后联系方式 , 类型: java.lang.String
	*/
	public static final String AFTER_SALES_CONTACTS_INFO="afterSalesContactsInfo";
	
	/**
	 * 售后联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> AFTER_SALES_CONTACTS_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,AFTER_SALES_CONTACTS_INFO, java.lang.String.class, "售后联系方式", "售后联系方式", java.lang.String.class, null);
	
	/**
	 * 统一社会信用代码 , 类型: java.lang.String
	*/
	public static final String UNIT_CODE="unitCode";
	
	/**
	 * 统一社会信用代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> UNIT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,UNIT_CODE, java.lang.String.class, "统一社会信用代码", "统一社会信用代码", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,ADDRESS, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_NOTES="maintainerNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> MAINTAINER_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,MAINTAINER_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Maintainer,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Maintainer.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MAINTAINER_NAME , BUSINESS_CONTACTS , BUSINESS_CONTACTS_INFO , AFTER_SALES_CONTACTS , AFTER_SALES_CONTACTS_INFO , UNIT_CODE , ADDRESS , MAINTAINER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.Maintainer {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Maintainer setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param maintainerName 名称
		 * @return 当前对象
		*/
		public Maintainer setMaintainerName(String maintainerName) {
			super.change(MAINTAINER_NAME,super.getMaintainerName(),maintainerName);
			super.setMaintainerName(maintainerName);
			return this;
		}
		
		/**
		 * 设置 商务联系人
		 * @param businessContacts 商务联系人
		 * @return 当前对象
		*/
		public Maintainer setBusinessContacts(String businessContacts) {
			super.change(BUSINESS_CONTACTS,super.getBusinessContacts(),businessContacts);
			super.setBusinessContacts(businessContacts);
			return this;
		}
		
		/**
		 * 设置 商务联系方式
		 * @param businessContactsInfo 商务联系方式
		 * @return 当前对象
		*/
		public Maintainer setBusinessContactsInfo(String businessContactsInfo) {
			super.change(BUSINESS_CONTACTS_INFO,super.getBusinessContactsInfo(),businessContactsInfo);
			super.setBusinessContactsInfo(businessContactsInfo);
			return this;
		}
		
		/**
		 * 设置 售后联系人
		 * @param afterSalesContacts 售后联系人
		 * @return 当前对象
		*/
		public Maintainer setAfterSalesContacts(String afterSalesContacts) {
			super.change(AFTER_SALES_CONTACTS,super.getAfterSalesContacts(),afterSalesContacts);
			super.setAfterSalesContacts(afterSalesContacts);
			return this;
		}
		
		/**
		 * 设置 售后联系方式
		 * @param afterSalesContactsInfo 售后联系方式
		 * @return 当前对象
		*/
		public Maintainer setAfterSalesContactsInfo(String afterSalesContactsInfo) {
			super.change(AFTER_SALES_CONTACTS_INFO,super.getAfterSalesContactsInfo(),afterSalesContactsInfo);
			super.setAfterSalesContactsInfo(afterSalesContactsInfo);
			return this;
		}
		
		/**
		 * 设置 统一社会信用代码
		 * @param unitCode 统一社会信用代码
		 * @return 当前对象
		*/
		public Maintainer setUnitCode(String unitCode) {
			super.change(UNIT_CODE,super.getUnitCode(),unitCode);
			super.setUnitCode(unitCode);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param address 地址
		 * @return 当前对象
		*/
		public Maintainer setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param maintainerNotes 备注
		 * @return 当前对象
		*/
		public Maintainer setMaintainerNotes(String maintainerNotes) {
			super.change(MAINTAINER_NOTES,super.getMaintainerNotes(),maintainerNotes);
			super.setMaintainerNotes(maintainerNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Maintainer setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Maintainer setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Maintainer setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Maintainer setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Maintainer setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Maintainer setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Maintainer setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Maintainer setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Maintainer setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
	}
}