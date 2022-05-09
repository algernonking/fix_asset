package com.dt.platform.domain.datacenter.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.datacenter.RackVO;
import java.util.List;
import com.dt.platform.domain.datacenter.Rack;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import org.github.foxnic.web.domain.system.DictItem;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 21:19:32
 * @sign 8ECDA644F0C7595F7B41AA4E5FCF40F6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RackVOMeta extends RackMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String RACK_CODE="rackCode";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> RACK_CODE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String RACK_TYPE="rackType";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> RACK_TYPE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String RACK_NAME="rackName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> RACK_NAME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final String ENVIRONMENT="environment";
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> ENVIRONMENT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,ENVIRONMENT, java.lang.String.class, "环境", "环境", java.lang.String.class, null);
	
	/**
	 * 使用分类 , 类型: java.lang.String
	*/
	public static final String RACK_USED_TYPE="rackUsedType";
	
	/**
	 * 使用分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> RACK_USED_TYPE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_USED_TYPE, java.lang.String.class, "使用分类", "使用分类", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final String AREA_ID="areaId";
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> AREA_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,AREA_ID, java.lang.String.class, "区域", "区域", java.lang.String.class, null);
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final String LAYER_ID="layerId";
	
	/**
	 * 层级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> LAYER_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,LAYER_ID, java.lang.String.class, "层级", "层级", java.lang.String.class, null);
	
	/**
	 * 容量 , 类型: java.math.BigDecimal
	*/
	public static final String RACK_CAPTICAL="rackCaptical";
	
	/**
	 * 容量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.math.BigDecimal> RACK_CAPTICAL_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_CAPTICAL, java.math.BigDecimal.class, "容量", "容量", java.math.BigDecimal.class, null);
	
	/**
	 * U位数量 , 类型: java.lang.Integer
	*/
	public static final String U_POSTION_NUMBER="uPostionNumber";
	
	/**
	 * U位数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> U_POSTION_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,U_POSTION_NUMBER, java.lang.Integer.class, "U位数量", "U位数量", java.lang.Integer.class, null);
	
	/**
	 * PDU数量 , 类型: java.lang.Integer
	*/
	public static final String PDU_NUMBER="pduNumber";
	
	/**
	 * PDU数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> PDU_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,PDU_NUMBER, java.lang.Integer.class, "PDU数量", "PDU数量", java.lang.Integer.class, null);
	
	/**
	 * 跳线数 , 类型: java.lang.Integer
	*/
	public static final String JUMPER_NUMBER="jumperNumber";
	
	/**
	 * 跳线数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> JUMPER_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,JUMPER_NUMBER, java.lang.Integer.class, "跳线数", "跳线数", java.lang.Integer.class, null);
	
	/**
	 * 合同电力 , 类型: java.lang.Integer
	*/
	public static final String CONTRACT_POWER="contractPower";
	
	/**
	 * 合同电力 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> CONTRACT_POWER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,CONTRACT_POWER, java.lang.Integer.class, "合同电力", "合同电力", java.lang.Integer.class, null);
	
	/**
	 * 设备数量 , 类型: java.lang.Integer
	*/
	public static final String EQUIPMENT_NUMBER="equipmentNumber";
	
	/**
	 * 设备数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> EQUIPMENT_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,EQUIPMENT_NUMBER, java.lang.Integer.class, "设备数量", "设备数量", java.lang.Integer.class, null);
	
	/**
	 * 到期日期 , 类型: java.util.Date
	*/
	public static final String EXPIRE_DATE="expireDate";
	
	/**
	 * 到期日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.util.Date> EXPIRE_DATE_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,EXPIRE_DATE, java.util.Date.class, "到期日期", "到期日期", java.util.Date.class, null);
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final String RACK_LABEL1="rackLabel1";
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> RACK_LABEL1_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_LABEL1, java.lang.String.class, "标签1", "标签1", java.lang.String.class, null);
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final String RACK_LABEL2="rackLabel2";
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> RACK_LABEL2_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_LABEL2, java.lang.String.class, "标签2", "标签2", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String RACK_NOTES="rackNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> RACK_NOTES_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,RACK_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final String AREA="area";
	
	/**
	 * 区域 , 类型: com.dt.platform.domain.datacenter.Area
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,com.dt.platform.domain.datacenter.Area> AREA_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,AREA, com.dt.platform.domain.datacenter.Area.class, "区域", "", com.dt.platform.domain.datacenter.Area.class, null);
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final String LAYER="layer";
	
	/**
	 * 层级 , 类型: com.dt.platform.domain.datacenter.Layer
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,com.dt.platform.domain.datacenter.Layer> LAYER_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,LAYER, com.dt.platform.domain.datacenter.Layer.class, "层级", "", com.dt.platform.domain.datacenter.Layer.class, null);
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String STATUS_DICT="statusDict";
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,org.github.foxnic.web.domain.system.DictItem> STATUS_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,STATUS_DICT, org.github.foxnic.web.domain.system.DictItem.class, "状态", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 使用类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String USED_TYPE_DICT="usedTypeDict";
	
	/**
	 * 使用类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,org.github.foxnic.web.domain.system.DictItem> USED_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,USED_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "使用类型", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 环境 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String ENVIRONMENT_DICT="environmentDict";
	
	/**
	 * 环境 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.datacenter.RackVO,org.github.foxnic.web.domain.system.DictItem> ENVIRONMENT_DICT_PROP = new BeanProperty(com.dt.platform.domain.datacenter.RackVO.class ,ENVIRONMENT_DICT, org.github.foxnic.web.domain.system.DictItem.class, "环境", "", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , RACK_CODE , RACK_TYPE , RACK_NAME , STATUS , ENVIRONMENT , RACK_USED_TYPE , AREA_ID , LAYER_ID , RACK_CAPTICAL , U_POSTION_NUMBER , PDU_NUMBER , JUMPER_NUMBER , CONTRACT_POWER , EQUIPMENT_NUMBER , EXPIRE_DATE , RACK_LABEL1 , RACK_LABEL2 , RACK_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , AREA , LAYER , STATUS_DICT , TYPE_DICT , USED_TYPE_DICT , ENVIRONMENT_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.datacenter.RackVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public RackVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public RackVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public RackVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public RackVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public RackVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public RackVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public RackVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public RackVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public RackVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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
		 * 设置 类型
		 * @param rackType 类型
		 * @return 当前对象
		*/
		public Rack setRackType(String rackType) {
			super.change(RACK_TYPE,super.getRackType(),rackType);
			super.setRackType(rackType);
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
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Rack setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 环境
		 * @param environment 环境
		 * @return 当前对象
		*/
		public Rack setEnvironment(String environment) {
			super.change(ENVIRONMENT,super.getEnvironment(),environment);
			super.setEnvironment(environment);
			return this;
		}
		
		/**
		 * 设置 使用分类
		 * @param rackUsedType 使用分类
		 * @return 当前对象
		*/
		public Rack setRackUsedType(String rackUsedType) {
			super.change(RACK_USED_TYPE,super.getRackUsedType(),rackUsedType);
			super.setRackUsedType(rackUsedType);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param areaId 区域
		 * @return 当前对象
		*/
		public Rack setAreaId(String areaId) {
			super.change(AREA_ID,super.getAreaId(),areaId);
			super.setAreaId(areaId);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layerId 层级
		 * @return 当前对象
		*/
		public Rack setLayerId(String layerId) {
			super.change(LAYER_ID,super.getLayerId(),layerId);
			super.setLayerId(layerId);
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
		 * 设置 U位数量
		 * @param uPostionNumber U位数量
		 * @return 当前对象
		*/
		public Rack setUPostionNumber(Integer uPostionNumber) {
			super.change(U_POSTION_NUMBER,super.getUPostionNumber(),uPostionNumber);
			super.setUPostionNumber(uPostionNumber);
			return this;
		}
		
		/**
		 * 设置 PDU数量
		 * @param pduNumber PDU数量
		 * @return 当前对象
		*/
		public Rack setPduNumber(Integer pduNumber) {
			super.change(PDU_NUMBER,super.getPduNumber(),pduNumber);
			super.setPduNumber(pduNumber);
			return this;
		}
		
		/**
		 * 设置 跳线数
		 * @param jumperNumber 跳线数
		 * @return 当前对象
		*/
		public Rack setJumperNumber(Integer jumperNumber) {
			super.change(JUMPER_NUMBER,super.getJumperNumber(),jumperNumber);
			super.setJumperNumber(jumperNumber);
			return this;
		}
		
		/**
		 * 设置 合同电力
		 * @param contractPower 合同电力
		 * @return 当前对象
		*/
		public Rack setContractPower(Integer contractPower) {
			super.change(CONTRACT_POWER,super.getContractPower(),contractPower);
			super.setContractPower(contractPower);
			return this;
		}
		
		/**
		 * 设置 设备数量
		 * @param equipmentNumber 设备数量
		 * @return 当前对象
		*/
		public Rack setEquipmentNumber(Integer equipmentNumber) {
			super.change(EQUIPMENT_NUMBER,super.getEquipmentNumber(),equipmentNumber);
			super.setEquipmentNumber(equipmentNumber);
			return this;
		}
		
		/**
		 * 设置 到期日期
		 * @param expireDate 到期日期
		 * @return 当前对象
		*/
		public Rack setExpireDate(Date expireDate) {
			super.change(EXPIRE_DATE,super.getExpireDate(),expireDate);
			super.setExpireDate(expireDate);
			return this;
		}
		
		/**
		 * 设置 标签1
		 * @param rackLabel1 标签1
		 * @return 当前对象
		*/
		public Rack setRackLabel1(String rackLabel1) {
			super.change(RACK_LABEL1,super.getRackLabel1(),rackLabel1);
			super.setRackLabel1(rackLabel1);
			return this;
		}
		
		/**
		 * 设置 标签2
		 * @param rackLabel2 标签2
		 * @return 当前对象
		*/
		public Rack setRackLabel2(String rackLabel2) {
			super.change(RACK_LABEL2,super.getRackLabel2(),rackLabel2);
			super.setRackLabel2(rackLabel2);
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
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Rack setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param area 区域
		 * @return 当前对象
		*/
		public Rack setArea(Area area) {
			super.change(AREA,super.getArea(),area);
			super.setArea(area);
			return this;
		}
		
		/**
		 * 设置 层级
		 * @param layer 层级
		 * @return 当前对象
		*/
		public Rack setLayer(Layer layer) {
			super.change(LAYER,super.getLayer(),layer);
			super.setLayer(layer);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param statusDict 状态
		 * @return 当前对象
		*/
		public Rack setStatusDict(DictItem statusDict) {
			super.change(STATUS_DICT,super.getStatusDict(),statusDict);
			super.setStatusDict(statusDict);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param typeDict 类型
		 * @return 当前对象
		*/
		public Rack setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}
		
		/**
		 * 设置 使用类型
		 * @param usedTypeDict 使用类型
		 * @return 当前对象
		*/
		public Rack setUsedTypeDict(DictItem usedTypeDict) {
			super.change(USED_TYPE_DICT,super.getUsedTypeDict(),usedTypeDict);
			super.setUsedTypeDict(usedTypeDict);
			return this;
		}
		
		/**
		 * 设置 环境
		 * @param environmentDict 环境
		 * @return 当前对象
		*/
		public Rack setEnvironmentDict(DictItem environmentDict) {
			super.change(ENVIRONMENT_DICT,super.getEnvironmentDict(),environmentDict);
			super.setEnvironmentDict(environmentDict);
			return this;
		}
	}
}