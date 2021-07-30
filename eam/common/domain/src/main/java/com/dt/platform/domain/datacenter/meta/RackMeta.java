package com.dt.platform.domain.datacenter.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.datacenter.Rack;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.datacenter.DcInfo;
import com.dt.platform.domain.datacenter.RackArea;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-30 16:52:47
 * @sign 0190C32989C14F624CB2F18E3DD3565B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RackMeta {
	
	/**
	 * 主键
	*/
	public static final String ID="id";
	
	/**
	 * 主键
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> ID_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 数据中心
	*/
	public static final String DC_ID="dcId";
	
	/**
	 * 数据中心
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> DC_ID_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DC_ID, java.lang.String.class, "数据中心", "数据中心", java.lang.String.class, null);
	
	/**
	 * 机柜区域
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 机柜区域
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> AREA_ID_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,AREA_ID, java.lang.String.class, "机柜区域", "机柜区域", java.lang.String.class, null);
	
	/**
	 * 编码
	*/
	public static final String RACK_CODE="rackCode";
	
	/**
	 * 编码
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_CODE_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称
	*/
	public static final String RACK_NAME="rackName";
	
	/**
	 * 名称
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_NAME_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 容量
	*/
	public static final String RACK_CAPTICAL="rackCaptical";
	
	/**
	 * 容量
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.math.BigDecimal> RACK_CAPTICAL_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_CAPTICAL, java.math.BigDecimal.class, "容量", "容量", java.math.BigDecimal.class, null);
	
	/**
	 * 标签
	*/
	public static final String RACK_LABELS="rackLabels";
	
	/**
	 * 标签
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_LABELS_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_LABELS, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 备注
	*/
	public static final String RACK_NOTES="rackNotes";
	
	/**
	 * 备注
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> RACK_NOTES_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> CREATE_BY_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> CREATE_TIME_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> UPDATE_BY_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> UPDATE_TIME_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> DELETED_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.String> DELETE_BY_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.util.Date> DELETE_TIME_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version
	*/
	public static final String VERSION="version";
	
	/**
	 * version
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,java.lang.Integer> VERSION_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 机柜所属数据中心
	*/
	public static final String INFO="info";
	
	/**
	 * 机柜所属数据中心
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,com.dt.platform.domain.datacenter.DcInfo> INFO_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,INFO, com.dt.platform.domain.datacenter.DcInfo.class, "机柜所属数据中心", "", com.dt.platform.domain.datacenter.DcInfo.class, null);
	
	/**
	 * 机柜所属区域
	*/
	public static final String RACK_AREA="rackArea";
	
	/**
	 * 机柜所属区域
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.Rack,com.dt.platform.domain.datacenter.RackArea> RACK_AREA_PROP=new BeanProperty(com.dt.platform.domain.datacenter.Rack.class ,RACK_AREA, com.dt.platform.domain.datacenter.RackArea.class, "机柜所属区域", "", com.dt.platform.domain.datacenter.RackArea.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DC_ID , AREA_ID , RACK_CODE , RACK_NAME , RACK_CAPTICAL , RACK_LABELS , RACK_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , INFO , RACK_AREA };
	
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
		 * 设置 机柜区域
		 * @param areaId 机柜区域
		 * @return 当前对象
		*/
		public Rack setAreaId(String areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
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
		 * 设置 机柜所属数据中心
		 * @param info 机柜所属数据中心
		 * @return 当前对象
		*/
		public Rack setInfo(DcInfo info) {
			super.change(INFO,super.getInfo(),info);
			super.setInfo(info);
			return this;
		}
		
		/**
		 * 设置 机柜所属区域
		 * @param rackArea 机柜所属区域
		 * @return 当前对象
		*/
		public Rack setRackArea(RackArea rackArea) {
			super.change(RACK_AREA,super.getRackArea(),rackArea);
			super.setRackArea(rackArea);
			return this;
		}
	}
}