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


import com.dt.platform.proxy.ops.HostDbServiceProxy;
import com.dt.platform.domain.ops.meta.HostDbVOMeta;
import com.dt.platform.domain.ops.HostDb;
import com.dt.platform.domain.ops.HostDbVO;
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
import com.dt.platform.domain.ops.meta.HostDbMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IHostDbService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 14:34:42
*/

@Api(tags = "数据库")
@ApiSort(0)
@RestController("OpsHostDbController")
public class HostDbController extends SuperController {

	@Autowired
	private IHostDbService hostDbService;

	
	/**
	 * 添加数据库
	*/
	@ApiOperation(value = "添加数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478319999837011968"),
		@ApiImplicitParam(name = HostDbVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostDbVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473626988658032641"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = HostDbVOMeta.ID)
	@SentinelResource(value = HostDbServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.INSERT)
	public Result insert(HostDbVO hostDbVO) {
		Result result=hostDbService.insert(hostDbVO);
		return result;
	}

	
	/**
	 * 删除数据库
	*/
	@ApiOperation(value = "删除数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478319999837011968")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = HostDbVOMeta.ID)
	@SentinelResource(value = HostDbServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=hostDbService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除数据库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = HostDbVOMeta.IDS)
	@SentinelResource(value = HostDbServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=hostDbService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新数据库
	*/
	@ApiOperation(value = "更新数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478319999837011968"),
		@ApiImplicitParam(name = HostDbVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostDbVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473626988658032641"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { HostDbVOMeta.PAGE_INDEX , HostDbVOMeta.PAGE_SIZE , HostDbVOMeta.SEARCH_FIELD , HostDbVOMeta.FUZZY_FIELD , HostDbVOMeta.SEARCH_VALUE , HostDbVOMeta.SORT_FIELD , HostDbVOMeta.SORT_TYPE , HostDbVOMeta.IDS } ) 
	@NotNull(name = HostDbVOMeta.ID)
	@SentinelResource(value = HostDbServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.UPDATE)
	public Result update(HostDbVO hostDbVO) {
		Result result=hostDbService.update(hostDbVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存数据库
	*/
	@ApiOperation(value = "保存数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478319999837011968"),
		@ApiImplicitParam(name = HostDbVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostDbVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473626988658032641"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostDbVOMeta.PAGE_INDEX , HostDbVOMeta.PAGE_SIZE , HostDbVOMeta.SEARCH_FIELD , HostDbVOMeta.FUZZY_FIELD , HostDbVOMeta.SEARCH_VALUE , HostDbVOMeta.SORT_FIELD , HostDbVOMeta.SORT_TYPE , HostDbVOMeta.IDS } )
	@NotNull(name = HostDbVOMeta.ID)
	@SentinelResource(value = HostDbServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.SAVE)
	public Result save(HostDbVO hostDbVO) {
		Result result=hostDbService.save(hostDbVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据库
	*/
	@ApiOperation(value = "获取数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = HostDbVOMeta.ID)
	@SentinelResource(value = HostDbServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.GET_BY_ID)
	public Result<HostDb> getById(String id) {
		Result<HostDb> result=new Result<>();
		HostDb hostDb=hostDbService.getById(id);
		result.success(true).data(hostDb);
		return result;
	}


	/**
	 * 批量删除数据库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除数据库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = HostDbVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = HostDbVOMeta.IDS)
		@SentinelResource(value = HostDbServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.GET_BY_IDS)
	public Result<List<HostDb>> getByIds(List<String> ids) {
		Result<List<HostDb>> result=new Result<>();
		List<HostDb> list=hostDbService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询数据库
	*/
	@ApiOperation(value = "查询数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478319999837011968"),
		@ApiImplicitParam(name = HostDbVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostDbVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473626988658032641"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostDbVOMeta.PAGE_INDEX , HostDbVOMeta.PAGE_SIZE } )
	@SentinelResource(value = HostDbServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.QUERY_LIST)
	public Result<List<HostDb>> queryList(HostDbVO sample) {
		Result<List<HostDb>> result=new Result<>();
		List<HostDb> list=hostDbService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询数据库
	*/
	@ApiOperation(value = "分页查询数据库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostDbVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478319999837011968"),
		@ApiImplicitParam(name = HostDbVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostDbVOMeta.SERVICE_INFO_ID , value = "服务内容" , required = false , dataTypeClass=String.class , example = "473626988658032641"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = HostDbServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostDbServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<HostDb>> queryPagedList(HostDbVO sample) {
		Result<PagedList<HostDb>> result=new Result<>();
		PagedList<HostDb> list=hostDbService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = HostDbServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostDbServiceProxy.EXPORT_EXCEL)
	public void exportExcel(HostDbVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=hostDbService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = HostDbServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostDbServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=hostDbService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = HostDbServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostDbServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=hostDbService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}