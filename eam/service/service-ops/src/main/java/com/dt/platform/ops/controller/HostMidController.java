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


import com.dt.platform.proxy.ops.HostMidServiceProxy;
import com.dt.platform.domain.ops.meta.HostMidVOMeta;
import com.dt.platform.domain.ops.HostMid;
import com.dt.platform.domain.ops.HostMidVO;
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
import com.dt.platform.domain.ops.meta.HostMidMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IHostMidService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 中间件 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-12 17:11:54
*/

@Api(tags = "中间件")
@ApiSort(0)
@RestController("OpsHostMidController")
public class HostMidController extends SuperController {

	@Autowired
	private IHostMidService hostMidService;

	
	/**
	 * 添加中间件
	*/
	@ApiOperation(value = "添加中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.SERVICE_DETAIL_ID , value = "服务内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = HostMidVOMeta.ID)
	@SentinelResource(value = HostMidServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.INSERT)
	public Result insert(HostMidVO hostMidVO) {
		Result result=hostMidService.insert(hostMidVO);
		return result;
	}

	
	/**
	 * 删除中间件
	*/
	@ApiOperation(value = "删除中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = HostMidVOMeta.ID)
	@SentinelResource(value = HostMidServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=hostMidService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除中间件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = HostMidVOMeta.IDS)
	@SentinelResource(value = HostMidServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=hostMidService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新中间件
	*/
	@ApiOperation(value = "更新中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.SERVICE_DETAIL_ID , value = "服务内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { HostMidVOMeta.PAGE_INDEX , HostMidVOMeta.PAGE_SIZE , HostMidVOMeta.SEARCH_FIELD , HostMidVOMeta.FUZZY_FIELD , HostMidVOMeta.SEARCH_VALUE , HostMidVOMeta.SORT_FIELD , HostMidVOMeta.SORT_TYPE , HostMidVOMeta.IDS } ) 
	@NotNull(name = HostMidVOMeta.ID)
	@SentinelResource(value = HostMidServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.UPDATE)
	public Result update(HostMidVO hostMidVO) {
		Result result=hostMidService.update(hostMidVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存中间件
	*/
	@ApiOperation(value = "保存中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.SERVICE_DETAIL_ID , value = "服务内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostMidVOMeta.PAGE_INDEX , HostMidVOMeta.PAGE_SIZE , HostMidVOMeta.SEARCH_FIELD , HostMidVOMeta.FUZZY_FIELD , HostMidVOMeta.SEARCH_VALUE , HostMidVOMeta.SORT_FIELD , HostMidVOMeta.SORT_TYPE , HostMidVOMeta.IDS } )
	@NotNull(name = HostMidVOMeta.ID)
	@SentinelResource(value = HostMidServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.SAVE)
	public Result save(HostMidVO hostMidVO) {
		Result result=hostMidService.save(hostMidVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取中间件
	*/
	@ApiOperation(value = "获取中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = HostMidVOMeta.ID)
	@SentinelResource(value = HostMidServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.GET_BY_ID)
	public Result<HostMid> getById(String id) {
		Result<HostMid> result=new Result<>();
		HostMid hostMid=hostMidService.getById(id);
		result.success(true).data(hostMid);
		return result;
	}


	/**
	 * 批量删除中间件 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除中间件")
		@ApiImplicitParams({
				@ApiImplicitParam(name = HostMidVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = HostMidVOMeta.IDS)
		@SentinelResource(value = HostMidServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.GET_BY_IDS)
	public Result<List<HostMid>> getByIds(List<String> ids) {
		Result<List<HostMid>> result=new Result<>();
		List<HostMid> list=hostMidService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询中间件
	*/
	@ApiOperation(value = "查询中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.SERVICE_DETAIL_ID , value = "服务内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostMidVOMeta.PAGE_INDEX , HostMidVOMeta.PAGE_SIZE } )
	@SentinelResource(value = HostMidServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.QUERY_LIST)
	public Result<List<HostMid>> queryList(HostMidVO sample) {
		Result<List<HostMid>> result=new Result<>();
		List<HostMid> list=hostMidService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询中间件
	*/
	@ApiOperation(value = "分页查询中间件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostMidVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.HOST_ID , value = "主机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostMidVOMeta.SERVICE_DETAIL_ID , value = "服务内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = HostMidServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostMidServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<HostMid>> queryPagedList(HostMidVO sample) {
		Result<PagedList<HostMid>> result=new Result<>();
		PagedList<HostMid> list=hostMidService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = HostMidServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostMidServiceProxy.EXPORT_EXCEL)
	public void exportExcel(HostMidVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=hostMidService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = HostMidServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostMidServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=hostMidService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = HostMidServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostMidServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=hostMidService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}