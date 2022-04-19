package com.dt.platform.eam.controller;


import java.util.List;

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


import com.dt.platform.proxy.eam.AssetStockGoodsServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockGoodsVOMeta;
import com.dt.platform.domain.eam.AssetStockGoods;
import com.dt.platform.domain.eam.AssetStockGoodsVO;
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
import com.dt.platform.domain.eam.meta.AssetStockGoodsMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockGoodsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 物品库存 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-19 10:04:37
*/

@Api(tags = "物品库存")
@ApiSort(0)
@RestController("EamAssetStockGoodsController")
public class AssetStockGoodsController extends SuperController {

	@Autowired
	private IAssetStockGoodsService assetStockGoodsService;


	/**
	 * 添加物品库存
	*/
	@ApiOperation(value = "添加物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockGoodsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.INSERT)
	public Result insert(AssetStockGoodsVO assetStockGoodsVO) {
		Result result=assetStockGoodsService.insert(assetStockGoodsVO,false);
		return result;
	}



	/**
	 * 删除物品库存
	*/
	@ApiOperation(value = "删除物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockGoodsVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockGoodsService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除物品库存 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockGoodsVOMeta.IDS)
	@SentinelResource(value = AssetStockGoodsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockGoodsService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新物品库存
	*/
	@ApiOperation(value = "更新物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockGoodsVOMeta.PAGE_INDEX , AssetStockGoodsVOMeta.PAGE_SIZE , AssetStockGoodsVOMeta.SEARCH_FIELD , AssetStockGoodsVOMeta.FUZZY_FIELD , AssetStockGoodsVOMeta.SEARCH_VALUE , AssetStockGoodsVOMeta.DIRTY_FIELDS , AssetStockGoodsVOMeta.SORT_FIELD , AssetStockGoodsVOMeta.SORT_TYPE , AssetStockGoodsVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.UPDATE)
	public Result update(AssetStockGoodsVO assetStockGoodsVO) {
		Result result=assetStockGoodsService.update(assetStockGoodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存物品库存
	*/
	@ApiOperation(value = "保存物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsVOMeta.PAGE_INDEX , AssetStockGoodsVOMeta.PAGE_SIZE , AssetStockGoodsVOMeta.SEARCH_FIELD , AssetStockGoodsVOMeta.FUZZY_FIELD , AssetStockGoodsVOMeta.SEARCH_VALUE , AssetStockGoodsVOMeta.DIRTY_FIELDS , AssetStockGoodsVOMeta.SORT_FIELD , AssetStockGoodsVOMeta.SORT_TYPE , AssetStockGoodsVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.SAVE)
	public Result save(AssetStockGoodsVO assetStockGoodsVO) {
		Result result=assetStockGoodsService.save(assetStockGoodsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取物品库存
	*/
	@ApiOperation(value = "获取物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockGoodsVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.GET_BY_ID)
	public Result<AssetStockGoods> getById(String id) {
		Result<AssetStockGoods> result=new Result<>();
		AssetStockGoods assetStockGoods=assetStockGoodsService.getById(id);
		result.success(true).data(assetStockGoods);
		return result;
	}


	/**
	 * 批量获取物品库存 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取物品库存")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockGoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockGoodsVOMeta.IDS)
		@SentinelResource(value = AssetStockGoodsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockGoods>> getByIds(List<String> ids) {
		Result<List<AssetStockGoods>> result=new Result<>();
		List<AssetStockGoods> list=assetStockGoodsService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询物品库存
	*/
	@ApiOperation(value = "查询物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsVOMeta.PAGE_INDEX , AssetStockGoodsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockGoodsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.QUERY_LIST)
	public Result<List<AssetStockGoods>> queryList(AssetStockGoodsVO sample) {
		Result<List<AssetStockGoods>> result=new Result<>();
		List<AssetStockGoods> list=assetStockGoodsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询物品库存
	*/
	@ApiOperation(value = "分页查询物品库存")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_TYPE , value = "库存类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NAME , value = "单据名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.RECEIVER_USER_NAME , value = "接收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.BUSINESS_DATE , value = "业务时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.STOCK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockGoodsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockGoods>> queryPagedList(AssetStockGoodsVO sample) {
		Result<PagedList<AssetStockGoods>> result=new Result<>();
		PagedList<AssetStockGoods> list=assetStockGoodsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockGoodsServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockGoodsVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockGoodsService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockGoodsServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockGoodsService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockGoodsServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockGoodsService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}