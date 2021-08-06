package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.Asset;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-05 15:17:41
 * @sign 8F2803FCFE3D79B0FA341A44DB9D25F9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetMeta {
	
	/**
	 * 主键
	*/
	public static final String ID="id";
	
	/**
	 * 主键
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 单据编号
	*/
	public static final String BUSI_CODE="busiCode";
	
	/**
	 * 单据编号
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> BUSI_CODE_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,BUSI_CODE, java.lang.String.class, "单据编号", "单据编号", java.lang.String.class, null);
	
	/**
	 * 资产状态
	*/
	public static final String STATUS="status";
	
	/**
	 * 资产状态
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> STATUS_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,STATUS, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 资产编号
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 资产编号
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> ASSET_CODE_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_CODE, java.lang.String.class, "资产编号", "资产编号", java.lang.String.class, null);
	
	/**
	 * 分类ID
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 分类ID
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> CATEGORY_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CATEGORY_ID, java.lang.String.class, "分类ID", "分类ID", java.lang.String.class, null);
	
	/**
	 * 标准型号ID
	*/
	public static final String GOODS_ID="goodsId";
	
	/**
	 * 标准型号ID
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> GOODS_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,GOODS_ID, java.lang.String.class, "标准型号ID", "标准型号ID", java.lang.String.class, null);
	
	/**
	 * 标准型号资产名称
	*/
	public static final String NAME="name";
	
	/**
	 * 标准型号资产名称
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> NAME_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,NAME, java.lang.String.class, "标准型号资产名称", "标准型号资产名称", java.lang.String.class, null);
	
	/**
	 * 标准型号厂商
	*/
	public static final String MANUFACTURER_ID="manufacturerId";
	
	/**
	 * 标准型号厂商
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> MANUFACTURER_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,MANUFACTURER_ID, java.lang.String.class, "标准型号厂商", "标准型号厂商", java.lang.String.class, null);
	
	/**
	 * 标准型号品牌
	*/
	public static final String BRAND_ID="brandId";
	
	/**
	 * 标准型号品牌
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> BRAND_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,BRAND_ID, java.lang.String.class, "标准型号品牌", "标准型号品牌", java.lang.String.class, null);
	
	/**
	 * 标准型号规格型号
	*/
	public static final String MODEL="model";
	
	/**
	 * 标准型号规格型号
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> MODEL_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,MODEL, java.lang.String.class, "标准型号规格型号", "标准型号规格型号", java.lang.String.class, null);
	
	/**
	 * 标准型号物品图片
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 标准型号物品图片
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> PICTURE_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,PICTURE_ID, java.lang.String.class, "标准型号物品图片", "标准型号物品图片", java.lang.String.class, null);
	
	/**
	 * 标准型号计量单位
	*/
	public static final String UNIT="unit";
	
	/**
	 * 标准型号计量单位
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> UNIT_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,UNIT, java.lang.String.class, "标准型号计量单位", "标准型号计量单位", java.lang.String.class, null);
	
	/**
	 * 标准型号单价
	*/
	public static final String UNIT_PRICE="unitPrice";
	
	/**
	 * 标准型号单价
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.math.BigDecimal> UNIT_PRICE_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,UNIT_PRICE, java.math.BigDecimal.class, "标准型号单价", "标准型号单价", java.math.BigDecimal.class, null);
	
	/**
	 * 资产RFID
	*/
	public static final String RFID="rfid";
	
	/**
	 * 资产RFID
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> RFID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,RFID, java.lang.String.class, "资产RFID", "资产RFID", java.lang.String.class, null);
	
	/**
	 * 资产数量
	*/
	public static final String ASSET_NUMBER="assetNumber";
	
	/**
	 * 资产数量
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.math.BigDecimal> ASSET_NUMBER_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_NUMBER, java.math.BigDecimal.class, "资产数量", "资产数量", java.math.BigDecimal.class, null);
	
	/**
	 * 批次号如果来自库存建议填写库存单据
	*/
	public static final String BATCH_NUMBER="batchNumber";
	
	/**
	 * 批次号如果来自库存建议填写库存单据
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> BATCH_NUMBER_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,BATCH_NUMBER, java.lang.String.class, "批次号如果来自库存建议填写库存单据", "批次号如果来自库存建议填写库存单据", java.lang.String.class, null);
	
	/**
	 * 资产序列号
	*/
	public static final String SN="sn";
	
	/**
	 * 资产序列号
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> SN_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,SN, java.lang.String.class, "资产序列号", "资产序列号", java.lang.String.class, null);
	
	/**
	 * 来源
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> SOURCE_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 来源详情
	*/
	public static final String SOURCE_DETAIL="sourceDetail";
	
	/**
	 * 来源详情
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> SOURCE_DETAIL_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,SOURCE_DETAIL, java.lang.String.class, "来源详情", "来源详情", java.lang.String.class, null);
	
	/**
	 * 存放区域
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 存放区域
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> AREA_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,AREA_ID, java.lang.String.class, "存放区域", "存放区域", java.lang.String.class, null);
	
	/**
	 * 存放地点
	*/
	public static final String PLACE_DETAIL="placeDetail";
	
	/**
	 * 存放地点
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> PLACE_DETAIL_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,PLACE_DETAIL, java.lang.String.class, "存放地点", "存放地点", java.lang.String.class, null);
	
	/**
	 * 使用人员
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 使用人员
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> USER_ID_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,USER_ID, java.lang.String.class, "使用人员", "使用人员", java.lang.String.class, null);
	
	/**
	 * 生产日期
	*/
	public static final String PRODUCTION_DATE="productionDate";
	
	/**
	 * 生产日期
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> PRODUCTION_DATE_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,PRODUCTION_DATE, java.util.Date.class, "生产日期", "生产日期", java.util.Date.class, null);
	
	/**
	 * 入库时间
	*/
	public static final String STORAGE_TIME="storageTime";
	
	/**
	 * 入库时间
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> STORAGE_TIME_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,STORAGE_TIME, java.util.Date.class, "入库时间", "入库时间", java.util.Date.class, null);
	
	/**
	 * 是否显示(显示:1 , 不显示:0,报废后不显示)
	*/
	public static final String DISPLAY="display";
	
	/**
	 * 是否显示(显示:1 , 不显示:0,报废后不显示)
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> DISPLAY_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DISPLAY, java.lang.String.class, "是否显示(显示:1", "不显示:0,报废后不显示)", java.lang.String.class, null);
	
	/**
	 * 备注
	*/
	public static final String ASSETS_NOTES="assetsNotes";
	
	/**
	 * 备注
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> ASSETS_NOTES_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSETS_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> CREATE_BY_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> CREATE_TIME_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> UPDATE_BY_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> UPDATE_TIME_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.Integer> DELETED_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> DELETE_BY_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> DELETE_TIME_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version
	*/
	public static final String VERSION="version";
	
	/**
	 * version
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.Integer> VERSION_PROP=new BeanProperty(com.dt.platform.domain.eam.Asset.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSI_CODE , STATUS , ASSET_CODE , CATEGORY_ID , GOODS_ID , NAME , MANUFACTURER_ID , BRAND_ID , MODEL , PICTURE_ID , UNIT , UNIT_PRICE , RFID , ASSET_NUMBER , BATCH_NUMBER , SN , SOURCE_ID , SOURCE_DETAIL , AREA_ID , PLACE_DETAIL , USER_ID , PRODUCTION_DATE , STORAGE_TIME , DISPLAY , ASSETS_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.Asset {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Asset setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 单据编号
		 * @param busiCode 单据编号
		 * @return 当前对象
		*/
		public Asset setBusiCode(String busiCode) {
			super.change(BUSI_CODE,super.getBusiCode(),busiCode);
			super.setBusiCode(busiCode);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param status 资产状态
		 * @return 当前对象
		*/
		public Asset setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 资产编号
		 * @param assetCode 资产编号
		 * @return 当前对象
		*/
		public Asset setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 分类ID
		 * @param categoryId 分类ID
		 * @return 当前对象
		*/
		public Asset setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 标准型号ID
		 * @param goodsId 标准型号ID
		 * @return 当前对象
		*/
		public Asset setGoodsId(String goodsId) {
			super.change(GOODS_ID,super.getGoodsId(),goodsId);
			super.setGoodsId(goodsId);
			return this;
		}
		
		/**
		 * 设置 标准型号资产名称
		 * @param name 标准型号资产名称
		 * @return 当前对象
		*/
		public Asset setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 标准型号厂商
		 * @param manufacturerId 标准型号厂商
		 * @return 当前对象
		*/
		public Asset setManufacturerId(String manufacturerId) {
			super.change(MANUFACTURER_ID,super.getManufacturerId(),manufacturerId);
			super.setManufacturerId(manufacturerId);
			return this;
		}
		
		/**
		 * 设置 标准型号品牌
		 * @param brandId 标准型号品牌
		 * @return 当前对象
		*/
		public Asset setBrandId(String brandId) {
			super.change(BRAND_ID,super.getBrandId(),brandId);
			super.setBrandId(brandId);
			return this;
		}
		
		/**
		 * 设置 标准型号规格型号
		 * @param model 标准型号规格型号
		 * @return 当前对象
		*/
		public Asset setModel(String model) {
			super.change(MODEL,super.getModel(),model);
			super.setModel(model);
			return this;
		}
		
		/**
		 * 设置 标准型号物品图片
		 * @param pictureId 标准型号物品图片
		 * @return 当前对象
		*/
		public Asset setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 标准型号计量单位
		 * @param unit 标准型号计量单位
		 * @return 当前对象
		*/
		public Asset setUnit(String unit) {
			super.change(UNIT,super.getUnit(),unit);
			super.setUnit(unit);
			return this;
		}
		
		/**
		 * 设置 标准型号单价
		 * @param unitPrice 标准型号单价
		 * @return 当前对象
		*/
		public Asset setUnitPrice(BigDecimal unitPrice) {
			super.change(UNIT_PRICE,super.getUnitPrice(),unitPrice);
			super.setUnitPrice(unitPrice);
			return this;
		}
		
		/**
		 * 设置 资产RFID
		 * @param rfid 资产RFID
		 * @return 当前对象
		*/
		public Asset setRfid(String rfid) {
			super.change(RFID,super.getRfid(),rfid);
			super.setRfid(rfid);
			return this;
		}
		
		/**
		 * 设置 资产数量
		 * @param assetNumber 资产数量
		 * @return 当前对象
		*/
		public Asset setAssetNumber(BigDecimal assetNumber) {
			super.change(ASSET_NUMBER,super.getAssetNumber(),assetNumber);
			super.setAssetNumber(assetNumber);
			return this;
		}
		
		/**
		 * 设置 批次号如果来自库存建议填写库存单据
		 * @param batchNumber 批次号如果来自库存建议填写库存单据
		 * @return 当前对象
		*/
		public Asset setBatchNumber(String batchNumber) {
			super.change(BATCH_NUMBER,super.getBatchNumber(),batchNumber);
			super.setBatchNumber(batchNumber);
			return this;
		}
		
		/**
		 * 设置 资产序列号
		 * @param sn 资产序列号
		 * @return 当前对象
		*/
		public Asset setSn(String sn) {
			super.change(SN,super.getSn(),sn);
			super.setSn(sn);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceId 来源
		 * @return 当前对象
		*/
		public Asset setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 来源详情
		 * @param sourceDetail 来源详情
		 * @return 当前对象
		*/
		public Asset setSourceDetail(String sourceDetail) {
			super.change(SOURCE_DETAIL,super.getSourceDetail(),sourceDetail);
			super.setSourceDetail(sourceDetail);
			return this;
		}
		
		/**
		 * 设置 存放区域
		 * @param areaId 存放区域
		 * @return 当前对象
		*/
		public Asset setAreaId(String areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
			return this;
		}
		
		/**
		 * 设置 存放地点
		 * @param placeDetail 存放地点
		 * @return 当前对象
		*/
		public Asset setPlaceDetail(String placeDetail) {
			super.change(PLACE_DETAIL,super.getPlaceDetail(),placeDetail);
			super.setPlaceDetail(placeDetail);
			return this;
		}
		
		/**
		 * 设置 使用人员
		 * @param userId 使用人员
		 * @return 当前对象
		*/
		public Asset setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 生产日期
		 * @param productionDate 生产日期
		 * @return 当前对象
		*/
		public Asset setProductionDate(Date productionDate) {
			super.change(PRODUCTION_DATE,super.getProductionDate(),productionDate);
			super.setProductionDate(productionDate);
			return this;
		}
		
		/**
		 * 设置 入库时间
		 * @param storageTime 入库时间
		 * @return 当前对象
		*/
		public Asset setStorageTime(Date storageTime) {
			super.change(STORAGE_TIME,super.getStorageTime(),storageTime);
			super.setStorageTime(storageTime);
			return this;
		}
		
		/**
		 * 设置 是否显示(显示:1
		 * @param display 是否显示(显示:1
		 * @return 当前对象
		*/
		public Asset setDisplay(String display) {
			super.change(DISPLAY,super.getDisplay(),display);
			super.setDisplay(display);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param assetsNotes 备注
		 * @return 当前对象
		*/
		public Asset setAssetsNotes(String assetsNotes) {
			super.change(ASSETS_NOTES,super.getAssetsNotes(),assetsNotes);
			super.setAssetsNotes(assetsNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Asset setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Asset setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Asset setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Asset setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Asset setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Asset setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Asset setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Asset setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}