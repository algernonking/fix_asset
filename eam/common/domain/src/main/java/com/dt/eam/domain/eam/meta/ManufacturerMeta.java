package com.dt.eam.domain.eam.meta;

import com.dt.eam.domain.eam.Manufacturer;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-25 13:25:46
 * @sign 5E0067CB73A2FAD378EA6F251B3BD5B7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ManufacturerMeta {
	
	/**
	 * 主键
	*/
	public static final String ID="id";
	
	/**
	 * 名称
	*/
	public static final String MANUFACTURER_NAME="manufacturerName";
	
	/**
	 * 所在地
	*/
	public static final String LOCATION="location";
	
	/**
	 * 备注
	*/
	public static final String MANUFACTURER_NOTES="manufacturerNotes";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MANUFACTURER_NAME , LOCATION , MANUFACTURER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.eam.domain.eam.Manufacturer {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Manufacturer setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param manufacturerName 名称
		 * @return 当前对象
		*/
		public Manufacturer setManufacturerName(String manufacturerName) {
			super.change(MANUFACTURER_NAME,super.getManufacturerName(),manufacturerName);
			super.setManufacturerName(manufacturerName);
			return this;
		}
		
		/**
		 * 设置 所在地
		 * @param location 所在地
		 * @return 当前对象
		*/
		public Manufacturer setLocation(String location) {
			super.change(LOCATION,super.getLocation(),location);
			super.setLocation(location);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param manufacturerNotes 备注
		 * @return 当前对象
		*/
		public Manufacturer setManufacturerNotes(String manufacturerNotes) {
			super.change(MANUFACTURER_NOTES,super.getManufacturerNotes(),manufacturerNotes);
			super.setManufacturerNotes(manufacturerNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Manufacturer setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Manufacturer setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Manufacturer setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Manufacturer setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Manufacturer setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Manufacturer setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Manufacturer setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Manufacturer setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}