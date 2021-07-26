package com.dt.platform.domain.datacenter.meta;

import com.dt.platform.domain.datacenter.Rack;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.datacenter.DcInfo;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-26 17:58:28
 * @sign 760427217E66C0777DC9974CF7517CCD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RackMeta {
	
	/**
	 * 主键
	*/
	public static final String ID="id";
	
	/**
	 * 数据中心
	*/
	public static final String DC_ID="dcId";
	
	/**
	 * 编码
	*/
	public static final String RACK_CODE="rackCode";
	
	/**
	 * 名称
	*/
	public static final String RACK_NAME="rackName";
	
	/**
	 * 容量
	*/
	public static final String RACK_CAPTICAL="rackCaptical";
	
	/**
	 * 标签
	*/
	public static final String RACK_LABELS="rackLabels";
	
	/**
	 * 备注
	*/
	public static final String RACK_NOTES="rackNotes";
	
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
	 * version
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据中心 , 数据中心名称
	*/
	public static final String DC_NAME="dcName";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DC_ID , RACK_CODE , RACK_NAME , RACK_CAPTICAL , RACK_LABELS , RACK_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , DC_NAME };
	
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
		 * 设置 数据中心
		 * @param dcId 数据中心
		 * @return 当前对象
		*/
		public Rack setDcId(String dcId) {
			super.change(DC_ID,super.getDcId(),dcId);
			super.setDcId(dcId);
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
		 * 设置 数据中心
		 * @param dcName 数据中心
		 * @return 当前对象
		*/
		public Rack setDcName(DcInfo dcName) {
			super.change(DC_NAME,super.getDcName(),dcName);
			super.setDcName(dcName);
			return this;
		}
	}
}