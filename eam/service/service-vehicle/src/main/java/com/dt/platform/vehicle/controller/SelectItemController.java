package com.dt.platform.vehicle.controller;


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


import com.dt.platform.proxy.vehicle.SelectItemServiceProxy;
import com.dt.platform.domain.vehicle.meta.SelectItemVOMeta;
import com.dt.platform.domain.vehicle.SelectItem;
import com.dt.platform.domain.vehicle.SelectItemVO;
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
import com.dt.platform.domain.vehicle.meta.SelectItemMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.ISelectItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆数据 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:34:30
*/

@Api(tags = "车辆数据")
@ApiSort(0)
@RestController("VehicleSelectItemController")
public class SelectItemController extends SuperController {

	@Autowired
	private ISelectItemService selectItemService;


	/**
	 * 添加车辆数据
	*/
	@ApiOperation(value = "添加车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = SelectItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.INSERT)
	public Result insert(SelectItemVO selectItemVO) {
		Result result=selectItemService.insert(selectItemVO,false);
		return result;
	}



	/**
	 * 删除车辆数据
	*/
	@ApiOperation(value = "删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SelectItemVOMeta.ID)
	@SentinelResource(value = SelectItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=selectItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SelectItemVOMeta.IDS)
	@SentinelResource(value = SelectItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=selectItemService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新车辆数据
	*/
	@ApiOperation(value = "更新车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SelectItemVOMeta.PAGE_INDEX , SelectItemVOMeta.PAGE_SIZE , SelectItemVOMeta.SEARCH_FIELD , SelectItemVOMeta.FUZZY_FIELD , SelectItemVOMeta.SEARCH_VALUE , SelectItemVOMeta.DIRTY_FIELDS , SelectItemVOMeta.SORT_FIELD , SelectItemVOMeta.SORT_TYPE , SelectItemVOMeta.IDS } )
	@NotNull(name = SelectItemVOMeta.ID)
	@SentinelResource(value = SelectItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.UPDATE)
	public Result update(SelectItemVO selectItemVO) {
		Result result=selectItemService.update(selectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆数据
	*/
	@ApiOperation(value = "保存车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SelectItemVOMeta.PAGE_INDEX , SelectItemVOMeta.PAGE_SIZE , SelectItemVOMeta.SEARCH_FIELD , SelectItemVOMeta.FUZZY_FIELD , SelectItemVOMeta.SEARCH_VALUE , SelectItemVOMeta.DIRTY_FIELDS , SelectItemVOMeta.SORT_FIELD , SelectItemVOMeta.SORT_TYPE , SelectItemVOMeta.IDS } )
	@NotNull(name = SelectItemVOMeta.ID)
	@SentinelResource(value = SelectItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.SAVE)
	public Result save(SelectItemVO selectItemVO) {
		Result result=selectItemService.save(selectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆数据
	*/
	@ApiOperation(value = "获取车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SelectItemVOMeta.ID)
	@SentinelResource(value = SelectItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.GET_BY_ID)
	public Result<SelectItem> getById(String id) {
		Result<SelectItem> result=new Result<>();
		SelectItem selectItem=selectItemService.getById(id);
		result.success(true).data(selectItem);
		return result;
	}


	/**
	 * 批量获取车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = SelectItemVOMeta.IDS)
		@SentinelResource(value = SelectItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.GET_BY_IDS)
	public Result<List<SelectItem>> getByIds(List<String> ids) {
		Result<List<SelectItem>> result=new Result<>();
		List<SelectItem> list=selectItemService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆数据
	*/
	@ApiOperation(value = "查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SelectItemVOMeta.PAGE_INDEX , SelectItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SelectItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.QUERY_LIST)
	public Result<List<SelectItem>> queryList(SelectItemVO sample) {
		Result<List<SelectItem>> result=new Result<>();
		List<SelectItem> list=selectItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆数据
	*/
	@ApiOperation(value = "分页查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SelectItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SelectItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<SelectItem>> queryPagedList(SelectItemVO sample) {
		Result<PagedList<SelectItem>> result=new Result<>();
		PagedList<SelectItem> list=selectItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SelectItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SelectItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SelectItemVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=selectItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SelectItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SelectItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=selectItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = SelectItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SelectItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=selectItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}