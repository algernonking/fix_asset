package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_NODE_HOST;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 节点主机
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:45
 * @sign 5EE83777E8AB2DCC42E9B49E474E2BFC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_node_host")
public class MonitorNodeHost extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_NODE_HOST.$TABLE;
	
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
	 * 主机名称：主机名称
	*/
	@ApiModelProperty(required = false,value="主机名称" , notes = "主机名称")
	private Date hostname;
	
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
	private Integer cpu;
	
	/**
	 * CPU主频：CPU主频
	*/
	@ApiModelProperty(required = false,value="CPU主频" , notes = "CPU主频")
	private BigDecimal cpuFre;
	
	/**
	 * 内存(M)：内存(M)
	*/
	@ApiModelProperty(required = false,value="内存(M)" , notes = "内存(M)")
	private Integer memory;
	
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
	 * 内存使用率：内存使用率
	*/
	@ApiModelProperty(required = false,value="内存使用率" , notes = "内存使用率")
	private BigDecimal memoryUsed;
	
	/**
	 * 虚拟内存使用率：虚拟内存使用率
	*/
	@ApiModelProperty(required = false,value="虚拟内存使用率" , notes = "虚拟内存使用率")
	private BigDecimal vmemoryUsed;
	
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
	 * 内存：内存
	*/
	@ApiModelProperty(required = false,value="内存" , notes = "内存")
	private Integer pMemoryUsed;
	
	/**
	 * 虚拟内存：虚拟内存
	*/
	@ApiModelProperty(required = false,value="虚拟内存" , notes = "虚拟内存")
	private Integer vMemoryUsed;
	
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
	public MonitorNodeHost setId(String id) {
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
	public MonitorNodeHost setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 主机名称<br>
	 * 主机名称
	 * @return 主机名称
	*/
	public Date getHostname() {
		return hostname;
	}
	
	/**
	 * 设置 主机名称
	 * @param hostname 主机名称
	 * @return 当前对象
	*/
	public MonitorNodeHost setHostname(Date hostname) {
		this.hostname=hostname;
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
	public MonitorNodeHost setBoottime(Date boottime) {
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
	public MonitorNodeHost setOsVerion(String osVerion) {
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
	public MonitorNodeHost setArch(String arch) {
		this.arch=arch;
		return this;
	}
	
	/**
	 * 获得 CPU数量<br>
	 * CPU数量
	 * @return CPU数量
	*/
	public Integer getCpu() {
		return cpu;
	}
	
	/**
	 * 设置 CPU数量
	 * @param cpu CPU数量
	 * @return 当前对象
	*/
	public MonitorNodeHost setCpu(Integer cpu) {
		this.cpu=cpu;
		return this;
	}
	
	/**
	 * 获得 CPU主频<br>
	 * CPU主频
	 * @return CPU主频
	*/
	public BigDecimal getCpuFre() {
		return cpuFre;
	}
	
	/**
	 * 设置 CPU主频
	 * @param cpuFre CPU主频
	 * @return 当前对象
	*/
	public MonitorNodeHost setCpuFre(BigDecimal cpuFre) {
		this.cpuFre=cpuFre;
		return this;
	}
	
	/**
	 * 获得 内存(M)<br>
	 * 内存(M)
	 * @return 内存(M)
	*/
	public Integer getMemory() {
		return memory;
	}
	
	/**
	 * 设置 内存(M)
	 * @param memory 内存(M)
	 * @return 当前对象
	*/
	public MonitorNodeHost setMemory(Integer memory) {
		this.memory=memory;
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
	public MonitorNodeHost setCpuSys(BigDecimal cpuSys) {
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
	public MonitorNodeHost setCpuUser(BigDecimal cpuUser) {
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
	public MonitorNodeHost setCpuWait(BigDecimal cpuWait) {
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
	public MonitorNodeHost setCpuIdle(BigDecimal cpuIdle) {
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
	public MonitorNodeHost setCpuUsed(BigDecimal cpuUsed) {
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
	public MonitorNodeHost setOsLoad(BigDecimal osLoad) {
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
	public MonitorNodeHost setOsLoad5(BigDecimal osLoad5) {
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
	public MonitorNodeHost setOsLoad15(BigDecimal osLoad15) {
		this.osLoad15=osLoad15;
		return this;
	}
	
	/**
	 * 获得 内存使用率<br>
	 * 内存使用率
	 * @return 内存使用率
	*/
	public BigDecimal getMemoryUsed() {
		return memoryUsed;
	}
	
	/**
	 * 设置 内存使用率
	 * @param memoryUsed 内存使用率
	 * @return 当前对象
	*/
	public MonitorNodeHost setMemoryUsed(BigDecimal memoryUsed) {
		this.memoryUsed=memoryUsed;
		return this;
	}
	
	/**
	 * 获得 虚拟内存使用率<br>
	 * 虚拟内存使用率
	 * @return 虚拟内存使用率
	*/
	public BigDecimal getVmemoryUsed() {
		return vmemoryUsed;
	}
	
	/**
	 * 设置 虚拟内存使用率
	 * @param vmemoryUsed 虚拟内存使用率
	 * @return 当前对象
	*/
	public MonitorNodeHost setVmemoryUsed(BigDecimal vmemoryUsed) {
		this.vmemoryUsed=vmemoryUsed;
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
	public MonitorNodeHost setNetworkFlowUp(BigDecimal networkFlowUp) {
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
	public MonitorNodeHost setNetworkFlowDown(BigDecimal networkFlowDown) {
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
	public MonitorNodeHost setProcessCnt(Integer processCnt) {
		this.processCnt=processCnt;
		return this;
	}
	
	/**
	 * 获得 内存<br>
	 * 内存
	 * @return 内存
	*/
	public Integer getPMemoryUsed() {
		return pMemoryUsed;
	}
	
	/**
	 * 设置 内存
	 * @param pMemoryUsed 内存
	 * @return 当前对象
	*/
	public MonitorNodeHost setPMemoryUsed(Integer pMemoryUsed) {
		this.pMemoryUsed=pMemoryUsed;
		return this;
	}
	
	/**
	 * 获得 虚拟内存<br>
	 * 虚拟内存
	 * @return 虚拟内存
	*/
	public Integer getVMemoryUsed() {
		return vMemoryUsed;
	}
	
	/**
	 * 设置 虚拟内存
	 * @param vMemoryUsed 虚拟内存
	 * @return 当前对象
	*/
	public MonitorNodeHost setVMemoryUsed(Integer vMemoryUsed) {
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
	public MonitorNodeHost setInfo(String info) {
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
	public MonitorNodeHost setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public MonitorNodeHost setNotes(String notes) {
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
	public MonitorNodeHost setCreateBy(String createBy) {
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
	public MonitorNodeHost setCreateTime(Date createTime) {
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
	public MonitorNodeHost setUpdateBy(String updateBy) {
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
	public MonitorNodeHost setUpdateTime(Date updateTime) {
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
	public MonitorNodeHost setDeleted(Integer deleted) {
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
	public MonitorNodeHost setDeleteBy(String deleteBy) {
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
	public MonitorNodeHost setDeleteTime(Date deleteTime) {
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
	public MonitorNodeHost setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorNodeHost , 转换好的 MonitorNodeHost 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeHost , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorNodeHost
	 * @param monitorNodeHostMap 包含实体信息的 Map 对象
	 * @return MonitorNodeHost , 转换好的的 MonitorNodeHost 对象
	*/
	@Transient
	public static MonitorNodeHost createFrom(Map<String,Object> monitorNodeHostMap) {
		if(monitorNodeHostMap==null) return null;
		MonitorNodeHost po = EntityContext.create(MonitorNodeHost.class, monitorNodeHostMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeHost
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeHost , 转换好的的 MonitorNodeHost 对象
	*/
	@Transient
	public static MonitorNodeHost createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeHost po = EntityContext.create(MonitorNodeHost.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorNodeHost，等同于 new
	 * @return MonitorNodeHost 对象
	*/
	@Transient
	public static MonitorNodeHost create() {
		return EntityContext.create(MonitorNodeHost.class);
	}
}