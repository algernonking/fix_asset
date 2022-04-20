package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.GoodsStock;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.Brand;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 13:15:09
 * @sign 413570DC08AC047448B23BE995B36C4C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class GoodsStockMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,CATEGORY_ID, java.lang.String.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 物品名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 物品名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,NAME, java.lang.String.class, "物品名称", "物品名称", java.lang.String.class, null);
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,CODE, java.lang.String.class, "物品编码", "物品编码", java.lang.String.class, null);
	
	/**
	 * 物品条码 , 类型: java.lang.String
	*/
	public static final String BAR_CODE="barCode";
	
	/**
	 * 物品条码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> BAR_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,BAR_CODE, java.lang.String.class, "物品条码", "物品条码", java.lang.String.class, null);
	
	/**
	 * 规格型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 规格型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,MODEL, java.lang.String.class, "规格型号", "规格型号", java.lang.String.class, null);
	
	/**
	 * 厂商 , 类型: java.lang.String
	*/
	public static final String MANUFACTURER_ID="manufacturerId";
	
	/**
	 * 厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> MANUFACTURER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,MANUFACTURER_ID, java.lang.String.class, "厂商", "厂商", java.lang.String.class, null);
	
	/**
	 * 品牌商标 , 类型: java.lang.String
	*/
	public static final String BRAND_ID="brandId";
	
	/**
	 * 品牌商标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> BRAND_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,BRAND_ID, java.lang.String.class, "品牌商标", "品牌商标", java.lang.String.class, null);
	
	/**
	 * 默认单价 , 类型: java.math.BigDecimal
	*/
	public static final String DEFAULT_PRICE="defaultPrice";
	
	/**
	 * 默认单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.math.BigDecimal> DEFAULT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,DEFAULT_PRICE, java.math.BigDecimal.class, "默认单价", "默认单价", java.math.BigDecimal.class, null);
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,UNIT, java.lang.String.class, "计量单位", "计量单位", java.lang.String.class, null);
	
	/**
	 * 安全库存下限 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_MIN="stockMin";
	
	/**
	 * 安全库存下限 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.math.BigDecimal> STOCK_MIN_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,STOCK_MIN, java.math.BigDecimal.class, "安全库存下限", "安全库存下限", java.math.BigDecimal.class, null);
	
	/**
	 * 安全库存上限 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_MAX="stockMax";
	
	/**
	 * 安全库存上限 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.math.BigDecimal> STOCK_MAX_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,STOCK_MAX, java.math.BigDecimal.class, "安全库存上限", "安全库存上限", java.math.BigDecimal.class, null);
	
	/**
	 * 安全库存 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_SECURITY="stockSecurity";
	
	/**
	 * 安全库存 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.math.BigDecimal> STOCK_SECURITY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,STOCK_SECURITY, java.math.BigDecimal.class, "安全库存", "安全库存", java.math.BigDecimal.class, null);
	
	/**
	 * 物品图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 物品图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,PICTURE_ID, java.lang.String.class, "物品图片", "物品图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 资产分类 , 类型: com.dt.platform.domain.eam.Category
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 类型: com.dt.platform.domain.eam.Category
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,com.dt.platform.domain.eam.Category> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,CATEGORY, com.dt.platform.domain.eam.Category.class, "资产分类", "资产分类", com.dt.platform.domain.eam.Category.class, null);
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final String MANUFACTURER="manufacturer";
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,com.dt.platform.domain.eam.Manufacturer> MANUFACTURER_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,MANUFACTURER, com.dt.platform.domain.eam.Manufacturer.class, "生产厂商", "生产厂商", com.dt.platform.domain.eam.Manufacturer.class, null);
	
	/**
	 * 品牌 , 类型: com.dt.platform.domain.eam.Brand
	*/
	public static final String BRAND="brand";
	
	/**
	 * 品牌 , 类型: com.dt.platform.domain.eam.Brand
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStock,com.dt.platform.domain.eam.Brand> BRAND_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStock.class ,BRAND, com.dt.platform.domain.eam.Brand.class, "品牌", "品牌", com.dt.platform.domain.eam.Brand.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CATEGORY_ID , STATUS , NAME , CODE , BAR_CODE , MODEL , MANUFACTURER_ID , BRAND_ID , DEFAULT_PRICE , UNIT , STOCK_MIN , STOCK_MAX , STOCK_SECURITY , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CATEGORY , MANUFACTURER , BRAND };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.GoodsStock {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public GoodsStock setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param categoryId 资产分类
		 * @return 当前对象
		*/
		public GoodsStock setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public GoodsStock setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 物品名称
		 * @param name 物品名称
		 * @return 当前对象
		*/
		public GoodsStock setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 物品编码
		 * @param code 物品编码
		 * @return 当前对象
		*/
		public GoodsStock setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 物品条码
		 * @param barCode 物品条码
		 * @return 当前对象
		*/
		public GoodsStock setBarCode(String barCode) {
			super.change(BAR_CODE,super.getBarCode(),barCode);
			super.setBarCode(barCode);
			return this;
		}
		
		/**
		 * 设置 规格型号
		 * @param model 规格型号
		 * @return 当前对象
		*/
		public GoodsStock setModel(String model) {
			super.change(MODEL,super.getModel(),model);
			super.setModel(model);
			return this;
		}
		
		/**
		 * 设置 厂商
		 * @param manufacturerId 厂商
		 * @return 当前对象
		*/
		public GoodsStock setManufacturerId(String manufacturerId) {
			super.change(MANUFACTURER_ID,super.getManufacturerId(),manufacturerId);
			super.setManufacturerId(manufacturerId);
			return this;
		}
		
		/**
		 * 设置 品牌商标
		 * @param brandId 品牌商标
		 * @return 当前对象
		*/
		public GoodsStock setBrandId(String brandId) {
			super.change(BRAND_ID,super.getBrandId(),brandId);
			super.setBrandId(brandId);
			return this;
		}
		
		/**
		 * 设置 默认单价
		 * @param defaultPrice 默认单价
		 * @return 当前对象
		*/
		public GoodsStock setDefaultPrice(BigDecimal defaultPrice) {
			super.change(DEFAULT_PRICE,super.getDefaultPrice(),defaultPrice);
			super.setDefaultPrice(defaultPrice);
			return this;
		}
		
		/**
		 * 设置 计量单位
		 * @param unit 计量单位
		 * @return 当前对象
		*/
		public GoodsStock setUnit(String unit) {
			super.change(UNIT,super.getUnit(),unit);
			super.setUnit(unit);
			return this;
		}
		
		/**
		 * 设置 安全库存下限
		 * @param stockMin 安全库存下限
		 * @return 当前对象
		*/
		public GoodsStock setStockMin(BigDecimal stockMin) {
			super.change(STOCK_MIN,super.getStockMin(),stockMin);
			super.setStockMin(stockMin);
			return this;
		}
		
		/**
		 * 设置 安全库存上限
		 * @param stockMax 安全库存上限
		 * @return 当前对象
		*/
		public GoodsStock setStockMax(BigDecimal stockMax) {
			super.change(STOCK_MAX,super.getStockMax(),stockMax);
			super.setStockMax(stockMax);
			return this;
		}
		
		/**
		 * 设置 安全库存
		 * @param stockSecurity 安全库存
		 * @return 当前对象
		*/
		public GoodsStock setStockSecurity(BigDecimal stockSecurity) {
			super.change(STOCK_SECURITY,super.getStockSecurity(),stockSecurity);
			super.setStockSecurity(stockSecurity);
			return this;
		}
		
		/**
		 * 设置 物品图片
		 * @param pictureId 物品图片
		 * @return 当前对象
		*/
		public GoodsStock setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public GoodsStock setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public GoodsStock setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public GoodsStock setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public GoodsStock setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public GoodsStock setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public GoodsStock setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public GoodsStock setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public GoodsStock setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public GoodsStock setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public GoodsStock setCategory(Category category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 生产厂商
		 * @param manufacturer 生产厂商
		 * @return 当前对象
		*/
		public GoodsStock setManufacturer(Manufacturer manufacturer) {
			super.change(MANUFACTURER,super.getManufacturer(),manufacturer);
			super.setManufacturer(manufacturer);
			return this;
		}
		
		/**
		 * 设置 品牌
		 * @param brand 品牌
		 * @return 当前对象
		*/
		public GoodsStock setBrand(Brand brand) {
			super.change(BRAND,super.getBrand(),brand);
			super.setBrand(brand);
			return this;
		}
	}
}