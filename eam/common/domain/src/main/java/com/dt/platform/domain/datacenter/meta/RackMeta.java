package com.dt.platform.domain.datacenter.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.datacenter.Rack;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-25 21:22:02
 * @sign 5CB5A32802E4AE817FA2D58DB9975B95
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RackMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> AREA_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,AREA_ID, java.lang.String.class, "区域", "区域", java.lang.String.class, null);
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final String LAYER_ID="layerId";
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> LAYER_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,LAYER_ID, java.lang.String.class, "层级", "层级", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String RACK_CODE="rackCode";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_CODE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String RACK_NAME="rackName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_NAME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 容量 , 类型: java.math.BigDecimal
	*/
	public static final String RACK_CAPTICAL="rackCaptical";
	
	/**
	 * 容量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.math.BigDecimal> RACK_CAPTICAL_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_CAPTICAL, java.math.BigDecimal.class, "容量", "容量", java.math.BigDecimal.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String RACK_LABELS="rackLabels";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_LABELS_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_LABELS, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String RACK_NOTES="rackNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_NOTES_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final String AREA="area";
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,com.dt.platform.domain.datacenter.Area> AREA_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,AREA, com.dt.platform.domain.datacenter.Area.class, "区域", "", com.dt.platform.domain.datacenter.Area.class, null);
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final String LAYER="layer";
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,com.dt.platform.domain.datacenter.Layer> LAYER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,LAYER, com.dt.platform.domain.datacenter.Layer.class, "层级", "", com.dt.platform.domain.datacenter.Layer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , AREA_ID , LAYER_ID , RACK_CODE , RACK_NAME , RACK_CAPTICAL , RACK_LABELS , RACK_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , AREA , LAYER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.datacenter.Rack {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Rack setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param areaId 区域
		 * @return 当前对象
		*/
		public Rack setAreaId(String areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layerId 层级
		 * @return 当前对象
		*/
		public Rack setLayerId(String layerId) {
			super.change(LAYER_ID,super.getLayerId(),layerId);
			super.setLayerId(layerId);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param rackCode 编码
		 * @return 当前对象
		*/
		public Rack setRackCode(String rackCode) {
			super.change(RACK_CODE,super.getRackCode(),rackCode);
			super.setRackCode(rackCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param rackName 名称
		 * @return 当前对象
		*/
		public Rack setRackName(String rackName) {
			super.change(RACK_NAME,super.getRackName(),rackName);
			super.setRackName(rackName);
			return this;
		}
		
		/**
		 * 设置 容量
		 * @param rackCaptical 容量
		 * @return 当前对象
		*/
		public Rack setRackCaptical(BigDecimal rackCaptical) {
			super.change(RACK_CAPTICAL,super.getRackCaptical(),rackCaptical);
			super.setRackCaptical(rackCaptical);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param rackLabels 标签
		 * @return 当前对象
		*/
		public Rack setRackLabels(String rackLabels) {
			super.change(RACK_LABELS,super.getRackLabels(),rackLabels);
			super.setRackLabels(rackLabels);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param rackNotes 备注
		 * @return 当前对象
		*/
		public Rack setRackNotes(String rackNotes) {
			super.change(RACK_NOTES,super.getRackNotes(),rackNotes);
			super.setRackNotes(rackNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Rack setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Rack setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Rack setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Rack setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Rack setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Rack setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Rack setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Rack setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param area 区域
		 * @return 当前对象
		*/
		public Rack setArea(Area area) {
			super.change(AREA,super.getArea(),area);
			super.setArea(area);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layer 层级
		 * @return 当前对象
		*/
		public Rack setLayer(Layer layer) {
			super.change(LAYER,super.getLayer(),layer);
			super.setLayer(layer);
			return this;
		}
	}
}