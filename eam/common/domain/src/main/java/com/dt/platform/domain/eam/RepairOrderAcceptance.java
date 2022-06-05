package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_ORDER_ACCEPTANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 维修验收
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 05:56:19
 * @sign D0E5AB998802BFC4640D5FA59F004DD8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_order_acceptance")
public class RepairOrderAcceptance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_ORDER_ACCEPTANCE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 申请单：申请单
	*/
	@ApiModelProperty(required = false,value="申请单" , notes = "申请单")
	private String orderId;
	
	/**
	 * 维修单：维修单
	*/
	@ApiModelProperty(required = false,value="维修单" , notes = "维修单")
	private String orderActId;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 维修结果：维修结果
	*/
	@ApiModelProperty(required = false,value="维修结果" , notes = "维修结果")
	private String resultType;
	
	/**
	 * 验收人：验收人
	*/
	@ApiModelProperty(required = false,value="验收人" , notes = "验收人")
	private String accepterId;
	
	/**
	 * 实际故障：实际故障
	*/
	@ApiModelProperty(required = false,value="实际故障" , notes = "实际故障")
	private String categoryTplId;
	
	/**
	 * 实际花费：实际花费
	*/
	@ApiModelProperty(required = false,value="实际花费" , notes = "实际花费")
	private BigDecimal actualCost;
	
	/**
	 * 完成时间：完成时间
	*/
	@ApiModelProperty(required = false,value="完成时间" , notes = "完成时间")
	private Date finishTime;
	
	/**
	 * 验收备注：验收备注
	*/
	@ApiModelProperty(required = false,value="验收备注" , notes = "验收备注")
	private String notes;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
	private String selectedCode;
	
	/**
	 * 申请单：申请单
	*/
	@ApiModelProperty(required = false,value="申请单" , notes = "申请单")
	private RepairOrder order;
	
	/**
	 * 维修单：维修单
	*/
	@ApiModelProperty(required = false,value="维修单" , notes = "维修单")
	private RepairOrderAct orderAct;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 验收人：验收人
	*/
	@ApiModelProperty(required = false,value="验收人" , notes = "验收人")
	private Employee accepter;
	
	/**
	 * 结果类型：结果类型
	*/
	@ApiModelProperty(required = false,value="结果类型" , notes = "结果类型")
	private DictItem resultTypeDict;
	
	/**
	 * 报修故障：报修故障
	*/
	@ApiModelProperty(required = false,value="报修故障" , notes = "报修故障")
	private RepairCategoryTpl categoryTpl;
	
	/**
	 * 订单名称：订单名称
	*/
	@ApiModelProperty(required = false,value="订单名称" , notes = "订单名称")
	private String orderName;
	
	/**
	 * 订单编号：订单编号
	*/
	@ApiModelProperty(required = false,value="订单编号" , notes = "订单编号")
	private String orderBusinessCode;
	
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
	public RepairOrderAcceptance setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 申请单<br>
	 * 申请单
	 * @return 申请单
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 申请单
	 * @param orderId 申请单
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 维修单<br>
	 * 维修单
	 * @return 维修单
	*/
	public String getOrderActId() {
		return orderActId;
	}
	
	/**
	 * 设置 维修单
	 * @param orderActId 维修单
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setOrderActId(String orderActId) {
		this.orderActId=orderActId;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 维修结果<br>
	 * 维修结果
	 * @return 维修结果
	*/
	public String getResultType() {
		return resultType;
	}
	
	/**
	 * 设置 维修结果
	 * @param resultType 维修结果
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setResultType(String resultType) {
		this.resultType=resultType;
		return this;
	}
	
	/**
	 * 获得 验收人<br>
	 * 验收人
	 * @return 验收人
	*/
	public String getAccepterId() {
		return accepterId;
	}
	
	/**
	 * 设置 验收人
	 * @param accepterId 验收人
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setAccepterId(String accepterId) {
		this.accepterId=accepterId;
		return this;
	}
	
	/**
	 * 获得 实际故障<br>
	 * 实际故障
	 * @return 实际故障
	*/
	public String getCategoryTplId() {
		return categoryTplId;
	}
	
	/**
	 * 设置 实际故障
	 * @param categoryTplId 实际故障
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setCategoryTplId(String categoryTplId) {
		this.categoryTplId=categoryTplId;
		return this;
	}
	
	/**
	 * 获得 实际花费<br>
	 * 实际花费
	 * @return 实际花费
	*/
	public BigDecimal getActualCost() {
		return actualCost;
	}
	
	/**
	 * 设置 实际花费
	 * @param actualCost 实际花费
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setActualCost(BigDecimal actualCost) {
		this.actualCost=actualCost;
		return this;
	}
	
	/**
	 * 获得 完成时间<br>
	 * 完成时间
	 * @return 完成时间
	*/
	public Date getFinishTime() {
		return finishTime;
	}
	
	/**
	 * 设置 完成时间
	 * @param finishTime 完成时间
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setFinishTime(Date finishTime) {
		this.finishTime=finishTime;
		return this;
	}
	
	/**
	 * 获得 验收备注<br>
	 * 验收备注
	 * @return 验收备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 验收备注
	 * @param notes 验收备注
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public RepairOrderAcceptance setOriginatorId(String originatorId) {
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
	public RepairOrderAcceptance setCreateBy(String createBy) {
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
	public RepairOrderAcceptance setCreateTime(Date createTime) {
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
	public RepairOrderAcceptance setUpdateBy(String updateBy) {
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
	public RepairOrderAcceptance setUpdateTime(Date updateTime) {
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
	public RepairOrderAcceptance setDeleted(Integer deleted) {
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
	public RepairOrderAcceptance setDeleted(Boolean deletedBool) {
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
	public RepairOrderAcceptance setDeleteBy(String deleteBy) {
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
	public RepairOrderAcceptance setDeleteTime(Date deleteTime) {
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
	public RepairOrderAcceptance setVersion(Integer version) {
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
	public RepairOrderAcceptance setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 申请单<br>
	 * 申请单
	 * @return 申请单
	*/
	public RepairOrder getOrder() {
		return order;
	}
	
	/**
	 * 设置 申请单
	 * @param order 申请单
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setOrder(RepairOrder order) {
		this.order=order;
		return this;
	}
	
	/**
	 * 获得 维修单<br>
	 * 维修单
	 * @return 维修单
	*/
	public RepairOrderAct getOrderAct() {
		return orderAct;
	}
	
	/**
	 * 设置 维修单
	 * @param orderAct 维修单
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setOrderAct(RepairOrderAct orderAct) {
		this.orderAct=orderAct;
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
	public RepairOrderAcceptance setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 验收人<br>
	 * 验收人
	 * @return 验收人
	*/
	public Employee getAccepter() {
		return accepter;
	}
	
	/**
	 * 设置 验收人
	 * @param accepter 验收人
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setAccepter(Employee accepter) {
		this.accepter=accepter;
		return this;
	}
	
	/**
	 * 获得 结果类型<br>
	 * 结果类型
	 * @return 结果类型
	*/
	public DictItem getResultTypeDict() {
		return resultTypeDict;
	}
	
	/**
	 * 设置 结果类型
	 * @param resultTypeDict 结果类型
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setResultTypeDict(DictItem resultTypeDict) {
		this.resultTypeDict=resultTypeDict;
		return this;
	}
	
	/**
	 * 获得 报修故障<br>
	 * 报修故障
	 * @return 报修故障
	*/
	public RepairCategoryTpl getCategoryTpl() {
		return categoryTpl;
	}
	
	/**
	 * 设置 报修故障
	 * @param categoryTpl 报修故障
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setCategoryTpl(RepairCategoryTpl categoryTpl) {
		this.categoryTpl=categoryTpl;
		return this;
	}
	
	/**
	 * 获得 订单名称<br>
	 * 订单名称
	 * @return 订单名称
	*/
	public String getOrderName() {
		return orderName;
	}
	
	/**
	 * 设置 订单名称
	 * @param orderName 订单名称
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setOrderName(String orderName) {
		this.orderName=orderName;
		return this;
	}
	
	/**
	 * 获得 订单编号<br>
	 * 订单编号
	 * @return 订单编号
	*/
	public String getOrderBusinessCode() {
		return orderBusinessCode;
	}
	
	/**
	 * 设置 订单编号
	 * @param orderBusinessCode 订单编号
	 * @return 当前对象
	*/
	public RepairOrderAcceptance setOrderBusinessCode(String orderBusinessCode) {
		this.orderBusinessCode=orderBusinessCode;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairOrderAcceptance , 转换好的 RepairOrderAcceptance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairOrderAcceptance , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 RepairOrderAcceptance
	 * @param repairOrderAcceptanceMap 包含实体信息的 Map 对象
	 * @return RepairOrderAcceptance , 转换好的的 RepairOrderAcceptance 对象
	*/
	@Transient
	public static RepairOrderAcceptance createFrom(Map<String,Object> repairOrderAcceptanceMap) {
		if(repairOrderAcceptanceMap==null) return null;
		RepairOrderAcceptance po = EntityContext.create(RepairOrderAcceptance.class, repairOrderAcceptanceMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairOrderAcceptance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairOrderAcceptance , 转换好的的 RepairOrderAcceptance 对象
	*/
	@Transient
	public static RepairOrderAcceptance createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairOrderAcceptance po = EntityContext.create(RepairOrderAcceptance.class,pojo);
		return po;
	}

	/**
	 * 创建一个 RepairOrderAcceptance，等同于 new
	 * @return RepairOrderAcceptance 对象
	*/
	@Transient
	public static RepairOrderAcceptance create() {
		return EntityContext.create(RepairOrderAcceptance.class);
	}
}