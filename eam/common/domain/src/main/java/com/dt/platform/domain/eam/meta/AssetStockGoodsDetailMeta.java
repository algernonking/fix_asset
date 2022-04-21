package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetStockGoodsDetail;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 06:06:16
 * @sign 300AEBDB19033946A9A6FEC32B8BA9EE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetStockGoodsDetailMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final String GOODS_ID="goodsId";
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.String> GOODS_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,GOODS_ID, java.lang.String.class, "物品编码", "物品编码", java.lang.String.class, null);
	
	/**
	 * 库存单 , 类型: java.lang.String
	*/
	public static final String STOCK_ID="stockId";
	
	/**
	 * 库存单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.String> STOCK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,STOCK_ID, java.lang.String.class, "库存单", "库存单", java.lang.String.class, null);
	
	/**
	 * 入库数量 , 类型: java.math.BigDecimal
	*/
	public static final String IN_NUMBER="inNumber";
	
	/**
	 * 入库数量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.math.BigDecimal> IN_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,IN_NUMBER, java.math.BigDecimal.class, "入库数量", "入库数量", java.math.BigDecimal.class, null);
	
	/**
	 * 当前数量 , 类型: java.math.BigDecimal
	*/
	public static final String CUR_NUMBER="curNumber";
	
	/**
	 * 当前数量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.math.BigDecimal> CUR_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,CUR_NUMBER, java.math.BigDecimal.class, "当前数量", "当前数量", java.math.BigDecimal.class, null);
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final String UNIT_PRICE="unitPrice";
	
	/**
	 * 单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.math.BigDecimal> UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,UNIT_PRICE, java.math.BigDecimal.class, "单价", "单价", java.math.BigDecimal.class, null);
	
	/**
	 * 金额 , 类型: java.math.BigDecimal
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.math.BigDecimal> AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,AMOUNT, java.math.BigDecimal.class, "金额", "金额", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetStockGoodsDetail,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetStockGoodsDetail.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , GOODS_ID , STOCK_ID , IN_NUMBER , CUR_NUMBER , UNIT_PRICE , AMOUNT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetStockGoodsDetail {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 物品编码
		 * @param goodsId 物品编码
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setGoodsId(String goodsId) {
			super.change(GOODS_ID,super.getGoodsId(),goodsId);
			super.setGoodsId(goodsId);
			return this;
		}
		
		/**
		 * 设置 库存单
		 * @param stockId 库存单
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setStockId(String stockId) {
			super.change(STOCK_ID,super.getStockId(),stockId);
			super.setStockId(stockId);
			return this;
		}
		
		/**
		 * 设置 入库数量
		 * @param inNumber 入库数量
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setInNumber(BigDecimal inNumber) {
			super.change(IN_NUMBER,super.getInNumber(),inNumber);
			super.setInNumber(inNumber);
			return this;
		}
		
		/**
		 * 设置 当前数量
		 * @param curNumber 当前数量
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setCurNumber(BigDecimal curNumber) {
			super.change(CUR_NUMBER,super.getCurNumber(),curNumber);
			super.setCurNumber(curNumber);
			return this;
		}
		
		/**
		 * 设置 单价
		 * @param unitPrice 单价
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setUnitPrice(BigDecimal unitPrice) {
			super.change(UNIT_PRICE,super.getUnitPrice(),unitPrice);
			super.setUnitPrice(unitPrice);
			return this;
		}
		
		/**
		 * 设置 金额
		 * @param amount 金额
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setAmount(BigDecimal amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetStockGoodsDetail setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}