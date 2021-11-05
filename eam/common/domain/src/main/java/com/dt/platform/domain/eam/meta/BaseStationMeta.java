package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.BaseStation;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Position;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-03 15:24:02
 * @sign 2FB38690CF4235B69861282A362ED1DD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BaseStationMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 区域主键 , 类型: java.lang.String
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 区域主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> AREA_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,AREA_ID, java.lang.String.class, "区域主键", "区域主键", java.lang.String.class, null);
	
	/**
	 * 基站名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 基站名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,NAME, java.lang.String.class, "基站名称", "基站名称", java.lang.String.class, null);
	
	/**
	 * 经度 , 类型: java.math.BigDecimal
	*/
	public static final String LONGITUDE="longitude";
	
	/**
	 * 经度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.math.BigDecimal> LONGITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,LONGITUDE, java.math.BigDecimal.class, "经度", "经度", java.math.BigDecimal.class, null);
	
	/**
	 * 纬度 , 类型: java.math.BigDecimal
	*/
	public static final String LATITUDE="latitude";
	
	/**
	 * 纬度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.math.BigDecimal> LATITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,LATITUDE, java.math.BigDecimal.class, "纬度", "纬度", java.math.BigDecimal.class, null);
	
	/**
	 * 设备ID , 类型: java.lang.String
	*/
	public static final String DEVICE_ID="deviceId";
	
	/**
	 * 设备ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> DEVICE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,DEVICE_ID, java.lang.String.class, "设备ID", "设备ID", java.lang.String.class, null);
	
	/**
	 * 设备类型 , 1：无源；2：有源 , 类型: java.lang.String
	*/
	public static final String DEVICE_TYPE="deviceType";
	
	/**
	 * 设备类型 , 1：无源；2：有源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> DEVICE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,DEVICE_TYPE, java.lang.String.class, "设备类型", "1：无源；2：有源", java.lang.String.class, null);
	
	/**
	 * 是否在线 , 类型: java.lang.Integer
	*/
	public static final String IS_ON_LINE="isOnLine";
	
	/**
	 * 是否在线 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.Integer> IS_ON_LINE_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,IS_ON_LINE, java.lang.Integer.class, "是否在线", "是否在线", java.lang.Integer.class, null);
	
	/**
	 * 工作类型 , 1：入基站；2：出基站；3：范围基站；4：工位基站 , 类型: java.lang.String
	*/
	public static final String WORK_TYPE="workType";
	
	/**
	 * 工作类型 , 1：入基站；2：出基站；3：范围基站；4：工位基站 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> WORK_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,WORK_TYPE, java.lang.String.class, "工作类型", "1：入基站；2：出基站；3：范围基站；4：工位基站", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 基站区域 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String DEVICE_AREA="deviceArea";
	
	/**
	 * 基站区域 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.BaseStation,com.dt.platform.domain.eam.Position> DEVICE_AREA_PROP = new BeanProperty(com.dt.platform.domain.eam.BaseStation.class ,DEVICE_AREA, com.dt.platform.domain.eam.Position.class, "基站区域", "基站区域", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , AREA_ID , NAME , LONGITUDE , LATITUDE , DEVICE_ID , DEVICE_TYPE , IS_ON_LINE , WORK_TYPE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , DEVICE_AREA };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.BaseStation {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public BaseStation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 区域主键
		 * @param areaId 区域主键
		 * @return 当前对象
		*/
		public BaseStation setAreaId(String areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
			return this;
		}
		
		/**
		 * 设置 基站名称
		 * @param name 基站名称
		 * @return 当前对象
		*/
		public BaseStation setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 经度
		 * @param longitude 经度
		 * @return 当前对象
		*/
		public BaseStation setLongitude(BigDecimal longitude) {
			super.change(LONGITUDE,super.getLongitude(),longitude);
			super.setLongitude(longitude);
			return this;
		}
		
		/**
		 * 设置 纬度
		 * @param latitude 纬度
		 * @return 当前对象
		*/
		public BaseStation setLatitude(BigDecimal latitude) {
			super.change(LATITUDE,super.getLatitude(),latitude);
			super.setLatitude(latitude);
			return this;
		}
		
		/**
		 * 设置 设备ID
		 * @param deviceId 设备ID
		 * @return 当前对象
		*/
		public BaseStation setDeviceId(String deviceId) {
			super.change(DEVICE_ID,super.getDeviceId(),deviceId);
			super.setDeviceId(deviceId);
			return this;
		}
		
		/**
		 * 设置 设备类型
		 * @param deviceType 设备类型
		 * @return 当前对象
		*/
		public BaseStation setDeviceType(String deviceType) {
			super.change(DEVICE_TYPE,super.getDeviceType(),deviceType);
			super.setDeviceType(deviceType);
			return this;
		}
		
		/**
		 * 设置 是否在线
		 * @param isOnLine 是否在线
		 * @return 当前对象
		*/
		public BaseStation setIsOnLine(Integer isOnLine) {
			super.change(IS_ON_LINE,super.getIsOnLine(),isOnLine);
			super.setIsOnLine(isOnLine);
			return this;
		}
		
		/**
		 * 设置 工作类型
		 * @param workType 工作类型
		 * @return 当前对象
		*/
		public BaseStation setWorkType(String workType) {
			super.change(WORK_TYPE,super.getWorkType(),workType);
			super.setWorkType(workType);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public BaseStation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public BaseStation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public BaseStation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public BaseStation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public BaseStation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public BaseStation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public BaseStation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public BaseStation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 基站区域
		 * @param deviceArea 基站区域
		 * @return 当前对象
		*/
		public BaseStation setDeviceArea(Position deviceArea) {
			super.change(DEVICE_AREA,super.getDeviceArea(),deviceArea);
			super.setDeviceArea(deviceArea);
			return this;
		}
	}
}