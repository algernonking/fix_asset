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


import com.dt.platform.proxy.ops.ServicetypeServiceProxy;
import com.dt.platform.domain.ops.meta.ServicetypeVOMeta;
import com.dt.platform.domain.ops.Servicetype;
import com.dt.platform.domain.ops.ServicetypeVO;
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
import com.dt.platform.ops.service.IServicetypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 服务种类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-27 15:03:54
*/

@Api(tags = "服务种类")
@ApiSort(0)
@RestController("OpsServicetypeController")
public class ServicetypeController extends SuperController {

	@Autowired
	private IServicetypeService servicetypeService;

	
	/**
	 * 添加服务种类
	*/
	@ApiOperation(value = "添加服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ServicetypeVOMeta.ID)
	@SentinelResource(value = ServicetypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.INSERT)
	public Result insert(ServicetypeVO servicetypeVO) {
		Result result=servicetypeService.insert(servicetypeVO);
		return result;
	}

	
	/**
	 * 删除服务种类
	*/
	@ApiOperation(value = "删除服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ServicetypeVOMeta.ID)
	@SentinelResource(value = ServicetypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=servicetypeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除服务种类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ServicetypeVOMeta.IDS)
	@SentinelResource(value = ServicetypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=servicetypeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新服务种类
	*/
	@ApiOperation(value = "更新服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ServicetypeVOMeta.PAGE_INDEX , ServicetypeVOMeta.PAGE_SIZE , ServicetypeVOMeta.SEARCH_FIELD , ServicetypeVOMeta.SEARCH_VALUE , ServicetypeVOMeta.SORT_FIELD , ServicetypeVOMeta.SORT_TYPE , ServicetypeVOMeta.IDS } ) 
	@NotNull(name = ServicetypeVOMeta.ID)
	@SentinelResource(value = ServicetypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.UPDATE)
	public Result update(ServicetypeVO servicetypeVO) {
		Result result=servicetypeService.update(servicetypeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存服务种类
	*/
	@ApiOperation(value = "保存服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServicetypeVOMeta.PAGE_INDEX , ServicetypeVOMeta.PAGE_SIZE , ServicetypeVOMeta.SEARCH_FIELD , ServicetypeVOMeta.SEARCH_VALUE , ServicetypeVOMeta.SORT_FIELD , ServicetypeVOMeta.SORT_TYPE , ServicetypeVOMeta.IDS } )
	@NotNull(name = ServicetypeVOMeta.ID)
	@SentinelResource(value = ServicetypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.SAVE)
	public Result save(ServicetypeVO servicetypeVO) {
		Result result=servicetypeService.save(servicetypeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取服务种类
	*/
	@ApiOperation(value = "获取服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ServicetypeVOMeta.ID)
	@SentinelResource(value = ServicetypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.GET_BY_ID)
	public Result<Servicetype> getById(String id) {
		Result<Servicetype> result=new Result<>();
		Servicetype role=servicetypeService.getById(id);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 批量删除服务种类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除服务种类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ServicetypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ServicetypeVOMeta.IDS)
		@SentinelResource(value = ServicetypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.GET_BY_IDS)
	public Result<List<Servicetype>> getByIds(List<String> ids) {
		Result<List<Servicetype>> result=new Result<>();
		List<Servicetype> list=servicetypeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询服务种类
	*/
	@ApiOperation(value = "查询服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServicetypeVOMeta.PAGE_INDEX , ServicetypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ServicetypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.QUERY_LIST)
	public Result<List<Servicetype>> queryList(ServicetypeVO sample) {
		Result<List<Servicetype>> result=new Result<>();
		List<Servicetype> list=servicetypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询服务种类
	*/
	@ApiOperation(value = "分页查询服务种类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServicetypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServicetypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ServicetypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServicetypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Servicetype>> queryPagedList(ServicetypeVO sample) {
		Result<PagedList<Servicetype>> result=new Result<>();
		PagedList<Servicetype> list=servicetypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ServicetypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServicetypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ServicetypeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=servicetypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ServicetypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServicetypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=servicetypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ServicetypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServicetypeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=servicetypeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}