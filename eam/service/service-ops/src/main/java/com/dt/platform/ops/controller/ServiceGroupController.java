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


import com.dt.platform.proxy.ops.ServiceGroupServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceGroupVOMeta;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.ServiceGroupVO;
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
import com.dt.platform.domain.ops.meta.ServiceGroupMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceGroupService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 服务分组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:05:24
*/

@Api(tags = "服务分组")
@ApiSort(0)
@RestController("OpsServiceGroupController")
public class ServiceGroupController extends SuperController {

	@Autowired
	private IServiceGroupService serviceGroupService;

	
	/**
	 * 添加服务分组
	*/
	@ApiOperation(value = "添加服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ServiceGroupVOMeta.ID)
	@SentinelResource(value = ServiceGroupServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.INSERT)
	public Result insert(ServiceGroupVO serviceGroupVO) {
		Result result=serviceGroupService.insert(serviceGroupVO);
		return result;
	}

	
	/**
	 * 删除服务分组
	*/
	@ApiOperation(value = "删除服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ServiceGroupVOMeta.ID)
	@SentinelResource(value = ServiceGroupServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=serviceGroupService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除服务分组 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ServiceGroupVOMeta.IDS)
	@SentinelResource(value = ServiceGroupServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=serviceGroupService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新服务分组
	*/
	@ApiOperation(value = "更新服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ServiceGroupVOMeta.PAGE_INDEX , ServiceGroupVOMeta.PAGE_SIZE , ServiceGroupVOMeta.SEARCH_FIELD , ServiceGroupVOMeta.FUZZY_FIELD , ServiceGroupVOMeta.SEARCH_VALUE , ServiceGroupVOMeta.SORT_FIELD , ServiceGroupVOMeta.SORT_TYPE , ServiceGroupVOMeta.IDS } ) 
	@NotNull(name = ServiceGroupVOMeta.ID)
	@SentinelResource(value = ServiceGroupServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.UPDATE)
	public Result update(ServiceGroupVO serviceGroupVO) {
		Result result=serviceGroupService.update(serviceGroupVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存服务分组
	*/
	@ApiOperation(value = "保存服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceGroupVOMeta.PAGE_INDEX , ServiceGroupVOMeta.PAGE_SIZE , ServiceGroupVOMeta.SEARCH_FIELD , ServiceGroupVOMeta.FUZZY_FIELD , ServiceGroupVOMeta.SEARCH_VALUE , ServiceGroupVOMeta.SORT_FIELD , ServiceGroupVOMeta.SORT_TYPE , ServiceGroupVOMeta.IDS } )
	@NotNull(name = ServiceGroupVOMeta.ID)
	@SentinelResource(value = ServiceGroupServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.SAVE)
	public Result save(ServiceGroupVO serviceGroupVO) {
		Result result=serviceGroupService.save(serviceGroupVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取服务分组
	*/
	@ApiOperation(value = "获取服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ServiceGroupVOMeta.ID)
	@SentinelResource(value = ServiceGroupServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.GET_BY_ID)
	public Result<ServiceGroup> getById(String id) {
		Result<ServiceGroup> result=new Result<>();
		ServiceGroup serviceGroup=serviceGroupService.getById(id);
		result.success(true).data(serviceGroup);
		return result;
	}


	/**
	 * 批量删除服务分组 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除服务分组")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ServiceGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ServiceGroupVOMeta.IDS)
		@SentinelResource(value = ServiceGroupServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.GET_BY_IDS)
	public Result<List<ServiceGroup>> getByIds(List<String> ids) {
		Result<List<ServiceGroup>> result=new Result<>();
		List<ServiceGroup> list=serviceGroupService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询服务分组
	*/
	@ApiOperation(value = "查询服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceGroupVOMeta.PAGE_INDEX , ServiceGroupVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ServiceGroupServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.QUERY_LIST)
	public Result<List<ServiceGroup>> queryList(ServiceGroupVO sample) {
		Result<List<ServiceGroup>> result=new Result<>();
		List<ServiceGroup> list=serviceGroupService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询服务分组
	*/
	@ApiOperation(value = "分页查询服务分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "数据库"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ServiceGroupServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceGroupServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ServiceGroup>> queryPagedList(ServiceGroupVO sample) {
		Result<PagedList<ServiceGroup>> result=new Result<>();
		PagedList<ServiceGroup> list=serviceGroupService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ServiceGroupServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceGroupServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ServiceGroupVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=serviceGroupService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ServiceGroupServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceGroupServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=serviceGroupService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ServiceGroupServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceGroupServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=serviceGroupService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}