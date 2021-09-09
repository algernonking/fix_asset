package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetExtEquipment;
import java.util.Date;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.eam.Asset;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:55
 * @sign C49E555FA66D085304686EC2B2564DFE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetExtEquipmentMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 设备编号 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_CODE="equipmentCode";
	
	/**
	 * 设备编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> EQUIPMENT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,EQUIPMENT_CODE, java.lang.String.class, "设备编号", "设备编号", java.lang.String.class, null);
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_STATUS="equipmentStatus";
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> EQUIPMENT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,EQUIPMENT_STATUS, java.lang.String.class, "设备状态", "设备状态", java.lang.String.class, null);
	
	/**
	 * 设备IP , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_IP="equipmentIp";
	
	/**
	 * 设备IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> EQUIPMENT_IP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,EQUIPMENT_IP, java.lang.String.class, "设备IP", "设备IP", java.lang.String.class, null);
	
	/**
	 * 管理IP , 类型: java.lang.String
	*/
	public static final String MANAGE_IP="manageIp";
	
	/**
	 * 管理IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> MANAGE_IP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,MANAGE_IP, java.lang.String.class, "管理IP", "管理IP", java.lang.String.class, null);
	
	/**
	 * 设备CPU , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_CPU="equipmentCpu";
	
	/**
	 * 设备CPU , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> EQUIPMENT_CPU_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,EQUIPMENT_CPU, java.lang.String.class, "设备CPU", "设备CPU", java.lang.String.class, null);
	
	/**
	 * 设备内存 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_MEMORY="equipmentMemory";
	
	/**
	 * 设备内存 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> EQUIPMENT_MEMORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,EQUIPMENT_MEMORY, java.lang.String.class, "设备内存", "设备内存", java.lang.String.class, null);
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final String LAYER_ID="layerId";
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> LAYER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,LAYER_ID, java.lang.String.class, "层级", "层级", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> AREA_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,AREA_ID, java.lang.String.class, "区域", "区域", java.lang.String.class, null);
	
	/**
	 * 机柜 , 类型: java.lang.String
	*/
	public static final String RACK_ID="rackId";
	
	/**
	 * 机柜 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> RACK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,RACK_ID, java.lang.String.class, "机柜", "机柜", java.lang.String.class, null);
	
	/**
	 * 机柜上位置 , 类型: java.lang.Integer
	*/
	public static final String RACK_UP_NUMBER="rackUpNumber";
	
	/**
	 * 机柜上位置 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.Integer> RACK_UP_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,RACK_UP_NUMBER, java.lang.Integer.class, "机柜上位置", "机柜上位置", java.lang.Integer.class, null);
	
	/**
	 * 机柜下位置 , 类型: java.lang.Integer
	*/
	public static final String RACK_DOWN_NUMBER="rackDownNumber";
	
	/**
	 * 机柜下位置 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.Integer> RACK_DOWN_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,RACK_DOWN_NUMBER, java.lang.Integer.class, "机柜下位置", "机柜下位置", java.lang.Integer.class, null);
	
	/**
	 * PDU接口 , 类型: java.lang.String
	*/
	public static final String PDU="pdu";
	
	/**
	 * PDU接口 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> PDU_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,PDU, java.lang.String.class, "PDU接口", "PDU接口", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_NOTES="equipmentNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> EQUIPMENT_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,EQUIPMENT_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_DESC="equipmentDesc";
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> EQUIPMENT_DESC_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,EQUIPMENT_DESC, java.lang.String.class, "描述", "描述", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final String AREA="area";
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,com.dt.platform.domain.datacenter.Area> AREA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,AREA, com.dt.platform.domain.datacenter.Area.class, "区域", "区域", com.dt.platform.domain.datacenter.Area.class, null);
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final String LAYER="layer";
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,com.dt.platform.domain.datacenter.Layer> LAYER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,LAYER, com.dt.platform.domain.datacenter.Layer.class, "层级", "层级", com.dt.platform.domain.datacenter.Layer.class, null);
	
	/**
	 * 机柜 , 类型: com.dt.platform.domain.datacenter.Rack
	*/
	public static final String RACK="rack";
	
	/**
	 * 机柜 , 类型: com.dt.platform.domain.datacenter.Rack
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,com.dt.platform.domain.datacenter.Rack> RACK_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,RACK, com.dt.platform.domain.datacenter.Rack.class, "机柜", "机柜", com.dt.platform.domain.datacenter.Rack.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtEquipment,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtEquipment.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ASSET_ID , EQUIPMENT_CODE , EQUIPMENT_STATUS , EQUIPMENT_IP , MANAGE_IP , EQUIPMENT_CPU , EQUIPMENT_MEMORY , LAYER_ID , AREA_ID , RACK_ID , RACK_UP_NUMBER , RACK_DOWN_NUMBER , PDU , EQUIPMENT_NOTES , EQUIPMENT_DESC , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , AREA , LAYER , RACK , ASSET };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetExtEquipment {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetExtEquipment setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public AssetExtEquipment setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 设备编号
		 * @param equipmentCode 设备编号
		 * @return 当前对象
		*/
		public AssetExtEquipment setEquipmentCode(String equipmentCode) {
			super.change(EQUIPMENT_CODE,super.getEquipmentCode(),equipmentCode);
			super.setEquipmentCode(equipmentCode);
			return this;
		}
		
		/**
		 * 设置 设备状态
		 * @param equipmentStatus 设备状态
		 * @return 当前对象
		*/
		public AssetExtEquipment setEquipmentStatus(String equipmentStatus) {
			super.change(EQUIPMENT_STATUS,super.getEquipmentStatus(),equipmentStatus);
			super.setEquipmentStatus(equipmentStatus);
			return this;
		}
		
		/**
		 * 设置 设备IP
		 * @param equipmentIp 设备IP
		 * @return 当前对象
		*/
		public AssetExtEquipment setEquipmentIp(String equipmentIp) {
			super.change(EQUIPMENT_IP,super.getEquipmentIp(),equipmentIp);
			super.setEquipmentIp(equipmentIp);
			return this;
		}
		
		/**
		 * 设置 管理IP
		 * @param manageIp 管理IP
		 * @return 当前对象
		*/
		public AssetExtEquipment setManageIp(String manageIp) {
			super.change(MANAGE_IP,super.getManageIp(),manageIp);
			super.setManageIp(manageIp);
			return this;
		}
		
		/**
		 * 设置 设备CPU
		 * @param equipmentCpu 设备CPU
		 * @return 当前对象
		*/
		public AssetExtEquipment setEquipmentCpu(String equipmentCpu) {
			super.change(EQUIPMENT_CPU,super.getEquipmentCpu(),equipmentCpu);
			super.setEquipmentCpu(equipmentCpu);
			return this;
		}
		
		/**
		 * 设置 设备内存
		 * @param equipmentMemory 设备内存
		 * @return 当前对象
		*/
		public AssetExtEquipment setEquipmentMemory(String equipmentMemory) {
			super.change(EQUIPMENT_MEMORY,super.getEquipmentMemory(),equipmentMemory);
			super.setEquipmentMemory(equipmentMemory);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layerId 层级
		 * @return 当前对象
		*/
		public AssetExtEquipment setLayerId(String layerId) {
			super.change(LAYER_ID,super.getLayerId(),layerId);
			super.setLayerId(layerId);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param areaId 区域
		 * @return 当前对象
		*/
		public AssetExtEquipment setAreaId(String areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
			return this;
		}
		
		/**
		 * 设置 机柜
		 * @param rackId 机柜
		 * @return 当前对象
		*/
		public AssetExtEquipment setRackId(String rackId) {
			super.change(RACK_ID,super.getRackId(),rackId);
			super.setRackId(rackId);
			return this;
		}
		
		/**
		 * 设置 机柜上位置
		 * @param rackUpNumber 机柜上位置
		 * @return 当前对象
		*/
		public AssetExtEquipment setRackUpNumber(Integer rackUpNumber) {
			super.change(RACK_UP_NUMBER,super.getRackUpNumber(),rackUpNumber);
			super.setRackUpNumber(rackUpNumber);
			return this;
		}
		
		/**
		 * 设置 机柜下位置
		 * @param rackDownNumber 机柜下位置
		 * @return 当前对象
		*/
		public AssetExtEquipment setRackDownNumber(Integer rackDownNumber) {
			super.change(RACK_DOWN_NUMBER,super.getRackDownNumber(),rackDownNumber);
			super.setRackDownNumber(rackDownNumber);
			return this;
		}
		
		/**
		 * 设置 PDU接口
		 * @param pdu PDU接口
		 * @return 当前对象
		*/
		public AssetExtEquipment setPdu(String pdu) {
			super.change(PDU,super.getPdu(),pdu);
			super.setPdu(pdu);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param equipmentNotes 备注
		 * @return 当前对象
		*/
		public AssetExtEquipment setEquipmentNotes(String equipmentNotes) {
			super.change(EQUIPMENT_NOTES,super.getEquipmentNotes(),equipmentNotes);
			super.setEquipmentNotes(equipmentNotes);
			return this;
		}
		
		/**
		 * 设置 描述
		 * @param equipmentDesc 描述
		 * @return 当前对象
		*/
		public AssetExtEquipment setEquipmentDesc(String equipmentDesc) {
			super.change(EQUIPMENT_DESC,super.getEquipmentDesc(),equipmentDesc);
			super.setEquipmentDesc(equipmentDesc);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetExtEquipment setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetExtEquipment setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetExtEquipment setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetExtEquipment setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetExtEquipment setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetExtEquipment setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetExtEquipment setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetExtEquipment setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param area 区域
		 * @return 当前对象
		*/
		public AssetExtEquipment setArea(Area area) {
			super.change(AREA,super.getArea(),area);
			super.setArea(area);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layer 层级
		 * @return 当前对象
		*/
		public AssetExtEquipment setLayer(Layer layer) {
			super.change(LAYER,super.getLayer(),layer);
			super.setLayer(layer);
			return this;
		}
		
		/**
		 * 设置 机柜
		 * @param rack 机柜
		 * @return 当前对象
		*/
		public AssetExtEquipment setRack(Rack rack) {
			super.change(RACK,super.getRack(),rack);
			super.setRack(rack);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public AssetExtEquipment setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
	}
}