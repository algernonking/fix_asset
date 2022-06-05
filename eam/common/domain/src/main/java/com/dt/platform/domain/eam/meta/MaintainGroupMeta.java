package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.MaintainGroup;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 19:20:57
 * @sign 8102E3E1D3AB3BABE7520530A5669A59
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MaintainGroupMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String LEADER_ID="leaderId";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> LEADER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,LEADER_ID, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 负责人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String LEADER="leader";
	
	/**
	 * 负责人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,org.github.foxnic.web.domain.hrm.Employee> LEADER_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,LEADER, org.github.foxnic.web.domain.hrm.Employee.class, "负责人", "负责人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 成员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MEMBER_LIST="memberList";
	
	/**
	 * 成员 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,org.github.foxnic.web.domain.hrm.Employee> MEMBER_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,MEMBER_LIST, java.util.List.class, "成员", "成员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 成员 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String MEMBER_IDS="memberIds";
	
	/**
	 * 成员 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainGroup,java.lang.String> MEMBER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainGroup.class ,MEMBER_IDS, java.util.List.class, "成员", "成员", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , STATUS , LEADER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , LEADER , MEMBER_LIST , MEMBER_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.MaintainGroup {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MaintainGroup setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MaintainGroup setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MaintainGroup setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param leaderId 负责人
		 * @return 当前对象
		*/
		public MaintainGroup setLeaderId(String leaderId) {
			super.change(LEADER_ID,super.getLeaderId(),leaderId);
			super.setLeaderId(leaderId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MaintainGroup setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MaintainGroup setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MaintainGroup setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MaintainGroup setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MaintainGroup setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MaintainGroup setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MaintainGroup setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MaintainGroup setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public MaintainGroup setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public MaintainGroup setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param leader 负责人
		 * @return 当前对象
		*/
		public MaintainGroup setLeader(Employee leader) {
			super.change(LEADER,super.getLeader(),leader);
			super.setLeader(leader);
			return this;
		}
		
		/**
		 * 设置 成员
		 * @param memberList 成员
		 * @return 当前对象
		*/
		public MaintainGroup setMemberList(List<Employee> memberList) {
			super.change(MEMBER_LIST,super.getMemberList(),memberList);
			super.setMemberList(memberList);
			return this;
		}
		
		/**
		 * 设置 成员
		 * @param memberIds 成员
		 * @return 当前对象
		*/
		public MaintainGroup setMemberIds(List<String> memberIds) {
			super.change(MEMBER_IDS,super.getMemberIds(),memberIds);
			super.setMemberIds(memberIds);
			return this;
		}
	}
}