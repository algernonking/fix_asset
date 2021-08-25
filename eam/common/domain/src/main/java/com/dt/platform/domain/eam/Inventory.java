package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-24 20:00:02
 * @sign F1DBC8DB38389F930613D14FA1A07717
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory")
public class Inventory extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 业务编码：业务编码
	*/
	@ApiModelProperty(required = false,value="业务编码" , notes = "业务编码")
	private String businessCode;
	
	/**
	 * 盘点名称：盘点名称
	*/
	@ApiModelProperty(required = false,value="盘点名称" , notes = "盘点名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 数据状态：数据状态
	*/
	@ApiModelProperty(required = false,value="数据状态" , notes = "数据状态")
	private String dataStatus;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private String useOrganizationId;
	
	/**
	 * 资产位置：资产位置
	*/
	@ApiModelProperty(required = false,value="资产位置" , notes = "资产位置")
	private String positionId;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String directoryId;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date finishTime;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
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
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private Position position;
	
	/**
	 * 盘点人员：盘点人员
	*/
	@ApiModelProperty(required = false,value="盘点人员" , notes = "盘点人员")
	private List<InventoryUser> inventoryUserList;
	
	/**
	 * 盘点人员列表：盘点人员列表
	*/
	@ApiModelProperty(required = false,value="盘点人员列表" , notes = "盘点人员列表")
	private List<String> inventoryUserIds;
	
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
	public Inventory setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编码<br>
	 * 业务编码
	 * @return 业务编码
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编码
	 * @param businessCode 业务编码
	 * @return 当前对象
	*/
	public Inventory setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 盘点名称<br>
	 * 盘点名称
	 * @return 盘点名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 盘点名称
	 * @param name 盘点名称
	 * @return 当前对象
	*/
	public Inventory setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public Inventory setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 数据状态<br>
	 * 数据状态
	 * @return 数据状态
	*/
	public String getDataStatus() {
		return dataStatus;
	}
	
	/**
	 * 设置 数据状态
	 * @param dataStatus 数据状态
	 * @return 当前对象
	*/
	public Inventory setDataStatus(String dataStatus) {
		this.dataStatus=dataStatus;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public Inventory setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public String getOwnCompanyId() {
		return ownCompanyId;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownCompanyId 所属公司
	 * @return 当前对象
	*/
	public Inventory setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public String getUseOrganizationId() {
		return useOrganizationId;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganizationId 使用公司/部门
	 * @return 当前对象
	*/
	public Inventory setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 资产位置<br>
	 * 资产位置
	 * @return 资产位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 资产位置
	 * @param positionId 资产位置
	 * @return 当前对象
	*/
	public Inventory setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getDirectoryId() {
		return directoryId;
	}
	
	/**
	 * 设置 负责人
	 * @param directoryId 负责人
	 * @return 当前对象
	*/
	public Inventory setDirectoryId(String directoryId) {
		this.directoryId=directoryId;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public Inventory setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getFinishTime() {
		return finishTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param finishTime 结束时间
	 * @return 当前对象
	*/
	public Inventory setFinishTime(Date finishTime) {
		this.finishTime=finishTime;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public Inventory setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 业务日期<br>
	 * 业务日期
	 * @return 业务日期
	*/
	public Date getBusinessDate() {
		return businessDate;
	}
	
	/**
	 * 设置 业务日期
	 * @param businessDate 业务日期
	 * @return 当前对象
	*/
	public Inventory setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
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
	public Inventory setNotes(String notes) {
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
	public Inventory setCreateBy(String createBy) {
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
	public Inventory setCreateTime(Date createTime) {
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
	public Inventory setUpdateBy(String updateBy) {
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
	public Inventory setUpdateTime(Date updateTime) {
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
	public Inventory setDeleted(Integer deleted) {
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
	public Inventory setDeleteBy(String deleteBy) {
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
	public Inventory setDeleteTime(Date deleteTime) {
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
	public Inventory setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public Inventory setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 盘点人员<br>
	 * 盘点人员
	 * @return 盘点人员
	*/
	public List<InventoryUser> getInventoryUserList() {
		return inventoryUserList;
	}
	
	/**
	 * 设置 盘点人员
	 * @param inventoryUserList 盘点人员
	 * @return 当前对象
	*/
	public Inventory setInventoryUserList(List<InventoryUser> inventoryUserList) {
		this.inventoryUserList=inventoryUserList;
		return this;
	}
	
	/**
	 * 添加 盘点人员
	 * @param inventoryUser 盘点人员
	 * @return 当前对象
	*/
	public Inventory addInventoryUser(InventoryUser inventoryUser) {
		if(this.inventoryUserList==null) inventoryUserList=new ArrayList<>();
		this.inventoryUserList.add(inventoryUser);
		return this;
	}
	
	/**
	 * 获得 盘点人员列表<br>
	 * 盘点人员列表
	 * @return 盘点人员列表
	*/
	public List<String> getInventoryUserIds() {
		return inventoryUserIds;
	}
	
	/**
	 * 设置 盘点人员列表
	 * @param inventoryUserIds 盘点人员列表
	 * @return 当前对象
	*/
	public Inventory setInventoryUserIds(List<String> inventoryUserIds) {
		this.inventoryUserIds=inventoryUserIds;
		return this;
	}
	
	/**
	 * 添加 盘点人员列表
	 * @param inventoryUserId 盘点人员列表
	 * @return 当前对象
	*/
	public Inventory addInventoryUserId(String inventoryUserId) {
		if(this.inventoryUserIds==null) inventoryUserIds=new ArrayList<>();
		this.inventoryUserIds.add(inventoryUserId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Inventory , 转换好的 Inventory 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Inventory , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Inventory
	 * @param inventoryMap 包含实体信息的 Map 对象
	 * @return Inventory , 转换好的的 Inventory 对象
	*/
	@Transient
	public static Inventory createFrom(Map<String,Object> inventoryMap) {
		if(inventoryMap==null) return null;
		Inventory po = EntityContext.create(Inventory.class, inventoryMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Inventory
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Inventory , 转换好的的 Inventory 对象
	*/
	@Transient
	public static Inventory createFrom(Object pojo) {
		if(pojo==null) return null;
		Inventory po = EntityContext.create(Inventory.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Inventory，等同于 new
	 * @return Inventory 对象
	*/
	@Transient
	public static Inventory create() {
		return EntityContext.create(Inventory.class);
	}
}