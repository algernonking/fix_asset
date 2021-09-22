package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.OPS_VOUCHER_OWNER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-18 12:22:14
 * @sign D3F1D53C055204833009FEC0E22450D8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_voucher_owner")
public class VoucherOwner extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_VOUCHER_OWNER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 类别：类别
	*/
	@ApiModelProperty(required = false,value="类别" , notes = "类别")
	private String categoryCode;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String position;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 凭证类型：凭证类型
	*/
	@ApiModelProperty(required = false,value="凭证类型" , notes = "凭证类型")
	private List<DictItem> voucherCategory;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证")
	private List<Voucher> voucherList;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证")
	private List<String> voucherIds;
	
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
	public VoucherOwner setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类别<br>
	 * 类别
	 * @return 类别
	*/
	public String getCategoryCode() {
		return categoryCode;
	}
	
	/**
	 * 设置 类别
	 * @param categoryCode 类别
	 * @return 当前对象
	*/
	public VoucherOwner setCategoryCode(String categoryCode) {
		this.categoryCode=categoryCode;
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
	public VoucherOwner setLabel(String label) {
		this.label=label;
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
	public VoucherOwner setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPosition() {
		return position;
	}
	
	/**
	 * 设置 位置
	 * @param position 位置
	 * @return 当前对象
	*/
	public VoucherOwner setPosition(String position) {
		this.position=position;
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
	public VoucherOwner setNotes(String notes) {
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
	public VoucherOwner setCreateBy(String createBy) {
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
	public VoucherOwner setCreateTime(Date createTime) {
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
	public VoucherOwner setUpdateBy(String updateBy) {
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
	public VoucherOwner setUpdateTime(Date updateTime) {
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
	public VoucherOwner setDeleted(Integer deleted) {
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
	public VoucherOwner setDeleteBy(String deleteBy) {
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
	public VoucherOwner setDeleteTime(Date deleteTime) {
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
	public VoucherOwner setVersion(Integer version) {
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
	public VoucherOwner setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 凭证类型<br>
	 * 凭证类型
	 * @return 凭证类型
	*/
	public List<DictItem> getVoucherCategory() {
		return voucherCategory;
	}
	
	/**
	 * 设置 凭证类型
	 * @param voucherCategory 凭证类型
	 * @return 当前对象
	*/
	public VoucherOwner setVoucherCategory(List<DictItem> voucherCategory) {
		this.voucherCategory=voucherCategory;
		return this;
	}
	
	/**
	 * 添加 凭证类型
	 * @param entity 凭证类型
	 * @return 当前对象
	*/
	public VoucherOwner addVoucherCategory(DictItem entity) {
		if(this.voucherCategory==null) voucherCategory=new ArrayList<>();
		this.voucherCategory.add(entity);
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public List<Voucher> getVoucherList() {
		return voucherList;
	}
	
	/**
	 * 设置 凭证
	 * @param voucherList 凭证
	 * @return 当前对象
	*/
	public VoucherOwner setVoucherList(List<Voucher> voucherList) {
		this.voucherList=voucherList;
		return this;
	}
	
	/**
	 * 添加 凭证
	 * @param voucher 凭证
	 * @return 当前对象
	*/
	public VoucherOwner addVoucher(Voucher voucher) {
		if(this.voucherList==null) voucherList=new ArrayList<>();
		this.voucherList.add(voucher);
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public List<String> getVoucherIds() {
		return voucherIds;
	}
	
	/**
	 * 设置 凭证
	 * @param voucherIds 凭证
	 * @return 当前对象
	*/
	public VoucherOwner setVoucherIds(List<String> voucherIds) {
		this.voucherIds=voucherIds;
		return this;
	}
	
	/**
	 * 添加 凭证
	 * @param voucherId 凭证
	 * @return 当前对象
	*/
	public VoucherOwner addVoucherId(String voucherId) {
		if(this.voucherIds==null) voucherIds=new ArrayList<>();
		this.voucherIds.add(voucherId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return VoucherOwner , 转换好的 VoucherOwner 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VoucherOwner , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 VoucherOwner
	 * @param voucherOwnerMap 包含实体信息的 Map 对象
	 * @return VoucherOwner , 转换好的的 VoucherOwner 对象
	*/
	@Transient
	public static VoucherOwner createFrom(Map<String,Object> voucherOwnerMap) {
		if(voucherOwnerMap==null) return null;
		VoucherOwner po = EntityContext.create(VoucherOwner.class, voucherOwnerMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 VoucherOwner
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VoucherOwner , 转换好的的 VoucherOwner 对象
	*/
	@Transient
	public static VoucherOwner createFrom(Object pojo) {
		if(pojo==null) return null;
		VoucherOwner po = EntityContext.create(VoucherOwner.class,pojo);
		return po;
	}

	/**
	 * 创建一个 VoucherOwner，等同于 new
	 * @return VoucherOwner 对象
	*/
	@Transient
	public static VoucherOwner create() {
		return EntityContext.create(VoucherOwner.class);
	}
}