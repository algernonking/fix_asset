package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_INFORMATION_SYSTEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-15 18:34:43
 * @sign 7FF33F13522A084F72AC62376C1AD5E5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_information_system")
public class InformationSystem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_INFORMATION_SYSTEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 父节点：默认无为0
	*/
	@ApiModelProperty(required = false,value="父节点" , notes = "默认无为0")
	private String pid;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 介绍：介绍
	*/
	@ApiModelProperty(required = false,value="介绍" , notes = "介绍")
	private String profile;
	
	/**
	 * 当前状态：当前状态
	*/
	@ApiModelProperty(required = false,value="当前状态" , notes = "当前状态")
	private String status;
	
	/**
	 * 运维模式：运维模式
	*/
	@ApiModelProperty(required = false,value="运维模式" , notes = "运维模式")
	private String opsMethod;
	
	/**
	 * 开发模式：开发模式
	*/
	@ApiModelProperty(required = false,value="开发模式" , notes = "开发模式")
	private String devMethod;
	
	/**
	 * 技术联系人：技术联系人
	*/
	@ApiModelProperty(required = false,value="技术联系人" , notes = "技术联系人")
	private String technicalContact;
	
	/**
	 * 业务联系人：业务联系人
	*/
	@ApiModelProperty(required = false,value="业务联系人" , notes = "业务联系人")
	private String businessContact;
	
	/**
	 * 所属组织：所属组织
	*/
	@ApiModelProperty(required = false,value="所属组织" , notes = "所属组织")
	private String belongOrgInfo;
	
	/**
	 * 最后一次演练：最后一次演练
	*/
	@ApiModelProperty(required = false,value="最后一次演练" , notes = "最后一次演练")
	private Date lastdrillDate;
	
	/**
	 * 上线时间：上线时间
	*/
	@ApiModelProperty(required = false,value="上线时间" , notes = "上线时间")
	private Date onlineDate;
	
	/**
	 * 下线时间：下线时间
	*/
	@ApiModelProperty(required = false,value="下线时间" , notes = "下线时间")
	private Date offlineDate;
	
	/**
	 * 操作系统：操作系统
	*/
	@ApiModelProperty(required = false,value="操作系统" , notes = "操作系统")
	private String osInfo;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String dbInfo;
	
	/**
	 * 应用：应用
	*/
	@ApiModelProperty(required = false,value="应用" , notes = "应用")
	private String appInfo;
	
	/**
	 * 等级：等级
	*/
	@ApiModelProperty(required = false,value="等级" , notes = "等级")
	private String grade;
	
	/**
	 * RTO：RTO
	*/
	@ApiModelProperty(required = false,value="RTO" , notes = "RTO")
	private String rto;
	
	/**
	 * RPO：RPO
	*/
	@ApiModelProperty(required = false,value="RPO" , notes = "RPO")
	private String rpo;
	
	/**
	 * 硬件信息：硬件信息
	*/
	@ApiModelProperty(required = false,value="硬件信息" , notes = "硬件信息")
	private String hardwareInfo;
	
	/**
	 * 备份信息：备份信息
	*/
	@ApiModelProperty(required = false,value="备份信息" , notes = "备份信息")
	private String backupInfo;
	
	/**
	 * 本地备份：本地备份
	*/
	@ApiModelProperty(required = false,value="本地备份" , notes = "本地备份")
	private String sameplaceBacupInfo;
	
	/**
	 * 异地备份：异地备份
	*/
	@ApiModelProperty(required = false,value="异地备份" , notes = "异地备份")
	private String diffplaceBackupInfo;
	
	/**
	 * 归档模式：归档模式
	*/
	@ApiModelProperty(required = false,value="归档模式" , notes = "归档模式")
	private String archMethod;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String labels;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
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
	public InformationSystem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 父节点<br>
	 * 默认无为0
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
	public InformationSystem setPid(String pid) {
		this.pid=pid;
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
	public InformationSystem setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 介绍<br>
	 * 介绍
	 * @return 介绍
	*/
	public String getProfile() {
		return profile;
	}
	
	/**
	 * 设置 介绍
	 * @param profile 介绍
	 * @return 当前对象
	*/
	public InformationSystem setProfile(String profile) {
		this.profile=profile;
		return this;
	}
	
	/**
	 * 获得 当前状态<br>
	 * 当前状态
	 * @return 当前状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 当前状态
	 * @param status 当前状态
	 * @return 当前对象
	*/
	public InformationSystem setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 运维模式<br>
	 * 运维模式
	 * @return 运维模式
	*/
	public String getOpsMethod() {
		return opsMethod;
	}
	
	/**
	 * 设置 运维模式
	 * @param opsMethod 运维模式
	 * @return 当前对象
	*/
	public InformationSystem setOpsMethod(String opsMethod) {
		this.opsMethod=opsMethod;
		return this;
	}
	
	/**
	 * 获得 开发模式<br>
	 * 开发模式
	 * @return 开发模式
	*/
	public String getDevMethod() {
		return devMethod;
	}
	
	/**
	 * 设置 开发模式
	 * @param devMethod 开发模式
	 * @return 当前对象
	*/
	public InformationSystem setDevMethod(String devMethod) {
		this.devMethod=devMethod;
		return this;
	}
	
	/**
	 * 获得 技术联系人<br>
	 * 技术联系人
	 * @return 技术联系人
	*/
	public String getTechnicalContact() {
		return technicalContact;
	}
	
	/**
	 * 设置 技术联系人
	 * @param technicalContact 技术联系人
	 * @return 当前对象
	*/
	public InformationSystem setTechnicalContact(String technicalContact) {
		this.technicalContact=technicalContact;
		return this;
	}
	
	/**
	 * 获得 业务联系人<br>
	 * 业务联系人
	 * @return 业务联系人
	*/
	public String getBusinessContact() {
		return businessContact;
	}
	
	/**
	 * 设置 业务联系人
	 * @param businessContact 业务联系人
	 * @return 当前对象
	*/
	public InformationSystem setBusinessContact(String businessContact) {
		this.businessContact=businessContact;
		return this;
	}
	
	/**
	 * 获得 所属组织<br>
	 * 所属组织
	 * @return 所属组织
	*/
	public String getBelongOrgInfo() {
		return belongOrgInfo;
	}
	
	/**
	 * 设置 所属组织
	 * @param belongOrgInfo 所属组织
	 * @return 当前对象
	*/
	public InformationSystem setBelongOrgInfo(String belongOrgInfo) {
		this.belongOrgInfo=belongOrgInfo;
		return this;
	}
	
	/**
	 * 获得 最后一次演练<br>
	 * 最后一次演练
	 * @return 最后一次演练
	*/
	public Date getLastdrillDate() {
		return lastdrillDate;
	}
	
	/**
	 * 设置 最后一次演练
	 * @param lastdrillDate 最后一次演练
	 * @return 当前对象
	*/
	public InformationSystem setLastdrillDate(Date lastdrillDate) {
		this.lastdrillDate=lastdrillDate;
		return this;
	}
	
	/**
	 * 获得 上线时间<br>
	 * 上线时间
	 * @return 上线时间
	*/
	public Date getOnlineDate() {
		return onlineDate;
	}
	
	/**
	 * 设置 上线时间
	 * @param onlineDate 上线时间
	 * @return 当前对象
	*/
	public InformationSystem setOnlineDate(Date onlineDate) {
		this.onlineDate=onlineDate;
		return this;
	}
	
	/**
	 * 获得 下线时间<br>
	 * 下线时间
	 * @return 下线时间
	*/
	public Date getOfflineDate() {
		return offlineDate;
	}
	
	/**
	 * 设置 下线时间
	 * @param offlineDate 下线时间
	 * @return 当前对象
	*/
	public InformationSystem setOfflineDate(Date offlineDate) {
		this.offlineDate=offlineDate;
		return this;
	}
	
	/**
	 * 获得 操作系统<br>
	 * 操作系统
	 * @return 操作系统
	*/
	public String getOsInfo() {
		return osInfo;
	}
	
	/**
	 * 设置 操作系统
	 * @param osInfo 操作系统
	 * @return 当前对象
	*/
	public InformationSystem setOsInfo(String osInfo) {
		this.osInfo=osInfo;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbInfo() {
		return dbInfo;
	}
	
	/**
	 * 设置 数据库
	 * @param dbInfo 数据库
	 * @return 当前对象
	*/
	public InformationSystem setDbInfo(String dbInfo) {
		this.dbInfo=dbInfo;
		return this;
	}
	
	/**
	 * 获得 应用<br>
	 * 应用
	 * @return 应用
	*/
	public String getAppInfo() {
		return appInfo;
	}
	
	/**
	 * 设置 应用
	 * @param appInfo 应用
	 * @return 当前对象
	*/
	public InformationSystem setAppInfo(String appInfo) {
		this.appInfo=appInfo;
		return this;
	}
	
	/**
	 * 获得 等级<br>
	 * 等级
	 * @return 等级
	*/
	public String getGrade() {
		return grade;
	}
	
	/**
	 * 设置 等级
	 * @param grade 等级
	 * @return 当前对象
	*/
	public InformationSystem setGrade(String grade) {
		this.grade=grade;
		return this;
	}
	
	/**
	 * 获得 RTO<br>
	 * RTO
	 * @return RTO
	*/
	public String getRto() {
		return rto;
	}
	
	/**
	 * 设置 RTO
	 * @param rto RTO
	 * @return 当前对象
	*/
	public InformationSystem setRto(String rto) {
		this.rto=rto;
		return this;
	}
	
	/**
	 * 获得 RPO<br>
	 * RPO
	 * @return RPO
	*/
	public String getRpo() {
		return rpo;
	}
	
	/**
	 * 设置 RPO
	 * @param rpo RPO
	 * @return 当前对象
	*/
	public InformationSystem setRpo(String rpo) {
		this.rpo=rpo;
		return this;
	}
	
	/**
	 * 获得 硬件信息<br>
	 * 硬件信息
	 * @return 硬件信息
	*/
	public String getHardwareInfo() {
		return hardwareInfo;
	}
	
	/**
	 * 设置 硬件信息
	 * @param hardwareInfo 硬件信息
	 * @return 当前对象
	*/
	public InformationSystem setHardwareInfo(String hardwareInfo) {
		this.hardwareInfo=hardwareInfo;
		return this;
	}
	
	/**
	 * 获得 备份信息<br>
	 * 备份信息
	 * @return 备份信息
	*/
	public String getBackupInfo() {
		return backupInfo;
	}
	
	/**
	 * 设置 备份信息
	 * @param backupInfo 备份信息
	 * @return 当前对象
	*/
	public InformationSystem setBackupInfo(String backupInfo) {
		this.backupInfo=backupInfo;
		return this;
	}
	
	/**
	 * 获得 本地备份<br>
	 * 本地备份
	 * @return 本地备份
	*/
	public String getSameplaceBacupInfo() {
		return sameplaceBacupInfo;
	}
	
	/**
	 * 设置 本地备份
	 * @param sameplaceBacupInfo 本地备份
	 * @return 当前对象
	*/
	public InformationSystem setSameplaceBacupInfo(String sameplaceBacupInfo) {
		this.sameplaceBacupInfo=sameplaceBacupInfo;
		return this;
	}
	
	/**
	 * 获得 异地备份<br>
	 * 异地备份
	 * @return 异地备份
	*/
	public String getDiffplaceBackupInfo() {
		return diffplaceBackupInfo;
	}
	
	/**
	 * 设置 异地备份
	 * @param diffplaceBackupInfo 异地备份
	 * @return 当前对象
	*/
	public InformationSystem setDiffplaceBackupInfo(String diffplaceBackupInfo) {
		this.diffplaceBackupInfo=diffplaceBackupInfo;
		return this;
	}
	
	/**
	 * 获得 归档模式<br>
	 * 归档模式
	 * @return 归档模式
	*/
	public String getArchMethod() {
		return archMethod;
	}
	
	/**
	 * 设置 归档模式
	 * @param archMethod 归档模式
	 * @return 当前对象
	*/
	public InformationSystem setArchMethod(String archMethod) {
		this.archMethod=archMethod;
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
	public InformationSystem setLabels(String labels) {
		this.labels=labels;
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
	public InformationSystem setNotes(String notes) {
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
	public InformationSystem setCreateBy(String createBy) {
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
	public InformationSystem setCreateTime(Date createTime) {
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
	public InformationSystem setUpdateBy(String updateBy) {
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
	public InformationSystem setUpdateTime(Date updateTime) {
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
	public InformationSystem setDeleted(Integer deleted) {
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
	public InformationSystem setDeleteBy(String deleteBy) {
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
	public InformationSystem setDeleteTime(Date deleteTime) {
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
	public InformationSystem setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InformationSystem , 转换好的 InformationSystem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InformationSystem , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InformationSystem
	 * @param informationSystemMap 包含实体信息的 Map 对象
	 * @return InformationSystem , 转换好的的 InformationSystem 对象
	*/
	@Transient
	public static InformationSystem createFrom(Map<String,Object> informationSystemMap) {
		if(informationSystemMap==null) return null;
		InformationSystem po = EntityContext.create(InformationSystem.class, informationSystemMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InformationSystem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InformationSystem , 转换好的的 InformationSystem 对象
	*/
	@Transient
	public static InformationSystem createFrom(Object pojo) {
		if(pojo==null) return null;
		InformationSystem po = EntityContext.create(InformationSystem.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InformationSystem，等同于 new
	 * @return InformationSystem 对象
	*/
	@Transient
	public static InformationSystem create() {
		return EntityContext.create(InformationSystem.class);
	}
}