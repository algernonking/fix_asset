package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetHandle;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-17 10:18:49
 * @sign B01AAEFE38571F139290CD8CBBC13341
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetHandleMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 单据状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 单据状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,STATUS, java.lang.String.class, "单据状态", "单据状态", java.lang.String.class, null);
	
	/**
	 * 单据编号 , 类型: java.lang.String
	*/
	public static final String BUSI_CODE="busiCode";
	
	/**
	 * 单据编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> BUSI_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,BUSI_CODE, java.lang.String.class, "单据编号", "单据编号", java.lang.String.class, null);
	
	/**
	 * 单据名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 单据名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,NAME, java.lang.String.class, "单据名称", "单据名称", java.lang.String.class, null);
	
	/**
	 * 处置类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 处置类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,TYPE, java.lang.String.class, "处置类型", "处置类型", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 处置数量 , 类型: java.math.BigDecimal
	*/
	public static final String HANDLE_NUMBER="handleNumber";
	
	/**
	 * 处置数量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.math.BigDecimal> HANDLE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,HANDLE_NUMBER, java.math.BigDecimal.class, "处置数量", "处置数量", java.math.BigDecimal.class, null);
	
	/**
	 * 处理日期 , 类型: java.util.Date
	*/
	public static final String HANDLE_DATE="handleDate";
	
	/**
	 * 处理日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.util.Date> HANDLE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,HANDLE_DATE, java.util.Date.class, "处理日期", "处理日期", java.util.Date.class, null);
	
	/**
	 * 计划完成时间 , 类型: java.util.Date
	*/
	public static final String PLAN_FINISH_DATE="planFinishDate";
	
	/**
	 * 计划完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.util.Date> PLAN_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,PLAN_FINISH_DATE, java.util.Date.class, "计划完成时间", "计划完成时间", java.util.Date.class, null);
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final String ACTUAL_FINISH_DATE="actualFinishDate";
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.util.Date> ACTUAL_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,ACTUAL_FINISH_DATE, java.util.Date.class, "实际完成时间", "实际完成时间", java.util.Date.class, null);
	
	/**
	 * 制单人 , 操作人 , 类型: java.lang.String
	*/
	public static final String OPERUSER_ID="operuserId";
	
	/**
	 * 制单人 , 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> OPERUSER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,OPERUSER_ID, java.lang.String.class, "制单人", "操作人", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetHandle,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetHandle.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROC_ID , STATUS , BUSI_CODE , NAME , TYPE , CONTENT , HANDLE_NUMBER , HANDLE_DATE , PLAN_FINISH_DATE , ACTUAL_FINISH_DATE , OPERUSER_ID , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetHandle {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetHandle setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetHandle setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 单据状态
		 * @param status 单据状态
		 * @return 当前对象
		*/
		public AssetHandle setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 单据编号
		 * @param busiCode 单据编号
		 * @return 当前对象
		*/
		public AssetHandle setBusiCode(String busiCode) {
			super.change(BUSI_CODE,super.getBusiCode(),busiCode);
			super.setBusiCode(busiCode);
			return this;
		}
		
		/**
		 * 设置 单据名称
		 * @param name 单据名称
		 * @return 当前对象
		*/
		public AssetHandle setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 处置类型
		 * @param type 处置类型
		 * @return 当前对象
		*/
		public AssetHandle setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public AssetHandle setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 处置数量
		 * @param handleNumber 处置数量
		 * @return 当前对象
		*/
		public AssetHandle setHandleNumber(BigDecimal handleNumber) {
			super.change(HANDLE_NUMBER,super.getHandleNumber(),handleNumber);
			super.setHandleNumber(handleNumber);
			return this;
		}
		
		/**
		 * 设置 处理日期
		 * @param handleDate 处理日期
		 * @return 当前对象
		*/
		public AssetHandle setHandleDate(Date handleDate) {
			super.change(HANDLE_DATE,super.getHandleDate(),handleDate);
			super.setHandleDate(handleDate);
			return this;
		}
		
		/**
		 * 设置 计划完成时间
		 * @param planFinishDate 计划完成时间
		 * @return 当前对象
		*/
		public AssetHandle setPlanFinishDate(Date planFinishDate) {
			super.change(PLAN_FINISH_DATE,super.getPlanFinishDate(),planFinishDate);
			super.setPlanFinishDate(planFinishDate);
			return this;
		}
		
		/**
		 * 设置 实际完成时间
		 * @param actualFinishDate 实际完成时间
		 * @return 当前对象
		*/
		public AssetHandle setActualFinishDate(Date actualFinishDate) {
			super.change(ACTUAL_FINISH_DATE,super.getActualFinishDate(),actualFinishDate);
			super.setActualFinishDate(actualFinishDate);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param operuserId 制单人
		 * @return 当前对象
		*/
		public AssetHandle setOperuserId(String operuserId) {
			super.change(OPERUSER_ID,super.getOperuserId(),operuserId);
			super.setOperuserId(operuserId);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public AssetHandle setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetHandle setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetHandle setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetHandle setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetHandle setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetHandle setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetHandle setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetHandle setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetHandle setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetHandle setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}