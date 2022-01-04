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


import com.dt.platform.proxy.eam.InventoryWarehouseServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryWarehouseVOMeta;
import com.dt.platform.domain.eam.InventoryWarehouse;
import com.dt.platform.domain.eam.InventoryWarehouseVO;
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
import com.dt.platform.domain.eam.meta.InventoryWarehouseMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryWarehouseService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点仓库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-04 11:09:02
*/

@Api(tags = "盘点仓库")
@ApiSort(0)
@RestController("EamInventoryWarehouseController")
public class InventoryWarehouseController extends SuperController {

	@Autowired
	private IInventoryWarehouseService inventoryWarehouseService;


	/**
	 * 添加盘点仓库
	*/
	@ApiOperation(value = "添加盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.VALUE , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InventoryWarehouseServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.INSERT)
	public Result insert(InventoryWarehouseVO inventoryWarehouseVO) {
		Result result=inventoryWarehouseService.insert(inventoryWarehouseVO,false);
		return result;
	}



	/**
	 * 删除盘点仓库
	*/
	@ApiOperation(value = "删除盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryWarehouseVOMeta.ID)
	@SentinelResource(value = InventoryWarehouseServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryWarehouseService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryWarehouseVOMeta.IDS)
	@SentinelResource(value = InventoryWarehouseServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryWarehouseService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新盘点仓库
	*/
	@ApiOperation(value = "更新盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.VALUE , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryWarehouseVOMeta.PAGE_INDEX , InventoryWarehouseVOMeta.PAGE_SIZE , InventoryWarehouseVOMeta.SEARCH_FIELD , InventoryWarehouseVOMeta.FUZZY_FIELD , InventoryWarehouseVOMeta.SEARCH_VALUE , InventoryWarehouseVOMeta.DIRTY_FIELDS , InventoryWarehouseVOMeta.SORT_FIELD , InventoryWarehouseVOMeta.SORT_TYPE , InventoryWarehouseVOMeta.IDS } )
	@NotNull(name = InventoryWarehouseVOMeta.ID)
	@SentinelResource(value = InventoryWarehouseServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.UPDATE)
	public Result update(InventoryWarehouseVO inventoryWarehouseVO) {
		Result result=inventoryWarehouseService.update(inventoryWarehouseVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点仓库
	*/
	@ApiOperation(value = "保存盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.VALUE , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryWarehouseVOMeta.PAGE_INDEX , InventoryWarehouseVOMeta.PAGE_SIZE , InventoryWarehouseVOMeta.SEARCH_FIELD , InventoryWarehouseVOMeta.FUZZY_FIELD , InventoryWarehouseVOMeta.SEARCH_VALUE , InventoryWarehouseVOMeta.DIRTY_FIELDS , InventoryWarehouseVOMeta.SORT_FIELD , InventoryWarehouseVOMeta.SORT_TYPE , InventoryWarehouseVOMeta.IDS } )
	@NotNull(name = InventoryWarehouseVOMeta.ID)
	@SentinelResource(value = InventoryWarehouseServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.SAVE)
	public Result save(InventoryWarehouseVO inventoryWarehouseVO) {
		Result result=inventoryWarehouseService.save(inventoryWarehouseVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点仓库
	*/
	@ApiOperation(value = "获取盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryWarehouseVOMeta.ID)
	@SentinelResource(value = InventoryWarehouseServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.GET_BY_ID)
	public Result<InventoryWarehouse> getById(String id) {
		Result<InventoryWarehouse> result=new Result<>();
		InventoryWarehouse inventoryWarehouse=inventoryWarehouseService.getById(id);
		result.success(true).data(inventoryWarehouse);
		return result;
	}


	/**
	 * 批量获取盘点仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点仓库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryWarehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryWarehouseVOMeta.IDS)
		@SentinelResource(value = InventoryWarehouseServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.GET_BY_IDS)
	public Result<List<InventoryWarehouse>> getByIds(List<String> ids) {
		Result<List<InventoryWarehouse>> result=new Result<>();
		List<InventoryWarehouse> list=inventoryWarehouseService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点仓库
	*/
	@ApiOperation(value = "查询盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.VALUE , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryWarehouseVOMeta.PAGE_INDEX , InventoryWarehouseVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryWarehouseServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.QUERY_LIST)
	public Result<List<InventoryWarehouse>> queryList(InventoryWarehouseVO sample) {
		Result<List<InventoryWarehouse>> result=new Result<>();
		List<InventoryWarehouse> list=inventoryWarehouseService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点仓库
	*/
	@ApiOperation(value = "分页查询盘点仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.VALUE , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryWarehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryWarehouseServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryWarehouseServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryWarehouse>> queryPagedList(InventoryWarehouseVO sample) {
		Result<PagedList<InventoryWarehouse>> result=new Result<>();
		PagedList<InventoryWarehouse> list=inventoryWarehouseService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryWarehouseServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryWarehouseServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryWarehouseVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inventoryWarehouseService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryWarehouseServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryWarehouseServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inventoryWarehouseService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InventoryWarehouseServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryWarehouseServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inventoryWarehouseService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}