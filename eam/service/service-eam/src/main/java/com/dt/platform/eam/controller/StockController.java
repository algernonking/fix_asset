package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.meta.AssetDataChangeVOMeta;
import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
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


import com.dt.platform.proxy.eam.StockServiceProxy;
import com.dt.platform.domain.eam.meta.StockVOMeta;
import com.dt.platform.domain.eam.Stock;
import com.dt.platform.domain.eam.StockVO;
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
import com.dt.platform.domain.eam.meta.StockMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.Warehouse;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IStockService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产库存 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-22 13:52:26
*/

@Api(tags = "资产库存")
@ApiSort(0)
@RestController("EamStockController")
public class StockController extends SuperController {

	@Autowired
	private IStockService stockService;


	/**
	 * 添加资产库存
	*/
	@ApiOperation(value = "添加资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StockVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = StockServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.INSERT)
	public Result insert(StockVO stockVO) {
		Result result=stockService.insert(stockVO,false);
		return result;
	}



	/**
	 * 删除资产库存
	*/
	@ApiOperation(value = "删除资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = StockVOMeta.ID)
	@SentinelResource(value = StockServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=stockService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产库存 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = StockVOMeta.IDS)
	@SentinelResource(value = StockServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=stockService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产库存
	*/
	@ApiOperation(value = "更新资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StockVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { StockVOMeta.PAGE_INDEX , StockVOMeta.PAGE_SIZE , StockVOMeta.SEARCH_FIELD , StockVOMeta.FUZZY_FIELD , StockVOMeta.SEARCH_VALUE , StockVOMeta.DIRTY_FIELDS , StockVOMeta.SORT_FIELD , StockVOMeta.SORT_TYPE , StockVOMeta.IDS } )
	@NotNull(name = StockVOMeta.ID)
	@SentinelResource(value = StockServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.UPDATE)
	public Result update(StockVO stockVO) {
		Result result=stockService.update(stockVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产库存
	*/
	@ApiOperation(value = "保存资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StockVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { StockVOMeta.PAGE_INDEX , StockVOMeta.PAGE_SIZE , StockVOMeta.SEARCH_FIELD , StockVOMeta.FUZZY_FIELD , StockVOMeta.SEARCH_VALUE , StockVOMeta.DIRTY_FIELDS , StockVOMeta.SORT_FIELD , StockVOMeta.SORT_TYPE , StockVOMeta.IDS } )
	@NotNull(name = StockVOMeta.ID)
	@SentinelResource(value = StockServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.SAVE)
	public Result save(StockVO stockVO) {
		Result result=stockService.save(stockVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产库存
	*/
	@ApiOperation(value = "获取资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = StockVOMeta.ID)
	@SentinelResource(value = StockServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.GET_BY_ID)
	public Result<Stock> getById(String id) {
		Result<Stock> result=new Result<>();
		Stock stock=stockService.getById(id);
		// join 关联的对象
		stockService.dao().fill(stock)
			.with("ownerCompany")
			.with("manager")
			.with(StockMeta.WAREHOUSE)
			.with(StockMeta.SOURCE)
			.with(StockMeta.SUPPLIER)
			.execute();
		result.success(true).data(stock);
		return result;
	}


	/**
	 * 批量获取资产库存 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产库存")
		@ApiImplicitParams({
				@ApiImplicitParam(name = StockVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = StockVOMeta.IDS)
		@SentinelResource(value = StockServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.GET_BY_IDS)
	public Result<List<Stock>> getByIds(List<String> ids) {
		Result<List<Stock>> result=new Result<>();
		List<Stock> list=stockService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产库存
	*/
	@ApiOperation(value = "查询资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StockVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { StockVOMeta.PAGE_INDEX , StockVOMeta.PAGE_SIZE } )
	@SentinelResource(value = StockServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.QUERY_LIST)
	public Result<List<Stock>> queryList(StockVO sample) {
		Result<List<Stock>> result=new Result<>();
		List<Stock> list=stockService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产库存
	*/
	@ApiOperation(value = "分页查询资产库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = StockVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = StockVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = StockVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = StockServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StockServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Stock>> queryPagedList(StockVO sample) {
		Result<PagedList<Stock>> result=new Result<>();
		PagedList<Stock> list=stockService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		stockService.dao().fill(list)
			.with("ownerCompany")
			.with("manager")
			.with(StockMeta.WAREHOUSE)
			.with(StockMeta.SOURCE)
			.with(StockMeta.SUPPLIER)
			.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 送审
	 * */
	@ApiOperation(value = "变更送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = StockVOMeta.ID)
	@ApiOperationSupport(order=9)
	@SentinelResource(value = StockServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(StockServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return stockService.forApproval(id);
	}





	/**
	 * 确认
	 * */
	@ApiOperation(value = "变更确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = StockVOMeta.ID)
	@ApiOperationSupport(order=10)
	@SentinelResource(value = StockServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(StockServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return stockService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "变更撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = StockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = StockVOMeta.ID)
	@ApiOperationSupport(order=11)
	@SentinelResource(value = StockServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(StockServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return stockService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=12)
	@SentinelResource(value = StockServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(StockServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return stockService.approve(approveVO);
	}




	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = StockServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(StockServiceProxy.EXPORT_EXCEL)
	public void exportExcel(StockVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=stockService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = StockServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(StockServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=stockService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = StockServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(StockServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=stockService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}