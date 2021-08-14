package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_SERVICE_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 16:01:43
 * @sign C76E500B932E95AD19FB1FDEFB3062C1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_service_info")
public class ServiceInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_SERVICE_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 服务ID：服务ID
	*/
	@ApiModelProperty(required = false,value="服务ID" , notes = "服务ID")
	private String serviceCategoryId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 补丁：补丁
	*/
	@ApiModelProperty(required = false,value="补丁" , notes = "补丁")
	private String patch;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 服务
	*/
	@ApiModelProperty(required = false,value="服务" , notes = "")
	private ServiceCategory serviceCategory;
	
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
	public ServiceInfo setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 服务ID<br>
	 * 服务ID
	 * @return 服务ID
	*/
	public String getServiceCategoryId() {
		return serviceCategoryId;
	}
	
	/**
	 * 设置 服务ID
	 * @param serviceCategoryId 服务ID
	 * @return 当前对象
	*/
	public ServiceInfo setServiceCategoryId(String serviceCategoryId) {
		this.serviceCategoryId=serviceCategoryId;
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
	public ServiceInfo setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 补丁<br>
	 * 补丁
	 * @return 补丁
	*/
	public String getPatch() {
		return patch;
	}
	
	/**
	 * 设置 补丁
	 * @param patch 补丁
	 * @return 当前对象
	*/
	public ServiceInfo setPatch(String patch) {
		this.patch=patch;
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
	public ServiceInfo setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public ServiceInfo setSort(Integer sort) {
		this.sort=sort;
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
	public ServiceInfo setCreateBy(String createBy) {
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
	public ServiceInfo setCreateTime(Date createTime) {
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
	public ServiceInfo setUpdateBy(String updateBy) {
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
	public ServiceInfo setUpdateTime(Date updateTime) {
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
	public ServiceInfo setDeleted(Integer deleted) {
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
	public ServiceInfo setDeleteBy(String deleteBy) {
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
	public ServiceInfo setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public ServiceInfo setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 服务<br>
	 * @return 服务
	*/
	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}
	
	/**
	 * 设置 服务
	 * @param serviceCategory 服务
	 * @return 当前对象
	*/
	public ServiceInfo setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory=serviceCategory;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ServiceInfo , 转换好的 ServiceInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ServiceInfo , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ServiceInfo
	 * @param serviceInfoMap 包含实体信息的 Map 对象
	 * @return ServiceInfo , 转换好的的 ServiceInfo 对象
	*/
	@Transient
	public static ServiceInfo createFrom(Map<String,Object> serviceInfoMap) {
		if(serviceInfoMap==null) return null;
		ServiceInfo po = EntityContext.create(ServiceInfo.class, serviceInfoMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ServiceInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ServiceInfo , 转换好的的 ServiceInfo 对象
	*/
	@Transient
	public static ServiceInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		ServiceInfo po = EntityContext.create(ServiceInfo.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ServiceInfo，等同于 new
	 * @return ServiceInfo 对象
	*/
	@Transient
	public static ServiceInfo create() {
		return EntityContext.create(ServiceInfo.class);
	}
}