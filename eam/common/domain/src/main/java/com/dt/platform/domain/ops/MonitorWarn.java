package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_WARN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 节点告警
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:57
 * @sign AF2D1B9440B00EA6B31537770BFD2D84
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_warn")
public class MonitorWarn extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_WARN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点")
	private String nodeId;
	
	/**
	 * 监控数值：监控数值
	*/
	@ApiModelProperty(required = false,value="监控数值" , notes = "监控数值")
	private String nodeValueId;
	
	/**
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版")
	private String monitorTplCode;
	
	/**
	 * 监控指标：监控指标
	*/
	@ApiModelProperty(required = false,value="监控指标" , notes = "监控指标")
	private String indicatorCode;
	
	/**
	 * 指标名称：指标名称
	*/
	@ApiModelProperty(required = false,value="指标名称" , notes = "指标名称")
	private String indicatorName;
	
	/**
	 * 告警等级：告警等级
	*/
	@ApiModelProperty(required = false,value="告警等级" , notes = "告警等级")
	private String warnLevel;
	
	/**
	 * 处理状态：处理状态
	*/
	@ApiModelProperty(required = false,value="处理状态" , notes = "处理状态")
	private String status;
	
	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间")
	private Date handledTime;
	
	/**
	 * 告警时间：告警时间
	*/
	@ApiModelProperty(required = false,value="告警时间" , notes = "告警时间")
	private Date warnTime;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
	/**
	 * 节点模版：节点模版
	*/
	@ApiModelProperty(required = false,value="节点模版" , notes = "节点模版")
	private MonitorTpl tpl;
	
	/**
	 * 节点指标：节点指标
	*/
	@ApiModelProperty(required = false,value="节点指标" , notes = "节点指标")
	private List<MonitorTplIndicator> tplIndicator;
	
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
	public MonitorWarn setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 节点<br>
	 * 节点
	 * @return 节点
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点
	 * @param nodeId 节点
	 * @return 当前对象
	*/
	public MonitorWarn setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 监控数值<br>
	 * 监控数值
	 * @return 监控数值
	*/
	public String getNodeValueId() {
		return nodeValueId;
	}
	
	/**
	 * 设置 监控数值
	 * @param nodeValueId 监控数值
	 * @return 当前对象
	*/
	public MonitorWarn setNodeValueId(String nodeValueId) {
		this.nodeValueId=nodeValueId;
		return this;
	}
	
	/**
	 * 获得 监控模版<br>
	 * 监控模版
	 * @return 监控模版
	*/
	public String getMonitorTplCode() {
		return monitorTplCode;
	}
	
	/**
	 * 设置 监控模版
	 * @param monitorTplCode 监控模版
	 * @return 当前对象
	*/
	public MonitorWarn setMonitorTplCode(String monitorTplCode) {
		this.monitorTplCode=monitorTplCode;
		return this;
	}
	
	/**
	 * 获得 监控指标<br>
	 * 监控指标
	 * @return 监控指标
	*/
	public String getIndicatorCode() {
		return indicatorCode;
	}
	
	/**
	 * 设置 监控指标
	 * @param indicatorCode 监控指标
	 * @return 当前对象
	*/
	public MonitorWarn setIndicatorCode(String indicatorCode) {
		this.indicatorCode=indicatorCode;
		return this;
	}
	
	/**
	 * 获得 指标名称<br>
	 * 指标名称
	 * @return 指标名称
	*/
	public String getIndicatorName() {
		return indicatorName;
	}
	
	/**
	 * 设置 指标名称
	 * @param indicatorName 指标名称
	 * @return 当前对象
	*/
	public MonitorWarn setIndicatorName(String indicatorName) {
		this.indicatorName=indicatorName;
		return this;
	}
	
	/**
	 * 获得 告警等级<br>
	 * 告警等级
	 * @return 告警等级
	*/
	public String getWarnLevel() {
		return warnLevel;
	}
	
	/**
	 * 设置 告警等级
	 * @param warnLevel 告警等级
	 * @return 当前对象
	*/
	public MonitorWarn setWarnLevel(String warnLevel) {
		this.warnLevel=warnLevel;
		return this;
	}
	
	/**
	 * 获得 处理状态<br>
	 * 处理状态
	 * @return 处理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 处理状态
	 * @param status 处理状态
	 * @return 当前对象
	*/
	public MonitorWarn setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 处理时间<br>
	 * 处理时间
	 * @return 处理时间
	*/
	public Date getHandledTime() {
		return handledTime;
	}
	
	/**
	 * 设置 处理时间
	 * @param handledTime 处理时间
	 * @return 当前对象
	*/
	public MonitorWarn setHandledTime(Date handledTime) {
		this.handledTime=handledTime;
		return this;
	}
	
	/**
	 * 获得 告警时间<br>
	 * 告警时间
	 * @return 告警时间
	*/
	public Date getWarnTime() {
		return warnTime;
	}
	
	/**
	 * 设置 告警时间
	 * @param warnTime 告警时间
	 * @return 当前对象
	*/
	public MonitorWarn setWarnTime(Date warnTime) {
		this.warnTime=warnTime;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public MonitorWarn setContent(String content) {
		this.content=content;
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
	public MonitorWarn setNotes(String notes) {
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
	public MonitorWarn setCreateBy(String createBy) {
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
	public MonitorWarn setCreateTime(Date createTime) {
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
	public MonitorWarn setUpdateBy(String updateBy) {
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
	public MonitorWarn setUpdateTime(Date updateTime) {
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
	public MonitorWarn setDeleted(Integer deleted) {
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
	public MonitorWarn setDeleteBy(String deleteBy) {
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
	public MonitorWarn setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public MonitorWarn setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 节点模版<br>
	 * 节点模版
	 * @return 节点模版
	*/
	public MonitorTpl getTpl() {
		return tpl;
	}
	
	/**
	 * 设置 节点模版
	 * @param tpl 节点模版
	 * @return 当前对象
	*/
	public MonitorWarn setTpl(MonitorTpl tpl) {
		this.tpl=tpl;
		return this;
	}
	
	/**
	 * 获得 节点指标<br>
	 * 节点指标
	 * @return 节点指标
	*/
	public List<MonitorTplIndicator> getTplIndicator() {
		return tplIndicator;
	}
	
	/**
	 * 设置 节点指标
	 * @param tplIndicator 节点指标
	 * @return 当前对象
	*/
	public MonitorWarn setTplIndicator(List<MonitorTplIndicator> tplIndicator) {
		this.tplIndicator=tplIndicator;
		return this;
	}
	
	/**
	 * 添加 节点指标
	 * @param entity 节点指标
	 * @return 当前对象
	*/
	public MonitorWarn addTplIndicator(MonitorTplIndicator entity) {
		if(this.tplIndicator==null) tplIndicator=new ArrayList<>();
		this.tplIndicator.add(entity);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorWarn , 转换好的 MonitorWarn 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorWarn , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorWarn
	 * @param monitorWarnMap 包含实体信息的 Map 对象
	 * @return MonitorWarn , 转换好的的 MonitorWarn 对象
	*/
	@Transient
	public static MonitorWarn createFrom(Map<String,Object> monitorWarnMap) {
		if(monitorWarnMap==null) return null;
		MonitorWarn po = EntityContext.create(MonitorWarn.class, monitorWarnMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorWarn
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorWarn , 转换好的的 MonitorWarn 对象
	*/
	@Transient
	public static MonitorWarn createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorWarn po = EntityContext.create(MonitorWarn.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorWarn，等同于 new
	 * @return MonitorWarn 对象
	*/
	@Transient
	public static MonitorWarn create() {
		return EntityContext.create(MonitorWarn.class);
	}
}