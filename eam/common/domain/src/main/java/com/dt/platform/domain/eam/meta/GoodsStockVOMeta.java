package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.GoodsStockVO;
import java.util.List;
import com.dt.platform.domain.eam.GoodsStock;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.Brand;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-19 07:22:05
 * @sign E61DDEDD383FD9454C0576D5BA324863
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class GoodsStockVOMeta extends GoodsStockMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,CATEGORY_ID, java.lang.String.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 物品名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 物品名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,NAME, java.lang.String.class, "物品名称", "物品名称", java.lang.String.class, null);
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 物品编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,CODE, java.lang.String.class, "物品编码", "物品编码", java.lang.String.class, null);
	
	/**
	 * 物品条码 , 类型: java.lang.String
	*/
	public static final String BAR_CODE="barCode";
	
	/**
	 * 物品条码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> BAR_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,BAR_CODE, java.lang.String.class, "物品条码", "物品条码", java.lang.String.class, null);
	
	/**
	 * 规格型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 规格型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,MODEL, java.lang.String.class, "规格型号", "规格型号", java.lang.String.class, null);
	
	/**
	 * 厂商 , 类型: java.lang.String
	*/
	public static final String MANUFACTURER_ID="manufacturerId";
	
	/**
	 * 厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> MANUFACTURER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,MANUFACTURER_ID, java.lang.String.class, "厂商", "厂商", java.lang.String.class, null);
	
	/**
	 * 品牌商标 , 类型: java.lang.String
	*/
	public static final String BRAND_ID="brandId";
	
	/**
	 * 品牌商标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> BRAND_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,BRAND_ID, java.lang.String.class, "品牌商标", "品牌商标", java.lang.String.class, null);
	
	/**
	 * 默认单价 , 类型: java.math.BigDecimal
	*/
	public static final String DEFAULT_PRICE="defaultPrice";
	
	/**
	 * 默认单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.math.BigDecimal> DEFAULT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,DEFAULT_PRICE, java.math.BigDecimal.class, "默认单价", "默认单价", java.math.BigDecimal.class, null);
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,UNIT, java.lang.String.class, "计量单位", "计量单位", java.lang.String.class, null);
	
	/**
	 * 安全库存下限 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_MIN="stockMin";
	
	/**
	 * 安全库存下限 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.math.BigDecimal> STOCK_MIN_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,STOCK_MIN, java.math.BigDecimal.class, "安全库存下限", "安全库存下限", java.math.BigDecimal.class, null);
	
	/**
	 * 安全库存上限 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_MAX="stockMax";
	
	/**
	 * 安全库存上限 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.math.BigDecimal> STOCK_MAX_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,STOCK_MAX, java.math.BigDecimal.class, "安全库存上限", "安全库存上限", java.math.BigDecimal.class, null);
	
	/**
	 * 安全库存 , 类型: java.math.BigDecimal
	*/
	public static final String STOCK_SECURITY="stockSecurity";
	
	/**
	 * 安全库存 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.math.BigDecimal> STOCK_SECURITY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,STOCK_SECURITY, java.math.BigDecimal.class, "安全库存", "安全库存", java.math.BigDecimal.class, null);
	
	/**
	 * 物品图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 物品图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,PICTURE_ID, java.lang.String.class, "物品图片", "物品图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 资产分类 , 类型: com.dt.platform.domain.eam.Category
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 类型: com.dt.platform.domain.eam.Category
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,com.dt.platform.domain.eam.Category> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,CATEGORY, com.dt.platform.domain.eam.Category.class, "资产分类", "资产分类", com.dt.platform.domain.eam.Category.class, null);
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final String MANUFACTURER="manufacturer";
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,com.dt.platform.domain.eam.Manufacturer> MANUFACTURER_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,MANUFACTURER, com.dt.platform.domain.eam.Manufacturer.class, "生产厂商", "生产厂商", com.dt.platform.domain.eam.Manufacturer.class, null);
	
	/**
	 * 品牌 , 类型: com.dt.platform.domain.eam.Brand
	*/
	public static final String BRAND="brand";
	
	/**
	 * 品牌 , 类型: com.dt.platform.domain.eam.Brand
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockVO,com.dt.platform.domain.eam.Brand> BRAND_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockVO.class ,BRAND, com.dt.platform.domain.eam.Brand.class, "品牌", "品牌", com.dt.platform.domain.eam.Brand.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , CATEGORY_ID , STATUS , NAME , CODE , BAR_CODE , MODEL , MANUFACTURER_ID , BRAND_ID , DEFAULT_PRICE , UNIT , STOCK_MIN , STOCK_MAX , STOCK_SECURITY , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CATEGORY , MANUFACTURER , BRAND };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.GoodsStockVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public GoodsStockVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public GoodsStockVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public GoodsStockVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public GoodsStockVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public GoodsStockVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public GoodsStockVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public GoodsStockVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public GoodsStockVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public GoodsStockVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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