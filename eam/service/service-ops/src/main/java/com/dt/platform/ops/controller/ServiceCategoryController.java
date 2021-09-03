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


import com.dt.platform.proxy.ops.ServiceCategoryServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceCategoryVOMeta;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceCategoryVO;
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
import com.dt.platform.domain.ops.meta.ServiceCategoryMeta;
import com.dt.platform.domain.ops.ServiceGroup;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 服务类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:36:25
*/

@Api(tags = "服务类型")
@ApiSort(0)
@RestController("OpsServiceCategoryController")
public class ServiceCategoryController extends SuperController {

	@Autowired
	private IServiceCategoryService serviceCategoryService;

	
	/**
	 * 添加服务类型
	*/
	@ApiOperation(value = "添加服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID , value = "服务分组" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ServiceCategoryVOMeta.ID)
	@SentinelResource(value = ServiceCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.INSERT)
	public Result insert(ServiceCategoryVO serviceCategoryVO) {
		Result result=serviceCategoryService.insert(serviceCategoryVO);
		return result;
	}

	
	/**
	 * 删除服务类型
	*/
	@ApiOperation(value = "删除服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473621482614816700")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ServiceCategoryVOMeta.ID)
	@SentinelResource(value = ServiceCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=serviceCategoryService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除服务类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ServiceCategoryVOMeta.IDS)
	@SentinelResource(value = ServiceCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=serviceCategoryService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新服务类型
	*/
	@ApiOperation(value = "更新服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID , value = "服务分组" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ServiceCategoryVOMeta.PAGE_INDEX , ServiceCategoryVOMeta.PAGE_SIZE , ServiceCategoryVOMeta.SEARCH_FIELD , ServiceCategoryVOMeta.FUZZY_FIELD , ServiceCategoryVOMeta.SEARCH_VALUE , ServiceCategoryVOMeta.SORT_FIELD , ServiceCategoryVOMeta.SORT_TYPE , ServiceCategoryVOMeta.IDS } ) 
	@NotNull(name = ServiceCategoryVOMeta.ID)
	@SentinelResource(value = ServiceCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.UPDATE)
	public Result update(ServiceCategoryVO serviceCategoryVO) {
		Result result=serviceCategoryService.update(serviceCategoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存服务类型
	*/
	@ApiOperation(value = "保存服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID , value = "服务分组" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceCategoryVOMeta.PAGE_INDEX , ServiceCategoryVOMeta.PAGE_SIZE , ServiceCategoryVOMeta.SEARCH_FIELD , ServiceCategoryVOMeta.FUZZY_FIELD , ServiceCategoryVOMeta.SEARCH_VALUE , ServiceCategoryVOMeta.SORT_FIELD , ServiceCategoryVOMeta.SORT_TYPE , ServiceCategoryVOMeta.IDS } )
	@NotNull(name = ServiceCategoryVOMeta.ID)
	@SentinelResource(value = ServiceCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.SAVE)
	public Result save(ServiceCategoryVO serviceCategoryVO) {
		Result result=serviceCategoryService.save(serviceCategoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取服务类型
	*/
	@ApiOperation(value = "获取服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ServiceCategoryVOMeta.ID)
	@SentinelResource(value = ServiceCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.GET_BY_ID)
	public Result<ServiceCategory> getById(String id) {
		Result<ServiceCategory> result=new Result<>();
		ServiceCategory serviceCategory=serviceCategoryService.getById(id);
		// 关联出 服务分组 数据
		serviceCategoryService.join(serviceCategory,ServiceCategoryMeta.GROUP);
		result.success(true).data(serviceCategory);
		return result;
	}


	/**
	 * 批量删除服务类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除服务类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ServiceCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ServiceCategoryVOMeta.IDS)
		@SentinelResource(value = ServiceCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.GET_BY_IDS)
	public Result<List<ServiceCategory>> getByIds(List<String> ids) {
		Result<List<ServiceCategory>> result=new Result<>();
		List<ServiceCategory> list=serviceCategoryService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询服务类型
	*/
	@ApiOperation(value = "查询服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID , value = "服务分组" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceCategoryVOMeta.PAGE_INDEX , ServiceCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ServiceCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.QUERY_LIST)
	public Result<List<ServiceCategory>> queryList(ServiceCategoryVO sample) {
		Result<List<ServiceCategory>> result=new Result<>();
		List<ServiceCategory> list=serviceCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询服务类型
	*/
	@ApiOperation(value = "分页查询服务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID , value = "服务分组" , required = false , dataTypeClass=String.class , example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ServiceCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ServiceCategory>> queryPagedList(ServiceCategoryVO sample) {
		Result<PagedList<ServiceCategory>> result=new Result<>();
		PagedList<ServiceCategory> list=serviceCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 服务分组 数据
		serviceCategoryService.join(list,ServiceCategoryMeta.GROUP);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ServiceCategoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceCategoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ServiceCategoryVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=serviceCategoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ServiceCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=serviceCategoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ServiceCategoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceCategoryServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=serviceCategoryService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}