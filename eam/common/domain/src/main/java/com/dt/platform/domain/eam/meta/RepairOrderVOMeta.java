package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.RepairOrderVO;
import java.util.List;
import com.dt.platform.domain.eam.RepairOrder;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.RepairOrderAct;
import com.dt.platform.domain.eam.RepairOrderAcceptance;
import com.dt.platform.domain.eam.RepairCategoryTpl;
import com.dt.platform.domain.eam.RepairUrgency;
import org.github.foxnic.web.domain.hrm.Organization;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 05:30:41
 * @sign 0C15AB85B40C4A51A86235D608C2150D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RepairOrderVOMeta extends RepairOrderMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final String REPAIR_STATUS="repairStatus";
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> REPAIR_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,REPAIR_STATUS, java.lang.String.class, "维修状态", "维修状态", java.lang.String.class, null);
	
	/**
	 * 故障类型 , 类型: java.lang.String
	*/
	public static final String CATEGORY_TPL_ID="categoryTplId";
	
	/**
	 * 故障类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> CATEGORY_TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,CATEGORY_TPL_ID, java.lang.String.class, "故障类型", "故障类型", java.lang.String.class, null);
	
	/**
	 * 维修类型 , 类型: java.lang.String
	*/
	public static final String REPAIR_TYPE="repairType";
	
	/**
	 * 维修类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> REPAIR_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,REPAIR_TYPE, java.lang.String.class, "维修类型", "维修类型", java.lang.String.class, null);
	
	/**
	 * 紧急程度 , 类型: java.lang.String
	*/
	public static final String URGENCY_ID="urgencyId";
	
	/**
	 * 紧急程度 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> URGENCY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,URGENCY_ID, java.lang.String.class, "紧急程度", "紧急程度", java.lang.String.class, null);
	
	/**
	 * 报修部门 , 类型: java.lang.String
	*/
	public static final String REPORT_ORG_ID="reportOrgId";
	
	/**
	 * 报修部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> REPORT_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,REPORT_ORG_ID, java.lang.String.class, "报修部门", "报修部门", java.lang.String.class, null);
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final String REPORT_USER_ID="reportUserId";
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> REPORT_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,REPORT_USER_ID, java.lang.String.class, "报修人", "报修人", java.lang.String.class, null);
	
	/**
	 * 维修费用 , 类型: java.math.BigDecimal
	*/
	public static final String REPAIR_COST="repairCost";
	
	/**
	 * 维修费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.math.BigDecimal> REPAIR_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,REPAIR_COST, java.math.BigDecimal.class, "维修费用", "维修费用", java.math.BigDecimal.class, null);
	
	/**
	 * 计划完成日期 , 类型: java.util.Date
	*/
	public static final String PLAN_FINISH_DATE="planFinishDate";
	
	/**
	 * 计划完成日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.util.Date> PLAN_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,PLAN_FINISH_DATE, java.util.Date.class, "计划完成日期", "计划完成日期", java.util.Date.class, null);
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,CONTENT, java.lang.String.class, "报修内容", "报修内容", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 维修单 , 类型: java.lang.String
	*/
	public static final String AUTO_ACT="autoAct";
	
	/**
	 * 维修单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> AUTO_ACT_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,AUTO_ACT, java.lang.String.class, "维修单", "维修单", java.lang.String.class, null);
	
	/**
	 * 创建规则 , 类型: java.lang.String
	*/
	public static final String AUTO_ACT_RULE="autoActRule";
	
	/**
	 * 创建规则 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> AUTO_ACT_RULE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,AUTO_ACT_RULE, java.lang.String.class, "创建规则", "创建规则", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ASSET_LIST, java.util.List.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_IDS="assetIds";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,java.lang.String> ASSET_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ASSET_IDS, java.util.List.class, "资产列表", "资产列表", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 报修人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String REPORT_USER="reportUser";
	
	/**
	 * 报修人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,org.github.foxnic.web.domain.hrm.Employee> REPORT_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,REPORT_USER, org.github.foxnic.web.domain.hrm.Employee.class, "报修人", "报修人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 维修单 , 类型: com.dt.platform.domain.eam.RepairOrderAct
	*/
	public static final String ORDER_ACT="orderAct";
	
	/**
	 * 维修单 , 类型: com.dt.platform.domain.eam.RepairOrderAct
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,com.dt.platform.domain.eam.RepairOrderAct> ORDER_ACT_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ORDER_ACT, com.dt.platform.domain.eam.RepairOrderAct.class, "维修单", "维修单", com.dt.platform.domain.eam.RepairOrderAct.class, null);
	
	/**
	 * 验收单 , 类型: com.dt.platform.domain.eam.RepairOrderAcceptance
	*/
	public static final String ORDER_ACCEPTANCE="orderAcceptance";
	
	/**
	 * 验收单 , 类型: com.dt.platform.domain.eam.RepairOrderAcceptance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,com.dt.platform.domain.eam.RepairOrderAcceptance> ORDER_ACCEPTANCE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ORDER_ACCEPTANCE, com.dt.platform.domain.eam.RepairOrderAcceptance.class, "验收单", "验收单", com.dt.platform.domain.eam.RepairOrderAcceptance.class, null);
	
	/**
	 * 报修故障 , 类型: com.dt.platform.domain.eam.RepairCategoryTpl
	*/
	public static final String CATEGORY_TPL="categoryTpl";
	
	/**
	 * 报修故障 , 类型: com.dt.platform.domain.eam.RepairCategoryTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,com.dt.platform.domain.eam.RepairCategoryTpl> CATEGORY_TPL_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,CATEGORY_TPL, com.dt.platform.domain.eam.RepairCategoryTpl.class, "报修故障", "报修故障", com.dt.platform.domain.eam.RepairCategoryTpl.class, null);
	
	/**
	 * 紧急程度 , 类型: com.dt.platform.domain.eam.RepairUrgency
	*/
	public static final String REPAIR_URGENCY="repairUrgency";
	
	/**
	 * 紧急程度 , 类型: com.dt.platform.domain.eam.RepairUrgency
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,com.dt.platform.domain.eam.RepairUrgency> REPAIR_URGENCY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,REPAIR_URGENCY, com.dt.platform.domain.eam.RepairUrgency.class, "紧急程度", "紧急程度", com.dt.platform.domain.eam.RepairUrgency.class, null);
	
	/**
	 * 报修部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 报修部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderVO,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderVO.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "报修部门", "报修部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , BUSINESS_CODE , PROC_ID , STATUS , NAME , REPAIR_STATUS , CATEGORY_TPL_ID , REPAIR_TYPE , URGENCY_ID , REPORT_ORG_ID , REPORT_USER_ID , REPAIR_COST , PLAN_FINISH_DATE , CONTENT , PICTURE_ID , ORIGINATOR_ID , BUSINESS_DATE , AUTO_ACT , AUTO_ACT_RULE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , ASSET_LIST , ASSET_IDS , ORIGINATOR , REPORT_USER , ORDER_ACT , ORDER_ACCEPTANCE , CATEGORY_TPL , REPAIR_URGENCY , ORGANIZATION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.RepairOrderVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public RepairOrderVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public RepairOrderVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public RepairOrderVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public RepairOrderVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public RepairOrderVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public RepairOrderVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public RepairOrderVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public RepairOrderVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public RepairOrderVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RepairOrder setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public RepairOrder setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public RepairOrder setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public RepairOrder setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public RepairOrder setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 维修状态
		 * @param repairStatus 维修状态
		 * @return 当前对象
		*/
		public RepairOrder setRepairStatus(String repairStatus) {
			super.change(REPAIR_STATUS,super.getRepairStatus(),repairStatus);
			super.setRepairStatus(repairStatus);
			return this;
		}
		
		/**
		 * 设置 故障类型
		 * @param categoryTplId 故障类型
		 * @return 当前对象
		*/
		public RepairOrder setCategoryTplId(String categoryTplId) {
			super.change(CATEGORY_TPL_ID,super.getCategoryTplId(),categoryTplId);
			super.setCategoryTplId(categoryTplId);
			return this;
		}
		
		/**
		 * 设置 维修类型
		 * @param repairType 维修类型
		 * @return 当前对象
		*/
		public RepairOrder setRepairType(String repairType) {
			super.change(REPAIR_TYPE,super.getRepairType(),repairType);
			super.setRepairType(repairType);
			return this;
		}
		
		/**
		 * 设置 紧急程度
		 * @param urgencyId 紧急程度
		 * @return 当前对象
		*/
		public RepairOrder setUrgencyId(String urgencyId) {
			super.change(URGENCY_ID,super.getUrgencyId(),urgencyId);
			super.setUrgencyId(urgencyId);
			return this;
		}
		
		/**
		 * 设置 报修部门
		 * @param reportOrgId 报修部门
		 * @return 当前对象
		*/
		public RepairOrder setReportOrgId(String reportOrgId) {
			super.change(REPORT_ORG_ID,super.getReportOrgId(),reportOrgId);
			super.setReportOrgId(reportOrgId);
			return this;
		}
		
		/**
		 * 设置 报修人
		 * @param reportUserId 报修人
		 * @return 当前对象
		*/
		public RepairOrder setReportUserId(String reportUserId) {
			super.change(REPORT_USER_ID,super.getReportUserId(),reportUserId);
			super.setReportUserId(reportUserId);
			return this;
		}
		
		/**
		 * 设置 维修费用
		 * @param repairCost 维修费用
		 * @return 当前对象
		*/
		public RepairOrder setRepairCost(BigDecimal repairCost) {
			super.change(REPAIR_COST,super.getRepairCost(),repairCost);
			super.setRepairCost(repairCost);
			return this;
		}
		
		/**
		 * 设置 计划完成日期
		 * @param planFinishDate 计划完成日期
		 * @return 当前对象
		*/
		public RepairOrder setPlanFinishDate(Date planFinishDate) {
			super.change(PLAN_FINISH_DATE,super.getPlanFinishDate(),planFinishDate);
			super.setPlanFinishDate(planFinishDate);
			return this;
		}
		
		/**
		 * 设置 报修内容
		 * @param content 报修内容
		 * @return 当前对象
		*/
		public RepairOrder setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public RepairOrder setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public RepairOrder setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public RepairOrder setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 维修单
		 * @param autoAct 维修单
		 * @return 当前对象
		*/
		public RepairOrder setAutoAct(String autoAct) {
			super.change(AUTO_ACT,super.getAutoAct(),autoAct);
			super.setAutoAct(autoAct);
			return this;
		}
		
		/**
		 * 设置 创建规则
		 * @param autoActRule 创建规则
		 * @return 当前对象
		*/
		public RepairOrder setAutoActRule(String autoActRule) {
			super.change(AUTO_ACT_RULE,super.getAutoActRule(),autoActRule);
			super.setAutoActRule(autoActRule);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RepairOrder setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RepairOrder setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RepairOrder setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RepairOrder setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RepairOrder setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RepairOrder setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RepairOrder setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public RepairOrder setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public RepairOrder setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public RepairOrder setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetList 资产
		 * @return 当前对象
		*/
		public RepairOrder setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetIds 资产列表
		 * @return 当前对象
		*/
		public RepairOrder setAssetIds(List<String> assetIds) {
			super.change(ASSET_IDS,super.getAssetIds(),assetIds);
			super.setAssetIds(assetIds);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public RepairOrder setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 报修人
		 * @param reportUser 报修人
		 * @return 当前对象
		*/
		public RepairOrder setReportUser(Employee reportUser) {
			super.change(REPORT_USER,super.getReportUser(),reportUser);
			super.setReportUser(reportUser);
			return this;
		}
		
		/**
		 * 设置 维修单
		 * @param orderAct 维修单
		 * @return 当前对象
		*/
		public RepairOrder setOrderAct(RepairOrderAct orderAct) {
			super.change(ORDER_ACT,super.getOrderAct(),orderAct);
			super.setOrderAct(orderAct);
			return this;
		}
		
		/**
		 * 设置 验收单
		 * @param orderAcceptance 验收单
		 * @return 当前对象
		*/
		public RepairOrder setOrderAcceptance(RepairOrderAcceptance orderAcceptance) {
			super.change(ORDER_ACCEPTANCE,super.getOrderAcceptance(),orderAcceptance);
			super.setOrderAcceptance(orderAcceptance);
			return this;
		}
		
		/**
		 * 设置 报修故障
		 * @param categoryTpl 报修故障
		 * @return 当前对象
		*/
		public RepairOrder setCategoryTpl(RepairCategoryTpl categoryTpl) {
			super.change(CATEGORY_TPL,super.getCategoryTpl(),categoryTpl);
			super.setCategoryTpl(categoryTpl);
			return this;
		}
		
		/**
		 * 设置 紧急程度
		 * @param repairUrgency 紧急程度
		 * @return 当前对象
		*/
		public RepairOrder setRepairUrgency(RepairUrgency repairUrgency) {
			super.change(REPAIR_URGENCY,super.getRepairUrgency(),repairUrgency);
			super.setRepairUrgency(repairUrgency);
			return this;
		}
		
		/**
		 * 设置 报修部门
		 * @param organization 报修部门
		 * @return 当前对象
		*/
		public RepairOrder setOrganization(Organization organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
	}
}