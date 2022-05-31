package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetRepairVOMeta;
import com.dt.platform.proxy.eam.AssetRepairServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.hrm.Person;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.eam.RepairOrderServiceProxy;
import com.dt.platform.domain.eam.meta.RepairOrderVOMeta;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.eam.meta.RepairOrderMeta;
import java.math.BigDecimal;

import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairOrderService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维修工单 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 19:33:23
*/

@Api(tags = "维修工单")
@ApiSort(0)
@RestController("EamRepairOrderController")
public class RepairOrderController extends SuperController {

	@Autowired
	private IRepairOrderService repairOrderService;


	/**
	 * 添加维修工单
	*/
	@ApiOperation(value = "添加维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.CATEGORY_TPL_ID , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_TYPE , value = "维修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.URGENCY_ID , value = "紧急程度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_ORG_ID , value = "报修部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
	    @ApiImplicitParam(name = RepairOrderVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairOrderServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.INSERT)
	public Result insert(RepairOrderVO repairOrderVO) {
		Result result=repairOrderService.insert(repairOrderVO,false);
		return result;
	}



	/**
	 * 删除维修工单
	*/
	@ApiOperation(value = "删除维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairOrderVOMeta.ID)
	@SentinelResource(value = RepairOrderServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairOrderService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除维修工单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairOrderVOMeta.IDS)
	@SentinelResource(value = RepairOrderServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairOrderService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新维修工单
	*/
	@ApiOperation(value = "更新维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.CATEGORY_TPL_ID , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_TYPE , value = "维修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.URGENCY_ID , value = "紧急程度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_ORG_ID , value = "报修部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = RepairOrderVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairOrderVOMeta.PAGE_INDEX , RepairOrderVOMeta.PAGE_SIZE , RepairOrderVOMeta.SEARCH_FIELD , RepairOrderVOMeta.FUZZY_FIELD , RepairOrderVOMeta.SEARCH_VALUE , RepairOrderVOMeta.DIRTY_FIELDS , RepairOrderVOMeta.SORT_FIELD , RepairOrderVOMeta.SORT_TYPE , RepairOrderVOMeta.IDS } )
	@NotNull(name = RepairOrderVOMeta.ID)
	@SentinelResource(value = RepairOrderServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.UPDATE)
	public Result update(RepairOrderVO repairOrderVO) {
		Result result=repairOrderService.update(repairOrderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存维修工单
	*/
	@ApiOperation(value = "保存维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.CATEGORY_TPL_ID , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_TYPE , value = "维修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.URGENCY_ID , value = "紧急程度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_ORG_ID , value = "报修部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		 @ApiImplicitParam(name = RepairOrderVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairOrderVOMeta.PAGE_INDEX , RepairOrderVOMeta.PAGE_SIZE , RepairOrderVOMeta.SEARCH_FIELD , RepairOrderVOMeta.FUZZY_FIELD , RepairOrderVOMeta.SEARCH_VALUE , RepairOrderVOMeta.DIRTY_FIELDS , RepairOrderVOMeta.SORT_FIELD , RepairOrderVOMeta.SORT_TYPE , RepairOrderVOMeta.IDS } )
	@NotNull(name = RepairOrderVOMeta.ID)
	@SentinelResource(value = RepairOrderServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.SAVE)
	public Result save(RepairOrderVO repairOrderVO) {
		Result result=repairOrderService.save(repairOrderVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取维修工单
	*/
	@ApiOperation(value = "获取维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairOrderVOMeta.ID)
	@SentinelResource(value = RepairOrderServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.GET_BY_ID)
	public Result<RepairOrder> getById(String id) {
		Result<RepairOrder> result=new Result<>();
		RepairOrder repairOrder=repairOrderService.getById(id);
		// join 关联的对象
		repairOrderService.dao().fill(repairOrder)
			.with("originator")
			.with("organization")
			.with("reportUser")
			.with(RepairOrderMeta.CATEGORY_TPL)
			.with(RepairOrderMeta.REPAIR_URGENCY)
			.execute();


		repairOrderService.dao().join(repairOrder.getReportUser(), Person.class);
		repairOrderService.dao().join(repairOrder.getOriginator(), Person.class);

		result.success(true).data(repairOrder);
		return result;
	}


	/**
	 * 批量获取维修工单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取维修工单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairOrderVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairOrderVOMeta.IDS)
		@SentinelResource(value = RepairOrderServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.GET_BY_IDS)
	public Result<List<RepairOrder>> getByIds(List<String> ids) {
		Result<List<RepairOrder>> result=new Result<>();
		List<RepairOrder> list=repairOrderService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询维修工单
	*/
	@ApiOperation(value = "查询维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.CATEGORY_TPL_ID , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_TYPE , value = "维修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.URGENCY_ID , value = "紧急程度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_ORG_ID , value = "报修部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		 @ApiImplicitParam(name = RepairOrderVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairOrderVOMeta.PAGE_INDEX , RepairOrderVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairOrderServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.QUERY_LIST)
	public Result<List<RepairOrder>> queryList(RepairOrderVO sample) {
		Result<List<RepairOrder>> result=new Result<>();
		List<RepairOrder> list=repairOrderService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询维修工单
	*/
	@ApiOperation(value = "分页查询维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.CATEGORY_TPL_ID , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_TYPE , value = "维修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.URGENCY_ID , value = "紧急程度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_ORG_ID , value = "报修部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		 @ApiImplicitParam(name = RepairOrderVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairOrderServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairOrder>> queryPagedList(RepairOrderVO sample) {
		Result<PagedList<RepairOrder>> result=new Result<>();
		PagedList<RepairOrder> list=repairOrderService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		repairOrderService.dao().fill(list)
			.with("originator")
			.with("organization")
			.with("reportUser")
			.with(RepairOrderMeta.CATEGORY_TPL)
			.with(RepairOrderMeta.REPAIR_URGENCY)
			.execute();

		List<Employee> originator= CollectorUtil.collectList(list.getList(), RepairOrder::getOriginator);
		repairOrderService.dao().join(originator, Person.class);

		List<Employee> reportUser= CollectorUtil.collectList(list.getList(),RepairOrder::getReportUser);
		repairOrderService.dao().join(reportUser, Person.class);

		result.success(true).data(list);
		return result;
	}


	/**
	 * 报修送审
	 * */
	@ApiOperation(value = "报修送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = RepairOrderVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = RepairOrderServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return repairOrderService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "报修确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = RepairOrderVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = RepairOrderServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return repairOrderService.confirmOperation(id);
	}



	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = RepairOrderVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = RepairOrderVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = RepairOrderServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return repairOrderService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = RepairOrderServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return repairOrderService.approve(approveVO);
	}


	/**
	 * 派单
	 * */
	@ApiOperation(value = "派单")
	@ApiOperationSupport(order=16)
	@SentinelResource(value = RepairOrderServiceProxy.DISPATCH , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.DISPATCH)
	public Result dispatchOrder(List<String> ids,String actId)  {
		return repairOrderService.dispatchOrder(ids,actId);
	}

	/**
	 * 派单
	 * */
	@ApiOperation(value = "验证派单")
	@ApiOperationSupport(order=17)
	@SentinelResource(value = RepairOrderServiceProxy.VALIDATE_DISPATCH_ORDER , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.VALIDATE_DISPATCH_ORDER)
	public Result validateDispatchOrder(List<String> ids)  {
		return repairOrderService.validateDispatchOrder(ids);
	}

	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairOrderServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairOrderVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairOrderService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairOrderServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairOrderService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairOrderServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}

		List<ValidateResult> errors=repairOrderService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}