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


import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceInfoVOMeta;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.ServiceInfoVO;
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
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.domain.ops.ServiceCategory;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 服务 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 18:43:53
*/

@Api(tags = "服务")
@ApiSort(0)
@RestController("OpsServiceInfoController")
public class ServiceInfoController extends SuperController {

	@Autowired
	private IServiceInfoService serviceInfoService;

	
	/**
	 * 添加服务
	*/
	@ApiOperation(value = "添加服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID , value = "服务分类" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle 11.2.0.4"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ServiceInfoVOMeta.ID)
	@SentinelResource(value = ServiceInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.INSERT)
	public Result insert(ServiceInfoVO serviceInfoVO) {
		Result result=serviceInfoService.insert(serviceInfoVO);
		return result;
	}

	
	/**
	 * 删除服务
	*/
	@ApiOperation(value = "删除服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ServiceInfoVOMeta.ID)
	@SentinelResource(value = ServiceInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=serviceInfoService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除服务 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ServiceInfoVOMeta.IDS)
	@SentinelResource(value = ServiceInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=serviceInfoService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新服务
	*/
	@ApiOperation(value = "更新服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID , value = "服务分类" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle 11.2.0.4"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ServiceInfoVOMeta.PAGE_INDEX , ServiceInfoVOMeta.PAGE_SIZE , ServiceInfoVOMeta.SEARCH_FIELD , ServiceInfoVOMeta.FUZZY_FIELD , ServiceInfoVOMeta.SEARCH_VALUE , ServiceInfoVOMeta.SORT_FIELD , ServiceInfoVOMeta.SORT_TYPE , ServiceInfoVOMeta.IDS } ) 
	@NotNull(name = ServiceInfoVOMeta.ID)
	@SentinelResource(value = ServiceInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.UPDATE)
	public Result update(ServiceInfoVO serviceInfoVO) {
		Result result=serviceInfoService.update(serviceInfoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存服务
	*/
	@ApiOperation(value = "保存服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID , value = "服务分类" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle 11.2.0.4"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceInfoVOMeta.PAGE_INDEX , ServiceInfoVOMeta.PAGE_SIZE , ServiceInfoVOMeta.SEARCH_FIELD , ServiceInfoVOMeta.FUZZY_FIELD , ServiceInfoVOMeta.SEARCH_VALUE , ServiceInfoVOMeta.SORT_FIELD , ServiceInfoVOMeta.SORT_TYPE , ServiceInfoVOMeta.IDS } )
	@NotNull(name = ServiceInfoVOMeta.ID)
	@SentinelResource(value = ServiceInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.SAVE)
	public Result save(ServiceInfoVO serviceInfoVO) {
		Result result=serviceInfoService.save(serviceInfoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取服务
	*/
	@ApiOperation(value = "获取服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ServiceInfoVOMeta.ID)
	@SentinelResource(value = ServiceInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.GET_BY_ID)
	public Result<ServiceInfo> getById(String id) {
		Result<ServiceInfo> result=new Result<>();
		ServiceInfo serviceInfo=serviceInfoService.getById(id);
		// 关联出 服务类型 数据
		serviceInfoService.join(serviceInfo,ServiceInfoMeta.SERVICE_CATEGORY);
		result.success(true).data(serviceInfo);
		return result;
	}


	/**
	 * 批量删除服务 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除服务")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ServiceInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ServiceInfoVOMeta.IDS)
		@SentinelResource(value = ServiceInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.GET_BY_IDS)
	public Result<List<ServiceInfo>> getByIds(List<String> ids) {
		Result<List<ServiceInfo>> result=new Result<>();
		List<ServiceInfo> list=serviceInfoService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询服务
	*/
	@ApiOperation(value = "查询服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID , value = "服务分类" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle 11.2.0.4"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceInfoVOMeta.PAGE_INDEX , ServiceInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ServiceInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.QUERY_LIST)
	public Result<List<ServiceInfo>> queryList(ServiceInfoVO sample) {
		Result<List<ServiceInfo>> result=new Result<>();
		List<ServiceInfo> list=serviceInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询服务
	*/
	@ApiOperation(value = "分页查询服务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID , value = "服务分类" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Oracle 11.2.0.4"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ServiceInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ServiceInfo>> queryPagedList(ServiceInfoVO sample) {
		Result<PagedList<ServiceInfo>> result=new Result<>();
		PagedList<ServiceInfo> list=serviceInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 服务类型 数据
		serviceInfoService.join(list,ServiceInfoMeta.SERVICE_CATEGORY);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ServiceInfoServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceInfoServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ServiceInfoVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=serviceInfoService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ServiceInfoServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceInfoServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=serviceInfoService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ServiceInfoServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceInfoServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=serviceInfoService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}