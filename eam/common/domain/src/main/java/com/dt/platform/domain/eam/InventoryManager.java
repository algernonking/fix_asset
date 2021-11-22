package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY_MANAGER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 资产管理人
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-19 21:37:25
 * @sign 5F4B14BDE872A4241DDC5D7774B2FD25
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory_manager")
public class InventoryManager extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY_MANAGER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 盘点：盘点
	*/
	@ApiModelProperty(required = false,value="盘点" , notes = "盘点")
	private String inventoryId;
	
	/**
	 * 盘点人：盘点人
	*/
	@ApiModelProperty(required = false,value="盘点人" , notes = "盘点人")
	private String userId;
	
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
	 * 资产管理员：资产管理员
	*/
	@ApiModelProperty(required = false,value="资产管理员" , notes = "资产管理员")
	private Employee inventoryManager;
	
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
	public InventoryManager setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 盘点<br>
	 * 盘点
	 * @return 盘点
	*/
	public String getInventoryId() {
		return inventoryId;
	}
	
	/**
	 * 设置 盘点
	 * @param inventoryId 盘点
	 * @return 当前对象
	*/
	public InventoryManager setInventoryId(String inventoryId) {
		this.inventoryId=inventoryId;
		return this;
	}
	
	/**
	 * 获得 盘点人<br>
	 * 盘点人
	 * @return 盘点人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 盘点人
	 * @param userId 盘点人
	 * @return 当前对象
	*/
	public InventoryManager setUserId(String userId) {
		this.userId=userId;
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
	public InventoryManager setNotes(String notes) {
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
	public InventoryManager setCreateBy(String createBy) {
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
	public InventoryManager setCreateTime(Date createTime) {
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
	public InventoryManager setUpdateBy(String updateBy) {
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
	public InventoryManager setUpdateTime(Date updateTime) {
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
	public InventoryManager setDeleted(Integer deleted) {
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
	public InventoryManager setDeleteBy(String deleteBy) {
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
	public InventoryManager setDeleteTime(Date deleteTime) {
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
	public InventoryManager setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 资产管理员<br>
	 * 资产管理员
	 * @return 资产管理员
	*/
	public Employee getInventoryManager() {
		return inventoryManager;
	}
	
	/**
	 * 设置 资产管理员
	 * @param inventoryManager 资产管理员
	 * @return 当前对象
	*/
	public InventoryManager setInventoryManager(Employee inventoryManager) {
		this.inventoryManager=inventoryManager;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InventoryManager , 转换好的 InventoryManager 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryManager , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InventoryManager
	 * @param inventoryManagerMap 包含实体信息的 Map 对象
	 * @return InventoryManager , 转换好的的 InventoryManager 对象
	*/
	@Transient
	public static InventoryManager createFrom(Map<String,Object> inventoryManagerMap) {
		if(inventoryManagerMap==null) return null;
		InventoryManager po = EntityContext.create(InventoryManager.class, inventoryManagerMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InventoryManager
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryManager , 转换好的的 InventoryManager 对象
	*/
	@Transient
	public static InventoryManager createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryManager po = EntityContext.create(InventoryManager.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InventoryManager，等同于 new
	 * @return InventoryManager 对象
	*/
	@Transient
	public static InventoryManager create() {
		return EntityContext.create(InventoryManager.class);
	}
}