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


import com.dt.platform.proxy.eam.InventoryPositionServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryPositionVOMeta;
import com.dt.platform.domain.eam.InventoryPosition;
import com.dt.platform.domain.eam.InventoryPositionVO;
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
import com.dt.platform.domain.eam.meta.InventoryPositionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryPositionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点位置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-04 11:05:01
*/

@Api(tags = "盘点位置")
@ApiSort(0)
@RestController("EamInventoryPositionController")
public class InventoryPositionController extends SuperController {

	@Autowired
	private IInventoryPositionService inventoryPositionService;


	/**
	 * 添加盘点位置
	*/
	@ApiOperation(value = "添加盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.VALUE , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InventoryPositionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.INSERT)
	public Result insert(InventoryPositionVO inventoryPositionVO) {
		Result result=inventoryPositionService.insert(inventoryPositionVO,false);
		return result;
	}



	/**
	 * 删除盘点位置
	*/
	@ApiOperation(value = "删除盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryPositionVOMeta.ID)
	@SentinelResource(value = InventoryPositionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryPositionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点位置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryPositionVOMeta.IDS)
	@SentinelResource(value = InventoryPositionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryPositionService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新盘点位置
	*/
	@ApiOperation(value = "更新盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.VALUE , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryPositionVOMeta.PAGE_INDEX , InventoryPositionVOMeta.PAGE_SIZE , InventoryPositionVOMeta.SEARCH_FIELD , InventoryPositionVOMeta.FUZZY_FIELD , InventoryPositionVOMeta.SEARCH_VALUE , InventoryPositionVOMeta.DIRTY_FIELDS , InventoryPositionVOMeta.SORT_FIELD , InventoryPositionVOMeta.SORT_TYPE , InventoryPositionVOMeta.IDS } )
	@NotNull(name = InventoryPositionVOMeta.ID)
	@SentinelResource(value = InventoryPositionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.UPDATE)
	public Result update(InventoryPositionVO inventoryPositionVO) {
		Result result=inventoryPositionService.update(inventoryPositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点位置
	*/
	@ApiOperation(value = "保存盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.VALUE , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryPositionVOMeta.PAGE_INDEX , InventoryPositionVOMeta.PAGE_SIZE , InventoryPositionVOMeta.SEARCH_FIELD , InventoryPositionVOMeta.FUZZY_FIELD , InventoryPositionVOMeta.SEARCH_VALUE , InventoryPositionVOMeta.DIRTY_FIELDS , InventoryPositionVOMeta.SORT_FIELD , InventoryPositionVOMeta.SORT_TYPE , InventoryPositionVOMeta.IDS } )
	@NotNull(name = InventoryPositionVOMeta.ID)
	@SentinelResource(value = InventoryPositionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.SAVE)
	public Result save(InventoryPositionVO inventoryPositionVO) {
		Result result=inventoryPositionService.save(inventoryPositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点位置
	*/
	@ApiOperation(value = "获取盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryPositionVOMeta.ID)
	@SentinelResource(value = InventoryPositionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.GET_BY_ID)
	public Result<InventoryPosition> getById(String id) {
		Result<InventoryPosition> result=new Result<>();
		InventoryPosition inventoryPosition=inventoryPositionService.getById(id);
		result.success(true).data(inventoryPosition);
		return result;
	}


	/**
	 * 批量获取盘点位置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点位置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryPositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryPositionVOMeta.IDS)
		@SentinelResource(value = InventoryPositionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.GET_BY_IDS)
	public Result<List<InventoryPosition>> getByIds(List<String> ids) {
		Result<List<InventoryPosition>> result=new Result<>();
		List<InventoryPosition> list=inventoryPositionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点位置
	*/
	@ApiOperation(value = "查询盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.VALUE , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryPositionVOMeta.PAGE_INDEX , InventoryPositionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryPositionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.QUERY_LIST)
	public Result<List<InventoryPosition>> queryList(InventoryPositionVO sample) {
		Result<List<InventoryPosition>> result=new Result<>();
		List<InventoryPosition> list=inventoryPositionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点位置
	*/
	@ApiOperation(value = "分页查询盘点位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.VALUE , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryPositionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPositionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryPosition>> queryPagedList(InventoryPositionVO sample) {
		Result<PagedList<InventoryPosition>> result=new Result<>();
		PagedList<InventoryPosition> list=inventoryPositionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryPositionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryPositionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryPositionVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inventoryPositionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryPositionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryPositionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inventoryPositionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InventoryPositionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryPositionServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inventoryPositionService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}