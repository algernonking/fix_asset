package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_MONITOR_NODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 节点
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-22 17:47:09
 * @sign 1E4445C7D63FE940F72B0945961CA866
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_node")
public class MonitorNode extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_NODE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP")
	private String nodeIp;
	
	/**
	 * 父节点：父节点
	*/
	@ApiModelProperty(required = false,value="父节点" , notes = "父节点")
	private String pid;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 子类型：子类型
	*/
	@ApiModelProperty(required = false,value="子类型" , notes = "子类型")
	private String subType;
	
	/**
	 * 节点分组：节点分组
	*/
	@ApiModelProperty(required = false,value="节点分组" , notes = "节点分组")
	private String groupId;
	
	/**
	 * 主机名：主机名
	*/
	@ApiModelProperty(required = false,value="主机名" , notes = "主机名")
	private String nodeName;
	
	/**
	 * 可见主机名：可见主机名
	*/
	@ApiModelProperty(required = false,value="可见主机名" , notes = "可见主机名")
	private String nodeNameShow;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String nodeType;
	
	/**
	 * 是否启用：是否启用
	*/
	@ApiModelProperty(required = false,value="是否启用" , notes = "是否启用")
	private String nodeEnabled;
	
	/**
	 * 监控状态：监控状态
	*/
	@ApiModelProperty(required = false,value="监控状态" , notes = "监控状态")
	private String status;
	
	/**
	 * 凭证(SSH)：凭证(SSH)
	*/
	@ApiModelProperty(required = false,value="凭证(SSH)" , notes = "凭证(SSH)")
	private String sshVoucherId;
	
	/**
	 * SSH端口：SSH端口
	*/
	@ApiModelProperty(required = false,value="SSH端口" , notes = "SSH端口")
	private Integer sshPort;
	
	/**
	 * Agent端口：Agent端口
	*/
	@ApiModelProperty(required = false,value="Agent端口" , notes = "Agent端口")
	private Integer agentPort;
	
	/**
	 * Zabbix代理端口：Zabbix代理端口
	*/
	@ApiModelProperty(required = false,value="Zabbix代理端口" , notes = "Zabbix代理端口")
	private Integer zabbixAgentPort;
	
	/**
	 * Snmp端口：Snmp端口
	*/
	@ApiModelProperty(required = false,value="Snmp端口" , notes = "Snmp端口")
	private Integer snmpPort;
	
	/**
	 * Snmp版本：Snmp版本
	*/
	@ApiModelProperty(required = false,value="Snmp版本" , notes = "Snmp版本")
	private String snmpVersion;
	
	/**
	 * Snmp团体：Snmp团体
	*/
	@ApiModelProperty(required = false,value="Snmp团体" , notes = "Snmp团体")
	private String snmpCommunity;
	
	/**
	 * Jmx端口：Jmx端口
	*/
	@ApiModelProperty(required = false,value="Jmx端口" , notes = "Jmx端口")
	private Integer jmxPort;
	
	/**
	 * Jmx端口：Jmx端口
	*/
	@ApiModelProperty(required = false,value="Jmx端口" , notes = "Jmx端口")
	private Integer impiPort;
	
	/**
	 * Jdbc地址：Jdbc地址
	*/
	@ApiModelProperty(required = false,value="Jdbc地址" , notes = "Jdbc地址")
	private String jdbcUrl;
	
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
	 * ssh凭证：ssh凭证
	*/
	@ApiModelProperty(required = false,value="ssh凭证" , notes = "ssh凭证")
	private MonitorVoucher sshVoucher;
	
	/**
	 * 数据库信息：数据库信息
	*/
	@ApiModelProperty(required = false,value="数据库信息" , notes = "数据库信息")
	private MonitorNodeDb monitorNodeDb;
	
	/**
	 * 数值信息：数值信息
	*/
	@ApiModelProperty(required = false,value="数值信息" , notes = "数值信息")
	private List<MonitorNodeValue> monitorNodeValueList;
	
	/**
	 * 节点分组：节点分组
	*/
	@ApiModelProperty(required = false,value="节点分组" , notes = "节点分组")
	private MonitorNodeGroup monitorNodeGroup;
	
	/**
	 * 节点类型：节点类型
	*/
	@ApiModelProperty(required = false,value="节点类型" , notes = "节点类型")
	private MonitorNodeType monitorNodeType;
	
	/**
	 * 节点子类型：节点子类型
	*/
	@ApiModelProperty(required = false,value="节点子类型" , notes = "节点子类型")
	private MonitorNodeSubtype monitorNodeSubType;
	
	/**
	 * 监控模版列表：监控模版列表
	*/
	@ApiModelProperty(required = false,value="监控模版列表" , notes = "监控模版列表")
	private List<MonitorTpl> monitorTplList;
	
	/**
	 * 监控模版Ids：监控模版Ids
	*/
	@ApiModelProperty(required = false,value="监控模版Ids" , notes = "监控模版Ids")
	private List<String> monitorTplIds;
	
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
	public MonitorNode setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 IP<br>
	 * IP
	 * @return IP
	*/
	public String getNodeIp() {
		return nodeIp;
	}
	
	/**
	 * 设置 IP
	 * @param nodeIp IP
	 * @return 当前对象
	*/
	public MonitorNode setNodeIp(String nodeIp) {
		this.nodeIp=nodeIp;
		return this;
	}
	
	/**
	 * 获得 父节点<br>
	 * 父节点
	 * @return 父节点
	*/
	public String getPid() {
		return pid;
	}
	
	/**
	 * 设置 父节点
	 * @param pid 父节点
	 * @return 当前对象
	*/
	public MonitorNode setPid(String pid) {
		this.pid=pid;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public MonitorNode setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 子类型<br>
	 * 子类型
	 * @return 子类型
	*/
	public String getSubType() {
		return subType;
	}
	
	/**
	 * 设置 子类型
	 * @param subType 子类型
	 * @return 当前对象
	*/
	public MonitorNode setSubType(String subType) {
		this.subType=subType;
		return this;
	}
	
	/**
	 * 获得 节点分组<br>
	 * 节点分组
	 * @return 节点分组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 节点分组
	 * @param groupId 节点分组
	 * @return 当前对象
	*/
	public MonitorNode setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 主机名<br>
	 * 主机名
	 * @return 主机名
	*/
	public String getNodeName() {
		return nodeName;
	}
	
	/**
	 * 设置 主机名
	 * @param nodeName 主机名
	 * @return 当前对象
	*/
	public MonitorNode setNodeName(String nodeName) {
		this.nodeName=nodeName;
		return this;
	}
	
	/**
	 * 获得 可见主机名<br>
	 * 可见主机名
	 * @return 可见主机名
	*/
	public String getNodeNameShow() {
		return nodeNameShow;
	}
	
	/**
	 * 设置 可见主机名
	 * @param nodeNameShow 可见主机名
	 * @return 当前对象
	*/
	public MonitorNode setNodeNameShow(String nodeNameShow) {
		this.nodeNameShow=nodeNameShow;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getNodeType() {
		return nodeType;
	}
	
	/**
	 * 设置 类型
	 * @param nodeType 类型
	 * @return 当前对象
	*/
	public MonitorNode setNodeType(String nodeType) {
		this.nodeType=nodeType;
		return this;
	}
	
	/**
	 * 获得 是否启用<br>
	 * 是否启用
	 * @return 是否启用
	*/
	public String getNodeEnabled() {
		return nodeEnabled;
	}
	
	/**
	 * 设置 是否启用
	 * @param nodeEnabled 是否启用
	 * @return 当前对象
	*/
	public MonitorNode setNodeEnabled(String nodeEnabled) {
		this.nodeEnabled=nodeEnabled;
		return this;
	}
	
	/**
	 * 获得 监控状态<br>
	 * 监控状态
	 * @return 监控状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 监控状态
	 * @param status 监控状态
	 * @return 当前对象
	*/
	public MonitorNode setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 凭证(SSH)<br>
	 * 凭证(SSH)
	 * @return 凭证(SSH)
	*/
	public String getSshVoucherId() {
		return sshVoucherId;
	}
	
	/**
	 * 设置 凭证(SSH)
	 * @param sshVoucherId 凭证(SSH)
	 * @return 当前对象
	*/
	public MonitorNode setSshVoucherId(String sshVoucherId) {
		this.sshVoucherId=sshVoucherId;
		return this;
	}
	
	/**
	 * 获得 SSH端口<br>
	 * SSH端口
	 * @return SSH端口
	*/
	public Integer getSshPort() {
		return sshPort;
	}
	
	/**
	 * 设置 SSH端口
	 * @param sshPort SSH端口
	 * @return 当前对象
	*/
	public MonitorNode setSshPort(Integer sshPort) {
		this.sshPort=sshPort;
		return this;
	}
	
	/**
	 * 获得 Agent端口<br>
	 * Agent端口
	 * @return Agent端口
	*/
	public Integer getAgentPort() {
		return agentPort;
	}
	
	/**
	 * 设置 Agent端口
	 * @param agentPort Agent端口
	 * @return 当前对象
	*/
	public MonitorNode setAgentPort(Integer agentPort) {
		this.agentPort=agentPort;
		return this;
	}
	
	/**
	 * 获得 Zabbix代理端口<br>
	 * Zabbix代理端口
	 * @return Zabbix代理端口
	*/
	public Integer getZabbixAgentPort() {
		return zabbixAgentPort;
	}
	
	/**
	 * 设置 Zabbix代理端口
	 * @param zabbixAgentPort Zabbix代理端口
	 * @return 当前对象
	*/
	public MonitorNode setZabbixAgentPort(Integer zabbixAgentPort) {
		this.zabbixAgentPort=zabbixAgentPort;
		return this;
	}
	
	/**
	 * 获得 Snmp端口<br>
	 * Snmp端口
	 * @return Snmp端口
	*/
	public Integer getSnmpPort() {
		return snmpPort;
	}
	
	/**
	 * 设置 Snmp端口
	 * @param snmpPort Snmp端口
	 * @return 当前对象
	*/
	public MonitorNode setSnmpPort(Integer snmpPort) {
		this.snmpPort=snmpPort;
		return this;
	}
	
	/**
	 * 获得 Snmp版本<br>
	 * Snmp版本
	 * @return Snmp版本
	*/
	public String getSnmpVersion() {
		return snmpVersion;
	}
	
	/**
	 * 设置 Snmp版本
	 * @param snmpVersion Snmp版本
	 * @return 当前对象
	*/
	public MonitorNode setSnmpVersion(String snmpVersion) {
		this.snmpVersion=snmpVersion;
		return this;
	}
	
	/**
	 * 获得 Snmp团体<br>
	 * Snmp团体
	 * @return Snmp团体
	*/
	public String getSnmpCommunity() {
		return snmpCommunity;
	}
	
	/**
	 * 设置 Snmp团体
	 * @param snmpCommunity Snmp团体
	 * @return 当前对象
	*/
	public MonitorNode setSnmpCommunity(String snmpCommunity) {
		this.snmpCommunity=snmpCommunity;
		return this;
	}
	
	/**
	 * 获得 Jmx端口<br>
	 * Jmx端口
	 * @return Jmx端口
	*/
	public Integer getJmxPort() {
		return jmxPort;
	}
	
	/**
	 * 设置 Jmx端口
	 * @param jmxPort Jmx端口
	 * @return 当前对象
	*/
	public MonitorNode setJmxPort(Integer jmxPort) {
		this.jmxPort=jmxPort;
		return this;
	}
	
	/**
	 * 获得 Jmx端口<br>
	 * Jmx端口
	 * @return Jmx端口
	*/
	public Integer getImpiPort() {
		return impiPort;
	}
	
	/**
	 * 设置 Jmx端口
	 * @param impiPort Jmx端口
	 * @return 当前对象
	*/
	public MonitorNode setImpiPort(Integer impiPort) {
		this.impiPort=impiPort;
		return this;
	}
	
	/**
	 * 获得 Jdbc地址<br>
	 * Jdbc地址
	 * @return Jdbc地址
	*/
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	
	/**
	 * 设置 Jdbc地址
	 * @param jdbcUrl Jdbc地址
	 * @return 当前对象
	*/
	public MonitorNode setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl=jdbcUrl;
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
	public MonitorNode setNotes(String notes) {
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
	public MonitorNode setCreateBy(String createBy) {
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
	public MonitorNode setCreateTime(Date createTime) {
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
	public MonitorNode setUpdateBy(String updateBy) {
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
	public MonitorNode setUpdateTime(Date updateTime) {
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
	public MonitorNode setDeleted(Integer deleted) {
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
	public MonitorNode setDeleteBy(String deleteBy) {
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
	public MonitorNode setDeleteTime(Date deleteTime) {
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
	public MonitorNode setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 ssh凭证<br>
	 * ssh凭证
	 * @return ssh凭证
	*/
	public MonitorVoucher getSshVoucher() {
		return sshVoucher;
	}
	
	/**
	 * 设置 ssh凭证
	 * @param sshVoucher ssh凭证
	 * @return 当前对象
	*/
	public MonitorNode setSshVoucher(MonitorVoucher sshVoucher) {
		this.sshVoucher=sshVoucher;
		return this;
	}
	
	/**
	 * 获得 数据库信息<br>
	 * 数据库信息
	 * @return 数据库信息
	*/
	public MonitorNodeDb getMonitorNodeDb() {
		return monitorNodeDb;
	}
	
	/**
	 * 设置 数据库信息
	 * @param monitorNodeDb 数据库信息
	 * @return 当前对象
	*/
	public MonitorNode setMonitorNodeDb(MonitorNodeDb monitorNodeDb) {
		this.monitorNodeDb=monitorNodeDb;
		return this;
	}
	
	/**
	 * 获得 数值信息<br>
	 * 数值信息
	 * @return 数值信息
	*/
	public List<MonitorNodeValue> getMonitorNodeValueList() {
		return monitorNodeValueList;
	}
	
	/**
	 * 设置 数值信息
	 * @param monitorNodeValueList 数值信息
	 * @return 当前对象
	*/
	public MonitorNode setMonitorNodeValueList(List<MonitorNodeValue> monitorNodeValueList) {
		this.monitorNodeValueList=monitorNodeValueList;
		return this;
	}
	
	/**
	 * 添加 数值信息
	 * @param monitorNodeValue 数值信息
	 * @return 当前对象
	*/
	public MonitorNode addMonitorNodeValue(MonitorNodeValue monitorNodeValue) {
		if(this.monitorNodeValueList==null) monitorNodeValueList=new ArrayList<>();
		this.monitorNodeValueList.add(monitorNodeValue);
		return this;
	}
	
	/**
	 * 获得 节点分组<br>
	 * 节点分组
	 * @return 节点分组
	*/
	public MonitorNodeGroup getMonitorNodeGroup() {
		return monitorNodeGroup;
	}
	
	/**
	 * 设置 节点分组
	 * @param monitorNodeGroup 节点分组
	 * @return 当前对象
	*/
	public MonitorNode setMonitorNodeGroup(MonitorNodeGroup monitorNodeGroup) {
		this.monitorNodeGroup=monitorNodeGroup;
		return this;
	}
	
	/**
	 * 获得 节点类型<br>
	 * 节点类型
	 * @return 节点类型
	*/
	public MonitorNodeType getMonitorNodeType() {
		return monitorNodeType;
	}
	
	/**
	 * 设置 节点类型
	 * @param monitorNodeType 节点类型
	 * @return 当前对象
	*/
	public MonitorNode setMonitorNodeType(MonitorNodeType monitorNodeType) {
		this.monitorNodeType=monitorNodeType;
		return this;
	}
	
	/**
	 * 获得 节点子类型<br>
	 * 节点子类型
	 * @return 节点子类型
	*/
	public MonitorNodeSubtype getMonitorNodeSubType() {
		return monitorNodeSubType;
	}
	
	/**
	 * 设置 节点子类型
	 * @param monitorNodeSubType 节点子类型
	 * @return 当前对象
	*/
	public MonitorNode setMonitorNodeSubType(MonitorNodeSubtype monitorNodeSubType) {
		this.monitorNodeSubType=monitorNodeSubType;
		return this;
	}
	
	/**
	 * 获得 监控模版列表<br>
	 * 监控模版列表
	 * @return 监控模版列表
	*/
	public List<MonitorTpl> getMonitorTplList() {
		return monitorTplList;
	}
	
	/**
	 * 设置 监控模版列表
	 * @param monitorTplList 监控模版列表
	 * @return 当前对象
	*/
	public MonitorNode setMonitorTplList(List<MonitorTpl> monitorTplList) {
		this.monitorTplList=monitorTplList;
		return this;
	}
	
	/**
	 * 添加 监控模版列表
	 * @param monitorTpl 监控模版列表
	 * @return 当前对象
	*/
	public MonitorNode addMonitorTpl(MonitorTpl monitorTpl) {
		if(this.monitorTplList==null) monitorTplList=new ArrayList<>();
		this.monitorTplList.add(monitorTpl);
		return this;
	}
	
	/**
	 * 获得 监控模版Ids<br>
	 * 监控模版Ids
	 * @return 监控模版Ids
	*/
	public List<String> getMonitorTplIds() {
		return monitorTplIds;
	}
	
	/**
	 * 设置 监控模版Ids
	 * @param monitorTplIds 监控模版Ids
	 * @return 当前对象
	*/
	public MonitorNode setMonitorTplIds(List<String> monitorTplIds) {
		this.monitorTplIds=monitorTplIds;
		return this;
	}
	
	/**
	 * 添加 监控模版Ids
	 * @param monitorTplId 监控模版Ids
	 * @return 当前对象
	*/
	public MonitorNode addMonitorTplId(String monitorTplId) {
		if(this.monitorTplIds==null) monitorTplIds=new ArrayList<>();
		this.monitorTplIds.add(monitorTplId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorNode , 转换好的 MonitorNode 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNode , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorNode
	 * @param monitorNodeMap 包含实体信息的 Map 对象
	 * @return MonitorNode , 转换好的的 MonitorNode 对象
	*/
	@Transient
	public static MonitorNode createFrom(Map<String,Object> monitorNodeMap) {
		if(monitorNodeMap==null) return null;
		MonitorNode po = EntityContext.create(MonitorNode.class, monitorNodeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorNode
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNode , 转换好的的 MonitorNode 对象
	*/
	@Transient
	public static MonitorNode createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNode po = EntityContext.create(MonitorNode.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorNode，等同于 new
	 * @return MonitorNode 对象
	*/
	@Transient
	public static MonitorNode create() {
		return EntityContext.create(MonitorNode.class);
	}
}