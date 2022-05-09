package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_NODE_VALUE_LAST;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 节点数值最新
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-20 14:46:45
 * @sign C1EFBF496424B39321E11194893D81C6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_node_value_last")
public class MonitorNodeValueLast extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_NODE_VALUE_LAST.$TABLE;
	
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
	 * 监控模版：监控模版
	*/
	@ApiModelProperty(required = false,value="监控模版" , notes = "监控模版")
	private String monitorTplCode;
	
	/**
	 * 结果状态：结果状态
	*/
	@ApiModelProperty(required = false,value="结果状态" , notes = "结果状态")
	private String resultStatus;
	
	/**
	 * 结果内容：结果内容
	*/
	@ApiModelProperty(required = false,value="结果内容" , notes = "结果内容")
	private String resultMessage;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标")
	private String indicatorCode;
	
	/**
	 * 主机名称：主机名称
	*/
	@ApiModelProperty(required = false,value="主机名称" , notes = "主机名称")
	private String hostname;
	
	/**
	 * 系统时间：系统时间
	*/
	@ApiModelProperty(required = false,value="系统时间" , notes = "系统时间")
	private String osDatetime;
	
	/**
	 * 启动时间：启动时间
	*/
	@ApiModelProperty(required = false,value="启动时间" , notes = "启动时间")
	private Date boottime;
	
	/**
	 * 系统：系统
	*/
	@ApiModelProperty(required = false,value="系统" , notes = "系统")
	private String osVerion;
	
	/**
	 * 架构：架构
	*/
	@ApiModelProperty(required = false,value="架构" , notes = "架构")
	private String arch;
	
	/**
	 * CPU数量：CPU数量
	*/
	@ApiModelProperty(required = false,value="CPU数量" , notes = "CPU数量")
	private Integer cpuNumber;
	
	/**
	 * CPU主频：CPU主频
	*/
	@ApiModelProperty(required = false,value="CPU主频" , notes = "CPU主频")
	private BigDecimal cpuFree;
	
	/**
	 * cpuSys：cpuSys
	*/
	@ApiModelProperty(required = false,value="cpuSys" , notes = "cpuSys")
	private BigDecimal cpuSys;
	
	/**
	 * cpuUser：cpuUser
	*/
	@ApiModelProperty(required = false,value="cpuUser" , notes = "cpuUser")
	private BigDecimal cpuUser;
	
	/**
	 * cpuWait：cpuWait
	*/
	@ApiModelProperty(required = false,value="cpuWait" , notes = "cpuWait")
	private BigDecimal cpuWait;
	
	/**
	 * CPU空闲旅：CPU空闲旅
	*/
	@ApiModelProperty(required = false,value="CPU空闲旅" , notes = "CPU空闲旅")
	private BigDecimal cpuIdle;
	
	/**
	 * CPU使用率：CPU使用率
	*/
	@ApiModelProperty(required = false,value="CPU使用率" , notes = "CPU使用率")
	private BigDecimal cpuUsed;
	
	/**
	 * 系统负载：系统负载
	*/
	@ApiModelProperty(required = false,value="系统负载" , notes = "系统负载")
	private BigDecimal osLoad;
	
	/**
	 * 系统负载5：系统负载5
	*/
	@ApiModelProperty(required = false,value="系统负载5" , notes = "系统负载5")
	private BigDecimal osLoad5;
	
	/**
	 * 系统负载15：系统负载15
	*/
	@ApiModelProperty(required = false,value="系统负载15" , notes = "系统负载15")
	private BigDecimal osLoad15;
	
	/**
	 * 上行流量：上行流量
	*/
	@ApiModelProperty(required = false,value="上行流量" , notes = "上行流量")
	private BigDecimal networkFlowUp;
	
	/**
	 * 下流量：下流量
	*/
	@ApiModelProperty(required = false,value="下流量" , notes = "下流量")
	private BigDecimal networkFlowDown;
	
	/**
	 * 连接数：连接数
	*/
	@ApiModelProperty(required = false,value="连接数" , notes = "连接数")
	private Integer processCnt;
	
	/**
	 * 物理内存(M)：物理内存(M)
	*/
	@ApiModelProperty(required = false,value="物理内存(M)" , notes = "物理内存(M)")
	private Long pMemorySize;
	
	/**
	 * 虚拟内存(M)：虚拟内存(M)
	*/
	@ApiModelProperty(required = false,value="虚拟内存(M)" , notes = "虚拟内存(M)")
	private Long vMemorySize;
	
	/**
	 * 物理内存使用率：物理内存使用率
	*/
	@ApiModelProperty(required = false,value="物理内存使用率" , notes = "物理内存使用率")
	private Long pMemoryUsed;
	
	/**
	 * 虚拟内存使用率：虚拟内存使用率
	*/
	@ApiModelProperty(required = false,value="虚拟内存使用率" , notes = "虚拟内存使用率")
	private Long vMemoryUsed;
	
	/**
	 * 信息：信息
	*/
	@ApiModelProperty(required = false,value="信息" , notes = "信息")
	private String info;
	
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
	 * 编码3：编码3
	*/
	@ApiModelProperty(required = false,value="编码3" , notes = "编码3")
	private String code3;
	
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
	 * 整数1：整数1
	*/
	@ApiModelProperty(required = false,value="整数1" , notes = "整数1")
	private Long valueInt1;
	
	/**
	 * 整数2：整数2
	*/
	@ApiModelProperty(required = false,value="整数2" , notes = "整数2")
	private Long valueInt2;
	
	/**
	 * 整数3：整数3
	*/
	@ApiModelProperty(required = false,value="整数3" , notes = "整数3")
	private Long valueInt3;
	
	/**
	 * 标签列1：标签列1
	*/
	@ApiModelProperty(required = false,value="标签列1" , notes = "标签列1")
	private String listLabel1;
	
	/**
	 * 标签列2：标签列2
	*/
	@ApiModelProperty(required = false,value="标签列2" , notes = "标签列2")
	private String listLabel2;
	
	/**
	 * 标签列3：标签列3
	*/
	@ApiModelProperty(required = false,value="标签列3" , notes = "标签列3")
	private String listLabel3;
	
	/**
	 * 编码列1：编码列1
	*/
	@ApiModelProperty(required = false,value="编码列1" , notes = "编码列1")
	private String listCode1;
	
	/**
	 * 编码列2：编码列2
	*/
	@ApiModelProperty(required = false,value="编码列2" , notes = "编码列2")
	private String listCode2;
	
	/**
	 * 编码列3：编码列3
	*/
	@ApiModelProperty(required = false,value="编码列3" , notes = "编码列3")
	private String listCode3;
	
	/**
	 * 数值列1：数值列1
	*/
	@ApiModelProperty(required = false,value="数值列1" , notes = "数值列1")
	private BigDecimal listValueNumber1;
	
	/**
	 * 数值列2：数值列2
	*/
	@ApiModelProperty(required = false,value="数值列2" , notes = "数值列2")
	private BigDecimal listValueNumber2;
	
	/**
	 * 数值列3：数值列3
	*/
	@ApiModelProperty(required = false,value="数值列3" , notes = "数值列3")
	private BigDecimal listValueNumber3;
	
	/**
	 * 字符串列1：字符串列1
	*/
	@ApiModelProperty(required = false,value="字符串列1" , notes = "字符串列1")
	private String listValueStr1;
	
	/**
	 * 字符串列2：字符串列2
	*/
	@ApiModelProperty(required = false,value="字符串列2" , notes = "字符串列2")
	private String listValueStr2;
	
	/**
	 * 字符串列3：字符串列3
	*/
	@ApiModelProperty(required = false,value="字符串列3" , notes = "字符串列3")
	private String listValueStr3;
	
	/**
	 * 整数列1：整数列1
	*/
	@ApiModelProperty(required = false,value="整数列1" , notes = "整数列1")
	private Long listValueInt1;
	
	/**
	 * 整数列2：整数列2
	*/
	@ApiModelProperty(required = false,value="整数列2" , notes = "整数列2")
	private Long listValueInt2;
	
	/**
	 * 整数列3：整数列3
	*/
	@ApiModelProperty(required = false,value="整数列3" , notes = "整数列3")
	private Long listValueInt3;
	
	/**
	 * 唯一标识：唯一标识
	*/
	@ApiModelProperty(required = false,value="唯一标识" , notes = "唯一标识")
	private String uid;
	
	/**
	 * 是否连接：是否连接
	*/
	@ApiModelProperty(required = false,value="是否连接" , notes = "是否连接")
	private Integer isConnected;
	
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
	public MonitorNodeValueLast setId(String id) {
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
	public MonitorNodeValueLast setNodeId(String nodeId) {
		this.nodeId=nodeId;
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
	public MonitorNodeValueLast setMonitorTplCode(String monitorTplCode) {
		this.monitorTplCode=monitorTplCode;
		return this;
	}
	
	/**
	 * 获得 结果状态<br>
	 * 结果状态
	 * @return 结果状态
	*/
	public String getResultStatus() {
		return resultStatus;
	}
	
	/**
	 * 设置 结果状态
	 * @param resultStatus 结果状态
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setResultStatus(String resultStatus) {
		this.resultStatus=resultStatus;
		return this;
	}
	
	/**
	 * 获得 结果内容<br>
	 * 结果内容
	 * @return 结果内容
	*/
	public String getResultMessage() {
		return resultMessage;
	}
	
	/**
	 * 设置 结果内容
	 * @param resultMessage 结果内容
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setResultMessage(String resultMessage) {
		this.resultMessage=resultMessage;
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
	public MonitorNodeValueLast setIndicatorCode(String indicatorCode) {
		this.indicatorCode=indicatorCode;
		return this;
	}
	
	/**
	 * 获得 主机名称<br>
	 * 主机名称
	 * @return 主机名称
	*/
	public String getHostname() {
		return hostname;
	}
	
	/**
	 * 设置 主机名称
	 * @param hostname 主机名称
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setHostname(String hostname) {
		this.hostname=hostname;
		return this;
	}
	
	/**
	 * 获得 系统时间<br>
	 * 系统时间
	 * @return 系统时间
	*/
	public String getOsDatetime() {
		return osDatetime;
	}
	
	/**
	 * 设置 系统时间
	 * @param osDatetime 系统时间
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setOsDatetime(String osDatetime) {
		this.osDatetime=osDatetime;
		return this;
	}
	
	/**
	 * 获得 启动时间<br>
	 * 启动时间
	 * @return 启动时间
	*/
	public Date getBoottime() {
		return boottime;
	}
	
	/**
	 * 设置 启动时间
	 * @param boottime 启动时间
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setBoottime(Date boottime) {
		this.boottime=boottime;
		return this;
	}
	
	/**
	 * 获得 系统<br>
	 * 系统
	 * @return 系统
	*/
	public String getOsVerion() {
		return osVerion;
	}
	
	/**
	 * 设置 系统
	 * @param osVerion 系统
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setOsVerion(String osVerion) {
		this.osVerion=osVerion;
		return this;
	}
	
	/**
	 * 获得 架构<br>
	 * 架构
	 * @return 架构
	*/
	public String getArch() {
		return arch;
	}
	
	/**
	 * 设置 架构
	 * @param arch 架构
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setArch(String arch) {
		this.arch=arch;
		return this;
	}
	
	/**
	 * 获得 CPU数量<br>
	 * CPU数量
	 * @return CPU数量
	*/
	public Integer getCpuNumber() {
		return cpuNumber;
	}
	
	/**
	 * 设置 CPU数量
	 * @param cpuNumber CPU数量
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCpuNumber(Integer cpuNumber) {
		this.cpuNumber=cpuNumber;
		return this;
	}
	
	/**
	 * 获得 CPU主频<br>
	 * CPU主频
	 * @return CPU主频
	*/
	public BigDecimal getCpuFree() {
		return cpuFree;
	}
	
	/**
	 * 设置 CPU主频
	 * @param cpuFree CPU主频
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCpuFree(BigDecimal cpuFree) {
		this.cpuFree=cpuFree;
		return this;
	}
	
	/**
	 * 获得 cpuSys<br>
	 * cpuSys
	 * @return cpuSys
	*/
	public BigDecimal getCpuSys() {
		return cpuSys;
	}
	
	/**
	 * 设置 cpuSys
	 * @param cpuSys cpuSys
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCpuSys(BigDecimal cpuSys) {
		this.cpuSys=cpuSys;
		return this;
	}
	
	/**
	 * 获得 cpuUser<br>
	 * cpuUser
	 * @return cpuUser
	*/
	public BigDecimal getCpuUser() {
		return cpuUser;
	}
	
	/**
	 * 设置 cpuUser
	 * @param cpuUser cpuUser
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCpuUser(BigDecimal cpuUser) {
		this.cpuUser=cpuUser;
		return this;
	}
	
	/**
	 * 获得 cpuWait<br>
	 * cpuWait
	 * @return cpuWait
	*/
	public BigDecimal getCpuWait() {
		return cpuWait;
	}
	
	/**
	 * 设置 cpuWait
	 * @param cpuWait cpuWait
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCpuWait(BigDecimal cpuWait) {
		this.cpuWait=cpuWait;
		return this;
	}
	
	/**
	 * 获得 CPU空闲旅<br>
	 * CPU空闲旅
	 * @return CPU空闲旅
	*/
	public BigDecimal getCpuIdle() {
		return cpuIdle;
	}
	
	/**
	 * 设置 CPU空闲旅
	 * @param cpuIdle CPU空闲旅
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCpuIdle(BigDecimal cpuIdle) {
		this.cpuIdle=cpuIdle;
		return this;
	}
	
	/**
	 * 获得 CPU使用率<br>
	 * CPU使用率
	 * @return CPU使用率
	*/
	public BigDecimal getCpuUsed() {
		return cpuUsed;
	}
	
	/**
	 * 设置 CPU使用率
	 * @param cpuUsed CPU使用率
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCpuUsed(BigDecimal cpuUsed) {
		this.cpuUsed=cpuUsed;
		return this;
	}
	
	/**
	 * 获得 系统负载<br>
	 * 系统负载
	 * @return 系统负载
	*/
	public BigDecimal getOsLoad() {
		return osLoad;
	}
	
	/**
	 * 设置 系统负载
	 * @param osLoad 系统负载
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setOsLoad(BigDecimal osLoad) {
		this.osLoad=osLoad;
		return this;
	}
	
	/**
	 * 获得 系统负载5<br>
	 * 系统负载5
	 * @return 系统负载5
	*/
	public BigDecimal getOsLoad5() {
		return osLoad5;
	}
	
	/**
	 * 设置 系统负载5
	 * @param osLoad5 系统负载5
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setOsLoad5(BigDecimal osLoad5) {
		this.osLoad5=osLoad5;
		return this;
	}
	
	/**
	 * 获得 系统负载15<br>
	 * 系统负载15
	 * @return 系统负载15
	*/
	public BigDecimal getOsLoad15() {
		return osLoad15;
	}
	
	/**
	 * 设置 系统负载15
	 * @param osLoad15 系统负载15
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setOsLoad15(BigDecimal osLoad15) {
		this.osLoad15=osLoad15;
		return this;
	}
	
	/**
	 * 获得 上行流量<br>
	 * 上行流量
	 * @return 上行流量
	*/
	public BigDecimal getNetworkFlowUp() {
		return networkFlowUp;
	}
	
	/**
	 * 设置 上行流量
	 * @param networkFlowUp 上行流量
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setNetworkFlowUp(BigDecimal networkFlowUp) {
		this.networkFlowUp=networkFlowUp;
		return this;
	}
	
	/**
	 * 获得 下流量<br>
	 * 下流量
	 * @return 下流量
	*/
	public BigDecimal getNetworkFlowDown() {
		return networkFlowDown;
	}
	
	/**
	 * 设置 下流量
	 * @param networkFlowDown 下流量
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setNetworkFlowDown(BigDecimal networkFlowDown) {
		this.networkFlowDown=networkFlowDown;
		return this;
	}
	
	/**
	 * 获得 连接数<br>
	 * 连接数
	 * @return 连接数
	*/
	public Integer getProcessCnt() {
		return processCnt;
	}
	
	/**
	 * 设置 连接数
	 * @param processCnt 连接数
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setProcessCnt(Integer processCnt) {
		this.processCnt=processCnt;
		return this;
	}
	
	/**
	 * 获得 物理内存(M)<br>
	 * 物理内存(M)
	 * @return 物理内存(M)
	*/
	public Long getPMemorySize() {
		return pMemorySize;
	}
	
	/**
	 * 设置 物理内存(M)
	 * @param pMemorySize 物理内存(M)
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setPMemorySize(Long pMemorySize) {
		this.pMemorySize=pMemorySize;
		return this;
	}
	
	/**
	 * 获得 虚拟内存(M)<br>
	 * 虚拟内存(M)
	 * @return 虚拟内存(M)
	*/
	public Long getVMemorySize() {
		return vMemorySize;
	}
	
	/**
	 * 设置 虚拟内存(M)
	 * @param vMemorySize 虚拟内存(M)
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setVMemorySize(Long vMemorySize) {
		this.vMemorySize=vMemorySize;
		return this;
	}
	
	/**
	 * 获得 物理内存使用率<br>
	 * 物理内存使用率
	 * @return 物理内存使用率
	*/
	public Long getPMemoryUsed() {
		return pMemoryUsed;
	}
	
	/**
	 * 设置 物理内存使用率
	 * @param pMemoryUsed 物理内存使用率
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setPMemoryUsed(Long pMemoryUsed) {
		this.pMemoryUsed=pMemoryUsed;
		return this;
	}
	
	/**
	 * 获得 虚拟内存使用率<br>
	 * 虚拟内存使用率
	 * @return 虚拟内存使用率
	*/
	public Long getVMemoryUsed() {
		return vMemoryUsed;
	}
	
	/**
	 * 设置 虚拟内存使用率
	 * @param vMemoryUsed 虚拟内存使用率
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setVMemoryUsed(Long vMemoryUsed) {
		this.vMemoryUsed=vMemoryUsed;
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
	public MonitorNodeValueLast setInfo(String info) {
		this.info=info;
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
	public MonitorNodeValueLast setLabel1(String label1) {
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
	public MonitorNodeValueLast setLabel2(String label2) {
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
	public MonitorNodeValueLast setLabel3(String label3) {
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
	public MonitorNodeValueLast setCode1(String code1) {
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
	public MonitorNodeValueLast setCode2(String code2) {
		this.code2=code2;
		return this;
	}
	
	/**
	 * 获得 编码3<br>
	 * 编码3
	 * @return 编码3
	*/
	public String getCode3() {
		return code3;
	}
	
	/**
	 * 设置 编码3
	 * @param code3 编码3
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setCode3(String code3) {
		this.code3=code3;
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
	public MonitorNodeValueLast setValueNumber1(BigDecimal valueNumber1) {
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
	public MonitorNodeValueLast setValueNumber2(BigDecimal valueNumber2) {
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
	public MonitorNodeValueLast setValueNumber3(BigDecimal valueNumber3) {
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
	public MonitorNodeValueLast setValueStr1(String valueStr1) {
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
	public MonitorNodeValueLast setValueStr2(String valueStr2) {
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
	public MonitorNodeValueLast setValueStr3(String valueStr3) {
		this.valueStr3=valueStr3;
		return this;
	}
	
	/**
	 * 获得 整数1<br>
	 * 整数1
	 * @return 整数1
	*/
	public Long getValueInt1() {
		return valueInt1;
	}
	
	/**
	 * 设置 整数1
	 * @param valueInt1 整数1
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setValueInt1(Long valueInt1) {
		this.valueInt1=valueInt1;
		return this;
	}
	
	/**
	 * 获得 整数2<br>
	 * 整数2
	 * @return 整数2
	*/
	public Long getValueInt2() {
		return valueInt2;
	}
	
	/**
	 * 设置 整数2
	 * @param valueInt2 整数2
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setValueInt2(Long valueInt2) {
		this.valueInt2=valueInt2;
		return this;
	}
	
	/**
	 * 获得 整数3<br>
	 * 整数3
	 * @return 整数3
	*/
	public Long getValueInt3() {
		return valueInt3;
	}
	
	/**
	 * 设置 整数3
	 * @param valueInt3 整数3
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setValueInt3(Long valueInt3) {
		this.valueInt3=valueInt3;
		return this;
	}
	
	/**
	 * 获得 标签列1<br>
	 * 标签列1
	 * @return 标签列1
	*/
	public String getListLabel1() {
		return listLabel1;
	}
	
	/**
	 * 设置 标签列1
	 * @param listLabel1 标签列1
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListLabel1(String listLabel1) {
		this.listLabel1=listLabel1;
		return this;
	}
	
	/**
	 * 获得 标签列2<br>
	 * 标签列2
	 * @return 标签列2
	*/
	public String getListLabel2() {
		return listLabel2;
	}
	
	/**
	 * 设置 标签列2
	 * @param listLabel2 标签列2
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListLabel2(String listLabel2) {
		this.listLabel2=listLabel2;
		return this;
	}
	
	/**
	 * 获得 标签列3<br>
	 * 标签列3
	 * @return 标签列3
	*/
	public String getListLabel3() {
		return listLabel3;
	}
	
	/**
	 * 设置 标签列3
	 * @param listLabel3 标签列3
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListLabel3(String listLabel3) {
		this.listLabel3=listLabel3;
		return this;
	}
	
	/**
	 * 获得 编码列1<br>
	 * 编码列1
	 * @return 编码列1
	*/
	public String getListCode1() {
		return listCode1;
	}
	
	/**
	 * 设置 编码列1
	 * @param listCode1 编码列1
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListCode1(String listCode1) {
		this.listCode1=listCode1;
		return this;
	}
	
	/**
	 * 获得 编码列2<br>
	 * 编码列2
	 * @return 编码列2
	*/
	public String getListCode2() {
		return listCode2;
	}
	
	/**
	 * 设置 编码列2
	 * @param listCode2 编码列2
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListCode2(String listCode2) {
		this.listCode2=listCode2;
		return this;
	}
	
	/**
	 * 获得 编码列3<br>
	 * 编码列3
	 * @return 编码列3
	*/
	public String getListCode3() {
		return listCode3;
	}
	
	/**
	 * 设置 编码列3
	 * @param listCode3 编码列3
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListCode3(String listCode3) {
		this.listCode3=listCode3;
		return this;
	}
	
	/**
	 * 获得 数值列1<br>
	 * 数值列1
	 * @return 数值列1
	*/
	public BigDecimal getListValueNumber1() {
		return listValueNumber1;
	}
	
	/**
	 * 设置 数值列1
	 * @param listValueNumber1 数值列1
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueNumber1(BigDecimal listValueNumber1) {
		this.listValueNumber1=listValueNumber1;
		return this;
	}
	
	/**
	 * 获得 数值列2<br>
	 * 数值列2
	 * @return 数值列2
	*/
	public BigDecimal getListValueNumber2() {
		return listValueNumber2;
	}
	
	/**
	 * 设置 数值列2
	 * @param listValueNumber2 数值列2
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueNumber2(BigDecimal listValueNumber2) {
		this.listValueNumber2=listValueNumber2;
		return this;
	}
	
	/**
	 * 获得 数值列3<br>
	 * 数值列3
	 * @return 数值列3
	*/
	public BigDecimal getListValueNumber3() {
		return listValueNumber3;
	}
	
	/**
	 * 设置 数值列3
	 * @param listValueNumber3 数值列3
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueNumber3(BigDecimal listValueNumber3) {
		this.listValueNumber3=listValueNumber3;
		return this;
	}
	
	/**
	 * 获得 字符串列1<br>
	 * 字符串列1
	 * @return 字符串列1
	*/
	public String getListValueStr1() {
		return listValueStr1;
	}
	
	/**
	 * 设置 字符串列1
	 * @param listValueStr1 字符串列1
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueStr1(String listValueStr1) {
		this.listValueStr1=listValueStr1;
		return this;
	}
	
	/**
	 * 获得 字符串列2<br>
	 * 字符串列2
	 * @return 字符串列2
	*/
	public String getListValueStr2() {
		return listValueStr2;
	}
	
	/**
	 * 设置 字符串列2
	 * @param listValueStr2 字符串列2
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueStr2(String listValueStr2) {
		this.listValueStr2=listValueStr2;
		return this;
	}
	
	/**
	 * 获得 字符串列3<br>
	 * 字符串列3
	 * @return 字符串列3
	*/
	public String getListValueStr3() {
		return listValueStr3;
	}
	
	/**
	 * 设置 字符串列3
	 * @param listValueStr3 字符串列3
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueStr3(String listValueStr3) {
		this.listValueStr3=listValueStr3;
		return this;
	}
	
	/**
	 * 获得 整数列1<br>
	 * 整数列1
	 * @return 整数列1
	*/
	public Long getListValueInt1() {
		return listValueInt1;
	}
	
	/**
	 * 设置 整数列1
	 * @param listValueInt1 整数列1
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueInt1(Long listValueInt1) {
		this.listValueInt1=listValueInt1;
		return this;
	}
	
	/**
	 * 获得 整数列2<br>
	 * 整数列2
	 * @return 整数列2
	*/
	public Long getListValueInt2() {
		return listValueInt2;
	}
	
	/**
	 * 设置 整数列2
	 * @param listValueInt2 整数列2
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueInt2(Long listValueInt2) {
		this.listValueInt2=listValueInt2;
		return this;
	}
	
	/**
	 * 获得 整数列3<br>
	 * 整数列3
	 * @return 整数列3
	*/
	public Long getListValueInt3() {
		return listValueInt3;
	}
	
	/**
	 * 设置 整数列3
	 * @param listValueInt3 整数列3
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setListValueInt3(Long listValueInt3) {
		this.listValueInt3=listValueInt3;
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
	public MonitorNodeValueLast setUid(String uid) {
		this.uid=uid;
		return this;
	}
	
	/**
	 * 获得 是否连接<br>
	 * 是否连接
	 * @return 是否连接
	*/
	public Integer getIsConnected() {
		return isConnected;
	}
	
	/**
	 * 设置 是否连接
	 * @param isConnected 是否连接
	 * @return 当前对象
	*/
	public MonitorNodeValueLast setIsConnected(Integer isConnected) {
		this.isConnected=isConnected;
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
	public MonitorNodeValueLast setRecordTime(Date recordTime) {
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
	public MonitorNodeValueLast setCreateBy(String createBy) {
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
	public MonitorNodeValueLast setCreateTime(Date createTime) {
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
	public MonitorNodeValueLast setUpdateBy(String updateBy) {
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
	public MonitorNodeValueLast setUpdateTime(Date updateTime) {
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
	public MonitorNodeValueLast setDeleted(Integer deleted) {
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
	public MonitorNodeValueLast setDeleteBy(String deleteBy) {
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
	public MonitorNodeValueLast setDeleteTime(Date deleteTime) {
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
	public MonitorNodeValueLast setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorNodeValueLast , 转换好的 MonitorNodeValueLast 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeValueLast , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorNodeValueLast
	 * @param monitorNodeValueLastMap 包含实体信息的 Map 对象
	 * @return MonitorNodeValueLast , 转换好的的 MonitorNodeValueLast 对象
	*/
	@Transient
	public static MonitorNodeValueLast createFrom(Map<String,Object> monitorNodeValueLastMap) {
		if(monitorNodeValueLastMap==null) return null;
		MonitorNodeValueLast po = EntityContext.create(MonitorNodeValueLast.class, monitorNodeValueLastMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeValueLast
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeValueLast , 转换好的的 MonitorNodeValueLast 对象
	*/
	@Transient
	public static MonitorNodeValueLast createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeValueLast po = EntityContext.create(MonitorNodeValueLast.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorNodeValueLast，等同于 new
	 * @return MonitorNodeValueLast 对象
	*/
	@Transient
	public static MonitorNodeValueLast create() {
		return EntityContext.create(MonitorNodeValueLast.class);
	}
}