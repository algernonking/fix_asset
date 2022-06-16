package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CertificateItem;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 13:00:56
 * @sign D4FB698F4663491DB3D30672EDEDB4A2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CertificateItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 证书 , 类型: java.lang.String
	*/
	public static final String CERTIFICATE_ID="certificateId";
	
	/**
	 * 证书 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> CERTIFICATE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,CERTIFICATE_ID, java.lang.String.class, "证书", "证书", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_DATE="startDate";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.util.Date> START_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,START_DATE, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 到期时间 , 类型: java.util.Date
	*/
	public static final String END_DATE="endDate";
	
	/**
	 * 到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.util.Date> END_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,END_DATE, java.util.Date.class, "到期时间", "到期时间", java.util.Date.class, null);
	
	/**
	 * 公钥 , 类型: java.lang.String
	*/
	public static final String PUBLIC_KEY="publicKey";
	
	/**
	 * 公钥 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> PUBLIC_KEY_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,PUBLIC_KEY, java.lang.String.class, "公钥", "公钥", java.lang.String.class, null);
	
	/**
	 * 私钥 , 类型: java.lang.String
	*/
	public static final String PRIVATE_KEY="privateKey";
	
	/**
	 * 私钥 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> PRIVATE_KEY_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,PRIVATE_KEY, java.lang.String.class, "私钥", "私钥", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,OPER_USER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPER_USER="operUser";
	
	/**
	 * 人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CertificateItem,org.github.foxnic.web.domain.hrm.Employee> OPER_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.CertificateItem.class ,OPER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "人员", "人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CERTIFICATE_ID , STATUS , START_DATE , END_DATE , PUBLIC_KEY , PRIVATE_KEY , CONTENT , OPER_USER_ID , ATTACH_ID , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , OPER_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CertificateItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CertificateItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 证书
		 * @param certificateId 证书
		 * @return 当前对象
		*/
		public CertificateItem setCertificateId(String certificateId) {
			super.change(CERTIFICATE_ID,super.getCertificateId(),certificateId);
			super.setCertificateId(certificateId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public CertificateItem setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startDate 开始时间
		 * @return 当前对象
		*/
		public CertificateItem setStartDate(Date startDate) {
			super.change(START_DATE,super.getStartDate(),startDate);
			super.setStartDate(startDate);
			return this;
		}
		
		/**
		 * 设置 到期时间
		 * @param endDate 到期时间
		 * @return 当前对象
		*/
		public CertificateItem setEndDate(Date endDate) {
			super.change(END_DATE,super.getEndDate(),endDate);
			super.setEndDate(endDate);
			return this;
		}
		
		/**
		 * 设置 公钥
		 * @param publicKey 公钥
		 * @return 当前对象
		*/
		public CertificateItem setPublicKey(String publicKey) {
			super.change(PUBLIC_KEY,super.getPublicKey(),publicKey);
			super.setPublicKey(publicKey);
			return this;
		}
		
		/**
		 * 设置 私钥
		 * @param privateKey 私钥
		 * @return 当前对象
		*/
		public CertificateItem setPrivateKey(String privateKey) {
			super.change(PRIVATE_KEY,super.getPrivateKey(),privateKey);
			super.setPrivateKey(privateKey);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public CertificateItem setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operUserId 操作人
		 * @return 当前对象
		*/
		public CertificateItem setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attachId 附件
		 * @return 当前对象
		*/
		public CertificateItem setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CertificateItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CertificateItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CertificateItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CertificateItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CertificateItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CertificateItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CertificateItem setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param operUser 人员
		 * @return 当前对象
		*/
		public CertificateItem setOperUser(Employee operUser) {
			super.change(OPER_USER,super.getOperUser(),operUser);
			super.setOperUser(operUser);
			return this;
		}
	}
}