package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.meta.AssetScrapVOMeta;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
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


import com.dt.platform.proxy.eam.PurchaseApplyServiceProxy;
import com.dt.platform.domain.eam.meta.PurchaseApplyVOMeta;
import com.dt.platform.domain.eam.PurchaseApply;
import com.dt.platform.domain.eam.PurchaseApplyVO;
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
import com.dt.platform.domain.eam.meta.PurchaseApplyMeta;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import com.dt.platform.domain.eam.PurchaseOrder;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPurchaseApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 采购申请 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-16 22:09:37
*/

@Api(tags = "采购申请")
@ApiSort(0)
@RestController("EamPurchaseApplyController")
public class PurchaseApplyController extends SuperController {

	@Autowired
	private IPurchaseApplyService purchaseApplyService;


	/**
	 * 添加采购申请
	*/
	@ApiOperation(value = "添加采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "567098245956763648"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_STATUS , value = "申请状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ASSET_CHECK , value = "验收情况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class , example = "473623647488049153"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.HARVEST_INFORMATION , value = "收货信息" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE , value = "期望到货时间" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_CONTENT , value = "申请说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_DATE , value = "申请日期" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = PurchaseApplyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.INSERT)
	public Result insert(PurchaseApplyVO purchaseApplyVO) {
		Result result=purchaseApplyService.insert(purchaseApplyVO,false);
		return result;
	}



	/**
	 * 删除采购申请
	*/
	@ApiOperation(value = "删除采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "567098245956763648")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@SentinelResource(value = PurchaseApplyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=purchaseApplyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除采购申请 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = PurchaseApplyVOMeta.IDS)
	@SentinelResource(value = PurchaseApplyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=purchaseApplyService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新采购申请
	*/
	@ApiOperation(value = "更新采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "567098245956763648"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_STATUS , value = "申请状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ASSET_CHECK , value = "验收情况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class , example = "473623647488049153"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.HARVEST_INFORMATION , value = "收货信息" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE , value = "期望到货时间" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_CONTENT , value = "申请说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_DATE , value = "申请日期" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { PurchaseApplyVOMeta.PAGE_INDEX , PurchaseApplyVOMeta.PAGE_SIZE , PurchaseApplyVOMeta.SEARCH_FIELD , PurchaseApplyVOMeta.FUZZY_FIELD , PurchaseApplyVOMeta.SEARCH_VALUE , PurchaseApplyVOMeta.DIRTY_FIELDS , PurchaseApplyVOMeta.SORT_FIELD , PurchaseApplyVOMeta.SORT_TYPE , PurchaseApplyVOMeta.IDS } )
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@SentinelResource(value = PurchaseApplyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.UPDATE)
	public Result update(PurchaseApplyVO purchaseApplyVO) {
		Result result=purchaseApplyService.update(purchaseApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存采购申请
	*/
	@ApiOperation(value = "保存采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "567098245956763648"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_STATUS , value = "申请状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ASSET_CHECK , value = "验收情况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class , example = "473623647488049153"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.HARVEST_INFORMATION , value = "收货信息" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE , value = "期望到货时间" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_CONTENT , value = "申请说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_DATE , value = "申请日期" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PurchaseApplyVOMeta.PAGE_INDEX , PurchaseApplyVOMeta.PAGE_SIZE , PurchaseApplyVOMeta.SEARCH_FIELD , PurchaseApplyVOMeta.FUZZY_FIELD , PurchaseApplyVOMeta.SEARCH_VALUE , PurchaseApplyVOMeta.DIRTY_FIELDS , PurchaseApplyVOMeta.SORT_FIELD , PurchaseApplyVOMeta.SORT_TYPE , PurchaseApplyVOMeta.IDS } )
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@SentinelResource(value = PurchaseApplyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.SAVE)
	public Result save(PurchaseApplyVO purchaseApplyVO) {
		Result result=purchaseApplyService.save(purchaseApplyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取采购申请
	*/
	@ApiOperation(value = "获取采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@SentinelResource(value = PurchaseApplyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.GET_BY_ID)
	public Result<PurchaseApply> getById(String id) {
		Result<PurchaseApply> result=new Result<>();
		PurchaseApply purchaseApply=purchaseApplyService.getById(id);
		// join 关联的对象
		purchaseApplyService.dao().fill(purchaseApply)
			.with("applyOrg")
			.with(PurchaseApplyMeta.SUPPLIER)
			.execute();
		result.success(true).data(purchaseApply);
		return result;
	}


	/**
	 * 批量获取采购申请 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取采购申请")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PurchaseApplyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = PurchaseApplyVOMeta.IDS)
		@SentinelResource(value = PurchaseApplyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.GET_BY_IDS)
	public Result<List<PurchaseApply>> getByIds(List<String> ids) {
		Result<List<PurchaseApply>> result=new Result<>();
		List<PurchaseApply> list=purchaseApplyService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询采购申请
	*/
	@ApiOperation(value = "查询采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "567098245956763648"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_STATUS , value = "申请状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ASSET_CHECK , value = "验收情况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class , example = "473623647488049153"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.HARVEST_INFORMATION , value = "收货信息" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE , value = "期望到货时间" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_CONTENT , value = "申请说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_DATE , value = "申请日期" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PurchaseApplyVOMeta.PAGE_INDEX , PurchaseApplyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PurchaseApplyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.QUERY_LIST)
	public Result<List<PurchaseApply>> queryList(PurchaseApplyVO sample) {
		Result<List<PurchaseApply>> result=new Result<>();
		List<PurchaseApply> list=purchaseApplyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询采购申请
	*/
	@ApiOperation(value = "分页查询采购申请")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "567098245956763648"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_STATUS , value = "申请状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ASSET_CHECK , value = "验收情况" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_ORG_ID , value = "申请部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class , example = "473623647488049153"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.HARVEST_INFORMATION , value = "收货信息" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE , value = "期望到货时间" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_CONTENT , value = "申请说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPLY_DATE , value = "申请日期" , required = false , dataTypeClass=String.class , example = "2022-04-12"),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseApplyVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = PurchaseApplyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseApplyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PurchaseApply>> queryPagedList(PurchaseApplyVO sample) {
		Result<PagedList<PurchaseApply>> result=new Result<>();
		PagedList<PurchaseApply> list=purchaseApplyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		purchaseApplyService.dao().fill(list)
			.with("applyOrg")
			.with(PurchaseApplyMeta.SUPPLIER)
			.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 报废送审
	 * */
	@ApiOperation(value = "报废送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = PurchaseApplyServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return purchaseApplyService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "报废确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = PurchaseApplyServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return purchaseApplyService.confirmOperation(id);
	}




	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = PurchaseApplyServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return purchaseApplyService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = PurchaseApplyServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return purchaseApplyService.approve(approveVO);
	}


	/**
	 * 验收
	 * */
	@ApiOperation(value = "验收")
	@ApiImplicitParams({
			@ApiImplicitParam(name = PurchaseApplyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = PurchaseApplyVOMeta.ID)
	@ApiOperationSupport(order=16)
	@SentinelResource(value = PurchaseApplyServiceProxy.CHECK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.CHECK)
	public Result check(String id,String checkId)  {
		return purchaseApplyService.check(id,checkId);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = PurchaseApplyServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.EXPORT_EXCEL)
	public void exportExcel(PurchaseApplyVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=purchaseApplyService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = PurchaseApplyServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=purchaseApplyService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = PurchaseApplyServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseApplyServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=purchaseApplyService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}