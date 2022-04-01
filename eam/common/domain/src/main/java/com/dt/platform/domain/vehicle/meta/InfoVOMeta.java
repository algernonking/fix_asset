package com.dt.platform.domain.vehicle.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.vehicle.InfoVO;
import java.util.List;
import com.dt.platform.domain.vehicle.Info;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-01 21:16:00
 * @sign A82F27772F72E013524EB233825CE59A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InfoVOMeta extends InfoMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final String REGISTRANT="registrant";
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> REGISTRANT_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,REGISTRANT, java.lang.String.class, "车牌号", "车牌号", java.lang.String.class, null);
	
	/**
	 * 车辆类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 车辆类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,TYPE, java.lang.String.class, "车辆类型", "车辆类型", java.lang.String.class, null);
	
	/**
	 * 登记人 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 登记人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,CODE, java.lang.String.class, "登记人", "登记人", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 品牌型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 品牌型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,MODEL, java.lang.String.class, "品牌型号", "品牌型号", java.lang.String.class, null);
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final String COLOR="color";
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> COLOR_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,COLOR, java.lang.String.class, "颜色", "颜色", java.lang.String.class, null);
	
	/**
	 * 发动机号 , 类型: java.lang.String
	*/
	public static final String ENGINE_NUMBER="engineNumber";
	
	/**
	 * 发动机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> ENGINE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,ENGINE_NUMBER, java.lang.String.class, "发动机号", "发动机号", java.lang.String.class, null);
	
	/**
	 * 车架号 , 类型: java.lang.String
	*/
	public static final String FRAME_NUMBER="frameNumber";
	
	/**
	 * 车架号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> FRAME_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,FRAME_NUMBER, java.lang.String.class, "车架号", "车架号", java.lang.String.class, null);
	
	/**
	 * 行驶证 , 类型: java.lang.String
	*/
	public static final String DRIVING_LICENSE="drivingLicense";
	
	/**
	 * 行驶证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> DRIVING_LICENSE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,DRIVING_LICENSE, java.lang.String.class, "行驶证", "行驶证", java.lang.String.class, null);
	
	/**
	 * 公里数 , 类型: java.math.BigDecimal
	*/
	public static final String KILOMETERS="kilometers";
	
	/**
	 * 公里数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.math.BigDecimal> KILOMETERS_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,KILOMETERS, java.math.BigDecimal.class, "公里数", "公里数", java.math.BigDecimal.class, null);
	
	/**
	 * 抢险(元) , 类型: java.math.BigDecimal
	*/
	public static final String RESCUE_MONEY="rescueMoney";
	
	/**
	 * 抢险(元) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.math.BigDecimal> RESCUE_MONEY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,RESCUE_MONEY, java.math.BigDecimal.class, "抢险(元)", "抢险(元)", java.math.BigDecimal.class, null);
	
	/**
	 * 商业险(元) , 类型: java.math.BigDecimal
	*/
	public static final String COMMERCIAL_INSURANCE_MONEY="commercialInsuranceMoney";
	
	/**
	 * 商业险(元) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.math.BigDecimal> COMMERCIAL_INSURANCE_MONEY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,COMMERCIAL_INSURANCE_MONEY, java.math.BigDecimal.class, "商业险(元)", "商业险(元)", java.math.BigDecimal.class, null);
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final String INSURANCE_COMPANY="insuranceCompany";
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> INSURANCE_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,INSURANCE_COMPANY, java.lang.String.class, "保险公司", "保险公司", java.lang.String.class, null);
	
	/**
	 * 上牌时间 , 类型: java.util.Date
	*/
	public static final String LICENSING_TIME="licensingTime";
	
	/**
	 * 上牌时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.util.Date> LICENSING_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,LICENSING_TIME, java.util.Date.class, "上牌时间", "上牌时间", java.util.Date.class, null);
	
	/**
	 * 报废时间 , 类型: java.util.Date
	*/
	public static final String SCRAP_TIME="scrapTime";
	
	/**
	 * 报废时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.util.Date> SCRAP_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,SCRAP_TIME, java.util.Date.class, "报废时间", "报废时间", java.util.Date.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String POSITION_DETAIL="positionDetail";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> POSITION_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,POSITION_DETAIL, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURES="pictures";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> PICTURES_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,PICTURES, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.InfoVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.InfoVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , REGISTRANT , TYPE , CODE , NAME , MODEL , COLOR , ENGINE_NUMBER , FRAME_NUMBER , DRIVING_LICENSE , KILOMETERS , RESCUE_MONEY , COMMERCIAL_INSURANCE_MONEY , INSURANCE_COMPANY , LICENSING_TIME , SCRAP_TIME , POSITION_DETAIL , PICTURES , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.vehicle.InfoVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InfoVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InfoVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InfoVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InfoVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InfoVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InfoVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InfoVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InfoVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InfoVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Info setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 车牌号
		 * @param registrant 车牌号
		 * @return 当前对象
		*/
		public Info setRegistrant(String registrant) {
			super.change(REGISTRANT,super.getRegistrant(),registrant);
			super.setRegistrant(registrant);
			return this;
		}
		
		/**
		 * 设置 车辆类型
		 * @param type 车辆类型
		 * @return 当前对象
		*/
		public Info setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 登记人
		 * @param code 登记人
		 * @return 当前对象
		*/
		public Info setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Info setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 品牌型号
		 * @param model 品牌型号
		 * @return 当前对象
		*/
		public Info setModel(String model) {
			super.change(MODEL,super.getModel(),model);
			super.setModel(model);
			return this;
		}
		
		/**
		 * 设置 颜色
		 * @param color 颜色
		 * @return 当前对象
		*/
		public Info setColor(String color) {
			super.change(COLOR,super.getColor(),color);
			super.setColor(color);
			return this;
		}
		
		/**
		 * 设置 发动机号
		 * @param engineNumber 发动机号
		 * @return 当前对象
		*/
		public Info setEngineNumber(String engineNumber) {
			super.change(ENGINE_NUMBER,super.getEngineNumber(),engineNumber);
			super.setEngineNumber(engineNumber);
			return this;
		}
		
		/**
		 * 设置 车架号
		 * @param frameNumber 车架号
		 * @return 当前对象
		*/
		public Info setFrameNumber(String frameNumber) {
			super.change(FRAME_NUMBER,super.getFrameNumber(),frameNumber);
			super.setFrameNumber(frameNumber);
			return this;
		}
		
		/**
		 * 设置 行驶证
		 * @param drivingLicense 行驶证
		 * @return 当前对象
		*/
		public Info setDrivingLicense(String drivingLicense) {
			super.change(DRIVING_LICENSE,super.getDrivingLicense(),drivingLicense);
			super.setDrivingLicense(drivingLicense);
			return this;
		}
		
		/**
		 * 设置 公里数
		 * @param kilometers 公里数
		 * @return 当前对象
		*/
		public Info setKilometers(BigDecimal kilometers) {
			super.change(KILOMETERS,super.getKilometers(),kilometers);
			super.setKilometers(kilometers);
			return this;
		}
		
		/**
		 * 设置 抢险(元)
		 * @param rescueMoney 抢险(元)
		 * @return 当前对象
		*/
		public Info setRescueMoney(BigDecimal rescueMoney) {
			super.change(RESCUE_MONEY,super.getRescueMoney(),rescueMoney);
			super.setRescueMoney(rescueMoney);
			return this;
		}
		
		/**
		 * 设置 商业险(元)
		 * @param commercialInsuranceMoney 商业险(元)
		 * @return 当前对象
		*/
		public Info setCommercialInsuranceMoney(BigDecimal commercialInsuranceMoney) {
			super.change(COMMERCIAL_INSURANCE_MONEY,super.getCommercialInsuranceMoney(),commercialInsuranceMoney);
			super.setCommercialInsuranceMoney(commercialInsuranceMoney);
			return this;
		}
		
		/**
		 * 设置 保险公司
		 * @param insuranceCompany 保险公司
		 * @return 当前对象
		*/
		public Info setInsuranceCompany(String insuranceCompany) {
			super.change(INSURANCE_COMPANY,super.getInsuranceCompany(),insuranceCompany);
			super.setInsuranceCompany(insuranceCompany);
			return this;
		}
		
		/**
		 * 设置 上牌时间
		 * @param licensingTime 上牌时间
		 * @return 当前对象
		*/
		public Info setLicensingTime(Date licensingTime) {
			super.change(LICENSING_TIME,super.getLicensingTime(),licensingTime);
			super.setLicensingTime(licensingTime);
			return this;
		}
		
		/**
		 * 设置 报废时间
		 * @param scrapTime 报废时间
		 * @return 当前对象
		*/
		public Info setScrapTime(Date scrapTime) {
			super.change(SCRAP_TIME,super.getScrapTime(),scrapTime);
			super.setScrapTime(scrapTime);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param positionDetail 位置
		 * @return 当前对象
		*/
		public Info setPositionDetail(String positionDetail) {
			super.change(POSITION_DETAIL,super.getPositionDetail(),positionDetail);
			super.setPositionDetail(positionDetail);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictures 图片
		 * @return 当前对象
		*/
		public Info setPictures(String pictures) {
			super.change(PICTURES,super.getPictures(),pictures);
			super.setPictures(pictures);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Info setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Info setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Info setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Info setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Info setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Info setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Info setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Info setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public Info setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Info setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
	}
}