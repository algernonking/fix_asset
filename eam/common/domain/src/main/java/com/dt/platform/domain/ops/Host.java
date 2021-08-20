package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_HOST;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 16:44:32
 * @sign B2F02B0409FC779079CA7F71F71E7718
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_host")
public class Host extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_HOST.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 信息系统：信息系统
	*/
	@ApiModelProperty(required = false,value="信息系统" , notes = "信息系统")
	private String systemId;
	
	/**
	 * 主机类型：主机类型
	*/
	@ApiModelProperty(required = false,value="主机类型" , notes = "主机类型")
	private String hostType;
	
	/**
	 * 主机状态：主机状态
	*/
	@ApiModelProperty(required = false,value="主机状态" , notes = "主机状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String hostName;
	
	/**
	 * 物理IP：物理IP
	*/
	@ApiModelProperty(required = false,value="物理IP" , notes = "物理IP")
	private String hostIp;
	
	/**
	 * 虚拟VIP：虚拟VIP
	*/
	@ApiModelProperty(required = false,value="虚拟VIP" , notes = "虚拟VIP")
	private String hostVip;
	
	/**
	 * 运行环境：运行环境
	*/
	@ApiModelProperty(required = false,value="运行环境" , notes = "运行环境")
	private String environment;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String positionId;
	
	/**
	 * 监控状态：监控状态
	*/
	@ApiModelProperty(required = false,value="监控状态" , notes = "监控状态")
	private String monitorStatus;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String directorUsername;
	
	/**
	 * 内存：内存
	*/
	@ApiModelProperty(required = false,value="内存" , notes = "内存")
	private BigDecimal hostMemory;
	
	/**
	 * CPU：CPU
	*/
	@ApiModelProperty(required = false,value="CPU" , notes = "CPU")
	private BigDecimal hostCpu;
	
	/**
	 * 其他配置：其他配置
	*/
	@ApiModelProperty(required = false,value="其他配置" , notes = "其他配置")
	private String hostConf;
	
	/**
	 * 系统管理员：系统管理员
	*/
	@ApiModelProperty(required = false,value="系统管理员" , notes = "系统管理员")
	private String userOsAdmin;
	
	/**
	 * 数据库管理员：数据库管理员
	*/
	@ApiModelProperty(required = false,value="数据库管理员" , notes = "数据库管理员")
	private String userDbAdmin;
	
	/**
	 * 数据库使用用户：数据库使用用户
	*/
	@ApiModelProperty(required = false,value="数据库使用用户" , notes = "数据库使用用户")
	private String userDbUsed;
	
	/**
	 * 应用使用用户：应用使用用户
	*/
	@ApiModelProperty(required = false,value="应用使用用户" , notes = "应用使用用户")
	private String userAppUsed;
	
	/**
	 * 运维操作用户：运维操作用户
	*/
	@ApiModelProperty(required = false,value="运维操作用户" , notes = "运维操作用户")
	private String userOpsOper;
	
	/**
	 * 其他用户：其他用户
	*/
	@ApiModelProperty(required = false,value="其他用户" , notes = "其他用户")
	private String userOther;
	
	/**
	 * 改密策略：改密策略
	*/
	@ApiModelProperty(required = false,value="改密策略" , notes = "改密策略")
	private String passwordStrategyId;
	
	/**
	 * 下线时间：下线时间
	*/
	@ApiModelProperty(required = false,value="下线时间" , notes = "下线时间")
	private Date offlineTime;
	
	/**
	 * 上线时间：上线时间
	*/
	@ApiModelProperty(required = false,value="上线时间" , notes = "上线时间")
	private Date onlineTime;
	
	/**
	 * 是否归档：是否归档
	*/
	@ApiModelProperty(required = false,value="是否归档" , notes = "是否归档")
	private String arch;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String labels;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String hostNotes;
	
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 信息系统：信息系统
	*/
	@ApiModelProperty(required = false,value="信息系统" , notes = "信息系统")
	private InformationSystem infoSystem;
	
	/**
	 * 所在位置：所在位置
	*/
	@ApiModelProperty(required = false,value="所在位置" , notes = "所在位置")
	private HostPosition position;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private List<ServiceInfo> hostDbList;
	
	/**
	 * 数据库列表：数据库
	*/
	@ApiModelProperty(required = false,value="数据库列表" , notes = "数据库")
	private List<String> hostDbIds;
	
	/**
	 * 中间件：中间件
	*/
	@ApiModelProperty(required = false,value="中间件" , notes = "中间件")
	private List<ServiceInfo> hostMiddlewareList;
	
	/**
	 * 中间件列表：中间件
	*/
	@ApiModelProperty(required = false,value="中间件列表" , notes = "中间件")
	private List<String> hostMiddlewareIds;
	
	/**
	 * 操作系统：操作系统
	*/
	@ApiModelProperty(required = false,value="操作系统" , notes = "操作系统")
	private List<ServiceInfo> hostOsList;
	
	/**
	 * 操作系统列表：操作系统
	*/
	@ApiModelProperty(required = false,value="操作系统列表" , notes = "操作系统")
	private List<String> hostOsIds;
	
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
	public Host setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 信息系统<br>
	 * 信息系统
	 * @return 信息系统
	*/
	public String getSystemId() {
		return systemId;
	}
	
	/**
	 * 设置 信息系统
	 * @param systemId 信息系统
	 * @return 当前对象
	*/
	public Host setSystemId(String systemId) {
		this.systemId=systemId;
		return this;
	}
	
	/**
	 * 获得 主机类型<br>
	 * 主机类型
	 * @return 主机类型
	*/
	public String getHostType() {
		return hostType;
	}
	
	/**
	 * 设置 主机类型
	 * @param hostType 主机类型
	 * @return 当前对象
	*/
	public Host setHostType(String hostType) {
		this.hostType=hostType;
		return this;
	}
	
	/**
	 * 获得 主机状态<br>
	 * 主机状态
	 * @return 主机状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 主机状态
	 * @param status 主机状态
	 * @return 当前对象
	*/
	public Host setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getHostName() {
		return hostName;
	}
	
	/**
	 * 设置 名称
	 * @param hostName 名称
	 * @return 当前对象
	*/
	public Host setHostName(String hostName) {
		this.hostName=hostName;
		return this;
	}
	
	/**
	 * 获得 物理IP<br>
	 * 物理IP
	 * @return 物理IP
	*/
	public String getHostIp() {
		return hostIp;
	}
	
	/**
	 * 设置 物理IP
	 * @param hostIp 物理IP
	 * @return 当前对象
	*/
	public Host setHostIp(String hostIp) {
		this.hostIp=hostIp;
		return this;
	}
	
	/**
	 * 获得 虚拟VIP<br>
	 * 虚拟VIP
	 * @return 虚拟VIP
	*/
	public String getHostVip() {
		return hostVip;
	}
	
	/**
	 * 设置 虚拟VIP
	 * @param hostVip 虚拟VIP
	 * @return 当前对象
	*/
	public Host setHostVip(String hostVip) {
		this.hostVip=hostVip;
		return this;
	}
	
	/**
	 * 获得 运行环境<br>
	 * 运行环境
	 * @return 运行环境
	*/
	public String getEnvironment() {
		return environment;
	}
	
	/**
	 * 设置 运行环境
	 * @param environment 运行环境
	 * @return 当前对象
	*/
	public Host setEnvironment(String environment) {
		this.environment=environment;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 位置
	 * @param positionId 位置
	 * @return 当前对象
	*/
	public Host setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 监控状态<br>
	 * 监控状态
	 * @return 监控状态
	*/
	public String getMonitorStatus() {
		return monitorStatus;
	}
	
	/**
	 * 设置 监控状态
	 * @param monitorStatus 监控状态
	 * @return 当前对象
	*/
	public Host setMonitorStatus(String monitorStatus) {
		this.monitorStatus=monitorStatus;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getDirectorUsername() {
		return directorUsername;
	}
	
	/**
	 * 设置 负责人
	 * @param directorUsername 负责人
	 * @return 当前对象
	*/
	public Host setDirectorUsername(String directorUsername) {
		this.directorUsername=directorUsername;
		return this;
	}
	
	/**
	 * 获得 内存<br>
	 * 内存
	 * @return 内存
	*/
	public BigDecimal getHostMemory() {
		return hostMemory;
	}
	
	/**
	 * 设置 内存
	 * @param hostMemory 内存
	 * @return 当前对象
	*/
	public Host setHostMemory(BigDecimal hostMemory) {
		this.hostMemory=hostMemory;
		return this;
	}
	
	/**
	 * 获得 CPU<br>
	 * CPU
	 * @return CPU
	*/
	public BigDecimal getHostCpu() {
		return hostCpu;
	}
	
	/**
	 * 设置 CPU
	 * @param hostCpu CPU
	 * @return 当前对象
	*/
	public Host setHostCpu(BigDecimal hostCpu) {
		this.hostCpu=hostCpu;
		return this;
	}
	
	/**
	 * 获得 其他配置<br>
	 * 其他配置
	 * @return 其他配置
	*/
	public String getHostConf() {
		return hostConf;
	}
	
	/**
	 * 设置 其他配置
	 * @param hostConf 其他配置
	 * @return 当前对象
	*/
	public Host setHostConf(String hostConf) {
		this.hostConf=hostConf;
		return this;
	}
	
	/**
	 * 获得 系统管理员<br>
	 * 系统管理员
	 * @return 系统管理员
	*/
	public String getUserOsAdmin() {
		return userOsAdmin;
	}
	
	/**
	 * 设置 系统管理员
	 * @param userOsAdmin 系统管理员
	 * @return 当前对象
	*/
	public Host setUserOsAdmin(String userOsAdmin) {
		this.userOsAdmin=userOsAdmin;
		return this;
	}
	
	/**
	 * 获得 数据库管理员<br>
	 * 数据库管理员
	 * @return 数据库管理员
	*/
	public String getUserDbAdmin() {
		return userDbAdmin;
	}
	
	/**
	 * 设置 数据库管理员
	 * @param userDbAdmin 数据库管理员
	 * @return 当前对象
	*/
	public Host setUserDbAdmin(String userDbAdmin) {
		this.userDbAdmin=userDbAdmin;
		return this;
	}
	
	/**
	 * 获得 数据库使用用户<br>
	 * 数据库使用用户
	 * @return 数据库使用用户
	*/
	public String getUserDbUsed() {
		return userDbUsed;
	}
	
	/**
	 * 设置 数据库使用用户
	 * @param userDbUsed 数据库使用用户
	 * @return 当前对象
	*/
	public Host setUserDbUsed(String userDbUsed) {
		this.userDbUsed=userDbUsed;
		return this;
	}
	
	/**
	 * 获得 应用使用用户<br>
	 * 应用使用用户
	 * @return 应用使用用户
	*/
	public String getUserAppUsed() {
		return userAppUsed;
	}
	
	/**
	 * 设置 应用使用用户
	 * @param userAppUsed 应用使用用户
	 * @return 当前对象
	*/
	public Host setUserAppUsed(String userAppUsed) {
		this.userAppUsed=userAppUsed;
		return this;
	}
	
	/**
	 * 获得 运维操作用户<br>
	 * 运维操作用户
	 * @return 运维操作用户
	*/
	public String getUserOpsOper() {
		return userOpsOper;
	}
	
	/**
	 * 设置 运维操作用户
	 * @param userOpsOper 运维操作用户
	 * @return 当前对象
	*/
	public Host setUserOpsOper(String userOpsOper) {
		this.userOpsOper=userOpsOper;
		return this;
	}
	
	/**
	 * 获得 其他用户<br>
	 * 其他用户
	 * @return 其他用户
	*/
	public String getUserOther() {
		return userOther;
	}
	
	/**
	 * 设置 其他用户
	 * @param userOther 其他用户
	 * @return 当前对象
	*/
	public Host setUserOther(String userOther) {
		this.userOther=userOther;
		return this;
	}
	
	/**
	 * 获得 改密策略<br>
	 * 改密策略
	 * @return 改密策略
	*/
	public String getPasswordStrategyId() {
		return passwordStrategyId;
	}
	
	/**
	 * 设置 改密策略
	 * @param passwordStrategyId 改密策略
	 * @return 当前对象
	*/
	public Host setPasswordStrategyId(String passwordStrategyId) {
		this.passwordStrategyId=passwordStrategyId;
		return this;
	}
	
	/**
	 * 获得 下线时间<br>
	 * 下线时间
	 * @return 下线时间
	*/
	public Date getOfflineTime() {
		return offlineTime;
	}
	
	/**
	 * 设置 下线时间
	 * @param offlineTime 下线时间
	 * @return 当前对象
	*/
	public Host setOfflineTime(Date offlineTime) {
		this.offlineTime=offlineTime;
		return this;
	}
	
	/**
	 * 获得 上线时间<br>
	 * 上线时间
	 * @return 上线时间
	*/
	public Date getOnlineTime() {
		return onlineTime;
	}
	
	/**
	 * 设置 上线时间
	 * @param onlineTime 上线时间
	 * @return 当前对象
	*/
	public Host setOnlineTime(Date onlineTime) {
		this.onlineTime=onlineTime;
		return this;
	}
	
	/**
	 * 获得 是否归档<br>
	 * 是否归档
	 * @return 是否归档
	*/
	public String getArch() {
		return arch;
	}
	
	/**
	 * 设置 是否归档
	 * @param arch 是否归档
	 * @return 当前对象
	*/
	public Host setArch(String arch) {
		this.arch=arch;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabels() {
		return labels;
	}
	
	/**
	 * 设置 标签
	 * @param labels 标签
	 * @return 当前对象
	*/
	public Host setLabels(String labels) {
		this.labels=labels;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getHostNotes() {
		return hostNotes;
	}
	
	/**
	 * 设置 备注
	 * @param hostNotes 备注
	 * @return 当前对象
	*/
	public Host setHostNotes(String hostNotes) {
		this.hostNotes=hostNotes;
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
	public Host setCreateBy(String createBy) {
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
	public Host setCreateTime(Date createTime) {
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
	public Host setUpdateBy(String updateBy) {
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
	public Host setUpdateTime(Date updateTime) {
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
	public Host setDeleted(Integer deleted) {
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
	public Host setDeleteBy(String deleteBy) {
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
	public Host setDeleteTime(Date deleteTime) {
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
	public Host setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 信息系统<br>
	 * 信息系统
	 * @return 信息系统
	*/
	public InformationSystem getInfoSystem() {
		return infoSystem;
	}
	
	/**
	 * 设置 信息系统
	 * @param infoSystem 信息系统
	 * @return 当前对象
	*/
	public Host setInfoSystem(InformationSystem infoSystem) {
		this.infoSystem=infoSystem;
		return this;
	}
	
	/**
	 * 获得 所在位置<br>
	 * 所在位置
	 * @return 所在位置
	*/
	public HostPosition getPosition() {
		return position;
	}
	
	/**
	 * 设置 所在位置
	 * @param position 所在位置
	 * @return 当前对象
	*/
	public Host setPosition(HostPosition position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public List<ServiceInfo> getHostDbList() {
		return hostDbList;
	}
	
	/**
	 * 设置 数据库
	 * @param hostDbList 数据库
	 * @return 当前对象
	*/
	public Host setHostDbList(List<ServiceInfo> hostDbList) {
		this.hostDbList=hostDbList;
		return this;
	}
	
	/**
	 * 添加 数据库
	 * @param hostDb 数据库
	 * @return 当前对象
	*/
	public Host addHostDb(ServiceInfo hostDb) {
		if(this.hostDbList==null) hostDbList=new ArrayList<>();
		this.hostDbList.add(hostDb);
		return this;
	}
	
	/**
	 * 获得 数据库列表<br>
	 * 数据库
	 * @return 数据库列表
	*/
	public List<String> getHostDbIds() {
		return hostDbIds;
	}
	
	/**
	 * 设置 数据库列表
	 * @param hostDbIds 数据库列表
	 * @return 当前对象
	*/
	public Host setHostDbIds(List<String> hostDbIds) {
		this.hostDbIds=hostDbIds;
		return this;
	}
	
	/**
	 * 添加 数据库列表
	 * @param hostDbId 数据库列表
	 * @return 当前对象
	*/
	public Host addHostDbId(String hostDbId) {
		if(this.hostDbIds==null) hostDbIds=new ArrayList<>();
		this.hostDbIds.add(hostDbId);
		return this;
	}
	
	/**
	 * 获得 中间件<br>
	 * 中间件
	 * @return 中间件
	*/
	public List<ServiceInfo> getHostMiddlewareList() {
		return hostMiddlewareList;
	}
	
	/**
	 * 设置 中间件
	 * @param hostMiddlewareList 中间件
	 * @return 当前对象
	*/
	public Host setHostMiddlewareList(List<ServiceInfo> hostMiddlewareList) {
		this.hostMiddlewareList=hostMiddlewareList;
		return this;
	}
	
	/**
	 * 添加 中间件
	 * @param hostMiddleware 中间件
	 * @return 当前对象
	*/
	public Host addHostMiddleware(ServiceInfo hostMiddleware) {
		if(this.hostMiddlewareList==null) hostMiddlewareList=new ArrayList<>();
		this.hostMiddlewareList.add(hostMiddleware);
		return this;
	}
	
	/**
	 * 获得 中间件列表<br>
	 * 中间件
	 * @return 中间件列表
	*/
	public List<String> getHostMiddlewareIds() {
		return hostMiddlewareIds;
	}
	
	/**
	 * 设置 中间件列表
	 * @param hostMiddlewareIds 中间件列表
	 * @return 当前对象
	*/
	public Host setHostMiddlewareIds(List<String> hostMiddlewareIds) {
		this.hostMiddlewareIds=hostMiddlewareIds;
		return this;
	}
	
	/**
	 * 添加 中间件列表
	 * @param hostMiddlewareId 中间件列表
	 * @return 当前对象
	*/
	public Host addHostMiddlewareId(String hostMiddlewareId) {
		if(this.hostMiddlewareIds==null) hostMiddlewareIds=new ArrayList<>();
		this.hostMiddlewareIds.add(hostMiddlewareId);
		return this;
	}
	
	/**
	 * 获得 操作系统<br>
	 * 操作系统
	 * @return 操作系统
	*/
	public List<ServiceInfo> getHostOsList() {
		return hostOsList;
	}
	
	/**
	 * 设置 操作系统
	 * @param hostOsList 操作系统
	 * @return 当前对象
	*/
	public Host setHostOsList(List<ServiceInfo> hostOsList) {
		this.hostOsList=hostOsList;
		return this;
	}
	
	/**
	 * 添加 操作系统
	 * @param hostOs 操作系统
	 * @return 当前对象
	*/
	public Host addHostOs(ServiceInfo hostOs) {
		if(this.hostOsList==null) hostOsList=new ArrayList<>();
		this.hostOsList.add(hostOs);
		return this;
	}
	
	/**
	 * 获得 操作系统列表<br>
	 * 操作系统
	 * @return 操作系统列表
	*/
	public List<String> getHostOsIds() {
		return hostOsIds;
	}
	
	/**
	 * 设置 操作系统列表
	 * @param hostOsIds 操作系统列表
	 * @return 当前对象
	*/
	public Host setHostOsIds(List<String> hostOsIds) {
		this.hostOsIds=hostOsIds;
		return this;
	}
	
	/**
	 * 添加 操作系统列表
	 * @param hostOsId 操作系统列表
	 * @return 当前对象
	*/
	public Host addHostOsId(String hostOsId) {
		if(this.hostOsIds==null) hostOsIds=new ArrayList<>();
		this.hostOsIds.add(hostOsId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Host , 转换好的 Host 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Host , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Host
	 * @param hostMap 包含实体信息的 Map 对象
	 * @return Host , 转换好的的 Host 对象
	*/
	@Transient
	public static Host createFrom(Map<String,Object> hostMap) {
		if(hostMap==null) return null;
		Host po = EntityContext.create(Host.class, hostMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Host
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Host , 转换好的的 Host 对象
	*/
	@Transient
	public static Host createFrom(Object pojo) {
		if(pojo==null) return null;
		Host po = EntityContext.create(Host.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Host，等同于 new
	 * @return Host 对象
	*/
	@Transient
	public static Host create() {
		return EntityContext.create(Host.class);
	}
}