package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.meta.AssetCollectionVOMeta;
import com.dt.platform.proxy.eam.AssetCollectionServiceProxy;
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


import com.dt.platform.proxy.eam.AssetStockGoodsInServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInVOMeta;
import com.dt.platform.domain.eam.AssetStockGoodsIn;
import com.dt.platform.domain.eam.AssetStockGoodsInVO;
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
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.GoodsStock;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockGoodsInService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存物品单 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 13:05:36
*/

@Api(tags = "库存物品单")
@ApiSort(0)
@RestController("EamAssetStockGoodsInController")
public class AssetStockGoodsInController extends SuperController {

	@Autowired
	private IAssetStockGoodsInService assetStockGoodsInService;


	/**
	 * 添加库存物品单
	*/
	@ApiOperation(value = "添加库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569508271568715776"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NAME , value = "单据名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STOCK_TYPE , value = "入库类型" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "569147473092673536"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "donation"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class , example = "2022-04-12 12:00:00"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.INSERT)
	public Result insert(AssetStockGoodsInVO assetStockGoodsInVO) {
		Result result=assetStockGoodsInService.insert(assetStockGoodsInVO,false);
		return result;
	}



	/**
	 * 删除库存物品单
	*/
	@ApiOperation(value = "删除库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569508271568715776")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockGoodsInVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockGoodsInService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存物品单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockGoodsInVOMeta.IDS)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockGoodsInService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存物品单
	*/
	@ApiOperation(value = "更新库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569508271568715776"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NAME , value = "单据名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STOCK_TYPE , value = "入库类型" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "569147473092673536"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "donation"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class , example = "2022-04-12 12:00:00"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockGoodsInVOMeta.PAGE_INDEX , AssetStockGoodsInVOMeta.PAGE_SIZE , AssetStockGoodsInVOMeta.SEARCH_FIELD , AssetStockGoodsInVOMeta.FUZZY_FIELD , AssetStockGoodsInVOMeta.SEARCH_VALUE , AssetStockGoodsInVOMeta.DIRTY_FIELDS , AssetStockGoodsInVOMeta.SORT_FIELD , AssetStockGoodsInVOMeta.SORT_TYPE , AssetStockGoodsInVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsInVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.UPDATE)
	public Result update(AssetStockGoodsInVO assetStockGoodsInVO) {
		Result result=assetStockGoodsInService.update(assetStockGoodsInVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存物品单
	*/
	@ApiOperation(value = "保存库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569508271568715776"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NAME , value = "单据名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STOCK_TYPE , value = "入库类型" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "569147473092673536"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "donation"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class , example = "2022-04-12 12:00:00"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsInVOMeta.PAGE_INDEX , AssetStockGoodsInVOMeta.PAGE_SIZE , AssetStockGoodsInVOMeta.SEARCH_FIELD , AssetStockGoodsInVOMeta.FUZZY_FIELD , AssetStockGoodsInVOMeta.SEARCH_VALUE , AssetStockGoodsInVOMeta.DIRTY_FIELDS , AssetStockGoodsInVOMeta.SORT_FIELD , AssetStockGoodsInVOMeta.SORT_TYPE , AssetStockGoodsInVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsInVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.SAVE)
	public Result save(AssetStockGoodsInVO assetStockGoodsInVO) {
		Result result=assetStockGoodsInService.save(assetStockGoodsInVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存物品单
	*/
	@ApiOperation(value = "获取库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockGoodsInVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.GET_BY_ID)
	public Result<AssetStockGoodsIn> getById(String id) {
		Result<AssetStockGoodsIn> result=new Result<>();
		AssetStockGoodsIn assetStockGoodsIn=assetStockGoodsInService.getById(id);
		// join 关联的对象
		assetStockGoodsInService.dao().fill(assetStockGoodsIn)
			.with("ownerCompany")
			.with("originator")
			.with("manager")
			.with(AssetStockGoodsInMeta.WAREHOUSE)
			.with(AssetStockGoodsInMeta.SOURCE)
			.with(AssetStockGoodsInMeta.STOCK_TYPE_DICT)
			.execute();
		result.success(true).data(assetStockGoodsIn);
		return result;
	}


	/**
	 * 批量获取库存物品单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存物品单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockGoodsInVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockGoodsInVOMeta.IDS)
		@SentinelResource(value = AssetStockGoodsInServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockGoodsIn>> getByIds(List<String> ids) {
		Result<List<AssetStockGoodsIn>> result=new Result<>();
		List<AssetStockGoodsIn> list=assetStockGoodsInService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存物品单
	*/
	@ApiOperation(value = "查询库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569508271568715776"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NAME , value = "单据名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STOCK_TYPE , value = "入库类型" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "569147473092673536"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "donation"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class , example = "2022-04-12 12:00:00"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsInVOMeta.PAGE_INDEX , AssetStockGoodsInVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockGoodsInServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.QUERY_LIST)
	public Result<List<AssetStockGoodsIn>> queryList(AssetStockGoodsInVO sample) {
		Result<List<AssetStockGoodsIn>> result=new Result<>();
		List<AssetStockGoodsIn> list=assetStockGoodsInService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存物品单
	*/
	@ApiOperation(value = "分页查询库存物品单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569508271568715776"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NAME , value = "单据名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.STOCK_TYPE , value = "入库类型" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "569147473092673536"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "donation"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class , example = "2022-04-12 12:00:00"),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsInVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsInServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockGoodsIn>> queryPagedList(AssetStockGoodsInVO sample) {
		Result<PagedList<AssetStockGoodsIn>> result=new Result<>();
		PagedList<AssetStockGoodsIn> list=assetStockGoodsInService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStockGoodsInService.dao().fill(list)
			.with("ownerCompany")
			.with("originator")
			.with("manager")
			.with(AssetStockGoodsInMeta.WAREHOUSE)
			.with(AssetStockGoodsInMeta.SOURCE)
			.with(AssetStockGoodsInMeta.STOCK_TYPE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsInVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsInServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetStockGoodsInService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsInVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsInServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetStockGoodsInService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsInVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsInVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsInServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetStockGoodsInService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetStockGoodsInServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsInServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetStockGoodsInService.approve(approveVO);
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockGoodsInServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsInServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockGoodsInVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockGoodsInService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockGoodsInServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsInServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockGoodsInService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockGoodsInServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsInServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockGoodsInService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}