package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDataPermissions;
import java.util.Date;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.pcm.Catalog;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Position;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-18 08:47:42
 * @sign 5FEFD8D535EF42E03531B3CCD34F6D10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetDataPermissionsMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 权限状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 权限状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,STATUS, java.lang.String.class, "权限状态", "权限状态", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,OWNER_CODE, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 权限编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 权限编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,CODE, java.lang.String.class, "权限编码", "权限编码", java.lang.String.class, null);
	
	/**
	 * 业务角色 , 类型: java.lang.String
	*/
	public static final String ROLE_CODE="roleCode";
	
	/**
	 * 业务角色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> ROLE_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,ROLE_CODE, java.lang.String.class, "业务角色", "业务角色", java.lang.String.class, null);
	
	/**
	 * 组织权限状态 , 类型: java.lang.String
	*/
	public static final String ORG_AUTHORITY_ENABLE="orgAuthorityEnable";
	
	/**
	 * 组织权限状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> ORG_AUTHORITY_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,ORG_AUTHORITY_ENABLE, java.lang.String.class, "组织权限状态", "组织权限状态", java.lang.String.class, null);
	
	/**
	 * 本组织激活 , 类型: java.lang.String
	*/
	public static final String ORG_LOCAL_ENABLE="orgLocalEnable";
	
	/**
	 * 本组织激活 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> ORG_LOCAL_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,ORG_LOCAL_ENABLE, java.lang.String.class, "本组织激活", "本组织激活", java.lang.String.class, null);
	
	/**
	 * 组织级联状态 , 类型: java.lang.String
	*/
	public static final String ORG_CASCADE_ENABLE="orgCascadeEnable";
	
	/**
	 * 组织级联状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> ORG_CASCADE_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,ORG_CASCADE_ENABLE, java.lang.String.class, "组织级联状态", "组织级联状态", java.lang.String.class, null);
	
	/**
	 * 分类权限状态 , 类型: java.lang.String
	*/
	public static final String CATALOG_AUTHORITY_ENABLE="catalogAuthorityEnable";
	
	/**
	 * 分类权限状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> CATALOG_AUTHORITY_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,CATALOG_AUTHORITY_ENABLE, java.lang.String.class, "分类权限状态", "分类权限状态", java.lang.String.class, null);
	
	/**
	 * 分类级联状态 , 类型: java.lang.String
	*/
	public static final String CATALOG_CASCADE_ENABLE="catalogCascadeEnable";
	
	/**
	 * 分类级联状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> CATALOG_CASCADE_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,CATALOG_CASCADE_ENABLE, java.lang.String.class, "分类级联状态", "分类级联状态", java.lang.String.class, null);
	
	/**
	 * 位置权限状态 , 类型: java.lang.String
	*/
	public static final String POSITION_AUTHORITY_ENABLE="positionAuthorityEnable";
	
	/**
	 * 位置权限状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> POSITION_AUTHORITY_ENABLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,POSITION_AUTHORITY_ENABLE, java.lang.String.class, "位置权限状态", "位置权限状态", java.lang.String.class, null);
	
	/**
	 * 优先级 , 类型: java.lang.Integer
	*/
	public static final String PRIORITY="priority";
	
	/**
	 * 优先级 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.Integer> PRIORITY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,PRIORITY, java.lang.Integer.class, "优先级", "优先级", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 业务角色 , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final String BUSI_ROLE="busiRole";
	
	/**
	 * 业务角色 , 类型: org.github.foxnic.web.domain.system.BusiRole
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,org.github.foxnic.web.domain.system.BusiRole> BUSI_ROLE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,BUSI_ROLE, org.github.foxnic.web.domain.system.BusiRole.class, "业务角色", "业务角色", org.github.foxnic.web.domain.system.BusiRole.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,CATEGORY, java.util.List.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CATEGORY_IDS="categoryIds";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> CATEGORY_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,CATEGORY_IDS, java.util.List.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,ORGANIZATION, java.util.List.class, "组织节点", "组织节点", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ORGANIZATION_IDS="organizationIds";
	
	/**
	 * 组织节点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> ORGANIZATION_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,ORGANIZATION_IDS, java.util.List.class, "组织节点", "组织节点", java.lang.String.class, null);
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,POSITION, java.util.List.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String POSITION_IDS="positionIds";
	
	/**
	 * 存放位置 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDataPermissions,java.lang.String> POSITION_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDataPermissions.class ,POSITION_IDS, java.util.List.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , STATUS , OWNER_CODE , CODE , ROLE_CODE , ORG_AUTHORITY_ENABLE , ORG_LOCAL_ENABLE , ORG_CASCADE_ENABLE , CATALOG_AUTHORITY_ENABLE , CATALOG_CASCADE_ENABLE , POSITION_AUTHORITY_ENABLE , PRIORITY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , BUSI_ROLE , CATEGORY , CATEGORY_IDS , ORGANIZATION , ORGANIZATION_IDS , POSITION , POSITION_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetDataPermissions {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetDataPermissions setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AssetDataPermissions setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 权限状态
		 * @param status 权限状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param ownerCode 归属
		 * @return 当前对象
		*/
		public AssetDataPermissions setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 权限编码
		 * @param code 权限编码
		 * @return 当前对象
		*/
		public AssetDataPermissions setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 业务角色
		 * @param roleCode 业务角色
		 * @return 当前对象
		*/
		public AssetDataPermissions setRoleCode(String roleCode) {
			super.change(ROLE_CODE,super.getRoleCode(),roleCode);
			super.setRoleCode(roleCode);
			return this;
		}
		
		/**
		 * 设置 组织权限状态
		 * @param orgAuthorityEnable 组织权限状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrgAuthorityEnable(String orgAuthorityEnable) {
			super.change(ORG_AUTHORITY_ENABLE,super.getOrgAuthorityEnable(),orgAuthorityEnable);
			super.setOrgAuthorityEnable(orgAuthorityEnable);
			return this;
		}
		
		/**
		 * 设置 本组织激活
		 * @param orgLocalEnable 本组织激活
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrgLocalEnable(String orgLocalEnable) {
			super.change(ORG_LOCAL_ENABLE,super.getOrgLocalEnable(),orgLocalEnable);
			super.setOrgLocalEnable(orgLocalEnable);
			return this;
		}
		
		/**
		 * 设置 组织级联状态
		 * @param orgCascadeEnable 组织级联状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrgCascadeEnable(String orgCascadeEnable) {
			super.change(ORG_CASCADE_ENABLE,super.getOrgCascadeEnable(),orgCascadeEnable);
			super.setOrgCascadeEnable(orgCascadeEnable);
			return this;
		}
		
		/**
		 * 设置 分类权限状态
		 * @param catalogAuthorityEnable 分类权限状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setCatalogAuthorityEnable(String catalogAuthorityEnable) {
			super.change(CATALOG_AUTHORITY_ENABLE,super.getCatalogAuthorityEnable(),catalogAuthorityEnable);
			super.setCatalogAuthorityEnable(catalogAuthorityEnable);
			return this;
		}
		
		/**
		 * 设置 分类级联状态
		 * @param catalogCascadeEnable 分类级联状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setCatalogCascadeEnable(String catalogCascadeEnable) {
			super.change(CATALOG_CASCADE_ENABLE,super.getCatalogCascadeEnable(),catalogCascadeEnable);
			super.setCatalogCascadeEnable(catalogCascadeEnable);
			return this;
		}
		
		/**
		 * 设置 位置权限状态
		 * @param positionAuthorityEnable 位置权限状态
		 * @return 当前对象
		*/
		public AssetDataPermissions setPositionAuthorityEnable(String positionAuthorityEnable) {
			super.change(POSITION_AUTHORITY_ENABLE,super.getPositionAuthorityEnable(),positionAuthorityEnable);
			super.setPositionAuthorityEnable(positionAuthorityEnable);
			return this;
		}
		
		/**
		 * 设置 优先级
		 * @param priority 优先级
		 * @return 当前对象
		*/
		public AssetDataPermissions setPriority(Integer priority) {
			super.change(PRIORITY,super.getPriority(),priority);
			super.setPriority(priority);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetDataPermissions setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetDataPermissions setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetDataPermissions setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetDataPermissions setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetDataPermissions setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetDataPermissions setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetDataPermissions setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetDataPermissions setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssetDataPermissions setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetDataPermissions setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 业务角色
		 * @param busiRole 业务角色
		 * @return 当前对象
		*/
		public AssetDataPermissions setBusiRole(BusiRole busiRole) {
			super.change(BUSI_ROLE,super.getBusiRole(),busiRole);
			super.setBusiRole(busiRole);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public AssetDataPermissions setCategory(List<Catalog> category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param categoryIds 资产分类
		 * @return 当前对象
		*/
		public AssetDataPermissions setCategoryIds(List<String> categoryIds) {
			super.change(CATEGORY_IDS,super.getCategoryIds(),categoryIds);
			super.setCategoryIds(categoryIds);
			return this;
		}
		
		/**
		 * 设置 组织节点
		 * @param organization 组织节点
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrganization(List<Organization> organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
		
		/**
		 * 设置 组织节点
		 * @param organizationIds 组织节点
		 * @return 当前对象
		*/
		public AssetDataPermissions setOrganizationIds(List<String> organizationIds) {
			super.change(ORGANIZATION_IDS,super.getOrganizationIds(),organizationIds);
			super.setOrganizationIds(organizationIds);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param position 存放位置
		 * @return 当前对象
		*/
		public AssetDataPermissions setPosition(List<Position> position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param positionIds 存放位置
		 * @return 当前对象
		*/
		public AssetDataPermissions setPositionIds(List<String> positionIds) {
			super.change(POSITION_IDS,super.getPositionIds(),positionIds);
			super.setPositionIds(positionIds);
			return this;
		}
	}
}