package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetExtFinancial;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Supplier;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 11:57:54
 * @sign 637D649AF57723282EFCE1461EAFC9FC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetExtFinancialMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 财务分类 , 类型: java.lang.String
	*/
	public static final String TYPE_ID="typeId";
	
	/**
	 * 财务分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> TYPE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,TYPE_ID, java.lang.String.class, "财务分类", "财务分类", java.lang.String.class, null);
	
	/**
	 * 财务编号 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 财务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,ASSET_CODE, java.lang.String.class, "财务编号", "财务编号", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 来源详情 , 类型: java.lang.String
	*/
	public static final String SOURCE_DETAIL="sourceDetail";
	
	/**
	 * 来源详情 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> SOURCE_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,SOURCE_DETAIL, java.lang.String.class, "来源详情", "来源详情", java.lang.String.class, null);
	
	/**
	 * 资产数量 , 类型: java.lang.Integer
	*/
	public static final String ASSET_NUMBER="assetNumber";
	
	/**
	 * 资产数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.Integer> ASSET_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,ASSET_NUMBER, java.lang.Integer.class, "资产数量", "资产数量", java.lang.Integer.class, null);
	
	/**
	 * 剩余数量 , 类型: java.lang.Integer
	*/
	public static final String REMAIN_NUMBER="remainNumber";
	
	/**
	 * 剩余数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.Integer> REMAIN_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,REMAIN_NUMBER, java.lang.Integer.class, "剩余数量", "剩余数量", java.lang.Integer.class, null);
	
	/**
	 * 资产供应商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_ID="supplierId";
	
	/**
	 * 资产供应商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> SUPPLIER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,SUPPLIER_ID, java.lang.String.class, "资产供应商", "资产供应商", java.lang.String.class, null);
	
	/**
	 * 税额 , 类型: java.math.BigDecimal
	*/
	public static final String TAXAMOUNT_RATE="taxamountRate";
	
	/**
	 * 税额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> TAXAMOUNT_RATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,TAXAMOUNT_RATE, java.math.BigDecimal.class, "税额", "税额", java.math.BigDecimal.class, null);
	
	/**
	 * 含税金额 , 类型: java.math.BigDecimal
	*/
	public static final String TAXAMOUNT_PRICE="taxamountPrice";
	
	/**
	 * 含税金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> TAXAMOUNT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,TAXAMOUNT_PRICE, java.math.BigDecimal.class, "含税金额", "含税金额", java.math.BigDecimal.class, null);
	
	/**
	 * 资产原值(单价) , 类型: java.math.BigDecimal
	*/
	public static final String ORIGINAL_UNIT_PRICE="originalUnitPrice";
	
	/**
	 * 资产原值(单价) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> ORIGINAL_UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,ORIGINAL_UNIT_PRICE, java.math.BigDecimal.class, "资产原值(单价)", "资产原值(单价)", java.math.BigDecimal.class, null);
	
	/**
	 * 累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final String ACCUMULATED_DEPRECIATION="accumulatedDepreciation";
	
	/**
	 * 累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> ACCUMULATED_DEPRECIATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,ACCUMULATED_DEPRECIATION, java.math.BigDecimal.class, "累计折旧", "累计折旧", java.math.BigDecimal.class, null);
	
	/**
	 * 残值率 , 类型: java.math.BigDecimal
	*/
	public static final String RESIDUALS_RATE="residualsRate";
	
	/**
	 * 残值率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> RESIDUALS_RATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,RESIDUALS_RATE, java.math.BigDecimal.class, "残值率", "残值率", java.math.BigDecimal.class, null);
	
	/**
	 * 资产净值 , 类型: java.math.BigDecimal
	*/
	public static final String NAV_PRICE="navPrice";
	
	/**
	 * 资产净值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> NAV_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,NAV_PRICE, java.math.BigDecimal.class, "资产净值", "资产净值", java.math.BigDecimal.class, null);
	
	/**
	 * 采购单价 , 类型: java.math.BigDecimal
	*/
	public static final String PURCHASE_UNIT_PRICE="purchaseUnitPrice";
	
	/**
	 * 采购单价 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> PURCHASE_UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,PURCHASE_UNIT_PRICE, java.math.BigDecimal.class, "采购单价", "采购单价", java.math.BigDecimal.class, null);
	
	/**
	 * 使用期限 , 类型: java.math.BigDecimal
	*/
	public static final String SERVICE_LIFE="serviceLife";
	
	/**
	 * 使用期限 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.math.BigDecimal> SERVICE_LIFE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,SERVICE_LIFE, java.math.BigDecimal.class, "使用期限", "使用期限", java.math.BigDecimal.class, null);
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.util.Date> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,PURCHASE_DATE, java.util.Date.class, "采购日期", "采购日期", java.util.Date.class, null);
	
	/**
	 * 入库时间 , 类型: java.util.Date
	*/
	public static final String STORAGE_TIME="storageTime";
	
	/**
	 * 入库时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.util.Date> STORAGE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,STORAGE_TIME, java.util.Date.class, "入库时间", "入库时间", java.util.Date.class, null);
	
	/**
	 * 入账时间 , 类型: java.util.Date
	*/
	public static final String ENTRY_TIME="entryTime";
	
	/**
	 * 入账时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.util.Date> ENTRY_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,ENTRY_TIME, java.util.Date.class, "入账时间", "入账时间", java.util.Date.class, null);
	
	/**
	 * 财务备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 财务备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,NOTES, java.lang.String.class, "财务备注", "财务备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final String SUPPLIER="supplier";
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetExtFinancial,com.dt.platform.domain.eam.Supplier> SUPPLIER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetExtFinancial.class ,SUPPLIER, com.dt.platform.domain.eam.Supplier.class, "供应商", "供应商", com.dt.platform.domain.eam.Supplier.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ASSET_ID , TYPE_ID , ASSET_CODE , SOURCE_ID , SOURCE_DETAIL , ASSET_NUMBER , REMAIN_NUMBER , SUPPLIER_ID , TAXAMOUNT_RATE , TAXAMOUNT_PRICE , ORIGINAL_UNIT_PRICE , ACCUMULATED_DEPRECIATION , RESIDUALS_RATE , NAV_PRICE , PURCHASE_UNIT_PRICE , SERVICE_LIFE , PURCHASE_DATE , STORAGE_TIME , ENTRY_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SUPPLIER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetExtFinancial {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetExtFinancial setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public AssetExtFinancial setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 财务分类
		 * @param typeId 财务分类
		 * @return 当前对象
		*/
		public AssetExtFinancial setTypeId(String typeId) {
			super.change(TYPE_ID,super.getTypeId(),typeId);
			super.setTypeId(typeId);
			return this;
		}
		
		/**
		 * 设置 财务编号
		 * @param assetCode 财务编号
		 * @return 当前对象
		*/
		public AssetExtFinancial setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceId 来源
		 * @return 当前对象
		*/
		public AssetExtFinancial setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 来源详情
		 * @param sourceDetail 来源详情
		 * @return 当前对象
		*/
		public AssetExtFinancial setSourceDetail(String sourceDetail) {
			super.change(SOURCE_DETAIL,super.getSourceDetail(),sourceDetail);
			super.setSourceDetail(sourceDetail);
			return this;
		}
		
		/**
		 * 设置 资产数量
		 * @param assetNumber 资产数量
		 * @return 当前对象
		*/
		public AssetExtFinancial setAssetNumber(Integer assetNumber) {
			super.change(ASSET_NUMBER,super.getAssetNumber(),assetNumber);
			super.setAssetNumber(assetNumber);
			return this;
		}
		
		/**
		 * 设置 剩余数量
		 * @param remainNumber 剩余数量
		 * @return 当前对象
		*/
		public AssetExtFinancial setRemainNumber(Integer remainNumber) {
			super.change(REMAIN_NUMBER,super.getRemainNumber(),remainNumber);
			super.setRemainNumber(remainNumber);
			return this;
		}
		
		/**
		 * 设置 资产供应商
		 * @param supplierId 资产供应商
		 * @return 当前对象
		*/
		public AssetExtFinancial setSupplierId(String supplierId) {
			super.change(SUPPLIER_ID,super.getSupplierId(),supplierId);
			super.setSupplierId(supplierId);
			return this;
		}
		
		/**
		 * 设置 税额
		 * @param taxamountRate 税额
		 * @return 当前对象
		*/
		public AssetExtFinancial setTaxamountRate(BigDecimal taxamountRate) {
			super.change(TAXAMOUNT_RATE,super.getTaxamountRate(),taxamountRate);
			super.setTaxamountRate(taxamountRate);
			return this;
		}
		
		/**
		 * 设置 含税金额
		 * @param taxamountPrice 含税金额
		 * @return 当前对象
		*/
		public AssetExtFinancial setTaxamountPrice(BigDecimal taxamountPrice) {
			super.change(TAXAMOUNT_PRICE,super.getTaxamountPrice(),taxamountPrice);
			super.setTaxamountPrice(taxamountPrice);
			return this;
		}
		
		/**
		 * 设置 资产原值(单价)
		 * @param originalUnitPrice 资产原值(单价)
		 * @return 当前对象
		*/
		public AssetExtFinancial setOriginalUnitPrice(BigDecimal originalUnitPrice) {
			super.change(ORIGINAL_UNIT_PRICE,super.getOriginalUnitPrice(),originalUnitPrice);
			super.setOriginalUnitPrice(originalUnitPrice);
			return this;
		}
		
		/**
		 * 设置 累计折旧
		 * @param accumulatedDepreciation 累计折旧
		 * @return 当前对象
		*/
		public AssetExtFinancial setAccumulatedDepreciation(BigDecimal accumulatedDepreciation) {
			super.change(ACCUMULATED_DEPRECIATION,super.getAccumulatedDepreciation(),accumulatedDepreciation);
			super.setAccumulatedDepreciation(accumulatedDepreciation);
			return this;
		}
		
		/**
		 * 设置 残值率
		 * @param residualsRate 残值率
		 * @return 当前对象
		*/
		public AssetExtFinancial setResidualsRate(BigDecimal residualsRate) {
			super.change(RESIDUALS_RATE,super.getResidualsRate(),residualsRate);
			super.setResidualsRate(residualsRate);
			return this;
		}
		
		/**
		 * 设置 资产净值
		 * @param navPrice 资产净值
		 * @return 当前对象
		*/
		public AssetExtFinancial setNavPrice(BigDecimal navPrice) {
			super.change(NAV_PRICE,super.getNavPrice(),navPrice);
			super.setNavPrice(navPrice);
			return this;
		}
		
		/**
		 * 设置 采购单价
		 * @param purchaseUnitPrice 采购单价
		 * @return 当前对象
		*/
		public AssetExtFinancial setPurchaseUnitPrice(BigDecimal purchaseUnitPrice) {
			super.change(PURCHASE_UNIT_PRICE,super.getPurchaseUnitPrice(),purchaseUnitPrice);
			super.setPurchaseUnitPrice(purchaseUnitPrice);
			return this;
		}
		
		/**
		 * 设置 使用期限
		 * @param serviceLife 使用期限
		 * @return 当前对象
		*/
		public AssetExtFinancial setServiceLife(BigDecimal serviceLife) {
			super.change(SERVICE_LIFE,super.getServiceLife(),serviceLife);
			super.setServiceLife(serviceLife);
			return this;
		}
		
		/**
		 * 设置 采购日期
		 * @param purchaseDate 采购日期
		 * @return 当前对象
		*/
		public AssetExtFinancial setPurchaseDate(Date purchaseDate) {
			super.change(PURCHASE_DATE,super.getPurchaseDate(),purchaseDate);
			super.setPurchaseDate(purchaseDate);
			return this;
		}
		
		/**
		 * 设置 入库时间
		 * @param storageTime 入库时间
		 * @return 当前对象
		*/
		public AssetExtFinancial setStorageTime(Date storageTime) {
			super.change(STORAGE_TIME,super.getStorageTime(),storageTime);
			super.setStorageTime(storageTime);
			return this;
		}
		
		/**
		 * 设置 入账时间
		 * @param entryTime 入账时间
		 * @return 当前对象
		*/
		public AssetExtFinancial setEntryTime(Date entryTime) {
			super.change(ENTRY_TIME,super.getEntryTime(),entryTime);
			super.setEntryTime(entryTime);
			return this;
		}
		
		/**
		 * 设置 财务备注
		 * @param notes 财务备注
		 * @return 当前对象
		*/
		public AssetExtFinancial setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetExtFinancial setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetExtFinancial setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetExtFinancial setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetExtFinancial setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetExtFinancial setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetExtFinancial setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetExtFinancial setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AssetExtFinancial setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplier 供应商
		 * @return 当前对象
		*/
		public AssetExtFinancial setSupplier(Supplier supplier) {
			super.change(SUPPLIER,super.getSupplier(),supplier);
			super.setSupplier(supplier);
			return this;
		}
	}
}