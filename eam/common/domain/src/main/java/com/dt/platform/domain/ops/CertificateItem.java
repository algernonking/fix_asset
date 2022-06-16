package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_CERTIFICATE_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 证书项
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 13:00:56
 * @sign D4FB698F4663491DB3D30672EDEDB4A2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_certificate_item")
public class CertificateItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_CERTIFICATE_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 证书：证书
	*/
	@ApiModelProperty(required = false,value="证书" , notes = "证书")
	private String certificateId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startDate;
	
	/**
	 * 到期时间：到期时间
	*/
	@ApiModelProperty(required = false,value="到期时间" , notes = "到期时间")
	private Date endDate;
	
	/**
	 * 公钥：公钥
	*/
	@ApiModelProperty(required = false,value="公钥" , notes = "公钥")
	private String publicKey;
	
	/**
	 * 私钥：私钥
	*/
	@ApiModelProperty(required = false,value="私钥" , notes = "私钥")
	private String privateKey;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
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
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private Employee operUser;
	
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
	public CertificateItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 证书<br>
	 * 证书
	 * @return 证书
	*/
	public String getCertificateId() {
		return certificateId;
	}
	
	/**
	 * 设置 证书
	 * @param certificateId 证书
	 * @return 当前对象
	*/
	public CertificateItem setCertificateId(String certificateId) {
		this.certificateId=certificateId;
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
	public CertificateItem setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * 设置 开始时间
	 * @param startDate 开始时间
	 * @return 当前对象
	*/
	public CertificateItem setStartDate(Date startDate) {
		this.startDate=startDate;
		return this;
	}
	
	/**
	 * 获得 到期时间<br>
	 * 到期时间
	 * @return 到期时间
	*/
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * 设置 到期时间
	 * @param endDate 到期时间
	 * @return 当前对象
	*/
	public CertificateItem setEndDate(Date endDate) {
		this.endDate=endDate;
		return this;
	}
	
	/**
	 * 获得 公钥<br>
	 * 公钥
	 * @return 公钥
	*/
	public String getPublicKey() {
		return publicKey;
	}
	
	/**
	 * 设置 公钥
	 * @param publicKey 公钥
	 * @return 当前对象
	*/
	public CertificateItem setPublicKey(String publicKey) {
		this.publicKey=publicKey;
		return this;
	}
	
	/**
	 * 获得 私钥<br>
	 * 私钥
	 * @return 私钥
	*/
	public String getPrivateKey() {
		return privateKey;
	}
	
	/**
	 * 设置 私钥
	 * @param privateKey 私钥
	 * @return 当前对象
	*/
	public CertificateItem setPrivateKey(String privateKey) {
		this.privateKey=privateKey;
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
	public CertificateItem setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人
	 * @param operUserId 操作人
	 * @return 当前对象
	*/
	public CertificateItem setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 附件
	 * @param attachId 附件
	 * @return 当前对象
	*/
	public CertificateItem setAttachId(String attachId) {
		this.attachId=attachId;
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
	public CertificateItem setUpdateBy(String updateBy) {
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
	public CertificateItem setUpdateTime(Date updateTime) {
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
	public CertificateItem setDeleted(Integer deleted) {
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
	public CertificateItem setDeleted(Boolean deletedBool) {
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
	public CertificateItem setDeleteBy(String deleteBy) {
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
	public CertificateItem setDeleteTime(Date deleteTime) {
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
	public CertificateItem setVersion(Integer version) {
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
	public CertificateItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 人员
	 * @param operUser 人员
	 * @return 当前对象
	*/
	public CertificateItem setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CertificateItem , 转换好的 CertificateItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CertificateItem , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 CertificateItem
	 * @param certificateItemMap 包含实体信息的 Map 对象
	 * @return CertificateItem , 转换好的的 CertificateItem 对象
	*/
	@Transient
	public static CertificateItem createFrom(Map<String,Object> certificateItemMap) {
		if(certificateItemMap==null) return null;
		CertificateItem po = EntityContext.create(CertificateItem.class, certificateItemMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 CertificateItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CertificateItem , 转换好的的 CertificateItem 对象
	*/
	@Transient
	public static CertificateItem createFrom(Object pojo) {
		if(pojo==null) return null;
		CertificateItem po = EntityContext.create(CertificateItem.class,pojo);
		return po;
	}

	/**
	 * 创建一个 CertificateItem，等同于 new
	 * @return CertificateItem 对象
	*/
	@Transient
	public static CertificateItem create() {
		return EntityContext.create(CertificateItem.class);
	}
}