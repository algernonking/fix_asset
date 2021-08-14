package com.dt.platform.domain.datacenter;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.DC_RACK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 08:53:22
 * @sign 5CB5A32802E4AE817FA2D58DB9975B95
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "dc_rack")
public class Rack extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =DC_RACK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 区域：区域
	*/
	@ApiModelProperty(required = false,value="区域" , notes = "区域")
	private String areaId;
	
	/**
	 * 层级：层级
	*/
	@ApiModelProperty(required = false,value="层级" , notes = "层级")
	private String layerId;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String rackCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String rackName;
	
	/**
	 * 容量：容量
	*/
	@ApiModelProperty(required = false,value="容量" , notes = "容量")
	private BigDecimal rackCaptical;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String rackLabels;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String rackNotes;
	
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
	 * 区域
	*/
	@ApiModelProperty(required = false,value="区域" , notes = "")
	private Area area;
	
	/**
	 * 层级
	*/
	@ApiModelProperty(required = false,value="层级" , notes = "")
	private Layer layer;
	
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
	public Rack setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 区域<br>
	 * 区域
	 * @return 区域
	*/
	public String getAreaId() {
		return areaId;
	}
	
	/**
	 * 设置 区域
	 * @param areaId 区域
	 * @return 当前对象
	*/
	public Rack setAreaId(String areaId) {
		this.areaId=areaId;
		return this;
	}
	
	/**
	 * 获得 层级<br>
	 * 层级
	 * @return 层级
	*/
	public String getLayerId() {
		return layerId;
	}
	
	/**
	 * 设置 层级
	 * @param layerId 层级
	 * @return 当前对象
	*/
	public Rack setLayerId(String layerId) {
		this.layerId=layerId;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getRackCode() {
		return rackCode;
	}
	
	/**
	 * 设置 编码
	 * @param rackCode 编码
	 * @return 当前对象
	*/
	public Rack setRackCode(String rackCode) {
		this.rackCode=rackCode;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getRackName() {
		return rackName;
	}
	
	/**
	 * 设置 名称
	 * @param rackName 名称
	 * @return 当前对象
	*/
	public Rack setRackName(String rackName) {
		this.rackName=rackName;
		return this;
	}
	
	/**
	 * 获得 容量<br>
	 * 容量
	 * @return 容量
	*/
	public BigDecimal getRackCaptical() {
		return rackCaptical;
	}
	
	/**
	 * 设置 容量
	 * @param rackCaptical 容量
	 * @return 当前对象
	*/
	public Rack setRackCaptical(BigDecimal rackCaptical) {
		this.rackCaptical=rackCaptical;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getRackLabels() {
		return rackLabels;
	}
	
	/**
	 * 设置 标签
	 * @param rackLabels 标签
	 * @return 当前对象
	*/
	public Rack setRackLabels(String rackLabels) {
		this.rackLabels=rackLabels;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getRackNotes() {
		return rackNotes;
	}
	
	/**
	 * 设置 备注
	 * @param rackNotes 备注
	 * @return 当前对象
	*/
	public Rack setRackNotes(String rackNotes) {
		this.rackNotes=rackNotes;
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
	public Rack setCreateBy(String createBy) {
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
	public Rack setCreateTime(Date createTime) {
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
	public Rack setUpdateBy(String updateBy) {
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
	public Rack setUpdateTime(Date updateTime) {
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
	public Rack setDeleted(Integer deleted) {
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
	public Rack setDeleteBy(String deleteBy) {
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
	public Rack setDeleteTime(Date deleteTime) {
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
	public Rack setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 区域<br>
	 * @return 区域
	*/
	public Area getArea() {
		return area;
	}
	
	/**
	 * 设置 区域
	 * @param area 区域
	 * @return 当前对象
	*/
	public Rack setArea(Area area) {
		this.area=area;
		return this;
	}
	
	/**
	 * 获得 层级<br>
	 * @return 层级
	*/
	public Layer getLayer() {
		return layer;
	}
	
	/**
	 * 设置 层级
	 * @param layer 层级
	 * @return 当前对象
	*/
	public Rack setLayer(Layer layer) {
		this.layer=layer;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Rack , 转换好的 Rack 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Rack , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Rack
	 * @param rackMap 包含实体信息的 Map 对象
	 * @return Rack , 转换好的的 Rack 对象
	*/
	@Transient
	public static Rack createFrom(Map<String,Object> rackMap) {
		if(rackMap==null) return null;
		Rack po = EntityContext.create(Rack.class, rackMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Rack
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Rack , 转换好的的 Rack 对象
	*/
	@Transient
	public static Rack createFrom(Object pojo) {
		if(pojo==null) return null;
		Rack po = EntityContext.create(Rack.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Rack，等同于 new
	 * @return Rack 对象
	*/
	@Transient
	public static Rack create() {
		return EntityContext.create(Rack.class);
	}
}