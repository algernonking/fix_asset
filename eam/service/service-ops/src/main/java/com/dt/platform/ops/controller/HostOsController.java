package com.dt.platform.ops.controller;

 
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


import com.dt.platform.proxy.ops.HostOsServiceProxy;
import com.dt.platform.domain.ops.meta.HostOsVOMeta;
import com.dt.platform.domain.ops.HostOs;
import com.dt.platform.domain.ops.HostOsVO;
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
import com.dt.platform.domain.ops.meta.HostOsMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IHostOsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 操作系统 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-15 18:34:46
*/

@Api(tags = "操作系统")
@ApiSort(0)
@RestController("OpsHostOsController")
public class HostOsController extends SuperController {

	@Autowired
	private IHostOsService hostOsService;

	
	/**
	 * 添加操作系统
	*/
	@ApiOperation(value = "添加操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478258462665478144"),
		@ApiImplicitParam(name = HostOsVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostOsVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473631451401682944"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = HostOsVOMeta.ID)
	@SentinelResource(value = HostOsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.INSERT)
	public Result insert(HostOsVO hostOsVO) {
		Result result=hostOsService.insert(hostOsVO);
		return result;
	}

	
	/**
	 * 删除操作系统
	*/
	@ApiOperation(value = "删除操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478258462665478144")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = HostOsVOMeta.ID)
	@SentinelResource(value = HostOsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=hostOsService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除操作系统 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = HostOsVOMeta.IDS)
	@SentinelResource(value = HostOsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=hostOsService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新操作系统
	*/
	@ApiOperation(value = "更新操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478258462665478144"),
		@ApiImplicitParam(name = HostOsVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostOsVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473631451401682944"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { HostOsVOMeta.PAGE_INDEX , HostOsVOMeta.PAGE_SIZE , HostOsVOMeta.SEARCH_FIELD , HostOsVOMeta.FUZZY_FIELD , HostOsVOMeta.SEARCH_VALUE , HostOsVOMeta.SORT_FIELD , HostOsVOMeta.SORT_TYPE , HostOsVOMeta.IDS } ) 
	@NotNull(name = HostOsVOMeta.ID)
	@SentinelResource(value = HostOsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.UPDATE)
	public Result update(HostOsVO hostOsVO) {
		Result result=hostOsService.update(hostOsVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存操作系统
	*/
	@ApiOperation(value = "保存操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478258462665478144"),
		@ApiImplicitParam(name = HostOsVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostOsVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473631451401682944"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostOsVOMeta.PAGE_INDEX , HostOsVOMeta.PAGE_SIZE , HostOsVOMeta.SEARCH_FIELD , HostOsVOMeta.FUZZY_FIELD , HostOsVOMeta.SEARCH_VALUE , HostOsVOMeta.SORT_FIELD , HostOsVOMeta.SORT_TYPE , HostOsVOMeta.IDS } )
	@NotNull(name = HostOsVOMeta.ID)
	@SentinelResource(value = HostOsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.SAVE)
	public Result save(HostOsVO hostOsVO) {
		Result result=hostOsService.save(hostOsVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取操作系统
	*/
	@ApiOperation(value = "获取操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = HostOsVOMeta.ID)
	@SentinelResource(value = HostOsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.GET_BY_ID)
	public Result<HostOs> getById(String id) {
		Result<HostOs> result=new Result<>();
		HostOs hostOs=hostOsService.getById(id);
		result.success(true).data(hostOs);
		return result;
	}


	/**
	 * 批量删除操作系统 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除操作系统")
		@ApiImplicitParams({
				@ApiImplicitParam(name = HostOsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = HostOsVOMeta.IDS)
		@SentinelResource(value = HostOsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.GET_BY_IDS)
	public Result<List<HostOs>> getByIds(List<String> ids) {
		Result<List<HostOs>> result=new Result<>();
		List<HostOs> list=hostOsService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询操作系统
	*/
	@ApiOperation(value = "查询操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478258462665478144"),
		@ApiImplicitParam(name = HostOsVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostOsVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473631451401682944"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostOsVOMeta.PAGE_INDEX , HostOsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = HostOsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.QUERY_LIST)
	public Result<List<HostOs>> queryList(HostOsVO sample) {
		Result<List<HostOs>> result=new Result<>();
		List<HostOs> list=hostOsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询操作系统
	*/
	@ApiOperation(value = "分页查询操作系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostOsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478258462665478144"),
		@ApiImplicitParam(name = HostOsVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostOsVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473631451401682944"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = HostOsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostOsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<HostOs>> queryPagedList(HostOsVO sample) {
		Result<PagedList<HostOs>> result=new Result<>();
		PagedList<HostOs> list=hostOsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = HostOsServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostOsServiceProxy.EXPORT_EXCEL)
	public void exportExcel(HostOsVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=hostOsService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = HostOsServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostOsServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=hostOsService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = HostOsServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostOsServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=hostOsService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}