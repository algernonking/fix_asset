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


import com.dt.platform.proxy.ops.ServiceTypeServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceTypeVOMeta;
import com.dt.platform.domain.ops.ServiceType;
import com.dt.platform.domain.ops.ServiceTypeVO;
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
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 服务种类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-30 13:54:10
*/

@Api(tags = "服务种类")
@ApiSort(0)
@RestController("OpsServiceTypeController")
public class ServiceTypeController extends SuperController {

	@Autowired
	private IServiceTypeService serviceTypeService;

	
	/**
	 * 添加服务种类
	*/
	@ApiOperation(value = "添加服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "DB"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ServiceTypeVOMeta.ID)
	@SentinelResource(value = ServiceTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.INSERT)
	public Result insert(ServiceTypeVO serviceTypeVO) {
		Result result=serviceTypeService.insert(serviceTypeVO);
		return result;
	}

	
	/**
	 * 删除服务种类
	*/
	@ApiOperation(value = "删除服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ServiceTypeVOMeta.ID)
	@SentinelResource(value = ServiceTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=serviceTypeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除服务种类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ServiceTypeVOMeta.IDS)
	@SentinelResource(value = ServiceTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=serviceTypeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新服务种类
	*/
	@ApiOperation(value = "更新服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "DB"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ServiceTypeVOMeta.PAGE_INDEX , ServiceTypeVOMeta.PAGE_SIZE , ServiceTypeVOMeta.SEARCH_FIELD , ServiceTypeVOMeta.FUZZY_FIELD , ServiceTypeVOMeta.SEARCH_VALUE , ServiceTypeVOMeta.SORT_FIELD , ServiceTypeVOMeta.SORT_TYPE , ServiceTypeVOMeta.IDS } ) 
	@NotNull(name = ServiceTypeVOMeta.ID)
	@SentinelResource(value = ServiceTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.UPDATE)
	public Result update(ServiceTypeVO serviceTypeVO) {
		Result result=serviceTypeService.update(serviceTypeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存服务种类
	*/
	@ApiOperation(value = "保存服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "DB"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceTypeVOMeta.PAGE_INDEX , ServiceTypeVOMeta.PAGE_SIZE , ServiceTypeVOMeta.SEARCH_FIELD , ServiceTypeVOMeta.FUZZY_FIELD , ServiceTypeVOMeta.SEARCH_VALUE , ServiceTypeVOMeta.SORT_FIELD , ServiceTypeVOMeta.SORT_TYPE , ServiceTypeVOMeta.IDS } )
	@NotNull(name = ServiceTypeVOMeta.ID)
	@SentinelResource(value = ServiceTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.SAVE)
	public Result save(ServiceTypeVO serviceTypeVO) {
		Result result=serviceTypeService.save(serviceTypeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取服务种类
	*/
	@ApiOperation(value = "获取服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ServiceTypeVOMeta.ID)
	@SentinelResource(value = ServiceTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.GET_BY_ID)
	public Result<ServiceType> getById(String id) {
		Result<ServiceType> result=new Result<>();
		ServiceType role=serviceTypeService.getById(id);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 批量删除服务种类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除服务种类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ServiceTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ServiceTypeVOMeta.IDS)
		@SentinelResource(value = ServiceTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.GET_BY_IDS)
	public Result<List<ServiceType>> getByIds(List<String> ids) {
		Result<List<ServiceType>> result=new Result<>();
		List<ServiceType> list=serviceTypeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询服务种类
	*/
	@ApiOperation(value = "查询服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "DB"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceTypeVOMeta.PAGE_INDEX , ServiceTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ServiceTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.QUERY_LIST)
	public Result<List<ServiceType>> queryList(ServiceTypeVO sample) {
		Result<List<ServiceType>> result=new Result<>();
		List<ServiceType> list=serviceTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询服务种类
	*/
	@ApiOperation(value = "分页查询服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "DB"),
		@ApiImplicitParam(name = ServiceTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ServiceTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ServiceType>> queryPagedList(ServiceTypeVO sample) {
		Result<PagedList<ServiceType>> result=new Result<>();
		PagedList<ServiceType> list=serviceTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ServiceTypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceTypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ServiceTypeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=serviceTypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ServiceTypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceTypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=serviceTypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ServiceTypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceTypeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=serviceTypeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}