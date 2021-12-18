package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DATA_PERMISSIONS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.pcm.Catalog;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 资产数据权限
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-18 08:47:42
 * @sign 5FEFD8D535EF42E03531B3CCD34F6D10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_data_permissions")
public class AssetDataPermissions extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DATA_PERMISSIONS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 权限状态：权限状态
	*/
	@ApiModelProperty(required = false,value="权限状态" , notes = "权限状态")
	private String status;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属")
	private String ownerCode;
	
	/**
	 * 权限编码：权限编码
	*/
	@ApiModelProperty(required = false,value="权限编码" , notes = "权限编码")
	private String code;
	
	/**
	 * 业务角色：业务角色
	*/
	@ApiModelProperty(required = false,value="业务角色" , notes = "业务角色")
	private String roleCode;
	
	/**
	 * 组织权限状态：组织权限状态
	*/
	@ApiModelProperty(required = false,value="组织权限状态" , notes = "组织权限状态")
	private String orgAuthorityEnable;
	
	/**
	 * 本组织激活：本组织激活
	*/
	@ApiModelProperty(required = false,value="本组织激活" , notes = "本组织激活")
	private String orgLocalEnable;
	
	/**
	 * 组织级联状态：组织级联状态
	*/
	@ApiModelProperty(required = false,value="组织级联状态" , notes = "组织级联状态")
	private String orgCascadeEnable;
	
	/**
	 * 分类权限状态：分类权限状态
	*/
	@ApiModelProperty(required = false,value="分类权限状态" , notes = "分类权限状态")
	private String catalogAuthorityEnable;
	
	/**
	 * 分类级联状态：分类级联状态
	*/
	@ApiModelProperty(required = false,value="分类级联状态" , notes = "分类级联状态")
	private String catalogCascadeEnable;
	
	/**
	 * 位置权限状态：位置权限状态
	*/
	@ApiModelProperty(required = false,value="位置权限状态" , notes = "位置权限状态")
	private String positionAuthorityEnable;
	
	/**
	 * 优先级：优先级
	*/
	@ApiModelProperty(required = false,value="优先级" , notes = "优先级")
	private Integer priority;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 业务角色：业务角色
	*/
	@ApiModelProperty(required = false,value="业务角色" , notes = "业务角色")
	private BusiRole busiRole;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private List<Catalog> category;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private List<String> categoryIds;
	
	/**
	 * 组织节点：组织节点
	*/
	@ApiModelProperty(required = false,value="组织节点" , notes = "组织节点")
	private List<Organization> organization;
	
	/**
	 * 组织节点：组织节点
	*/
	@ApiModelProperty(required = false,value="组织节点" , notes = "组织节点")
	private List<String> organizationIds;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private List<Position> position;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private List<String> positionIds;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public AssetDataPermissions setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public AssetDataPermissions setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 权限状态<br>
	 * 权限状态
	 * @return 权限状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 权限状态
	 * @param status 权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public AssetDataPermissions setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 权限编码<br>
	 * 权限编码
	 * @return 权限编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 权限编码
	 * @param code 权限编码
	 * @return 当前对象
	*/
	public AssetDataPermissions setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 业务角色<br>
	 * 业务角色
	 * @return 业务角色
	*/
	public String getRoleCode() {
		return roleCode;
	}
	
	/**
	 * 设置 业务角色
	 * @param roleCode 业务角色
	 * @return 当前对象
	*/
	public AssetDataPermissions setRoleCode(String roleCode) {
		this.roleCode=roleCode;
		return this;
	}
	
	/**
	 * 获得 组织权限状态<br>
	 * 组织权限状态
	 * @return 组织权限状态
	*/
	public String getOrgAuthorityEnable() {
		return orgAuthorityEnable;
	}
	
	/**
	 * 设置 组织权限状态
	 * @param orgAuthorityEnable 组织权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrgAuthorityEnable(String orgAuthorityEnable) {
		this.orgAuthorityEnable=orgAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 本组织激活<br>
	 * 本组织激活
	 * @return 本组织激活
	*/
	public String getOrgLocalEnable() {
		return orgLocalEnable;
	}
	
	/**
	 * 设置 本组织激活
	 * @param orgLocalEnable 本组织激活
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrgLocalEnable(String orgLocalEnable) {
		this.orgLocalEnable=orgLocalEnable;
		return this;
	}
	
	/**
	 * 获得 组织级联状态<br>
	 * 组织级联状态
	 * @return 组织级联状态
	*/
	public String getOrgCascadeEnable() {
		return orgCascadeEnable;
	}
	
	/**
	 * 设置 组织级联状态
	 * @param orgCascadeEnable 组织级联状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrgCascadeEnable(String orgCascadeEnable) {
		this.orgCascadeEnable=orgCascadeEnable;
		return this;
	}
	
	/**
	 * 获得 分类权限状态<br>
	 * 分类权限状态
	 * @return 分类权限状态
	*/
	public String getCatalogAuthorityEnable() {
		return catalogAuthorityEnable;
	}
	
	/**
	 * 设置 分类权限状态
	 * @param catalogAuthorityEnable 分类权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setCatalogAuthorityEnable(String catalogAuthorityEnable) {
		this.catalogAuthorityEnable=catalogAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 分类级联状态<br>
	 * 分类级联状态
	 * @return 分类级联状态
	*/
	public String getCatalogCascadeEnable() {
		return catalogCascadeEnable;
	}
	
	/**
	 * 设置 分类级联状态
	 * @param catalogCascadeEnable 分类级联状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setCatalogCascadeEnable(String catalogCascadeEnable) {
		this.catalogCascadeEnable=catalogCascadeEnable;
		return this;
	}
	
	/**
	 * 获得 位置权限状态<br>
	 * 位置权限状态
	 * @return 位置权限状态
	*/
	public String getPositionAuthorityEnable() {
		return positionAuthorityEnable;
	}
	
	/**
	 * 设置 位置权限状态
	 * @param positionAuthorityEnable 位置权限状态
	 * @return 当前对象
	*/
	public AssetDataPermissions setPositionAuthorityEnable(String positionAuthorityEnable) {
		this.positionAuthorityEnable=positionAuthorityEnable;
		return this;
	}
	
	/**
	 * 获得 优先级<br>
	 * 优先级
	 * @return 优先级
	*/
	public Integer getPriority() {
		return priority;
	}
	
	/**
	 * 设置 优先级
	 * @param priority 优先级
	 * @return 当前对象
	*/
	public AssetDataPermissions setPriority(Integer priority) {
		this.priority=priority;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public AssetDataPermissions setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public AssetDataPermissions setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public AssetDataPermissions setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public AssetDataPermissions setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public AssetDataPermissions setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public AssetDataPermissions setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public AssetDataPermissions setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public AssetDataPermissions setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public AssetDataPermissions setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public AssetDataPermissions setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 业务角色<br>
	 * 业务角色
	 * @return 业务角色
	*/
	public BusiRole getBusiRole() {
		return busiRole;
	}
	
	/**
	 * 设置 业务角色
	 * @param busiRole 业务角色
	 * @return 当前对象
	*/
	public AssetDataPermissions setBusiRole(BusiRole busiRole) {
		this.busiRole=busiRole;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public List<Catalog> getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions setCategory(List<Catalog> category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 添加 资产分类
	 * @param entity 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions addCategory(Catalog entity) {
		if(this.category==null) category=new ArrayList<>();
		this.category.add(entity);
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public List<String> getCategoryIds() {
		return categoryIds;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryIds 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions setCategoryIds(List<String> categoryIds) {
		this.categoryIds=categoryIds;
		return this;
	}
	
	/**
	 * 添加 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public AssetDataPermissions addCategoryId(String categoryId) {
		if(this.categoryIds==null) categoryIds=new ArrayList<>();
		this.categoryIds.add(categoryId);
		return this;
	}
	
	/**
	 * 获得 组织节点<br>
	 * 组织节点
	 * @return 组织节点
	*/
	public List<Organization> getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 组织节点
	 * @param organization 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrganization(List<Organization> organization) {
		this.organization=organization;
		return this;
	}
	
	/**
	 * 添加 组织节点
	 * @param entity 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions addOrganization(Organization entity) {
		if(this.organization==null) organization=new ArrayList<>();
		this.organization.add(entity);
		return this;
	}
	
	/**
	 * 获得 组织节点<br>
	 * 组织节点
	 * @return 组织节点
	*/
	public List<String> getOrganizationIds() {
		return organizationIds;
	}
	
	/**
	 * 设置 组织节点
	 * @param organizationIds 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions setOrganizationIds(List<String> organizationIds) {
		this.organizationIds=organizationIds;
		return this;
	}
	
	/**
	 * 添加 组织节点
	 * @param organizationId 组织节点
	 * @return 当前对象
	*/
	public AssetDataPermissions addOrganizationId(String organizationId) {
		if(this.organizationIds==null) organizationIds=new ArrayList<>();
		this.organizationIds.add(organizationId);
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public List<Position> getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions setPosition(List<Position> position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 添加 存放位置
	 * @param entity 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions addPosition(Position entity) {
		if(this.position==null) position=new ArrayList<>();
		this.position.add(entity);
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public List<String> getPositionIds() {
		return positionIds;
	}
	
	/**
	 * 设置 存放位置
	 * @param positionIds 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions setPositionIds(List<String> positionIds) {
		this.positionIds=positionIds;
		return this;
	}
	
	/**
	 * 添加 存放位置
	 * @param positionId 存放位置
	 * @return 当前对象
	*/
	public AssetDataPermissions addPositionId(String positionId) {
		if(this.positionIds==null) positionIds=new ArrayList<>();
		this.positionIds.add(positionId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDataPermissions , 转换好的 AssetDataPermissions 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDataPermissions , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将 Map 转换成 AssetDataPermissions
	 * @param assetDataPermissionsMap 包含实体信息的 Map 对象
	 * @return AssetDataPermissions , 转换好的的 AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissions createFrom(Map<String,Object> assetDataPermissionsMap) {
		if(assetDataPermissionsMap==null) return null;
		AssetDataPermissions po = EntityContext.create(AssetDataPermissions.class, assetDataPermissionsMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDataPermissions
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDataPermissions , 转换好的的 AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissions createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDataPermissions po = EntityContext.create(AssetDataPermissions.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetDataPermissions，等同于 new
	 * @return AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissions create() {
		return EntityContext.create(AssetDataPermissions.class);
	}
}