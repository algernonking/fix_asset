package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAINTAIN_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 保养方案
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-05 21:12:40
 * @sign 5C6459B2F1D92C80C51AB22205F2900B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_maintain_plan")
public class MaintainPlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAINTAIN_PLAN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号")
	private String code;
	
	/**
	 * 方案名称：方案名称
	*/
	@ApiModelProperty(required = false,value="方案名称" , notes = "方案名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 执行班组：执行班组
	*/
	@ApiModelProperty(required = false,value="执行班组" , notes = "执行班组")
	private String groupId;
	
	/**
	 * 保养类型：保养类型
	*/
	@ApiModelProperty(required = false,value="保养类型" , notes = "保养类型")
	private String maintainType;
	
	/**
	 * 循环方式：循环方式
	*/
	@ApiModelProperty(required = false,value="循环方式" , notes = "循环方式")
	private String cycleMethod;
	
	/**
	 * 保养周期：保养周期
	*/
	@ApiModelProperty(required = false,value="保养周期" , notes = "保养周期")
	private String actionCycleId;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date endTime;
	
	/**
	 * 总工时：总工时
	*/
	@ApiModelProperty(required = false,value="总工时" , notes = "总工时")
	private BigDecimal totalCost;
	
	/**
	 * 方案说明：方案说明
	*/
	@ApiModelProperty(required = false,value="方案说明" , notes = "方案说明")
	private String info;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
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
	@Transient
	private Boolean deletedBool;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem maintainTypeDict;
	
	/**
	 * 周期：周期
	*/
	@ApiModelProperty(required = false,value="周期" , notes = "周期")
	private ActionCrontab actionCrontab;
	
	/**
	 * 执行班组：执行班组
	*/
	@ApiModelProperty(required = false,value="执行班组" , notes = "执行班组")
	private MaintainGroup maintainGroup;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
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
	public MaintainPlan setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编号
	 * @param code 编号
	 * @return 当前对象
	*/
	public MaintainPlan setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 方案名称<br>
	 * 方案名称
	 * @return 方案名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 方案名称
	 * @param name 方案名称
	 * @return 当前对象
	*/
	public MaintainPlan setName(String name) {
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
	public MaintainPlan setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 执行班组<br>
	 * 执行班组
	 * @return 执行班组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 执行班组
	 * @param groupId 执行班组
	 * @return 当前对象
	*/
	public MaintainPlan setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 保养类型<br>
	 * 保养类型
	 * @return 保养类型
	*/
	public String getMaintainType() {
		return maintainType;
	}
	
	/**
	 * 设置 保养类型
	 * @param maintainType 保养类型
	 * @return 当前对象
	*/
	public MaintainPlan setMaintainType(String maintainType) {
		this.maintainType=maintainType;
		return this;
	}
	
	/**
	 * 获得 循环方式<br>
	 * 循环方式
	 * @return 循环方式
	*/
	public String getCycleMethod() {
		return cycleMethod;
	}
	
	/**
	 * 设置 循环方式
	 * @param cycleMethod 循环方式
	 * @return 当前对象
	*/
	public MaintainPlan setCycleMethod(String cycleMethod) {
		this.cycleMethod=cycleMethod;
		return this;
	}
	
	/**
	 * 获得 保养周期<br>
	 * 保养周期
	 * @return 保养周期
	*/
	public String getActionCycleId() {
		return actionCycleId;
	}
	
	/**
	 * 设置 保养周期
	 * @param actionCycleId 保养周期
	 * @return 当前对象
	*/
	public MaintainPlan setActionCycleId(String actionCycleId) {
		this.actionCycleId=actionCycleId;
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
	public MaintainPlan setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public MaintainPlan setEndTime(Date endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 总工时<br>
	 * 总工时
	 * @return 总工时
	*/
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	/**
	 * 设置 总工时
	 * @param totalCost 总工时
	 * @return 当前对象
	*/
	public MaintainPlan setTotalCost(BigDecimal totalCost) {
		this.totalCost=totalCost;
		return this;
	}
	
	/**
	 * 获得 方案说明<br>
	 * 方案说明
	 * @return 方案说明
	*/
	public String getInfo() {
		return info;
	}
	
	/**
	 * 设置 方案说明
	 * @param info 方案说明
	 * @return 当前对象
	*/
	public MaintainPlan setInfo(String info) {
		this.info=info;
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
	public MaintainPlan setNotes(String notes) {
		this.notes=notes;
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
	public MaintainPlan setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public MaintainPlan setCreateBy(String createBy) {
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
	public MaintainPlan setCreateTime(Date createTime) {
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
	public MaintainPlan setUpdateBy(String updateBy) {
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
	public MaintainPlan setUpdateTime(Date updateTime) {
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
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public MaintainPlan setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public MaintainPlan setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
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
	public MaintainPlan setDeleteBy(String deleteBy) {
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
	public MaintainPlan setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public MaintainPlan setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public MaintainPlan setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getMaintainTypeDict() {
		return maintainTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param maintainTypeDict 类型
	 * @return 当前对象
	*/
	public MaintainPlan setMaintainTypeDict(DictItem maintainTypeDict) {
		this.maintainTypeDict=maintainTypeDict;
		return this;
	}
	
	/**
	 * 获得 周期<br>
	 * 周期
	 * @return 周期
	*/
	public ActionCrontab getActionCrontab() {
		return actionCrontab;
	}
	
	/**
	 * 设置 周期
	 * @param actionCrontab 周期
	 * @return 当前对象
	*/
	public MaintainPlan setActionCrontab(ActionCrontab actionCrontab) {
		this.actionCrontab=actionCrontab;
		return this;
	}
	
	/**
	 * 获得 执行班组<br>
	 * 执行班组
	 * @return 执行班组
	*/
	public MaintainGroup getMaintainGroup() {
		return maintainGroup;
	}
	
	/**
	 * 设置 执行班组
	 * @param maintainGroup 执行班组
	 * @return 当前对象
	*/
	public MaintainPlan setMaintainGroup(MaintainGroup maintainGroup) {
		this.maintainGroup=maintainGroup;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public MaintainPlan setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MaintainPlan , 转换好的 MaintainPlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainPlan , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MaintainPlan
	 * @param maintainPlanMap 包含实体信息的 Map 对象
	 * @return MaintainPlan , 转换好的的 MaintainPlan 对象
	*/
	@Transient
	public static MaintainPlan createFrom(Map<String,Object> maintainPlanMap) {
		if(maintainPlanMap==null) return null;
		MaintainPlan po = EntityContext.create(MaintainPlan.class, maintainPlanMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MaintainPlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainPlan , 转换好的的 MaintainPlan 对象
	*/
	@Transient
	public static MaintainPlan createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainPlan po = EntityContext.create(MaintainPlan.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MaintainPlan，等同于 new
	 * @return MaintainPlan 对象
	*/
	@Transient
	public static MaintainPlan create() {
		return EntityContext.create(MaintainPlan.class);
	}
}