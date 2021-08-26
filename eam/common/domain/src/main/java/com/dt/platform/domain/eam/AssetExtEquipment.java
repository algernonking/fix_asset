package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_EXT_EQUIPMENT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.Rack;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * null
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-25 21:22:38
 * @sign DD1A2F501C11E4AEE89229997DC2D977
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_ext_equipment")
public class AssetExtEquipment extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_EXT_EQUIPMENT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private String assetId;
	
	/**
	 * 设备IP：设备IP
	*/
	@ApiModelProperty(required = false,value="设备IP" , notes = "设备IP")
	private String equipmentIp;
	
	/**
	 * 管理IP：管理IP
	*/
	@ApiModelProperty(required = false,value="管理IP" , notes = "管理IP")
	private String manageIp;
	
	/**
	 * 设备CPU：设备CPU
	*/
	@ApiModelProperty(required = false,value="设备CPU" , notes = "设备CPU")
	private String equipmentCpu;
	
	/**
	 * 设备内存：设备内存
	*/
	@ApiModelProperty(required = false,value="设备内存" , notes = "设备内存")
	private String equipmentMemory;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String equipmentNotes;
	
	/**
	 * 描述：描述
	*/
	@ApiModelProperty(required = false,value="描述" , notes = "描述")
	private String equipmentDesc;
	
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
	 * 机柜：机柜
	*/
	@ApiModelProperty(required = false,value="机柜" , notes = "机柜")
	private String rackId;
	
	/**
	 * 机柜上位置编号：机柜上位置编号
	*/
	@ApiModelProperty(required = false,value="机柜上位置编号" , notes = "机柜上位置编号")
	private Integer rackUpPositionNumber;
	
	/**
	 * 机柜下位置编号：机柜下位置编号
	*/
	@ApiModelProperty(required = false,value="机柜下位置编号" , notes = "机柜下位置编号")
	private Integer rackDownPositionNumber;
	
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
	 * 区域：区域
	*/
	@ApiModelProperty(required = false,value="区域" , notes = "区域")
	private Area area;
	
	/**
	 * 层级：层级
	*/
	@ApiModelProperty(required = false,value="层级" , notes = "层级")
	private Layer layer;
	
	/**
	 * 机柜：机柜
	*/
	@ApiModelProperty(required = false,value="机柜" , notes = "机柜")
	private Rack rack;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
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
	public AssetExtEquipment setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产
	 * @param assetId 资产
	 * @return 当前对象
	*/
	public AssetExtEquipment setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 设备IP<br>
	 * 设备IP
	 * @return 设备IP
	*/
	public String getEquipmentIp() {
		return equipmentIp;
	}
	
	/**
	 * 设置 设备IP
	 * @param equipmentIp 设备IP
	 * @return 当前对象
	*/
	public AssetExtEquipment setEquipmentIp(String equipmentIp) {
		this.equipmentIp=equipmentIp;
		return this;
	}
	
	/**
	 * 获得 管理IP<br>
	 * 管理IP
	 * @return 管理IP
	*/
	public String getManageIp() {
		return manageIp;
	}
	
	/**
	 * 设置 管理IP
	 * @param manageIp 管理IP
	 * @return 当前对象
	*/
	public AssetExtEquipment setManageIp(String manageIp) {
		this.manageIp=manageIp;
		return this;
	}
	
	/**
	 * 获得 设备CPU<br>
	 * 设备CPU
	 * @return 设备CPU
	*/
	public String getEquipmentCpu() {
		return equipmentCpu;
	}
	
	/**
	 * 设置 设备CPU
	 * @param equipmentCpu 设备CPU
	 * @return 当前对象
	*/
	public AssetExtEquipment setEquipmentCpu(String equipmentCpu) {
		this.equipmentCpu=equipmentCpu;
		return this;
	}
	
	/**
	 * 获得 设备内存<br>
	 * 设备内存
	 * @return 设备内存
	*/
	public String getEquipmentMemory() {
		return equipmentMemory;
	}
	
	/**
	 * 设置 设备内存
	 * @param equipmentMemory 设备内存
	 * @return 当前对象
	*/
	public AssetExtEquipment setEquipmentMemory(String equipmentMemory) {
		this.equipmentMemory=equipmentMemory;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getEquipmentNotes() {
		return equipmentNotes;
	}
	
	/**
	 * 设置 备注
	 * @param equipmentNotes 备注
	 * @return 当前对象
	*/
	public AssetExtEquipment setEquipmentNotes(String equipmentNotes) {
		this.equipmentNotes=equipmentNotes;
		return this;
	}
	
	/**
	 * 获得 描述<br>
	 * 描述
	 * @return 描述
	*/
	public String getEquipmentDesc() {
		return equipmentDesc;
	}
	
	/**
	 * 设置 描述
	 * @param equipmentDesc 描述
	 * @return 当前对象
	*/
	public AssetExtEquipment setEquipmentDesc(String equipmentDesc) {
		this.equipmentDesc=equipmentDesc;
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
	public AssetExtEquipment setAreaId(String areaId) {
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
	public AssetExtEquipment setLayerId(String layerId) {
		this.layerId=layerId;
		return this;
	}
	
	/**
	 * 获得 机柜<br>
	 * 机柜
	 * @return 机柜
	*/
	public String getRackId() {
		return rackId;
	}
	
	/**
	 * 设置 机柜
	 * @param rackId 机柜
	 * @return 当前对象
	*/
	public AssetExtEquipment setRackId(String rackId) {
		this.rackId=rackId;
		return this;
	}
	
	/**
	 * 获得 机柜上位置编号<br>
	 * 机柜上位置编号
	 * @return 机柜上位置编号
	*/
	public Integer getRackUpPositionNumber() {
		return rackUpPositionNumber;
	}
	
	/**
	 * 设置 机柜上位置编号
	 * @param rackUpPositionNumber 机柜上位置编号
	 * @return 当前对象
	*/
	public AssetExtEquipment setRackUpPositionNumber(Integer rackUpPositionNumber) {
		this.rackUpPositionNumber=rackUpPositionNumber;
		return this;
	}
	
	/**
	 * 获得 机柜下位置编号<br>
	 * 机柜下位置编号
	 * @return 机柜下位置编号
	*/
	public Integer getRackDownPositionNumber() {
		return rackDownPositionNumber;
	}
	
	/**
	 * 设置 机柜下位置编号
	 * @param rackDownPositionNumber 机柜下位置编号
	 * @return 当前对象
	*/
	public AssetExtEquipment setRackDownPositionNumber(Integer rackDownPositionNumber) {
		this.rackDownPositionNumber=rackDownPositionNumber;
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
	public AssetExtEquipment setCreateBy(String createBy) {
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
	public AssetExtEquipment setCreateTime(Date createTime) {
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
	public AssetExtEquipment setUpdateBy(String updateBy) {
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
	public AssetExtEquipment setUpdateTime(Date updateTime) {
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
	public AssetExtEquipment setDeleted(Integer deleted) {
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
	public AssetExtEquipment setDeleteBy(String deleteBy) {
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
	public AssetExtEquipment setDeleteTime(Date deleteTime) {
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
	public AssetExtEquipment setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 区域<br>
	 * 区域
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
	public AssetExtEquipment setArea(Area area) {
		this.area=area;
		return this;
	}
	
	/**
	 * 获得 层级<br>
	 * 层级
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
	public AssetExtEquipment setLayer(Layer layer) {
		this.layer=layer;
		return this;
	}
	
	/**
	 * 获得 机柜<br>
	 * 机柜
	 * @return 机柜
	*/
	public Rack getRack() {
		return rack;
	}
	
	/**
	 * 设置 机柜
	 * @param rack 机柜
	 * @return 当前对象
	*/
	public AssetExtEquipment setRack(Rack rack) {
		this.rack=rack;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetExtEquipment setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetExtEquipment , 转换好的 AssetExtEquipment 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetExtEquipment , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetExtEquipment
	 * @param assetExtEquipmentMap 包含实体信息的 Map 对象
	 * @return AssetExtEquipment , 转换好的的 AssetExtEquipment 对象
	*/
	@Transient
	public static AssetExtEquipment createFrom(Map<String,Object> assetExtEquipmentMap) {
		if(assetExtEquipmentMap==null) return null;
		AssetExtEquipment po = EntityContext.create(AssetExtEquipment.class, assetExtEquipmentMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetExtEquipment
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetExtEquipment , 转换好的的 AssetExtEquipment 对象
	*/
	@Transient
	public static AssetExtEquipment createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetExtEquipment po = EntityContext.create(AssetExtEquipment.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetExtEquipment，等同于 new
	 * @return AssetExtEquipment 对象
	*/
	@Transient
	public static AssetExtEquipment create() {
		return EntityContext.create(AssetExtEquipment.class);
	}
}