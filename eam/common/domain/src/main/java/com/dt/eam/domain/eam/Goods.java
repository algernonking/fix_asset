package com.dt.eam.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.eam.constants.db.EAMTables.EAM_GOODS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 11:21:24
 * @sign 6BF6779BA19573FB20E2299A6C50133C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_goods")
public class Goods extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_GOODS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 状态：valid有效，invalid无效
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "valid有效，invalid无效")
	private String status;
	
	/**
	 * 分类ID：分类ID
	*/
	@ApiModelProperty(required = false,value="分类ID" , notes = "分类ID")
	private String categoryId;
	
	/**
	 * 物品图片：物品图片
	*/
	@ApiModelProperty(required = false,value="物品图片" , notes = "物品图片")
	private String pictureId;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 厂商：厂商
	*/
	@ApiModelProperty(required = false,value="厂商" , notes = "厂商")
	private String manufacturerId;
	
	/**
	 * 品牌：品牌
	*/
	@ApiModelProperty(required = false,value="品牌" , notes = "品牌")
	private String brandId;
	
	/**
	 * 规格型号：规格型号
	*/
	@ApiModelProperty(required = false,value="规格型号" , notes = "规格型号")
	private String model;
	
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
	 * 属性说明 : 主键
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
	public Goods setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 添加 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	
	/**
	 * 获得 状态<br>
	 * 属性说明 : valid有效，invalid无效
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
	public Goods setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 添加 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	
	/**
	 * 获得 分类ID<br>
	 * 属性说明 : 分类ID
	 * @return 分类ID
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 分类ID
	 * @param categoryId 分类ID
	 * @return 当前对象
	*/
	public Goods setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 添加 分类ID
	 * @param categoryId 分类ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 物品图片<br>
	 * 属性说明 : 物品图片
	 * @return 物品图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 物品图片
	 * @param pictureId 物品图片
	 * @return 当前对象
	*/
	public Goods setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 添加 物品图片
	 * @param pictureId 物品图片
	 * @return 当前对象
	*/
	
	/**
	 * 获得 编码<br>
	 * 属性说明 : 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public Goods setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 添加 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	
	/**
	 * 获得 名称<br>
	 * 属性说明 : 名称
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
	public Goods setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 添加 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	
	/**
	 * 获得 厂商<br>
	 * 属性说明 : 厂商
	 * @return 厂商
	*/
	public String getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * 设置 厂商
	 * @param manufacturerId 厂商
	 * @return 当前对象
	*/
	public Goods setManufacturerId(String manufacturerId) {
		this.manufacturerId=manufacturerId;
		return this;
	}
	
	/**
	 * 添加 厂商
	 * @param manufacturerId 厂商
	 * @return 当前对象
	*/
	
	/**
	 * 获得 品牌<br>
	 * 属性说明 : 品牌
	 * @return 品牌
	*/
	public String getBrandId() {
		return brandId;
	}
	
	/**
	 * 设置 品牌
	 * @param brandId 品牌
	 * @return 当前对象
	*/
	public Goods setBrandId(String brandId) {
		this.brandId=brandId;
		return this;
	}
	
	/**
	 * 添加 品牌
	 * @param brandId 品牌
	 * @return 当前对象
	*/
	
	/**
	 * 获得 规格型号<br>
	 * 属性说明 : 规格型号
	 * @return 规格型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 规格型号
	 * @param model 规格型号
	 * @return 当前对象
	*/
	public Goods setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 添加 规格型号
	 * @param model 规格型号
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建人ID<br>
	 * 属性说明 : 创建人ID
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
	public Goods setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 添加 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 创建时间<br>
	 * 属性说明 : 创建时间
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
	public Goods setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 添加 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改人ID<br>
	 * 属性说明 : 修改人ID
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
	public Goods setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 添加 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 修改时间<br>
	 * 属性说明 : 修改时间
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
	public Goods setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 添加 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 是否已删除<br>
	 * 属性说明 : 是否已删除
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
	public Goods setDeleted(Integer deleted) {
		this.deleted=deleted;
		return this;
	}
	
	/**
	 * 添加 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除人ID<br>
	 * 属性说明 : 删除人ID
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
	public Goods setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 添加 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	
	/**
	 * 获得 删除时间<br>
	 * 属性说明 : 删除时间
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
	public Goods setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 添加 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	
	/**
	 * 获得 version<br>
	 * 属性说明 : version
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
	public Goods setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 添加 version
	 * @param version version
	 * @return 当前对象
	*/

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Goods , 转换好的 Goods 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Goods , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 Goods
	 * @param goodsMap 包含实体信息的 Map 对象
	 * @return Goods , 转换好的的 Goods 对象
	*/
	@Transient
	public static Goods createFrom(Map<String,Object> goodsMap) {
		if(goodsMap==null) return null;
		Goods po = EntityContext.create(Goods.class, goodsMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Goods
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Goods , 转换好的的 Goods 对象
	*/
	@Transient
	public static Goods createFrom(Object pojo) {
		if(pojo==null) return null;
		Goods po = EntityContext.create(Goods.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Goods，等同于 new
	 * @return Goods 对象
	*/
	@Transient
	public static Goods create() {
		return new Goods();
	}
}