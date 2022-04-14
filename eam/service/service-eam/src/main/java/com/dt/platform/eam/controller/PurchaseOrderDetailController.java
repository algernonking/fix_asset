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


import com.dt.platform.proxy.eam.PurchaseOrderDetailServiceProxy;
import com.dt.platform.domain.eam.meta.PurchaseOrderDetailVOMeta;
import com.dt.platform.domain.eam.PurchaseOrderDetail;
import com.dt.platform.domain.eam.PurchaseOrderDetailVO;
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
import com.dt.platform.domain.eam.meta.PurchaseOrderDetailMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPurchaseOrderDetailService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 订单明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-15 05:22:46
*/

@Api(tags = "订单明细")
@ApiSort(0)
@RestController("EamPurchaseOrderDetailController")
public class PurchaseOrderDetailController extends SuperController {

	@Autowired
	private IPurchaseOrderDetailService purchaseOrderDetailService;


	/**
	 * 添加订单明细
	*/
	@ApiOperation(value = "添加订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = PurchaseOrderDetailVOMeta.ORDER_ID)
	@NotNull(name = PurchaseOrderDetailVOMeta.ASSET_ID)
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.INSERT)
	public Result insert(PurchaseOrderDetailVO purchaseOrderDetailVO) {
		Result result=purchaseOrderDetailService.insert(purchaseOrderDetailVO,false);
		return result;
	}



	/**
	 * 删除订单明细
	*/
	@ApiOperation(value = "删除订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = PurchaseOrderDetailVOMeta.ID)
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=purchaseOrderDetailService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除订单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = PurchaseOrderDetailVOMeta.IDS)
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=purchaseOrderDetailService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新订单明细
	*/
	@ApiOperation(value = "更新订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { PurchaseOrderDetailVOMeta.PAGE_INDEX , PurchaseOrderDetailVOMeta.PAGE_SIZE , PurchaseOrderDetailVOMeta.SEARCH_FIELD , PurchaseOrderDetailVOMeta.FUZZY_FIELD , PurchaseOrderDetailVOMeta.SEARCH_VALUE , PurchaseOrderDetailVOMeta.DIRTY_FIELDS , PurchaseOrderDetailVOMeta.SORT_FIELD , PurchaseOrderDetailVOMeta.SORT_TYPE , PurchaseOrderDetailVOMeta.IDS } )
	@NotNull(name = PurchaseOrderDetailVOMeta.ID)
	@NotNull(name = PurchaseOrderDetailVOMeta.ORDER_ID)
	@NotNull(name = PurchaseOrderDetailVOMeta.ASSET_ID)
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.UPDATE)
	public Result update(PurchaseOrderDetailVO purchaseOrderDetailVO) {
		Result result=purchaseOrderDetailService.update(purchaseOrderDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存订单明细
	*/
	@ApiOperation(value = "保存订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PurchaseOrderDetailVOMeta.PAGE_INDEX , PurchaseOrderDetailVOMeta.PAGE_SIZE , PurchaseOrderDetailVOMeta.SEARCH_FIELD , PurchaseOrderDetailVOMeta.FUZZY_FIELD , PurchaseOrderDetailVOMeta.SEARCH_VALUE , PurchaseOrderDetailVOMeta.DIRTY_FIELDS , PurchaseOrderDetailVOMeta.SORT_FIELD , PurchaseOrderDetailVOMeta.SORT_TYPE , PurchaseOrderDetailVOMeta.IDS } )
	@NotNull(name = PurchaseOrderDetailVOMeta.ID)
	@NotNull(name = PurchaseOrderDetailVOMeta.ORDER_ID)
	@NotNull(name = PurchaseOrderDetailVOMeta.ASSET_ID)
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.SAVE)
	public Result save(PurchaseOrderDetailVO purchaseOrderDetailVO) {
		Result result=purchaseOrderDetailService.save(purchaseOrderDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取订单明细
	*/
	@ApiOperation(value = "获取订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = PurchaseOrderDetailVOMeta.ID)
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.GET_BY_ID)
	public Result<PurchaseOrderDetail> getById(String id) {
		Result<PurchaseOrderDetail> result=new Result<>();
		PurchaseOrderDetail purchaseOrderDetail=purchaseOrderDetailService.getById(id);
		result.success(true).data(purchaseOrderDetail);
		return result;
	}


	/**
	 * 批量获取订单明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取订单明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = PurchaseOrderDetailVOMeta.IDS)
		@SentinelResource(value = PurchaseOrderDetailServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.GET_BY_IDS)
	public Result<List<PurchaseOrderDetail>> getByIds(List<String> ids) {
		Result<List<PurchaseOrderDetail>> result=new Result<>();
		List<PurchaseOrderDetail> list=purchaseOrderDetailService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询订单明细
	*/
	@ApiOperation(value = "查询订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PurchaseOrderDetailVOMeta.PAGE_INDEX , PurchaseOrderDetailVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.QUERY_LIST)
	public Result<List<PurchaseOrderDetail>> queryList(PurchaseOrderDetailVO sample) {
		Result<List<PurchaseOrderDetail>> result=new Result<>();
		List<PurchaseOrderDetail> list=purchaseOrderDetailService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询订单明细
	*/
	@ApiOperation(value = "分页查询订单明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ORDER_ID , value = "订单" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseOrderDetailVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseOrderDetailServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PurchaseOrderDetail>> queryPagedList(PurchaseOrderDetailVO sample) {
		Result<PagedList<PurchaseOrderDetail>> result=new Result<>();
		PagedList<PurchaseOrderDetail> list=purchaseOrderDetailService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseOrderDetailServiceProxy.EXPORT_EXCEL)
	public void exportExcel(PurchaseOrderDetailVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=purchaseOrderDetailService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = PurchaseOrderDetailServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseOrderDetailServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=purchaseOrderDetailService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = PurchaseOrderDetailServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseOrderDetailServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=purchaseOrderDetailService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}