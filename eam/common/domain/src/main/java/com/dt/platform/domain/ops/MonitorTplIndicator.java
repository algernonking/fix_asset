package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_MONITOR_TPL_INDICATOR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 模版指标
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-20 12:42:51
 * @sign B77DCC56FC19491081164BDC55DF7BB9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_tpl_indicator")
public class MonitorTplIndicator extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_TPL_INDICATOR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版")
	private String monitorTplCode;
	
	/**
	 * 监控方式：监控方式
	*/
	@ApiModelProperty(required = false,value="监控方式" , notes = "监控方式")
	private String monitorMethod;
	
	/**
	 * 指标类型：指标类型
	*/
	@ApiModelProperty(required = false,value="指标类型" , notes = "指标类型")
	private String indicatorType;
	
	/**
	 * 值行数：值行数
	*/
	@ApiModelProperty(required = false,value="值行数" , notes = "值行数")
	private String valueColumnRows;
	
	/**
	 * 值列数：值列数
	*/
	@ApiModelProperty(required = false,value="值列数" , notes = "值列数")
	private String valueColumnCols;
	
	/**
	 * 数值类型：数值类型
	*/
	@ApiModelProperty(required = false,value="数值类型" , notes = "数值类型")
	private String valueColumnType;
	
	/**
	 * 数值字段：数值字段
	*/
	@ApiModelProperty(required = false,value="数值字段" , notes = "数值字段")
	private String valueColumn;
	
	/**
	 * 数值字段映射：数值字段映射
	*/
	@ApiModelProperty(required = false,value="数值字段映射" , notes = "数值字段映射")
	private String valueColumnMap;
	
	/**
	 * 字段名称：字段名称
	*/
	@ApiModelProperty(required = false,value="字段名称" , notes = "字段名称")
	private String valueColumnName;
	
	/**
	 * 超时(秒)：超时(秒)
	*/
	@ApiModelProperty(required = false,value="超时(秒)" , notes = "超时(秒)")
	private Integer timeOut;
	
	/**
	 * 间隔时间(秒）：间隔时间(秒）
	*/
	@ApiModelProperty(required = false,value="间隔时间(秒）" , notes = "间隔时间(秒）")
	private Integer intervalTime;
	
	/**
	 * 数据保留天数：数据保留天数
	*/
	@ApiModelProperty(required = false,value="数据保留天数" , notes = "数据保留天数")
	private Integer dataKeepDay;
	
	/**
	 * 命令：命令
	*/
	@ApiModelProperty(required = false,value="命令" , notes = "命令")
	private String command;
	
	/**
	 * command_value：command_value
	*/
	@ApiModelProperty(required = false,value="command_value" , notes = "command_value")
	private String commandValue;
	
	/**
	 * 变量：变量
	*/
	@ApiModelProperty(required = false,value="变量" , notes = "变量")
	private String indicatorVariable;
	
	/**
	 * snmp元数据：snmp元数据
	*/
	@ApiModelProperty(required = false,value="snmp元数据" , notes = "snmp元数据")
	private String snmpOid;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer itemSort;
	
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
	 * 指标类型：指标类型
	*/
	@ApiModelProperty(required = false,value="指标类型" , notes = "指标类型")
	private MonitorTplIndicatorType monitorIndicatorType;
	
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
	public MonitorTplIndicator setId(String id) {
		this.id=id;
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
	public MonitorTplIndicator setStatus(String status) {
		this.status=status;
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
	public MonitorTplIndicator setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public MonitorTplIndicator setCode(String code) {
		this.code=code;
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
	public MonitorTplIndicator setMonitorTplCode(String monitorTplCode) {
		this.monitorTplCode=monitorTplCode;
		return this;
	}
	
	/**
	 * 获得 监控方式<br>
	 * 监控方式
	 * @return 监控方式
	*/
	public String getMonitorMethod() {
		return monitorMethod;
	}
	
	/**
	 * 设置 监控方式
	 * @param monitorMethod 监控方式
	 * @return 当前对象
	*/
	public MonitorTplIndicator setMonitorMethod(String monitorMethod) {
		this.monitorMethod=monitorMethod;
		return this;
	}
	
	/**
	 * 获得 指标类型<br>
	 * 指标类型
	 * @return 指标类型
	*/
	public String getIndicatorType() {
		return indicatorType;
	}
	
	/**
	 * 设置 指标类型
	 * @param indicatorType 指标类型
	 * @return 当前对象
	*/
	public MonitorTplIndicator setIndicatorType(String indicatorType) {
		this.indicatorType=indicatorType;
		return this;
	}
	
	/**
	 * 获得 值行数<br>
	 * 值行数
	 * @return 值行数
	*/
	public String getValueColumnRows() {
		return valueColumnRows;
	}
	
	/**
	 * 设置 值行数
	 * @param valueColumnRows 值行数
	 * @return 当前对象
	*/
	public MonitorTplIndicator setValueColumnRows(String valueColumnRows) {
		this.valueColumnRows=valueColumnRows;
		return this;
	}
	
	/**
	 * 获得 值列数<br>
	 * 值列数
	 * @return 值列数
	*/
	public String getValueColumnCols() {
		return valueColumnCols;
	}
	
	/**
	 * 设置 值列数
	 * @param valueColumnCols 值列数
	 * @return 当前对象
	*/
	public MonitorTplIndicator setValueColumnCols(String valueColumnCols) {
		this.valueColumnCols=valueColumnCols;
		return this;
	}
	
	/**
	 * 获得 数值类型<br>
	 * 数值类型
	 * @return 数值类型
	*/
	public String getValueColumnType() {
		return valueColumnType;
	}
	
	/**
	 * 设置 数值类型
	 * @param valueColumnType 数值类型
	 * @return 当前对象
	*/
	public MonitorTplIndicator setValueColumnType(String valueColumnType) {
		this.valueColumnType=valueColumnType;
		return this;
	}
	
	/**
	 * 获得 数值字段<br>
	 * 数值字段
	 * @return 数值字段
	*/
	public String getValueColumn() {
		return valueColumn;
	}
	
	/**
	 * 设置 数值字段
	 * @param valueColumn 数值字段
	 * @return 当前对象
	*/
	public MonitorTplIndicator setValueColumn(String valueColumn) {
		this.valueColumn=valueColumn;
		return this;
	}
	
	/**
	 * 获得 数值字段映射<br>
	 * 数值字段映射
	 * @return 数值字段映射
	*/
	public String getValueColumnMap() {
		return valueColumnMap;
	}
	
	/**
	 * 设置 数值字段映射
	 * @param valueColumnMap 数值字段映射
	 * @return 当前对象
	*/
	public MonitorTplIndicator setValueColumnMap(String valueColumnMap) {
		this.valueColumnMap=valueColumnMap;
		return this;
	}
	
	/**
	 * 获得 字段名称<br>
	 * 字段名称
	 * @return 字段名称
	*/
	public String getValueColumnName() {
		return valueColumnName;
	}
	
	/**
	 * 设置 字段名称
	 * @param valueColumnName 字段名称
	 * @return 当前对象
	*/
	public MonitorTplIndicator setValueColumnName(String valueColumnName) {
		this.valueColumnName=valueColumnName;
		return this;
	}
	
	/**
	 * 获得 超时(秒)<br>
	 * 超时(秒)
	 * @return 超时(秒)
	*/
	public Integer getTimeOut() {
		return timeOut;
	}
	
	/**
	 * 设置 超时(秒)
	 * @param timeOut 超时(秒)
	 * @return 当前对象
	*/
	public MonitorTplIndicator setTimeOut(Integer timeOut) {
		this.timeOut=timeOut;
		return this;
	}
	
	/**
	 * 获得 间隔时间(秒）<br>
	 * 间隔时间(秒）
	 * @return 间隔时间(秒）
	*/
	public Integer getIntervalTime() {
		return intervalTime;
	}
	
	/**
	 * 设置 间隔时间(秒）
	 * @param intervalTime 间隔时间(秒）
	 * @return 当前对象
	*/
	public MonitorTplIndicator setIntervalTime(Integer intervalTime) {
		this.intervalTime=intervalTime;
		return this;
	}
	
	/**
	 * 获得 数据保留天数<br>
	 * 数据保留天数
	 * @return 数据保留天数
	*/
	public Integer getDataKeepDay() {
		return dataKeepDay;
	}
	
	/**
	 * 设置 数据保留天数
	 * @param dataKeepDay 数据保留天数
	 * @return 当前对象
	*/
	public MonitorTplIndicator setDataKeepDay(Integer dataKeepDay) {
		this.dataKeepDay=dataKeepDay;
		return this;
	}
	
	/**
	 * 获得 命令<br>
	 * 命令
	 * @return 命令
	*/
	public String getCommand() {
		return command;
	}
	
	/**
	 * 设置 命令
	 * @param command 命令
	 * @return 当前对象
	*/
	public MonitorTplIndicator setCommand(String command) {
		this.command=command;
		return this;
	}
	
	/**
	 * 获得 command_value<br>
	 * command_value
	 * @return command_value
	*/
	public String getCommandValue() {
		return commandValue;
	}
	
	/**
	 * 设置 command_value
	 * @param commandValue command_value
	 * @return 当前对象
	*/
	public MonitorTplIndicator setCommandValue(String commandValue) {
		this.commandValue=commandValue;
		return this;
	}
	
	/**
	 * 获得 变量<br>
	 * 变量
	 * @return 变量
	*/
	public String getIndicatorVariable() {
		return indicatorVariable;
	}
	
	/**
	 * 设置 变量
	 * @param indicatorVariable 变量
	 * @return 当前对象
	*/
	public MonitorTplIndicator setIndicatorVariable(String indicatorVariable) {
		this.indicatorVariable=indicatorVariable;
		return this;
	}
	
	/**
	 * 获得 snmp元数据<br>
	 * snmp元数据
	 * @return snmp元数据
	*/
	public String getSnmpOid() {
		return snmpOid;
	}
	
	/**
	 * 设置 snmp元数据
	 * @param snmpOid snmp元数据
	 * @return 当前对象
	*/
	public MonitorTplIndicator setSnmpOid(String snmpOid) {
		this.snmpOid=snmpOid;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public MonitorTplIndicator setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getItemSort() {
		return itemSort;
	}
	
	/**
	 * 设置 排序
	 * @param itemSort 排序
	 * @return 当前对象
	*/
	public MonitorTplIndicator setItemSort(Integer itemSort) {
		this.itemSort=itemSort;
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
	public MonitorTplIndicator setNotes(String notes) {
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
	public MonitorTplIndicator setCreateBy(String createBy) {
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
	public MonitorTplIndicator setCreateTime(Date createTime) {
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
	public MonitorTplIndicator setUpdateBy(String updateBy) {
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
	public MonitorTplIndicator setUpdateTime(Date updateTime) {
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
	public MonitorTplIndicator setDeleted(Integer deleted) {
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
	public MonitorTplIndicator setDeleteBy(String deleteBy) {
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
	public MonitorTplIndicator setDeleteTime(Date deleteTime) {
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
	public MonitorTplIndicator setVersion(Integer version) {
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
	public MonitorTplIndicator setTpl(MonitorTpl tpl) {
		this.tpl=tpl;
		return this;
	}
	
	/**
	 * 获得 指标类型<br>
	 * 指标类型
	 * @return 指标类型
	*/
	public MonitorTplIndicatorType getMonitorIndicatorType() {
		return monitorIndicatorType;
	}
	
	/**
	 * 设置 指标类型
	 * @param monitorIndicatorType 指标类型
	 * @return 当前对象
	*/
	public MonitorTplIndicator setMonitorIndicatorType(MonitorTplIndicatorType monitorIndicatorType) {
		this.monitorIndicatorType=monitorIndicatorType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorTplIndicator , 转换好的 MonitorTplIndicator 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorTplIndicator , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorTplIndicator
	 * @param monitorTplIndicatorMap 包含实体信息的 Map 对象
	 * @return MonitorTplIndicator , 转换好的的 MonitorTplIndicator 对象
	*/
	@Transient
	public static MonitorTplIndicator createFrom(Map<String,Object> monitorTplIndicatorMap) {
		if(monitorTplIndicatorMap==null) return null;
		MonitorTplIndicator po = EntityContext.create(MonitorTplIndicator.class, monitorTplIndicatorMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorTplIndicator
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorTplIndicator , 转换好的的 MonitorTplIndicator 对象
	*/
	@Transient
	public static MonitorTplIndicator createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorTplIndicator po = EntityContext.create(MonitorTplIndicator.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorTplIndicator，等同于 new
	 * @return MonitorTplIndicator 对象
	*/
	@Transient
	public static MonitorTplIndicator create() {
		return EntityContext.create(MonitorTplIndicator.class);
	}
}