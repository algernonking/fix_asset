package com.dt.platform.domain.contract;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.ContractTables.CONT_CONTRACT_ATTACHMENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import com.dt.platform.constants.enums.contract.AttachmentOwnerType;
import javax.persistence.Transient;
import com.dt.platform.constants.enums.contract.AttachmentType;
import java.util.Date;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 合同附件
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-08 17:04:16
 * @sign D7980ADFFB36F414E1B1E453AEB83D1B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "cont_contract_attachment")
public class ContractAttachment extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CONT_CONTRACT_ATTACHMENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所有者ID：所有者ID
	*/
	@ApiModelProperty(required = false,value="所有者ID" , notes = "所有者ID")
	private String ownerId;
	
	/**
	 * 所有者类型：合同/履约情况；枚举： AttachmentOwnerType
	*/
	@ApiModelProperty(required = false,value="所有者类型" , notes = "合同/履约情况；枚举： AttachmentOwnerType")
	private String ownerType;
	@Transient
	private AttachmentOwnerType ownerTypeEnum;
	
	/**
	 * 附件类型：枚举：AttachmentType
	*/
	@ApiModelProperty(required = false,value="附件类型" , notes = "枚举：AttachmentType")
	private String type;
	@Transient
	private AttachmentType typeEnum;
	
	/**
	 * 文件ID：文件ID
	*/
	@ApiModelProperty(required = false,value="文件ID" , notes = "文件ID")
	private String fileId;
	
	/**
	 * 附件名称：附件名称
	*/
	@ApiModelProperty(required = false,value="附件名称" , notes = "附件名称")
	private String name;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 租户ID：租户ID
	*/
	@ApiModelProperty(required = false,value="租户ID" , notes = "租户ID")
	private String tenantId;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
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
	public ContractAttachment setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所有者ID<br>
	 * 所有者ID
	 * @return 所有者ID
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所有者ID
	 * @param ownerId 所有者ID
	 * @return 当前对象
	*/
	public ContractAttachment setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 所有者类型<br>
	 * 合同/履约情况；枚举： AttachmentOwnerType
	 * @return 所有者类型
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 获得 所有者类型 的投影属性<br>
	 * 等价于 getOwnerType 方法，获得对应的枚举类型
	 * @return 所有者类型
	*/
	@Transient
	public AttachmentOwnerType getOwnerTypeEnum() {
		if(this.ownerTypeEnum==null) {
			this.ownerTypeEnum = (AttachmentOwnerType) EnumUtil.parseByCode(AttachmentOwnerType.values(),ownerType);
		}
		return this.ownerTypeEnum ;
	}
	
	/**
	 * 设置 所有者类型
	 * @param ownerType 所有者类型
	 * @return 当前对象
	*/
	public ContractAttachment setOwnerType(String ownerType) {
		this.ownerType=ownerType;
		this.ownerTypeEnum= (AttachmentOwnerType) EnumUtil.parseByCode(AttachmentOwnerType.values(),ownerType) ;
		if(StringUtil.hasContent(ownerType) && this.ownerTypeEnum==null) {
			throw new IllegalArgumentException( ownerType + " is not one of AttachmentOwnerType");
		}
		return this;
	}
	
	/**
	 * 设置 所有者类型的投影属性，等同于设置 所有者类型
	 * @param ownerTypeEnum 所有者类型
	 * @return 当前对象
	*/
	@Transient
	public ContractAttachment setOwnerTypeEnum(AttachmentOwnerType ownerTypeEnum) {
		if(ownerTypeEnum==null) {
			this.setOwnerType(null);
		} else {
			this.setOwnerType(ownerTypeEnum.code());
		}
		this.ownerTypeEnum=ownerTypeEnum;
		return this;
	}
	
	/**
	 * 获得 附件类型<br>
	 * 枚举：AttachmentType
	 * @return 附件类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 附件类型 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 附件类型
	*/
	@Transient
	public AttachmentType getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (AttachmentType) EnumUtil.parseByCode(AttachmentType.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 附件类型
	 * @param type 附件类型
	 * @return 当前对象
	*/
	public ContractAttachment setType(String type) {
		this.type=type;
		this.typeEnum= (AttachmentType) EnumUtil.parseByCode(AttachmentType.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of AttachmentType");
		}
		return this;
	}
	
	/**
	 * 设置 附件类型的投影属性，等同于设置 附件类型
	 * @param typeEnum 附件类型
	 * @return 当前对象
	*/
	@Transient
	public ContractAttachment setTypeEnum(AttachmentType typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 文件ID<br>
	 * 文件ID
	 * @return 文件ID
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 文件ID
	 * @param fileId 文件ID
	 * @return 当前对象
	*/
	public ContractAttachment setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 附件名称<br>
	 * 附件名称
	 * @return 附件名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 附件名称
	 * @param name 附件名称
	 * @return 当前对象
	*/
	public ContractAttachment setName(String name) {
		this.name=name;
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
	public ContractAttachment setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 租户ID<br>
	 * 租户ID
	 * @return 租户ID
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户ID
	 * @param tenantId 租户ID
	 * @return 当前对象
	*/
	public ContractAttachment setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public ContractAttachment setCreateBy(String createBy) {
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
	public ContractAttachment setCreateTime(Date createTime) {
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
	public ContractAttachment setUpdateBy(String updateBy) {
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
	public ContractAttachment setUpdateTime(Date updateTime) {
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
	public ContractAttachment setDeleted(Integer deleted) {
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
	public ContractAttachment setDeleteBy(String deleteBy) {
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
	public ContractAttachment setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public ContractAttachment setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ContractAttachment , 转换好的 ContractAttachment 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ContractAttachment , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ContractAttachment
	 * @param contractAttachmentMap 包含实体信息的 Map 对象
	 * @return ContractAttachment , 转换好的的 ContractAttachment 对象
	*/
	@Transient
	public static ContractAttachment createFrom(Map<String,Object> contractAttachmentMap) {
		if(contractAttachmentMap==null) return null;
		ContractAttachment po = EntityContext.create(ContractAttachment.class, contractAttachmentMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ContractAttachment
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ContractAttachment , 转换好的的 ContractAttachment 对象
	*/
	@Transient
	public static ContractAttachment createFrom(Object pojo) {
		if(pojo==null) return null;
		ContractAttachment po = EntityContext.create(ContractAttachment.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ContractAttachment，等同于 new
	 * @return ContractAttachment 对象
	*/
	@Transient
	public static ContractAttachment create() {
		return EntityContext.create(ContractAttachment.class);
	}
}