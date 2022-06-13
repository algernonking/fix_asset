package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_TASK_POINT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 巡检点
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-14 06:28:14
 * @sign 60EBB7903698DDDA12764F1264B2A7D8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_task_point")
public class InspectionTaskPoint extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_TASK_POINT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String taskId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 巡检状态：巡检状态
	*/
	@ApiModelProperty(required = false,value="巡检状态" , notes = "巡检状态")
	private String pointStatus;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operTime;
	
	/**
	 * 巡检结果：巡检结果
	*/
	@ApiModelProperty(required = false,value="巡检结果" , notes = "巡检结果")
	private String content;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String pointCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String pointName;
	
	/**
	 * 巡检内容：巡检内容
	*/
	@ApiModelProperty(required = false,value="巡检内容" , notes = "巡检内容")
	private String pointContent;
	
	/**
	 * 巡检路线：巡检路线
	*/
	@ApiModelProperty(required = false,value="巡检路线" , notes = "巡检路线")
	private String pointRouteId;
	
	/**
	 * RFID：RFID
	*/
	@ApiModelProperty(required = false,value="RFID" , notes = "RFID")
	private String pointRfid;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String pointPos;
	
	/**
	 * 位置经度：位置经度
	*/
	@ApiModelProperty(required = false,value="位置经度" , notes = "位置经度")
	private String pointPosLongitude;
	
	/**
	 * 位置纬度：位置纬度
	*/
	@ApiModelProperty(required = false,value="位置纬度" , notes = "位置纬度")
	private String pointPosLatitude;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String pointNotes;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operId;
	
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
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * route：route
	*/
	@ApiModelProperty(required = false,value="route" , notes = "route")
	private InspectionRoute route;
	
	/**
	 * task：task
	*/
	@ApiModelProperty(required = false,value="task" , notes = "task")
	private InspectionTask task;
	
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
	public InspectionTaskPoint setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务
	 * @param taskId 任务
	 * @return 当前对象
	*/
	public InspectionTaskPoint setTaskId(String taskId) {
		this.taskId=taskId;
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
	public InspectionTaskPoint setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 巡检状态<br>
	 * 巡检状态
	 * @return 巡检状态
	*/
	public String getPointStatus() {
		return pointStatus;
	}
	
	/**
	 * 设置 巡检状态
	 * @param pointStatus 巡检状态
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointStatus(String pointStatus) {
		this.pointStatus=pointStatus;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param operTime 操作时间
	 * @return 当前对象
	*/
	public InspectionTaskPoint setOperTime(Date operTime) {
		this.operTime=operTime;
		return this;
	}
	
	/**
	 * 获得 巡检结果<br>
	 * 巡检结果
	 * @return 巡检结果
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 巡检结果
	 * @param content 巡检结果
	 * @return 当前对象
	*/
	public InspectionTaskPoint setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getPointCode() {
		return pointCode;
	}
	
	/**
	 * 设置 编码
	 * @param pointCode 编码
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointCode(String pointCode) {
		this.pointCode=pointCode;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getPointName() {
		return pointName;
	}
	
	/**
	 * 设置 名称
	 * @param pointName 名称
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointName(String pointName) {
		this.pointName=pointName;
		return this;
	}
	
	/**
	 * 获得 巡检内容<br>
	 * 巡检内容
	 * @return 巡检内容
	*/
	public String getPointContent() {
		return pointContent;
	}
	
	/**
	 * 设置 巡检内容
	 * @param pointContent 巡检内容
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointContent(String pointContent) {
		this.pointContent=pointContent;
		return this;
	}
	
	/**
	 * 获得 巡检路线<br>
	 * 巡检路线
	 * @return 巡检路线
	*/
	public String getPointRouteId() {
		return pointRouteId;
	}
	
	/**
	 * 设置 巡检路线
	 * @param pointRouteId 巡检路线
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointRouteId(String pointRouteId) {
		this.pointRouteId=pointRouteId;
		return this;
	}
	
	/**
	 * 获得 RFID<br>
	 * RFID
	 * @return RFID
	*/
	public String getPointRfid() {
		return pointRfid;
	}
	
	/**
	 * 设置 RFID
	 * @param pointRfid RFID
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointRfid(String pointRfid) {
		this.pointRfid=pointRfid;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPointPos() {
		return pointPos;
	}
	
	/**
	 * 设置 位置
	 * @param pointPos 位置
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointPos(String pointPos) {
		this.pointPos=pointPos;
		return this;
	}
	
	/**
	 * 获得 位置经度<br>
	 * 位置经度
	 * @return 位置经度
	*/
	public String getPointPosLongitude() {
		return pointPosLongitude;
	}
	
	/**
	 * 设置 位置经度
	 * @param pointPosLongitude 位置经度
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointPosLongitude(String pointPosLongitude) {
		this.pointPosLongitude=pointPosLongitude;
		return this;
	}
	
	/**
	 * 获得 位置纬度<br>
	 * 位置纬度
	 * @return 位置纬度
	*/
	public String getPointPosLatitude() {
		return pointPosLatitude;
	}
	
	/**
	 * 设置 位置纬度
	 * @param pointPosLatitude 位置纬度
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointPosLatitude(String pointPosLatitude) {
		this.pointPosLatitude=pointPosLatitude;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getPointNotes() {
		return pointNotes;
	}
	
	/**
	 * 设置 备注
	 * @param pointNotes 备注
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointNotes(String pointNotes) {
		this.pointNotes=pointNotes;
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
	public InspectionTaskPoint setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperId() {
		return operId;
	}
	
	/**
	 * 设置 操作人
	 * @param operId 操作人
	 * @return 当前对象
	*/
	public InspectionTaskPoint setOperId(String operId) {
		this.operId=operId;
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
	public InspectionTaskPoint setNotes(String notes) {
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
	public InspectionTaskPoint setCreateBy(String createBy) {
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
	public InspectionTaskPoint setCreateTime(Date createTime) {
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
	public InspectionTaskPoint setUpdateBy(String updateBy) {
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
	public InspectionTaskPoint setUpdateTime(Date updateTime) {
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
	public InspectionTaskPoint setDeleted(Integer deleted) {
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
	public InspectionTaskPoint setDeleted(Boolean deletedBool) {
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
	public InspectionTaskPoint setDeleteBy(String deleteBy) {
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
	public InspectionTaskPoint setDeleteTime(Date deleteTime) {
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
	public InspectionTaskPoint setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public InspectionTaskPoint setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public InspectionTaskPoint setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 route<br>
	 * route
	 * @return route
	*/
	public InspectionRoute getRoute() {
		return route;
	}
	
	/**
	 * 设置 route
	 * @param route route
	 * @return 当前对象
	*/
	public InspectionTaskPoint setRoute(InspectionRoute route) {
		this.route=route;
		return this;
	}
	
	/**
	 * 获得 task<br>
	 * task
	 * @return task
	*/
	public InspectionTask getTask() {
		return task;
	}
	
	/**
	 * 设置 task
	 * @param task task
	 * @return 当前对象
	*/
	public InspectionTaskPoint setTask(InspectionTask task) {
		this.task=task;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionTaskPoint , 转换好的 InspectionTaskPoint 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTaskPoint , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InspectionTaskPoint
	 * @param inspectionTaskPointMap 包含实体信息的 Map 对象
	 * @return InspectionTaskPoint , 转换好的的 InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPoint createFrom(Map<String,Object> inspectionTaskPointMap) {
		if(inspectionTaskPointMap==null) return null;
		InspectionTaskPoint po = EntityContext.create(InspectionTaskPoint.class, inspectionTaskPointMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionTaskPoint
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTaskPoint , 转换好的的 InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPoint createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTaskPoint po = EntityContext.create(InspectionTaskPoint.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InspectionTaskPoint，等同于 new
	 * @return InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPoint create() {
		return EntityContext.create(InspectionTaskPoint.class);
	}
}