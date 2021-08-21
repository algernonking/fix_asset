package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.Asset;
import java.util.Date;
import com.dt.platform.domain.eam.AssetExtFinancial;
import com.dt.platform.domain.eam.AssetExtEquipment;
import com.dt.platform.domain.eam.AssetExtSoftware;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.Goods;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.Warehouse;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 09:16:10
 * @sign 53AB89BD9706D4EA231D20626AE1B690
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CATEGORY_ID, java.lang.String.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 分类编码 , 类型: java.lang.String
	*/
	public static final String CATEGORY_CODE="categoryCode";
	
	/**
	 * 分类编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> CATEGORY_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CATEGORY_CODE, java.lang.String.class, "分类编码", "分类编码", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSI_CODE="busiCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> BUSI_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,BUSI_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 批次编码 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,BATCH_CODE, java.lang.String.class, "批次编码", "批次编码", java.lang.String.class, null);
	
	/**
	 * 资产编号 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 资产编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_CODE, java.lang.String.class, "资产编号", "资产编号", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,STATUS, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 是否显示 , 类型: java.lang.String
	*/
	public static final String DISPLAY="display";
	
	/**
	 * 是否显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> DISPLAY_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DISPLAY, java.lang.String.class, "是否显示", "是否显示", java.lang.String.class, null);
	
	/**
	 * 是否报废 , 类型: java.lang.String
	*/
	public static final String SCRAP="scrap";
	
	/**
	 * 是否报废 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> SCRAP_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,SCRAP, java.lang.String.class, "是否报废", "是否报废", java.lang.String.class, null);
	
	/**
	 * 标准物品档案 , 类型: java.lang.String
	*/
	public static final String GOODS_ID="goodsId";
	
	/**
	 * 标准物品档案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> GOODS_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,GOODS_ID, java.lang.String.class, "标准物品档案", "标准物品档案", java.lang.String.class, null);
	
	/**
	 * 标准型号资产名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 标准型号资产名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,NAME, java.lang.String.class, "标准型号资产名称", "标准型号资产名称", java.lang.String.class, null);
	
	/**
	 * 标准型号厂商 , 类型: java.lang.String
	*/
	public static final String MANUFACTURER_ID="manufacturerId";
	
	/**
	 * 标准型号厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> MANUFACTURER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,MANUFACTURER_ID, java.lang.String.class, "标准型号厂商", "标准型号厂商", java.lang.String.class, null);
	
	/**
	 * 标准型号规格型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 标准型号规格型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,MODEL, java.lang.String.class, "标准型号规格型号", "标准型号规格型号", java.lang.String.class, null);
	
	/**
	 * 标准型号物品图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 标准型号物品图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,PICTURE_ID, java.lang.String.class, "标准型号物品图片", "标准型号物品图片", java.lang.String.class, null);
	
	/**
	 * 标准型号计量单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 标准型号计量单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,UNIT, java.lang.String.class, "标准型号计量单位", "标准型号计量单位", java.lang.String.class, null);
	
	/**
	 * 序列号 , 类型: java.lang.String
	*/
	public static final String SERIAL_NUMBER="serialNumber";
	
	/**
	 * 序列号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> SERIAL_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,SERIAL_NUMBER, java.lang.String.class, "序列号", "序列号", java.lang.String.class, null);
	
	/**
	 * 所属单位 , 类型: java.lang.String
	*/
	public static final String MANAGEMENT_COMPANY_ID="managementCompanyId";
	
	/**
	 * 所属单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> MANAGEMENT_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,MANAGEMENT_COMPANY_ID, java.lang.String.class, "所属单位", "所属单位", java.lang.String.class, null);
	
	/**
	 * 管理人员 , 类型: java.lang.String
	*/
	public static final String MANAGER_ID="managerId";
	
	/**
	 * 管理人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,MANAGER_ID, java.lang.String.class, "管理人员", "管理人员", java.lang.String.class, null);
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final String USER_ORGANIZATION_ID="userOrganizationId";
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> USER_ORGANIZATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,USER_ORGANIZATION_ID, java.lang.String.class, "使用公司/部门", "使用公司/部门", java.lang.String.class, null);
	
	/**
	 * 使用人员 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 使用人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,USER_ID, java.lang.String.class, "使用人员", "使用人员", java.lang.String.class, null);
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,POSITION_ID, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 详细位置 , 类型: java.lang.String
	*/
	public static final String POSITION_DETAIL="positionDetail";
	
	/**
	 * 详细位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> POSITION_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,POSITION_DETAIL, java.lang.String.class, "详细位置", "详细位置", java.lang.String.class, null);
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_ID="warehouseId";
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> WAREHOUSE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,WAREHOUSE_ID, java.lang.String.class, "仓库", "仓库", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 资产数量 , 类型: java.lang.Integer
	*/
	public static final String ASSET_NUMBER="assetNumber";
	
	/**
	 * 资产数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.Integer> ASSET_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_NUMBER, java.lang.Integer.class, "资产数量", "资产数量", java.lang.Integer.class, null);
	
	/**
	 * 剩余数量 , 类型: java.lang.Integer
	*/
	public static final String REMAIN_NUMBER="remainNumber";
	
	/**
	 * 剩余数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.Integer> REMAIN_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,REMAIN_NUMBER, java.lang.Integer.class, "剩余数量", "剩余数量", java.lang.Integer.class, null);
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,PURCHASE_DATE, java.util.Date.class, "采购日期", "采购日期", java.util.Date.class, null);
	
	/**
	 * 资产RFID , 类型: java.lang.String
	*/
	public static final String RFID="rfid";
	
	/**
	 * 资产RFID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> RFID_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,RFID, java.lang.String.class, "资产RFID", "资产RFID", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 财务信息 , 类型: com.dt.platform.domain.eam.AssetExtFinancial
	*/
	public static final String ASSET_FINANCIAL="assetFinancial";
	
	/**
	 * 财务信息 , 类型: com.dt.platform.domain.eam.AssetExtFinancial
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.AssetExtFinancial> ASSET_FINANCIAL_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_FINANCIAL, com.dt.platform.domain.eam.AssetExtFinancial.class, "财务信息", "财务信息", com.dt.platform.domain.eam.AssetExtFinancial.class, null);
	
	/**
	 * 维保信息 , 类型: com.dt.platform.domain.eam.AssetExtFinancial
	*/
	public static final String ASSET_MAINTAINER="assetMaintainer";
	
	/**
	 * 维保信息 , 类型: com.dt.platform.domain.eam.AssetExtFinancial
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.AssetExtFinancial> ASSET_MAINTAINER_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_MAINTAINER, com.dt.platform.domain.eam.AssetExtFinancial.class, "维保信息", "维保信息", com.dt.platform.domain.eam.AssetExtFinancial.class, null);
	
	/**
	 * 设备信息 , 类型: com.dt.platform.domain.eam.AssetExtEquipment
	*/
	public static final String ASSET_EQUIPMENT="assetEquipment";
	
	/**
	 * 设备信息 , 类型: com.dt.platform.domain.eam.AssetExtEquipment
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.AssetExtEquipment> ASSET_EQUIPMENT_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_EQUIPMENT, com.dt.platform.domain.eam.AssetExtEquipment.class, "设备信息", "设备信息", com.dt.platform.domain.eam.AssetExtEquipment.class, null);
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetExtSoftware
	*/
	public static final String ASSET_EXT_SOFTWARE="assetExtSoftware";
	
	/**
	 * 软件信息 , 类型: com.dt.platform.domain.eam.AssetExtSoftware
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.AssetExtSoftware> ASSET_EXT_SOFTWARE_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,ASSET_EXT_SOFTWARE, com.dt.platform.domain.eam.AssetExtSoftware.class, "软件信息", "软件信息", com.dt.platform.domain.eam.AssetExtSoftware.class, null);
	
	/**
	 * 资产分类 , 类型: com.dt.platform.domain.eam.Category
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 类型: com.dt.platform.domain.eam.Category
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.Category> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,CATEGORY, com.dt.platform.domain.eam.Category.class, "资产分类", "资产分类", com.dt.platform.domain.eam.Category.class, null);
	
	/**
	 * 物品档案 , 类型: com.dt.platform.domain.eam.Goods
	*/
	public static final String GOODS="goods";
	
	/**
	 * 物品档案 , 类型: com.dt.platform.domain.eam.Goods
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.Goods> GOODS_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,GOODS, com.dt.platform.domain.eam.Goods.class, "物品档案", "物品档案", com.dt.platform.domain.eam.Goods.class, null);
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final String MANUFACTURER="manufacturer";
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.Manufacturer> MANUFACTURER_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,MANUFACTURER, com.dt.platform.domain.eam.Manufacturer.class, "生产厂商", "生产厂商", com.dt.platform.domain.eam.Manufacturer.class, null);
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE="warehouse";
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.Asset,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.Asset.class ,WAREHOUSE, com.dt.platform.domain.eam.Warehouse.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CATEGORY_ID , CATEGORY_CODE , BUSI_CODE , BATCH_CODE , ASSET_CODE , STATUS , DISPLAY , SCRAP , GOODS_ID , NAME , MANUFACTURER_ID , MODEL , PICTURE_ID , UNIT , SERIAL_NUMBER , MANAGEMENT_COMPANY_ID , MANAGER_ID , USER_ORGANIZATION_ID , USER_ID , POSITION_ID , POSITION_DETAIL , WAREHOUSE_ID , SOURCE_ID , ASSET_NUMBER , REMAIN_NUMBER , PURCHASE_DATE , RFID , ATTACH , NOTES , LABEL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSET_FINANCIAL , ASSET_MAINTAINER , ASSET_EQUIPMENT , ASSET_EXT_SOFTWARE , CATEGORY , GOODS , MANUFACTURER , WAREHOUSE };
	
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
		 * 设置 资产分类
		 * @param categoryId 资产分类
		 * @return 当前对象
		*/
		public Asset setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 分类编码
		 * @param categoryCode 分类编码
		 * @return 当前对象
		*/
		public Asset setCategoryCode(String categoryCode) {
			super.change(CATEGORY_CODE,super.getCategoryCode(),categoryCode);
			super.setCategoryCode(categoryCode);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param busiCode 业务编号
		 * @return 当前对象
		*/
		public Asset setBusiCode(String busiCode) {
			super.change(BUSI_CODE,super.getBusiCode(),busiCode);
			super.setBusiCode(busiCode);
			return this;
		}
		
		/**
		 * 设置 批次编码
		 * @param batchCode 批次编码
		 * @return 当前对象
		*/
		public Asset setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
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
		 * 设置 是否显示
		 * @param display 是否显示
		 * @return 当前对象
		*/
		public Asset setDisplay(String display) {
			super.change(DISPLAY,super.getDisplay(),display);
			super.setDisplay(display);
			return this;
		}
		
		/**
		 * 设置 是否报废
		 * @param scrap 是否报废
		 * @return 当前对象
		*/
		public Asset setScrap(String scrap) {
			super.change(SCRAP,super.getScrap(),scrap);
			super.setScrap(scrap);
			return this;
		}
		
		/**
		 * 设置 标准物品档案
		 * @param goodsId 标准物品档案
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
		 * 设置 序列号
		 * @param serialNumber 序列号
		 * @return 当前对象
		*/
		public Asset setSerialNumber(String serialNumber) {
			super.change(SERIAL_NUMBER,super.getSerialNumber(),serialNumber);
			super.setSerialNumber(serialNumber);
			return this;
		}
		
		/**
		 * 设置 所属单位
		 * @param managementCompanyId 所属单位
		 * @return 当前对象
		*/
		public Asset setManagementCompanyId(String managementCompanyId) {
			super.change(MANAGEMENT_COMPANY_ID,super.getManagementCompanyId(),managementCompanyId);
			super.setManagementCompanyId(managementCompanyId);
			return this;
		}
		
		/**
		 * 设置 管理人员
		 * @param managerId 管理人员
		 * @return 当前对象
		*/
		public Asset setManagerId(String managerId) {
			super.change(MANAGER_ID,super.getManagerId(),managerId);
			super.setManagerId(managerId);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param userOrganizationId 使用公司/部门
		 * @return 当前对象
		*/
		public Asset setUserOrganizationId(String userOrganizationId) {
			super.change(USER_ORGANIZATION_ID,super.getUserOrganizationId(),userOrganizationId);
			super.setUserOrganizationId(userOrganizationId);
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
		 * 设置 存放位置
		 * @param positionId 存放位置
		 * @return 当前对象
		*/
		public Asset setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 详细位置
		 * @param positionDetail 详细位置
		 * @return 当前对象
		*/
		public Asset setPositionDetail(String positionDetail) {
			super.change(POSITION_DETAIL,super.getPositionDetail(),positionDetail);
			super.setPositionDetail(positionDetail);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouseId 仓库
		 * @return 当前对象
		*/
		public Asset setWarehouseId(String warehouseId) {
			super.change(WAREHOUSE_ID,super.getWarehouseId(),warehouseId);
			super.setWarehouseId(warehouseId);
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
		 * 设置 资产数量
		 * @param assetNumber 资产数量
		 * @return 当前对象
		*/
		public Asset setAssetNumber(Integer assetNumber) {
			super.change(ASSET_NUMBER,super.getAssetNumber(),assetNumber);
			super.setAssetNumber(assetNumber);
			return this;
		}
		
		/**
		 * 设置 剩余数量
		 * @param remainNumber 剩余数量
		 * @return 当前对象
		*/
		public Asset setRemainNumber(Integer remainNumber) {
			super.change(REMAIN_NUMBER,super.getRemainNumber(),remainNumber);
			super.setRemainNumber(remainNumber);
			return this;
		}
		
		/**
		 * 设置 采购日期
		 * @param purchaseDate 采购日期
		 * @return 当前对象
		*/
		public Asset setPurchaseDate(Date purchaseDate) {
			super.change(PURCHASE_DATE,super.getPurchaseDate(),purchaseDate);
			super.setPurchaseDate(purchaseDate);
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
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public Asset setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Asset setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public Asset setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
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
		
		/**
		 * 设置 财务信息
		 * @param assetFinancial 财务信息
		 * @return 当前对象
		*/
		public Asset setAssetFinancial(AssetExtFinancial assetFinancial) {
			super.change(ASSET_FINANCIAL,super.getAssetFinancial(),assetFinancial);
			super.setAssetFinancial(assetFinancial);
			return this;
		}
		
		/**
		 * 设置 维保信息
		 * @param assetMaintainer 维保信息
		 * @return 当前对象
		*/
		public Asset setAssetMaintainer(AssetExtFinancial assetMaintainer) {
			super.change(ASSET_MAINTAINER,super.getAssetMaintainer(),assetMaintainer);
			super.setAssetMaintainer(assetMaintainer);
			return this;
		}
		
		/**
		 * 设置 设备信息
		 * @param assetEquipment 设备信息
		 * @return 当前对象
		*/
		public Asset setAssetEquipment(AssetExtEquipment assetEquipment) {
			super.change(ASSET_EQUIPMENT,super.getAssetEquipment(),assetEquipment);
			super.setAssetEquipment(assetEquipment);
			return this;
		}
		
		/**
		 * 设置 软件信息
		 * @param assetExtSoftware 软件信息
		 * @return 当前对象
		*/
		public Asset setAssetExtSoftware(AssetExtSoftware assetExtSoftware) {
			super.change(ASSET_EXT_SOFTWARE,super.getAssetExtSoftware(),assetExtSoftware);
			super.setAssetExtSoftware(assetExtSoftware);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public Asset setCategory(Category category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 物品档案
		 * @param goods 物品档案
		 * @return 当前对象
		*/
		public Asset setGoods(Goods goods) {
			super.change(GOODS,super.getGoods(),goods);
			super.setGoods(goods);
			return this;
		}
		
		/**
		 * 设置 生产厂商
		 * @param manufacturer 生产厂商
		 * @return 当前对象
		*/
		public Asset setManufacturer(Manufacturer manufacturer) {
			super.change(MANUFACTURER,super.getManufacturer(),manufacturer);
			super.setManufacturer(manufacturer);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouse 仓库
		 * @return 当前对象
		*/
		public Asset setWarehouse(Warehouse warehouse) {
			super.change(WAREHOUSE,super.getWarehouse(),warehouse);
			super.setWarehouse(warehouse);
			return this;
		}
	}
}