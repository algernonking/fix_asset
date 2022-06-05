package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.RepairOrderAcceptanceVO;
import java.util.List;
import com.dt.platform.domain.eam.RepairOrderAcceptance;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.RepairOrder;
import com.dt.platform.domain.eam.RepairOrderAct;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.RepairCategoryTpl;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 05:56:19
 * @sign 5A1E021892D703C9753E036F4681E679
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RepairOrderAcceptanceVOMeta extends RepairOrderAcceptanceMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 申请单 , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 申请单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORDER_ID, java.lang.String.class, "申请单", "申请单", java.lang.String.class, null);
	
	/**
	 * 维修单 , 类型: java.lang.String
	*/
	public static final String ORDER_ACT_ID="orderActId";
	
	/**
	 * 维修单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> ORDER_ACT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORDER_ACT_ID, java.lang.String.class, "维修单", "维修单", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 维修结果 , 类型: java.lang.String
	*/
	public static final String RESULT_TYPE="resultType";
	
	/**
	 * 维修结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> RESULT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,RESULT_TYPE, java.lang.String.class, "维修结果", "维修结果", java.lang.String.class, null);
	
	/**
	 * 验收人 , 类型: java.lang.String
	*/
	public static final String ACCEPTER_ID="accepterId";
	
	/**
	 * 验收人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> ACCEPTER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ACCEPTER_ID, java.lang.String.class, "验收人", "验收人", java.lang.String.class, null);
	
	/**
	 * 实际故障 , 类型: java.lang.String
	*/
	public static final String CATEGORY_TPL_ID="categoryTplId";
	
	/**
	 * 实际故障 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> CATEGORY_TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,CATEGORY_TPL_ID, java.lang.String.class, "实际故障", "实际故障", java.lang.String.class, null);
	
	/**
	 * 实际花费 , 类型: java.math.BigDecimal
	*/
	public static final String ACTUAL_COST="actualCost";
	
	/**
	 * 实际花费 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.math.BigDecimal> ACTUAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ACTUAL_COST, java.math.BigDecimal.class, "实际花费", "实际花费", java.math.BigDecimal.class, null);
	
	/**
	 * 完成时间 , 类型: java.util.Date
	*/
	public static final String FINISH_TIME="finishTime";
	
	/**
	 * 完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.util.Date> FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,FINISH_TIME, java.util.Date.class, "完成时间", "完成时间", java.util.Date.class, null);
	
	/**
	 * 验收备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 验收备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,NOTES, java.lang.String.class, "验收备注", "验收备注", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 申请单 , 类型: com.dt.platform.domain.eam.RepairOrder
	*/
	public static final String ORDER="order";
	
	/**
	 * 申请单 , 类型: com.dt.platform.domain.eam.RepairOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,com.dt.platform.domain.eam.RepairOrder> ORDER_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORDER, com.dt.platform.domain.eam.RepairOrder.class, "申请单", "申请单", com.dt.platform.domain.eam.RepairOrder.class, null);
	
	/**
	 * 维修单 , 类型: com.dt.platform.domain.eam.RepairOrderAct
	*/
	public static final String ORDER_ACT="orderAct";
	
	/**
	 * 维修单 , 类型: com.dt.platform.domain.eam.RepairOrderAct
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,com.dt.platform.domain.eam.RepairOrderAct> ORDER_ACT_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORDER_ACT, com.dt.platform.domain.eam.RepairOrderAct.class, "维修单", "维修单", com.dt.platform.domain.eam.RepairOrderAct.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 验收人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ACCEPTER="accepter";
	
	/**
	 * 验收人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,org.github.foxnic.web.domain.hrm.Employee> ACCEPTER_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ACCEPTER, org.github.foxnic.web.domain.hrm.Employee.class, "验收人", "验收人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 结果类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String RESULT_TYPE_DICT="resultTypeDict";
	
	/**
	 * 结果类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,org.github.foxnic.web.domain.system.DictItem> RESULT_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,RESULT_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "结果类型", "结果类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 报修故障 , 类型: com.dt.platform.domain.eam.RepairCategoryTpl
	*/
	public static final String CATEGORY_TPL="categoryTpl";
	
	/**
	 * 报修故障 , 类型: com.dt.platform.domain.eam.RepairCategoryTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,com.dt.platform.domain.eam.RepairCategoryTpl> CATEGORY_TPL_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,CATEGORY_TPL, com.dt.platform.domain.eam.RepairCategoryTpl.class, "报修故障", "报修故障", com.dt.platform.domain.eam.RepairCategoryTpl.class, null);
	
	/**
	 * 订单名称 , 类型: java.lang.String
	*/
	public static final String ORDER_NAME="orderName";
	
	/**
	 * 订单名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> ORDER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORDER_NAME, java.lang.String.class, "订单名称", "订单名称", java.lang.String.class, null);
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final String ORDER_BUSINESS_CODE="orderBusinessCode";
	
	/**
	 * 订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderAcceptanceVO,java.lang.String> ORDER_BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderAcceptanceVO.class ,ORDER_BUSINESS_CODE, java.lang.String.class, "订单编号", "订单编号", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , ORDER_ID , ORDER_ACT_ID , BUSINESS_CODE , RESULT_TYPE , ACCEPTER_ID , CATEGORY_TPL_ID , ACTUAL_COST , FINISH_TIME , NOTES , PICTURE_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , ORDER , ORDER_ACT , ORIGINATOR , ACCEPTER , RESULT_TYPE_DICT , CATEGORY_TPL , ORDER_NAME , ORDER_BUSINESS_CODE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.RepairOrderAcceptanceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public RepairOrderAcceptanceVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 申请单
		 * @param orderId 申请单
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 维修单
		 * @param orderActId 维修单
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOrderActId(String orderActId) {
			super.change(ORDER_ACT_ID,super.getOrderActId(),orderActId);
			super.setOrderActId(orderActId);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 维修结果
		 * @param resultType 维修结果
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setResultType(String resultType) {
			super.change(RESULT_TYPE,super.getResultType(),resultType);
			super.setResultType(resultType);
			return this;
		}
		
		/**
		 * 设置 验收人
		 * @param accepterId 验收人
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setAccepterId(String accepterId) {
			super.change(ACCEPTER_ID,super.getAccepterId(),accepterId);
			super.setAccepterId(accepterId);
			return this;
		}
		
		/**
		 * 设置 实际故障
		 * @param categoryTplId 实际故障
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setCategoryTplId(String categoryTplId) {
			super.change(CATEGORY_TPL_ID,super.getCategoryTplId(),categoryTplId);
			super.setCategoryTplId(categoryTplId);
			return this;
		}
		
		/**
		 * 设置 实际花费
		 * @param actualCost 实际花费
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setActualCost(BigDecimal actualCost) {
			super.change(ACTUAL_COST,super.getActualCost(),actualCost);
			super.setActualCost(actualCost);
			return this;
		}
		
		/**
		 * 设置 完成时间
		 * @param finishTime 完成时间
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setFinishTime(Date finishTime) {
			super.change(FINISH_TIME,super.getFinishTime(),finishTime);
			super.setFinishTime(finishTime);
			return this;
		}
		
		/**
		 * 设置 验收备注
		 * @param notes 验收备注
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 申请单
		 * @param order 申请单
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOrder(RepairOrder order) {
			super.change(ORDER,super.getOrder(),order);
			super.setOrder(order);
			return this;
		}
		
		/**
		 * 设置 维修单
		 * @param orderAct 维修单
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOrderAct(RepairOrderAct orderAct) {
			super.change(ORDER_ACT,super.getOrderAct(),orderAct);
			super.setOrderAct(orderAct);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 验收人
		 * @param accepter 验收人
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setAccepter(Employee accepter) {
			super.change(ACCEPTER,super.getAccepter(),accepter);
			super.setAccepter(accepter);
			return this;
		}
		
		/**
		 * 设置 结果类型
		 * @param resultTypeDict 结果类型
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setResultTypeDict(DictItem resultTypeDict) {
			super.change(RESULT_TYPE_DICT,super.getResultTypeDict(),resultTypeDict);
			super.setResultTypeDict(resultTypeDict);
			return this;
		}
		
		/**
		 * 设置 报修故障
		 * @param categoryTpl 报修故障
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setCategoryTpl(RepairCategoryTpl categoryTpl) {
			super.change(CATEGORY_TPL,super.getCategoryTpl(),categoryTpl);
			super.setCategoryTpl(categoryTpl);
			return this;
		}
		
		/**
		 * 设置 订单名称
		 * @param orderName 订单名称
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOrderName(String orderName) {
			super.change(ORDER_NAME,super.getOrderName(),orderName);
			super.setOrderName(orderName);
			return this;
		}
		
		/**
		 * 设置 订单编号
		 * @param orderBusinessCode 订单编号
		 * @return 当前对象
		*/
		public RepairOrderAcceptance setOrderBusinessCode(String orderBusinessCode) {
			super.change(ORDER_BUSINESS_CODE,super.getOrderBusinessCode(),orderBusinessCode);
			super.setOrderBusinessCode(orderBusinessCode);
			return this;
		}
	}
}