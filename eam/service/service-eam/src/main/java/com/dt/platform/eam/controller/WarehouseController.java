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


import com.dt.platform.proxy.eam.WarehouseServiceProxy;
import com.dt.platform.domain.eam.meta.WarehouseVOMeta;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.WarehouseVO;
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
import com.dt.platform.domain.eam.meta.WarehouseMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IWarehouseService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 仓库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 09:41:56
*/

@Api(tags = "仓库")
@ApiSort(0)
@RestController("EamWarehouseController")
public class WarehouseController extends SuperController {

	@Autowired
	private IWarehouseService warehouseService;

	
	/**
	 * 添加仓库
	*/
	@ApiOperation(value = "添加仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024653385170944"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = WarehouseVOMeta.ID)
	@SentinelResource(value = WarehouseServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.INSERT)
	public Result insert(WarehouseVO warehouseVO) {
		Result result=warehouseService.insert(warehouseVO);
		return result;
	}

	
	/**
	 * 删除仓库
	*/
	@ApiOperation(value = "删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024653385170944")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = WarehouseVOMeta.ID)
	@SentinelResource(value = WarehouseServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=warehouseService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = WarehouseVOMeta.IDS)
	@SentinelResource(value = WarehouseServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=warehouseService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新仓库
	*/
	@ApiOperation(value = "更新仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024653385170944"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { WarehouseVOMeta.PAGE_INDEX , WarehouseVOMeta.PAGE_SIZE , WarehouseVOMeta.SEARCH_FIELD , WarehouseVOMeta.FUZZY_FIELD , WarehouseVOMeta.SEARCH_VALUE , WarehouseVOMeta.SORT_FIELD , WarehouseVOMeta.SORT_TYPE , WarehouseVOMeta.IDS } ) 
	@NotNull(name = WarehouseVOMeta.ID)
	@SentinelResource(value = WarehouseServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.UPDATE)
	public Result update(WarehouseVO warehouseVO) {
		Result result=warehouseService.update(warehouseVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存仓库
	*/
	@ApiOperation(value = "保存仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024653385170944"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WarehouseVOMeta.PAGE_INDEX , WarehouseVOMeta.PAGE_SIZE , WarehouseVOMeta.SEARCH_FIELD , WarehouseVOMeta.FUZZY_FIELD , WarehouseVOMeta.SEARCH_VALUE , WarehouseVOMeta.SORT_FIELD , WarehouseVOMeta.SORT_TYPE , WarehouseVOMeta.IDS } )
	@NotNull(name = WarehouseVOMeta.ID)
	@SentinelResource(value = WarehouseServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.SAVE)
	public Result save(WarehouseVO warehouseVO) {
		Result result=warehouseService.save(warehouseVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取仓库
	*/
	@ApiOperation(value = "获取仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = WarehouseVOMeta.ID)
	@SentinelResource(value = WarehouseServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.GET_BY_ID)
	public Result<Warehouse> getById(String id) {
		Result<Warehouse> result=new Result<>();
		Warehouse warehouse=warehouseService.getById(id);
		result.success(true).data(warehouse);
		return result;
	}


	/**
	 * 批量删除仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除仓库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = WarehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = WarehouseVOMeta.IDS)
		@SentinelResource(value = WarehouseServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.GET_BY_IDS)
	public Result<List<Warehouse>> getByIds(List<String> ids) {
		Result<List<Warehouse>> result=new Result<>();
		List<Warehouse> list=warehouseService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询仓库
	*/
	@ApiOperation(value = "查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024653385170944"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WarehouseVOMeta.PAGE_INDEX , WarehouseVOMeta.PAGE_SIZE } )
	@SentinelResource(value = WarehouseServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.QUERY_LIST)
	public Result<List<Warehouse>> queryList(WarehouseVO sample) {
		Result<List<Warehouse>> result=new Result<>();
		List<Warehouse> list=warehouseService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询仓库
	*/
	@ApiOperation(value = "分页查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WarehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024653385170944"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = WarehouseVOMeta.WAREHOUSE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = WarehouseServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WarehouseServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Warehouse>> queryPagedList(WarehouseVO sample) {
		Result<PagedList<Warehouse>> result=new Result<>();
		PagedList<Warehouse> list=warehouseService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = WarehouseServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WarehouseServiceProxy.EXPORT_EXCEL)
	public void exportExcel(WarehouseVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=warehouseService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = WarehouseServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WarehouseServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=warehouseService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = WarehouseServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WarehouseServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=warehouseService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}