package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_NODE_LIST_VALUE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 节点列表数值
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:53
 * @sign D3FDF70A1984A31288B8B95934712149
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_node_list_value")
public class MonitorNodeListValue extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_NODE_LIST_VALUE.$TABLE;
	
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
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标")
	private String indicatorCode;
	
	/**
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版")
	private String monitorTplCode;
	
	/**
	 * 值类型：值类型
	*/
	@ApiModelProperty(required = false,value="值类型" , notes = "值类型")
	private String valueType;
	
	/**
	 * 标签1：标签1
	*/
	@ApiModelProperty(required = false,value="标签1" , notes = "标签1")
	private String label1;
	
	/**
	 * 标签2：标签2
	*/
	@ApiModelProperty(required = false,value="标签2" , notes = "标签2")
	private String label2;
	
	/**
	 * 标签3：标签3
	*/
	@ApiModelProperty(required = false,value="标签3" , notes = "标签3")
	private String label3;
	
	/**
	 * 编码1：编码1
	*/
	@ApiModelProperty(required = false,value="编码1" , notes = "编码1")
	private String code1;
	
	/**
	 * 编码2：编码2
	*/
	@ApiModelProperty(required = false,value="编码2" , notes = "编码2")
	private String code2;
	
	/**
	 * 数值1：数值1
	*/
	@ApiModelProperty(required = false,value="数值1" , notes = "数值1")
	private BigDecimal valueNumber1;
	
	/**
	 * 数值2：数值2
	*/
	@ApiModelProperty(required = false,value="数值2" , notes = "数值2")
	private BigDecimal valueNumber2;
	
	/**
	 * 数值3：数值3
	*/
	@ApiModelProperty(required = false,value="数值3" , notes = "数值3")
	private BigDecimal valueNumber3;
	
	/**
	 * 字符串1：字符串1
	*/
	@ApiModelProperty(required = false,value="字符串1" , notes = "字符串1")
	private String valueStr1;
	
	/**
	 * 字符串2：字符串2
	*/
	@ApiModelProperty(required = false,value="字符串2" , notes = "字符串2")
	private String valueStr2;
	
	/**
	 * 字符串3：字符串3
	*/
	@ApiModelProperty(required = false,value="字符串3" , notes = "字符串3")
	private String valueStr3;
	
	/**
	 * 唯一标识：唯一标识
	*/
	@ApiModelProperty(required = false,value="唯一标识" , notes = "唯一标识")
	private String uid;
	
	/**
	 * 信息：信息
	*/
	@ApiModelProperty(required = false,value="信息" , notes = "信息")
	private String info;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recordTime;
	
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
	public MonitorNodeListValue setId(String id) {
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
	public MonitorNodeListValue setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 指标<br>
	 * 指标
	 * @return 指标
	*/
	public String getIndicatorCode() {
		return indicatorCode;
	}
	
	/**
	 * 设置 指标
	 * @param indicatorCode 指标
	 * @return 当前对象
	*/
	public MonitorNodeListValue setIndicatorCode(String indicatorCode) {
		this.indicatorCode=indicatorCode;
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
	public MonitorNodeListValue setMonitorTplCode(String monitorTplCode) {
		this.monitorTplCode=monitorTplCode;
		return this;
	}
	
	/**
	 * 获得 值类型<br>
	 * 值类型
	 * @return 值类型
	*/
	public String getValueType() {
		return valueType;
	}
	
	/**
	 * 设置 值类型
	 * @param valueType 值类型
	 * @return 当前对象
	*/
	public MonitorNodeListValue setValueType(String valueType) {
		this.valueType=valueType;
		return this;
	}
	
	/**
	 * 获得 标签1<br>
	 * 标签1
	 * @return 标签1
	*/
	public String getLabel1() {
		return label1;
	}
	
	/**
	 * 设置 标签1
	 * @param label1 标签1
	 * @return 当前对象
	*/
	public MonitorNodeListValue setLabel1(String label1) {
		this.label1=label1;
		return this;
	}
	
	/**
	 * 获得 标签2<br>
	 * 标签2
	 * @return 标签2
	*/
	public String getLabel2() {
		return label2;
	}
	
	/**
	 * 设置 标签2
	 * @param label2 标签2
	 * @return 当前对象
	*/
	public MonitorNodeListValue setLabel2(String label2) {
		this.label2=label2;
		return this;
	}
	
	/**
	 * 获得 标签3<br>
	 * 标签3
	 * @return 标签3
	*/
	public String getLabel3() {
		return label3;
	}
	
	/**
	 * 设置 标签3
	 * @param label3 标签3
	 * @return 当前对象
	*/
	public MonitorNodeListValue setLabel3(String label3) {
		this.label3=label3;
		return this;
	}
	
	/**
	 * 获得 编码1<br>
	 * 编码1
	 * @return 编码1
	*/
	public String getCode1() {
		return code1;
	}
	
	/**
	 * 设置 编码1
	 * @param code1 编码1
	 * @return 当前对象
	*/
	public MonitorNodeListValue setCode1(String code1) {
		this.code1=code1;
		return this;
	}
	
	/**
	 * 获得 编码2<br>
	 * 编码2
	 * @return 编码2
	*/
	public String getCode2() {
		return code2;
	}
	
	/**
	 * 设置 编码2
	 * @param code2 编码2
	 * @return 当前对象
	*/
	public MonitorNodeListValue setCode2(String code2) {
		this.code2=code2;
		return this;
	}
	
	/**
	 * 获得 数值1<br>
	 * 数值1
	 * @return 数值1
	*/
	public BigDecimal getValueNumber1() {
		return valueNumber1;
	}
	
	/**
	 * 设置 数值1
	 * @param valueNumber1 数值1
	 * @return 当前对象
	*/
	public MonitorNodeListValue setValueNumber1(BigDecimal valueNumber1) {
		this.valueNumber1=valueNumber1;
		return this;
	}
	
	/**
	 * 获得 数值2<br>
	 * 数值2
	 * @return 数值2
	*/
	public BigDecimal getValueNumber2() {
		return valueNumber2;
	}
	
	/**
	 * 设置 数值2
	 * @param valueNumber2 数值2
	 * @return 当前对象
	*/
	public MonitorNodeListValue setValueNumber2(BigDecimal valueNumber2) {
		this.valueNumber2=valueNumber2;
		return this;
	}
	
	/**
	 * 获得 数值3<br>
	 * 数值3
	 * @return 数值3
	*/
	public BigDecimal getValueNumber3() {
		return valueNumber3;
	}
	
	/**
	 * 设置 数值3
	 * @param valueNumber3 数值3
	 * @return 当前对象
	*/
	public MonitorNodeListValue setValueNumber3(BigDecimal valueNumber3) {
		this.valueNumber3=valueNumber3;
		return this;
	}
	
	/**
	 * 获得 字符串1<br>
	 * 字符串1
	 * @return 字符串1
	*/
	public String getValueStr1() {
		return valueStr1;
	}
	
	/**
	 * 设置 字符串1
	 * @param valueStr1 字符串1
	 * @return 当前对象
	*/
	public MonitorNodeListValue setValueStr1(String valueStr1) {
		this.valueStr1=valueStr1;
		return this;
	}
	
	/**
	 * 获得 字符串2<br>
	 * 字符串2
	 * @return 字符串2
	*/
	public String getValueStr2() {
		return valueStr2;
	}
	
	/**
	 * 设置 字符串2
	 * @param valueStr2 字符串2
	 * @return 当前对象
	*/
	public MonitorNodeListValue setValueStr2(String valueStr2) {
		this.valueStr2=valueStr2;
		return this;
	}
	
	/**
	 * 获得 字符串3<br>
	 * 字符串3
	 * @return 字符串3
	*/
	public String getValueStr3() {
		return valueStr3;
	}
	
	/**
	 * 设置 字符串3
	 * @param valueStr3 字符串3
	 * @return 当前对象
	*/
	public MonitorNodeListValue setValueStr3(String valueStr3) {
		this.valueStr3=valueStr3;
		return this;
	}
	
	/**
	 * 获得 唯一标识<br>
	 * 唯一标识
	 * @return 唯一标识
	*/
	public String getUid() {
		return uid;
	}
	
	/**
	 * 设置 唯一标识
	 * @param uid 唯一标识
	 * @return 当前对象
	*/
	public MonitorNodeListValue setUid(String uid) {
		this.uid=uid;
		return this;
	}
	
	/**
	 * 获得 信息<br>
	 * 信息
	 * @return 信息
	*/
	public String getInfo() {
		return info;
	}
	
	/**
	 * 设置 信息
	 * @param info 信息
	 * @return 当前对象
	*/
	public MonitorNodeListValue setInfo(String info) {
		this.info=info;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public MonitorNodeListValue setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public MonitorNodeListValue setCreateBy(String createBy) {
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
	public MonitorNodeListValue setCreateTime(Date createTime) {
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
	public MonitorNodeListValue setUpdateBy(String updateBy) {
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
	public MonitorNodeListValue setUpdateTime(Date updateTime) {
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
	public MonitorNodeListValue setDeleted(Integer deleted) {
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
	public MonitorNodeListValue setDeleteBy(String deleteBy) {
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
	public MonitorNodeListValue setDeleteTime(Date deleteTime) {
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
	public MonitorNodeListValue setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorNodeListValue , 转换好的 MonitorNodeListValue 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeListValue , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorNodeListValue
	 * @param monitorNodeListValueMap 包含实体信息的 Map 对象
	 * @return MonitorNodeListValue , 转换好的的 MonitorNodeListValue 对象
	*/
	@Transient
	public static MonitorNodeListValue createFrom(Map<String,Object> monitorNodeListValueMap) {
		if(monitorNodeListValueMap==null) return null;
		MonitorNodeListValue po = EntityContext.create(MonitorNodeListValue.class, monitorNodeListValueMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeListValue
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeListValue , 转换好的的 MonitorNodeListValue 对象
	*/
	@Transient
	public static MonitorNodeListValue createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeListValue po = EntityContext.create(MonitorNodeListValue.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorNodeListValue，等同于 new
	 * @return MonitorNodeListValue 对象
	*/
	@Transient
	public static MonitorNodeListValue create() {
		return EntityContext.create(MonitorNodeListValue.class);
	}
}