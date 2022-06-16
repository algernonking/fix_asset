package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.Certificate;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.CertificateType;
import com.dt.platform.domain.ops.CertificatePosition;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 09:42:34
 * @sign 9AE36EB86AF15BDEF5B3DF82F235F061
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CertificateMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 项目 , 类型: java.lang.String
	*/
	public static final String PROJECT="project";
	
	/**
	 * 项目 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> PROJECT_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,PROJECT, java.lang.String.class, "项目", "项目", java.lang.String.class, null);
	
	/**
	 * 使用位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 使用位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,POSITION_ID, java.lang.String.class, "使用位置", "使用位置", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_DATE="startDate";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.util.Date> START_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,START_DATE, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_DATE="endDate";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.util.Date> END_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,END_DATE, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 证书类型 , 类型: com.dt.platform.domain.ops.CertificateType
	*/
	public static final String CERTIFICATE_TYPE="certificateType";
	
	/**
	 * 证书类型 , 类型: com.dt.platform.domain.ops.CertificateType
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,com.dt.platform.domain.ops.CertificateType> CERTIFICATE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,CERTIFICATE_TYPE, com.dt.platform.domain.ops.CertificateType.class, "证书类型", "证书类型", com.dt.platform.domain.ops.CertificateType.class, null);
	
	/**
	 * 证书位置 , 类型: com.dt.platform.domain.ops.CertificatePosition
	*/
	public static final String CERTIFICATE_POSITION="certificatePosition";
	
	/**
	 * 证书位置 , 类型: com.dt.platform.domain.ops.CertificatePosition
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Certificate,com.dt.platform.domain.ops.CertificatePosition> CERTIFICATE_POSITION_PROP = new BeanProperty(com.dt.platform.domain.ops.Certificate.class ,CERTIFICATE_POSITION, com.dt.platform.domain.ops.CertificatePosition.class, "证书位置", "证书位置", com.dt.platform.domain.ops.CertificatePosition.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , STATUS , PROJECT , POSITION_ID , TYPE , START_DATE , END_DATE , CONTENT , ORIGINATOR_ID , NOTES , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR , CERTIFICATE_TYPE , CERTIFICATE_POSITION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.Certificate {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Certificate setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Certificate setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Certificate setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param project 项目
		 * @return 当前对象
		*/
		public Certificate setProject(String project) {
			super.change(PROJECT,super.getProject(),project);
			super.setProject(project);
			return this;
		}
		
		/**
		 * 设置 使用位置
		 * @param positionId 使用位置
		 * @return 当前对象
		*/
		public Certificate setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public Certificate setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startDate 开始时间
		 * @return 当前对象
		*/
		public Certificate setStartDate(Date startDate) {
			super.change(START_DATE,super.getStartDate(),startDate);
			super.setStartDate(startDate);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endDate 结束时间
		 * @return 当前对象
		*/
		public Certificate setEndDate(Date endDate) {
			super.change(END_DATE,super.getEndDate(),endDate);
			super.setEndDate(endDate);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public Certificate setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public Certificate setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Certificate setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Certificate setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Certificate setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Certificate setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Certificate setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Certificate setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Certificate setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Certificate setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public Certificate setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 证书类型
		 * @param certificateType 证书类型
		 * @return 当前对象
		*/
		public Certificate setCertificateType(CertificateType certificateType) {
			super.change(CERTIFICATE_TYPE,super.getCertificateType(),certificateType);
			super.setCertificateType(certificateType);
			return this;
		}
		
		/**
		 * 设置 证书位置
		 * @param certificatePosition 证书位置
		 * @return 当前对象
		*/
		public Certificate setCertificatePosition(CertificatePosition certificatePosition) {
			super.change(CERTIFICATE_POSITION,super.getCertificatePosition(),certificatePosition);
			super.setCertificatePosition(certificatePosition);
			return this;
		}
	}
}