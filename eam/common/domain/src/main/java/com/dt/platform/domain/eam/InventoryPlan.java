package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 盘点计划
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-03 10:30:33
 * @sign C2074623F356DD7F649836872F7B6AA2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory_plan")
public class InventoryPlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY_PLAN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 计划名称：计划名称
	*/
	@ApiModelProperty(required = false,value="计划名称" , notes = "计划名称")
	private String name;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属")
	private String ownerCode;
	
	/**
	 * 启用状态：启用状态
	*/
	@ApiModelProperty(required = false,value="启用状态" , notes = "启用状态")
	private String status;
	
	/**
	 * 计划类型：计划类型
	*/
	@ApiModelProperty(required = false,value="计划类型" , notes = "计划类型")
	private String planType;
	
	/**
	 * 模板：模板
	*/
	@ApiModelProperty(required = false,value="模板" , notes = "模板")
	private String tplId;
	
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
	 * 盘点数据：盘点数据
	*/
	@ApiModelProperty(required = false,value="盘点数据" , notes = "盘点数据")
	private Inventory inventory;
	
	/**
	 * 盘点类型：盘点类型
	*/
	@ApiModelProperty(required = false,value="盘点类型" , notes = "盘点类型")
	private DictItem inventoryPlanType;
	
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
	public InventoryPlan setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 计划名称<br>
	 * 计划名称
	 * @return 计划名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 计划名称
	 * @param name 计划名称
	 * @return 当前对象
	*/
	public InventoryPlan setName(String name) {
		this.name=name;
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
	public InventoryPlan setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 启用状态<br>
	 * 启用状态
	 * @return 启用状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 启用状态
	 * @param status 启用状态
	 * @return 当前对象
	*/
	public InventoryPlan setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 计划类型<br>
	 * 计划类型
	 * @return 计划类型
	*/
	public String getPlanType() {
		return planType;
	}
	
	/**
	 * 设置 计划类型
	 * @param planType 计划类型
	 * @return 当前对象
	*/
	public InventoryPlan setPlanType(String planType) {
		this.planType=planType;
		return this;
	}
	
	/**
	 * 获得 模板<br>
	 * 模板
	 * @return 模板
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模板
	 * @param tplId 模板
	 * @return 当前对象
	*/
	public InventoryPlan setTplId(String tplId) {
		this.tplId=tplId;
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
	public InventoryPlan setNotes(String notes) {
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
	public InventoryPlan setCreateBy(String createBy) {
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
	public InventoryPlan setCreateTime(Date createTime) {
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
	public InventoryPlan setUpdateBy(String updateBy) {
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
	public InventoryPlan setUpdateTime(Date updateTime) {
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
	public InventoryPlan setDeleted(Integer deleted) {
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
	public InventoryPlan setDeleteBy(String deleteBy) {
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
	public InventoryPlan setDeleteTime(Date deleteTime) {
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
	public InventoryPlan setVersion(Integer version) {
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
	public InventoryPlan setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 盘点数据<br>
	 * 盘点数据
	 * @return 盘点数据
	*/
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * 设置 盘点数据
	 * @param inventory 盘点数据
	 * @return 当前对象
	*/
	public InventoryPlan setInventory(Inventory inventory) {
		this.inventory=inventory;
		return this;
	}
	
	/**
	 * 获得 盘点类型<br>
	 * 盘点类型
	 * @return 盘点类型
	*/
	public DictItem getInventoryPlanType() {
		return inventoryPlanType;
	}
	
	/**
	 * 设置 盘点类型
	 * @param inventoryPlanType 盘点类型
	 * @return 当前对象
	*/
	public InventoryPlan setInventoryPlanType(DictItem inventoryPlanType) {
		this.inventoryPlanType=inventoryPlanType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InventoryPlan , 转换好的 InventoryPlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryPlan , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InventoryPlan
	 * @param inventoryPlanMap 包含实体信息的 Map 对象
	 * @return InventoryPlan , 转换好的的 InventoryPlan 对象
	*/
	@Transient
	public static InventoryPlan createFrom(Map<String,Object> inventoryPlanMap) {
		if(inventoryPlanMap==null) return null;
		InventoryPlan po = EntityContext.create(InventoryPlan.class, inventoryPlanMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InventoryPlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryPlan , 转换好的的 InventoryPlan 对象
	*/
	@Transient
	public static InventoryPlan createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryPlan po = EntityContext.create(InventoryPlan.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InventoryPlan，等同于 new
	 * @return InventoryPlan 对象
	*/
	@Transient
	public static InventoryPlan create() {
		return EntityContext.create(InventoryPlan.class);
	}
}