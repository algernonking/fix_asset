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


import com.dt.platform.proxy.eam.InventoryDirectorServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryDirectorVOMeta;
import com.dt.platform.domain.eam.InventoryDirector;
import com.dt.platform.domain.eam.InventoryDirectorVO;
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
import com.dt.platform.domain.eam.meta.InventoryDirectorMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryDirectorService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点负责人 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-19 21:45:07
*/

@Api(tags = "盘点负责人")
@ApiSort(0)
@RestController("EamInventoryDirectorController")
public class InventoryDirectorController extends SuperController {

	@Autowired
	private IInventoryDirectorService inventoryDirectorService;


	/**
	 * 添加盘点负责人
	*/
	@ApiOperation(value = "添加盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InventoryDirectorServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.INSERT)
	public Result insert(InventoryDirectorVO inventoryDirectorVO) {
		Result result=inventoryDirectorService.insert(inventoryDirectorVO,false);
		return result;
	}



	/**
	 * 删除盘点负责人
	*/
	@ApiOperation(value = "删除盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryDirectorVOMeta.ID)
	@SentinelResource(value = InventoryDirectorServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryDirectorService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点负责人 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryDirectorVOMeta.IDS)
	@SentinelResource(value = InventoryDirectorServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryDirectorService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新盘点负责人
	*/
	@ApiOperation(value = "更新盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryDirectorVOMeta.PAGE_INDEX , InventoryDirectorVOMeta.PAGE_SIZE , InventoryDirectorVOMeta.SEARCH_FIELD , InventoryDirectorVOMeta.FUZZY_FIELD , InventoryDirectorVOMeta.SEARCH_VALUE , InventoryDirectorVOMeta.DIRTY_FIELDS , InventoryDirectorVOMeta.SORT_FIELD , InventoryDirectorVOMeta.SORT_TYPE , InventoryDirectorVOMeta.IDS } )
	@NotNull(name = InventoryDirectorVOMeta.ID)
	@SentinelResource(value = InventoryDirectorServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.UPDATE)
	public Result update(InventoryDirectorVO inventoryDirectorVO) {
		Result result=inventoryDirectorService.update(inventoryDirectorVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点负责人
	*/
	@ApiOperation(value = "保存盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryDirectorVOMeta.PAGE_INDEX , InventoryDirectorVOMeta.PAGE_SIZE , InventoryDirectorVOMeta.SEARCH_FIELD , InventoryDirectorVOMeta.FUZZY_FIELD , InventoryDirectorVOMeta.SEARCH_VALUE , InventoryDirectorVOMeta.DIRTY_FIELDS , InventoryDirectorVOMeta.SORT_FIELD , InventoryDirectorVOMeta.SORT_TYPE , InventoryDirectorVOMeta.IDS } )
	@NotNull(name = InventoryDirectorVOMeta.ID)
	@SentinelResource(value = InventoryDirectorServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.SAVE)
	public Result save(InventoryDirectorVO inventoryDirectorVO) {
		Result result=inventoryDirectorService.save(inventoryDirectorVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点负责人
	*/
	@ApiOperation(value = "获取盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryDirectorVOMeta.ID)
	@SentinelResource(value = InventoryDirectorServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.GET_BY_ID)
	public Result<InventoryDirector> getById(String id) {
		Result<InventoryDirector> result=new Result<>();
		InventoryDirector inventoryDirector=inventoryDirectorService.getById(id);
		result.success(true).data(inventoryDirector);
		return result;
	}


	/**
	 * 批量获取盘点负责人 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点负责人")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryDirectorVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryDirectorVOMeta.IDS)
		@SentinelResource(value = InventoryDirectorServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.GET_BY_IDS)
	public Result<List<InventoryDirector>> getByIds(List<String> ids) {
		Result<List<InventoryDirector>> result=new Result<>();
		List<InventoryDirector> list=inventoryDirectorService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点负责人
	*/
	@ApiOperation(value = "查询盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryDirectorVOMeta.PAGE_INDEX , InventoryDirectorVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryDirectorServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.QUERY_LIST)
	public Result<List<InventoryDirector>> queryList(InventoryDirectorVO sample) {
		Result<List<InventoryDirector>> result=new Result<>();
		List<InventoryDirector> list=inventoryDirectorService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点负责人
	*/
	@ApiOperation(value = "分页查询盘点负责人")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryDirectorVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryDirectorVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryDirectorServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryDirectorServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryDirector>> queryPagedList(InventoryDirectorVO sample) {
		Result<PagedList<InventoryDirector>> result=new Result<>();
		PagedList<InventoryDirector> list=inventoryDirectorService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryDirectorServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryDirectorServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryDirectorVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inventoryDirectorService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryDirectorServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryDirectorServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inventoryDirectorService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InventoryDirectorServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryDirectorServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inventoryDirectorService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}